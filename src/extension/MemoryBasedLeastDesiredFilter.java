package extension;

import collaborativefiltering.aggregation.Aggregator;
import entities.Item;
import entities.Rates;
import entities.User;
import entities.UserRates;
import providers.ItemProvider;
import providers.SimilarUsersProvider;
import providers.UserRatesProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/16/12
 * Time: 12:25 AM
 */
public class MemoryBasedLeastDesiredFilter implements LeastDesiredFilter{

    /**
     * возвращает схожих пользователей
     */
    private final SimilarUsersProvider similarUsersProvider;

    /**
     * возвращае оценки пользователя
     */
    private final UserRatesProvider userRatesProvider;

    /**
     * выдает список всех вещей
     */
    private final ItemProvider itemProvider;

    /**
     * предсказывает оценку товара пользователем
     */
    private final Aggregator aggregator;

    public MemoryBasedLeastDesiredFilter(SimilarUsersProvider similarUsersProvider,
                                         UserRatesProvider userRatesProvider,
                                         ItemProvider itemProvider,
                                         Aggregator aggregator){
        this.similarUsersProvider = similarUsersProvider;
        this.userRatesProvider = userRatesProvider;
        this.itemProvider = itemProvider;
        this.aggregator = aggregator;
    }

    /**
     * @param user    - пользователь
     * @param maxRate - максимальный рейтинг, при котором товар считается "не желанным"
     * @return наименее желаемые для пользователя товары.
     */
    @Override
    public Rates getLeastDesired(User user, double maxRate){
        UserRates mainUserRates = userRatesProvider.provide(user);
        Set<Item> items = itemProvider.provide();
        Map<Item, Double> rates = new HashMap<Item, Double>(items.size());

        for(Item item : items){
            double rate = aggregator.aggregate(
                    mainUserRates,
                    item,
                    similarUsersProvider.provide(user, item)
            );
            if(rate < maxRate)
                rates.put(item, rate);
        }

        return new Rates(rates);
    }
}
