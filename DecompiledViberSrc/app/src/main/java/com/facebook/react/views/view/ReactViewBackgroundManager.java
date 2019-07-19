package com.facebook.react.views.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import javax.annotation.Nullable;

public class ReactViewBackgroundManager
{

  @Nullable
  private ReactViewBackgroundDrawable mReactBackgroundDrawable;
  private View mView;

  public ReactViewBackgroundManager(View paramView)
  {
    this.mView = paramView;
  }

  private ReactViewBackgroundDrawable getOrCreateReactViewBackground()
  {
    Drawable localDrawable;
    if (this.mReactBackgroundDrawable == null)
    {
      this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(this.mView.getContext());
      localDrawable = this.mView.getBackground();
      ViewCompat.setBackground(this.mView, null);
      if (localDrawable != null)
        break label61;
      ViewCompat.setBackground(this.mView, this.mReactBackgroundDrawable);
    }
    while (true)
    {
      return this.mReactBackgroundDrawable;
      label61: Drawable[] arrayOfDrawable = new Drawable[2];
      arrayOfDrawable[0] = this.mReactBackgroundDrawable;
      arrayOfDrawable[1] = localDrawable;
      LayerDrawable localLayerDrawable = new LayerDrawable(arrayOfDrawable);
      ViewCompat.setBackground(this.mView, localLayerDrawable);
    }
  }

  public void setBackgroundColor(int paramInt)
  {
    if ((paramInt == 0) && (this.mReactBackgroundDrawable == null))
      return;
    getOrCreateReactViewBackground().setColor(paramInt);
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    getOrCreateReactViewBackground().setBorderColor(paramInt, paramFloat1, paramFloat2);
  }

  public void setBorderRadius(float paramFloat)
  {
    getOrCreateReactViewBackground().setRadius(paramFloat);
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    getOrCreateReactViewBackground().setRadius(paramFloat, paramInt);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    getOrCreateReactViewBackground().setBorderStyle(paramString);
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    getOrCreateReactViewBackground().setBorderWidth(paramInt, paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactViewBackgroundManager
 * JD-Core Version:    0.6.2
 */