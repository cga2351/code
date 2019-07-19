package com.viber.voip.widget.dslv;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;

public class c extends b
  implements Checkable
{
  public c(Context paramContext)
  {
    super(paramContext);
  }

  public boolean isChecked()
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable))
      return ((Checkable)localView).isChecked();
    return false;
  }

  public void setChecked(boolean paramBoolean)
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable))
      ((Checkable)localView).setChecked(paramBoolean);
  }

  public void toggle()
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable))
      ((Checkable)localView).toggle();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.dslv.c
 * JD-Core Version:    0.6.2
 */