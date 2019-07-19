package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;

public final class bc
{
  private static final FilenameFilter a = new FilenameFilter()
  {
    public boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return paramAnonymousString.startsWith("mytrg_");
    }
  };
  private static final FilenameFilter b = new FilenameFilter()
  {
    public boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return paramAnonymousString.endsWith(".mp4");
    }
  };
  private static volatile bc c;
  private final File d;

  private bc(File paramFile)
  {
    this.d = paramFile;
  }

  private int a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws Exception
  {
    int i = 0;
    byte[] arrayOfByte = new byte[8192];
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream, 8192);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramOutputStream, 8192);
    try
    {
      while (true)
      {
        int j = localBufferedInputStream.read(arrayOfByte, 0, 8192);
        if (j == -1)
          break;
        localBufferedOutputStream.write(arrayOfByte, 0, j);
        i += j;
      }
      localBufferedOutputStream.flush();
      try
      {
        localBufferedOutputStream.close();
      }
      catch (IOException localIOException3)
      {
        try
        {
          while (true)
          {
            localBufferedInputStream.close();
            return i;
            localIOException3 = localIOException3;
            dp.a(localIOException3.getMessage());
          }
        }
        catch (IOException localIOException4)
        {
          dp.a(localIOException4.getMessage());
          return i;
        }
      }
    }
    finally
    {
    }
    try
    {
      localBufferedOutputStream.close();
    }
    catch (IOException localIOException1)
    {
      try
      {
        while (true)
        {
          localBufferedInputStream.close();
          throw localObject;
          localIOException1 = localIOException1;
          dp.a(localIOException1.getMessage());
        }
      }
      catch (IOException localIOException2)
      {
        while (true)
          dp.a(localIOException2.getMessage());
      }
    }
  }

  public static bc a(Context paramContext)
  {
    bc localbc1 = c;
    if (localbc1 == null)
      try
      {
        bc localbc2 = c;
        if (localbc2 == null)
        {
          File localFile1 = paramContext.getCacheDir();
          boolean bool = true;
          if ((localFile1 != null) && (!localFile1.exists()))
            bool = localFile1.mkdir();
          if (!bool)
          {
            dp.c("DiskCache: unable to create cache dir");
            return null;
          }
          File localFile2 = new File(localFile1, "mytargetcache");
          if (!localFile2.exists())
            bool = localFile2.mkdir();
          if (!bool)
          {
            dp.c("DiskCache: unable to create cache dir");
            return null;
          }
          if ((localFile2.isDirectory()) && (localFile2.canWrite()))
          {
            localbc2 = new bc(localFile2);
            c = localbc2;
          }
        }
        return localbc2;
      }
      finally
      {
      }
    return localbc1;
  }

  private String a(String paramString1, String paramString2)
  {
    try
    {
      a();
      File localFile = b(paramString1, paramString2);
      if (localFile.exists())
        dp.a("DiskCache get path: " + localFile.getPath());
      while (true)
      {
        try
        {
          String str2 = localFile.getAbsolutePath();
          str1 = str2;
          return str1;
        }
        catch (Exception localException)
        {
          dp.c("DiskCache exception: " + localException);
        }
        String str1 = null;
      }
    }
    finally
    {
    }
  }

  private File b(String paramString1, String paramString2)
  {
    String str = "mytrg_" + bd.a(paramString1) + paramString2;
    return new File(this.d.getAbsolutePath() + File.separator + str);
  }

  // ERROR //
  public File a(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 106	com/my/target/bc:a	()V
    //   6: aload_0
    //   7: aload_2
    //   8: ldc 148
    //   10: invokespecial 109	com/my/target/bc:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   13: astore 4
    //   15: new 111	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   22: ldc 150
    //   24: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload 4
    //   29: invokevirtual 121	java/io/File:getPath	()Ljava/lang/String;
    //   32: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 68	com/my/target/dp:a	(Ljava/lang/String;)V
    //   41: new 152	java/io/FileOutputStream
    //   44: dup
    //   45: aload 4
    //   47: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore 5
    //   52: aload_0
    //   53: aload_1
    //   54: aload 5
    //   56: invokespecial 155	com/my/target/bc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   59: pop
    //   60: aload 5
    //   62: ifnull +8 -> 70
    //   65: aload 5
    //   67: invokevirtual 158	java/io/OutputStream:close	()V
    //   70: aload_0
    //   71: monitorexit
    //   72: aload 4
    //   74: areturn
    //   75: astore 11
    //   77: new 111	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   84: ldc 129
    //   86: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 11
    //   91: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 90	com/my/target/dp:c	(Ljava/lang/String;)V
    //   100: goto -30 -> 70
    //   103: astore_3
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_3
    //   107: athrow
    //   108: astore 6
    //   110: aconst_null
    //   111: astore 5
    //   113: new 111	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   120: ldc 129
    //   122: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 6
    //   127: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 90	com/my/target/dp:c	(Ljava/lang/String;)V
    //   136: aload 5
    //   138: ifnull +8 -> 146
    //   141: aload 5
    //   143: invokevirtual 158	java/io/OutputStream:close	()V
    //   146: aconst_null
    //   147: astore 4
    //   149: goto -79 -> 70
    //   152: astore 9
    //   154: new 111	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   161: ldc 129
    //   163: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 9
    //   168: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 90	com/my/target/dp:c	(Ljava/lang/String;)V
    //   177: goto -31 -> 146
    //   180: astore 7
    //   182: aconst_null
    //   183: astore 5
    //   185: aload 5
    //   187: ifnull +8 -> 195
    //   190: aload 5
    //   192: invokevirtual 158	java/io/OutputStream:close	()V
    //   195: aload 7
    //   197: athrow
    //   198: astore 8
    //   200: new 111	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   207: ldc 129
    //   209: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 8
    //   214: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 90	com/my/target/dp:c	(Ljava/lang/String;)V
    //   223: goto -28 -> 195
    //   226: astore 7
    //   228: goto -43 -> 185
    //   231: astore 6
    //   233: goto -120 -> 113
    //
    // Exception table:
    //   from	to	target	type
    //   65	70	75	java/lang/Exception
    //   2	41	103	finally
    //   65	70	103	finally
    //   77	100	103	finally
    //   141	146	103	finally
    //   154	177	103	finally
    //   190	195	103	finally
    //   195	198	103	finally
    //   200	223	103	finally
    //   41	52	108	java/lang/Exception
    //   141	146	152	java/lang/Exception
    //   41	52	180	finally
    //   190	195	198	java/lang/Exception
    //   52	60	226	finally
    //   113	136	226	finally
    //   52	60	231	java/lang/Exception
  }

  public String a(String paramString)
  {
    return a(paramString, ".mp4");
  }

  public void a()
  {
    while (true)
    {
      int k;
      try
      {
        long l = System.currentTimeMillis();
        try
        {
          if (604800000L + this.d.lastModified() < l)
          {
            File[] arrayOfFile2 = this.d.listFiles(a);
            if (arrayOfFile2 != null)
            {
              int j = arrayOfFile2.length;
              k = 0;
              if (k < j)
              {
                File localFile = arrayOfFile2[k];
                if ((!localFile.isFile()) || (604800000L + localFile.lastModified() >= l))
                  break label343;
                dp.a("DiskCache: remove expired file " + localFile.getPath());
                if (localFile.delete())
                  break label343;
                dp.a("DiskCache: unable to delete file " + localFile.getAbsolutePath());
                break label343;
              }
            }
            if (!this.d.setLastModified(l))
              dp.a("DiskCache: unable to set last modified to dir " + this.d.getAbsolutePath());
          }
          File[] arrayOfFile1 = this.d.listFiles(b);
          if ((arrayOfFile1 != null) && (arrayOfFile1.length > 10))
          {
            Arrays.sort(arrayOfFile1, new Comparator()
            {
              public int a(File paramAnonymousFile1, File paramAnonymousFile2)
              {
                return Long.valueOf(paramAnonymousFile2.lastModified()).compareTo(Long.valueOf(paramAnonymousFile1.lastModified()));
              }
            });
            int i = -1 + arrayOfFile1.length;
            if (i >= 10)
            {
              String str = arrayOfFile1[i].getPath();
              dp.a("DiskCache: remove redundant video " + str);
              if (!arrayOfFile1[i].delete())
                dp.a("DiskCache: unable to remove file " + str);
              i--;
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          dp.c("DiskCache exception: " + localException);
          return;
        }
      }
      finally
      {
      }
      label343: k++;
    }
  }

  // ERROR //
  public File b(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 106	com/my/target/bc:a	()V
    //   6: aload_0
    //   7: aload_2
    //   8: ldc 160
    //   10: invokespecial 109	com/my/target/bc:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   13: astore 4
    //   15: new 111	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   22: ldc 210
    //   24: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload 4
    //   29: invokevirtual 121	java/io/File:getPath	()Ljava/lang/String;
    //   32: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 68	com/my/target/dp:a	(Ljava/lang/String;)V
    //   41: new 152	java/io/FileOutputStream
    //   44: dup
    //   45: aload 4
    //   47: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore 5
    //   52: aload_0
    //   53: aload_1
    //   54: aload 5
    //   56: invokespecial 155	com/my/target/bc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   59: pop
    //   60: aload 5
    //   62: ifnull +8 -> 70
    //   65: aload 5
    //   67: invokevirtual 158	java/io/OutputStream:close	()V
    //   70: aload_0
    //   71: monitorexit
    //   72: aload 4
    //   74: areturn
    //   75: astore 11
    //   77: new 111	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   84: ldc 129
    //   86: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 11
    //   91: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 90	com/my/target/dp:c	(Ljava/lang/String;)V
    //   100: goto -30 -> 70
    //   103: astore_3
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_3
    //   107: athrow
    //   108: astore 6
    //   110: aconst_null
    //   111: astore 5
    //   113: new 111	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   120: ldc 129
    //   122: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 6
    //   127: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 90	com/my/target/dp:c	(Ljava/lang/String;)V
    //   136: aload 5
    //   138: ifnull +8 -> 146
    //   141: aload 5
    //   143: invokevirtual 158	java/io/OutputStream:close	()V
    //   146: aconst_null
    //   147: astore 4
    //   149: goto -79 -> 70
    //   152: astore 9
    //   154: new 111	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   161: ldc 129
    //   163: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 9
    //   168: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 90	com/my/target/dp:c	(Ljava/lang/String;)V
    //   177: goto -31 -> 146
    //   180: astore 7
    //   182: aconst_null
    //   183: astore 5
    //   185: aload 5
    //   187: ifnull +8 -> 195
    //   190: aload 5
    //   192: invokevirtual 158	java/io/OutputStream:close	()V
    //   195: aload 7
    //   197: athrow
    //   198: astore 8
    //   200: new 111	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   207: ldc 129
    //   209: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 8
    //   214: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 90	com/my/target/dp:c	(Ljava/lang/String;)V
    //   223: goto -28 -> 195
    //   226: astore 7
    //   228: goto -43 -> 185
    //   231: astore 6
    //   233: goto -120 -> 113
    //
    // Exception table:
    //   from	to	target	type
    //   65	70	75	java/io/IOException
    //   2	41	103	finally
    //   65	70	103	finally
    //   77	100	103	finally
    //   141	146	103	finally
    //   154	177	103	finally
    //   190	195	103	finally
    //   195	198	103	finally
    //   200	223	103	finally
    //   41	52	108	java/lang/Exception
    //   141	146	152	java/io/IOException
    //   41	52	180	finally
    //   190	195	198	java/io/IOException
    //   52	60	226	finally
    //   113	136	226	finally
    //   52	60	231	java/lang/Exception
  }

  public String b(String paramString)
  {
    return a(paramString, ".img");
  }

  public Bitmap c(String paramString)
  {
    while (true)
    {
      try
      {
        a();
        File localFile = b(paramString, ".img");
        if (localFile.exists())
        {
          dp.a("DiskCache get image: " + localFile.getPath());
          try
          {
            Bitmap localBitmap2 = BitmapFactory.decodeFile(localFile.getAbsolutePath());
            localObject2 = localBitmap2;
            return localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            System.gc();
            dp.c("DiskCache OOME, trying once again");
            try
            {
              BitmapFactory.Options localOptions = new BitmapFactory.Options();
              localOptions.inSampleSize = 2;
              Bitmap localBitmap1 = BitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
              localObject2 = localBitmap1;
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              dp.c("DiskCache OOME, called twice: " + localOutOfMemoryError1);
            }
          }
          catch (Exception localException)
          {
            dp.c("DiskCache exception: " + localException);
          }
        }
      }
      finally
      {
      }
      Object localObject2 = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bc
 * JD-Core Version:    0.6.2
 */