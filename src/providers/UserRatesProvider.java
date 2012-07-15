package providers;

import entities.User;
import entities.UserRates;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 1:23 AM
 */
public interface UserRatesProvider{

    /**
     * @param user - юзер
     * @return все оценки пользователя
     * @throws NoSuchElementException
     */
    public UserRates provide(User user) throws NoSuchElementException;
}
