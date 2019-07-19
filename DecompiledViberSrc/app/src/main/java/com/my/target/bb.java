package com.my.target;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;
import com.my.target.common.MyTargetActivity;
import com.my.target.common.MyTargetActivity.a;
import java.util.WeakHashMap;

public class bb
{
  private static final WeakHashMap<i, Boolean> a = new WeakHashMap();

  public static bb a()
  {
    return new bb();
  }

  private void a(String paramString, final i parami, final Context paramContext)
  {
    if ((parami.v()) || (bk.b(paramString)))
    {
      b(paramString, parami, paramContext);
      return;
    }
    a.put(parami, Boolean.valueOf(true));
    bk.e(paramString).a(new bk.a()
    {
      public void a(String paramAnonymousString)
      {
        if (!TextUtils.isEmpty(paramAnonymousString))
          bb.a(bb.this, paramAnonymousString, parami, paramContext);
        bb.b().remove(parami);
      }
    }).a(paramContext);
  }

  private void b(String paramString, i parami, Context paramContext)
  {
    a.a(paramString, parami).a(paramContext);
  }

  public void a(i parami, Context paramContext)
  {
    a(parami, parami.q(), paramContext);
  }

  public void a(i parami, String paramString, Context paramContext)
  {
    if (a.containsKey(parami));
    while (a.a(parami).a(paramContext))
      return;
    if (paramString != null)
      a(paramString, parami, paramContext);
    bi.a(parami.y().a("click"), paramContext);
  }

  private static abstract class a
  {
    protected final i a;

    protected a(i parami)
    {
      this.a = parami;
    }

    static a a(i parami)
    {
      return new bb.b(parami, null);
    }

    static a a(String paramString, i parami)
    {
      if (bk.b(paramString))
        return new bb.c(paramString, parami, null);
      return new bb.d(paramString, parami, null);
    }

    protected abstract boolean a(Context paramContext);
  }

  private static class b extends bb.a
  {
    private b(i parami)
    {
      super();
    }

    private boolean a(Intent paramIntent, Context paramContext)
    {
      try
      {
        if (!(paramContext instanceof Activity))
          paramIntent.addFlags(268435456);
        paramContext.startActivity(paramIntent);
        return true;
      }
      catch (Exception localException)
      {
      }
      return false;
    }

    private boolean a(String paramString1, String paramString2, Context paramContext)
    {
      if (paramString2 == null)
        return false;
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
        if (!(paramContext instanceof Activity))
          localIntent.addFlags(268435456);
        localIntent.setPackage(paramString1);
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception localException)
      {
      }
      return false;
    }

