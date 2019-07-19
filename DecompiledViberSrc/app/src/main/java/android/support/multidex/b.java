package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class b
  implements Closeable
{
  private final File a;
  private final long b;
  private final File c;
  private final RandomAccessFile d;
  private final FileChannel e;
  private final FileLock f;

  // ERROR //
  b(File paramFile1, File paramFile2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 28	java/lang/Object:<init>	()V
    //   4: ldc 30
    //   6: new 32	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   13: ldc 35
    //   15: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: invokevirtual 45	java/io/File:getPath	()Ljava/lang/String;
    //   22: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 47
    //   27: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 45	java/io/File:getPath	()Ljava/lang/String;
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 49
    //   39: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 58	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   48: pop
    //   49: aload_0
    //   50: aload_1
    //   51: putfield 60	android/support/multidex/b:a	Ljava/io/File;
    //   54: aload_0
    //   55: aload_2
    //   56: putfield 62	android/support/multidex/b:c	Ljava/io/File;
    //   59: aload_0
    //   60: aload_1
    //   61: invokestatic 65	android/support/multidex/b:b	(Ljava/io/File;)J
    //   64: putfield 67	android/support/multidex/b:b	J
    //   67: new 41	java/io/File
    //   70: dup
    //   71: aload_2
    //   72: ldc 69
    //   74: invokespecial 72	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   77: astore 4
    //   79: aload_0
    //   80: new 74	java/io/RandomAccessFile
    //   83: dup
    //   84: aload 4
    //   86: ldc 76
    //   88: invokespecial 77	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   91: putfield 79	android/support/multidex/b:d	Ljava/io/RandomAccessFile;
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 79	android/support/multidex/b:d	Ljava/io/RandomAccessFile;
    //   99: invokevirtual 83	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   102: putfield 85	android/support/multidex/b:e	Ljava/nio/channels/FileChannel;
    //   105: ldc 30
    //   107: new 32	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   114: ldc 87
    //   116: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 4
    //   121: invokevirtual 45	java/io/File:getPath	()Ljava/lang/String;
    //   124: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 58	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   133: pop
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 85	android/support/multidex/b:e	Ljava/nio/channels/FileChannel;
    //   139: invokevirtual 93	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   142: putfield 95	android/support/multidex/b:f	Ljava/nio/channels/FileLock;
    //   145: ldc 30
    //   147: new 32	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   154: aload 4
    //   156: invokevirtual 45	java/io/File:getPath	()Ljava/lang/String;
    //   159: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 97
    //   164: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 58	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   173: pop
    //   174: return
    //   175: aload_0
    //   176: getfield 85	android/support/multidex/b:e	Ljava/nio/channels/FileChannel;
    //   179: invokestatic 100	android/support/multidex/b:a	(Ljava/io/Closeable;)V
    //   182: aload 6
    //   184: athrow
    //   185: astore 5
    //   187: aload_0
    //   188: getfield 79	android/support/multidex/b:d	Ljava/io/RandomAccessFile;
    //   191: invokestatic 100	android/support/multidex/b:a	(Ljava/io/Closeable;)V
    //   194: aload 5
    //   196: athrow
    //   197: astore 5
    //   199: goto -12 -> 187
    //   202: astore 5
    //   204: goto -17 -> 187
    //   207: astore 6
    //   209: goto -34 -> 175
    //   212: astore 6
    //   214: goto -39 -> 175
    //   217: astore 6
    //   219: goto -44 -> 175
    //
    // Exception table:
    //   from	to	target	type
    //   94	105	185	java/io/IOException
    //   145	174	185	java/io/IOException
    //   175	185	185	java/io/IOException
    //   94	105	197	java/lang/RuntimeException
    //   145	174	197	java/lang/RuntimeException
    //   175	185	197	java/lang/RuntimeException
    //   94	105	202	java/lang/Error
    //   145	174	202	java/lang/Error
    //   175	185	202	java/lang/Error
    //   105	145	207	java/lang/Error
    //   105	145	212	java/io/IOException
    //   105	145	217	java/lang/RuntimeException
  }

  private static long a(File paramFile)
  {
    long l = paramFile.lastModified();
    if (l == -1L)
      l -= 1L;
    return l;
  }

  private static SharedPreferences a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11);
    for (int i = 0; ; i = 4)
      return paramContext.getSharedPreferences("multidex.version", i);
  }

  private List<a> a()
    throws IOException
  {
    String str1 = this.a.getName() + ".classes";
    b();
    ArrayList localArrayList = new ArrayList();
    ZipFile localZipFile = new ZipFile(this.a);
    try
    {
      localObject2 = localZipFile.getEntry("classes" + 2 + ".dex");
      i = 2;
      if (localObject2 != null)
      {
        String str2 = str1 + i + ".zip";
        a locala = new a(this.c, str2);
        localArrayList.add(locala);
        Log.i("MultiDex", "Extraction is needed for file " + locala);
        int j = 0;
        k = 0;
        while (true)
          if ((k < 3) && (j == 0))
          {
            n = k + 1;
            a(localZipFile, (ZipEntry)localObject2, locala, str1);
            try
            {
              locala.a = b(locala);
              j = 1;
              StringBuilder localStringBuilder = new StringBuilder().append("Extraction ");
              if (j == 0)
                break label536;
              str3 = "succeeded";
              Log.i("MultiDex", str3 + " '" + locala.getAbsolutePath() + "': length " + locala.length() + " - crc: " + locala.a);
              if (j != 0)
                break label529;
              locala.delete();
              if (!locala.exists())
                break label529;
              Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + locala.getPath() + "'");
              k = n;
            }
            catch (IOException localIOException2)
            {
              while (true)
              {
                Log.w("MultiDex", "Failed to read crc from " + locala.getAbsolutePath(), localIOException2);
                j = 0;
              }
            }
          }
        if (j == 0)
          throw new IOException("Could not create zip file " + locala.getAbsolutePath() + " for secondary dex (" + i + ")");
      }
    }
    finally
    {
      while (true)
      {
        int n;
        try
        {
          localZipFile.close();
          throw localObject1;
          int m = i + 1;
          ZipEntry localZipEntry = localZipFile.getEntry("classes" + m + ".dex");
          Object localObject2 = localZipEntry;
          int i = m;
          continue;
          try
          {
            localZipFile.close();
            return localArrayList;
          }
          catch (IOException localIOException3)
          {
            Log.w("MultiDex", "Failed to close resource", localIOException3);
            return localArrayList;
          }
        }
        catch (IOException localIOException1)
        {
          Log.w("MultiDex", "Failed to close resource", localIOException1);
          continue;
        }
        label529: int k = n;
        continue;
        label536: String str3 = "failed";
      }
    }
  }

  private List<a> a(Context paramContext, String paramString)
    throws IOException
  {
    Log.i("MultiDex", "loading existing secondary dex files");
    String str1 = this.a.getName() + ".classes";
    SharedPreferences localSharedPreferences = a(paramContext);
    int i = localSharedPreferences.getInt(paramString + "dex.number", 1);
    ArrayList localArrayList = new ArrayList(i - 1);
    int j = 2;
    while (j <= i)
    {
      String str2 = str1 + j + ".zip";
      a locala = new a(this.c, str2);
      if (locala.isFile())
      {
        locala.a = b(locala);
        long l1 = localSharedPreferences.getLong(paramString + "dex.crc." + j, -1L);
        long l2 = localSharedPreferences.getLong(paramString + "dex.time." + j, -1L);
        long l3 = locala.lastModified();
        if ((l2 != l3) || (l1 != locala.a))
          throw new IOException("Invalid extracted dex: " + locala + " (key \"" + paramString + "\"), expected modification time: " + l2 + ", modification time: " + l3 + ", expected crc: " + l1 + ", file crc: " + locala.a);
        localArrayList.add(locala);
        j++;
      }
      else
      {
        throw new IOException("Missing extracted secondary dex file '" + locala.getPath() + "'");
      }
    }
    return localArrayList;
  }

  private static void a(Context paramContext, String paramString, long paramLong1, long paramLong2, List<a> paramList)
  {
    SharedPreferences.Editor localEditor = a(paramContext).edit();
    localEditor.putLong(paramString + "timestamp", paramLong1);
    localEditor.putLong(paramString + "crc", paramLong2);
    localEditor.putInt(paramString + "dex.number", 1 + paramList.size());
    Iterator localIterator = paramList.iterator();
    for (int i = 2; localIterator.hasNext(); i++)
    {
      a locala = (a)localIterator.next();
      localEditor.putLong(paramString + "dex.crc." + i, locala.a);
      localEditor.putLong(paramString + "dex.time." + i, locala.lastModified());
    }
    localEditor.commit();
  }

  private static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("MultiDex", "Failed to close resource", localIOException);
    }
  }

  // ERROR //
  private static void a(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString)
    throws IOException, java.io.FileNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 310	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore 4
    //   7: new 32	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 312
    //   17: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_3
    //   21: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: ldc 150
    //   29: aload_2
    //   30: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   33: invokestatic 320	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   36: astore 5
    //   38: ldc 30
    //   40: new 32	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 322
    //   50: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 5
    //   55: invokevirtual 45	java/io/File:getPath	()Ljava/lang/String;
    //   58: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 58	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: new 324	java/util/zip/ZipOutputStream
    //   71: dup
    //   72: new 326	java/io/BufferedOutputStream
    //   75: dup
    //   76: new 328	java/io/FileOutputStream
    //   79: dup
    //   80: aload 5
    //   82: invokespecial 329	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: invokespecial 332	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   88: invokespecial 333	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   91: astore 7
    //   93: new 335	java/util/zip/ZipEntry
    //   96: dup
    //   97: ldc_w 337
    //   100: invokespecial 338	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   103: astore 8
    //   105: aload 8
    //   107: aload_1
    //   108: invokevirtual 341	java/util/zip/ZipEntry:getTime	()J
    //   111: invokevirtual 345	java/util/zip/ZipEntry:setTime	(J)V
    //   114: aload 7
    //   116: aload 8
    //   118: invokevirtual 349	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   121: sipush 16384
    //   124: newarray byte
    //   126: astore 12
    //   128: aload 4
    //   130: aload 12
    //   132: invokevirtual 355	java/io/InputStream:read	([B)I
    //   135: istore 13
    //   137: iload 13
    //   139: iconst_m1
    //   140: if_icmpeq +25 -> 165
    //   143: aload 7
    //   145: aload 12
    //   147: iconst_0
    //   148: iload 13
    //   150: invokevirtual 359	java/util/zip/ZipOutputStream:write	([BII)V
    //   153: aload 4
    //   155: aload 12
    //   157: invokevirtual 355	java/io/InputStream:read	([B)I
    //   160: istore 13
    //   162: goto -25 -> 137
    //   165: aload 7
    //   167: invokevirtual 362	java/util/zip/ZipOutputStream:closeEntry	()V
    //   170: aload 7
    //   172: invokevirtual 363	java/util/zip/ZipOutputStream:close	()V
    //   175: aload 5
    //   177: invokevirtual 366	java/io/File:setReadOnly	()Z
    //   180: ifne +80 -> 260
    //   183: new 21	java/io/IOException
    //   186: dup
    //   187: new 32	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 368
    //   197: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 5
    //   202: invokevirtual 369	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 371
    //   211: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_2
    //   215: invokevirtual 369	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   218: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 373
    //   224: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokespecial 215	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   233: athrow
    //   234: astore 10
    //   236: aload 4
    //   238: invokestatic 100	android/support/multidex/b:a	(Ljava/io/Closeable;)V
    //   241: aload 5
    //   243: invokevirtual 374	java/io/File:delete	()Z
    //   246: pop
    //   247: aload 10
    //   249: athrow
    //   250: astore 9
    //   252: aload 7
    //   254: invokevirtual 363	java/util/zip/ZipOutputStream:close	()V
    //   257: aload 9
    //   259: athrow
    //   260: ldc 30
    //   262: new 32	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 376
    //   272: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_2
    //   276: invokevirtual 45	java/io/File:getPath	()Ljava/lang/String;
    //   279: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 58	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   288: pop
    //   289: aload 5
    //   291: aload_2
    //   292: invokevirtual 380	java/io/File:renameTo	(Ljava/io/File;)Z
    //   295: ifne +54 -> 349
    //   298: new 21	java/io/IOException
    //   301: dup
    //   302: new 32	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 382
    //   312: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 5
    //   317: invokevirtual 369	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   320: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc_w 384
    //   326: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_2
    //   330: invokevirtual 369	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   333: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc_w 386
    //   339: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokespecial 215	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   348: athrow
    //   349: aload 4
    //   351: invokestatic 100	android/support/multidex/b:a	(Ljava/io/Closeable;)V
    //   354: aload 5
    //   356: invokevirtual 374	java/io/File:delete	()Z
    //   359: pop
    //   360: return
    //
    // Exception table:
    //   from	to	target	type
    //   68	93	234	finally
    //   170	234	234	finally
    //   252	260	234	finally
    //   260	349	234	finally
    //   93	137	250	finally
    //   143	162	250	finally
    //   165	170	250	finally
  }

  private static boolean a(Context paramContext, File paramFile, long paramLong, String paramString)
  {
    SharedPreferences localSharedPreferences = a(paramContext);
    return (localSharedPreferences.getLong(paramString + "timestamp", -1L) != a(paramFile)) || (localSharedPreferences.getLong(paramString + "crc", -1L) != paramLong);
  }

  private static long b(File paramFile)
    throws IOException
  {
    long l = c.a(paramFile);
    if (l == -1L)
      l -= 1L;
    return l;
  }

  private void b()
  {
    File[] arrayOfFile = this.c.listFiles(new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        return !paramAnonymousFile.getName().equals("MultiDex.lock");
      }
    });
    if (arrayOfFile == null)
    {
      Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.c.getPath() + ").");
      return;
    }
    int i = arrayOfFile.length;
    int j = 0;
    label64: File localFile;
    if (j < i)
    {
      localFile = arrayOfFile[j];
      Log.i("MultiDex", "Trying to delete old file " + localFile.getPath() + " of size " + localFile.length());
      if (localFile.delete())
        break label162;
      Log.w("MultiDex", "Failed to delete old file " + localFile.getPath());
    }
    while (true)
    {
      j++;
      break label64;
      break;
      label162: Log.i("MultiDex", "Deleted old file " + localFile.getPath());
    }
  }

  List<? extends File> a(Context paramContext, String paramString, boolean paramBoolean)
    throws IOException
  {
    Log.i("MultiDex", "MultiDexExtractor.load(" + this.a.getPath() + ", " + paramBoolean + ", " + paramString + ")");
    if (!this.f.isValid())
      throw new IllegalStateException("MultiDexExtractor was closed");
    List localList1;
    if ((!paramBoolean) && (!a(paramContext, this.a, this.b, paramString)))
      try
      {
        List localList2 = a(paramContext, paramString);
        localList1 = localList2;
        Log.i("MultiDex", "load found " + localList1.size() + " secondary dex files");
        return localList1;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", localIOException);
          localList1 = a();
          a(paramContext, paramString, a(this.a), this.b, localList1);
        }
      }
    if (paramBoolean)
      Log.i("MultiDex", "Forced extraction must be performed.");
    while (true)
    {
      localList1 = a();
      a(paramContext, paramString, a(this.a), this.b, localList1);
      break;
      Log.i("MultiDex", "Detected that extraction must be performed.");
    }
  }

  public void close()
    throws IOException
  {
    this.f.release();
    this.e.close();
    this.d.close();
  }

  private static class a extends File
  {
    public long a = -1L;

    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.multidex.b
 * JD-Core Version:    0.6.2
 */