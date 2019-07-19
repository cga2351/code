package com.viber.voip.contacts.c.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.n;
import com.viber.voip.contacts.c.d.n.a;
import com.viber.voip.settings.d.q;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
  implements n
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile a b;
  private Set<n.a> c = Collections.synchronizedSet(new HashSet());

  private a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.voip.viber.contacts.vibersync", 0);
    if (!d.q.c.a())
    {
      d.q.c.a(localSharedPreferences.getInt(d.q.c.c(), 100));
      d.q.b.a(localSharedPreferences.getInt(d.q.b.c(), -1));
      d.q.a.a(localSharedPreferences.getInt(d.q.a.c(), -1));
      d.q.d.a(localSharedPreferences.getInt(d.q.d.c(), 0));
    }
  }

  public static a a(Context paramContext)
  {
    if (b == null)
      b = new a(paramContext);
    return b;
  }

  public void a(int paramInt)
  {
    while (true)
    {
      int i;
      try
      {
        i = d();
        if ((i == 0) && (paramInt == 1))
        {
          e(paramInt);
          d.q.d.a(paramInt);
          return;
        }
      }
      finally
      {
      }
      if (((i != 0) && (i != 1) && (i != 3)) || ((paramInt != 2) && (((i != 0) && (i != 1) && (i != 2)) || (paramInt != 3))))
        if ((i == 4) || (paramInt != 4));
    }
  }

  public void a(n.a parama)
  {
    synchronized (this.c)
    {
      this.c.add(parama);
      parama.onSyncStateChanged(d(), true);
      return;
    }
  }

  public boolean a()
  {
    return d() != 4;
  }

  public void b()
  {
    try
    {
      e();
      e(d());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(int paramInt)
  {
    d.q.a.a(paramInt);
  }

  public void b(n.a parama)
  {
    synchronized (this.c)
    {
      this.c.remove(parama);
      return;
    }
  }

  public int c()
  {
    return d.q.c.d();
  }

  public void c(int paramInt)
  {
    d.q.b.a(paramInt);
  }

  public int d()
  {
    try
    {
      if (d.q.d.a())
      {
        int j = d.q.d.d();
        i = j;
        return i;
      }
      int i = 0;
    }
    finally
    {
    }
  }

  public void d(int paramInt)
  {
    d.q.c.a(paramInt);
  }

  public void e()
  {
    d.q.d.a(0);
    d.q.b.a(-1);
    d.q.a.a(-1);
    d.q.c.a(101);
  }

  public void e(int paramInt)
  {
    synchronized (this.c)
    {
      HashSet localHashSet = new HashSet(this.c);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((n.a)localIterator.next()).onSyncStateChanged(paramInt, false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.a
 * JD-Core Version:    0.6.2
 */