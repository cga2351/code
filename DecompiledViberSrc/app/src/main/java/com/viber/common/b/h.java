package com.viber.common.b;

import android.content.res.Resources;

public class h extends a
{
  private String c;

  public h(Resources paramResources, int paramInt1, int paramInt2)
  {
    super(paramResources.getString(paramInt1));
    this.c = paramResources.getString(paramInt2);
  }

  public h(Resources paramResources, int paramInt, String paramString)
  {
    super(paramResources.getString(paramInt));
    this.c = paramString;
  }

  public h(String paramString1, String paramString2)
  {
    super(paramString1);
    this.c = paramString2;
  }

  public void a(String paramString)
  {
    this.a.b(this.b, paramString);
  }

  public String d()
  {
    return this.a.a(this.b, this.c);
  }

  public void e()
  {
    this.a.b(this.b, this.c);
  }

  public String f()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.b.h
 * JD-Core Version:    0.6.2
 */