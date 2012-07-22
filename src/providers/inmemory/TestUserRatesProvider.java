package providers.inmemory;

import entities.Rates;
import entities.User;
import entities.UserRates;
import providers.UserRatesProvider;
import providers.inmemory.util.UsersStorage;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 7:54 PM
 */
public class TestUserRatesProvider implements UserRatesProvider{
    private final UsersStorage usersStorage;

    public TestUserRatesProvider(UsersStorage usersStorage){
        this.usersStorage = usersStorage;
    }

    @Override
    public UserRates provide(User user){
        Rates rates = usersStorage.getUserRates(user);
        if(null == rates)
            throw new NoSuchElementException("User " + user + " doesn't exist.");
        return new UserRates(
                user,
                usersStorage.getUserRates(user)
        );
    }
}
