package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.a;

public class b
  implements a
{
  public List<String> a()
  {
    return Arrays.asList(new String[] { "me.everything.launcher" });
  }

  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws me.leolin.shortcutbadger.b
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("package_name", paramComponentName.getPackageName());
    localContentValues.put("activity_name", paramComponentName.getClassName());
    localContentValues.put("count", Integer.valueOf(paramInt));
    paramContext.getContentResolver().insert(Uri.parse("content://me.everything.badger/apps"), localContentValues);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.b
 * JD-Core Version:    0.6.2
 */