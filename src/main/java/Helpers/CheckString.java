package Helpers;

public class CheckString {
    public static boolean check(String strToCheck, String wordToFind) {

        String[] listOfWords = strToCheck.split(" ");
        for (String word : listOfWords) {
            if (word.contains("tel:+373")) {
                return true;
            }
        }

        return false;
    }
}
