package com.my.target.a;

import android.content.Context;
import com.my.target.az;
import com.my.target.b.c.a.e;
import com.my.target.co;
import com.my.target.co.b;
import com.my.target.dp;

public final class a extends com.my.target.common.a
{
  private final Context b;
  private com.my.target.b.b.c c;
  private a d;
  private boolean e = false;
  private boolean f = true;

  public a(int paramInt, Context paramContext)
  {
    super(paramInt, "fullscreen");
    this.b = paramContext;
    dp.c("InterstitialAd created. Version: 5.3.11");
  }

  private void a(com.my.target.b.c.b.c paramc, String paramString)
  {
    if (this.d != null)
      if (paramc != null)
        break label40;
    label40: for (e locale = null; locale == null; locale = paramc.c())
    {
      a locala = this.d;
      if (paramString == null)
        paramString = "no ad";
      locala.onNoAd(paramString, this);
      return;
    }
    this.c = com.my.target.b.b.c.a(this, locale, paramc);
    if (this.c != null)
    {
      this.d.onLoad(this);
      return;
    }
    this.d.onNoAd("no ad", this);
  }

  public final void a(a parama)
  {
    this.d = parama;
  }

  public final boolean a()
  {
    return this.f;
  }

  public final boolean b()
  {
    return this.e;
  }

  public final a c()
  {
    return this.d;
  }

  public final void d()
  {
    co.a(this.a).a(new co.b()
    {
      public void a(com.my.target.b.c.b.c paramAnonymousc, String paramAnonymousString)
      {
        a.a(a.this, paramAnonymousc, paramAnonymousString);
      }
    }).a(this.b);
  }

  public final void e()
  {
    if (this.c == null)
    {
      dp.c("InterstitialAd.show: No ad");
      return;
    }
    this.c.a(this.b);
  }

  public final void f()
  {
    if (this.c != null)
    {
      this.c.g();
      this.c = null;
    }
    this.d = null;
  }

  public static abstract interface a
  {
    public abstract void onClick(a parama);

    public abstract void onDismiss(a parama);

    public abstract void onDisplay(a parama);

    public abstract void onLoad(a parama);

    public abstract void onNoAd(String paramString, a parama);

    public abstract void onVideoCompleted(a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.a.a
 * JD-Core Version:    0.6.2
 */