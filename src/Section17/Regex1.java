package Section17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {

    public static void main(String[] args) {
        String alphanumeric = "abcDeeeF2Fgiiikd9jj482";
        String secondString = "abcDeee12abcDeeeFgiiikd9482";

        String newAlphumeric = "abcDeeeF2Fgiiikd9jjj482";
        System.out.println(newAlphumeric.replaceAll("[^ej]","X"));

        String whiteSpace = "I have blanks and \t also a new line\n";
        System.out.println(whiteSpace);
        System.out.println(whiteSpace.replaceAll("\\W",""));
        System.out.println(whiteSpace.replaceAll("\\b","x"));

        String thirdAlphaNum = "abcDeeeF2Fghhiijiiikd9jj482";
        System.out.println(thirdAlphaNum.replaceAll("^abcDe+","YYY"));
        System.out.println(thirdAlphaNum.replaceAll("^abcDe*","YYY"));
        System.out.println(thirdAlphaNum.replaceAll("^abcDe{2,5}","YYY"));
        System.out.println(thirdAlphaNum.replaceAll("h+i*j","YYY"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>subheading</h2>");
        htmlText.append("<h2>subheading</h2>");

        String h2Pattern = "(<h2>)";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        int count = 0;
        matcher.reset();
        while (matcher.find()) {
            count++;
            System.out.println("Occurence " + count + ": " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.*?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        String tvTest = "tstvtkt";
        String tNotVRegExp ="t(?!v)";

        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotmatcher = tNotVPattern.matcher(tvTest);
        count = 0;
        while (tNotmatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + ": " + tNotmatcher.start() + " to " + tNotmatcher.end());
        }
    }
}
