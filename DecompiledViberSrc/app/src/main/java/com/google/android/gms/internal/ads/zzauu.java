package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;

final class zzauu
  implements Runnable
{
  zzauu(zzaur paramzzaur, Bitmap paramBitmap)
  {
  }

  public final void run()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    this.zzdrq.compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream);
    synchronized (zzaur.zza(this.zzdrr))
    {
      zzaur.zzb(this.zzdrr).zzhsc = new zzdsn();
      zzaur.zzb(this.zzdrr).zzhsc.zzhsu = localByteArrayOutputStream.toByteArray();
      zzaur.zzb(this.zzdrr).zzhsc.mimeType = "image/png";
      zzaur.zzb(this.zzdrr).zzhsc.zzhrv = Integer.valueOf(1);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzauu
 * JD-Core Version:    0.6.2
 */