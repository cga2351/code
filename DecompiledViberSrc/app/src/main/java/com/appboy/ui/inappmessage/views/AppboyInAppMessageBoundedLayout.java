package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.appboy.ui.R.styleable;

public class AppboyInAppMessageBoundedLayout extends RelativeLayout
{
  private int mMaxDefinedHeightPixels;
  private int mMaxDefinedWidthPixels;
  private int mMinDefinedHeightPixels;
  private int mMinDefinedWidthPixels;

  public AppboyInAppMessageBoundedLayout(Context paramContext)
  {
    super(paramContext);
  }

  public AppboyInAppMessageBoundedLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppboyInAppMessageBoundedLayout);
    this.mMaxDefinedWidthPixels = localTypedArray.getDimensionPixelSize(R.styleable.AppboyInAppMessageBoundedLayout_appboyBoundedLayoutMaxWidth, 0);
    this.mMinDefinedWidthPixels = localTypedArray.getDimensionPixelSize(R.styleable.AppboyInAppMessageBoundedLayout_appboyBoundedLayoutMinWidth, 0);
    this.mMaxDefinedHeightPixels = localTypedArray.getDimensionPixelSize(R.styleable.AppboyInAppMessageBoundedLayout_appboyBoundedLayoutMaxHeight, 0);
    this.mMinDefinedHeightPixels = localTypedArray.getDimensionPixelSize(R.styleable.AppboyInAppMessageBoundedLayout_appboyBoundedLayoutMinHeight, 0);
    localTypedArray.recycle();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int k;
    int n;
    if ((this.mMinDefinedWidthPixels > 0) && (i < this.mMinDefinedWidthPixels))
    {
      int i1 = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.mMinDefinedWidthPixels, i1);
      k = View.MeasureSpec.getSize(paramInt2);
      if ((this.mMinDefinedHeightPixels <= 0) || (k >= this.mMinDefinedHeightPixels))
        break label115;
      n = View.MeasureSpec.getMode(paramInt2);
    }
    label115: int m;
    for (paramInt2 = View.MeasureSpec.makeMeasureSpec(this.mMinDefinedHeightPixels, n); ; paramInt2 = View.MeasureSpec.makeMeasureSpec(this.mMaxDefinedHeightPixels, m))
    {
      do
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
        if ((this.mMaxDefinedWidthPixels <= 0) || (i <= this.mMaxDefinedWidthPixels))
          break;
        int j = View.MeasureSpec.getMode(paramInt1);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.mMaxDefinedWidthPixels, j);
        break;
      }
      while ((this.mMaxDefinedHeightPixels <= 0) || (k <= this.mMaxDefinedHeightPixels));
      m = View.MeasureSpec.getMode(paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageBoundedLayout
 * JD-Core Version:    0.6.2
 */