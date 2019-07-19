package me.leolin.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;
import me.leolin.shortcutbadger.a;
import me.leolin.shortcutbadger.b;

public class h
  implements a
{
  private final Uri a = Uri.parse("content://com.android.badge/badge");

  public List<String> a()
  {
    return Collections.singletonList("com.zui.launcher");
  }

  @TargetApi(11)
  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("app_badge_count", paramInt);
    paramContext.getContentResolver().call(this.a, "setAppBadgeCount", null, localBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.h
 * JD-Core Version:    0.6.2
 */