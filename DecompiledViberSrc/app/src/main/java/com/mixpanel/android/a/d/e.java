package com.mixpanel.android.a.d;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] b = new byte[0];
  private ByteBuffer a;
  protected boolean c;
  protected d.a d;
  protected boolean e;

  public e()
  {
  }

  public e(d.a parama)
  {
    this.d = parama;
    this.a = ByteBuffer.wrap(b);
  }

  public e(d paramd)
  {
    this.c = paramd.d();
    this.d = paramd.f();
    this.a = paramd.c();
    this.e = paramd.e();
  }

  public void a(d.a parama)
  {
    this.d = parama;
  }

  public void a(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.b
  {
    this.a = paramByteBuffer;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public ByteBuffer c()
  {
    return this.a;
  }

  public boolean d()
  {
    return this.c;
  }

  public boolean e()
  {
    return this.e;
  }

  public d.a f()
  {
    return this.d;
  }

  public String toString()
  {
    return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(com.mixpanel.android.a.f.b.a(new String(this.a.array()))) + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.d.e
 * JD-Core Version:    0.6.2
 */