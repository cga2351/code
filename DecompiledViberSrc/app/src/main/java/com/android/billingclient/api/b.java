package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;

public abstract class b
{
  public static a a(Context paramContext)
  {
    return new a(paramContext, null);
  }

  public abstract int a(Activity paramActivity, e parame);

  public abstract int a(String paramString);

  public abstract void a(d paramd);

  public abstract void a(k paramk, l paraml);

  public abstract void a(String paramString, f paramf);

  public abstract boolean a();

  public abstract h.a b(String paramString);

  public abstract void b();

  public static final class a
  {
    private final Context a;
    private int b = 0;
    private int c = 0;
    private i d;

    private a(Context paramContext)
    {
      this.a = paramContext;
    }

    public a a(i parami)
    {
      this.d = parami;
      return this;
    }

    public b a()
    {
      if (this.a == null)
        throw new IllegalArgumentException("Please provide a valid Context.");
      if (this.d == null)
        throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
      return new c(this.a, this.b, this.c, this.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.b
 * JD-Core Version:    0.6.2
 */