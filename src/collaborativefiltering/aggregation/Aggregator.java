package collaborativefiltering.aggregation;

import entities.Item;
import entities.UserRates;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 2:20 AM
 * Агрегирует информацию о рейтинге интересуемой вещи у похожих пользователей для предсказания рейтинга данного пользователя
 */
public interface Aggregator{

    /**
     * @param userRates         - интересуемый пользователь и его оценки вещей
     * @param item              - интересующая вещь
     * @param similarUsersRates - польззователи, похожие на интересуемого и оценившие (выставившие рейтинг) интересуемой вещи
     * @return - предположительный рейтинг выставленный пользователем интересующей нас вещи
     */
    public double aggregate(UserRates userRates, Item item, Collection<UserRates> similarUsersRates);

}
