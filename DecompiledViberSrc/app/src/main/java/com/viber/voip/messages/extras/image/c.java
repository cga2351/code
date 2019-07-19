package com.viber.voip.messages.extras.image;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore.Video;
import android.util.DisplayMetrics;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.extras.a;
import com.viber.voip.messages.l;
import com.viber.voip.util.af;
import com.viber.voip.util.at;
import com.viber.voip.util.aw;
import com.viber.voip.util.bj;
import com.viber.voip.util.bw;
import com.viber.voip.util.da;
import com.viber.voip.util.dq;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.j;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.sqlite.database.sqlite.SQLiteException;

public class c
{
  public static int a;
  private static final Logger b = ViberEnv.getLogger();
  private static Integer c;
  private Map<String, a> d = new HashMap();

  static
  {
    a();
  }

  private static Bitmap a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2;
    while (true)
    {
      Bitmap localBitmap3;
      try
      {
        if ((paramUri.getScheme() != null) && (paramUri.getScheme().startsWith("content")))
        {
          ContentResolver localContentResolver = paramContext.getContentResolver();
          int i = Integer.parseInt(paramUri.getLastPathSegment());
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inSampleSize = 1;
          localBitmap3 = dq.a(localContentResolver, i, 1, localOptions);
          if (localBitmap3 != null)
            break label134;
          localBitmap3 = ThumbnailUtils.createVideoThumbnail(paramUri.getPath(), 1);
          break label134;
          if (localObject != null)
          {
            localBitmap2 = j.a((Bitmap)localObject, paramInt1, paramInt2, 0);
            if (localBitmap2 == localObject)
              break;
            j.c((Bitmap)localObject);
            return localBitmap2;
          }
        }
        else
        {
          Bitmap localBitmap1 = ThumbnailUtils.createVideoThumbnail(paramUri.getPath(), 1);
          localObject = localBitmap1;
          continue;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      return localObject;
      label134: Object localObject = localBitmap3;
    }
    return localBitmap2;
  }

  // ERROR //
  public static Uri a(Context paramContext, Bitmap paramBitmap, Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +110 -> 111
    //   4: aload_0
    //   5: invokevirtual 56	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   8: astore_3
    //   9: aload_3
    //   10: aload_2
    //   11: invokevirtual 102	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   14: astore 8
    //   16: aload 8
    //   18: astore 5
    //   20: aload_1
    //   21: getstatic 108	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   24: bipush 80
    //   26: aload 5
    //   28: invokestatic 111	com/viber/voip/util/dq:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: iconst_1
    //   33: anewarray 113	java/io/Flushable
    //   36: dup
    //   37: iconst_0
    //   38: aload 5
    //   40: aastore
    //   41: invokestatic 118	com/viber/voip/util/bj:a	([Ljava/io/Flushable;)V
    //   44: aload 5
    //   46: invokestatic 121	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   49: aload_1
    //   50: invokestatic 93	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   53: aload_2
    //   54: areturn
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 5
    //   60: iconst_1
    //   61: anewarray 113	java/io/Flushable
    //   64: dup
    //   65: iconst_0
    //   66: aload 5
    //   68: aastore
    //   69: invokestatic 118	com/viber/voip/util/bj:a	([Ljava/io/Flushable;)V
    //   72: aload 5
    //   74: invokestatic 121	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   77: aconst_null
    //   78: astore_2
    //   79: goto -30 -> 49
    //   82: astore 4
    //   84: aconst_null
    //   85: astore 5
    //   87: aload 4
    //   89: astore 6
    //   91: iconst_1
    //   92: anewarray 113	java/io/Flushable
    //   95: dup
    //   96: iconst_0
    //   97: aload 5
    //   99: aastore
    //   100: invokestatic 118	com/viber/voip/util/bj:a	([Ljava/io/Flushable;)V
    //   103: aload 5
    //   105: invokestatic 121	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   108: aload 6
    //   110: athrow
    //   111: aconst_null
    //   112: astore_2
    //   113: goto -64 -> 49
    //   116: astore 6
    //   118: goto -27 -> 91
    //   121: astore 9
    //   123: goto -63 -> 60
    //
    // Exception table:
    //   from	to	target	type
    //   9	16	55	java/io/IOException
    //   9	16	82	finally
    //   20	32	116	finally
    //   20	32	121	java/io/IOException
  }

  public static Uri a(Context paramContext, Uri paramUri)
  {
    return a(paramContext, paramUri, dv.q, null, 222, 222, -1, l.a(at.g(paramUri)));
  }

  public static Uri a(Context paramContext, Uri paramUri, int paramInt)
  {
    Uri localUri = dv.q.a(paramContext, paramUri.toString(), true);
    return a(paramContext, paramUri, dv.q, localUri, 400, 960, -1, paramInt);
  }

  public static Uri a(Context paramContext, Uri paramUri1, Uri paramUri2, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean);
    for (dv localdv = dv.f; ; localdv = dv.q)
      return a(paramContext, paramUri1, localdv, paramUri2, 400, 960, -1, paramInt);
  }

