package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class zzdkd
{
  private ECPublicKey zzgyv;

  public zzdkd(ECPublicKey paramECPublicKey)
  {
    this.zzgyv = paramECPublicKey;
  }

  public final zzdke zza(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, zzdku paramzzdku)
    throws GeneralSecurityException
  {
    int i = 1;
    KeyPair localKeyPair = zzdkq.zza(this.zzgyv.getParams());
    ECPublicKey localECPublicKey1 = (ECPublicKey)localKeyPair.getPublic();
    ECPrivateKey localECPrivateKey = (ECPrivateKey)localKeyPair.getPrivate();
    ECPublicKey localECPublicKey2 = this.zzgyv;
    try
    {
      ECParameterSpec localECParameterSpec1 = localECPublicKey2.getParams();
      ECParameterSpec localECParameterSpec2 = localECPrivateKey.getParams();
      if ((!localECParameterSpec1.getCurve().equals(localECParameterSpec2.getCurve())) || (!localECParameterSpec1.getGenerator().equals(localECParameterSpec2.getGenerator())) || (!localECParameterSpec1.getOrder().equals(localECParameterSpec2.getOrder())) || (localECParameterSpec1.getCofactor() != localECParameterSpec2.getCofactor()))
        throw new GeneralSecurityException("invalid public key spec");
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new GeneralSecurityException(localIllegalArgumentException.toString());
      byte[] arrayOfByte1 = zzdkq.zza(localECPrivateKey, localECPublicKey2.getW());
      EllipticCurve localEllipticCurve = localECPublicKey1.getParams().getCurve();
      ECPoint localECPoint = localECPublicKey1.getW();
      zzdkq.zza(localECPoint, localEllipticCurve);
      int j = zzdkq.zzb(localEllipticCurve);
      byte[] arrayOfByte10;
      byte[] arrayOfByte3;
      Mac localMac;
      switch (zzdkr.zzgzy[paramzzdku.ordinal()])
      {
      default:
        String str = String.valueOf(paramzzdku);
        throw new GeneralSecurityException(15 + String.valueOf(str).length() + "invalid format:" + str);
      case 1:
        arrayOfByte10 = new byte[1 + j * 2];
        byte[] arrayOfByte11 = localECPoint.getAffineX().toByteArray();
        byte[] arrayOfByte12 = localECPoint.getAffineY().toByteArray();
        System.arraycopy(arrayOfByte12, 0, arrayOfByte10, 1 + j * 2 - arrayOfByte12.length, arrayOfByte12.length);
        System.arraycopy(arrayOfByte11, 0, arrayOfByte10, j + 1 - arrayOfByte11.length, arrayOfByte11.length);
        arrayOfByte10[0] = 4;
      case 2:
        byte[] arrayOfByte7;
        for (localObject = arrayOfByte10; ; localObject = arrayOfByte7)
        {
          byte[][] arrayOfByte = new byte[2][];
          arrayOfByte[0] = localObject;
          arrayOfByte[i] = arrayOfByte1;
          arrayOfByte3 = zzdjr.zza(arrayOfByte);
          localMac = (Mac)zzdkw.zzhaq.zzgt(paramString);
          if (paramInt <= 255 * localMac.getMacLength())
            break;
          throw new GeneralSecurityException("size too large");
          arrayOfByte7 = new byte[j * 2];
          byte[] arrayOfByte8 = localECPoint.getAffineX().toByteArray();
          if (arrayOfByte8.length > j)
            arrayOfByte8 = Arrays.copyOfRange(arrayOfByte8, arrayOfByte8.length - j, arrayOfByte8.length);
          byte[] arrayOfByte9 = localECPoint.getAffineY().toByteArray();
          if (arrayOfByte9.length > j)
            arrayOfByte9 = Arrays.copyOfRange(arrayOfByte9, arrayOfByte9.length - j, arrayOfByte9.length);
          System.arraycopy(arrayOfByte9, 0, arrayOfByte7, j * 2 - arrayOfByte9.length, arrayOfByte9.length);
          System.arraycopy(arrayOfByte8, 0, arrayOfByte7, j - arrayOfByte8.length, arrayOfByte8.length);
        }
      case 3:
      }
      Object localObject = new byte[j + 1];
      byte[] arrayOfByte2 = localECPoint.getAffineX().toByteArray();
      System.arraycopy(arrayOfByte2, 0, localObject, j + 1 - arrayOfByte2.length, arrayOfByte2.length);
      if (localECPoint.getAffineY().testBit(0));
      for (int k = 3; ; k = 2)
      {
        localObject[0] = k;
        break;
      }
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0))
        localMac.init(new SecretKeySpec(new byte[localMac.getMacLength()], paramString));
      byte[] arrayOfByte5;
      byte[] arrayOfByte6;
      int m;
      while (true)
      {
        byte[] arrayOfByte4 = localMac.doFinal(arrayOfByte3);
        arrayOfByte5 = new byte[paramInt];
        localMac.init(new SecretKeySpec(arrayOfByte4, paramString));
        arrayOfByte6 = new byte[0];
        m = 0;
        while (true)
        {
          localMac.update(arrayOfByte6);
          localMac.update(paramArrayOfByte2);
          localMac.update((byte)i);
          arrayOfByte6 = localMac.doFinal();
          if (m + arrayOfByte6.length >= paramInt)
            break;
          System.arraycopy(arrayOfByte6, 0, arrayOfByte5, m, arrayOfByte6.length);
          m += arrayOfByte6.length;
          i++;
        }
        localMac.init(new SecretKeySpec(paramArrayOfByte1, paramString));
      }
      System.arraycopy(arrayOfByte6, 0, arrayOfByte5, m, paramInt - m);
      return new zzdke((byte[])localObject, arrayOfByte5);
    }
    catch (NullPointerException localNullPointerException)
    {
      label134: break label134;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdkd
 * JD-Core Version:    0.6.2
 */