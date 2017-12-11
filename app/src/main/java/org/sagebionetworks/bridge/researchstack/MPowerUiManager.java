package org.sagebionetworks.bridge.researchstack;

import android.content.Context;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.ActionItem;
import org.researchstack.backbone.UiManager;
import org.researchstack.backbone.ui.LearnActivity;
import org.sagebase.mpower.ActivitiesFragment;
import org.sagebase.mpower.DashboardFragment;
import org.sagebase.mpower.R;
import org.sagebase.mpower.SettingsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheMDP on 12/12/16.
 */

public class MPowerUiManager extends UiManager {
    /**
     * @return List of ActionItems w/ Fragment class items
     */
    @Override
    public List<ActionItem> getMainTabBarItems() {
        List<ActionItem> navItems = new ArrayList<>();

        navItems.add(new ActionItem.ActionItemBuilder().setId(R.id.nav_activities)
                .setTitle(R.string.rsb_activities)
                .setIcon(R.drawable.rsb_ic_tab_activities)
                .setClass(ActivitiesFragment.class)
                .build());

        navItems.add(new ActionItem.ActionItemBuilder().setId(R.id.nav_dashboard)
                .setTitle(R.string.rsb_dashboard)
                .setIcon(R.drawable.rsb_ic_tab_dashboard)
                .setClass(DashboardFragment.class)
                .build());

        return navItems;
    }

    /**
     * @return List of ActionItems w/ Activity class items. The class items are then used to
     * construct an intent for a MenuItem when {@link org.researchstack.backbone.ui.MainActivity#onCreateOptionsMenu}
     * is called
     */
    @Override
    public List<ActionItem> getMainActionBarItems() {
        List<ActionItem> navItems = new ArrayList<>();

        navItems.add(new ActionItem.ActionItemBuilder().setId(R.id.nav_learn)
                .setTitle(R.string.rsb_learn)
                .setIcon(R.drawable.rsb_ic_action_learn)
                .setClass(LearnActivity.class)
                .build());

        navItems.add(new ActionItem.ActionItemBuilder().setId(R.id.nav_settings)
                .setTitle(R.string.rsb_settings)
                .setIcon(R.drawable.rsb_ic_action_settings)
                .setClass(SettingsActivity.class)
                .build());

        return navItems;
    }

    @Override
    public Step getInclusionCriteriaStep(Context context) {
        return null;
    }

    @Override
    public boolean isInclusionCriteriaValid(StepResult stepResult) {
        return false;
    }

    @Override
    public boolean isConsentSkippable() {
        return true;
    }

}
