package com.viber.voip.registration;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.c.v;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ah;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.bl;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.dj;
import com.viber.voip.util.dl;
import com.viber.voip.widget.TextViewWithDescriptionAndCountdown;
import com.viber.voip.widget.ViewWithDescription.a;
import java.text.SimpleDateFormat;
import javax.inject.Inject;

public abstract class h extends j
  implements View.OnClickListener
{
  private CountDownTimer A;
  private int B = 0;
  private long C = 60000L;
  private q D = q.a;
  private int E;
  private ProgressBar F;
  private cj.a G = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      boolean bool1 = true;
      boolean bool2;
      boolean bool4;
      label47: boolean bool3;
      label81: h localh;
      if (paramAnonymousInt1 != -1)
      {
        bool2 = bool1;
        if (h.g(h.this) != null)
        {
          TextView localTextView2 = h.g(h.this);
          if ((!bool2) || (!h.h(h.this)))
            break label121;
          bool4 = bool1;
          localTextView2.setEnabled(bool4);
        }
        TextView localTextView1 = h.j(h.this);
        if ((!bool2) || (!h.i(h.this)))
          break label127;
        bool3 = bool1;
        localTextView1.setEnabled(bool3);
        localh = h.this;
        if (bool2)
          break label133;
      }
      while (true)
      {
        localh.b(bool1);
        h.this.d(bool2);
        return;
        bool2 = false;
        break;
        label121: bool4 = false;
        break label47;
        label127: bool3 = false;
        break label81;
        label133: bool1 = false;
      }
    }
  };
  protected final Logger a = ViberEnv.getLogger(getClass());
  protected ActivationController.ActivationCode b;

  @Inject
  public af c;

  @Inject
  dagger.a<d> d;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextViewWithDescriptionAndCountdown r;
  private TextView s;
  private TextView t;
  private TextView u;
  private boolean v = true;
  private boolean w = true;
  private com.viber.voip.util.t x;
  private com.viber.voip.util.t y;
  private ae z;

  private void E()
  {
    if (com.viber.common.d.c.a())
    {
      this.E = 7;
      return;
    }
    this.E = 5;
  }

  private void F()
  {
    int k;
    int i;
    label70: TextView localTextView;
    if (this.s != null)
    {
      if (this.D == q.b)
      {
        k = R.string.activation_screen_send_sms;
        this.s.setText(k);
      }
    }
    else
    {
      this.o.setText(com.viber.common.d.c.a(getString(R.string.activation_screen_wrong_number)));
      this.o.setOnClickListener(this);
      if (this.D != q.b)
        break label181;
      i = R.string.activation_screen_waiting_call_messsage;
      String str1 = b();
      String str2 = getString(i, new Object[] { str1 });
      int j = str2.indexOf(str1);
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new StyleSpan(1), j, j + str1.length(), 17);
      this.p.setText(localSpannableString);
      if (!this.mIsTablet)
      {
        localTextView = this.q;
        if (this.D != q.b)
          break label188;
      }
    }
    label181: label188: for (boolean bool = true; ; bool = false)
    {
      dj.c(localTextView, bool);
      return;
      k = R.string.activation_screen_resend_sms;
      break;
      i = R.string.activation_screen_waiting_sms_messsage;
      break label70;
    }
  }

  private void G()
  {
    boolean bool = true;
    switch (7.a[this.D.ordinal()])
    {
    default:
    case 2:
    case 1:
    }
    for (bool = false; ; bool = false)
      do
      {
        dj.c(this.n, bool);
        return;
      }
      while ((ActivationController.IS_ACTIVATION_BY_PHONE_CALL_AVAILABLE) && (this.j.a(n.o)));
  }

  private void H()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    if (com.viber.common.d.c.a())
    {
      localLayoutParams.leftMargin = com.viber.voip.util.e.j.a(getContext(), 5.0F);
      localLayoutParams.addRule(1, R.id.click_here);
      return;
    }
    localLayoutParams.rightMargin = com.viber.voip.util.e.j.a(getContext(), 5.0F);
    localLayoutParams.addRule(0, R.id.click_here);
  }

  private void I()
  {
    this.r.a(this.C);
    this.r.a(true);
    this.F.setProgress(0);
    dj.b(this.F, true);
    this.A = new CountDownTimer(this.C, 100L)
    {
      public void onFinish()
      {
        h.a(h.this, 1);
        h.this.v();
      }

      public void onTick(long paramAnonymousLong)
      {
        h.a(h.this, paramAnonymousLong);
        h.d(h.this).a(paramAnonymousLong);
        h.e(h.this).setProgress((int)(60000L - paramAnonymousLong));
      }
    };
    this.A.start();
  }

  private void J()
  {
    if (this.A != null)
    {
      this.A.cancel();
      this.A = null;
    }
    if (this.r != null)
      this.r.a(false);
    dj.b(this.F, false);
  }

  private void K()
  {
    dj.d(getActivity());
    M();
  }

  private void L()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()));
    do
    {
      an.a locala;
      do
      {
        return;
        locala = an.b(c());
      }
      while (!locala.a);
      this.C = 60000L;
      b(2);
      this.y = new com.viber.voip.util.t();
      this.z.b(String.valueOf(locala.b), new aj()
      {
        public void a(final v paramAnonymousv)
        {
          h.b(h.this, null);
          final FragmentActivity localFragmentActivity = h.this.getActivity();
          if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()));
          while (((paramAnonymousv != null) && (paramAnonymousv.f())) || (paramAnonymousv == null))
            return;
          h.b(h.this, new Runnable()
          {
            public void run()
            {
              if ("123".equals(paramAnonymousv.g()))
                h.f(h.this);
              while (!"109".equals(paramAnonymousv.g()))
                return;
              h.this.f_(false);
              h.this.j();
            }
          });
        }
      }
      , this.y);
    }
    while (this.D == q.c);
    this.D = q.c;
    F();
    G();
  }

  private void M()
  {
    if (ActivationController.ActivationCode.isEmpty(this.b))
      ad.f().b(this);
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    }
    while ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!e()));
    if (this.u != null)
      this.u.setEnabled(false);
    this.r.setEnabled(false);
    N();
    ((d)this.d.get()).a(this.b.source);
    a(this.b.code);
  }

  private void N()
  {
    z.a(this, DialogCode.D104a);
    if (ao.f())
      z.a(this, DialogCode.D104c);
  }

  private String O()
  {
    if (this.r != null)
      return this.r.getText().toString();
    return "";
  }

  private void P()
  {
    if (this.y != null)
    {
      this.y.b();
      this.y = null;
    }
  }

  private void Q()
  {
    if (this.x != null)
    {
      this.x.b();
      this.x = null;
    }
  }

  private void R()
  {
    com.viber.voip.ui.dialogs.a.b().b(this);
    J();
  }

  private void b(int paramInt)
  {
    this.B = paramInt;
    switch (paramInt)
    {
    default:
      return;
    case 0:
      g(false);
      h(false);
      I();
      return;
    case 1:
      if (this.s != null)
      {
        g(true);
        if (!an.a(c()))
          break label88;
        P();
      }
      while (true)
      {
        h(true);
        J();
        return;
        this.s.setText(R.string.activation_support_link);
        this.s.setId(R.id.activation_get_help);
        com.viber.voip.ui.dialogs.a.m().a(this).b(this);
      }
    case 2:
      label88: g(false);
      I();
      return;
    case 3:
    }
    g(false);
    h(false);
    J();
  }

  private void b(View paramView)
  {
    this.r = ((TextViewWithDescriptionAndCountdown)paramView.findViewById(R.id.code_input));
    this.r.setCountdownFormat(new SimpleDateFormat("mm:ss"));
    this.r.a(new TextWatcher()
    {
      private void a()
      {
        String str = h.b(h.this);
        if ((ActivationController.ActivationCode.isEmpty(h.this.b)) || (!TextUtils.equals(h.this.b.code, str)))
          h.this.b = new ActivationController.ActivationCode(str, ActivationController.b.b);
        h.c(h.this);
      }

      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = paramAnonymousEditable.toString().length();
        if (h.a(h.this) == null)
          if (i == 6)
            a();
        do
        {
          do
          {
            return;
            if (i < 4)
              break;
            h.a(h.this).setEnabled(true);
          }
          while (i != 6);
          a();
          return;
        }
        while (!h.a(h.this).isEnabled());
        h.a(h.this).setEnabled(false);
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }
    });
    this.t = ((TextView)paramView.findViewById(R.id.activate_via_call_btn));
    this.t.setOnClickListener(this);
    this.s = ((TextView)paramView.findViewById(R.id.resend_sms_btn));
    if (this.s != null)
      this.s.setOnClickListener(this);
    this.p = ((TextView)paramView.findViewById(R.id.subtitle));
    this.o = ((TextView)paramView.findViewById(R.id.change_number_btn));
    if (this.mIsTablet)
    {
      E();
      TextView localTextView = (TextView)paramView.findViewById(R.id.sync_txt);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams.addRule(this.E, R.id.code_input_container);
      localTextView.setLayoutParams(localLayoutParams);
      this.u = ((TextView)paramView.findViewById(R.id.continue_btn));
      if (ao.f())
      {
        this.t.setTextColor(getResources().getColorStateList(R.color.link_text_selector));
        this.u.setOnClickListener(this);
        this.i = paramView.findViewById(R.id.info_btn);
        this.i.setOnClickListener(this);
        a(paramView);
        H();
      }
    }
    while (true)
    {
      F();
      this.F = ((ProgressBar)paramView.findViewById(R.id.countdownProgress));
      this.F.setMax(60000);
      C();
      return;
      this.t.setText(R.string.activation_screen_activate_via_call);
      if (this.u == null)
        break;
      this.u.setVisibility(8);
      break;
      dj.b(paramView.findViewById(R.id.title), Y_());
      this.n = ((TextView)paramView.findViewById(R.id.code_auto_detection_hint));
      this.q = ((TextView)paramView.findViewById(R.id.waiting_call_warning));
    }
  }

  private void d(ActivationController.ActivationCode paramActivationCode)
  {
    this.b = paramActivationCode;
    if (this.r != null)
      this.r.setText(paramActivationCode.code);
  }

  private void d(String paramString)
  {
    ((d)this.d.get()).a(o(), paramString);
    String str1 = c();
    String str2 = String.format(ap.c().aR, new Object[] { str1 });
    GenericWebViewActivity.a(getActivity(), str2, getString(R.string.activation_support_link));
  }

  private q f(boolean paramBoolean)
  {
    if (paramBoolean)
      return q.b;
    return q.c;
  }

  private void g(boolean paramBoolean)
  {
    if (this.s != null)
    {
      if (cj.b(getActivity()))
        this.s.setEnabled(paramBoolean);
      this.v = paramBoolean;
    }
  }

  private void h(boolean paramBoolean)
  {
    if (cj.b(getActivity()))
      this.t.setEnabled(paramBoolean);
    this.w = paramBoolean;
  }

  protected abstract boolean Y_();

  protected int Z_()
  {
    return R.layout.info_popup_secondary;
  }

  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(R.layout.activation, paramViewGroup, false);
  }

  protected q a(Bundle paramBundle)
  {
    q localq;
    if (ao.f())
      localq = q.a;
    do
    {
      return localq;
      if (paramBundle == null)
        break;
      localq = (q)paramBundle.getSerializable("key_expected_activation_code_source");
    }
    while (localq != null);
    return f(w().isRegistrationMadeViaTzintuk());
  }

  protected void a()
  {
    com.viber.voip.ui.dialogs.a.h().a(this).b(this);
  }

  public void a(final ActivationController.ActivationCode paramActivationCode)
  {
    b(paramActivationCode);
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        h.this.c(paramActivationCode);
      }
    });
  }

  protected abstract void a(String paramString);

  public void a(String paramString1, String paramString2)
  {
    p();
    if ((this.b.source != ActivationController.b.c) && (this.b.code.equals(paramString1)))
    {
      if (!TextUtils.isEmpty(paramString2))
        break label84;
      if (!ao.f())
        break label73;
      com.viber.voip.ui.dialogs.a.d().b(this);
    }
    while (true)
    {
      if ((getActivity() instanceof RegistrationActivity))
        ((RegistrationActivity)getActivity()).b();
      return;
      label73: com.viber.voip.ui.dialogs.a.c().b(this);
      continue;
      label84: com.viber.voip.ui.dialogs.a.c().a(paramString2).e(false).b(this);
    }
  }

  protected abstract String b();

  protected abstract void b(ActivationController.ActivationCode paramActivationCode);

  protected abstract void b(boolean paramBoolean);

  protected abstract String c();

  public void c(ActivationController.ActivationCode paramActivationCode)
  {
    d(paramActivationCode);
    M();
    if (this.u != null)
      this.u.setEnabled(false);
    if (this.r != null)
      this.r.setEnabled(false);
  }

  protected void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    this.D = f(paramBoolean);
    F();
    G();
  }

  protected abstract void d();

  protected void d(boolean paramBoolean)
  {
    if ((paramBoolean) && (!ActivationController.ActivationCode.isEmpty(this.b)) && (this.b.code.length() == 6))
      K();
  }

  protected abstract boolean e();

  protected abstract void f();

  protected void j()
  {
    this.b = null;
    w().resetActivationCode();
  }

  protected ActivationController.ActivationCode k()
  {
    Bundle localBundle1 = getActivity().getIntent().getExtras();
    ActivationController.ActivationCode localActivationCode;
    if ((localBundle1 != null) && (localBundle1.getParcelable("activation_code") != null))
      localActivationCode = (ActivationController.ActivationCode)localBundle1.getParcelable("activation_code");
    Parcelable localParcelable;
    do
    {
      Bundle localBundle2;
      do
      {
        return localActivationCode;
        localBundle2 = getArguments();
        localActivationCode = null;
      }
      while (localBundle2 == null);
      localParcelable = getArguments().getParcelable("activation_code");
      localActivationCode = null;
    }
    while (localParcelable == null);
    return (ActivationController.ActivationCode)getArguments().getParcelable("activation_code");
  }

  protected void l()
  {
    if (this.B == 0)
    {
      b(3);
      this.C = 0L;
      if (an.a(c()))
        g(true);
      h(true);
    }
  }

  protected void m()
  {
    if (this.B == 0)
      b(3);
    this.C = 60000L;
    b(0);
  }

  protected void n()
  {
    ((d)this.d.get()).b(o());
    String str1 = ViberApplication.getInstance().getHardwareParameters().getUdid();
    String str2 = c();
    String str3 = dl.j(dl.b(String.format(ap.c().v, new Object[] { str2, str1 })));
    if ((this instanceof com.viber.voip.registration.changephonenumber.j))
      str3 = dl.m(str3);
    GenericWebViewActivity.a(getActivity(), str3, getString(R.string.activation_screen_activate_via_call));
  }

  protected String o()
  {
    return "Onboarding";
  }

  public void onAttach(Activity paramActivity)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramActivity);
    if (ao.f())
      com.viber.voip.ui.dialogs.a.f().b(this);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.continue_btn)
    {
      String str = O();
      if (str.length() >= 4)
        this.b = new ActivationController.ActivationCode(str, ActivationController.b.b);
      K();
    }
    do
    {
      do
      {
        return;
        if (i == R.id.change_number_btn)
        {
          d();
          return;
        }
        if (i == R.id.resend_sms_btn)
        {
          ((d)this.d.get()).c(o());
          if (!cj.b(getActivity()))
          {
            f.b().d();
            return;
          }
          L();
          return;
        }
        if (i != R.id.activate_via_call_btn)
          break;
        if (!ao.f())
        {
          n();
          return;
        }
      }
      while ((this.x != null) || (getActivity().isFinishing()));
      h(false);
      N();
      u();
      this.x = new com.viber.voip.util.t();
      this.z.a(new aj()
      {
        public void a(final com.viber.voip.registration.c.t paramAnonymoust)
        {
          h.a(h.this, null);
          h.a(h.this, new Runnable()
          {
            public void run()
            {
              FragmentActivity localFragmentActivity = h.this.getActivity();
              if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()))
                return;
              if ((paramAnonymoust != null) && (!paramAnonymoust.f()) && ("109".equals(paramAnonymoust.g())))
              {
                ActivationController localActivationController = h.this.w();
                localActivationController.setDeviceKey(null);
                localActivationController.setKeyChainDeviceKey(null);
                UserManager.from(localFragmentActivity).getRegistrationValues().a().b();
                localActivationController.setActivationStepToPref(0);
                ViberDialogHandlers.ah localah = new ViberDialogHandlers.ah();
                k.n().a(localah).d();
              }
              while (true)
              {
                h.a(h.this, true);
                h.this.v();
                return;
                if ((paramAnonymoust != null) && (paramAnonymoust.f()))
                  Toast.makeText(localFragmentActivity, R.string.resend_code_popup, 1).show();
              }
            }
          });
        }
      }
      , this.x);
      return;
      if (i == R.id.policy)
      {
        ViberActionRunner.bl.b(getActivity());
        return;
      }
      if (i == R.id.info_btn)
      {
        D();
        return;
      }
    }
    while (i != R.id.activation_get_help);
    d("screen");
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.g != null) && (this.g.isShowing()))
      this.g.dismiss();
    C();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.B = paramBundle.getInt("key_status");
      this.C = paramBundle.getLong("key_millis_until_finished");
    }
    this.D = a(paramBundle);
    this.z = new ae(ViberApplication.getInstance().getEngine(false), av.a(av.e.g), ViberApplication.getInstance().getRequestCreator());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = a(paramLayoutInflater, paramViewGroup);
    b(localView);
    b(this.B);
    ActivationController.ActivationCode localActivationCode = k();
    if (!ActivationController.ActivationCode.isEmpty(localActivationCode))
      c(localActivationCode);
    while (true)
    {
      cj.a(ViberApplication.getApplication()).a(this.G);
      return localView;
      if (this.u != null)
        this.u.setEnabled(false);
    }
  }

  public void onDestroy()
  {
    s();
    super.onDestroy();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D128))
      switch (paramInt)
      {
      default:
      case -1:
      }
    while ((!paramm.a(DialogCode.D140a)) || (-1 != paramInt))
    {
      return;
      ao.a(false);
      TextViewWithDescriptionAndCountdown localTextViewWithDescriptionAndCountdown = this.r;
      InputFilter[] arrayOfInputFilter = new InputFilter[1];
      if (ao.f());
      for (int i = 4; ; i = 6)
      {
        arrayOfInputFilter[0] = new InputFilter.LengthFilter(i);
        localTextViewWithDescriptionAndCountdown.setFilters(arrayOfInputFilter);
        y();
        return;
      }
    }
    d("dialog");
  }

  public void onResume()
  {
    super.onResume();
    G();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("key_status", this.B);
    paramBundle.putLong("key_millis_until_finished", this.C);
    paramBundle.putSerializable("key_expected_activation_code_source", this.D);
    super.onSaveInstanceState(paramBundle);
  }

  public void p()
  {
    if (this.u != null)
      this.u.setEnabled(true);
    this.r.setEnabled(true);
    v();
  }

  protected void q()
  {
    this.r.setStatus(ViewWithDescription.a.b);
    b(3);
  }

  protected void r()
  {
    super.r();
    if ((getActivity() != null) && (!getActivity().isFinishing()) && (ViberApplication.isTablet(getActivity())))
    {
      this.r.setEnabled(true);
      h(true);
    }
  }

  protected final void s()
  {
    f();
    Q();
    P();
    J();
    N();
    v();
    b(false);
    cj.a(ViberApplication.getApplication()).b(this.G);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.h
 * JD-Core Version:    0.6.2
 */