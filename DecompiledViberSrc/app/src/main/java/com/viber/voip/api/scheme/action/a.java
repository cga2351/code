package com.viber.voip.api.scheme.action;

import com.viber.voip.invitelinks.d;
import com.viber.voip.invitelinks.d.b;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class a extends g
{
  private final d h;
  private final a i;

  public a(String paramString, d paramd, EventBus paramEventBus, a parama)
  {
    super(paramString, paramEventBus);
    this.h = paramd;
    this.i = parama;
  }

  protected void a()
  {
    this.h.a(this.f);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onAcceptGroupInvite(final d.b paramb)
  {
    a(new g.a()
    {
      public String a()
      {
        return paramb.h;
      }

      public void b()
      {
        a.a(a.this).a(paramb);
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a(d.b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.a
 * JD-Core Version:    0.6.2
 */