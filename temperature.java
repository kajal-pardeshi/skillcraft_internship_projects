import java.util.*;
public class temperature 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("choose a conversion type from following");
        System.out.println("1.convert from celsius to fahrenheit");
        System.out.println("2.convert from celsius to kelvin");
        System.out.println("3.convert from kelvin to fahrenheit");
        System.out.println("4.convert from kelvin to celsius");
        System.out.println("5.convert from fahrenheit to celsius");
        System.out.println("6.convert from fahrenheit to kelvin");
        System.out.println("enter your choice from 1 to 6");
        int choice=sc.nextInt();
        System.out.println("enter the temperature");
        double temp=sc.nextDouble();
        sc.close();
        switch(choice)
        {
            case 1:
            double celsius_to_fahrenheit=(temp*9/5)+32;
            System.out.println("conversion from celsius to fahrenheit is:"+celsius_to_fahrenheit);
            break;

            case 2:
            double celsius_to_kelvin=temp+273.15;
            System.out.println("conversion from celsius to kelvin is:"+celsius_to_kelvin);
            break;

            case 3:
            double kelvin_to_fahrenheit=(temp-273.15)*9/5+32;
            System.out.println("conversion from kelvin to fahrenheit is:"+kelvin_to_fahrenheit);
            break;


            case 4:
            double kelvin_to_celsius=temp-273.15;
            System.out.println("conversion from kelvin to celsius is:"+kelvin_to_celsius);
            break;


            case 5:
            double fahrenheit_to_celsius=(temp-32)*5/9;
            System.out.println("conversion from fahrenheit to clesius is:"+fahrenheit_to_celsius);
            break;


            case 6:
            double fahrenheit_to_kelvin=(temp-32)*5/9+273.15;
            System.out.println("converison from fahrenheit to kelvin is:"+fahrenheit_to_kelvin);
            break;

            default:
            System.out.println("invalid input");
            break;
        }

    }
}
