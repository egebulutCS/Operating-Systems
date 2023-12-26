/**
 * Database
 * 
 * @author X Y
 * @version 2018
 */
public class Database
{
    /**
     * Prints a usage message
     */
    public static void usage() {
        System.err.println("Usage: java Database R WRITERS");
        System.err.println("  R is the number of readers.");
        System.err.println("  WRITERS consists of 3*W arguments");
        System.err.println("    where W is the number of writers.");
        System.err.println("    The three arguments for each writer are");
        System.err.println("    firstName lastName address");
    }

    /**
     * Main method
     * 
     * @param  args   the command line arguments
     */
  public static void main(String args[]) {
    // TODO: parse command line arguments
    int readerNo = Integer.parseInt(args[0]);
    String[] parameters = new String[args.length-1];
    for(int i = 0; i<args.length-1; i++){
        parameters[i] = args[i+1];
    }

    // the shared database record
    Record record = new Record();
    
    // TODO: create writers and readers threads
    Thread[] writersT = new Thread[parameters.length];
    Thread[] readersT = new Thread[readerNo];
    for(int i = 0; i<parameters.length; i++){
        String[] writer = parameters[i].split(" ");
        writersT[i] = new Thread(new WriterTask(i, record, writer[0], writer[1], writer[2]));
        if(i<readerNo){
            readersT[i] = new Thread(new ReaderTask(i, record));
        }
    }
    

    // TODO: start writers threads before readers threads
    for(int i = 0; i<writersT.length; i++){
        writersT[i].start();
        try{writersT[i].join();} catch (InterruptedException e) {}
        readersT[i].start();
        try{readersT[i].join();} catch (InterruptedException e) {}
    }
    
    // TODO: wait until all threads have finished
//    for(int i = 0; i<readersT.length; i++){
//        try{readersT[i].join();} catch (InterruptedException e) {}
//    }
  }
}
