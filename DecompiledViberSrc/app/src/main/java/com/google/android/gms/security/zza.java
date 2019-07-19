package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

final class zza extends AsyncTask<Void, Void, Integer>
{
  zza(Context paramContext, ProviderInstaller.ProviderInstallListener paramProviderInstallListener)
  {
  }

  private final Integer zza(Void[] paramArrayOfVoid)
  {
    try
    {
      ProviderInstaller.installIfNeeded(this.val$context);
      return Integer.valueOf(0);
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      return Integer.valueOf(localGooglePlayServicesRepairableException.getConnectionStatusCode());
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      return Integer.valueOf(localGooglePlayServicesNotAvailableException.errorCode);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.security.zza
 * JD-Core Version:    0.6.2
 */