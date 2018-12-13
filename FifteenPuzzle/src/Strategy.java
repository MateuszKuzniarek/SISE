

public abstract class Strategy
{
    protected boolean isSolutionFound;
    protected StrategyInformation information;

    protected boolean validateCoordinates(State state, int x, int y)
    {
        if(x<0 || y<0) return false;
        if(x>=state.getHeight() || y>=state.getWidth()) return false;
        return true;
    }

    protected void swap(State state, int x1, int y1, int x2, int y2)
    {
        int temp = state.get(x2, y2);
        state.set(x2, y2, state.get(x1, y1));
        state.set(x1, y1, temp);
    }

    protected boolean validateState(State state)
    {
        int i = 0;
        int width = state.getWidth();
        int size = state.getHeight()*width;
        while(state.get((i/width),(i%width)) == i+1 && i<size) i++;
        return i == size-1 && state.get((i/width),(i%width)) == 0;
    }

    protected void markSolution(String solution)
    {
        this.isSolutionFound = true;
        information.setSolutionLength(solution.length());
        information.setSolution(solution);
    }

    protected boolean initiateMovement(String solution)
    {
        information.setNumberOfVisitedStates(information.getNumberOfVisitedStates()+1); //needs thinking through
        if(isSolutionFound) return false;
        if(information.getRecursionDepth()<solution.length()) information.setRecursionDepth(solution.length());
        return true;
    }

    protected boolean validateMove(State state, char move, int[] zeroCoordinates)
    {
        if(move == 'L')
        {
            if(!validateCoordinates(state, zeroCoordinates[0], zeroCoordinates[1]-1)) return false;
        }
        else if(move == 'R')
        {
            if(!validateCoordinates(state, zeroCoordinates[0], zeroCoordinates[1]+1)) return false;
        }
        else if(move == 'U')
        {
            if(!validateCoordinates(state, zeroCoordinates[0]-1, zeroCoordinates[1])) return false;
        }
        else if(move == 'D')
        {
            if(!validateCoordinates(state, zeroCoordinates[0]+1, zeroCoordinates[1])) return false;
        }
        return true;
    }

    protected void decideWhereToMove(State state, char move, int[] zeroCoorfinates)
    {
        if(move == 'L')
        {
            swap(state, zeroCoorfinates[0], zeroCoorfinates[1], zeroCoorfinates[0], zeroCoorfinates[1]-1);
        }
        else if(move == 'R')
        {
            swap(state, zeroCoorfinates[0], zeroCoorfinates[1], zeroCoorfinates[0], zeroCoorfinates[1]+1);
        }
        else if(move == 'U')
        {
            swap(state, zeroCoorfinates[0], zeroCoorfinates[1], zeroCoorfinates[0]-1, zeroCoorfinates[1]);
        }
        else if(move == 'D')
        {
            swap(state, zeroCoorfinates[0], zeroCoorfinates[1], zeroCoorfinates[0]+1, zeroCoorfinates[1]);
        }
    }

    public abstract void findSolution(State initialState);

    public StrategyInformation getInformation()
    {
        return information;
    }
}
