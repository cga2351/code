package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import me.leolin.shortcutbadger.a;
import me.leolin.shortcutbadger.b;

public class g
  implements a
{
  public List<String> a()
  {
    return new ArrayList(0);
  }

  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("app_badge_count", paramInt);
    localBundle.putString("app_badge_component_name", paramComponentName.flattenToString());
    if (Build.VERSION.SDK_INT >= 11)
      paramContext.getContentResolver().call(Uri.parse("content://com.android.launcher3.cornermark.unreadbadge"), "setAppUnreadCount", null, localBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.g
 * JD-Core Version:    0.6.2
 */