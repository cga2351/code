package com.c.a.a;

import java.io.Serializable;

public class e
  implements Serializable
{
  public static final e a = new e("N/A", -1L, -1L, -1, -1);
  final long b;
  final long c;
  final int d;
  final int e;
  final Object f;

  public e(Object paramObject, long paramLong, int paramInt1, int paramInt2)
  {
    this(paramObject, -1L, paramLong, paramInt1, paramInt2);
  }

  public e(Object paramObject, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.f = paramObject;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramInt1;
    this.e = paramInt2;
  }

  public long a()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramObject == this)
      bool2 = bool1;
    e locale;
    Object localObject;
    do
    {
      boolean bool3;
      do
      {
        do
        {
          return bool2;
          bool2 = false;
        }
        while (paramObject == null);
        bool3 = paramObject instanceof e;
        bool2 = false;
      }
      while (!bool3);
      locale = (e)paramObject;
      if (this.f != null)
        break;
      localObject = locale.f;
      bool2 = false;
    }
    while (localObject != null);
    if ((this.d == locale.d) && (this.e == locale.e) && (this.c == locale.c) && (a() == locale.a()));
    while (true)
    {
      return bool1;
      if (this.f.equals(locale.f))
        break;
      return false;
      bool1 = false;
    }
  }

  public int hashCode()
  {
    if (this.f == null);
    for (int i = 1; ; i = this.f.hashCode())
      return ((i ^ this.d) + this.e ^ (int)this.c) + (int)this.b;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    localStringBuilder.append("[Source: ");
    if (this.f == null)
      localStringBuilder.append("UNKNOWN");
    while (true)
    {
      localStringBuilder.append("; line: ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", column: ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
      localStringBuilder.append(this.f.toString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.e
 * JD-Core Version:    0.6.2
 */