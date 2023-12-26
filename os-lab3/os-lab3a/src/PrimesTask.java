/**
 * PrimesTask
 * 
 * @author X Y
 * @version 2018
 */
public class PrimesTask implements Runnable
{
    boolean[] isPrime;
    int N;
    /**
     * Constructor for objects of class PrimesTask
     * 
     */
    public PrimesTask(boolean[] b) {
        isPrime = b;
    }

    /**
     * The thread's run method
     */
    public void run() {
        // implement the run method
        for(int i = 2; i <= isPrime.length; i++){
            for(int j = i; j <= isPrime.length; j++){
                int index = i*j;
                if(index < isPrime.length){
                    isPrime[index] = false;
                }
            }
        }
        
        
    }
}
