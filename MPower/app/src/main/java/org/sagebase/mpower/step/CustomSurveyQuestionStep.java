package org.sagebase.mpower.step;

import org.researchstack.backbone.answerformat.AnswerFormat;
import org.researchstack.backbone.step.QuestionStep;
import org.sagebase.mpower.layout.CustomSurveyQuestionStepLayout;

/**
 * Created by rianhouston on 4/2/17.
 */

public class CustomSurveyQuestionStep extends QuestionStep {
  public CustomSurveyQuestionStep(String identifier) {
    super(identifier);
  }

  public CustomSurveyQuestionStep(String identifier, String title) {
    super(identifier, title);
  }

  public CustomSurveyQuestionStep(String identifier, String title, AnswerFormat format) {
    super(identifier, title, format);
  }

  public Class getStepLayoutClass() {
    return CustomSurveyQuestionStepLayout.class;
  }
}
