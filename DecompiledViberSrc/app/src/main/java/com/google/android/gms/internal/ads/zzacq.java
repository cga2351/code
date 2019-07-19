package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
@ParametersAreNonnullByDefault
public final class zzacq
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private final Object lock = new Object();
  private Bundle metaData = new Bundle();
  private final ConditionVariable zzckm = new ConditionVariable();

  @VisibleForTesting
  private volatile boolean zzckn = false;
  private SharedPreferences zzcko = null;
  private Context zzckp;
  private JSONObject zzckq = new JSONObject();
  private volatile boolean zzxs = false;

  private final void zzqp()
  {
    if (this.zzcko == null)
      return;
    try
    {
      this.zzckq = new JSONObject((String)zzazm.zza(this.zzckp, new zzacr(this)));
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public final void initialize(Context paramContext)
  {
    if (this.zzxs)
      return;
    synchronized (this.lock)
    {
      if (this.zzxs)
        return;
    }
    if (!this.zzckn)
      this.zzckn = true;
    Object localObject3;
    if (paramContext.getApplicationContext() == null)
      localObject3 = paramContext;
    while (true)
    {
      this.zzckp = ((Context)localObject3);
      try
      {
        this.metaData = Wrappers.packageManager(this.zzckp).getApplicationInfo(this.zzckp.getPackageName(), 128).metaData;
        try
        {
          label85: localContext1 = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
          if ((localContext1 == null) && (paramContext != null))
          {
            Context localContext2 = paramContext.getApplicationContext();
            if (localContext2 == null);
            while (true)
            {
              if (paramContext != null)
                break label149;
              this.zzckn = false;
              this.zzckm.open();
              return;
              Context localContext3 = paramContext.getApplicationContext();
              localObject3 = localContext3;
              break;
              paramContext = localContext2;
            }
            label149: zzyr.zzpc();
            this.zzcko = paramContext.getSharedPreferences("google_ads_flags", 0);
            if (this.zzcko != null)
              this.zzcko.registerOnSharedPreferenceChangeListener(this);
            zzqp();
            this.zzxs = true;
            this.zzckn = false;
            this.zzckm.open();
            return;
          }
        }
        finally
        {
          this.zzckn = false;
          this.zzckm.open();
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        break label85;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        while (true)
        {
          Context localContext1;
          continue;
          paramContext = localContext1;
        }
      }
    }
  }

  public final void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ("flag_configuration".equals(paramString))
      zzqp();
  }

  public final <T> T zzd(zzaci<T> paramzzaci)
  {
    if (!this.zzckm.block(5000L))
      synchronized (this.lock)
      {
        if (!this.zzckn)
          throw new IllegalStateException("Flags.initialize() was not called!");
      }
    if ((!this.zzxs) || (this.zzcko == null));
    synchronized (this.lock)
    {
      if ((!this.zzxs) || (this.zzcko == null))
      {
        Object localObject3 = paramzzaci.zzqm();
        return localObject3;
      }
      if (paramzzaci.getSource() != 2)
        break label132;
      if (this.metaData == null)
        return paramzzaci.zzqm();
    }
    return paramzzaci.zza(this.metaData);
    label132: if ((paramzzaci.getSource() == 1) && (this.zzckq.has(paramzzaci.getKey())))
      return paramzzaci.zza(this.zzckq);
    return zzazm.zza(this.zzckp, new zzacs(this, paramzzaci));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzacq
 * JD-Core Version:    0.6.2
 */