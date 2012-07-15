package collaborativefiltering.utils;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 2:12 AM
 */
public class MathUtil{

    public static double sumOfSquares(double[] values){
        double sumOfSquares = 0;
        for(double val : values){
            sumOfSquares += val * val;
        }
        return sumOfSquares;
    }

    public static double l2Norm(double[] values){
        return Math.sqrt(sumOfSquares(values));
    }

    /**
     * !warning! length of valuesA must be same as valuesB, take care about it yourself.
     *
     * @param valuesA - first values
     * @param valuesB - second values
     * @return dot product of two arrays: valuesA and valuesB
     */
    public static double dotProduct(double[] valuesA, double[] valuesB){
        double dotProduct = 0;
        for(int i = 0; i < valuesA.length; ++i){
            dotProduct = valuesA[i] * valuesB[i];
        }
        return dotProduct;
    }

}
