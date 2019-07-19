package com.viber.voip.user.viberid.connectaccount.connectsteps.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.design.widget.TextInputLayout;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.LinearInterpolator;
import android.widget.ScrollView;
import com.viber.voip.R.id;
import com.viber.voip.user.viberid.connectaccount.ViberIdConnectActivity;
import com.viber.voip.user.viberid.connectaccount.freestickers.StickersViewContainer;
import com.viber.voip.util.dj;

public class StepsAnimator
{
  static final int TRANSLATION_DURATION = 250;
  private final ViberIdConnectActivity mActivity;
  private final View mContinueButton;
  private final View mFooterView;
  private boolean mIsAnimating;
  private final ScrollView mScrollView;
  private final StickersViewContainer mStickersViewContainer;
  private final View mTopSeparator;

  public StepsAnimator(ViberIdConnectActivity paramViberIdConnectActivity, StickersViewContainer paramStickersViewContainer)
  {
    this.mActivity = paramViberIdConnectActivity;
    this.mStickersViewContainer = paramStickersViewContainer;
    this.mScrollView = ((ScrollView)this.mActivity.findViewById(R.id.scroll_view));
    this.mTopSeparator = this.mActivity.findViewById(R.id.top_divider);
    this.mContinueButton = this.mActivity.findViewById(R.id.continue_button);
    this.mFooterView = this.mActivity.findViewById(R.id.footer_text);
  }

  public boolean isAnimating()
  {
    return this.mIsAnimating;
  }

