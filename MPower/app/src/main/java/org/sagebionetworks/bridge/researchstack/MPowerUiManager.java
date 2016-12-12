package org.sagebionetworks.bridge.researchstack;

import android.content.Context;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.step.Step;
import org.researchstack.skin.ActionItem;
import org.researchstack.skin.UiManager;

import java.util.List;

/**
 * Created by TheMDP on 12/12/16.
 */

public class MPowerUiManager extends UiManager {
    @Override
    public List<ActionItem> getMainActionBarItems() {
        return null;
    }

    @Override
    public List<ActionItem> getMainTabBarItems() {
        return null;
    }

    @Override
    public Step getInclusionCriteriaStep(Context context) {
        return null;
    }

    @Override
    public boolean isInclusionCriteriaValid(StepResult result) {
        return false;
    }
}
