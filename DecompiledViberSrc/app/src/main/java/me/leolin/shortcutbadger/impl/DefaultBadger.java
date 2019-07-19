package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.b;

public class DefaultBadger
  implements me.leolin.shortcutbadger.a
{
  public List<String> a()
  {
    return Arrays.asList(new String[] { "fr.neamar.kiss", "com.quaap.launchtime", "com.quaap.launchtime_official" });
  }

  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
    localIntent.putExtra("badge_count", paramInt);
    localIntent.putExtra("badge_count_package_name", paramComponentName.getPackageName());
    localIntent.putExtra("badge_count_class_name", paramComponentName.getClassName());
    me.leolin.shortcutbadger.a.a.c(paramContext, localIntent);
  }

  boolean a(Context paramContext)
  {
    return (me.leolin.shortcutbadger.a.a.a(paramContext, new Intent("android.intent.action.BADGE_COUNT_UPDATE")).size() > 0) || ((Build.VERSION.SDK_INT >= 26) && (me.leolin.shortcutbadger.a.a.a(paramContext, new Intent("me.leolin.shortcutbadger.BADGE_COUNT_UPDATE")).size() > 0));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.DefaultBadger
 * JD-Core Version:    0.6.2
 */