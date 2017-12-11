package org.sagebase.mpower;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.researchstack.backbone.utils.ResUtils;
import org.researchstack.backbone.ResourceManager;
import org.researchstack.backbone.model.StudyOverviewModel;
import org.researchstack.backbone.ui.OverviewActivity;
import org.researchstack.backbone.ui.adapter.OnboardingPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MPowerOverviewActivity extends OverviewActivity {

    private View pagerFrame;
    private View pagerContainer;
    private Button signUp;
    private TextView signIn;
    private List<ImageView> mBullets;
    private Drawable activeBullet;
    private Drawable bullet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_onboarding);

        ImageView logoView = (ImageView) findViewById(R.id.layout_studyoverview_landing_logo);
        TextView titleView = (TextView) findViewById(R.id.layout_studyoverview_landing_title);
        TextView subtitleView = (TextView) findViewById(R.id.layout_studyoverview_landing_subtitle);

        activeBullet = getResources().getDrawable(R.drawable.bullet_active);
        bullet = getResources().getDrawable(R.drawable.bullet);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_studyoverview_main);
        final StudyOverviewModel model = parseStudyOverviewModel();

        titleView.setVisibility(View.GONE);
        subtitleView.setVisibility(View.GONE);

        // setup the bullets and the first/last buttons
        int padding = (int) getResources().getDimension(R.dimen.bullet_padding);
        mBullets = new ArrayList<ImageView>();
        LinearLayout container = (LinearLayout) findViewById(R.id.bullet_container);

        for (int i = 0; i < model.getQuestions().size(); i++) {
            ImageView img = new ImageView(this);
            if (i == 0) {
                img.setImageDrawable(activeBullet);
            } else {
                img.setImageDrawable(bullet);
            }
            mBullets.add(img);
            img.setPadding(padding, padding, padding, padding);
            container.addView(img);
        }

        signUp = (Button) findViewById(org.researchstack.backbone.R.id.intro_sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignUpClicked(view);
            }
        });

        signIn = (TextView) findViewById(org.researchstack.backbone.R.id.intro_sign_in);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignInClicked(view);
            }
        });

        int resId = ResUtils.getDrawableResourceId(this, model.getLogoName());
        logoView.setImageResource(resId);

        pagerContainer = findViewById(org.researchstack.backbone.R.id.pager_container);
        pagerContainer.setTranslationY(48);
        pagerContainer.setAlpha(0);
        pagerContainer.setScaleX(.9f);
        pagerContainer.setScaleY(.9f);

        pagerFrame = findViewById(org.researchstack.backbone.R.id.pager_frame);
        pagerFrame.setAlpha(0);

        OnboardingPagerAdapter adapter = new OnboardingPagerAdapter(this, model.getQuestions());
        ViewPager pager = (ViewPager) findViewById(org.researchstack.backbone.R.id.pager);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(adapter);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //Log.d(LOG_TAG, "onPageSelected: " + position);

                ImageView img = mBullets.get(position);
                img.setImageDrawable(activeBullet);

                for (int i = 0; i < model.getQuestions().size(); i++) {
                    if (i != position) {
                        ImageView imgv = mBullets.get(i);
                        imgv.setImageDrawable(bullet);
                    }
                }
          }

          @Override
          public void onPageScrollStateChanged(int state) {
          }
        });

    showPager(0);
  }

  private StudyOverviewModel parseStudyOverviewModel()
  {
    return ResourceManager.getInstance().getStudyOverview().create(this);
  }

  private void showPager(int index)
  {
    pagerFrame.animate().alpha(1)
            .setDuration(150)
            .withStartAction(new Runnable() {
              @Override
              public void run() {
                pagerFrame.setVisibility(View.VISIBLE);
              }
            })
             .withEndAction(new Runnable() {
              @Override
              public void run() {
                pagerContainer.animate()
                        .translationY(0)
                        .setDuration(100)
                        .alpha(1)
                        .scaleX(1)
                        .scaleY(1);
              }
            });

    signUp.setActivated(true);
  }
}
