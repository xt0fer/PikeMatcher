public class Guts {

    private char regex[] = null;
    private char text[] = null;

    public Guts() {

    }

    public static void main(String args) {

    }
    //    /* match: search for regexp anywhere in text */
//    int match(char *regexp, char *text)
//    {
//        if (regexp[0] == '^')
//            return matchhere(regexp+1, text);
//        do {    /* must look even if string is empty */
//            if (matchhere(regexp, text))
//                return 1;
//        } while (*text++ != '\0');
//        return 0;
//    }
    public boolean match(String regex, String text) {
        this.regex = regex.toCharArray();
        this.text = text.toCharArray();
        int r = 0;
        int t = 0;

        if (this.regex[r] == '^') {
            return (matchhere(r + 1, t) == 1);
        }
        do {
            if (matchhere(r, t) == 1) {
                return true;
            }
        } while (t++ != text.length());
        return false;
    }

    //    /* matchhere: search for regexp at beginning of text */
//    int matchhere(char *regexp, char *text)
//    {
//        if (regexp[0] == '\0') return 1;
//        if (regexp[1] == '*')
//            return matchstar(regexp[0], regexp+2, text);
//        if (regexp[0] == '$' && regexp[1] == '\0') return *text == '\0';
//        if (*text!='\0' && (regexp[0]=='.' || regexp[0]==*text)) return matchhere(regexp+1, text+1);
//        return 0;
//    }
    private int matchhere(int r, int t) {
        if (r == this.regex.length) return 1;
        if ((r + 1 < this.regex.length) && (this.regex[r + 1] == '*'))
            return matchstar(this.regex[0], r + 2, t);
        if (this.regex[r] == '$' && ((r + 1) == this.regex.length))
            return (t == text.length) ? 1 : 0;
        if ((t != this.text.length) && (this.regex[r] == '.' || this.regex[r] == this.text[t]))
            return matchhere(r + 1, t + 1);
        return 0;

    }

    //    /* matchstar: search for c*regexp at beginning of text */
//    int matchstar(int c, char *regexp, char *text)
//    {
//        do {    /* a * matches zero or more instances */
//            if (matchhere(regexp, text))
//                return 1;
//        } while (*text != '\0' && (*text++ == c || c == '.'));
//
//        return 0;
//    }
    private int matchstar(char c, int r, int t) {
        do {
            if (matchhere(r, t) == 1) {
                return 1;
            }
        } while ((t != this.text.length) && ((this.text[t++] == c) || (c == '.')));
        return 0;
    }
}
