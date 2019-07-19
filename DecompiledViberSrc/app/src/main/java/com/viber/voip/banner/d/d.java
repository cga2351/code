package com.viber.voip.banner.d;

import com.viber.voip.model.entity.b;

public abstract class d extends b
{
  long a;
  String b;
  long c;
  String d;
  int e;
  boolean f;

  public abstract g a();

  public void a(int paramInt)
  {
    this.e = paramInt;
  }

  public void a(long paramLong)
  {
    this.a = paramLong;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public long b()
  {
    return this.a;
  }

  public void b(long paramLong)
  {
    this.c = paramLong;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public String c()
  {
    return this.b;
  }

  public long d()
  {
    return this.c;
  }

  public String e()
  {
    return this.d;
  }

  public boolean f()
  {
    return this.f;
  }

  public int g()
  {
    return this.e;
  }

  public String getTable()
  {
    return "remote_banners";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.d
 * JD-Core Version:    0.6.2
 */