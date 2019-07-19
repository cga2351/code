package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcqp extends zzawc
{
  private zzbjn zzgfq;

  public zzcqp(zzbjn paramzzbjn)
  {
    this.zzgfq = paramzzbjn;
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzawd paramzzawd, zzavz paramzzavz)
  {
    Context localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    String str1 = paramzzawd.zzchl;
    String str2 = paramzzawd.zzbsv;
    zzyb localzzyb = paramzzawd.zzdsw;
    zzcqo localzzcqo = this.zzgfq.zzacn().zze(new zzbqx.zza().zzbt(localContext).zza(new zzcxw().zzft(str1).zzg(new zzxy().zzot()).zzd(localzzyb).zzamq()).zzagh()).zza(new zzcqs(new zzcqs.zza().zzfs(str2), null));
    new zzbtu.zza().zzagt();
    zzbas.zza(localzzcqo.zzaem().zzaen(), new zzcqq(this, paramzzavz), this.zzgfq.zzace());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqp
 * JD-Core Version:    0.6.2
 */