package com.yandex.metrica;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.Location;
import com.yandex.metrica.a.a;
import com.yandex.metrica.impl.bz;
import com.yandex.metrica.impl.ob.lc;
import java.util.Map;

public final class YandexMetrica
{
  private static final lc a = new lc(bz.a());

  public static void activate(Context paramContext, YandexMetricaConfig paramYandexMetricaConfig)
  {
    a.a(paramContext, paramYandexMetricaConfig);
  }

  public static void activateReporter(Context paramContext, ReporterConfig paramReporterConfig)
  {
    a.a(paramContext, paramReporterConfig);
  }

  public static void enableActivityAutoTracking(Application paramApplication)
  {
    a.a(paramApplication);
  }

  public static int getLibraryApiLevel()
  {
    return 72;
  }

  public static String getLibraryVersion()
  {
    return "3.4.0";
  }

  public static IReporter getReporter(Context paramContext, String paramString)
  {
    return a.a(paramContext, paramString);
  }

  public static void pauseSession(Activity paramActivity)
  {
    a.b(paramActivity);
  }

  public static void registerReferrerBroadcastReceivers(BroadcastReceiver[] paramArrayOfBroadcastReceiver)
  {
    MetricaEventHandler.a(paramArrayOfBroadcastReceiver);
  }

  public static void reportAppOpen(Activity paramActivity)
  {
    a.c(paramActivity);
  }

  public static void reportAppOpen(String paramString)
  {
    a.c(paramString);
  }

  public static void reportError(String paramString, Throwable paramThrowable)
  {
    a.a(paramString, paramThrowable);
  }

  public static void reportEvent(String paramString)
  {
    a.a(paramString);
  }

  public static void reportEvent(String paramString1, String paramString2)
  {
    a.a(paramString1, paramString2);
  }

  public static void reportEvent(String paramString, Map<String, Object> paramMap)
  {
    a.a(paramString, paramMap);
  }

  public static void reportNativeCrash(String paramString)
  {
    a.b(paramString);
  }

  public static void reportReferralUrl(String paramString)
  {
    a.d(paramString);
  }

  public static void reportRevenue(Revenue paramRevenue)
  {
    a.a(paramRevenue);
  }

  public static void reportUnhandledException(Throwable paramThrowable)
  {
    a.a(paramThrowable);
  }

  public static void reportUserProfile(a parama)
  {
    a.a(parama);
  }

  public static void requestAppMetricaDeviceID(AppMetricaDeviceIDListener paramAppMetricaDeviceIDListener)
  {
    a.a(paramAppMetricaDeviceIDListener);
  }

  public static void requestDeferredDeeplinkParameters(DeferredDeeplinkParametersListener paramDeferredDeeplinkParametersListener)
  {
    a.a(paramDeferredDeeplinkParametersListener);
  }

  public static void resumeSession(Activity paramActivity)
  {
    a.a(paramActivity);
  }

  public static void sendEventsBuffer()
  {
    a.e();
  }

  public static void setLocation(Location paramLocation)
  {
    a.a(paramLocation);
  }

  public static void setLocationTracking(Context paramContext, boolean paramBoolean)
  {
    a.a(paramContext, paramBoolean);
  }

  public static void setLocationTracking(boolean paramBoolean)
  {
    a.a(paramBoolean);
  }

  public static void setStatisticsSending(Context paramContext, boolean paramBoolean)
  {
    a.b(paramContext, paramBoolean);
  }

  public static void setUserProfileID(String paramString)
  {
    a.e(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.YandexMetrica
 * JD-Core Version:    0.6.2
 */