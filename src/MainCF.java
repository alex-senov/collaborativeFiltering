import collaborativefiltering.CollaborativeFilter;
import collaborativefiltering.MemoryBasedCollaborativeFilter;
import collaborativefiltering.aggregation.Aggregator;
import entities.Item;
import entities.User;
import providers.inmemory.TestSimilarUsersProvider;
import providers.inmemory.TestUserRatesProvider;
import providers.inmemory.util.UsersReaderSimple;
import providers.inmemory.util.UsersStorage;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 8:11 PM
 */
public class MainCF{

    public static void main(String[] args){
        ArgumentsManager argManager = new ArgumentsManager(args);
        User user = argManager.getUser();
        Item item = argManager.getItem();
        Aggregator aggregator = argManager.getAggregator();
        String filePath = argManager.getFilePath();

        try{
            UsersStorage usersStorage =
                    new UsersStorage(new UsersReaderSimple(filePath).getAllUsersRates());

            CollaborativeFilter collaborativeFilter = new MemoryBasedCollaborativeFilter(
                    new TestUserRatesProvider(usersStorage),
                    new TestSimilarUsersProvider(usersStorage),
                    aggregator
            );

            System.out.print("Predicted rate of user " + user.getId() + " for item " + item.getId() + " is: " + collaborativeFilter.rate(user, item));
        } catch(IOException e){
            throw new
                    RuntimeException(e);
        }
    }

}
