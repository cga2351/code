package com.viber.voip.notif.f;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;

public class f
  implements e
{
  private final SparseArrayCompat<d> a = new SparseArrayCompat();

  public f(Context paramContext, dagger.a<com.viber.voip.messages.d.b> parama, com.viber.voip.b.d paramd)
  {
    a(new a());
    a(new c(paramContext));
    a(new h(paramContext));
    a(new b(paramContext, parama, paramd));
  }

  private void a(d paramd)
  {
    this.a.put(paramd.a(), paramd);
  }

  public <T extends d> T a(int paramInt)
  {
    d locald = (d)this.a.get(paramInt);
    if (locald == null)
      throw new IllegalArgumentException("Icon provider with type = " + paramInt + " is not registered");
    return locald;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.f.f
 * JD-Core Version:    0.6.2
 */