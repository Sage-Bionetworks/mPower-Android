package org.sagebase.mpower.layout;

import android.content.Context;
import android.util.AttributeSet;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.ui.step.layout.SurveyStepLayout;
import org.sagebionetworks.bridge.researchstack.MPowerPrefs;

/**
 * Created by rianhouston on 4/2/17.
 */

public class MoodSurveyCustomQuestionStepLayout extends SurveyStepLayout {
    public MoodSurveyCustomQuestionStepLayout(Context context) {
        super(context);
    }

    public MoodSurveyCustomQuestionStepLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoodSurveyCustomQuestionStepLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onComplete() {
        // save the custom question
        StepResult result = stepBody.getStepResult(false);
        String question = (String)result.getResult();
        MPowerPrefs.getInstance().setCustomSurveyQuestion(question);
        super.onComplete();
    }
}
