package com.viber.voip.api.scheme.action;

import android.content.Context;
import org.greenrobot.eventbus.EventBus;

public abstract class g extends f
{
  protected final String f;
  protected final EventBus g;
  private c.a h;

  public g(String paramString, EventBus paramEventBus)
  {
    this.f = paramString;
    this.g = paramEventBus;
  }

  protected abstract void a();

  public void a(Context paramContext, c.a parama)
  {
    this.h = parama;
    if (!this.g.isRegistered(this))
      this.g.register(this);
    a();
  }

  protected final void a(a parama)
  {
    if (!this.f.equals(parama.a()));
    do
    {
      return;
      this.g.unregister(this);
      parama.b();
    }
    while (this.h == null);
    this.h.b();
  }

  protected static abstract interface a
  {
    public abstract String a();

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.g
 * JD-Core Version:    0.6.2
 */