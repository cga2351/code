package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.ak.a;
import com.yandex.mobile.ads.impl.in;
import com.yandex.mobile.ads.impl.le;
import java.util.Iterator;
import java.util.List;

class l
  implements aq
{
  final al a;
  private final List<le> b;
  private String c;
  private af d;

  l(List<le> paramList, al paramal)
  {
    this.b = paramList;
    this.a = paramal;
  }

  private boolean a(aq.b paramb)
  {
    return (this.d != null) && (a(paramb, this.b));
  }

  public aq.a a()
  {
    int i;
    if (this.b != null)
    {
      Iterator localIterator = this.b.iterator();
      i = 0;
      if (!localIterator.hasNext())
        break label59;
      if (!((le)localIterator.next()).f())
        break label153;
    }
    label153: for (int m = i + 1; ; m = i)
    {
      i = m;
      break;
      i = 0;
      label59: int j;
      ak.a locala;
      if (i >= 2)
      {
        j = 1;
        int k = 0;
        if (j != 0)
        {
          boolean bool = b();
          k = 0;
          if (bool)
            k = 1;
        }
        if (k == 0)
          break label115;
        locala = ak.a.g;
      }
      while (true)
      {
        return new ap(locala, this.c);
        j = 0;
        break;
        label115: if (c())
          locala = ak.a.j;
        else if (d())
          locala = ak.a.d;
        else
          locala = ak.a.a;
      }
    }
  }

  public void a(af paramaf)
  {
    this.d = paramaf;
  }

  protected boolean a(aq.b paramb, List<le> paramList)
  {
    return (!this.a.b()) || ((paramList != null) && (paramb.a(paramList)));
  }

  public boolean b()
  {
    return !a(new aq.b()
    {
      public final boolean a(List<le> paramAnonymousList)
      {
        Iterator localIterator = paramAnonymousList.iterator();
        while (localIterator.hasNext())
        {
          le localle = (le)localIterator.next();
          if (localle.f())
          {
            in localin = l.a(l.this).a(localle);
            if ((localin != null) && (localin.d()))
              return true;
          }
        }
        return false;
      }
    });
  }

  public boolean c()
  {
    return !a(new aq.b()
    {
      public final boolean a(List<le> paramAnonymousList)
      {
        Iterator localIterator = paramAnonymousList.iterator();
        while (localIterator.hasNext())
        {
          le localle = (le)localIterator.next();
          if (localle.f())
          {
            in localin = l.a(l.this).a(localle);
            if ((localin == null) || (!localin.c()))
            {
              l.a(l.this, localle.a());
              return false;
            }
          }
        }
        return true;
      }
    });
  }

  public boolean d()
  {
    return !a(new aq.b()
    {
      public final boolean a(List<le> paramAnonymousList)
      {
        Iterator localIterator = paramAnonymousList.iterator();
        while (localIterator.hasNext())
        {
          le localle = (le)localIterator.next();
          if (localle.f())
          {
            in localin = l.a(l.this).a(localle);
            Object localObject = localle.c();
            if ((localin == null) || (!localin.b(localObject)))
            {
              l.a(l.this, localle.a());
              return false;
            }
          }
        }
        return true;
      }
    });
  }

  public boolean e()
  {
    return a(new aq.b()
    {
      public final boolean a(List<le> paramAnonymousList)
      {
        Iterator localIterator = paramAnonymousList.iterator();
        while (localIterator.hasNext())
        {
          le localle = (le)localIterator.next();
          if (localle.f())
          {
            in localin = l.a(l.this).a(localle);
            if ((localin == null) || (!localin.b()))
            {
              l.a(l.this, localle.a());
              return false;
            }
          }
        }
        return true;
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.l
 * JD-Core Version:    0.6.2
 */