package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.b;
import com.viber.voip.notif.f;
import com.viber.voip.schedule.d;
import com.viber.voip.ui.j.av;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.util.ba;
import com.viber.voip.util.cn;
import com.viber.voip.util.cv;
import com.viber.voip.w;
import javax.inject.Singleton;

public abstract class go
{
  @Singleton
  static com.viber.voip.messages.ui.media.player.d.e a(ViberApplication paramViberApplication)
  {
    return paramViberApplication.getPlayerWindowManager();
  }

  static cn a(Context paramContext)
  {
    return new cn(paramContext.getResources());
  }

  static cv a()
  {
    return cv.a();
  }

  static w a(Context paramContext, Handler paramHandler, cv paramcv, dagger.a<f> parama, ProfileNotification paramProfileNotification, b paramb)
  {
    return new w(paramHandler, paramcv, new ba(paramContext, parama, d.a().c()), paramProfileNotification, paramb.a(paramContext));
  }

  static com.viber.voip.util.links.e b()
  {
    return com.viber.voip.util.links.e.a();
  }

  @Singleton
  static av c()
  {
    return new com.viber.voip.ui.j.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.go
 * JD-Core Version:    0.6.2
 */