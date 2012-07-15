import collaborativefiltering.CollaborativeFilter;
import collaborativefiltering.MemoryBasedCollaborativeFilter;
import collaborativefiltering.aggregation.Aggregator;
import entities.Item;
import entities.User;
import providers.inmemory.TestSimilarUsersProvider;
import providers.inmemory.TestUserRatesProvider;

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

        CollaborativeFilter collaborativeFilter = new MemoryBasedCollaborativeFilter(
                new TestUserRatesProvider(),
                new TestSimilarUsersProvider(),
                aggregator
        );

        System.out.print("Predicted rate of user " + user.getId() + " for item " + item.getId() + " is: " + collaborativeFilter.rate(user, item));
    }

}
