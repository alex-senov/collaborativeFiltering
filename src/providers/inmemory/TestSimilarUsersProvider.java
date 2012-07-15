package providers.inmemory;

import entities.Item;
import entities.User;
import entities.UserRates;
import providers.SimilarUsersProvider;
import providers.inmemory.util.UsersStorage;

import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 7:59 PM
 */
public class TestSimilarUsersProvider implements SimilarUsersProvider{

    @Override
    public Set<UserRates> provide(User user, Item item){
        return UsersStorage.getUsersWithItem(item);
    }
}
