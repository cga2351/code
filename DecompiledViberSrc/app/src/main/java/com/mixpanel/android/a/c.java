package com.mixpanel.android.a;

import android.annotation.SuppressLint;
import com.mixpanel.android.a.b.e;
import com.mixpanel.android.a.c.g;
import com.mixpanel.android.a.d.d.a;
import com.mixpanel.android.a.e.f;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@SuppressLint({"Assert"})
public class c
  implements a
{
  public static int a;
  public static boolean b;
  public static final List<com.mixpanel.android.a.b.a> c;
  public SelectionKey d;
  public ByteChannel e;
  public final BlockingQueue<ByteBuffer> f;
  public final BlockingQueue<ByteBuffer> g;
  private volatile boolean i = false;
  private a.a j = a.a.a;
  private final d k;
  private List<com.mixpanel.android.a.b.a> l;
  private com.mixpanel.android.a.b.a m = null;
  private a.b n;
  private d.a o = null;
  private ByteBuffer p = ByteBuffer.allocate(0);
  private com.mixpanel.android.a.e.a q = null;
  private String r = null;
  private Integer s = null;
  private Boolean t = null;
  private String u = null;

  static
  {
    if (!c.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      h = bool;
      a = 16384;
      b = false;
      c = new ArrayList(4);
      c.add(new com.mixpanel.android.a.b.c());
      c.add(new com.mixpanel.android.a.b.b());
      c.add(new e());
      c.add(new com.mixpanel.android.a.b.d());
      return;
    }
  }

  public c(d paramd, com.mixpanel.android.a.b.a parama)
  {
    if ((paramd == null) || ((parama == null) && (this.n == a.b.b)))
      throw new IllegalArgumentException("parameters must not be null");
    this.f = new LinkedBlockingQueue();
    this.g = new LinkedBlockingQueue();
    this.k = paramd;
    this.n = a.b.a;
    if (parama != null)
      this.m = parama.c();
  }

  private void a(f paramf)
  {
    if (b)
      System.out.println("open using draft: " + this.m.getClass().getSimpleName());
    this.j = a.a.c;
    try
    {
      this.k.a(this, paramf);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.k.a(this, localRuntimeException);
    }
  }

  private void a(Collection<com.mixpanel.android.a.d.d> paramCollection)
  {
    if (!c())
      throw new g();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      a((com.mixpanel.android.a.d.d)localIterator.next());
  }

  private void a(List<ByteBuffer> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      e((ByteBuffer)localIterator.next());
  }

  // ERROR //
  private boolean b(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   4: invokevirtual 236	java/nio/ByteBuffer:capacity	()I
    //   7: ifne +70 -> 77
    //   10: aload_1
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 240	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   18: pop
    //   19: aload_0
    //   20: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   23: ifnonnull +211 -> 234
    //   26: aload_0
    //   27: aload 4
    //   29: invokespecial 243	com/mixpanel/android/a/c:d	(Ljava/nio/ByteBuffer;)Lcom/mixpanel/android/a/b/a$b;
    //   32: astore 30
    //   34: getstatic 248	com/mixpanel/android/a/b/a$b:a	Lcom/mixpanel/android/a/b/a$b;
    //   37: astore 31
    //   39: aload 30
    //   41: aload 31
    //   43: if_acmpne +191 -> 234
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   51: aload_0
    //   52: invokeinterface 251 2 0
    //   57: invokestatic 256	com/mixpanel/android/a/f/b:a	(Ljava/lang/String;)[B
    //   60: invokestatic 260	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   63: invokespecial 225	com/mixpanel/android/a/c:e	(Ljava/nio/ByteBuffer;)V
    //   66: aload_0
    //   67: bipush 253
    //   69: ldc_w 262
    //   72: invokevirtual 265	com/mixpanel/android/a/c:a	(ILjava/lang/String;)V
    //   75: iconst_0
    //   76: ireturn
    //   77: aload_0
    //   78: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   81: invokevirtual 268	java/nio/ByteBuffer:remaining	()I
    //   84: aload_1
    //   85: invokevirtual 268	java/nio/ByteBuffer:remaining	()I
    //   88: if_icmpge +44 -> 132
    //   91: aload_0
    //   92: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   95: invokevirtual 236	java/nio/ByteBuffer:capacity	()I
    //   98: aload_1
    //   99: invokevirtual 268	java/nio/ByteBuffer:remaining	()I
    //   102: iadd
    //   103: invokestatic 109	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   106: astore 33
    //   108: aload_0
    //   109: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   112: invokevirtual 271	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   115: pop
    //   116: aload 33
    //   118: aload_0
    //   119: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   122: invokevirtual 275	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   125: pop
    //   126: aload_0
    //   127: aload 33
    //   129: putfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   132: aload_0
    //   133: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   136: aload_1
    //   137: invokevirtual 275	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   140: pop
    //   141: aload_0
    //   142: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   145: invokevirtual 271	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   148: pop
    //   149: aload_0
    //   150: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   153: astore 4
    //   155: goto -142 -> 13
    //   158: astore 32
    //   160: aload_0
    //   161: sipush 1006
    //   164: ldc_w 277
    //   167: iconst_1
    //   168: invokespecial 280	com/mixpanel/android/a/c:c	(ILjava/lang/String;Z)V
    //   171: goto -96 -> 75
    //   174: astore 6
    //   176: aload_0
    //   177: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   180: invokevirtual 236	java/nio/ByteBuffer:capacity	()I
    //   183: ifne +606 -> 789
    //   186: aload 4
    //   188: invokevirtual 283	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   191: pop
    //   192: aload 6
    //   194: invokevirtual 285	com/mixpanel/android/a/c/a:a	()I
    //   197: istore 10
    //   199: iload 10
    //   201: ifne +561 -> 762
    //   204: bipush 16
    //   206: aload 4
    //   208: invokevirtual 236	java/nio/ByteBuffer:capacity	()I
    //   211: iadd
    //   212: istore 10
    //   214: aload_0
    //   215: iload 10
    //   217: invokestatic 109	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   220: putfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   223: aload_0
    //   224: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   227: aload_1
    //   228: invokevirtual 275	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   231: pop
    //   232: iconst_0
    //   233: ireturn
    //   234: aload_0
    //   235: getfield 123	com/mixpanel/android/a/c:n	Lcom/mixpanel/android/a/a$b;
    //   238: getstatic 127	com/mixpanel/android/a/a$b:b	Lcom/mixpanel/android/a/a$b;
    //   241: if_acmpne +314 -> 555
    //   244: aload_0
    //   245: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   248: ifnonnull +233 -> 481
    //   251: aload_0
    //   252: getfield 287	com/mixpanel/android/a/c:l	Ljava/util/List;
    //   255: invokeinterface 222 1 0
    //   260: astore 21
    //   262: aload 21
    //   264: invokeinterface 211 1 0
    //   269: ifeq +192 -> 461
    //   272: aload 21
    //   274: invokeinterface 215 1 0
    //   279: checkcast 147	com/mixpanel/android/a/b/a
    //   282: invokevirtual 150	com/mixpanel/android/a/b/a:c	()Lcom/mixpanel/android/a/b/a;
    //   285: astore 22
    //   287: aload 22
    //   289: aload_0
    //   290: getfield 123	com/mixpanel/android/a/c:n	Lcom/mixpanel/android/a/a$b;
    //   293: invokevirtual 290	com/mixpanel/android/a/b/a:a	(Lcom/mixpanel/android/a/a$b;)V
    //   296: aload 4
    //   298: invokevirtual 283	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   301: pop
    //   302: aload 22
    //   304: aload 4
    //   306: invokevirtual 293	com/mixpanel/android/a/b/a:d	(Ljava/nio/ByteBuffer;)Lcom/mixpanel/android/a/e/f;
    //   309: astore 25
    //   311: aload 25
    //   313: instanceof 295
    //   316: ifne +16 -> 332
    //   319: aload_0
    //   320: sipush 1002
    //   323: ldc_w 297
    //   326: iconst_0
    //   327: invokevirtual 299	com/mixpanel/android/a/c:b	(ILjava/lang/String;Z)V
    //   330: iconst_0
    //   331: ireturn
    //   332: aload 25
    //   334: checkcast 295	com/mixpanel/android/a/e/a
    //   337: astore 26
    //   339: aload 22
    //   341: aload 26
    //   343: invokevirtual 302	com/mixpanel/android/a/b/a:a	(Lcom/mixpanel/android/a/e/a;)Lcom/mixpanel/android/a/b/a$b;
    //   346: getstatic 248	com/mixpanel/android/a/b/a$b:a	Lcom/mixpanel/android/a/b/a$b;
    //   349: if_acmpne -87 -> 262
    //   352: aload_0
    //   353: aload 26
    //   355: invokeinterface 304 1 0
    //   360: putfield 121	com/mixpanel/android/a/c:u	Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   367: aload_0
    //   368: aload 22
    //   370: aload 26
    //   372: invokeinterface 307 4 0
    //   377: astore 29
    //   379: aload_0
    //   380: aload 22
    //   382: aload 22
    //   384: aload 26
    //   386: aload 29
    //   388: invokevirtual 310	com/mixpanel/android/a/b/a:a	(Lcom/mixpanel/android/a/e/a;Lcom/mixpanel/android/a/e/i;)Lcom/mixpanel/android/a/e/c;
    //   391: aload_0
    //   392: getfield 123	com/mixpanel/android/a/c:n	Lcom/mixpanel/android/a/a$b;
    //   395: invokevirtual 313	com/mixpanel/android/a/b/a:a	(Lcom/mixpanel/android/a/e/f;Lcom/mixpanel/android/a/a$b;)Ljava/util/List;
    //   398: invokespecial 315	com/mixpanel/android/a/c:a	(Ljava/util/List;)V
    //   401: aload_0
    //   402: aload 22
    //   404: putfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   407: aload_0
    //   408: aload 26
    //   410: invokespecial 317	com/mixpanel/android/a/c:a	(Lcom/mixpanel/android/a/e/f;)V
    //   413: iconst_1
    //   414: ireturn
    //   415: astore 28
    //   417: aload_0
    //   418: aload 28
    //   420: invokevirtual 318	com/mixpanel/android/a/c/b:a	()I
    //   423: aload 28
    //   425: invokevirtual 321	com/mixpanel/android/a/c/b:getMessage	()Ljava/lang/String;
    //   428: iconst_0
    //   429: invokevirtual 299	com/mixpanel/android/a/c:b	(ILjava/lang/String;Z)V
    //   432: iconst_0
    //   433: ireturn
    //   434: astore 27
    //   436: aload_0
    //   437: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   440: aload_0
    //   441: aload 27
    //   443: invokeinterface 194 3 0
    //   448: aload_0
    //   449: iconst_m1
    //   450: aload 27
    //   452: invokevirtual 322	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   455: iconst_0
    //   456: invokevirtual 299	com/mixpanel/android/a/c:b	(ILjava/lang/String;Z)V
    //   459: iconst_0
    //   460: ireturn
    //   461: aload_0
    //   462: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   465: ifnonnull +362 -> 827
    //   468: aload_0
    //   469: sipush 1002
    //   472: ldc_w 324
    //   475: invokevirtual 265	com/mixpanel/android/a/c:a	(ILjava/lang/String;)V
    //   478: goto +349 -> 827
    //   481: aload_0
    //   482: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   485: aload 4
    //   487: invokevirtual 293	com/mixpanel/android/a/b/a:d	(Ljava/nio/ByteBuffer;)Lcom/mixpanel/android/a/e/f;
    //   490: astore 19
    //   492: aload 19
    //   494: instanceof 295
    //   497: ifne +16 -> 513
    //   500: aload_0
    //   501: sipush 1002
    //   504: ldc_w 297
    //   507: iconst_0
    //   508: invokevirtual 299	com/mixpanel/android/a/c:b	(ILjava/lang/String;Z)V
    //   511: iconst_0
    //   512: ireturn
    //   513: aload 19
    //   515: checkcast 295	com/mixpanel/android/a/e/a
    //   518: astore 20
    //   520: aload_0
    //   521: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   524: aload 20
    //   526: invokevirtual 302	com/mixpanel/android/a/b/a:a	(Lcom/mixpanel/android/a/e/a;)Lcom/mixpanel/android/a/b/a$b;
    //   529: getstatic 248	com/mixpanel/android/a/b/a$b:a	Lcom/mixpanel/android/a/b/a$b;
    //   532: if_acmpne +11 -> 543
    //   535: aload_0
    //   536: aload 20
    //   538: invokespecial 317	com/mixpanel/android/a/c:a	(Lcom/mixpanel/android/a/e/f;)V
    //   541: iconst_1
    //   542: ireturn
    //   543: aload_0
    //   544: sipush 1002
    //   547: ldc_w 326
    //   550: invokevirtual 265	com/mixpanel/android/a/c:a	(ILjava/lang/String;)V
    //   553: iconst_0
    //   554: ireturn
    //   555: aload_0
    //   556: getfield 123	com/mixpanel/android/a/c:n	Lcom/mixpanel/android/a/a$b;
    //   559: getstatic 145	com/mixpanel/android/a/a$b:a	Lcom/mixpanel/android/a/a$b;
    //   562: if_acmpne -330 -> 232
    //   565: aload_0
    //   566: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   569: aload_0
    //   570: getfield 123	com/mixpanel/android/a/c:n	Lcom/mixpanel/android/a/a$b;
    //   573: invokevirtual 290	com/mixpanel/android/a/b/a:a	(Lcom/mixpanel/android/a/a$b;)V
    //   576: aload_0
    //   577: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   580: aload 4
    //   582: invokevirtual 293	com/mixpanel/android/a/b/a:d	(Ljava/nio/ByteBuffer;)Lcom/mixpanel/android/a/e/f;
    //   585: astore 13
    //   587: aload 13
    //   589: instanceof 328
    //   592: ifne +16 -> 608
    //   595: aload_0
    //   596: sipush 1002
    //   599: ldc_w 297
    //   602: iconst_0
    //   603: invokevirtual 299	com/mixpanel/android/a/c:b	(ILjava/lang/String;Z)V
    //   606: iconst_0
    //   607: ireturn
    //   608: aload 13
    //   610: checkcast 328	com/mixpanel/android/a/e/h
    //   613: astore 14
    //   615: aload_0
    //   616: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   619: aload_0
    //   620: getfield 113	com/mixpanel/android/a/c:q	Lcom/mixpanel/android/a/e/a;
    //   623: aload 14
    //   625: invokevirtual 331	com/mixpanel/android/a/b/a:a	(Lcom/mixpanel/android/a/e/a;Lcom/mixpanel/android/a/e/h;)Lcom/mixpanel/android/a/b/a$b;
    //   628: astore 15
    //   630: getstatic 248	com/mixpanel/android/a/b/a$b:a	Lcom/mixpanel/android/a/b/a$b;
    //   633: astore 16
    //   635: aload 15
    //   637: aload 16
    //   639: if_acmpne +73 -> 712
    //   642: aload_0
    //   643: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   646: aload_0
    //   647: aload_0
    //   648: getfield 113	com/mixpanel/android/a/c:q	Lcom/mixpanel/android/a/e/a;
    //   651: aload 14
    //   653: invokeinterface 334 4 0
    //   658: aload_0
    //   659: aload 14
    //   661: invokespecial 317	com/mixpanel/android/a/c:a	(Lcom/mixpanel/android/a/e/f;)V
    //   664: iconst_1
    //   665: ireturn
    //   666: astore 18
    //   668: aload_0
    //   669: aload 18
    //   671: invokevirtual 318	com/mixpanel/android/a/c/b:a	()I
    //   674: aload 18
    //   676: invokevirtual 321	com/mixpanel/android/a/c/b:getMessage	()Ljava/lang/String;
    //   679: iconst_0
    //   680: invokevirtual 299	com/mixpanel/android/a/c:b	(ILjava/lang/String;Z)V
    //   683: iconst_0
    //   684: ireturn
    //   685: astore 17
    //   687: aload_0
    //   688: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   691: aload_0
    //   692: aload 17
    //   694: invokeinterface 194 3 0
    //   699: aload_0
    //   700: iconst_m1
    //   701: aload 17
    //   703: invokevirtual 322	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   706: iconst_0
    //   707: invokevirtual 299	com/mixpanel/android/a/c:b	(ILjava/lang/String;Z)V
    //   710: iconst_0
    //   711: ireturn
    //   712: aload_0
    //   713: sipush 1002
    //   716: new 161	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   723: ldc_w 336
    //   726: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload_0
    //   730: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   733: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   736: ldc_w 341
    //   739: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokevirtual 265	com/mixpanel/android/a/c:a	(ILjava/lang/String;)V
    //   748: goto -516 -> 232
    //   751: astore 12
    //   753: aload_0
    //   754: aload 12
    //   756: invokevirtual 344	com/mixpanel/android/a/c:a	(Lcom/mixpanel/android/a/c/b;)V
    //   759: goto -527 -> 232
    //   762: getstatic 58	com/mixpanel/android/a/c:h	Z
    //   765: ifne -551 -> 214
    //   768: aload 6
    //   770: invokevirtual 285	com/mixpanel/android/a/c/a:a	()I
    //   773: aload 4
    //   775: invokevirtual 268	java/nio/ByteBuffer:remaining	()I
    //   778: if_icmpge -564 -> 214
    //   781: new 346	java/lang/AssertionError
    //   784: dup
    //   785: invokespecial 347	java/lang/AssertionError:<init>	()V
    //   788: athrow
    //   789: aload_0
    //   790: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   793: aload_0
    //   794: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   797: invokevirtual 350	java/nio/ByteBuffer:limit	()I
    //   800: invokevirtual 354	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   803: pop
    //   804: aload_0
    //   805: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   808: aload_0
    //   809: getfield 111	com/mixpanel/android/a/c:p	Ljava/nio/ByteBuffer;
    //   812: invokevirtual 236	java/nio/ByteBuffer:capacity	()I
    //   815: invokevirtual 356	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   818: pop
    //   819: goto -587 -> 232
    //   822: astore 23
    //   824: goto -562 -> 262
    //   827: iconst_0
    //   828: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   46	75	158	com/mixpanel/android/a/c/b
    //   19	39	174	com/mixpanel/android/a/c/a
    //   46	75	174	com/mixpanel/android/a/c/a
    //   160	171	174	com/mixpanel/android/a/c/a
    //   234	262	174	com/mixpanel/android/a/c/a
    //   262	287	174	com/mixpanel/android/a/c/a
    //   287	330	174	com/mixpanel/android/a/c/a
    //   332	363	174	com/mixpanel/android/a/c/a
    //   363	379	174	com/mixpanel/android/a/c/a
    //   379	413	174	com/mixpanel/android/a/c/a
    //   417	432	174	com/mixpanel/android/a/c/a
    //   436	459	174	com/mixpanel/android/a/c/a
    //   461	478	174	com/mixpanel/android/a/c/a
    //   481	511	174	com/mixpanel/android/a/c/a
    //   513	541	174	com/mixpanel/android/a/c/a
    //   543	553	174	com/mixpanel/android/a/c/a
    //   555	606	174	com/mixpanel/android/a/c/a
    //   608	635	174	com/mixpanel/android/a/c/a
    //   642	658	174	com/mixpanel/android/a/c/a
    //   658	664	174	com/mixpanel/android/a/c/a
    //   668	683	174	com/mixpanel/android/a/c/a
    //   687	710	174	com/mixpanel/android/a/c/a
    //   712	748	174	com/mixpanel/android/a/c/a
    //   753	759	174	com/mixpanel/android/a/c/a
    //   363	379	415	com/mixpanel/android/a/c/b
    //   363	379	434	java/lang/RuntimeException
    //   642	658	666	com/mixpanel/android/a/c/b
    //   642	658	685	java/lang/RuntimeException
    //   234	262	751	com/mixpanel/android/a/c/d
    //   262	287	751	com/mixpanel/android/a/c/d
    //   461	478	751	com/mixpanel/android/a/c/d
    //   481	511	751	com/mixpanel/android/a/c/d
    //   513	541	751	com/mixpanel/android/a/c/d
    //   543	553	751	com/mixpanel/android/a/c/d
    //   555	606	751	com/mixpanel/android/a/c/d
    //   608	635	751	com/mixpanel/android/a/c/d
    //   642	658	751	com/mixpanel/android/a/c/d
    //   658	664	751	com/mixpanel/android/a/c/d
    //   668	683	751	com/mixpanel/android/a/c/d
    //   687	710	751	com/mixpanel/android/a/c/d
    //   712	748	751	com/mixpanel/android/a/c/d
    //   287	330	822	com/mixpanel/android/a/c/d
    //   332	363	822	com/mixpanel/android/a/c/d
    //   363	379	822	com/mixpanel/android/a/c/d
    //   379	413	822	com/mixpanel/android/a/c/d
    //   417	432	822	com/mixpanel/android/a/c/d
    //   436	459	822	com/mixpanel/android/a/c/d
  }

  private void c(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.j != a.a.d) && (this.j != a.a.e))
    {
      if (this.j != a.a.c)
        break label191;
      if (paramInt == 1006)
      {
        if ((!h) && (paramBoolean))
          throw new AssertionError();
        this.j = a.a.d;
        b(paramInt, paramString, false);
      }
    }
    else
    {
      return;
    }
    if ((this.m.b() == com.mixpanel.android.a.b.a.a.a) || (!paramBoolean));
    while (true)
    {
      try
      {
        this.k.a(this, paramInt, paramString);
        a(new com.mixpanel.android.a.d.b(paramInt, paramString));
        b(paramInt, paramString, paramBoolean);
        if (paramInt == 1002)
          b(paramInt, paramString, paramBoolean);
        this.j = a.a.d;
        this.p = null;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.k.a(this, localRuntimeException);
        continue;
      }
      catch (com.mixpanel.android.a.c.b localb)
      {
        this.k.a(this, localb);
        b(1006, "generated frame is invalid", false);
        continue;
      }
      label191: if (paramInt == -3)
      {
        if ((!h) && (!paramBoolean))
          throw new AssertionError();
        b(-3, paramString, true);
      }
      else
      {
        b(-1, paramString, false);
      }
    }
  }

  private void c(ByteBuffer paramByteBuffer)
  {
    label520: 
    while (true)
    {
      com.mixpanel.android.a.d.d locald;
      d.a locala1;
      boolean bool;
      int i1;
      String str;
      try
      {
        Iterator localIterator = this.m.c(paramByteBuffer).iterator();
        if (localIterator.hasNext())
        {
          locald = (com.mixpanel.android.a.d.d)localIterator.next();
          if (b)
            System.out.println("matched frame: " + locald);
          locala1 = locald.f();
          bool = locald.d();
          if (locala1 != d.a.f)
            break label203;
          if (!(locald instanceof com.mixpanel.android.a.d.a))
            break label520;
          com.mixpanel.android.a.d.a locala = (com.mixpanel.android.a.d.a)locald;
          i1 = locala.a();
          str = locala.b();
          if (this.j != a.a.d)
            break label166;
          a(i1, str, true);
          continue;
        }
      }
      catch (com.mixpanel.android.a.c.b localb)
      {
        this.k.a(this, localb);
        a(localb);
      }
      return;
      label166: if (this.m.b() == com.mixpanel.android.a.b.a.a.c)
      {
        c(i1, str, true);
      }
      else
      {
        b(i1, str, false);
        continue;
        label203: if (locala1 == d.a.d)
        {
          this.k.b(this, locald);
        }
        else if (locala1 == d.a.e)
        {
          this.k.c(this, locald);
        }
        else
        {
          if ((!bool) || (locala1 == d.a.a))
          {
            if (locala1 != d.a.a)
            {
              if (this.o != null)
                throw new com.mixpanel.android.a.c.b(1002, "Previous continuous frame sequence not completed.");
              this.o = locala1;
            }
            label363: 
            do
              while (true)
              {
                try
                {
                  this.k.a(this, locald);
                }
                catch (RuntimeException localRuntimeException1)
                {
                  this.k.a(this, localRuntimeException1);
                }
                break;
                if (!bool)
                  break label363;
                if (this.o == null)
                  throw new com.mixpanel.android.a.c.b(1002, "Continuous frame sequence was not started.");
                this.o = null;
              }
            while (this.o != null);
            throw new com.mixpanel.android.a.c.b(1002, "Continuous frame sequence was not started.");
          }
          if (this.o != null)
            throw new com.mixpanel.android.a.c.b(1002, "Continuous frame sequence not completed.");
          d.a locala2 = d.a.b;
          if (locala1 == locala2)
          {
            try
            {
              this.k.a(this, com.mixpanel.android.a.f.b.a(locald.c()));
            }
            catch (RuntimeException localRuntimeException3)
            {
              this.k.a(this, localRuntimeException3);
            }
          }
          else
          {
            d.a locala3 = d.a.c;
            if (locala1 == locala3)
            {
              try
              {
                this.k.a(this, locald.c());
              }
              catch (RuntimeException localRuntimeException2)
              {
                this.k.a(this, localRuntimeException2);
              }
            }
            else
            {
              throw new com.mixpanel.android.a.c.b(1002, "non control or continious frame expected");
              str = "";
              i1 = 1005;
            }
          }
        }
      }
    }
  }

  private com.mixpanel.android.a.b.a.b d(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.a
  {
    paramByteBuffer.mark();
    if (paramByteBuffer.limit() > com.mixpanel.android.a.b.a.c.length)
      return com.mixpanel.android.a.b.a.b.b;
    if (paramByteBuffer.limit() < com.mixpanel.android.a.b.a.c.length)
      throw new com.mixpanel.android.a.c.a(com.mixpanel.android.a.b.a.c.length);
    for (int i1 = 0; paramByteBuffer.hasRemaining(); i1++)
      if (com.mixpanel.android.a.b.a.c[i1] != paramByteBuffer.get())
      {
        paramByteBuffer.reset();
        return com.mixpanel.android.a.b.a.b.b;
      }
    return com.mixpanel.android.a.b.a.b.a;
  }

  private void e(ByteBuffer paramByteBuffer)
  {
    PrintStream localPrintStream;
    StringBuilder localStringBuilder;
    if (b)
    {
      localPrintStream = System.out;
      localStringBuilder = new StringBuilder().append("write(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() <= 1000)
        break label95;
    }
    label95: for (String str = "too big to display"; ; str = new String(paramByteBuffer.array()))
    {
      localPrintStream.println(str + "}");
      this.f.add(paramByteBuffer);
      this.k.b(this);
      return;
    }
  }

  public InetSocketAddress a()
  {
    return this.k.c(this);
  }

  public void a(int paramInt, String paramString)
  {
    c(paramInt, paramString, false);
  }

  // ERROR //
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	com/mixpanel/android/a/c:j	Lcom/mixpanel/android/a/a$a;
    //   6: astore 5
    //   8: getstatic 360	com/mixpanel/android/a/a$a:e	Lcom/mixpanel/android/a/a$a;
    //   11: astore 6
    //   13: aload 5
    //   15: aload 6
    //   17: if_acmpne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 485	com/mixpanel/android/a/c:d	Ljava/nio/channels/SelectionKey;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 485	com/mixpanel/android/a/c:d	Ljava/nio/channels/SelectionKey;
    //   34: invokevirtual 490	java/nio/channels/SelectionKey:cancel	()V
    //   37: aload_0
    //   38: getfield 492	com/mixpanel/android/a/c:e	Ljava/nio/channels/ByteChannel;
    //   41: astore 7
    //   43: aload 7
    //   45: ifnull +12 -> 57
    //   48: aload_0
    //   49: getfield 492	com/mixpanel/android/a/c:e	Ljava/nio/channels/ByteChannel;
    //   52: invokeinterface 497 1 0
    //   57: aload_0
    //   58: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   61: aload_0
    //   62: iload_1
    //   63: aload_2
    //   64: iload_3
    //   65: invokeinterface 500 5 0
    //   70: aload_0
    //   71: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   81: invokevirtual 502	com/mixpanel/android/a/b/a:a	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 113	com/mixpanel/android/a/c:q	Lcom/mixpanel/android/a/e/a;
    //   89: aload_0
    //   90: getstatic 360	com/mixpanel/android/a/a$a:e	Lcom/mixpanel/android/a/a$a;
    //   93: putfield 99	com/mixpanel/android/a/c:j	Lcom/mixpanel/android/a/a$a;
    //   96: aload_0
    //   97: getfield 139	com/mixpanel/android/a/c:f	Ljava/util/concurrent/BlockingQueue;
    //   100: invokeinterface 505 1 0
    //   105: goto -85 -> 20
    //   108: astore 4
    //   110: aload_0
    //   111: monitorexit
    //   112: aload 4
    //   114: athrow
    //   115: astore 9
    //   117: aload_0
    //   118: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   121: aload_0
    //   122: aload 9
    //   124: invokeinterface 194 3 0
    //   129: goto -72 -> 57
    //   132: astore 8
    //   134: aload_0
    //   135: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   138: aload_0
    //   139: aload 8
    //   141: invokeinterface 194 3 0
    //   146: goto -76 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	108	finally
    //   23	37	108	finally
    //   37	43	108	finally
    //   48	57	108	finally
    //   57	70	108	finally
    //   70	84	108	finally
    //   84	105	108	finally
    //   117	129	108	finally
    //   134	146	108	finally
    //   48	57	115	java/io/IOException
    //   57	70	132	java/lang/RuntimeException
  }

  protected void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, "", paramBoolean);
  }

  public void a(com.mixpanel.android.a.c.b paramb)
  {
    c(paramb.a(), paramb.getMessage(), false);
  }

  public void a(d.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    a(this.m.a(parama, paramByteBuffer, paramBoolean));
  }

  public void a(com.mixpanel.android.a.d.d paramd)
  {
    if (b)
      System.out.println("send frame: " + paramd);
    e(this.m.a(paramd));
  }

  public void a(com.mixpanel.android.a.e.b paramb)
    throws com.mixpanel.android.a.c.d
  {
    if ((!h) && (this.j == a.a.b))
      throw new AssertionError("shall only be called once");
    this.q = this.m.a(paramb);
    this.u = paramb.a();
    if ((!h) && (this.u == null))
      throw new AssertionError();
    try
    {
      this.k.a(this, this.q);
      a(this.m.a(this.q, this.n));
      return;
    }
    catch (com.mixpanel.android.a.c.b localb)
    {
      throw new com.mixpanel.android.a.c.d("Handshake data rejected by client.");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.k.a(this, localRuntimeException);
      throw new com.mixpanel.android.a.c.d("rejected because of" + localRuntimeException);
    }
  }

  public void a(ByteBuffer paramByteBuffer)
  {
    if ((!h) && (!paramByteBuffer.hasRemaining()))
      throw new AssertionError();
    String str;
    if (b)
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder().append("process(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() > 1000)
      {
        str = "too big to display";
        localPrintStream.println(str + "}");
      }
    }
    else
    {
      if (this.j == a.a.a)
        break label166;
      c(paramByteBuffer);
    }
    while (true)
    {
      if ((h) || (d()) || (e()) || (!paramByteBuffer.hasRemaining()))
        return;
      throw new AssertionError();
      str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
      break;
      label166: if (b(paramByteBuffer))
      {
        if ((!h) && (this.p.hasRemaining() == paramByteBuffer.hasRemaining()) && (paramByteBuffer.hasRemaining()))
          throw new AssertionError();
        if (paramByteBuffer.hasRemaining())
          c(paramByteBuffer);
        else if (this.p.hasRemaining())
          c(this.p);
      }
    }
  }

  public void b()
  {
    if (g() == a.a.a)
    {
      a(-1, true);
      return;
    }
    if (this.i)
    {
      a(this.s.intValue(), this.r, this.t.booleanValue());
      return;
    }
    if (this.m.b() == com.mixpanel.android.a.b.a.a.a)
    {
      a(1000, true);
      return;
    }
    if (this.m.b() == com.mixpanel.android.a.b.a.a.b)
    {
      if (this.n == a.b.b)
      {
        a(1006, true);
        return;
      }
      a(1000, true);
      return;
    }
    a(1006, true);
  }

  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, false);
  }

  // ERROR //
  protected void b(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/mixpanel/android/a/c:i	Z
    //   6: istore 5
    //   8: iload 5
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic 574	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: putfield 117	com/mixpanel/android/a/c:s	Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 115	com/mixpanel/android/a/c:r	Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic 577	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: putfield 119	com/mixpanel/android/a/c:t	Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 93	com/mixpanel/android/a/c:i	Z
    //   42: aload_0
    //   43: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   46: aload_0
    //   47: invokeinterface 468 2 0
    //   52: aload_0
    //   53: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   56: aload_0
    //   57: iload_1
    //   58: aload_2
    //   59: iload_3
    //   60: invokeinterface 579 5 0
    //   65: aload_0
    //   66: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   69: ifnull +10 -> 79
    //   72: aload_0
    //   73: getfield 101	com/mixpanel/android/a/c:m	Lcom/mixpanel/android/a/b/a;
    //   76: invokevirtual 502	com/mixpanel/android/a/b/a:a	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 113	com/mixpanel/android/a/c:q	Lcom/mixpanel/android/a/e/a;
    //   84: goto -71 -> 13
    //   87: astore 4
    //   89: aload_0
    //   90: monitorexit
    //   91: aload 4
    //   93: athrow
    //   94: astore 6
    //   96: aload_0
    //   97: getfield 143	com/mixpanel/android/a/c:k	Lcom/mixpanel/android/a/d;
    //   100: aload_0
    //   101: aload 6
    //   103: invokeinterface 194 3 0
    //   108: goto -43 -> 65
    //
    // Exception table:
    //   from	to	target	type
    //   2	8	87	finally
    //   16	52	87	finally
    //   52	65	87	finally
    //   65	79	87	finally
    //   79	84	87	finally
    //   96	108	87	finally
    //   52	65	94	java/lang/RuntimeException
  }

  public boolean c()
  {
    if ((h) || (this.j != a.a.c) || (!this.i))
    {
      if (this.j == a.a.c)
        return true;
    }
    else
      throw new AssertionError();
    return false;
  }

  public boolean d()
  {
    return this.j == a.a.d;
  }

  public boolean e()
  {
    return this.i;
  }

  public boolean f()
  {
    return this.j == a.a.e;
  }

  public a.a g()
  {
    return this.j;
  }

  public int hashCode()
  {
    return super.hashCode();
  }

  public String toString()
  {
    return super.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.c
 * JD-Core Version:    0.6.2
 */