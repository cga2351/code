package com.viber.voip.g.a.a.a;

import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.story.m.e;
import com.viber.voip.util.cj;
import com.viber.voip.viberout.a.g;
import com.viber.voip.viberout.a.j;
import com.viber.voip.viberout.a.l;
import com.viber.voip.viberout.a.p;
import com.viber.voip.viberout.ui.products.ViberOutProductsPresenter;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bw
  implements d<ViberOutProductsPresenter>
{
  private final Provider<p> a;
  private final Provider<j> b;
  private final Provider<g> c;
  private final Provider<cj> d;
  private final Provider<l> e;
  private final Provider<ICdrController> f;
  private final Provider<e> g;

  public static ViberOutProductsPresenter a(p paramp, j paramj, g paramg, cj paramcj, l paraml, ICdrController paramICdrController, e parame)
  {
    return (ViberOutProductsPresenter)h.a(bs.a(paramp, paramj, paramg, paramcj, paraml, paramICdrController, parame), "Cannot return null from a non-@Nullable @Provides method");
  }

  public ViberOutProductsPresenter a()
  {
    return (ViberOutProductsPresenter)h.a(bs.a((p)this.a.get(), (j)this.b.get(), (g)this.c.get(), (cj)this.d.get(), (l)this.e.get(), (ICdrController)this.f.get(), (e)this.g.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.a.bw
 * JD-Core Version:    0.6.2
 */