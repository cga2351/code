package com.mixpanel.android.a.b;

import com.mixpanel.android.a.d.d.a;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class a
{
  public static int a = 1000;
  public static int b = 64;
  public static final byte[] c = com.mixpanel.android.a.f.b.a("");
  protected com.mixpanel.android.a.a.b d = null;
  protected d.a e = null;

  public static com.mixpanel.android.a.e.c a(ByteBuffer paramByteBuffer, com.mixpanel.android.a.a.b paramb)
    throws com.mixpanel.android.a.c.d, com.mixpanel.android.a.c.a
  {
    String str1 = b(paramByteBuffer);
    if (str1 == null)
      throw new com.mixpanel.android.a.c.a(128 + paramByteBuffer.capacity());
    String[] arrayOfString1 = str1.split(" ", 3);
    if (arrayOfString1.length != 3)
      throw new com.mixpanel.android.a.c.d();
    Object localObject;
    if (paramb == com.mixpanel.android.a.a.b.a)
    {
      localObject = new com.mixpanel.android.a.e.e();
      i locali = (i)localObject;
      locali.a(Short.parseShort(arrayOfString1[1]));
      locali.a(arrayOfString1[2]);
    }
    for (String str2 = b(paramByteBuffer); ; str2 = b(paramByteBuffer))
    {
      if ((str2 == null) || (str2.length() <= 0))
        break label192;
      String[] arrayOfString2 = str2.split(":", 2);
      if (arrayOfString2.length != 2)
      {
        throw new com.mixpanel.android.a.c.d("not an http header");
        localObject = new com.mixpanel.android.a.e.d();
        ((com.mixpanel.android.a.e.b)localObject).a(arrayOfString1[1]);
        break;
      }
      ((com.mixpanel.android.a.e.c)localObject).a(arrayOfString2[0], arrayOfString2[1].replaceFirst("^ +", ""));
    }
    label192: if (str2 == null)
      throw new com.mixpanel.android.a.c.a();
    return localObject;
  }

  public static ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b1;
    for (int i = 48; ; i = b1)
      if (paramByteBuffer.hasRemaining())
      {
        b1 = paramByteBuffer.get();
        localByteBuffer.put(b1);
        if ((i == 13) && (b1 == 10))
        {
          localByteBuffer.limit(-2 + localByteBuffer.position());
          localByteBuffer.position(0);
          return localByteBuffer;
        }
      }
      else
      {
        paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
        return null;
      }
  }

  public static String b(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = a(paramByteBuffer);
    if (localByteBuffer == null)
      return null;
    return com.mixpanel.android.a.f.b.a(localByteBuffer.array(), 0, localByteBuffer.limit());
  }

  public int a(int paramInt)
    throws com.mixpanel.android.a.c.e, com.mixpanel.android.a.c.b
  {
    if (paramInt < 0)
      throw new com.mixpanel.android.a.c.b(1002, "Negative count");
    return paramInt;
  }

  public abstract b a(com.mixpanel.android.a.e.a parama)
    throws com.mixpanel.android.a.c.d;

  public abstract b a(com.mixpanel.android.a.e.a parama, h paramh)
    throws com.mixpanel.android.a.c.d;

  public abstract com.mixpanel.android.a.e.b a(com.mixpanel.android.a.e.b paramb)
    throws com.mixpanel.android.a.c.d;

  public abstract com.mixpanel.android.a.e.c a(com.mixpanel.android.a.e.a parama, i parami)
    throws com.mixpanel.android.a.c.d;

  public abstract ByteBuffer a(com.mixpanel.android.a.d.d paramd);

  public List<com.mixpanel.android.a.d.d> a(d.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if ((parama != d.a.c) && (parama != d.a.b) && (parama != d.a.b))
      throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
    com.mixpanel.android.a.d.e locale;
    if (this.e != null)
    {
      this.e = d.a.a;
      locale = new com.mixpanel.android.a.d.e(this.e);
    }
    while (true)
    {
      try
      {
        locale.a(paramByteBuffer);
        locale.a(paramBoolean);
        if (paramBoolean)
        {
          this.e = null;
          return Collections.singletonList(locale);
          this.e = parama;
        }
      }
      catch (com.mixpanel.android.a.c.b localb)
      {
        throw new RuntimeException(localb);
      }
      this.e = parama;
    }
  }

  public List<ByteBuffer> a(f paramf, com.mixpanel.android.a.a.b paramb)
  {
    return a(paramf, paramb, true);
  }

  public List<ByteBuffer> a(f paramf, com.mixpanel.android.a.a.b paramb, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if ((paramf instanceof com.mixpanel.android.a.e.a))
    {
      localStringBuilder.append("GET ");
      localStringBuilder.append(((com.mixpanel.android.a.e.a)paramf).a());
      localStringBuilder.append(" HTTP/1.1");
    }
    while (true)
    {
      localStringBuilder.append("\r\n");
      Iterator localIterator = paramf.b();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramf.b(str1);
        localStringBuilder.append(str1);
        localStringBuilder.append(": ");
        localStringBuilder.append(str2);
        localStringBuilder.append("\r\n");
      }
      if (!(paramf instanceof h))
        break;
      localStringBuilder.append("HTTP/1.1 101 " + ((h)paramf).a());
    }
    throw new RuntimeException("unknow role");
    localStringBuilder.append("\r\n");
    byte[] arrayOfByte1 = com.mixpanel.android.a.f.b.b(localStringBuilder.toString());
    byte[] arrayOfByte2;
    if (paramBoolean)
    {
      arrayOfByte2 = paramf.c();
      if (arrayOfByte2 != null)
        break label274;
    }
    label274: for (int i = 0; ; i = arrayOfByte2.length)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + arrayOfByte1.length);
      localByteBuffer.put(arrayOfByte1);
      if (arrayOfByte2 != null)
        localByteBuffer.put(arrayOfByte2);
      localByteBuffer.flip();
      return Collections.singletonList(localByteBuffer);
      arrayOfByte2 = null;
      break;
    }
  }

  public abstract void a();

  public void a(com.mixpanel.android.a.a.b paramb)
  {
    this.d = paramb;
  }

  protected boolean a(f paramf)
  {
    return (paramf.b("Upgrade").equalsIgnoreCase("websocket")) && (paramf.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }

  public abstract a b();

  public abstract a c();

  public abstract List<com.mixpanel.android.a.d.d> c(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.b;

  public f d(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.d
  {
    return a(paramByteBuffer, this.d);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.b.a
 * JD-Core Version:    0.6.2
 */