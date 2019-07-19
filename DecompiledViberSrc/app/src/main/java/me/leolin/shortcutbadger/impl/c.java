package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.a;
import me.leolin.shortcutbadger.b;

public class c
  implements a
{
  public List<String> a()
  {
    return Arrays.asList(new String[] { "com.huawei.android.launcher" });
  }

  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("package", paramContext.getPackageName());
    localBundle.putString("class", paramComponentName.getClassName());
    localBundle.putInt("badgenumber", paramInt);
    paramContext.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.c
 * JD-Core Version:    0.6.2
 */