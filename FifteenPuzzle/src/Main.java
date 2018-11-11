public class Main
{
    public static void main(String[] args)
    {
        Strategy strategy;
        Fifteen fifteen = new Fifteen();

        if(args[0] == "bfs")
        {
            //TO DO
        }
        else if(args[0] == "dfs")
        {
            //TO DO
        }
        else if(args[0] == "astr")
        {
            //TO DO
        }
        else return;

        //fifteen.setStrategy(strategy);
        fifteen.solve(args[2], args[3], args[4]);
    }
}
