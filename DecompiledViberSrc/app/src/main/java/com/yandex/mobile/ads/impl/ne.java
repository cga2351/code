package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import java.util.List;

public final class ne
{
  private final bz a;
  private final kv b;
  private final ns c;
  private final ng d;

  public ne(Context paramContext, bz parambz, kv paramkv)
  {
    this.a = parambz;
    this.b = paramkv;
    this.c = new ns();
    this.d = new ng(paramContext);
  }

  public final void a(Context paramContext, ls paramls)
  {
    List localList = paramls.c();
    Intent localIntent = this.d.a(localList);
    if (localIntent != null)
    {
      Context localContext = ns.a(paramContext);
      if (localContext != null)
      {
        this.a.a(fd.b.w);
        localContext.startActivity(localIntent);
      }
      return;
    }
    String str = paramls.b();
    this.b.a(str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ne
 * JD-Core Version:    0.6.2
 */