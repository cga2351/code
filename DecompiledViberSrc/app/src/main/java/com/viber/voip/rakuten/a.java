package com.viber.voip.rakuten;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.billing.b;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ah;
import com.viber.voip.registration.ai;
import com.viber.voip.registration.ao;
import com.viber.voip.registration.ao.b;
import com.viber.voip.registration.c.h;
import com.viber.voip.registration.c.p;
import com.viber.voip.registration.c.z;
import com.viber.voip.registration.s;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.at;
import com.viber.voip.util.cj;
import com.viber.voip.util.dl;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private h b;
  private e c;
  private String d;
  private String e;
  private String f;
  private d g;
  private b h;
  private c i;
  private ah j;

  private a()
  {
    a(e.a);
    this.j = ViberApplication.getInstance().getRequestCreator();
  }

  @Deprecated
  public static a a()
  {
    return a.a();
  }

  private void a(e parame)
  {
    this.c = parame;
    m();
  }

  private boolean c(Context paramContext)
  {
    if (this.b != null)
    {
      switch (1.a[this.c.ordinal()])
      {
      default:
      case 1:
      }
      while (true)
      {
        return true;
        if (this.b.d() != null)
        {
          a(this.b.d());
          this.b = null;
        }
        else if (this.b.c() != null)
        {
          paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.b.c())));
          this.b = null;
        }
      }
    }
    return false;
  }

  private static boolean l()
  {
    return !ao.f();
  }

  private void m()
  {
    if (this.g != null);
    switch (1.a[this.c.ordinal()])
    {
    default:
      return;
    case 1:
      this.g.e();
      return;
    case 2:
    case 3:
      this.g.a();
      return;
    case 4:
      this.g.a("+" + i(), this.f);
      return;
    case 5:
      this.g.b();
      return;
    case 6:
      this.g.c();
      return;
    case 7:
    }
    this.g.d();
  }

  private void n()
  {
    this.d = null;
    this.e = null;
    this.f = null;
  }

  private void o()
  {
    a(e.b);
    this.h = new b(null);
    this.h.execute(new Void[0]);
  }

  private void p()
  {
    a(e.b);
    this.i = new c(null);
    this.i.execute(new Void[0]);
  }

  public void a(Activity paramActivity)
  {
    if (l())
      c(paramActivity);
  }

  public void a(Context paramContext)
  {
    if (l())
    {
      if ((this.d == null) && (this.e == null))
        break label45;
      if (ViberApplication.isActivated())
      {
        if (this.c == e.a)
          o();
        RakutenRegistrationActivity.a(paramContext);
      }
    }
    label45: 
    while (!c(paramContext))
      return;
  }

  public void a(Context paramContext, String paramString)
  {
    String str1 = j();
    String str2 = ap.c().j + "?s=" + UserManager.from(paramContext).getRegistrationValues().n();
    if (!TextUtils.isEmpty(str1))
      str2 = str2 + "&t=" + str1;
    if (!TextUtils.isEmpty(paramString))
      str2 = str2 + "&" + paramString;
    ViberActionRunner.at.a(paramContext, dl.j(dl.h(dl.b(str2))));
  }

  public void a(Context paramContext, String paramString1, String paramString2)
  {
    RakutenUrlSchemeData localRakutenUrlSchemeData;
    if (l())
    {
      localRakutenUrlSchemeData = new RakutenUrlSchemeData(paramString1, paramString2);
      switch (1.a[this.c.ordinal()])
      {
      default:
      case 1:
      }
    }
    do
      return;
    while (!ViberApplication.isActivated());
    this.d = localRakutenUrlSchemeData.rToken;
    this.e = localRakutenUrlSchemeData.referral;
  }

  public void a(d paramd)
  {
    this.g = paramd;
    m();
  }

  public void a(h paramh)
  {
    if ((l()) && (paramh != null) && ((paramh.d() != null) || (paramh.c() != null)))
      this.b = paramh;
  }

  public void a(String paramString)
  {
    s.a(ao.b.e, paramString);
  }

  public void b(Context paramContext)
  {
    a(paramContext, "");
  }

  public void b(d paramd)
  {
    if (this.g == paramd)
      this.g = null;
  }

  public boolean b()
  {
    if (!l())
      return false;
    return UserManager.from(ViberApplication.getApplication()).getRegistrationValues().p();
  }

  public void c()
  {
    String str = ap.c().k;
    a("");
    n();
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str));
    localIntent.setFlags(268435456);
    ViberApplication.getApplication().startActivity(localIntent);
  }

  public void d()
  {
    p();
  }

  public void e()
  {
    a(e.a);
    n();
  }

  public void f()
  {
    a(e.a);
  }

  public void g()
  {
    a(e.a);
  }

  public void h()
  {
    a(e.a);
  }

  String i()
  {
    return b.b();
  }

  public String j()
  {
    return s.a(ao.b.e);
  }

  public void k()
  {
    s.b(ao.b.e);
    a(e.a);
    n();
  }

  private static final class a
  {
    private static final a a;

    static
    {
      if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a);
      for (a locala = new a(null); ; locala = null)
      {
        a = locala;
        return;
      }
    }
  }

  private class b extends AsyncTask<Void, Void, p>
  {
    private b()
    {
    }

    protected p a(Void[] paramArrayOfVoid)
    {
      try
      {
        if (a.a(a.this) != null)
          new ai().a(a.b(a.this).d(a.a(a.this)));
        if (a.c(a.this) != null)
        {
          p localp = (p)new ai().a(a.b(a.this).c(a.c(a.this)));
          return localp;
        }
        return null;
      }
      catch (Exception localException)
      {
        localException = localException;
        return null;
      }
      finally
      {
      }
    }

    protected void a(p paramp)
    {
      a.a(a.this, null);
      if (paramp == null)
      {
        a.d(a.this);
        a.a(a.this, a.e.a);
        return;
      }
      if (paramp.f())
      {
        a.a(a.this, paramp.a());
        a.a(a.this, a.e.c);
        return;
      }
      a.d(a.this);
      a.a(a.this, a.e.f);
    }
  }

  private class c extends AsyncTask<Void, Void, z>
  {
    private c()
    {
    }

    // ERROR //
    protected z a(Void[] paramArrayOfVoid)
    {
      // Byte code:
      //   0: new 22	com/viber/voip/registration/ai
      //   3: dup
      //   4: invokespecial 23	com/viber/voip/registration/ai:<init>	()V
      //   7: aload_0
      //   8: getfield 11	com/viber/voip/rakuten/a$c:a	Lcom/viber/voip/rakuten/a;
      //   11: invokestatic 29	com/viber/voip/rakuten/a:b	(Lcom/viber/voip/rakuten/a;)Lcom/viber/voip/registration/ah;
      //   14: aload_0
      //   15: getfield 11	com/viber/voip/rakuten/a$c:a	Lcom/viber/voip/rakuten/a;
      //   18: invokestatic 33	com/viber/voip/rakuten/a:c	(Lcom/viber/voip/rakuten/a;)Ljava/lang/String;
      //   21: invokevirtual 39	com/viber/voip/registration/ah:e	(Ljava/lang/String;)Lcom/viber/voip/registration/ag;
      //   24: invokevirtual 42	com/viber/voip/registration/ai:a	(Lcom/viber/voip/registration/ag;)Ljava/lang/Object;
      //   27: checkcast 44	com/viber/voip/registration/c/z
      //   30: astore 4
      //   32: aload 4
      //   34: areturn
      //   35: astore_3
      //   36: aconst_null
      //   37: areturn
      //   38: astore_2
      //   39: aload_2
      //   40: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   0	32	35	java/lang/Exception
      //   0	32	38	finally
    }

    protected void a(z paramz)
    {
      a.a(a.this, null);
      if ((paramz != null) && (paramz.f()))
      {
        a.this.a(a.c(a.this));
        a.d(a.this);
        a.a(a.this, a.e.e);
        return;
      }
      a.d(a.this);
      if ((paramz == null) && (!cj.b(ViberApplication.getApplication())))
      {
        a.a(a.this, a.e.g);
        return;
      }
      a.a(a.this, a.e.f);
    }
  }

  public static abstract interface d
  {
    public abstract void a();

    public abstract void a(String paramString1, String paramString2);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();
  }

  private static enum e
  {
    static
    {
      e[] arrayOfe = new e[7];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      arrayOfe[4] = e;
      arrayOfe[5] = f;
      arrayOfe[6] = g;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.rakuten.a
 * JD-Core Version:    0.6.2
 */