public class StrategyInformation
{
    private int solutionLength;
    private String solution;
    private int numberOfVisitedStates;
    private int numberOfProcessedStates;
    private int recursionDepth;
    private float processTime;

    public int getSolutionLength()
    {
        return solutionLength;
    }

    public void setSolutionLength(int solutionLength)
    {
        this.solutionLength = solutionLength;
    }

    public String getSolution()
    {
        return solution;
    }

    public void setSolution(String solution)
    {
        this.solution = solution;
    }

    public int getNumberOfVisitedStates()
    {
        return numberOfVisitedStates;
    }

    public void setNumberOfVisitedStates(int numberOfVisitedStates)
    {
        this.numberOfVisitedStates = numberOfVisitedStates;
    }

    public int getNumberOfProcessedStates()
    {
        return numberOfProcessedStates;
    }

    public void setNumberOfProcessedStates(int numberOfProcessedStates)
    {
        this.numberOfProcessedStates = numberOfProcessedStates;
    }

    public int getRecursionDepth()
    {
        return recursionDepth;
    }

    public void setRecursionDepth(int recursionDepth)
    {
        this.recursionDepth = recursionDepth;
    }

    public float getProcessTime()
    {
        return processTime;
    }

    public void setProcessTime(float processTime)
    {
        this.processTime = processTime;
    }
}
