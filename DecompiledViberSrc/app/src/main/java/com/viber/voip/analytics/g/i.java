package com.viber.voip.analytics.g;

import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.bn;

public class i
{
  private static final com.viber.common.a.e b = ViberEnv.getLogger();
  a a;

  public i(a parama)
  {
    this.a = parama;
  }

  private boolean b(long paramLong)
  {
    return this.a.b(paramLong);
  }

  public boolean a(long paramLong)
  {
    return b(paramLong);
  }

  public static class a
  {
    private final com.viber.common.b.e a;

    public a(com.viber.common.b.e parame)
    {
      this.a = parame;
    }

    public void a(long paramLong)
    {
      this.a.a(paramLong);
    }

    public boolean b(long paramLong)
    {
      long l = paramLong - 1000L * d.bn.b.d();
      return this.a.d() < l;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.g.i
 * JD-Core Version:    0.6.2
 */