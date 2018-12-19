package parkingLot.Backend;

import java.io.IOException;

import org.junit.Test;

public class FireBaseDBTest {

	@Test
	public void test() {
		try {
			DB db=new FireBaseDB();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
