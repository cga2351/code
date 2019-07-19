package com.viber.voip.phone;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.viber.voip.R.dimen;
import com.viber.voip.phone.viber.LocalVideoContentPositionManagerQuadrant;
import com.viber.voip.util.cl;
import com.viber.voip.util.dj;

public abstract class LocalVideoContainerInitialPositionDefiner
{
  private boolean mAreBarsVisible;
  private Runnable mCorrectPositionAction = (Runnable)cl.b(Runnable.class);
  protected final int mDefaultMargin;
  private boolean mIsLocalVideoContainerSizeSet;
  private boolean mIsPositionNeedCorrection = true;
  private boolean mIsViewsInit;
  protected final int mWideMargin;

  protected LocalVideoContainerInitialPositionDefiner(Resources paramResources)
  {
    this.mDefaultMargin = paramResources.getDimensionPixelSize(R.dimen.video_call_margin_default);
    this.mWideMargin = paramResources.getDimensionPixelSize(R.dimen.video_call_margin_wide);
  }

  @SuppressLint({"RtlHardcoded"})
  public InitialPosition applyOrientation(int paramInt)
  {
    LocalVideoContainerInitialPositionDefiner.InitialPosition.Builder localBuilder = new LocalVideoContainerInitialPositionDefiner.InitialPosition.Builder();
    if (paramInt == 90)
      localBuilder.setSwitchCameraAttrs(90, 51).setAvailableRect(new Rect(this.mWideMargin, this.mDefaultMargin, this.mDefaultMargin, this.mDefaultMargin));
    while (true)
    {
      localBuilder.setContainerQuadrant(getContainerQuadrant());
      return localBuilder.build();
      if (paramInt == 270)
        localBuilder.setSwitchCameraAttrs(270, 85).setAvailableRect(new Rect(this.mDefaultMargin, this.mDefaultMargin, this.mWideMargin, this.mDefaultMargin));
      else
        localBuilder.setSwitchCameraAttrs(0, 83).setAvailableRect(new Rect(this.mDefaultMargin, this.mDefaultMargin, this.mDefaultMargin, this.mWideMargin));
    }
  }

  public boolean canBarsBeHidden()
  {
    return true;
  }

  public void correctInitialPosition(View paramView)
  {
    if ((this.mIsPositionNeedCorrection) && (this.mAreBarsVisible) && (this.mIsViewsInit) && (this.mIsLocalVideoContainerSizeSet))
    {
      if (paramView.getWidth() == 0)
        break label50;
      this.mCorrectPositionAction.run();
    }
    while (true)
    {
      this.mIsPositionNeedCorrection = false;
      return;
      label50: dj.a(paramView, this.mCorrectPositionAction);
    }
  }

  protected abstract int getContainerQuadrant();

  public Rect getMarginsRectWhenBarsDisplayed(int paramInt, View paramView1, View paramView2)
  {
    Rect localRect = new Rect();
    if (paramInt == 90)
    {
      localRect.left = paramView1.getWidth();
      int k = 0;
      if (paramView2 != null)
        k = paramView2.getWidth();
      localRect.right = k;
      return localRect;
    }
    if (paramInt == 270)
    {
      int i = 0;
      if (paramView2 != null)
        i = paramView2.getWidth();
      localRect.left = i;
      localRect.right = paramView1.getWidth();
      return localRect;
    }
    int j = 0;
    if (paramView2 != null)
      j = paramView2.getHeight();
    localRect.top = j;
    localRect.bottom = paramView1.getHeight();
    return localRect;
  }

  public void onBarViewsInit(View paramView)
  {
    this.mIsViewsInit = true;
    correctInitialPosition(paramView);
  }

  public void onLocalVideoContainerSizeUpdated(View paramView)
  {
    this.mIsLocalVideoContainerSizeSet = true;
    correctInitialPosition(paramView);
  }

  public void resetInitState()
  {
    this.mIsViewsInit = false;
    this.mIsPositionNeedCorrection = true;
  }

