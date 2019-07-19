package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  private static final Object zzdb = new Object();
  private static ClassLoader zzdc = null;
  private static Integer zzdd = null;
  private boolean zzde = false;

  @KeepForSdk
  protected static boolean canUnparcelSafely(String paramString)
  {
    zzp();
    return true;
  }

  @KeepForSdk
  protected static Integer getUnparcelClientVersion()
  {
    synchronized (zzdb)
    {
      return null;
    }
  }

  private static ClassLoader zzp()
  {
    synchronized (zzdb)
    {
      return null;
    }
  }

  @KeepForSdk
  protected abstract boolean prepareForClientVersion(int paramInt);

  @KeepForSdk
  public void setShouldDowngrade(boolean paramBoolean)
  {
    this.zzde = paramBoolean;
  }

  @KeepForSdk
  protected boolean shouldDowngrade()
  {
    return this.zzde;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.DowngradeableSafeParcel
 * JD-Core Version:    0.6.2
 */