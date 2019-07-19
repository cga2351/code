package com.viber.voip.report.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.a.a.a;
import com.viber.voip.api.a.a.a.d;
import com.viber.voip.report.a.a.e;
import com.viber.voip.report.a.a.f;
import g.l;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private final a b;
  private final boolean c;

  public b(a parama, boolean paramBoolean)
  {
    this.b = parama;
    this.c = paramBoolean;
  }

  public void a(long paramLong1, long paramLong2, String paramString1, e parame, String paramString2, a parama)
  {
    try
    {
      f localf = new f(paramLong1, paramLong2, paramString1, parame, paramString2, this.c);
      l locall = this.b.a(localf.a()).a();
      if (locall.a())
      {
        d locald = (d)locall.b();
        if ((locald != null) && (locald.a() > 0L))
        {
          parama.a(paramLong1, locald);
          return;
        }
      }
      parama.a(paramLong1);
      return;
    }
    catch (Throwable localThrowable)
    {
      parama.a(paramLong1);
    }
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong);

    public abstract void a(long paramLong, d paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.report.a.b
 * JD-Core Version:    0.6.2
 */