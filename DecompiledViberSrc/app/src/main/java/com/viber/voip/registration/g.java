package com.viber.voip.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;

public class g extends j
  implements View.OnClickListener
{
  protected int Z_()
  {
    return 0;
  }

  protected void a()
  {
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.ok)
      ViberApplication.getInstance().getActivationController().setStep(10, true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_auth_description, paramViewGroup, false);
    localView.findViewById(R.id.ok).setOnClickListener(this);
    return localView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.g
 * JD-Core Version:    0.6.2
 */