package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.viber.voip.gallery.selection.x;
import com.viber.voip.gallery.selection.y;

public class DurationWithIconCheckableImageView extends DurationCheckableImageView
{
  public DurationWithIconCheckableImageView(Context paramContext)
  {
    super(paramContext);
  }

  public DurationWithIconCheckableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public DurationWithIconCheckableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected x a(Context paramContext)
  {
    return new y(paramContext);
  }

  public void setDuration(long paramLong)
  {
    this.a.a(paramLong);
    a(this.a, 4, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.DurationWithIconCheckableImageView
 * JD-Core Version:    0.6.2
 */