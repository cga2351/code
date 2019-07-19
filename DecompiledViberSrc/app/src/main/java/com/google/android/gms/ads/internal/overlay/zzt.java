package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzxp;

@zzare
public final class zzt extends zzaqi
{
  private AdOverlayInfoParcel zzdky;
  private boolean zzdkz = false;
  private boolean zzdla = false;
  private Activity zzzd;

  public zzt(Activity paramActivity, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    this.zzdky = paramAdOverlayInfoParcel;
    this.zzzd = paramActivity;
  }

  private final void zztp()
  {
    try
    {
      if (!this.zzdla)
      {
        if (this.zzdky.zzdko != null)
          this.zzdky.zzdko.zzsz();
        this.zzdla = true;
      }
      return;
    }
    finally
    {
    }
  }

  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    throws RemoteException
  {
  }

  public final void onBackPressed()
    throws RemoteException
  {
  }

  public final void onCreate(Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
      i = 0;
      if (bool)
        i = 1;
    }
    if (this.zzdky == null)
      this.zzzd.finish();
    do
    {
      return;
      if (i != 0)
      {
        this.zzzd.finish();
        return;
      }
      if (paramBundle == null)
      {
        if (this.zzdky.zzcgj != null)
          this.zzdky.zzcgj.onAdClicked();
        if ((this.zzzd.getIntent() != null) && (this.zzzd.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true)) && (this.zzdky.zzdko != null))
          this.zzdky.zzdko.zzta();
      }
      zzk.zzle();
    }
    while (zza.zza(this.zzzd, this.zzdky.zzdkn, this.zzdky.zzdks));
    this.zzzd.finish();
  }

  public final void onDestroy()
    throws RemoteException
  {
    if (this.zzzd.isFinishing())
      zztp();
  }

  public final void onPause()
    throws RemoteException
  {
    if (this.zzdky.zzdko != null)
      this.zzdky.zzdko.onPause();
    if (this.zzzd.isFinishing())
      zztp();
  }

  public final void onRestart()
    throws RemoteException
  {
  }

  public final void onResume()
    throws RemoteException
  {
    if (this.zzdkz)
      this.zzzd.finish();
    do
    {
      return;
      this.zzdkz = true;
    }
    while (this.zzdky.zzdko == null);
    this.zzdky.zzdko.onResume();
  }

  public final void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdkz);
  }

  public final void onStart()
    throws RemoteException
  {
  }

  public final void onStop()
    throws RemoteException
  {
    if (this.zzzd.isFinishing())
      zztp();
  }

  public final void zzac(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
  }

  public final void zzdd()
    throws RemoteException
  {
  }

  public final boolean zztg()
    throws RemoteException
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzt
 * JD-Core Version:    0.6.2
 */