package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;

@zzare
public final class zzbaf
{
  public static <T> T zza(Context paramContext, String paramString, zzbag<IBinder, T> paramzzbag)
    throws zzbah
  {
    try
    {
      Object localObject = paramzzbag.apply(zzbm(paramContext).instantiate(paramString));
      return localObject;
    }
    catch (Exception localException)
    {
      throw new zzbah(localException);
    }
  }

  public static Context zzbl(Context paramContext)
    throws zzbah
  {
    return zzbm(paramContext).getModuleContext();
  }

  private static DynamiteModule zzbm(Context paramContext)
    throws zzbah
  {
    try
    {
      DynamiteModule localDynamiteModule = DynamiteModule.load(paramContext, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.ads.dynamite");
      return localDynamiteModule;
    }
    catch (Exception localException)
    {
      throw new zzbah(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbaf
 * JD-Core Version:    0.6.2
 */