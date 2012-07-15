/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/16/12
 * Time: 2:06 AM
 */
public class Main{

    public static void main(String[] args){
        ArgumentsManager argManager = new ArgumentsManager(args);
        String task = argManager.getTask();
        if(task.equals(TASK_COLLABORATIVE_FILTERING)){
            MainCF.main(args);
        }
        if(task.equals(TASK_LEAST_DESIRED)){
            MainLD.main(args);
        }
    }

    private static final String TASK_COLLABORATIVE_FILTERING = "cf";
    private static final String TASK_LEAST_DESIRED = "ld";

}
