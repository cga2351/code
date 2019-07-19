package com.facebook.react.uimanager.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import javax.annotation.Nullable;

public class SizeMonitoringFrameLayout extends FrameLayout
{

  @Nullable
  private OnSizeChangedListener mOnSizeChangedListener;

  public SizeMonitoringFrameLayout(Context paramContext)
  {
    super(paramContext);
  }

  public SizeMonitoringFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SizeMonitoringFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mOnSizeChangedListener != null)
      this.mOnSizeChangedListener.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setOnSizeChangedListener(OnSizeChangedListener paramOnSizeChangedListener)
  {
    this.mOnSizeChangedListener = paramOnSizeChangedListener;
  }

  public static abstract interface OnSizeChangedListener
  {
    public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.common.SizeMonitoringFrameLayout
 * JD-Core Version:    0.6.2
 */