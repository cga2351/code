package com.viber.voip.registration;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.a;
import com.viber.voip.util.cg;

public class d extends h
  implements f.a
{
  private f n;

  private void E()
  {
    this.e.removeMessages(2);
  }

  protected boolean Y_()
  {
    return true;
  }

  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 2)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      {
        if (ActivationController.ActivationCode.isEmpty(this.b))
        {
          p();
          a.m().a(this).b(this);
        }
      }
      else
        return;
      a(this.b.code, null);
      return;
    }
    v();
  }

  protected void a(String paramString)
  {
    u();
    f localf = new f(paramString, this);
    this.n = localf;
    localf.execute(new String[0]);
  }

  public void a(String paramString, com.viber.voip.registration.c.d paramd)
  {
    this.n = null;
    E();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()))
      return;
    if (paramd == null)
    {
      p();
      x();
      return;
    }
    if (paramd.f())
    {
      q();
      return;
    }
    if ("109".equals(paramd.g()))
    {
      l();
      f_(w().isRegistrationMadeViaTzintuk());
      if (this.b.source != ActivationController.b.c)
      {
        m();
        a(paramString, null);
      }
      j();
      return;
    }
    a(paramString, paramd.h());
  }

  protected String b()
  {
    ActivationController localActivationController = w();
    return cg.a(getContext(), localActivationController.getCountryCode(), localActivationController.getRegNumber(), localActivationController.getRegNumberCanonized());
  }

  protected void b(ActivationController.ActivationCode paramActivationCode)
  {
    w().setActivationCode(paramActivationCode);
  }

  protected void b(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof RegistrationActivity))
      ((RegistrationActivity)localFragmentActivity).a(paramBoolean);
  }

  protected String c()
  {
    return w().getRegNumberCanonized();
  }

  protected void d()
  {
    s();
    w().setStep(0, true);
  }

  protected boolean e()
  {
    return this.n == null;
  }

  protected void f()
  {
    if (this.n != null)
    {
      this.n.cancel(true);
      this.n = null;
    }
  }

  public void g()
  {
    super.g();
    this.e.sendEmptyMessageDelayed(2, 60000L);
  }

  protected void h()
  {
  }

  protected void i()
  {
  }

  public boolean onBackPressed()
  {
    return true;
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D105e)) || (paramm.a(DialogCode.D105)))
    {
      switch (paramInt)
      {
      default:
        return;
      case -1:
        w().setCameFromSecondaryActivation(true);
        w().setStep(5, true);
        return;
      case -2:
      }
      w().setStep(0, true);
      return;
    }
    super.onDialogAction(paramm, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.d
 * JD-Core Version:    0.6.2
 */