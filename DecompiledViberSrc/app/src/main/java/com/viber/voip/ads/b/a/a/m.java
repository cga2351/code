package com.viber.voip.ads.b.a.a;

import android.os.Handler;
import android.util.SparseArray;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.f;
import com.viber.voip.util.ap;

public class m
{
  private final SparseArray<l> a = new SparseArray();
  private final ap b;

  public m(ap paramap)
  {
    this.b = paramap;
  }

  private l b(int paramInt)
  {
    Handler localHandler = av.a(av.e.a);
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return new y(this.b, localHandler);
    case 2:
      return new n(localHandler);
    case 5:
      return new a(d.f.d, localHandler);
    case 2147483647:
    }
    return new ab(localHandler);
  }

  public l a(int paramInt)
  {
    l locall = (l)this.a.get(paramInt);
    if (locall == null)
      locall = b(paramInt);
    return locall;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.a.m
 * JD-Core Version:    0.6.2
 */