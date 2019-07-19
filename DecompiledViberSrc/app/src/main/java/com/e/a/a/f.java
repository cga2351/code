package com.e.a.a;

import com.e.a.k;
import java.security.interfaces.RSAPublicKey;
import java.util.Set;

public class f extends e
  implements k
{
  private final c b = new c();
  private final RSAPublicKey c;

  public f(RSAPublicKey paramRSAPublicKey)
  {
    this(paramRSAPublicKey, null);
  }

  public f(RSAPublicKey paramRSAPublicKey, Set<String> paramSet)
  {
    if (paramRSAPublicKey == null)
      throw new IllegalArgumentException("The public RSA key must not be null");
    this.c = paramRSAPublicKey;
    this.b.a(paramSet);
  }

  // ERROR //
  public boolean a(com.e.a.i parami, byte[] paramArrayOfByte, com.e.a.d.c paramc)
    throws com.e.a.d
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/e/a/a/f:b	Lcom/e/a/a/c;
    //   4: aload_1
    //   5: invokevirtual 49	com/e/a/a/c:a	(Lcom/e/a/c;)Z
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: invokevirtual 55	com/e/a/i:e	()Lcom/e/a/h;
    //   17: aload_0
    //   18: invokevirtual 56	com/e/a/a/f:a	()Lcom/e/a/b/a;
    //   21: invokevirtual 61	com/e/a/b/a:a	()Ljava/security/Provider;
    //   24: invokestatic 66	com/e/a/a/d:a	(Lcom/e/a/h;Ljava/security/Provider;)Ljava/security/Signature;
    //   27: astore 4
    //   29: aload 4
    //   31: aload_0
    //   32: getfield 32	com/e/a/a/f:c	Ljava/security/interfaces/RSAPublicKey;
    //   35: invokevirtual 72	java/security/Signature:initVerify	(Ljava/security/PublicKey;)V
    //   38: aload 4
    //   40: aload_2
    //   41: invokevirtual 76	java/security/Signature:update	([B)V
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 81	com/e/a/d/c:a	()[B
    //   50: invokevirtual 85	java/security/Signature:verify	([B)Z
    //   53: istore 7
    //   55: iload 7
    //   57: ireturn
    //   58: astore 5
    //   60: new 42	com/e/a/d
    //   63: dup
    //   64: new 87	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 89
    //   70: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload 5
    //   75: invokevirtual 94	java/security/InvalidKeyException:getMessage	()Ljava/lang/String;
    //   78: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: aload 5
    //   86: invokespecial 104	com/e/a/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: athrow
    //   90: astore 6
    //   92: iconst_0
    //   93: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   29	38	58	java/security/InvalidKeyException
    //   38	55	90	java/security/SignatureException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.a.f
 * JD-Core Version:    0.6.2
 */