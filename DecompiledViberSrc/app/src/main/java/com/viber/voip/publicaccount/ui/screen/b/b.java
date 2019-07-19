package com.viber.voip.publicaccount.ui.screen.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.publicaccount.wizard.a.e;

public class b extends e
  implements View.OnClickListener
{
  public static b a(Bundle paramBundle)
  {
    b localb = new b();
    localb.setArguments(b(paramBundle));
    return localb;
  }

  protected void a()
  {
    d(g());
  }

  public int b()
  {
    return R.string.create_public_account_intro_title;
  }

  public Bundle c()
  {
    return g();
  }

  public boolean e()
  {
    ViberApplication.getInstance().getEngine(false).getCdrController().handleReportPACreationStartAndLeaveProcess(this.d, System.currentTimeMillis(), 1);
    return false;
  }

  public void onClick(View paramView)
  {
    a();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.create_public_account_intro_layout, paramViewGroup, false);
    localView.findViewById(R.id.button_join_now).setOnClickListener(this);
    return localView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.b.b
 * JD-Core Version:    0.6.2
 */