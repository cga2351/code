package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zze extends zzj
{
  private int zzt;

  protected zze(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 25);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.zzt = Arrays.hashCode(paramArrayOfByte);
      return;
    }
  }

  protected static byte[] zza(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zzi)))
      return false;
    try
    {
      zzi localzzi = (zzi)paramObject;
      if (localzzi.zzc() != hashCode())
        return false;
      IObjectWrapper localIObjectWrapper = localzzi.zzb();
      if (localIObjectWrapper == null)
        return false;
      byte[] arrayOfByte = (byte[])ObjectWrapper.unwrap(localIObjectWrapper);
      boolean bool = Arrays.equals(getBytes(), arrayOfByte);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("GoogleCertificates", "Failed to get Google certificates from remote", localRemoteException);
    }
    return false;
  }

  abstract byte[] getBytes();

  public int hashCode()
  {
    return this.zzt;
  }

  public final IObjectWrapper zzb()
  {
    return ObjectWrapper.wrap(getBytes());
  }

  public final int zzc()
  {
    return hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.zze
 * JD-Core Version:    0.6.2
 */