public class DFSStrategy extends TreeSearchingStrategy
{
    private int maximalDepth = 20;

    DFSStrategy(String permutation)
    {
        this.permutation = permutation;
    }

    private void move(State state, char move, String solution)
    {
        solution += move;
        information.setNumberOfVisitedStates(information.getNumberOfVisitedStates()+1); //needs thinking through
        if(solution.length()>maximalDepth) return;
        if(information.getRecursionDepth()<solution.length()) information.setRecursionDepth(solution.length());
        if(isSolutionFound) return;
        State newState = new State(state);

        if(!decideWhereToMove(newState, move)) return;

        information.setNumberOfProcessedStates(information.getNumberOfProcessedStates()+1);

        if(validateState(newState))
        {
            markSolution(solution);
            return;
        }

        move(newState, permutation.charAt(0), solution);
        move(newState, permutation.charAt(1), solution);
        move(newState, permutation.charAt(2), solution);
        move(newState, permutation.charAt(3), solution);

    }

    @Override
    public void findSolution(State initialState)
    {
        long startTime = System.nanoTime();
        State state = new State(initialState);
        isSolutionFound = false;
        information = new StrategyInformation();
        information.setNumberOfVisitedStates(0);
        information.setNumberOfProcessedStates(0);
        move(state, permutation.charAt(0), "");
        move(state, permutation.charAt(1), "");
        move(state, permutation.charAt(2), "");
        move(state, permutation.charAt(3), "");
        if(!isSolutionFound) information.setSolutionLength(-1);
        float elapsedTimeInMillis = (System.nanoTime() - startTime)/1000000f;
        information.setProcessTime(elapsedTimeInMillis);
    }
}