package com.yandex.mobile.ads.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.yandex.metrica.YandexMetrica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class cz
{
  private static final Object a = new Object();
  private static volatile cz b;
  private static final List<String> d = new ArrayList()
  {
    private static final long serialVersionUID = 5712356855156500689L;
  };
  private static final List<String> e = new ArrayList()
  {
    private static final long serialVersionUID = 7066618132468587294L;
  };
  private boolean c = true;

  public static cz a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new cz();
      return b;
    }
  }

  public static boolean b()
  {
    try
    {
      YandexMetrica.getLibraryVersion();
      return true;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
    }
    return false;
  }

  public final boolean a(Context paramContext)
    throws cz.a
  {
    if (this.c)
    {
      PackageManager localPackageManager;
      String str1;
      synchronized (a)
      {
        if (!this.c)
          break label248;
        if (!fl.a(paramContext))
          break label243;
        localPackageManager = paramContext.getPackageManager();
        str1 = paramContext.getPackageName();
        Iterator localIterator = new ArrayList(d).iterator();
        while (true)
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            ComponentName localComponentName = new ComponentName(str1, str2);
            try
            {
              localPackageManager.getActivityInfo(localComponentName, 32);
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException2)
            {
              throw new a(String.format("Please, check %s activity in AndroidManifest file.", new Object[] { str2 }));
            }
          }
      }
      try
      {
        ArrayList localArrayList = new ArrayList(e);
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(str1, 4096);
        if (localPackageInfo.requestedPermissions != null)
        {
          localArrayList.removeAll(Arrays.asList(localPackageInfo.requestedPermissions));
          if (localArrayList.size() > 0)
            throw new a(String.format("Please, check %s permission in AndroidManifest file.", new Object[] { localArrayList }));
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = e;
        throw new a(String.format("Please, check %s permission in AndroidManifest file.", arrayOfObject));
      }
      label243: this.c = false;
    }
    label248: return true;
  }

  public static final class a extends Exception
  {
    private static final long serialVersionUID = 3046464751153928670L;

    public a(String paramString)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cz
 * JD-Core Version:    0.6.2
 */