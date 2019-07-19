package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

public final class zzdlk
  implements zzdbx
{
  private Mac zzhbh;
  private final int zzhbi;
  private final String zzhbj;
  private final Key zzhbk;

  public zzdlk(String paramString, Key paramKey, int paramInt)
    throws GeneralSecurityException
  {
    if (paramInt < 10)
      throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    int i = -1;
    String str1;
    switch (paramString.hashCode())
    {
    default:
      switch (i)
      {
      default:
        str1 = String.valueOf(paramString);
        if (str1.length() == 0);
        break;
      case 0:
      case 1:
      case 2:
      }
      break;
    case -1823053428:
    case 392315118:
    case 392317873:
    }
    for (String str2 = "unknown Hmac algorithm: ".concat(str1); ; str2 = new String("unknown Hmac algorithm: "))
    {
      throw new NoSuchAlgorithmException(str2);
      if (!paramString.equals("HMACSHA1"))
        break;
      i = 0;
      break;
      if (!paramString.equals("HMACSHA256"))
        break;
      i = 1;
      break;
      if (!paramString.equals("HMACSHA512"))
        break;
      i = 2;
      break;
      if (paramInt <= 20)
        break label228;
      throw new InvalidAlgorithmParameterException("tag size too big");
      if (paramInt <= 32)
        break label228;
      throw new InvalidAlgorithmParameterException("tag size too big");
      if (paramInt <= 64)
        break label228;
      throw new InvalidAlgorithmParameterException("tag size too big");
    }
    label228: this.zzhbj = paramString;
    this.zzhbi = paramInt;
    this.zzhbk = paramKey;
    this.zzhbh = ((Mac)zzdkw.zzhaq.zzgt(paramString));
    this.zzhbh.init(paramKey);
  }

  public final byte[] zzk(byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    try
    {
      localMac = (Mac)this.zzhbh.clone();
      localMac.update(paramArrayOfByte);
      byte[] arrayOfByte = new byte[this.zzhbi];
      System.arraycopy(localMac.doFinal(), 0, arrayOfByte, 0, this.zzhbi);
      return arrayOfByte;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (true)
      {
        Mac localMac = (Mac)zzdkw.zzhaq.zzgt(this.zzhbj);
        localMac.init(this.zzhbk);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdlk
 * JD-Core Version:    0.6.2
 */