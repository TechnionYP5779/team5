package parkingLot.Backend;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import parkingLot.Logic.Parking;
import parkingLot.Logic.User;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

public class FireBaseDB implements DB{

	private Firestore DB;
	
	private Map<String, Object> user2map(User u){
		Map<String,Object> retMap=new HashMap<>();
		retMap.put("name", u.getName());
		return retMap;
	}
	
	private Map<String, Object> parking2map(Parking p){
		Map<String,Object> retMap=new HashMap<>();
		retMap.put("location",p.getLocation() );
		retMap.put("owner", p.getUserName());
		return retMap;
	}
	
	
	public FireBaseDB(String path)  {
		InputStream serviceAccount = null;
		try {
			serviceAccount = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoogleCredentials credentials = null;
		try {
			credentials = GoogleCredentials.fromStream(serviceAccount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FirestoreOptions options =  FirestoreOptions.newBuilder()
			    .setCredentials(credentials)
			    .setTimestampsInSnapshotsEnabled(true)
			    .build();
			 this.DB = options.getService();
	}
	
	@Override
	public User getUser(String email, String password) {
		CollectionReference users = DB.collection("users");
		/*
		MessageDigest digest=null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		password+=email;
		byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		String shash=String.valueOf(hash);
		System.out.println(shash);
		*/
		com.google.cloud.firestore.Query query = users.whereEqualTo("password", password);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		try {
			for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
				if((!"-1".equals(document.getId()))&& email.equals(document.getId()))
					return new User(document.getString("name"),email,123);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User u,String password) {
		Map<String,Object> m = user2map(u);
		m.put("password", password);
		DocumentReference docRef = DB.collection("users").document(u.getEmail());
		/*
		MessageDigest digest=null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		password+=u.getEmail();
		byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		m.put("password", String.valueOf(hash));
		*/
		ApiFuture<WriteResult> result=docRef.set(m);
		try {
			result.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<Parking> getParkings() {
		
		ArrayList<Parking> ret=new ArrayList<>();
		
		CollectionReference parkings = DB.collection("parking");
		com.google.cloud.firestore.Query query = parkings;
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		try {
			for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
				if(!"-1".equals(document.getId()))
				ret.add(new Parking(Integer.valueOf(document.getId()),Parking.size.PRIVATE_CAR,document.getString("location"),document.getString("owner")));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
		
	}

	@Override
	public boolean addParking(Parking p) {
		int maxId=-1;
		ArrayList<Parking> l=this.getParkings();
		for(Parking pk : l) {
			if(pk.getId()>maxId)
				maxId=pk.getId();
		}
		p.setId(maxId+1);
		Map<String,Object> m = parking2map(p);
		DocumentReference docRef = DB.collection("parking").document(String.valueOf(p.getId()));
		ApiFuture<WriteResult> result=docRef.set(m);
		try {
			result.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
