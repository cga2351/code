package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

abstract interface zzdpz
{
  public abstract int getTag();

  public abstract double readDouble()
    throws IOException;

  public abstract float readFloat()
    throws IOException;

  public abstract String readString()
    throws IOException;

  public abstract void readStringList(List<String> paramList)
    throws IOException;

  public abstract <T> T zza(zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException;

  public abstract <T> void zza(List<T> paramList, zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException;

  public abstract <K, V> void zza(Map<K, V> paramMap, zzdpc<K, V> paramzzdpc, zzdnn paramzzdnn)
    throws IOException;

  public abstract long zzavv()
    throws IOException;

  public abstract long zzavw()
    throws IOException;

  public abstract int zzavx()
    throws IOException;

  public abstract long zzavy()
    throws IOException;

  public abstract int zzavz()
    throws IOException;

  public abstract boolean zzawa()
    throws IOException;

  public abstract String zzawb()
    throws IOException;

  public abstract zzdmq zzawc()
    throws IOException;

  public abstract int zzawd()
    throws IOException;

  public abstract int zzawe()
    throws IOException;

  public abstract int zzawf()
    throws IOException;

  public abstract long zzawg()
    throws IOException;

  public abstract int zzawh()
    throws IOException;

  public abstract long zzawi()
    throws IOException;

  public abstract int zzaws()
    throws IOException;

  public abstract boolean zzawt()
    throws IOException;

  @Deprecated
  public abstract <T> T zzb(zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException;

  @Deprecated
  public abstract <T> void zzb(List<T> paramList, zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException;

  public abstract void zzi(List<Double> paramList)
    throws IOException;

  public abstract void zzj(List<Float> paramList)
    throws IOException;

  public abstract void zzk(List<Long> paramList)
    throws IOException;

  public abstract void zzl(List<Long> paramList)
    throws IOException;

  public abstract void zzm(List<Integer> paramList)
    throws IOException;

  public abstract void zzn(List<Long> paramList)
    throws IOException;

  public abstract void zzo(List<Integer> paramList)
    throws IOException;

  public abstract void zzp(List<Boolean> paramList)
    throws IOException;

  public abstract void zzq(List<String> paramList)
    throws IOException;

  public abstract void zzr(List<zzdmq> paramList)
    throws IOException;

  public abstract void zzs(List<Integer> paramList)
    throws IOException;

  public abstract void zzt(List<Integer> paramList)
    throws IOException;

  public abstract void zzu(List<Integer> paramList)
    throws IOException;

  public abstract void zzv(List<Long> paramList)
    throws IOException;

  public abstract void zzw(List<Integer> paramList)
    throws IOException;

  public abstract void zzx(List<Long> paramList)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpz
 * JD-Core Version:    0.6.2
 */