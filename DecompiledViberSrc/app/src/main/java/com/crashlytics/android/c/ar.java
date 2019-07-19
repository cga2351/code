package com.crashlytics.android.c;

import android.content.Context;
import c.a.a.a.a.b.i;

class ar
  implements ax
{
  private final Context a;
  private final ax b;
  private boolean c = false;
  private String d;

  public ar(Context paramContext, ax paramax)
  {
    this.a = paramContext;
    this.b = paramax;
  }

  public String a()
  {
    if (!this.c)
    {
      this.d = i.n(this.a);
      this.c = true;
    }
    if (this.d != null)
      return this.d;
    if (this.b != null)
      return this.b.a();
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ar
 * JD-Core Version:    0.6.2
 */