package parkingLot.Backend;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fluent.ly.box;
import parkingLot.Logic.Parking;

@RestController
@RequestMapping("/parking")
public class ParkingController {

	private final Map<Integer, Parking> addressDb = new HashMap<>();
	

	@RequestMapping(value = "addParking", method = RequestMethod.POST)
	public void addParking(@RequestBody final HttpParking ¢) throws ServletException {
		Parking parking = new Parking(Parking.size.PRIVATE_CAR, ¢.address, ¢.userName);
		addressDb.put(box.it(parking.getId()), parking);
	}

	@RequestMapping(value = "getParking", method = RequestMethod.GET)
	public Collection<Parking> getParking() throws ServletException {
		return addressDb.values();
	}

	private static class HttpParking {
		public String address;
		public String userName;
	}

}
