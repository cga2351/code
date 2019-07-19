package com.mixpanel.android.a.b;

import com.mixpanel.android.a.d.d.a;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class d extends a
{
  protected boolean f = false;
  protected List<com.mixpanel.android.a.d.d> g = new LinkedList();
  protected ByteBuffer h;
  private final Random i = new Random();

  public a.b a(com.mixpanel.android.a.e.a parama)
  {
    if ((parama.c("Origin")) && (a(parama)))
      return a.b.a;
    return a.b.b;
  }

  public a.b a(com.mixpanel.android.a.e.a parama, h paramh)
  {
    if ((parama.b("WebSocket-Origin").equals(paramh.b("Origin"))) && (a(paramh)))
      return a.b.a;
    return a.b.b;
  }

  public com.mixpanel.android.a.e.b a(com.mixpanel.android.a.e.b paramb)
    throws com.mixpanel.android.a.c.d
  {
    paramb.a("Upgrade", "WebSocket");
    paramb.a("Connection", "Upgrade");
    if (!paramb.c("Origin"))
      paramb.a("Origin", "random" + this.i.nextInt());
    return paramb;
  }

  public com.mixpanel.android.a.e.c a(com.mixpanel.android.a.e.a parama, i parami)
    throws com.mixpanel.android.a.c.d
  {
    parami.a("Web Socket Protocol Handshake");
    parami.a("Upgrade", "WebSocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("WebSocket-Origin", parama.b("Origin"));
    parami.a("WebSocket-Location", "ws://" + parama.b("Host") + parama.a());
    return parami;
  }

  public ByteBuffer a(com.mixpanel.android.a.d.d paramd)
  {
    if (paramd.f() != d.a.b)
      throw new RuntimeException("only text frames supported");
    ByteBuffer localByteBuffer1 = paramd.c();
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(2 + localByteBuffer1.remaining());
    localByteBuffer2.put((byte)0);
    localByteBuffer1.mark();
    localByteBuffer2.put(localByteBuffer1);
    localByteBuffer1.reset();
    localByteBuffer2.put((byte)-1);
    localByteBuffer2.flip();
    return localByteBuffer2;
  }

  public void a()
  {
    this.f = false;
    this.h = null;
  }

  public a.a b()
  {
    return a.a.a;
  }

  public a c()
  {
    return new d();
  }

  public List<com.mixpanel.android.a.d.d> c(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.b
  {
    List localList = e(paramByteBuffer);
    if (localList == null)
      throw new com.mixpanel.android.a.c.b(1002);
    return localList;
  }

  public ByteBuffer d()
  {
    return ByteBuffer.allocate(b);
  }

  protected List<com.mixpanel.android.a.d.d> e(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.b
  {
    while (paramByteBuffer.hasRemaining())
    {
      byte b = paramByteBuffer.get();
      if (b == 0)
      {
        if (this.f)
          throw new com.mixpanel.android.a.c.c("unexpected START_OF_FRAME");
        this.f = true;
      }
      else if (b == -1)
      {
        if (!this.f)
          throw new com.mixpanel.android.a.c.c("unexpected END_OF_FRAME");
        if (this.h != null)
        {
          this.h.flip();
          com.mixpanel.android.a.d.e locale = new com.mixpanel.android.a.d.e();
          locale.a(this.h);
          locale.a(true);
          locale.a(d.a.b);
          this.g.add(locale);
          this.h = null;
          paramByteBuffer.mark();
        }
        this.f = false;
      }
      else
      {
        boolean bool = this.f;
        localList = null;
        if (!bool)
          break label221;
        if (this.h == null)
          this.h = d();
        while (true)
        {
          this.h.put(b);
          break;
          if (!this.h.hasRemaining())
            this.h = f(this.h);
        }
      }
    }
    List localList = this.g;
    this.g = new LinkedList();
    label221: return localList;
  }

  public ByteBuffer f(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.e, com.mixpanel.android.a.c.b
  {
    paramByteBuffer.flip();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(a(2 * paramByteBuffer.capacity()));
    localByteBuffer.put(paramByteBuffer);
    return localByteBuffer;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.b.d
 * JD-Core Version:    0.6.2
 */