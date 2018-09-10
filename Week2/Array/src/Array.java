public class Array
{
    int[] new_arr;
    int[] repeat_arr(int[] arr)
    {
        new_arr = new int[arr.length * 2];
        for (int i = 0; i < new_arr.length; i++)
        {
            new_arr[i] = arr[i / 2];
        }
        return new_arr;
    }

    public String toString()
    {
        String s = "";
        for(int i = 0; i < new_arr.length; i++)
        {
            s += Integer.toString(new_arr[i]);
            s += " ";
        }
        return s;
    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3, 8, 2};
        Array r = new Array();
        r.repeat_arr(arr);
        System.out.println(r);
    }
}