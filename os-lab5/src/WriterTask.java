/**
 * WriterTask
 * 
 * @author X Y
 * @version 2018
 */
public class WriterTask implements Runnable
{
  private Record record; // reference to the shared record
  
  private int writerId;
  
  private String firstName;
  private String lastName;
  private String address;
  
  /**
   * Constructor for objects of class WriterTask
   * 
   */
  public WriterTask(int writerId, Record record,
		    String firstName, String lastName, String address) {
    this.writerId = writerId;
    this.record = record;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }
  

  /**
   * The thread's run method
   */
  public void run() {
    // acquire write lock
    // TODO
    record.acquireWriteLock();
      
    // print the data to be written
    System.out.println(
      "writer "+writerId+": "+firstName+" "+lastName+" "+address);
    
    // write the data to the record
    record.updateFirstName(firstName);
    record.updateLastName(lastName);
    record.updateAddress(address);

    // release write lock
    // TODO
    record.releaseWriteLock();

  }
}
