import java.util.ArrayList;

public abstract class Strategy
{
    protected boolean validateState(ArrayList<ArrayList<Integer>> state)
    {
        int i = 0;
        int width = state.get(0).size();
        int size = state.size()*width;
        int currentNumber;
        while(state.get(i/width).get(i%width) == i+1 && i<width);
        return i == size && state.get(i / width).get(i % width) == 0;
    }

    public abstract StrategyInformation findSolution(ArrayList<ArrayList<Integer>> initialState);

}
