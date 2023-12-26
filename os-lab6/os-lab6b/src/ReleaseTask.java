
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 * ReleaseTask
 *
 * @author Mohammed Alasmar
 * @version 2017
 */
public class ReleaseTask implements Runnable {

  // reference to the shared resourceManager
  private ResourceManager resourceManager; 

  /**
   * Constructor for objects of class ReleaseTask
   *
   * @param managerTask
   */
  public ReleaseTask(ResourceManager resourceManager) {
    this.resourceManager = resourceManager;
  }

  /**
   * The thread's run method
   */
  public void run() {

      try {
          // TODO:  release a resource
          sleep(2000);
          resourceManager.increaseCount();
      } catch (InterruptedException ex) {
          Logger.getLogger(ReleaseTask.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
