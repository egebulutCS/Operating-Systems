
/**
 * ResourcesSemaphore
 *
 * @author Mohammed Alasmar
 * @version 2017
 */
public class ResourcesSemaphore {

    /**
     * Prints a usage message
     */
    public static void usage() {
        System.err.println("Usage: java ResourcesSemaphore " +
			   "maxResources numberOfResourcesToGet " +
			   "numberOfResourcesToRelease ");
        System.err.println(" numberOfResourcesToGet - " +
			   "numberOfResourcesToRelease > maxResources");
        System.err.println(" numberOfResourcesToRelease > " +
			   "numberOfResourcesToGet ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO: use the following variables
         int maxResources;
         int numberOfResourcesToGet;
         int numberOfResourcesToRelease;

        // TODO: parse command line arguments to assign values
        //       to the above variables
        maxResources = Integer.parseInt(args[0]);
        numberOfResourcesToGet = Integer.parseInt(args[1]);
        numberOfResourcesToRelease = Integer.parseInt(args[2]);
        
        // TODO: the shared object
        ResourceManager resourceManager = new ResourceManager(maxResources);

        // TODO: create ReleaseTask and GetTask threads
//        Thread get = new Thread(new GetTask(resourceManager));
//        Thread rls = new Thread(new ReleaseTask(resourceManager));

        Thread[] ts = new Thread[numberOfResourcesToGet+numberOfResourcesToRelease];

        for(int i = 0; i < numberOfResourcesToGet; i++){
            ts[i] = new Thread(new GetTask(resourceManager));
            ts[i].start();
        }
        
        for(int i = numberOfResourcesToGet; i < numberOfResourcesToGet+numberOfResourcesToRelease; i++){
            ts[i] = new Thread(new ReleaseTask(resourceManager));
            ts[i].start();
        }
        for(int i = 0; i < ts.length; i++){
            try{ts[i].join();} catch (InterruptedException e) {}
        }
        


        
        // TODO: wait until all threads have finished
//        get.start();
//        try{get.join();} catch (InterruptedException e) {}
//        rls.start();
//        try{rls.join();} catch (InterruptedException e) {}
        
        // TODO: print the number of still available and still used resources  
        System.out.println("Still available resources="+resourceManager.getAvailableResources());
        System.out.println("Still used resources="+(maxResources-resourceManager.getAvailableResources()));
        
    }

}
