package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;

@TargetApi(16)
public final class zzgn extends zzgr
{
  private final zzgq zzacy;
  private final zzhq zzacz;
  private int zzada;
  private long zzadb;

  public zzgn(zzhn paramzzhn, Handler paramHandler, zzgq paramzzgq)
  {
    this(paramzzhn, null, true, paramHandler, paramzzgq);
  }

  private zzgn(zzhn paramzzhn, zzhz paramzzhz, boolean paramBoolean, Handler paramHandler, zzgq paramzzgq)
  {
    super(paramzzhn, null, true, paramHandler, paramzzgq);
    this.zzacy = paramzzgq;
    this.zzada = 0;
    this.zzacz = new zzhq();
  }

  protected final boolean isReady()
  {
    return (this.zzacz.zzer()) || ((super.isReady()) && (zzeg() == 2));
  }

  protected final void onStarted()
  {
    super.onStarted();
    this.zzacz.play();
  }

  protected final void onStopped()
  {
    this.zzacz.pause();
    super.onStopped();
  }

  protected final void seekTo(long paramLong)
    throws zzgd
  {
    super.seekTo(paramLong);
    this.zzacz.reset();
    this.zzadb = -9223372036854775808L;
  }

  public final void zza(int paramInt, Object paramObject)
    throws zzgd
  {
    if (paramInt == 1)
    {
      this.zzacz.setVolume(((Float)paramObject).floatValue());
      return;
    }
    super.zza(paramInt, paramObject);
  }

  protected final void zza(MediaCodec paramMediaCodec, String paramString, MediaFormat paramMediaFormat, MediaCrypto paramMediaCrypto)
  {
    if ("OMX.google.raw.decoder".equals(paramString))
    {
      String str = paramMediaFormat.getString("mime");
      paramMediaFormat.setString("mime", "audio/raw");
      paramMediaCodec.configure(paramMediaFormat, null, paramMediaCrypto, 0);
      paramMediaFormat.setString("mime", str);
      return;
    }
    paramMediaCodec.configure(paramMediaFormat, null, paramMediaCrypto, 0);
  }

  protected final void zza(zzhj paramzzhj, MediaFormat paramMediaFormat)
  {
    if (zzkl.zzaw(paramzzhj.mimeType))
    {
      this.zzacz.zza(paramzzhj.zzen(), 0);
      return;
    }
    this.zzacz.zza(paramMediaFormat, 0);
  }

