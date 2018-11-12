public class MoveArgs
{
    private State state;
    private String solution;
    private char move;

    public MoveArgs(State state, char move, String solution)
    {
        this.state = state;
        this.solution = solution;
        this.move = move;
    }

    public State getState()
    {
        return state;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public String getSolution()
    {
        return solution;
    }

    public void setSolution(String solution)
    {
        this.solution = solution;
    }

    public char getMove()
    {
        return move;
    }

    public void setMove(char move)
    {
        this.move = move;
    }
}
