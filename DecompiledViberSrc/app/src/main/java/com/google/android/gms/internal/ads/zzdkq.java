package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import javax.crypto.KeyAgreement;

public final class zzdkq
{
  private static BigInteger zza(EllipticCurve paramEllipticCurve)
    throws GeneralSecurityException
  {
    ECField localECField = paramEllipticCurve.getField();
    if ((localECField instanceof ECFieldFp))
      return ((ECFieldFp)localECField).getP();
    throw new GeneralSecurityException("Only curves over prime order fields are supported");
  }

  public static KeyPair zza(ECParameterSpec paramECParameterSpec)
    throws GeneralSecurityException
  {
    KeyPairGenerator localKeyPairGenerator = (KeyPairGenerator)zzdkw.zzhau.zzgt("EC");
    localKeyPairGenerator.initialize(paramECParameterSpec);
    return localKeyPairGenerator.generateKeyPair();
  }

  public static ECPrivateKey zza(zzdks paramzzdks, byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    ECParameterSpec localECParameterSpec = zza(paramzzdks);
    ECPrivateKeySpec localECPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(1, paramArrayOfByte), localECParameterSpec);
    return (ECPrivateKey)((KeyFactory)zzdkw.zzhav.zzgt("EC")).generatePrivate(localECPrivateKeySpec);
  }

  public static ECPublicKey zza(zzdks paramzzdks, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    ECParameterSpec localECParameterSpec = zza(paramzzdks);
    ECPoint localECPoint = new ECPoint(new BigInteger(1, paramArrayOfByte1), new BigInteger(1, paramArrayOfByte2));
    zza(localECPoint, localECParameterSpec.getCurve());
    ECPublicKeySpec localECPublicKeySpec = new ECPublicKeySpec(localECPoint, localECParameterSpec);
    return (ECPublicKey)((KeyFactory)zzdkw.zzhav.zzgt("EC")).generatePublic(localECPublicKeySpec);
  }

  public static ECParameterSpec zza(zzdks paramzzdks)
    throws NoSuchAlgorithmException
  {
    switch (zzdkr.zzgzz[paramzzdks.ordinal()])
    {
    default:
      String str = String.valueOf(paramzzdks);
      throw new NoSuchAlgorithmException(22 + String.valueOf(str).length() + "curve not implemented:" + str);
    case 1:
      return zza("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    case 2:
      return zza("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
    case 3:
    }
    return zza("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
  }

  private static ECParameterSpec zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    BigInteger localBigInteger1 = new BigInteger(paramString1);
    BigInteger localBigInteger2 = new BigInteger(paramString2);
    BigInteger localBigInteger3 = localBigInteger1.subtract(new BigInteger("3"));
    BigInteger localBigInteger4 = new BigInteger(paramString3, 16);
    BigInteger localBigInteger5 = new BigInteger(paramString4, 16);
    BigInteger localBigInteger6 = new BigInteger(paramString5, 16);
    return new ECParameterSpec(new EllipticCurve(new ECFieldFp(localBigInteger1), localBigInteger3, localBigInteger4), new ECPoint(localBigInteger5, localBigInteger6), localBigInteger2, 1);
  }

  static void zza(ECPublicKey paramECPublicKey)
    throws GeneralSecurityException
  {
    zza(paramECPublicKey.getW(), paramECPublicKey.getParams().getCurve());
  }

  static void zza(ECPoint paramECPoint, EllipticCurve paramEllipticCurve)
    throws GeneralSecurityException
  {
    BigInteger localBigInteger1 = zza(paramEllipticCurve);
    BigInteger localBigInteger2 = paramECPoint.getAffineX();
    BigInteger localBigInteger3 = paramECPoint.getAffineY();
    if ((localBigInteger2 == null) || (localBigInteger3 == null))
      throw new GeneralSecurityException("point is at infinity");
    if ((localBigInteger2.signum() == -1) || (localBigInteger2.compareTo(localBigInteger1) != -1))
      throw new GeneralSecurityException("x is out of range");
    if ((localBigInteger3.signum() == -1) || (localBigInteger3.compareTo(localBigInteger1) != -1))
      throw new GeneralSecurityException("y is out of range");
    if (!localBigInteger3.multiply(localBigInteger3).mod(localBigInteger1).equals(localBigInteger2.multiply(localBigInteger2).add(paramEllipticCurve.getA()).multiply(localBigInteger2).add(paramEllipticCurve.getB()).mod(localBigInteger1)))
      throw new GeneralSecurityException("Point is not on curve");
  }

  public static byte[] zza(ECPrivateKey paramECPrivateKey, ECPoint paramECPoint)
    throws GeneralSecurityException
  {
    zza(paramECPoint, paramECPrivateKey.getParams().getCurve());
    ECParameterSpec localECParameterSpec = paramECPrivateKey.getParams();
    localECParameterSpec.getCurve();
    ECPublicKeySpec localECPublicKeySpec = new ECPublicKeySpec(paramECPoint, localECParameterSpec);
    PublicKey localPublicKey = KeyFactory.getInstance("EC").generatePublic(localECPublicKeySpec);
    KeyAgreement localKeyAgreement = (KeyAgreement)zzdkw.zzhat.zzgt("ECDH");
    localKeyAgreement.init(paramECPrivateKey);
    byte[] arrayOfByte;
    EllipticCurve localEllipticCurve;
    BigInteger localBigInteger1;
    try
    {
      localKeyAgreement.doPhase(localPublicKey, true);
      arrayOfByte = localKeyAgreement.generateSecret();
      localEllipticCurve = paramECPrivateKey.getParams().getCurve();
      localBigInteger1 = new BigInteger(1, arrayOfByte);
      if ((localBigInteger1.signum() == -1) || (localBigInteger1.compareTo(zza(localEllipticCurve)) != -1))
        throw new GeneralSecurityException("shared secret is out of range");
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new GeneralSecurityException(localIllegalStateException.toString());
    }
    BigInteger localBigInteger2 = zza(localEllipticCurve);
    BigInteger localBigInteger3 = localEllipticCurve.getA();
    BigInteger localBigInteger4 = localEllipticCurve.getB();
    BigInteger localBigInteger5 = localBigInteger1.multiply(localBigInteger1).add(localBigInteger3).multiply(localBigInteger1).add(localBigInteger4).mod(localBigInteger2);
    if (localBigInteger2.signum() != 1)
      throw new InvalidAlgorithmParameterException("p must be positive");
    BigInteger localBigInteger6 = localBigInteger5.mod(localBigInteger2);
    if (localBigInteger6.equals(BigInteger.ZERO))
      localObject1 = BigInteger.ZERO;
    boolean bool2;
    do
    {
      boolean bool1;
      do
      {
        while ((localObject1 == null) || (((BigInteger)localObject1).multiply((BigInteger)localObject1).mod(localBigInteger2).compareTo(localBigInteger6) == 0))
        {
          if (true == ((BigInteger)localObject1).testBit(0))
            break label710;
          localBigInteger2.subtract((BigInteger)localObject1).mod(localBigInteger2);
          return arrayOfByte;
          if ((!localBigInteger2.testBit(0)) || (!localBigInteger2.testBit(1)))
            break;
          localObject1 = localBigInteger6.modPow(localBigInteger2.add(BigInteger.ONE).shiftRight(2), localBigInteger2);
        }
        throw new GeneralSecurityException("Could not find a modular square root");
        bool1 = localBigInteger2.testBit(0);
        localObject1 = null;
      }
      while (!bool1);
      bool2 = localBigInteger2.testBit(1);
      localObject1 = null;
    }
    while (bool2);
    BigInteger localBigInteger7 = BigInteger.ONE;
    BigInteger localBigInteger8 = localBigInteger2.subtract(BigInteger.ONE).shiftRight(1);
    int i = 0;
    BigInteger localBigInteger9;
    do
    {
      localBigInteger9 = localBigInteger7.multiply(localBigInteger7).subtract(localBigInteger6).mod(localBigInteger2);
      if (localBigInteger9.equals(BigInteger.ZERO))
      {
        localObject1 = localBigInteger7;
        break;
      }
      BigInteger localBigInteger10 = localBigInteger9.modPow(localBigInteger8, localBigInteger2);
      if (localBigInteger10.add(BigInteger.ONE).equals(localBigInteger2))
        break label533;
      if (!localBigInteger10.equals(BigInteger.ONE))
        throw new InvalidAlgorithmParameterException("p is not prime");
      localBigInteger7 = localBigInteger7.add(BigInteger.ONE);
      i++;
    }
    while ((i != 128) || (localBigInteger2.isProbablePrime(80)));
    throw new InvalidAlgorithmParameterException("p is not prime");
    label533: BigInteger localBigInteger11 = localBigInteger2.add(BigInteger.ONE).shiftRight(1);
    Object localObject2 = BigInteger.ONE;
    int j = -2 + localBigInteger11.bitLength();
    Object localObject1 = localBigInteger7;
    label566: BigInteger localBigInteger13;
    Object localObject3;
    BigInteger localBigInteger14;
    if (j >= 0)
    {
      BigInteger localBigInteger12 = ((BigInteger)localObject1).multiply((BigInteger)localObject2);
      localBigInteger13 = ((BigInteger)localObject1).multiply((BigInteger)localObject1).add(((BigInteger)localObject2).multiply((BigInteger)localObject2).mod(localBigInteger2).multiply(localBigInteger9)).mod(localBigInteger2);
      localObject3 = localBigInteger12.add(localBigInteger12).mod(localBigInteger2);
      if (!localBigInteger11.testBit(j))
        break label703;
      localBigInteger14 = localBigInteger13.multiply(localBigInteger7).add(((BigInteger)localObject3).multiply(localBigInteger9)).mod(localBigInteger2);
      BigInteger localBigInteger15 = localBigInteger7.multiply((BigInteger)localObject3).add(localBigInteger13).mod(localBigInteger2);
      localObject3 = localBigInteger15;
    }
    while (true)
    {
      j--;
      Object localObject4 = localObject3;
      localObject1 = localBigInteger14;
      localObject2 = localObject4;
      break label566;
      break;
      label703: localBigInteger14 = localBigInteger13;
    }
    label710: return arrayOfByte;
  }

  public static int zzb(EllipticCurve paramEllipticCurve)
    throws GeneralSecurityException
  {
    return (7 + zza(paramEllipticCurve).subtract(BigInteger.ONE).bitLength()) / 8;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdkq
 * JD-Core Version:    0.6.2
 */