package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.b;

public class AdwHomeBadger
  implements me.leolin.shortcutbadger.a
{
  public List<String> a()
  {
    return Arrays.asList(new String[] { "org.adw.launcher", "org.adwfreak.launcher" });
  }

  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    Intent localIntent = new Intent("org.adw.launcher.counter.SEND");
    localIntent.putExtra("PNAME", paramComponentName.getPackageName());
    localIntent.putExtra("CNAME", paramComponentName.getClassName());
    localIntent.putExtra("COUNT", paramInt);
    me.leolin.shortcutbadger.a.a.b(paramContext, localIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.AdwHomeBadger
 * JD-Core Version:    0.6.2
 */