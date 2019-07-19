package com.viber.voip.ui.doodle.pickers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.Checkable;
import com.viber.voip.util.v;

class c extends a
  implements Checkable
{
  private static final int[] e = { 16842919 };
  private static final int[] f = { 16842912 };
  private b g;
  private boolean h;

  public c(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1, paramInt2, paramInt3);
  }

  private static int c(int paramInt)
  {
    if (v.a(paramInt) >= 0.05F);
    for (int i = 1291845632; ; i = 1308622847)
      return v.a(paramInt, i);
  }

  protected Drawable a()
  {
    this.d = new b(this.a, this.b, this.c);
    this.g = new b(this.a, this.b, c(this.c));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(e, this.g);
    localStateListDrawable.addState(f, this.g);
    localStateListDrawable.addState(new int[0], this.d);
    return localStateListDrawable;
  }

  public void a(int paramInt)
  {
    super.a(paramInt);
    this.g.b(c(this.c));
  }

  public void b(int paramInt)
  {
    super.b(paramInt);
    this.g.a(paramInt);
  }

  public boolean isChecked()
  {
    return this.h;
  }

  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked())
      mergeDrawableStates(arrayOfInt, f);
    return arrayOfInt;
  }

  public void setChecked(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      refreshDrawableState();
    }
  }

  public void toggle()
  {
    if (!this.h);
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.pickers.c
 * JD-Core Version:    0.6.2
 */