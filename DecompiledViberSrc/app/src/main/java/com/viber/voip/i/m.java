package com.viber.voip.i;

import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.f.a;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.a.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class m extends k
{
  private static ArrayList<m> l = new ArrayList();
  protected final e j = ViberEnv.getLogger("WasabiFeatureSwitcher");
  private final a.b k;

  m(a.b paramb, String paramString, d[] paramArrayOfd)
  {
    super(paramb.a(), paramString, paramArrayOfd);
    this.k = paramb;
    this.g = g();
    synchronized (l)
    {
      l.add(this);
      return;
    }
  }

  m(a.b paramb, d[] paramArrayOfd)
  {
    this(paramb, "WASABI: " + paramb.a(), paramArrayOfd);
  }

  private int a(a.b paramb)
  {
    if (g.a().b(paramb));
    for (boolean bool = g.a().a(paramb); bool; bool = C_())
      return 1;
    return 0;
  }

  public static void p()
  {
    synchronized (l)
    {
      Iterator localIterator = l.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          m localm = (m)localIterator.next();
          try
          {
            localm.m();
          }
          catch (Throwable localThrowable)
          {
            com.crashlytics.android.a.m localm1 = new com.crashlytics.android.a.m("WasabiFeatureSwitcher.invalidateStates error");
            localm1.a("sInstances", Arrays.toString(l.toArray()));
            localm1.a("message", localThrowable.getMessage());
            a.a(localm1);
          }
        }
    }
  }

  protected boolean C_()
  {
    return false;
  }

  public void a(int paramInt)
  {
    m();
  }

  protected int o()
  {
    if (this.k != null)
      return a(this.k);
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.i.m
 * JD-Core Version:    0.6.2
 */