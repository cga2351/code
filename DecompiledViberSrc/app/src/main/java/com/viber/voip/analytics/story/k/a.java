package com.viber.voip.analytics.story.k;

import com.viber.voip.model.e;

public abstract class a
{
  protected final String a;
  protected final String b;

  public a(String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.b = paramString1;
  }

  public String a()
  {
    return this.b + "_" + this.a;
  }

  public abstract void b();

  public void c()
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = a();
    e.a("analytics", arrayOfString);
  }

  public abstract boolean d();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.k.a
 * JD-Core Version:    0.6.2
 */