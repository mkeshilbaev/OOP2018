import java.util.Scanner;

public class NumberInWords {
    private static String returnDigits(int number)
    {
        //int number = Integer.parseInt(str);
        String s = "";
        switch (number)
        {
            case 1: s = "one"; break;
            case 2: s = "two"; break;
            case 3: s = "three"; break;
            case 4: s = "four"; break;
            case 5: s = "five"; break;
            case 6: s = "six"; break;
            case 7: s = "seven"; break;
            case 8: s = "eight"; break;
            case 9: s = "nine"; break;
        }
        return s;
    }
    private static String returnTens(int number)
    {
        String s = "";
        //int number = Integer.parseInt(str);
        // number/=10;
        switch(number)
        {
            case 2: s = "twenty"; break;
            case 3: s = "thirty"; break;
            case 4: s = "fourty"; break;
            case 5: s = "fifty"; break;
            case 6: s = "sixty"; break;
            case 7: s = "seventy"; break;
            case 8: s = "eighty"; break;
            case 9: s = "ninety"; break;
            case 1: s = "ten"; break;
        }

        return s;
    }
    private static String returnTensFrom10To20(int number)
    {
        String s ="";
        switch (number)
        {
            case 1: s = "ten"; break;
            case 11: s = "eleven"; break;
            case 12: s = "twelve"; break;
            case 13: s = "thirteen"; break;
            case 14: s = "fourteen"; break;
            case 15: s = "fifteen"; break;
            case 16: s = "sixteen"; break;
            case 17: s = "seventeen"; break;
            case 18: s = "eighteen"; break;
            case 19: s = "nineteen"; break;
        }
        return s;
    }
    private static String inWords(int number)
    {
        boolean check = false;
        String s = "";
        int thousands, hundred, ten, units;
        thousands = number / 1000; // 3251 3
        hundred = (number % 1000) / 100; // 2
        ten = (number % 1000) % 100 / 10;
        units = number % 10;
        if (thousands != 0)
        {
            if(thousands >= 9)
            {
                int numberThousands = thousands;
                int hundredThousands, tenThousands, digitThousands;
                hundredThousands = numberThousands /100;
                tenThousands = numberThousands %100/10;
                digitThousands = numberThousands %10;
                s+="(";
                if(hundredThousands != 0)
                {
                    s += returnDigits(hundredThousands);
                    s += " hundred ";
                }
                if(tenThousands >= 2)
                {
                    s += returnTens(tenThousands);
                    s += " ";
                    s += returnDigits(digitThousands);
                }
                else if(tenThousands > 0)
                {
                    //tenThousands += digitThousands;
                    s += returnTensFrom10To20(tenThousands*10 + digitThousands);
                }

                else if(tenThousands == 0)
                {
                    s += returnDigits(digitThousands);
                }
                s += ") thousands ";

            }
            else {
                s += returnDigits(thousands);
                s += " thousands ";
            }
        }
        if(hundred != 0)
        {
            s += returnDigits(hundred);
            s += " hundred ";
            s += " [and] ";
            check = true;
        }

        if(ten >= 2)
        {
            s += returnTens(ten);
            s += " ";
            s += returnDigits(units);
        }
        else if(ten*10+units >= 11 && ten*10 + units <= 19)
        {
            s += returnTensFrom10To20(ten*10+units);
        }
        else if(ten > 0)
        {
            ten += units;
            s += returnTensFrom10To20(ten);
        }

        else if(ten == 0)
        {
            if(!check && ((hundred != 0) || thousands !=0))
                s += " [and] ";
            s += returnDigits(units);
        }
        return s;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(inWords(number));
    }
}
