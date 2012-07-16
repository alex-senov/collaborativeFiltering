package providers.inmemory.util;

import entities.Item;
import entities.Rates;
import entities.User;
import entities.UserRates;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 7:15 PM
 */
public class UsersReader{
    //private static String FILE_NAME = UsersReader.class.getClassLoader().getResource("resources/test_users_rates.txt").getPath();
    private static InputStream inputStream = UsersReader.class.getClassLoader().getResourceAsStream("resources/test_users_rates.txt");

    private static final String DELIMITER = ";";
    private static final String SEPARATOR = ",";

    public static Map<User, Rates> getAllUsersRates() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        Map<User, Rates> result = new HashMap<User, Rates>();
        while(reader.ready()){
            UserRates userRates = getUserRatesFromString(reader.readLine());
            result.put(userRates.getUser(), userRates.getRates());
        }
        return result;
    }

    private static UserRates getUserRatesFromString(String line){
        int delimiterIndex = line.indexOf(DELIMITER);
        long userId = Long.parseLong(line.substring(0, delimiterIndex));
        line = line.substring(delimiterIndex + 1);

        Map<Item, Double> rates = new HashMap<Item, Double>();
        if(line.contains(DELIMITER)){
            for(String itemRate : line.split(DELIMITER)){
                int sepIndex = itemRate.indexOf(SEPARATOR);
                rates.put(
                        new Item(Long.parseLong(itemRate.substring(0, sepIndex))),
                        Double.parseDouble(itemRate.substring(sepIndex + 1))
                );
            }
        }
        return new UserRates(
                new User(userId),
                new Rates(rates)
        );
    }

}




























