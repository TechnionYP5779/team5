package parkingLot.Backend;

import java.util.Date;
import java.util.HashMap;
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

	private final Map<String, String> userDb = new HashMap<>();

	public UserController() {
		userDb.put("igor", "igor");
		userDb.put("or", "or");
		userDb.put("lior", "lior");
		userDb.put("nir", "nir");
		userDb.put("shalev", "shalev");
		userDb.put("shaked", "shaked");
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
