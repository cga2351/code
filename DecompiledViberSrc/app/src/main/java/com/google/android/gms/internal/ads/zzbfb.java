package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@zzare
public final class zzbfb
  implements zzkw, zzqi, zzsj<zzrv>, zztn
{

  @VisibleForTesting
  private static int zzefe;

  @VisibleForTesting
  private static int zzeff;
  private int bytesTransferred;
  private final zzbdf zzefr;
  private final zzbfa zzeha;
  private final zzlo zzehb;
  private final zzlo zzehc;
  private final zzrj zzehd;
  private zzkv zzehe;
  private ByteBuffer zzehf;
  private boolean zzehg;
  private zzbfj zzehh;
  private Set<WeakReference<zzbew>> zzehi = new HashSet();
  private final Context zzlj;

  public zzbfb(Context paramContext, zzbdf paramzzbdf)
  {
    this.zzlj = paramContext;
    this.zzefr = paramzzbdf;
    this.zzeha = new zzbfa();
    this.zzehb = new zzth(this.zzlj, zzpg.zzbhn, 0L, zzaxj.zzdvx, this, -1);
    this.zzehc = new zzms(zzpg.zzbhn);
    this.zzehd = new zzrg();
    if (zzaxa.zzvj())
    {
      String str = String.valueOf(this);
      zzaxa.zzds(28 + String.valueOf(str).length() + "ExoPlayerAdapter initialize " + str);
    }
    zzefe = 1 + zzefe;
    zzlo[] arrayOfzzlo = new zzlo[2];
    arrayOfzzlo[0] = this.zzehc;
    arrayOfzzlo[1] = this.zzehb;
    this.zzehe = zzkz.zza(arrayOfzzlo, this.zzehd, this.zzeha);
    this.zzehe.zza(this);
  }

  @VisibleForTesting
  private final zzql zza(Uri paramUri, String paramString)
  {
    Object localObject2;
    if ((this.zzehg) && (this.zzehf.limit() > 0))
    {
      byte[] arrayOfByte2 = new byte[this.zzehf.limit()];
      this.zzehf.get(arrayOfByte2);
      localObject2 = new zzbfc(arrayOfByte2);
      return new zzqh(paramUri, (zzrw)localObject2, zzbfh.zzehn, -1, zzaxj.zzdvx, this, null, this.zzefr.zzeek);
    }
    if (this.zzefr.zzeem > 0);
    for (Object localObject1 = new zzbfd(this, paramString); ; localObject1 = new zzbfe(this, paramString))
    {
      if (this.zzefr.zzeen)
        localObject1 = new zzbff(this, (zzrw)localObject1);
      if (this.zzehf.limit() > 0)
      {
        byte[] arrayOfByte1 = new byte[this.zzehf.limit()];
        this.zzehf.get(arrayOfByte1);
        localObject1 = new zzbfg((zzrw)localObject1, arrayOfByte1);
      }
      localObject2 = localObject1;
      break;
    }
  }

  public static int zzyp()
  {
    return zzefe;
  }

  public static int zzyq()
  {
    return zzeff;
  }

  public final void finalize()
    throws Throwable
  {
    zzefe = -1 + zzefe;
    if (zzaxa.zzvj())
    {
      String str = String.valueOf(this);
      zzaxa.zzds(26 + String.valueOf(str).length() + "ExoPlayerAdapter finalize " + str);
    }
  }

  public final long getBytesTransferred()
  {
    return this.bytesTransferred;
  }

  public final void release()
  {
    if (this.zzehe != null)
    {
      this.zzehe.zzb(this);
      this.zzehe.release();
      this.zzehe = null;
      zzeff = -1 + zzeff;
    }
  }

  public final void zza(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    if (this.zzehh != null)
      this.zzehh.zzo(paramInt1, paramInt2);
  }

  final void zza(Surface paramSurface, boolean paramBoolean)
  {
    zzky localzzky = new zzky(this.zzehb, 1, paramSurface);
    if (paramBoolean)
    {
      this.zzehe.zzb(new zzky[] { localzzky });
      return;
    }
    this.zzehe.zza(new zzky[] { localzzky });
  }

  public final void zza(zzbfj paramzzbfj)
  {
    this.zzehh = paramzzbfj;
  }

  public final void zza(zzku paramzzku)
  {
    if (this.zzehh != null)
      this.zzehh.zza("onPlayerError", paramzzku);
  }

  public final void zza(zzln paramzzln)
  {
  }

  public final void zza(zzlr paramzzlr, Object paramObject)
  {
  }

  public final void zza(zzrb paramzzrb, zzro paramzzro)
  {
  }

  public final void zza(boolean paramBoolean, int paramInt)
  {
    if (this.zzehh != null)
      this.zzehh.zzde(paramInt);
  }

  public final void zza(Uri[] paramArrayOfUri, String paramString)
  {
    zza(paramArrayOfUri, paramString, ByteBuffer.allocate(0), false);
  }

  public final void zza(Uri[] paramArrayOfUri, String paramString, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    int i = 0;
    this.zzehf = paramByteBuffer;
    this.zzehg = paramBoolean;
    if (paramArrayOfUri.length == 1);
    zzql[] arrayOfzzql;
    for (Object localObject = zza(paramArrayOfUri[0], paramString); ; localObject = new zzqo(arrayOfzzql))
    {
      this.zzehe.zza((zzql)localObject);
      zzeff = 1 + zzeff;
      return;
      arrayOfzzql = new zzql[paramArrayOfUri.length];
      while (i < paramArrayOfUri.length)
      {
        arrayOfzzql[i] = zza(paramArrayOfUri[i], paramString);
        i++;
      }
    }
  }

  final void zzap(boolean paramBoolean)
  {
    int i = 0;
    if (i < this.zzehe.zzgs())
    {
      zzrj localzzrj = this.zzehd;
      if (!paramBoolean);
      for (boolean bool = true; ; bool = false)
      {
        localzzrj.zzg(i, bool);
        i++;
        break;
      }
    }
  }

  final void zzb(float paramFloat, boolean paramBoolean)
  {
    zzky localzzky = new zzky(this.zzehc, 2, Float.valueOf(paramFloat));
    if (paramBoolean)
    {
      this.zzehe.zzb(new zzky[] { localzzky });
      return;
    }
    this.zzehe.zza(new zzky[] { localzzky });
  }

  public final void zzb(int paramInt, long paramLong)
  {
  }

  public final void zzb(Surface paramSurface)
  {
  }

  public final void zzb(IOException paramIOException)
  {
    if (this.zzehh != null)
      this.zzehh.zza("onLoadError", paramIOException);
  }

  public final void zzdc(int paramInt)
  {
    Iterator localIterator = this.zzehi.iterator();
    while (localIterator.hasNext())
    {
      zzbew localzzbew = (zzbew)((WeakReference)localIterator.next()).get();
      if (localzzbew != null)
        localzzbew.setReceiveBufferSize(paramInt);
    }
  }

  public final void zze(zznc paramzznc)
  {
  }

  public final void zze(String paramString, long paramLong1, long paramLong2)
  {
  }

  public final void zzf(zznc paramzznc)
  {
  }

  public final void zzgt()
  {
  }

  public final void zzh(boolean paramBoolean)
  {
  }

  public final void zzk(zzlh paramzzlh)
  {
  }

  public final zzkv zzzt()
  {
    return this.zzehe;
  }

  public final zzbfa zzzu()
  {
    return this.zzeha;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfb
 * JD-Core Version:    0.6.2
 */