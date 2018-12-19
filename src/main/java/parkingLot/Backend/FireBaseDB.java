package parkingLot.Backend;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import parkingLot.Logic.Parking;
import parkingLot.Logic.User;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class FireBaseDB implements DB{

	private Firestore DB;
	
	public FireBaseDB(String keyLocation) throws IOException{
		InputStream serviceAccount = new FileInputStream(keyLocation);
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirestoreOptions options =  FirestoreOptions.newBuilder()
		    .setCredentials(credentials)
		    .setTimestampsInSnapshotsEnabled(true)
		    .build();
		Firestore DB = options.getService();
	}
	
	public FireBaseDB() throws IOException{
		InputStream serviceAccount = new FileInputStream("C:\\Users\\אור\\eclipse-workspace\\team5\\src\\main\\java\\parkingLot\\Backend\\key.json");
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirestoreOptions options =  FirestoreOptions.newBuilder()
			    .setCredentials(credentials)
			    .setTimestampsInSnapshotsEnabled(true)
			    .build();
			Firestore DB = options.getService();
			DocumentReference docRef = DB.collection("users").document("alovelace");
			// Add document data  with id "alovelace" using a hashmap
			Map<String, Object> data = new HashMap<>();
			data.put("first", "Ada");
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
	}
	
	@Override
	public User getUser(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(User u) {
		return false;
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
