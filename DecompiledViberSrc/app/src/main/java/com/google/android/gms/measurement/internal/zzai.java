package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzrx;
import com.google.android.gms.internal.measurement.zzsh;
import com.google.android.gms.internal.measurement.zzsi;
import com.google.android.gms.internal.measurement.zzso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@VisibleForTesting
public final class zzai
{
  private static volatile zzbw zzada;
  static zzn zzaih;
  static List<zza<Integer>> zzaii = new ArrayList();
  static List<zza<Long>> zzaij = new ArrayList();
  static List<zza<Boolean>> zzaik = new ArrayList();
  static List<zza<String>> zzail = new ArrayList();
  static List<zza<Double>> zzaim = new ArrayList();
  private static final zzso zzain = new zzso(zzsh.zzfq("com.google.android.gms.measurement"));

  @VisibleForTesting
  private static Boolean zzaio;
  private static zza<Boolean> zzaip = zza.zzb("measurement.log_third_party_store_events_enabled", false, false);
  private static zza<Boolean> zzaiq = zza.zzb("measurement.log_installs_enabled", false, false);
  private static zza<Boolean> zzair = zza.zzb("measurement.log_upgrades_enabled", false, false);
  public static zza<Boolean> zzais = zza.zzb("measurement.log_androidId_enabled", false, false);
  public static zza<Boolean> zzait = zza.zzb("measurement.upload_dsid_enabled", false, false);
  public static zza<String> zzaiu = zza.zzd("measurement.log_tag", "FA", "FA-SVC");
  public static zza<Long> zzaiv = zza.zzb("measurement.ad_id_cache_time", 10000L, 10000L);
  public static zza<Long> zzaiw = zza.zzb("measurement.monitoring.sample_period_millis", 86400000L, 86400000L);
  public static zza<Long> zzaix = zza.zzb("measurement.config.cache_time", 86400000L, 3600000L);
  public static zza<String> zzaiy = zza.zzd("measurement.config.url_scheme", "https", "https");
  public static zza<String> zzaiz = zza.zzd("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
  public static zza<Integer> zzaja = zza.zzc("measurement.upload.max_bundles", 100, 100);
  public static zza<Integer> zzajb = zza.zzc("measurement.upload.max_batch_size", 65536, 65536);
  public static zza<Integer> zzajc = zza.zzc("measurement.upload.max_bundle_size", 65536, 65536);
  public static zza<Integer> zzajd = zza.zzc("measurement.upload.max_events_per_bundle", 1000, 1000);
  public static zza<Integer> zzaje = zza.zzc("measurement.upload.max_events_per_day", 100000, 100000);
  public static zza<Integer> zzajf = zza.zzc("measurement.upload.max_error_events_per_day", 1000, 1000);
  public static zza<Integer> zzajg = zza.zzc("measurement.upload.max_public_events_per_day", 50000, 50000);
  public static zza<Integer> zzajh = zza.zzc("measurement.upload.max_conversions_per_day", 500, 500);
  public static zza<Integer> zzaji = zza.zzc("measurement.upload.max_realtime_events_per_day", 10, 10);
  public static zza<Integer> zzajj = zza.zzc("measurement.store.max_stored_events_per_app", 100000, 100000);
  public static zza<String> zzajk = zza.zzd("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
  public static zza<Long> zzajl = zza.zzb("measurement.upload.backoff_period", 43200000L, 43200000L);
  public static zza<Long> zzajm = zza.zzb("measurement.upload.window_interval", 3600000L, 3600000L);
  public static zza<Long> zzajn = zza.zzb("measurement.upload.interval", 3600000L, 3600000L);
  public static zza<Long> zzajo = zza.zzb("measurement.upload.realtime_upload_interval", 10000L, 10000L);
  public static zza<Long> zzajp = zza.zzb("measurement.upload.debug_upload_interval", 1000L, 1000L);
  public static zza<Long> zzajq = zza.zzb("measurement.upload.minimum_delay", 500L, 500L);
  public static zza<Long> zzajr = zza.zzb("measurement.alarm_manager.minimum_interval", 60000L, 60000L);
  public static zza<Long> zzajs = zza.zzb("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L);
  public static zza<Long> zzajt = zza.zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L);
  public static zza<Long> zzaju = zza.zzb("measurement.upload.initial_upload_delay_time", 15000L, 15000L);
  public static zza<Long> zzajv = zza.zzb("measurement.upload.retry_time", 1800000L, 1800000L);
  public static zza<Integer> zzajw = zza.zzc("measurement.upload.retry_count", 6, 6);
  public static zza<Long> zzajx = zza.zzb("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
  public static zza<Integer> zzajy = zza.zzc("measurement.lifetimevalue.max_currency_tracked", 4, 4);
  public static zza<Integer> zzajz = zza.zzc("measurement.audience.filter_result_max_count", 200, 200);
  public static zza<Long> zzaka = zza.zzb("measurement.service_client.idle_disconnect_millis", 5000L, 5000L);
  public static zza<Boolean> zzakb = zza.zzb("measurement.test.boolean_flag", false, false);
  public static zza<String> zzakc = zza.zzd("measurement.test.string_flag", "---", "---");
  public static zza<Long> zzakd = zza.zzb("measurement.test.long_flag", -1L, -1L);
  public static zza<Integer> zzake = zza.zzc("measurement.test.int_flag", -2, -2);
  public static zza<Double> zzakf = zza.zza("measurement.test.double_flag", -3.0D, -3.0D);
  public static zza<Integer> zzakg = zza.zzc("measurement.experiment.max_ids", 50, 50);
  public static zza<Boolean> zzakh = zza.zzb("measurement.lifetimevalue.user_engagement_tracking_enabled", true, true);
  public static zza<Boolean> zzaki = zza.zzb("measurement.audience.complex_param_evaluation", true, true);
  public static zza<Boolean> zzakj = zza.zzb("measurement.validation.internal_limits_internal_event_params", false, false);
  public static zza<Boolean> zzakk = zza.zzb("measurement.quality.unsuccessful_update_retry_counter", true, true);
  public static zza<Boolean> zzakl = zza.zzb("measurement.iid.disable_on_collection_disabled", true, true);
  public static zza<Boolean> zzakm = zza.zzb("measurement.app_launch.call_only_when_enabled", true, true);
  public static zza<Boolean> zzakn = zza.zzb("measurement.run_on_worker_inline", true, false);
  public static zza<Boolean> zzako = zza.zzb("measurement.audience.dynamic_filters", true, true);
  public static zza<Boolean> zzakp = zza.zzb("measurement.reset_analytics.persist_time", false, false);
  public static zza<Boolean> zzakq = zza.zzb("measurement.validation.value_and_currency_params", false, false);
  public static zza<Boolean> zzakr = zza.zzb("measurement.sampling.time_zone_offset_enabled", false, false);
  public static zza<Boolean> zzaks = zza.zzb("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", false, false);
  public static zza<Boolean> zzakt = zza.zzb("measurement.fetch_config_with_admob_app_id", true, true);
  public static zza<Boolean> zzaku = zza.zzb("measurement.client.sessions.session_id_enabled", false, false);
  public static zza<Boolean> zzakv = zza.zzb("measurement.service.sessions.session_number_enabled", false, false);
  public static zza<Boolean> zzakw = zza.zzb("measurement.client.sessions.immediate_start_enabled", false, false);
  public static zza<Boolean> zzakx = zza.zzb("measurement.client.sessions.background_sessions_enabled", false, false);
  public static zza<Boolean> zzaky = zza.zzb("measurement.client.sessions.remove_expired_session_properties_enabled", false, false);
  private static zza<Boolean> zzakz = zza.zzb("measurement.service.sessions.session_number_backfill_enabled", false, false);
  public static zza<Boolean> zzala = zza.zzb("measurement.collection.firebase_global_collection_flag_enabled", true, true);
  public static zza<Boolean> zzalb = zza.zzb("measurement.collection.efficient_engagement_reporting_enabled", false, false);
  public static zza<Boolean> zzalc = zza.zzb("measurement.collection.redundant_engagement_removal_enabled", false, false);
  public static zza<Boolean> zzald = zza.zzb("measurement.remove_app_instance_id_cache_enabled", true, true);
  public static zza<Boolean> zzale = zza.zzb("measurement.collection.init_params_control_enabled", true, true);
  public static zza<Boolean> zzalf = zza.zzb("measurement.upload.disable_is_uploader", false, false);
  public static zza<Boolean> zzalg = zza.zzb("measurement.experiment.enable_experiment_reporting", false, false);
  public static zza<Boolean> zzalh = zza.zzb("measurement.collection.log_event_and_bundle_v2", true, true);
  public static zza<Boolean> zzali = zza.zzb("measurement.collection.null_empty_event_name_fix", true, true);

  static void zza(zzbw paramzzbw)
  {
    zzada = paramzzbw;
  }

  static void zza(zzn paramzzn)
  {
    zzaih = paramzzn;
    zza.zzjb();
  }

  @VisibleForTesting
  static void zza(Exception paramException)
  {
    if (zzada == null)
      return;
    Context localContext = zzada.getContext();
    if (zzaio == null)
      if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(localContext, 12451000) != 0)
        break label68;
    label68: for (boolean bool = true; ; bool = false)
    {
      zzaio = Boolean.valueOf(bool);
      if (!zzaio.booleanValue())
        break;
      zzada.zzgt().zzjg().zzg("Got Exception on PhenotypeFlag.get on Play device", paramException);
      return;
    }
  }

  public static Map<String, String> zzm(Context paramContext)
  {
    return zzrx.zza(paramContext.getContentResolver(), zzsh.zzfq("com.google.android.gms.measurement")).zztk();
  }

  @VisibleForTesting
  public static final class zza<V>
  {
    private final V zzaan;
    private zzsi<V> zzalj;
    private final V zzalk;
    private volatile V zzall;
    private final String zzoj;

    private zza(String paramString, V paramV1, V paramV2)
    {
      this.zzoj = paramString;
      this.zzaan = paramV1;
      this.zzalk = paramV2;
    }

    static zza<Double> zza(String paramString, double paramDouble1, double paramDouble2)
    {
      zza localzza = new zza(paramString, Double.valueOf(-3.0D), Double.valueOf(-3.0D));
      zzai.zzaim.add(localzza);
      return localzza;
    }

    static zza<Long> zzb(String paramString, long paramLong1, long paramLong2)
    {
      zza localzza = new zza(paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      zzai.zzaij.add(localzza);
      return localzza;
    }

    static zza<Boolean> zzb(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      zza localzza = new zza(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2));
      zzai.zzaik.add(localzza);
      return localzza;
    }

    static zza<Integer> zzc(String paramString, int paramInt1, int paramInt2)
    {
      zza localzza = new zza(paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      zzai.zzaii.add(localzza);
      return localzza;
    }

    static zza<String> zzd(String paramString1, String paramString2, String paramString3)
    {
      zza localzza = new zza(paramString1, paramString2, paramString3);
      zzai.zzail.add(localzza);
      return localzza;
    }

    private static void zzja()
    {
      while (true)
      {
        try
        {
          if (!zzn.isMainThread())
            try
            {
              Iterator localIterator1 = zzai.zzaik.iterator();
              if (!localIterator1.hasNext())
                break label83;
              zza localzza5 = (zza)localIterator1.next();
              localzza5.zzall = localzza5.zzalj.get();
              continue;
            }
            catch (SecurityException localSecurityException)
            {
              zzai.zza(localSecurityException);
            }
          else
            throw new IllegalStateException("Tried to refresh flag cache on main thread or on package side.");
        }
        finally
        {
        }
        label83: Iterator localIterator2 = zzai.zzail.iterator();
        while (localIterator2.hasNext())
        {
          zza localzza4 = (zza)localIterator2.next();
          localzza4.zzall = localzza4.zzalj.get();
        }
        Iterator localIterator3 = zzai.zzaij.iterator();
        while (localIterator3.hasNext())
        {
          zza localzza3 = (zza)localIterator3.next();
          localzza3.zzall = localzza3.zzalj.get();
        }
        Iterator localIterator4 = zzai.zzaii.iterator();
        while (localIterator4.hasNext())
        {
          zza localzza2 = (zza)localIterator4.next();
          localzza2.zzall = localzza2.zzalj.get();
        }
        Iterator localIterator5 = zzai.zzaim.iterator();
        while (localIterator5.hasNext())
        {
          zza localzza1 = (zza)localIterator5.next();
          localzza1.zzall = localzza1.zzalj.get();
        }
      }
    }

    private static void zzq()
    {
      try
      {
        Iterator localIterator1 = zzai.zzaik.iterator();
        while (localIterator1.hasNext())
        {
          zza localzza5 = (zza)localIterator1.next();
          zzso localzzso5 = zzai.zziz();
          String str5 = localzza5.zzoj;
          localzza5.zzalj = localzzso5.zzd(str5, ((Boolean)localzza5.zzaan).booleanValue());
        }
      }
      finally
      {
      }
      Iterator localIterator2 = zzai.zzail.iterator();
      while (localIterator2.hasNext())
      {
        zza localzza4 = (zza)localIterator2.next();
        zzso localzzso4 = zzai.zziz();
        String str4 = localzza4.zzoj;
        localzza4.zzalj = localzzso4.zzy(str4, (String)localzza4.zzaan);
      }
      Iterator localIterator3 = zzai.zzaij.iterator();
      while (localIterator3.hasNext())
      {
        zza localzza3 = (zza)localIterator3.next();
        zzso localzzso3 = zzai.zziz();
        String str3 = localzza3.zzoj;
        localzza3.zzalj = localzzso3.zze(str3, ((Long)localzza3.zzaan).longValue());
      }
      Iterator localIterator4 = zzai.zzaii.iterator();
      while (localIterator4.hasNext())
      {
        zza localzza2 = (zza)localIterator4.next();
        zzso localzzso2 = zzai.zziz();
        String str2 = localzza2.zzoj;
        localzza2.zzalj = localzzso2.zzd(str2, ((Integer)localzza2.zzaan).intValue());
      }
      Iterator localIterator5 = zzai.zzaim.iterator();
      while (localIterator5.hasNext())
      {
        zza localzza1 = (zza)localIterator5.next();
        zzso localzzso1 = zzai.zziz();
        String str1 = localzza1.zzoj;
        localzza1.zzalj = localzzso1.zzb(str1, ((Double)localzza1.zzaan).doubleValue());
      }
    }

    public final V get()
    {
      if (zzai.zzaih == null)
        return this.zzaan;
      if (zzn.isMainThread())
      {
        if (this.zzall == null)
          return this.zzaan;
        return this.zzall;
      }
      zzja();
      try
      {
        Object localObject = this.zzalj.get();
        return localObject;
      }
      catch (SecurityException localSecurityException)
      {
        zzai.zza(localSecurityException);
      }
      return this.zzalj.getDefaultValue();
    }

    public final V get(V paramV)
    {
      if (paramV != null)
        return paramV;
      if (zzai.zzaih == null)
        return this.zzaan;
      if (zzn.isMainThread())
      {
        if (this.zzall == null)
          return this.zzaan;
        return this.zzall;
      }
      zzja();
      try
      {
        Object localObject = this.zzalj.get();
        return localObject;
      }
      catch (SecurityException localSecurityException)
      {
        zzai.zza(localSecurityException);
      }
      return this.zzalj.getDefaultValue();
    }

    public final String getKey()
    {
      return this.zzoj;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzai
 * JD-Core Version:    0.6.2
 */