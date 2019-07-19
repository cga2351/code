package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

@Deprecated
@TargetApi(16)
public final class zzgl
  implements zzhn
{
  private final Uri uri;
  private final Map<String, String> zzab;
  private final FileDescriptor zzacn;
  private final long zzaco;
  private final long zzacp;
  private MediaExtractor zzacq;
  private zzho[] zzacr;
  private boolean zzacs;
  private int zzact;
  private int[] zzacu;
  private boolean[] zzacv;
  private long zzacw;
  private final Context zzlj;

  public zzgl(Context paramContext, Uri paramUri, Map<String, String> paramMap, int paramInt)
  {
    if (zzkq.SDK_INT >= 16);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      this.zzact = 2;
      this.zzlj = ((Context)zzkh.checkNotNull(paramContext));
      this.uri = ((Uri)zzkh.checkNotNull(paramUri));
      this.zzab = null;
      this.zzacn = null;
      this.zzaco = 0L;
      this.zzacp = 0L;
      return;
    }
  }

  private final void zza(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) || (this.zzacw != paramLong))
    {
      this.zzacw = paramLong;
      this.zzacq.seekTo(paramLong, 0);
      while (i < this.zzacu.length)
      {
        if (this.zzacu[i] != 0)
          this.zzacv[i] = true;
        i++;
      }
    }
  }

  public final int getTrackCount()
  {
    zzkh.checkState(this.zzacs);
    return this.zzacu.length;
  }

  public final void release()
  {
    if (this.zzact > 0);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      int i = -1 + this.zzact;
      this.zzact = i;
      if ((i == 0) && (this.zzacq != null))
      {
        this.zzacq.release();
        this.zzacq = null;
      }
      return;
    }
  }

  public final int zza(int paramInt, long paramLong, zzhk paramzzhk, zzhm paramzzhm, boolean paramBoolean)
  {
    zzkh.checkState(this.zzacs);
    if (this.zzacu[paramInt] != 0);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      if (this.zzacv[paramInt] == 0)
        break;
      this.zzacv[paramInt] = false;
      return -5;
    }
    if (paramBoolean)
      return -2;
    if (this.zzacu[paramInt] != 2)
    {
      paramzzhk.zzado = zzhj.zza(this.zzacq.getTrackFormat(paramInt));
      Map localMap;
      zzhx localzzhx;
      if (zzkq.SDK_INT >= 18)
      {
        localMap = this.zzacq.getPsshInfo();
        if ((localMap == null) || (localMap.isEmpty()))
          localzzhx = null;
      }
      while (true)
      {
        paramzzhk.zzadp = localzzhx;
        this.zzacu[paramInt] = 2;
        return -4;
        localzzhx = new zzhx("video/mp4");
        localzzhx.putAll(localMap);
        continue;
        localzzhx = null;
      }
    }
    int i = this.zzacq.getSampleTrackIndex();
    if (i == paramInt)
    {
      if (paramzzhm.zzde != null)
      {
        int j = paramzzhm.zzde.position();
        paramzzhm.size = this.zzacq.readSampleData(paramzzhm.zzde, j);
        paramzzhm.zzde.position(j + paramzzhm.size);
      }
      while (true)
      {
        paramzzhm.zzaga = this.zzacq.getSampleTime();
        paramzzhm.flags = (0x3 & this.zzacq.getSampleFlags());
        if (paramzzhm.zzeo())
          paramzzhm.zzafz.zza(this.zzacq);
        this.zzacw = -1L;
        this.zzacq.advance();
        return -3;
        paramzzhm.size = 0;
      }
    }
    if (i < 0)
      return -1;
    return -2;
  }

  public final void zza(int paramInt, long paramLong)
  {
    boolean bool1 = true;
    zzkh.checkState(this.zzacs);
    boolean bool2;
    if (this.zzacu[paramInt] == 0)
    {
      bool2 = bool1;
      zzkh.checkState(bool2);
      this.zzacu[paramInt] = bool1;
      this.zzacq.selectTrack(paramInt);
      if (paramLong == 0L)
        break label64;
    }
    while (true)
    {
      zza(paramLong, bool1);
      return;
      bool2 = false;
      break;
      label64: bool1 = false;
    }
  }

  public final boolean zzdg(long paramLong)
    throws IOException
  {
    if (!this.zzacs)
    {
      this.zzacq = new MediaExtractor();
      int i;
      label79: MediaFormat localMediaFormat;
      if (this.zzlj != null)
      {
        this.zzacq.setDataSource(this.zzlj, this.uri, null);
        this.zzacu = new int[this.zzacq.getTrackCount()];
        this.zzacv = new boolean[this.zzacu.length];
        this.zzacr = new zzho[this.zzacu.length];
        i = 0;
        if (i >= this.zzacu.length)
          break label170;
        localMediaFormat = this.zzacq.getTrackFormat(i);
        if (!localMediaFormat.containsKey("durationUs"))
          break label162;
      }
      label162: for (long l = localMediaFormat.getLong("durationUs"); ; l = -1L)
      {
        String str = localMediaFormat.getString("mime");
        this.zzacr[i] = new zzho(str, l);
        i++;
        break label79;
        this.zzacq.setDataSource(null, 0L, 0L);
        break;
      }
      label170: this.zzacs = true;
    }
    return true;
  }

  public final boolean zzdh(long paramLong)
  {
    return true;
  }

  public final void zzdi(long paramLong)
  {
    zzkh.checkState(this.zzacs);
    zza(paramLong, false);
  }

  public final long zzdu()
  {
    zzkh.checkState(this.zzacs);
    long l1 = this.zzacq.getCachedDuration();
    if (l1 == -1L)
      return -1L;
    long l2 = this.zzacq.getSampleTime();
    if (l2 == -1L)
      return -3L;
    return l2 + l1;
  }

  public final zzho zzo(int paramInt)
  {
    zzkh.checkState(this.zzacs);
    return this.zzacr[paramInt];
  }

  public final void zzp(int paramInt)
  {
    zzkh.checkState(this.zzacs);
    if (this.zzacu[paramInt] != 0);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      this.zzacq.unselectTrack(paramInt);
      this.zzacv[paramInt] = false;
      this.zzacu[paramInt] = 0;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzgl
 * JD-Core Version:    0.6.2
 */