  private static Uri a(Context paramContext, Uri paramUri1, dv paramdv, Uri paramUri2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    if ((paramUri1 == null) || (!o.b()) || (!o.a()))
      return null;
    Uri localUri2;
    if ((i == paramInt4) || (1003 == paramInt4))
      if (paramUri2 != null)
        localUri2 = paramUri2;
    try
    {
      return j.a(paramContext, paramUri1, localUri2, paramdv, paramInt1, paramInt2, true);
      Uri localUri1 = j.a(paramContext, paramUri1, paramdv, paramInt1, paramInt2, true, paramInt3);
      return localUri1;
      if ((paramInt4 == 3) || (paramInt4 == 1004) || (paramInt4 == 1010))
      {
        Bitmap localBitmap1 = a(paramContext, paramUri1, paramInt1, paramInt2);
        if (paramUri2 == null)
          if (localBitmap1 == null)
            break label134;
        while (true)
        {
          paramUri2 = paramdv.a(paramContext, null, i);
          return a(paramContext, localBitmap1, paramUri2);
          label134: i = 0;
        }
      }
      if (1005 == paramInt4)
      {
        Bitmap localBitmap2 = b(paramContext, paramUri1, paramInt1, paramInt2);
        if (paramUri2 == null)
          paramUri2 = dv.q.a(paramContext, null, i);
        return a(paramContext, localBitmap2, paramUri2);
      }
      if (14 == paramInt4)
        return a(paramUri1, paramUri2);
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Uri a(Context paramContext, byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    File localFile = dv.q.a(paramContext, paramString);
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    try
    {
      localFileOutputStream.write(paramArrayOfByte);
      Uri localUri = Uri.fromFile(localFile);
      return localUri;
    }
    finally
    {
      bj.a(localFileOutputStream);
    }
  }

  // ERROR //
  private static Uri a(Uri paramUri1, Uri paramUri2)
  {
    // Byte code:
    //   0: new 193	android/os/Bundle
    //   3: dup
    //   4: invokespecial 194	android/os/Bundle:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 79	android/net/Uri:getPath	()Ljava/lang/String;
    //   12: astore_3
    //   13: aload_3
    //   14: aload_2
    //   15: invokestatic 200	com/viber/voip/phone/ViberVideoPttPlay:getPreview	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   18: aload_2
    //   19: ldc 202
    //   21: invokevirtual 206	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +9 -> 37
    //   31: aload 4
    //   33: arraylength
    //   34: ifgt +7 -> 41
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: areturn
    //   41: invokestatic 212	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
    //   44: astore 5
    //   46: aload_1
    //   47: ifnonnull +22 -> 69
    //   50: getstatic 128	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   53: aload 5
    //   55: aload_3
    //   56: iconst_1
    //   57: invokevirtual 215	com/viber/voip/util/dv:b	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;
    //   60: astore 6
    //   62: aload 6
    //   64: ifnonnull +21 -> 85
    //   67: aconst_null
    //   68: areturn
    //   69: new 217	java/io/File
    //   72: dup
    //   73: aload_1
    //   74: invokevirtual 79	android/net/Uri:getPath	()Ljava/lang/String;
    //   77: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore 6
    //   82: goto -20 -> 62
    //   85: new 222	java/io/ByteArrayInputStream
    //   88: dup
    //   89: aload 4
    //   91: invokespecial 224	java/io/ByteArrayInputStream:<init>	([B)V
    //   94: astore 7
    //   96: new 180	java/io/FileOutputStream
    //   99: dup
    //   100: aload 6
    //   102: invokespecial 183	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   105: astore 8
    //   107: aload 7
    //   109: aload 8
    //   111: invokestatic 227	com/viber/voip/util/bj:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   114: iconst_2
    //   115: anewarray 229	java/io/Closeable
    //   118: dup
    //   119: iconst_0
    //   120: aload 7
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload 8
    //   127: aastore
    //   128: invokestatic 232	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   131: aload_1
    //   132: ifnonnull -93 -> 39
    //   135: aload 6
    //   137: invokestatic 191	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   140: areturn
    //   141: astore 13
    //   143: aconst_null
    //   144: astore 8
    //   146: aload 13
    //   148: astore 9
    //   150: getstatic 23	com/viber/voip/messages/extras/image/c:b	Lcom/viber/dexshared/Logger;
    //   153: aload 9
    //   155: new 234	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   162: ldc 237
    //   164: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_3
    //   168: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokeinterface 247 3 0
    //   179: aload_1
    //   180: ifnonnull +9 -> 189
    //   183: aload 6
    //   185: invokevirtual 250	java/io/File:delete	()Z
    //   188: pop
    //   189: iconst_2
    //   190: anewarray 229	java/io/Closeable
    //   193: dup
    //   194: iconst_0
    //   195: aload 7
    //   197: aastore
    //   198: dup
    //   199: iconst_1
    //   200: aload 8
    //   202: aastore
    //   203: invokestatic 232	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   206: goto -75 -> 131
    //   209: astore 12
    //   211: aconst_null
    //   212: astore 8
    //   214: aload 12
    //   216: astore 10
    //   218: iconst_2
    //   219: anewarray 229	java/io/Closeable
    //   222: dup
    //   223: iconst_0
    //   224: aload 7
    //   226: aastore
    //   227: dup
    //   228: iconst_1
    //   229: aload 8
    //   231: aastore
    //   232: invokestatic 232	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   235: aload 10
    //   237: athrow
    //   238: astore 10
    //   240: goto -22 -> 218
    //   243: astore 9
    //   245: goto -95 -> 150
    //
    // Exception table:
    //   from	to	target	type
    //   96	107	141	java/io/IOException
    //   96	107	209	finally
    //   107	114	238	finally
    //   150	179	238	finally
    //   183	189	238	finally
    //   107	114	243	java/io/IOException
  }

  // ERROR //
  public static Uri a(byte[] paramArrayOfByte, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: arraylength
    //   6: ifeq +7 -> 13
    //   9: aload_1
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 180	java/io/FileOutputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 183	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   23: astore_2
    //   24: aload_2
    //   25: aload_0
    //   26: invokevirtual 254	java/io/OutputStream:write	([B)V
    //   29: aload_1
    //   30: invokestatic 191	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   33: astore 5
    //   35: aload_2
    //   36: invokestatic 121	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   39: aload 5
    //   41: areturn
    //   42: astore_3
    //   43: aconst_null
    //   44: astore_2
    //   45: getstatic 23	com/viber/voip/messages/extras/image/c:b	Lcom/viber/dexshared/Logger;
    //   48: aload_3
    //   49: new 234	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 256
    //   59: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokeinterface 247 3 0
    //   74: aload_2
    //   75: invokestatic 121	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   78: aconst_null
    //   79: areturn
    //   80: astore 6
    //   82: aconst_null
    //   83: astore_2
    //   84: aload 6
    //   86: astore 4
    //   88: aload_2
    //   89: invokestatic 121	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   92: aload 4
    //   94: athrow
    //   95: astore 4
    //   97: goto -9 -> 88
    //   100: astore_3
    //   101: goto -56 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   15	24	42	java/io/IOException
    //   15	24	80	finally
    //   24	35	95	finally
    //   45	74	95	finally
    //   24	35	100	java/io/IOException
  }

  public static a a(Context paramContext, String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    if (da.a(paramString))
      return new a(arrayOfByte);
    return new a(d(paramContext, Uri.parse(paramString), 10240));
  }

  public static a a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[0];
    if (da.a(paramString))
      return new a(arrayOfByte);
    return new a(paramArrayOfByte);
  }

  private static void a()
  {
    a = b();
  }

  private static int b()
  {
    while (true)
    {
      int j;
      try
      {
        if (c == null)
        {
          j = ViberApplication.getApplication().getResources().getDisplayMetrics().densityDpi;
          if (j >= 640)
            c = Integer.valueOf(920);
        }
        else
        {
          int i = c.intValue();
          return i;
        }
        if (j >= 480)
        {
          c = Integer.valueOf(640);
          continue;
        }
      }
      finally
      {
      }
      if (j >= 320)
        c = Integer.valueOf(460);
      else
        c = Integer.valueOf(400);
    }
  }

  // ERROR //
  private static Bitmap b(Context paramContext, Uri paramUri, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 311	com/viber/voip/util/e/m
    //   3: dup
    //   4: invokespecial 312	com/viber/voip/util/e/m:<init>	()V
    //   7: astore 4
    //   9: new 314	pl/droidsonroids/gif/f
    //   12: dup
    //   13: invokespecial 315	pl/droidsonroids/gif/f:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: aload_1
    //   21: iload_2
    //   22: iload_3
    //   23: invokestatic 320	com/viber/voip/util/aw:a	(Landroid/net/Uri;II)I
    //   26: invokevirtual 323	pl/droidsonroids/gif/f:a	(I)V
    //   29: aload 4
    //   31: aload_0
    //   32: invokevirtual 56	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: aload_1
    //   36: invokevirtual 326	com/viber/voip/util/e/m:a	(Landroid/content/ContentResolver;Landroid/net/Uri;)Lpl/droidsonroids/gif/d;
    //   39: checkcast 328	pl/droidsonroids/gif/c
    //   42: aload 5
    //   44: invokevirtual 331	pl/droidsonroids/gif/c:a	(Lpl/droidsonroids/gif/f;)Lpl/droidsonroids/gif/d;
    //   47: checkcast 328	pl/droidsonroids/gif/c
    //   50: invokevirtual 334	pl/droidsonroids/gif/c:c	()Lpl/droidsonroids/gif/b;
    //   53: iconst_0
    //   54: invokevirtual 339	pl/droidsonroids/gif/b:b	(I)Landroid/graphics/Bitmap;
    //   57: astore 9
    //   59: aload 9
    //   61: iload_2
    //   62: iload_3
    //   63: iconst_0
    //   64: invokestatic 90	com/viber/voip/util/e/j:a	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   67: astore 12
    //   69: aload 12
    //   71: aload 9
    //   73: if_acmpeq +8 -> 81
    //   76: aload 9
    //   78: invokestatic 93	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   81: aload 12
    //   83: areturn
    //   84: astore 7
    //   86: aconst_null
    //   87: astore 8
    //   89: invokestatic 343	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   92: invokevirtual 346	com/viber/voip/ViberApplication:onOutOfMemory	()V
    //   95: aload 8
    //   97: areturn
    //   98: astore 11
    //   100: aload 9
    //   102: astore 8
    //   104: goto -15 -> 89
    //   107: astore 6
    //   109: aconst_null
    //   110: areturn
    //   111: astore 10
    //   113: aload 9
    //   115: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	59	84	java/lang/OutOfMemoryError
    //   59	69	98	java/lang/OutOfMemoryError
    //   76	81	98	java/lang/OutOfMemoryError
    //   0	59	107	java/lang/Exception
    //   59	69	111	java/lang/Exception
    //   76	81	111	java/lang/Exception
  }

  public static Uri b(Context paramContext, Uri paramUri, int paramInt)
  {
    Uri localUri = dv.f.a(paramContext, paramUri.toString(), true);
    return a(paramContext, paramUri, dv.f, localUri, 400, 960, -1, paramInt);
  }

  public static void b(Context paramContext, Uri paramUri)
  {
    Rect localRect = aw.a(paramUri);
    if ((localRect.isEmpty()) || ((localRect.width() < 400) && (localRect.height() < 960)))
      return;
    a(paramContext, paramUri, paramUri, 1, false);
  }

  public static long c(Context paramContext, Uri paramUri, int paramInt)
  {
    int i = 1;
    ContentResolver localContentResolver = paramContext.getContentResolver();
    long l = 0L;
    if (l.e(paramInt))
      if ((paramUri.getScheme() != null) && (paramUri.getScheme().startsWith("content")) && (i == 0));
    do
    {
      try
      {
        Cursor localCursor = MediaStore.Video.query(localContentResolver, paramUri, new String[] { "duration" });
        if ((!af.b(localCursor)) && (localCursor.moveToFirst()))
          l = localCursor.getLong(0);
        af.a(localCursor);
        return l;
        i = 0;
      }
      catch (SQLiteException localSQLiteException)
      {
        return bw.b(paramContext, paramUri);
      }
      return bw.b(paramContext, paramUri);
      if ((l.f(paramInt)) || (5 == paramInt))
        return at.c(paramContext, paramUri);
    }
    while (2 != paramInt);
    return bw.b(paramContext, paramUri);
  }

  // ERROR //
  private static byte[] d(Context paramContext, Uri paramUri, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: newarray byte
    //   5: astore 4
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload 4
    //   13: areturn
    //   14: aload_0
    //   15: invokevirtual 56	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: aload_1
    //   19: invokevirtual 414	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   22: astore 21
    //   24: aload 21
    //   26: astore 11
    //   28: aload 11
    //   30: invokevirtual 419	java/io/InputStream:available	()I
    //   33: iload_2
    //   34: if_icmple +230 -> 264
    //   37: new 67	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 68	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore 26
    //   46: aload 26
    //   48: getstatic 425	android/graphics/Bitmap$Config:ALPHA_8	Landroid/graphics/Bitmap$Config;
    //   51: putfield 428	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   54: aload 11
    //   56: aconst_null
    //   57: aload 26
    //   59: invokestatic 431	com/viber/voip/util/dq:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: astore 27
    //   64: aload 27
    //   66: astore 14
    //   68: new 433	java/io/ByteArrayOutputStream
    //   71: dup
    //   72: ldc_w 434
    //   75: invokespecial 436	java/io/ByteArrayOutputStream:<init>	(I)V
    //   78: astore 6
    //   80: aload 14
    //   82: getstatic 108	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   85: bipush 70
    //   87: aload 6
    //   89: invokestatic 111	com/viber/voip/util/dq:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   92: pop
    //   93: ldc2_w 437
    //   96: iload_2
    //   97: i2d
    //   98: aload 6
    //   100: invokevirtual 441	java/io/ByteArrayOutputStream:size	()I
    //   103: i2d
    //   104: ddiv
    //   105: dmul
    //   106: d2i
    //   107: istore 34
    //   109: iload 34
    //   111: iflt +30 -> 141
    //   114: aload 6
    //   116: invokevirtual 444	java/io/ByteArrayOutputStream:reset	()V
    //   119: aload 14
    //   121: getstatic 108	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   124: iload 34
    //   126: aload 6
    //   128: invokestatic 111	com/viber/voip/util/dq:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   131: pop
    //   132: aload 6
    //   134: invokevirtual 441	java/io/ByteArrayOutputStream:size	()I
    //   137: iload_2
    //   138: if_icmpge +63 -> 201
    //   141: aload 6
    //   143: invokevirtual 441	java/io/ByteArrayOutputStream:size	()I
    //   146: iload_2
    //   147: if_icmple +73 -> 220
    //   150: new 408	java/lang/IllegalArgumentException
    //   153: dup
    //   154: ldc_w 446
    //   157: invokespecial 447	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   160: athrow
    //   161: astore 32
    //   163: aload 14
    //   165: astore 7
    //   167: aload 11
    //   169: astore 8
    //   171: iconst_0
    //   172: newarray byte
    //   174: astore 9
    //   176: aload 7
    //   178: invokestatic 93	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   181: iconst_2
    //   182: anewarray 229	java/io/Closeable
    //   185: dup
    //   186: iconst_0
    //   187: aload 8
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: aload 6
    //   194: aastore
    //   195: invokestatic 232	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   198: aload 9
    //   200: areturn
    //   201: iload 34
    //   203: ifeq -62 -> 141
    //   206: iinc 34 246
    //   209: iload 34
    //   211: ifge -102 -> 109
    //   214: iconst_0
    //   215: istore 34
    //   217: goto -108 -> 109
    //   220: aload 6
    //   222: invokevirtual 451	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   225: astore 36
    //   227: aload 14
    //   229: astore 37
    //   231: aload 36
    //   233: astore 38
    //   235: aload 37
    //   237: astore 39
    //   239: aload 39
    //   241: invokestatic 93	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   244: iconst_2
    //   245: anewarray 229	java/io/Closeable
    //   248: dup
    //   249: iconst_0
    //   250: aload 11
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: aload 6
    //   257: aastore
    //   258: invokestatic 232	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   261: aload 38
    //   263: areturn
    //   264: aload 11
    //   266: invokevirtual 419	java/io/InputStream:available	()I
    //   269: newarray byte
    //   271: astore 44
    //   273: aload 11
    //   275: aload 44
    //   277: invokevirtual 455	java/io/InputStream:read	([B)I
    //   280: pop
    //   281: aload 44
    //   283: astore 38
    //   285: aconst_null
    //   286: astore 6
    //   288: aconst_null
    //   289: astore 39
    //   291: goto -52 -> 239
    //   294: astore 19
    //   296: aconst_null
    //   297: astore 6
    //   299: aconst_null
    //   300: astore 11
    //   302: aload 4
    //   304: astore 20
    //   306: aload_3
    //   307: invokestatic 93	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   310: iconst_2
    //   311: anewarray 229	java/io/Closeable
    //   314: dup
    //   315: iconst_0
    //   316: aload 11
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: aload 6
    //   323: aastore
    //   324: invokestatic 232	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   327: aload 20
    //   329: areturn
    //   330: astore 17
    //   332: aconst_null
    //   333: astore 6
    //   335: aconst_null
    //   336: astore 11
    //   338: aload 4
    //   340: astore 18
    //   342: aload_3
    //   343: invokestatic 93	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   346: iconst_2
    //   347: anewarray 229	java/io/Closeable
    //   350: dup
    //   351: iconst_0
    //   352: aload 11
    //   354: aastore
    //   355: dup
    //   356: iconst_1
    //   357: aload 6
    //   359: aastore
    //   360: invokestatic 232	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   363: aload 18
    //   365: areturn
    //   366: astore 15
    //   368: aconst_null
    //   369: astore 6
    //   371: aconst_null
    //   372: astore 11
    //   374: aload 4
    //   376: astore 16
    //   378: aload_3
    //   379: invokestatic 93	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   382: iconst_2
    //   383: anewarray 229	java/io/Closeable
    //   386: dup
    //   387: iconst_0
    //   388: aload 11
    //   390: aastore
    //   391: dup
    //   392: iconst_1
    //   393: aload 6
    //   395: aastore
    //   396: invokestatic 232	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   399: aload 16
    //   401: areturn
    //   402: astore 13
    //   404: aconst_null
    //   405: astore 14
    //   407: aconst_null
    //   408: astore 11
    //   410: aload 14
    //   412: invokestatic 93	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   415: iconst_2
    //   416: anewarray 229	java/io/Closeable
    //   419: dup
    //   420: iconst_0
    //   421: aload 11
    //   423: aastore
    //   424: dup
    //   425: iconst_1
    //   426: aload_3
    //   427: aastore
    //   428: invokestatic 232	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   431: aload 13
    //   433: athrow
    //   434: astore 13
    //   436: aconst_null
    //   437: astore_3
    //   438: aconst_null
    //   439: astore 14
    //   441: goto -31 -> 410
    //   444: astore 13
    //   446: aconst_null
    //   447: astore_3
    //   448: goto -38 -> 410
    //   451: astore 31
    //   453: aload 6
    //   455: astore_3
    //   456: aload 31
    //   458: astore 13
    //   460: goto -50 -> 410
    //   463: astore 10
    //   465: aload 8
    //   467: astore 11
    //   469: aload 6
    //   471: astore 12
    //   473: aload 10
    //   475: astore 13
    //   477: aload 7
    //   479: astore 14
    //   481: aload 12
    //   483: astore_3
    //   484: goto -74 -> 410
    //   487: astore 25
    //   489: aload 4
    //   491: astore 16
    //   493: aconst_null
    //   494: astore 6
    //   496: aconst_null
    //   497: astore_3
    //   498: goto -120 -> 378
    //   501: astore 43
    //   503: aload 14
    //   505: astore_3
    //   506: aload 4
    //   508: astore 16
    //   510: aconst_null
    //   511: astore 6
    //   513: goto -135 -> 378
    //   516: astore 30
    //   518: aload 14
    //   520: astore_3
    //   521: aload 4
    //   523: astore 16
    //   525: goto -147 -> 378
    //   528: astore 47
    //   530: aload 44
    //   532: astore 16
    //   534: aconst_null
    //   535: astore 6
    //   537: aconst_null
    //   538: astore_3
    //   539: goto -161 -> 378
    //   542: astore 24
    //   544: aload 4
    //   546: astore 18
    //   548: aconst_null
    //   549: astore 6
    //   551: aconst_null
    //   552: astore_3
    //   553: goto -211 -> 342
    //   556: astore 42
    //   558: aload 14
    //   560: astore_3
    //   561: aload 4
    //   563: astore 18
    //   565: aconst_null
    //   566: astore 6
    //   568: goto -226 -> 342
    //   571: astore 29
    //   573: aload 14
    //   575: astore_3
    //   576: aload 4
    //   578: astore 18
    //   580: goto -238 -> 342
    //   583: astore 46
    //   585: aload 44
    //   587: astore 18
    //   589: aconst_null
    //   590: astore 6
    //   592: aconst_null
    //   593: astore_3
    //   594: goto -252 -> 342
    //   597: astore 23
    //   599: aload 4
    //   601: astore 20
    //   603: aconst_null
    //   604: astore 6
    //   606: aconst_null
    //   607: astore_3
    //   608: goto -302 -> 306
    //   611: astore 41
    //   613: aload 14
    //   615: astore_3
    //   616: aload 4
    //   618: astore 20
    //   620: aconst_null
    //   621: astore 6
    //   623: goto -317 -> 306
    //   626: astore 28
    //   628: aload 14
    //   630: astore_3
    //   631: aload 4
    //   633: astore 20
    //   635: goto -329 -> 306
    //   638: astore 45
    //   640: aload 44
    //   642: astore 20
    //   644: aconst_null
    //   645: astore 6
    //   647: aconst_null
    //   648: astore_3
    //   649: goto -343 -> 306
    //   652: astore 5
    //   654: aconst_null
    //   655: astore 6
    //   657: aconst_null
    //   658: astore 7
    //   660: aconst_null
    //   661: astore 8
    //   663: goto -492 -> 171
    //   666: astore 22
    //   668: aload 11
    //   670: astore 8
    //   672: aconst_null
    //   673: astore 6
    //   675: aconst_null
    //   676: astore 7
    //   678: goto -507 -> 171
    //   681: astore 40
    //   683: aload 11
    //   685: astore 8
    //   687: aload 14
    //   689: astore 7
    //   691: aconst_null
    //   692: astore 6
    //   694: goto -523 -> 171
    //
    // Exception table:
    //   from	to	target	type
    //   80	109	161	java/io/FileNotFoundException
    //   114	141	161	java/io/FileNotFoundException
    //   141	161	161	java/io/FileNotFoundException
    //   220	227	161	java/io/FileNotFoundException
    //   14	24	294	java/io/IOException
    //   14	24	330	java/lang/IllegalArgumentException
    //   14	24	366	java/lang/NullPointerException
    //   14	24	402	finally
    //   28	64	434	finally
    //   264	273	434	finally
    //   273	281	434	finally
    //   68	80	444	finally
    //   80	109	451	finally
    //   114	141	451	finally
    //   141	161	451	finally
    //   220	227	451	finally
    //   171	176	463	finally
    //   28	64	487	java/lang/NullPointerException
    //   264	273	487	java/lang/NullPointerException
    //   68	80	501	java/lang/NullPointerException
    //   80	109	516	java/lang/NullPointerException
    //   114	141	516	java/lang/NullPointerException
    //   141	161	516	java/lang/NullPointerException
    //   220	227	516	java/lang/NullPointerException
    //   273	281	528	java/lang/NullPointerException
    //   28	64	542	java/lang/IllegalArgumentException
    //   264	273	542	java/lang/IllegalArgumentException
    //   68	80	556	java/lang/IllegalArgumentException
    //   80	109	571	java/lang/IllegalArgumentException
    //   114	141	571	java/lang/IllegalArgumentException
    //   141	161	571	java/lang/IllegalArgumentException
    //   220	227	571	java/lang/IllegalArgumentException
    //   273	281	583	java/lang/IllegalArgumentException
    //   28	64	597	java/io/IOException
    //   264	273	597	java/io/IOException
    //   68	80	611	java/io/IOException
    //   80	109	626	java/io/IOException
    //   114	141	626	java/io/IOException
    //   141	161	626	java/io/IOException
    //   220	227	626	java/io/IOException
    //   273	281	638	java/io/IOException
    //   14	24	652	java/io/FileNotFoundException
    //   28	64	666	java/io/FileNotFoundException
    //   264	273	666	java/io/FileNotFoundException
    //   273	281	666	java/io/FileNotFoundException
    //   68	80	681	java/io/FileNotFoundException
  }

  public void a(String paramString)
  {
    synchronized (this.d)
    {
      this.d.remove(paramString);
      return;
    }
  }

  public void a(String paramString, byte[] paramArrayOfByte)
  {
    this.d.put(paramString, a(ViberApplication.getApplication(), paramString, paramArrayOfByte));
  }

  public boolean b(String paramString)
  {
    return this.d.get(paramString) != null;
  }

  public byte[] c(String paramString)
  {
    i.a();
    a locala;
    synchronized (this.d)
    {
      locala = (a)this.d.get(paramString);
      if (locala == null)
      {
        if ((!da.a(paramString)) && (paramString.startsWith("http")))
        {
          String str = e.a(Uri.parse(paramString));
          if (str != null)
            paramString = "file://" + str;
        }
        locala = a(ViberApplication.getApplication(), paramString);
      }
    }
    synchronized (this.d)
    {
      this.d.put(paramString, locala);
      return locala.a;
      localObject1 = finally;
      throw localObject1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.image.c
 * JD-Core Version:    0.6.2
 */