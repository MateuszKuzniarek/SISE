

public abstract class Strategy
{
    protected boolean isSolutionFound;
    protected StrategyInformation information;

    protected boolean swap(State state, int x1, int y1, int x2, int y2)
    {
        if(x2<0 || y2<0 || x1<0 || y1<0) return false;
        if(x1>=state.getHeight() || x2>=state.getHeight()) return false;
        if(y1>=state.getWidth() || y2>=state.getWidth()) return false;
        int temp = state.get(x2, y2);
        state.set(x2, y2, state.get(x1, y1));
        state.set(x1, y1, temp);
        return true;
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

    public abstract void findSolution(State initialState);

    public StrategyInformation getInformation()
    {
        return information;
    }
}
