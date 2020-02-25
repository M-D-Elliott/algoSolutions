package com.sg.hackerrank;

public class TimeInWords {

    private static final String O_CLOCK = " 'o clock";

    public static final String run(int hour, int minute) {
        String ret = "";

        if (minute == 0) {
            String hourAsString = intToEnglishWord(hour);
            if (hour != 0 && hour != 12) {
                ret = hourAsString + O_CLOCK;
            }

        } else if (minute > 30) {

            String hourAsString = "";

            if (hour == 12) {
                hourAsString = intToEnglishWord(1);
            } else {
                hourAsString = intToEnglishWord(hour + 1);
            }
            ret = minutesTo(60 - minute) + hourAsString;
        } else {
            String hourAsString = intToEnglishWord(hour);
            ret = minutesPast(minute) + hourAsString;
        }

        return ret;
    }

    private static final String intToEnglishWord(int n) {
        switch (n) {
            default:
            case 0:
                return "midnight";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "quarter";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eightteen";
            case 19:
                return "nineteen";
            case 20:
                return "twenty";
            case 21:
                return "twenty-one";
            case 22:
                return "twenty-two";
            case 23:
                return "twenty-three";
            case 24:
                return "twenty-four";
            case 25:
                return "twenty-five";
            case 26:
                return "twenty-six";
            case 27:
                return "twenty-seven";
            case 28:
                return "twenty-eight";
            case 29:
                return "twenty-nine";
            case 30:
                return "half";
        }
    }

    private static final String minutesTo(int minute) {
        String ret = "";

        ret = intToEnglishWord(minute);
        if (minute != 30 && minute != 15) {
            ret += " minute";
            if (minute != 1) {
                ret += "s";
            }
        }

        ret += " to ";

        return ret;
    }

    private static final String minutesPast(int minute) {
        String ret = "";

        ret = intToEnglishWord(minute);

        if (minute != 30 && minute != 15) {
            ret += " minute";
            if (minute != 1) {
                ret += "s";
            }
        }

        ret += " past ";

        return ret;
    }
}
