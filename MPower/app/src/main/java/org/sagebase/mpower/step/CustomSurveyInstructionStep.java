package org.sagebase.mpower.step;

import org.researchstack.backbone.step.InstructionStep;
import org.sagebase.mpower.layout.CustomSurveyInstructionStepLayout;

/**
 * Created by rianhouston on 4/1/17.
 */

public class CustomSurveyInstructionStep extends InstructionStep {

    /* Default constructor needed for serilization/deserialization of object */
    CustomSurveyInstructionStep() {
        super();
    }

    public CustomSurveyInstructionStep(String identifier, String title, String detailText)
    {
        super(identifier, title, detailText);
        setOptional(false);
    }

    public Class getStepLayoutClass() {
        return CustomSurveyInstructionStepLayout.class;
    }
}
