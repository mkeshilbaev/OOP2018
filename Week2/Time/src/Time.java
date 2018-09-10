public class Time
{
    private int h,m,s;

    Time(int h,int m, int s)
    {
        if(h >= 0 && h <= 23 && m >= 0 && s >= 0) {
            this.h = h;
            this.m = m;
            this.s = s;
        }
        else
        {
            System.out.println("Invalid input");
        }
    }
    public String toUniversal()
    {
        String time = "";
        if(s >= 60)
        {
            m += s / 60;
            s %= 60;
        }
        if(m >= 60)
        {
            h += m / 60;
            m %= 60;
        }
        if(h < 10)
        {
            time += "0";
        }
        time += h;
        time += ":";
        if(m < 10)
        {
            time += "0";
        }
        time += m;
        time += ":";
        if(s < 10)
        {
            time += "0";
        }
        time+=s;
        time += '\n';
        return time;
    }
    public String toStandart()
    {
        String time = "";
        String ampm = "";
        if(s >= 60)
        {
            m += s / 60;
            s %= 60;
        }
        if(m >= 60)
        {
            h += m / 60;
            m %= 60;
        }
        h %= 12;
        if(h >= 1 && h <= 11)
        {
            ampm = "AM";
            if(h == 24)
            {
                h = 0;
            }
        }
        else
        {
            ampm = "PM";
        }
        if(h < 10)
        {
            time += "0";
        }
        time += h;
        time += ":";
        if(m < 10)
        {
            time += "0";
        }
        time += m;
        time += ":";
        if(s < 10)
        {
            time += "0";
        }
        time+=s;
        time = time +  " " + ampm + '\n';
        return time;
    }
    public void add(Time t)
    {
        h += t.h;
        m += t.m;
        s += t.s;
    }

    public static void main(String[] args)
    {
        Time t1 = new Time(10,2,2);
        Time t2 = new Time(3,1,5);
        t1.add(t2);
        System.out.println(t1.toUniversal());
        System.out.println(t1.toStandart());
    }
}
