package com.appboy.ui.actions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import com.appboy.a.b;
import com.appboy.b.e;
import com.appboy.f.a;
import com.appboy.f.c;
import com.appboy.f.i;
import com.appboy.ui.AppboyWebViewActivity;
import com.appboy.ui.support.UriUtils;
import java.util.Iterator;
import java.util.List;

public class UriAction
  implements IAction
{
  private static final String TAG = c.a(UriAction.class);
  private final e mChannel;
  private final Bundle mExtras;
  private Uri mUri;
  private boolean mUseWebView;

  UriAction(Uri paramUri, Bundle paramBundle, boolean paramBoolean, e parame)
  {
    this.mUri = paramUri;
    this.mExtras = paramBundle;
    this.mUseWebView = paramBoolean;
    this.mChannel = parame;
  }

  private static Intent getActionViewIntent(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(paramUri);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    List localList = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
    if (localList.size() > 1)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        if (localResolveInfo.activityInfo.packageName.equals(paramContext.getPackageName()))
        {
          c.b(TAG, "Setting deep link activity to " + localResolveInfo.activityInfo.packageName + ".");
          localIntent.setPackage(localResolveInfo.activityInfo.packageName);
        }
      }
    }
    return localIntent;
  }

  private static TaskStackBuilder getConfiguredTaskBackStackBuilder(Context paramContext, Bundle paramBundle)
  {
    b localb = new b(paramContext);
    TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(paramContext);
    if (localb.r())
    {
      String str = localb.s();
      if (i.c(str))
      {
        c.c(TAG, "Adding main activity intent to back stack while opening uri from push");
        localTaskStackBuilder.addNextIntent(UriUtils.getMainActivityIntent(paramContext, paramBundle));
        return localTaskStackBuilder;
      }
      if (UriUtils.isActivityRegisteredInManifest(paramContext, str))
      {
        c.c(TAG, "Adding custom back stack activity while opening uri from push: " + str);
        localTaskStackBuilder.addNextIntent(new Intent().setClassName(paramContext, str));
        return localTaskStackBuilder;
      }
      c.c(TAG, "Not adding unregistered activity to the back stack while opening uri from push: " + str);
      return localTaskStackBuilder;
    }
    c.c(TAG, "Not adding back stack activity while opening uri from push due to disabled configuration setting.");
    return localTaskStackBuilder;
  }

  private static Intent getWebViewActivityIntent(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, AppboyWebViewActivity.class);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    localIntent.putExtra("url", paramUri.toString());
    return localIntent;
  }

  private static void openUriWithActionView(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    Intent localIntent = getActionViewIntent(paramContext, paramUri, paramBundle);
    localIntent.setFlags(872415232);
    if (localIntent.resolveActivity(paramContext.getPackageManager()) != null)
    {
      paramContext.startActivity(localIntent);
      return;
    }
    c.d(TAG, "Could not find appropriate activity to open for deep link " + paramUri + ".");
  }

  private static void openUriWithActionViewFromPush(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    TaskStackBuilder localTaskStackBuilder = getConfiguredTaskBackStackBuilder(paramContext, paramBundle);
    localTaskStackBuilder.addNextIntent(getActionViewIntent(paramContext, paramUri, paramBundle));
    try
    {
      localTaskStackBuilder.startActivities(paramBundle);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      c.c(TAG, "Could not find appropriate activity to open for deep link " + paramUri, localActivityNotFoundException);
    }
  }

  static void openUriWithWebViewActivity(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    Intent localIntent = getWebViewActivityIntent(paramContext, paramUri, paramBundle);
    localIntent.setFlags(872415232);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      c.d(TAG, "Appboy AppboyWebViewActivity not opened successfully.", localException);
    }
  }

  private static void openUriWithWebViewActivityFromPush(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    TaskStackBuilder localTaskStackBuilder = getConfiguredTaskBackStackBuilder(paramContext, paramBundle);
    localTaskStackBuilder.addNextIntent(getWebViewActivityIntent(paramContext, paramUri, paramBundle));
    try
    {
      localTaskStackBuilder.startActivities(paramBundle);
      return;
    }
    catch (Exception localException)
    {
      c.d(TAG, "Appboy AppboyWebViewActivity not opened successfully.", localException);
    }
  }

  public void execute(Context paramContext)
  {
    if (a.b(this.mUri))
    {
      c.b(TAG, "Not executing local Uri: " + this.mUri);
      return;
    }
    c.b(TAG, "Executing Uri action from channel " + this.mChannel + ": " + this.mUri + ". UseWebView: " + this.mUseWebView + ". Extras: " + this.mExtras);
    if ((this.mUseWebView) && (a.a.contains(this.mUri.getScheme())))
    {
      if (this.mChannel.equals(e.a))
      {
        openUriWithWebViewActivityFromPush(paramContext, this.mUri, this.mExtras);
        return;
      }
      openUriWithWebViewActivity(paramContext, this.mUri, this.mExtras);
      return;
    }
    if (this.mChannel.equals(e.a))
    {
      openUriWithActionViewFromPush(paramContext, this.mUri, this.mExtras);
      return;
    }
    openUriWithActionView(paramContext, this.mUri, this.mExtras);
  }

  public Uri getUri()
  {
    return this.mUri;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.actions.UriAction
 * JD-Core Version:    0.6.2
 */