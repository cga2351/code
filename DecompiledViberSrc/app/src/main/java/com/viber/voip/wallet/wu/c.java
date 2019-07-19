package com.viber.voip.wallet.wu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.common.dialogs.h.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.util.cj;

public class c extends aq
  implements View.OnClickListener
{
  private a a;

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!(paramActivity instanceof a))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramActivity.getClass().getSimpleName();
      arrayOfObject[1] = a.class.getSimpleName();
      throw new ClassCastException(String.format("Activity %s must implement fragment's callback %s.", arrayOfObject));
    }
    this.a = ((a)paramActivity);
  }

  public void onClick(View paramView)
  {
    if (!cj.b(getContext()));
    int i;
    do
    {
      f.b().a(getActivity());
      do
        return;
      while (this.a == null);
      i = paramView.getId();
      if (i == R.id.item_phone_contacts)
      {
        this.a.b();
        return;
      }
      if (i == R.id.item_recent_recipients)
      {
        this.a.c();
        return;
      }
      if (i == R.id.item_new_recipient)
      {
        this.a.d();
        return;
      }
    }
    while (i != R.id.btn_view_transactions);
    this.a.e();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    View localView = paramLayoutInflater.inflate(R.layout.fragment_wallet_wu_selection, paramViewGroup, false);
    localView.findViewById(R.id.item_phone_contacts).setOnClickListener(this);
    localView.findViewById(R.id.item_recent_recipients).setOnClickListener(this);
    localView.findViewById(R.id.item_new_recipient).setOnClickListener(this);
    localView.findViewById(R.id.btn_view_transactions).setOnClickListener(this);
    return localView;
  }

  public void onDetach()
  {
    super.onDetach();
    this.a = null;
  }

  public void onResume()
  {
    super.onResume();
    a locala = ((AppCompatActivity)getActivity()).getSupportActionBar();
    if (locala != null)
    {
      locala.b(R.string.options_send_wo);
      locala.c(R.string.wu_selection_activity_subtitle);
    }
  }

  public static abstract interface a
  {
    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.wallet.wu.c
 * JD-Core Version:    0.6.2
 */