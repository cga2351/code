package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
final class zzvb
{

  @VisibleForTesting
  private ByteArrayOutputStream zzbwb = new ByteArrayOutputStream(4096);

  @VisibleForTesting
  private Base64OutputStream zzbwc = new Base64OutputStream(this.zzbwb, 10);

  // ERROR //
  public final java.lang.String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/google/android/gms/internal/ads/zzvb:zzbwc	Landroid/util/Base64OutputStream;
    //   4: invokevirtual 34	android/util/Base64OutputStream:close	()V
    //   7: aload_0
    //   8: getfield 20	com/google/android/gms/internal/ads/zzvb:zzbwb	Ljava/io/ByteArrayOutputStream;
    //   11: invokevirtual 35	java/io/ByteArrayOutputStream:close	()V
    //   14: aload_0
    //   15: getfield 20	com/google/android/gms/internal/ads/zzvb:zzbwb	Ljava/io/ByteArrayOutputStream;
    //   18: invokevirtual 37	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   21: astore 4
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 20	com/google/android/gms/internal/ads/zzvb:zzbwb	Ljava/io/ByteArrayOutputStream;
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 27	com/google/android/gms/internal/ads/zzvb:zzbwc	Landroid/util/Base64OutputStream;
    //   33: aload 4
    //   35: areturn
    //   36: astore_1
    //   37: ldc 39
    //   39: aload_1
    //   40: invokestatic 45	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: goto -36 -> 7
    //   46: astore_3
    //   47: ldc 39
    //   49: aload_3
    //   50: invokestatic 45	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 20	com/google/android/gms/internal/ads/zzvb:zzbwb	Ljava/io/ByteArrayOutputStream;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 27	com/google/android/gms/internal/ads/zzvb:zzbwc	Landroid/util/Base64OutputStream;
    //   63: ldc 47
    //   65: areturn
    //   66: astore_2
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 20	com/google/android/gms/internal/ads/zzvb:zzbwb	Ljava/io/ByteArrayOutputStream;
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 27	com/google/android/gms/internal/ads/zzvb:zzbwc	Landroid/util/Base64OutputStream;
    //   77: aload_2
    //   78: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	36	java/io/IOException
    //   7	23	46	java/io/IOException
    //   7	23	66	finally
    //   47	53	66	finally
  }

  public final void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.zzbwc.write(paramArrayOfByte);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvb
 * JD-Core Version:    0.6.2
 */