package collaborativefiltering.aggregation;

import entities.Item;
import entities.UserRates;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 2:27 AM
 * Аггрегатор, просто усредняющий оценки схожих пользователей.
 */
public class UniformAggregator implements Aggregator{

    @Override
    public double aggregate(UserRates userRates, Item item, Collection<UserRates> similarUsersRates){
        double rate = 0;
        for(UserRates ur : similarUsersRates){
            rate += ur.getRates().getRate(item);
        }
        return rate / similarUsersRates.size();
    }
}
