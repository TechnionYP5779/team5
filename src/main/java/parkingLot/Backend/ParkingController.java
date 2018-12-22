package parkingLot.Backend;

import java.util.Collection;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import parkingLot.Logic.Parking;

@RestController
@RequestMapping("/parking")
public class ParkingController {

	private final  DB db= new FireBaseDB(".\\credentials\\credentials.json");
	

	@RequestMapping(value = "addParking", method = RequestMethod.POST)
	public void addParking(@RequestBody final HttpParking ¢) throws ServletException {
		Parking parking = new Parking(Parking.size.PRIVATE_CAR, ¢.address, ¢.userName);
		db.addParking(parking);
	}

	@RequestMapping(value = "getParking", method = RequestMethod.GET)
	public Collection<Parking> getParking() throws ServletException {
		return db.getParkings();
	}

	private static class HttpParking {
		public String address;
		public String userName;
	}

}
