public abstract class TreeSearchingStrategy extends Strategy
{
    protected String permutation;

    protected boolean decideWhereToMove(State state, char move)
    {
        int[] coordinates = state.find(0);
        if(move == 'L')
        {
            if(!swap(state, coordinates[0], coordinates[1], coordinates[0], coordinates[1]-1)) return false;
        }
        else if(move == 'R')
        {
            if(!swap(state, coordinates[0], coordinates[1], coordinates[0], coordinates[1]+1)) return false;
        }
        else if(move == 'U')
        {
            if(!swap(state, coordinates[0], coordinates[1], coordinates[0]-1, coordinates[1])) return false;
        }
        else if(move == 'D')
        {
            if(!swap(state, coordinates[0], coordinates[1], coordinates[0]+1, coordinates[1])) return false;
        }
        return true;
    }

}
