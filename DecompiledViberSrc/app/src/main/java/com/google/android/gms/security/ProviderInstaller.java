package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static final Object lock = new Object();
  private static final GoogleApiAvailabilityLight zziu = GoogleApiAvailabilityLight.getInstance();
  private static Method zziv = null;

  public static void installIfNeeded(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    zziu.verifyGooglePlayServicesIsAvailable(paramContext, 11925000);
    Context localContext;
    try
    {
      localContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (localContext == null)
      {
        if (Log.isLoggable("ProviderInstaller", 6))
          Log.e("ProviderInstaller", "Failed to get remote context");
        throw new GooglePlayServicesNotAvailableException(8);
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (Log.isLoggable("ProviderInstaller", 6))
        Log.e("ProviderInstaller", "Failed to get remote context - resource not found");
      throw new GooglePlayServicesNotAvailableException(8);
    }
    while (true)
    {
      Throwable localThrowable;
      synchronized (lock)
      {
        try
        {
          if (zziv == null)
            zziv = localContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
          zziv.invoke(null, new Object[] { localContext });
          return;
        }
        catch (Exception localException)
        {
          localThrowable = localException.getCause();
          if (!Log.isLoggable("ProviderInstaller", 6))
            continue;
        }
        if (localThrowable == null)
        {
          str1 = localException.getMessage();
          String str2 = String.valueOf(str1);
          if (str2.length() == 0)
            break label237;
          str3 = "Failed to install provider: ".concat(str2);
          Log.e("ProviderInstaller", str3);
          throw new GooglePlayServicesNotAvailableException(8);
        }
      }
      String str1 = localThrowable.getMessage();
      continue;
      label237: String str3 = new String("Failed to install provider: ");
    }
  }

  public static void installIfNeededAsync(Context paramContext, ProviderInstallListener paramProviderInstallListener)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    Preconditions.checkNotNull(paramProviderInstallListener, "Listener must not be null");
    Preconditions.checkMainThread("Must be called on the UI thread");
    new zza(paramContext, paramProviderInstallListener).execute(new Void[0]);
  }

  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);

    public abstract void onProviderInstalled();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.security.ProviderInstaller
 * JD-Core Version:    0.6.2
 */