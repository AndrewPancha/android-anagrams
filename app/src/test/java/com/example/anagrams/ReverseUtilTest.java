package com.example.anagrams;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseUtilTest {

    @Test
    public void reverseText() {
        String input = "abcd efgh 123";
        String toIgnore = "0123456789";
        String output;
        String expected = "dcba hgfe 123";

        output = ReverseUtil.reverseText(input, toIgnore);

        assertEquals(" ", expected, output);
    }

    @Test
    public void reverseTextIfToIgnoreEqualsEmptyString() {
        String input = "abcd efgh";
        String toIgnore = "";
        String output;
        String expected = "dcba hgfe";

        output = ReverseUtil.reverseText(input, "");

        assertEquals(" ", expected, output);
    }

    @Test
    public void reverseTextIfInputEqualsEmptyString() {
        String input = "";
        String toIgnore = "0123456789";
        String output;
        String expected = "";

        output = ReverseUtil.reverseText("", "");

        assertEquals(" ", expected, output);
    }


}