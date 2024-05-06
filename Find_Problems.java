import java.util.ArrayList;
public class FindProblems {
    //Problem Keywords
    public final static char[] beginProblem = "\\begin{problem}".toCharArray();
    public final static char[] endProblem = "\\end{problem}".toCharArray();
    
    char[] contents;//From Input
    int[] probStarts;
    int[] probStops;

    
    public FindProblems(char[] contents) {
	this.contents = contents;
    }

    /* Determines whether the sequence of characters in chars starting
       at offset off matches the chars of sought. Now its own Module.
       
    private static boolean match(char[] chars, int off, char[] sought) {
	for (int i=0; i<sought.length; i++) {
	    if (off+i >= chars.length || sought[i] != chars[off+i])
		return false;
	}
	return true;
    }
*/

    /* Constructs probStarts and probStops. */
    public void execute() {
	ArrayList<Integer> startList = new ArrayList<>(),
	    stopList = new ArrayList<>();
	int n = contents.length;
	boolean inProblem = false; // is i currently inside a problem?
	for (int i=0; i<n; i++) {
		match_problems_beg = new Match_Problems(contents, i, beginProblem);
		match_problems_end = new Match_Problems(contents, i, endProblem);
	    if (match_problems_beg.execute()) {
		if (inProblem)
		    throw new RuntimeException
			("Encountered \\begin{problem} when inside a problem");
		startList.add(i);
		inProblem = true;
	    } else if (match_problems_end.execute()){
		if (!inProblem)
		    throw new RuntimeException
			("Encountered \\end{problem} when outside any problem");
		inProblem = false;
		stopList.add(i + endProblem.length);
	    }
	}
	if (inProblem)
	    throw new RuntimeException
		("Missing \\endProblem for last problem");
	int nprob = startList.size();
	assert nprob == stopList.size();
	probStarts = new int[nprob];
	probStops = new int[nprob];
	for (int i=0; i<nprob; i++)
	    probStarts[i] = startList.get(i);
	for (int i=0; i<nprob; i++)
	    probStops[i] = stopList.get(i);
    }
}
