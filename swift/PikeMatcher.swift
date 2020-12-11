//
//  PikeMatcher.swift
//
//
//  Created by Kristofer Younger on 12/10/20.
//

import Foundation
/*
 https://www.cs.princeton.edu/courses/archive/spr09/cos333/beautiful.html

    This java by kyounger. yet untested.
 */

extension String {

    var length: Int {
        return count
    }

    subscript (i: Int) -> String {
        return self[i ..< i + 1]
    }

    func substring(fromIndex: Int) -> String {
        return self[min(fromIndex, length) ..< length]
    }

    func substring(toIndex: Int) -> String {
        return self[0 ..< max(0, toIndex)]
    }

    subscript (r: Range<Int>) -> String {
        let range = Range(uncheckedBounds: (lower: max(0, min(length, r.lowerBound)),
                                            upper: min(length, max(0, r.upperBound))))
        let start = index(startIndex, offsetBy: range.lowerBound)
        let end = index(start, offsetBy: range.upperBound - range.lowerBound)
        return String(self[start ..< end])
    }
}

class PikeMatcher {

    /* match: search for regexp anywhere in text */
    func match(regexp: String, text: String) -> Bool {
        if regexp[regexp.startIndex] == "^"{
            return self.matchhere(regexp: String(regexp.dropFirst()), text: text)
        }
        var ttext = text
        repeat {    /* must look even if string is empty */
            if (self.matchhere(regexp: regexp, text: ttext)) {
                return true;
            }
            ttext = String(ttext.dropFirst())
        } while (ttext != "");
        return false;
    }

    /* matchhere: search for regexp at beginning of text */
    func matchhere(regexp: String, text: String) -> Bool {
        //print("matchhere", regexp, text)
        if (regexp == "") {
            return true;
        }
        if (regexp.count > 1 && regexp[1] == "*") {
            return self.matchstar(c: Character(regexp[0]), regexp: regexp.substring(fromIndex: 2), text: text);
        }
        if (regexp[regexp.startIndex] == "$" && regexp.count == 1) {
            return text=="";
        }
        if (text != "" && (regexp[regexp.startIndex] == "." || regexp[regexp.startIndex] == text[text.startIndex])) {
            return self.matchhere(regexp: String(regexp.dropFirst()), text: String(text.dropFirst()));
        }
        return false;
    }

    /* matchstar: search for c*regexp at beginning of text */
    func matchstar(c: Character, regexp: String, text: String)  -> Bool {
        var t = 0;
        repeat {
            if (self.matchhere(regexp: regexp, text: text) == true) {
                return true;
            }
            t += 1
        } while ((t < text.count) && (Character(text[t]) == c || c == "."));
        return false;
    }
}
