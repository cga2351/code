package com.viber.voip.util;

import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Rect;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.http.OkHttpClientFactory;
import f.e;
import f.f;
import f.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class aw
{
  public static final int a = (int)TimeUnit.SECONDS.toMillis(3L);
  private static final Logger b = ViberEnv.getLogger();
  private static final f c = f.a(new byte[] { 0, 33, -7 });
  private static final f d = f.a(new byte[] { 71, 73, 70, 56, 55, 97 });
  private static final f e = f.a(new byte[] { 71, 73, 70, 56, 57, 97 });

  public static int a(Uri paramUri, int paramInt1, int paramInt2)
  {
    Rect localRect = a(paramUri);
    return Math.max(1, Math.min(localRect.width() / paramInt1, localRect.height() / paramInt2));
  }

  public static Rect a(Uri paramUri)
  {
    if (paramUri == null)
      return new Rect();
    InputStream localInputStream = null;
    try
    {
      localInputStream = b(paramUri);
      if (localInputStream == null)
      {
        Rect localRect1 = new Rect();
        return localRect1;
      }
      Rect localRect2 = a(localInputStream);
      return localRect2;
    }
    catch (IOException localIOException)
    {
      b.a(localIOException, "getGifDisplaySize(): Unable to get display size of the GIF for uri = " + paramUri);
      if (dk.f(paramUri))
        ViberApplication.getInstance().getDownloadValve().a(paramUri.toString());
      return new Rect();
    }
    finally
    {
      bj.a(localInputStream);
    }
  }

  private static Rect a(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[10];
    if (paramInputStream.read(arrayOfByte) == 10)
    {
      if (!a(arrayOfByte))
        return new Rect();
      return new Rect(0, 0, 0xFF & arrayOfByte[6] | arrayOfByte[7] << 8, 0xFF & arrayOfByte[8] | arrayOfByte[9] << 8);
    }
    return new Rect();
  }

  public static void a(Uri paramUri, OutputStream paramOutputStream)
    throws IOException
  {
    InputStream localInputStream = b(paramUri);
    if (localInputStream != null);
    try
    {
      a(localInputStream, paramOutputStream);
      return;
    }
    finally
    {
      bj.a(localInputStream);
    }
  }

  // ERROR //
  public static void a(com.viber.voip.flatbuffers.model.msginfo.MsgInfo paramMsgInfo, com.viber.voip.flatbuffers.model.msginfo.MsgInfo[] paramArrayOfMsgInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 163	com/viber/voip/util/dv:n	Lcom/viber/voip/util/dv;
    //   5: invokestatic 167	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
    //   8: aload_0
    //   9: invokevirtual 172	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:getThumbnailUrl	()Ljava/lang/String;
    //   12: iconst_0
    //   13: invokevirtual 175	com/viber/voip/util/dv:b	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;
    //   16: astore 7
    //   18: aload 7
    //   20: ifnonnull +8 -> 28
    //   23: aconst_null
    //   24: invokestatic 92	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   27: return
    //   28: aload 7
    //   30: invokevirtual 181	java/io/File:exists	()Z
    //   33: istore 8
    //   35: aconst_null
    //   36: astore_2
    //   37: iload 8
    //   39: ifeq +19 -> 58
    //   42: aload 7
    //   44: invokevirtual 185	java/io/File:length	()J
    //   47: lconst_0
    //   48: lcmp
    //   49: istore 9
    //   51: aconst_null
    //   52: astore_2
    //   53: iload 9
    //   55: ifne +29 -> 84
    //   58: new 187	java/io/FileOutputStream
    //   61: dup
    //   62: aload 7
    //   64: invokespecial 190	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore 4
    //   69: aload_0
    //   70: invokevirtual 172	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:getThumbnailUrl	()Ljava/lang/String;
    //   73: invokestatic 194	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   76: aload 4
    //   78: invokestatic 196	com/viber/voip/util/aw:a	(Landroid/net/Uri;Ljava/io/OutputStream;)V
    //   81: aload 4
    //   83: astore_2
    //   84: aload 7
    //   86: invokevirtual 185	java/io/File:length	()J
    //   89: lconst_0
    //   90: lcmp
    //   91: ifle +82 -> 173
    //   94: aload 7
    //   96: invokestatic 200	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   99: invokestatic 61	com/viber/voip/util/aw:a	(Landroid/net/Uri;)Landroid/graphics/Rect;
    //   102: astore 12
    //   104: aload_0
    //   105: aload 12
    //   107: invokevirtual 70	android/graphics/Rect:height	()I
    //   110: invokevirtual 204	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:setThumbnailHeight	(I)V
    //   113: aload_0
    //   114: aload 12
    //   116: invokevirtual 67	android/graphics/Rect:width	()I
    //   119: invokevirtual 207	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:setThumbnailWidth	(I)V
    //   122: aload_1
    //   123: arraylength
    //   124: ifle +61 -> 185
    //   127: aload_1
    //   128: arraylength
    //   129: istore 13
    //   131: iconst_0
    //   132: istore 14
    //   134: iload 14
    //   136: iload 13
    //   138: if_icmpge +47 -> 185
    //   141: aload_1
    //   142: iload 14
    //   144: aaload
    //   145: astore 15
    //   147: aload 15
    //   149: aload 12
    //   151: invokevirtual 70	android/graphics/Rect:height	()I
    //   154: invokevirtual 204	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:setThumbnailHeight	(I)V
    //   157: aload 15
    //   159: aload 12
    //   161: invokevirtual 67	android/graphics/Rect:width	()I
    //   164: invokevirtual 207	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:setThumbnailWidth	(I)V
    //   167: iinc 14 1
    //   170: goto -36 -> 134
    //   173: aload 7
    //   175: invokevirtual 210	java/io/File:delete	()Z
    //   178: istore 11
    //   180: iload 11
    //   182: ifeq +3 -> 185
    //   185: aload_2
    //   186: invokestatic 92	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   189: return
    //   190: astore 6
    //   192: aload_2
    //   193: invokestatic 92	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   196: return
    //   197: astore_3
    //   198: aconst_null
    //   199: astore 4
    //   201: aload_3
    //   202: astore 5
    //   204: aload 4
    //   206: invokestatic 92	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   209: aload 5
    //   211: athrow
    //   212: astore 5
    //   214: goto -10 -> 204
    //   217: astore 10
    //   219: aload_2
    //   220: astore 4
    //   222: aload 10
    //   224: astore 5
    //   226: goto -22 -> 204
    //   229: astore 16
    //   231: aload 4
    //   233: astore_2
    //   234: goto -42 -> 192
    //
    // Exception table:
    //   from	to	target	type
    //   2	18	190	java/io/IOException
    //   28	35	190	java/io/IOException
    //   42	51	190	java/io/IOException
    //   58	69	190	java/io/IOException
    //   84	131	190	java/io/IOException
    //   141	167	190	java/io/IOException
    //   173	180	190	java/io/IOException
    //   2	18	197	finally
    //   28	35	197	finally
    //   42	51	197	finally
    //   58	69	197	finally
    //   69	81	212	finally
    //   84	131	217	finally
    //   141	167	217	finally
    //   173	180	217	finally
    //   69	81	229	java/io/IOException
  }

  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    e locale = l.a(l.a(paramInputStream));
    byte[] arrayOfByte1 = locale.h(6L);
    if (!a(arrayOfByte1))
    {
      paramOutputStream.write(arrayOfByte1);
      bj.a(locale.g(), paramOutputStream);
      return;
    }
    if (b(arrayOfByte1))
    {
      paramOutputStream.write(arrayOfByte1);
      bj.a(locale.g(), paramOutputStream);
      return;
    }
    long l1 = locale.b(c);
    if (l1 != -1L)
    {
      long l2 = l1 + c.h();
      long l3 = locale.a(c, l2);
      if (l3 != -1L)
      {
        byte[] arrayOfByte2 = locale.h(l3);
        paramOutputStream.write(arrayOfByte1);
        paramOutputStream.write(arrayOfByte2);
        paramOutputStream.write(0);
        paramOutputStream.write(59);
        return;
      }
      paramOutputStream.write(arrayOfByte1);
      bj.a(locale.g(), paramOutputStream);
      return;
    }
    paramOutputStream.write(arrayOfByte1);
    bj.a(locale.g(), paramOutputStream);
  }

  private static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte.length >= 6) && ((c(paramArrayOfByte)) || (b(paramArrayOfByte)));
  }

  private static InputStream b(Uri paramUri)
    throws IOException
  {
    FileInputStream localFileInputStream;
    if (dk.b(paramUri))
      localFileInputStream = new FileInputStream(new File(paramUri.getPath()));
    boolean bool;
    do
    {
      return localFileInputStream;
      if (dk.a(paramUri))
        return ViberApplication.getApplication().getContentResolver().openInputStream(paramUri);
      bool = dk.f(paramUri);
      localFileInputStream = null;
    }
    while (!bool);
    return c(paramUri);
  }

  private static boolean b(byte[] paramArrayOfByte)
  {
    return d.a(0, paramArrayOfByte, 0, 6);
  }

  private static InputStream c(Uri paramUri)
    throws IOException
  {
    String str = paramUri.toString();
    if (!ViberApplication.getInstance().getDownloadValve().c(str))
      return null;
    OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder().connectTimeout(a, TimeUnit.MILLISECONDS).writeTimeout(a, TimeUnit.MILLISECONDS);
    Request.Builder localBuilder1 = new Request.Builder().url(str);
    localBuilder1.header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.45 Safari/535.19");
    Response localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
    if (!bg.a.d(localResponse.header("Content-Type")))
      throw new IOException("Not a gif file.");
    return localResponse.body().byteStream();
  }

  private static boolean c(byte[] paramArrayOfByte)
  {
    return e.a(0, paramArrayOfByte, 0, 6);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.aw
 * JD-Core Version:    0.6.2
 */