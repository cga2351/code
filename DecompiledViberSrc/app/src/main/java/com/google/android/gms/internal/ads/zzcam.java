package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzcam
{
  private final Clock zzbsb;
  private final Executor zzfiv;
  private final zzayv zzfqs;

  public zzcam(zzayv paramzzayv, Clock paramClock, Executor paramExecutor)
  {
    this.zzfqs = paramzzayv;
    this.zzbsb = paramClock;
    this.zzfiv = paramExecutor;
  }

  private final Bitmap zza(byte[] paramArrayOfByte, double paramDouble, boolean paramBoolean)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = ((int)(160.0D * paramDouble));
    if (!paramBoolean)
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    zzaci localzzaci1 = zzact.zzcwo;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
    {
      localOptions.inJustDecodeBounds = true;
      zza(paramArrayOfByte, localOptions);
      localOptions.inJustDecodeBounds = false;
      int i = localOptions.outWidth * localOptions.outHeight;
      if (i > 0)
      {
        zzaci localzzaci2 = zzact.zzcwp;
        int j = ((Integer)zzyr.zzpe().zzd(localzzaci2)).intValue();
        localOptions.inSampleSize = (1 << (33 - Integer.numberOfLeadingZeros((i - 1) / j)) / 2);
      }
    }
    return zza(paramArrayOfByte, localOptions);
  }

  private final Bitmap zza(byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    long l1 = this.zzbsb.elapsedRealtime();
    Bitmap localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, paramOptions);
    long l2 = this.zzbsb.elapsedRealtime();
    if ((Build.VERSION.SDK_INT >= 19) && (localBitmap != null))
    {
      int i = localBitmap.getWidth();
      int j = localBitmap.getHeight();
      int k = localBitmap.getAllocationByteCount();
      long l3 = l2 - l1;
      Thread localThread1 = Looper.getMainLooper().getThread();
      Thread localThread2 = Thread.currentThread();
      boolean bool = false;
      if (localThread1 == localThread2)
        bool = true;
      zzaxa.zzds(108 + "Decoded image w: " + i + " h:" + j + " bytes: " + k + " time: " + l3 + " on ui thread: " + bool);
    }
    return localBitmap;
  }

  public final zzbbi<Bitmap> zza(String paramString, double paramDouble, boolean paramBoolean)
  {
    return zzbas.zza(zzayv.zzeg(paramString), new zzcan(this, paramDouble, paramBoolean), this.zzfiv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcam
 * JD-Core Version:    0.6.2
 */