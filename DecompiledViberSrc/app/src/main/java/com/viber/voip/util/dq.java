package com.viber.voip.util;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.provider.MediaStore.Video.Thumbnails;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.b.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;

public final class dq
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Object b = new Object();

  public static Bitmap a(ContentResolver paramContentResolver, long paramLong, int paramInt, BitmapFactory.Options paramOptions)
  {
    if (paramOptions == null)
      paramOptions = new BitmapFactory.Options();
    a(paramOptions);
    try
    {
      synchronized (b)
      {
        Bitmap localBitmap = MediaStore.Video.Thumbnails.getThumbnail(paramContentResolver, paramLong, paramInt, paramOptions);
        return localBitmap;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    finally
    {
      b(paramOptions);
    }
  }

  public static Bitmap a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, new BitmapFactory.Options());
  }

  public static Bitmap a(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    a(paramOptions);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(paramResources, paramInt, paramOptions);
      return localBitmap;
    }
    finally
    {
      b(paramOptions);
    }
  }

  public static Bitmap a(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    a(paramOptions);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, paramRect, paramOptions);
      return localBitmap;
    }
    finally
    {
      b(paramOptions);
    }
  }

  public static Bitmap a(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    a(localOptions);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      return localBitmap;
    }
    finally
    {
      b(localOptions);
    }
  }

  public static Bitmap a(InputStream paramInputStream, BitmapFactory.Options paramOptions)
  {
    a(paramOptions);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
      return localBitmap;
    }
    finally
    {
      b(paramOptions);
    }
  }

  public static Bitmap a(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    a(paramOptions);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramInputStream, paramRect, paramOptions);
      return localBitmap;
    }
    finally
    {
      b(paramOptions);
    }
  }

  public static Bitmap a(String paramString)
  {
    return a(paramString, new BitmapFactory.Options());
  }

  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    a(paramOptions);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      return localBitmap;
    }
    finally
    {
      b(paramOptions);
    }
  }

  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    a(paramOptions);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
      return localBitmap;
    }
    finally
    {
      b(paramOptions);
    }
  }

  private static void a(BitmapFactory.Options paramOptions)
  {
    if ((paramOptions != null) && (paramOptions.inTempStorage == null))
      paramOptions.inTempStorage = a.a(65536);
  }

  public static boolean a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, File paramFile)
    throws FileNotFoundException
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      boolean bool = a(paramBitmap, paramCompressFormat, paramInt, localFileOutputStream);
      return bool;
    }
    finally
    {
      bj.a(new Flushable[] { localFileOutputStream });
      bj.a(localFileOutputStream);
    }
  }

  public static boolean a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, OutputStream paramOutputStream)
  {
    if (paramInt > 100)
      paramInt = 100;
    return paramBitmap.compress(paramCompressFormat, paramInt, paramOutputStream);
  }

  public static boolean a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
    throws FileNotFoundException
  {
    return a(paramBitmap, paramCompressFormat, paramInt, new File(paramString));
  }

  public static byte[] a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(16384);
    try
    {
      a(paramBitmap, paramCompressFormat, paramInt, localByteArrayOutputStream);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      return arrayOfByte;
    }
    finally
    {
      bj.a(localByteArrayOutputStream);
    }
  }

  // ERROR //
  public static Bitmap b(ContentResolver paramContentResolver, long paramLong, int paramInt, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnonnull +12 -> 14
    //   5: new 28	android/graphics/BitmapFactory$Options
    //   8: dup
    //   9: invokespecial 29	android/graphics/BitmapFactory$Options:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: invokestatic 32	com/viber/voip/util/dq:a	(Landroid/graphics/BitmapFactory$Options;)V
    //   19: getstatic 23	com/viber/voip/util/dq:b	Ljava/lang/Object;
    //   22: astore 8
    //   24: aload 8
    //   26: monitorenter
    //   27: aload_0
    //   28: lload_1
    //   29: iload_3
    //   30: aload 4
    //   32: invokestatic 132	android/provider/MediaStore$Images$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   35: astore 10
    //   37: aload 8
    //   39: monitorexit
    //   40: aload 4
    //   42: invokestatic 39	com/viber/voip/util/dq:b	(Landroid/graphics/BitmapFactory$Options;)V
    //   45: aload 10
    //   47: areturn
    //   48: astore 9
    //   50: aload 8
    //   52: monitorexit
    //   53: aload 9
    //   55: athrow
    //   56: astore 7
    //   58: aload 4
    //   60: invokestatic 39	com/viber/voip/util/dq:b	(Landroid/graphics/BitmapFactory$Options;)V
    //   63: aconst_null
    //   64: areturn
    //   65: astore 6
    //   67: aload 4
    //   69: invokestatic 39	com/viber/voip/util/dq:b	(Landroid/graphics/BitmapFactory$Options;)V
    //   72: aload 6
    //   74: athrow
    //   75: astore 5
    //   77: goto -19 -> 58
    //
    // Exception table:
    //   from	to	target	type
    //   27	40	48	finally
    //   50	53	48	finally
    //   19	27	56	java/lang/Exception
    //   53	56	56	java/lang/Exception
    //   19	27	65	finally
    //   53	56	65	finally
    //   19	27	75	java/lang/OutOfMemoryError
    //   53	56	75	java/lang/OutOfMemoryError
  }

  private static void b(BitmapFactory.Options paramOptions)
  {
    if ((paramOptions != null) && (paramOptions.inTempStorage != null))
    {
      a.a(paramOptions.inTempStorage);
      paramOptions.inTempStorage = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dq
 * JD-Core Version:    0.6.2
 */