public class HammingHeuristic extends Heuristic
{
    @Override
    public int calculate(State state)
    {
        int result = 0;
        int currentNumber = 1;
        int size = state.getHeight()*state.getWidth();
        for(int i=0; i<state.getHeight(); i++)
        {
            for(int j=0; j<state.getWidth() && currentNumber<size; j++)
            {
                if(state.get(i, j)!= currentNumber) result++;
                currentNumber++;
            }
        }
        return result;
    }
}
