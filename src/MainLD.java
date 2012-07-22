import collaborativefiltering.aggregation.Aggregator;
import entities.Rates;
import entities.User;
import extension.LeastDesiredFilter;
import extension.MemoryBasedLeastDesiredFilter;
import providers.inmemory.TestItemProvider;
import providers.inmemory.TestSimilarUsersProvider;
import providers.inmemory.TestUserRatesProvider;
import providers.inmemory.util.UsersReaderSimple;
import providers.inmemory.util.UsersStorage;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/16/12
 * Time: 1:59 AM
 */
public class MainLD{
    public static void main(String[] args){
        ArgumentsManager argManager = new ArgumentsManager(args);
        User user = argManager.getUser();
        Aggregator aggregator = argManager.getAggregator();
        double maxRate = argManager.getMaxRate();

        String filePath = argManager.getFilePath();

        try{
            UsersStorage usersStorage =
                    new UsersStorage(new UsersReaderSimple(filePath).getAllUsersRates());

            LeastDesiredFilter leastDesiredFilter = new MemoryBasedLeastDesiredFilter(
                new TestSimilarUsersProvider(usersStorage),
                new TestUserRatesProvider(usersStorage),
                new TestItemProvider(),
                aggregator
            );

            Rates leastDesired = leastDesiredFilter.getLeastDesired(user, maxRate);
            System.out.println("Least desired items for user " + user.getId() + " are: " + leastDesired.toString());
        } catch(IOException e){
            throw new
                    RuntimeException(e);
        }
    }
}