  public void startAnimation(final ContentAnimatorProvider paramContentAnimatorProvider1, final ContentAnimatorProvider paramContentAnimatorProvider2, final boolean paramBoolean)
  {
    if (this.mIsAnimating)
      return;
    this.mIsAnimating = true;
    this.mStickersViewContainer.pauseAnimation();
    final int i = this.mScrollView.getChildAt(0).getHeight();
    final int j = paramContentAnimatorProvider1.getContentView().getWidth();
    paramContentAnimatorProvider1.init(paramBoolean, j);
    paramContentAnimatorProvider2.init(paramBoolean, j);
    dj.b(paramContentAnimatorProvider1.getContentView(), true);
    dj.b(paramContentAnimatorProvider2.getContentView(), true);
    paramContentAnimatorProvider2.getContentView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        paramContentAnimatorProvider2.getContentView().getViewTreeObserver().removeOnPreDrawListener(this);
        int i = paramContentAnimatorProvider2.getContentView().getHeight() - paramContentAnimatorProvider1.getContentView().getHeight();
        int j = StepsAnimator.this.mScrollView.getScrollY();
        final int k;
        int m;
        ObjectAnimator localObjectAnimator1;
        ObjectAnimator localObjectAnimator2;
        ObjectAnimator localObjectAnimator3;
        int i1;
        StepsAnimator.ContentAnimatorProvider.DividerOffsetInfo localDividerOffsetInfo1;
        if (i >= 0)
        {
          int i2 = StepsAnimator.this.mScrollView.getChildAt(0).getHeight() - StepsAnimator.this.mScrollView.getHeight();
          int i3 = -i;
          k = i2;
          m = i3;
          i = 0;
          int n = j - k;
          View localView1 = StepsAnimator.this.mContinueButton;
          Property localProperty1 = View.TRANSLATION_Y;
          float[] arrayOfFloat1 = new float[2];
          arrayOfFloat1[0] = m;
          arrayOfFloat1[1] = i;
          localObjectAnimator1 = ObjectAnimator.ofFloat(localView1, localProperty1, arrayOfFloat1).setDuration(250L);
          View localView2 = StepsAnimator.this.mFooterView;
          Property localProperty2 = View.TRANSLATION_Y;
          float[] arrayOfFloat2 = new float[2];
          arrayOfFloat2[0] = m;
          arrayOfFloat2[1] = i;
          localObjectAnimator2 = ObjectAnimator.ofFloat(localView2, localProperty2, arrayOfFloat2).setDuration(250L);
          View localView3 = StepsAnimator.this.mScrollView.getChildAt(0);
          Property localProperty3 = View.TRANSLATION_Y;
          float[] arrayOfFloat3 = new float[2];
          arrayOfFloat3[0] = 0.0F;
          arrayOfFloat3[1] = n;
          localObjectAnimator3 = ObjectAnimator.ofFloat(localView3, localProperty3, arrayOfFloat3).setDuration(250L);
          i1 = paramContentAnimatorProvider1.getBottomDividerPosition() - paramContentAnimatorProvider2.getBottomDividerPosition();
          if (i1 > 0)
            break label440;
          localDividerOffsetInfo1 = new StepsAnimator.ContentAnimatorProvider.DividerOffsetInfo(i1, true);
        }
        for (StepsAnimator.ContentAnimatorProvider.DividerOffsetInfo localDividerOffsetInfo2 = new StepsAnimator.ContentAnimatorProvider.DividerOffsetInfo(0, false); ; localDividerOffsetInfo2 = new StepsAnimator.ContentAnimatorProvider.DividerOffsetInfo(i1, true))
        {
          AnimatorSet localAnimatorSet = new AnimatorSet();
          Animator[] arrayOfAnimator = new Animator[5];
          arrayOfAnimator[0] = localObjectAnimator3;
          arrayOfAnimator[1] = localObjectAnimator1;
          arrayOfAnimator[2] = localObjectAnimator2;
          arrayOfAnimator[3] = paramContentAnimatorProvider1.getAnimator(paramBoolean, 250, j, localDividerOffsetInfo2);
          arrayOfAnimator[4] = paramContentAnimatorProvider2.getAnimator(paramBoolean, 250, j, localDividerOffsetInfo1);
          localAnimatorSet.playTogether(arrayOfAnimator);
          localAnimatorSet.setInterpolator(new LinearInterpolator());
          localAnimatorSet.addListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              StepsAnimator.this.mScrollView.postDelayed(new Runnable()
              {
                public void run()
                {
                  StepsAnimator.this.mScrollView.setScrollY(StepsAnimator.1.1.this.val$endScroll);
                  StepsAnimator.this.mScrollView.getChildAt(0).setTranslationY(0.0F);
                  dj.b(StepsAnimator.1.this.val$exitContentAnimatorProvider.getContentView(), false);
                  StepsAnimator.this.mContinueButton.setTranslationY(0.0F);
                  StepsAnimator.this.mFooterView.setTranslationY(0.0F);
                  StepsAnimator.this.mTopSeparator.setTranslationY(0.0F);
                  StepsAnimator.1.this.val$enterContentAnimatorProvider.onAnimationEnd(StepsAnimator.1.this.val$forward);
                  StepsAnimator.1.this.val$exitContentAnimatorProvider.onAnimationEnd(StepsAnimator.1.this.val$forward);
                  StepsAnimator.access$402(StepsAnimator.this, false);
                }
              }
              , 50L);
            }
          });
          localAnimatorSet.start();
          return true;
          k = Math.max(i + i - StepsAnimator.this.mScrollView.getHeight(), 0);
          m = 0;
          break;
          label440: localDividerOffsetInfo1 = new StepsAnimator.ContentAnimatorProvider.DividerOffsetInfo(0, false);
        }
      }
    });
    paramContentAnimatorProvider2.getContentView().invalidate();
  }

  public static abstract class ContentAnimatorProvider
  {
    View mBottomDivider;
    private View mContentView;
    View[] mViews;
    boolean[] mViewsDefaultStates;

    ContentAnimatorProvider(View paramView1, View paramView2, View[] paramArrayOfView)
    {
      this.mContentView = paramView1;
      this.mBottomDivider = paramView2;
      this.mViews = paramArrayOfView;
      this.mViewsDefaultStates = new boolean[paramArrayOfView.length];
      for (int i = 0; i < this.mViews.length; i++)
        this.mViewsDefaultStates[i] = this.mViews[i].isEnabled();
    }

    private void setInputsState(boolean paramBoolean)
    {
      for (int i = 0; i < this.mViews.length; i++)
      {
        View localView = this.mViews[i];
        if ((this.mViewsDefaultStates[i] != 0) && ((localView instanceof TextInputLayout)))
          localView.setEnabled(paramBoolean);
      }
    }

    public abstract Animator getAnimator(boolean paramBoolean, int paramInt1, int paramInt2, DividerOffsetInfo paramDividerOffsetInfo);

    int getBottomDividerPosition()
    {
      return this.mBottomDivider.getBottom();
    }

    View getContentView()
    {
      return this.mContentView;
    }

    public void init(boolean paramBoolean, int paramInt)
    {
      setInputsState(false);
    }

    public void onAnimationEnd(boolean paramBoolean)
    {
      setInputsState(true);
      this.mBottomDivider.setTranslationY(0.0F);
      dj.b(this.mBottomDivider, true);
    }

    final Animator prepareDividerCorrectionAnimator(DividerOffsetInfo paramDividerOffsetInfo, int paramInt)
    {
      View localView1 = this.mBottomDivider;
      int i;
      View localView2;
      Property localProperty;
      float[] arrayOfFloat;
      float f1;
      label65: float f2;
      if (paramDividerOffsetInfo.showDivider)
      {
        i = 0;
        localView1.setVisibility(i);
        if ((!paramDividerOffsetInfo.showDivider) || (paramDividerOffsetInfo.dividerOffset == 0))
          break label129;
        localView2 = this.mBottomDivider;
        localProperty = View.TRANSLATION_Y;
        arrayOfFloat = new float[2];
        if (paramDividerOffsetInfo.dividerOffset >= 0)
          break label112;
        f1 = paramDividerOffsetInfo.dividerOffset;
        arrayOfFloat[0] = f1;
        int j = paramDividerOffsetInfo.dividerOffset;
        f2 = 0.0F;
        if (j >= 0)
          break label118;
      }
      while (true)
      {
        arrayOfFloat[1] = f2;
        return ObjectAnimator.ofFloat(localView2, localProperty, arrayOfFloat).setDuration(paramInt);
        i = 4;
        break;
        label112: f1 = 0.0F;
        break label65;
        label118: f2 = -paramDividerOffsetInfo.dividerOffset;
      }
      label129: return ValueAnimator.ofInt(new int[] { 0, 0 }).setDuration(0L);
    }

    static class DividerOffsetInfo
    {
      final int dividerOffset;
      final boolean showDivider;

      DividerOffsetInfo(int paramInt, boolean paramBoolean)
      {
        this.dividerOffset = paramInt;
        this.showDivider = paramBoolean;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.animation.StepsAnimator
 * JD-Core Version:    0.6.2
 */