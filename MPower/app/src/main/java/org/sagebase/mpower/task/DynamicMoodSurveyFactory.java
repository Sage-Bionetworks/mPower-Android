package org.sagebase.mpower.task;

import android.content.Context;
import android.util.Log;

import org.researchstack.backbone.answerformat.TextAnswerFormat;
import org.researchstack.backbone.step.InstructionStep;
import org.researchstack.backbone.step.QuestionStep;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.task.OrderedTask;
import org.researchstack.backbone.task.factory.MoodSurveyFactory;
import org.researchstack.backbone.task.factory.MoodSurveyFrequency;
import org.sagebase.mpower.step.CustomSurveyInstructionStep;
import org.sagebase.mpower.step.CustomSurveyQuestionStep;
import org.sagebase.mpower.step.MoodSurveyCompletionStep;
import org.sagebase.mpower.R;
import org.sagebionetworks.bridge.researchstack.MPowerPrefs;

import java.util.ArrayList;
import java.util.List;

import static org.researchstack.backbone.task.factory.TaskFactory.Constants.ConclusionStepIdentifier;

/**
 * Created by rianhouston on 3/30/17.
 */

public class DynamicMoodSurveyFactory extends MoodSurveyFactory {
    private static final String LOG_TAG = DynamicMoodSurveyFactory.class.getCanonicalName();

    private static final String CustomSurveyInstrcutionIdentifier = "customer.survey.instruction";
    private static final String CustomSurveyQuestionIdentifier = "custom.survey.question";

    private static final int TEXT_ANSWER_FORMAT_MAX_LENGTH = 90;
    private static final int NUMBER_OF_COMPLETIONS_UNTIL_DISPLAYING_CUSTOMSURVEY = 6;

    public static OrderedTask moodSurvey(Context context, String identifier) {
        List<Step> steps = initSteps(context);

        OrderedTask task = new OrderedTask(identifier, steps);
        return task;

    }

    private static List<Step> initSteps(Context context) {
        List<Step> stepList = new ArrayList<>();

        MoodSurveyFrequency frequency = MoodSurveyFrequency.DAILY;

        int counter = MPowerPrefs.getInstance().getCustomSurveyCounter();
        String customQuestionText = MPowerPrefs.getInstance().getCustomSurveyQuestion();

        // Intro
        {
            String text = context.getString(R.string.rss_activities_mood_survey_intended_use);
            stepList.add(getIntroStep(context, frequency, text));
        }

        if(counter == NUMBER_OF_COMPLETIONS_UNTIL_DISPLAYING_CUSTOMSURVEY) {

            // Custom Survey
            {
                String title = context.getString(R.string.custom_mood_survey_title);
                String text = context.getString(R.string.custom_mood_survey_text);
                InstructionStep step = new CustomSurveyInstructionStep(CustomSurveyInstrcutionIdentifier, title, text);
                step.setMoreDetailText(context.getString(R.string.custom_mood_survey_dialog_label));
                stepList.add(step);
            }

            // Custom Question
            {
                TextAnswerFormat answer = new TextAnswerFormat(TEXT_ANSWER_FORMAT_MAX_LENGTH);
                answer.setIsMultipleLines(true);
                answer.setMinumumLength(1);
                QuestionStep step = new CustomSurveyQuestionStep(CustomSurveyQuestionIdentifier,
                        context.getString(R.string.custom_mood_survey_question_text), answer);
                step.setPlaceholder(context.getString(R.string.custom_mood_survey_placeholder_text));

                stepList.add(step);
            }
        }

        // Custom
        if (customQuestionText != null) {
            stepList.add(getCustomQuestionStep(context, customQuestionText));
        }

        // Clarity
        stepList.add(getClarityStep(context, frequency));

        // Overall
        stepList.add(getOverallStep(context, frequency));

        // Pain
        stepList.add(getPainStep(context, frequency));

        // Sleep
        stepList.add(getSleepStep(context, frequency));

        // Exercise
        stepList.add(getExerciseStep(context, frequency));

        // Completion
        {
            String title = context.getString(R.string.custom_mood_survey_completion_title);
            String text = context.getString(R.string.custom_mood_survey_completion_text);
            stepList.add(new MoodSurveyCompletionStep(ConclusionStepIdentifier, title, text));
        }

        return stepList;
    }
}
