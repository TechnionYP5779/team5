package parkingLot.Backend;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import parkingLot.Logic.Parking;
import parkingLot.Logic.User;
import parkingLot.Logic.Parking.size;

public class FireBaseDBTest {

	@Test
	public void test() {
		try {
			DB db=new FireBaseDB("C:\\Users\\אור\\eclipse-workspace\\team5\\credentials\\credentials.json");
			//User u= new User("or", "or@gmail", 123456789);
			assert db!=null;
			//db.addUser(u, "123");
			
			//Parking p=new Parking(Parking.size.PRIVATE_CAR,"kfar-saba",  "or@gmail"); 
			//db.addParking(p);
			ArrayList<Parking> p=db.getParkings();
			for(Parking pk : p ) {
				System.out.println("parking with id="+pk.getId()+" location="+pk.getLocation()+" owner="+pk.getUserName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
