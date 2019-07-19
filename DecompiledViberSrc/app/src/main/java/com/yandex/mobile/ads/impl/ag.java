package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.text.TextUtils;

public final class ag
{
  private final eo a;
  private final cf b;
  private final ah c;

  public ag(Context paramContext, eo parameo)
  {
    this.a = parameo;
    this.b = new cf(paramContext);
    this.c = ah.a();
  }

  public final void a(Context paramContext, a parama)
  {
    if (this.b.a())
    {
      ai localai = new ai(paramContext, this.c, parama);
      String str1 = this.a.f();
      StringBuilder localStringBuilder;
      String str4;
      if (!TextUtils.isEmpty(str1))
      {
        String str3 = ab.a(er.a(paramContext)).b(this.a.d()).c().b(paramContext).a(paramContext, this.a.g()).f(paramContext).a().b().d();
        localStringBuilder = new StringBuilder(str1);
        if (str1.endsWith("/"))
        {
          str4 = "";
          localStringBuilder.append(str4);
          localStringBuilder.append("v1/startup");
          localStringBuilder.append("?");
          localStringBuilder.append(str3);
        }
      }
      for (String str2 = localStringBuilder.toString(); ; str2 = null)
      {
        if (TextUtils.isEmpty(str2))
          break label202;
        bo localbo = new bo(str2, this.b, localai);
        af.a().a(paramContext, localbo);
        return;
        str4 = "/";
        break;
      }
      label202: localai.a(new q());
      return;
    }
    parama.a();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(ov paramov);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ag
 * JD-Core Version:    0.6.2
 */