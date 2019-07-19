package com.e.a.a.a;

import java.math.BigInteger;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;

public class a
{
  public static boolean a(BigInteger paramBigInteger1, BigInteger paramBigInteger2, ECParameterSpec paramECParameterSpec)
  {
    EllipticCurve localEllipticCurve = paramECParameterSpec.getCurve();
    BigInteger localBigInteger1 = localEllipticCurve.getA();
    BigInteger localBigInteger2 = localEllipticCurve.getB();
    BigInteger localBigInteger3 = ((ECFieldFp)localEllipticCurve.getField()).getP();
    return paramBigInteger2.pow(2).mod(localBigInteger3).equals(paramBigInteger1.pow(3).add(localBigInteger1.multiply(paramBigInteger1)).add(localBigInteger2).mod(localBigInteger3));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.a.a.a
 * JD-Core Version:    0.6.2
 */