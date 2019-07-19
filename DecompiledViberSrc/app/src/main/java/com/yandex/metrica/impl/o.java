package com.yandex.metrica.impl;

import android.location.Location;
import com.yandex.metrica.g;
import com.yandex.metrica.g.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class o
  implements ag
{
  private Location a;
  private Boolean b;
  private Boolean c;
  private Map<String, String> d = new LinkedHashMap();
  private Map<String, String> e = new LinkedHashMap();
  private boolean f;
  private boolean g;
  private bj h;

  private static void a(Map<String, String> paramMap, g.a parama)
  {
    if (!bw.a(paramMap))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        parama.b((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }

  private static void b(Map<String, String> paramMap, g.a parama)
  {
    if (!bw.a(paramMap))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        parama.a((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }

  private void e()
  {
    if (this.h != null)
      this.h.a(this.b, this.c);
  }

  public Location a()
  {
    return this.a;
  }

  public g a(g paramg)
  {
    if (this.g)
      return paramg;
    g.a locala = g.a(paramg.apiKey);
    locala.a(paramg.b, paramg.j);
    locala.c(paramg.a);
    locala.a(paramg.preloadInfo);
    locala.a(paramg.location);
    locala.a(paramg.l);
    int i;
    int j;
    label100: int k;
    label124: int m;
    label151: int n;
    label178: int i1;
    label205: int i2;
    label235: int i3;
    label262: int i4;
    label289: int i5;
    label316: int i6;
    label343: int i7;
    label370: int i8;
    label394: int i9;
    label421: int i10;
    label486: int i15;
    label499: int i11;
    label530: int i14;
    label543: Boolean localBoolean2;
    int i12;
    if (paramg.d != null)
    {
      i = 1;
      if (i != 0)
        locala.a(paramg.d);
      if (paramg.appVersion == null)
        break label653;
      j = 1;
      if (j != 0)
        locala.a(paramg.appVersion);
      if (paramg.f == null)
        break label659;
      k = 1;
      if (k != 0)
        locala.d(paramg.f.intValue());
      if (paramg.e == null)
        break label665;
      m = 1;
      if (m != 0)
        locala.b(paramg.e.intValue());
      if (paramg.g == null)
        break label671;
      n = 1;
      if (n != 0)
        locala.c(paramg.g.intValue());
      if (paramg.logs == null)
        break label677;
      i1 = 1;
      if ((i1 != 0) && (paramg.logs.booleanValue()))
        locala.a();
      if (paramg.sessionTimeout == null)
        break label683;
      i2 = 1;
      if (i2 != 0)
        locala.a(paramg.sessionTimeout.intValue());
      if (paramg.crashReporting == null)
        break label689;
      i3 = 1;
      if (i3 != 0)
        locala.a(paramg.crashReporting.booleanValue());
      if (paramg.nativeCrashReporting == null)
        break label695;
      i4 = 1;
      if (i4 != 0)
        locala.b(paramg.nativeCrashReporting.booleanValue());
      if (paramg.locationTracking == null)
        break label701;
      i5 = 1;
      if (i5 != 0)
        locala.c(paramg.locationTracking.booleanValue());
      if (paramg.installedAppCollecting == null)
        break label707;
      i6 = 1;
      if (i6 != 0)
        locala.d(paramg.installedAppCollecting.booleanValue());
      if (paramg.c == null)
        break label713;
      i7 = 1;
      if (i7 != 0)
        locala.b(paramg.c);
      if (paramg.firstActivationAsUpdate == null)
        break label719;
      i8 = 1;
      if (i8 != 0)
        locala.f(paramg.firstActivationAsUpdate.booleanValue());
      if (paramg.statisticsSending == null)
        break label725;
      i9 = 1;
      if (i9 != 0)
        locala.e(paramg.statisticsSending.booleanValue());
      a(this.d, locala);
      a(paramg.i, locala);
      b(this.e, locala);
      b(paramg.h, locala);
      Boolean localBoolean1 = b();
      if (paramg.locationTracking != null)
        break label731;
      i10 = 1;
      if (i10 != 0)
      {
        if (localBoolean1 == null)
          break label737;
        i15 = 1;
        if (i15 != 0)
          locala.c(localBoolean1.booleanValue());
      }
      Location localLocation = a();
      if (paramg.location != null)
        break label743;
      i11 = 1;
      if (i11 != 0)
      {
        if (localLocation == null)
          break label749;
        i14 = 1;
        if (i14 != 0)
          locala.a(localLocation);
      }
      localBoolean2 = c();
      if (paramg.statisticsSending != null)
        break label755;
      i12 = 1;
      label571: if (i12 != 0)
        if (localBoolean2 == null)
          break label761;
    }
    label653: label659: label665: label671: label677: label683: label689: label695: label701: label707: label713: label719: label725: label731: label737: label743: label749: label755: label761: for (int i13 = 1; ; i13 = 0)
    {
      if (i13 != 0)
        locala.e(localBoolean2.booleanValue());
      this.g = true;
      this.a = null;
      this.b = null;
      this.c = null;
      this.d.clear();
      this.e.clear();
      this.f = false;
      return locala.b();
      i = 0;
      break;
      j = 0;
      break label100;
      k = 0;
      break label124;
      m = 0;
      break label151;
      n = 0;
      break label178;
      i1 = 0;
      break label205;
      i2 = 0;
      break label235;
      i3 = 0;
      break label262;
      i4 = 0;
      break label289;
      i5 = 0;
      break label316;
      i6 = 0;
      break label343;
      i7 = 0;
      break label370;
      i8 = 0;
      break label394;
      i9 = 0;
      break label421;
      i10 = 0;
      break label486;
      i15 = 0;
      break label499;
      i11 = 0;
      break label530;
      i14 = 0;
      break label543;
      i12 = 0;
      break label571;
    }
  }

  public void a(Location paramLocation)
  {
    this.a = paramLocation;
  }

  public void a(bj parambj)
  {
    this.h = parambj;
  }

  public void a(boolean paramBoolean)
  {
    this.b = Boolean.valueOf(paramBoolean);
    e();
  }

  public Boolean b()
  {
    return this.b;
  }

  public Boolean c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.f;
  }

  public void setStatisticsSending(boolean paramBoolean)
  {
    this.c = Boolean.valueOf(paramBoolean);
    e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.o
 * JD-Core Version:    0.6.2
 */