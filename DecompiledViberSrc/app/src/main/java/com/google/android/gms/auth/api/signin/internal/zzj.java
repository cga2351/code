package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

final class zzj extends zzc
{
  zzj(zzi paramzzi)
  {
  }

  public final void zzc(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
    throws RemoteException
  {
    if (paramGoogleSignInAccount != null)
      zzp.zzd(this.zzbk.val$context).zzc(this.zzbk.zzbj, paramGoogleSignInAccount);
    this.zzbk.setResult(new GoogleSignInResult(paramGoogleSignInAccount, paramStatus));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzj
 * JD-Core Version:    0.6.2
 */