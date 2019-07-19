package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.yandex.mobile.ads.AdActivity;

public final class eq
{
  public static void a(Context paramContext)
  {
    int i = 1;
    while (true)
    {
      int i8;
      try
      {
        ActivityInfo[] arrayOfActivityInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 1).activities;
        int j = arrayOfActivityInfo.length;
        int k = 0;
        if (k >= j)
          break label291;
        ActivityInfo localActivityInfo1 = arrayOfActivityInfo[k];
        if (AdActivity.a.equals(localActivityInfo1.name))
        {
          localActivityInfo2 = localActivityInfo1;
          if (localActivityInfo2 == null)
            break label274;
          if ((0x10 & localActivityInfo2.configChanges) > 0)
          {
            m = i;
            int n = m & 0x1;
            if ((0x20 & localActivityInfo2.configChanges) <= 0)
              continue;
            i1 = i;
            int i2 = n & i1;
            if ((0x80 & localActivityInfo2.configChanges) <= 0)
              continue;
            i3 = i;
            int i4 = i2 & i3;
            if ((0x100 & localActivityInfo2.configChanges) <= 0)
              continue;
            i5 = i;
            int i6 = i4 & i5;
            if ((0x200 & localActivityInfo2.configChanges) <= 0)
              continue;
            i7 = i;
            i8 = i7 & i6;
            if (!fl.a(13))
              break label284;
            if ((0x400 & localActivityInfo2.configChanges) <= 0)
              continue;
            i10 = i;
            int i11 = i8 & i10;
            int i12 = localActivityInfo2.configChanges;
            if ((i12 & 0x800) <= 0)
              continue;
            i9 = i & i11;
            if (i9 == 0)
              break label274;
          }
        }
        else
        {
          k++;
          continue;
        }
        int m = 0;
        continue;
        int i1 = 0;
        continue;
        int i3 = 0;
        continue;
        int i5 = 0;
        continue;
        int i7 = 0;
        continue;
        int i10 = 0;
        continue;
        i = 0;
        continue;
      }
      catch (Exception localException)
      {
      }
      label274: throw new IllegalStateException("Ad Activity into the AndroidManifest.xml is integrated wrong");
      label284: int i9 = i8;
      continue;
      label291: ActivityInfo localActivityInfo2 = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.eq
 * JD-Core Version:    0.6.2
 */