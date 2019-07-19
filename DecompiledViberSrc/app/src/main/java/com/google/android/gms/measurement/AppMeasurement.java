package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.internal.zza;
import com.google.android.gms.measurement.internal.zzbw;
import com.google.android.gms.measurement.internal.zzcu;
import com.google.android.gms.measurement.internal.zzcv;
import com.google.android.gms.measurement.internal.zzcw;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import com.google.android.gms.measurement.internal.zzda;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzfu;
import com.google.android.gms.measurement.internal.zzfx;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
@ShowFirstParty
public class AppMeasurement
{

  @KeepForSdk
  @ShowFirstParty
  public static final String CRASH_ORIGIN = "crash";

  @KeepForSdk
  @ShowFirstParty
  public static final String FCM_ORIGIN = "fcm";

  @KeepForSdk
  @ShowFirstParty
  public static final String FIAM_ORIGIN = "fiam";
  private final zzbw zzada;

  public AppMeasurement(zzbw paramzzbw)
  {
    Preconditions.checkNotNull(paramzzbw);
    this.zzada = paramzzbw;
  }

  @Deprecated
  @Keep
  @ShowFirstParty
  public static AppMeasurement getInstance(Context paramContext)
  {
    return zzbw.zza(paramContext, null).zzkm();
  }

  @Keep
  public void beginAdUnitExposure(String paramString)
  {
    this.zzada.zzgi().beginAdUnitExposure(paramString, this.zzada.zzbx().elapsedRealtime());
  }

