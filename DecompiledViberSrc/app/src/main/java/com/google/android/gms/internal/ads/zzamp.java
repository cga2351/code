package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.b;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.lang.reflect.Constructor;
import java.util.Map;

@zzare
public final class zzamp extends zzamr
{
  private static final zzapc zzdga = new zzapc();
  private Map<Class<? extends NetworkExtras>, NetworkExtras> zzdfz;

  private final <NetworkExtrasT extends f, ServerParametersT extends e> zzamt zzcw(String paramString)
    throws RemoteException
  {
    try
    {
      Class localClass = Class.forName(paramString, false, zzamp.class.getClassLoader());
      if (b.class.isAssignableFrom(localClass))
      {
        b localb = (b)localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        return new zzanu(localb, (f)this.zzdfz.get(localb.getAdditionalParametersType()));
      }
      if (MediationAdapter.class.isAssignableFrom(localClass))
        return new zzanm((MediationAdapter)localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      if (Adapter.class.isAssignableFrom(localClass))
        return new zzanm((Adapter)localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      zzbae.zzep(64 + String.valueOf(paramString).length() + "Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable)
    {
    }
    return zzcx(paramString);
  }

  private final zzamt zzcx(String paramString)
    throws RemoteException
  {
    do
    {
      try
      {
        zzbae.zzdp("Reflection failed, retrying using direct instantiation");
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(paramString))
          return new zzanm(new AdMobAdapter());
        if ("com.google.ads.mediation.AdUrlAdapter".equals(paramString))
        {
          zzanm localzzanm = new zzanm(new AdUrlAdapter());
          return localzzanm;
        }
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzd(43 + String.valueOf(paramString).length() + "Could not instantiate mediation adapter: " + paramString + ". ", localThrowable);
        throw new RemoteException();
      }
      if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
        return new zzanm(new com.google.android.gms.ads.mediation.customevent.CustomEventAdapter());
    }
    while (!"com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString));
    com.google.ads.mediation.customevent.CustomEventAdapter localCustomEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
    zzanu localzzanu = new zzanu(localCustomEventAdapter, (CustomEventExtras)this.zzdfz.get(localCustomEventAdapter.getAdditionalParametersType()));
    return localzzanu;
  }

  public final zzamt zzcu(String paramString)
    throws RemoteException
  {
    return zzcw(paramString);
  }

  public final boolean zzcv(String paramString)
    throws RemoteException
  {
    try
    {
      boolean bool = CustomEvent.class.isAssignableFrom(Class.forName(paramString, false, zzamp.class.getClassLoader()));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzep(80 + String.valueOf(paramString).length() + "Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
    }
    return false;
  }

  public final zzaow zzcy(String paramString)
    throws RemoteException
  {
    return zzapc.zzdd(paramString);
  }

  public final void zzf(Map<Class<? extends NetworkExtras>, NetworkExtras> paramMap)
  {
    this.zzdfz = paramMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamp
 * JD-Core Version:    0.6.2
 */