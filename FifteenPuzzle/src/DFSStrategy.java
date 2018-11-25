public class DFSStrategy extends Strategy
{
    private int maximalDepth = 20;
    private String permutation;

    DFSStrategy(String permutation)
    {
        this.permutation = permutation;
    }

    private void move(State state, char move, String solution)
    {
        solution += move;
        if(solution.length()>maximalDepth) return;
        if(!initiateMovement(solution)) return;
        State newState = new State(state);

        int[] zeroCoordinates = newState.find(0);
        decideWhereToMove(newState, move, zeroCoordinates);

        information.setNumberOfProcessedStates(information.getNumberOfProcessedStates()+1);

        if(validateState(newState))
        {
            markSolution(solution);
            return;
        }

        zeroCoordinates = newState.find(0);
        if(validateMove(newState, permutation.charAt(0), zeroCoordinates)) move(newState, permutation.charAt(0), solution);
        if(validateMove(newState, permutation.charAt(1), zeroCoordinates)) move(newState, permutation.charAt(1), solution);
        if(validateMove(newState, permutation.charAt(2), zeroCoordinates)) move(newState, permutation.charAt(2), solution);
        if(validateMove(newState, permutation.charAt(3), zeroCoordinates)) move(newState, permutation.charAt(3), solution);
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

        int[] zeroCoordinates = state.find(0);
        if(validateMove(state, permutation.charAt(0), zeroCoordinates)) move(state, permutation.charAt(0), "");
        if(validateMove(state, permutation.charAt(1), zeroCoordinates)) move(state, permutation.charAt(1), "");
        if(validateMove(state, permutation.charAt(2), zeroCoordinates)) move(state, permutation.charAt(2), "");
        if(validateMove(state, permutation.charAt(3), zeroCoordinates)) move(state, permutation.charAt(3), "");
        if(!isSolutionFound) information.setSolutionLength(-1);
        float elapsedTimeInMillis = (System.nanoTime() - startTime)/1000000f;
        information.setProcessTime(elapsedTimeInMillis);
    }
}
