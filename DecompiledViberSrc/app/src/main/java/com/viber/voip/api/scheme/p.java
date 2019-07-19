package com.viber.voip.api.scheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.viber.voip.api.scheme.action.c;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.util.bz;

public enum p
  implements g
{
  public static h b = new h()
  {
    public g[] a()
    {
      return p.values();
    }
  };
  final String c;
  final String d;

  static
  {
    p[] arrayOfp = new p[1];
    arrayOfp[0] = a;
    e = arrayOfp;
  }

  private p(String paramString1, String paramString2)
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
 * Qualified Name:     com.viber.voip.api.scheme.p
 * JD-Core Version:    0.6.2
 */