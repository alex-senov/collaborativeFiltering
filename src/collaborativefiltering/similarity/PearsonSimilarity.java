package collaborativefiltering.similarity;

import collaborativefiltering.utils.DescriptiveStatistics;
import collaborativefiltering.utils.SimilarityIntersector;
import entities.UserRates;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 1:11 AM
 * Оценивает схожесть пользователей используя коэффициент корреляции пирсона.
 */
public class PearsonSimilarity implements Similarity{

    @Override
    public double computeSimilarity(UserRates userRatesA, UserRates userRatesB){
        SimilarityIntersector intersector = new SimilarityIntersector(userRatesA, userRatesB);
        if(intersector.intersectionSize() == 0) return 0;
        if(intersector.intersectionSize() == 1) return PRIOR_SIMILARITY;

        double[] valuesA = intersector.getValuesA();
        double[] valuesB = intersector.getValuesB();

        double meanA = DescriptiveStatistics.mean(valuesA);
        double meanB = DescriptiveStatistics.mean(valuesB);
        double varA = DescriptiveStatistics.variance(valuesA, meanA);
        double varB = DescriptiveStatistics.variance(valuesB, meanB);
        double cov = DescriptiveStatistics.covariance(valuesA, valuesB, meanA, meanB);

        if(varA * varB == 0) return 0;
        return cov / Math.sqrt(varA * varB);
    }

    private static final double PRIOR_SIMILARITY = 0.0;
}
