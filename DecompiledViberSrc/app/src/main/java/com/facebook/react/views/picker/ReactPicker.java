package com.facebook.react.views.picker;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.facebook.react.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

public class ReactPicker extends AppCompatSpinner
{
  private final AdapterView.OnItemSelectedListener mItemSelectedListener = new AdapterView.OnItemSelectedListener()
  {
    public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (ReactPicker.this.mOnSelectListener != null)
        ReactPicker.this.mOnSelectListener.onItemSelected(paramAnonymousInt);
    }

    public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
    {
      if (ReactPicker.this.mOnSelectListener != null)
        ReactPicker.this.mOnSelectListener.onItemSelected(-1);
    }
  };
  private int mMode = 0;

  @Nullable
  private OnSelectListener mOnSelectListener;

  @Nullable
  private Integer mPrimaryColor;

  @Nullable
  private Integer mStagedSelection;
  private final Runnable measureAndLayout = new Runnable()
  {
    public void run()
    {
      ReactPicker.this.measure(View.MeasureSpec.makeMeasureSpec(ReactPicker.this.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ReactPicker.this.getHeight(), 1073741824));
      ReactPicker.this.layout(ReactPicker.this.getLeft(), ReactPicker.this.getTop(), ReactPicker.this.getRight(), ReactPicker.this.getBottom());
    }
  };

  public ReactPicker(Context paramContext)
  {
    super(paramContext);
  }

  public ReactPicker(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mMode = paramInt;
  }

  public ReactPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ReactPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public ReactPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.mMode = paramInt2;
  }

  private void setSelectionWithSuppressEvent(int paramInt)
  {
    if (paramInt != getSelectedItemPosition())
    {
      setOnItemSelectedListener(null);
      setSelection(paramInt, false);
      setOnItemSelectedListener(this.mItemSelectedListener);
    }
  }

  @VisibleForTesting
  public int getMode()
  {
    return this.mMode;
  }

  @Nullable
  public OnSelectListener getOnSelectListener()
  {
    return this.mOnSelectListener;
  }

  @Nullable
  public Integer getPrimaryColor()
  {
    return this.mPrimaryColor;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (getOnItemSelectedListener() == null)
      setOnItemSelectedListener(this.mItemSelectedListener);
  }

  public void requestLayout()
  {
    super.requestLayout();
    post(this.measureAndLayout);
  }

  public void setOnSelectListener(@Nullable OnSelectListener paramOnSelectListener)
  {
    this.mOnSelectListener = paramOnSelectListener;
  }

  public void setPrimaryColor(@Nullable Integer paramInteger)
  {
    this.mPrimaryColor = paramInteger;
  }

  public void setStagedSelection(int paramInt)
  {
    this.mStagedSelection = Integer.valueOf(paramInt);
  }

  public void updateStagedSelection()
  {
    if (this.mStagedSelection != null)
    {
      setSelectionWithSuppressEvent(this.mStagedSelection.intValue());
      this.mStagedSelection = null;
    }
  }

  public static abstract interface OnSelectListener
  {
    public abstract void onItemSelected(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.picker.ReactPicker
 * JD-Core Version:    0.6.2
 */