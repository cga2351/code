package com.viber.voip.contacts.c;

import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.m;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;

public class a
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a(b paramb)
  {
    try
    {
      a(UserManager.from(ViberApplication.getApplication()).getRegistrationValues().h(), paramb);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void a(m paramm, b paramb)
  {
    if ((!TextUtils.isEmpty(paramm.getViberName())) || (!TextUtils.isEmpty(paramm.e())))
      if (paramb != null)
        paramb.a(a.b);
    while (paramb == null)
      return;
    paramb.a(a.a);
  }

  public static void a(String paramString, b paramb)
  {
    ViberApplication.getInstance().getMessagesManager().e().b(paramString, new ci.a()
    {
      public void onGetUserDetail(m[] paramAnonymousArrayOfm)
      {
        m localm = paramAnonymousArrayOfm[0];
        if (localm != null)
          a.a(localm, this.a);
      }

      public void onGetUserError()
      {
        if (this.a != null)
          this.a.a(a.a.b);
      }
    }
    , false);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }

  public static abstract interface b
  {
    public abstract void a(a.a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.a
 * JD-Core Version:    0.6.2
 */