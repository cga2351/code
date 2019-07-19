package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.viber.voip.app.b;
import com.viber.voip.notif.f;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.util.cv;
import com.viber.voip.w;
import dagger.a;
import dagger.a.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gp
  implements d<w>
{
  private final Provider<Context> a;
  private final Provider<Handler> b;
  private final Provider<cv> c;
  private final Provider<f> d;
  private final Provider<ProfileNotification> e;
  private final Provider<b> f;

  public static w a(Context paramContext, Handler paramHandler, cv paramcv, a<f> parama, ProfileNotification paramProfileNotification, b paramb)
  {
    return (w)h.a(go.a(paramContext, paramHandler, paramcv, parama, paramProfileNotification, paramb), "Cannot return null from a non-@Nullable @Provides method");
  }

  public w a()
  {
    return (w)h.a(go.a((Context)this.a.get(), (Handler)this.b.get(), (cv)this.c.get(), c.b(this.d), (ProfileNotification)this.e.get(), (b)this.f.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gp
 * JD-Core Version:    0.6.2
 */