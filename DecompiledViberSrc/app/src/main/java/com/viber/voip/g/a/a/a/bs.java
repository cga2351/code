package com.viber.voip.g.a.a.a;

import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.story.m.e;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.bj;
import com.viber.voip.util.cj;
import com.viber.voip.viberout.a.a;
import com.viber.voip.viberout.a.g;
import com.viber.voip.viberout.a.j;
import com.viber.voip.viberout.a.l;
import com.viber.voip.viberout.a.p;
import com.viber.voip.viberout.a.t.d;
import com.viber.voip.viberout.ui.products.ViberOutProductsPresenter;

public abstract class bs
{
  static t.d a(HardwareParameters paramHardwareParameters, af paramaf, a parama)
  {
    return new t.d(paramHardwareParameters, paramaf, parama, d.bj.l, d.bj.n, d.bj.m);
  }

  static ViberOutProductsPresenter a(p paramp, j paramj, g paramg, cj paramcj, l paraml, ICdrController paramICdrController, e parame)
  {
    return new ViberOutProductsPresenter(paramp, paramj, paramg, paramcj, paraml, paramICdrController, parame, d.bj.o, d.bj.p);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.a.bs
 * JD-Core Version:    0.6.2
 */