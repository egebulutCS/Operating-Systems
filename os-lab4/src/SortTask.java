import java.lang.Comparable;
import java.util.Arrays;

/**
 * SortTask
 * 
 * @author X Y
 * @version 2018
 */
public class SortTask<T extends Comparable<? super T>> implements Runnable
{
    T[] array;
    /**
     * Constructor for objects of class SortTask
     * 
     */
    public SortTask(T[] array) {
        this.array = array;
    }

    /**
     * The thread's run method
     */
    public void run() {
        Arrays.sort(array);
    }
}
