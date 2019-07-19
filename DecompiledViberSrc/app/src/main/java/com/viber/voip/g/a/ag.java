package com.viber.voip.g.a;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.ViberApplication;

public abstract class ag
{
  static Context a(ViberApplication paramViberApplication)
  {
    return ViberApplication.getApplication();
  }

  static Resources a(Context paramContext)
  {
    return paramContext.getResources();
  }

  static Application b(ViberApplication paramViberApplication)
  {
    return ViberApplication.getApplication();
  }

  static KeyguardManager b(Context paramContext)
  {
    return (KeyguardManager)paramContext.getSystemService("keyguard");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ag
 * JD-Core Version:    0.6.2
 */