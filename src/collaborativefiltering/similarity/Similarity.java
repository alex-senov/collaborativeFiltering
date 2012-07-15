package collaborativefiltering.similarity;

import entities.UserRates;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 12:39 AM
 * Мера схожести пользователей по их оценкам
 */
public interface Similarity{

    /**
     * @param userRatesA - первый пользователь
     * @param userRatesB - второй пользователь
     * @return оценка их схожести
     */
    public double computeSimilarity(UserRates userRatesA, UserRates userRatesB);
}
