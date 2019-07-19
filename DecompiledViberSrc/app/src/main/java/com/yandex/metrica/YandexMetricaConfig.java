package com.yandex.metrica;

import android.location.Location;
import com.yandex.metrica.impl.af;
import com.yandex.metrica.impl.ob.pt;
import com.yandex.metrica.impl.ob.px;
import com.yandex.metrica.impl.ob.py;

public class YandexMetricaConfig
{
  public final String apiKey;
  public final String appVersion;
  public final Boolean crashReporting;
  public final Boolean firstActivationAsUpdate;
  public final Boolean installedAppCollecting;
  public final Location location;
  public final Boolean locationTracking;
  public final Boolean logs;
  public final Boolean nativeCrashReporting;
  public final PreloadInfo preloadInfo;
  public final Integer sessionTimeout;
  public final Boolean statisticsSending;

  protected YandexMetricaConfig(Builder paramBuilder)
  {
    this.apiKey = Builder.a(paramBuilder);
    this.appVersion = Builder.b(paramBuilder);
    this.sessionTimeout = Builder.c(paramBuilder);
    this.crashReporting = Builder.d(paramBuilder);
    this.nativeCrashReporting = Builder.e(paramBuilder);
    this.location = Builder.f(paramBuilder);
    this.locationTracking = Builder.g(paramBuilder);
    this.installedAppCollecting = Builder.h(paramBuilder);
    this.logs = Builder.i(paramBuilder);
    this.preloadInfo = Builder.j(paramBuilder);
    this.firstActivationAsUpdate = Builder.k(paramBuilder);
    this.statisticsSending = Builder.l(paramBuilder);
  }

  protected YandexMetricaConfig(YandexMetricaConfig paramYandexMetricaConfig)
  {
    this.apiKey = paramYandexMetricaConfig.apiKey;
    this.appVersion = paramYandexMetricaConfig.appVersion;
    this.sessionTimeout = paramYandexMetricaConfig.sessionTimeout;
    this.crashReporting = paramYandexMetricaConfig.crashReporting;
    this.nativeCrashReporting = paramYandexMetricaConfig.nativeCrashReporting;
    this.location = paramYandexMetricaConfig.location;
    this.locationTracking = paramYandexMetricaConfig.locationTracking;
    this.installedAppCollecting = paramYandexMetricaConfig.installedAppCollecting;
    this.logs = paramYandexMetricaConfig.logs;
    this.preloadInfo = paramYandexMetricaConfig.preloadInfo;
    this.firstActivationAsUpdate = paramYandexMetricaConfig.firstActivationAsUpdate;
    this.statisticsSending = paramYandexMetricaConfig.statisticsSending;
  }

  public static YandexMetricaConfig fromJson(String paramString)
  {
    return new af().a(paramString);
  }

  public static Builder newConfigBuilder(String paramString)
  {
    return new Builder(paramString);
  }

  public String toJson()
  {
    return new af().a(this);
  }

  public static class Builder
  {
    private static final px<String> a = new pt(new py());
    private final String b;
    private String c;
    private Integer d;
    private Boolean e;
    private Boolean f;
    private Location g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private PreloadInfo k;
    private Boolean l;
    private Boolean m;

    protected Builder(String paramString)
    {
      a.a(paramString);
      this.b = paramString;
    }

    public YandexMetricaConfig build()
    {
      return new YandexMetricaConfig(this);
    }

    public Builder handleFirstActivationAsUpdate(boolean paramBoolean)
    {
      this.l = Boolean.valueOf(paramBoolean);
      return this;
    }

    public Builder withAppVersion(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public Builder withCrashReporting(boolean paramBoolean)
    {
      this.e = Boolean.valueOf(paramBoolean);
      return this;
    }

    public Builder withInstalledAppCollecting(boolean paramBoolean)
    {
      this.i = Boolean.valueOf(paramBoolean);
      return this;
    }

    public Builder withLocation(Location paramLocation)
    {
      this.g = paramLocation;
      return this;
    }

    public Builder withLocationTracking(boolean paramBoolean)
    {
      this.h = Boolean.valueOf(paramBoolean);
      return this;
    }

    public Builder withLogs()
    {
      this.j = Boolean.TRUE;
      return this;
    }

    public Builder withNativeCrashReporting(boolean paramBoolean)
    {
      this.f = Boolean.valueOf(paramBoolean);
      return this;
    }

    public Builder withPreloadInfo(PreloadInfo paramPreloadInfo)
    {
      this.k = paramPreloadInfo;
      return this;
    }

    public Builder withSessionTimeout(int paramInt)
    {
      this.d = Integer.valueOf(paramInt);
      return this;
    }

    public Builder withStatisticsSending(boolean paramBoolean)
    {
      this.m = Boolean.valueOf(paramBoolean);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.YandexMetricaConfig
 * JD-Core Version:    0.6.2
 */