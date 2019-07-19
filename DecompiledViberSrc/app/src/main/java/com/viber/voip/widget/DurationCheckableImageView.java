package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.viber.voip.gallery.selection.x;

public class DurationCheckableImageView extends CheckableImageView
{
  protected x a;

  public DurationCheckableImageView(Context paramContext)
  {
    super(paramContext);
  }

  public DurationCheckableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public DurationCheckableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected x a(Context paramContext)
  {
    return new x(paramContext);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    this.a = a(paramContext);
  }

  public void setDuration(long paramLong)
  {
    this.a.a(paramLong);
    a(this.a, 9, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.DurationCheckableImageView
 * JD-Core Version:    0.6.2
 */