package com.viber.voip.messages.extras.image;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import com.android.camera.CropImage;
import com.viber.common.d.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backgrounds.q;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.j;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static final Logger a = ViberEnv.getLogger();

  public static int a(Activity paramActivity)
  {
    Resources localResources = ViberApplication.getApplication().getResources();
    int i = localResources.getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0)
      return localResources.getDimensionPixelSize(i);
    if (paramActivity != null)
    {
      Rect localRect = new Rect();
      Window localWindow = paramActivity.getWindow();
      localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
      return Math.abs(localRect.top - localWindow.findViewById(16908290).getTop());
    }
    return 0;
  }

  public static int a(Activity paramActivity, int paramInt)
  {
    int[] arrayOfInt = j.b(paramActivity);
    float f = paramInt / arrayOfInt[0];
    if (f == 0.0F)
      f = 1.0F;
    return (int)(f * arrayOfInt[1]);
  }

  public static int a(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0)
      return paramContext.getResources().getDimensionPixelSize(i);
    return 38;
  }

  public static Intent a(Activity paramActivity, q paramq)
  {
    int[] arrayOfInt = j.b(paramActivity);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1] - b(paramActivity);
    return a(paramActivity, paramq.a(), i, j, i, j, paramq.a(false), paramq.a(true));
  }

  public static Intent a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramUri, paramInt1, paramInt2, paramInt1, paramInt2, dv.h.a(paramContext, null, false), null);
  }

  public static Intent a(Context paramContext, Uri paramUri1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Uri paramUri2, Uri paramUri3)
  {
    Intent localIntent = new Intent(paramContext, CropImage.class);
    localIntent.setDataAndType(paramUri1, "image/*");
    localIntent.putExtra("outputX", paramInt1);
    localIntent.putExtra("outputY", paramInt2);
    localIntent.putExtra("aspectX", paramInt3);
    localIntent.putExtra("aspectY", paramInt4);
    localIntent.putExtra("scale", true);
    localIntent.putExtra("landscapeUri", paramUri3);
    localIntent.putExtra("output", paramUri2);
    return localIntent;
  }

  public static Intent a(Context paramContext, Uri paramUri1, Uri paramUri2, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramUri1, paramInt1, paramInt2, paramInt1, paramInt2, paramUri2, null);
  }

  private static ResolveInfo a(List<ResolveInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if ((localResolveInfo.activityInfo.name.contains("Photographs")) || (localResolveInfo.activityInfo.name.contains("Wallpaper")))
        return localResolveInfo;
    }
    return null;
  }

  public static void a(Context paramContext, Uri paramUri)
  {
    a(paramContext, paramUri, true);
  }

  private static void a(Context paramContext, Uri paramUri, boolean paramBoolean)
  {
    Uri localUri = d.a(paramUri, paramContext, "com.viber.voip.provider.file");
    if (localUri == null);
    while (true)
    {
      return;
      Intent localIntent = new Intent("android.intent.action.ATTACH_DATA");
      ViberActionRunner.a(paramContext, localIntent, localUri);
      localIntent.setDataAndType(localUri, "image/*");
      localIntent.putExtra("mimeType", "image/*");
      List localList = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
      if (paramBoolean);
      for (ResolveInfo localResolveInfo = a(localList); localResolveInfo != null; localResolveInfo = b(localList))
      {
        localIntent.setClassName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name);
        paramContext.startActivity(localIntent);
        return;
      }
    }
  }

  public static int b(Activity paramActivity)
  {
    return dj.c() + a(paramActivity);
  }

  private static ResolveInfo b(List<ResolveInfo> paramList)
  {
    Iterator localIterator1 = paramList.iterator();
    ResolveInfo localResolveInfo2;
    do
    {
      boolean bool = localIterator1.hasNext();
      localObject = null;
      if (!bool)
        break;
      localResolveInfo2 = (ResolveInfo)localIterator1.next();
    }
    while (!localResolveInfo2.activityInfo.name.contains("LockScreen"));
    Object localObject = localResolveInfo2;
    if (localObject == null)
    {
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        ResolveInfo localResolveInfo1 = (ResolveInfo)localIterator2.next();
        if (localResolveInfo1.activityInfo.name.contains("Wallpaper"))
          return localResolveInfo1;
      }
    }
    return localObject;
  }

  public static void b(Context paramContext, Uri paramUri)
  {
    a(paramContext, paramUri, false);
  }

  public static Intent c(Context paramContext, Uri paramUri)
  {
    return a(paramContext, paramUri, dv.s.a(paramContext, null, true), 720, 720);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.image.b
 * JD-Core Version:    0.6.2
 */