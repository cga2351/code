package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.R.styleable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class PreferenceImageView extends ImageView
{
  private int mMaxHeight = 2147483647;
  private int mMaxWidth = 2147483647;

  public PreferenceImageView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PreferenceImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PreferenceImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PreferenceImageView, paramInt, 0);
    setMaxWidth(localTypedArray.getDimensionPixelSize(R.styleable.PreferenceImageView_maxWidth, 2147483647));
    setMaxHeight(localTypedArray.getDimensionPixelSize(R.styleable.PreferenceImageView_maxHeight, 2147483647));
    localTypedArray.recycle();
  }

  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }

  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    if ((i == -2147483648) || (i == 0))
    {
      int j = View.MeasureSpec.getSize(paramInt1);
      int k = getMaxWidth();
      if ((k != 2147483647) && ((k < j) || (i == 0)))
        paramInt1 = View.MeasureSpec.makeMeasureSpec(k, -2147483648);
    }
    int m = View.MeasureSpec.getMode(paramInt2);
    if ((m == -2147483648) || (m == 0))
    {
      int n = View.MeasureSpec.getSize(paramInt2);
      int i1 = getMaxHeight();
      if ((i1 != 2147483647) && ((i1 < n) || (m == 0)))
        paramInt2 = View.MeasureSpec.makeMeasureSpec(i1, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }

  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
    super.setMaxHeight(paramInt);
  }

  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    super.setMaxWidth(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.PreferenceImageView
 * JD-Core Version:    0.6.2
 */