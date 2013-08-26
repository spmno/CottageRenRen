package com.spmno.cottagerenren;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GuideActivity extends AppBaseActivity implements View.OnClickListener{

    private Button registerButton;
    private Button lookPeopleIKnowButton;
    private Button loginButton;

    private ImageView guideImageView;
    private TextView guideText;

    private Drawable[] pictures;
    private Animation[] animations;

    private int picturePosition = 0;

    private String[] texts = {"儿时友，莫难忘", "同学情，请珍惜", "共奋斗，同分享", "感谢一路有你", "青春勇敢飞翔", "理想从未远去"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        guideText.setText(texts[picturePosition]);
        guideImageView.setImageDrawable(pictures[picturePosition]);
        guideImageView.startAnimation(animations[picturePosition]);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void setupView() {
        guideImageView = (ImageView) findViewById(R.id.guide_image);
        guideText = (TextView) findViewById(R.id.guide_content);
        registerButton = (Button) findViewById(R.id.register_button);
        lookPeopleIKnowButton = (Button) findViewById(R.id.look_people_i_know);
        loginButton = (Button) findViewById(R.id.login_button);

        registerButton.setOnClickListener(this);
        lookPeopleIKnowButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        pictures = new Drawable[] {
                getResources().getDrawable(R.drawable.guide_pic1),
                getResources().getDrawable(R.drawable.guide_pic2),
                getResources().getDrawable(R.drawable.guide_pic3),
                getResources().getDrawable(R.drawable.guide_pic1),
                getResources().getDrawable(R.drawable.guide_pic2),
                getResources().getDrawable(R.drawable.guide_pic3)
        };

        animations = new Animation[] {
                AnimationUtils.loadAnimation(this, R.anim.guide_welcome_fade_in),
                AnimationUtils.loadAnimation(this, R.anim.guide_welcome_fade_in_scale),
                AnimationUtils.loadAnimation(this, R.anim.guide_welcome_fade_out)
        };
        animations[0].setDuration(1500);
        animations[1].setDuration(3000);
        animations[2].setDuration(1500);

        animations[0].setAnimationListener(new GuideAnimationListener(0));
        animations[1].setAnimationListener(new GuideAnimationListener(1));
        animations[2].setAnimationListener(new GuideAnimationListener(2));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_button: {
                break;
            }
            case R.id.look_people_i_know: {
                break;
            }
            case R.id.login_button: {
                Intent intent = new Intent(GuideActivity.this, AuthActivity.class);
                startActivity(intent);
                GuideActivity.this.finish();
                break;
            }
        }
    }

    class GuideAnimationListener implements Animation.AnimationListener {
        private int index;

        public GuideAnimationListener(int index) {
            this.index = index;
        }

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (index < (animations.length-1)) {
                guideImageView.startAnimation(animations[index+1]);
            } else {
                picturePosition++;
                if (picturePosition > (pictures.length - 1)) {
                    picturePosition = 0;
                }

                guideText.setText(texts[picturePosition]);
                guideImageView.setImageDrawable(pictures[picturePosition]);
                guideImageView.startAnimation(animations[0]);
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
