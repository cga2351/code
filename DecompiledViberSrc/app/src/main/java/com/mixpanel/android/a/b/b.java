package com.mixpanel.android.a.b;

import android.annotation.SuppressLint;
import com.mixpanel.android.a.d.d.a;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressLint({"Assert", "UseValueOf"})
public class b extends a
{
  private ByteBuffer g;
  private com.mixpanel.android.a.d.d h = null;
  private final Random i = new Random();

  static
  {
    if (!b.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      f = bool;
      return;
    }
  }

  private byte a(d.a parama)
  {
    if (parama == d.a.a)
      return 0;
    if (parama == d.a.b)
      return 1;
    if (parama == d.a.c)
      return 2;
    if (parama == d.a.f)
      return 8;
    if (parama == d.a.d)
      return 9;
    if (parama == d.a.e)
      return 10;
    throw new RuntimeException("Don't know how to handle " + parama.toString());
  }

  private d.a a(byte paramByte)
    throws com.mixpanel.android.a.c.c
  {
    switch (paramByte)
    {
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    default:
      throw new com.mixpanel.android.a.c.c("unknow optcode " + (short)paramByte);
    case 0:
      return d.a.a;
    case 1:
      return d.a.b;
    case 2:
      return d.a.c;
    case 8:
      return d.a.f;
    case 9:
      return d.a.d;
    case 10:
    }
    return d.a.e;
  }

  private String a(String paramString)
  {
    String str1 = paramString.trim();
    String str2 = str1 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      return com.mixpanel.android.a.f.a.a(localMessageDigest.digest(str2.getBytes()));
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }

  private byte[] a(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int j = -8 + paramInt * 8;
    for (int k = 0; k < paramInt; k++)
      arrayOfByte[k] = ((byte)(int)(paramLong >>> j - k * 8));
    return arrayOfByte;
  }

