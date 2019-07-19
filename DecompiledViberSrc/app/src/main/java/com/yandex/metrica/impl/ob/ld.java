package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.YandexMetricaConfig;

public class ld extends lf
{
  private static final px<YandexMetricaConfig> f = new pt(new ps("Config"));
  private static final px<String> g = new pt(new pr("Native crash"));
  private static final px<Activity> h = new pt(new ps("Activity"));
  private static final px<Application> i = new pt(new ps("Application"));
  private static final px<Context> j = new pt(new ps("Context"));
  private static final px<DeferredDeeplinkParametersListener> k = new pt(new ps("Deeplink listener"));
  private static final px<AppMetricaDeviceIDListener> l = new pt(new ps("DeviceID listener"));
  private static final px<ReporterConfig> m = new pt(new ps("Reporter Config"));
  private static final px<String> n = new pt(new pr("Deeplink"));
  private static final px<String> o = new pt(new pr("Referral url"));
  private static final px<String> p = new pt(new py());

  public void a(Activity paramActivity)
  {
    h.a(paramActivity);
  }

  public void a(Application paramApplication)
  {
    i.a(paramApplication);
  }

  public void a(Context paramContext)
  {
    j.a(paramContext);
  }

  public void a(Context paramContext, ReporterConfig paramReporterConfig)
  {
    j.a(paramContext);
    m.a(paramReporterConfig);
  }

  public void a(Context paramContext, YandexMetricaConfig paramYandexMetricaConfig)
  {
    j.a(paramContext);
    f.a(paramYandexMetricaConfig);
  }

  public void a(Context paramContext, String paramString)
  {
    j.a(paramContext);
    p.a(paramString);
  }

  public void a(AppMetricaDeviceIDListener paramAppMetricaDeviceIDListener)
  {
    l.a(paramAppMetricaDeviceIDListener);
  }

  public void a(DeferredDeeplinkParametersListener paramDeferredDeeplinkParametersListener)
  {
    k.a(paramDeferredDeeplinkParametersListener);
  }

  public void a(String paramString)
  {
    g.a(paramString);
  }

  public void b(Context paramContext)
  {
    j.a(paramContext);
  }

  public void b(String paramString)
  {
    n.a(paramString);
  }

  public void c(String paramString)
  {
    o.a(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ld
 * JD-Core Version:    0.6.2
 */