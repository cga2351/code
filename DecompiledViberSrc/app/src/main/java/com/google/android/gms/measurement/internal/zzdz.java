package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzdz
  implements Runnable
{
  zzdz(zzdy paramzzdy, boolean paramBoolean, zzdx paramzzdx1, zzdx paramzzdx2)
  {
  }

  public final void run()
  {
    int i;
    if (this.zzasc.zzgv().zzbk(this.zzasc.zzgk().zzal()))
      if ((this.zzarz) && (this.zzasc.zzart != null))
      {
        i = 1;
        if (i != 0)
          zzdy.zza(this.zzasc, this.zzasc.zzart, true);
      }
    while (true)
    {
      int j;
      if ((this.zzasa != null) && (this.zzasa.zzarr == this.zzasb.zzarr) && (zzfx.zzv(this.zzasa.zzarq, this.zzasb.zzarq)))
      {
        boolean bool = zzfx.zzv(this.zzasa.zzuw, this.zzasb.zzuw);
        j = 0;
        if (bool);
      }
      else
      {
        j = 1;
      }
      if (j != 0)
      {
        Bundle localBundle = new Bundle();
        zzdy.zza(this.zzasb, localBundle, true);
        if (this.zzasa != null)
        {
          if (this.zzasa.zzuw != null)
            localBundle.putString("_pn", this.zzasa.zzuw);
          localBundle.putString("_pc", this.zzasa.zzarq);
          localBundle.putLong("_pi", this.zzasa.zzarr);
        }
        if ((this.zzasc.zzgv().zzbk(this.zzasc.zzgk().zzal())) && (i != 0))
        {
          long l = this.zzasc.zzgo().zzlp();
          if (l > 0L)
            this.zzasc.zzgr().zza(localBundle, l);
        }
        this.zzasc.zzgj().zza("auto", "_vs", localBundle);
      }
      this.zzasc.zzart = this.zzasb;
      this.zzasc.zzgl().zza(this.zzasb);
      return;
      i = 0;
      break;
      if ((this.zzarz) && (this.zzasc.zzart != null))
        zzdy.zza(this.zzasc, this.zzasc.zzart, true);
      i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzdz
 * JD-Core Version:    0.6.2
 */