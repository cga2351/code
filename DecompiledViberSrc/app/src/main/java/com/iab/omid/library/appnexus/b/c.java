package com.iab.omid.library.appnexus.b;

import android.annotation.SuppressLint;
import android.content.Context;

public class c
{

  @SuppressLint({"StaticFieldLeak"})
  private static c a = new c();
  private Context b;

  public static c a()
  {
    return a;
  }

  public void a(Context paramContext)
  {
    if (paramContext != null);
    for (Context localContext = paramContext.getApplicationContext(); ; localContext = null)
    {
      this.b = localContext;
      return;
    }
  }

  public Context b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.b.c
 * JD-Core Version:    0.6.2
 */