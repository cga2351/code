package com.yandex.metrica.impl.ob;

import android.location.Location;
import com.yandex.metrica.CounterConfiguration.a;
import com.yandex.metrica.impl.bw;
import java.util.List;

public class lr extends lp
{
  private boolean a;
  private Location b;
  private boolean c;
  private boolean d;
  private CounterConfiguration.a e;
  private int f;
  private int g;
  private boolean h;
  private int i;
  private boolean j;
  private String k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private String p;
  private List<String> q;
  private boolean r;
  private int s;

  public String D()
  {
    return this.k;
  }

  public boolean E()
  {
    return this.l;
  }

  public boolean F()
  {
    return this.m;
  }

  public boolean G()
  {
    return this.n;
  }

  public boolean H()
  {
    return this.o;
  }

  public boolean I()
  {
    return this.r;
  }

  public boolean J()
  {
    return this.a;
  }

  public Location K()
  {
    return this.b;
  }

  public boolean L()
  {
    return this.c;
  }

  public boolean M()
  {
    return this.d;
  }

  public CounterConfiguration.a N()
  {
    return this.e;
  }

  public int O()
  {
    return this.f;
  }

  public int P()
  {
    return this.g;
  }

  public int Q()
  {
    return this.i;
  }

  public int R()
  {
    return this.s;
  }

  public boolean S()
  {
    return this.j;
  }

  public String a()
  {
    return oq.b(this.p, "");
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
  }

  public void a(Location paramLocation)
  {
    this.b = paramLocation;
  }

  public void a(CounterConfiguration.a parama)
  {
    this.e = parama;
  }

  void a(String paramString)
  {
    this.p = paramString;
  }

