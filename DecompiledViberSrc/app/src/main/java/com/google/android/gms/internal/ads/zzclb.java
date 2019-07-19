package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzclb
{
  private final AtomicReference<zzamq> zzgal = new AtomicReference();

  private final zzamq zzaks()
    throws RemoteException
  {
    zzamq localzzamq = (zzamq)this.zzgal.get();
    if (localzzamq == null)
    {
      zzaxa.zzep("Unexpected call to adapter creator.");
      throw new RemoteException();
    }
    return localzzamq;
  }

  private final zzamt zzf(String paramString, JSONObject paramJSONObject)
    throws RemoteException
  {
    zzamq localzzamq = zzaks();
    if (("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString)) || ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(paramString)))
      try
      {
        if (localzzamq.zzcv(paramJSONObject.getString("class_name")))
          return localzzamq.zzcu("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        zzamt localzzamt = localzzamq.zzcu("com.google.ads.mediation.customevent.CustomEventAdapter");
        return localzzamt;
      }
      catch (JSONException localJSONException)
      {
        zzaxa.zzc("Invalid custom event.", localJSONException);
      }
    return localzzamq.zzcu(paramString);
  }

  public final boolean zzakr()
  {
    return this.zzgal.get() != null;
  }

  public final void zzb(zzamq paramzzamq)
  {
    this.zzgal.compareAndSet(null, paramzzamq);
  }

  public final zzaow zzcy(String paramString)
    throws RemoteException
  {
    return zzaks().zzcy(paramString);
  }

  public final zzamt zze(String paramString, JSONObject paramJSONObject)
    throws RemoteException
  {
    if ("com.google.ads.mediation.admob.AdMobAdapter".equals(paramString))
      return new zzanm(new AdMobAdapter());
    if ("com.google.ads.mediation.AdUrlAdapter".equals(paramString))
      return new zzanm(new AdUrlAdapter());
    if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(paramString))
      return new zzanm(new zzapm());
    return zzf(paramString, paramJSONObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzclb
 * JD-Core Version:    0.6.2
 */