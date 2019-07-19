package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import java.lang.ref.WeakReference;

final class zaar extends zac
{
  private final WeakReference<zaak> zagj;

  zaar(zaak paramzaak)
  {
    this.zagj = new WeakReference(paramzaak);
  }

  public final void zab(zaj paramzaj)
  {
    zaak localzaak = (zaak)this.zagj.get();
    if (localzaak == null)
      return;
    zaak.zad(localzaak).zaa(new zaas(this, localzaak, localzaak, paramzaj));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaar
 * JD-Core Version:    0.6.2
 */