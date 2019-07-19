package com.viber.voip.notif;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.common.b.b;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.y;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.jni.mustupgrade.MustUpgradeDelegate;
import com.viber.jni.mustupgrade.MustUpgradeListener;
import com.viber.voip.AcceptTermsAndPoliciesDialogActivity;
import com.viber.voip.AcceptTermsAndPoliciesWebActivity;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberSystemActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.view.BlockedUserSplashActivity;
import com.viber.voip.p;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.be;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.bn;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.bo;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.y;
import com.viber.voip.ui.dialogs.e;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.ViberActionRunner.j;
import com.viber.voip.util.bs;
import com.viber.voip.util.d.a;
import java.io.IOException;

public final class h
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  private static final Logger e = ViberEnv.getLogger();
  private static h f;
  private boolean g;
  private boolean h;

  private h()
  {
    if (!ViberApplication.isActivated())
      j();
    com.viber.voip.util.d.a(new d.a()
    {
      public void a(boolean paramAnonymousBoolean, Class paramAnonymousClass)
      {
        if (paramAnonymousBoolean)
        {
          h.a(h.this, paramAnonymousClass);
          h.b(h.this, paramAnonymousClass);
        }
      }
    });
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    localEngine.addCallInfoListener(new CallHandler.CallInfoReadyListener()
    {
      public void onCallInfoReady(CallInfo paramAnonymousCallInfo)
      {
        if ((paramAnonymousCallInfo != null) && (!paramAnonymousCallInfo.isCallEnding()))
          h.a(h.this);
      }
    });
    EngineDelegatesManager localEngineDelegatesManager = localEngine.getDelegatesManager();
    DialerLocalCallStateListener localDialerLocalCallStateListener = localEngineDelegatesManager.getDialerLocalCallStateListener();
    DialerControllerDelegate.DialerLocalCallState[] arrayOfDialerLocalCallState = new DialerControllerDelegate.DialerLocalCallState[1];
    arrayOfDialerLocalCallState[0] = new DialerControllerDelegate.DialerLocalCallState()
    {
      public void onCallEnded(long paramAnonymousLong, boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        h.a(h.this, true);
      }

      public void onCallStarted(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
      {
      }

      public void onHangup()
      {
      }
    };
    localDialerLocalCallStateListener.registerDelegate(arrayOfDialerLocalCallState);
    ConnectionListener localConnectionListener = localEngineDelegatesManager.getConnectionListener();
    ConnectionDelegate[] arrayOfConnectionDelegate = new ConnectionDelegate[1];
    arrayOfConnectionDelegate[0] = new ConnectionDelegate()
    {
      public void onConnect()
      {
      }

      public void onConnectionStateChange(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
        {
          h.b(h.this, false);
          h.this.h();
        }
      }
    };
    localConnectionListener.registerDelegate(arrayOfConnectionDelegate);
    MustUpgradeListener localMustUpgradeListener = localEngineDelegatesManager.getMustUpgradeListener();
    MustUpgradeDelegate[] arrayOfMustUpgradeDelegate = new MustUpgradeDelegate[1];
    arrayOfMustUpgradeDelegate[0] = new MustUpgradeDelegate()
    {
      public void onClientUpgrade(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 1)
          h.this.e();
        while (paramAnonymousInt != 2)
          return;
        h.this.f();
      }
    };
    localMustUpgradeListener.registerDelegate(arrayOfMustUpgradeDelegate);
  }

  public static h a()
  {
    if (f == null)
      f = new h();
    return f;
  }

  private void a(DialogCode paramDialogCode)
  {
    try
    {
      z.a(ViberApplication.getApplication(), paramDialogCode);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void a(Class paramClass)
  {
    if ((!ViberSystemActivity.class.equals(paramClass)) && (!AcceptTermsAndPoliciesDialogActivity.class.equals(paramClass)) && (!AcceptTermsAndPoliciesWebActivity.class.equals(paramClass)))
    {
      k();
      return;
    }
    h();
  }

  private void b(Class paramClass)
  {
    if ((!BlockedUserSplashActivity.class.equals(paramClass)) && (!ao.f()) && (d.ad.K.d()) && (!ViberSystemActivity.class.equals(paramClass)) && (!AcceptTermsAndPoliciesDialogActivity.class.equals(paramClass)) && (!AcceptTermsAndPoliciesWebActivity.class.equals(paramClass)))
      ViberActionRunner.j.a(ViberApplication.getApplication(), d.ad.L.d());
  }

  private void b(boolean paramBoolean)
  {
    if ((paramBoolean) || (m()))
    {
      c(this.g);
      d(this.h);
      e(d());
    }
  }

  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e.c().a(new ViberDialogHandlers.bn()).d();
      return;
    }
    a(DialogCode.D725);
  }

  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e.d().a(new ViberDialogHandlers.bo()).d();
      return;
    }
    a(DialogCode.D726);
  }

  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.a(k.C().a(new ViberDialogHandlers.y()).b(AcceptTermsAndPoliciesDialogActivity.class).putExtra("com.viber.extra.TYPE", "REMOTE_DIALOG"));
      return;
    }
    a(DialogCode.D3004);
  }

  private void k()
  {
    b(false);
  }

  private void l()
  {
    if (this.g)
      c(false);
    if (this.h)
      d(false);
    if (d())
      e(false);
  }

  private boolean m()
  {
    if (!ViberApplication.getInstance().isOnForeground());
    CallInfo localCallInfo;
    do
    {
      return false;
      localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
    }
    while ((localCallInfo != null) && (!localCallInfo.isCallEnding()));
    return true;
  }

  private void n()
  {
    a(true, false);
  }

  public void a(final Context paramContext)
  {
    if (bs.a())
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse("https://www.viber.com/dl?forward=amazon"));
      paramContext.startActivity(localIntent);
      return;
    }
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        int i = 1;
        try
        {
          boolean bool = bs.b();
          i = bool;
          label10: if (i != 0);
          for (String str = "https://www.viber.com/dl" + "?forward=google"; ; str = "https://www.viber.com/dl" + "?forward=direct")
          {
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setData(Uri.parse(str));
            paramContext.startActivity(localIntent);
            return;
          }
        }
        catch (IOException localIOException)
        {
          break label10;
        }
      }
    });
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = d; ; i = c)
    {
      int j = d.be.d.d();
      if (j != i)
      {
        if (j != a)
          d.be.c.a(true);
        d.be.d.a(i);
        k();
      }
      return;
    }
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    d.be.c.a(false);
    if (paramBoolean1)
      e(false);
    if (paramBoolean2)
      ViberApplication.getInstance().getEngine(true).getCdrController().handleReportTermsAndPrivacyPolicy();
  }

  public void b()
  {
    this.g = false;
    String str1 = p.d();
    String str2 = d.be.a.d();
    if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1)))
    {
      boolean bool1 = d.be.b.d();
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      this.h = bool2;
      return;
    }
    d.be.b.e();
    this.h = false;
  }

  public boolean c()
  {
    return this.g;
  }

  public boolean d()
  {
    return d.be.c.d();
  }

  public void e()
  {
    this.g = true;
    k();
  }

  public void f()
  {
    String str1 = d.be.a.d();
    String str2 = p.d();
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2)))
      return;
    d.be.b.a(false);
    d.be.a.a(str2);
    this.h = true;
    k();
  }

  public void g()
  {
    d.be.c.a(true);
    k();
  }

  protected void h()
  {
    if (!this.g)
      c(false);
    if (!this.h)
      d(false);
    if (!d())
      e(false);
  }

  public void i()
  {
    d.be.b.a(true);
    this.h = false;
  }

  public void j()
  {
    d.be.d.e();
    n();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h
 * JD-Core Version:    0.6.2
 */