package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.h;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;

class a
  implements h
{
  private final h a;
  private final byte[] b;
  private final byte[] c;
  private CipherInputStream d;

  public a(h paramh, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.a = paramh;
    this.b = paramArrayOfByte1;
    this.c = paramArrayOfByte2;
  }

  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    com.google.android.exoplayer2.g.a.a(this.d);
    int i = this.d.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i < 0)
      i = -1;
    return i;
  }

  // ERROR //
  public final long a(com.google.android.exoplayer2.f.l paraml)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 51	com/google/android/exoplayer2/source/c/a:d	()Ljavax/crypto/Cipher;
    //   4: astore_3
    //   5: new 53	javax/crypto/spec/SecretKeySpec
    //   8: dup
    //   9: aload_0
    //   10: getfield 22	com/google/android/exoplayer2/source/c/a:b	[B
    //   13: ldc 55
    //   15: invokespecial 58	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   18: astore 4
    //   20: new 60	javax/crypto/spec/IvParameterSpec
    //   23: dup
    //   24: aload_0
    //   25: getfield 24	com/google/android/exoplayer2/source/c/a:c	[B
    //   28: invokespecial 63	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   31: astore 5
    //   33: aload_3
    //   34: iconst_2
    //   35: aload 4
    //   37: aload 5
    //   39: invokevirtual 69	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   42: new 71	com/google/android/exoplayer2/f/k
    //   45: dup
    //   46: aload_0
    //   47: getfield 20	com/google/android/exoplayer2/source/c/a:a	Lcom/google/android/exoplayer2/f/h;
    //   50: aload_1
    //   51: invokespecial 74	com/google/android/exoplayer2/f/k:<init>	(Lcom/google/android/exoplayer2/f/h;Lcom/google/android/exoplayer2/f/l;)V
    //   54: astore 7
    //   56: aload_0
    //   57: new 36	javax/crypto/CipherInputStream
    //   60: dup
    //   61: aload 7
    //   63: aload_3
    //   64: invokespecial 77	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   67: putfield 29	com/google/android/exoplayer2/source/c/a:d	Ljavax/crypto/CipherInputStream;
    //   70: aload 7
    //   72: invokevirtual 79	com/google/android/exoplayer2/f/k:a	()V
    //   75: ldc2_w 80
    //   78: lreturn
    //   79: astore_2
    //   80: new 83	java/lang/RuntimeException
    //   83: dup
    //   84: aload_2
    //   85: invokespecial 86	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   88: athrow
    //   89: astore 6
    //   91: new 83	java/lang/RuntimeException
    //   94: dup
    //   95: aload 6
    //   97: invokespecial 86	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   100: athrow
    //   101: astore_2
    //   102: goto -22 -> 80
    //   105: astore 6
    //   107: goto -16 -> 91
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	79	java/security/NoSuchAlgorithmException
    //   33	42	89	java/security/InvalidKeyException
    //   0	5	101	javax/crypto/NoSuchPaddingException
    //   33	42	105	java/security/InvalidAlgorithmParameterException
  }

  public final Uri a()
  {
    return this.a.a();
  }

  public final void a(ad paramad)
  {
    this.a.a(paramad);
  }

  public final Map<String, List<String>> b()
  {
    return this.a.b();
  }

  public void c()
    throws IOException
  {
    if (this.d != null)
    {
      this.d = null;
      this.a.c();
    }
  }

  protected Cipher d()
    throws NoSuchPaddingException, NoSuchAlgorithmException
  {
    return Cipher.getInstance("AES/CBC/PKCS7Padding");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a
 * JD-Core Version:    0.6.2
 */