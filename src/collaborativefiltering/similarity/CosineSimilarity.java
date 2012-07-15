package collaborativefiltering.similarity;

import collaborativefiltering.utils.MathUtil;
import collaborativefiltering.utils.SimilarityIntersector;
import entities.UserRates;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 2:10 AM
 * * Оценивает схожесть пользователей используя косинусово расстояние.
 */
public class CosineSimilarity implements Similarity{
    @Override
    public double computeSimilarity(UserRates userRatesA, UserRates userRatesB){
        SimilarityIntersector intersector = new SimilarityIntersector(userRatesA, userRatesB);
        if(intersector.intersectionSize() == 0) return 0;

        double[] valuesA = intersector.getValuesA();
        double[] valuesB = intersector.getValuesB();

        double l2NormA = MathUtil.l2Norm(valuesA);
        double l2NormB = MathUtil.l2Norm(valuesB);
        double dotProduct = MathUtil.dotProduct(valuesA, valuesB);

        return dotProduct / l2NormA / l2NormB;
    }
}
