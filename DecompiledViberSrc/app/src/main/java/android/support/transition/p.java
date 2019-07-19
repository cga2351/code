package android.support.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class p extends l
{
  int h;
  boolean i = false;
  private ArrayList<l> j = new ArrayList();
  private boolean k = true;
  private int l = 0;

  private void r()
  {
    a locala = new a(this);
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
      ((l)localIterator.next()).a(locala);
    this.h = this.j.size();
  }

  public p a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + paramInt);
    case 1:
      this.k = false;
      return this;
    case 0:
    }
    this.k = true;
    return this;
  }

  public p a(l paraml)
  {
    this.j.add(paraml);
    paraml.d = this;
    if (this.a >= 0L)
      paraml.a(this.a);
    if ((0x1 & this.l) != 0)
      paraml.a(d());
    if ((0x2 & this.l) != 0)
      paraml.a(n());
    if ((0x4 & this.l) != 0)
      paraml.a(l());
    if ((0x8 & this.l) != 0)
      paraml.a(m());
    return this;
  }

  String a(String paramString)
  {
    Object localObject = super.a(paramString);
    int m = 0;
    while (m < this.j.size())
    {
      String str = (String)localObject + "\n" + ((l)this.j.get(m)).a(new StringBuilder().append(paramString).append("  ").toString());
      m++;
      localObject = str;
    }
    return localObject;
  }

  public void a(g paramg)
  {
    super.a(paramg);
    this.l = (0x4 | this.l);
    for (int m = 0; m < this.j.size(); m++)
      ((l)this.j.get(m)).a(paramg);
  }

  public void a(l.b paramb)
  {
    super.a(paramb);
    this.l = (0x8 | this.l);
    int m = this.j.size();
    for (int n = 0; n < m; n++)
      ((l)this.j.get(n)).a(paramb);
  }

  public void a(o paramo)
  {
    super.a(paramo);
    this.l = (0x2 | this.l);
    int m = this.j.size();
    for (int n = 0; n < m; n++)
      ((l)this.j.get(n)).a(paramo);
  }

  public void a(s params)
  {
    if (a(params.b))
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        if (locall.a(params.b))
        {
          locall.a(params);
          params.c.add(locall);
        }
      }
    }
  }

  protected void a(ViewGroup paramViewGroup, t paramt1, t paramt2, ArrayList<s> paramArrayList1, ArrayList<s> paramArrayList2)
  {
    long l1 = c();
    int m = this.j.size();
    int n = 0;
    if (n < m)
    {
      l locall = (l)this.j.get(n);
      if ((l1 > 0L) && ((this.k) || (n == 0)))
      {
        long l2 = locall.c();
        if (l2 <= 0L)
          break label101;
        locall.b(l2 + l1);
      }
      while (true)
      {
        locall.a(paramViewGroup, paramt1, paramt2, paramArrayList1, paramArrayList2);
        n++;
        break;
        label101: locall.b(l1);
      }
    }
  }

  public l b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.j.size()))
      return null;
    return (l)this.j.get(paramInt);
  }

  public p b(TimeInterpolator paramTimeInterpolator)
  {
    this.l = (0x1 | this.l);
    if (this.j != null)
    {
      int m = this.j.size();
      for (int n = 0; n < m; n++)
        ((l)this.j.get(n)).a(paramTimeInterpolator);
    }
    return (p)super.a(paramTimeInterpolator);
  }

  public void b(s params)
  {
    if (a(params.b))
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        if (locall.a(params.b))
        {
          locall.b(params);
          params.c.add(locall);
        }
      }
    }
  }

  public p c(long paramLong)
  {
    super.a(paramLong);
    if (this.a >= 0L)
    {
      int m = this.j.size();
      for (int n = 0; n < m; n++)
        ((l)this.j.get(n)).a(paramLong);
    }
    return this;
  }

  public p c(l.c paramc)
  {
    return (p)super.a(paramc);
  }

  void c(s params)
  {
    super.c(params);
    int m = this.j.size();
    for (int n = 0; n < m; n++)
      ((l)this.j.get(n)).c(params);
  }

  public p d(long paramLong)
  {
    return (p)super.b(paramLong);
  }

  public p d(l.c paramc)
  {
    return (p)super.b(paramc);
  }

  public void d(View paramView)
  {
    super.d(paramView);
    int m = this.j.size();
    for (int n = 0; n < m; n++)
      ((l)this.j.get(n)).d(paramView);
  }

  protected void e()
  {
    if (this.j.isEmpty())
    {
      j();
      k();
    }
    while (true)
    {
      return;
      r();
      if (!this.k)
      {
        for (int m = 1; m < this.j.size(); m++)
          ((l)this.j.get(m - 1)).a(new m()
          {
            public void a(l paramAnonymousl)
            {
              this.a.e();
              paramAnonymousl.b(this);
            }
          });
        l locall = (l)this.j.get(0);
        if (locall != null)
          locall.e();
      }
      else
      {
        Iterator localIterator = this.j.iterator();
        while (localIterator.hasNext())
          ((l)localIterator.next()).e();
      }
    }
  }

  public void e(View paramView)
  {
    super.e(paramView);
    int m = this.j.size();
    for (int n = 0; n < m; n++)
      ((l)this.j.get(n)).e(paramView);
  }

  public p f(View paramView)
  {
    for (int m = 0; m < this.j.size(); m++)
      ((l)this.j.get(m)).b(paramView);
    return (p)super.b(paramView);
  }

  public p g(View paramView)
  {
    for (int m = 0; m < this.j.size(); m++)
      ((l)this.j.get(m)).c(paramView);
    return (p)super.c(paramView);
  }

  public l o()
  {
    p localp = (p)super.o();
    localp.j = new ArrayList();
    int m = this.j.size();
    for (int n = 0; n < m; n++)
      localp.a(((l)this.j.get(n)).o());
    return localp;
  }

  public int q()
  {
    return this.j.size();
  }

  static class a extends m
  {
    p a;

    a(p paramp)
    {
      this.a = paramp;
    }

    public void a(l paraml)
    {
      p localp = this.a;
      localp.h = (-1 + localp.h);
      if (this.a.h == 0)
      {
        this.a.i = false;
        this.a.k();
      }
      paraml.b(this);
    }

    public void d(l paraml)
    {
      if (!this.a.i)
      {
        this.a.j();
        this.a.i = true;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.p
 * JD-Core Version:    0.6.2
 */