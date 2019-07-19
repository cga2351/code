package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.content.Context;
import android.support.v4.content.PermissionChecker;
import android.util.Log;

final class zzse
  implements zzsb
{
  static zzse zzbrl;
  private final Context zzri;

  private zzse()
  {
    this.zzri = null;
  }

  private zzse(Context paramContext)
  {
    this.zzri = paramContext;
    this.zzri.getContentResolver().registerContentObserver(zzru.CONTENT_URI, true, new zzsg(this, null));
  }

  static zzse zzad(Context paramContext)
  {
    while (true)
    {
      try
      {
        if (zzbrl == null)
        {
          if (PermissionChecker.checkSelfPermission(paramContext, "com.google.android.providers.gsf.permission.READ_GSERVICES") != 0)
            break label66;
          i = 1;
          if (i != 0)
          {
            localzzse2 = new zzse(paramContext);
            zzbrl = localzzse2;
          }
        }
        else
        {
          zzse localzzse1 = zzbrl;
          return localzzse1;
        }
        zzse localzzse2 = new zzse();
        continue;
      }
      finally
      {
      }
      label66: int i = 0;
    }
  }

  private final String zzfo(String paramString)
  {
    if (this.zzri == null)
      return null;
    String str1;
    try
    {
      String str3 = (String)zzsc.zza(new zzsf(this, paramString));
      return str3;
    }
    catch (SecurityException localSecurityException)
    {
      str1 = String.valueOf(paramString);
      if (str1.length() == 0);
    }
    for (String str2 = "Unable to read GServices for: ".concat(str1); ; str2 = new String("Unable to read GServices for: "))
    {
      Log.e("GservicesLoader", str2, localSecurityException);
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzse
 * JD-Core Version:    0.6.2
 */