package com.viber.voip.contacts.a.a;

public abstract class a<GR extends c, CH extends b>
{
  public int a()
  {
    int i = b();
    int j = 0;
    int k = i;
    if (j < i)
    {
      if (c(j).c());
      for (int m = b(j); ; m = 0)
      {
        k += m;
        j++;
        break;
      }
    }
    return k;
  }

  public int a(GR paramGR)
  {
    int i = b();
    int j = 0;
    int k = 0;
    if (j < i)
    {
      if (paramGR == c(j))
        return k;
      int m = k + 1;
      if (c(j).c());
      for (int n = b(j); ; n = 0)
      {
        int i1 = m + n;
        j++;
        k = i1;
        break;
      }
    }
    return -1;
  }

  public a a(int paramInt)
  {
    int i = b();
    int j = 0;
    int i1;
    for (int k = 0; j < i; k = i1)
    {
      int m = k + 1;
      if (m - 1 >= paramInt)
        return c(j);
      if (c(j).c());
      for (int n = b(j); ; n = 0)
      {
        i1 = m + n;
        if (i1 - 1 < paramInt)
          break;
        return a(j, paramInt - m);
      }
      j++;
    }
    return null;
  }

  public abstract CH a(int paramInt1, int paramInt2);

  public abstract void a(int paramInt1, int paramInt2, Object[] paramArrayOfObject);

  public void a(int paramInt, Object[] paramArrayOfObject)
  {
    a(paramInt, b(paramInt), paramArrayOfObject);
  }

  public void a(Object[] paramArrayOfObject)
  {
    b(b(), paramArrayOfObject);
  }

  public abstract int b();

  public abstract int b(int paramInt);

  public abstract void b(int paramInt, Object[] paramArrayOfObject);

  public GR c()
  {
    for (int i = 0; i < b(); i++)
    {
      c localc = c(i);
      if (localc.c())
        return localc;
    }
    return null;
  }

  public abstract GR c(int paramInt);

  public static abstract class a
  {
    protected int a;
    protected long b;
    protected Object c;

    public a(int paramInt, long paramLong, Object paramObject)
    {
      this.a = paramInt;
      this.b = paramLong;
      this.c = paramObject;
    }

    public int a()
    {
      return this.a;
    }

    public Object b()
    {
      return this.c;
    }

    public String toString()
    {
      return "BaseData{mType=" + this.a + ", mId=" + this.b + ", mData='" + this.c + '\'' + '}';
    }
  }

  public static abstract class b extends a.a
  {
    public b(int paramInt, long paramLong, Object paramObject)
    {
      super(paramLong, paramObject);
    }
  }

  public static abstract class c extends a.a
  {
    protected boolean d;

    public c(int paramInt, long paramLong, Object paramObject)
    {
      super(paramLong, paramObject);
    }

    public final boolean c()
    {
      return this.d;
    }

    public final void d()
    {
      this.d = true;
    }

    public final void e()
    {
      this.d = false;
    }

    public final void f()
    {
      if (!this.d);
      for (boolean bool = true; ; bool = false)
      {
        this.d = bool;
        return;
      }
    }

    public String toString()
    {
      return "GroupData{mIsExpanded=" + this.d + ", " + super.toString() + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.a.a.a
 * JD-Core Version:    0.6.2
 */