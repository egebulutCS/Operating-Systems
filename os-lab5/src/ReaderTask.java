/**
 * ReaderTask
 * 
 * @author X Y
 * @version 2018
 */
public class ReaderTask implements Runnable
{
  private Record record; // reference to the shared record
  
  private int readerId;
  
  /**
   * Constructor for objects of class ReaderTask
   * 
   */
  public ReaderTask(int readerId, Record record) {
    this.readerId = readerId;
    this.record = record;
  }

  /**
   * The thread's run method
   */
  public void run() {
    // acquire read lock
    // TODO
    record.acquireReadLock();

    // read the data from the record
    String firstName = record.readFirstName();
    String lastName = record.readLastName();
    String address = record.readAddress();

    // release read lock
    // TODO
    record.releaseReadLock();

    // print the data
    print(firstName, lastName, address);
  }
  
  /**
   * Prints the data read from the record
   */
  private void print(String firstName, String lastName, String address) {
    System.out.println(
      "reader "+readerId+": "+firstName+" "+lastName+" "+address);
  }

}
