package com.viber.voip.model.a;

import com.viber.voip.g.b.b;

public abstract class a
{
  private final b<d> a;
  private final String b;
  private final long c;
  private final String d;

  public a(b<d> paramb, String paramString, long paramLong)
  {
    this.a = paramb;
    this.b = paramString;
    this.c = paramLong;
    this.d = (paramString + "_last_write_time_ms");
  }

  protected abstract String a();

  public String a(long paramLong)
  {
    if (b(paramLong))
    {
      String str = a();
      a(str, paramLong);
      return str;
    }
    return ((d)this.a.get()).e(this.b);
  }

  public void a(String paramString, long paramLong)
  {
    d locald = (d)this.a.get();
    locald.f(this.b, paramString);
    locald.a(this.d, paramLong);
  }

  public boolean b(long paramLong)
  {
    Long localLong = ((d)this.a.get()).g(this.d);
    return (localLong == null) || (localLong.longValue() + this.c < paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.a.a
 * JD-Core Version:    0.6.2
 */