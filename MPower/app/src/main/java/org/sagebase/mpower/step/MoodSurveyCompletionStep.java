package org.sagebase.mpower.step;

import org.researchstack.backbone.step.CompletionStep;
import org.sagebase.mpower.layout.MoodSurveyCompletionStepLayout;

/**
 * Created by TheMDP on 1/18/17.
 */

public class MoodSurveyCompletionStep extends CompletionStep {

    /* Default constructor needed for serilization/deserialization of object */
    MoodSurveyCompletionStep() {
        super();
    }

    public MoodSurveyCompletionStep(String identifier, String title, String detailText)
    {
        super(identifier, title, detailText);
        setOptional(false);
    }

    public Class getStepLayoutClass() {
        return MoodSurveyCompletionStepLayout.class;
    }
}
