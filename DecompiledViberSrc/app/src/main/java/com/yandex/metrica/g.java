package com.yandex.metrica;

import android.location.Location;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class g extends YandexMetricaConfig
{
  public final String a;
  public final Map<String, String> b;
  public final String c;
  public final List<String> d;
  public final Integer e;
  public final Integer f;
  public final Integer g;
  public final Map<String, String> h;
  public final Map<String, String> i;
  public final Boolean j;
  public final Boolean k;
  public final d l;

  public g(YandexMetricaConfig paramYandexMetricaConfig)
  {
    super(paramYandexMetricaConfig);
    this.a = null;
    this.b = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.c = null;
    this.i = null;
    this.j = null;
    this.k = null;
    this.d = null;
    this.h = null;
    this.l = null;
  }

  private g(a parama)
  {
    super(a.a(parama));
    this.e = a.b(parama);
    List localList1 = a.c(parama);
    List localList2;
    Map localMap1;
    label50: Map localMap2;
    label90: Map localMap3;
    if (localList1 == null)
    {
      localList2 = null;
      this.d = localList2;
      this.a = a.d(parama);
      if (a.e(parama) != null)
        break label149;
      localMap1 = null;
      this.b = localMap1;
      this.g = a.f(parama);
      this.f = a.g(parama);
      this.c = parama.a;
      if (a.h(parama) != null)
        break label161;
      localMap2 = null;
      this.h = localMap2;
      LinkedHashMap localLinkedHashMap = a.i(parama);
      localMap3 = null;
      if (localLinkedHashMap != null)
        break label173;
    }
    while (true)
    {
      this.i = localMap3;
      this.j = a.j(parama);
      this.k = a.k(parama);
      this.l = a.l(parama);
      return;
      localList2 = Collections.unmodifiableList(localList1);
      break;
      label149: localMap1 = Collections.unmodifiableMap(a.e(parama));
      break label50;
      label161: localMap2 = Collections.unmodifiableMap(a.h(parama));
      break label90;
      label173: localMap3 = Collections.unmodifiableMap(a.i(parama));
    }
  }

  public static a a(String paramString)
  {
    return new a(paramString);
  }

  public static g a(YandexMetricaConfig paramYandexMetricaConfig)
  {
    if ((paramYandexMetricaConfig instanceof g))
      return (g)paramYandexMetricaConfig;
    return new g(paramYandexMetricaConfig);
  }

  public static a b(YandexMetricaConfig paramYandexMetricaConfig)
  {
    int m = 1;
    a locala = a(paramYandexMetricaConfig.apiKey);
    int n;
    int i1;
    label42: int i2;
    label69: int i3;
    label96: int i4;
    label123: int i5;
    label147: int i6;
    label174: int i7;
    label201: int i8;
    label231: int i9;
    label255: g localg;
    if (paramYandexMetricaConfig.appVersion != null)
    {
      n = m;
      if (n != 0)
        locala.a(paramYandexMetricaConfig.appVersion);
      if (paramYandexMetricaConfig.sessionTimeout == null)
        break label314;
      i1 = m;
      if (i1 != 0)
        locala.a(paramYandexMetricaConfig.sessionTimeout.intValue());
      if (paramYandexMetricaConfig.crashReporting == null)
        break label320;
      i2 = m;
      if (i2 != 0)
        locala.a(paramYandexMetricaConfig.crashReporting.booleanValue());
      if (paramYandexMetricaConfig.nativeCrashReporting == null)
        break label326;
      i3 = m;
      if (i3 != 0)
        locala.b(paramYandexMetricaConfig.nativeCrashReporting.booleanValue());
      if (paramYandexMetricaConfig.location == null)
        break label332;
      i4 = m;
      if (i4 != 0)
        locala.a(paramYandexMetricaConfig.location);
      if (paramYandexMetricaConfig.locationTracking == null)
        break label338;
      i5 = m;
      if (i5 != 0)
        locala.c(paramYandexMetricaConfig.locationTracking.booleanValue());
      if (paramYandexMetricaConfig.installedAppCollecting == null)
        break label344;
      i6 = m;
      if (i6 != 0)
        locala.d(paramYandexMetricaConfig.installedAppCollecting.booleanValue());
      if (paramYandexMetricaConfig.logs == null)
        break label350;
      i7 = m;
      if ((i7 != 0) && (paramYandexMetricaConfig.logs.booleanValue()))
        locala.a();
      if (paramYandexMetricaConfig.preloadInfo == null)
        break label356;
      i8 = m;
      if (i8 != 0)
        locala.a(paramYandexMetricaConfig.preloadInfo);
      if (paramYandexMetricaConfig.firstActivationAsUpdate == null)
        break label362;
      i9 = m;
      if (i9 != 0)
        locala.f(paramYandexMetricaConfig.firstActivationAsUpdate.booleanValue());
      if ((paramYandexMetricaConfig instanceof g))
      {
        localg = (g)paramYandexMetricaConfig;
        if (localg.d == null)
          break label368;
      }
    }
    while (true)
    {
      if (m != 0)
        locala.a(localg.d);
      return locala;
      n = 0;
      break;
      label314: i1 = 0;
      break label42;
      label320: i2 = 0;
      break label69;
      label326: i3 = 0;
      break label96;
      label332: i4 = 0;
      break label123;
      label338: i5 = 0;
      break label147;
      label344: i6 = 0;
      break label174;
      label350: i7 = 0;
      break label201;
      label356: i8 = 0;
      break label231;
      label362: i9 = 0;
      break label255;
      label368: m = 0;
    }
  }

  public static final class a
  {
    public String a;
    private YandexMetricaConfig.Builder b;
    private String c;
    private List<String> d;
    private Integer e;
    private Map<String, String> f;
    private Integer g;
    private Integer h;
    private LinkedHashMap<String, String> i = new LinkedHashMap();
    private LinkedHashMap<String, String> j = new LinkedHashMap();
    private Boolean k;
    private Boolean l;
    private d m;

    protected a(String paramString)
    {
      this.b = YandexMetricaConfig.newConfigBuilder(paramString);
    }

    public a a()
    {
      this.b.withLogs();
      return this;
    }

    public a a(int paramInt)
    {
      this.b.withSessionTimeout(paramInt);
      return this;
    }

    public a a(Location paramLocation)
    {
      this.b.withLocation(paramLocation);
      return this;
    }

    public a a(PreloadInfo paramPreloadInfo)
    {
      this.b.withPreloadInfo(paramPreloadInfo);
      return this;
    }

    public a a(d paramd)
    {
      this.m = paramd;
      return this;
    }

    public a a(String paramString)
    {
      this.b.withAppVersion(paramString);
      return this;
    }

    public a a(String paramString1, String paramString2)
    {
      this.i.put(paramString1, paramString2);
      return this;
    }

    public a a(List<String> paramList)
    {
      this.d = paramList;
      return this;
    }

    public a a(Map<String, String> paramMap, Boolean paramBoolean)
    {
      this.k = paramBoolean;
      this.f = paramMap;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.b.withCrashReporting(paramBoolean);
      return this;
    }

    public a b(int paramInt)
    {
      if (paramInt < 0)
        throw new IllegalArgumentException(String.format(Locale.US, "Invalid %1$s. %1$s should be positive.", new Object[] { "App Build Number" }));
      this.e = Integer.valueOf(paramInt);
      return this;
    }

    public a b(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public a b(String paramString1, String paramString2)
    {
      this.j.put(paramString1, paramString2);
      return this;
    }

    public a b(boolean paramBoolean)
    {
      this.b.withNativeCrashReporting(paramBoolean);
      return this;
    }

    public g b()
    {
      return new g(this, (byte)0);
    }

    public a c(int paramInt)
    {
      this.h = Integer.valueOf(paramInt);
      return this;
    }

    public a c(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public a c(boolean paramBoolean)
    {
      this.b.withLocationTracking(paramBoolean);
      return this;
    }

    public a d(int paramInt)
    {
      this.g = Integer.valueOf(paramInt);
      return this;
    }

    public a d(boolean paramBoolean)
    {
      this.b.withInstalledAppCollecting(paramBoolean);
      return this;
    }

    public a e(boolean paramBoolean)
    {
      this.b.withStatisticsSending(paramBoolean);
      return this;
    }

    public a f(boolean paramBoolean)
    {
      this.b.handleFirstActivationAsUpdate(paramBoolean);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.g
 * JD-Core Version:    0.6.2
 */