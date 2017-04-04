package org.sagebase.mpower.step;

import org.researchstack.backbone.answerformat.AnswerFormat;
import org.researchstack.backbone.step.QuestionStep;
import org.sagebase.mpower.layout.MoodSurveyCustomQuestionStepLayout;

/**
 * Created by rianhouston on 4/2/17.
 */

public class MoodSurveyCustomQuestionStep extends QuestionStep {
    public MoodSurveyCustomQuestionStep(String identifier) {
    super(identifier);
  }

    public MoodSurveyCustomQuestionStep(String identifier, String title) {
    super(identifier, title);
  }

    public MoodSurveyCustomQuestionStep(String identifier, String title, AnswerFormat format) {
        super(identifier, title, format);
    }

    public Class getStepLayoutClass() {
    return MoodSurveyCustomQuestionStepLayout.class;
  }
}
