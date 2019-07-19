package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class RemoteCreator<T>
{
  private final String zzia;
  private T zzib;

  @KeepForSdk
  protected RemoteCreator(String paramString)
  {
    this.zzia = paramString;
  }

  @KeepForSdk
  protected abstract T getRemoteCreator(IBinder paramIBinder);

  @KeepForSdk
  protected final T getRemoteCreatorInstance(Context paramContext)
    throws RemoteCreator.RemoteCreatorException
  {
    ClassLoader localClassLoader;
    if (this.zzib == null)
    {
      Preconditions.checkNotNull(paramContext);
      Context localContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (localContext == null)
        throw new RemoteCreatorException("Could not get remote context.");
      localClassLoader = localContext.getClassLoader();
    }
    try
    {
      this.zzib = getRemoteCreator((IBinder)localClassLoader.loadClass(this.zzia).newInstance());
      return this.zzib;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RemoteCreatorException("Could not load creator class.", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RemoteCreatorException("Could not instantiate creator.", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RemoteCreatorException("Could not access creator.", localIllegalAccessException);
    }
  }

  @KeepForSdk
  public static class RemoteCreatorException extends Exception
  {
    public RemoteCreatorException(String paramString)
    {
      super();
    }

    public RemoteCreatorException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.RemoteCreator
 * JD-Core Version:    0.6.2
 */