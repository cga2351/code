package com.viber.voip.api.scheme.action;

import android.content.Context;
import com.viber.voip.av.f;
import com.viber.voip.messages.controller.manager.ab;
import java.util.concurrent.ScheduledExecutorService;

public class j extends f
{
  private ab f;

  public j(ab paramab)
  {
    this.f = paramab;
  }

  public void a(Context paramContext, c.a parama)
  {
    av.f.d.execute(new k(this, paramContext, parama));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.j
 * JD-Core Version:    0.6.2
 */