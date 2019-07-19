package com.viber.voip.b.a;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.b.a.a.b;
import com.viber.voip.b.a.a.f;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.viber.voip.b.d
{
  private static final Logger a = ViberEnv.getLogger();
  private long b;
  private long c = -1L;
  private final Map<com.viber.voip.b.a, com.viber.voip.b.c> d = new ConcurrentHashMap(com.viber.voip.b.a.values().length, 1.0F);
  private Runnable e = new Runnable()
  {
    public void run()
    {
      a.this.a();
    }
  };

  public a()
  {
    com.viber.voip.util.d.c(new d.b()
    {
      public void onAppStopped()
      {
        i.c(this);
      }

      public void onBackground()
      {
        av.a(av.e.g).postDelayed(a.a(a.this), 300000L);
      }

      public void onForeground()
      {
        av.a(av.e.g).removeCallbacks(a.a(a.this));
      }

      public void onForegroundStateChanged(boolean paramAnonymousBoolean)
      {
        i.a(this, paramAnonymousBoolean);
      }
    });
  }

  private static boolean a(com.viber.voip.b.a parama, com.viber.voip.b.a[] paramArrayOfa)
  {
    if ((paramArrayOfa == null) || (parama == null));
    while (true)
    {
      return false;
      int i = paramArrayOfa.length;
      for (int j = 0; j < i; j++)
        if (paramArrayOfa[j] == parama)
          return true;
    }
  }

  public com.viber.voip.b.c a(com.viber.voip.b.a parama)
  {
    com.viber.voip.b.c localc1 = (com.viber.voip.b.c)this.d.get(parama);
    if (localc1 == null)
      try
      {
        com.viber.voip.b.c localc2 = (com.viber.voip.b.c)this.d.get(parama);
        if (localc2 == null)
        {
          localc2 = b(parama);
          this.d.put(parama, localc2);
        }
        return localc2;
      }
      finally
      {
      }
    return localc1;
  }

  public void a()
  {
    synchronized (this.d)
    {
      Iterator localIterator = this.d.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getKey() != com.viber.voip.b.a.c)
        {
          com.viber.voip.b.c localc = (com.viber.voip.b.c)localEntry.getValue();
          if (localc != null)
            localc.evictAll();
        }
      }
    }
    System.gc();
  }

  public void a(float paramFloat, com.viber.voip.b.a[] paramArrayOfa)
  {
    synchronized (this.d)
    {
      Iterator localIterator = this.d.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!a((com.viber.voip.b.a)localEntry.getKey(), paramArrayOfa))
        {
          com.viber.voip.b.c localc = (com.viber.voip.b.c)localEntry.getValue();
          localc.trimToSize((int)(paramFloat * localc.size()));
        }
      }
    }
    System.gc();
  }

  public void a(int paramInt)
  {
    if ((paramInt == this.c) && (System.currentTimeMillis() - this.b < 60000L))
      return;
    if (paramInt <= 5)
    {
      com.viber.voip.b.a[] arrayOfa6 = new com.viber.voip.b.a[3];
      arrayOfa6[0] = com.viber.voip.b.a.g;
      arrayOfa6[1] = com.viber.voip.b.a.e;
      arrayOfa6[2] = com.viber.voip.b.a.c;
      a(0.85F, arrayOfa6);
    }
    while (true)
    {
      this.c = paramInt;
      this.b = System.currentTimeMillis();
      return;
      if (paramInt <= 10)
      {
        com.viber.voip.b.a[] arrayOfa5 = new com.viber.voip.b.a[2];
        arrayOfa5[0] = com.viber.voip.b.a.g;
        arrayOfa5[1] = com.viber.voip.b.a.c;
        a(0.7F, arrayOfa5);
      }
      else if (paramInt <= 15)
      {
        com.viber.voip.b.a[] arrayOfa4 = new com.viber.voip.b.a[2];
        arrayOfa4[0] = com.viber.voip.b.a.g;
        arrayOfa4[1] = com.viber.voip.b.a.c;
        a(0.3F, arrayOfa4);
      }
      else if (paramInt <= 20)
      {
        com.viber.voip.b.a[] arrayOfa3 = new com.viber.voip.b.a[3];
        arrayOfa3[0] = com.viber.voip.b.a.g;
        arrayOfa3[1] = com.viber.voip.b.a.i;
        arrayOfa3[2] = com.viber.voip.b.a.c;
        a(0.7F, arrayOfa3);
      }
      else if (paramInt <= 40)
      {
        com.viber.voip.b.a[] arrayOfa2 = new com.viber.voip.b.a[1];
        arrayOfa2[0] = com.viber.voip.b.a.c;
        a(0.4F, arrayOfa2);
      }
      else if (paramInt <= 60)
      {
        com.viber.voip.b.a[] arrayOfa1 = new com.viber.voip.b.a[1];
        arrayOfa1[0] = com.viber.voip.b.a.c;
        a(0.3F, arrayOfa1);
      }
      else if (paramInt <= 80)
      {
        b();
      }
      else
      {
        a();
      }
    }
  }

  public com.viber.voip.b.c b(com.viber.voip.b.a parama)
  {
    switch (3.a[parama.ordinal()])
    {
    default:
      return null;
    case 1:
      return new com.viber.voip.b.a.a.a(parama);
    case 2:
      return new com.viber.voip.b.a.a.a(parama);
    case 3:
      return new com.viber.voip.b.a.a.a(parama);
    case 4:
      return new com.viber.voip.b.a.a.a.e(parama);
    case 5:
      return new com.viber.voip.b.a.a.a.c(parama.toString());
    case 6:
      return new com.viber.voip.b.a.a.a.a(parama);
    case 7:
      return new f(parama.toString());
    case 8:
      return new com.viber.voip.b.a.a.c(parama.toString());
    case 9:
      return new com.viber.voip.b.a.a.e(parama.toString());
    case 10:
      return new b(parama);
    case 11:
      return new com.viber.voip.b.a.a.a(parama);
    case 12:
    }
    return new com.viber.voip.b.a.a.d(parama.toString(), aj.b());
  }

  public void b()
  {
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.a.a
 * JD-Core Version:    0.6.2
 */