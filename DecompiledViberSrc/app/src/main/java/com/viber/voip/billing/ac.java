package com.viber.voip.billing;

import android.os.SystemClock;

public class ac
{
  public final long a;
  public final String b;
  private final long c;

  public ac(long paramLong, String paramString)
  {
    this.a = paramLong;
    this.b = paramString;
    this.c = SystemClock.elapsedRealtime();
  }

  public boolean a()
  {
    return SystemClock.elapsedRealtime() - this.c > 13800000L;
  }

  public String toString()
  {
    return "WebToken{token:" + this.b + ", timestamp:" + this.a + ", localTimestamp:" + this.c + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.ac
 * JD-Core Version:    0.6.2
 */