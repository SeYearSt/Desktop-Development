import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    static String zipRuleUsa ="\\b\\d{5}-?\\d{4}\\b";
    static String zipRuleRoland = "\\b\\d{2,2}-\\d{3,3}\\b";
    static Pattern patternUsa = Pattern.compile(Main.zipRuleUsa);
    static Pattern patternPol = Pattern.compile(Main.zipRuleRoland);

    public static void main(String[] args){
        System.out.print("Enter a string : ");
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner. nextLine();
//        Debug line
//        String inputString = "12345-6789 12-111";
        System.out.println("USA ZIP code");
        findAndOutput(inputString, Main.patternUsa);
        System.out.println("Poland ZIP code");
        findAndOutput(inputString, Main.patternPol);
    }

    static void findAndOutput(String text, Pattern pattern){
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}
