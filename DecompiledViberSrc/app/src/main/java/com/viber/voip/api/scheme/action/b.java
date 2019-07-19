package com.viber.voip.api.scheme.action;

import com.viber.voip.invitelinks.n;
import com.viber.voip.invitelinks.n.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class b extends g
{
  private final n h;
  private final a i;

  public b(String paramString, n paramn, EventBus paramEventBus, a parama)
  {
    super(paramString, paramEventBus);
    this.h = paramn;
    this.i = parama;
  }

  protected void a()
  {
    this.h.a(this.f);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onAcceptGroupInvite(final n.a parama)
  {
    a(new g.a()
    {
      public String a()
      {
        return parama.c;
      }

      public void b()
      {
        b.a(b.this).a(parama.a, parama.b);
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.b
 * JD-Core Version:    0.6.2
 */