package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class zabc extends zabr
{
  private WeakReference<zaaw> zahl;

  zabc(zaaw paramzaaw)
  {
    this.zahl = new WeakReference(paramzaaw);
  }

  public final void zas()
  {
    zaaw localzaaw = (zaaw)this.zahl.get();
    if (localzaaw == null)
      return;
    zaaw.zaa(localzaaw);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zabc
 * JD-Core Version:    0.6.2
 */