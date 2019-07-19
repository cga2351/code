package com.viber.voip.model.a;

import com.viber.voip.util.u;
import java.util.List;
import java.util.Set;

public abstract class d
{
  public final int a()
  {
    int i = c();
    int j = b();
    a(i);
    return j;
  }

  public int a(a parama)
  {
    String str = parama.a();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = parama.b();
    return a(str, arrayOfString);
  }

  public abstract int a(String paramString, Long[] paramArrayOfLong);

  public abstract int a(String paramString, String[] paramArrayOfString);

  public long a(String paramString1, String paramString2, long paramLong)
  {
    Long localLong = (Long)a(paramString1, paramString2, 1);
    if (localLong != null)
      paramLong = localLong.longValue();
    return paramLong;
  }

  abstract Object a(String paramString1, String paramString2, int paramInt);

  public abstract List<String> a(String paramString1, String paramString2);

  public List<String> a(String paramString, boolean paramBoolean)
  {
    return a(paramString, String.valueOf(paramBoolean));
  }

  public abstract Set<String> a(String paramString);

  public void a(int paramInt)
  {
    b("keystore_metadata", "keystore_version", paramInt);
  }

  public void a(String paramString, int paramInt)
  {
    b("-1", paramString, paramInt);
  }

  public void a(String paramString, long paramLong)
  {
    b("-1", paramString, paramLong);
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, 0);
  }

  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt);

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramString1, paramString2, String.valueOf(paramBoolean), 3);
  }

  public final void a(List<a> paramList)
  {
    if (u.a(paramList))
      return;
    b(paramList);
  }

  protected abstract int b();

  public Integer b(String paramString1, String paramString2)
  {
    return (Integer)a(paramString1, paramString2, 2);
  }

  public abstract Set<a> b(String paramString);

  public void b(a parama)
  {
    a(parama.a, parama.b, parama.d(), parama.d);
  }

  public void b(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, String.valueOf(paramInt), 2);
  }

  public void b(String paramString1, String paramString2, long paramLong)
  {
    a(paramString1, paramString2, String.valueOf(paramLong), 1);
  }

  public void b(String paramString, boolean paramBoolean)
  {
    a("-1", paramString, paramBoolean);
  }

  protected void b(List<a> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++)
      b((a)paramList.get(j));
  }

  public int c()
  {
    Integer localInteger = b("keystore_metadata", "keystore_version");
    if (localInteger == null)
      return 0;
    return localInteger.intValue();
  }

  public abstract int c(String paramString);

  public Long c(String paramString1, String paramString2)
  {
    return (Long)a(paramString1, paramString2, 1);
  }

  public final void c(List<a> paramList)
  {
    if (u.a(paramList))
      return;
    d(paramList);
  }

  public String d(String paramString1, String paramString2)
  {
    return (String)a(paramString1, paramString2, 0);
  }

  public abstract List<a> d(String paramString);

  protected void d(List<a> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++)
      a((a)paramList.get(j));
  }

  public Boolean e(String paramString1, String paramString2)
  {
    return (Boolean)a(paramString1, paramString2, 3);
  }

  public String e(String paramString)
  {
    return d("-1", paramString);
  }

  public Integer f(String paramString)
  {
    return b("-1", paramString);
  }

  public void f(String paramString1, String paramString2)
  {
    a("-1", paramString1, paramString2);
  }

  public Long g(String paramString)
  {
    return c("-1", paramString);
  }

  public Boolean h(String paramString)
  {
    return e("-1", paramString);
  }

  public int i(String paramString)
  {
    return a("-1", new String[] { paramString });
  }

  public static final class a
  {
    public final String a;
    public final String b;
    public final Object c;
    public final int d;

    public a(String paramString1, String paramString2, Object paramObject, int paramInt)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramObject;
      this.d = paramInt;
    }

    public static a a(String paramString1, String paramString2, Long paramLong)
    {
      return new a(paramString1, paramString2, paramLong, 1);
    }

    public static a a(String paramString1, String paramString2, String paramString3)
    {
      return new a(paramString1, paramString2, paramString3, 0);
    }

    public String a()
    {
      return this.a;
    }

    public String b()
    {
      return this.b;
    }

    public Object c()
    {
      return this.c;
    }

    public String d()
    {
      if (this.c == null)
        return null;
      return String.valueOf(this.c);
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1;
      if (this == paramObject)
        bool1 = true;
      a locala;
      boolean bool2;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return bool1;
            bool1 = false;
          }
          while (paramObject == null);
          localClass1 = getClass();
          localClass2 = paramObject.getClass();
          bool1 = false;
        }
        while (localClass1 != localClass2);
        locala = (a)paramObject;
        bool2 = this.a.equals(locala.a);
        bool1 = false;
      }
      while (!bool2);
      return this.b.equals(locala.b);
    }

    public int hashCode()
    {
      if (this.a != null);
      for (int i = this.a.hashCode(); ; i = 0)
      {
        int j = i * 31;
        String str = this.b;
        int k = 0;
        if (str != null)
          k = this.b.hashCode();
        return j + k;
      }
    }

    public String toString()
    {
      return "Entry{mCategory='" + this.a + '\'' + ", mKey='" + this.b + '\'' + ", mValue=" + this.c + ", mValueType=" + this.d + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.a.d
 * JD-Core Version:    0.6.2
 */