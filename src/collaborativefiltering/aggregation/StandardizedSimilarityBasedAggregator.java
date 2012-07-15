package collaborativefiltering.aggregation;

import collaborativefiltering.similarity.Similarity;
import entities.Item;
import entities.UserRates;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 2:59 AM
 * Вычисление прогнозируемого рейтинга происходит через взвешанную, центрированную сумму рейтингов похожих пользователей
 * Веса - схожесть, вычисляемая similarity
 * Центрирование - на средний рейтинг пользователя
 */
public class StandardizedSimilarityBasedAggregator implements Aggregator{
    private final Similarity similarity;

    public StandardizedSimilarityBasedAggregator(Similarity similarity){
        this.similarity = similarity;
    }

    @Override
    public double aggregate(UserRates userRates, Item item, Collection<UserRates> similarUsersRates){
        double rate = 0;
        double absSimSum = 0;
        for(UserRates uRates : similarUsersRates){
            double uMean = getMeanRate(uRates);
            double sim = similarity.computeSimilarity(userRates, uRates);
            absSimSum += Math.abs(sim);
            rate += sim * (uRates.getRates().getRate(item) - uMean);
        }
        return getMeanRate(userRates) + rate / absSimSum;
    }

    private static double getMeanRate(UserRates userRates){
        double mean = 0;
        for(double val : userRates.getRates().values()){
            mean += val;
        }
        return mean / userRates.getRates().size();
    }
}
