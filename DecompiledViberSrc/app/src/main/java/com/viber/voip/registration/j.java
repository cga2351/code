package com.viber.voip.registration;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.permissions.b;
import com.viber.voip.permissions.c.a;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cg;
import com.viber.voip.util.dj;
import com.viber.voip.widget.MessageBar;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public abstract class j extends aq
  implements m.c, c.a, ActivationController.a, w.a
{
  private static final long a = TimeUnit.MINUTES.toMillis(5L);
  private static final long b = TimeUnit.SECONDS.toMillis(10L);
  private final Logger c = ViberEnv.getLogger(getClass());
  private int d;
  protected Handler e;
  protected TextView f;
  protected PopupWindow g;
  protected int h;
  protected View i;
  protected com.viber.common.permission.c j;
  protected boolean k;
  protected String l;
  protected d m;
  private int n;
  private boolean o;
  private com.viber.voip.permissions.c p;

  private void a(long paramLong)
  {
    Message localMessage = this.e.obtainMessage(1);
    this.e.sendMessageDelayed(localMessage, paramLong);
  }

  private void a(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      ad.a(paramString).a(localFragmentActivity);
  }

  private void c()
  {
    ActivationController localActivationController = w();
    localActivationController.setDeviceKey(null);
    localActivationController.setKeyChainDeviceKey(null);
    UserManager.from(getActivity()).getRegistrationValues().a().b();
    a(b);
    localActivationController.startRegistration(localActivationController.getCountryCode(), localActivationController.getRegNumber(), null, null, true, this.m, this, localActivationController.getKeyChainDeviceKeySource());
  }

  private void d()
  {
    av.a(av.e.b).post(new Runnable()
    {
      public void run()
      {
        ViberApplication.getInstance().getEngine(true).reInitService();
      }
    });
  }

  public void A()
  {
    t();
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        j.this.w().resumeActivation();
      }
    });
  }

  public void B()
  {
    x();
    t();
    c("waiting_for_activation_dialog");
  }

  protected void C()
  {
    View localView = getLayoutInflater().inflate(Z_(), null, false);
    this.d = getResources().getDimensionPixelSize(R.dimen.info_popup_width);
    this.n = getResources().getDimensionPixelSize(R.dimen.info_popup_height);
    if ((this instanceof al))
      localView.setBackgroundResource(R.drawable.info_popup_secure_bg);
    this.g = new PopupWindow(localView, this.d, this.n);
    this.g.setTouchable(true);
    this.g.setOutsideTouchable(true);
    this.g.setFocusable(true);
    this.g.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
    this.h = getResources().getDimensionPixelSize(R.dimen.info_popup_maring);
  }

  protected void D()
  {
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int i1;
    int i2;
    if (!this.g.isShowing())
    {
      arrayOfInt1 = new int[2];
      arrayOfInt2 = new int[2];
      this.i.getLocationOnScreen(arrayOfInt1);
      this.f.getLocationOnScreen(arrayOfInt2);
      if (dj.c(getActivity()))
        break label113;
      i1 = arrayOfInt1[0] + this.i.getMeasuredWidth() / 2 - this.d / 2;
      if (!(this instanceof al))
        break label155;
      if (dj.c(getActivity()))
        break label130;
      i2 = arrayOfInt2[1] - this.n - this.h;
    }
    while (true)
    {
      this.g.showAtLocation(this.i, 0, i1, i2);
      return;
      label113: i1 = arrayOfInt1[0] - this.d - this.h;
      break;
      label130: i2 = arrayOfInt1[1] + this.i.getMeasuredHeight() / 2 - this.n / 2;
      continue;
      label155: if (!dj.c(getActivity()))
        i2 = arrayOfInt2[1] + this.f.getHeight();
      else
        i2 = arrayOfInt1[1] - this.h;
    }
  }

  protected abstract int Z_();

  protected abstract void a();

  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
    }
    r();
  }

  protected void a(View paramView)
  {
    this.f = ((TextView)paramView.findViewById(R.id.click_here));
    this.f.setVisibility(0);
    String str = this.f.getText().toString();
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new UnderlineSpan(), 0, str.length(), 0);
    this.f.setText(localSpannableString);
    this.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        j.this.a();
      }
    });
  }

  public void a(ActivationController.ActivationCode paramActivationCode)
  {
    this.e.post(new Runnable()
    {
      public void run()
      {
        j.this.t();
        j.this.c("waiting_for_activation_dialog");
      }
    });
  }

  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = cg.a(getContext(), paramString1, paramString3, paramString5);
    a locala = new a(paramString1, paramString2, paramString4, paramString3);
    if (ao.f());
    for (l.a locala1 = com.viber.voip.ui.dialogs.a.d(str); ; locala1 = com.viber.voip.ui.dialogs.a.c(str))
    {
      locala1.a(this).a(locala).b(this);
      return;
    }
  }

  protected void b(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()))
      return;
    int i1;
    if ("country_code_loading_dialog".equals(paramString))
      i1 = R.string.progress_loading;
    while (true)
      if ((i1 != -1) && (!ViberApplication.isTablet(localFragmentActivity)))
      {
        ad.a(i1).c(this);
        return;
        if ("waiting_for_activation_dialog".equals(paramString))
          i1 = R.string.waiting_for_sms;
        else if ("activation_waiting_dialog".equals(paramString))
          i1 = R.string.dialog_activation_title;
      }
      else
      {
        if (!(localFragmentActivity instanceof RegistrationActivity))
          break;
        ((RegistrationActivity)localFragmentActivity).d().a(getString(i1), "", 0, 0, false, true, true);
        return;
        i1 = -1;
      }
  }

  public void b(String paramString1, String paramString2)
  {
    t();
    if ((!this.o) && ("119".equals(paramString2)))
    {
      this.o = true;
      c();
      return;
    }
    c("waiting_for_activation_dialog");
    c(paramString1, paramString2);
  }

  protected void c(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (!(localFragmentActivity instanceof RegistrationActivity)));
    MessageBar localMessageBar;
    do
    {
      return;
      if (!ViberApplication.isTablet(getActivity()))
        break;
      localMessageBar = ((RegistrationActivity)localFragmentActivity).d();
    }
    while (localMessageBar == null);
    localMessageBar.a();
    return;
    z.b(this, DialogCode.D_PROGRESS);
  }

  protected void c(String paramString1, String paramString2)
  {
    a(paramString1);
  }

  protected void c(boolean paramBoolean)
  {
    ActivationController localActivationController = w();
    h();
    a(a);
    localActivationController.startRegistration(localActivationController.getCountryCode(), localActivationController.getRegNumber(), localActivationController.getKeyChainDeviceKey(), localActivationController.getKeyChainUDID(), paramBoolean, this.m, this, localActivationController.getKeyChainDeviceKeySource());
  }

  protected void e(boolean paramBoolean)
  {
    i();
    if (!ViberApplication.isActivated())
      if (!paramBoolean)
        break label27;
    label27: for (int i1 = 9; ; i1 = 1)
    {
      w().setStep(i1, true);
      return;
    }
  }

  public void f_(boolean paramBoolean)
  {
    c(paramBoolean);
  }

  public void g()
  {
    if (!ao.f())
    {
      e(false);
      t();
      if (getActivity() != null)
        ((RegistrationActivity)getActivity()).b();
    }
  }

  protected void h()
  {
    u();
  }

  protected void i()
  {
    v();
  }

  public boolean onBackPressed()
  {
    t();
    return super.onBackPressed();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = new Handler(new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        j.this.a(paramAnonymousMessage.what);
        return false;
      }
    });
    this.j = com.viber.common.permission.c.a(getActivity());
    if (ao.f());
    for (this.p = new com.viber.voip.permissions.a(this, this.j, this); ; this.p = new b(this, this.j, this))
    {
      this.m = g.a().c().b();
      return;
    }
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D105)) || (paramm.a(DialogCode.D105e)))
      switch (paramInt)
      {
      default:
      case -1:
      case -2:
      }
    while (true)
    {
      this.p.onDialogAction(paramm, paramInt);
      return;
      a locala = (a)paramm.d();
      w().storeRegValues(locala.a, locala.b, locala.d, locala.c);
      this.p.a();
      continue;
      this.k = true;
      this.l = "Activation Screen";
      continue;
      if ((paramm.a(DialogCode.D103)) || (paramm.a(DialogCode.D103a)) || (paramm.a(DialogCode.D103b)))
        switch (paramInt)
        {
        default:
          break;
        case -1:
          this.k = true;
          this.l = "Phone Number Validation";
        }
    }
  }

  public void onStart()
  {
    super.onStart();
    this.j.a(this.p);
  }

  public void onStop()
  {
    super.onStop();
    this.j.b(this.p);
  }

  protected void r()
  {
    if (ao.f())
    {
      i();
      x();
      return;
    }
    e(false);
  }

  protected void t()
  {
    this.e.removeMessages(1);
  }

  protected void u()
  {
    b("activation_waiting_dialog");
  }

  protected void v()
  {
    c("activation_waiting_dialog");
  }

  protected ActivationController w()
  {
    return ViberApplication.getInstance().getActivationController();
  }

  protected void x()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      f.b().a(localFragmentActivity);
  }

  protected void y()
  {
    ActivationController localActivationController = w();
    String str1 = localActivationController.getCountryCode();
    String str2 = localActivationController.getAlphaCountryCode();
    String str3 = localActivationController.getRegNumber();
    String str4 = localActivationController.getRegNumberCanonized();
    a(str1, str2, str3, localActivationController.getCountry(), str4);
  }

  public void z()
  {
    d();
  }

  private static class a
    implements Serializable
  {
    String a;
    String b;
    String c;
    String d;

    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString4;
      this.d = paramString3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.j
 * JD-Core Version:    0.6.2
 */