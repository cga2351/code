package com.adsnative.c;

import android.content.Context;
import android.net.Uri;

public enum l
{
  private final boolean f;

  static
  {
    l[] arrayOfl = new l[5];
    arrayOfl[0] = a;
    arrayOfl[1] = b;
    arrayOfl[2] = c;
    arrayOfl[3] = d;
    arrayOfl[4] = e;
  }

  private l(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  protected abstract void a(Context paramContext, Uri paramUri, m paramm)
    throws f;

  public void a(m paramm, Context paramContext, Uri paramUri, boolean paramBoolean)
    throws f
  {
    i.b("Ad event URL: " + paramUri);
    if ((this.f) && (!paramBoolean))
      throw new f("Attempted to handle action without user interaction.");
    a(paramContext, paramUri, paramm);
  }

  public abstract boolean a(Uri paramUri);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.l
 * JD-Core Version:    0.6.2
 */