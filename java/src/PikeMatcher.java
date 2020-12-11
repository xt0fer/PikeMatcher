/*
PikeMatcher.java
 https://www.cs.princeton.edu/courses/archive/spr09/cos333/beautiful.html
    This java by kyounger. yet untested.
 */
pulic class PikeMatcher {
    /* match: search for regexp anywhere in text */
    public boolean match(String regexp, String text) {
        if (regexp.charAt(0) == '^')
            return matchhere(regexp.substring(1), text);
        do {    /* must look even if string is empty */
            if (matchhere(regexp, text))
                return true;
            text = text.substring(1);
        } while (!text.equals(""));
        return false;
}
    /* matchhere: search for regexp at beginning of text */
    public boolean matchhere(String regexp, String text) {
        if (regexp.equals(""))
            return true;
        if (regexp.charAt(1) == '*')
            return matchstar(regexp.charAt(0), regexp.substring(2), text);
        if (regexp.charAt(0) == '$' && regexp.length() == 1)
            return text.equals("");
        if (text != "" && (regexp.charAt(0) == '.' || regexp.charAt(0)==
         text.charAt(0)))
            return matchhere(regexp.substring(1), text.substring(1));
        return false;
    }
    /* matchstar: search for c*regexp at beginning of text */
    public boolean matchstar(String c, String regexp, String text) {
        int t = 0;
        do {
            if (matchhere(regexp, text) == true) {
                return true;
            }
            t++;
        } while (!text.equals("") &&
                (text.charAt(t).equals(c) || c == '.'));
        return false;
} 
}
