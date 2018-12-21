package parkingLot.Backend;
import java.io.FileInputStream;
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
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.Query;

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
		retMap.put("owner", p.getOwner());
		return retMap;
	}
	
	
	public FireBaseDB(String path) throws IOException{
		InputStream serviceAccount = new FileInputStream(path);
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirestoreOptions options =  FirestoreOptions.newBuilder()
			    .setCredentials(credentials)
			    .setTimestampsInSnapshotsEnabled(true)
			    .build();
			 this.DB = options.getService();
			/*
			DocumentReference docRef = DB.collection("users").document("alovelace");
			// Add document data  with id "alovelace" using a hashmap
			Map<String, Object> data = new HashMap<>();
			data.put("first", "AdaBoost");
			data.put("last", "Lovelace");
			data.put("born", 1815);
			//asynchronously write data
			ApiFuture<WriteResult> result = docRef.set(data);
			// ...
			// result.get() blocks on response
			try {
				System.out.println("Update time : " + result.get().getUpdateTime());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			CollectionReference cities = DB.collection("users");
			// Create a query against the collection.
			com.google.cloud.firestore.Query query = cities.whereEqualTo("first", "AdaBoost");
			// retrieve  query results asynchronously using query.get()
			ApiFuture<QuerySnapshot> querySnapshot = query.get();
			try {
				for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
					  System.out.println(document.getString("last"));
					}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
	}
	
	@Override
	public User getUser(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(User u,String password) {
		Map<String,Object> m = user2map(u);
		DocumentReference docRef = DB.collection("users").document(u.getEmail());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addParking(Parking p) {
		// TODO Auto-generated method stub
		return false;
	}

}