  public void a(List<String> paramList)
  {
    this.q = paramList;
  }

  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public List<String> b()
  {
    return this.q;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public void c(int paramInt)
  {
    this.i = paramInt;
  }

  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  public void d(int paramInt)
  {
    this.s = paramInt;
  }

  public void d(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public void e(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public boolean e()
  {
    return (super.e()) && (!bw.a(b()));
  }

  public void f(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public void g(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public void h(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public void i(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public static final class a extends lm.a
  {
    public final String a;
    public final Boolean e;
    public final Location f;
    public final Boolean g;
    public final Boolean h;
    public final Integer i;
    public final Integer j;
    public final Integer k;
    public final Boolean l;
    public final Boolean m;
    public final CounterConfiguration.a n;

    public a(String paramString1, String paramString2, String paramString3, String paramString4, Boolean paramBoolean1, Location paramLocation, Boolean paramBoolean2, Boolean paramBoolean3, CounterConfiguration.a parama, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Boolean paramBoolean4, Boolean paramBoolean5)
    {
      super(paramString2, paramString3);
      this.a = paramString4;
      this.e = paramBoolean1;
      this.f = paramLocation;
      this.g = paramBoolean2;
      this.h = paramBoolean3;
      this.n = parama;
      this.i = paramInteger1;
      this.j = paramInteger2;
      this.k = paramInteger3;
      this.l = paramBoolean4;
      this.m = paramBoolean5;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Location localLocation2;
      do
      {
        Location localLocation1;
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass()))
            return false;
          if (!super.equals(paramObject))
            return false;
          a locala = (a)paramObject;
          if (this.a != null)
          {
            if (this.a.equals(locala.a));
          }
          else
            while (locala.a != null)
              return false;
          if (this.e != null)
          {
            if (this.e.equals(locala.e));
          }
          else
            while (locala.e != null)
              return false;
          if (this.g != null)
          {
            if (this.g.equals(locala.g));
          }
          else
            while (locala.g != null)
              return false;
          if (this.h != null)
          {
            if (this.h.equals(locala.h));
          }
          else
            while (locala.h != null)
              return false;
          if (this.n != locala.n)
            return false;
          if (this.i != null)
          {
            if (this.i.equals(locala.i));
          }
          else
            while (locala.i != null)
              return false;
          if (this.j != null)
          {
            if (this.j.equals(locala.j));
          }
          else
            while (locala.j != null)
              return false;
          if (this.k != null)
          {
            if (this.k.equals(locala.k));
          }
          else
            while (locala.k != null)
              return false;
          if (this.l != null)
          {
            if (this.l.equals(locala.l));
          }
          else
            while (locala.l != null)
              return false;
          if (this.m != null)
          {
            if (this.m.equals(locala.m));
          }
          else
            while (locala.m != null)
              return false;
          localLocation1 = this.f;
          localLocation2 = locala.f;
        }
        while (localLocation1 == localLocation2);
        if ((localLocation1 == null) || (localLocation2 == null))
          return false;
        if (localLocation1.getTime() != localLocation2.getTime())
          return false;
        if ((bw.a(17)) && (localLocation1.getElapsedRealtimeNanos() != localLocation2.getElapsedRealtimeNanos()))
          return false;
        if (Double.compare(localLocation2.getLatitude(), localLocation1.getLatitude()) != 0)
          return false;
        if (Double.compare(localLocation2.getLongitude(), localLocation1.getLongitude()) != 0)
          return false;
        if (Double.compare(localLocation2.getAltitude(), localLocation1.getAltitude()) != 0)
          return false;
        if (Float.compare(localLocation2.getSpeed(), localLocation1.getSpeed()) != 0)
          return false;
        if (Float.compare(localLocation2.getBearing(), localLocation1.getBearing()) != 0)
          return false;
        if (Float.compare(localLocation2.getAccuracy(), localLocation1.getAccuracy()) != 0)
          return false;
        if (bw.a(26))
        {
          if (Float.compare(localLocation2.getVerticalAccuracyMeters(), localLocation1.getVerticalAccuracyMeters()) != 0)
            return false;
          if (Float.compare(localLocation2.getSpeedAccuracyMetersPerSecond(), localLocation1.getSpeedAccuracyMetersPerSecond()) != 0)
            return false;
          if (Float.compare(localLocation2.getBearingAccuracyDegrees(), localLocation1.getBearingAccuracyDegrees()) != 0)
            return false;
        }
        if (localLocation1.getProvider() != null)
        {
          if (localLocation1.getProvider().equals(localLocation2.getProvider()));
        }
        else
          while (localLocation2.getProvider() != null)
            return false;
        if (localLocation1.getExtras() != null)
          return localLocation1.getExtras().equals(localLocation2.getExtras());
      }
      while (localLocation2.getExtras() == null);
      return false;
    }

    public int hashCode()
    {
      int i1 = 31 * super.hashCode();
      int i2;
      int i4;
      label46: int i21;
      label86: int i26;
      label244: int i28;
      label274: int i30;
      label304: int i35;
      label346: int i37;
      label376: int i39;
      label406: int i33;
      label438: int i6;
      label445: int i8;
      label471: int i10;
      label497: int i12;
      label534: int i14;
      label560: int i16;
      label586: int i17;
      if (this.a != null)
      {
        i2 = this.a.hashCode();
        int i3 = 31 * (i2 + i1);
        if (this.e == null)
          break label656;
        i4 = this.e.hashCode();
        int i5 = 31 * (i4 + i3);
        if (this.f == null)
          break label710;
        Location localLocation = this.f;
        if (localLocation.getProvider() == null)
          break label662;
        i21 = localLocation.getProvider().hashCode();
        int i22 = i21 * 31 + (int)(localLocation.getTime() ^ localLocation.getTime() >>> 32);
        if (bw.a(17))
          i22 = i22 * 31 + (int)(localLocation.getElapsedRealtimeNanos() ^ localLocation.getElapsedRealtimeNanos() >>> 32);
        long l1 = Double.doubleToLongBits(localLocation.getLatitude());
        int i23 = i22 * 31 + (int)(l1 ^ l1 >>> 32);
        long l2 = Double.doubleToLongBits(localLocation.getLongitude());
        int i24 = i23 * 31 + (int)(l2 ^ l2 >>> 32);
        long l3 = Double.doubleToLongBits(localLocation.getAltitude());
        int i25 = 31 * (i24 * 31 + (int)(l3 ^ l3 >>> 32));
        if (localLocation.getSpeed() == 0.0F)
          break label668;
        i26 = Float.floatToIntBits(localLocation.getSpeed());
        int i27 = 31 * (i26 + i25);
        if (localLocation.getBearing() == 0.0F)
          break label674;
        i28 = Float.floatToIntBits(localLocation.getBearing());
        int i29 = 31 * (i28 + i27);
        if (localLocation.getAccuracy() == 0.0F)
          break label680;
        i30 = Float.floatToIntBits(localLocation.getAccuracy());
        int i31 = i30 + i29;
        if (bw.a(26))
        {
          int i34 = i31 * 31;
          if (localLocation.getVerticalAccuracyMeters() == 0.0F)
            break label686;
          i35 = Float.floatToIntBits(localLocation.getVerticalAccuracyMeters());
          int i36 = 31 * (i35 + i34);
          if (localLocation.getSpeedAccuracyMetersPerSecond() == 0.0F)
            break label692;
          i37 = Float.floatToIntBits(localLocation.getSpeedAccuracyMetersPerSecond());
          int i38 = 31 * (i37 + i36);
          if (localLocation.getBearingAccuracyDegrees() == 0.0F)
            break label698;
          i39 = Float.floatToIntBits(localLocation.getBearingAccuracyDegrees());
          i31 = i39 + i38;
        }
        int i32 = i31 * 31;
        if (localLocation.getExtras() == null)
          break label704;
        i33 = localLocation.getExtras().hashCode();
        i6 = i33 + i32;
        int i7 = 31 * (i6 + i5);
        if (this.g == null)
          break label716;
        i8 = this.g.hashCode();
        int i9 = 31 * (i8 + i7);
        if (this.h == null)
          break label722;
        i10 = this.h.hashCode();
        int i11 = 31 * (31 * (i10 + i9) + this.n.hashCode());
        if (this.i == null)
          break label728;
        i12 = this.i.hashCode();
        int i13 = 31 * (i12 + i11);
        if (this.j == null)
          break label734;
        i14 = this.j.hashCode();
        int i15 = 31 * (i14 + i13);
        if (this.k == null)
          break label740;
        i16 = this.k.hashCode();
        i17 = 31 * (i16 + i15);
        if (this.l == null)
          break label746;
      }
      label656: label662: label668: label674: label680: label686: label692: label698: label704: label710: label716: label722: label728: label734: label740: label746: for (int i18 = this.l.hashCode(); ; i18 = 0)
      {
        int i19 = 31 * (i18 + i17);
        Boolean localBoolean = this.m;
        int i20 = 0;
        if (localBoolean != null)
          i20 = this.m.hashCode();
        return i19 + i20;
        i2 = 0;
        break;
        i4 = 0;
        break label46;
        i21 = 0;
        break label86;
        i26 = 0;
        break label244;
        i28 = 0;
        break label274;
        i30 = 0;
        break label304;
        i35 = 0;
        break label346;
        i37 = 0;
        break label376;
        i39 = 0;
        break label406;
        i33 = 0;
        break label438;
        i6 = 0;
        break label445;
        i8 = 0;
        break label471;
        i10 = 0;
        break label497;
        i12 = 0;
        break label534;
        i14 = 0;
        break label560;
        i16 = 0;
        break label586;
      }
    }
  }

  public static class b extends lp.a<lr, lr.a>
  {
    private final ab c;

    public b(ab paramab)
    {
      super(paramab.b().b());
      this.c = paramab;
    }

    protected lr a()
    {
      return new lr((byte)0);
    }

    public lr a(lm.c<lr.a> paramc)
    {
      lr locallr = (lr)super.b(paramc);
      lr.a(locallr, ((lr.a)paramc.b).a);
      lr.a(locallr, this.c.F());
      locallr.d(this.c.u());
      locallr.e(oq.a(((lr.a)paramc.b).e, true));
      locallr.a(((lr.a)paramc.b).f);
      locallr.f(oq.a(((lr.a)paramc.b).g, false));
      locallr.g(oq.a(((lr.a)paramc.b).h, false));
      locallr.a(Math.max(10, oq.a(((lr.a)paramc.b).i, 10)));
      locallr.c(oq.a(((lr.a)paramc.b).j, 7));
      locallr.b(oq.a(((lr.a)paramc.b).k, 90));
      locallr.h(oq.a(((lr.a)paramc.b).l, false));
      locallr.a(((lr.a)paramc.b).n);
      locallr.i(oq.a(((lr.a)paramc.b).m, true));
      a(locallr, paramc.a);
      return locallr;
    }

    void a(lr paramlr, mw parammw)
    {
      b(paramlr, parammw);
      c(paramlr, parammw);
      paramlr.a(parammw.l);
    }

    void b(lr paramlr, mw parammw)
    {
      paramlr.a(parammw.d);
    }

    void c(lr paramlr, mw parammw)
    {
      paramlr.a(parammw.n.a);
      paramlr.b(parammw.n.b);
      paramlr.c(parammw.n.c);
      paramlr.d(parammw.n.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lr
 * JD-Core Version:    0.6.2
 */