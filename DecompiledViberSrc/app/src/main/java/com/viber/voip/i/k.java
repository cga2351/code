package com.viber.voip.i;

import com.viber.common.b.h;
import com.viber.voip.util.bz;

public class k extends g
{
  protected h i;

  k(String paramString1, String paramString2, int[] paramArrayOfInt, String[] paramArrayOfString, int paramInt, d[] paramArrayOfd)
  {
    super(paramString1, paramString2, paramArrayOfInt, paramArrayOfString, paramInt, paramArrayOfd);
  }

  k(String paramString1, String paramString2, d[] paramArrayOfd)
  {
    super(paramString1, paramString2, paramArrayOfd);
  }

  public static String a(String paramString)
  {
    return "server_" + paramString;
  }

  protected final int a()
  {
    return 2147483647;
  }

  public void a(int paramInt)
  {
    this.i.a(String.valueOf(paramInt));
    m();
  }

  protected int[] a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt1 = super.a(paramArrayOfInt);
    int[] arrayOfInt2 = new int[1 + arrayOfInt1.length];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
    arrayOfInt2[arrayOfInt1.length] = 2147483647;
    return arrayOfInt2;
  }

  protected String[] a(String[] paramArrayOfString)
  {
    String[] arrayOfString1 = super.a(paramArrayOfString);
    String[] arrayOfString2 = new String[1 + arrayOfString1.length];
    System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, arrayOfString1.length);
    arrayOfString2[arrayOfString1.length] = "Use server";
    return arrayOfString2;
  }

  protected int g()
  {
    int j = o();
    if (this.d != j)
    {
      if (l())
        return j;
      return this.d;
    }
    return this.d;
  }

  protected void k()
  {
    super.k();
    this.i = new h(a(this.e), String.valueOf(n()));
  }

  protected int n()
  {
    return this.d;
  }

  protected int o()
  {
    return bz.a(this.i.d(), this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.i.k
 * JD-Core Version:    0.6.2
 */