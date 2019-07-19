package com.google.android.gms.maps.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class zzbz
{
  private static final String TAG = zzbz.class.getSimpleName();

  @SuppressLint({"StaticFieldLeak"})
  private static Context zzck = null;
  private static zze zzcl;

  public static zze zza(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    Preconditions.checkNotNull(paramContext);
    if (zzcl != null)
      return zzcl;
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext, 13400000);
    switch (i)
    {
    default:
      throw new GooglePlayServicesNotAvailableException(i);
    case 0:
    }
    Log.i(TAG, "Making Creator dynamically");
    IBinder localIBinder = (IBinder)zza(zzb(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl");
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      zzcl = (zze)localObject;
      try
      {
        zzcl.zza(ObjectWrapper.wrap(zzb(paramContext).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        return zzcl;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
        if ((localIInterface instanceof zze))
        {
          localObject = (zze)localIInterface;
          continue;
        }
        localObject = new zzf(localIBinder);
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }

  private static <T> T zza(Class<?> paramClass)
  {
    String str1;
    try
    {
      Object localObject = paramClass.newInstance();
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      String str3 = String.valueOf(paramClass.getName());
      if (str3.length() != 0);
      for (String str4 = "Unable to instantiate the dynamic class ".concat(str3); ; str4 = new String("Unable to instantiate the dynamic class "))
        throw new IllegalStateException(str4);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      str1 = String.valueOf(paramClass.getName());
      if (str1.length() == 0);
    }
    for (String str2 = "Unable to call the default constructor of ".concat(str1); ; str2 = new String("Unable to call the default constructor of "))
      throw new IllegalStateException(str2);
  }

  private static <T> T zza(ClassLoader paramClassLoader, String paramString)
  {
    String str1;
    try
    {
      Object localObject = zza(((ClassLoader)Preconditions.checkNotNull(paramClassLoader)).loadClass(paramString));
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      str1 = String.valueOf(paramString);
      if (str1.length() == 0);
    }
    for (String str2 = "Unable to find dynamic class ".concat(str1); ; str2 = new String("Unable to find dynamic class "))
      throw new IllegalStateException(str2);
  }

  private static Context zzb(Context paramContext)
  {
    if (zzck != null)
      return zzck;
    Context localContext = zzc(paramContext);
    zzck = localContext;
    return localContext;
  }

  private static Context zzc(Context paramContext)
  {
    try
    {
      Context localContext = DynamiteModule.load(paramContext, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").getModuleContext();
      return localContext;
    }
    catch (Exception localException)
    {
      Log.e(TAG, "Failed to load maps module, use legacy", localException);
    }
    return GooglePlayServicesUtil.getRemoteContext(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzbz
 * JD-Core Version:    0.6.2
 */