  @Keep
  @KeepForSdk
  @ShowFirstParty
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.zzada.zzgj().clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }

  @Keep
  @VisibleForTesting
  protected void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    this.zzada.zzgj().clearConditionalUserPropertyAs(paramString1, paramString2, paramString3, paramBundle);
  }

  @Keep
  public void endAdUnitExposure(String paramString)
  {
    this.zzada.zzgi().endAdUnitExposure(paramString, this.zzada.zzbx().elapsedRealtime());
  }

  @Keep
  public long generateEventId()
  {
    return this.zzada.zzgr().zzmj();
  }

  @Keep
  public String getAppInstanceId()
  {
    return this.zzada.zzgj().zzgc();
  }

  @KeepForSdk
  public Boolean getBoolean()
  {
    return this.zzada.zzgj().zzkx();
  }

  @Keep
  @KeepForSdk
  @ShowFirstParty
  public List<ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2)
  {
    return this.zzada.zzgj().getConditionalUserProperties(paramString1, paramString2);
  }

  @Keep
  @VisibleForTesting
  protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String paramString1, String paramString2, String paramString3)
  {
    return this.zzada.zzgj().getConditionalUserPropertiesAs(paramString1, paramString2, paramString3);
  }

  @Keep
  public String getCurrentScreenClass()
  {
    return this.zzada.zzgj().getCurrentScreenClass();
  }

  @Keep
  public String getCurrentScreenName()
  {
    return this.zzada.zzgj().getCurrentScreenName();
  }

  @KeepForSdk
  public Double getDouble()
  {
    return this.zzada.zzgj().zzlb();
  }

  @Keep
  public String getGmpAppId()
  {
    return this.zzada.zzgj().getGmpAppId();
  }

  @KeepForSdk
  public Integer getInteger()
  {
    return this.zzada.zzgj().zzla();
  }

  @KeepForSdk
  public Long getLong()
  {
    return this.zzada.zzgj().zzkz();
  }

  @Keep
  @KeepForSdk
  @ShowFirstParty
  public int getMaxUserProperties(String paramString)
  {
    this.zzada.zzgj();
    Preconditions.checkNotEmpty(paramString);
    return 25;
  }

  @KeepForSdk
  public String getString()
  {
    return this.zzada.zzgj().zzky();
  }

  @Keep
  @VisibleForTesting
  protected Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.zzada.zzgj().getUserProperties(paramString1, paramString2, paramBoolean);
  }

  @KeepForSdk
  @ShowFirstParty
  public Map<String, Object> getUserProperties(boolean paramBoolean)
  {
    List localList = this.zzada.zzgj().zzk(paramBoolean);
    ArrayMap localArrayMap = new ArrayMap(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      zzfu localzzfu = (zzfu)localIterator.next();
      localArrayMap.put(localzzfu.name, localzzfu.getValue());
    }
    return localArrayMap;
  }

  @Keep
  @VisibleForTesting
  protected Map<String, Object> getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return this.zzada.zzgj().getUserPropertiesAs(paramString1, paramString2, paramString3, paramBoolean);
  }

  @ShowFirstParty
  public final void logEvent(String paramString, Bundle paramBundle)
  {
    this.zzada.zzgj().zza("app", paramString, paramBundle, true);
  }

  @Keep
  @ShowFirstParty
  public void logEventInternal(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.zzada.zzgj().logEvent(paramString1, paramString2, paramBundle);
  }

  @KeepForSdk
  @ShowFirstParty
  public void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    this.zzada.zzgj().logEvent(paramString1, paramString2, paramBundle, true, false, paramLong);
  }

  @KeepForSdk
  @ShowFirstParty
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    this.zzada.zzgj().zza(paramOnEventListener);
  }

  @Keep
  @KeepForSdk
  @ShowFirstParty
  public void setConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
  {
    this.zzada.zzgj().setConditionalUserProperty(paramConditionalUserProperty);
  }

  @Keep
  @VisibleForTesting
  protected void setConditionalUserPropertyAs(ConditionalUserProperty paramConditionalUserProperty)
  {
    this.zzada.zzgj().setConditionalUserPropertyAs(paramConditionalUserProperty);
  }

  @KeepForSdk
  @ShowFirstParty
  public void setEventInterceptor(EventInterceptor paramEventInterceptor)
  {
    this.zzada.zzgj().zza(paramEventInterceptor);
  }

  @Deprecated
  @KeepForSdk
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    this.zzada.zzgj().setMeasurementEnabled(paramBoolean);
  }

  @Deprecated
  @ShowFirstParty
  public final void setMinimumSessionDuration(long paramLong)
  {
    this.zzada.zzgj().setMinimumSessionDuration(paramLong);
  }

  @ShowFirstParty
  public final void setSessionTimeoutDuration(long paramLong)
  {
    this.zzada.zzgj().setSessionTimeoutDuration(paramLong);
  }

  @ShowFirstParty
  public final void setUserProperty(String paramString1, String paramString2)
  {
    this.zzada.zzgj().zzb("app", paramString1, paramString2, false);
  }

  @KeepForSdk
  @ShowFirstParty
  public void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.zzada.zzgj().zzb(paramString1, paramString2, paramObject, true);
  }

  @KeepForSdk
  @ShowFirstParty
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    this.zzada.zzgj().zzb(paramOnEventListener);
  }

  public final void zzd(boolean paramBoolean)
  {
    this.zzada.zzgj().zzd(paramBoolean);
  }

  @KeepForSdk
  @ShowFirstParty
  public static class ConditionalUserProperty
  {

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public boolean mActive;

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mAppId;

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mCreationTimestamp;

    @Keep
    public String mExpiredEventName;

    @Keep
    public Bundle mExpiredEventParams;

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mName;

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mOrigin;

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTimeToLive;

    @Keep
    public String mTimedOutEventName;

    @Keep
    public Bundle mTimedOutEventParams;

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mTriggerEventName;

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTriggerTimeout;

    @Keep
    public String mTriggeredEventName;

    @Keep
    public Bundle mTriggeredEventParams;

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTriggeredTimestamp;

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public Object mValue;

    public ConditionalUserProperty()
    {
    }

    public ConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
    {
      Preconditions.checkNotNull(paramConditionalUserProperty);
      this.mAppId = paramConditionalUserProperty.mAppId;
      this.mOrigin = paramConditionalUserProperty.mOrigin;
      this.mCreationTimestamp = paramConditionalUserProperty.mCreationTimestamp;
      this.mName = paramConditionalUserProperty.mName;
      if (paramConditionalUserProperty.mValue != null)
      {
        this.mValue = zzdw.zze(paramConditionalUserProperty.mValue);
        if (this.mValue == null)
          this.mValue = paramConditionalUserProperty.mValue;
      }
      this.mActive = paramConditionalUserProperty.mActive;
      this.mTriggerEventName = paramConditionalUserProperty.mTriggerEventName;
      this.mTriggerTimeout = paramConditionalUserProperty.mTriggerTimeout;
      this.mTimedOutEventName = paramConditionalUserProperty.mTimedOutEventName;
      if (paramConditionalUserProperty.mTimedOutEventParams != null)
        this.mTimedOutEventParams = new Bundle(paramConditionalUserProperty.mTimedOutEventParams);
      this.mTriggeredEventName = paramConditionalUserProperty.mTriggeredEventName;
      if (paramConditionalUserProperty.mTriggeredEventParams != null)
        this.mTriggeredEventParams = new Bundle(paramConditionalUserProperty.mTriggeredEventParams);
      this.mTriggeredTimestamp = paramConditionalUserProperty.mTriggeredTimestamp;
      this.mTimeToLive = paramConditionalUserProperty.mTimeToLive;
      this.mExpiredEventName = paramConditionalUserProperty.mExpiredEventName;
      if (paramConditionalUserProperty.mExpiredEventParams != null)
        this.mExpiredEventParams = new Bundle(paramConditionalUserProperty.mExpiredEventParams);
    }
  }

  @KeepForSdk
  @ShowFirstParty
  public static final class Event extends zzcu
  {

    @KeepForSdk
    @ShowFirstParty
    public static final String AD_REWARD = "_ar";

    @KeepForSdk
    @ShowFirstParty
    public static final String APP_EXCEPTION = "_ae";
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

  @KeepForSdk
  @ShowFirstParty
  public static final class Param extends zzcv
  {

    @KeepForSdk
    @ShowFirstParty
    public static final String FATAL = "fatal";

    @KeepForSdk
    @ShowFirstParty
    public static final String TIMESTAMP = "timestamp";

    @KeepForSdk
    @ShowFirstParty
    public static final String TYPE = "type";
  }

  @KeepForSdk
  @ShowFirstParty
  public static final class UserProperty extends zzcw
  {

    @KeepForSdk
    @ShowFirstParty
    public static final String FIREBASE_LAST_NOTIFICATION = "_ln";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement
 * JD-Core Version:    0.6.2
 */