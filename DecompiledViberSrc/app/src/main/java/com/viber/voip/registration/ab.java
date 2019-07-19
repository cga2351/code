package com.viber.voip.registration;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.b.h;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.m;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.SecureSecondaryActivationDelegate;
import com.viber.jni.secure.SecureSecondaryActivationListener;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.az;
import com.viber.voip.settings.d.b;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ViberActionRunner.bl;
import com.viber.voip.util.dj;

public class ab extends j
  implements View.OnClickListener, ac.b
{
  private static final String[] a = { "primary", "secondary" };
  private static final Logger b = ViberEnv.getLogger();
  private Spinner c;
  private Spinner d;
  private Button n;
  private ac o;
  private SecureSecondaryActivationListener p;
  private d q;
  private final SecureSecondaryActivationDelegate r = new SecureSecondaryActivationDelegate()
  {
    public void onSecondaryStartActivation(final boolean paramAnonymousBoolean)
    {
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          ab.this.e(paramAnonymousBoolean);
          ab.this.t();
        }
      });
    }

    public void onSecureActivationCodeReceived(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
    {
    }

    public void onSecureSecondaryActivationFinished(int paramAnonymousInt)
    {
    }
  };
  private d.al s;
  private Runnable t;

  public ab()
  {
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[2];
    arrayOfa[0] = d.az.a;
    arrayOfa[1] = d.az.b;
    this.s = new d.al(arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        if (paramAnonymousa == d.az.a)
          d.az.a.d();
        while (true)
        {
          av.e.a.a().removeCallbacks(ab.a(ab.this));
          av.e.a.a().postDelayed(ab.a(ab.this), 100L);
          return;
          if (paramAnonymousa == d.az.b)
            d.az.b.d();
        }
      }
    };
    this.t = new Runnable()
    {
      public void run()
      {
        ViberApplication.exit(ab.this.getActivity(), true);
      }
    };
  }

  @SuppressLint({"MissingPermission"})
  private String a(CountryCode paramCountryCode)
  {
    if (this.j.a(new String[] { "android.permission.READ_PHONE_STATE" }));
    for (String str1 = ((TelephonyManager)ViberApplication.getApplication().getSystemService("phone")).getLine1Number(); ; str1 = null)
    {
      String str2 = paramCountryCode.getIddCode();
      String str3 = "+" + str2;
      String str6;
      if ((!TextUtils.isEmpty(str1)) && (str1.startsWith(str3)))
      {
        this.q.a("SIM card");
        str6 = str1.substring(str3.length());
      }
      String str5;
      boolean bool3;
      do
      {
        String str4;
        boolean bool2;
        do
        {
          boolean bool1;
          do
          {
            return str6;
            str4 = d.b.a.d();
            str5 = d.b.b.d();
            bool1 = TextUtils.isEmpty(str4);
            str6 = null;
          }
          while (bool1);
          bool2 = TextUtils.isEmpty(str5);
          str6 = null;
        }
        while (bool2);
        bool3 = str4.equals(str2);
        str6 = null;
      }
      while (!bool3);
      this.q.a("Backup Restore");
      return str5;
    }
  }

  private void a(a parama)
  {
    CountryCode localCountryCode = this.o.a();
    if (localCountryCode == null);
    String str;
    do
    {
      return;
      str = localCountryCode.getName();
      if (a.a == parama)
      {
        com.viber.voip.ui.dialogs.a.b(str).a(this).b(this);
        return;
      }
    }
    while (a.b != parama);
    com.viber.voip.ui.dialogs.a.a(str).a(this).b(this);
  }

  protected int Z_()
  {
    return 0;
  }

  protected void a()
  {
  }

  public void a(Intent paramIntent, int paramInt)
  {
    getActivity().startActivityForResult(paramIntent, paramInt);
  }

  public void a(ActivationController.ActivationCode paramActivationCode)
  {
    super.a(paramActivationCode);
    ActivationController localActivationController = w();
    localActivationController.setActivationCode(paramActivationCode);
    localActivationController.setStep(1, true);
  }

  public void a(boolean paramBoolean)
  {
    this.n.setEnabled(paramBoolean);
  }

  public void aa_()
  {
    String str1 = this.o.b();
    CountryCode localCountryCode = this.o.a();
    if ((TextUtils.isEmpty(str1)) || (localCountryCode == null))
      return;
    String str2 = localCountryCode.getIddCode();
    if (TextUtils.isEmpty(str2))
    {
      Toast.makeText(getActivity(), R.string.registration_invalid_idd_code, 0).show();
      return;
    }
    dj.a(getActivity(), false);
    String str3 = ViberApplication.getInstance().getEngine(true).getPhoneController().canonizePhoneNumberForCountryCode(Integer.parseInt(str2), str1);
    String str4 = localCountryCode.getCode();
    String str5 = localCountryCode.getName();
    boolean bool;
    if (!TextUtils.isEmpty(str4))
    {
      bool = new v().a(str2, str1);
      if (bool)
        break label179;
      this.k = true;
      this.l = "Phone Number Validation";
      com.viber.voip.ui.dialogs.a.a().b(this);
    }
    while (true)
    {
      if (!this.k)
        break label194;
      this.q.a(bool, this.l);
      return;
      str4 = af.a(str3, str2);
      break;
      label179: a(str2, str4, str1, str5, str3);
    }
    label194: this.q.a(bool);
  }

  protected void c(String paramString1, String paramString2)
  {
    if ((ViberApplication.isTablet(getActivity())) && ("114".equals(paramString2)))
    {
      w().setStep(5, true);
      return;
    }
    if ((ViberApplication.isTablet(getActivity())) && ("115".equals(paramString2)))
    {
      com.viber.voip.ui.dialogs.a.g().a(this).b(this);
      return;
    }
    if ("104".equals(paramString2))
    {
      com.viber.voip.ui.dialogs.a.a().a(this).b(this);
      return;
    }
    if ("121".equals(paramString2))
    {
      a(a.a);
      return;
    }
    if ("122".equals(paramString2))
    {
      a(a.b);
      return;
    }
    super.c(paramString1, paramString2);
  }

  protected void c(boolean paramBoolean)
  {
    if (ViberApplication.isTablet(getActivity()))
      this.o.a(false);
    super.c(paramBoolean);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (paramBundle != null)
    {
      CountryCode localCountryCode = (CountryCode)paramBundle.getParcelable("country_code");
      String str = paramBundle.getString("phone_number");
      this.o.b(localCountryCode, str);
      return;
    }
    this.o.c();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.o.a(paramInt1, paramInt2, paramIntent);
  }

  public boolean onBackPressed()
  {
    w().setStep(4, false);
    return super.onBackPressed();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.btn_continue)
      aa_();
    while (i != R.id.policy)
      return;
    ViberActionRunner.bl.b(getActivity());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.p = ViberApplication.getInstance().getEngine(false).getDelegatesManager().getSecureSecondaryActivationListener();
    SecureSecondaryActivationListener localSecureSecondaryActivationListener = this.p;
    SecureSecondaryActivationDelegate[] arrayOfSecureSecondaryActivationDelegate = new SecureSecondaryActivationDelegate[1];
    arrayOfSecureSecondaryActivationDelegate[0] = this.r;
    localSecureSecondaryActivationListener.registerDelegate(arrayOfSecureSecondaryActivationDelegate);
    this.q = g.a().c().b();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.registration, paramViewGroup, false);
    this.n = ((Button)localView.findViewById(R.id.btn_continue));
    this.n.setOnClickListener(this);
    l locall = ViberApplication.getInstance().getCountryCodeManager();
    this.o = new ac(getActivity(), localView, locall, this.q, this)
    {
      public void a(CountryCode paramAnonymousCountryCode, String paramAnonymousString)
      {
        if (paramAnonymousCountryCode != null)
          paramAnonymousString = ab.a(ab.this, paramAnonymousCountryCode);
        super.a(paramAnonymousCountryCode, paramAnonymousString);
      }
    };
    if (ViberApplication.isTablet(getActivity()))
      ((TextView)localView.findViewById(R.id.subtitle)).setText(R.string.registration_account_description);
    this.c = ((Spinner)localView.findViewById(R.id.server));
    this.d = ((Spinner)localView.findViewById(R.id.device_type));
    ao.a(ViberApplication.isTablet(getActivity()));
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    return localView;
  }

  public void onDestroy()
  {
    if (this.o != null)
      this.o.d();
    w().removeRegistrationCallback();
    this.p.removeDelegate(this.r);
    c("waiting_for_activation_dialog");
    super.onDestroy();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D113)) && (-3 == paramInt))
      ao.a(false);
    super.onDialogAction(paramm, paramInt);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("country_code", this.o.a());
    paramBundle.putString("phone_number", this.o.b());
    super.onSaveInstanceState(paramBundle);
  }

  protected void r()
  {
    c("waiting_for_activation_dialog");
    this.o.a(true);
  }

  protected void t()
  {
    super.t();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()) && (ViberApplication.isTablet(localFragmentActivity)))
      this.o.a(true);
  }

  static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ab
 * JD-Core Version:    0.6.2
 */