import java.util.ArrayList;

public class DFSStrategy extends Strategy
{
    private String permutation;
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
        int[] coordinates = state.find(0);
        if(move == 'L')
        {
            if(!swap(newState, coordinates[0], coordinates[1], coordinates[0], coordinates[1]-1)) return;
        }
        else if(move == 'R')
        {
            if(!swap(newState, coordinates[0], coordinates[1], coordinates[0], coordinates[1]+1)) return;
        }
        else if(move == 'U')
        {
            if(!swap(newState, coordinates[0], coordinates[1], coordinates[0]-1, coordinates[1])) return;
        }
        else if(move == 'D')
        {
            if(!swap(newState, coordinates[0], coordinates[1], coordinates[0]+1, coordinates[1])) return;
        }

        information.setNumberOfProcessedStates(information.getNumberOfProcessedStates()+1);

        if(validateState(newState))
        {
            this.isSolutionFound = true;
            information.setSolutionLength(solution.length());
            information.setSolution(solution);
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
        information = new StrategyInformation();
        move(state, permutation.charAt(0), "");
        move(state, permutation.charAt(1), "");
        move(state, permutation.charAt(2), "");
        move(state, permutation.charAt(3), "");
        if(!isSolutionFound) information.setSolutionLength(-1);
        float elapsedTimeInMillis = (System.nanoTime() - startTime)/1000000f;
        information.setProcessTime(elapsedTimeInMillis);
    }
}
