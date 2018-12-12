package parkingLot.Backend;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fluent.ly.box;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

	private final Map<String, List<String>> userDb = new HashMap<>();
	
	private final Map<Integer, String> addressDb = new HashMap<>();

	public UserController() {
		userDb.put("tom", Arrays.asList("user"));
		userDb.put("sally", Arrays.asList("user", "admin"));
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody final UserLogin login) throws ServletException {
		if (login.name == null || !userDb.containsKey(login.name)) {
			throw new ServletException("Invalid login");
		}
		return new LoginResponse(Jwts.builder().setSubject(login.name).claim("roles", userDb.get(login.name))
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact());
	}
	
	@RequestMapping(value = "addParking", method = RequestMethod.POST)
	public void addParking(@RequestBody final Address address) throws ServletException {
		System.out.println("addingParking");
		System.out.println(address.address);
		addressDb.put(box.it(1), address.address);
	}
	
	@RequestMapping(value = "getParking", method = RequestMethod.GET)
	public String getParking(final HttpServletRequest request)
			throws ServletException {
		System.out.println("GET");
		final Claims claims = (Claims) request.getAttribute("claims");
		System.out.println(addressDb.get(1));
		return "\"" + addressDb.get(1) + "\"";
	}

	@SuppressWarnings("unused")
	private static class UserLogin {
		public String name;
		public String password;
	}

	@SuppressWarnings("unused")
	private static class LoginResponse {
		public String token;

		public LoginResponse(final String token) {
			this.token = token;
		}
	}
	
	@SuppressWarnings("unused")
	private static class AddressResponse {
		public String address;
		
		public AddressResponse(final String address) {
			this.address = address;
		}
	}
	
	@SuppressWarnings("unused")
	private static class Address {
		public String address;
	}
}
