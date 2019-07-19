package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzyf;
import com.google.android.gms.internal.ads.zzyr;

@KeepForSdkWithMembers
public class AdActivity extends Activity
{
  public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
  public static final String SIMPLE_CLASS_NAME = "AdActivity";
  private zzaqh zzaah;

  private final void zzdd()
  {
    if (this.zzaah != null);
    try
    {
      this.zzaah.zzdd();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      this.zzaah.onActivityResult(paramInt1, paramInt2, paramIntent);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localException);
    }
  }

  public void onBackPressed()
  {
    int i = 1;
    try
    {
      if (this.zzaah != null)
      {
        boolean bool = this.zzaah.zztg();
        i = bool;
      }
      if (i != 0)
        super.onBackPressed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      this.zzaah.zzac(ObjectWrapper.wrap(paramConfiguration));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzaah = zzyr.zzpb().zzb(this);
    if (this.zzaah == null)
    {
      zzbae.zze("#007 Could not call remote method.", null);
      finish();
      return;
    }
    try
    {
      this.zzaah.onCreate(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      finish();
    }
  }

  protected void onDestroy()
  {
    try
    {
      if (this.zzaah != null)
        this.zzaah.onDestroy();
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  protected void onPause()
  {
    try
    {
      if (this.zzaah != null)
        this.zzaah.onPause();
      super.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
        finish();
      }
    }
  }

  protected void onRestart()
  {
    super.onRestart();
    try
    {
      if (this.zzaah != null)
        this.zzaah.onRestart();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      finish();
    }
  }

  protected void onResume()
  {
    super.onResume();
    try
    {
      if (this.zzaah != null)
        this.zzaah.onResume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      finish();
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      if (this.zzaah != null)
        this.zzaah.onSaveInstanceState(paramBundle);
      super.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
        finish();
      }
    }
  }

  protected void onStart()
  {
    super.onStart();
    try
    {
      if (this.zzaah != null)
        this.zzaah.onStart();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      finish();
    }
  }

  protected void onStop()
  {
    try
    {
      if (this.zzaah != null)
        this.zzaah.onStop();
      super.onStop();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
        finish();
      }
    }
  }

  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    zzdd();
  }

  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    zzdd();
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    zzdd();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdActivity
 * JD-Core Version:    0.6.2
 */