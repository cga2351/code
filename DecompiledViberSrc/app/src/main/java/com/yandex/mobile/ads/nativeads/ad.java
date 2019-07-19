package com.yandex.mobile.ads.nativeads;

import android.util.Pair;
import android.view.View;
import com.yandex.mobile.ads.impl.ak;
import com.yandex.mobile.ads.impl.ak.a;
import com.yandex.mobile.ads.impl.bx;
import com.yandex.mobile.ads.impl.dh;

class ad
  implements ba
{
  final aq a;
  private af b;

  ad(aq paramaq)
  {
    this.a = paramaq;
  }

  public final ak a(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    ak.a locala1;
    if (paramBoolean)
      locala1 = ak.a.c;
    while (true)
    {
      Pair localPair = new Pair(locala1, localObject);
      ak localak = a((ak.a)localPair.first, paramBoolean);
      localak.a((String)localPair.second);
      return localak;
      if (a())
      {
        locala1 = ak.a.l;
        localObject = null;
      }
      else
      {
        int i;
        if (this.b != null)
        {
          View localView = this.b.b();
          if (localView != null)
          {
            int k = localView.getHeight();
            if ((localView.getWidth() < 10) || (k < 10))
              i = 1;
          }
        }
        while (true)
        {
          if (i == 0)
            break label146;
          locala1 = ak.a.m;
          localObject = null;
          break;
          i = 0;
          continue;
          i = 1;
        }
        label146: int j;
        if (this.b != null)
        {
          boolean bool = dh.a(this.b.b(), paramInt);
          j = 0;
          if (!bool);
        }
        while (true)
        {
          if (j == 0)
            break label195;
          locala1 = ak.a.i;
          localObject = null;
          break;
          j = 1;
        }
        label195: aq.a locala = this.a.a();
        locala1 = locala.b();
        localObject = locala.a();
      }
    }
  }

  protected ak a(ak.a parama, boolean paramBoolean)
  {
    return new ak(parama, new bx());
  }

  public final void a(af paramaf)
  {
    this.b = paramaf;
    this.a.a(paramaf);
  }

  public final boolean a()
  {
    if (this.b != null)
    {
      View localView = this.b.b();
      if (localView != null)
        return dh.d(localView);
    }
    return true;
  }

  public final boolean b()
  {
    return this.a.e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.ad
 * JD-Core Version:    0.6.2
 */