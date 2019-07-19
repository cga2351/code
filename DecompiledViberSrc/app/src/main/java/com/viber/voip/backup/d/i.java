package com.viber.voip.backup.d;

import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Bitmap.CompressFormat;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.entity.u;

public class i extends d<u>
{
  private static final Logger c = ViberEnv.getLogger();
  private static final Bitmap.CompressFormat d = Bitmap.CompressFormat.JPEG;
  protected ContentResolver a = ViberApplication.getApplication().getContentResolver();
  protected final int b;
  private final long e;

  public i(int paramInt, long paramLong)
  {
    this.b = paramInt;
    this.e = paramLong;
  }

  public boolean a(u paramu)
  {
    boolean bool1 = paramu.b < this.e;
    boolean bool2 = false;
    if (!bool1)
    {
      int i = paramu.d;
      if ((1 != i) && (3 != i))
      {
        bool2 = false;
        if (1005 != i);
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }

  // ERROR //
  protected byte[] b(u paramu)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: invokevirtual 72	com/viber/voip/model/entity/u:b	()Landroid/net/Uri;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnonnull +9 -> 21
    //   15: aconst_null
    //   16: astore 8
    //   18: aload 8
    //   20: areturn
    //   21: aload 4
    //   23: invokestatic 78	com/viber/voip/util/dx:q	(Landroid/net/Uri;)Z
    //   26: ifeq +29 -> 55
    //   29: aload 4
    //   31: invokestatic 82	com/viber/voip/util/dx:r	(Landroid/net/Uri;)Ljava/lang/String;
    //   34: astore 22
    //   36: aload 22
    //   38: invokestatic 87	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
    //   41: ifne +75 -> 116
    //   44: aload 22
    //   46: invokestatic 93	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   49: astore 23
    //   51: aload 23
    //   53: astore 4
    //   55: aload_0
    //   56: getfield 50	com/viber/voip/backup/d/i:a	Landroid/content/ContentResolver;
    //   59: aload 4
    //   61: invokevirtual 99	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   64: astore 9
    //   66: aload 9
    //   68: astore 6
    //   70: aload 6
    //   72: sipush 16384
    //   75: invokestatic 104	com/viber/voip/util/bj:a	(Ljava/io/InputStream;I)[B
    //   78: astore 11
    //   80: aload 11
    //   82: astore 8
    //   84: aload 8
    //   86: arraylength
    //   87: i2f
    //   88: fstore 13
    //   90: aload_0
    //   91: getfield 52	com/viber/voip/backup/d/i:b	I
    //   94: istore 14
    //   96: fload 13
    //   98: iload 14
    //   100: i2f
    //   101: fdiv
    //   102: ldc 105
    //   104: fcmpg
    //   105: ifge +13 -> 118
    //   108: aload 6
    //   110: invokestatic 108	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   113: aload 8
    //   115: areturn
    //   116: aconst_null
    //   117: areturn
    //   118: new 110	android/graphics/BitmapFactory$Options
    //   121: dup
    //   122: invokespecial 111	android/graphics/BitmapFactory$Options:<init>	()V
    //   125: astore 15
    //   127: aload 15
    //   129: getstatic 117	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   132: putfield 120	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   135: aload 8
    //   137: iconst_0
    //   138: aload 8
    //   140: arraylength
    //   141: aload 15
    //   143: invokestatic 125	com/viber/voip/util/dq:a	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   146: astore 16
    //   148: aload 16
    //   150: ifnonnull +10 -> 160
    //   153: aload 6
    //   155: invokestatic 108	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   158: aconst_null
    //   159: areturn
    //   160: bipush 100
    //   162: istore 17
    //   164: aload 8
    //   166: arraylength
    //   167: istore 18
    //   169: iload_2
    //   170: iconst_2
    //   171: if_icmpge +69 -> 240
    //   174: ldc 126
    //   176: aload_0
    //   177: getfield 52	com/viber/voip/backup/d/i:b	I
    //   180: i2f
    //   181: iload 18
    //   183: i2f
    //   184: fdiv
    //   185: fmul
    //   186: iload 17
    //   188: i2f
    //   189: fmul
    //   190: f2i
    //   191: istore 19
    //   193: iload_2
    //   194: ifne +13 -> 207
    //   197: iload 19
    //   199: bipush 15
    //   201: if_icmpgt +6 -> 207
    //   204: iinc 19 10
    //   207: aload 16
    //   209: getstatic 32	com/viber/voip/backup/d/i:d	Landroid/graphics/Bitmap$CompressFormat;
    //   212: iload 19
    //   214: invokestatic 129	com/viber/voip/util/dq:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;I)[B
    //   217: astore 8
    //   219: aload 8
    //   221: arraylength
    //   222: istore 20
    //   224: aload 8
    //   226: arraylength
    //   227: i2f
    //   228: aload_0
    //   229: getfield 52	com/viber/voip/backup/d/i:b	I
    //   232: i2f
    //   233: fdiv
    //   234: ldc 105
    //   236: fcmpg
    //   237: ifge +21 -> 258
    //   240: aload 16
    //   242: invokevirtual 134	android/graphics/Bitmap:recycle	()V
    //   245: aload 6
    //   247: invokestatic 108	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   250: aload 8
    //   252: ifnull -234 -> 18
    //   255: aload 8
    //   257: areturn
    //   258: iinc 2 1
    //   261: iload 19
    //   263: istore 17
    //   265: iload 20
    //   267: istore 18
    //   269: goto -100 -> 169
    //   272: astore 7
    //   274: aconst_null
    //   275: astore 8
    //   277: aload_3
    //   278: invokestatic 108	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   281: goto -31 -> 250
    //   284: astore 5
    //   286: aconst_null
    //   287: astore 6
    //   289: aload 6
    //   291: invokestatic 108	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   294: aload 5
    //   296: athrow
    //   297: astore 5
    //   299: goto -10 -> 289
    //   302: astore 10
    //   304: aload 6
    //   306: astore_3
    //   307: aconst_null
    //   308: astore 8
    //   310: goto -33 -> 277
    //   313: astore 12
    //   315: aload 6
    //   317: astore_3
    //   318: goto -41 -> 277
    //   321: astore 21
    //   323: goto -268 -> 55
    //
    // Exception table:
    //   from	to	target	type
    //   55	66	272	java/io/IOException
    //   55	66	284	finally
    //   70	80	297	finally
    //   84	96	297	finally
    //   118	148	297	finally
    //   164	169	297	finally
    //   174	193	297	finally
    //   207	240	297	finally
    //   240	245	297	finally
    //   70	80	302	java/io/IOException
    //   84	96	313	java/io/IOException
    //   118	148	313	java/io/IOException
    //   164	169	313	java/io/IOException
    //   174	193	313	java/io/IOException
    //   207	240	313	java/io/IOException
    //   240	245	313	java/io/IOException
    //   29	51	321	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.i
 * JD-Core Version:    0.6.2
 */