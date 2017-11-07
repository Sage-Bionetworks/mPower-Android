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

public class ActivitiesFragment extends org.researchstack.skin.ui.fragment.ActivitiesFragment {
    // TODO: remove the methods below once we finish task builder
    public static final String APHWalkingActivitySurveyIdentifier = "4-APHTimedWalking-80F09109-265A-49C6-9C5D-765E49AAF5D9";
    public static final String APHVoiceActivitySurveyIdentifier =   "3-APHPhonation-C614A231-A7B7-4173-BDC8-098309354292";
    public static final String APHTappingActivitySurveyIdentifier = "2-APHIntervalTapping-7259AC18-D711-47A6-ADBD-6CFCECDED1DF";
    public static final String APHTremorActivitySurveyIdentifier =  "1-APHTremor-108E189F-4B5B-48DC-BFD7-FA6796EEf439";
    public static final String APHMoodSurveyIdentifier =            "3-APHMoodSurvey-7259AC18-D711-47A6-ADBD-6CFCECDED1DF";

    @Override
    public void startCustomMoodSurveyTask() {

        Task task = DynamicMoodSurveyFactory.moodSurvey(getContext(), MoodSurveyFactory.MoodSurveyIdentifier);
        startActivity(ViewTaskActivity.newIntent(getContext(), task));
    }

    @Override
    protected void startCustomTask(SchedulesAndTasksModel.TaskScheduleModel task) {
        // TODO: figure out a different way to show do these in loadTask
        switch (task.taskID) {
            case APHTappingActivitySurveyIdentifier:
                startCustomTappingTask();
                break;
            case APHTremorActivitySurveyIdentifier:
                startCustomTremorTask();
                break;
            case APHVoiceActivitySurveyIdentifier:
                startCustomVoiceTask();
                break;
            case APHWalkingActivitySurveyIdentifier:
                startCustomWalkingTask();
                break;
            case APHMoodSurveyIdentifier:
                startCustomMoodSurveyTask();
                break;
            default:
                Toast.makeText(getActivity(),
                        org.researchstack.skin.R.string.rss_local_error_load_task,
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
