package com.yandex.metrica.impl.ob;

import android.location.Location;

class ic
{
  public hp.a a;
  private Long b;
  private long c;
  private Location d;

  public ic(hp.a parama, long paramLong, Location paramLocation)
  {
    this(parama, paramLong, paramLocation, null);
  }

  public ic(hp.a parama, long paramLong, Location paramLocation, Long paramLong1)
  {
    this.a = parama;
    this.b = paramLong1;
    this.c = paramLong;
    this.d = paramLocation;
  }

  public Long a()
  {
    return this.b;
  }

  public long b()
  {
    return this.c;
  }

  public Location c()
  {
    return this.d;
  }

  public String toString()
  {
    return "LocationWrapper{collectionMode=" + this.a + ", mIncrementalId=" + this.b + ", mReceiveTimestamp=" + this.c + ", mLocation=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ic
 * JD-Core Version:    0.6.2
 */