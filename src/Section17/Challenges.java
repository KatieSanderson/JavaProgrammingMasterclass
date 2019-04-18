package Section17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenges {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        String regex = "I want a \\w+.";

        String regex1 = "I want a (bike|ball).";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(challenge1);
        Matcher matcher2 = pattern.matcher(challenge2);

        String challenge4 = "replace all blanks with underscores.";
//        System.out.println(challenge4.replaceAll(" ","_"));
//        System.out.println(challenge4.replaceAll("\\s","_"));

        String challenge5 = "aaabcccccccccdddeffg";
        String regex5 = "a+b+c+d+e+f+g+";
        regex5 = "\\w+";
        regex5 = ".+";
        regex5 = "[a-g]+";
        regex5 = "[abcdefg]+";
//        System.out.println(challenge5.matches("aaabcccccccccdddeffg"));

        String challenge7 = "abcd.135";
        String regex7 = "\\w+\\.(\\d+)\\s";
//        System.out.println(challenge7.matches(regex7));

        String challenge8 = "abcd.135uvqz.7tzik.999";

        Pattern pattern8 = Pattern.compile(regex7);
        Matcher matcher8 = pattern8.matcher(challenge8);
        while (matcher8.find()) {
//            System.out.println(matcher8.group(1));
        }
//        System.out.println(matcher8.find());

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Matcher matcher8b = pattern8.matcher(challenge9);
        while (matcher8b.find()) {
//            System.out.println(matcher8b.start(1) + " " + (matcher8b.end(1) - 1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {21, 23}";
        String regex11 = "\\{(\\d+, \\d+)\\}";
        Pattern pattern11 = Pattern.compile(regex11);
        Matcher matcher11 = pattern11.matcher(challenge11);
        while (matcher11.find()) {
//            System.out.println(matcher11.group(1));
        }

        String challenge12 = "11111";
        String regex12 = "^\\d{5}$";
//        System.out.println(challenge12.matches(regex12));
//        Pattern pattern11 = Pattern.compile(regex12);
//        Matcher matcher11 = pattern11.matcher(challenge11);

        String challenge13 = "11111-1111";
        String regex13 = "^\\d{5}-\\d{4}$";
        System.out.println(challenge13.matches(regex13));


        String challenge14 = "11111-1111";
        String challenge15 = "11111";
        String regex14 = "^\\d{5}[-\\d{4}]*$";
        System.out.println(challenge14.matches(regex14));
        System.out.println(challenge15.matches(regex14));
    }
}
