package com.mixpanel.android.a.b;

import android.annotation.SuppressLint;
import com.mixpanel.android.a.d.d.a;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressLint({"UseValueOf"})
public class e extends d
{
  private static final byte[] j = { -1, 0 };
  private boolean i = false;
  private final Random k = new Random();

  private static byte[] a(String paramString)
    throws com.mixpanel.android.a.c.d
  {
    long l1;
    long l2;
    try
    {
      l1 = Long.parseLong(paramString.replaceAll("[^0-9]", ""));
      l2 = -1 + paramString.split(" ").length;
      if (l2 == 0L)
        throw new com.mixpanel.android.a.c.d("invalid Sec-WebSocket-Key (/key2/)");
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new com.mixpanel.android.a.c.d("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
    }
    long l3 = new Long(l1 / l2).longValue();
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = ((byte)(int)(l3 >> 24));
    arrayOfByte[1] = ((byte)(int)(l3 << 8 >> 24));
    arrayOfByte[2] = ((byte)(int)(l3 << 16 >> 24));
    arrayOfByte[3] = ((byte)(int)(l3 << 24 >> 24));
    return arrayOfByte;
  }

  public static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws com.mixpanel.android.a.c.d
  {
    byte[] arrayOfByte1 = a(paramString1);
    byte[] arrayOfByte2 = a(paramString2);
    byte[] arrayOfByte3 = new byte[16];
    arrayOfByte3[0] = arrayOfByte1[0];
    arrayOfByte3[1] = arrayOfByte1[1];
    arrayOfByte3[2] = arrayOfByte1[2];
    arrayOfByte3[3] = arrayOfByte1[3];
    arrayOfByte3[4] = arrayOfByte2[0];
    arrayOfByte3[5] = arrayOfByte2[1];
    arrayOfByte3[6] = arrayOfByte2[2];
    arrayOfByte3[7] = arrayOfByte2[3];
    arrayOfByte3[8] = paramArrayOfByte[0];
    arrayOfByte3[9] = paramArrayOfByte[1];
    arrayOfByte3[10] = paramArrayOfByte[2];
    arrayOfByte3[11] = paramArrayOfByte[3];
    arrayOfByte3[12] = paramArrayOfByte[4];
    arrayOfByte3[13] = paramArrayOfByte[5];
    arrayOfByte3[14] = paramArrayOfByte[6];
    arrayOfByte3[15] = paramArrayOfByte[7];
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return localMessageDigest.digest(arrayOfByte3);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }

  private static String e()
  {
    Random localRandom = new Random();
    long l = 1 + localRandom.nextInt(12);
    String str1 = Long.toString(l * (1 + localRandom.nextInt(Math.abs(new Long(4294967295L / l).intValue()))));
    int m = 1 + localRandom.nextInt(12);
    for (int n = 0; n < m; n++)
    {
      int i3 = Math.abs(localRandom.nextInt(str1.length()));
      char c = (char)(33 + localRandom.nextInt(95));
      if ((c >= '0') && (c <= '9'))
        c = (char)(c - '\017');
      str1 = new StringBuilder(str1).insert(i3, c).toString();
    }
    int i1 = 0;
    String str2 = str1;
    while (i1 < l)
    {
      int i2 = Math.abs(1 + localRandom.nextInt(-1 + str2.length()));
      str2 = new StringBuilder(str2).insert(i2, " ").toString();
      i1++;
    }
    return str2;
  }

  public a.b a(com.mixpanel.android.a.e.a parama)
  {
    if ((parama.b("Upgrade").equals("WebSocket")) && (parama.b("Connection").contains("Upgrade")) && (parama.b("Sec-WebSocket-Key1").length() > 0) && (!parama.b("Sec-WebSocket-Key2").isEmpty()) && (parama.c("Origin")))
      return a.b.a;
    return a.b.b;
  }

  public a.b a(com.mixpanel.android.a.e.a parama, h paramh)
  {
    if (this.i)
      return a.b.b;
    byte[] arrayOfByte;
    try
    {
      if ((!paramh.b("Sec-WebSocket-Origin").equals(parama.b("Origin"))) || (!a(paramh)))
        return a.b.b;
      arrayOfByte = paramh.c();
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
        throw new com.mixpanel.android.a.c.a();
    }
    catch (com.mixpanel.android.a.c.d locald)
    {
      throw new RuntimeException("bad handshakerequest", locald);
    }
    if (Arrays.equals(arrayOfByte, a(parama.b("Sec-WebSocket-Key1"), parama.b("Sec-WebSocket-Key2"), parama.c())))
      return a.b.a;
    a.b localb = a.b.b;
    return localb;
  }

  public com.mixpanel.android.a.e.b a(com.mixpanel.android.a.e.b paramb)
  {
    paramb.a("Upgrade", "WebSocket");
    paramb.a("Connection", "Upgrade");
    paramb.a("Sec-WebSocket-Key1", e());
    paramb.a("Sec-WebSocket-Key2", e());
    if (!paramb.c("Origin"))
      paramb.a("Origin", "random" + this.k.nextInt());
    byte[] arrayOfByte = new byte[8];
    this.k.nextBytes(arrayOfByte);
    paramb.a(arrayOfByte);
    return paramb;
  }

  public com.mixpanel.android.a.e.c a(com.mixpanel.android.a.e.a parama, i parami)
    throws com.mixpanel.android.a.c.d
  {
    parami.a("WebSocket Protocol Handshake");
    parami.a("Upgrade", "WebSocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("Sec-WebSocket-Origin", parama.b("Origin"));
    parami.a("Sec-WebSocket-Location", "ws://" + parama.b("Host") + parama.a());
    String str1 = parama.b("Sec-WebSocket-Key1");
    String str2 = parama.b("Sec-WebSocket-Key2");
    byte[] arrayOfByte = parama.c();
    if ((str1 == null) || (str2 == null) || (arrayOfByte == null) || (arrayOfByte.length != 8))
      throw new com.mixpanel.android.a.c.d("Bad keys");
    parami.a(a(str1, str2, arrayOfByte));
    return parami;
  }

  public ByteBuffer a(com.mixpanel.android.a.d.d paramd)
  {
    if (paramd.f() == d.a.f)
      return ByteBuffer.wrap(j);
    return super.a(paramd);
  }

  public a.a b()
  {
    return a.a.b;
  }

  public a c()
  {
    return new e();
  }

  public List<com.mixpanel.android.a.d.d> c(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.b
  {
    paramByteBuffer.mark();
    List localList = super.e(paramByteBuffer);
    if (localList == null)
    {
      paramByteBuffer.reset();
      localList = this.g;
      this.f = true;
      if (this.h == null)
      {
        this.h = ByteBuffer.allocate(2);
        if (paramByteBuffer.remaining() > this.h.remaining())
          throw new com.mixpanel.android.a.c.c();
      }
      else
      {
        throw new com.mixpanel.android.a.c.c();
      }
      this.h.put(paramByteBuffer);
      if (this.h.hasRemaining())
        break label137;
      if (Arrays.equals(this.h.array(), j))
        localList.add(new com.mixpanel.android.a.d.b(1000));
    }
    else
    {
      return localList;
    }
    throw new com.mixpanel.android.a.c.c();
    label137: this.g = new LinkedList();
    return localList;
  }

  public f d(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.d
  {
    com.mixpanel.android.a.e.c localc = a(paramByteBuffer, this.d);
    int m;
    if (((localc.c("Sec-WebSocket-Key1")) || (this.d == com.mixpanel.android.a.a.b.a)) && (!localc.c("Sec-WebSocket-Version")))
    {
      if (this.d != com.mixpanel.android.a.a.b.b)
        break label77;
      m = 8;
    }
    while (true)
    {
      byte[] arrayOfByte = new byte[m];
      try
      {
        paramByteBuffer.get(arrayOfByte);
        localc.a(arrayOfByte);
        return localc;
        label77: m = 16;
      }
      catch (BufferUnderflowException localBufferUnderflowException)
      {
      }
    }
    throw new com.mixpanel.android.a.c.a(16 + paramByteBuffer.capacity());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.b.e
 * JD-Core Version:    0.6.2
 */