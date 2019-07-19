package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import java.lang.reflect.Constructor;

@zzare
public class zzapc
{
  public static zzaow zzdd(String paramString)
    throws RemoteException
  {
    try
    {
      zzapd localzzapd = new zzapd((RtbAdapter)Class.forName(paramString, false, zzapc.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      return localzzapd;
    }
    catch (Throwable localThrowable)
    {
    }
    throw new RemoteException();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapc
 * JD-Core Version:    0.6.2
 */