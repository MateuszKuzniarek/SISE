import java.util.LinkedList;

public class AStarStrategy extends Strategy
{
    private LinkedList<MoveArgs> moveArgs = new LinkedList<>();
    private Heuristic heuristic;

    AStarStrategy(String heuristicName)
    {
        if(heuristicName.equals("hamm")) heuristic = new HammingHeuristic();
        else if(heuristicName.equals("manh")) heuristic = new ManhattanHeuristic();
    }

    private void addMoveToList(State state, int[] zeroCoordinates, String solution, char move)
    {
        MoveArgs args;
        solution += move;
        if(validateMove(state, move, zeroCoordinates))
        {
            State newState = new State(state);
            args = new MoveArgs(newState, move, solution);
            decideWhereToMove(newState, move, zeroCoordinates);
            args.setCost(solution.length()+heuristic.calculate(newState));
            if(moveArgs.size()==0) moveArgs.add(args);
            else
            {
                int i = 0;
                while(i<moveArgs.size() && moveArgs.get(i).getCost()<args.getCost()) i++;
                moveArgs.add(i, args);
            }
        }
    }

    private void move(State state, String solution)
    {
        if(!initiateMovement(solution)) return;

        information.setNumberOfProcessedStates(information.getNumberOfProcessedStates()+1);

        if(validateState(state))
        {
            markSolution(solution);
            return;
        }

        int[] zeroCoordinates = state.find(0);

        addMoveToList(state, zeroCoordinates, solution, 'R');
        addMoveToList(state, zeroCoordinates, solution, 'L');
        addMoveToList(state, zeroCoordinates, solution, 'U');
        addMoveToList(state, zeroCoordinates, solution, 'D');

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
        addMoveToList(state, zeroCoordinates, "", 'R');
        addMoveToList(state, zeroCoordinates, "", 'L');
        addMoveToList(state, zeroCoordinates, "", 'U');
        addMoveToList(state, zeroCoordinates, "", 'D');

        while(moveArgs.peek()!=null)
        {
            MoveArgs nextArgs = moveArgs.poll();
            move(nextArgs.getState(), nextArgs.getSolution());
        }

        if(!isSolutionFound) information.setSolutionLength(-1);
        float elapsedTimeInMillis = (System.nanoTime() - startTime)/1000000f;
        information.setNumberOfVisitedStates(information.getNumberOfVisitedStates()+moveArgs.size());
        information.setProcessTime(elapsedTimeInMillis);
    }
}
