  public class Match_Answers(){
    char[] c; 
    int off;
 }
    public void Match_Answers(char[] c, int off){
        this.c = c;
        this.off = off;
    }
 
 private boolean execute(int off, char[] c, char[] contents) {
	int n = c.length;
	if (off+n > contents.length)
	    return false;
	for (int i=0; i<n; i++) {
	    if (c[i] != contents[off+i])
		return false;
	}
	return true;
    }
