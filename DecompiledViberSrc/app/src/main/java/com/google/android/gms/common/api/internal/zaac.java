package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import java.util.Map;

final class zaac
  implements PendingResult.StatusListener
{
  zaac(zaab paramzaab, BasePendingResult paramBasePendingResult)
  {
  }

  public final void onComplete(Status paramStatus)
  {
    zaab.zaa(this.zafm).remove(this.zafl);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaac
 * JD-Core Version:    0.6.2
 */