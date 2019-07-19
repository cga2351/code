package com.viber.voip.ui.doodle.a.a;

import android.view.MotionEvent;

public class a
  implements b
{
  private final b a;
  private final a b;
  private boolean c;

  public a(b paramb, a parama)
  {
    this.a = paramb;
    this.b = parama;
  }

  public boolean a()
  {
    return this.c;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (1 == i)
    {
      this.a.b(this, this.c);
      if (this.b != null)
        this.b.b(this, this.c);
      this.c = false;
    }
    boolean bool;
    do
    {
      return true;
      bool = this.a.a(f1, f2);
      if (this.c == bool)
        break;
      this.c = bool;
      this.a.a(this, bool);
    }
    while (this.b == null);
    this.b.a(this, bool);
    return true;
    return false;
  }

  public static abstract interface a
  {
    public abstract void a(a parama, boolean paramBoolean);

    public abstract void b(a parama, boolean paramBoolean);
  }

  public static abstract interface b extends a.a
  {
    public abstract boolean a(float paramFloat1, float paramFloat2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.a.a.a
 * JD-Core Version:    0.6.2
 */