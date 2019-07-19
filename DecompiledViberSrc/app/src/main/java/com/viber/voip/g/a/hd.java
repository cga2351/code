package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.react.ReactContextManager;
import com.viber.voip.react.d;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bx;
import com.viber.voip.vln.e;
import com.viber.voip.vln.f;
import dagger.a;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

public abstract class hd
{
  @Singleton
  static d a(bx parambx, Handler paramHandler, EventBus paramEventBus, g paramg)
  {
    return new f(parambx, paramHandler, paramEventBus, paramg);
  }

  @Singleton
  static e a(ViberApplication paramViberApplication, a<ReactContextManager> parama, UserManager paramUserManager)
  {
    return new e(paramViberApplication, parama, paramUserManager);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.hd
 * JD-Core Version:    0.6.2
 */