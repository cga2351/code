package me.leolin.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.a;
import me.leolin.shortcutbadger.b;

public class SonyHomeBadger
  implements a
{
  private final Uri a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");
  private AsyncQueryHandler b;

  private ContentValues a(int paramInt, ComponentName paramComponentName)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("badge_count", Integer.valueOf(paramInt));
    localContentValues.put("package_name", paramComponentName.getPackageName());
    localContentValues.put("activity_name", paramComponentName.getClassName());
    return localContentValues;
  }

  private void a(ContentValues paramContentValues)
  {
    this.b.startInsert(0, null, this.a, paramContentValues);
  }

  private void a(Context paramContext, ContentValues paramContentValues)
  {
    paramContext.getApplicationContext().getContentResolver().insert(this.a, paramContentValues);
  }

  private static boolean a(Context paramContext)
  {
    ProviderInfo localProviderInfo = paramContext.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0);
    boolean bool = false;
    if (localProviderInfo != null)
      bool = true;
    return bool;
  }

  private static void b(Context paramContext, ComponentName paramComponentName, int paramInt)
  {
    Intent localIntent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
    localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", paramComponentName.getPackageName());
    localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", paramComponentName.getClassName());
    localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(paramInt));
    if (paramInt > 0);
    for (boolean bool = true; ; bool = false)
    {
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", bool);
      paramContext.sendBroadcast(localIntent);
      return;
    }
  }

  private void c(Context paramContext, ComponentName paramComponentName, int paramInt)
  {
    if (paramInt < 0)
      return;
    ContentValues localContentValues = a(paramInt, paramComponentName);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (this.b == null)
        this.b = new AsyncQueryHandler(paramContext.getApplicationContext().getContentResolver())
        {
        };
      a(localContentValues);
      return;
    }
    a(paramContext, localContentValues);
  }

  public List<String> a()
  {
    return Arrays.asList(new String[] { "com.sonyericsson.home", "com.sonymobile.home" });
  }

  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    if (a(paramContext))
    {
      c(paramContext, paramComponentName, paramInt);
      return;
    }
    b(paramContext, paramComponentName, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.SonyHomeBadger
 * JD-Core Version:    0.6.2
 */