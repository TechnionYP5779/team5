package parkingLot.Backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import fluent.ly.unbox;
import parkingLot.Logic.Parking;
import parkingLot.Logic.User;

public class FireBaseDB implements DB {

	private final Firestore DB;

	private static Map<String, Object> user2map(final User ¢) {
		final Map<String, Object> $ = new HashMap<>();
		$.put("name", ¢.getName());
		return $;
	}

	private static Map<String, Object> parking2map(final Parking ¢) {
		final Map<String, Object> $ = new HashMap<>();
		$.put("location", ¢.getLocation());
		$.put("owner", ¢.getUserName());
		return $;
	}

	public FireBaseDB(final String path) {
		InputStream serviceAccount = null;
		try {
			serviceAccount = new FileInputStream(path);
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		GoogleCredentials credentials = null;
		try {
			credentials = GoogleCredentials.fromStream(serviceAccount);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		final FirestoreOptions options = FirestoreOptions.newBuilder().setCredentials(credentials)
				.setTimestampsInSnapshotsEnabled(true).build();
		this.DB = options.getService();
	}

	@Override
	public User getUser(final String email, final String password) {
		final CollectionReference users = DB.collection("users");
		/*
		 * MessageDigest digest=null; try { digest =
		 * MessageDigest.getInstance("SHA-256"); } catch (NoSuchAlgorithmException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); return null; }
		 * password+=email; byte[] hash =
		 * digest.digest(password.getBytes(StandardCharsets.UTF_8)); String
		 * shash=String.valueOf(hash); System.out.println(shash);
		 */
		final com.google.cloud.firestore.Query query = users.whereEqualTo("password", password);
		final ApiFuture<QuerySnapshot> querySnapshot = query.get();
		try {
			for (final DocumentSnapshot document : querySnapshot.get().getDocuments())
				if (!"-1".equals(document.getId()) && email.equals(document.getId()))
					return new User(document.getString("name"), email, 123);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (final ExecutionException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(final User u, final String password) {
		final Map<String, Object> m = user2map(u);
		m.put("password", password);
		final DocumentReference docRef = DB.collection("users").document(u.getEmail());
		/*
		 * MessageDigest digest=null; try { digest =
		 * MessageDigest.getInstance("SHA-256"); } catch (NoSuchAlgorithmException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); return false; }
		 * password+=u.getEmail(); byte[] hash =
		 * digest.digest(password.getBytes(StandardCharsets.UTF_8)); m.put("password",
		 * String.valueOf(hash));
		 */
		final ApiFuture<WriteResult> result = docRef.set(m);
		try {
			result.get();
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (final ExecutionException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<Parking> getParkings() {

		final ArrayList<Parking> $ = new ArrayList<>();

		final CollectionReference parkings = DB.collection("parking");
		final com.google.cloud.firestore.Query query = parkings;
		final ApiFuture<QuerySnapshot> querySnapshot = query.get();
		try {
			for (final DocumentSnapshot document : querySnapshot.get().getDocuments())
				if (!"-1".equals(document.getId()))
					$.add(new Parking(unbox.it(Integer.valueOf(document.getId())), Parking.size.PRIVATE_CAR,
							document.getString("location"), document.getString("owner")));
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (final ExecutionException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return $;

	}

	@Override
	public boolean addParking(final Parking p) {
		int maxId = -1;
		final ArrayList<Parking> l = this.getParkings();
		for (final Parking pk : l)
			if (pk.getId() > maxId)
				maxId = pk.getId();
		p.setId(maxId + 1);
		final Map<String, Object> m = parking2map(p);
		final DocumentReference docRef = DB.collection("parking").document(String.valueOf(p.getId()));
		final ApiFuture<WriteResult> result = docRef.set(m);
		try {
			result.get();
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (final ExecutionException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return false;
	}

}
