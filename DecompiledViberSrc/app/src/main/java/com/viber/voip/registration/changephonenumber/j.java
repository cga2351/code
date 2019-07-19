package com.viber.voip.registration.changephonenumber;

import android.app.Activity;
import com.viber.voip.registration.ActivationController.ActivationCode;
import com.viber.voip.registration.h;

public class j extends h
{
  protected a.a n = a.a;

  protected boolean Y_()
  {
    return false;
  }

  protected void a(String paramString)
  {
    this.n.a(paramString);
  }

  protected String b()
  {
    return this.n.f();
  }

  protected void b(ActivationController.ActivationCode paramActivationCode)
  {
  }

  protected void b(boolean paramBoolean)
  {
    this.n.a(paramBoolean);
  }

  protected String c()
  {
    return this.n.e();
  }

  protected void d()
  {
    onBackPressed();
  }

  protected boolean e()
  {
    return this.n.a();
  }

  protected void f()
  {
  }

  public void f_(boolean paramBoolean)
  {
    this.n.a(a.b.c, paramBoolean);
  }

  protected ActivationController.ActivationCode k()
  {
    return null;
  }

  protected String o()
  {
    return "Change Number";
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof a.a))
      this.n = ((a.a)paramActivity);
  }

  public boolean onBackPressed()
  {
    s();
    this.n.a(a.b.b);
    return true;
  }

  public void onDetach()
  {
    super.onDetach();
    this.n = null;
  }

  protected void u()
  {
    this.n.c();
  }

  protected void v()
  {
    this.n.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.j
 * JD-Core Version:    0.6.2
 */