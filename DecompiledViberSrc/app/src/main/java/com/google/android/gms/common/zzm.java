package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class zzm
{
  private static final zzm zzab = new zzm(true, null, null);
  private final Throwable cause;
  final boolean zzac;
  private final String zzad;

  zzm(boolean paramBoolean, @Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    this.zzac = paramBoolean;
    this.zzad = paramString;
    this.cause = paramThrowable;
  }

  static zzm zza(String paramString, Throwable paramThrowable)
  {
    return new zzm(false, paramString, paramThrowable);
  }

  static zzm zza(Callable<String> paramCallable)
  {
    return new zzo(paramCallable, null);
  }

  static String zza(String paramString, zze paramzze, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2);
    for (String str = "debug cert rejected"; ; str = "not whitelisted")
    {
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = str;
      arrayOfObject[1] = paramString;
      arrayOfObject[2] = Hex.zza(AndroidUtilsLight.zzi("SHA-1").digest(paramzze.getBytes()));
      arrayOfObject[3] = Boolean.valueOf(paramBoolean1);
      arrayOfObject[4] = "12451009.false";
      return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", arrayOfObject);
    }
  }

  static zzm zzb(String paramString)
  {
    return new zzm(false, paramString, null);
  }

  static zzm zze()
  {
    return zzab;
  }

  @Nullable
  String getErrorMessage()
  {
    return this.zzad;
  }

  final void zzf()
  {
    if ((!this.zzac) && (Log.isLoggable("GoogleCertificatesRslt", 3)))
    {
      if (this.cause != null)
        Log.d("GoogleCertificatesRslt", getErrorMessage(), this.cause);
    }
    else
      return;
    Log.d("GoogleCertificatesRslt", getErrorMessage());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.zzm
 * JD-Core Version:    0.6.2
 */