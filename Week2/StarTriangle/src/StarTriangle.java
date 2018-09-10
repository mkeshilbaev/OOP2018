public class StarTriangle
{
    private int width;
    StarTriangle(int width)
    {
        this.width = width;
    }

    public String toString() {
        String s = "";
        for(int i = 1; i <= this.width; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                s += "[*]";
            }
            if(i != width)
                s+='\n';
        }
        return s;
    }

    public static void main(String[] args)
    {
        StarTriangle small = new StarTriangle(5);
        System.out.println(small);
    }
}