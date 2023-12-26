
import java.util.Arrays;

/**
 * Sorting
 * 
 * @author X Y
 * @version 2018
 */
public class SortingN
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
        int N = Integer.parseInt(args[args.length-1]);
        Integer[] numbers = new Integer[args.length-1];
        Integer[][] arrays = new Integer[N][];
        for(int i = 0; i < args.length-1; i++){
            numbers[i] = Integer.parseInt(args[i]);
        }
        // parse command line arguments and split the list
        int size = numbers.length/N;
        for(int i = 0; i<N; i++){
            arrays[i] = Arrays.copyOfRange(numbers, size*i, size*(i+1));
        }
        //Integer[] firstHalf = Arrays.copyOfRange(numbers, 0, (numbers.length/2));
        //Integer[] secondHalf = Arrays.copyOfRange(numbers, (numbers.length/2), numbers.length);
        // create threads for the sorting tasks 
        Thread[] threads = new Thread[N];
        for(int i = 0; i<N; i++){
            threads[i] = new Thread(new SortTask<Integer>(arrays[i]));
        }
        //Thread sortThread1 = new Thread(new SortTask<Integer>(firstHalf));
        //Thread sortThread2 = new Thread(new SortTask<Integer>(secondHalf));
        // wait until the threads terminate
        for(int i=0; i<N; i++){
            threads[i].start();
            try{threads[i].join();} catch (InterruptedException e) {}
        }
        //sortThread1.start();
        //sortThread2.start();
        //try{sortThread1.join();} catch (InterruptedException e) {}
        //try{sortThread2.join();} catch (InterruptedException e) {}
        // create a thread for the merging task 
//        Thread[] merges = new Thread[N];
//        for(int i=0; i<N-1; i++){
//            merges[i] = new Thread(new MergeTask<Integer>(numbers,arrays));
//        }
//        for(int i=0; i<N-1; i++){
//            merges[i].start();
//            try{merges[i].join();} catch (InterruptedException e) {}
//        }
        Thread mergeThread = new Thread(new MergeTask1<Integer>(numbers, arrays, N));
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
