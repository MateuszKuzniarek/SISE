import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Fifteen
{
    private ArrayList<ArrayList<Integer>> initialState;
    private Strategy strategy;

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void loadFromFile(String path)
    {
        initialState = new ArrayList<>();
        File file = new File(path);
        try
        {
            Scanner scanner = new Scanner(file);
            int height, width;
            height = Integer.valueOf(scanner.next());
            width = Integer.valueOf(scanner.next());
            for(int i=0; i<height; i++)
            {
                ArrayList<Integer> row = new ArrayList<>();
                for(int j=0; j<width; j++)
                {
                    row.add(Integer.valueOf(scanner.next()));
                }
                initialState.add(row);
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
        File file = filePath.getParent().toFile();
        file.mkdirs();
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
        if(information.getSolutionLength() == -1) content += "\n" + information.getSolution();
        writeToFile(path, content);
    }

    private void writeAdditionalInformationToFile(String path, StrategyInformation information)
    {
        String content = "";
        content += information.getSolutionLength() + "\n";
        content += information.getNumberOfVisitedStates() + "\n";
        content += information.getNumberOfProcessedStates() + "\n";
        content += information.getRecursionDepth() + "\n";
        content += information.getProcessTime();
        writeToFile(path, content);
    }

    private StrategyInformation findSolution()
    {
        return strategy.findSolution(initialState);
    }

    public void solve(String inputPath, String resultPath, String additionalInformationPath)
    {
        loadFromFile(inputPath);
        StrategyInformation information = findSolution();
        writeResultToFile(resultPath, information);
        writeAdditionalInformationToFile(additionalInformationPath, information);
    }
}
