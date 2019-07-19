package com.viber.voip.n;

import android.app.Application;
import android.view.Display;
import android.view.WindowManager;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private static int b = -1;
  private static int c = 0;

  public static int a()
  {
    int i = b();
    if (b == -1);
    for (int j = 0; ; j = b)
      return (360 + (j - i)) % 360;
  }

  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0;
    case 1:
      return 90;
    case 2:
      return 180;
    case 3:
    }
    return 270;
  }

  public static int b()
  {
    return a(c());
  }

  private static int c()
  {
    return ((WindowManager)ViberApplication.getApplication().getSystemService("window")).getDefaultDisplay().getRotation();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.n.b
 * JD-Core Version:    0.6.2
 */