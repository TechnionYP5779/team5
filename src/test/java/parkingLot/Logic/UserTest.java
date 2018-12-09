/** Since 2018 - 11 - 26
 * @author Igor Bashmashnikov
 * @author Or Feldman */
package parkingLot.Logic;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
import parkingLot.Logic.User;
import parkingLot.Logic.User.*;

/** @author Igor Bashmashnikov */
@SuppressWarnings("static-method")
public class UserTest {
	@Test
	public void testEquals() {
		final User user1 = new User("igor", "igor@igor", 123456);
		final User user2 = new User("igor", "igor@igor", 123456);
		assert user1.equals(user1);
		assert !user1.equals(user2);
		assert !user2.equals(user1);
	}

	@Test
	public void testIdSetting() {
		final User user1 = new User("igor", "igor@igor", 123456);
		final User user2 = new User("igor", "igor@igor", 123456);
		final User user3 = new User("igor", "igor@igor", 123456);
		assert user1.getId() < user2.getId() && user2.getId() < user3.getId();
	}

	@Test
	public void testBuyersFeedback() {
		final User user = new User("or", "or@or", 123456);
		azzert.that(user.getBuyerRank(), is(0.0));
		user.addBuyerFeedback(FEEDBACK.FINE);
		user.addBuyerFeedback(FEEDBACK.EXCELLENT);
		user.addBuyerFeedback(FEEDBACK.GOOD);
		azzert.that(user.getBuyerRank(), is(4.0));
		user.addBuyerFeedback(FEEDBACK.BAD);
		azzert.that(user.getBuyerRank(), is(3.5));
	}

	@Test
	public void testSellersFeedback() {
		final User user = new User("or", "or@or", 123456);
		azzert.that(user.getBuyerRank(), is(0.0));
		user.addSellerFeedback(FEEDBACK.FINE);
		user.addSellerFeedback(FEEDBACK.EXCELLENT);
		user.addSellerFeedback(FEEDBACK.GOOD);
		azzert.that(user.getSellerRank(), is(4.0));
		user.addSellerFeedback(FEEDBACK.BAD);
		azzert.that(user.getSellerRank(), is(3.5));
	}
}
