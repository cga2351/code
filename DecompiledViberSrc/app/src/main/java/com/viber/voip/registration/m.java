package com.viber.voip.registration;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.g.a;
import com.viber.voip.analytics.story.o;
import com.viber.voip.i.c.a;
import com.viber.voip.i.f;
import com.viber.voip.registration.c.l;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.j;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.l;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class m extends aq
  implements View.OnClickListener, m.c, ac.b, n.a
{
  private static final Logger a = ViberEnv.getLogger();
  private ac b;
  private String c;
  private n d;
  private ActivationController e;
  private PhoneController f;
  private a g;

  private void b(String paramString)
  {
    ad.h().a(getActivity()).a(paramString).a(getActivity());
  }

  private boolean c()
  {
    CountryCode localCountryCode = this.b.a();
    String str1 = this.b.b();
    v localv = new v();
    if ((localCountryCode == null) || (da.a(str1)) || (!localv.a(localCountryCode.getIddCode(), str1)))
      return false;
    while (true)
    {
      try
      {
        int i = Integer.parseInt(localCountryCode.getIddCode());
        str2 = this.f.canonizePhoneNumberForCountryCode(i, str1);
        if (!da.a(str2))
          return str2.equals(this.c);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return false;
      }
      String str2 = str1;
    }
  }

  private void d()
  {
    if (getActivity() != null)
      z.a(getActivity().getSupportFragmentManager(), DialogCode.D_PROGRESS);
  }

  private void e()
  {
    this.e.deActivateAndExit(getActivity(), true);
  }

  public void a(Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt);
  }

  public void a(l paraml)
  {
    if (paraml == null)
    {
      d();
      ad.h().a(getActivity()).a(getActivity());
      return;
    }
    if ((paraml.f()) || ("107".equals(paraml.g())))
    {
      e();
      return;
    }
    d();
    b(paraml.h());
  }

  public void a(String paramString)
  {
    d();
    if (paramString.equals("CONNECTION_PROBLEM"))
      ad.a().d();
  }

  public void a(boolean paramBoolean)
  {
  }

  public void aa_()
  {
  }

  public void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      ad.a(R.string.dialog_deactivation_progress).b(false).a(localFragmentActivity);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.a(paramInt1, paramInt2, paramIntent);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.deactivate_btn)
      if (c())
        j.a().a(this).b(this);
    while (i != R.id.change_phone_number_btn)
    {
      return;
      t.m().a(getContext());
      return;
    }
    this.g.a("Change phone number");
    startActivity(ViberActionRunner.l.a(getContext(), "Deactivate Account"));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Application localApplication = ViberApplication.getApplication();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    Engine localEngine = localViberApplication.getEngine(false);
    this.c = localViberApplication.getUserManager().getRegistrationValues().g();
    this.d = new n(localEngine.getDelegatesManager().getSecureTokenListener(), localEngine.getPhoneController(), localApplication, this);
    this.e = localViberApplication.getActivationController();
    this.f = localEngine.getPhoneController();
    this.g = g.a().c().c();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(R.layout.fragment_deactivate, paramViewGroup, false);
    TextView localTextView1 = (TextView)localView1.findViewById(R.id.text_description);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getString(R.string.gdpr_deactivate_account_desciption1));
    localSpannableStringBuilder.append("\n\n");
    localSpannableStringBuilder.append(getString(R.string.gdpr_deactivate_account_desciption2));
    localSpannableStringBuilder.append("\n\n");
    localSpannableStringBuilder.append(getString(R.string.gdpr_deactivate_account_desciption3));
    localSpannableStringBuilder.append("\n\n");
    localSpannableStringBuilder.append(Html.fromHtml(getString(R.string.gdpr_deactivate_account_desciption4)));
    localTextView1.setText(localSpannableStringBuilder);
    localTextView1.setMovementMethod(LinkMovementMethod.getInstance());
    this.b = new ac(getContext(), localView1, ViberApplication.getInstance().getCountryCodeManager(), this);
    this.b.c();
    ((TextView)localView1.findViewById(R.id.deactivate_btn)).setOnClickListener(this);
    TextView localTextView2 = (TextView)localView1.findViewById(R.id.need_help_text);
    localTextView2.setText(Html.fromHtml(getString(R.string.deactivate_account_contact_support)));
    localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
    View localView2 = localView1.findViewById(R.id.change_phone_number_btn);
    if (c.a.a.e())
    {
      localView2.setOnClickListener(this);
      return localView1;
    }
    dj.b(localView2, false);
    return localView1;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.d.b();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D446))
    {
      if (-1 != paramInt)
        break label35;
      this.g.a("Deactivate account");
      this.d.a();
    }
    label35: 
    while (-2 != paramInt)
      return;
    this.g.a("Deactivate account canceled");
  }

  public void onPause()
  {
    super.onPause();
    this.d.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.m
 * JD-Core Version:    0.6.2
 */