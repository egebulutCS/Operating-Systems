
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Record
 * 
 * @author X Y
 * @version 2018
 */
public class Record
{
  private int readerCount; // Counts the current number of readers
  private boolean writing; // Indicates whether the record is being written

  // the data
  private String firstName;
  private String lastName;
  private String address;
  
  /**
   * Constructor for objects of class Record
   * 
   */
  public Record() {
    firstName = "empty";
    lastName = "empty";
    address = "empty";
  }

  /**
   * Reads the first name
   */
  public String readFirstName() {
    doStuff();
    return firstName;
  }

  /**
   * Updates the first name
   */
  public void updateFirstName(String firstName) {
    doStuff();
    this.firstName = firstName;
  }

  /**
   * Reads the last name
   */
  public String readLastName() {
    doStuff();
    return lastName;
  }

  /**
   * Updates the last name
   */
  public void updateLastName(String lastName) {
    doStuff();
    this.lastName = lastName;
  }

  /**
   * Reads the address
   */
  public String readAddress() {
    doStuff();
    return address;
  }

  /**
   * Updates the address
   */
  public void updateAddress(String address) {
    doStuff();
    this.address = address;
  }
  
  /**
   * Waits until the database is not written anymore,
   * then acquires a read lock.
   * Multiple simultaneous readers are allowed.
   */
  public synchronized void acquireReadLock() {
    // TODO
    while(writing){
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    readerCount++;
      
  }

  /**
   * Releases a read lock.
   * If there are no more readers we notify
   * a potential waiting thread.
   */
  public synchronized void releaseReadLock() {
    // TODO
    readerCount--;
    if(readerCount == 0){
        notify();
    }
      
  }
  
  /**
   * Waits until the database is not read anymore,
   * then acquires the write lock.
   * Only a single simultaneous writer is allowed.
   */
  public synchronized void acquireWriteLock() {
    // TODO
    while((readerCount>0) || (writing)){
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    writing = true;
      
  }

  /**
   * Releases the write lock and notifies
   * all waiting threads.
   */
  public synchronized void releaseWriteLock() {
    // TODO
    writing = false;
    notify();
      
  }

  /**
   * Simulates some expensive operation
   */
  private void doStuff() {
    for (long i=0; i<100000000L; i++);
  }

}
