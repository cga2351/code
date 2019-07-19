package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzaxd
  implements zzaxc
{
  private final Object lock = new Object();

  @Nullable
  @GuardedBy("lock")
  private SharedPreferences zzcko;

  @GuardedBy("lock")
  private boolean zzdlu = true;

  @GuardedBy("lock")
  private boolean zzdmj = false;

  @GuardedBy("lock")
  private String zzdmm = "";

  @GuardedBy("lock")
  private boolean zzdnv = true;

  @GuardedBy("lock")
  private boolean zzdog = true;
  private boolean zzduy;
  private final List<Runnable> zzduz = new ArrayList();
  private zzbbi<?> zzdva;

  @Nullable
  @GuardedBy("lock")
  private zzus zzdvb = null;

  @Nullable
  @GuardedBy("lock")
  private SharedPreferences.Editor zzdvc;

  @GuardedBy("lock")
  private boolean zzdvd = false;

  @Nullable
  @GuardedBy("lock")
  private String zzdve;

  @Nullable
  @GuardedBy("lock")
  private String zzdvf;

  @GuardedBy("lock")
  private long zzdvg = 0L;

  @GuardedBy("lock")
  private long zzdvh = 0L;

  @GuardedBy("lock")
  private long zzdvi = 0L;

  @GuardedBy("lock")
  private int zzdvj = -1;

  @GuardedBy("lock")
  private int zzdvk = 0;

  @GuardedBy("lock")
  private Set<String> zzdvl = Collections.emptySet();

  @GuardedBy("lock")
  private JSONObject zzdvm = new JSONObject();

  @GuardedBy("lock")
  private String zzdvn = null;

  private final void zzc(Bundle paramBundle)
  {
    zzaxh.zzdvr.execute(new zzaxf(this));
  }

  private final void zzvy()
  {
    if (this.zzdva == null);
    while (this.zzdva.isDone())
      return;
    try
    {
      this.zzdva.get(1L, TimeUnit.SECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      zzaxa.zzd("Interrupted while waiting for preferences loaded.", localInterruptedException);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      zzaxa.zzc("Fail to initialize AdSharedPreferenceManager.", localExecutionException);
      return;
    }
    catch (CancellationException localCancellationException)
    {
      break label50;
    }
    catch (TimeoutException localTimeoutException)
    {
      label50: break label50;
    }
  }

  private final Bundle zzvz()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("listener_registration_bundle", true);
    synchronized (this.lock)
    {
      localBundle.putBoolean("use_https", this.zzdlu);
      localBundle.putBoolean("content_url_opted_out", this.zzdnv);
      localBundle.putBoolean("content_vertical_opted_out", this.zzdog);
      localBundle.putBoolean("auto_collect_location", this.zzdmj);
      localBundle.putInt("version_code", this.zzdvk);
      localBundle.putStringArray("never_pool_slots", (String[])this.zzdvl.toArray(new String[0]));
      localBundle.putString("app_settings_json", this.zzdmm);
      localBundle.putLong("app_settings_last_update_ms", this.zzdvg);
      localBundle.putLong("app_last_background_time_ms", this.zzdvh);
      localBundle.putInt("request_in_session_count", this.zzdvj);
      localBundle.putLong("first_ad_req_time_ms", this.zzdvi);
      localBundle.putString("native_advanced_settings", this.zzdvm.toString());
      localBundle.putString("display_cutout", this.zzdvn);
      if (this.zzdve != null)
        localBundle.putString("content_url_hashes", this.zzdve);
      if (this.zzdvf != null)
        localBundle.putString("content_vertical_hashes", this.zzdvf);
      return localBundle;
    }
  }

  public final void zza(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str3;
    if (paramString == null)
      str3 = "admob";
    while (true)
    {
      this.zzdva = zzaxh.zzc(new zzaxe(this, paramContext, str3));
      this.zzduy = paramBoolean;
      return;
      String str1 = String.valueOf("admob__");
      String str2 = String.valueOf(paramString);
      if (str2.length() != 0)
        str3 = str1.concat(str2);
      else
        str3 = new String(str1);
    }
  }

  public final void zzai(boolean paramBoolean)
  {
    zzvy();
    synchronized (this.lock)
    {
      if (this.zzdnv == paramBoolean)
        return;
      this.zzdnv = paramBoolean;
      if (this.zzdvc != null)
      {
        this.zzdvc.putBoolean("content_url_opted_out", paramBoolean);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("content_url_opted_out", this.zzdnv);
      localBundle.putBoolean("content_vertical_opted_out", this.zzdog);
      zzc(localBundle);
      return;
    }
  }

  public final void zzaj(boolean paramBoolean)
  {
    zzvy();
    synchronized (this.lock)
    {
      if (this.zzdog == paramBoolean)
        return;
      this.zzdog = paramBoolean;
      if (this.zzdvc != null)
      {
        this.zzdvc.putBoolean("content_vertical_opted_out", paramBoolean);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("content_url_opted_out", this.zzdnv);
      localBundle.putBoolean("content_vertical_opted_out", this.zzdog);
      zzc(localBundle);
      return;
    }
  }

  public final void zzak(boolean paramBoolean)
  {
    zzvy();
    synchronized (this.lock)
    {
      if (this.zzdmj == paramBoolean)
        return;
      this.zzdmj = paramBoolean;
      if (this.zzdvc != null)
      {
        this.zzdvc.putBoolean("auto_collect_location", paramBoolean);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("auto_collect_location", paramBoolean);
      zzc(localBundle);
      return;
    }
  }

  public final void zzb(Runnable paramRunnable)
  {
    this.zzduz.add(paramRunnable);
  }

  public final void zzc(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    zzvy();
    while (true)
    {
      JSONArray localJSONArray1;
      int j;
      synchronized (this.lock)
      {
        localJSONArray1 = this.zzdvm.optJSONArray(paramString1);
        if (localJSONArray1 != null)
          break label276;
        localJSONArray2 = new JSONArray();
        j = localJSONArray2.length();
        if (i >= localJSONArray2.length())
          break label124;
        JSONObject localJSONObject2 = localJSONArray2.optJSONObject(i);
        if (localJSONObject2 == null)
          return;
        if (paramString2.equals(localJSONObject2.optString("template_id")))
        {
          if ((!paramBoolean) || (!localJSONObject2.optBoolean("uses_media_view", false)))
            break label128;
          return;
        }
      }
      i++;
      continue;
      label124: i = j;
      try
      {
        label128: JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("template_id", paramString2);
        localJSONObject1.put("uses_media_view", paramBoolean);
        localJSONObject1.put("timestamp_ms", zzk.zzln().currentTimeMillis());
        localJSONArray2.put(i, localJSONObject1);
        this.zzdvm.put(paramString1, localJSONArray2);
        if (this.zzdvc != null)
        {
          this.zzdvc.putString("native_advanced_settings", this.zzdvm.toString());
          this.zzdvc.apply();
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("native_advanced_settings", this.zzdvm.toString());
        zzc(localBundle);
        return;
      }
      catch (JSONException localJSONException)
      {
        while (true)
          zzaxa.zzd("Could not update native advanced settings", localJSONException);
      }
      label276: JSONArray localJSONArray2 = localJSONArray1;
    }
  }

  public final void zzct(int paramInt)
  {
    zzvy();
    synchronized (this.lock)
    {
      if (this.zzdvk == paramInt)
        return;
      this.zzdvk = paramInt;
      if (this.zzdvc != null)
      {
        this.zzdvc.putInt("version_code", paramInt);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("version_code", paramInt);
      zzc(localBundle);
      return;
    }
  }

  public final void zzcu(int paramInt)
  {
    zzvy();
    synchronized (this.lock)
    {
      if (this.zzdvj == paramInt)
        return;
      this.zzdvj = paramInt;
      if (this.zzdvc != null)
      {
        this.zzdvc.putInt("request_in_session_count", paramInt);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("request_in_session_count", paramInt);
      zzc(localBundle);
      return;
    }
  }

  public final void zzdt(@Nullable String paramString)
  {
    zzvy();
    Object localObject1 = this.lock;
    if (paramString != null);
    try
    {
      if (paramString.equals(this.zzdve))
        return;
      this.zzdve = paramString;
      if (this.zzdvc != null)
      {
        this.zzdvc.putString("content_url_hashes", paramString);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("content_url_hashes", paramString);
      zzc(localBundle);
      return;
    }
    finally
    {
    }
  }

  public final void zzdu(@Nullable String paramString)
  {
    zzvy();
    Object localObject1 = this.lock;
    if (paramString != null);
    try
    {
      if (paramString.equals(this.zzdvf))
        return;
      this.zzdvf = paramString;
      if (this.zzdvc != null)
      {
        this.zzdvc.putString("content_vertical_hashes", paramString);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("content_vertical_hashes", paramString);
      zzc(localBundle);
      return;
    }
    finally
    {
    }
  }

  public final void zzdv(String paramString)
  {
    zzvy();
    synchronized (this.lock)
    {
      long l = zzk.zzln().currentTimeMillis();
      this.zzdvg = l;
      if ((paramString == null) || (paramString.equals(this.zzdmm)))
        return;
      this.zzdmm = paramString;
      if (this.zzdvc != null)
      {
        this.zzdvc.putString("app_settings_json", paramString);
        this.zzdvc.putLong("app_settings_last_update_ms", l);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("app_settings_json", paramString);
      localBundle.putLong("app_settings_last_update_ms", l);
      zzc(localBundle);
      Iterator localIterator = this.zzduz.iterator();
      if (localIterator.hasNext())
        ((Runnable)localIterator.next()).run();
    }
  }

  public final void zzdw(String paramString)
  {
    zzvy();
    synchronized (this.lock)
    {
      if (TextUtils.equals(this.zzdvn, paramString))
        return;
      this.zzdvn = paramString;
      if (this.zzdvc != null)
      {
        this.zzdvc.putString("display_cutout", paramString);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("display_cutout", paramString);
      zzc(localBundle);
      return;
    }
  }

  public final void zzfc(long paramLong)
  {
    zzvy();
    synchronized (this.lock)
    {
      if (this.zzdvh == paramLong)
        return;
      this.zzdvh = paramLong;
      if (this.zzdvc != null)
      {
        this.zzdvc.putLong("app_last_background_time_ms", paramLong);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putLong("app_last_background_time_ms", paramLong);
      zzc(localBundle);
      return;
    }
  }

  public final void zzfd(long paramLong)
  {
    zzvy();
    synchronized (this.lock)
    {
      if (this.zzdvi == paramLong)
        return;
      this.zzdvi = paramLong;
      if (this.zzdvc != null)
      {
        this.zzdvc.putLong("first_ad_req_time_ms", paramLong);
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putLong("first_ad_req_time_ms", paramLong);
      zzc(localBundle);
      return;
    }
  }

  @Nullable
  public final zzus zzvk()
  {
    if (!this.zzduy)
      return null;
    if (!PlatformVersion.isAtLeastIceCreamSandwich())
      return null;
    if ((zzvl()) && (zzvn()))
      return null;
    zzaci localzzaci = zzact.zzcnb;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return null;
    synchronized (this.lock)
    {
      if (Looper.getMainLooper() == null)
        return null;
      if (this.zzdvb == null)
        this.zzdvb = new zzus();
      this.zzdvb.zzmv();
      zzaxa.zzeo("start fetching content...");
      zzus localzzus = this.zzdvb;
      return localzzus;
    }
  }

  public final boolean zzvl()
  {
    zzvy();
    synchronized (this.lock)
    {
      boolean bool = this.zzdnv;
      return bool;
    }
  }

  @Nullable
  public final String zzvm()
  {
    zzvy();
    synchronized (this.lock)
    {
      String str = this.zzdve;
      return str;
    }
  }

  public final boolean zzvn()
  {
    zzvy();
    synchronized (this.lock)
    {
      boolean bool = this.zzdog;
      return bool;
    }
  }

  @Nullable
  public final String zzvo()
  {
    zzvy();
    synchronized (this.lock)
    {
      String str = this.zzdvf;
      return str;
    }
  }

  public final boolean zzvp()
  {
    zzvy();
    synchronized (this.lock)
    {
      boolean bool = this.zzdmj;
      return bool;
    }
  }

  public final int zzvq()
  {
    zzvy();
    synchronized (this.lock)
    {
      int i = this.zzdvk;
      return i;
    }
  }

  public final zzawm zzvr()
  {
    zzvy();
    synchronized (this.lock)
    {
      zzawm localzzawm = new zzawm(this.zzdmm, this.zzdvg);
      return localzzawm;
    }
  }

  public final long zzvs()
  {
    zzvy();
    synchronized (this.lock)
    {
      long l = this.zzdvh;
      return l;
    }
  }

  public final int zzvt()
  {
    zzvy();
    synchronized (this.lock)
    {
      int i = this.zzdvj;
      return i;
    }
  }

  public final long zzvu()
  {
    zzvy();
    synchronized (this.lock)
    {
      long l = this.zzdvi;
      return l;
    }
  }

  public final JSONObject zzvv()
  {
    zzvy();
    synchronized (this.lock)
    {
      JSONObject localJSONObject = this.zzdvm;
      return localJSONObject;
    }
  }

  public final void zzvw()
  {
    zzvy();
    synchronized (this.lock)
    {
      this.zzdvm = new JSONObject();
      if (this.zzdvc != null)
      {
        this.zzdvc.remove("native_advanced_settings");
        this.zzdvc.apply();
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("native_advanced_settings", "{}");
      zzc(localBundle);
      return;
    }
  }

  public final String zzvx()
  {
    zzvy();
    synchronized (this.lock)
    {
      String str = this.zzdvn;
      return str;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxd
 * JD-Core Version:    0.6.2
 */