package com.viber.voip.notif;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import com.viber.voip.R.dimen;

public class a
{
  private final Context a;
  private int[] b;
  private final int[] c = { 400, 400 };

  public a(Context paramContext)
  {
    this.a = paramContext;
  }

  private int[] c()
  {
    Resources localResources = this.a.getResources();
    boolean bool = Build.MODEL.equalsIgnoreCase("sgp321");
    int i;
    int j;
    if (bool)
    {
      i = R.dimen.notification_big_picture_width_xperia_z;
      j = localResources.getDimensionPixelSize(i);
      if (!bool)
        break label66;
    }
    label66: for (int k = R.dimen.notification_big_picture_height_xperia_z; ; k = R.dimen.notification_big_picture_height)
    {
      return new int[] { j, localResources.getDimensionPixelSize(k) };
      i = R.dimen.notification_big_picture_width;
      break;
    }
  }

  public int[] a()
  {
    if (this.b == null)
      this.b = c();
    return this.b;
  }

  public int[] b()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a
 * JD-Core Version:    0.6.2
 */