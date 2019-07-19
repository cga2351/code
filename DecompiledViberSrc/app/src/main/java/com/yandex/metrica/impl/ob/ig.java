package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.h;
import java.util.List;

class ig extends lm
{
  private final hp a;

  private ig(hp paramhp)
  {
    this.a = paramhp;
  }

  public hp a()
  {
    return this.a;
  }

  List<String> b()
  {
    return d().h;
  }

  public static class a
  {
    public final mw a;
    public final hp b;

    public a(mw parammw, hp paramhp)
    {
      this.a = parammw;
      this.b = paramhp;
    }
  }

  protected static class b
    implements lm.d<ig, ig.a>
  {
    private final Context a;

    protected b(Context paramContext)
    {
      this.a = paramContext;
    }

    public ig a(ig.a parama)
    {
      ig localig = new ig(parama.b, (byte)0);
      ig.a(localig, bw.b(this.a, this.a.getPackageName()));
      ig.b(localig, bw.a(this.a, this.a.getPackageName()));
      localig.h(oq.b(h.a(this.a).a(parama.a), ""));
      ig.a(localig, parama.a);
      ig.a(localig, h.a(this.a));
      ig.c(localig, this.a.getPackageName());
      ig.d(localig, parama.a.a);
      ig.e(localig, parama.a.b);
      ig.a(localig, GoogleAdvertisingIdGetter.a().c(this.a));
      return localig;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ig
 * JD-Core Version:    0.6.2
 */