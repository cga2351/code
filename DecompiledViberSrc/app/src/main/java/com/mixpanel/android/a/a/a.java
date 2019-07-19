package com.mixpanel.android.a.a;

import android.annotation.SuppressLint;
import com.mixpanel.android.a.b;
import com.mixpanel.android.a.c;
import com.mixpanel.android.a.d.d.a;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.e.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

@SuppressLint({"Assert"})
public abstract class a extends b
  implements com.mixpanel.android.a.a, Runnable
{
  protected URI a = null;
  private c c = null;
  private Socket d = null;
  private InputStream e;
  private OutputStream f;
  private Proxy g = Proxy.NO_PROXY;
  private Thread h;
  private com.mixpanel.android.a.b.a i;
  private Map<String, String> j;
  private CountDownLatch k = new CountDownLatch(1);
  private CountDownLatch l = new CountDownLatch(1);
  private int m = 0;

  static
  {
    if (!a.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      b = bool;
      return;
    }
  }

  public a(URI paramURI, com.mixpanel.android.a.b.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null)
      throw new IllegalArgumentException();
    if (parama == null)
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    this.a = paramURI;
    this.i = parama;
    this.j = paramMap;
    this.m = paramInt;
    this.c = new c(this, parama);
  }

  private int h()
  {
    int n = this.a.getPort();
    String str;
    if (n == -1)
    {
      str = this.a.getScheme();
      if (str.equals("wss"))
        n = 443;
    }
    else
    {
      return n;
    }
    if (str.equals("ws"))
      return 80;
    throw new RuntimeException("unkonow scheme" + str);
  }

  private void i()
    throws com.mixpanel.android.a.c.d
  {
    String str1 = this.a.getPath();
    String str2 = this.a.getQuery();
    if ((str1 == null) || (str1.length() == 0))
      str1 = "/";
    if (str2 != null)
      str1 = str1 + "?" + str2;
    int n = h();
    StringBuilder localStringBuilder = new StringBuilder().append(this.a.getHost());
    if (n != 80);
    com.mixpanel.android.a.e.d locald;
    for (String str3 = ":" + n; ; str3 = "")
    {
      String str4 = str3;
      locald = new com.mixpanel.android.a.e.d();
      locald.a(str1);
      locald.a("Host", str4);
      if (this.j == null)
        break;
      Iterator localIterator = this.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        locald.a((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    this.c.a(locald);
  }

  public InetSocketAddress a()
  {
    return this.c.a();
  }

  public void a(int paramInt, String paramString)
  {
  }

  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
  }

  public void a(com.mixpanel.android.a.a parama, int paramInt, String paramString)
  {
    a(paramInt, paramString);
  }

  public final void a(com.mixpanel.android.a.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    this.k.countDown();
    this.l.countDown();
    if (this.h != null)
      this.h.interrupt();
    try
    {
      if (this.d != null)
        this.d.close();
      b(paramInt, paramString, paramBoolean);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        a(this, localIOException);
    }
  }

  public void a(com.mixpanel.android.a.a parama, com.mixpanel.android.a.d.d paramd)
  {
    b(paramd);
  }

  public final void a(com.mixpanel.android.a.a parama, f paramf)
  {
    this.k.countDown();
    a((h)paramf);
  }

  public final void a(com.mixpanel.android.a.a parama, Exception paramException)
  {
    a(paramException);
  }

  public final void a(com.mixpanel.android.a.a parama, String paramString)
  {
    a(paramString);
  }

  public final void a(com.mixpanel.android.a.a parama, ByteBuffer paramByteBuffer)
  {
    a(paramByteBuffer);
  }

  public void a(d.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this.c.a(parama, paramByteBuffer, paramBoolean);
  }

  public void a(com.mixpanel.android.a.d.d paramd)
  {
    this.c.a(paramd);
  }

  public abstract void a(h paramh);

  public abstract void a(Exception paramException);

  public abstract void a(String paramString);

  public void a(Socket paramSocket)
  {
    if (this.d != null)
      throw new IllegalStateException("socket has already been set");
    this.d = paramSocket;
  }

  public void a(ByteBuffer paramByteBuffer)
  {
  }

  public void b()
  {
    if (this.h != null)
      throw new IllegalStateException("WebSocketClient objects are not reuseable");
    this.h = new Thread(this);
    this.h.start();
  }

  public abstract void b(int paramInt, String paramString, boolean paramBoolean);

  public final void b(com.mixpanel.android.a.a parama)
  {
  }

  public void b(com.mixpanel.android.a.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, paramString, paramBoolean);
  }

  public void b(com.mixpanel.android.a.d.d paramd)
  {
  }

  public InetSocketAddress c(com.mixpanel.android.a.a parama)
  {
    if (this.d != null)
      return (InetSocketAddress)this.d.getLocalSocketAddress();
    return null;
  }

  public boolean c()
    throws InterruptedException
  {
    b();
    this.k.await();
    return this.c.c();
  }

  public boolean d()
  {
    return this.c.c();
  }

  public boolean e()
  {
    return this.c.e();
  }

  public boolean f()
  {
    return this.c.f();
  }

  public boolean g()
  {
    return this.c.d();
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/mixpanel/android/a/a/a:d	Ljava/net/Socket;
    //   4: ifnonnull +189 -> 193
    //   7: aload_0
    //   8: new 223	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 64	com/mixpanel/android/a/a/a:g	Ljava/net/Proxy;
    //   16: invokespecial 300	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 57	com/mixpanel/android/a/a/a:d	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 57	com/mixpanel/android/a/a/a:d	Ljava/net/Socket;
    //   26: invokevirtual 303	java/net/Socket:isBound	()Z
    //   29: ifne +32 -> 61
    //   32: aload_0
    //   33: getfield 57	com/mixpanel/android/a/a/a:d	Ljava/net/Socket;
    //   36: new 279	java/net/InetSocketAddress
    //   39: dup
    //   40: aload_0
    //   41: getfield 53	com/mixpanel/android/a/a/a:a	Ljava/net/URI;
    //   44: invokevirtual 151	java/net/URI:getHost	()Ljava/lang/String;
    //   47: aload_0
    //   48: invokespecial 148	com/mixpanel/android/a/a/a:h	()I
    //   51: invokespecial 306	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   54: aload_0
    //   55: getfield 75	com/mixpanel/android/a/a/a:m	I
    //   58: invokevirtual 310	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 57	com/mixpanel/android/a/a/a:d	Ljava/net/Socket;
    //   66: invokevirtual 314	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   69: putfield 316	com/mixpanel/android/a/a/a:e	Ljava/io/InputStream;
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 57	com/mixpanel/android/a/a/a:d	Ljava/net/Socket;
    //   77: invokevirtual 320	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   80: putfield 96	com/mixpanel/android/a/a/a:f	Ljava/io/OutputStream;
    //   83: aload_0
    //   84: invokespecial 322	com/mixpanel/android/a/a/a:i	()V
    //   87: aload_0
    //   88: new 218	java/lang/Thread
    //   91: dup
    //   92: new 324	com/mixpanel/android/a/a/a$a
    //   95: dup
    //   96: aload_0
    //   97: aconst_null
    //   98: invokespecial 327	com/mixpanel/android/a/a/a$a:<init>	(Lcom/mixpanel/android/a/a/a;Lcom/mixpanel/android/a/a/a$1;)V
    //   101: invokespecial 266	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   104: putfield 216	com/mixpanel/android/a/a/a:h	Ljava/lang/Thread;
    //   107: aload_0
    //   108: getfield 216	com/mixpanel/android/a/a/a:h	Ljava/lang/Thread;
    //   111: invokevirtual 269	java/lang/Thread:start	()V
    //   114: getstatic 329	com/mixpanel/android/a/c:a	I
    //   117: newarray byte
    //   119: astore_2
    //   120: aload_0
    //   121: invokevirtual 330	com/mixpanel/android/a/a/a:f	()Z
    //   124: ifne +110 -> 234
    //   127: aload_0
    //   128: getfield 316	com/mixpanel/android/a/a/a:e	Ljava/io/InputStream;
    //   131: aload_2
    //   132: invokevirtual 336	java/io/InputStream:read	([B)I
    //   135: istore 5
    //   137: iload 5
    //   139: iconst_m1
    //   140: if_icmpeq +94 -> 234
    //   143: aload_0
    //   144: getfield 55	com/mixpanel/android/a/a/a:c	Lcom/mixpanel/android/a/c;
    //   147: aload_2
    //   148: iconst_0
    //   149: iload 5
    //   151: invokestatic 342	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   154: invokevirtual 343	com/mixpanel/android/a/c:a	(Ljava/nio/ByteBuffer;)V
    //   157: goto -37 -> 120
    //   160: astore 4
    //   162: aload_0
    //   163: getfield 55	com/mixpanel/android/a/a/a:c	Lcom/mixpanel/android/a/c;
    //   166: invokevirtual 344	com/mixpanel/android/a/c:b	()V
    //   169: getstatic 47	com/mixpanel/android/a/a/a:b	Z
    //   172: ifne +61 -> 233
    //   175: aload_0
    //   176: getfield 57	com/mixpanel/android/a/a/a:d	Ljava/net/Socket;
    //   179: invokevirtual 347	java/net/Socket:isClosed	()Z
    //   182: ifne +51 -> 233
    //   185: new 349	java/lang/AssertionError
    //   188: dup
    //   189: invokespecial 350	java/lang/AssertionError:<init>	()V
    //   192: athrow
    //   193: aload_0
    //   194: getfield 57	com/mixpanel/android/a/a/a:d	Ljava/net/Socket;
    //   197: invokevirtual 347	java/net/Socket:isClosed	()Z
    //   200: ifeq -178 -> 22
    //   203: new 211	java/io/IOException
    //   206: dup
    //   207: invokespecial 351	java/io/IOException:<init>	()V
    //   210: athrow
    //   211: astore_1
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 55	com/mixpanel/android/a/a/a:c	Lcom/mixpanel/android/a/c;
    //   217: aload_1
    //   218: invokevirtual 231	com/mixpanel/android/a/a/a:a	(Lcom/mixpanel/android/a/a;Ljava/lang/Exception;)V
    //   221: aload_0
    //   222: getfield 55	com/mixpanel/android/a/a/a:c	Lcom/mixpanel/android/a/c;
    //   225: iconst_m1
    //   226: aload_1
    //   227: invokevirtual 354	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 356	com/mixpanel/android/a/c:b	(ILjava/lang/String;)V
    //   233: return
    //   234: aload_0
    //   235: getfield 55	com/mixpanel/android/a/a/a:c	Lcom/mixpanel/android/a/c;
    //   238: invokevirtual 344	com/mixpanel/android/a/c:b	()V
    //   241: goto -72 -> 169
    //   244: astore_3
    //   245: aload_0
    //   246: aload_3
    //   247: invokevirtual 244	com/mixpanel/android/a/a/a:a	(Ljava/lang/Exception;)V
    //   250: aload_0
    //   251: getfield 55	com/mixpanel/android/a/a/a:c	Lcom/mixpanel/android/a/c;
    //   254: sipush 1006
    //   257: aload_3
    //   258: invokevirtual 357	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   261: invokevirtual 356	com/mixpanel/android/a/c:b	(ILjava/lang/String;)V
    //   264: goto -95 -> 169
    //
    // Exception table:
    //   from	to	target	type
    //   120	137	160	java/io/IOException
    //   143	157	160	java/io/IOException
    //   234	241	160	java/io/IOException
    //   0	22	211	java/lang/Exception
    //   22	61	211	java/lang/Exception
    //   61	87	211	java/lang/Exception
    //   193	211	211	java/lang/Exception
    //   120	137	244	java/lang/RuntimeException
    //   143	157	244	java/lang/RuntimeException
    //   234	241	244	java/lang/RuntimeException
  }

  private class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      Thread.currentThread().setName("WebsocketWriteThread");
      try
      {
        while (!Thread.interrupted())
        {
          ByteBuffer localByteBuffer = (ByteBuffer)a.a(a.this).f.take();
          a.b(a.this).write(localByteBuffer.array(), 0, localByteBuffer.limit());
          a.b(a.this).flush();
        }
      }
      catch (IOException localIOException)
      {
        a.a(a.this).b();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.a.a
 * JD-Core Version:    0.6.2
 */