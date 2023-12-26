/**
 * Letters
 * 
 * @author <your student ID>
 * @version 2018
 */
import java.util.Arrays;
public class Letters
{
    /**
     * Prints a usage message
     */
    public static void usage() {
        System.err.println("Usage: java Letters WORDS*");
        System.err.println("  Outputs which letters a-z occur in WORDS*");
	System.err.println("  WORDS* can be any number of words");
	System.err.println("    separated by spaces");
    }

    /**
     * Main method
     * 
     * @param  args   the command line arguments
     */
    public static void main(String args[]) {
        // check arguments
        // (args is the array of words passed on the command line)
        
        // Use a suitable data structure for storing the map (char -> boolean)
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        boolean[] isPresent = new boolean[alphabet.length];
        Arrays.fill(isPresent, Boolean.FALSE);
        // initialise the data structure
        Thread[] threads = new Thread[args.length];
        // create a thread for each word and start the threads 
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new LettersTask(args[i].toCharArray(),alphabet,isPresent));
        }
        // wait until the threads have terminated
        for(int i = 0; i < threads.length; i++){
            threads[i].start();
            try{threads[i].join();} catch (InterruptedException e) {};
        }
        for(int i = 0; i <= alphabet.length; i++){
            System.out.println(alphabet[i] + ": " + isPresent[i]);
        }
        // output the result in the following format:
        // a: true
        // b: false
        // ...
        // z: false

    }
}
