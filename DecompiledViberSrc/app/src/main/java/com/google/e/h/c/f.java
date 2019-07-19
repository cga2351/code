package com.google.e.h.c;

import com.google.e.h.a.h;
import com.google.e.h.a.j;

public final class f
{
  private h a;
  private com.google.e.h.a.f b;
  private j c;
  private int d = -1;
  private b e;

  public static boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }

  public b a()
  {
    return this.e;
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(com.google.e.h.a.f paramf)
  {
    this.b = paramf;
  }

  public void a(h paramh)
  {
    this.a = paramh;
  }

  public void a(j paramj)
  {
    this.c = paramj;
  }

  public void a(b paramb)
  {
    this.e = paramb;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("<<\n");
    localStringBuilder.append(" mode: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n ecLevel: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n version: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(this.d);
    if (this.e == null)
      localStringBuilder.append("\n matrix: null\n");
    while (true)
    {
      localStringBuilder.append(">>\n");
      return localStringBuilder.toString();
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(this.e);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.c.f
 * JD-Core Version:    0.6.2
 */