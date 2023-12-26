import java.lang.Comparable;

/**
 * MergeTask
 * 
 * @author X Y
 * @version 2018
 */
public class MergeTask1<T extends Comparable<? super T>> implements Runnable
{
    T[] numbers;
    T[] firstArray;
    T[] secondArray;
    T[][] arrays;
    T[][] merged;
    int N;
    /**
     * Constructor for objects of class MergeTask
     * 
     */
    public MergeTask1(T[] numbers, T[][] arrays, int N) {
        this.numbers = numbers;
        this.arrays = arrays;
        this.N = N;
    }

    /**
     * The thread's run method
     */
    public void run() {
        merged = arrays;
        int counter = N;
        while(N>1){
            N/=2;
            for(int i = 0; i<N; i++){
                firstArray = merged[i];
                secondArray = merged[i+N];
                T[] sortedList = numbers;
                System.out.println(firstArray.length + " " + secondArray.length);
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
            merged[i] = sortedList;
            }
        }
    numbers = merged[N];
    }
}