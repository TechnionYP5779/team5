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
import parkingLot.Logic.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private final DB db=new FireBaseDB("C:\\Users\\אור\\eclipse-workspace\\team5\\credentials\\credentials.json"); 

	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody final UserLogin ¢) throws ServletException {
		if (¢.name == null || ¢.password==null ) {
			System.out.println("here1");
			throw new ServletException("Invalid login");
		}
		User $=db.getUser(¢.name, ¢.password);
		if($==null)
			throw new ServletException("Invalid login");
		return new LoginResponse(Jwts.builder().setSubject(¢.name).claim("roles", $.getName())
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact());
	}
	
	
	@RequestMapping(value = "signUp", method = RequestMethod.POST)
	public void addParking(@RequestBody final UserLogin ¢) throws ServletException {
		int index;
		if(¢.name.indexOf("@")==-1)
			index=¢.name.length();
		else
			index=(¢.name.indexOf("@"));
		db.addUser(new User(¢.name.substring(0, index),¢.name,123456789), ¢.password);
	}

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
