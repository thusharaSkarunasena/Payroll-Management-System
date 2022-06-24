/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.main;

/**
 *
 * @author Thushara Supun
 */
public class ed {

    public static String encrypt(String text) {
        String strData = "";
        try {

            for (int i = 0; i < text.length(); i++) {
                char ch = Character.toLowerCase(text.charAt(i));
                switch (ch) {
                    case 'a':
                        strData = strData + "{";
                        break;
                    case 'b':
                        strData = strData + "}";
                        break;
                    case 'c':
                        strData = strData + "#";
                        break;
                    case 'd':
                        strData = strData + "~";
                        break;
                    case 'e':
                        strData = strData + "+";
                        break;
                    case 'f':
                        strData = strData + "-";
                        break;
                    case 'g':
                        strData = strData + "*";
                        break;
                    case 'h':
                        strData = strData + "@";
                        break;
                    case 'i':
                        strData = strData + "/";
                        break;
                    case 'j':
                        strData = strData + "\\";
                        break;
                    case 'k':
                        strData = strData + "?";
                        break;
                    case 'l':
                        strData = strData + "$";
                        break;
                    case 'm':
                        strData = strData + "!";
                        break;
                    case 'n':
                        strData = strData + "^";
                        break;
                    case 'o':
                        strData = strData + "(";
                        break;
                    case 'p':
                        strData = strData + ")";
                        break;
                    case 'q':
                        strData = strData + "<";
                        break;
                    case 'r':
                        strData = strData + ">";
                        break;
                    case 's':
                        strData = strData + "=";
                        break;
                    case 't':
                        strData = strData + ";";
                        break;
                    case 'u':
                        strData = strData + ",";
                        break;
                    case 'v':
                        strData = strData + "_";
                        break;
                    case 'w':
                        strData = strData + "[";
                        break;
                    case 'x':
                        strData = strData + "]";
                        break;
                    case 'y':
                        strData = strData + ":";
                        break;
                    case 'z':
                        strData = strData + "\"";
                        break;
                    case ' ':
                        strData = strData + " ";
                        break;
                    case '.':
                        strData = strData + '3';
                        break;
                    case ',':
                        strData = strData + "1";
                        break;
                    case '(':
                        strData = strData + '4';
                        break;
                    case '\"':
                        strData = strData + '5';
                        break;
                    case ')':
                        strData = strData + "7";
                        break;
                    case '?':
                        strData = strData + "2";
                        break;
                    case '!':
                        strData = strData + "8";
                        break;
                    case '-':
                        strData = strData + "6";
                        break;
                    case '%':
                        strData = strData + "9";
                        break;
                    case '1':
                        strData = strData + "r";
                        break;
                    case '2':
                        strData = strData + "k";
                        break;
                    case '3':
                        strData = strData + "b";
                        break;
                    case '4':
                        strData = strData + "e";
                        break;
                    case '5':
                        strData = strData + "q";
                        break;
                    case '6':
                        strData = strData + "h";
                        break;
                    case '7':
                        strData = strData + "u";
                        break;
                    case '8':
                        strData = strData + "y";
                        break;
                    case '9':
                        strData = strData + "w";
                        break;
                    case '0':
                        strData = strData + "z";
                        break;
                    default:
                        strData = strData + "0";
                        break;
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

        return strData;

    }

    public static String decrypt(String text) {
        String strData = "";
        try {

            for (int i = 0; i < text.length(); i++) {
                char ch = Character.toLowerCase(text.charAt(i));
                switch (ch) {
                    case '{':
                        strData = strData + "A";
                        break;
                    case '}':
                        strData = strData + "B";
                        break;
                    case '#':
                        strData = strData + "C";
                        break;
                    case '~':
                        strData = strData + "D";
                        break;
                    case '+':
                        strData = strData + "E";
                        break;
                    case '-':
                        strData = strData + "F";
                        break;
                    case '*':
                        strData = strData + "G";
                        break;
                    case '@':
                        strData = strData + "H";
                        break;
                    case '/':
                        strData = strData + "I";
                        break;
                    case '\\':
                        strData = strData + "J";
                        break;
                    case '?':
                        strData = strData + "K";
                        break;
                    case '$':
                        strData = strData + "L";
                        break;
                    case '!':
                        strData = strData + "M";
                        break;
                    case '^':
                        strData = strData + "N";
                        break;
                    case '(':
                        strData = strData + "O";
                        break;
                    case ')':
                        strData = strData + "P";
                        break;
                    case '<':
                        strData = strData + "Q";
                        break;
                    case '>':
                        strData = strData + "R";
                        break;
                    case '=':
                        strData = strData + "S";
                        break;
                    case ';':
                        strData = strData + "T";
                        break;
                    case ',':
                        strData = strData + "U";
                        break;
                    case '_':
                        strData = strData + "V";
                        break;
                    case '[':
                        strData = strData + "W";
                        break;
                    case ']':
                        strData = strData + "X";
                        break;
                    case ':':
                        strData = strData + "Y";
                        break;
                    case '\"':
                        strData = strData + "Z";
                        break;
                    case '1':
                        strData = strData + "r";
                        break;
                    case '2':
                        strData = strData + "k";
                        break;
                    case '3':
                        strData = strData + "b";
                        break;
                    case '4':
                        strData = strData + "e";
                        break;
                    case '5':
                        strData = strData + "q";
                        break;
                    case '6':
                        strData = strData + "h";
                        break;
                    case '7':
                        strData = strData + "u";
                        break;
                    case '8':
                        strData = strData + "y";
                        break;
                    case '9':
                        strData = strData + "w";
                        break;
                    case '0':
                        strData = strData + "z";
                        break;
                    default:
                        strData = strData + "0";
                        break;
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

        return strData;
    }
}
