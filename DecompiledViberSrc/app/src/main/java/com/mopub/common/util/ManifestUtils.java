package com.mopub.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.privacy.ConsentDialogActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManifestUtils
{
  private static b a = new b();
  private static final List<Class<? extends Activity>> b = new ArrayList(4);
  private static final List<Class<? extends Activity>> c;
  private static final List<Class<? extends Activity>> d;

  static
  {
    try
    {
      Class localClass1 = Class.forName("com.mopub.mobileads.MoPubActivity");
      Class localClass2 = Class.forName("com.mopub.mobileads.MraidActivity");
      Class localClass3 = Class.forName("com.mopub.mobileads.RewardedMraidActivity");
      b.add(localClass1);
      b.add(localClass2);
      b.add(localClass3);
      b.add(MraidVideoPlayerActivity.class);
      b.add(MoPubBrowser.class);
      c = new ArrayList(1);
      c.add(MoPubBrowser.class);
      d = new ArrayList(1);
      d.add(ConsentDialogActivity.class);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "ManifestUtils running without interstitial module" });
    }
  }

  private static a a(Context paramContext, Class<? extends Activity> paramClass)
    throws PackageManager.NameNotFoundException
  {
    ActivityInfo localActivityInfo = paramContext.getPackageManager().getActivityInfo(new ComponentName(paramContext, paramClass.getName()), 0);
    a locala = new a(null);
    locala.hasKeyboardHidden = a.hasFlag(paramClass, localActivityInfo.configChanges, 32);
    locala.hasOrientation = a.hasFlag(paramClass, localActivityInfo.configChanges, 128);
    locala.hasScreenSize = true;
    locala.hasScreenSize = a.hasFlag(paramClass, localActivityInfo.configChanges, 1024);
    return locala;
  }

  private static List<Class<? extends Activity>> a(Context paramContext, List<Class<? extends Activity>> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if (Intents.deviceCanHandleIntent(paramContext, new Intent(paramContext, localClass)) == paramBoolean)
        localArrayList.add(localClass);
    }
    return localArrayList;
  }

  private static void a(Context paramContext)
  {
    if (isDebuggable(paramContext))
    {
      Toast localToast = Toast.makeText(paramContext, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.", 1);
      localToast.setGravity(7, 0, 0);
      localToast.show();
    }
  }

  @VisibleForTesting
  static void a(Context paramContext, List<Class<? extends Activity>> paramList)
  {
    List localList = a(paramContext, paramList, false);
    if (localList.isEmpty())
      return;
    a(paramContext);
    a(localList);
  }

  private static void a(List<Class<? extends Activity>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      localStringBuilder.append("\n\t").append(localClass.getName());
    }
    localStringBuilder.append("\n\nPlease update your manifest to include them.");
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localStringBuilder.toString();
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
  }

  @VisibleForTesting
  static void b(Context paramContext, List<Class<? extends Activity>> paramList)
  {
    List localList = c(paramContext, a(paramContext, paramList, true));
    if (localList.isEmpty())
      return;
    a(paramContext);
    d(paramContext, localList);
  }

  @TargetApi(13)
  private static List<Class<? extends Activity>> c(Context paramContext, List<Class<? extends Activity>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        a locala = a(paramContext, localClass);
        if ((!locala.hasKeyboardHidden) || (!locala.hasOrientation) || (!locala.hasScreenSize))
          localArrayList.add(localClass);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
    }
    return localArrayList;
  }

  public static void checkGdprActivitiesDeclared(Context paramContext)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramContext, "context is not allowed to be null"))
      return;
    a(paramContext, d);
    b(paramContext, d);
  }

  public static void checkNativeActivitiesDeclared(Context paramContext)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramContext, "context is not allowed to be null"))
      return;
    a(paramContext, c);
    b(paramContext, c);
  }

  public static void checkWebViewActivitiesDeclared(Context paramContext)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramContext, "context is not allowed to be null"))
      return;
    a(paramContext, b);
    b(paramContext, b);
  }

  private static void d(Context paramContext, List<Class<? extends Activity>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("In AndroidManifest, the android:configChanges param is missing values for the following MoPub activities:\n");
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      Class localClass;
      if (localIterator.hasNext())
        localClass = (Class)localIterator.next();
      try
      {
        a locala = a(paramContext, localClass);
        if (!locala.hasKeyboardHidden)
          localStringBuilder.append("\n\tThe android:configChanges param for activity " + localClass.getName() + " must include keyboardHidden.");
        if (!locala.hasOrientation)
          localStringBuilder.append("\n\tThe android:configChanges param for activity " + localClass.getName() + " must include orientation.");
        if (!locala.hasScreenSize)
        {
          localStringBuilder.append("\n\tThe android:configChanges param for activity " + localClass.getName() + " must include screenSize.");
          continue;
          localStringBuilder.append("\n\nPlease update your manifest to include them.");
          MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localStringBuilder.toString();
          MoPubLog.log(localSdkLogEvent, arrayOfObject);
          return;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
    }
  }

  public static boolean isDebuggable(Context paramContext)
  {
    return Utils.bitMaskContainsFlag(paramContext.getApplicationInfo().flags, 2);
  }

  private static class a
  {
    public boolean hasKeyboardHidden;
    public boolean hasOrientation;
    public boolean hasScreenSize;
  }

  static class b
  {
    public boolean hasFlag(Class paramClass, int paramInt1, int paramInt2)
    {
      return Utils.bitMaskContainsFlag(paramInt1, paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.ManifestUtils
 * JD-Core Version:    0.6.2
 */