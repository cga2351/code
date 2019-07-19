package com.facebook.react.uimanager.layoutanimation;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class LayoutAnimationController
{
  private static final boolean ENABLED = true;
  private final AbstractLayoutAnimation mLayoutCreateAnimation = new LayoutCreateAnimation();
  private final AbstractLayoutAnimation mLayoutDeleteAnimation = new LayoutDeleteAnimation();
  private final SparseArray<LayoutHandlingAnimation> mLayoutHandlers = new SparseArray(0);
  private final AbstractLayoutAnimation mLayoutUpdateAnimation = new LayoutUpdateAnimation();
  private boolean mShouldAnimateLayout;

  private void disableUserInteractions(View paramView)
  {
    int i = 0;
    paramView.setClickable(false);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      while (i < localViewGroup.getChildCount())
      {
        disableUserInteractions(localViewGroup.getChildAt(i));
        i++;
      }
    }
  }

  public void applyLayoutUpdate(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    UiThreadUtil.assertOnUiThread();
    final int i = paramView.getId();
    LayoutHandlingAnimation localLayoutHandlingAnimation = (LayoutHandlingAnimation)this.mLayoutHandlers.get(i);
    if (localLayoutHandlingAnimation != null)
      localLayoutHandlingAnimation.onLayoutUpdate(paramInt1, paramInt2, paramInt3, paramInt4);
    label135: 
    while (true)
    {
      return;
      AbstractLayoutAnimation localAbstractLayoutAnimation;
      Animation localAnimation;
      if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0))
      {
        localAbstractLayoutAnimation = this.mLayoutCreateAnimation;
        localAnimation = localAbstractLayoutAnimation.createAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
        if (!(localAnimation instanceof LayoutHandlingAnimation))
          break label120;
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            LayoutAnimationController.this.mLayoutHandlers.remove(i);
          }

          public void onAnimationRepeat(Animation paramAnonymousAnimation)
          {
          }

          public void onAnimationStart(Animation paramAnonymousAnimation)
          {
            LayoutAnimationController.this.mLayoutHandlers.put(i, (LayoutHandlingAnimation)paramAnonymousAnimation);
          }
        });
      }
      while (true)
      {
        if (localAnimation == null)
          break label135;
        paramView.startAnimation(localAnimation);
        return;
        localAbstractLayoutAnimation = this.mLayoutUpdateAnimation;
        break;
        label120: paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      }
    }
  }

  public void deleteView(View paramView, final LayoutAnimationListener paramLayoutAnimationListener)
  {
    UiThreadUtil.assertOnUiThread();
    Animation localAnimation = this.mLayoutDeleteAnimation.createAnimation(paramView, paramView.getLeft(), paramView.getTop(), paramView.getWidth(), paramView.getHeight());
    if (localAnimation != null)
    {
      disableUserInteractions(paramView);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          paramLayoutAnimationListener.onAnimationEnd();
        }

        public void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
        }

        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
        }
      });
      paramView.startAnimation(localAnimation);
      return;
    }
    paramLayoutAnimationListener.onAnimationEnd();
  }

  public void initializeFromConfig(@Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null)
      reset();
    int i;
    do
    {
      return;
      this.mShouldAnimateLayout = false;
      boolean bool = paramReadableMap.hasKey("duration");
      i = 0;
      if (bool)
        i = paramReadableMap.getInt("duration");
      if (paramReadableMap.hasKey(LayoutAnimationType.toString(LayoutAnimationType.CREATE)))
      {
        this.mLayoutCreateAnimation.initializeFromConfig(paramReadableMap.getMap(LayoutAnimationType.toString(LayoutAnimationType.CREATE)), i);
        this.mShouldAnimateLayout = true;
      }
      if (paramReadableMap.hasKey(LayoutAnimationType.toString(LayoutAnimationType.UPDATE)))
      {
        this.mLayoutUpdateAnimation.initializeFromConfig(paramReadableMap.getMap(LayoutAnimationType.toString(LayoutAnimationType.UPDATE)), i);
        this.mShouldAnimateLayout = true;
      }
    }
    while (!paramReadableMap.hasKey(LayoutAnimationType.toString(LayoutAnimationType.DELETE)));
    this.mLayoutDeleteAnimation.initializeFromConfig(paramReadableMap.getMap(LayoutAnimationType.toString(LayoutAnimationType.DELETE)), i);
    this.mShouldAnimateLayout = true;
  }

  public void reset()
  {
    this.mLayoutCreateAnimation.reset();
    this.mLayoutUpdateAnimation.reset();
    this.mLayoutDeleteAnimation.reset();
    this.mShouldAnimateLayout = false;
  }

  public boolean shouldAnimateLayout(View paramView)
  {
    return ((this.mShouldAnimateLayout) && (paramView.getParent() != null)) || (this.mLayoutHandlers.get(paramView.getId()) != null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.LayoutAnimationController
 * JD-Core Version:    0.6.2
 */