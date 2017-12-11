package org.sagebase.mpower;

import android.widget.Toast;

import org.researchstack.backbone.model.SchedulesAndTasksModel;
import org.researchstack.backbone.task.Task;
import org.researchstack.backbone.task.factory.MoodSurveyFactory;
import org.researchstack.backbone.ui.ViewTaskActivity;
import org.sagebase.mpower.task.DynamicMoodSurveyFactory;

/**
 * Created by rianhouston on 3/29/17.
 */

public class ActivitiesFragment extends org.researchstack.backbone.ui.fragment.ActivitiesFragment {
    private static final String LOG_TAG = ActivitiesFragment.class.getCanonicalName();

    @Override
    protected void startCustomTask(SchedulesAndTasksModel.TaskScheduleModel task) {
        Toast.makeText(getActivity(),
                org.researchstack.backbone.R.string.rsb_local_error_load_task,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startCustomMoodSurveyTask() {

        Task task = DynamicMoodSurveyFactory.moodSurvey(getContext(), MoodSurveyFactory.MoodSurveyIdentifier);
        startActivity(ViewTaskActivity.newIntent(getContext(), task));
    }
}
