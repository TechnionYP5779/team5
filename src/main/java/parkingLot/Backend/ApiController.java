package parkingLot.Backend;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fluent.ly.box;
import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/api")
public class ApiController {
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "role/{role}", method = RequestMethod.GET)
	public static Boolean login(@PathVariable final String role, final HttpServletRequest r) throws ServletException {
		final Claims $ = (Claims) r.getAttribute("claims");

		return box.it(((List<String>) $.get("roles")).contains(role));
	}
}
