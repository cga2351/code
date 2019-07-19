package me.leolin.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;
import me.leolin.shortcutbadger.b;

public class d
  implements me.leolin.shortcutbadger.a
{
  private int a = -1;

  @TargetApi(11)
  private void a(Context paramContext, int paramInt)
    throws b
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("app_badge_count", paramInt);
      paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
    throw new b("Unable to execute Badge By Content Provider");
  }

  private void b(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    if (paramInt == 0)
      paramInt = -1;
    Intent localIntent = new Intent("com.oppo.unsettledevent");
    localIntent.putExtra("pakeageName", paramComponentName.getPackageName());
    localIntent.putExtra("number", paramInt);
    localIntent.putExtra("upgradeNumber", paramInt);
    me.leolin.shortcutbadger.a.a.b(paramContext, localIntent);
  }

  public List<String> a()
  {
    return Collections.singletonList("com.oppo.launcher");
  }

  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    if (this.a == paramInt)
      return;
    this.a = paramInt;
    if (Build.VERSION.SDK_INT >= 11)
    {
      a(paramContext, paramInt);
      return;
    }
    b(paramContext, paramComponentName, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.d
 * JD-Core Version:    0.6.2
 */