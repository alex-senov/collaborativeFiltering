import collaborativefiltering.aggregation.Aggregator;
import collaborativefiltering.aggregation.NormalizedSimilarityBasedAggregator;
import collaborativefiltering.aggregation.StandardizedSimilarityBasedAggregator;
import collaborativefiltering.aggregation.UniformAggregator;
import collaborativefiltering.similarity.CosineSimilarity;
import collaborativefiltering.similarity.PearsonSimilarity;
import collaborativefiltering.similarity.Similarity;
import entities.Item;
import entities.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/16/12
 * Time: 1:25 AM
 */
public class ArgumentsManager{

    private final Map<String, String> arguments;

    public ArgumentsManager(String[] args){
        if((args.length % 2) != 0 || args.length > 2 * indicators.size())
            throw new IllegalArgumentException("Wrong number of parameters!");

        arguments = new HashMap<String, String>(args.length / 2);
        for(int i = 0; i < args.length / 2; ++i){
            arguments.put(args[2 * i], args[2 * i + 1]);
        }
    }

    public String getTask(){
        if(!arguments.containsKey(TASK))
            throw new IllegalArgumentException("Necessary argument " + TASK + " missing.");
        return arguments.get(TASK);
    }

    public User getUser(){
        return new User(
                getIntValue(USER)
        );
    }

    public Item getItem(){
        return new Item(
                getIntValue(ITEM)
        );
    }

    public double getMaxRate(){
        if(arguments.containsKey(MAX_RATE))
            return Double.parseDouble(arguments.get(MAX_RATE));
        return DEFAULT_MAX_RATE;
    }

    public Aggregator getAggregator(){
        long aggId = getIntValue(AGGREGATOR);

        if(1 == aggId) return new UniformAggregator();

        long simId = getIntValue(SIMILARITY);
        Similarity similarity;
        if(1 == simId)
            similarity = new PearsonSimilarity();
        if(2 == simId)
            similarity = new CosineSimilarity();
        else
            throw new RuntimeException("Illegal " + SIMILARITY + "argument value: " + simId);

        if(2 == aggId)
            return new NormalizedSimilarityBasedAggregator(similarity);
        if(3 == aggId)
            return new StandardizedSimilarityBasedAggregator(similarity);
        else
            throw new RuntimeException("Illegal " + AGGREGATOR + "argument value: " + aggId);
    }

    private long getIntValue(String key){
        if(!arguments.containsKey(key))
            throw new IllegalArgumentException("Necessary argument " + key + " missing.");
        return Long.parseLong(arguments.get(key));
    }


    private static final String USER = "-u";
    private static final String ITEM = "-i";
    private static final String AGGREGATOR = "-a";
    private static final String SIMILARITY = "-s";
    private static final String TASK = "-t";
    private static final String MAX_RATE = "-m";

    private static final Set<String> indicators;

    static{
        indicators = new HashSet<String>();
        indicators.add(USER);
        indicators.add(ITEM);
        indicators.add(AGGREGATOR);
        indicators.add(SIMILARITY);
        indicators.add(TASK);
        indicators.add(MAX_RATE);
    }

    private final double DEFAULT_MAX_RATE = 3.0;
}
