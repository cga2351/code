package com.yandex.mobile.ads.impl;

import java.util.concurrent.BlockingQueue;

public final class og extends Thread
{
  private final BlockingQueue<oi<?>> a;
  private final of b;
  private final ob c;
  private final ol d;
  private volatile boolean e = false;

  public og(BlockingQueue<oi<?>> paramBlockingQueue, of paramof, ob paramob, ol paramol)
  {
    this.a = paramBlockingQueue;
    this.b = paramof;
    this.c = paramob;
    this.d = paramol;
  }

  public final void a()
  {
    this.e = true;
    interrupt();
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 46	android/os/Process:setThreadPriority	(I)V
    //   5: invokestatic 52	android/os/SystemClock:elapsedRealtime	()J
    //   8: lstore_1
    //   9: aload_0
    //   10: getfield 24	com/yandex/mobile/ads/impl/og:a	Ljava/util/concurrent/BlockingQueue;
    //   13: invokeinterface 58 1 0
    //   18: checkcast 60	com/yandex/mobile/ads/impl/oi
    //   21: astore 4
    //   23: aload 4
    //   25: invokevirtual 64	com/yandex/mobile/ads/impl/oi:j	()Z
    //   28: ifeq +57 -> 85
    //   31: aload 4
    //   33: invokevirtual 67	com/yandex/mobile/ads/impl/oi:g	()V
    //   36: goto -31 -> 5
    //   39: astore 8
    //   41: aload 8
    //   43: invokestatic 52	android/os/SystemClock:elapsedRealtime	()J
    //   46: lload_1
    //   47: lsub
    //   48: invokevirtual 70	com/yandex/mobile/ads/impl/ov:a	(J)V
    //   51: aload 4
    //   53: aload 8
    //   55: invokevirtual 73	com/yandex/mobile/ads/impl/oi:a	(Lcom/yandex/mobile/ads/impl/ov;)Lcom/yandex/mobile/ads/impl/ov;
    //   58: astore 9
    //   60: aload_0
    //   61: getfield 30	com/yandex/mobile/ads/impl/og:d	Lcom/yandex/mobile/ads/impl/ol;
    //   64: aload 4
    //   66: aload 9
    //   68: invokeinterface 78 3 0
    //   73: goto -68 -> 5
    //   76: astore_3
    //   77: aload_0
    //   78: getfield 22	com/yandex/mobile/ads/impl/og:e	Z
    //   81: ifeq -76 -> 5
    //   84: return
    //   85: getstatic 84	android/os/Build$VERSION:SDK_INT	I
    //   88: bipush 14
    //   90: if_icmplt +11 -> 101
    //   93: aload 4
    //   95: invokevirtual 88	com/yandex/mobile/ads/impl/oi:f	()I
    //   98: invokestatic 93	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   101: aload_0
    //   102: getfield 26	com/yandex/mobile/ads/impl/og:b	Lcom/yandex/mobile/ads/impl/of;
    //   105: aload 4
    //   107: invokeinterface 98 2 0
    //   112: astore 10
    //   114: aload 10
    //   116: getfield 102	com/yandex/mobile/ads/impl/oh:d	Z
    //   119: ifeq +82 -> 201
    //   122: aload 4
    //   124: invokevirtual 105	com/yandex/mobile/ads/impl/oi:s	()Z
    //   127: ifeq +74 -> 201
    //   130: aload 4
    //   132: invokevirtual 67	com/yandex/mobile/ads/impl/oi:g	()V
    //   135: goto -130 -> 5
    //   138: astore 5
    //   140: iconst_1
    //   141: anewarray 107	java/lang/Object
    //   144: astore 6
    //   146: aload 6
    //   148: iconst_0
    //   149: aload 5
    //   151: invokevirtual 111	java/lang/Exception:toString	()Ljava/lang/String;
    //   154: aastore
    //   155: aload 5
    //   157: ldc 113
    //   159: aload 6
    //   161: invokestatic 118	com/yandex/mobile/ads/impl/on:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: new 38	com/yandex/mobile/ads/impl/ov
    //   167: dup
    //   168: aload 5
    //   170: invokespecial 121	com/yandex/mobile/ads/impl/ov:<init>	(Ljava/lang/Throwable;)V
    //   173: astore 7
    //   175: aload 7
    //   177: invokestatic 52	android/os/SystemClock:elapsedRealtime	()J
    //   180: lload_1
    //   181: lsub
    //   182: invokevirtual 70	com/yandex/mobile/ads/impl/ov:a	(J)V
    //   185: aload_0
    //   186: getfield 30	com/yandex/mobile/ads/impl/og:d	Lcom/yandex/mobile/ads/impl/ol;
    //   189: aload 4
    //   191: aload 7
    //   193: invokeinterface 78 3 0
    //   198: goto -193 -> 5
    //   201: aload 4
    //   203: aload 10
    //   205: invokevirtual 124	com/yandex/mobile/ads/impl/oi:a	(Lcom/yandex/mobile/ads/impl/oh;)Lcom/yandex/mobile/ads/impl/ok;
    //   208: astore 11
    //   210: aload 4
    //   212: invokevirtual 127	com/yandex/mobile/ads/impl/oi:m	()Z
    //   215: ifeq +30 -> 245
    //   218: aload 11
    //   220: getfield 132	com/yandex/mobile/ads/impl/ok:b	Lcom/yandex/mobile/ads/impl/ob$a;
    //   223: ifnull +22 -> 245
    //   226: aload_0
    //   227: getfield 28	com/yandex/mobile/ads/impl/og:c	Lcom/yandex/mobile/ads/impl/ob;
    //   230: aload 4
    //   232: invokevirtual 134	com/yandex/mobile/ads/impl/oi:b	()Ljava/lang/String;
    //   235: aload 11
    //   237: getfield 132	com/yandex/mobile/ads/impl/ok:b	Lcom/yandex/mobile/ads/impl/ob$a;
    //   240: invokeinterface 139 3 0
    //   245: aload 4
    //   247: invokevirtual 142	com/yandex/mobile/ads/impl/oi:r	()V
    //   250: aload_0
    //   251: getfield 30	com/yandex/mobile/ads/impl/og:d	Lcom/yandex/mobile/ads/impl/ol;
    //   254: aload 4
    //   256: aload 11
    //   258: invokeinterface 145 3 0
    //   263: goto -258 -> 5
    //
    // Exception table:
    //   from	to	target	type
    //   23	36	39	com/yandex/mobile/ads/impl/ov
    //   85	101	39	com/yandex/mobile/ads/impl/ov
    //   101	135	39	com/yandex/mobile/ads/impl/ov
    //   201	245	39	com/yandex/mobile/ads/impl/ov
    //   245	263	39	com/yandex/mobile/ads/impl/ov
    //   9	23	76	java/lang/InterruptedException
    //   23	36	138	java/lang/Exception
    //   85	101	138	java/lang/Exception
    //   101	135	138	java/lang/Exception
    //   201	245	138	java/lang/Exception
    //   245	263	138	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.og
 * JD-Core Version:    0.6.2
 */