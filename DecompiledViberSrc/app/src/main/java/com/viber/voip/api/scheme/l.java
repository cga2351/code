package com.viber.voip.api.scheme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.viber.jni.Engine;
import com.viber.voip.ViberApplication;
import com.viber.voip.api.scheme.action.c;
import com.viber.voip.api.scheme.action.i;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.i.c.p;
import com.viber.voip.i.f;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.ViberActionRunner.bi;
import java.util.ArrayList;
import java.util.List;

public enum l
  implements g
{
  public static h c = new h()
  {
    public g[] a()
    {
      return l.values();
    }
  };
  private final String d;
  private final String e;

  static
  {
    l[] arrayOfl = new l[2];
    arrayOfl[0] = a;
    arrayOfl[1] = b;
    f = arrayOfl;
  }

  private l(String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.e = paramString2;
  }

  private static c c(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    if (c.p.a.e())
    {
      af localaf = ViberApplication.getInstance().getEngine(false).getUserManager().getRegistrationValues();
      Intent localIntent = ViberActionRunner.bi.b(paramContext, localaf.l(), localaf.g());
      localIntent.setData(paramUri);
      localArrayList.add(new y(localIntent));
    }
    while (true)
    {
      return new i((c[])localArrayList.toArray(new c[0]));
      localArrayList.add(new y(new Intent(paramContext, ViberActionRunner.ab.a(ViberApplication.isTablet(paramContext)))));
      localArrayList.add(c.e);
    }
  }

  public String a()
  {
    return this.d;
  }

  public String b()
  {
    return this.e;
  }

  public int c()
  {
    return ordinal();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.l
 * JD-Core Version:    0.6.2
 */