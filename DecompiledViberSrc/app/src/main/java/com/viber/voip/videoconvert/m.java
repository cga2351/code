package com.viber.voip.videoconvert;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.media.ThumbnailUtils;
import android.util.Base64;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class m
{
  static String a(int paramInt, boolean paramBoolean)
  {
    int i = Color.red(paramInt);
    int j = Color.green(paramInt);
    int k = Color.blue(paramInt);
    if (paramBoolean);
    for (String str = "%1X%1X%1X"; ; str = "%1x%1x%1x")
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(i >> 4);
      arrayOfObject[1] = Integer.valueOf(j >> 4);
      arrayOfObject[2] = Integer.valueOf(k >> 4);
      return String.format(str, arrayOfObject);
    }
  }

  static String a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int[] arrayOfInt = new int[i * j];
    paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(i);
    arrayOfObject[1] = Integer.valueOf(j);
    Object localObject1 = String.format("%dx%d:", arrayOfObject);
    for (int k = -4 + i / 2; k < 4 + i / 2; k++)
    {
      int i5 = -4 + j / 2;
      if (i5 < 4 + j / 2)
      {
        if (k >= i);
        for (Object localObject2 = localObject1; ; localObject2 = localObject1)
        {
          i5++;
          localObject1 = localObject2;
          break;
          if (i5 < j)
            break label127;
        }
        label127: StringBuilder localStringBuilder3 = new StringBuilder().append((String)localObject1);
        int i6 = arrayOfInt[(k + i5 * i)];
        if (k % 2 == 0);
        for (boolean bool3 = true; ; bool3 = false)
        {
          localObject2 = a(i6, bool3);
          break;
        }
      }
    }
    String str1 = (String)localObject1 + ",";
    int m = 0;
    if (m < 48)
    {
      if (m >= i);
      while (m >= j)
      {
        m++;
        break;
      }
      StringBuilder localStringBuilder2 = new StringBuilder().append(str1);
      int i4 = arrayOfInt[(m + m * i)];
      if (m % 2 == 0);
      for (boolean bool2 = true; ; bool2 = false)
      {
        str1 = a(i4, bool2);
        break;
      }
    }
    String str2 = str1 + ",";
    int n = 0;
    if (n < 48)
    {
      int i1 = i - 1 - n;
      int i2 = j - 1 - n;
      if (i1 < 0);
      while (i2 < 0)
      {
        n++;
        break;
      }
      StringBuilder localStringBuilder1 = new StringBuilder().append(str2);
      int i3 = arrayOfInt[(i1 + i2 * i)];
      if (i1 % 2 == 0);
      for (boolean bool1 = true; ; bool1 = false)
      {
        str2 = a(i3, bool1);
        break;
      }
    }
    return str2;
  }

  static String a(String paramString)
  {
    File localFile = new File(paramString);
    long l = localFile.length();
    String str1;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      byte[] arrayOfByte = new byte[32];
      int i = localFileInputStream.read(arrayOfByte);
      if (i != -1)
      {
        String str2 = Base64.encodeToString(arrayOfByte, 0, i, 2);
        str1 = "l=" + Long.toString(l) + "," + str2;
        if (l > 96L)
        {
          localFileInputStream.skip(l - 48L - 48L);
          String str3 = Base64.encodeToString(arrayOfByte, 0, localFileInputStream.read(arrayOfByte), 2);
          return str1 + "," + str3;
        }
      }
      else
      {
        String str4 = "file can't be read 2, len=" + Long.toString(l);
        return str4;
      }
    }
    catch (Exception localException)
    {
      str1 = "file can't be read 1";
    }
    return str1;
  }

  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1024];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  private void a(String paramString1, String paramString2)
  {
    try
    {
      a(new FileInputStream(paramString1), new FileOutputStream(paramString2));
      return;
    }
    catch (Exception localException)
    {
      e.a().a(localException.toString());
    }
  }

  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Color.red(paramInt2);
    int j = Color.green(paramInt2);
    int k = Color.blue(paramInt2);
    int m = Color.red(paramInt1);
    int n = Color.green(paramInt1);
    int i1 = Color.blue(paramInt1);
    return (i <= m + paramInt3) && (i >= m - paramInt3) && (j <= n + paramInt3) && (j >= n - paramInt3) && (k <= i1 + paramInt3) && (k >= i1 - paramInt3);
  }

  private static boolean a(Bitmap paramBitmap, int paramInt, a parama)
  {
    if (paramBitmap == null)
    {
      e.a().a("verifyConfiguration: input bitmap is null");
      return false;
    }
    e locale1 = e.a();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(paramBitmap.getWidth());
    arrayOfObject1[1] = Integer.valueOf(paramBitmap.getHeight());
    locale1.a(String.format("verifyConfiguration: input bitmap has dimensions %dx%d", arrayOfObject1));
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int[] arrayOfInt = new int[i * j];
    paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    e.a().a("verifyConfiguration: value of top left pixel " + Integer.toHexString(arrayOfInt[0]));
    int k = 0;
    int m = 0;
    int n = 64;
    while (n < j - 64)
    {
      int i13 = m;
      int i14 = k;
      int i15 = 64;
      if (i15 < i - 64)
      {
        if (a(paramInt, arrayOfInt[(i15 + n * i)], 60))
          i13++;
        while (true)
        {
          i15++;
          break;
          i14++;
        }
      }
      n++;
      k = i14;
      m = i13;
    }
    double d = 1.0D * k / (m + k);
    e locale2 = e.a();
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(k);
    arrayOfObject2[1] = Double.valueOf(100.0D * d);
    locale2.a(String.format("verifyConfiguration: %d pixels (%6f per cent) are not OK", arrayOfObject2));
    if (d > 0.001944444444444445D)
      return false;
    if ((i < 128) || (j < 128) || (parama == null))
      return true;
    int i1 = 0;
    if (i1 < 64)
    {
      int i11 = 0;
      for (int i12 = 64; ; i12++)
        if (i12 < i - 64)
        {
          if (!a(paramInt, arrayOfInt[(i12 + i * (-1 + (j - i1)))], 60))
          {
            i11++;
            if (i11 >= 5)
              parama.a = (i1 + 1);
          }
        }
        else
        {
          i1++;
          break;
        }
    }
    int i2 = 0;
    if (i2 < 64)
    {
      int i9 = 0;
      for (int i10 = 64; ; i10++)
        if (i10 < i - 64)
        {
          if (!a(paramInt, arrayOfInt[(i10 + i2 * i)], 60))
          {
            i9++;
            if (i9 >= 5)
              parama.b = (i2 + 1);
          }
        }
        else
        {
          i2++;
          break;
        }
    }
    int i3 = 0;
    if (i3 < 64)
    {
      int i7 = 0;
      for (int i8 = 64; ; i8++)
        if (i8 < j - 64)
        {
          if (!a(paramInt, arrayOfInt[(-1 + (i - i3) + i8 * i)], 60))
          {
            i7++;
            if (i7 >= 5)
              parama.c = (i3 + 1);
          }
        }
        else
        {
          i3++;
          break;
        }
    }
    int i4 = 0;
    if (i4 < 64)
    {
      int i5 = 0;
      for (int i6 = 64; ; i6++)
        if (i6 < j - 64)
        {
          if (!a(paramInt, arrayOfInt[(i4 + i6 * i)], 60))
          {
            i5++;
            if (i5 >= 5)
              parama.d = (i4 + 1);
          }
        }
        else
        {
          i4++;
          break;
        }
    }
    e locale3 = e.a();
    Object[] arrayOfObject3 = new Object[4];
    arrayOfObject3[0] = Integer.valueOf(parama.b);
    arrayOfObject3[1] = Integer.valueOf(parama.a);
    arrayOfObject3[2] = Integer.valueOf(parama.c);
    arrayOfObject3[3] = Integer.valueOf(parama.d);
    locale3.a(String.format("verifyConfiguration: Cropping parameters: shave %d,%d,%d,%d pixels from top,bottom,left,right respectively", arrayOfObject3));
    return true;
  }

  private static String b(String paramString)
  {
    return VideoConverterService.b().getExternalFilesDir(null) + "/" + paramString;
  }

  // ERROR //
  private static void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: invokestatic 194	com/viber/voip/videoconvert/VideoConverterService:b	()Landroid/content/Context;
    //   7: invokevirtual 211	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   10: astore 4
    //   12: aload 4
    //   14: aload_1
    //   15: invokevirtual 217	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore 10
    //   20: aload 10
    //   22: astore 6
    //   24: new 74	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokestatic 219	com/viber/voip/videoconvert/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 11
    //   37: aload 11
    //   39: invokevirtual 223	java/io/File:exists	()Z
    //   42: ifeq +212 -> 254
    //   45: aload 11
    //   47: invokevirtual 226	java/io/File:lastModified	()J
    //   50: lstore 15
    //   52: invokestatic 194	com/viber/voip/videoconvert/VideoConverterService:b	()Landroid/content/Context;
    //   55: invokevirtual 230	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   58: invokestatic 194	com/viber/voip/videoconvert/VideoConverterService:b	()Landroid/content/Context;
    //   61: invokevirtual 233	android/content/Context:getPackageName	()Ljava/lang/String;
    //   64: iconst_0
    //   65: invokevirtual 239	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   68: astore 18
    //   70: invokestatic 145	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   73: astore 19
    //   75: iconst_2
    //   76: anewarray 4	java/lang/Object
    //   79: astore 20
    //   81: aload 20
    //   83: iconst_0
    //   84: lload 15
    //   86: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: aastore
    //   90: aload 20
    //   92: iconst_1
    //   93: aload 18
    //   95: getfield 248	android/content/pm/PackageInfo:lastUpdateTime	J
    //   98: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   101: aastore
    //   102: aload 19
    //   104: ldc 250
    //   106: aload 20
    //   108: invokestatic 36	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   111: invokevirtual 148	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   114: lload 15
    //   116: aload 18
    //   118: getfield 248	android/content/pm/PackageInfo:lastUpdateTime	J
    //   121: lcmp
    //   122: ifle +115 -> 237
    //   125: invokestatic 145	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   128: new 56	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   135: ldc 252
    //   137: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 205
    //   146: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 254
    //   155: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 148	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   164: iload_3
    //   165: ifeq +245 -> 410
    //   168: new 137	java/io/FileOutputStream
    //   171: dup
    //   172: aload 11
    //   174: invokespecial 255	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   177: astore 12
    //   179: aload 6
    //   181: aload 12
    //   183: invokestatic 140	com/viber/voip/videoconvert/m:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   186: invokestatic 145	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   189: new 56	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 257
    //   199: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_0
    //   203: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 205
    //   208: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 254
    //   217: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokevirtual 148	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   226: aload 6
    //   228: invokestatic 259	com/viber/voip/videoconvert/m:a	(Ljava/io/Closeable;)V
    //   231: aload 12
    //   233: invokestatic 259	com/viber/voip/videoconvert/m:a	(Ljava/io/Closeable;)V
    //   236: return
    //   237: iconst_1
    //   238: istore_3
    //   239: goto -75 -> 164
    //   242: astore 17
    //   244: aload 17
    //   246: invokevirtual 262	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   249: iconst_1
    //   250: istore_3
    //   251: goto -87 -> 164
    //   254: iconst_1
    //   255: istore_3
    //   256: goto -92 -> 164
    //   259: astore 7
    //   261: aconst_null
    //   262: astore 8
    //   264: invokestatic 145	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   267: new 56	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 264
    //   277: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 205
    //   286: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_1
    //   290: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 266
    //   296: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 7
    //   301: invokevirtual 267	java/io/IOException:toString	()Ljava/lang/String;
    //   304: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokevirtual 148	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   313: new 74	java/io/File
    //   316: dup
    //   317: aload_1
    //   318: invokestatic 219	com/viber/voip/videoconvert/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   321: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   324: invokevirtual 270	java/io/File:delete	()Z
    //   327: pop
    //   328: aload 8
    //   330: invokestatic 259	com/viber/voip/videoconvert/m:a	(Ljava/io/Closeable;)V
    //   333: aload_2
    //   334: invokestatic 259	com/viber/voip/videoconvert/m:a	(Ljava/io/Closeable;)V
    //   337: return
    //   338: astore 5
    //   340: aconst_null
    //   341: astore 6
    //   343: aload 6
    //   345: invokestatic 259	com/viber/voip/videoconvert/m:a	(Ljava/io/Closeable;)V
    //   348: aload_2
    //   349: invokestatic 259	com/viber/voip/videoconvert/m:a	(Ljava/io/Closeable;)V
    //   352: aload 5
    //   354: athrow
    //   355: astore 5
    //   357: aconst_null
    //   358: astore_2
    //   359: goto -16 -> 343
    //   362: astore 14
    //   364: aload 12
    //   366: astore_2
    //   367: aload 14
    //   369: astore 5
    //   371: goto -28 -> 343
    //   374: astore 5
    //   376: aload 8
    //   378: astore 6
    //   380: goto -37 -> 343
    //   383: astore 7
    //   385: aload 6
    //   387: astore 8
    //   389: aconst_null
    //   390: astore_2
    //   391: goto -127 -> 264
    //   394: astore 13
    //   396: aload 12
    //   398: astore_2
    //   399: aload 13
    //   401: astore 7
    //   403: aload 6
    //   405: astore 8
    //   407: goto -143 -> 264
    //   410: aconst_null
    //   411: astore 12
    //   413: goto -187 -> 226
    //
    // Exception table:
    //   from	to	target	type
    //   52	164	242	android/content/pm/PackageManager$NameNotFoundException
    //   12	20	259	java/io/IOException
    //   12	20	338	finally
    //   24	52	355	finally
    //   52	164	355	finally
    //   168	179	355	finally
    //   244	249	355	finally
    //   179	226	362	finally
    //   264	328	374	finally
    //   24	52	383	java/io/IOException
    //   52	164	383	java/io/IOException
    //   168	179	383	java/io/IOException
    //   244	249	383	java/io/IOException
    //   179	226	394	java/io/IOException
  }

  public c a(b paramb)
  {
    if ("".equals("skipVerify"))
    {
      c localc1 = new c();
      localc1.c = paramb;
      localc1.b = null;
      localc1.a = true;
      localc1.d = false;
      localc1.e = null;
      return localc1;
    }
    b("/assets", "sample.mp4");
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(paramb.c);
    arrayOfObject1[1] = Integer.valueOf(paramb.d);
    b("/assets", String.format("sample_%dx%d.mp4", arrayOfObject1));
    int i = paramb.c;
    int j = paramb.d;
    int k = paramb.e;
    int m = paramb.f;
    c localc = paramb.a;
    a locala = new a();
    c localc2 = new c();
    localc2.c = paramb;
    String str1 = b("sample.mp4");
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(i);
    arrayOfObject2[1] = Integer.valueOf(j);
    String str2 = b(String.format("sample_%dx%d.mp4", arrayOfObject2));
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = Integer.valueOf(i);
    arrayOfObject3[1] = Integer.valueOf(j);
    String str3 = b(String.format("intermediate_%dx%d.mp4", arrayOfObject3));
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = Integer.valueOf(k);
    arrayOfObject4[1] = Integer.valueOf(m);
    String str4 = b(String.format("videocheck_%dx%d.mp4", arrayOfObject4));
    Object[] arrayOfObject5 = new Object[2];
    arrayOfObject5[0] = Integer.valueOf(k);
    arrayOfObject5[1] = Integer.valueOf(m);
    String str5 = b(String.format("videocheck_%dx%d_unpacked", arrayOfObject5));
    String str6 = localc.b();
    e.a().a("verifyConfiguration checking " + str6);
    e.a().a("verifyConfiguration using files: " + str1 + " " + str2 + " " + str3 + " " + str4 + " " + str5);
    if ((new File(str4).exists()) && (!new File(str4).delete()))
    {
      e.a().a("verifyConfiguration can't delete " + str4);
      localc2.a = false;
      localc2.b = "Can't delete pre-existing converted sample file";
      return localc2;
    }
    long l1 = System.nanoTime();
    if (new File(str2).exists())
    {
      e.a().a("verifyConfiguration phase 1: sample of the appropriate size already exists");
      str3 = str2;
    }
    while (true)
    {
      e.a().a("verifyConfiguration phase 2: convert resized sample to the destination resultion");
      try
      {
        g localg2 = new g();
        localg2.a = str3;
        localg2.b = paramb.b;
        localg2.c = 25.0D;
        localg2.d = 0;
        localg2.e = i;
        localg2.f = j;
        localg2.g = str4;
        localg2.h = k;
        localg2.i = m;
        localg2.j = 100000;
        localg2.k = 0;
        localg2.l = null;
        localg2.m = Integer.valueOf(30000);
        localg2.n = false;
        localg2.o = locala;
        boolean bool2 = localc.a(localg2);
        long l5 = System.nanoTime();
        e.a().a("verifyConfiguration phase 2: isEncodingSuccessfull=" + Boolean.toString(bool2));
        if (!bool2)
        {
          localc2.a = false;
          localc2.b = ("converting failed and no sample, took millis: " + Long.toString((l5 - l1) / 1000000L));
          return localc2;
          e.a().a("verifyConfiguration phase 1: resize a sample to the source size");
          try
          {
            g localg1 = new g();
            localg1.a = str1;
            localg1.b = str1;
            localg1.c = 25.0D;
            localg1.d = 0;
            localg1.e = 640;
            localg1.f = 360;
            localg1.g = str3;
            localg1.h = i;
            localg1.i = j;
            localg1.j = 100000;
            localg1.k = 0;
            localg1.l = null;
            localg1.m = Integer.valueOf(30000);
            localg1.n = false;
            localg1.o = locala;
            boolean bool1 = localc.a(localg1);
            long l3 = System.nanoTime();
            e.a().a("verifyConfiguration phase 1: isEncodingSuccessfull=" + Boolean.toString(bool1));
            if (!bool1)
            {
              localc2.a = false;
              localc2.b = ("preconverting failed and no sample, took millis: " + Long.toString((l3 - l1) / 1000000L));
              return localc2;
            }
          }
          catch (Throwable localThrowable1)
          {
            long l2 = System.nanoTime();
            localThrowable1.printStackTrace();
            localc2.a = false;
            localc2.b = ("pre-converting: " + localThrowable1.toString() + ", took millis: " + Long.toString((l2 - l1) / 1000000L));
            return localc2;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        long l4 = System.nanoTime();
        localThrowable2.printStackTrace();
        localc2.a = false;
        localc2.b = ("converting: " + localThrowable2.toString() + ", took millis: " + Long.toString((l4 - l1) / 1000000L));
        return localc2;
      }
    }
    e.a().a("verifyConfiguration phase 3: create thumbnail of the converted video");
    Bitmap localBitmap = ThumbnailUtils.createVideoThumbnail(str4, 2);
    if (localBitmap == null)
    {
      e.a().a("verifyConfiguration phase 3: Can't get thumbnail");
      a(str4, "/sdcard/cant_get_thumbnail_" + str6 + ".mp4");
      localc2.a = false;
      localc2.b = ("can't get thumbnail; " + a(str4));
      return localc2;
    }
    e.a().a("verifyConfiguration: analyse resulting bitmap for artifacts");
    localc2.e = new a();
    boolean bool3 = a(localBitmap, -763880, localc2.e);
    boolean bool4 = false;
    if (!bool3)
    {
      bool3 = a(localBitmap, -14647041, localc2.e);
      if (bool3)
        e.a().a("verifyConfiguration: Looks like U and V channels swapped here");
      bool4 = true;
    }
    if (!bool3)
      a(str4, "/sdcard/wrong_colour_" + str6 + ".mp4");
    try
    {
      localBitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream("/sdcard/wrong_colour_" + str6 + ".png"));
      label1367: localc2.a = false;
      localc2.b = a(localBitmap);
      return localc2;
      if (!new File(str2).exists())
        a(str3, str2);
      localc2.b = null;
      localc2.a = true;
      localc2.d = bool4;
      return localc2;
    }
    catch (Exception localException)
    {
      break label1367;
    }
  }

  public static class a
  {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
  }

  public static class b
  {
    public c a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
  }

  public static class c
  {
    public boolean a;
    public String b;
    public m.b c;
    public boolean d;
    public m.a e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.m
 * JD-Core Version:    0.6.2
 */