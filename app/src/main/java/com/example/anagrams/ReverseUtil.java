package com.example.anagrams;

public class ReverseUtil {

    public static String reverseText(String userText, String toIgnore) {
        String[] userTextArray = userText.split(" ");
        for (int i = 0; i < userTextArray.length; i++) {
            String word = userTextArray[i];
            userTextArray[i] = reverseWord(word, toIgnore);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < userTextArray.length - 1; i++) {
            result.append(userTextArray[i]).append(" ");
        }
        result.append(userTextArray[userTextArray.length - 1]);
        return result.toString();
    }

    private static String reverseWord(String word, String toIgnore) {
        char[] wordCharArray = word.toCharArray();

        int j = 0;
        int k = wordCharArray.length - 1;
        while (j < k) {
            if (toIgnore.indexOf(wordCharArray[j]) != -1) {
                j++;
            } else if (toIgnore.indexOf(wordCharArray[k]) != -1) {
                k--;
            } else {
                char temp = wordCharArray[j];
                wordCharArray[j] = wordCharArray[k];
                wordCharArray[k] = temp;
                j++;
                k--;
            }
        }

        return String.valueOf(wordCharArray);
    }
}
