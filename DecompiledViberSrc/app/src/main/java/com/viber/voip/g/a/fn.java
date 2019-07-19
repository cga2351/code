package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.extras.a.e;
import com.viber.voip.messages.extras.c.a;
import javax.inject.Singleton;

public abstract class fn
{
  static e a(ViberApplication paramViberApplication)
  {
    return paramViberApplication.getFacebookManager();
  }

  @Singleton
  static a a(Context paramContext, g paramg)
  {
    a locala = new a(paramg);
    locala.a(paramContext);
    return locala;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fn
 * JD-Core Version:    0.6.2
 */