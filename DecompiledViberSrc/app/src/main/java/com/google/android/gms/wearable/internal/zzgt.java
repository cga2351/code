package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;

final class zzgt extends zzgm<Channel.GetOutputStreamResult>
{
  private final zzbr zzeu;

  public zzgt(BaseImplementation.ResultHolder<Channel.GetOutputStreamResult> paramResultHolder, zzbr paramzzbr)
  {
    super(paramResultHolder);
    this.zzeu = ((zzbr)Preconditions.checkNotNull(paramzzbr));
  }

  public final void zza(zzdo paramzzdo)
  {
    ParcelFileDescriptor localParcelFileDescriptor = paramzzdo.zzdr;
    zzbl localzzbl = null;
    if (localParcelFileDescriptor != null)
    {
      localzzbl = new zzbl(new ParcelFileDescriptor.AutoCloseOutputStream(paramzzdo.zzdr));
      this.zzeu.zza(new zzbm(localzzbl));
    }
    zza(new zzbh(new Status(paramzzdo.statusCode), localzzbl));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgt
 * JD-Core Version:    0.6.2
 */