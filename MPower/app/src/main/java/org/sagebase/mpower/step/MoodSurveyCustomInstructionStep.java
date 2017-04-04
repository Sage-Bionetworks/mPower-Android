package org.sagebase.mpower.step;

import org.researchstack.backbone.step.InstructionStep;
import org.sagebase.mpower.layout.MoodSurveyCustomInstructionStepLayout;

/**
 * Created by rianhouston on 4/1/17.
 */

public class MoodSurveyCustomInstructionStep extends InstructionStep {

    /* Default constructor needed for serilization/deserialization of object */
    MoodSurveyCustomInstructionStep() {
        super();
    }

    public MoodSurveyCustomInstructionStep(String identifier, String title, String detailText)
    {
        super(identifier, title, detailText);
        setOptional(false);
    }

    public Class getStepLayoutClass() {
        return MoodSurveyCustomInstructionStepLayout.class;
    }
}
