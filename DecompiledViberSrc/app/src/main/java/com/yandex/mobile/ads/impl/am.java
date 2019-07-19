package com.yandex.mobile.ads.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class am
  implements Comparable<am>
{
  private static final Pattern a = Pattern.compile("^[\\d]*(\\.[\\d]*)*(\\-.*)?");
  private final String b;
  private int[] c;
  private String d;
  private Integer e;
  private boolean f = true;

  public am(String paramString)
  {
    this.b = paramString.toLowerCase();
    a();
  }

  private int a(int paramInt)
  {
    if (paramInt >= this.c.length)
      return 0;
    return this.c[paramInt];
  }

  private static int a(String paramString1, String paramString2)
  {
    int i = paramString1.compareTo(paramString2);
    if (i < 0)
      return -1;
    if (i > 0)
      return 1;
    return 0;
  }

  private void a()
  {
    String[] arrayOfString1 = this.b.split("-");
    if (!a.matcher(this.b).matches())
      this.f = false;
    String[] arrayOfString2 = arrayOfString1[0].split("\\.");
    int k;
    if (this.f)
    {
      this.c = new int[arrayOfString2.length];
      for (int i = 0; i < this.c.length; i++)
        this.c[i] = Integer.parseInt(arrayOfString2[i]);
      int j = this.b.indexOf('-');
      if ((j < 0) || (j >= -1 + this.b.length()))
        break label162;
      this.d = this.b.substring(j);
      boolean bool = this.d.endsWith("-snapshot");
      k = 0;
      if (!bool)
        break label156;
    }
    while (true)
    {
      this.e = Integer.valueOf(k);
      return;
      label156: k = 1;
    }
    label162: this.e = Integer.valueOf(2);
  }

  public final int a(am paramam)
  {
    int i = 1;
    if ((!this.f) || (!paramam.f))
      if (!this.f);
    label147: 
    while (true)
    {
      return i;
      if (paramam.f)
        return -1;
      return a(this.b, paramam.b);
      int j = Math.max(this.c.length, paramam.c.length);
      int k = 0;
      int m;
      int n;
      if (k < j)
      {
        m = a(k);
        n = paramam.a(k);
        if (m <= n);
      }
      while (true)
      {
        if (i != 0)
          break label147;
        if (!this.e.equals(paramam.e))
          break label161;
        if (!this.e.equals(Integer.valueOf(2)))
          break label149;
        return 0;
        if (m < n)
        {
          i = -1;
        }
        else
        {
          k++;
          break;
          i = 0;
        }
      }
    }
    label149: return a(this.d, paramam.d);
    label161: return this.e.compareTo(paramam.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.am
 * JD-Core Version:    0.6.2
 */