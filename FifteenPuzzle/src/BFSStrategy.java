import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

public class BFSStrategy extends TreeSearchingStrategy
{
    private String permutation;
    private LinkedList<MoveArgs> moveArgs = new LinkedList<>();

    BFSStrategy(String permutation)
    {
        this.permutation = permutation;
    }

    private void move(State state, char move, String solution)
    {
        solution += move;
        information.setNumberOfVisitedStates(information.getNumberOfVisitedStates()+1); //needs thinking through
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

        moveArgs.offer(new MoveArgs(newState, permutation.charAt(0), solution));
        moveArgs.offer(new MoveArgs(newState, permutation.charAt(1), solution));
        moveArgs.offer(new MoveArgs(newState, permutation.charAt(2), solution));
        moveArgs.offer(new MoveArgs(newState, permutation.charAt(3), solution));
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
        moveArgs.offer(new MoveArgs(state, permutation.charAt(0), ""));
        moveArgs.offer(new MoveArgs(state, permutation.charAt(1), ""));
        moveArgs.offer(new MoveArgs(state, permutation.charAt(2), ""));
        moveArgs.offer(new MoveArgs(state, permutation.charAt(3), ""));

        while(moveArgs.peek()!=null)
        {
            MoveArgs nextArgs = moveArgs.poll();
            move(nextArgs.getState(), nextArgs.getMove(), nextArgs.getSolution());
        }

        if(!isSolutionFound) information.setSolutionLength(-1);
        float elapsedTimeInMillis = (System.nanoTime() - startTime)/1000000f;
        information.setProcessTime(elapsedTimeInMillis);
    }
}
