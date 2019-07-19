package com.viber.voip.backup.auto;

import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.a;
import com.viber.voip.backup.g;

public class c
{
  private static final e a = ViberEnv.getLogger();
  private final g b;
  private final b c;
  private final d d;

  public c(g paramg, b paramb, d paramd)
  {
    this.b = paramg;
    this.c = paramb;
    this.d = paramd;
  }

  private boolean a()
  {
    switch (this.b.c())
    {
    default:
      this.d.a();
      return false;
    case 1:
      this.d.b();
      return false;
    case 0:
    }
    return true;
  }

  private boolean a(long paramLong)
  {
    return !this.c.b(paramLong);
  }

  private boolean a(a parama)
  {
    return parama.b();
  }

  public boolean a(a parama, long paramLong)
  {
    return (a(parama)) && (a(paramLong)) && (a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.auto.c
 * JD-Core Version:    0.6.2
 */