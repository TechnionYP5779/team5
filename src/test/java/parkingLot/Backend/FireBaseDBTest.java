package parkingLot.Backend;

import org.junit.Test;

public class FireBaseDBTest {
	@SuppressWarnings("static-method")
	@Test
	public void test() {
		DB db = new FireBaseDB(".\\credentials\\credentials.json");
		assert db != null;
		// db.addUser(u, "123");
		// Parking p=new Parking(Parking.size.PRIVATE_CAR,"kfar-saba", "or@gmail");
		// db.addParking(p);
		// ArrayList<Parking> p=db.getParkings();
		// for(Parking pk : p ) {
		// System.out.println("parking with id="+pk.getId()+"
		// location="+pk.getLocation()+" owner="+pk.getUserName());
		// }
		// System.out.println(db.getUser("or@gmail", "123").getName());
	}

}
