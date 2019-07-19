package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.List;
import java.util.Map;

@KeepForSdk
public class AppMeasurementSdk
{
  private final zzea zzadd;

  public AppMeasurementSdk(zzea paramzzea)
  {
    this.zzadd = paramzzea;
  }

  @KeepForSdk
  public static AppMeasurementSdk getInstance(Context paramContext)
  {
    return zzea.zza(paramContext, null, null, null, null).zzga();
  }

  @KeepForSdk
  public static AppMeasurementSdk getInstance(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    return zzea.zza(paramContext, paramString1, paramString2, paramString3, paramBundle).zzga();
  }

  @KeepForSdk
  public void beginAdUnitExposure(String paramString)
  {
    this.zzadd.beginAdUnitExposure(paramString);
  }

  @KeepForSdk
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.zzadd.clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }

  @KeepForSdk
  public void endAdUnitExposure(String paramString)
  {
    this.zzadd.endAdUnitExposure(paramString);
  }

  @KeepForSdk
  public long generateEventId()
  {
    return this.zzadd.generateEventId();
  }

  @KeepForSdk
  public String getAppIdOrigin()
  {
    return this.zzadd.getAppIdOrigin();
  }

  @KeepForSdk
  public String getAppInstanceId()
  {
    return this.zzadd.zzgc();
  }

  @KeepForSdk
  public List<Bundle> getConditionalUserProperties(String paramString1, String paramString2)
  {
    return this.zzadd.getConditionalUserProperties(paramString1, paramString2);
  }

  @KeepForSdk
  public String getCurrentScreenClass()
  {
    return this.zzadd.getCurrentScreenClass();
  }

  @KeepForSdk
  public String getCurrentScreenName()
  {
    return this.zzadd.getCurrentScreenName();
  }

  @KeepForSdk
  public String getGmpAppId()
  {
    return this.zzadd.getGmpAppId();
  }

  @KeepForSdk
  public int getMaxUserProperties(String paramString)
  {
    return this.zzadd.getMaxUserProperties(paramString);
  }

  @KeepForSdk
  public Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.zzadd.getUserProperties(paramString1, paramString2, paramBoolean);
  }

  @KeepForSdk
  public void logEvent(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.zzadd.logEventInternal(paramString1, paramString2, paramBundle);
  }

  @KeepForSdk
  public void logEventNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    this.zzadd.logEventInternalNoInterceptor(paramString1, paramString2, paramBundle, paramLong);
  }

  @KeepForSdk
  public void performAction(Bundle paramBundle)
  {
    this.zzadd.zza(paramBundle, false);
  }

  @KeepForSdk
  public Bundle performActionWithResponse(Bundle paramBundle)
  {
    return this.zzadd.zza(paramBundle, true);
  }

  @KeepForSdk
  @ShowFirstParty
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    this.zzadd.zza(paramOnEventListener);
  }

  @KeepForSdk
  public void setConditionalUserProperty(Bundle paramBundle)
  {
    this.zzadd.setConditionalUserProperty(paramBundle);
  }

  @KeepForSdk
  public void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    this.zzadd.setCurrentScreen(paramActivity, paramString1, paramString2);
  }

  @KeepForSdk
  @ShowFirstParty
  public void setEventInterceptor(EventInterceptor paramEventInterceptor)
  {
    this.zzadd.zza(paramEventInterceptor);
  }

  @KeepForSdk
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    this.zzadd.setMeasurementEnabled(paramBoolean);
  }

  @KeepForSdk
  public void setUserProperty(String paramString1, String paramString2, Object paramObject)
  {
    this.zzadd.zza(paramString1, paramString2, paramObject, true);
  }

  @KeepForSdk
  @ShowFirstParty
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    this.zzadd.zzb(paramOnEventListener);
  }

  @KeepForSdk
  public static final class ConditionalUserProperty
  {

    @KeepForSdk
    public static final String ACTIVE = "active";

    @KeepForSdk
    public static final String CREATION_TIMESTAMP = "creation_timestamp";

    @KeepForSdk
    public static final String EXPIRED_EVENT_NAME = "expired_event_name";

    @KeepForSdk
    public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";

    @KeepForSdk
    public static final String NAME = "name";

    @KeepForSdk
    public static final String ORIGIN = "origin";

    @KeepForSdk
    public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";

    @KeepForSdk
    public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";

    @KeepForSdk
    public static final String TIME_TO_LIVE = "time_to_live";

    @KeepForSdk
    public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";

    @KeepForSdk
    public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";

    @KeepForSdk
    public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";

    @KeepForSdk
    public static final String TRIGGER_EVENT_NAME = "trigger_event_name";

    @KeepForSdk
    public static final String TRIGGER_TIMEOUT = "trigger_timeout";

    @KeepForSdk
    public static final String VALUE = "value";
  }

  @KeepForSdk
  @ShowFirstParty
  public static abstract interface EventInterceptor extends zzcx
  {
    @KeepForSdk
    @ShowFirstParty
    public abstract void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }

  @KeepForSdk
  @ShowFirstParty
  public static abstract interface OnEventListener extends zzcy
  {
    @KeepForSdk
    @ShowFirstParty
    public abstract void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.api.AppMeasurementSdk
 * JD-Core Version:    0.6.2
 */