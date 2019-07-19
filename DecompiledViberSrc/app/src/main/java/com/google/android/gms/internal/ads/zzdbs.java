package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public abstract class zzdbs<P, KeyProto extends zzdpj, KeyFormatProto extends zzdpj>
  implements zzdbr<P>
{
  private final Class<P> zzgpd;
  private final Class<KeyProto> zzgpe;
  private final Class<KeyFormatProto> zzgpf;
  private final String zzgpg;

  protected zzdbs(Class<P> paramClass, Class<KeyProto> paramClass1, Class<KeyFormatProto> paramClass2, String paramString)
  {
    this.zzgpd = paramClass;
    this.zzgpe = paramClass1;
    this.zzgpf = paramClass2;
    this.zzgpg = paramString;
  }

  private static <Casted> Casted zza(Object paramObject, String paramString, Class<Casted> paramClass)
    throws GeneralSecurityException
  {
    if (!paramClass.isInstance(paramObject))
      throw new GeneralSecurityException(paramString);
    return paramObject;
  }

  private final P zzf(KeyProto paramKeyProto)
    throws GeneralSecurityException
  {
    zzc(paramKeyProto);
    return zze(paramKeyProto);
  }

  private final KeyProto zzh(KeyFormatProto paramKeyFormatProto)
    throws GeneralSecurityException
  {
    zzd(paramKeyFormatProto);
    zzdpj localzzdpj = zzg(paramKeyFormatProto);
    zzc(localzzdpj);
    return localzzdpj;
  }

  public final String getKeyType()
  {
    return this.zzgpg;
  }

  public final P zza(zzdpj paramzzdpj)
    throws GeneralSecurityException
  {
    String str1 = String.valueOf(this.zzgpe.getName());
    if (str1.length() != 0);
    for (String str2 = "Expected proto of type ".concat(str1); ; str2 = new String("Expected proto of type "))
      return zzf((zzdpj)zza(paramzzdpj, str2, this.zzgpe));
  }

  public final Class<P> zzanr()
  {
    return this.zzgpd;
  }

  protected abstract zzdgq.zzb zzans();

  public final zzdpj zzb(zzdpj paramzzdpj)
    throws GeneralSecurityException
  {
    String str1 = String.valueOf(this.zzgpf.getName());
    if (str1.length() != 0);
    for (String str2 = "Expected proto of type ".concat(str1); ; str2 = new String("Expected proto of type "))
      return zzh((zzdpj)zza(paramzzdpj, str2, this.zzgpf));
  }

  protected abstract void zzc(KeyProto paramKeyProto)
    throws GeneralSecurityException;

  protected abstract void zzd(KeyFormatProto paramKeyFormatProto)
    throws GeneralSecurityException;

  protected abstract P zze(KeyProto paramKeyProto)
    throws GeneralSecurityException;

  protected abstract KeyProto zzg(KeyFormatProto paramKeyFormatProto)
    throws GeneralSecurityException;

  public final P zzp(zzdmq paramzzdmq)
    throws GeneralSecurityException
  {
    String str1;
    try
    {
      Object localObject = zzf(zzs(paramzzdmq));
      return localObject;
    }
    catch (zzdoj localzzdoj)
    {
      str1 = String.valueOf(this.zzgpe.getName());
      if (str1.length() == 0);
    }
    for (String str2 = "Failures parsing proto of type ".concat(str1); ; str2 = new String("Failures parsing proto of type "))
      throw new GeneralSecurityException(str2, localzzdoj);
  }

  public final zzdpj zzq(zzdmq paramzzdmq)
    throws GeneralSecurityException
  {
    String str1;
    try
    {
      zzdpj localzzdpj = zzh(zzt(paramzzdmq));
      return localzzdpj;
    }
    catch (zzdoj localzzdoj)
    {
      str1 = String.valueOf(this.zzgpf.getName());
      if (str1.length() == 0);
    }
    for (String str2 = "Failures parsing proto of type ".concat(str1); ; str2 = new String("Failures parsing proto of type "))
      throw new GeneralSecurityException(str2, localzzdoj);
  }

  public final zzdgq zzr(zzdmq paramzzdmq)
    throws GeneralSecurityException
  {
    try
    {
      zzdpj localzzdpj1 = zzt(paramzzdmq);
      zzdpj localzzdpj2 = zzh(localzzdpj1);
      return (zzdgq)zzdgq.zzarw().zzgk(this.zzgpg).zzbo(localzzdpj2.zzavf()).zzb(zzans()).zzaya();
    }
    catch (zzdoj localzzdoj)
    {
      throw new GeneralSecurityException("Unexpected proto", localzzdoj);
    }
  }

  protected abstract KeyProto zzs(zzdmq paramzzdmq)
    throws zzdoj;

  protected abstract KeyFormatProto zzt(zzdmq paramzzdmq)
    throws zzdoj;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdbs
 * JD-Core Version:    0.6.2
 */