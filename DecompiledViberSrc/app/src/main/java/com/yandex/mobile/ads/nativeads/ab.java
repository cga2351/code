package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.ak;
import com.yandex.mobile.ads.impl.ak.a;
import com.yandex.mobile.ads.impl.nn;
import java.util.Iterator;
import java.util.List;

final class ab extends ad
{
  private final List<? extends aw> b;

  public ab(List<? extends aw> paramList, aq paramaq)
  {
    super(paramaq);
    this.b = paramList;
  }

  protected final ak a(ak.a parama, boolean paramBoolean)
  {
    int j;
    if (ak.a.a == parama)
    {
      Iterator localIterator1 = this.b.iterator();
      if (!localIterator1.hasNext())
        break label141;
      aw localaw = (aw)localIterator1.next();
      ba localba = localaw.d();
      Iterator localIterator2 = localaw.e().b().iterator();
      while (localIterator2.hasNext())
        if (localba.a(((com.yandex.mobile.ads.impl.bd)localIterator2.next()).c(), paramBoolean).b() != ak.a.a)
        {
          j = 0;
          label102: if (j == 0)
            break label139;
        }
    }
    label139: label141: for (int i = 1; ; i = 0)
    {
      if (i == 0)
        parama = ak.a.f;
      return new ak(parama, new nn());
      j = 1;
      break label102;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.ab
 * JD-Core Version:    0.6.2
 */