package com.crashlytics.android.a;

import c.a.a.a.a.c.a.e;

class x
{
  long a;
  private e b;

  public x(e parame)
  {
    if (parame == null)
      throw new NullPointerException("retryState must not be null");
    this.b = parame;
  }

  public void a()
  {
    this.a = 0L;
    this.b = this.b.c();
  }

  public boolean a(long paramLong)
  {
    long l = 1000000L * this.b.a();
    return paramLong - this.a >= l;
  }

  public void b(long paramLong)
  {
    this.a = paramLong;
    this.b = this.b.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.x
 * JD-Core Version:    0.6.2
 */