package com.android.billingclient.api;

import java.util.ArrayList;

public class e
{
  private String a;
  private String b;
  private j c;
  private String d;
  private String e;
  private boolean f;
  private int g = 0;

  public static a i()
  {
    return new a(null);
  }

  public String a()
  {
    if (this.c != null)
      return this.c.a();
    return this.a;
  }

  public String b()
  {
    if (this.c != null)
      return this.c.b();
    return this.b;
  }

  public j c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public String e()
  {
    return this.e;
  }

  public boolean f()
  {
    return this.f;
  }

  public int g()
  {
    return this.g;
  }

  public boolean h()
  {
    return (this.f) || (this.e != null) || (this.g != 0);
  }

  public static class a
  {
    private String a;
    private String b;
    private j c;
    private String d;
    private String e;
    private boolean f;
    private int g = 0;

    @Deprecated
    public a a(String paramString)
    {
      if (this.c != null)
        throw new RuntimeException("Sku details already set");
      this.a = paramString;
      return this;
    }

    @Deprecated
    public a a(ArrayList<String> paramArrayList)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
        this.d = ((String)paramArrayList.get(0));
      return this;
    }

    public e a()
    {
      e locale = new e();
      e.a(locale, this.a);
      e.b(locale, this.b);
      e.a(locale, this.c);
      e.c(locale, this.d);
      e.d(locale, this.e);
      e.a(locale, this.f);
      e.a(locale, this.g);
      return locale;
    }

    @Deprecated
    public a b(String paramString)
    {
      if (this.c != null)
        throw new RuntimeException("Sku details already set");
      this.b = paramString;
      return this;
    }

    public a c(String paramString)
    {
      this.e = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.e
 * JD-Core Version:    0.6.2
 */