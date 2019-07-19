package com.viber.voip.messages.controller.b;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.f;
import com.viber.voip.e.a.e;
import com.viber.voip.util.bj;
import com.viber.voip.util.dq;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class a
{
  private static final Logger d = ViberEnv.getLogger();
  private static final Map<String, Lock> e = new HashMap();
  private static final Executor f = av.f.b;
  protected final com.viber.voip.messages.extras.image.c a;
  protected final Context b;
  protected final ContentResolver c;
  private volatile Uri g;

  public a(com.viber.voip.messages.extras.image.c paramc, Context paramContext)
  {
    this.a = paramc;
    this.b = paramContext;
    this.c = paramContext.getContentResolver();
  }

  private Lock a(String paramString)
  {
    try
    {
      Object localObject2 = (Lock)e.get(paramString);
      if (localObject2 == null)
      {
        localObject2 = new ReentrantLock();
        e.put(paramString, localObject2);
      }
      return localObject2;
    }
    finally
    {
    }
  }

  // ERROR //
  private void a(CountDownLatch paramCountDownLatch)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   5: ldc 85
    //   7: ldc 87
    //   9: invokeinterface 92 3 0
    //   14: aload_0
    //   15: invokevirtual 95	com/viber/voip/messages/controller/b/a:b	()Landroid/net/Uri;
    //   18: astore_3
    //   19: aload_0
    //   20: getfield 49	com/viber/voip/messages/controller/b/a:b	Landroid/content/Context;
    //   23: aload_3
    //   24: invokestatic 100	com/viber/voip/util/e/j:a	(Landroid/content/Context;Landroid/net/Uri;)Landroid/graphics/BitmapFactory$Options;
    //   27: astore 4
    //   29: aload 4
    //   31: getfield 106	android/graphics/BitmapFactory$Options:outWidth	I
    //   34: istore 5
    //   36: aload 4
    //   38: getfield 109	android/graphics/BitmapFactory$Options:outHeight	I
    //   41: istore 6
    //   43: iload 5
    //   45: sipush 1280
    //   48: if_icmpgt +11 -> 59
    //   51: iload 6
    //   53: sipush 1280
    //   56: if_icmple +35 -> 91
    //   59: iload_2
    //   60: istore 7
    //   62: iload 7
    //   64: ifne +336 -> 400
    //   67: aload_0
    //   68: getfield 49	com/viber/voip/messages/controller/b/a:b	Landroid/content/Context;
    //   71: aload_3
    //   72: invokestatic 114	com/viber/voip/util/at:a	(Landroid/content/Context;Landroid/net/Uri;)Ljava/io/File;
    //   75: astore 19
    //   77: aload 19
    //   79: ifnonnull +18 -> 97
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 119	java/util/concurrent/CountDownLatch:countDown	()V
    //   90: return
    //   91: iconst_0
    //   92: istore 7
    //   94: goto -32 -> 62
    //   97: aload 19
    //   99: invokevirtual 125	java/io/File:length	()J
    //   102: ldc2_w 126
    //   105: lcmp
    //   106: ifle +137 -> 243
    //   109: aload_0
    //   110: getfield 49	com/viber/voip/messages/controller/b/a:b	Landroid/content/Context;
    //   113: aload_3
    //   114: invokestatic 130	com/viber/voip/util/at:b	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   117: invokestatic 133	com/viber/voip/util/e/j:a	(Ljava/lang/String;)I
    //   120: istore 8
    //   122: aload_0
    //   123: invokevirtual 136	com/viber/voip/messages/controller/b/a:d	()Lcom/viber/voip/util/dv;
    //   126: astore 9
    //   128: new 116	java/util/concurrent/CountDownLatch
    //   131: dup
    //   132: iconst_2
    //   133: invokespecial 139	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   136: astore 10
    //   138: iload 7
    //   140: ifne +12 -> 152
    //   143: iload_2
    //   144: ifne +8 -> 152
    //   147: iload 8
    //   149: ifeq +129 -> 278
    //   152: aload_0
    //   153: getfield 49	com/viber/voip/messages/controller/b/a:b	Landroid/content/Context;
    //   156: iload 5
    //   158: iload 6
    //   160: aload_3
    //   161: aload 9
    //   163: sipush 1280
    //   166: sipush 1280
    //   169: iload 8
    //   171: invokestatic 142	com/viber/voip/util/e/j:a	(Landroid/content/Context;IILandroid/net/Uri;Lcom/viber/voip/util/dv;III)Landroid/graphics/Bitmap;
    //   174: astore 12
    //   176: aload 12
    //   178: astore 13
    //   180: aload 13
    //   182: ifnonnull +76 -> 258
    //   185: aload_0
    //   186: aload 10
    //   188: aload_1
    //   189: invokespecial 145	com/viber/voip/messages/controller/b/a:a	(Ljava/util/concurrent/CountDownLatch;Ljava/util/concurrent/CountDownLatch;)V
    //   192: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   195: ldc 85
    //   197: ldc 147
    //   199: invokeinterface 92 3 0
    //   204: aload 10
    //   206: invokevirtual 150	java/util/concurrent/CountDownLatch:await	()V
    //   209: aload 13
    //   211: ifnull +8 -> 219
    //   214: aload 13
    //   216: invokevirtual 155	android/graphics/Bitmap:recycle	()V
    //   219: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   222: ldc 85
    //   224: ldc 147
    //   226: invokeinterface 157 3 0
    //   231: aload_0
    //   232: getfield 159	com/viber/voip/messages/controller/b/a:g	Landroid/net/Uri;
    //   235: ifnonnull +147 -> 382
    //   238: aload_0
    //   239: invokevirtual 162	com/viber/voip/messages/controller/b/a:k	()V
    //   242: return
    //   243: iconst_0
    //   244: istore_2
    //   245: goto -136 -> 109
    //   248: astore 11
    //   250: aload_0
    //   251: aload 10
    //   253: aload_1
    //   254: invokespecial 145	com/viber/voip/messages/controller/b/a:a	(Ljava/util/concurrent/CountDownLatch;Ljava/util/concurrent/CountDownLatch;)V
    //   257: return
    //   258: aload_0
    //   259: aload 13
    //   261: aload 10
    //   263: aload_1
    //   264: invokespecial 165	com/viber/voip/messages/controller/b/a:b	(Landroid/graphics/Bitmap;Ljava/util/concurrent/CountDownLatch;Ljava/util/concurrent/CountDownLatch;)V
    //   267: aload_0
    //   268: aload 13
    //   270: aload 10
    //   272: invokespecial 168	com/viber/voip/messages/controller/b/a:b	(Landroid/graphics/Bitmap;Ljava/util/concurrent/CountDownLatch;)V
    //   275: goto -83 -> 192
    //   278: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   281: ldc 85
    //   283: ldc 170
    //   285: invokeinterface 92 3 0
    //   290: aload_0
    //   291: getfield 49	com/viber/voip/messages/controller/b/a:b	Landroid/content/Context;
    //   294: aload_3
    //   295: invokestatic 173	com/viber/voip/util/e/j:b	(Landroid/content/Context;Landroid/net/Uri;)[B
    //   298: astore 17
    //   300: aload_0
    //   301: aload 17
    //   303: aload 10
    //   305: aload_1
    //   306: invokespecial 176	com/viber/voip/messages/controller/b/a:b	([BLjava/util/concurrent/CountDownLatch;Ljava/util/concurrent/CountDownLatch;)V
    //   309: aload 9
    //   311: aload_0
    //   312: getfield 49	com/viber/voip/messages/controller/b/a:b	Landroid/content/Context;
    //   315: aload_3
    //   316: invokevirtual 182	android/net/Uri:toString	()Ljava/lang/String;
    //   319: iconst_1
    //   320: invokevirtual 187	com/viber/voip/util/dv:a	(Landroid/content/Context;Ljava/lang/String;Z)Landroid/net/Uri;
    //   323: astore 18
    //   325: aload_0
    //   326: aload 18
    //   328: aload 17
    //   330: invokevirtual 190	com/viber/voip/messages/controller/b/a:a	(Landroid/net/Uri;[B)V
    //   333: aload_0
    //   334: aload 18
    //   336: putfield 159	com/viber/voip/messages/controller/b/a:g	Landroid/net/Uri;
    //   339: aload 10
    //   341: invokevirtual 119	java/util/concurrent/CountDownLatch:countDown	()V
    //   344: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   347: ldc 85
    //   349: ldc 170
    //   351: invokeinterface 157 3 0
    //   356: aconst_null
    //   357: astore 13
    //   359: goto -167 -> 192
    //   362: astore 16
    //   364: aload 10
    //   366: invokevirtual 119	java/util/concurrent/CountDownLatch:countDown	()V
    //   369: goto -25 -> 344
    //   372: astore 15
    //   374: aload 10
    //   376: invokevirtual 119	java/util/concurrent/CountDownLatch:countDown	()V
    //   379: aload 15
    //   381: athrow
    //   382: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   385: ldc 85
    //   387: ldc 87
    //   389: invokeinterface 157 3 0
    //   394: return
    //   395: astore 14
    //   397: goto -188 -> 209
    //   400: iconst_0
    //   401: istore_2
    //   402: goto -293 -> 109
    //
    // Exception table:
    //   from	to	target	type
    //   152	176	248	java/lang/Exception
    //   290	339	362	java/lang/Exception
    //   290	339	372	finally
    //   204	209	395	java/lang/InterruptedException
  }

  private void a(CountDownLatch paramCountDownLatch1, CountDownLatch paramCountDownLatch2)
  {
    paramCountDownLatch1.countDown();
    paramCountDownLatch1.countDown();
    if (paramCountDownLatch2 != null)
      paramCountDownLatch2.countDown();
    k();
  }

  private void b(Bitmap paramBitmap, CountDownLatch paramCountDownLatch)
  {
    av.f.c.execute(new b(this, paramBitmap, paramCountDownLatch));
  }

  private void b(Bitmap paramBitmap, CountDownLatch paramCountDownLatch1, CountDownLatch paramCountDownLatch2)
  {
    av.f.c.execute(new d(this, paramBitmap, paramCountDownLatch1, paramCountDownLatch2));
  }

  private void b(byte[] paramArrayOfByte, CountDownLatch paramCountDownLatch1, CountDownLatch paramCountDownLatch2)
  {
    av.f.c.execute(new c(this, paramArrayOfByte, paramCountDownLatch1, paramCountDownLatch2));
  }

  protected abstract File a();

  protected abstract void a(Uri paramUri);

  protected void a(Uri paramUri, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte == null);
    OutputStream localOutputStream;
    do
    {
      return;
      e.b().a("SEND_MESSAGE", "MesSendDelegate save file");
      localOutputStream = this.c.openOutputStream(paramUri);
    }
    while (localOutputStream == null);
    localOutputStream.write(paramArrayOfByte);
    localOutputStream.flush();
    bj.a(localOutputStream);
    e.b().b("SEND_MESSAGE", "MesSendDelegate save file");
  }

  protected void a(byte[] paramArrayOfByte, String paramString)
  {
    e.b().a("SEND_MESSAGE", "UP short thumb bitm only");
    if (this.a.b(paramString))
      return;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ALPHA_8;
    Bitmap localBitmap = dq.a(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    dq.a(localBitmap, Bitmap.CompressFormat.JPEG, 70, localByteArrayOutputStream);
    for (int i = (int)(70.0D * (10240 / localByteArrayOutputStream.size())); ; i -= 10)
      if (i > 0)
      {
        localByteArrayOutputStream.reset();
        dq.a(localBitmap, Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
        if (localByteArrayOutputStream.size() >= 10240);
      }
      else
      {
        if (localByteArrayOutputStream.size() > 10240)
          break;
        e.b().b("SEND_MESSAGE", "UP short thumb bitm only");
        localBitmap.recycle();
        this.a.a(paramString, localByteArrayOutputStream.toByteArray());
        return;
      }
  }

  protected byte[] a(Bitmap paramBitmap)
  {
    e.b().a("SEND_MESSAGE", "UP createAndSaveMessageThumbnail");
    boolean bool = g();
    byte[] arrayOfByte = null;
    if (bool)
    {
      arrayOfByte = b(paramBitmap);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        b(arrayOfByte);
    }
    e.b().b("SEND_MESSAGE", "UP createAndSaveMessageThumbnail");
    return arrayOfByte;
  }

  protected byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    return a(dq.a(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions));
  }

  protected abstract Uri b();

  protected void b(Uri paramUri)
  {
  }

  protected void b(byte[] paramArrayOfByte)
  {
    Uri localUri = f();
    try
    {
      a(localUri, paramArrayOfByte);
      a(localUri);
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  protected byte[] b(Bitmap paramBitmap)
  {
    e.b().a("SEND_MESSAGE", "UP prepareThumbnailBitmap");
    Bitmap localBitmap = j.a(paramBitmap, 400, 960, 0, false);
    if (localBitmap == null)
      return null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    dq.a(localBitmap, Bitmap.CompressFormat.JPEG, 70, localByteArrayOutputStream);
    localBitmap.recycle();
    e.b().b("SEND_MESSAGE", "UP prepareThumbnailBitmap");
    return localByteArrayOutputStream.toByteArray();
  }

  protected abstract String c();

  protected abstract dv d();

  protected abstract File e();

  protected abstract Uri f();

  protected abstract boolean g();

  protected abstract void h();

  // ERROR //
  public void i()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 245	com/viber/voip/messages/controller/b/a:c	()Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: invokestatic 347	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +8 -> 19
    //   14: aload_0
    //   15: invokevirtual 162	com/viber/voip/messages/controller/b/a:k	()V
    //   18: return
    //   19: aload_0
    //   20: aload_2
    //   21: invokespecial 349	com/viber/voip/messages/controller/b/a:a	(Ljava/lang/String;)Ljava/util/concurrent/locks/Lock;
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 352 1 0
    //   31: getstatic 36	com/viber/voip/messages/controller/b/a:e	Ljava/util/Map;
    //   34: astore 8
    //   36: aload 8
    //   38: monitorenter
    //   39: getstatic 36	com/viber/voip/messages/controller/b/a:e	Ljava/util/Map;
    //   42: aload_2
    //   43: aload_3
    //   44: invokeinterface 73 3 0
    //   49: pop
    //   50: aload 8
    //   52: monitorexit
    //   53: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   56: ldc 85
    //   58: ldc_w 354
    //   61: invokeinterface 92 3 0
    //   66: aload_0
    //   67: invokevirtual 356	com/viber/voip/messages/controller/b/a:a	()Ljava/io/File;
    //   70: astore 11
    //   72: aload 11
    //   74: ifnonnull +96 -> 170
    //   77: aload_0
    //   78: invokevirtual 162	com/viber/voip/messages/controller/b/a:k	()V
    //   81: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   84: ldc 85
    //   86: ldc_w 354
    //   89: invokeinterface 157 3 0
    //   94: getstatic 36	com/viber/voip/messages/controller/b/a:e	Ljava/util/Map;
    //   97: astore 12
    //   99: aload 12
    //   101: monitorenter
    //   102: getstatic 36	com/viber/voip/messages/controller/b/a:e	Ljava/util/Map;
    //   105: aload_2
    //   106: invokeinterface 359 2 0
    //   111: pop
    //   112: aload_3
    //   113: invokeinterface 362 1 0
    //   118: aload 12
    //   120: monitorexit
    //   121: return
    //   122: astore 13
    //   124: aload 12
    //   126: monitorexit
    //   127: aload 13
    //   129: athrow
    //   130: astore 9
    //   132: aload 8
    //   134: monitorexit
    //   135: aload 9
    //   137: athrow
    //   138: astore 4
    //   140: getstatic 36	com/viber/voip/messages/controller/b/a:e	Ljava/util/Map;
    //   143: astore 5
    //   145: aload 5
    //   147: monitorenter
    //   148: getstatic 36	com/viber/voip/messages/controller/b/a:e	Ljava/util/Map;
    //   151: aload_2
    //   152: invokeinterface 359 2 0
    //   157: pop
    //   158: aload_3
    //   159: invokeinterface 362 1 0
    //   164: aload 5
    //   166: monitorexit
    //   167: aload 4
    //   169: athrow
    //   170: aload 11
    //   172: invokevirtual 125	java/io/File:length	()J
    //   175: lconst_0
    //   176: lcmp
    //   177: ifle +145 -> 322
    //   180: aload_0
    //   181: invokevirtual 364	com/viber/voip/messages/controller/b/a:e	()Ljava/io/File;
    //   184: astore 20
    //   186: aload 20
    //   188: ifnull +13 -> 201
    //   191: aload 20
    //   193: invokevirtual 125	java/io/File:length	()J
    //   196: lconst_0
    //   197: lcmp
    //   198: ifne +113 -> 311
    //   201: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   204: ldc 85
    //   206: ldc_w 366
    //   209: invokeinterface 92 3 0
    //   214: aload_0
    //   215: invokevirtual 368	com/viber/voip/messages/controller/b/a:h	()V
    //   218: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   221: ldc 85
    //   223: ldc_w 366
    //   226: invokeinterface 157 3 0
    //   231: aload_0
    //   232: aload_0
    //   233: invokevirtual 136	com/viber/voip/messages/controller/b/a:d	()Lcom/viber/voip/util/dv;
    //   236: aload_0
    //   237: getfield 49	com/viber/voip/messages/controller/b/a:b	Landroid/content/Context;
    //   240: aload_0
    //   241: invokevirtual 95	com/viber/voip/messages/controller/b/a:b	()Landroid/net/Uri;
    //   244: invokevirtual 182	android/net/Uri:toString	()Ljava/lang/String;
    //   247: iconst_1
    //   248: invokevirtual 187	com/viber/voip/util/dv:a	(Landroid/content/Context;Ljava/lang/String;Z)Landroid/net/Uri;
    //   251: putfield 159	com/viber/voip/messages/controller/b/a:g	Landroid/net/Uri;
    //   254: aload_0
    //   255: aload_0
    //   256: getfield 159	com/viber/voip/messages/controller/b/a:g	Landroid/net/Uri;
    //   259: invokevirtual 370	com/viber/voip/messages/controller/b/a:b	(Landroid/net/Uri;)V
    //   262: aload_1
    //   263: ifnull +7 -> 270
    //   266: aload_1
    //   267: invokevirtual 150	java/util/concurrent/CountDownLatch:await	()V
    //   270: getstatic 36	com/viber/voip/messages/controller/b/a:e	Ljava/util/Map;
    //   273: astore 16
    //   275: aload 16
    //   277: monitorenter
    //   278: getstatic 36	com/viber/voip/messages/controller/b/a:e	Ljava/util/Map;
    //   281: aload_2
    //   282: invokeinterface 359 2 0
    //   287: pop
    //   288: aload_3
    //   289: invokeinterface 362 1 0
    //   294: aload 16
    //   296: monitorexit
    //   297: invokestatic 83	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   300: ldc 85
    //   302: ldc_w 354
    //   305: invokeinterface 157 3 0
    //   310: return
    //   311: aload_0
    //   312: aload_0
    //   313: invokevirtual 317	com/viber/voip/messages/controller/b/a:f	()Landroid/net/Uri;
    //   316: invokevirtual 335	com/viber/voip/messages/controller/b/a:a	(Landroid/net/Uri;)V
    //   319: goto -88 -> 231
    //   322: aload_0
    //   323: invokevirtual 373	com/viber/voip/messages/controller/b/a:j	()Z
    //   326: istore 15
    //   328: aconst_null
    //   329: astore_1
    //   330: iload 15
    //   332: ifeq +12 -> 344
    //   335: new 116	java/util/concurrent/CountDownLatch
    //   338: dup
    //   339: iconst_1
    //   340: invokespecial 139	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   343: astore_1
    //   344: aload_0
    //   345: aload_1
    //   346: invokespecial 375	com/viber/voip/messages/controller/b/a:a	(Ljava/util/concurrent/CountDownLatch;)V
    //   349: goto -95 -> 254
    //   352: astore 17
    //   354: aload 16
    //   356: monitorexit
    //   357: aload 17
    //   359: athrow
    //   360: astore 6
    //   362: aload 5
    //   364: monitorexit
    //   365: aload 6
    //   367: athrow
    //   368: astore 19
    //   370: goto -100 -> 270
    //
    // Exception table:
    //   from	to	target	type
    //   102	121	122	finally
    //   124	127	122	finally
    //   39	53	130	finally
    //   132	135	130	finally
    //   25	39	138	finally
    //   53	72	138	finally
    //   77	94	138	finally
    //   135	138	138	finally
    //   170	186	138	finally
    //   191	201	138	finally
    //   201	231	138	finally
    //   231	254	138	finally
    //   254	262	138	finally
    //   266	270	138	finally
    //   311	319	138	finally
    //   322	328	138	finally
    //   335	344	138	finally
    //   344	349	138	finally
    //   278	297	352	finally
    //   354	357	352	finally
    //   148	167	360	finally
    //   362	365	360	finally
    //   266	270	368	java/lang/InterruptedException
  }

  protected boolean j()
  {
    return true;
  }

  protected abstract void k();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.a
 * JD-Core Version:    0.6.2
 */