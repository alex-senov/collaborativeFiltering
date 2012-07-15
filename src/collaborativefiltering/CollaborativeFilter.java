package collaborativefiltering;

import entities.Item;
import entities.User;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 12:28 AM
 */
public interface CollaborativeFilter{

    /**
     * @param user -пользователь
     * @param item - товар
     * @return прогноз рейтинга, который выставил бы пользователь этому товару
     */
    public double rate(User user, Item item);
}
