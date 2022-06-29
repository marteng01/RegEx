import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasyRegExTest
{
    public static void main(String[] args)
    {
        String text = "Lorem ipsum 10.10.5.3 dolor sit amet, consetetur 192.168.1.26 sadipscing elitr, sed diam nonumy 2022-06-29 10:06:23.123 eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

        //nicht ganz korrekter RegEx für eine IP
        Pattern ipPattern = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
        Matcher matcherIP = ipPattern.matcher(text);

        //Format für einen Zeitstempel der Form YYYY-MM-DD HH:mm:ss.S
        Pattern timestampPattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}\s[0-9]{2}:[0-9]{2}:[0-9]{2}\\.[0-9]{1,3}");
        Matcher matcherTimestamp = timestampPattern.matcher(text);

        System.out.println("kleiner RegEx Tester");

        System.out.println("1. Test");
        while (matcherIP.find())
        {
            System.out.println("IP gefunden: " + matcherIP.group());
        }
        //leere Zeile
        System.out.println("");

        System.out.println("2. Test");
        while (matcherTimestamp.find())
        {
            System.out.println("Datum gefunden: " + matcherTimestamp.group());
        }
        //leere Zeile
        System.out.println("");


        System.out.println("Ende");
    }
}
