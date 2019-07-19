package com.viber.voip.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;

public class t extends d
  implements View.OnClickListener
{
  private boolean n;

  protected int Z_()
  {
    return R.layout.info_popup_primary;
  }

  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(R.layout.new_user, paramViewGroup, false);
  }

  protected void a()
  {
    ao.a(true);
    w().setStep(0, true);
  }

  protected void a(View paramView)
  {
    if (this.n)
    {
      ((TextView)paramView.findViewById(R.id.click_here)).setVisibility(8);
      this.i.setVisibility(8);
    }
    while (true)
    {
      c(false);
      return;
      super.a(paramView);
    }
  }

  protected void e(boolean paramBoolean)
  {
    c("waiting_for_activation_dialog");
    if (!ViberApplication.isActivated())
      w().setStep(5, true);
  }

  public void onAttach(Activity paramActivity)
  {
    ao.a(false);
    super.onAttach(paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle != null)
      this.n = localBundle.getBoolean("came_from_secondary");
    while (getArguments() == null)
      return;
    this.n = getArguments().getBoolean("came_from_secondary");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.t
 * JD-Core Version:    0.6.2
 */