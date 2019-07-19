package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public class Wrappers
{
  private static Wrappers zzhx = new Wrappers();
  private PackageManagerWrapper zzhw = null;

  @KeepForSdk
  public static PackageManagerWrapper packageManager(Context paramContext)
  {
    return zzhx.zzi(paramContext);
  }

  @VisibleForTesting
  private final PackageManagerWrapper zzi(Context paramContext)
  {
    try
    {
      if (this.zzhw == null)
        if (paramContext.getApplicationContext() != null)
          break label37;
      while (true)
      {
        this.zzhw = new PackageManagerWrapper(paramContext);
        PackageManagerWrapper localPackageManagerWrapper = this.zzhw;
        return localPackageManagerWrapper;
        label37: Context localContext = paramContext.getApplicationContext();
        paramContext = localContext;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.wrappers.Wrappers
 * JD-Core Version:    0.6.2
 */