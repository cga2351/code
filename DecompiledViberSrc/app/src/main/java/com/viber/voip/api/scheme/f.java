package com.viber.voip.api.scheme;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.string;
import com.viber.voip.api.scheme.action.c;
import com.viber.voip.pixie.ProxySettings;
import com.viber.voip.pixie.ProxySettingsHolder;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.u;
import com.viber.voip.util.da;

public enum f
  implements g
{
  public static h b = new h()
  {
    public g[] a()
    {
      return f.values();
    }
  };
  final String c;
  final String d;

  static
  {
    f[] arrayOff = new f[1];
    arrayOff[0] = a;
    e = arrayOff;
  }

  private f(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
  }

  public String a()
  {
    return this.c;
  }

  public String b()
  {
    return this.d;
  }

  public int c()
  {
    return ordinal();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.f
 * JD-Core Version:    0.6.2
 */