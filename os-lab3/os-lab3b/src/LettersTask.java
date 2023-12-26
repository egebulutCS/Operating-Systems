/**
 * LettersTask
 * 
 * @author <your student ID>
 * @version 2018
 */
public class LettersTask implements Runnable
{
    char[] word;
    char[] alphabet;
    boolean[] isPresent;
    /**
     * Constructor for objects of class LettersTask
     * 
     */
    public LettersTask(char[] word, char[] alphabet, boolean[] isPresent) {
        this.word = word;
        this.alphabet = alphabet;
        this.isPresent = isPresent;
    }

    /**
     * The thread's run method
     */
    public void run() {
        for(int i = 0; i <= word.length; i++){
            for(int j = 0; j < alphabet.length; j++){
                if(word[i] == alphabet[j]){
                    isPresent[j] = true;
                }
            }
        }
    }
}
