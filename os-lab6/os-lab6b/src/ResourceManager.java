import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * ResourceManager
 *
 * @author Mohammed Alasmar
 * @version 2017
 */
public class ResourceManager {

    /**
     * Constructor for objects of class ResourceManager
     *
     */
    Semaphore semaphore;
    public ResourceManager(int maxResources) {
        // TODO: Create a semaphore with required number of permits
        semaphore = new Semaphore(maxResources);
        
        // TODO: print the initially available permits
        System.out.println("available_resources=" + semaphore.availablePermits());
    }

    /**
     * returns the available_resources
     */
    public int getAvailableResources() {
       // TODO 
       
       return semaphore.availablePermits();
    }

    /**
     * If sufficient resources available, then get one, otherwise wait. Multiple
     * simultaneous requests are allowed.
     */
    public void decreaseCount() {
       // TODO 
       try {
           semaphore.acquire();
           printGet();
       } catch (InterruptedException ex) {
           Logger.getLogger(ResourceManager.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     * Releases one resource then notify a potential waiting thread.
     */
    public void increaseCount() {
      // TODO 
      semaphore.release();
      printRelease();
    }
    
    /**
     * Prints the available_resources after getting a resource
     */
    private void printGet() {
        System.out.println("  (get one resource)     " +
			   Thread.currentThread().getName() +
			   " ==> available_resources=" + semaphore.availablePermits());
    }

    /**
     * Prints the available_resources after releasing a resource
     */
    private void printRelease() {
        System.out.println("  (release one resource) " +
			   Thread.currentThread().getName() +
			   " ==> available_resources=" + semaphore.availablePermits());
    }
}
