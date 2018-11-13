import static java.lang.Math.abs;

public class ManhattanHeuristic extends Heuristic
{

    @Override
    public int calculate(State state)
    {
        int result = 0;
        int currentNumber = 1;
        for(int i=0; i<state.getHeight(); i++)
        {
            for(int j=0; j<state.getWidth(); j++)
            {
                if(state.get(i, j)!= currentNumber && state.get(i, j) != 0)
                {
                    result += abs(i - (state.get(i, j)-1)/state.getWidth());
                    result += abs(j - (state.get(i, j)-1)%state.getWidth());
                }
                currentNumber++;
            }
        }
        return result;
    }
}
