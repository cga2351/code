package com.yandex.metrica.impl;

import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.or;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class al
  implements am
{
  private final or<String, Integer> a = new or();
  private final Map<b, a> b = new LinkedHashMap();
  private final Map<b, a> c = new LinkedHashMap();

  private static void a(Intent paramIntent, Map<b, a> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((a)localEntry.getValue()).a(paramIntent))
        ((b)localEntry.getKey()).a();
    }
  }

  private static boolean a(int paramInt)
  {
    return paramInt == Process.myPid();
  }

  private a d()
  {
    return new a()
    {
      public boolean a(Intent paramAnonymousIntent)
      {
        return "com.yandex.metrica.ACTION_C_BG_L".equals(paramAnonymousIntent.getAction());
      }
    };
  }

  private int e()
  {
    Collection localCollection = this.a.a("com.yandex.metrica.IMetricaService");
    int i;
    if (!bw.a(localCollection))
    {
      Iterator localIterator = localCollection.iterator();
      i = 0;
      if (!localIterator.hasNext())
        break label66;
      if (a(((Integer)localIterator.next()).intValue()))
        break label68;
    }
    label66: label68: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      i = 0;
      return i;
    }
  }

  private void e(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (!TextUtils.isEmpty(str))
      this.a.a(str, Integer.valueOf(g(paramIntent)));
    a(paramIntent, this.b);
  }

  private static boolean f(Intent paramIntent)
  {
    boolean bool1 = "com.yandex.metrica.IMetricaService".equals(paramIntent.getAction());
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = a(g(paramIntent));
      bool2 = false;
      if (!bool3)
        bool2 = true;
    }
    return bool2;
  }

  private static int g(Intent paramIntent)
  {
    int i = -1;
    Uri localUri = paramIntent.getData();
    if ((localUri != null) && (localUri.getPath().equals("/client")));
    try
    {
      int j = Integer.parseInt(localUri.getQueryParameter("pid"));
      i = j;
      return i;
    }
    catch (Exception localException)
    {
    }
    return i;
  }

  public void a()
  {
  }

  public void a(Intent paramIntent)
  {
    if (paramIntent != null)
      e(paramIntent);
  }

  public void a(Intent paramIntent, int paramInt)
  {
  }

  public void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
  }

  public void a(b paramb)
  {
    this.b.put(paramb, d());
  }

  public void b()
  {
  }

  public void b(Intent paramIntent)
  {
    if (paramIntent != null)
      e(paramIntent);
  }

  public void b(b paramb)
  {
    this.c.put(paramb, d());
  }

  public void c(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getAction();
      if (!TextUtils.isEmpty(str))
        this.a.b(str, Integer.valueOf(g(paramIntent)));
      a(paramIntent, this.c);
    }
  }

  public void c(b paramb)
  {
    this.b.put(paramb, new a()
    {
      public boolean a(Intent paramAnonymousIntent)
      {
        return al.a(al.this, paramAnonymousIntent);
      }
    });
  }

  public boolean c()
  {
    return !bw.a(this.a.a("com.yandex.metrica.ACTION_C_BG_L"));
  }

  public void d(b paramb)
  {
    this.b.put(paramb, new a()
    {
      public boolean a(Intent paramAnonymousIntent)
      {
        return al.d(paramAnonymousIntent);
      }
    });
  }

  public void e(b paramb)
  {
    this.c.put(paramb, new a()
    {
      public boolean a(Intent paramAnonymousIntent)
      {
        return (al.d(paramAnonymousIntent)) && (al.a(al.this));
      }
    });
  }

  static abstract interface a
  {
    public abstract boolean a(Intent paramIntent);
  }

  static abstract interface b
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.al
 * JD-Core Version:    0.6.2
 */