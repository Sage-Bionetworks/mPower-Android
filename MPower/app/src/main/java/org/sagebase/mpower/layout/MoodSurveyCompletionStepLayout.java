package org.sagebase.mpower.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import org.researchstack.backbone.ui.step.layout.InstructionStepLayout;
import org.sagebionetworks.bridge.researchstack.MPowerPrefs;


/**
 * Created by rianhouston on 4/1/17.
 */

public class MoodSurveyCompletionStepLayout extends InstructionStepLayout {
    private static final String LOG_TAG = MoodSurveyCompletionStepLayout.class.getCanonicalName();

    public MoodSurveyCompletionStepLayout(Context context) {
        super(context);
    }

    public MoodSurveyCompletionStepLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoodSurveyCompletionStepLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public MoodSurveyCompletionStepLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onComplete() {
        // increment the counter
        int counter = MPowerPrefs.getInstance().getCustomSurveyCounter() + 1;
        MPowerPrefs.getInstance().setCustomSurveyCounter(counter);
        super.onComplete();
    }
}
