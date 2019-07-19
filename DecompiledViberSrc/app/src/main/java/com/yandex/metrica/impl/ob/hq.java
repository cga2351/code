package com.yandex.metrica.impl.ob;

import android.location.Location;
import com.yandex.metrica.impl.d.a;
import java.util.concurrent.TimeUnit;

class hq extends hn
{
  public static final long a = TimeUnit.MINUTES.toMillis(2L);
  public static final long b = TimeUnit.SECONDS.toMillis(10L);
  private d.a<Location> c;
  private a d;
  private long e;

  public hq(hm paramhm)
  {
    this(paramhm, new a(a, 200L, 50L), b);
  }

  hq(hm paramhm, a parama, long paramLong)
  {
    super(paramhm);
    this.d = parama;
    this.e = paramLong;
  }

  public static boolean a(Location paramLocation1, Location paramLocation2, long paramLong1, long paramLong2)
  {
    if (paramLocation2 == null);
    label44: int k;
    label72: label78: label82: 
    while (true)
    {
      return true;
      if (paramLocation1 == null)
        return false;
      long l = paramLocation1.getTime() - paramLocation2.getTime();
      int i;
      int j;
      if (l > paramLong1)
      {
        i = 1;
        if (l >= -paramLong1)
          break label72;
        j = 1;
        if (l <= 0L)
          break label78;
      }
      for (k = 1; ; k = 0)
      {
        if (i != 0)
          break label82;
        if (j == 0)
          break label84;
        return false;
        i = 0;
        break;
        j = 0;
        break label44;
      }
    }
    label84: int m = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
    int n;
    label104: int i1;
    if (m > 0)
    {
      n = 1;
      if (m >= 0)
        break label175;
      i1 = 1;
      label112: if (m <= paramLong2)
        break label181;
    }
    label175: label181: for (int i2 = 1; ; i2 = 0)
    {
      boolean bool = a(paramLocation1.getProvider(), paramLocation2.getProvider());
      if ((i1 != 0) || ((k != 0) && (n == 0)) || ((k != 0) && (i2 == 0) && (bool)))
        break;
      return false;
      n = 0;
      break label104;
      i1 = 0;
      break label112;
    }
  }

  static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return paramString2 == null;
    return paramString1.equals(paramString2);
  }

  public Location a()
  {
    if (this.c == null)
      return null;
    return (Location)this.c.d();
  }

  public void a(Location paramLocation, hp paramhp)
  {
    if (paramLocation != null)
      if ((this.c != null) && (!this.c.a(this.e)) && (!a(paramLocation, (Location)this.c.a(), this.d.a, this.d.b)))
        break label95;
    label95: for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        Location localLocation = new Location(paramLocation);
        d.a locala = new d.a();
        locala.a(localLocation);
        this.c = locala;
      }
      return;
    }
  }

  public static class a
  {
    public final long a;
    public final long b;
    public final long c;

    public a(long paramLong1, long paramLong2, long paramLong3)
    {
      this.a = paramLong1;
      this.b = paramLong2;
      this.c = paramLong3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hq
 * JD-Core Version:    0.6.2
 */