package org.researchstack.backbone.answerformat;


import org.researchstack.backbone.model.Choice;

public class BooleanAnswerFormat extends ChoiceAnswerFormat
{

    //TODO Fetch strings from Resources
    public BooleanAnswerFormat()
    {
        super(ChoiceAnswerStyle.SingleChoice, new Choice<>("Yes", true), new Choice<>("No", false));
    }

    @Override
    public QuestionType getQuestionType()
    {
        return Type.Boolean;
    }
}