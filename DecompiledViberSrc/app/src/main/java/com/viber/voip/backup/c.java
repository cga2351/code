package com.viber.voip.backup;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.viber.common.a.e;
import com.viber.common.dialogs.h.a;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backup.c.d;
import com.viber.voip.backup.ui.RestoreActivity;
import com.viber.voip.notif.g;

public final class c
  implements Application.ActivityLifecycleCallbacks, j
{
  private static final e a = ViberEnv.getLogger();
  private final Context b;
  private final a c;
  private final b d;

  public c(Context paramContext, Engine paramEngine)
  {
    this.b = paramContext;
    this.c = new a(null);
    this.d = new b(paramEngine.getPhoneController());
  }

  public void a(Uri paramUri, int paramInt)
  {
    if (this.d.d(paramUri))
      this.d.a(paramUri, paramInt);
    while (!this.c.d(paramUri))
      return;
    this.c.a(paramUri, paramInt);
  }

  public void a(Uri paramUri, d paramd)
  {
    if (this.d.d(paramUri))
      this.d.a(paramUri, paramd);
    while (!this.c.d(paramUri))
      return;
    this.c.a(paramUri, paramd);
  }

  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }

  public boolean a()
  {
    return this.d.a();
  }

  public boolean a(Uri paramUri)
  {
    return (this.c.a(paramUri)) || (this.d.a(paramUri));
  }

  public void b(Uri paramUri)
  {
    if (this.d.d(paramUri))
      this.d.b(paramUri);
    while (!this.c.d(paramUri))
      return;
    this.c.b(paramUri);
  }

  public void c(Uri paramUri)
  {
    if (this.d.d(paramUri))
      this.d.c(paramUri);
    while (!this.c.d(paramUri))
      return;
    this.c.c(paramUri);
  }

  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.d.onActivityCreated(paramActivity, paramBundle);
    this.c.onActivityCreated(paramActivity, paramBundle);
  }

  public void onActivityDestroyed(Activity paramActivity)
  {
    this.d.onActivityDestroyed(paramActivity);
    this.c.onActivityDestroyed(paramActivity);
  }

  public void onActivityPaused(Activity paramActivity)
  {
    this.d.onActivityPaused(paramActivity);
    this.c.onActivityPaused(paramActivity);
  }

  public void onActivityResumed(Activity paramActivity)
  {
    this.d.onActivityResumed(paramActivity);
    this.c.onActivityResumed(paramActivity);
  }

  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    this.d.onActivitySaveInstanceState(paramActivity, paramBundle);
    this.c.onActivitySaveInstanceState(paramActivity, paramBundle);
  }

  public void onActivityStarted(Activity paramActivity)
  {
    this.d.onActivityStarted(paramActivity);
    this.c.onActivityStarted(paramActivity);
  }

  public void onActivityStopped(Activity paramActivity)
  {
    this.d.onActivityStopped(paramActivity);
    this.c.onActivityStopped(paramActivity);
  }

  private final class a
    implements Application.ActivityLifecycleCallbacks, j
  {
    private volatile boolean b;
    private volatile boolean c;
    private volatile boolean d;
    private volatile d e;
    private volatile int f = 0;

    private a()
    {
    }

    private void a()
    {
      if ((this.b) && (this.c))
      {
        if (!this.d)
          break label54;
        Toast.makeText(c.a(c.this), R.string.backup_export_complete, 1).show();
      }
      while (true)
      {
        this.c = false;
        this.d = false;
        this.e = null;
        return;
        label54: if (this.e != null)
          com.viber.voip.ui.dialogs.t.j().d();
      }
    }

    public void a(Uri paramUri, int paramInt)
    {
    }

    public void a(Uri paramUri, d paramd)
    {
      this.c = true;
      this.d = false;
      this.e = paramd;
      a();
    }

    public void a(boolean paramBoolean)
    {
      if (paramBoolean);
      for (int i = -1; ; i = 1)
      {
        this.f = Math.max(i + this.f, 0);
        return;
      }
    }

    public boolean a(Uri paramUri)
    {
      return d(paramUri);
    }

    public void b(Uri paramUri)
    {
      this.c = true;
      this.d = true;
      this.e = null;
      a();
    }

    public void c(Uri paramUri)
    {
      this.c = true;
      this.d = false;
      this.e = null;
      a();
    }

    public boolean d(Uri paramUri)
    {
      return (this.f == 0) && (t.c(paramUri));
    }

    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
    }

    public void onActivityDestroyed(Activity paramActivity)
    {
    }

    public void onActivityPaused(Activity paramActivity)
    {
      this.b = false;
    }

    public void onActivityResumed(Activity paramActivity)
    {
      if (l.a(paramActivity))
        this.b = false;
      do
      {
        return;
        this.b = true;
      }
      while (!this.c);
      a();
    }

    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
    }

    public void onActivityStarted(Activity paramActivity)
    {
    }

    public void onActivityStopped(Activity paramActivity)
    {
    }
  }

  private final class b
    implements Application.ActivityLifecycleCallbacks, j
  {
    private final PhoneController b;
    private volatile boolean c;
    private volatile boolean d;
    private volatile boolean e;
    private final Handler f;
    private final Runnable g = new Runnable()
    {
      public void run()
      {
        c.b.a(c.b.this);
      }
    };

    public b(PhoneController arg2)
    {
      Object localObject;
      this.b = localObject;
      this.f = av.a(av.e.f);
    }

    private void a(boolean paramBoolean)
    {
      if (this.c != paramBoolean)
      {
        this.c = paramBoolean;
        e();
      }
    }

    private boolean a(Activity paramActivity)
    {
      return paramActivity instanceof RestoreActivity;
    }

    private void b()
    {
      if (!this.e)
      {
        this.e = true;
        g.a(c.a(c.this)).h();
        this.b.disconnect();
      }
    }

    private void c()
    {
      if (this.e)
      {
        this.b.connect();
        this.e = false;
      }
    }

    private void d()
    {
      if ((this.c) || (this.d));
      for (int i = 1; i != 0; i = 0)
      {
        b();
        return;
      }
      c();
    }

    private void e()
    {
      this.f.post(this.g);
    }

    public void a(Uri paramUri, int paramInt)
    {
      a(true);
    }

    public void a(Uri paramUri, d paramd)
    {
      a(false);
    }

    public boolean a()
    {
      return this.e;
    }

    public boolean a(Uri paramUri)
    {
      return false;
    }

    public void b(Uri paramUri)
    {
      a(false);
    }

    public void c(Uri paramUri)
    {
      a(false);
    }

    public boolean d(Uri paramUri)
    {
      return t.d(paramUri);
    }

    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
    }

    public void onActivityDestroyed(Activity paramActivity)
    {
    }

    public void onActivityPaused(Activity paramActivity)
    {
      if (this.d)
      {
        this.d = false;
        e();
      }
    }

    public void onActivityResumed(Activity paramActivity)
    {
      boolean bool = this.d;
      this.d = a(paramActivity);
      if (bool != this.d)
        e();
    }

    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
    }

    public void onActivityStarted(Activity paramActivity)
    {
    }

    public void onActivityStopped(Activity paramActivity)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.c
 * JD-Core Version:    0.6.2
 */