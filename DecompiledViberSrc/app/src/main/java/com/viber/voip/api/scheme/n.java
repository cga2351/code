package com.viber.voip.api.scheme;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.viber.voip.R.string;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.api.scheme.action.c;
import com.viber.voip.api.scheme.action.p;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.links.SimpleOpenUrlSpec;
import java.util.Locale;

public enum n
  implements g
{
  public static final h y = new h()
  {
    public g[] a()
    {
      return n.values();
    }
  };
  final String A;
  final boolean B;
  final String z;

  static
  {
    n[] arrayOfn = new n[24];
    arrayOfn[0] = a;
    arrayOfn[1] = b;
    arrayOfn[2] = c;
    arrayOfn[3] = d;
    arrayOfn[4] = e;
    arrayOfn[5] = f;
    arrayOfn[6] = g;
    arrayOfn[7] = h;
    arrayOfn[8] = i;
    arrayOfn[9] = j;
    arrayOfn[10] = k;
    arrayOfn[11] = l;
    arrayOfn[12] = m;
    arrayOfn[13] = n;
    arrayOfn[14] = o;
    arrayOfn[15] = p;
    arrayOfn[16] = q;
    arrayOfn[17] = r;
    arrayOfn[18] = s;
    arrayOfn[19] = t;
    arrayOfn[20] = u;
    arrayOfn[21] = v;
    arrayOfn[22] = w;
    arrayOfn[23] = x;
  }

  private n(String paramString)
  {
    this(paramString, null);
  }

  private n(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, true);
  }

  private n(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.z = paramString1;
    this.A = paramString2;
    this.B = paramBoolean;
  }

  public c a(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    try
    {
      p localp = new p(new SimpleOpenUrlSpec(d(), this.B, false));
      return localp;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return c.a;
  }

  public String a()
  {
    return "weblinks";
  }

  public String b()
  {
    return this.z;
  }

  public int c()
  {
    return ordinal();
  }

  public String d()
  {
    return this.A;
  }

  private static class a
  {
    static final String a = ap.c().f() + "/communities/";
    static final String b = ap.c().f() + "/viber-public-content-policy/";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.n
 * JD-Core Version:    0.6.2
 */