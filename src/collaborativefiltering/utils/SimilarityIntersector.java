package collaborativefiltering.utils;

import entities.Item;
import entities.UserRates;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 9:23 PM
 */
public class SimilarityIntersector{

    private final double[] valuesA;
    private final double[] valuesB;

    public SimilarityIntersector(UserRates userRatesA, UserRates userRatesB){
        Set<Item> itemsIntersection = new HashSet<Item>(userRatesA.getRates().keySet());
        itemsIntersection.retainAll(userRatesB.getRates().keySet());
        valuesA = new double[itemsIntersection.size()];
        valuesB = new double[itemsIntersection.size()];
        int ind = 0;
        for(Item item : itemsIntersection){
            valuesA[ind] = userRatesA.getRates().getRate(item);
            valuesB[ind] = userRatesB.getRates().getRate(item);
            ++ind;
        }
    }

    public int intersectionSize(){
        return valuesA.length;
    }

    public double[] getValuesA(){
        return valuesA;
    }

    public double[] getValuesB(){
        return valuesB;
    }
}
