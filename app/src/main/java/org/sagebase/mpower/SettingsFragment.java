package org.sagebase.mpower;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import org.researchstack.backbone.utils.LogExt;
import org.sagebionetworks.bridge.researchstack.MPowerPrefs;

public class SettingsFragment extends org.researchstack.backbone.ui.fragment.SettingsFragment {
    public static final String KEY_CUSTOM_QUESTION = "MPOWER_CUSTOM_QUESTION";

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        super.onCreatePreferences(bundle, s);

        PreferenceScreen screen = getPreferenceScreen();

        // Get profile preference
        PreferenceCategory category = (PreferenceCategory) screen.findPreference(KEY_PROFILE);

        // TODO:  not sure where this should go so adding to profile for now
        if (category != null && MPowerPrefs.getInstance().getCustomSurveyQuestion() != null) {
            Preference editTextPref = new Preference(screen.getContext());
            editTextPref.setKey(KEY_CUSTOM_QUESTION);
            editTextPref.setTitle(getString(R.string.settings_custom_question_title));
            showCustomQuestionSummary(editTextPref);

            category.addPreference(editTextPref);
        }
    }

    @Override
    public String getVersionString() {
        return getString(org.researchstack.backbone.R.string.rsb_settings_version,
                BuildConfig.VERSION_NAME,
                BuildConfig.VERSION_CODE);
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        LogExt.i(getClass(), String.valueOf(preference.getTitle()));

        if(preference.hasKey()) {
            switch (preference.getKey()) {
                case KEY_CUSTOM_QUESTION:
                    showCustomQuestion(getActivity(), preference);
                    return true;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    private void showCustomQuestion(Context context, final Preference preference) {
        LayoutInflater factory = LayoutInflater.from(context);
        final View textEntryView = factory.inflate(R.layout.custom_question_preference, null);

        String question = MPowerPrefs.getInstance().getCustomSurveyQuestion();
        final EditText editText = (EditText)textEntryView.findViewById(R.id.custom_question_preference);
        if(question != null && question.length() > 0) {
            editText.setText(question);
        }
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(getString(R.string.settings_custom_question_title))
                .setView(textEntryView)
                .setPositiveButton(getString(R.string.rsb_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String text = editText.getText().toString();
                        MPowerPrefs.getInstance().setCustomSurveyQuestion(text);
                        showCustomQuestionSummary(preference);
                    }
                })
                .setNegativeButton(getString(R.string.rsb_cancel), null);
        Dialog dialog = builder.create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        dialog.show();

    }

    private void showCustomQuestionSummary(Preference preference) {
        String question = MPowerPrefs.getInstance().getCustomSurveyQuestion();
        if(question == null || question.length() == 0) {
            question = getString(R.string.settings_custom_question_summary);
        }
        preference.setSummary(question);

    }

}