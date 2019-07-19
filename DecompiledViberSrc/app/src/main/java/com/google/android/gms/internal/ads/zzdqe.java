package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzdqe extends zzdqd<FieldDescriptorType, Object>
{
  zzdqe(int paramInt)
  {
    super(paramInt, null);
  }

  public final void zzavj()
  {
    if (!isImmutable())
    {
      for (int i = 0; i < zzazp(); i++)
      {
        Map.Entry localEntry2 = zzgz(i);
        if (((zzdnt)localEntry2.getKey()).zzaxn())
          localEntry2.setValue(Collections.unmodifiableList((List)localEntry2.getValue()));
      }
      Iterator localIterator = zzazq().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator.next();
        if (((zzdnt)localEntry1.getKey()).zzaxn())
          localEntry1.setValue(Collections.unmodifiableList((List)localEntry1.getValue()));
      }
    }
    super.zzavj();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdqe
 * JD-Core Version:    0.6.2
 */