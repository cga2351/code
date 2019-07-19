package com.viber.voip.api.scheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.viber.common.b.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.api.scheme.action.c;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.settings.d.bm.a;
import com.viber.voip.wallet.a;
import com.viber.voip.wallet.wu.WesternUnionSelectionActivity;

public enum o
  implements g
{
  public static h d = new h()
  {
    public g[] a()
    {
      return o.values();
    }
  };
  final String b;
  final String c;

  static
  {
    o[] arrayOfo = new o[1];
    arrayOfo[0] = a;
    e = arrayOfo;
  }

  private o(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public int c()
  {
    return ordinal();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.o
 * JD-Core Version:    0.6.2
 */