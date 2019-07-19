package com.viber.voip.api.scheme;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.story.o;
import com.viber.voip.api.scheme.action.c;
import com.viber.voip.api.scheme.action.m;
import com.viber.voip.messages.k;

public enum b
  implements g
{
  public static h b = new h()
  {
    public g[] a()
    {
      return b.values();
    }
  };
  private final String c;
  private final String d;

  static
  {
    b[] arrayOfb = new b[1];
    arrayOfb[0] = a;
    e = arrayOfb;
  }

  private b(String paramString1, String paramString2)
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
 * Qualified Name:     com.viber.voip.api.scheme.b
 * JD-Core Version:    0.6.2
 */