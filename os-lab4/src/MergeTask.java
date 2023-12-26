import java.lang.Comparable;

/**
 * MergeTask
 * 
 * @author X Y
 * @version 2018
 */
public class MergeTask<T extends Comparable<? super T>> implements Runnable
{
    T[] numbers;
    T[] firstArray;
    T[] secondArray;
    /**
     * Constructor for objects of class MergeTask
     * 
     */
    public MergeTask(T[] numbers, T[] firstArray, T[] secondArray) {
        this.firstArray = firstArray;
        this.secondArray = secondArray;
        this.numbers = numbers;
    }

    /**
     * The thread's run method
     */
    public void run() {
        T[] sortedList = numbers;
        int firstIndex = 0;
        int secondIndex = 0;
        int sortedIndex = 0;
        while((firstIndex!=firstArray.length) && (secondIndex!=secondArray.length)){
            //System.out.println(sortedIndex + " " + firstIndex + " " + firstArray[firstIndex]);
            //System.out.println(sortedIndex + " " + secondIndex + " " + secondArray[secondIndex]);
            while(firstArray[firstIndex] == null){
                firstIndex++;
            }
            while(secondArray[secondIndex] == null){
                secondIndex++;
                }
                if((firstArray[firstIndex].compareTo(secondArray[secondIndex]) <= 0) && (firstIndex != firstArray.length)){
                    sortedList[sortedIndex] = firstArray[firstIndex];
                    if(firstIndex<secondArray.length){
                        firstIndex++;
                    }
                } else if((firstArray[firstIndex].compareTo(secondArray[secondIndex]) > 0) && (secondIndex != secondArray.length)){
                    sortedList[sortedIndex] = secondArray[secondIndex];
                    if(secondIndex<secondArray.length){
                        secondIndex++;
                    }
                }
            sortedIndex++;
        }
        while(firstIndex<firstArray.length){
            sortedList[sortedIndex] = firstArray[firstIndex];
            if(firstIndex<secondArray.length){
                firstIndex++;
                sortedIndex++;
            }
        }
        while(secondIndex<secondArray.length){
            sortedList[sortedIndex] = secondArray[secondIndex];
            if(secondIndex<secondArray.length){
                secondIndex++;
                sortedIndex++;
            }
        }
    numbers = sortedList;
    }
}
    