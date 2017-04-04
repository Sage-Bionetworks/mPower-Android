package org.sagebase.mpower;

import org.researchstack.backbone.task.Task;
import org.researchstack.backbone.ui.ViewTaskActivity;
import org.sagebase.mpower.task.DynamicMoodSurveyFactory;

/**
 * Created by rianhouston on 3/29/17.
 */

public class ActivitiesFragment extends org.researchstack.skin.ui.fragment.ActivitiesFragment {
  private static final String LOG_TAG = ActivitiesFragment.class.getCanonicalName();

  @Override
  protected void startCustomMoodSurveyTask() {
//    Task task = DynamicMoodSurveyFactory.moodSurvey(
//            getContext(),
//            "Mood Survey",
//            "Tell us how you feel. We\'ll ask you to rate your mental clarity, mood, and pain level today as well as how well you slept and how much exercise you have done in the last day. You will also have an opportunity to track any activity or thought that you choose yourself.",
//            MoodSurveyFrequency.DAILY,
//            "Today, my thinking is:",
//            new ArrayList<TaskExcludeOption>());

    Task task = DynamicMoodSurveyFactory.moodSurvey(getContext(), "Mood Survey");
    startActivity(ViewTaskActivity.newIntent(getContext(), task));
  }
}
