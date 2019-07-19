package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzwp extends zzwo<FieldDescriptorType, Object>
{
  zzwp(int paramInt)
  {
    super(paramInt, null);
  }

  public final void zzsw()
  {
    if (!isImmutable())
    {
      for (int i = 0; i < zzyc(); i++)
      {
        Map.Entry localEntry2 = zzbx(i);
        if (((zzuh)localEntry2.getKey()).zzwb())
          localEntry2.setValue(Collections.unmodifiableList((List)localEntry2.getValue()));
      }
      Iterator localIterator = zzyd().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator.next();
        if (((zzuh)localEntry1.getKey()).zzwb())
          localEntry1.setValue(Collections.unmodifiableList((List)localEntry1.getValue()));
      }
    }
    super.zzsw();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwp
 * JD-Core Version:    0.6.2
 */