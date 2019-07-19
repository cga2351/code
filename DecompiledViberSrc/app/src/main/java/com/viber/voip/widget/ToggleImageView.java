package com.viber.voip.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.Checkable;

public class ToggleImageView extends AppCompatImageView
  implements Checkable
{
  private static final int[] a = { 16842912 };
  private boolean b;

  public ToggleImageView(Context paramContext)
  {
    super(paramContext);
  }

  public ToggleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ToggleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean isChecked()
  {
    return this.b;
  }

  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.b)
      return mergeDrawableStates(super.onCreateDrawableState(paramInt + a.length), a);
    return super.onCreateDrawableState(paramInt);
  }

  public void setChecked(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      refreshDrawableState();
    }
  }

  public void toggle()
  {
    if (!this.b);
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ToggleImageView
 * JD-Core Version:    0.6.2
 */