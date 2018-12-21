package parkingLot.Backend;

import java.io.IOException;

import org.junit.Test;

import parkingLot.Logic.User;

public class FireBaseDBTest {

	@Test
	public void test() {
		try {
			DB db=new FireBaseDB("C:\\Users\\אור\\eclipse-workspace\\team5\\credentials\\credentials.json");
			User u= new User("or", "or@gmail", 123456789);
			assert db!=null;
			db.addUser(u, "123");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
