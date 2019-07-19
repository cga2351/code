package com.viber.voip.notif.d;

import java.util.Arrays;

public class k
{
  private final String[] a;
  private final int[] b;
  private int c = 0;

  k(int paramInt)
  {
    this.a = new String[paramInt];
    this.b = new int[paramInt];
  }

  k(String paramString, int paramInt)
  {
    this.a = new String[1];
    this.b = new int[1];
    a(paramString, paramInt);
  }

  public int a()
  {
    return this.a.length;
  }

  public String a(int paramInt)
  {
    return this.a[paramInt];
  }

  void a(k paramk)
  {
    int i = 0;
    int j = paramk.a();
    while (i < j)
    {
      a(paramk.a(i), paramk.b(i));
      i++;
    }
  }

  void a(String paramString, int paramInt)
  {
    if (this.c == this.a.length)
      return;
    this.a[this.c] = paramString;
    this.b[this.c] = paramInt;
    this.c = (1 + this.c);
  }

  public int b(int paramInt)
  {
    return this.b[paramInt];
  }

  public String toString()
  {
    return "NotificationPresenterResult{tags=" + Arrays.toString(this.a) + ", ids=" + Arrays.toString(this.b) + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.k
 * JD-Core Version:    0.6.2
 */