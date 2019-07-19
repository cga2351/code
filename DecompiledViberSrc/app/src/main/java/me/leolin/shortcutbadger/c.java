package me.leolin.shortcutbadger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;
import me.leolin.shortcutbadger.impl.ApexHomeBadger;
import me.leolin.shortcutbadger.impl.DefaultBadger;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import me.leolin.shortcutbadger.impl.NovaHomeBadger;
import me.leolin.shortcutbadger.impl.SonyHomeBadger;
import me.leolin.shortcutbadger.impl.d;
import me.leolin.shortcutbadger.impl.e;
import me.leolin.shortcutbadger.impl.f;
import me.leolin.shortcutbadger.impl.g;
import me.leolin.shortcutbadger.impl.h;

public final class c
{
  private static final List<Class<? extends a>> a = new LinkedList();
  private static final Object b = new Object();
  private static a c;
  private static ComponentName d;

  static
  {
    a.add(AdwHomeBadger.class);
    a.add(ApexHomeBadger.class);
    a.add(DefaultBadger.class);
    a.add(NewHtcHomeBadger.class);
    a.add(NovaHomeBadger.class);
    a.add(SonyHomeBadger.class);
    a.add(me.leolin.shortcutbadger.impl.a.class);
    a.add(me.leolin.shortcutbadger.impl.c.class);
    a.add(d.class);
    a.add(e.class);
    a.add(h.class);
    a.add(f.class);
    a.add(g.class);
    a.add(me.leolin.shortcutbadger.impl.b.class);
  }

  public static void a(Context paramContext, int paramInt)
    throws b
  {
    if ((c == null) && (!a(paramContext)))
      throw new b("No default launcher available");
    try
    {
      c.a(paramContext, d, paramInt);
      return;
    }
    catch (Exception localException)
    {
      throw new b("Unable to execute badge", localException);
    }
  }

  private static boolean a(Context paramContext)
  {
    Intent localIntent1 = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
    if (localIntent1 == null)
    {
      Log.e("ShortcutBadger", "Unable to find launch intent for package " + paramContext.getPackageName());
      return false;
    }
    d = localIntent1.getComponent();
    Intent localIntent2 = new Intent("android.intent.action.MAIN");
    localIntent2.addCategory("android.intent.category.HOME");
    Iterator localIterator1 = paramContext.getPackageManager().queryIntentActivities(localIntent2, 65536).iterator();
    while (true)
    {
      String str;
      label125: Class localClass;
      if (localIterator1.hasNext())
      {
        str = ((ResolveInfo)localIterator1.next()).activityInfo.packageName;
        Iterator localIterator2 = a.iterator();
        if (localIterator2.hasNext())
          localClass = (Class)localIterator2.next();
      }
      try
      {
        locala = (a)localClass.newInstance();
        if ((locala == null) || (!locala.a().contains(str)))
          break label125;
        c = locala;
        if (c == null)
          continue;
        if (c == null)
        {
          if (Build.MANUFACTURER.equalsIgnoreCase("ZUK"))
            c = new h();
        }
        else
          return true;
      }
      catch (Exception localException)
      {
        while (true)
        {
          a locala = null;
          continue;
          if (Build.MANUFACTURER.equalsIgnoreCase("OPPO"))
            c = new d();
          else if (Build.MANUFACTURER.equalsIgnoreCase("VIVO"))
            c = new f();
          else if (Build.MANUFACTURER.equalsIgnoreCase("ZTE"))
            c = new g();
          else
            c = new DefaultBadger();
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.c
 * JD-Core Version:    0.6.2
 */