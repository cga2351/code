package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzp
{
  private static zzp zzbn = null;

  @VisibleForTesting
  private Storage zzbo;

  @VisibleForTesting
  private GoogleSignInAccount zzbp;

  @VisibleForTesting
  private GoogleSignInOptions zzbq;

  private zzp(Context paramContext)
  {
    this.zzbo = Storage.getInstance(paramContext);
    this.zzbp = this.zzbo.getSavedDefaultGoogleSignInAccount();
    this.zzbq = this.zzbo.getSavedDefaultGoogleSignInOptions();
  }

  public static zzp zzd(Context paramContext)
  {
    try
    {
      zzp localzzp = zze(paramContext.getApplicationContext());
      return localzzp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static zzp zze(Context paramContext)
  {
    try
    {
      if (zzbn == null)
        zzbn = new zzp(paramContext);
      zzp localzzp = zzbn;
      return localzzp;
    }
    finally
    {
    }
  }

  public final void clear()
  {
    try
    {
      this.zzbo.clear();
      this.zzbp = null;
      this.zzbq = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzc(GoogleSignInOptions paramGoogleSignInOptions, GoogleSignInAccount paramGoogleSignInAccount)
  {
    try
    {
      this.zzbo.saveDefaultGoogleSignInAccount(paramGoogleSignInAccount, paramGoogleSignInOptions);
      this.zzbp = paramGoogleSignInAccount;
      this.zzbq = paramGoogleSignInOptions;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final GoogleSignInAccount zzh()
  {
    try
    {
      GoogleSignInAccount localGoogleSignInAccount = this.zzbp;
      return localGoogleSignInAccount;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final GoogleSignInOptions zzi()
  {
    try
    {
      GoogleSignInOptions localGoogleSignInOptions = this.zzbq;
      return localGoogleSignInOptions;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzp
 * JD-Core Version:    0.6.2
 */