package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzda extends zzf
{

  @VisibleForTesting
  protected zzdu zzara;
  private zzcx zzarb;
  private final Set<zzcy> zzarc = new CopyOnWriteArraySet();
  private boolean zzard;
  private final AtomicReference<String> zzare = new AtomicReference();

  @VisibleForTesting
  protected boolean zzarf = true;

  protected zzda(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  private final void zza(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    long l1 = zzbx().currentTimeMillis();
    Preconditions.checkNotNull(paramConditionalUserProperty);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mName);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mOrigin);
    Preconditions.checkNotNull(paramConditionalUserProperty.mValue);
    paramConditionalUserProperty.mCreationTimestamp = l1;
    String str = paramConditionalUserProperty.mName;
    Object localObject1 = paramConditionalUserProperty.mValue;
    if (zzgr().zzcv(str) != 0)
    {
      zzgt().zzjg().zzg("Invalid conditional user property name", zzgq().zzbv(str));
      return;
    }
    if (zzgr().zzi(str, localObject1) != 0)
    {
      zzgt().zzjg().zze("Invalid conditional user property value", zzgq().zzbv(str), localObject1);
      return;
    }
    Object localObject2 = zzgr().zzj(str, localObject1);
    if (localObject2 == null)
    {
      zzgt().zzjg().zze("Unable to normalize conditional user property value", zzgq().zzbv(str), localObject1);
      return;
    }
    paramConditionalUserProperty.mValue = localObject2;
    long l2 = paramConditionalUserProperty.mTriggerTimeout;
    if ((!TextUtils.isEmpty(paramConditionalUserProperty.mTriggerEventName)) && ((l2 > 15552000000L) || (l2 < 1L)))
    {
      zzgt().zzjg().zze("Invalid conditional user property timeout", zzgq().zzbv(str), Long.valueOf(l2));
      return;
    }
    long l3 = paramConditionalUserProperty.mTimeToLive;
    if ((l3 > 15552000000L) || (l3 < 1L))
    {
      zzgt().zzjg().zze("Invalid conditional user property time to live", zzgq().zzbv(str), Long.valueOf(l3));
      return;
    }
    zzgs().zzc(new zzdi(this, paramConditionalUserProperty));
  }

  private final void zza(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    Preconditions.checkNotEmpty(paramString1);
    if (!zzgv().zze(paramString3, zzai.zzali))
      Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotNull(paramBundle);
    zzaf();
    zzcl();
    if (!this.zzada.isEnabled())
      zzgt().zzjn().zzby("Event not sent since app measurement is disabled");
    label325: label331: zzdx localzzdx1;
    boolean bool2;
    do
    {
      return;
      if (!this.zzard)
        this.zzard = true;
      try
      {
        Class localClass = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
        try
        {
          Method localMethod = localClass.getDeclaredMethod("initialize", new Class[] { Context.class });
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = getContext();
          localMethod.invoke(null, arrayOfObject);
          if (paramBoolean3)
          {
            zzgw();
            if (!"_iap".equals(paramString2))
            {
              localzzfx = this.zzada.zzgr();
              if (!localzzfx.zzs("event", paramString2))
              {
                i5 = 2;
                if (i5 == 0)
                  break label331;
                zzgt().zzji().zzg("Invalid public event name. Event will not be logged (FE)", zzgq().zzbt(paramString2));
                this.zzada.zzgr();
                String str4 = zzfx.zza(paramString2, 40, true);
                if (paramString2 == null)
                  break label325;
                i6 = paramString2.length();
                this.zzada.zzgr().zza(i5, "_ev", str4, i6);
              }
            }
          }
        }
        catch (Exception localException)
        {
          while (true)
            zzgt().zzjj().zzg("Failed to invoke Tag Manager's initialize() method", localException);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        while (true)
        {
          zzfx localzzfx;
          int i5;
          int i6;
          zzgt().zzjm().zzby("Tag Manager is not found and thus will not be used");
          continue;
          if (!localzzfx.zza("event", zzcu.zzaqt, paramString2))
          {
            i5 = 13;
          }
          else if (!localzzfx.zza("event", 40, paramString2))
          {
            i5 = 2;
          }
          else
          {
            i5 = 0;
            continue;
            i6 = 0;
          }
        }
        zzgw();
        localzzdx1 = zzgm().zzle();
        if ((localzzdx1 != null) && (!paramBundle.containsKey("_sc")))
          localzzdx1.zzars = true;
        if ((paramBoolean1) && (paramBoolean3));
        for (boolean bool1 = true; ; bool1 = false)
        {
          zzdy.zza(localzzdx1, paramBundle, bool1);
          bool2 = "am".equals(paramString1);
          boolean bool3 = zzfx.zzcy(paramString2);
          if ((!paramBoolean1) || (this.zzarb == null) || (bool3) || (bool2))
            break;
          zzgt().zzjn().zze("Passing event to registered event handler (FE)", zzgq().zzbt(paramString2), zzgq().zzd(paramBundle));
          this.zzarb.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
          return;
        }
      }
    }
    while (!this.zzada.zzkv());
    int i = zzgr().zzcu(paramString2);
    if (i != 0)
    {
      zzgt().zzji().zzg("Invalid event name. Event will not be logged (FE)", zzgq().zzbt(paramString2));
      zzgr();
      String str3 = zzfx.zza(paramString2, 40, true);
      if (paramString2 != null);
      for (int i4 = paramString2.length(); ; i4 = 0)
      {
        this.zzada.zzgr().zza(paramString3, i, "_ev", str3, i4);
        return;
      }
    }
    List localList = CollectionUtils.listOf(new String[] { "_o", "_sn", "_sc", "_si" });
    Bundle localBundle1 = zzgr().zza(paramString3, paramString2, paramBundle, localList, paramBoolean3, true);
    zzdx localzzdx2;
    if ((localBundle1 == null) || (!localBundle1.containsKey("_sc")) || (!localBundle1.containsKey("_si")))
    {
      localzzdx2 = null;
      if (localzzdx2 != null)
        break label1515;
    }
    label1303: label1453: label1459: label1466: label1508: label1515: for (zzdx localzzdx3 = localzzdx1; ; localzzdx3 = localzzdx2)
    {
      if (zzgv().zzbk(paramString3))
      {
        zzgw();
        if ((zzgm().zzle() != null) && ("_ae".equals(paramString2)))
        {
          long l2 = zzgo().zzlp();
          if (l2 > 0L)
            zzgr().zza(localBundle1, l2);
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localBundle1);
      long l1 = zzgr().zzmk().nextLong();
      if ((zzgv().zze(zzgk().zzal(), zzai.zzaky)) && (zzgu().zzanq.get() > 0L) && (zzgu().zzaf(paramLong)) && (zzgu().zzant.get()))
      {
        zzgt().zzjo().zzby("Current session is expired, remove the session number and Id");
        if (zzgv().zze(zzgk().zzal(), zzai.zzaku))
          zza("auto", "_sid", null, zzbx().currentTimeMillis());
        if (zzgv().zze(zzgk().zzal(), zzai.zzakv))
          zza("auto", "_sno", null, zzbx().currentTimeMillis());
      }
      if ((zzgv().zzbj(zzgk().zzal())) && (localBundle1.getLong("extend_session", 0L) == 1L))
      {
        zzgt().zzjo().zzby("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
        this.zzada.zzgo().zza(paramLong, true);
      }
      int j = 0;
      String[] arrayOfString = (String[])localBundle1.keySet().toArray(new String[paramBundle.size()]);
      Arrays.sort(arrayOfString);
      int k = arrayOfString.length;
      int m = 0;
      label1008: Bundle[] arrayOfBundle;
      if (m < k)
      {
        String str2 = arrayOfString[m];
        Object localObject = localBundle1.get(str2);
        zzgr();
        arrayOfBundle = zzfx.zzf(localObject);
        if (arrayOfBundle == null)
          break label1508;
        localBundle1.putInt(str2, arrayOfBundle.length);
        int i3 = 0;
        while (true)
          if (i3 < arrayOfBundle.length)
          {
            Bundle localBundle4 = arrayOfBundle[i3];
            zzdy.zza(localzzdx3, localBundle4, true);
            Bundle localBundle5 = zzgr().zza(paramString3, "_ep", localBundle4, localList, paramBoolean3, false);
            localBundle5.putString("_en", paramString2);
            localBundle5.putLong("_eid", l1);
            localBundle5.putString("_gn", str2);
            localBundle5.putInt("_ll", arrayOfBundle.length);
            localBundle5.putInt("_i", i3);
            localArrayList.add(localBundle5);
            i3++;
            continue;
            localzzdx2 = new zzdx(localBundle1.getString("_sn"), localBundle1.getString("_sc"), Long.valueOf(localBundle1.getLong("_si")).longValue());
            break;
          }
      }
      for (int i2 = j + arrayOfBundle.length; ; i2 = j)
      {
        m++;
        j = i2;
        break label1008;
        if (j != 0)
        {
          localBundle1.putLong("_eid", l1);
          localBundle1.putInt("_epc", j);
        }
        for (int n = 0; n < localArrayList.size(); n++)
        {
          Bundle localBundle2 = (Bundle)localArrayList.get(n);
          int i1;
          String str1;
          if (n != 0)
          {
            i1 = 1;
            if (i1 == 0)
              break label1453;
            str1 = "_ep";
            localBundle2.putString("_o", paramString1);
            if (!paramBoolean2)
              break label1459;
          }
          for (Bundle localBundle3 = zzgr().zze(localBundle2); ; localBundle3 = localBundle2)
          {
            zzgt().zzjn().zze("Logging event (FE)", zzgq().zzbt(paramString2), zzgq().zzd(localBundle3));
            zzag localzzag = new zzag(str1, new zzad(localBundle3), paramString1, paramLong);
            zzgl().zzc(localzzag, paramString3);
            if (bool2)
              break label1466;
            Iterator localIterator = this.zzarc.iterator();
            while (localIterator.hasNext())
              ((zzcy)localIterator.next()).onEvent(paramString1, paramString2, new Bundle(localBundle3), paramLong);
            i1 = 0;
            break;
            str1 = paramString2;
            break label1303;
          }
        }
        zzgw();
        if ((zzgm().zzle() == null) || (!"_ae".equals(paramString2)))
          break;
        zzgo().zza(true, true);
        return;
      }
    }
  }

  private final void zza(String paramString1, String paramString2, long paramLong, Object paramObject)
  {
    zzgs().zzc(new zzdd(this, paramString1, paramString2, paramObject, paramLong));
  }

  private final void zza(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    long l = zzbx().currentTimeMillis();
    Preconditions.checkNotEmpty(paramString2);
    AppMeasurement.ConditionalUserProperty localConditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
    localConditionalUserProperty.mAppId = paramString1;
    localConditionalUserProperty.mName = paramString2;
    localConditionalUserProperty.mCreationTimestamp = l;
    if (paramString3 != null)
    {
      localConditionalUserProperty.mExpiredEventName = paramString3;
      localConditionalUserProperty.mExpiredEventParams = paramBundle;
    }
    zzgs().zzc(new zzdj(this, localConditionalUserProperty));
  }

  private final String zzah(long paramLong)
  {
    synchronized (new AtomicReference())
    {
      zzgs().zzc(new zzdf(this, ???));
      try
      {
        ???.wait(paramLong);
        return (String)???.get();
      }
      catch (InterruptedException localInterruptedException)
      {
        zzgt().zzjj().zzby("Interrupted waiting for app instance id");
        return null;
      }
    }
  }

  @VisibleForTesting
  private final Map<String, Object> zzb(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (zzgs().zzkf())
    {
      zzgt().zzjg().zzby("Cannot get user properties from analytics worker thread");
      return Collections.emptyMap();
    }
    if (zzn.isMainThread())
    {
      zzgt().zzjg().zzby("Cannot get user properties from main thread");
      return Collections.emptyMap();
    }
    List localList;
    synchronized (new AtomicReference())
    {
      this.zzada.zzgs().zzc(new zzdm(this, ???, paramString1, paramString2, paramString3, paramBoolean));
      try
      {
        ???.wait(5000L);
        localList = (List)???.get();
        if (localList == null)
        {
          zzgt().zzjj().zzby("Timed out waiting for get user properties");
          return Collections.emptyMap();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          zzgt().zzjj().zzg("Interrupted waiting for get user properties", localInterruptedException);
      }
    }
    ArrayMap localArrayMap = new ArrayMap(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      zzfu localzzfu = (zzfu)localIterator.next();
      localArrayMap.put(localzzfu.name, localzzfu.getValue());
    }
    return localArrayMap;
  }

  private final void zzb(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    zzaf();
    zzcl();
    Preconditions.checkNotNull(paramConditionalUserProperty);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mName);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mOrigin);
    Preconditions.checkNotNull(paramConditionalUserProperty.mValue);
    if (!this.zzada.isEnabled())
    {
      zzgt().zzjn().zzby("Conditional property not sent since collection is disabled");
      return;
    }
    zzfu localzzfu = new zzfu(paramConditionalUserProperty.mName, paramConditionalUserProperty.mTriggeredTimestamp, paramConditionalUserProperty.mValue, paramConditionalUserProperty.mOrigin);
    try
    {
      zzag localzzag1 = zzgr().zza(paramConditionalUserProperty.mAppId, paramConditionalUserProperty.mTriggeredEventName, paramConditionalUserProperty.mTriggeredEventParams, paramConditionalUserProperty.mOrigin, 0L, true, false);
      zzag localzzag2 = zzgr().zza(paramConditionalUserProperty.mAppId, paramConditionalUserProperty.mTimedOutEventName, paramConditionalUserProperty.mTimedOutEventParams, paramConditionalUserProperty.mOrigin, 0L, true, false);
      zzag localzzag3 = zzgr().zza(paramConditionalUserProperty.mAppId, paramConditionalUserProperty.mExpiredEventName, paramConditionalUserProperty.mExpiredEventParams, paramConditionalUserProperty.mOrigin, 0L, true, false);
      zzo localzzo = new zzo(paramConditionalUserProperty.mAppId, paramConditionalUserProperty.mOrigin, localzzfu, paramConditionalUserProperty.mCreationTimestamp, false, paramConditionalUserProperty.mTriggerEventName, localzzag2, paramConditionalUserProperty.mTriggerTimeout, localzzag1, paramConditionalUserProperty.mTimeToLive, localzzag3);
      zzgl().zzd(localzzo);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
  }

  private final void zzb(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    Bundle localBundle = zzfx.zzf(paramBundle);
    zzgs().zzc(new zzdc(this, paramString1, paramString2, paramLong, localBundle, paramBoolean1, paramBoolean2, paramBoolean3, paramString3));
  }

  private final void zzc(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    zzaf();
    zzcl();
    Preconditions.checkNotNull(paramConditionalUserProperty);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mName);
    if (!this.zzada.isEnabled())
    {
      zzgt().zzjn().zzby("Conditional property not cleared since collection is disabled");
      return;
    }
    zzfu localzzfu = new zzfu(paramConditionalUserProperty.mName, 0L, null, null);
    try
    {
      zzag localzzag = zzgr().zza(paramConditionalUserProperty.mAppId, paramConditionalUserProperty.mExpiredEventName, paramConditionalUserProperty.mExpiredEventParams, paramConditionalUserProperty.mOrigin, paramConditionalUserProperty.mCreationTimestamp, true, false);
      zzo localzzo = new zzo(paramConditionalUserProperty.mAppId, paramConditionalUserProperty.mOrigin, localzzfu, paramConditionalUserProperty.mCreationTimestamp, paramConditionalUserProperty.mActive, paramConditionalUserProperty.mTriggerEventName, null, paramConditionalUserProperty.mTriggerTimeout, null, paramConditionalUserProperty.mTimeToLive, localzzag);
      zzgl().zzd(localzzo);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
  }

  @VisibleForTesting
  private final List<AppMeasurement.ConditionalUserProperty> zzf(String paramString1, String paramString2, String paramString3)
  {
    if (zzgs().zzkf())
    {
      zzgt().zzjg().zzby("Cannot get conditional user properties from analytics worker thread");
      return Collections.emptyList();
    }
    if (zzn.isMainThread())
    {
      zzgt().zzjg().zzby("Cannot get conditional user properties from main thread");
      return Collections.emptyList();
    }
    List localList;
    synchronized (new AtomicReference())
    {
      this.zzada.zzgs().zzc(new zzdk(this, ???, paramString1, paramString2, paramString3));
      try
      {
        ???.wait(5000L);
        localList = (List)???.get();
        if (localList == null)
        {
          zzgt().zzjj().zzg("Timed out waiting for get conditional user properties", paramString1);
          return Collections.emptyList();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          zzgt().zzjj().zze("Interrupted waiting for get conditional user properties", paramString1, localInterruptedException);
      }
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      zzo localzzo = (zzo)localIterator.next();
      AppMeasurement.ConditionalUserProperty localConditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
      localConditionalUserProperty.mAppId = localzzo.packageName;
      localConditionalUserProperty.mOrigin = localzzo.origin;
      localConditionalUserProperty.mCreationTimestamp = localzzo.creationTimestamp;
      localConditionalUserProperty.mName = localzzo.zzags.name;
      localConditionalUserProperty.mValue = localzzo.zzags.getValue();
      localConditionalUserProperty.mActive = localzzo.active;
      localConditionalUserProperty.mTriggerEventName = localzzo.triggerEventName;
      if (localzzo.zzagt != null)
      {
        localConditionalUserProperty.mTimedOutEventName = localzzo.zzagt.name;
        if (localzzo.zzagt.zzahu != null)
          localConditionalUserProperty.mTimedOutEventParams = localzzo.zzagt.zzahu.zziy();
      }
      localConditionalUserProperty.mTriggerTimeout = localzzo.triggerTimeout;
      if (localzzo.zzagu != null)
      {
        localConditionalUserProperty.mTriggeredEventName = localzzo.zzagu.name;
        if (localzzo.zzagu.zzahu != null)
          localConditionalUserProperty.mTriggeredEventParams = localzzo.zzagu.zzahu.zziy();
      }
      localConditionalUserProperty.mTriggeredTimestamp = localzzo.zzags.zzaum;
      localConditionalUserProperty.mTimeToLive = localzzo.timeToLive;
      if (localzzo.zzagv != null)
      {
        localConditionalUserProperty.mExpiredEventName = localzzo.zzagv.name;
        if (localzzo.zzagv.zzahu != null)
          localConditionalUserProperty.mExpiredEventParams = localzzo.zzagv.zzahu.zziy();
      }
      localArrayList.add(localConditionalUserProperty);
    }
    return localArrayList;
  }

  private final void zzj(boolean paramBoolean)
  {
    zzaf();
    zzgg();
    zzcl();
    zzgt().zzjn().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(paramBoolean));
    zzgu().setMeasurementEnabled(paramBoolean);
    zzlc();
  }

  private final void zzlc()
  {
    if ((zzgv().zzba(zzgk().zzal())) && (this.zzada.isEnabled()) && (this.zzarf))
    {
      zzgt().zzjn().zzby("Recording app launch after enabling measurement for the first time (FE)");
      zzld();
      return;
    }
    zzgt().zzjn().zzby("Updating Scion state (FE)");
    zzgl().zzlg();
  }

  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzgg();
    zza(null, paramString1, paramString2, paramBundle);
  }

  public final void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Preconditions.checkNotEmpty(paramString1);
    zzgf();
    zza(paramString1, paramString2, paramString3, paramBundle);
  }

  public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2)
  {
    zzgg();
    return zzf(null, paramString1, paramString2);
  }

  public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String paramString1, String paramString2, String paramString3)
  {
    Preconditions.checkNotEmpty(paramString1);
    zzgf();
    return zzf(paramString1, paramString2, paramString3);
  }

  public final String getCurrentScreenClass()
  {
    zzdx localzzdx = this.zzada.zzgm().zzlf();
    if (localzzdx != null)
      return localzzdx.zzarq;
    return null;
  }

  public final String getCurrentScreenName()
  {
    zzdx localzzdx = this.zzada.zzgm().zzlf();
    if (localzzdx != null)
      return localzzdx.zzuw;
    return null;
  }

  public final String getGmpAppId()
  {
    if (this.zzada.zzko() != null)
      return this.zzada.zzko();
    try
    {
      String str = GoogleServices.getGoogleAppId();
      return str;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.zzada.zzgt().zzjg().zzg("getGoogleAppId failed with exception", localIllegalStateException);
    }
    return null;
  }

  public final Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    zzgg();
    return zzb(null, paramString1, paramString2, paramBoolean);
  }

  public final Map<String, Object> getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString1);
    zzgf();
    return zzb(paramString1, paramString2, paramString3, paramBoolean);
  }

  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle)
  {
    logEvent(paramString1, paramString2, paramBundle, true, true, zzbx().currentTimeMillis());
  }

  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    zzgg();
    if (paramString1 == null);
    for (String str = "app"; ; str = paramString1)
    {
      if (paramBundle == null);
      for (Bundle localBundle = new Bundle(); ; localBundle = paramBundle)
      {
        boolean bool1;
        if ((!paramBoolean2) || (this.zzarb == null) || (zzfx.zzcy(paramString2)))
        {
          bool1 = true;
          if (paramBoolean1)
            break label81;
        }
        label81: for (boolean bool2 = true; ; bool2 = false)
        {
          zzb(str, paramString2, paramLong, localBundle, paramBoolean2, bool1, bool2, null);
          return;
          bool1 = false;
          break;
        }
      }
    }
  }

  public final void resetAnalyticsData(long paramLong)
  {
    if (zzgv().zza(zzai.zzald))
      zzcp(null);
    zzgs().zzc(new zzdg(this, paramLong));
  }

  public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    Preconditions.checkNotNull(paramConditionalUserProperty);
    zzgg();
    AppMeasurement.ConditionalUserProperty localConditionalUserProperty = new AppMeasurement.ConditionalUserProperty(paramConditionalUserProperty);
    if (!TextUtils.isEmpty(localConditionalUserProperty.mAppId))
      zzgt().zzjj().zzby("Package name should be null when calling setConditionalUserProperty");
    localConditionalUserProperty.mAppId = null;
    zza(localConditionalUserProperty);
  }

  public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    Preconditions.checkNotNull(paramConditionalUserProperty);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mAppId);
    zzgf();
    zza(new AppMeasurement.ConditionalUserProperty(paramConditionalUserProperty));
  }

  public final void setMeasurementEnabled(boolean paramBoolean)
  {
    zzcl();
    zzgg();
    zzgs().zzc(new zzdq(this, paramBoolean));
  }

  public final void setMinimumSessionDuration(long paramLong)
  {
    zzgg();
    zzgs().zzc(new zzds(this, paramLong));
  }

  public final void setSessionTimeoutDuration(long paramLong)
  {
    zzgg();
    zzgs().zzc(new zzdt(this, paramLong));
  }

  public final void zza(zzcx paramzzcx)
  {
    zzaf();
    zzgg();
    zzcl();
    if ((paramzzcx != null) && (paramzzcx != this.zzarb))
      if (this.zzarb != null)
        break label46;
    label46: for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "EventInterceptor already set.");
      this.zzarb = paramzzcx;
      return;
    }
  }

  public final void zza(zzcy paramzzcy)
  {
    zzgg();
    zzcl();
    Preconditions.checkNotNull(paramzzcy);
    if (!this.zzarc.add(paramzzcy))
      zzgt().zzjj().zzby("OnEventListener already registered");
  }

  final void zza(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    zzgg();
    zzaf();
    if ((this.zzarb == null) || (zzfx.zzcy(paramString2)));
    for (boolean bool = true; ; bool = false)
    {
      zza(paramString1, paramString2, paramLong, paramBundle, true, bool, false, null);
      return;
    }
  }

  final void zza(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzgg();
    zzaf();
    zza(paramString1, paramString2, zzbx().currentTimeMillis(), paramBundle);
  }

  public final void zza(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    logEvent(paramString1, paramString2, paramBundle, false, true, zzbx().currentTimeMillis());
  }

  final void zza(String paramString1, String paramString2, Object paramObject, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzaf();
    zzgg();
    zzcl();
    if (!this.zzada.isEnabled())
      zzgt().zzjn().zzby("User property not set since app measurement is disabled");
    while (!this.zzada.zzkv())
      return;
    zzgt().zzjn().zze("Setting user property (FE)", zzgq().zzbt(paramString2), paramObject);
    zzfu localzzfu = new zzfu(paramString2, paramLong, paramObject, paramString1);
    zzgl().zzb(localzzfu);
  }

  public final void zza(String paramString1, String paramString2, Object paramObject, boolean paramBoolean, long paramLong)
  {
    int i = 6;
    if (paramString1 == null);
    for (String str1 = "app"; ; str1 = paramString1)
    {
      if (paramBoolean)
      {
        i = zzgr().zzcv(paramString2);
        if (i == 0)
          break label140;
        zzgr();
        String str3 = zzfx.zza(paramString2, 24, true);
        int m = 0;
        if (paramString2 != null)
          m = paramString2.length();
        this.zzada.zzgr().zza(i, "_ev", str3, m);
      }
      label140: Object localObject;
      do
      {
        return;
        zzfx localzzfx = zzgr();
        if (!localzzfx.zzs("user property", paramString2))
          break;
        if (!localzzfx.zza("user property", zzcw.zzaqx, paramString2))
        {
          i = 15;
          break;
        }
        if (!localzzfx.zza("user property", 24, paramString2))
          break;
        i = 0;
        break;
        if (paramObject == null)
          break label252;
        int j = zzgr().zzi(paramString2, paramObject);
        if (j != 0)
        {
          zzgr();
          String str2 = zzfx.zza(paramString2, 24, true);
          int k;
          if (!(paramObject instanceof String))
          {
            boolean bool = paramObject instanceof CharSequence;
            k = 0;
            if (!bool);
          }
          else
          {
            k = String.valueOf(paramObject).length();
          }
          this.zzada.zzgr().zza(j, "_ev", str2, k);
          return;
        }
        localObject = zzgr().zzj(paramString2, paramObject);
      }
      while (localObject == null);
      zza(str1, paramString2, paramLong, localObject);
      return;
      label252: zza(str1, paramString2, paramLong, null);
      return;
    }
  }

  public final String zzag(long paramLong)
  {
    String str = null;
    if (zzgs().zzkf())
      zzgt().zzjg().zzby("Cannot retrieve app instance id from analytics worker thread");
    long l2;
    do
    {
      return str;
      if (zzn.isMainThread())
      {
        zzgt().zzjg().zzby("Cannot retrieve app instance id from main thread");
        return null;
      }
      long l1 = zzbx().elapsedRealtime();
      str = zzah(120000L);
      l2 = zzbx().elapsedRealtime() - l1;
    }
    while ((str != null) || (l2 >= 120000L));
    return zzah(120000L - l2);
  }

  public final void zzb(zzcy paramzzcy)
  {
    zzgg();
    zzcl();
    Preconditions.checkNotNull(paramzzcy);
    if (!this.zzarc.remove(paramzzcy))
      zzgt().zzjj().zzby("OnEventListener had not been registered");
  }

  public final void zzb(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    zza(paramString1, paramString2, paramObject, paramBoolean, zzbx().currentTimeMillis());
  }

  final void zzcp(String paramString)
  {
    this.zzare.set(paramString);
  }

  public final void zzd(boolean paramBoolean)
  {
    zzcl();
    zzgg();
    zzgs().zzc(new zzdr(this, paramBoolean));
  }

  public final String zzgc()
  {
    zzgg();
    return (String)this.zzare.get();
  }

  protected final boolean zzgy()
  {
    return false;
  }

  public final List<zzfu> zzk(boolean paramBoolean)
  {
    zzgg();
    zzcl();
    zzgt().zzjn().zzby("Fetching user attributes (FE)");
    List localList;
    if (zzgs().zzkf())
    {
      zzgt().zzjg().zzby("Cannot get all user properties from analytics worker thread");
      localList = Collections.emptyList();
    }
    while (true)
    {
      return localList;
      if (zzn.isMainThread())
      {
        zzgt().zzjg().zzby("Cannot get all user properties from main thread");
        return Collections.emptyList();
      }
      synchronized (new AtomicReference())
      {
        this.zzada.zzgs().zzc(new zzde(this, ???, paramBoolean));
        try
        {
          ???.wait(5000L);
          localList = (List)???.get();
          if (localList != null)
            continue;
          zzgt().zzjj().zzby("Timed out waiting for get user properties");
          return Collections.emptyList();
        }
        catch (InterruptedException localInterruptedException)
        {
          while (true)
            zzgt().zzjj().zzg("Interrupted waiting for get user properties", localInterruptedException);
        }
      }
    }
  }

  public final void zzkw()
  {
    if ((getContext().getApplicationContext() instanceof Application))
      ((Application)getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzara);
  }

  public final Boolean zzkx()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Boolean)zzgs().zza(localAtomicReference, 15000L, "boolean test flag value", new zzdb(this, localAtomicReference));
  }

  public final String zzky()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (String)zzgs().zza(localAtomicReference, 15000L, "String test flag value", new zzdl(this, localAtomicReference));
  }

  public final Long zzkz()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Long)zzgs().zza(localAtomicReference, 15000L, "long test flag value", new zzdn(this, localAtomicReference));
  }

  public final Integer zzla()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Integer)zzgs().zza(localAtomicReference, 15000L, "int test flag value", new zzdo(this, localAtomicReference));
  }

  public final Double zzlb()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Double)zzgs().zza(localAtomicReference, 15000L, "double test flag value", new zzdp(this, localAtomicReference));
  }

  public final void zzld()
  {
    zzaf();
    zzgg();
    zzcl();
    if (!this.zzada.zzkv());
    String str;
    do
    {
      do
      {
        return;
        zzgl().zzld();
        this.zzarf = false;
        str = zzgu().zzka();
      }
      while (TextUtils.isEmpty(str));
      zzgp().zzcl();
    }
    while (str.equals(Build.VERSION.RELEASE));
    Bundle localBundle = new Bundle();
    localBundle.putString("_po", str);
    logEvent("auto", "_ou", localBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzda
 * JD-Core Version:    0.6.2
 */