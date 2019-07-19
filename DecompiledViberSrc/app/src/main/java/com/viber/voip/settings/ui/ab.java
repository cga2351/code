package com.viber.voip.settings.ui;

import android.os.Handler;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.g;
import dagger.b;

public final class ab
  implements b<y>
{
  public static void a(y paramy, Handler paramHandler)
  {
    paramy.c = paramHandler;
  }

  public static void a(y paramy, ICdrController paramICdrController)
  {
    paramy.e = paramICdrController;
  }

  public static void a(y paramy, g paramg)
  {
    paramy.d = paramg;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ab
 * JD-Core Version:    0.6.2
 */