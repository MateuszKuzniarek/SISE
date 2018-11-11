import java.util.ArrayList;

public class BFSStrategy extends Strategy
{
    private String permutation;

    BFSStrategy(String permutation)
    {
        this.permutation = permutation;
    }

    private void move(State state, char move)
    {
        // TO DO
    }

    @Override
    public void findSolution(State initialState)
    {
        isSolutionFound = false;
        information = new StrategyInformation();
        move(initialState, permutation.charAt(0));
        move(initialState, permutation.charAt(1));
        move(initialState, permutation.charAt(2));
        move(initialState, permutation.charAt(3));
    }
}
