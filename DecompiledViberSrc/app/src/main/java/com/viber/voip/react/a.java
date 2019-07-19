package com.viber.voip.react;

import android.text.TextUtils;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;

class a
  implements Runnable
{
  private static final Logger a = ViberEnv.getLogger();
  private final d b;
  private final ReactContextManager.Params c;

  a(d paramd, ReactContextManager.Params paramParams)
  {
    this.b = paramd;
    this.c = paramParams;
  }

  public void run()
  {
    boolean bool = this.c.isInitRequested();
    if ((bool) && ((TextUtils.isEmpty(this.c.getMemberId())) || (TextUtils.isEmpty(this.c.getRegPhoneCanonized()))));
    e locale;
    ReactContext localReactContext;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            locale = this.b.a(ViberApplication.getApplication(), this.c);
          }
          while (locale == null);
          if (!bool)
            break;
        }
        while (locale.b());
        locale.c();
        return;
      }
      while (!locale.b());
      localReactContext = locale.a().getCurrentReactContext();
    }
    while ((localReactContext != null) && (localReactContext.getCurrentActivity() != null));
    locale.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.react.a
 * JD-Core Version:    0.6.2
 */