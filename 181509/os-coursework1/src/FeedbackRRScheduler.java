import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;

/**
 * Feedback Round Robin Scheduler
 * 
 * @version 2017
 */
public class FeedbackRRScheduler extends AbstractScheduler {

  // TODO
  private Queue<Process> readyQueue;
  private int timeQuantum;
  
  public FeedbackRRScheduler(){
      readyQueue = new PriorityQueue<Process>();
  }
  
  @Override
  public void initialize(Properties parameters) {
      timeQuantum = Integer.parseInt(parameters.getProperty("timeQuantum","10"));
  }
  
  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public void ready(Process process, boolean usedFullTimeQuantum) {

    // TODO
    if(usedFullTimeQuantum){
        process.setPriority(process.getPriority()+1);
    }
    readyQueue.offer(process);
  }

  /**
   * Removes the next process to be run from the ready queue 
   * and returns it. 
   * Returns null if there is no process to run.
   */
  public Process schedule() {

    // TODO
    System.out.println("Scheduler selects process "+readyQueue.peek());
    return readyQueue.poll();
  }
  
  @Override
  public int getTimeQuantum(){
      return timeQuantum;
  }
  
  @Override
  public boolean isPreemptive() {
    return true;
  }
}
