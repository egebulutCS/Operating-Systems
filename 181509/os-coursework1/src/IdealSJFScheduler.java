import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;

/**
 * Ideal Shortest Job First Scheduler
 * 
 * @version 2017
 */
public class IdealSJFScheduler extends AbstractScheduler {

  // TODO
  private Queue<Process> readyQueue;
  
  public IdealSJFScheduler(){
    readyQueue = new PriorityQueue<Process>();
  }
  
  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public void ready(Process process, boolean usedFullTimeQuantum) {

    // TODO
    //process.setPriority(process.getNextBurst());
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
        p.setPriority(p.getNextBurst());
        processes[i] = p;
    }
    for(int i =0; i<processes.length; i++){
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
