package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

final class zzddj
  implements zzdjz
{
  private final String zzgqe;
  private final int zzgqf;
  private zzdes zzgqg;
  private zzddq zzgqh;
  private int zzgqi;

  zzddj(zzdgv paramzzdgv)
    throws GeneralSecurityException
  {
    this.zzgqe = paramzzdgv.zzart();
    if (this.zzgqe.equals("type.googleapis.com/google.crypto.tink.AesGcmKey"))
      try
      {
        zzdeu localzzdeu = zzdeu.zzal(paramzzdgv.zzaru());
        this.zzgqg = ((zzdes)zzdce.zzb(paramzzdgv));
        this.zzgqf = localzzdeu.getKeySize();
        return;
      }
      catch (zzdoj localzzdoj2)
      {
        throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", localzzdoj2);
      }
    if (this.zzgqe.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey"))
      try
      {
        zzdds localzzdds = zzdds.zzv(paramzzdgv.zzaru());
        this.zzgqh = ((zzddq)zzdce.zzb(paramzzdgv));
        this.zzgqi = localzzdds.zzaoe().getKeySize();
        this.zzgqf = (localzzdds.zzaof().getKeySize() + this.zzgqi);
        return;
      }
      catch (zzdoj localzzdoj1)
      {
        throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", localzzdoj1);
      }
    String str1 = String.valueOf(this.zzgqe);
    if (str1.length() != 0);
    for (String str2 = "unsupported AEAD DEM key type: ".concat(str1); ; str2 = new String("unsupported AEAD DEM key type: "))
      throw new GeneralSecurityException(str2);
  }

  public final int zzanz()
  {
    return this.zzgqf;
  }

  public final zzdbi zzm(byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    if (paramArrayOfByte.length != this.zzgqf)
      throw new GeneralSecurityException("Symmetric key has incorrect length");
    if (this.zzgqe.equals("type.googleapis.com/google.crypto.tink.AesGcmKey"))
    {
      zzdes localzzdes = (zzdes)((zzdes.zza)zzdes.zzapn().zza(this.zzgqg)).zzak(zzdmq.zzi(paramArrayOfByte, 0, this.zzgqf)).zzaya();
      return (zzdbi)zzdce.zza(this.zzgqe, localzzdes, zzdbi.class);
    }
    if (this.zzgqe.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey"))
    {
      byte[] arrayOfByte1 = Arrays.copyOfRange(paramArrayOfByte, 0, this.zzgqi);
      byte[] arrayOfByte2 = Arrays.copyOfRange(paramArrayOfByte, this.zzgqi, this.zzgqf);
      zzdea localzzdea = (zzdea)((zzdea.zza)zzdea.zzaot().zza(this.zzgqh.zzaoa())).zzab(zzdmq.zzz(arrayOfByte1)).zzaya();
      zzdgk localzzdgk = (zzdgk)((zzdgk.zza)zzdgk.zzark().zza(this.zzgqh.zzaob())).zzbl(zzdmq.zzz(arrayOfByte2)).zzaya();
      zzddq localzzddq = (zzddq)zzddq.zzaoc().zzdu(this.zzgqh.getVersion()).zzb(localzzdea).zzb(localzzdgk).zzaya();
      return (zzdbi)zzdce.zza(this.zzgqe, localzzddq, zzdbi.class);
    }
    throw new GeneralSecurityException("unknown DEM key type");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzddj
 * JD-Core Version:    0.6.2
 */