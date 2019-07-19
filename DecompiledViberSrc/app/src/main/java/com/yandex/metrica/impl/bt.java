package com.yandex.metrica.impl;

import com.yandex.metrica.impl.ob.fy;
import com.yandex.metrica.impl.ob.oq;
import java.util.HashSet;

public class bt
{
  private final a a;
  private Boolean b;
  private final HashSet<String> c = new HashSet();
  private final HashSet<String> d = new HashSet();

  public bt(a parama)
  {
    this.a = parama;
    this.b = this.a.a();
  }

  private boolean e()
  {
    if (this.b == null)
      return (!this.c.isEmpty()) || (this.d.isEmpty());
    return this.b.booleanValue();
  }

  public void a(Boolean paramBoolean)
  {
    try
    {
      this.b = Boolean.valueOf(Boolean.FALSE.equals(paramBoolean));
      this.a.a(this.b.booleanValue());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String paramString, Boolean paramBoolean)
  {
    try
    {
      if (oq.a(paramBoolean, true))
      {
        this.d.add(paramString);
        this.c.remove(paramString);
      }
      while (true)
      {
        return;
        this.c.add(paramString);
        this.d.remove(paramString);
      }
    }
    finally
    {
    }
  }

  public boolean a()
  {
    try
    {
      boolean bool2;
      if (this.b == null)
        if (this.d.isEmpty())
        {
          boolean bool3 = this.c.isEmpty();
          if (bool3)
            bool2 = true;
        }
      while (true)
      {
        return bool2;
        bool2 = false;
        continue;
        boolean bool1 = this.b.booleanValue();
        bool2 = bool1;
      }
    }
    finally
    {
    }
  }

  public boolean b()
  {
    try
    {
      boolean bool3;
      if (this.b == null)
        bool3 = this.d.isEmpty();
      boolean bool1;
      for (boolean bool2 = bool3; ; bool2 = bool1)
      {
        return bool2;
        bool1 = this.b.booleanValue();
      }
    }
    finally
    {
    }
  }

  public boolean c()
  {
    try
    {
      boolean bool = e();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean d()
  {
    try
    {
      boolean bool = e();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static abstract interface a
  {
    public abstract Boolean a();

    public abstract void a(boolean paramBoolean);
  }

  public static class b
    implements bt.a
  {
    private final fy a;

    public b(fy paramfy)
    {
      this.a = paramfy;
    }

    public Boolean a()
    {
      return this.a.j();
    }

    public void a(boolean paramBoolean)
    {
      this.a.d(paramBoolean).i();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bt
 * JD-Core Version:    0.6.2
 */