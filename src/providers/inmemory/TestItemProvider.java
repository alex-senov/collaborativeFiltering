package providers.inmemory;

import entities.Item;
import providers.ItemProvider;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/16/12
 * Time: 12:05 AM
 */
public class TestItemProvider implements ItemProvider{
    @Override
    public Set<Item> provide(){
        Set<Item> result = new HashSet<Item>(MAX_ITEM_ID);
        for(int i = 1; i <= MAX_ITEM_ID; ++i){
            result.add(new Item(i));
        }
        return result;
    }

    private static final int MAX_ITEM_ID = 101;
}
