package com.viber.voip.schedule;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.util.i.e;

public class b
  implements f
{
  private static final Logger a = ViberEnv.getLogger();
  private final bs b;
  private final long c;
  private final e d;

  public b(bs parambs, long paramLong, e parame)
  {
    this.b = parambs;
    this.c = paramLong;
    this.d = parame;
  }

  public int a(Bundle paramBundle)
  {
    long l = this.d.a() - this.c;
    try
    {
      this.b.g(l);
      return 0;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
    return 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.b
 * JD-Core Version:    0.6.2
 */