package com.viber.voip.util.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dq;
import java.io.FileDescriptor;

public abstract class i extends k
{
  private static final Logger d = ViberEnv.getLogger();

  public i(Context paramContext)
  {
    super(paramContext);
  }

  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int k = 1;
    if (((paramInt2 > 0) && (i > paramInt2)) || ((paramInt1 > 0) && (j > paramInt1)))
    {
      int m = i / 2;
      int n = j / 2;
      while ((m / k > paramInt2) && (n / k > paramInt1))
        k *= 2;
    }
    return k;
  }

  // ERROR //
  static Bitmap a(android.net.Uri paramUri, f paramf, Context paramContext)
    throws java.io.IOException, com.viber.voip.util.upload.b.a
  {
    // Byte code:
    //   0: new 24	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 38	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_3
    //   8: aload_1
    //   9: getfield 44	com/viber/voip/util/e/f:h	Z
    //   12: ifne +92 -> 104
    //   15: aload_1
    //   16: invokevirtual 48	com/viber/voip/util/e/f:g	()I
    //   19: ifle +85 -> 104
    //   22: aload_3
    //   23: iconst_1
    //   24: putfield 51	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   27: aload_2
    //   28: aload_0
    //   29: aload_1
    //   30: getfield 54	com/viber/voip/util/e/f:c	Z
    //   33: aload_1
    //   34: getfield 57	com/viber/voip/util/e/f:m	I
    //   37: aload_1
    //   38: getfield 61	com/viber/voip/util/e/f:n	Ljava/lang/String;
    //   41: invokestatic 66	com/viber/voip/util/e/e:a	(Landroid/content/Context;Landroid/net/Uri;ZILjava/lang/String;)Ljava/io/InputStream;
    //   44: astore 8
    //   46: aload 8
    //   48: ifnull +15 -> 63
    //   51: aload 8
    //   53: invokevirtual 71	java/io/InputStream:available	()I
    //   56: istore 10
    //   58: iload 10
    //   60: ifgt +10 -> 70
    //   63: aload 8
    //   65: invokestatic 76	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   68: aconst_null
    //   69: areturn
    //   70: aload 8
    //   72: aconst_null
    //   73: aload_3
    //   74: invokestatic 81	com/viber/voip/util/dq:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: pop
    //   78: aload 8
    //   80: invokestatic 76	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   83: aload_3
    //   84: aload_3
    //   85: aload_1
    //   86: invokevirtual 48	com/viber/voip/util/e/f:g	()I
    //   89: aload_1
    //   90: invokevirtual 83	com/viber/voip/util/e/f:h	()I
    //   93: invokestatic 85	com/viber/voip/util/e/i:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   96: putfield 88	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   99: aload_3
    //   100: iconst_0
    //   101: putfield 51	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   104: aload_2
    //   105: aload_0
    //   106: aload_1
    //   107: getfield 54	com/viber/voip/util/e/f:c	Z
    //   110: aload_1
    //   111: getfield 57	com/viber/voip/util/e/f:m	I
    //   114: aload_1
    //   115: getfield 61	com/viber/voip/util/e/f:n	Ljava/lang/String;
    //   118: invokestatic 66	com/viber/voip/util/e/e:a	(Landroid/content/Context;Landroid/net/Uri;ZILjava/lang/String;)Ljava/io/InputStream;
    //   121: astore 4
    //   123: aload 4
    //   125: ifnull +15 -> 140
    //   128: aload 4
    //   130: invokevirtual 71	java/io/InputStream:available	()I
    //   133: istore 6
    //   135: iload 6
    //   137: ifgt +20 -> 157
    //   140: aload 4
    //   142: invokestatic 76	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   145: aconst_null
    //   146: areturn
    //   147: astore 9
    //   149: aload 8
    //   151: invokestatic 76	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   154: aload 9
    //   156: athrow
    //   157: aload_3
    //   158: iconst_1
    //   159: putfield 91	android/graphics/BitmapFactory$Options:inMutable	Z
    //   162: aload 4
    //   164: aconst_null
    //   165: aload_3
    //   166: invokestatic 81	com/viber/voip/util/dq:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   169: astore 7
    //   171: aload 4
    //   173: invokestatic 76	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   176: aload 7
    //   178: areturn
    //   179: astore 5
    //   181: aload 4
    //   183: invokestatic 76	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   186: aload 5
    //   188: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   51	58	147	finally
    //   70	78	147	finally
    //   128	135	179	finally
    //   157	171	179	finally
  }

  public static Bitmap a(FileDescriptor paramFileDescriptor)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = false;
    return dq.a(paramFileDescriptor, null, localOptions);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.i
 * JD-Core Version:    0.6.2
 */