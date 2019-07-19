package com.yandex.metrica.impl.ob;

public abstract class fx
{
  private final fk a;
  private final String b;

  static
  {
    fx.class.getSimpleName();
  }

  public fx(fk paramfk)
  {
    this(paramfk, null);
  }

  public fx(fk paramfk, String paramString)
  {
    this.a = paramfk;
    this.b = paramString;
  }

  protected <T extends fx> T a(String paramString, int paramInt)
  {
    try
    {
      this.a.b(paramString, paramInt);
      return this;
    }
    finally
    {
    }
  }

  public <T extends fx> T a(String paramString, long paramLong)
  {
    try
    {
      this.a.b(paramString, paramLong);
      return this;
    }
    finally
    {
    }
  }

  public <T extends fx> T a(String paramString, boolean paramBoolean)
  {
    try
    {
      this.a.b(paramString, paramBoolean);
      return this;
    }
    finally
    {
    }
  }

  int b(String paramString, int paramInt)
  {
    return this.a.a(paramString, paramInt);
  }

  public long b(String paramString, long paramLong)
  {
    return this.a.a(paramString, paramLong);
  }

  protected <T extends fx> T b(String paramString1, String paramString2)
  {
    try
    {
      this.a.b(paramString1, paramString2);
      return this;
    }
    finally
    {
    }
  }

  public boolean b(String paramString, boolean paramBoolean)
  {
    return this.a.a(paramString, paramBoolean);
  }

  String c(String paramString1, String paramString2)
  {
    return this.a.a(paramString1, paramString2);
  }

  public String h()
  {
    return this.b;
  }

  public void i()
  {
    try
    {
      this.a.b();
      return;
    }
    finally
    {
    }
  }

  protected jo o(String paramString)
  {
    return new jo(paramString, h());
  }

  public <T extends fx> T p(String paramString)
  {
    try
    {
      this.a.a(paramString);
      return this;
    }
    finally
    {
    }
  }

  String q(String paramString)
  {
    return this.a.a(paramString, null);
  }

  public boolean r(String paramString)
  {
    return this.a.b(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fx
 * JD-Core Version:    0.6.2
 */