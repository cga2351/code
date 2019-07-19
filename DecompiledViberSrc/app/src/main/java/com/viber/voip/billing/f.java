package com.viber.voip.billing;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;

public class f
  implements Comparable<f>
{
  private static final Logger a = ViberEnv.getLogger();
  private final IabProductId b;
  private final String c;
  private final int d;
  private final double e;
  private final String f;
  private final String g;
  private String h;
  private String i;
  private ArrayList<String> j;

  public f(IabProductId paramIabProductId)
  {
    this(paramIabProductId, null, 0.0D, null, 0, null);
  }

  public f(IabProductId paramIabProductId, String paramString1, double paramDouble, String paramString2, int paramInt, String paramString3)
  {
    this.b = paramIabProductId;
    this.c = paramString1;
    this.e = paramDouble;
    this.f = paramString2;
    this.d = paramInt;
    this.g = paramString3;
  }

  public int a(f paramf)
  {
    return Integer.valueOf(this.d).compareTo(Integer.valueOf(paramf.f()));
  }

  public String a()
  {
    if (this.h != null)
      return this.h;
    if ("USD".equals(this.f))
      return "$" + this.e;
    if ("EUR".equals(this.f))
      return "€" + this.e;
    return this.c;
  }

  public void a(String paramString)
  {
    this.i = paramString;
  }

  public void a(ArrayList<String> paramArrayList)
  {
    this.j = paramArrayList;
  }

  public IabProductId b()
  {
    return this.b;
  }

  public void b(String paramString)
  {
    this.h = paramString;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.f;
  }

  public double e()
  {
    return this.e;
  }

  public int f()
  {
    return this.d;
  }

  public String toString()
  {
    return "{name: " + this.c + " billingPrice: " + this.e + " billingCurrencyCode: " + this.f + " position: " + this.d + " freeCredit: " + this.g + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.f
 * JD-Core Version:    0.6.2
 */