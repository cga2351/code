package com.viber.voip.registration;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.util.dj;

public class AuthSecondaryActivity extends ViberFragmentActivity
{
  protected View a;

  void a()
  {
    switch (ViberApplication.getInstance().getActivationController().getStep())
    {
    default:
      this.a.setBackgroundResource(R.drawable.round_grey_bg);
      d();
      a(true);
      return;
    case 16:
      this.a.setBackgroundResource(R.color.negative);
      dj.a(this, (int)getResources().getDimension(R.dimen.auth_tablet_description_dialog_width), (int)getResources().getDimension(R.dimen.auth_tablet_description_dialog_height), false, false);
      b();
      return;
    case 10:
    }
    this.a.setBackgroundResource(R.drawable.round_grey_bg);
    c();
    a(false);
  }

  void a(boolean paramBoolean)
  {
    dj.a(this, (int)getResources().getDimension(R.dimen.auth_tablet_dialog_width), (int)getResources().getDimension(R.dimen.auth_tablet_dialog_height), false, paramBoolean);
  }

  void b()
  {
    g localg = new g();
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(R.id.fragment_container, localg);
    localFragmentTransaction.commit();
  }

  void c()
  {
    al localal = new al();
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (localFragmentManager.findFragmentByTag("secure") == null)
    {
      FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
      localFragmentTransaction.replace(R.id.fragment_container, localal, "secure");
      localFragmentTransaction.commit();
    }
  }

  void d()
  {
    am localam = new am();
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(R.id.fragment_container, localam);
    localFragmentTransaction.commit();
  }

  boolean e()
  {
    ActivationController localActivationController = ViberApplication.getInstance().getActivationController();
    boolean bool1 = localActivationController.isSecureActivation();
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = localActivationController.isActivationCompleted();
      bool2 = false;
      if (!bool3)
      {
        localActivationController.setStep(8, false);
        bool2 = true;
      }
    }
    return bool2;
  }

  public void finish()
  {
    super.finish();
    e();
    overridePendingTransition(0, 0);
  }

  public void onBackPressed()
  {
    if (e())
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    setContentView(R.layout.auth_secondary_activity);
    this.a = findViewById(R.id.fragment_container);
    a();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.AuthSecondaryActivity
 * JD-Core Version:    0.6.2
 */