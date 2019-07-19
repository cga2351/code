package com.viber.voip.widget;

import android.graphics.drawable.Drawable.Callback;
import pl.droidsonroids.gif.b;
import pl.droidsonroids.gif.k;

public class h
{
  private final a a;
  private b b;
  private k c;

  public h(a parama)
  {
    this.a = parama;
  }

  public void a(b paramb)
  {
    if (paramb == this.b)
      return;
    b localb = this.b;
    k localk = this.c;
    Drawable.Callback localCallback;
    if (paramb != null)
    {
      localCallback = paramb.getCallback();
      this.a.a(paramb);
      if ((localb != null) && (localk != null))
      {
        localk.b(this.a.a());
        localb.setCallback(localk);
      }
      this.b = paramb;
      if (this.b == null)
        break label162;
      if (!(localCallback instanceof k))
        break label128;
      this.c = ((k)localCallback);
    }
    while (true)
    {
      this.c.a(this.a.a());
      this.b.setCallback(this.c);
      return;
      localCallback = null;
      break;
      label128: this.c = new k();
      if ((localCallback != null) && (localCallback != this))
        this.c.a(localCallback);
    }
    label162: this.c = null;
  }

  public static abstract interface a
  {
    public abstract Drawable.Callback a();

    public abstract void a(b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.h
 * JD-Core Version:    0.6.2
 */