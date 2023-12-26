
import java.util.Arrays;

/**
 * Sorting
 * 
 * @author X Y
 * @version 2018
 */
public class Sorting
{
    /**
     * Prints a usage message
     */
    public static void usage() {
        System.err.println("Usage: java Sorting ARGS");
        System.err.println("  Outputs ARGS in ascending order");
        System.err.println("  ARGS can be any number of words");
    }

    /**
     * Main method
     * 
     * @param  args   the command line arguments
     */
    public static void main(String args[]) {
        // use a suitable data structure to hold the lists
        Integer[] numbers = new Integer[args.length];
        for(int i = 0; i < args.length; i++){
            numbers[i] = Integer.parseInt(args[i]);
        }
        // parse command line arguments and split the list
        Integer[] firstHalf = Arrays.copyOfRange(numbers, 0, (numbers.length/2));
        Integer[] secondHalf = Arrays.copyOfRange(numbers, (numbers.length/2), numbers.length);
        // create threads for the sorting tasks 
        Thread sortThread1 = new Thread(new SortTask<Integer>(firstHalf));
        Thread sortThread2 = new Thread(new SortTask<Integer>(secondHalf));
        // wait until the threads terminate
        sortThread1.start();
        sortThread2.start();
        try{sortThread1.join();} catch (InterruptedException e) {}
        try{sortThread2.join();} catch (InterruptedException e) {}
        // create a thread for the merging task 
        Thread mergeThread = new Thread(new MergeTask<Integer>(numbers, firstHalf, secondHalf));
        mergeThread.start();
        try{mergeThread.join();} catch (InterruptedException e) {}
        // print the result
        System.out.print("Sorted array: { ");
        int i = 0;
        for(int n:numbers){
            System.out.print(n);
            if(i!=numbers.length-1){
                System.out.print(", ");
            }
            i++;
        }
        System.out.print(" }");
    }
}
