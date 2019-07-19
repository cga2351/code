package com.yandex.metrica.impl.ob;

import android.location.Location;

class hy
{
  private String a;
  private hp b;
  private hm c;
  private Location d;
  private long e;
  private on f;
  private ii g;
  private hl h;

  hy(String paramString, hp paramhp, hm paramhm, Location paramLocation, long paramLong, on paramon, ii paramii, hl paramhl)
  {
    this.a = paramString;
    this.b = paramhp;
    this.c = paramhm;
    this.d = paramLocation;
    this.e = paramLong;
    this.f = paramon;
    this.g = paramii;
    this.h = paramhl;
  }

  public hy(String paramString, hp paramhp, hm paramhm, ii paramii, hl paramhl)
  {
    this(paramString, paramhp, paramhm, null, 0L, new om(), paramii, paramhl);
  }

  public void a(Location paramLocation)
  {
    int i = 0;
    int j;
    int k;
    label74: int m;
    if (paramLocation != null)
    {
      hp localhp = this.b;
      i = 0;
      if (localhp != null)
      {
        if (this.d == null)
          break label189;
        if (this.f.a() - this.e <= this.b.e)
          break label171;
        j = 1;
        if (paramLocation.distanceTo(this.d) <= this.b.f)
          break label177;
        k = 1;
        if ((this.d != null) && (paramLocation.getTime() - this.d.getTime() < 0L))
          break label183;
        m = 1;
        label101: if (j == 0)
        {
          i = 0;
          if (k == 0);
        }
        else
        {
          i = 0;
          if (m == 0);
        }
      }
    }
    label171: label177: label183: label189: for (i = 1; ; i = 1)
    {
      if (i != 0)
      {
        this.d = paramLocation;
        this.e = System.currentTimeMillis();
        this.c.a(this.a, paramLocation, this.b);
        this.g.a();
        this.h.a();
      }
      return;
      j = 0;
      break;
      k = 0;
      break label74;
      m = 0;
      break label101;
    }
  }

  public void a(hp paramhp)
  {
    this.b = paramhp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hy
 * JD-Core Version:    0.6.2
 */