import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class playpen {
    public static void main(String[] args) {
        if("abcdefg".matches("c.e")){
            System.out.println("It's a match!");
        }
        else{
            //its not a match because .matches checks if the WHOLE string matches, not partial
            System.out.println("Not a match");
        }

        if("abcdefg".matches(".b.d.f.")){
            // It is a match because its the exact number of characters
            System.out.println("It's a match!");
        }
        else{
            System.out.println("Not a match");
        }

        //Split method

        //we have to use an Arrays. method because the .split method returns it as an array
        //Splitting on empty string "" will split every single character
        //If you split on ., it actually returns an empty array, EVERY character is removed
        System.out.println(Arrays.asList("Anne of the 1000 days".split("")));

        //replaceAll
        //First parameter is what to replace, 2nd is what to replace with
        System.out.println("one+one=2".replaceAll("one", "1"));

        //replaceFirst
        //Exactly what it sounds like, will only replace it the first time
        System.out.println("one+one=2".replaceFirst("one", "1"));

        //the replace() method ONLY takes literal chars, will not understand any Regex
        System.out.println("one+one=2".replace('o', '0'));

        //Use Pattern and Matcher java.utils to precompile and save space
        Pattern pattern  = Pattern.compile("/");
        Matcher matcher = pattern.matcher("3/13/2020");
        System.out.println(matcher.replaceAll("-"));

        //Pattern and Matcher have plenty of useful methods for helping us work with Regex

        //character classes
        // \d means digits, you have to double \ to make it work in Java
        System.out.println("Numbers 7 and 13".replaceAll("\\d", "digit"));

        //The uppercase means the inverse of the lowercase version, so it \d is a digit, \D is anything
        //but a digit

        // \s is a whitespace, \w is a word character

        // use [] to give multiple possiblities to a single character, with no separation
        // Use a ^ to do the opposite and say not these, kind of like ! in logic
        System.out.println("F".matches("[ABCDEFG]"));

        //You can use - to make a range as well
        System.out.println("F".matches("[a-gA-G]"));

        // The && operator works, and the | (single) works as an OR
        System.out.println("ade".matches("a(bc|de)"));

        // Quantifiers tell Regex how many
        // The default is exactly one, implicitly assumed
        // * means 0 or more occurences
        // + means 1 or more
        // ? is a boolean, meaning 0 or 1

        //Quanitifiers are "greedy" and match as many characters as possible

        //The ? is also a quantifier if after a special character. It makes it lazy

        // + as a quantifier is possessive, which is like greedy but with no "back off"

        //We can use {} to specify a range, so \d{3} means 3 digits in a row
        System.out.println("Hello 456".replaceAll("\\d{3}", "3 digits"));

        //We can limit the range by putting a second digit, \d{3, 5} means 3-5 digits
        System.out.println("Hello1234".replaceAll("\\d{3,5}", " digits"));

        //We can also specify a minimum with no maximum by not having anything after the comma
        System.out.println("Hello12345679012345".replaceAll("\\d{3,}", " many digits"));

        System.out.println(Arrays.asList("This,   is,   a ,good ,    quote".split("\\s*,\\s*")));

        //Capture groups
        // you can use () to group segments of strings
        // you can name your capture groups by doing ?<Name> like this
        // (?<spaces>\s+)(?<text>\w+)(?<digits>\d+)

        //We can put (?i) inside of a group like this ((?i)my-pattern)
        //You can undo it mid capture group too by like this: ((?i)my-(?-i)pattern)
        //In that case, "pattern" is not case sensitive

        System.out.println("Hot diggity dog hot diggity dog".replaceAll("((?i)Hot Diggity)", "replaced"));

        //We can backreference groups by either referencing their number or name with \k<name> or \<groupnumber>
        System.out.println("Equities-Development-Asia".replaceAll("(?<business>\\w+)(-(\\w+))+(?<region>\\w+)",
                "Region: ${region} Business: $1"));

        //We can use the boundary tag \b to indicate we want something at the start or end of a word like this
        // \bword or word\b

        System.out.println("This is a test, isn't it?".replaceAll("\\bis", "IS"));

        System.out.println("This is a test, isn't it?".replaceAll("is\\b", "IS"));

        //^ is an anchor that matches the beginning of a LINE
        //$ is an anchor that matches the end of a LINE

        //?< is look behind
        //?> is look ahead

        //You can also do look aheads in negatives with the ?!
    }
}
