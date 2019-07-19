package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzbla extends zzaaa
{
  private final zzbaj zzbtd;
  private final zzclb zzfeg;
  private final zzcjy<zzamt, zzcla> zzfeh;
  private final zzcpe zzfei;
  private final zzcga zzfej;
  private final Context zzlj;

  @GuardedBy("this")
  private boolean zzxs;

  zzbla(Context paramContext, zzbaj paramzzbaj, zzclb paramzzclb, zzcjy<zzamt, zzcla> paramzzcjy, zzcpe paramzzcpe, zzcga paramzzcga)
  {
    this.zzlj = paramContext;
    this.zzbtd = paramzzbaj;
    this.zzfeg = paramzzclb;
    this.zzfeh = paramzzcjy;
    this.zzfei = paramzzcpe;
    this.zzfej = paramzzcga;
    this.zzxs = false;
  }

  private final String zzaep()
  {
    Context localContext;
    if (this.zzlj.getApplicationContext() == null)
      localContext = this.zzlj;
    try
    {
      while (true)
      {
        Bundle localBundle = Wrappers.packageManager(localContext).getApplicationInfo(localContext.getPackageName(), 128).metaData;
        return localBundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        localContext = this.zzlj.getApplicationContext();
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      zzaxa.zza("Error getting metadata", localNullPointerException);
      return "";
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label52: break label52;
    }
  }

  public final String getVersionString()
  {
    return this.zzbtd.zzbsy;
  }

  public final void setAppMuted(boolean paramBoolean)
  {
    try
    {
      zzk.zzll().setAppMuted(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setAppVolume(float paramFloat)
  {
    try
    {
      zzk.zzll().setAppVolume(paramFloat);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza()
  {
    try
    {
      if (this.zzxs)
        zzaxa.zzep("Mobile ads is initialized already.");
      while (true)
      {
        return;
        zzact.initialize(this.zzlj);
        zzk.zzlk().zzd(this.zzlj, this.zzbtd);
        zzk.zzlm().initialize(this.zzlj);
        this.zzxs = true;
        this.zzfej.zzajx();
        zzaci localzzaci = zzact.zzcqv;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
          this.zzfei.zzakw();
      }
    }
    finally
    {
    }
  }

  public final void zza(zzais paramzzais)
    throws RemoteException
  {
    this.zzfej.zzb(paramzzais);
  }

  public final void zza(zzamq paramzzamq)
    throws RemoteException
  {
    this.zzfeg.zzb(paramzzamq);
  }

  public final void zzb(@Nullable String paramString, IObjectWrapper paramIObjectWrapper)
  {
    zzaci localzzaci1 = zzact.zzcsy;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue());
    for (String str = zzaep(); ; str = "")
    {
      if (TextUtils.isEmpty(str));
      while (true)
      {
        if (TextUtils.isEmpty(paramString));
        while (true)
        {
          return;
          zzact.initialize(this.zzlj);
          zzaci localzzaci2 = zzact.zzcsw;
          boolean bool1 = ((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue();
          zzaci localzzaci3 = zzact.zzcou;
          boolean bool2 = bool1 | ((Boolean)zzyr.zzpe().zzd(localzzaci3)).booleanValue();
          zzaci localzzaci4 = zzact.zzcou;
          zzblb localzzblb;
          int i;
          if (((Boolean)zzyr.zzpe().zzd(localzzaci4)).booleanValue())
          {
            localzzblb = new zzblb(this, (Runnable)ObjectWrapper.unwrap(paramIObjectWrapper));
            i = 1;
          }
          while (i != 0)
          {
            zzk.zzlo().zza(this.zzlj, this.zzbtd, paramString, localzzblb);
            return;
            i = bool2;
            localzzblb = null;
          }
        }
        paramString = str;
      }
    }
  }

  public final void zzbu(String paramString)
  {
    try
    {
      zzact.initialize(this.zzlj);
      if (!TextUtils.isEmpty(paramString))
      {
        zzaci localzzaci = zzact.zzcsw;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
          zzk.zzlo().zza(this.zzlj, this.zzbtd, paramString, null);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzbv(String paramString)
  {
    this.zzfei.zzfr(paramString);
  }

  public final void zzc(IObjectWrapper paramIObjectWrapper, String paramString)
  {
    if (paramIObjectWrapper == null)
    {
      zzaxa.zzen("Wrapped context is null. Failed to open debug menu.");
      return;
    }
    Context localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    if (localContext == null)
    {
      zzaxa.zzen("Context is null. Failed to open debug menu.");
      return;
    }
    zzayc localzzayc = new zzayc(localContext);
    localzzayc.setAdUnitId(paramString);
    localzzayc.zzp(this.zzbtd.zzbsy);
    localzzayc.showDialog();
  }

  public final float zzpq()
  {
    try
    {
      float f = zzk.zzll().zzpq();
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean zzpr()
  {
    try
    {
      boolean bool = zzk.zzll().zzpr();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final List<zzain> zzps()
    throws RemoteException
  {
    return this.zzfej.zzajy();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbla
 * JD-Core Version:    0.6.2
 */