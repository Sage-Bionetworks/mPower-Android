package org.sagebase.mpower;

import org.junit.Before;
import org.junit.Test;
import org.researchstack.backbone.model.SchedulesAndTasksModel;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ActivitiesFragmentTest {
    private ActivitiesFragment fragment;

    @Before
    public void setup() {
        // Spy fragment, so we can separate out non-test calls.
        fragment = spy(new ActivitiesFragment());
    }

    @Test
    public void startCustomTask_Tapping() {
        // Spy fragment.startCustomTask()
        doNothing().when(fragment).startCustomTappingTask();

        // Make test task
        SchedulesAndTasksModel.TaskScheduleModel taskScheduleModel =
                new SchedulesAndTasksModel.TaskScheduleModel();
        taskScheduleModel.taskID = ActivitiesFragment.APHTappingActivitySurveyIdentifier;

        // Execute
        fragment.startCustomTask(taskScheduleModel);

        // Verify data flow
        verify(fragment).startCustomTappingTask();
    }

    @Test
    public void startCustomTask_Tremor() {
        // Spy fragment.startCustomTask()
        doNothing().when(fragment).startCustomTremorTask();

        // Make test task
        SchedulesAndTasksModel.TaskScheduleModel taskScheduleModel =
                new SchedulesAndTasksModel.TaskScheduleModel();
        taskScheduleModel.taskID = ActivitiesFragment.APHTremorActivitySurveyIdentifier;

        // Execute
        fragment.startCustomTask(taskScheduleModel);

        // Verify data flow
        verify(fragment).startCustomTremorTask();
    }

    @Test
    public void startCustomTask_Voice() {
        // Spy fragment.startCustomTask()
        doNothing().when(fragment).startCustomVoiceTask();

        // Make test task
        SchedulesAndTasksModel.TaskScheduleModel taskScheduleModel =
                new SchedulesAndTasksModel.TaskScheduleModel();
        taskScheduleModel.taskID = ActivitiesFragment.APHVoiceActivitySurveyIdentifier;

        // Execute
        fragment.startCustomTask(taskScheduleModel);

        // Verify data flow
        verify(fragment).startCustomVoiceTask();
    }

    @Test
    public void startCustomTask_Walking() {
        // Spy fragment.startCustomTask()
        doNothing().when(fragment).startCustomWalkingTask();

        // Make test task
        SchedulesAndTasksModel.TaskScheduleModel taskScheduleModel =
                new SchedulesAndTasksModel.TaskScheduleModel();
        taskScheduleModel.taskID = ActivitiesFragment.APHWalkingActivitySurveyIdentifier;

        // Execute
        fragment.startCustomTask(taskScheduleModel);

        // Verify data flow
        verify(fragment).startCustomWalkingTask();
    }

    @Test
    public void startCustomTask_Mood() {
        // Spy fragment.startCustomTask()
        doNothing().when(fragment).startCustomMoodSurveyTask();

        // Make test task
        SchedulesAndTasksModel.TaskScheduleModel taskScheduleModel =
                new SchedulesAndTasksModel.TaskScheduleModel();
        taskScheduleModel.taskID = ActivitiesFragment.APHMoodSurveyIdentifier;

        // Execute
        fragment.startCustomTask(taskScheduleModel);

        // Verify data flow
        verify(fragment).startCustomMoodSurveyTask();
    }
}
