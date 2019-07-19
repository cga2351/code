package com.viber.voip.registration;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.z;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;

public class am extends j
  implements View.OnClickListener
{
  private boolean d()
  {
    return getActivity() instanceof RegistrationActivity;
  }

  protected int Z_()
  {
    return 0;
  }

  protected void a()
  {
  }

  protected void c()
  {
    boolean bool = d();
    if (bool);
    for (int i = 15; ; i = 8)
    {
      if (bool)
        ad.a(R.string.generic_please_wait_dialog_text).b(false).a(getActivity());
      ViberApplication.getInstance().getActivationController().setStep(i, bool);
      if ((getActivity() != null) && (!bool))
        getActivity().finish();
      return;
    }
  }

  public boolean onBackPressed()
  {
    c();
    return true;
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == R.id.continueBtn) || (i == R.id.closeBtn))
      c();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (d())
    {
      View localView2 = paramLayoutInflater.inflate(R.layout.fragment_success_auth, paramViewGroup, false);
      localView2.findViewById(R.id.continueBtn).setOnClickListener(this);
      return localView2;
    }
    View localView1 = paramLayoutInflater.inflate(R.layout.fragment_success_auth_dialog, paramViewGroup, false);
    localView1.findViewById(R.id.closeBtn).setOnClickListener(this);
    return localView1;
  }

  public void onStop()
  {
    super.onStop();
    z.a(this, DialogCode.D_PROGRESS);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.am
 * JD-Core Version:    0.6.2
 */