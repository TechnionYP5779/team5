package parkingLot.Backend;

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
	public void addParking(@RequestBody final Address ¢) throws ServletException {
		addressDb.put(box.it(1), new Parking(0, Parking.size.PRIVATE_CAR, ¢.address));
	}

	@RequestMapping(value = "getParking", method = RequestMethod.GET)
	public String getParking() throws ServletException {
		return "\"" + addressDb.get(box.it(1)).getLocation() + "\"";
	}

	private static class Address {
		public String address;
	}

}
