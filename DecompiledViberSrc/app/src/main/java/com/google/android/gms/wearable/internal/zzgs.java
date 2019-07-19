package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;

final class zzgs extends zzgm<Channel.GetInputStreamResult>
{
  private final zzbr zzeu;

  public zzgs(BaseImplementation.ResultHolder<Channel.GetInputStreamResult> paramResultHolder, zzbr paramzzbr)
  {
    super(paramResultHolder);
    this.zzeu = ((zzbr)Preconditions.checkNotNull(paramzzbr));
  }

  public final void zza(zzdm paramzzdm)
  {
    ParcelFileDescriptor localParcelFileDescriptor = paramzzdm.zzdr;
    zzbj localzzbj = null;
    if (localParcelFileDescriptor != null)
    {
      localzzbj = new zzbj(new ParcelFileDescriptor.AutoCloseInputStream(paramzzdm.zzdr));
      this.zzeu.zza(new zzbk(localzzbj));
    }
    zza(new zzbg(new Status(paramzzdm.statusCode), localzzbj));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgs
 * JD-Core Version:    0.6.2
 */