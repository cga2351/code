package com.viber.voip.gdpr.ui.iabconsent;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class f
  implements e
{
  private final FragmentActivity a;

  public f(FragmentActivity paramFragmentActivity)
  {
    this.a = paramFragmentActivity;
  }

  public void a()
  {
    if (!this.a.isFinishing())
      this.a.finish();
  }

  public void b()
  {
    this.a.getSupportFragmentManager().beginTransaction().replace(16908290, new g()).commit();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.iabconsent.f
 * JD-Core Version:    0.6.2
 */