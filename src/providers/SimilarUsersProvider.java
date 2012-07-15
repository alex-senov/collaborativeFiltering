package providers;

import entities.Item;
import entities.User;
import entities.UserRates;

import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 1:07 AM
 */
public interface SimilarUsersProvider{

    /**
     * @param user - юзер
     * @param item - товар
     * @return список пользователей, похожих на юзера и оценивних товар.
     * @throws NoSuchElementException
     */
    public Set<UserRates> provide(User user, Item item) throws NoSuchElementException;
}
