package com.viber.voip.messages.controller;

import com.viber.dexshared.Logger;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.a.k;
import org.greenrobot.eventbus.EventBus;

public class cg
  implements ConnectionDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private int b = 0;
  private final com.viber.voip.util.i.e c;
  private final com.viber.common.b.e d;
  private final ch e;
  private final EventBus f;

  public cg(ch paramch, com.viber.voip.util.i.e parame, com.viber.common.b.e parame1, EventBus paramEventBus)
  {
    this.c = parame;
    this.d = parame1;
    this.e = paramch;
    this.f = paramEventBus;
  }

  private void a()
  {
    this.f.post(new k());
  }

  public void onConnect()
  {
  }

  public void onConnectionStateChange(int paramInt)
  {
    if (this.b == paramInt)
      return;
    if (paramInt == 3)
    {
      long l = this.c.a();
      if ((this.d.d() > 0L) && (l - this.d.d() > this.e.a()))
        a();
      this.d.a(l);
    }
    while (true)
    {
      this.b = paramInt;
      return;
      if (this.b == 3)
        this.d.a(this.c.a());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.cg
 * JD-Core Version:    0.6.2
 */