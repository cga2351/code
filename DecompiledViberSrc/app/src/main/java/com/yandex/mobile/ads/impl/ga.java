package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.yandex.mobile.ads.b;
import java.util.List;
import java.util.Map;

public abstract class ga extends fy
{
  private final ao h = new ao(this.b, paramb, this.k, cw.a(this));
  private ap i;
  private final cm j = new cm(this.b, r());
  private final ao.c k = new ao.c()
  {
    public final ak a(int paramAnonymousInt)
    {
      ak.a locala;
      if (ga.a(ga.this))
        locala = ak.a.c;
      while (true)
      {
        return new ak(locala, new bx());
        if (!ga.this.j())
          locala = ak.a.b;
        else if (ga.b(ga.this))
          locala = ak.a.l;
        else if ((!ga.this.a(paramAnonymousInt)) || (!ga.this.c()))
          locala = ak.a.i;
        else
          locala = ak.a.a;
      }
    }
  };

  protected ga(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }

  private boolean a()
  {
    return !b();
  }

  protected final boolean A()
  {
    return (a()) || (v());
  }

  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      super.a(paramInt, paramBundle);
      return;
    case 9:
    }
    this.j.d();
    this.h.c();
  }

  public void a(Intent paramIntent)
  {
    new StringBuilder("onPhoneStateChanged(), intent.getAction = ").append(paramIntent.getAction()).append(", isAdVisible = ").append(b());
    this.h.a(paramIntent, b());
  }

  public void a(WebView paramWebView, Map<String, String> paramMap)
  {
    new StringBuilder("onAdDisplayed(), clazz = ").append(this);
    if (this.g != null)
    {
      List localList = cw.a(this.g, paramMap);
      this.h.a(this.g.b(), localList);
    }
    cm localcm = this.j;
    if (this.g != null);
    for (cn localcn = this.g.h(); ; localcn = null)
    {
      localcm.a(localcn);
      z();
      return;
    }
  }

  public void a(v<String> paramv)
  {
    try
    {
      super.a(paramv);
      this.i = new ap(this.b, paramv.g());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(String paramString)
  {
    b(paramString);
  }

  protected abstract boolean a(int paramInt);

  public void b(int paramInt)
  {
    if (paramInt == 0)
      this.h.a();
    while (true)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = getClass().toString();
      arrayOfObject[1] = Integer.valueOf(paramInt);
      return;
      this.h.b();
    }
  }

  public final void b(v<String> paramv)
  {
    if (a(paramv.c()))
    {
      super.b(paramv);
      return;
    }
    onAdFailedToLoad(t.e);
  }

  protected abstract boolean b();

  protected abstract boolean c();

  public void e()
  {
    new StringBuilder("cleanOut(), clazz = ").append(this);
    super.e();
    this.h.b();
  }

  public void f()
  {
    super.f();
    this.j.e();
  }

  public void onAdClosed()
  {
    super.onAdClosed();
    new StringBuilder("onAdClosed(), clazz = ").append(getClass());
    this.j.b();
  }

  public void onAdLeftApplication()
  {
    try
    {
      super.onAdLeftApplication();
      this.j.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onAdOpened()
  {
    new StringBuilder("onAdOpened(), clazz = ").append(this);
    super.onAdOpened();
    this.j.a();
  }

  protected final void z()
  {
    try
    {
      if (b())
      {
        new StringBuilder("trackAdOnDisplayed(), clazz = ").append(this);
        this.h.a();
        if (this.i != null)
          this.i.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ga
 * JD-Core Version:    0.6.2
 */