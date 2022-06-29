import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTester
{
    private final String meinText = "Das ist mein toller Text den ich durchsuchen werde." + System.lineSeparator() +
                                    "20220621191600 ein Ereignis 192.168.1.55 ist eingetreten." + System.lineSeparator() +
                                    "20220621191630 ein Ereignis 10.65.56.55 ist eingetreten." + System.lineSeparator() +
                                    "20220621191800 ein weiteres Ereignis ist eingetreten" + System.lineSeparator();

    enum PATTERNS
    {
        SEARCH_IP("Suche IP", "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}"),
        SEARCH_DATETIME("Suche Zeitstempel", "[0-9]{14}"),
        SEARCH_DATETIME_FULLLINE("Suche Zeile mit Zeitstempel", "[0-9]{14}.*(\\r|\\n|$)");

        private final String pattern;
        private final String headline;

        PATTERNS(String headline, String pattern)
        {
            this.headline = headline;
            this.pattern = pattern;
        }
    }

    public RegExTester()
    {
        System.out.println("############# Mein Text ##########");
        System.out.println(meinText);
        System.out.println();
    }


    private void searchPattern(PATTERNS pattern)
    {
        System.out.println("############# " + pattern.headline + " ##########");
        Matcher matcher = Pattern.compile(pattern.pattern).matcher(meinText);
        int i = 1;
        while (matcher.find())
        {
            System.out.println("Treffer " + i++ + ": " + matcher.group());
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        RegExTester regExTester = new RegExTester();

        for (PATTERNS pattern : PATTERNS.values())
        {
            regExTester.searchPattern(pattern);
        }
    }

}
