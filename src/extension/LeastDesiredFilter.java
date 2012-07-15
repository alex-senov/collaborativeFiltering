package extension;

import entities.Rates;
import entities.User;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/16/12
 * Time: 12:21 AM
 * Возвращает (предполагаемо) наименее желаемые для пользователя товары.
 */
public interface LeastDesiredFilter{

    /**
     * @param user    - пользователь
     * @param maxRate - максимальный рейтинг, при котором товар считается не "желанным"
     * @return наименее желаемые для пользователя товары.
     */
    public Rates getLeastDesired(User user, double maxRate);
}
