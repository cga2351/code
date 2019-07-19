package com.viber.voip.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;

public class SpinnerWithDescription extends ViewWithDescription
{
  private Spinner e;

  public SpinnerWithDescription(Context paramContext)
  {
    super(paramContext);
  }

  public SpinnerWithDescription(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SpinnerWithDescription(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected View b(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.e = new Spinner(paramContext);
    Drawable localDrawable = df.a(ContextCompat.getDrawable(paramContext, R.drawable.spinner_with_desc_background), dc.d(paramContext, R.attr.spinnerWithDescriptionTint), true);
    this.e.setBackground(localDrawable);
    return this.e;
  }

  public Object getSelectedItem()
  {
    return this.e.getSelectedItem();
  }

  public int getSelectedItemPosition()
  {
    return this.e.getSelectedItemPosition();
  }

  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    this.e.setAdapter(paramSpinnerAdapter);
  }

  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.e.setOnItemClickListener(paramOnItemClickListener);
  }

  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.e.setOnItemLongClickListener(paramOnItemLongClickListener);
  }

  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.e.setOnItemSelectedListener(paramOnItemSelectedListener);
  }

  public void setSelection(int paramInt)
  {
    this.e.setSelection(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.SpinnerWithDescription
 * JD-Core Version:    0.6.2
 */