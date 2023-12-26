
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ResourceManager
 *
 * @author Mohammed Alasmar
 * @version 2017
 */
public class ResourceManager {

    private int availableResources;

    /**
     * Constructor for objects of class ResourceManager
     *
     */
    public ResourceManager(int maxResources) {
        this.availableResources = maxResources;
    }

    /**
     * returns the availableResources
     */
    public int getAvailableResources() {
        return availableResources;
    }

    /**
     * If sufficient resources available, then get one, otherwise wait. Multiple
     * simultaneous requests are allowed. Print the availableResources after
     * taking a resource.
     */
    public synchronized void decreaseCount() {
      // TODO
      while(availableResources<1){
          try {
              wait();
          } catch (InterruptedException ex) {
              Logger.getLogger(ResourceManager.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      availableResources--;
      printGet();
    }

    /**
     * Releases one resource then notify a potential waiting thread. Print the
     * availableResources after releasing a resource.
     */
    public synchronized void increaseCount() {
      // TODO
      notifyAll();
      availableResources++;
      printRelease();
  
    }

    /**
     * Prints the available_resources after getting a resource
     */
    private void printGet() {
        System.out.println("  (get one resource)     " +
			   Thread.currentThread().getName() +
			   " ==> available_resources=" + availableResources);
    }

    /**
     * Prints the available_resources after releasing a resource
     */
    private void printRelease() {
        System.out.println("  (release one resource) " +
			   Thread.currentThread().getName() +
			   " ==> available_resources=" + availableResources);
    }

}
