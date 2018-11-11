

public abstract class Strategy
{
    protected boolean isSolutionFound;
    protected StrategyInformation information;

    protected boolean validateState(State state)
    {
        int i = 0;
        int width = state.getWidth();
        int size = state.getHeight()*width;
        int currentNumber;
        while(state.get((i/width),(i%width)) == i+1 && i<size) i++;
        return i == size && state.get((i/width),(i%width)) == 0;
    }

    public abstract void findSolution(State initialState);

    public StrategyInformation getInformation()
    {
        return information;
    }
}
