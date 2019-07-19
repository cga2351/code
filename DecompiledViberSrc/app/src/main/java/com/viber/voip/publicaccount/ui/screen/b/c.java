package com.viber.voip.publicaccount.ui.screen.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.e.a;
import com.viber.voip.util.dj;

public class c extends com.viber.voip.publicaccount.wizard.a.e
  implements View.OnClickListener, m.c, e.a
{
  private com.viber.voip.publicaccount.ui.holders.e f;
  private View g;

  public static c a(Bundle paramBundle)
  {
    c localc = new c();
    localc.setArguments(b(paramBundle));
    return localc;
  }

  private void b(boolean paramBoolean)
  {
    this.g.setEnabled(paramBoolean);
    a(paramBoolean);
  }

  public void V_()
  {
    this.f.b(this.c);
    d(g());
  }

  public void W_()
  {
    this.a.e();
  }

  protected void a()
  {
    dj.d(getActivity());
    this.f.b(this.c);
    this.f.c(this.c);
  }

  public void a(com.viber.voip.publicaccount.ui.holders.c paramc, boolean paramBoolean)
  {
    if (paramBoolean)
      this.f.b(this.c);
    b(paramBoolean);
  }

  public int b()
  {
    return R.string.public_account_enter_details;
  }

  public Bundle c()
  {
    if (this.f != null)
    {
      this.f.b(this.c);
      if (this.f.d())
        this.c.setGroupUri(null);
    }
    return g();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.f.a(paramInt1, paramInt2, paramIntent);
  }

  public void onClick(View paramView)
  {
    if (paramView == this.g)
      a();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.create_public_account_second_step_layout, paramViewGroup, false);
    this.g = localView.findViewById(R.id.btn_continue);
    this.g.setOnClickListener(this);
    this.f = new com.viber.voip.publicaccount.ui.holders.e(this, this);
    this.f.a(localView);
    if (paramBundle == null)
      this.f.a(this.c);
    while (true)
    {
      this.f.a(this.c);
      setHasOptionsMenu(true);
      return localView;
      this.f.b(paramBundle);
      this.g.setEnabled(paramBundle.getBoolean("continue_enabled"));
    }
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (this.f != null)
      this.f.onDialogAction(paramm, paramInt);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.f != null)
      this.f.a(paramBundle);
    if (this.g != null)
      paramBundle.putBoolean("continue_enabled", this.g.isEnabled());
  }

  public void onStart()
  {
    super.onStart();
    if (this.f != null)
      this.f.b();
  }

  public void onStop()
  {
    if (this.f != null)
      this.f.c();
    super.onStop();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.b.c
 * JD-Core Version:    0.6.2
 */