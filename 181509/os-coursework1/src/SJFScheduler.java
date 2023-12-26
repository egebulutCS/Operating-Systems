import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;

/**
 * Shortest Job First Scheduler
 * 
 * @version 2017
 */
public class SJFScheduler extends AbstractScheduler {

  // TODO
  private Queue<Process> readyQueue;
  int initialBurstEstimate;
  double alphaBurstEstimate;
  
  public SJFScheduler(){
      readyQueue = new PriorityQueue<Process>(); // priorty queue
  }
  
  public void initialize(Properties parameters) {
      initialBurstEstimate = Integer.parseInt(parameters.getProperty("initialBurstEstimate","10"));
      alphaBurstEstimate = Double.parseDouble(parameters.getProperty("alphaBurstEstimate","0.5"));
  }
  
  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public void ready(Process process, boolean usedFullTimeQuantum) {

    // TODO
//    System.out.println("Initial Burst Estimate value: " + initialBurstEstimate);
//    System.out.println("Alpha Burst Estimate value: " + alphaBurstEstimate);
//    int newEstimate = (int) (((alphaBurstEstimate*process.getRecentBurst())) + ((1 - alphaBurstEstimate) * process.getPriority()));
//    process.setPriority(newEstimate);
    readyQueue.offer(process);
  }

  /**
   * Removes the next process to be run from the ready queue 
   * and returns it. 
   * Returns null if there is no process to run.
   */
  public Process schedule() {

    // TODO
    Process[] processes = new Process[readyQueue.size()];
    Process p;
    for(int i = 0; i<processes.length; i++){
        p = readyQueue.poll();
        int newEstimate = (int) (((alphaBurstEstimate*p.getRecentBurst())) + ((1 - alphaBurstEstimate) * initialBurstEstimate));
        p.setPriority(newEstimate);
        processes[i] = p;
        initialBurstEstimate = newEstimate;
    }
    for(int i = 0; i<processes.length; i++){
        readyQueue.offer(processes[i]);
    }
    System.out.println("Scheduler selects process "+readyQueue.peek());
    return readyQueue.poll();
  }
  @Override
  public boolean isPreemptive() {
    return false;
  }
}
