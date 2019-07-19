package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;

public final class b extends fz
{
  final int a;
  int b;
  private final aj g;
  private aj h;
  private boolean i = true;

  b(Context paramContext, v paramv, aj paramaj)
  {
    super(paramContext, paramv);
    this.g = paramaj;
    if (k())
    {
      this.a = paramaj.b(paramContext);
      this.b = paramaj.a(paramContext);
      return;
    }
    if (paramv.d() == 0);
    for (int j = paramaj.b(paramContext); ; j = paramv.d())
    {
      this.a = j;
      this.b = paramv.e();
      return;
    }
  }

  private boolean k()
  {
    Context localContext = getContext();
    return (i()) && (this.f.d() == 0) && (this.f.e() == 0) && (this.g.b(localContext) > 0) && (this.g.a(localContext) > 0);
  }

  protected final void a()
  {
    if (this.i)
    {
      this.h = new aj(this.a, this.b, this.g.c());
      boolean bool = gw.a(getContext(), this.h, this.g);
      if ((this.e != null) && (bool))
        this.e.a(this, j());
      if (this.e != null)
      {
        if (!bool)
          break label100;
        this.e.onAdLoaded();
      }
    }
    while (true)
    {
      this.i = false;
      return;
      label100: this.e.onAdFailedToLoad(t.c);
    }
  }

  protected final void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.b = paramInt;
  }

  @SuppressLint({"AddJavascriptInterface"})
  protected final void a(Context paramContext)
  {
    addJavascriptInterface(new fz.a(this, paramContext), "AdPerformActionsJSI");
  }

  protected final String b()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1;
    StringBuilder localStringBuilder2;
    int j;
    int k;
    if (this.f.s())
    {
      str1 = dt.a(this.a);
      localStringBuilder2 = localStringBuilder1.append(str1);
      Context localContext = getContext();
      j = this.g.b(localContext);
      k = this.g.a(localContext);
      if (!k())
        break label99;
    }
    label99: for (String str2 = dt.a(j, k); ; str2 = "")
    {
      return str2 + super.b();
      str1 = "";
      break;
    }
  }

  public final aj c()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.b
 * JD-Core Version:    0.6.2
 */