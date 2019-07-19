package com.viber.voip.notif.h;

import com.viber.voip.util.av;

public class n
{
  private final long a;
  private final String b;
  private final int c;

  n(long paramLong, String paramString, int paramInt)
  {
    this.a = paramLong;
    this.b = paramString;
    this.c = paramInt;
  }

  public long a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public boolean d()
  {
    return !av.d(c(), 16384);
  }

  public boolean e()
  {
    return av.d(this.c, 1048576);
  }

  public String toString()
  {
    return "PublicAccountNotificationInfo{mGroupId=" + this.a + ", mGroupUri='" + this.b + '\'' + ", mFlags=" + this.c + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.n
 * JD-Core Version:    0.6.2
 */