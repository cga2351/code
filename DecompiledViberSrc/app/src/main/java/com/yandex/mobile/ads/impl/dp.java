package com.yandex.mobile.ads.impl;

import android.content.Context;

public final class dp extends ds
{
  private final dq a = new dq(this, new dx());

  public dp(Context paramContext)
  {
    super(paramContext);
  }

  protected final void a()
  {
    this.a.a();
  }

  public final void c(String paramString)
  {
    this.a.b(paramString);
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    dv.a locala = this.a.a(paramInt1, paramInt2);
    super.onMeasure(locala.a, locala.b);
  }

  public final void setAspectRatio(float paramFloat)
  {
    dw localdw = new dw(paramFloat);
    this.a.a(localdw);
  }

  public final void setClickListener(jt paramjt)
  {
    this.a.a(paramjt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dp
 * JD-Core Version:    0.6.2
 */