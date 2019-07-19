package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

final class zzdta
  implements Iterator<E>
{
  private int pos = 0;

  zzdta(zzdsz paramzzdsz)
  {
  }

  public final boolean hasNext()
  {
    return (this.pos < this.zzhtx.zzhtv.size()) || (this.zzhtx.zzhtw.hasNext());
  }

  public final E next()
  {
    while (true)
    {
      if (this.pos < this.zzhtx.zzhtv.size())
      {
        List localList = this.zzhtx.zzhtv;
        int i = this.pos;
        this.pos = (i + 1);
        return localList.get(i);
      }
      this.zzhtx.zzhtv.add(this.zzhtx.zzhtw.next());
    }
  }

  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdta
 * JD-Core Version:    0.6.2
 */