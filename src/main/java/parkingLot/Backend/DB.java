package parkingLot.Backend;

import java.util.ArrayList;

import parkingLot.Logic.Parking;
import parkingLot.Logic.User;

public interface DB {

	User getUser(String id, String password);

	boolean addUser(User u);

	ArrayList<Parking> getParkings();

	boolean addParking(Parking p);

}
