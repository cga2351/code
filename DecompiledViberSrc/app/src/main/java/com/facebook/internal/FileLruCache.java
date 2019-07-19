package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.Settings;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class FileLruCache
{
  private static final String HEADER_CACHEKEY_KEY = "key";
  private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
  static final String TAG = FileLruCache.class.getSimpleName();
  private static final AtomicLong bufferIndex = new AtomicLong();
  private final File directory;
  private boolean isTrimInProgress;
  private boolean isTrimPending;
  private AtomicLong lastClearCacheTime = new AtomicLong(0L);
  private final Limits limits;
  private final Object lock;
  private final String tag;

  public FileLruCache(Context paramContext, String paramString, Limits paramLimits)
  {
    this.tag = paramString;
    this.limits = paramLimits;
    this.directory = new File(paramContext.getCacheDir(), paramString);
    this.lock = new Object();
    if ((this.directory.mkdirs()) || (this.directory.isDirectory()))
      BufferFile.deleteAll(this.directory);
  }

  private void postTrim()
  {
    synchronized (this.lock)
    {
      if (!this.isTrimPending)
      {
        this.isTrimPending = true;
        Settings.getExecutor().execute(new Runnable()
        {
          public void run()
          {
            FileLruCache.this.trim();
          }
        });
      }
      return;
    }
  }

  private void renameToTargetAndTrim(String paramString, File paramFile)
  {
    if (!paramFile.renameTo(new File(this.directory, Utility.md5hash(paramString))))
      paramFile.delete();
    postTrim();
  }

  // ERROR //
  private void trim()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 98	com/facebook/internal/FileLruCache:isTrimPending	Z
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 131	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   17: aload_1
    //   18: monitorexit
    //   19: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   22: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   25: ldc 139
    //   27: invokestatic 145	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 147	java/util/PriorityQueue
    //   33: dup
    //   34: invokespecial 148	java/util/PriorityQueue:<init>	()V
    //   37: astore 6
    //   39: lconst_0
    //   40: lstore 7
    //   42: lconst_0
    //   43: lstore 9
    //   45: aload_0
    //   46: getfield 65	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   49: invokestatic 152	com/facebook/internal/FileLruCache$BufferFile:excludeBufferFiles	()Ljava/io/FilenameFilter;
    //   52: invokevirtual 156	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   55: astore 11
    //   57: aload 11
    //   59: ifnull +304 -> 363
    //   62: aload 11
    //   64: arraylength
    //   65: istore 12
    //   67: iconst_0
    //   68: istore 13
    //   70: iload 13
    //   72: iload 12
    //   74: if_icmpge +289 -> 363
    //   77: aload 11
    //   79: iload 13
    //   81: aaload
    //   82: astore 14
    //   84: new 158	com/facebook/internal/FileLruCache$ModifiedFile
    //   87: dup
    //   88: aload 14
    //   90: invokespecial 160	com/facebook/internal/FileLruCache$ModifiedFile:<init>	(Ljava/io/File;)V
    //   93: astore 15
    //   95: aload 6
    //   97: aload 15
    //   99: invokevirtual 164	java/util/PriorityQueue:add	(Ljava/lang/Object;)Z
    //   102: pop
    //   103: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   106: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   109: new 166	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   116: ldc 169
    //   118: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 15
    //   123: invokevirtual 177	com/facebook/internal/FileLruCache$ModifiedFile:getModified	()J
    //   126: invokestatic 183	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   129: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: ldc 188
    //   134: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 15
    //   139: invokevirtual 191	com/facebook/internal/FileLruCache$ModifiedFile:getFile	()Ljava/io/File;
    //   142: invokevirtual 194	java/io/File:getName	()Ljava/lang/String;
    //   145: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 145	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload 14
    //   156: invokevirtual 200	java/io/File:length	()J
    //   159: lstore 17
    //   161: lload 17
    //   163: lload 7
    //   165: ladd
    //   166: lstore 19
    //   168: lconst_1
    //   169: lload 9
    //   171: ladd
    //   172: lstore 21
    //   174: iinc 13 1
    //   177: lload 21
    //   179: lstore 9
    //   181: lload 19
    //   183: lstore 7
    //   185: goto -115 -> 70
    //   188: astore_2
    //   189: aload_1
    //   190: monitorexit
    //   191: aload_2
    //   192: athrow
    //   193: lload 23
    //   195: aload_0
    //   196: getfield 52	com/facebook/internal/FileLruCache:limits	Lcom/facebook/internal/FileLruCache$Limits;
    //   199: invokevirtual 206	com/facebook/internal/FileLruCache$Limits:getByteCount	()I
    //   202: i2l
    //   203: lcmp
    //   204: ifgt +17 -> 221
    //   207: lload 25
    //   209: aload_0
    //   210: getfield 52	com/facebook/internal/FileLruCache:limits	Lcom/facebook/internal/FileLruCache$Limits;
    //   213: invokevirtual 209	com/facebook/internal/FileLruCache$Limits:getFileCount	()I
    //   216: i2l
    //   217: lcmp
    //   218: ifle +77 -> 295
    //   221: aload 6
    //   223: invokevirtual 213	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   226: checkcast 158	com/facebook/internal/FileLruCache$ModifiedFile
    //   229: invokevirtual 191	com/facebook/internal/FileLruCache$ModifiedFile:getFile	()Ljava/io/File;
    //   232: astore 27
    //   234: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   237: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   240: new 166	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   247: ldc 215
    //   249: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 27
    //   254: invokevirtual 194	java/io/File:getName	()Ljava/lang/String;
    //   257: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 145	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   266: lload 23
    //   268: aload 27
    //   270: invokevirtual 200	java/io/File:length	()J
    //   273: lsub
    //   274: lstore 23
    //   276: lload 25
    //   278: lconst_1
    //   279: lsub
    //   280: lstore 28
    //   282: aload 27
    //   284: invokevirtual 127	java/io/File:delete	()Z
    //   287: pop
    //   288: lload 28
    //   290: lstore 25
    //   292: goto -99 -> 193
    //   295: aload_0
    //   296: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   299: astore 31
    //   301: aload 31
    //   303: monitorenter
    //   304: aload_0
    //   305: iconst_0
    //   306: putfield 131	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   309: aload_0
    //   310: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   313: invokevirtual 218	java/lang/Object:notifyAll	()V
    //   316: aload 31
    //   318: monitorexit
    //   319: return
    //   320: astore 32
    //   322: aload 31
    //   324: monitorexit
    //   325: aload 32
    //   327: athrow
    //   328: astore_3
    //   329: aload_0
    //   330: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   333: astore 4
    //   335: aload 4
    //   337: monitorenter
    //   338: aload_0
    //   339: iconst_0
    //   340: putfield 131	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   343: aload_0
    //   344: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   347: invokevirtual 218	java/lang/Object:notifyAll	()V
    //   350: aload 4
    //   352: monitorexit
    //   353: aload_3
    //   354: athrow
    //   355: astore 5
    //   357: aload 4
    //   359: monitorexit
    //   360: aload 5
    //   362: athrow
    //   363: lload 7
    //   365: lstore 23
    //   367: lload 9
    //   369: lstore 25
    //   371: goto -178 -> 193
    //
    // Exception table:
    //   from	to	target	type
    //   7	19	188	finally
    //   189	191	188	finally
    //   304	319	320	finally
    //   322	325	320	finally
    //   19	39	328	finally
    //   45	57	328	finally
    //   62	67	328	finally
    //   77	161	328	finally
    //   193	221	328	finally
    //   221	276	328	finally
    //   282	288	328	finally
    //   338	353	355	finally
    //   357	360	355	finally
  }

  public void clearCache()
  {
    final File[] arrayOfFile = this.directory.listFiles(BufferFile.excludeBufferFiles());
    this.lastClearCacheTime.set(System.currentTimeMillis());
    if (arrayOfFile != null)
      Settings.getExecutor().execute(new Runnable()
      {
        public void run()
        {
          File[] arrayOfFile = arrayOfFile;
          int i = arrayOfFile.length;
          for (int j = 0; j < i; j++)
            arrayOfFile[j].delete();
        }
      });
  }

  public InputStream get(String paramString)
    throws IOException
  {
    return get(paramString, null);
  }

  public InputStream get(String paramString1, String paramString2)
    throws IOException
  {
    File localFile = new File(this.directory, Utility.md5hash(paramString1));
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(localFileInputStream, 8192);
      try
      {
        JSONObject localJSONObject = StreamHeader.readHeader(localBufferedInputStream);
        if (localJSONObject == null)
          return null;
        String str1 = localJSONObject.optString("key");
        if (str1 != null)
        {
          boolean bool1 = str1.equals(paramString1);
          if (bool1);
        }
        else
        {
          return null;
        }
        String str2 = localJSONObject.optString("tag", null);
        if ((paramString2 != null) || (str2 == null))
        {
          if (paramString2 != null)
          {
            boolean bool2 = paramString2.equals(str2);
            if (bool2);
          }
        }
        else
          return null;
        long l = new Date().getTime();
        Logger.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + Long.valueOf(l) + " for " + localFile.getName());
        localFile.setLastModified(l);
        return localBufferedInputStream;
      }
      finally
      {
        localBufferedInputStream.close();
      }
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public InputStream interceptAndPut(String paramString, InputStream paramInputStream)
    throws IOException
  {
    return new CopyingInputStream(paramInputStream, openPutStream(paramString));
  }

  OutputStream openPutStream(String paramString)
    throws IOException
  {
    return openPutStream(paramString, null);
  }

  // ERROR //
  public OutputStream openPutStream(final String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   4: invokestatic 305	com/facebook/internal/FileLruCache$BufferFile:newFile	(Ljava/io/File;)Ljava/io/File;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 127	java/io/File:delete	()Z
    //   12: pop
    //   13: aload_3
    //   14: invokevirtual 308	java/io/File:createNewFile	()Z
    //   17: ifne +34 -> 51
    //   20: new 236	java/io/IOException
    //   23: dup
    //   24: new 166	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 310
    //   34: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_3
    //   38: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 316	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: new 318	java/io/FileOutputStream
    //   54: dup
    //   55: aload_3
    //   56: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   59: astore 5
    //   61: new 321	java/io/BufferedOutputStream
    //   64: dup
    //   65: new 323	com/facebook/internal/FileLruCache$CloseCallbackOutputStream
    //   68: dup
    //   69: aload 5
    //   71: new 325	com/facebook/internal/FileLruCache$1
    //   74: dup
    //   75: aload_0
    //   76: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   79: aload_3
    //   80: aload_1
    //   81: invokespecial 328	com/facebook/internal/FileLruCache$1:<init>	(Lcom/facebook/internal/FileLruCache;JLjava/io/File;Ljava/lang/String;)V
    //   84: invokespecial 331	com/facebook/internal/FileLruCache$CloseCallbackOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V
    //   87: sipush 8192
    //   90: invokespecial 334	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   93: astore 6
    //   95: new 258	org/json/JSONObject
    //   98: dup
    //   99: invokespecial 335	org/json/JSONObject:<init>	()V
    //   102: astore 7
    //   104: aload 7
    //   106: ldc 8
    //   108: aload_1
    //   109: invokevirtual 339	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload_2
    //   114: invokestatic 343	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   117: ifne +12 -> 129
    //   120: aload 7
    //   122: ldc 11
    //   124: aload_2
    //   125: invokevirtual 339	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload 6
    //   131: aload 7
    //   133: invokestatic 347	com/facebook/internal/FileLruCache$StreamHeader:writeHeader	(Ljava/io/OutputStream;Lorg/json/JSONObject;)V
    //   136: aload 6
    //   138: areturn
    //   139: astore 12
    //   141: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   144: iconst_5
    //   145: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   148: new 166	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 349
    //   158: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 12
    //   163: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 352	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   172: new 236	java/io/IOException
    //   175: dup
    //   176: aload 12
    //   178: invokevirtual 355	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   181: invokespecial 316	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   184: athrow
    //   185: astore 9
    //   187: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   190: iconst_5
    //   191: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   194: new 166	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 357
    //   204: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 9
    //   209: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 352	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   218: new 236	java/io/IOException
    //   221: dup
    //   222: aload 9
    //   224: invokevirtual 358	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   227: invokespecial 316	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   230: athrow
    //   231: astore 8
    //   233: aload 6
    //   235: invokevirtual 359	java/io/BufferedOutputStream:close	()V
    //   238: aload 8
    //   240: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   51	61	139	java/io/FileNotFoundException
    //   95	129	185	org/json/JSONException
    //   129	136	185	org/json/JSONException
    //   95	129	231	finally
    //   129	136	231	finally
    //   187	231	231	finally
  }

  long sizeInBytesForTest()
  {
    long l1;
    synchronized (this.lock)
    {
      while (true)
      {
        if (!this.isTrimPending)
        {
          boolean bool = this.isTrimInProgress;
          if (!bool)
            break;
        }
        try
        {
          this.lock.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
        }
      }
      File[] arrayOfFile = this.directory.listFiles();
      l1 = 0L;
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        int j = 0;
        if (j < i)
        {
          long l2 = l1 + arrayOfFile[j].length();
          j++;
          l1 = l2;
        }
      }
    }
    return l1;
  }

  public String toString()
  {
    return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
  }

  private static class BufferFile
  {
    private static final String FILE_NAME_PREFIX = "buffer";
    private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return !paramAnonymousString.startsWith("buffer");
      }
    };
    private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.startsWith("buffer");
      }
    };

    static void deleteAll(File paramFile)
    {
      File[] arrayOfFile = paramFile.listFiles(excludeNonBufferFiles());
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++)
          arrayOfFile[j].delete();
      }
    }

    static FilenameFilter excludeBufferFiles()
    {
      return filterExcludeBufferFiles;
    }

    static FilenameFilter excludeNonBufferFiles()
    {
      return filterExcludeNonBufferFiles;
    }

    static File newFile(File paramFile)
    {
      return new File(paramFile, "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
    }
  }

  private static class CloseCallbackOutputStream extends OutputStream
  {
    final FileLruCache.StreamCloseCallback callback;
    final OutputStream innerStream;

    CloseCallbackOutputStream(OutputStream paramOutputStream, FileLruCache.StreamCloseCallback paramStreamCloseCallback)
    {
      this.innerStream = paramOutputStream;
      this.callback = paramStreamCloseCallback;
    }

    public void close()
      throws IOException
    {
      try
      {
        this.innerStream.close();
        return;
      }
      finally
      {
        this.callback.onClose();
      }
    }

    public void flush()
      throws IOException
    {
      this.innerStream.flush();
    }

    public void write(int paramInt)
      throws IOException
    {
      this.innerStream.write(paramInt);
    }

    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      this.innerStream.write(paramArrayOfByte);
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.innerStream.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }

  private static final class CopyingInputStream extends InputStream
  {
    final InputStream input;
    final OutputStream output;

    CopyingInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
    {
      this.input = paramInputStream;
      this.output = paramOutputStream;
    }

    public int available()
      throws IOException
    {
      return this.input.available();
    }

    public void close()
      throws IOException
    {
      try
      {
        this.input.close();
        return;
      }
      finally
      {
        this.output.close();
      }
    }

    public void mark(int paramInt)
    {
      throw new UnsupportedOperationException();
    }

    public boolean markSupported()
    {
      return false;
    }

    public int read()
      throws IOException
    {
      int i = this.input.read();
      if (i >= 0)
        this.output.write(i);
      return i;
    }

    public int read(byte[] paramArrayOfByte)
      throws IOException
    {
      int i = this.input.read(paramArrayOfByte);
      if (i > 0)
        this.output.write(paramArrayOfByte, 0, i);
      return i;
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = this.input.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i > 0)
        this.output.write(paramArrayOfByte, paramInt1, i);
      return i;
    }

    public void reset()
    {
      try
      {
        throw new UnsupportedOperationException();
      }
      finally
      {
      }
    }

    public long skip(long paramLong)
      throws IOException
    {
      byte[] arrayOfByte = new byte[1024];
      int i;
      for (long l = 0L; ; l += i)
        if (l < paramLong)
        {
          i = read(arrayOfByte, 0, (int)Math.min(paramLong - l, arrayOfByte.length));
          if (i >= 0);
        }
        else
        {
          return l;
        }
    }
  }

  public static final class Limits
  {
    private int byteCount = 1048576;
    private int fileCount = 1024;

    int getByteCount()
    {
      return this.byteCount;
    }

    int getFileCount()
    {
      return this.fileCount;
    }

    void setByteCount(int paramInt)
    {
      if (paramInt < 0)
        throw new InvalidParameterException("Cache byte-count limit must be >= 0");
      this.byteCount = paramInt;
    }

    void setFileCount(int paramInt)
    {
      if (paramInt < 0)
        throw new InvalidParameterException("Cache file count limit must be >= 0");
      this.fileCount = paramInt;
    }
  }

  private static final class ModifiedFile
    implements Comparable<ModifiedFile>
  {
    private static final int HASH_MULTIPLIER = 37;
    private static final int HASH_SEED = 29;
    private final File file;
    private final long modified;

    ModifiedFile(File paramFile)
    {
      this.file = paramFile;
      this.modified = paramFile.lastModified();
    }

    public int compareTo(ModifiedFile paramModifiedFile)
    {
      if (getModified() < paramModifiedFile.getModified())
        return -1;
      if (getModified() > paramModifiedFile.getModified())
        return 1;
      return getFile().compareTo(paramModifiedFile.getFile());
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ModifiedFile)) && (compareTo((ModifiedFile)paramObject) == 0);
    }

    File getFile()
    {
      return this.file;
    }

    long getModified()
    {
      return this.modified;
    }

    public int hashCode()
    {
      return 37 * (1073 + this.file.hashCode()) + (int)(this.modified % 2147483647L);
    }
  }

  private static abstract interface StreamCloseCallback
  {
    public abstract void onClose();
  }

  private static final class StreamHeader
  {
    private static final int HEADER_VERSION;

    static JSONObject readHeader(InputStream paramInputStream)
      throws IOException
    {
      int i = 0;
      if (paramInputStream.read() != 0)
        return null;
      int j = 0;
      int k = 0;
      while (j < 3)
      {
        int n = paramInputStream.read();
        if (n == -1)
        {
          Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
          return null;
        }
        k = (k << 8) + (n & 0xFF);
        j++;
      }
      byte[] arrayOfByte = new byte[k];
      while (i < arrayOfByte.length)
      {
        int m = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
        if (m < 1)
        {
          Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + arrayOfByte.length);
          return null;
        }
        i += m;
      }
      JSONTokener localJSONTokener = new JSONTokener(new String(arrayOfByte));
      try
      {
        Object localObject = localJSONTokener.nextValue();
        if (!(localObject instanceof JSONObject))
        {
          Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + localObject.getClass().getCanonicalName());
          return null;
        }
        JSONObject localJSONObject = (JSONObject)localObject;
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IOException(localJSONException.getMessage());
      }
    }

    static void writeHeader(OutputStream paramOutputStream, JSONObject paramJSONObject)
      throws IOException
    {
      byte[] arrayOfByte = paramJSONObject.toString().getBytes();
      paramOutputStream.write(0);
      paramOutputStream.write(0xFF & arrayOfByte.length >> 16);
      paramOutputStream.write(0xFF & arrayOfByte.length >> 8);
      paramOutputStream.write(0xFF & arrayOfByte.length >> 0);
      paramOutputStream.write(arrayOfByte);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.internal.FileLruCache
 * JD-Core Version:    0.6.2
 */