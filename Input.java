//package randex-redesign;
import java.io.*;
import java.util.Arrays;


/*V2 of input is designed to hide the contents of the file from other modules.
Ideally, this should prevent any other module from needing to see the contents 
variable, previously known as chars.
 */
public class Input{
    String fname;
    char[] contents;

    public Input(String fname){
        this.fname = fname;
    }

    public void reader()throws FileNotFoundException, IOException{
        FileReader tome = new FileReader(fname);
        int length = 2;
        int off = 0;
        contents = new char[length];
        while (true) { 
            int n = tome.read(contents, off, length - off);
            if (n<0) break;
            off += n;
            if (off == length){
                length *= 2;
                contents = Arrays.copyOf(contents, 2*length);
            }
        }
        tome.close();
        contents = Arrays.copyOf(contents, contents.length);
        }

        //so up til now, its been the exact same process as V1
        //Now we're going to integrate the find classes into
        //a single class so as to hide contents from other modules. 


    }
