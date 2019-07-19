package com.viber.common.b;

import android.content.res.Resources;

public class b extends a
{
  private boolean c;

  public b(Resources paramResources, int paramInt1, int paramInt2)
  {
    super(paramResources.getString(paramInt1));
    this.c = Boolean.parseBoolean(paramResources.getString(paramInt2));
  }

  public b(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    super(paramResources.getString(paramInt));
    this.c = paramBoolean;
  }

  public b(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.c = paramBoolean;
  }

  public void a(boolean paramBoolean)
  {
    this.a.b(this.b, paramBoolean);
  }

  public boolean d()
  {
    return this.a.a(this.b, this.c);
  }

  public void e()
  {
    this.a.b(this.b, this.c);
  }

  public boolean f()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.b.b
 * JD-Core Version:    0.6.2
 */