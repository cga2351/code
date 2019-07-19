package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@VisibleForTesting
public final class zzahs
{
  private final View view;
  private final zzdh zzdap;
  private final Context zzlj;

  public zzahs(Context paramContext, zzdh paramzzdh, View paramView)
  {
    this.zzlj = paramContext;
    this.zzdap = paramzzdh;
    this.view = paramView;
  }

  private static Intent zza(Intent paramIntent, ResolveInfo paramResolveInfo)
  {
    Intent localIntent = new Intent(paramIntent);
    localIntent.setClassName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
    return localIntent;
  }

  @VisibleForTesting
  private final ResolveInfo zza(Intent paramIntent, ArrayList<ResolveInfo> paramArrayList)
  {
    try
    {
      PackageManager localPackageManager = this.zzlj.getPackageManager();
      if (localPackageManager == null)
        return null;
      List localList = localPackageManager.queryIntentActivities(paramIntent, 65536);
      ResolveInfo localResolveInfo2 = localPackageManager.resolveActivity(paramIntent, 65536);
      if ((localList != null) && (localResolveInfo2 != null))
        for (int i = 0; i < localList.size(); i++)
        {
          ResolveInfo localResolveInfo3 = (ResolveInfo)localList.get(i);
          if (localResolveInfo2 != null)
          {
            boolean bool = localResolveInfo2.activityInfo.name.equals(localResolveInfo3.activityInfo.name);
            if (bool)
            {
              localResolveInfo1 = localResolveInfo2;
              try
              {
                paramArrayList.addAll(localList);
                return localResolveInfo1;
              }
              catch (Throwable localThrowable2)
              {
              }
              zzk.zzlk().zza(localThrowable2, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
              return localResolveInfo1;
            }
          }
        }
    }
    catch (Throwable localThrowable1)
    {
      while (true)
      {
        Object localObject = localThrowable1;
        ResolveInfo localResolveInfo1 = null;
        continue;
        localResolveInfo1 = null;
      }
    }
  }

  @VisibleForTesting
  private final ResolveInfo zzb(Intent paramIntent)
  {
    return zza(paramIntent, new ArrayList());
  }

  private static Intent zzf(Uri paramUri)
  {
    if (paramUri == null)
      return null;
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setData(paramUri);
    localIntent.setAction("android.intent.action.VIEW");
    return localIntent;
  }

  @VisibleForTesting
  public final Intent zze(Map<String, String> paramMap)
  {
    ActivityManager localActivityManager = (ActivityManager)this.zzlj.getSystemService("activity");
    String str = (String)paramMap.get("u");
    boolean bool1 = TextUtils.isEmpty(str);
    Intent localIntent1 = null;
    if (bool1);
    boolean bool2;
    boolean bool3;
    ArrayList localArrayList1;
    Intent localIntent2;
    label249: 
    do
    {
      return localIntent1;
      Uri localUri1 = Uri.parse(zzahr.zza(this.zzlj, this.zzdap, str, this.view, null));
      bool2 = Boolean.parseBoolean((String)paramMap.get("use_first_package"));
      bool3 = Boolean.parseBoolean((String)paramMap.get("use_running_process"));
      int i;
      Uri localUri2;
      if (!Boolean.parseBoolean((String)paramMap.get("use_custom_tabs")))
      {
        zzaci localzzaci = zzact.zzctz;
        if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
      }
      else
      {
        i = 1;
        if (!"http".equalsIgnoreCase(localUri1.getScheme()))
          break label249;
        localUri2 = localUri1.buildUpon().scheme("https").build();
      }
      Intent localIntent3;
      while (true)
      {
        localArrayList1 = new ArrayList();
        localIntent2 = zzf(localUri1);
        localIntent3 = zzf(localUri2);
        if (i != 0)
        {
          zzk.zzlg();
          zzaxj.zzb(this.zzlj, localIntent2);
          zzk.zzlg();
          zzaxj.zzb(this.zzlj, localIntent3);
        }
        ResolveInfo localResolveInfo1 = zza(localIntent2, localArrayList1);
        if (localResolveInfo1 == null)
          break label287;
        return zza(localIntent2, localResolveInfo1);
        i = 0;
        break;
        boolean bool4 = "https".equalsIgnoreCase(localUri1.getScheme());
        localUri2 = null;
        if (bool4)
          localUri2 = localUri1.buildUpon().scheme("http").build();
      }
      if (localIntent3 == null)
        break;
      ResolveInfo localResolveInfo3 = zzb(localIntent3);
      if (localResolveInfo3 == null)
        break;
      localIntent1 = zza(localIntent2, localResolveInfo3);
    }
    while (zzb(localIntent1) != null);
    label287: if (localArrayList1.size() == 0)
      return localIntent2;
    if ((bool3) && (localActivityManager != null))
    {
      List localList = localActivityManager.getRunningAppProcesses();
      if (localList != null)
      {
        ArrayList localArrayList2 = (ArrayList)localArrayList1;
        int j = localArrayList2.size();
        int m;
        for (int k = 0; k < j; k = m)
        {
          Object localObject = localArrayList2.get(k);
          m = k + 1;
          ResolveInfo localResolveInfo2 = (ResolveInfo)localObject;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
            if (((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.equals(localResolveInfo2.activityInfo.packageName))
              return zza(localIntent2, localResolveInfo2);
        }
      }
    }
    if (bool2)
      return zza(localIntent2, (ResolveInfo)localArrayList1.get(0));
    return localIntent2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzahs
 * JD-Core Version:    0.6.2
 */