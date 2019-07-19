package com.viber.voip.news;

import com.viber.voip.ui.web.a;

class n extends a
{
  protected final ViberNewsProviderSpec a;
  protected final int b;

  n(ViberNewsProviderSpec paramViberNewsProviderSpec, int paramInt)
  {
    super("", false, "", false, -1, false);
    this.a = paramViberNewsProviderSpec;
    this.b = paramInt;
  }

  public boolean a(int paramInt)
  {
    return this.a.isUrlParameterRequired(paramInt);
  }

  public int c()
  {
    return this.a.getId();
  }

  public String d()
  {
    return this.a.getUrl();
  }

  public int e()
  {
    return this.b;
  }

  public boolean f()
  {
    return this.a.openArticleOnNewScreen();
  }

  public int g()
  {
    return this.a.getArticlesDetectionStrategy();
  }

  public long h()
  {
    return this.a.getCacheTimeMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.n
 * JD-Core Version:    0.6.2
 */