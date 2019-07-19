package com.viber.voip.ui.doodle.pickers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.ImageView;

class a extends ImageView
{
  protected int a;
  protected int b;
  protected int c;
  protected b d;

  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    setImageDrawable(a());
  }

  protected Drawable a()
  {
    this.d = new b(this.a, this.b, this.c);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[0], this.d);
    return localStateListDrawable;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
    this.d.b(this.c);
  }

  public int b()
  {
    return this.b;
  }

  public void b(int paramInt)
  {
    this.b = paramInt;
    this.d.a(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.pickers.a
 * JD-Core Version:    0.6.2
 */