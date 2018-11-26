/** Since 2018 - 11 - 26
 * @author Igor Bashmashnikov
 * @author Or Feldman */
package parkingLot;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

/** @author Igor Bashmashnikov */
@SuppressWarnings("static-method") public class UserTest {
  @Test public void testEquals() {
    final User user1 = new User("igor", "igor@igor", 123456);
    final User user2 = new User("igor", "igor@igor", 123456);
    assert user1.equals(user1);
    assert !user1.equals(user2);
    assert !user2.equals(user1);
  }

  @Test public void testIdSetting() {
    final User user1 = new User("igor", "igor@igor", 123456);
    final User user2 = new User("igor", "igor@igor", 123456);
    final User user3 = new User("igor", "igor@igor", 123456);
    assert user1.getId() < user2.getId() && user2.getId() < user3.getId();
  }

  @Test public void testBuyersFeedback() {
    final User user = new User("or", "or@or", 123456);
    azzert.that(user.getBuyerFeedback(), is(0.0));
    user.addBuyerFeedback(2.0);
    user.addBuyerFeedback(11.0);
    user.addBuyerFeedback(1.0);
    azzert.that(user.getBuyerFeedback(), is(1.5));
    user.addBuyerFeedback(3.0);
    azzert.that(user.getBuyerFeedback(), is(2.0));
  }

  @Test public void testSellersFeedback() {
    final User user = new User("or", "or@or", 123456);
    azzert.that(user.getSellerFeedback(), is(0.0));
    user.addSellerFeedback(2.0);
    user.addSellerFeedback(11.0);
    user.addSellerFeedback(1.0);
    azzert.that(user.getSellerFeedback(), is(1.5));
    user.addSellerFeedback(3.0);
    azzert.that(user.getSellerFeedback(), is(2.0));
  }
}
