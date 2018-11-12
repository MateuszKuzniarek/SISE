public class State
{
    private int[][] state;
    private int height;
    private int width;

    State(int height, int width)
    {
        this.height = height;
        this.width = width;
        state = new int[height][width];
    }

    State(State stateToCopy)
    {
        this.height = stateToCopy.getHeight();
        this.width = stateToCopy.getWidth();
        this.state = new int[height][];
        for(int i=0; i<height; i++)
        {
            state[i] = stateToCopy.getState()[i].clone();
        }
    }

    public int get(int x, int y)
    {
        return state[x][y];
    }

    public void set(int x, int y, int value)
    {
        state[x][y] = value;
    }

    public int[] find(int value)
    {
        int[] coordinates = new int[2];
        int size = width*height;
        int i = 0;
        while(state[i/width][i%width] !=value && i<size) i++;
        if(i!=size)
        {
            coordinates[0] = i/width;
            coordinates[1] = i%width;
            return coordinates;
        }
        else return null;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public int[][] getState()
    {
        return state;
    }
}