  // ERROR //
  protected final boolean zza(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, java.nio.ByteBuffer paramByteBuffer, android.media.MediaCodec.BufferInfo paramBufferInfo, int paramInt, boolean paramBoolean)
    throws zzgd
  {
    // Byte code:
    //   0: iload 9
    //   2: ifeq +38 -> 40
    //   5: aload 5
    //   7: iload 8
    //   9: iconst_0
    //   10: invokevirtual 143	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   13: aload_0
    //   14: getfield 147	com/google/android/gms/internal/ads/zzgn:zzadf	Lcom/google/android/gms/internal/ads/zzga;
    //   17: astore 17
    //   19: aload 17
    //   21: iconst_1
    //   22: aload 17
    //   24: getfield 152	com/google/android/gms/internal/ads/zzga:zzabl	I
    //   27: iadd
    //   28: putfield 152	com/google/android/gms/internal/ads/zzga:zzabl	I
    //   31: aload_0
    //   32: getfield 34	com/google/android/gms/internal/ads/zzgn:zzacz	Lcom/google/android/gms/internal/ads/zzhq;
    //   35: invokevirtual 155	com/google/android/gms/internal/ads/zzhq:zzeq	()V
    //   38: iconst_1
    //   39: ireturn
    //   40: aload_0
    //   41: getfield 34	com/google/android/gms/internal/ads/zzgn:zzacz	Lcom/google/android/gms/internal/ads/zzhq;
    //   44: invokevirtual 158	com/google/android/gms/internal/ads/zzhq:isInitialized	()Z
    //   47: ifne +37 -> 84
    //   50: aload_0
    //   51: getfield 27	com/google/android/gms/internal/ads/zzgn:zzada	I
    //   54: ifeq +105 -> 159
    //   57: aload_0
    //   58: getfield 34	com/google/android/gms/internal/ads/zzgn:zzacz	Lcom/google/android/gms/internal/ads/zzhq;
    //   61: aload_0
    //   62: getfield 27	com/google/android/gms/internal/ads/zzgn:zzada	I
    //   65: invokevirtual 162	com/google/android/gms/internal/ads/zzhq:zzq	(I)I
    //   68: pop
    //   69: aload_0
    //   70: invokevirtual 167	com/google/android/gms/internal/ads/zzhp:getState	()I
    //   73: iconst_3
    //   74: if_icmpne +10 -> 84
    //   77: aload_0
    //   78: getfield 34	com/google/android/gms/internal/ads/zzgn:zzacz	Lcom/google/android/gms/internal/ads/zzhq;
    //   81: invokevirtual 53	com/google/android/gms/internal/ads/zzhq:play	()V
    //   84: aload_0
    //   85: getfield 34	com/google/android/gms/internal/ads/zzgn:zzacz	Lcom/google/android/gms/internal/ads/zzhq;
    //   88: aload 6
    //   90: aload 7
    //   92: getfield 172	android/media/MediaCodec$BufferInfo:offset	I
    //   95: aload 7
    //   97: getfield 175	android/media/MediaCodec$BufferInfo:size	I
    //   100: aload 7
    //   102: getfield 178	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   105: invokevirtual 181	com/google/android/gms/internal/ads/zzhq:zza	(Ljava/nio/ByteBuffer;IIJ)I
    //   108: istore 12
    //   110: iload 12
    //   112: iconst_1
    //   113: iand
    //   114: ifeq +10 -> 124
    //   117: aload_0
    //   118: ldc2_w 69
    //   121: putfield 72	com/google/android/gms/internal/ads/zzgn:zzadb	J
    //   124: iload 12
    //   126: iconst_2
    //   127: iand
    //   128: ifeq +134 -> 262
    //   131: aload 5
    //   133: iload 8
    //   135: iconst_0
    //   136: invokevirtual 143	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   139: aload_0
    //   140: getfield 147	com/google/android/gms/internal/ads/zzgn:zzadf	Lcom/google/android/gms/internal/ads/zzga;
    //   143: astore 13
    //   145: aload 13
    //   147: iconst_1
    //   148: aload 13
    //   150: getfield 184	com/google/android/gms/internal/ads/zzga:zzabk	I
    //   153: iadd
    //   154: putfield 184	com/google/android/gms/internal/ads/zzga:zzabk	I
    //   157: iconst_1
    //   158: ireturn
    //   159: aload_0
    //   160: aload_0
    //   161: getfield 34	com/google/android/gms/internal/ads/zzgn:zzacz	Lcom/google/android/gms/internal/ads/zzhq;
    //   164: iconst_0
    //   165: invokevirtual 162	com/google/android/gms/internal/ads/zzhq:zzq	(I)I
    //   168: putfield 27	com/google/android/gms/internal/ads/zzgn:zzada	I
    //   171: goto -102 -> 69
    //   174: astore 14
    //   176: aload_0
    //   177: getfield 188	com/google/android/gms/internal/ads/zzgn:zzabq	Landroid/os/Handler;
    //   180: ifnull +28 -> 208
    //   183: aload_0
    //   184: getfield 25	com/google/android/gms/internal/ads/zzgn:zzacy	Lcom/google/android/gms/internal/ads/zzgq;
    //   187: ifnull +21 -> 208
    //   190: aload_0
    //   191: getfield 188	com/google/android/gms/internal/ads/zzgn:zzabq	Landroid/os/Handler;
    //   194: new 190	com/google/android/gms/internal/ads/zzgo
    //   197: dup
    //   198: aload_0
    //   199: aload 14
    //   201: invokespecial 193	com/google/android/gms/internal/ads/zzgo:<init>	(Lcom/google/android/gms/internal/ads/zzgn;Lcom/google/android/gms/internal/ads/zzhu;)V
    //   204: invokevirtual 199	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   207: pop
    //   208: new 63	com/google/android/gms/internal/ads/zzgd
    //   211: dup
    //   212: aload 14
    //   214: invokespecial 202	com/google/android/gms/internal/ads/zzgd:<init>	(Ljava/lang/Throwable;)V
    //   217: athrow
    //   218: astore 10
    //   220: aload_0
    //   221: getfield 188	com/google/android/gms/internal/ads/zzgn:zzabq	Landroid/os/Handler;
    //   224: ifnull +28 -> 252
    //   227: aload_0
    //   228: getfield 25	com/google/android/gms/internal/ads/zzgn:zzacy	Lcom/google/android/gms/internal/ads/zzgq;
    //   231: ifnull +21 -> 252
    //   234: aload_0
    //   235: getfield 188	com/google/android/gms/internal/ads/zzgn:zzabq	Landroid/os/Handler;
    //   238: new 204	com/google/android/gms/internal/ads/zzgp
    //   241: dup
    //   242: aload_0
    //   243: aload 10
    //   245: invokespecial 207	com/google/android/gms/internal/ads/zzgp:<init>	(Lcom/google/android/gms/internal/ads/zzgn;Lcom/google/android/gms/internal/ads/zzhv;)V
    //   248: invokevirtual 199	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   251: pop
    //   252: new 63	com/google/android/gms/internal/ads/zzgd
    //   255: dup
    //   256: aload 10
    //   258: invokespecial 202	com/google/android/gms/internal/ads/zzgd:<init>	(Ljava/lang/Throwable;)V
    //   261: athrow
    //   262: iconst_0
    //   263: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   50	69	174	com/google/android/gms/internal/ads/zzhu
    //   159	171	174	com/google/android/gms/internal/ads/zzhu
    //   84	110	218	com/google/android/gms/internal/ads/zzhv
  }

  protected final boolean zzas(String paramString)
  {
    return (zzkl.zzav(paramString)) && (super.zzas(paramString));
  }

  protected final void zzb(long paramLong, boolean paramBoolean)
  {
    super.zzb(paramLong, paramBoolean);
    this.zzadb = -9223372036854775808L;
  }

  protected final zzgc zzc(String paramString, boolean paramBoolean)
    throws zzgz
  {
    if (zzkl.zzaw(paramString))
      return new zzgc("OMX.google.raw.decoder", true);
    return super.zzc(paramString, paramBoolean);
  }

  protected final boolean zzdw()
  {
    return true;
  }

  protected final boolean zzdx()
  {
    return (super.zzdx()) && ((!this.zzacz.zzer()) || (!this.zzacz.zzes()));
  }

  protected final long zzdy()
  {
    long l = this.zzacz.zzf(zzdx());
    if (l == -9223372036854775808L);
    for (this.zzadb = Math.max(this.zzadb, super.zzdy()); ; this.zzadb = Math.max(this.zzadb, l))
      return this.zzadb;
  }

  protected final void zzdz()
  {
    this.zzada = 0;
    try
    {
      this.zzacz.reset();
      return;
    }
    finally
    {
      super.zzdz();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzgn
 * JD-Core Version:    0.6.2
 */