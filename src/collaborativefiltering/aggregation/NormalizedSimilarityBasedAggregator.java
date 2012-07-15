package collaborativefiltering.aggregation;

import collaborativefiltering.similarity.Similarity;
import entities.Item;
import entities.UserRates;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 2:39 AM
 * Вычисление прогнозируемого рейтинга происходит через взвешанную сумму рейтингов похожих пользователей
 * Веса - схожесть, вычисляемая similarity
 */
public class NormalizedSimilarityBasedAggregator implements Aggregator{

    /**
     * определяет схожесть пользователей
     */
    private final Similarity similarity;

    public NormalizedSimilarityBasedAggregator(Similarity similarity){
        this.similarity = similarity;
    }

    @Override
    public double aggregate(UserRates userRates, Item item, Collection<UserRates> similarUsersRates){
        double rate = 0;
        double absSimSum = 0;
        for(UserRates ur : similarUsersRates){
            double sim = similarity.computeSimilarity(userRates, ur);
            absSimSum += Math.abs(sim);
            rate += sim * ur.getRates().getRate(item);
        }
        return rate / absSimSum;
    }
}
