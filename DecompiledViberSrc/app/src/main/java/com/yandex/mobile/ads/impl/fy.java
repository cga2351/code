package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.mobile.ads.b;

public abstract class fy extends y<String>
  implements dn
{
  private gf h;

  fy(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }

  protected final bm<String> a(String paramString1, String paramString2)
  {
    return new gq(this.b, this.f, paramString1, paramString2, this);
  }

  protected abstract gf a(String paramString, v<String> paramv, aj paramaj);

  protected abstract boolean a(aj paramaj);

  protected final boolean a(aj paramaj1, aj paramaj2)
  {
    return (a(paramaj1)) && (gw.a(this.b, paramaj1, paramaj2));
  }

  public final void b(cv paramcv)
  {
    a(this.f.c(), paramcv);
  }

  public void b(v<String> paramv)
  {
    aj localaj = this.f.b();
    if (localaj == null)
    {
      onAdFailedToLoad(t.d);
      return;
    }
    if (!a(paramv.c(), localaj))
    {
      onAdFailedToLoad(t.c);
      return;
    }
    String str = (String)paramv.r();
    if (!TextUtils.isEmpty(str))
    {
      this.h = a(str, paramv, localaj);
      this.h.a(str);
      return;
    }
    onAdFailedToLoad(t.e);
  }

  public final void b(boolean paramBoolean)
  {
  }

  public void e()
  {
    super.e();
    if (this.h != null)
      this.h.b();
    this.h = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fy
 * JD-Core Version:    0.6.2
 */