    private boolean b(String paramString1, String paramString2, Context paramContext)
    {
      if (paramString2 == null)
        return false;
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
        if (!(paramContext instanceof Activity))
          localIntent.addFlags(268435456);
        localIntent.setPackage(paramString1);
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception localException)
      {
      }
      return false;
    }

    protected boolean a(Context paramContext)
    {
      if (!"store".equals(this.a.m()));
      String str1;
      Intent localIntent;
      do
      {
        do
        {
          do
          {
            return false;
            str1 = this.a.b();
          }
          while (str1 == null);
          localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(str1);
        }
        while (localIntent == null);
        if (a(str1, this.a.e(), paramContext))
        {
          bi.a(this.a.y().a("deeplinkClick"), paramContext);
          return true;
        }
      }
      while ((!b(str1, this.a.s(), paramContext)) && (!a(localIntent, paramContext)));
      bi.a(this.a.y().a("click"), paramContext);
      String str2 = this.a.q();
      if ((str2 != null) && (!bk.b(str2)))
        bk.e(str2).a(paramContext);
      return true;
    }
  }

  private static class c extends bb.d
  {
    private c(String paramString, i parami)
    {
      super(parami, null);
    }

    private boolean a(String paramString, Context paramContext)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        if (!(paramContext instanceof Activity))
          localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception localException)
      {
      }
      return false;
    }

    private boolean b(String paramString, Context paramContext)
    {
      try
      {
        if (this.a.x())
        {
          Intent localIntent2 = paramContext.getPackageManager().getLaunchIntentForPackage("com.android.vending");
          if (localIntent2 != null)
          {
            localIntent2.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.activities.LaunchUrlHandlerActivity"));
            if (!(paramContext instanceof Activity))
              localIntent2.addFlags(268435456);
            localIntent2.setData(Uri.parse(paramString));
            paramContext.startActivity(localIntent2);
          }
        }
        else
        {
          Intent localIntent1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
          if (!(paramContext instanceof Activity))
            localIntent1.addFlags(268435456);
          paramContext.startActivity(localIntent1);
        }
      }
      catch (Exception localException)
      {
        return false;
      }
      return true;
    }

    protected boolean a(Context paramContext)
    {
      if (bk.c(this.b))
      {
        if (!a(this.b, paramContext));
      }
      else
        while (b(this.b, paramContext))
          return true;
      return super.a(paramContext);
    }
  }

  private static class d extends bb.a
  {
    protected final String b;

    private d(String paramString, i parami)
    {
      super();
      this.b = paramString;
    }

    private boolean a(String paramString, Context paramContext)
    {
      bb.e.a(paramString).a(paramContext);
      return true;
    }

    @TargetApi(18)
    private boolean b(String paramString, Context paramContext)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        Bundle localBundle = new Bundle();
        localBundle.putBinder("android.support.customtabs.extra.SESSION", null);
        if (!(paramContext instanceof Activity))
          localIntent.addFlags(268435456);
        localIntent.setPackage("com.android.chrome");
        localIntent.putExtras(localBundle);
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
      }
      return false;
    }

    private boolean c(String paramString, Context paramContext)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        if (!(paramContext instanceof Activity))
          localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception localException)
      {
      }
      return false;
    }

    protected boolean a(Context paramContext)
    {
      if (this.a.w())
        return c(this.b, paramContext);
      if ((Build.VERSION.SDK_INT >= 18) && (b(this.b, paramContext)))
        return true;
      if (("store".equals(this.a.m())) || ((Build.VERSION.SDK_INT >= 28) && (!bk.d(this.b))))
        return c(this.b, paramContext);
      return a(this.b, paramContext);
    }
  }

  private static class e
    implements MyTargetActivity.a
  {
    private final String a;
    private ba b;

    private e(String paramString)
    {
      this.a = paramString;
    }

    public static e a(String paramString)
    {
      return new e(paramString);
    }

    public void a(Context paramContext)
    {
      MyTargetActivity.a = this;
      Intent localIntent = new Intent(paramContext, MyTargetActivity.class);
      if (!(paramContext instanceof Activity))
        localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
    }

    public void a(final MyTargetActivity paramMyTargetActivity, Intent paramIntent, FrameLayout paramFrameLayout)
    {
      paramMyTargetActivity.setTheme(16973837);
      if (Build.VERSION.SDK_INT >= 21)
      {
        Window localWindow = paramMyTargetActivity.getWindow();
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(-12232092);
      }
      this.b = new ba(paramMyTargetActivity);
      paramFrameLayout.addView(this.b);
      this.b.d();
      this.b.setUrl(this.a);
      this.b.setListener(new ba.b()
      {
        public void a()
        {
          paramMyTargetActivity.finish();
        }
      });
    }

    public boolean a(MenuItem paramMenuItem)
    {
      return false;
    }

    public void b()
    {
    }

    public void c()
    {
    }

    public void d()
    {
    }

    public void e()
    {
      if (this.b != null)
      {
        this.b.c();
        this.b = null;
      }
    }

    public boolean f()
    {
      if ((this.b != null) && (this.b.a()))
      {
        this.b.b();
        return false;
      }
      return true;
    }

    public void k_()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bb
 * JD-Core Version:    0.6.2
 */