  public static int b(f paramf)
  {
    int j = -1;
    String str = paramf.b("Sec-WebSocket-Version");
    if (str.length() > 0);
    try
    {
      int k = new Integer(str.trim()).intValue();
      j = k;
      return j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return j;
  }

  public a.b a(com.mixpanel.android.a.e.a parama)
    throws com.mixpanel.android.a.c.d
  {
    int j = b(parama);
    if ((j == 7) || (j == 8))
    {
      if (a(parama))
        return a.b.a;
      return a.b.b;
    }
    return a.b.b;
  }

  public a.b a(com.mixpanel.android.a.e.a parama, h paramh)
    throws com.mixpanel.android.a.c.d
  {
    if ((!parama.c("Sec-WebSocket-Key")) || (!paramh.c("Sec-WebSocket-Accept")))
      return a.b.b;
    String str = paramh.b("Sec-WebSocket-Accept");
    if (a(parama.b("Sec-WebSocket-Key")).equals(str))
      return a.b.a;
    return a.b.b;
  }

  public com.mixpanel.android.a.e.b a(com.mixpanel.android.a.e.b paramb)
  {
    paramb.a("Upgrade", "websocket");
    paramb.a("Connection", "Upgrade");
    paramb.a("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.i.nextBytes(arrayOfByte);
    paramb.a("Sec-WebSocket-Key", com.mixpanel.android.a.f.a.a(arrayOfByte));
    return paramb;
  }

  public com.mixpanel.android.a.e.c a(com.mixpanel.android.a.e.a parama, i parami)
    throws com.mixpanel.android.a.c.d
  {
    parami.a("Upgrade", "websocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("Switching Protocols");
    String str = parama.b("Sec-WebSocket-Key");
    if (str == null)
      throw new com.mixpanel.android.a.c.d("missing Sec-WebSocket-Key");
    parami.a("Sec-WebSocket-Accept", a(str));
    return parami;
  }

  public ByteBuffer a(com.mixpanel.android.a.d.d paramd)
  {
    int j = -128;
    int k = 0;
    ByteBuffer localByteBuffer1 = paramd.c();
    int m;
    int n;
    label39: int i1;
    label51: int i3;
    label65: ByteBuffer localByteBuffer2;
    int i4;
    if (this.d == com.mixpanel.android.a.a.b.a)
    {
      m = 1;
      if (localByteBuffer1.remaining() > 125)
        break label159;
      n = 1;
      if (n <= 1)
        break label182;
      i1 = n + 1;
      int i2 = i1 + 1;
      if (m == 0)
        break label189;
      i3 = 4;
      localByteBuffer2 = ByteBuffer.allocate(i3 + i2 + localByteBuffer1.remaining());
      i4 = a(paramd.f());
      if (!paramd.d())
        break label195;
    }
    byte[] arrayOfByte;
    label159: label182: label189: label195: for (int i5 = j; ; i5 = 0)
    {
      localByteBuffer2.put((byte)(i4 | i5));
      arrayOfByte = a(localByteBuffer1.remaining(), n);
      if ((f) || (arrayOfByte.length == n))
        break label201;
      throw new AssertionError();
      m = 0;
      break;
      if (localByteBuffer1.remaining() <= 65535)
      {
        n = 2;
        break label39;
      }
      n = 8;
      break label39;
      i1 = n;
      break label51;
      i3 = 0;
      break label65;
    }
    label201: if (n == 1)
    {
      int i6 = arrayOfByte[0];
      if (m != 0);
      while (true)
      {
        localByteBuffer2.put((byte)(i6 | j));
        if (m == 0)
          break;
        ByteBuffer localByteBuffer3 = ByteBuffer.allocate(4);
        localByteBuffer3.putInt(this.i.nextInt());
        localByteBuffer2.put(localByteBuffer3.array());
        while (localByteBuffer1.hasRemaining())
        {
          localByteBuffer2.put((byte)(localByteBuffer1.get() ^ localByteBuffer3.get(k % 4)));
          k++;
        }
        j = 0;
      }
    }
    if (n == 2)
    {
      if (m != 0);
      while (true)
      {
        localByteBuffer2.put((byte)(j | 0x7E));
        localByteBuffer2.put(arrayOfByte);
        break;
        j = 0;
      }
    }
    if (n == 8)
    {
      if (m != 0);
      while (true)
      {
        localByteBuffer2.put((byte)(j | 0x7F));
        localByteBuffer2.put(arrayOfByte);
        break;
        j = 0;
      }
    }
    throw new RuntimeException("Size representation not supported/specified");
    localByteBuffer2.put(localByteBuffer1);
    if ((!f) && (localByteBuffer2.remaining() != 0))
      throw new AssertionError(localByteBuffer2.remaining());
    localByteBuffer2.flip();
    return localByteBuffer2;
  }

  public void a()
  {
    this.g = null;
  }

  public a.a b()
  {
    return a.a.c;
  }

  public a c()
  {
    return new b();
  }

  public List<com.mixpanel.android.a.d.d> c(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.e, com.mixpanel.android.a.c.b
  {
    LinkedList localLinkedList = new LinkedList();
    if (this.g != null);
    try
    {
      paramByteBuffer.mark();
      int j = paramByteBuffer.remaining();
      int k = this.g.remaining();
      if (k > j)
      {
        this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(j + paramByteBuffer.position());
        return Collections.emptyList();
      }
      this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), k);
      paramByteBuffer.position(k + paramByteBuffer.position());
      localLinkedList.add(e((ByteBuffer)this.g.duplicate().position(0)));
      this.g = null;
      while (paramByteBuffer.hasRemaining())
      {
        paramByteBuffer.mark();
        try
        {
          localLinkedList.add(e(paramByteBuffer));
        }
        catch (a locala1)
        {
          paramByteBuffer.reset();
          this.g = ByteBuffer.allocate(a(locala1.a()));
          this.g.put(paramByteBuffer);
        }
      }
      return localLinkedList;
    }
    catch (a locala2)
    {
      this.g.limit();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(a(locala2.a()));
      if ((!f) && (localByteBuffer.limit() <= this.g.limit()))
        throw new AssertionError();
      this.g.rewind();
      localByteBuffer.put(this.g);
      this.g = localByteBuffer;
    }
    return c(paramByteBuffer);
  }

  public com.mixpanel.android.a.d.d e(ByteBuffer paramByteBuffer)
    throws b.a, com.mixpanel.android.a.c.b
  {
    int j = 2;
    int k = 0;
    int m = paramByteBuffer.remaining();
    if (m < j)
      throw new a(j);
    int n = paramByteBuffer.get();
    if (n >> 8 != 0);
    for (boolean bool = true; ; bool = false)
    {
      int i1 = (byte)((n & 0x7F) >> 4);
      if (i1 == 0)
        break;
      throw new com.mixpanel.android.a.c.c("bad rsv " + i1);
    }
    int i2 = paramByteBuffer.get();
    if ((i2 & 0xFFFFFF80) != 0);
    int i4;
    d.a locala;
    for (int i3 = 1; ; i3 = 0)
    {
      i4 = (byte)(i2 & 0x7F);
      locala = a((byte)(n & 0xF));
      if ((bool) || ((locala != d.a.d) && (locala != d.a.e) && (locala != d.a.f)))
        break;
      throw new com.mixpanel.android.a.c.c("control frames may no be fragmented");
    }
    if ((i4 >= 0) && (i4 <= 125))
      if (i3 == 0)
        break label419;
    label419: for (int i7 = 4; ; i7 = 0)
    {
      int i8 = i4 + (i7 + j);
      if (m >= i8)
        break label425;
      throw new a(i8);
      if ((locala == d.a.d) || (locala == d.a.e) || (locala == d.a.f))
        throw new com.mixpanel.android.a.c.c("more than 125 octets");
      if (i4 == 126)
      {
        if (m < 4)
          throw new a(4);
        byte[] arrayOfByte3 = new byte[3];
        arrayOfByte3[1] = paramByteBuffer.get();
        arrayOfByte3[j] = paramByteBuffer.get();
        i4 = new BigInteger(arrayOfByte3).intValue();
        j = 4;
        break;
      }
      if (m < 10)
        throw new a(10);
      byte[] arrayOfByte1 = new byte[8];
      for (int i5 = 0; i5 < 8; i5++)
        arrayOfByte1[i5] = paramByteBuffer.get();
      long l = new BigInteger(arrayOfByte1).longValue();
      if (l > 2147483647L)
        throw new com.mixpanel.android.a.c.e("Payloadsize is to big...");
      int i6 = (int)l;
      j = 10;
      i4 = i6;
      break;
    }
    label425: ByteBuffer localByteBuffer = ByteBuffer.allocate(a(i4));
    if (i3 != 0)
    {
      byte[] arrayOfByte2 = new byte[4];
      paramByteBuffer.get(arrayOfByte2);
      while (k < i4)
      {
        localByteBuffer.put((byte)(paramByteBuffer.get() ^ arrayOfByte2[(k % 4)]));
        k++;
      }
    }
    localByteBuffer.put(paramByteBuffer.array(), paramByteBuffer.position(), localByteBuffer.limit());
    paramByteBuffer.position(paramByteBuffer.position() + localByteBuffer.limit());
    Object localObject;
    if (locala == d.a.f)
      localObject = new com.mixpanel.android.a.d.b();
    while (true)
    {
      localByteBuffer.flip();
      ((com.mixpanel.android.a.d.c)localObject).a(localByteBuffer);
      return localObject;
      localObject = new com.mixpanel.android.a.d.e();
      ((com.mixpanel.android.a.d.c)localObject).a(bool);
      ((com.mixpanel.android.a.d.c)localObject).a(locala);
    }
  }

  private class a extends Throwable
  {
    private int b;

    public a(int arg2)
    {
      int i;
      this.b = i;
    }

    public int a()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.b.b
 * JD-Core Version:    0.6.2
 */