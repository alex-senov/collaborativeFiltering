package providers.inmemory.util;

import entities.Item;
import entities.Rates;
import entities.User;
import entities.UserRates;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 7:38 PM
 */
public class UsersStorage{

    private static final Map<User, Rates> usersAndRates;

    public static Rates getUserRates(User user){
        return usersAndRates.get(user);
    }

    public static Set<UserRates> getUsersWithItem(Item item){
        Set<UserRates> result = new HashSet<UserRates>();
        for(Map.Entry<User, Rates> userRate : usersAndRates.entrySet()){
            if(userRate.getValue().isRated(item)){
                result.add(new UserRates(
                        userRate.getKey(),
                        userRate.getValue()
                ));
            }
        }
        return result;
    }


    static{
        try{
            usersAndRates = UsersReader.getAllUsersRates();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
