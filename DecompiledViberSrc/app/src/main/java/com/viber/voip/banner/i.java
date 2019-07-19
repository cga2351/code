package com.viber.voip.banner;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.webkit.URLUtil;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.d.h;
import com.viber.voip.banner.d.j;
import com.viber.voip.banner.datatype.Splash;
import com.viber.voip.banner.e.a;
import com.viber.voip.messages.conversation.publicaccount.PublicChatsActivity;
import com.viber.voip.settings.d.ad;
import com.viber.voip.util.cj;
import com.viber.voip.util.d.b;
import com.viber.voip.util.dj;
import com.viber.voip.y;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class i
{
  private static final Logger a = ViberEnv.getLogger();
  private static i e;
  private static final d.b f = new d.b()
  {
    private Set<String> a;
    private String b;

    public void onAppStopped()
    {
      com.viber.voip.util.i.c(this);
    }

    public void onBackground()
    {
      Application localApplication = ViberApplication.getApplication();
      localApplication.sendBroadcast(new Intent("com.viber.voip.action.HIDE_REMOTE_SPLASH"));
      this.b = ViberApplication.getInstance().getActivityOnForeground();
      if (!d.ad.B.d())
        if ((!this.a.contains(this.b)) || (!dj.h(localApplication)))
          break label69;
      label69: for (boolean bool = true; ; bool = false)
      {
        d.ad.B.a(bool);
        return;
      }
    }

    public void onForeground()
    {
      String str = ViberApplication.getInstance().getActivityOnForeground();
      if (str == null);
      do
      {
        return;
        if (!str.equals(this.b))
        {
          d.ad.B.a(false);
          return;
        }
      }
      while (!PublicChatsActivity.a.equals(str));
      i.a().b(false);
    }

    public void onForegroundStateChanged(boolean paramAnonymousBoolean)
    {
      com.viber.voip.util.i.a(this, paramAnonymousBoolean);
    }
  };
  private final Handler b = av.a(av.e.g);
  private final Handler c = av.a(av.e.a);
  private final d d = new d(ViberApplication.getApplication());

  private i()
  {
    c();
  }

  public static Intent a(String paramString1, String paramString2)
  {
    return RemoteSplashActivity.a(paramString1, paramString2, -1L, null);
  }

  @Deprecated
  public static i a()
  {
    if (e == null);
    try
    {
      if (e == null)
        e = new i();
      return e;
    }
    finally
    {
    }
  }

  private void a(final long paramLong)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        i.a(i.this).b(paramLong);
      }
    });
  }

  private void a(long paramLong, int paramInt, String paramString)
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    if (localEngine.isInitialized())
      localEngine.getPhoneController().handleReportBannerStatistics(paramLong, paramInt, paramString);
  }

  private void a(h paramh)
  {
    Splash localSplash = a.h(paramh.c());
    if (!URLUtil.isNetworkUrl(localSplash.url))
      a(paramh.b(), paramh.e());
    while (!cj.b(ViberApplication.getApplication()))
      return;
    if (paramh.f())
    {
      a(paramh.b(), 0, paramh.e());
      a(paramh.b());
      return;
    }
    RemoteSplashActivity.b(localSplash.title, localSplash.url, paramh.b(), paramh.e());
    a(paramh.b(), 0, paramh.e());
  }

  private void c()
  {
    com.viber.voip.util.d.c(f);
  }

  public void a(long paramLong, String paramString)
  {
    if (paramString != null)
      a(paramLong, 1, paramString);
    a(paramLong);
  }

  public void a(long paramLong, j[] paramArrayOfj)
  {
    if (d.ad.A.d())
      return;
    if (paramLong > 0L)
    {
      this.b.postDelayed(new a(paramArrayOfj), paramLong);
      return;
    }
    this.b.post(new a(paramArrayOfj));
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (long l = 500L; ; l = 0L)
    {
      j[] arrayOfj = new j[1];
      arrayOfj[0] = j.a;
      a(l, arrayOfj);
      d.ad.B.a(false);
      return;
    }
  }

  public void a(j[] paramArrayOfj)
  {
    if (d.ad.A.d())
      return;
    this.b.post(new a(paramArrayOfj));
  }

  public void b()
  {
    d.ad.C.a(true);
  }

  public void b(boolean paramBoolean)
  {
    if (d.ad.B.d())
      if (!paramBoolean)
        break label45;
    label45: for (long l = 500L; ; l = 0L)
    {
      j[] arrayOfj = new j[1];
      arrayOfj[0] = j.a;
      a(l, arrayOfj);
      d.ad.B.a(false);
      return;
    }
  }

  public void c(boolean paramBoolean)
  {
    if (d.ad.C.d())
      if (!paramBoolean)
        break label45;
    label45: for (long l = 500L; ; l = 0L)
    {
      j[] arrayOfj = new j[1];
      arrayOfj[0] = j.i;
      a(l, arrayOfj);
      d.ad.C.a(false);
      return;
    }
  }

  private final class a
    implements Runnable
  {
    private final j[] b;

    public a(j[] arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      j[] arrayOfj = this.b;
      int i = arrayOfj.length;
      int j = 0;
      while (j < i)
      {
        j localj = arrayOfj[j];
        h localh = i.a(i.this).a(localj);
        if (localh == null)
          j++;
        else
          i.a(i.this, localh);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.i
 * JD-Core Version:    0.6.2
 */