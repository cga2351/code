package com.viber.voip.api.scheme;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.action.c;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ap;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.ce;
import com.viber.voip.viberwallet.ViberWalletWebActivity;
import com.viber.voip.wallet.a;
import java.util.regex.Pattern;

public enum m
  implements g
{
  public static h g = new h()
  {
    public g[] a()
    {
      return m.values();
    }
  };
  final String e;
  final String f;

  static
  {
    m[] arrayOfm = new m[4];
    arrayOfm[0] = a;
    arrayOfm[1] = b;
    arrayOfm[2] = c;
    arrayOfm[3] = d;
    h = arrayOfm;
  }

  private m(String paramString1, String paramString2)
  {
    this.e = paramString1;
    this.f = paramString2;
  }

  public String a()
  {
    return this.e;
  }

  public String b()
  {
    return this.f;
  }

  public int c()
  {
    return ordinal();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.m
 * JD-Core Version:    0.6.2
 */