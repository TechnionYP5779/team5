package parkingLot.Backend;

import java.util.ArrayList;

import parkingLot.Logic.Parking;
import parkingLot.Logic.User;

public interface DB {

	User getUser(String email, String password);

	boolean addUser(User u, String password);

	ArrayList<Parking> getParkings();

	boolean addParking(Parking p);

}
