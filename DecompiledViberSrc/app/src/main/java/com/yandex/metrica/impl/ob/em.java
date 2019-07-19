package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;

class em
{
  fy a;
  private final v b;
  private String c;
  private el d;
  private mw e;

  public em(Context paramContext, mw parammw)
  {
    this(paramContext.getPackageName(), new fy(fj.a(paramContext).c()), new el(), parammw);
  }

  em(String paramString, fy paramfy, el paramel, mw parammw)
  {
    this.c = paramString;
    this.a = paramfy;
    this.d = paramel;
    this.e = parammw;
    this.b = new v(this.c);
  }

  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    this.d.a(localBundle, this.c, this.a.g());
    return localBundle;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.em
 * JD-Core Version:    0.6.2
 */