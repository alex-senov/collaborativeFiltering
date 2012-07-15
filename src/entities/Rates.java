package entities;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 7:43 PM
 * Класс - оценки товаров
 * (лучше сделать интерфейс с множеством реализаций, но пока без надобности
 */
public class Rates{

    private final Map<Item, Double> rates;

    public Rates(Map<Item, Double> rates){
        this.rates = rates;
    }

    /**
     * sayse, whether item is rated or not
     *
     * @param item - some item
     * @return true, if item is rated, false otherwise
     */
    public boolean isRated(Item item){
        return rates.containsKey(item);
    }

    /**
     * returns item rate
     *
     * @param item - item
     * @return rate if item rated and null if not.
     */
    public Double getRate(Item item){
        return rates.get(item);
    }

    public int size(){
        return rates.size();
    }

    public Collection<Double> values(){
        return rates.values();
    }

    public Set<Item> keySet(){
        return rates.keySet();
    }

    @Override
    public int hashCode(){
        return rates.hashCode();
    }

    @Override
    public boolean equals(Object o){
        return rates.equals(o);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String toString(){
        return rates.toString();
    }
}
