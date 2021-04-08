package main.java.rocks.zipcode;/*
PikeMatcher.java

 https://www.cs.princeton.edu/courses/archive/spr09/cos333/beautiful.html

    This java by kyounger. yet untested.
 */

public class PikeMatcher {


    public PikeMatcher(){}

    /* match: search for regexp anywhere in text */
    public boolean match(String regexp, String text) {
        if (regexp.charAt(0) == '^')
            return matchhere(regexp.substring(1), text);
        do {    /* must look even if string is empty */
            if (matchhere(regexp, text))
                //This means we found at least one instance of the regex in the text
                return true;
            //this means we did NOT find the occurance at the beginning of the text,
            //so we substring it out and search at the next
            text = text.substring(1);
            //We do this until there is no more text, which lets us exit the do while
        } while (!text.equals(""));
        return false;
    }

    /* matchhere: search for regexp at beginning of text */
    public boolean matchhere(String regexp, String text) {
        if (regexp.equals(""))
            //No regex left means a complete match has been found, return true.
            return true;
        if (regexp.length() > 1 && regexp.charAt(1) == '*')
            //implements stars. Stars MUST be the second character for a regex.
            return matchstar(regexp.charAt(0), regexp.substring(2), text);
        if (regexp.charAt(0) == '$' && regexp.length() == 1)
            //Checks for dollarsign regex being the last character
            return text.equals("");
        if (!text.equals("") && (regexp.charAt(0) == '.' || regexp.charAt(0)== text.charAt(0)))
            //if the text isn't done, and if the character were looking at matches
            // . or the first regex charatcer, then continue with the next parts
            // of the reg and string to confirm complete match
            return matchhere(regexp.substring(1), text.substring(1));
        return false;
    }

    /* matchstar: search for c*regexp at beginning of text */
    public boolean matchstar(char c, String regexp, String text) {

        do {
            if (matchhere(regexp, text) == true) {
                return true;
            }
            text=text.substring(1);
            //I don't think the exit condition is correct,
            // should lead to prematurely leaving the loop before searching the whole text for a match
        } while (!text.equals("") &&
                (text.charAt(0) == c || c == '.'));
        return false;
    }
}
