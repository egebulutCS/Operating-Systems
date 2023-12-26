
/**
 * GetTask
 *
 * @author Mohammed Alasmar
 * @version 2017
 */
public class GetTask implements Runnable {

  // reference to the shared resourceManager
  private ResourceManager resourceManager; 

  /**
   * Constructor for objects of class GetTask
   *
   * @param managerTask
   */
  public GetTask(ResourceManager resourceManager) {
    this.resourceManager = resourceManager;
  }

  /**
   * The thread's run method
   */
  public void run() {
    // do something expensive
    doStuff();

    // TODO: now, get a resource
    resourceManager.decreaseCount();
  }

  /**
   * Simulates some expensive operation
   */
  private void doStuff() {
    for (long i=0; i<10000000L; i++);
  }

}
