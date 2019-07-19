package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzadr
{
  public static boolean zzj(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null);
    while (true)
    {
      return false;
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
      ResolveInfo localResolveInfo1 = localPackageManager.resolveActivity(localIntent, 0);
      List localList = localPackageManager.queryIntentActivities(localIntent, 65536);
      if ((localList != null) && (localResolveInfo1 != null))
        for (int i = 0; i < localList.size(); i++)
        {
          ResolveInfo localResolveInfo2 = (ResolveInfo)localList.get(i);
          if (localResolveInfo1.activityInfo.name.equals(localResolveInfo2.activityInfo.name))
            return localResolveInfo1.activityInfo.packageName.equals(zzdtu.zzbu(paramContext));
        }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadr
 * JD-Core Version:    0.6.2
 */