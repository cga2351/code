package com.viber.voip.api.scheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.ViberApplication;
import com.viber.voip.api.scheme.action.h.a;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.registration.ao;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ao;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.ViberActionRunner.c;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ce;
import java.util.regex.Pattern;

public enum c
  implements g
{
  public static h h = new h()
  {
    public g[] a()
    {
      return c.values();
    }
  };
  private final String i;
  private final String j;

  static
  {
    c[] arrayOfc = new c[7];
    arrayOfc[0] = a;
    arrayOfc[1] = b;
    arrayOfc[2] = c;
    arrayOfc[3] = d;
    arrayOfc[4] = e;
    arrayOfc[5] = f;
    arrayOfc[6] = g;
    k = arrayOfc;
  }

  private c(String paramString1, String paramString2)
  {
    this.i = paramString1;
    this.j = paramString2;
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
 * Qualified Name:     com.viber.voip.api.scheme.c
 * JD-Core Version:    0.6.2
 */