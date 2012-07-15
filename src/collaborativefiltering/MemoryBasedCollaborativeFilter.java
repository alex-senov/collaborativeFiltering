package collaborativefiltering;

import collaborativefiltering.aggregation.Aggregator;
import entities.Item;
import entities.User;
import entities.UserRates;
import providers.SimilarUsersProvider;
import providers.UserRatesProvider;

import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 12:35 AM
 */
public class MemoryBasedCollaborativeFilter implements CollaborativeFilter{

    /**
     * возвращает схожих пользователей
     */
    private final SimilarUsersProvider similarUsersProvider;

    /**
     * возвращае оценки пользователя
     */
    private final UserRatesProvider userRatesProvider;

    /**
     * предсказывает оценку товара пользователем
     */
    private final Aggregator aggregator;

    public MemoryBasedCollaborativeFilter(UserRatesProvider userRatesProvider, SimilarUsersProvider similarUsersProvider, Aggregator aggregator){
        this.userRatesProvider = userRatesProvider;
        this.similarUsersProvider = similarUsersProvider;
        this.aggregator = aggregator;
    }

    @Override
    public double rate(User user, Item item){
        UserRates mainUserRates = userRatesProvider.provide(user);
        Set<UserRates> similarUsersRates = similarUsersProvider.provide(user, item);
        return aggregator.aggregate(mainUserRates, item, similarUsersRates);
    }


}
