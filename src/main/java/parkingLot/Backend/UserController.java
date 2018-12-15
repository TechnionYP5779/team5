package parkingLot.Backend;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

	private final Map<String, List<String>> userDb = new HashMap<>();

	public UserController() {
		userDb.put("igor", Arrays.asList("user", "admin"));
		userDb.put("or", Arrays.asList("user", "admin"));
		userDb.put("lior", Arrays.asList("user", "admin"));
		userDb.put("nir", Arrays.asList("user", "admin"));
		userDb.put("shalev", Arrays.asList("user", "admin"));
		userDb.put("shaked", Arrays.asList("user", "admin"));
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody final UserLogin ¢) throws ServletException {
		if (¢.name == null || !userDb.containsKey(¢.name))
			throw new ServletException("Invalid login");
		return new LoginResponse(Jwts.builder().setSubject(¢.name).claim("roles", userDb.get(¢.name))
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact());
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
}
