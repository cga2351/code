package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class zau
  implements zabt
{
  private zau(zas paramzas)
  {
  }

  public final void zab(int paramInt, boolean paramBoolean)
  {
    zas.zaa(this.zaep).lock();
    try
    {
      if ((zas.zac(this.zaep)) || (zas.zad(this.zaep) == null) || (!zas.zad(this.zaep).isSuccess()))
      {
        zas.zaa(this.zaep, false);
        zas.zaa(this.zaep, paramInt, paramBoolean);
        return;
      }
      zas.zaa(this.zaep, true);
      zas.zae(this.zaep).onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zas.zaa(this.zaep).unlock();
    }
  }

  public final void zab(Bundle paramBundle)
  {
    zas.zaa(this.zaep).lock();
    try
    {
      zas.zaa(this.zaep, paramBundle);
      zas.zaa(this.zaep, ConnectionResult.RESULT_SUCCESS);
      zas.zab(this.zaep);
      return;
    }
    finally
    {
      zas.zaa(this.zaep).unlock();
    }
  }

  public final void zac(ConnectionResult paramConnectionResult)
  {
    zas.zaa(this.zaep).lock();
    try
    {
      zas.zaa(this.zaep, paramConnectionResult);
      zas.zab(this.zaep);
      return;
    }
    finally
    {
      zas.zaa(this.zaep).unlock();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zau
 * JD-Core Version:    0.6.2
 */