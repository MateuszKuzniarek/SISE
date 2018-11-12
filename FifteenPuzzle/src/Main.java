public class Main
{
    public static void main(String[] args)
    {
        Strategy strategy = new DFSStrategy(args[1]); //initialization just to stop Intellij screaming
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
            //TO DO
        }
        else return;
        fifteen.setStrategy(strategy);
        fifteen.solve(args[2], args[3], args[4]);
    }
}
