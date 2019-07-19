package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout
{
  private OnAttachListener mAttachListener;
  private final Rect mDecorPadding = new Rect();
  private TypedValue mFixedHeightMajor;
  private TypedValue mFixedHeightMinor;
  private TypedValue mFixedWidthMajor;
  private TypedValue mFixedWidthMinor;
  private TypedValue mMinWidthMajor;
  private TypedValue mMinWidthMinor;

  public ContentFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void dispatchFitSystemWindows(Rect paramRect)
  {
    fitSystemWindows(paramRect);
  }

  public TypedValue getFixedHeightMajor()
  {
    if (this.mFixedHeightMajor == null)
      this.mFixedHeightMajor = new TypedValue();
    return this.mFixedHeightMajor;
  }

  public TypedValue getFixedHeightMinor()
  {
    if (this.mFixedHeightMinor == null)
      this.mFixedHeightMinor = new TypedValue();
    return this.mFixedHeightMinor;
  }

  public TypedValue getFixedWidthMajor()
  {
    if (this.mFixedWidthMajor == null)
      this.mFixedWidthMajor = new TypedValue();
    return this.mFixedWidthMajor;
  }

  public TypedValue getFixedWidthMinor()
  {
    if (this.mFixedWidthMinor == null)
      this.mFixedWidthMinor = new TypedValue();
    return this.mFixedWidthMinor;
  }

  public TypedValue getMinWidthMajor()
  {
    if (this.mMinWidthMajor == null)
      this.mMinWidthMajor = new TypedValue();
    return this.mMinWidthMajor;
  }

  public TypedValue getMinWidthMinor()
  {
    if (this.mMinWidthMinor == null)
      this.mMinWidthMinor = new TypedValue();
    return this.mMinWidthMinor;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mAttachListener != null)
      this.mAttachListener.onAttachedFromWindow();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mAttachListener != null)
      this.mAttachListener.onDetachedFromWindow();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int i;
    int j;
    int k;
    TypedValue localTypedValue3;
    label55: int i6;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      i = 1;
      j = View.MeasureSpec.getMode(paramInt1);
      k = View.MeasureSpec.getMode(paramInt2);
      if (j != -2147483648)
        break label490;
      if (i == 0)
        break label348;
      localTypedValue3 = this.mFixedWidthMinor;
      if ((localTypedValue3 == null) || (localTypedValue3.type == 0))
        break label490;
      if (localTypedValue3.type != 5)
        break label357;
      i6 = (int)localTypedValue3.getDimension(localDisplayMetrics);
    }
    label388: label397: 
    while (true)
    {
      label86: if (i6 > 0)
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.min(i6 - (this.mDecorPadding.left + this.mDecorPadding.right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
      label143: label174: label348: label357: label490: for (int m = 1; ; m = 0)
      {
        TypedValue localTypedValue2;
        int i5;
        if (k == -2147483648)
        {
          if (i == 0)
            break label388;
          localTypedValue2 = this.mFixedHeightMajor;
          if ((localTypedValue2 != null) && (localTypedValue2.type != 0))
          {
            if (localTypedValue2.type != 5)
              break label397;
            i5 = (int)localTypedValue2.getDimension(localDisplayMetrics);
          }
        }
        while (true)
        {
          if (i5 > 0)
            paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i5 - (this.mDecorPadding.top + this.mDecorPadding.bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          super.onMeasure(paramInt1, paramInt2);
          int n = getMeasuredWidth();
          int i1 = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
          TypedValue localTypedValue1;
          label254: int i4;
          if ((m == 0) && (j == -2147483648))
            if (i != 0)
            {
              localTypedValue1 = this.mMinWidthMinor;
              if ((localTypedValue1 == null) || (localTypedValue1.type == 0))
                break label468;
              if (localTypedValue1.type != 5)
                break label437;
              i4 = (int)localTypedValue1.getDimension(localDisplayMetrics);
            }
          while (true)
          {
            if (i4 > 0)
              i4 -= this.mDecorPadding.left + this.mDecorPadding.right;
            int i2;
            if (n < i4)
              i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            for (int i3 = 1; ; i3 = 0)
            {
              if (i3 != 0)
                super.onMeasure(i2, paramInt2);
              return;
              i = 0;
              break;
              localTypedValue3 = this.mFixedWidthMajor;
              break label55;
              if (localTypedValue3.type != 6)
                break label496;
              i6 = (int)localTypedValue3.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label86;
              localTypedValue2 = this.mFixedHeightMinor;
              break label143;
              if (localTypedValue2.type != 6)
                break label484;
              i5 = (int)localTypedValue2.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
              break label174;
              localTypedValue1 = this.mMinWidthMajor;
              break label254;
              if (localTypedValue1.type != 6)
                break label478;
              i4 = (int)localTypedValue1.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label285;
              i2 = i1;
            }
            i4 = 0;
          }
          i5 = 0;
        }
      }
      label285: label437: label468: label478: label484: label496: i6 = 0;
    }
  }

  public void setAttachListener(OnAttachListener paramOnAttachListener)
  {
    this.mAttachListener = paramOnAttachListener;
  }

  public void setDecorPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mDecorPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (ViewCompat.isLaidOut(this))
      requestLayout();
  }

  public static abstract interface OnAttachListener
  {
    public abstract void onAttachedFromWindow();

    public abstract void onDetachedFromWindow();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ContentFrameLayout
 * JD-Core Version:    0.6.2
 */