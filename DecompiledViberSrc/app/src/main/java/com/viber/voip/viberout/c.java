package com.viber.voip.viberout;

import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.viberout.ViberOutBalanceDelegate;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.bj;

public class c extends PhoneControllerDelegateAdapter
  implements ViberOutBalanceDelegate
{
  private static final Logger a = ViberEnv.getLogger();

  public static c a()
  {
    return a.a();
  }

  public void onEnableVOReferrallProgram(boolean paramBoolean)
  {
    d.bj.q.a(paramBoolean);
  }

  public boolean onViberOutBalanceChange(long paramLong)
  {
    a.a().a(paramLong);
    return true;
  }

  private static class a
  {
    private static final c a = new c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.c
 * JD-Core Version:    0.6.2
 */