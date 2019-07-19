package com.viber.voip.api.scheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.viber.voip.ViberApplication;
import com.viber.voip.api.scheme.action.c;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.h.a;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.viberid.ViberIdTriggerStateHolder;
import com.viber.voip.user.viberid.connectaccount.ViberIdConnectActivity;

public enum k
  implements g
{
  public static final h b = new h()
  {
    public g[] a()
    {
      return k.values();
    }
  };
  private final String c;
  private final String d;

  static
  {
    k[] arrayOfk = new k[1];
    arrayOfk[0] = a;
    e = arrayOfk;
  }

  private k(String paramString1, String paramString2)
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
 * Qualified Name:     com.viber.voip.api.scheme.k
 * JD-Core Version:    0.6.2
 */