package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class zzbd extends zzcs
{

  @VisibleForTesting
  static final Pair<String, Long> zzana = new Pair("", Long.valueOf(0L));
  private SharedPreferences zzabr;
  public zzbh zzanb;
  public final zzbg zzanc = new zzbg(this, "last_upload", 0L);
  public final zzbg zzand = new zzbg(this, "last_upload_attempt", 0L);
  public final zzbg zzane = new zzbg(this, "backoff", 0L);
  public final zzbg zzanf = new zzbg(this, "last_delete_stale", 0L);
  public final zzbg zzang = new zzbg(this, "midnight_offset", 0L);
  public final zzbg zzanh = new zzbg(this, "first_open_time", 0L);
  public final zzbg zzani = new zzbg(this, "app_install_time", 0L);
  public final zzbi zzanj = new zzbi(this, "app_instance_id", null);
  private String zzank;
  private boolean zzanl;
  private long zzanm;
  public final zzbg zzann = new zzbg(this, "time_before_start", 10000L);
  public final zzbg zzano = new zzbg(this, "session_timeout", 1800000L);
  public final zzbf zzanp = new zzbf(this, "start_new_session", true);
  public final zzbg zzanq = new zzbg(this, "last_pause_time", 0L);
  public final zzbg zzanr = new zzbg(this, "time_active", 0L);
  public boolean zzans;
  public zzbf zzant = new zzbf(this, "app_backgrounded", false);

  zzbd(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  private final SharedPreferences zzju()
  {
    zzaf();
    zzcl();
    return this.zzabr;
  }

  final void setMeasurementEnabled(boolean paramBoolean)
  {
    zzaf();
    zzgt().zzjo().zzg("Setting measurementEnabled", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzju().edit();
    localEditor.putBoolean("measurement_enabled", paramBoolean);
    localEditor.apply();
  }

  final boolean zzaf(long paramLong)
  {
    return paramLong - this.zzano.get() > this.zzanq.get();
  }

  final Pair<String, Boolean> zzbz(String paramString)
  {
    zzaf();
    long l = zzbx().elapsedRealtime();
    if ((this.zzank != null) && (l < this.zzanm))
      return new Pair(this.zzank, Boolean.valueOf(this.zzanl));
    this.zzanm = (l + zzgv().zza(paramString, zzai.zzaiv));
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      if (localInfo != null)
      {
        this.zzank = localInfo.getId();
        this.zzanl = localInfo.isLimitAdTrackingEnabled();
      }
      if (this.zzank == null)
        this.zzank = "";
      AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
      return new Pair(this.zzank, Boolean.valueOf(this.zzanl));
    }
    catch (Exception localException)
    {
      while (true)
      {
        zzgt().zzjn().zzg("Unable to get advertising id", localException);
        this.zzank = "";
      }
    }
  }

  final String zzca(String paramString)
  {
    zzaf();
    String str = (String)zzbz(paramString).first;
    MessageDigest localMessageDigest = zzfx.getMessageDigest();
    if (localMessageDigest == null)
      return null;
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new BigInteger(1, localMessageDigest.digest(str.getBytes()));
    return String.format(localLocale, "%032X", arrayOfObject);
  }

  final void zzcb(String paramString)
  {
    zzaf();
    SharedPreferences.Editor localEditor = zzju().edit();
    localEditor.putString("gmp_app_id", paramString);
    localEditor.apply();
  }

  final void zzcc(String paramString)
  {
    zzaf();
    SharedPreferences.Editor localEditor = zzju().edit();
    localEditor.putString("admob_app_id", paramString);
    localEditor.apply();
  }

  final void zzg(boolean paramBoolean)
  {
    zzaf();
    zzgt().zzjo().zzg("Setting useService", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzju().edit();
    localEditor.putBoolean("use_service", paramBoolean);
    localEditor.apply();
  }

  protected final boolean zzgy()
  {
    return true;
  }

  protected final void zzgz()
  {
    this.zzabr = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    this.zzans = this.zzabr.getBoolean("has_been_opened", false);
    if (!this.zzans)
    {
      SharedPreferences.Editor localEditor = this.zzabr.edit();
      localEditor.putBoolean("has_been_opened", true);
      localEditor.apply();
    }
    this.zzanb = new zzbh(this, "health_monitor", Math.max(0L, ((Long)zzai.zzaiw.get()).longValue()), null);
  }

  final boolean zzh(boolean paramBoolean)
  {
    zzaf();
    return zzju().getBoolean("measurement_enabled", paramBoolean);
  }

  final void zzi(boolean paramBoolean)
  {
    zzaf();
    zzgt().zzjo().zzg("Updating deferred analytics collection", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzju().edit();
    localEditor.putBoolean("deferred_analytics_collection", paramBoolean);
    localEditor.apply();
  }

  final String zzjv()
  {
    zzaf();
    return zzju().getString("gmp_app_id", null);
  }

  final String zzjw()
  {
    zzaf();
    return zzju().getString("admob_app_id", null);
  }

  final Boolean zzjx()
  {
    zzaf();
    if (!zzju().contains("use_service"))
      return null;
    return Boolean.valueOf(zzju().getBoolean("use_service", false));
  }

  final void zzjy()
  {
    boolean bool1 = true;
    zzaf();
    zzgt().zzjo().zzby("Clearing collection preferences.");
    if (zzgv().zza(zzai.zzale))
    {
      Boolean localBoolean = zzjz();
      SharedPreferences.Editor localEditor2 = zzju().edit();
      localEditor2.clear();
      localEditor2.apply();
      if (localBoolean != null)
        setMeasurementEnabled(localBoolean.booleanValue());
    }
    boolean bool2;
    do
    {
      return;
      bool2 = zzju().contains("measurement_enabled");
      if (bool2)
        bool1 = zzh(bool1);
      SharedPreferences.Editor localEditor1 = zzju().edit();
      localEditor1.clear();
      localEditor1.apply();
    }
    while (!bool2);
    setMeasurementEnabled(bool1);
  }

  final Boolean zzjz()
  {
    zzaf();
    if (zzju().contains("measurement_enabled"))
      return Boolean.valueOf(zzju().getBoolean("measurement_enabled", true));
    return null;
  }

  protected final String zzka()
  {
    zzaf();
    String str1 = zzju().getString("previous_os_version", null);
    zzgp().zzcl();
    String str2 = Build.VERSION.RELEASE;
    if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1)))
    {
      SharedPreferences.Editor localEditor = zzju().edit();
      localEditor.putString("previous_os_version", str2);
      localEditor.apply();
    }
    return str1;
  }

  final boolean zzkb()
  {
    zzaf();
    return zzju().getBoolean("deferred_analytics_collection", false);
  }

  final boolean zzkc()
  {
    return this.zzabr.contains("deferred_analytics_collection");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbd
 * JD-Core Version:    0.6.2
 */