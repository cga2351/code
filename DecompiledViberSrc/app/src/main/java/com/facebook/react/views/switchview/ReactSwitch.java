package com.facebook.react.views.switchview;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.SwitchCompat;
import javax.annotation.Nullable;

class ReactSwitch extends SwitchCompat
{
  private boolean mAllowChange = true;

  @Nullable
  private Integer mTrackColorForFalse = null;

  @Nullable
  private Integer mTrackColorForTrue = null;

  public ReactSwitch(Context paramContext)
  {
    super(paramContext);
  }

  private void setTrackColor(boolean paramBoolean)
  {
    if ((this.mTrackColorForTrue != null) || (this.mTrackColorForFalse != null))
      if (!paramBoolean)
        break label29;
    label29: for (Integer localInteger = this.mTrackColorForTrue; ; localInteger = this.mTrackColorForFalse)
    {
      setTrackColor(localInteger);
      return;
    }
  }

  public void setChecked(boolean paramBoolean)
  {
    if ((this.mAllowChange) && (isChecked() != paramBoolean))
    {
      this.mAllowChange = false;
      super.setChecked(paramBoolean);
      setTrackColor(paramBoolean);
    }
  }

  void setColor(Drawable paramDrawable, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramDrawable.clearColorFilter();
      return;
    }
    paramDrawable.setColorFilter(paramInteger.intValue(), PorterDuff.Mode.MULTIPLY);
  }

  void setOn(boolean paramBoolean)
  {
    if (isChecked() != paramBoolean)
    {
      super.setChecked(paramBoolean);
      setTrackColor(paramBoolean);
    }
    this.mAllowChange = true;
  }

  public void setThumbColor(@Nullable Integer paramInteger)
  {
    setColor(super.getThumbDrawable(), paramInteger);
  }

  public void setTrackColor(@Nullable Integer paramInteger)
  {
    setColor(super.getTrackDrawable(), paramInteger);
  }

  public void setTrackColorForFalse(@Nullable Integer paramInteger)
  {
    if (paramInteger == this.mTrackColorForFalse);
    do
    {
      return;
      this.mTrackColorForFalse = paramInteger;
    }
    while (isChecked());
    setTrackColor(this.mTrackColorForFalse);
  }

  public void setTrackColorForTrue(@Nullable Integer paramInteger)
  {
    if (paramInteger == this.mTrackColorForTrue);
    do
    {
      return;
      this.mTrackColorForTrue = paramInteger;
    }
    while (!isChecked());
    setTrackColor(this.mTrackColorForTrue);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.switchview.ReactSwitch
 * JD-Core Version:    0.6.2
 */