package collaborativefiltering.utils;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 1:51 AM
 */
public class DescriptiveStatistics{

    public static double mean(double[] values){
        double mean = 0;
        for(double val : values){
            mean += val;
        }
        return mean / values.length;
    }

    public static double variance(double[] values){
        double mean = mean(values);
        double var = 0;
        for(double val : values){
            var += (val - mean) * (val - mean);
        }
        return var / values.length;
    }

    public static double variance(double[] values, double mean){
        double var = 0;
        for(double val : values){
            var += (val - mean) * (val - mean);
        }
        return var / values.length;
    }

    /**
     * !warning! length of valuesA must be same as valuesB, take care about it yourself.
     *
     * @param valuesA - first values
     * @param valuesB - second values
     * @param meanA   - mean of valuesA
     * @param meanB   - mean of valuesB
     * @return covariance two arrays: valuesA and valuesB
     */
    public static double covariance(double[] valuesA, double[] valuesB, double meanA, double meanB){
        double cov = 0;
        for(int i = 0; i < valuesA.length; ++i){
            cov += (valuesA[i] - meanA) * (valuesB[i] - meanB);
        }
        return cov / valuesA.length;
    }
}
