package com.viber.voip.messages.extensions;

import com.viber.common.b.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.n;
import java.util.concurrent.TimeUnit;

public class i
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.DAYS.toMillis(7L);

  @Deprecated
  public static i a()
  {
    return a.a();
  }

  public boolean b()
  {
    return System.currentTimeMillis() - d.n.i.d() <= b;
  }

  public void c()
  {
    d.n.i.a(0L);
  }

  public void d()
  {
    d.n.i.a(System.currentTimeMillis());
  }

  private static class a
  {
    private static final i a = new i(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.i
 * JD-Core Version:    0.6.2
 */