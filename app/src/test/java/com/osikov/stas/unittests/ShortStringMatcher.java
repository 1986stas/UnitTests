package com.osikov.stas.unittests;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ShortStringMatcher extends TypeSafeMatcher<String> {

    private int length;

    public ShortStringMatcher(int length) {
        this.length = length;
    }


    @Override
    public void describeTo(Description description) {
        description.appendText("Length of string must be shorter than " + length);
    }

    @Override
    protected boolean matchesSafely(String item) {
        return item.length() < length;
    }

    static Matcher<String> isShortString(int limit) {
        return new ShortStringMatcher(limit);
    }
    
}
