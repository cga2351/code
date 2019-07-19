package com.viber.voip.publicaccount.ui.screen.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.g;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.c;
import com.viber.voip.publicaccount.ui.holders.d;
import com.viber.voip.publicaccount.ui.holders.g;
import com.viber.voip.publicaccount.ui.holders.name.b;
import com.viber.voip.publicaccount.wizard.a.e;
import com.viber.voip.util.dj;

public class a extends e
  implements View.OnClickListener, m.g, d
{
  private b f;
  private View g;

  public static a a(Bundle paramBundle)
  {
    a locala = new a();
    locala.setArguments(b(paramBundle));
    return locala;
  }

  private void b(boolean paramBoolean)
  {
    this.g.setEnabled(paramBoolean);
  }

  public void V_()
  {
  }

  protected void a()
  {
    dj.d(getActivity());
    this.f.b(this.c);
    d(g());
  }

  public void a(c paramc, boolean paramBoolean)
  {
    if (paramBoolean)
      this.f.b(this.c);
    this.g.setEnabled(paramBoolean);
    b(paramBoolean);
  }

  public int b()
  {
    return R.string.create_public_account_step_title;
  }

  public Bundle c()
  {
    this.f.b(this.c);
    return g();
  }

  public boolean e()
  {
    if (this.c != null)
    {
      if (this.f != null)
        this.f.b(this.c);
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportPACreationStartAndLeaveProcess(this.d, System.currentTimeMillis(), 2, false, this.c.getName(), this.c.getCategoryId(), this.c.getSubCategoryId(), this.c.getTagLines(), this.c.getCountryCode(), this.c.getLocation(), this.c.getWebsite(), this.c.getEmail(), this.c.getGroupUri(), this.c.isAgeRestricted(), 0);
    }
    return super.e();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.g)
      a();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.create_public_account_first_step_layout, paramViewGroup, false);
    this.g = localView.findViewById(R.id.btn_continue);
    this.g.setOnClickListener(this);
    com.viber.voip.publicaccount.ui.holders.name.a locala = new com.viber.voip.publicaccount.ui.holders.name.a(this);
    this.f = new b(getContext(), this, locala, false);
    this.f.a(localView.findViewById(R.id.main_controls));
    if (paramBundle == null)
      this.f.a(this.c);
    while (true)
    {
      new g(localView, paramLayoutInflater);
      return localView;
      this.f.b(paramBundle);
      b(paramBundle.getBoolean("continue_enabled"));
    }
  }

  public void onDialogListAction(m paramm, int paramInt)
  {
    if (this.f != null)
    {
      this.f.onDialogListAction(paramm, paramInt);
      return;
    }
    paramm.dismiss();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.f != null)
      this.f.a(paramBundle);
    if (this.g != null)
      paramBundle.putBoolean("continue_enabled", this.g.isEnabled());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.b.a
 * JD-Core Version:    0.6.2
 */