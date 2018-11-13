public class Main
{
    public static void main(String[] args)
    {
        Strategy strategy;
        Fifteen fifteen = new Fifteen();

        if(args[0].equals("bfs"))
        {
            strategy = new BFSStrategy(args[1]);
        }
        else if(args[0].equals("dfs"))
        {
            strategy = new DFSStrategy(args[1]);
        }
        else if(args[0].equals("astr"))
        {
            strategy = new AStarStrategy(args[1]);
        }
        else return;
        fifteen.setStrategy(strategy);
        fifteen.solve(args[2], args[3], args[4]);
    }
}
