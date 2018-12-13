import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Fifteen
{
    private State initialState;
    private Strategy strategy;

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void loadFromFile(String path)
    {
        File file = new File(path);
        try
        {
            Scanner scanner = new Scanner(file);
            int height, width;
            height = Integer.valueOf(scanner.next());
            width = Integer.valueOf(scanner.next());
            initialState = new State(height, width);
            for(int i=0; i<height; i++)
            {
                for(int j=0; j<width; j++)
                {
                    initialState.set(i, j, Integer.valueOf(scanner.next()));
                }
            }
            scanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void writeToFile(String path, String content)
    {
        Path filePath = Paths.get(path);
        FileWriter writer;
        try
        {
            writer = new FileWriter(filePath.toFile(),false);
            writer.write(content);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void writeResultToFile(String path, StrategyInformation information)
    {
        String content = "";
        content += information.getSolutionLength();
        if(information.getSolutionLength() != -1) content += "\n" + information.getSolution();
        writeToFile(path, content);
    }

    private void writeAdditionalInformationToFile(String path, StrategyInformation information)
    {
        NumberFormat formatter = new DecimalFormat("#0.000");
        String content = "";
        content += information.getSolutionLength() + "\n";
        content += information.getNumberOfVisitedStates() + "\n";
        content += information.getNumberOfProcessedStates() + "\n";
        content += information.getRecursionDepth() + "\n";
        content += formatter.format(information.getProcessTime());
        writeToFile(path, content);
    }

    private void findSolution()
    {
        strategy.findSolution(initialState);
    }

    public void solve(String inputPath, String resultPath, String additionalInformationPath)
    {
        loadFromFile(inputPath);
        findSolution();
        writeResultToFile(resultPath, strategy.getInformation());
        writeAdditionalInformationToFile(additionalInformationPath, strategy.getInformation());
    }
}
