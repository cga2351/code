package com.viber.voip.api.scheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.viber.voip.ViberApplication;
import com.viber.voip.api.scheme.action.c;
import com.viber.voip.api.scheme.action.o;
import com.viber.voip.api.scheme.action.v;
import com.viber.voip.api.scheme.action.w;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.apps.model.AuthInfo;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.ActivationController.ActivationCode;
import com.viber.voip.registration.ActivationController.b;
import com.viber.voip.registration.changephonenumber.d;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.ViberActionRunner.au;
import com.viber.voip.util.ViberActionRunner.bg;
import com.viber.voip.util.ViberActionRunner.l;

public enum a
  implements g
{
  public static final h h = new h()
  {
    public c a(Context paramAnonymousContext, Uri paramAnonymousUri, Bundle paramAnonymousBundle)
    {
      c localc = super.a(paramAnonymousContext, paramAnonymousUri, paramAnonymousBundle);
      if (((localc == null) || (localc == c.d)) && (!ViberApplication.isActivated()))
      {
        ViberApplication.getInstance().getActivationController().resumeActivationWithDeepLink(paramAnonymousUri);
        localc = c.a;
      }
      return localc;
    }

    public g[] a()
    {
      return a.values();
    }
  };
  private final String i;
  private final String j;

  static
  {
    a[] arrayOfa = new a[7];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    arrayOfa[4] = e;
    arrayOfa[5] = f;
    arrayOfa[6] = g;
    k = arrayOfa;
  }

  private a(String paramString1, String paramString2)
  {
    this.i = paramString1;
    this.j = paramString2;
  }

  private static c b(Context paramContext, String paramString)
  {
    if (ViberApplication.isActivated())
    {
      if (ViberApplication.getInstance().getChangePhoneNumberController().a().f());
      for (Intent localIntent = ViberActionRunner.l.a(paramContext, new ActivationController.ActivationCode(paramString, ActivationController.b.d)); ; localIntent = ViberActionRunner.ab.a(paramContext))
        return new y(localIntent);
    }
    if (!TextUtils.isEmpty(i.a().getRegNumberCanonized()));
    for (int m = 1; ; m = 0)
    {
      int n = i.a().getStep();
      if ((1 != n) && (m == 0))
        break;
      if (1 != n)
        i.a().setStep(1, false);
      return new o(ViberActionRunner.au.a(new ActivationController.ActivationCode(paramString, ActivationController.b.d), paramContext));
    }
    i.a().setStep(0, true);
    return new o();
  }

  public String a()
  {
    return this.i;
  }

  public String b()
  {
    return this.j;
  }

  public int c()
  {
    return ordinal();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.a
 * JD-Core Version:    0.6.2
 */