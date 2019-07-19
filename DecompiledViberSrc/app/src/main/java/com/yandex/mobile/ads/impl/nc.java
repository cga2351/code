package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class nc
{
  private static final Object a = new Object();
  private static volatile nc b;
  private final nr c;
  private String[] d;

  private nc(Context paramContext)
  {
    this.c = new nr(paramContext);
  }

  public static nc a(Context paramContext)
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new nc(paramContext.getApplicationContext());
      return b;
    }
  }

  public final String[] a()
  {
    ArrayList localArrayList;
    if (this.d == null)
    {
      localArrayList = new ArrayList();
      if ((!this.c.a("com.android.launcher.permission.INSTALL_SHORTCUT")) || (!this.c.a("com.android.launcher.permission.UNINSTALL_SHORTCUT")))
        break label81;
    }
    label81: for (int i = 1; ; i = 0)
    {
      if (i != 0)
        localArrayList.add("shortcut");
      this.d = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
      return this.d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nc
 * JD-Core Version:    0.6.2
 */