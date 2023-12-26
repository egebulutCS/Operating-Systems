/**
 * Primes
 * 
 * @author X Y
 * @version 2018
 */
import java.util.Arrays;
public class Primes
{
    /**
     * Prints a usage message
     */
    public static void usage() {
        System.err.println("Usage: java Primes N");
        System.err.println("  Outputs the prime numbers up to N");
        System.err.println("  N must be an integer >= 2");
    }

    /**
     * Main method
     * 
     * @param  args   the command line arguments
     */
    public static void main(String args[]) {
        // parse arguments
        int N = Integer.parseInt(args[0]);
        boolean[] isPrime = new boolean[N];
        
        // initially assume all integers are prime
        Arrays.fill(isPrime, Boolean.TRUE);
        
        
        // create thread 
        Thread t1 = new Thread(new PrimesTask(isPrime));
        
        
	    // start thread
            t1.start();
            
        

        // wait until the thread terminates
        try{t1.join();} catch (InterruptedException e) {}
        

        // print the primes
        for(int i = 2; i < N; i++){
            if(isPrime[i] == true){
                System.out.print(i + ", ");
            }
        }
    }
}
