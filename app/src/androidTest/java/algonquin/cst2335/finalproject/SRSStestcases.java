package algonquin.cst2335.finalproject;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class SRSStestcases {

    @Rule
    public ActivityScenarioRule<SRSSSunriseMainActivity> activityRule = new ActivityScenarioRule<>(SRSSSunriseMainActivity.class);

    @Test
    public void testSunriseSunsetButtonClickable() {
        Espresso.onView(ViewMatchers.withId(R.id.SunriseSunset)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.sunrise)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.sunset)).check(matches(isDisplayed()));
    }
}
