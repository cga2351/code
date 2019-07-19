package com.viber.voip.camera.e.b;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

public final class a
{
  private final c a;
  private final Handler b = new Handler(Looper.getMainLooper());
  private final Runnable c = new a(null);

  public a(Activity paramActivity, int paramInt1, int paramInt2, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.a = new h(paramActivity, paramInt1, paramInt2, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a = new g(paramActivity, paramInt1, paramInt2, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      this.a = new f(paramActivity, paramInt1, paramInt2, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.a = new e(paramActivity, paramInt1, paramInt2, paramb);
      return;
    }
    this.a = new d(paramActivity, paramInt1, paramInt2, paramb);
  }

  private void b()
  {
    this.b.removeCallbacks(this.c);
  }

  public void a()
  {
    b();
    this.a.a();
  }

  public void a(long paramLong)
  {
    b();
    this.b.postDelayed(this.c, paramLong);
  }

  private class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      a.this.a();
    }
  }

  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }

  static abstract class c
  {
    final Activity a;
    final int b;
    final int c;
    final a.b d;
    boolean e = true;

    c(Activity paramActivity, int paramInt1, int paramInt2, a.b paramb)
    {
      this.a = paramActivity;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramb;
    }

    abstract void a();

    void a(boolean paramBoolean)
    {
      this.e = paramBoolean;
      if (this.d != null)
        this.d.a(this.e);
    }
  }

  static class d extends a.c
  {
    d(Activity paramActivity, int paramInt1, int paramInt2, a.b paramb)
    {
      super(paramInt1, paramInt2, paramb);
      if ((0x1 & this.c) != 0)
        this.a.getWindow().addFlags(768);
    }

    void a()
    {
      if (this.b > 0)
      {
        this.a.getWindow().addFlags(1024);
        a(false);
      }
    }
  }

  @TargetApi(11)
  static class e extends a.c
    implements View.OnSystemUiVisibilityChangeListener
  {
    final View f;

    e(Activity paramActivity, int paramInt1, int paramInt2, a.b paramb)
    {
      super(paramInt1, paramInt2, paramb);
      this.f = paramActivity.getWindow().getDecorView();
      this.f.setOnSystemUiVisibilityChangeListener(this);
    }

    void a()
    {
      this.f.setSystemUiVisibility(d());
    }

    protected void b()
    {
      ActionBar localActionBar = this.a.getActionBar();
      if (localActionBar != null)
        localActionBar.show();
      this.a.getWindow().clearFlags(1024);
      a(true);
    }

    protected void c()
    {
      ActionBar localActionBar = this.a.getActionBar();
      if (localActionBar != null)
        localActionBar.hide();
      this.a.getWindow().addFlags(1024);
      a(false);
    }

    protected int d()
    {
      return 1;
    }

    protected int e()
    {
      return 1;
    }

    public final void onSystemUiVisibilityChange(int paramInt)
    {
      if ((paramInt & e()) != 0)
      {
        c();
        return;
      }
      b();
    }
  }

  @TargetApi(14)
  static class f extends a.e
  {
    f(Activity paramActivity, int paramInt1, int paramInt2, a.b paramb)
    {
      super(paramInt1, paramInt2, paramb);
    }

    protected int d()
    {
      int i = 1;
      if (this.b >= 2)
        i = 3;
      return i;
    }

    protected int e()
    {
      if (this.b >= 2)
        return 2;
      return 1;
    }
  }

  @TargetApi(16)
  static class g extends a.f
  {
    g(Activity paramActivity, int paramInt1, int paramInt2, a.b paramb)
    {
      super(paramInt1, paramInt2, paramb);
    }

    protected void b()
    {
      if (this.b == 0)
      {
        ActionBar localActionBar = this.a.getActionBar();
        if (localActionBar != null)
          localActionBar.show();
      }
      a(true);
    }

    protected void c()
    {
      if (this.b == 0)
      {
        ActionBar localActionBar = this.a.getActionBar();
        if (localActionBar != null)
          localActionBar.hide();
      }
      a(false);
    }

    protected int d()
    {
      int i = super.d();
      if (this.b >= 1)
      {
        i |= 1284;
        if (this.b >= 2)
          i |= 512;
      }
      return i;
    }
  }

  @TargetApi(19)
  static class h extends a.g
  {
    h(Activity paramActivity, int paramInt1, int paramInt2, a.b paramb)
    {
      super(paramInt1, paramInt2, paramb);
    }

    protected int d()
    {
      int i = super.d();
      if (this.b == 3)
      {
        if ((0x2 & this.c) != 0);
        for (int j = 4096; ; j = 2048)
          return j | i;
      }
      return i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.e.b.a
 * JD-Core Version:    0.6.2
 */