package org.sagebase.mpower.layout;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.ui.step.layout.InstructionStepLayout;
import org.sagebase.mpower.R;


/**
 * Created by rianhouston on 4/1/17.
 */

public class MoodSurveyCustomInstructionStepLayout extends InstructionStepLayout {
    private static final String LOG_TAG = MoodSurveyCustomInstructionStepLayout.class.getCanonicalName();

    public MoodSurveyCustomInstructionStepLayout(Context context) {
        super(context);
    }

    public MoodSurveyCustomInstructionStepLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoodSurveyCustomInstructionStepLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public MoodSurveyCustomInstructionStepLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void initialize(Step step, StepResult result) {
        super.initialize(step, result);
        moreDetailTextView.setTextColor(getResources().getColor(R.color.colorPrimary));
        moreDetailTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = getContext().getString(R.string.custom_mood_survey_dialog_text);
                showOkAlertDialog(message);
            }
        });
    }

}
