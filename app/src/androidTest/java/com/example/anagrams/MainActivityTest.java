package com.example.anagrams;

import androidx.test.rule.ActivityTestRule;

import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule(MainActivity.class);


    @Test
    public void onCreate() {
    }

    @Test
    public void makeAnagram() {
        onView(withId(R.id.user_text_edit_text)).perform(typeText("Foxminded cool 24/7"));
        onView(withId(R.id.ignore_edit_text)).perform(typeText("0123456789"), closeSoftKeyboard());
        Spoon.screenshot(activityRule.getActivity(), "state_one");
        onView(withId(R.id.anagram_button)).perform(click());
        onView(withId(R.id.user_text_edit_text)).check(matches(withText("Foxminded cool 24/7")));
        onView(withId(R.id.ignore_edit_text)).check(matches(withText("0123456789")));
        onView(withId(R.id.anagram_text_view)).check(matches(withText("dednimxoF looc 24/7")));
        Spoon.screenshot(activityRule.getActivity(), "state_changed");
    }

    @Test
    public void makeAnagramIfUserTextEqualsEmptyString() {
        onView(withId(R.id.ignore_edit_text)).perform(typeText("0123456789"), closeSoftKeyboard());
        Spoon.screenshot(activityRule.getActivity(), "state_one");
        onView(withId(R.id.anagram_button)).perform(click());
        onView(withId(R.id.user_text_edit_text)).check(matches(withText("")));
        onView(withId(R.id.ignore_edit_text)).check(matches(withText("0123456789")));
        onView(withId(R.id.anagram_text_view)).check(matches(withText("")));
        Spoon.screenshot(activityRule.getActivity(), "state_changed");
    }

    @Test
    public void makeAnagramIfToIgnoreEqualsEmptyString() {
        onView(withId(R.id.user_text_edit_text)).perform(typeText("Foxminded cool 24/7"), closeSoftKeyboard());
        Spoon.screenshot(activityRule.getActivity(), "state_one");
        onView(withId(R.id.anagram_button)).perform(click());
        onView(withId(R.id.user_text_edit_text)).check(matches(withText("Foxminded cool 24/7")));
        onView(withId(R.id.ignore_edit_text)).check(matches(withText("")));
        onView(withId(R.id.anagram_text_view)).check(matches(withText("dednimxoF looc 7/42")));
        Spoon.screenshot(activityRule.getActivity(), "state_changed");
    }

    @Test
    public void makeAnagramIfAllFieldsEqualsEmptyString() {
        Spoon.screenshot(activityRule.getActivity(), "state_one");
        onView(withId(R.id.anagram_button)).perform(click());
        onView(withId(R.id.user_text_edit_text)).check(matches(withText("")));
        onView(withId(R.id.ignore_edit_text)).check(matches(withText("")));
        onView(withId(R.id.anagram_text_view)).check(matches(withText("")));
        Spoon.screenshot(activityRule.getActivity(), "state_changed");
    }
}