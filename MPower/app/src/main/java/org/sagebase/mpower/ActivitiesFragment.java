package org.sagebase.mpower;

import org.researchstack.backbone.task.Task;
import org.researchstack.backbone.task.factory.MoodSurveyFactory;
import org.researchstack.backbone.ui.ViewTaskActivity;
import org.sagebase.mpower.task.DynamicMoodSurveyFactory;

/**
 * Created by rianhouston on 3/29/17.
 */

public class ActivitiesFragment extends org.researchstack.skin.ui.fragment.ActivitiesFragment {
    private static final String LOG_TAG = ActivitiesFragment.class.getCanonicalName();

    @Override
    protected void startCustomMoodSurveyTask() {

        Task task = DynamicMoodSurveyFactory.moodSurvey(getContext(), MoodSurveyFactory.MoodSurveyIdentifier);
        startActivity(ViewTaskActivity.newIntent(getContext(), task));
    }
}
