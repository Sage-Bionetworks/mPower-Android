package org.sagebionetworks.bridge.researchstack;

import android.content.Context;

import org.researchstack.backbone.answerformat.BooleanAnswerFormat;
import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.step.FormStep;
import org.researchstack.backbone.step.QuestionStep;
import org.researchstack.backbone.step.Step;
import org.researchstack.skin.ActionItem;
import org.researchstack.skin.ResourceManager;
import org.researchstack.skin.UiManager;
import org.researchstack.skin.model.InclusionCriteriaModel;
import org.researchstack.skin.task.OnboardingTask;
import org.researchstack.skin.ui.LearnActivity;
import org.researchstack.skin.ui.fragment.ActivitiesFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by TheMDP on 12/12/16.
 */

public class MPowerUiManager extends UiManager {
    /**
     * @return List of ActionItems w/ Fragment class items
     */
    @Override
    public List<ActionItem> getMainTabBarItems()
    {
        List<ActionItem> navItems = new ArrayList<>();
//
//        navItems.add(new ActionItem.ActionItemBuilder().setId(R.id.nav_activities)
//                .setTitle(R.string.rss_activities)
//                .setIcon(R.drawable.rss_ic_tab_activities)
//                .setClass(ActivitiesFragment.class)
//                .build());
//
//        navItems.add(new ActionItem.ActionItemBuilder().setId(R.id.nav_dashboard)
//                .setTitle(R.string.rss_dashboard)
//                .setIcon(R.drawable.rss_ic_tab_dashboard)
//                .setClass(DashboardFragment.class)
//                .build());

        return navItems;
    }

    /**
     * @return List of ActionItems w/ Activity class items. The class items are then used to
     * construct an intent for a MenuItem when {@link org.researchstack.skin.ui.MainActivity#onCreateOptionsMenu}
     * is called
     */
    @Override
    public List<ActionItem> getMainActionBarItems()
    {
        List<ActionItem> navItems = new ArrayList<>();

//        navItems.add(new ActionItem.ActionItemBuilder().setId(R.id.nav_learn)
//                .setTitle(R.string.rss_learn)
//                .setIcon(R.drawable.rss_ic_action_learn)
//                .setClass(LearnActivity.class)
//                .build());
//
//        navItems.add(new ActionItem.ActionItemBuilder().setId(R.id.nav_settings)
//                .setTitle(R.string.rss_settings)
//                .setIcon(R.drawable.rss_ic_action_settings)
//                .setClass(SampleSettingsActivity.class)
//                .build());

        return navItems;
    }
    
    @Override
    public Step getInclusionCriteriaStep(Context context)
    {
        return null;
    }

    @Override
    public boolean isInclusionCriteriaValid(StepResult stepResult)
    {
        return false;
    }

    @Override
    public boolean isConsentSkippable()
    {
        return false;
    }

}
