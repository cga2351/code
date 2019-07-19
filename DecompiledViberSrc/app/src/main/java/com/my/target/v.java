package com.my.target;

import android.content.Context;

public abstract class v<T>
{
  protected boolean a;
  protected boolean b;
  protected int c = -1;
  protected T d;
  protected String e;

  protected abstract T b(String paramString, Context paramContext);

  public final T c(String paramString, Context paramContext)
  {
    this.a = true;
    this.b = false;
    this.c = -1;
    this.d = null;
    this.e = null;
    return b(paramString, paramContext);
  }

  public boolean c()
  {
    return this.a;
  }

  public T d()
  {
    return this.d;
  }

  public String e()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.v
 * JD-Core Version:    0.6.2
 */