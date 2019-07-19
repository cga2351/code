package com.mixpanel.android.a.d;

import com.mixpanel.android.a.c.c;
import java.nio.ByteBuffer;

public class b extends e
  implements a
{
  static final ByteBuffer a = ByteBuffer.allocate(0);
  private int f;
  private String g;

  public b()
  {
    super(d.a.f);
    a(true);
  }

  public b(int paramInt)
    throws com.mixpanel.android.a.c.b
  {
    super(d.a.f);
    a(true);
    a(paramInt, "");
  }

  public b(int paramInt, String paramString)
    throws com.mixpanel.android.a.c.b
  {
    super(d.a.f);
    a(true);
    a(paramInt, paramString);
  }

  private void a(int paramInt, String paramString)
    throws com.mixpanel.android.a.c.b
  {
    if (paramString == null);
    for (String str = ""; ; str = paramString)
    {
      if (paramInt == 1015)
      {
        str = "";
        paramInt = 1005;
      }
      if (paramInt == 1005)
      {
        if (str.length() > 0)
          throw new com.mixpanel.android.a.c.b(1002, "A close frame must have a closecode if it has a reason");
      }
      else
      {
        byte[] arrayOfByte = com.mixpanel.android.a.f.b.a(str);
        ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
        localByteBuffer1.putInt(paramInt);
        localByteBuffer1.position(2);
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(2 + arrayOfByte.length);
        localByteBuffer2.put(localByteBuffer1);
        localByteBuffer2.put(arrayOfByte);
        localByteBuffer2.rewind();
        a(localByteBuffer2);
      }
      return;
    }
  }

  private void g()
    throws c
  {
    this.f = 1005;
    ByteBuffer localByteBuffer1 = super.c();
    localByteBuffer1.mark();
    if (localByteBuffer1.remaining() >= 2)
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(4);
      localByteBuffer2.position(2);
      localByteBuffer2.putShort(localByteBuffer1.getShort());
      localByteBuffer2.position(0);
      this.f = localByteBuffer2.getInt();
      if ((this.f == 1006) || (this.f == 1015) || (this.f == 1005) || (this.f > 4999) || (this.f < 1000) || (this.f == 1004))
        throw new c("closecode must not be sent over the wire: " + this.f);
    }
    localByteBuffer1.reset();
  }

  private void h()
    throws com.mixpanel.android.a.c.b
  {
    if (this.f == 1005)
    {
      this.g = com.mixpanel.android.a.f.b.a(super.c());
      return;
    }
    ByteBuffer localByteBuffer = super.c();
    int i = localByteBuffer.position();
    try
    {
      localByteBuffer.position(2 + localByteBuffer.position());
      this.g = com.mixpanel.android.a.f.b.a(localByteBuffer);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new c(localIllegalArgumentException);
    }
    finally
    {
      localByteBuffer.position(i);
    }
  }

  public int a()
  {
    return this.f;
  }

  public void a(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.b
  {
    super.a(paramByteBuffer);
    g();
    h();
  }

  public String b()
  {
    return this.g;
  }

  public ByteBuffer c()
  {
    if (this.f == 1005)
      return a;
    return super.c();
  }

  public String toString()
  {
    return super.toString() + "code: " + this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.d.b
 * JD-Core Version:    0.6.2
 */