  public void setBarsVisibility(boolean paramBoolean)
  {
    this.mAreBarsVisible = paramBoolean;
  }

  public void setCorrectPositionAction(Runnable paramRunnable)
  {
    this.mCorrectPositionAction = paramRunnable;
  }

  public static class InitialPosition
  {
    public final Rect availableRect;

    @LocalVideoContentPositionManagerQuadrant
    public final int containerQuadrant;
    public final int switchCameraGravity;
    public final int switchCameraRotation;

    InitialPosition(Rect paramRect, @LocalVideoContentPositionManagerQuadrant int paramInt1, int paramInt2, int paramInt3)
    {
      this.availableRect = paramRect;
      this.containerQuadrant = paramInt1;
      this.switchCameraGravity = paramInt2;
      this.switchCameraRotation = paramInt3;
    }

    public static class Builder
    {
      private Rect mAvailableRect = new Rect();

      @LocalVideoContentPositionManagerQuadrant
      private int mContainerQuadrant = -1;
      private int mSwitchCameraGravity;
      private int mSwitchCameraRotation;

      public LocalVideoContainerInitialPositionDefiner.InitialPosition build()
      {
        return new LocalVideoContainerInitialPositionDefiner.InitialPosition(this.mAvailableRect, this.mContainerQuadrant, this.mSwitchCameraGravity, this.mSwitchCameraRotation);
      }

      public Builder setAvailableRect(Rect paramRect)
      {
        this.mAvailableRect = paramRect;
        return this;
      }

      public Builder setContainerQuadrant(int paramInt)
      {
        this.mContainerQuadrant = paramInt;
        return this;
      }

      public Builder setSwitchCameraAttrs(int paramInt1, int paramInt2)
      {
        this.mSwitchCameraRotation = paramInt1;
        this.mSwitchCameraGravity = paramInt2;
        return this;
      }
    }
  }

  public static class PhoneLocalVideoContainerInitialPositionDefiner extends LocalVideoContainerInitialPositionDefiner
  {
    public PhoneLocalVideoContainerInitialPositionDefiner(Resources paramResources)
    {
      super();
    }

    @LocalVideoContentPositionManagerQuadrant
    protected int getContainerQuadrant()
    {
      return 2;
    }
  }

  public static class TabletLocalVideoContainerInitialPositionDefiner extends LocalVideoContainerInitialPositionDefiner
  {
    public TabletLocalVideoContainerInitialPositionDefiner(Resources paramResources)
    {
      super();
    }

    @LocalVideoContentPositionManagerQuadrant
    protected int getContainerQuadrant()
    {
      return 0;
    }
  }

  public static class TabletMinimizedLocalVideoContainerInitialPositionDefiner extends LocalVideoContainerInitialPositionDefiner.TabletLocalVideoContainerInitialPositionDefiner
  {
    public TabletMinimizedLocalVideoContainerInitialPositionDefiner(Resources paramResources)
    {
      super();
    }

    @SuppressLint({"RtlHardcoded"})
    public LocalVideoContainerInitialPositionDefiner.InitialPosition applyOrientation(int paramInt)
    {
      return new LocalVideoContainerInitialPositionDefiner.InitialPosition.Builder().setSwitchCameraAttrs(0, 83).setAvailableRect(new Rect(this.mDefaultMargin, this.mDefaultMargin, this.mDefaultMargin, this.mWideMargin)).setContainerQuadrant(getContainerQuadrant()).build();
    }

    public boolean canBarsBeHidden()
    {
      return false;
    }

    public Rect getMarginsRectWhenBarsDisplayed(int paramInt, View paramView1, View paramView2)
    {
      Rect localRect = new Rect();
      if (paramView2 != null);
      for (int i = paramView2.getHeight(); ; i = 0)
      {
        localRect.top = i;
        localRect.bottom = paramView1.getHeight();
        return localRect;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.LocalVideoContainerInitialPositionDefiner
 * JD-Core Version:    0.6.2
 */