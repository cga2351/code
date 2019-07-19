package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import com.yandex.mobile.ads.nativeads.ae;
import java.util.ArrayList;
import java.util.List;

public final class kq
{
  private final List<ak.a> a = new ArrayList()
  {
  };
  private final kp b = new kp();
  private final kr c = new kr();

  public final void a(ak paramak, View paramView)
  {
    Context localContext;
    Boolean localBoolean;
    boolean bool1;
    boolean bool2;
    label56: ae localae;
    int i;
    if ((paramView instanceof ae))
    {
      localContext = paramView.getContext();
      es locales = es.a();
      et localet = locales.a(localContext);
      if (localet == null)
        break label106;
      localBoolean = localet.i();
      bool1 = locales.d();
      if (localBoolean == null)
        break label112;
      bool2 = localBoolean.booleanValue();
      if (bool2)
      {
        localae = (ae)paramView;
        ak.a locala = paramak.b();
        if (this.a.contains(locala))
          break label136;
        i = 1;
        label90: if (i == 0)
          break label142;
        this.c.a(paramak, localae);
      }
    }
    label106: label112: View localView2;
    label136: label142: 
    do
    {
      return;
      localBoolean = null;
      break;
      if ((bool1) && (fl.a(localContext)))
      {
        bool2 = true;
        break label56;
      }
      bool2 = false;
      break label56;
      i = 0;
      break label90;
      View localView1 = localae.findViewById(7846);
      if (localView1 != null)
        localae.removeView(localView1);
      localView2 = localae.findViewById(7845);
    }
    while (localView2 == null);
    localae.removeView(localView2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.kq
 * JD-Core Version:    0.6.2
 */