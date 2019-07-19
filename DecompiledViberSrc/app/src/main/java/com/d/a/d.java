package com.d.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  final String a;
  final a b;
  c[] c;
  private final List<b> d = new ArrayList();

  public d(String paramString, a parama, c[] paramArrayOfc)
  {
    this.a = paramString;
    if (parama == null)
      parama = new a();
    this.b = parama;
    this.c = paramArrayOfc;
    a();
  }

  private void a()
  {
    if (this.c.length > 0)
    {
      double d1 = this.c[0].a();
      for (int i = 1; i < this.c.length; i++)
      {
        if (d1 > this.c[i].a())
          throw new IllegalArgumentException("The order of the values is not correct. X-Values have to be ordered ASC. First the lowest x value and at least the highest x value.");
        d1 = this.c[i].a();
      }
    }
  }

  public void a(b paramb)
  {
    this.d.add(paramb);
  }

  public void a(c paramc, boolean paramBoolean, int paramInt)
  {
    if ((this.c.length > 0) && (paramc.a() < this.c[(-1 + this.c.length)].a()))
      throw new IllegalArgumentException("new x-value must be greater then the last value. x-values has to be ordered in ASC.");
    synchronized (this.c)
    {
      int i = this.c.length;
      if (i < paramInt)
      {
        arrayOfc2 = new c[i + 1];
        System.arraycopy(this.c, 0, arrayOfc2, 0, i);
        arrayOfc2[i] = paramc;
        this.c = arrayOfc2;
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (paramBoolean)
            localb.d();
        }
      }
      c[] arrayOfc2 = new c[paramInt];
      System.arraycopy(this.c, 1, arrayOfc2, 0, i - 1);
      arrayOfc2[(paramInt - 1)] = paramc;
    }
  }

  public static class a
  {
    public int a = -16746548;
    public int b = 3;

    public a()
    {
    }

    public a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.d.a.d
 * JD-Core Version:    0.6.2
 */