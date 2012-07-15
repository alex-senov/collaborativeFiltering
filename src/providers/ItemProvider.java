package providers;

import entities.Item;

import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/16/12
 * Time: 12:05 AM
 */
public interface ItemProvider{

    /**
     * @return все товары
     */
    public Set<Item> provide();
}
