import java.util.Random;

public class RandomizeProblemsAndAnswers {

    /* The number of problems (in) */
    int nprob;

    /* For each i in 0..numProblems - 1, the number of answers to problem i (in). */
    int[] numAnswers;

    /* The random number generator (in) */
    Random rand;

    /* Permutation of problem IDs (out) */
    int[] probPerm;

    /* A permutation for each problem (out) */
    int[][] answerPerms;

    /* Constructs new instance from given fields. Sets fields only, does nothing else. */
    public RandomizeProblemsAndAnswers(int nprob, int[] numAnswers, Random rand) {
        this.nprob = nprob;
        this.numAnswers = numAnswers;
        this.rand = rand;
    }

    /* Constructs the probPerm. */
    public void execute() {
        this.probPerm = new int[nprob];
        for (int i = 0; i < nprob; i++)
            probPerm[i] = i;
        for (int i = nprob - 1; i >= 0; i--) {
            int j = rand.nextInt(i + 1);
            if (i != j) {
                int t = probPerm[i];
                probPerm[i] = probPerm[j];
                probPerm[j] = t;
            }
        }
        
        
        // Construct random permutations for each problem
        answerPerms = new int[nprob][];
        for (int i = 0; i < nprob; i++) {
            answerPerms[i] = new int[numAnswers[i]];
            randomizeProblem(i);
        }
    }

    /* Constructs random permutation for problem pid, writing to answerPerms[pid][*]. */
    private void randomizeProblem(int pid) {
        int nanswer = numAnswers[pid];
        for (int i = 0; i < nanswer; i++)
            answerPerms[pid][i] = i;
        for (int i = nanswer - 1; i >= 0; i--) {
            int j = rand.nextInt(i + 1);
            if (i != j) {
                int t = answerPerms[pid][i];
                answerPerms[pid][i] = answerPerms[pid][j];
                answerPerms[pid][j] = t;
            }
        }
    }
}
