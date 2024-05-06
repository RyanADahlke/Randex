 public class Match_Problems(){
    char[] contents; 
    int off;
    char[] sought[];
 }
    public void Match_Problems(char[] contents, int off, char[] sought[]){
        this.contents = contents;
        this.off = off;
        this.sought = sought;
    }

 public static boolean execute(char[] contents, int off, char[] sought) {
	for (int i=0; i<sought.length; i++) {
	    if (off+i >= contents.length || sought[i] != contents[off+i])
		return false;
	}
	return true;
    }
