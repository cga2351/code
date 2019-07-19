package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Collections;
import java.util.List;
import me.leolin.shortcutbadger.b;

public class NewHtcHomeBadger
  implements me.leolin.shortcutbadger.a
{
  public List<String> a()
  {
    return Collections.singletonList("com.htc.launcher");
  }

  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    int i = 1;
    Intent localIntent1 = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
    localIntent1.putExtra("com.htc.launcher.extra.COMPONENT", paramComponentName.flattenToShortString());
    localIntent1.putExtra("com.htc.launcher.extra.COUNT", paramInt);
    Intent localIntent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
    localIntent2.putExtra("packagename", paramComponentName.getPackageName());
    localIntent2.putExtra("count", paramInt);
    try
    {
      me.leolin.shortcutbadger.a.a.b(paramContext, localIntent1);
      j = i;
    }
    catch (b localb1)
    {
      try
      {
        while (true)
        {
          me.leolin.shortcutbadger.a.a.b(paramContext, localIntent2);
          if ((j != 0) || (i != 0))
            break;
          throw new b("unable to resolve intent: " + localIntent2.toString());
          localb1 = localb1;
          int j = 0;
        }
      }
      catch (b localb2)
      {
        while (true)
          i = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.NewHtcHomeBadger
 * JD-Core Version:    0.6.2
 */