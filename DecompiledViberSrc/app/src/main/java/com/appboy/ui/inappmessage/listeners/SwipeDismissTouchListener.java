package com.appboy.ui.inappmessage.listeners;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

public class SwipeDismissTouchListener
  implements View.OnTouchListener
{
  private long mAnimationTime;
  private DismissCallbacks mCallbacks;
  private float mDownX;
  private float mDownY;
  private int mMaxFlingVelocity;
  private int mMinFlingVelocity;
  private int mSlop;
  private boolean mSwiping;
  private int mSwipingSlop;
  private Object mToken;
  private float mTranslationX;
  private VelocityTracker mVelocityTracker;
  private View mView;
  private int mViewWidth = 1;

  public SwipeDismissTouchListener(View paramView, Object paramObject, DismissCallbacks paramDismissCallbacks)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramView.getContext());
    this.mSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinFlingVelocity = (16 * localViewConfiguration.getScaledMinimumFlingVelocity());
    this.mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mAnimationTime = paramView.getContext().getResources().getInteger(17694720);
    this.mView = paramView;
    this.mToken = paramObject;
    this.mCallbacks = paramDismissCallbacks;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    paramMotionEvent.offsetLocation(this.mTranslationX, 0.0F);
    if (this.mViewWidth < 2)
      this.mViewWidth = this.mView.getWidth();
    float f3;
    float f4;
    float f5;
    float f6;
    boolean bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default:
    case 0:
    case 1:
      do
      {
        do
        {
          return false;
          this.mDownX = paramMotionEvent.getRawX();
          this.mDownY = paramMotionEvent.getRawY();
        }
        while (!this.mCallbacks.canDismiss(this.mToken));
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mVelocityTracker.addMovement(paramMotionEvent);
        return false;
      }
      while (this.mVelocityTracker == null);
      f3 = paramMotionEvent.getRawX() - this.mDownX;
      this.mVelocityTracker.addMovement(paramMotionEvent);
      this.mVelocityTracker.computeCurrentVelocity(1000);
      f4 = this.mVelocityTracker.getXVelocity();
      f5 = Math.abs(f4);
      f6 = Math.abs(this.mVelocityTracker.getYVelocity());
      if ((Math.abs(f3) > this.mViewWidth / 2) && (this.mSwiping))
        if (f3 > 0.0F)
          bool2 = bool1;
      break;
    case 3:
    case 2:
    }
    while (true)
    {
      float f7;
      if (bool1)
      {
        ViewPropertyAnimator localViewPropertyAnimator = this.mView.animate();
        if (bool2)
        {
          f7 = this.mViewWidth;
          label237: localViewPropertyAnimator.translationX(f7).alpha(0.0F).setDuration(this.mAnimationTime).setListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              SwipeDismissTouchListener.this.performDismiss();
            }
          });
        }
      }
      while (true)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mTranslationX = 0.0F;
        this.mDownX = 0.0F;
        this.mDownY = 0.0F;
        this.mSwiping = false;
        return false;
        bool2 = false;
        break;
        if ((this.mMinFlingVelocity > f5) || (f5 > this.mMaxFlingVelocity) || (f6 >= f5) || (!this.mSwiping))
          break label717;
        boolean bool3;
        label354: boolean bool4;
        label364: boolean bool5;
        if (f4 < 0.0F)
        {
          bool3 = bool1;
          if (f3 >= 0.0F)
            break label405;
          bool4 = bool1;
          if (bool3 != bool4)
            break label411;
          bool5 = bool1;
          label374: if (this.mVelocityTracker.getXVelocity() <= 0.0F)
            break label417;
        }
        while (true)
        {
          boolean bool6 = bool1;
          bool1 = bool5;
          bool2 = bool6;
          break;
          bool3 = false;
          break label354;
          label405: bool4 = false;
          break label364;
          label411: bool5 = false;
          break label374;
          label417: bool1 = false;
        }
        f7 = -this.mViewWidth;
        break label237;
        if (this.mSwiping)
          this.mView.animate().translationX(0.0F).alpha(1.0F).setDuration(this.mAnimationTime).setListener(null);
      }
      if (this.mVelocityTracker == null)
        break;
      this.mView.animate().translationX(0.0F).alpha(1.0F).setDuration(this.mAnimationTime).setListener(null);
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      this.mTranslationX = 0.0F;
      this.mDownX = 0.0F;
      this.mDownY = 0.0F;
      this.mSwiping = false;
      return false;
      if (this.mVelocityTracker == null)
        break;
      this.mVelocityTracker.addMovement(paramMotionEvent);
      float f1 = paramMotionEvent.getRawX() - this.mDownX;
      float f2 = paramMotionEvent.getRawY() - this.mDownY;
      if ((Math.abs(f1) > this.mSlop) && (Math.abs(f2) < Math.abs(f1) / 2.0F))
      {
        this.mSwiping = bool1;
        if (f1 <= 0.0F)
          break label707;
      }
      label707: for (int i = this.mSlop; ; i = -this.mSlop)
      {
        this.mSwipingSlop = i;
        this.mView.getParent().requestDisallowInterceptTouchEvent(bool1);
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(0x3 | paramMotionEvent.getActionIndex() << 8);
        this.mView.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        if (!this.mSwiping)
          break;
        this.mTranslationX = f1;
        this.mView.setTranslationX(f1 - this.mSwipingSlop);
        return bool1;
      }
      label717: bool2 = false;
      bool1 = false;
    }
  }

  @TargetApi(12)
  public void performDismiss()
  {
    final ViewGroup.LayoutParams localLayoutParams = this.mView.getLayoutParams();
    final int i = this.mView.getHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, 1 }).setDuration(this.mAnimationTime);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SwipeDismissTouchListener.this.mCallbacks.onDismiss(SwipeDismissTouchListener.this.mView, SwipeDismissTouchListener.this.mToken);
        SwipeDismissTouchListener.this.mView.setAlpha(1.0F);
        SwipeDismissTouchListener.this.mView.setTranslationX(0.0F);
        localLayoutParams.height = i;
        SwipeDismissTouchListener.this.mView.setLayoutParams(localLayoutParams);
      }
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        localLayoutParams.height = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        SwipeDismissTouchListener.this.mView.setLayoutParams(localLayoutParams);
      }
    });
    localValueAnimator.start();
  }

  public static abstract interface DismissCallbacks
  {
    public abstract boolean canDismiss(Object paramObject);

    public abstract void onDismiss(View paramView, Object paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.SwipeDismissTouchListener
 * JD-Core Version:    0.6.2
 */