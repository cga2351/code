package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class UnpackingSoSource extends DirectorySoSource
{
  private static final String DEPS_FILE_NAME = "dso_deps";
  private static final String LOCK_FILE_NAME = "dso_lock";
  private static final String MANIFEST_FILE_NAME = "dso_manifest";
  private static final byte MANIFEST_VERSION = 1;
  private static final byte STATE_CLEAN = 1;
  private static final byte STATE_DIRTY = 0;
  private static final String STATE_FILE_NAME = "dso_state";
  private static final String TAG = "fb-UnpackingSoSource";

  @Nullable
  private String[] mAbis;
  protected final Context mContext;

  @Nullable
  protected String mCorruptedLib;
  private final Map<String, Object> mLibsBeingLoaded = new HashMap();

  protected UnpackingSoSource(Context paramContext, File paramFile)
  {
    super(paramFile, 1);
    this.mContext = paramContext;
  }

  protected UnpackingSoSource(Context paramContext, String paramString)
  {
    super(getSoStorePath(paramContext, paramString), 1);
    this.mContext = paramContext;
  }

  private void deleteUnmentionedFiles(Dso[] paramArrayOfDso)
    throws IOException
  {
    String[] arrayOfString = this.soDirectory.list();
    if (arrayOfString == null)
      throw new IOException("unable to list directory " + this.soDirectory);
    int i = 0;
    if (i < arrayOfString.length)
    {
      String str = arrayOfString[i];
      if ((str.equals("dso_state")) || (str.equals("dso_lock")) || (str.equals("dso_deps")) || (str.equals("dso_manifest")));
      while (true)
      {
        i++;
        break;
        int j = 0;
        int k = 0;
        while ((k == 0) && (j < paramArrayOfDso.length))
        {
          if (paramArrayOfDso[j].name.equals(str))
            k = 1;
          j++;
        }
        if (k == 0)
        {
          File localFile = new File(this.soDirectory, str);
          Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + localFile);
          SysUtil.dumbDeleteRecursive(localFile);
        }
      }
    }
  }

  private void extractDso(InputDso paramInputDso, byte[] paramArrayOfByte)
    throws IOException
  {
    Log.i("fb-UnpackingSoSource", "extracting DSO " + paramInputDso.dso.name);
    if (!this.soDirectory.setWritable(true, true))
      throw new IOException("cannot make directory writable for us: " + this.soDirectory);
    File localFile = new File(this.soDirectory, paramInputDso.dso.name);
    try
    {
      RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile, "rw");
      localRandomAccessFile2 = localRandomAccessFile1;
      try
      {
        int i = paramInputDso.content.available();
        if (i > 1)
          SysUtil.fallocateIfSupported(localRandomAccessFile2.getFD(), i);
        SysUtil.copyBytes(localRandomAccessFile2, paramInputDso.content, 2147483647, paramArrayOfByte);
        localRandomAccessFile2.setLength(localRandomAccessFile2.getFilePointer());
        if (!localFile.setExecutable(true, false))
          throw new IOException("cannot make file executable: " + localFile);
      }
      catch (IOException localIOException1)
      {
        SysUtil.dumbDeleteRecursive(localFile);
        throw localIOException1;
      }
      finally
      {
        localRandomAccessFile2.close();
      }
    }
    catch (IOException localIOException2)
    {
      RandomAccessFile localRandomAccessFile2;
      while (true)
      {
        Log.w("fb-UnpackingSoSource", "error overwriting " + localFile + " trying to delete and start over", localIOException2);
        SysUtil.dumbDeleteRecursive(localFile);
        localRandomAccessFile2 = new RandomAccessFile(localFile, "rw");
      }
      localRandomAccessFile2.close();
    }
  }

  private Object getLibraryLock(String paramString)
  {
    synchronized (this.mLibsBeingLoaded)
    {
      Object localObject2 = this.mLibsBeingLoaded.get(paramString);
      if (localObject2 == null)
      {
        localObject2 = new Object();
        this.mLibsBeingLoaded.put(paramString, localObject2);
      }
      return localObject2;
    }
  }

  public static File getSoStorePath(Context paramContext, String paramString)
  {
    return new File(paramContext.getApplicationInfo().dataDir + "/" + paramString);
  }

  // ERROR //
  private boolean refreshLocked(final FileLocker paramFileLocker, int paramInt, final byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: new 69	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 67	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   8: ldc 23
    //   10: invokespecial 106	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore 4
    //   15: new 141	java/io/RandomAccessFile
    //   18: dup
    //   19: aload 4
    //   21: ldc 143
    //   23: invokespecial 144	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 5
    //   28: aload 5
    //   30: invokevirtual 230	java/io/RandomAccessFile:readByte	()B
    //   33: istore 12
    //   35: iload 12
    //   37: iconst_1
    //   38: if_icmpeq +39 -> 77
    //   41: ldc 26
    //   43: new 75	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   50: ldc 232
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 67	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   59: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: ldc 234
    //   64: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 114	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   73: pop
    //   74: iconst_0
    //   75: istore 12
    //   77: aload 5
    //   79: ifnull +12 -> 91
    //   82: iconst_0
    //   83: ifeq +208 -> 291
    //   86: aload 5
    //   88: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   91: new 69	java/io/File
    //   94: dup
    //   95: aload_0
    //   96: getfield 67	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   99: ldc 8
    //   101: invokespecial 106	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   104: astore 13
    //   106: new 141	java/io/RandomAccessFile
    //   109: dup
    //   110: aload 13
    //   112: ldc 143
    //   114: invokespecial 144	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   117: astore 14
    //   119: aload 14
    //   121: invokevirtual 237	java/io/RandomAccessFile:length	()J
    //   124: l2i
    //   125: newarray byte
    //   127: astore 20
    //   129: aload 14
    //   131: aload 20
    //   133: invokevirtual 241	java/io/RandomAccessFile:read	([B)I
    //   136: aload 20
    //   138: arraylength
    //   139: if_icmpeq +14 -> 153
    //   142: ldc 26
    //   144: ldc 243
    //   146: invokestatic 114	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   149: pop
    //   150: iconst_0
    //   151: istore 12
    //   153: aload 20
    //   155: aload_3
    //   156: invokestatic 248	java/util/Arrays:equals	([B[B)Z
    //   159: ifne +491 -> 650
    //   162: ldc 26
    //   164: ldc 250
    //   166: invokestatic 114	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   169: pop
    //   170: iconst_0
    //   171: istore 12
    //   173: goto +477 -> 650
    //   176: ldc 26
    //   178: ldc 252
    //   180: invokestatic 114	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   183: pop
    //   184: aload 4
    //   186: iconst_0
    //   187: invokestatic 61	com/facebook/soloader/UnpackingSoSource:writeState	(Ljava/io/File;B)V
    //   190: aload_0
    //   191: invokevirtual 256	com/facebook/soloader/UnpackingSoSource:makeUnpacker	()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    //   194: astore 22
    //   196: aload 22
    //   198: invokevirtual 262	com/facebook/soloader/UnpackingSoSource$Unpacker:getDsoManifest	()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   201: astore 28
    //   203: aload 22
    //   205: invokevirtual 266	com/facebook/soloader/UnpackingSoSource$Unpacker:openDsoIterator	()Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    //   208: astore 29
    //   210: aconst_null
    //   211: astore 30
    //   213: aload_0
    //   214: iload 12
    //   216: aload 28
    //   218: aload 29
    //   220: invokespecial 270	com/facebook/soloader/UnpackingSoSource:regenerate	(BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;)V
    //   223: aload 29
    //   225: ifnull +12 -> 237
    //   228: iconst_0
    //   229: ifeq +200 -> 429
    //   232: aload 29
    //   234: invokevirtual 273	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   237: aload 22
    //   239: ifnull +12 -> 251
    //   242: iconst_0
    //   243: ifeq +258 -> 501
    //   246: aload 22
    //   248: invokevirtual 274	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   251: aload 14
    //   253: ifnull +12 -> 265
    //   256: iconst_0
    //   257: ifeq +283 -> 540
    //   260: aload 14
    //   262: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   265: aload 28
    //   267: ifnonnull +301 -> 568
    //   270: iconst_0
    //   271: ireturn
    //   272: astore 11
    //   274: iconst_0
    //   275: istore 12
    //   277: goto -200 -> 77
    //   280: astore 40
    //   282: aconst_null
    //   283: aload 40
    //   285: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   288: goto -197 -> 91
    //   291: aload 5
    //   293: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   296: goto -205 -> 91
    //   299: astore 9
    //   301: aload 9
    //   303: athrow
    //   304: astore 10
    //   306: aload 9
    //   308: astore 7
    //   310: aload 10
    //   312: astore 6
    //   314: aload 5
    //   316: ifnull +13 -> 329
    //   319: aload 7
    //   321: ifnull +23 -> 344
    //   324: aload 5
    //   326: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   329: aload 6
    //   331: athrow
    //   332: astore 8
    //   334: aload 7
    //   336: aload 8
    //   338: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   341: goto -12 -> 329
    //   344: aload 5
    //   346: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   349: goto -20 -> 329
    //   352: astore 36
    //   354: aconst_null
    //   355: aload 36
    //   357: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   360: goto -123 -> 237
    //   363: astore 26
    //   365: aload 26
    //   367: athrow
    //   368: astore 27
    //   370: aload 26
    //   372: astore 24
    //   374: aload 27
    //   376: astore 23
    //   378: aload 22
    //   380: ifnull +13 -> 393
    //   383: aload 24
    //   385: ifnull +136 -> 521
    //   388: aload 22
    //   390: invokevirtual 274	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   393: aload 23
    //   395: athrow
    //   396: astore 18
    //   398: aload 18
    //   400: athrow
    //   401: astore 19
    //   403: aload 18
    //   405: astore 16
    //   407: aload 19
    //   409: astore 15
    //   411: aload 14
    //   413: ifnull +13 -> 426
    //   416: aload 16
    //   418: ifnull +142 -> 560
    //   421: aload 14
    //   423: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   426: aload 15
    //   428: athrow
    //   429: aload 29
    //   431: invokevirtual 273	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   434: goto -197 -> 237
    //   437: astore 23
    //   439: aconst_null
    //   440: astore 24
    //   442: goto -64 -> 378
    //   445: astore 30
    //   447: aload 30
    //   449: athrow
    //   450: astore 31
    //   452: aload 29
    //   454: ifnull +13 -> 467
    //   457: aload 30
    //   459: ifnull +23 -> 482
    //   462: aload 29
    //   464: invokevirtual 273	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   467: aload 31
    //   469: athrow
    //   470: astore 32
    //   472: aload 30
    //   474: aload 32
    //   476: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   479: goto -12 -> 467
    //   482: aload 29
    //   484: invokevirtual 273	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   487: goto -20 -> 467
    //   490: astore 35
    //   492: aconst_null
    //   493: aload 35
    //   495: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   498: goto -247 -> 251
    //   501: aload 22
    //   503: invokevirtual 274	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   506: goto -255 -> 251
    //   509: astore 25
    //   511: aload 24
    //   513: aload 25
    //   515: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   518: goto -125 -> 393
    //   521: aload 22
    //   523: invokevirtual 274	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   526: goto -133 -> 393
    //   529: astore 34
    //   531: aconst_null
    //   532: aload 34
    //   534: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   537: goto -272 -> 265
    //   540: aload 14
    //   542: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   545: goto -280 -> 265
    //   548: astore 17
    //   550: aload 16
    //   552: aload 17
    //   554: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   557: goto -131 -> 426
    //   560: aload 14
    //   562: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   565: goto -139 -> 426
    //   568: new 280	com/facebook/soloader/UnpackingSoSource$1
    //   571: dup
    //   572: aload_0
    //   573: aload 13
    //   575: aload_3
    //   576: aload 28
    //   578: aload 4
    //   580: aload_1
    //   581: invokespecial 283	com/facebook/soloader/UnpackingSoSource$1:<init>	(Lcom/facebook/soloader/UnpackingSoSource;Ljava/io/File;[BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Ljava/io/File;Lcom/facebook/soloader/FileLocker;)V
    //   584: astore 33
    //   586: iload_2
    //   587: iconst_1
    //   588: iand
    //   589: ifeq +43 -> 632
    //   592: new 285	java/lang/Thread
    //   595: dup
    //   596: aload 33
    //   598: new 75	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   605: ldc_w 287
    //   608: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload_0
    //   612: getfield 67	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   615: invokevirtual 290	java/io/File:getName	()Ljava/lang/String;
    //   618: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokespecial 293	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   627: invokevirtual 296	java/lang/Thread:start	()V
    //   630: iconst_1
    //   631: ireturn
    //   632: aload 33
    //   634: invokeinterface 301 1 0
    //   639: goto -9 -> 630
    //   642: astore 6
    //   644: aconst_null
    //   645: astore 7
    //   647: goto -333 -> 314
    //   650: iload 12
    //   652: ifeq -476 -> 176
    //   655: iload_2
    //   656: iconst_2
    //   657: iand
    //   658: istore 37
    //   660: aconst_null
    //   661: astore 28
    //   663: iload 37
    //   665: ifeq -414 -> 251
    //   668: goto -492 -> 176
    //   671: astore 15
    //   673: aconst_null
    //   674: astore 16
    //   676: goto -265 -> 411
    //
    // Exception table:
    //   from	to	target	type
    //   28	35	272	java/io/EOFException
    //   41	74	272	java/io/EOFException
    //   86	91	280	java/lang/Throwable
    //   28	35	299	java/lang/Throwable
    //   41	74	299	java/lang/Throwable
    //   301	304	304	finally
    //   324	329	332	java/lang/Throwable
    //   232	237	352	java/lang/Throwable
    //   196	210	363	java/lang/Throwable
    //   354	360	363	java/lang/Throwable
    //   429	434	363	java/lang/Throwable
    //   467	470	363	java/lang/Throwable
    //   472	479	363	java/lang/Throwable
    //   482	487	363	java/lang/Throwable
    //   365	368	368	finally
    //   119	150	396	java/lang/Throwable
    //   153	170	396	java/lang/Throwable
    //   176	196	396	java/lang/Throwable
    //   393	396	396	java/lang/Throwable
    //   492	498	396	java/lang/Throwable
    //   501	506	396	java/lang/Throwable
    //   511	518	396	java/lang/Throwable
    //   521	526	396	java/lang/Throwable
    //   398	401	401	finally
    //   196	210	437	finally
    //   232	237	437	finally
    //   354	360	437	finally
    //   429	434	437	finally
    //   462	467	437	finally
    //   467	470	437	finally
    //   472	479	437	finally
    //   482	487	437	finally
    //   213	223	445	java/lang/Throwable
    //   213	223	450	finally
    //   447	450	450	finally
    //   462	467	470	java/lang/Throwable
    //   246	251	490	java/lang/Throwable
    //   388	393	509	java/lang/Throwable
    //   260	265	529	java/lang/Throwable
    //   421	426	548	java/lang/Throwable
    //   28	35	642	finally
    //   41	74	642	finally
    //   119	150	671	finally
    //   153	170	671	finally
    //   176	196	671	finally
    //   246	251	671	finally
    //   388	393	671	finally
    //   393	396	671	finally
    //   492	498	671	finally
    //   501	506	671	finally
    //   511	518	671	finally
    //   521	526	671	finally
  }

  // ERROR //
  private void regenerate(byte paramByte, DsoManifest paramDsoManifest, InputDsoIterator paramInputDsoIterator)
    throws IOException
  {
    // Byte code:
    //   0: ldc 26
    //   2: new 75	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 305
    //   12: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 309	java/lang/Object:getClass	()Ljava/lang/Class;
    //   19: invokevirtual 312	java/lang/Class:getName	()Ljava/lang/String;
    //   22: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 114	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: new 141	java/io/RandomAccessFile
    //   35: dup
    //   36: new 69	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: getfield 67	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   44: ldc 14
    //   46: invokespecial 106	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: ldc 143
    //   51: invokespecial 144	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 5
    //   56: aconst_null
    //   57: astore 6
    //   59: iload_1
    //   60: iconst_1
    //   61: if_icmpne +14 -> 75
    //   64: aload 5
    //   66: invokestatic 317	com/facebook/soloader/UnpackingSoSource$DsoManifest:read	(Ljava/io/DataInput;)Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   69: astore 28
    //   71: aload 28
    //   73: astore 6
    //   75: aload 6
    //   77: ifnonnull +377 -> 454
    //   80: new 314	com/facebook/soloader/UnpackingSoSource$DsoManifest
    //   83: dup
    //   84: iconst_0
    //   85: anewarray 100	com/facebook/soloader/UnpackingSoSource$Dso
    //   88: invokespecial 319	com/facebook/soloader/UnpackingSoSource$DsoManifest:<init>	([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    //   91: astore 7
    //   93: aload_0
    //   94: aload_2
    //   95: getfield 323	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   98: invokespecial 325	com/facebook/soloader/UnpackingSoSource:deleteUnmentionedFiles	([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    //   101: ldc_w 326
    //   104: newarray byte
    //   106: astore 13
    //   108: aload_3
    //   109: invokevirtual 330	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:hasNext	()Z
    //   112: ifeq +248 -> 360
    //   115: aload_3
    //   116: invokevirtual 334	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:next	()Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    //   119: astore 16
    //   121: iconst_1
    //   122: istore 17
    //   124: iconst_0
    //   125: istore 18
    //   127: iload 17
    //   129: ifeq +129 -> 258
    //   132: iload 18
    //   134: aload 7
    //   136: getfield 323	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   139: arraylength
    //   140: if_icmpge +118 -> 258
    //   143: aload 7
    //   145: getfield 323	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   148: iload 18
    //   150: aaload
    //   151: getfield 103	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   154: aload 16
    //   156: getfield 130	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   159: getfield 103	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   162: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +35 -> 200
    //   168: aload 7
    //   170: getfield 323	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   173: iload 18
    //   175: aaload
    //   176: getfield 337	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   179: aload 16
    //   181: getfield 130	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   184: getfield 337	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   187: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: istore 25
    //   192: iload 25
    //   194: ifeq +6 -> 200
    //   197: iconst_0
    //   198: istore 17
    //   200: iinc 18 1
    //   203: goto -76 -> 127
    //   206: astore 26
    //   208: ldc 26
    //   210: ldc_w 339
    //   213: aload 26
    //   215: invokestatic 341	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   218: pop
    //   219: aconst_null
    //   220: astore 6
    //   222: goto -147 -> 75
    //   225: astore 11
    //   227: aload 11
    //   229: athrow
    //   230: astore 12
    //   232: aload 11
    //   234: astore 9
    //   236: aload 12
    //   238: astore 8
    //   240: aload 5
    //   242: ifnull +13 -> 255
    //   245: aload 9
    //   247: ifnull +191 -> 438
    //   250: aload 5
    //   252: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   255: aload 8
    //   257: athrow
    //   258: iload 17
    //   260: ifeq +11 -> 271
    //   263: aload_0
    //   264: aload 16
    //   266: aload 13
    //   268: invokespecial 343	com/facebook/soloader/UnpackingSoSource:extractDso	(Lcom/facebook/soloader/UnpackingSoSource$InputDso;[B)V
    //   271: aload 16
    //   273: ifnull -165 -> 108
    //   276: iconst_0
    //   277: ifeq +22 -> 299
    //   280: aload 16
    //   282: invokevirtual 344	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   285: goto -177 -> 108
    //   288: astore 19
    //   290: aconst_null
    //   291: aload 19
    //   293: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   296: goto -188 -> 108
    //   299: aload 16
    //   301: invokevirtual 344	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   304: goto -196 -> 108
    //   307: astore 23
    //   309: aload 23
    //   311: athrow
    //   312: astore 24
    //   314: aload 23
    //   316: astore 21
    //   318: aload 24
    //   320: astore 20
    //   322: aload 16
    //   324: ifnull +13 -> 337
    //   327: aload 21
    //   329: ifnull +23 -> 352
    //   332: aload 16
    //   334: invokevirtual 344	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   337: aload 20
    //   339: athrow
    //   340: astore 22
    //   342: aload 21
    //   344: aload 22
    //   346: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   349: goto -12 -> 337
    //   352: aload 16
    //   354: invokevirtual 344	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   357: goto -20 -> 337
    //   360: aload 5
    //   362: ifnull +12 -> 374
    //   365: iconst_0
    //   366: ifeq +52 -> 418
    //   369: aload 5
    //   371: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   374: ldc 26
    //   376: new 75	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 346
    //   386: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_0
    //   390: invokevirtual 309	java/lang/Object:getClass	()Ljava/lang/Class;
    //   393: invokevirtual 312	java/lang/Class:getName	()Ljava/lang/String;
    //   396: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 114	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   405: pop
    //   406: return
    //   407: astore 15
    //   409: aconst_null
    //   410: aload 15
    //   412: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   415: goto -41 -> 374
    //   418: aload 5
    //   420: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   423: goto -49 -> 374
    //   426: astore 10
    //   428: aload 9
    //   430: aload 10
    //   432: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   435: goto -180 -> 255
    //   438: aload 5
    //   440: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   443: goto -188 -> 255
    //   446: astore 20
    //   448: aconst_null
    //   449: astore 21
    //   451: goto -129 -> 322
    //   454: aload 6
    //   456: astore 7
    //   458: goto -365 -> 93
    //   461: astore 8
    //   463: aconst_null
    //   464: astore 9
    //   466: goto -226 -> 240
    //
    // Exception table:
    //   from	to	target	type
    //   64	71	206	java/lang/Exception
    //   64	71	225	java/lang/Throwable
    //   80	93	225	java/lang/Throwable
    //   93	108	225	java/lang/Throwable
    //   108	121	225	java/lang/Throwable
    //   208	219	225	java/lang/Throwable
    //   290	296	225	java/lang/Throwable
    //   299	304	225	java/lang/Throwable
    //   337	340	225	java/lang/Throwable
    //   342	349	225	java/lang/Throwable
    //   352	357	225	java/lang/Throwable
    //   227	230	230	finally
    //   280	285	288	java/lang/Throwable
    //   132	192	307	java/lang/Throwable
    //   263	271	307	java/lang/Throwable
    //   309	312	312	finally
    //   332	337	340	java/lang/Throwable
    //   369	374	407	java/lang/Throwable
    //   250	255	426	java/lang/Throwable
    //   132	192	446	finally
    //   263	271	446	finally
    //   64	71	461	finally
    //   80	93	461	finally
    //   93	108	461	finally
    //   108	121	461	finally
    //   208	219	461	finally
    //   280	285	461	finally
    //   290	296	461	finally
    //   299	304	461	finally
    //   332	337	461	finally
    //   337	340	461	finally
    //   342	349	461	finally
    //   352	357	461	finally
  }

  // ERROR //
  private static void writeState(File paramFile, byte paramByte)
    throws IOException
  {
    // Byte code:
    //   0: new 141	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 143
    //   7: invokespecial 144	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: lconst_0
    //   13: invokevirtual 349	java/io/RandomAccessFile:seek	(J)V
    //   16: aload_2
    //   17: iload_1
    //   18: invokevirtual 353	java/io/RandomAccessFile:write	(I)V
    //   21: aload_2
    //   22: aload_2
    //   23: invokevirtual 171	java/io/RandomAccessFile:getFilePointer	()J
    //   26: invokevirtual 175	java/io/RandomAccessFile:setLength	(J)V
    //   29: aload_2
    //   30: invokevirtual 158	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   33: invokevirtual 358	java/io/FileDescriptor:sync	()V
    //   36: aload_2
    //   37: ifnull +11 -> 48
    //   40: iconst_0
    //   41: ifeq +17 -> 58
    //   44: aload_2
    //   45: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   48: return
    //   49: astore 8
    //   51: aconst_null
    //   52: aload 8
    //   54: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   57: return
    //   58: aload_2
    //   59: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   62: return
    //   63: astore 6
    //   65: aload 6
    //   67: athrow
    //   68: astore 7
    //   70: aload 6
    //   72: astore 4
    //   74: aload 7
    //   76: astore_3
    //   77: aload_2
    //   78: ifnull +12 -> 90
    //   81: aload 4
    //   83: ifnull +21 -> 104
    //   86: aload_2
    //   87: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   90: aload_3
    //   91: athrow
    //   92: astore 5
    //   94: aload 4
    //   96: aload 5
    //   98: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   101: goto -11 -> 90
    //   104: aload_2
    //   105: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   108: goto -18 -> 90
    //   111: astore_3
    //   112: aconst_null
    //   113: astore 4
    //   115: goto -38 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   44	48	49	java/lang/Throwable
    //   11	36	63	java/lang/Throwable
    //   65	68	68	finally
    //   86	90	92	java/lang/Throwable
    //   11	36	111	finally
  }

  protected byte[] getDepsBlock()
    throws IOException
  {
    Parcel localParcel = Parcel.obtain();
    Unpacker localUnpacker = makeUnpacker();
    try
    {
      Dso[] arrayOfDso = localUnpacker.getDsoManifest().dsos;
      localParcel.writeByte((byte)1);
      localParcel.writeInt(arrayOfDso.length);
      for (int i = 0; i < arrayOfDso.length; i++)
      {
        localParcel.writeString(arrayOfDso[i].name);
        localParcel.writeString(arrayOfDso[i].hash);
      }
      if ((localUnpacker == null) || (0 != 0));
      while (true)
      {
        try
        {
          localUnpacker.close();
          byte[] arrayOfByte = localParcel.marshall();
          localParcel.recycle();
          return arrayOfByte;
        }
        catch (Throwable localThrowable4)
        {
          null.addSuppressed(localThrowable4);
          continue;
        }
        localUnpacker.close();
      }
    }
    catch (Throwable localThrowable3)
    {
      Object localObject1;
      try
      {
        throw localThrowable3;
      }
      finally
      {
        localThrowable1 = localThrowable3;
      }
      if ((localUnpacker == null) || (localThrowable1 != null));
      while (true)
      {
        try
        {
          localUnpacker.close();
          throw localObject1;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable1.addSuppressed(localThrowable2);
          continue;
        }
        localUnpacker.close();
      }
    }
    finally
    {
      while (true)
        Throwable localThrowable1 = null;
    }
  }

  public String[] getSoSourceAbis()
  {
    if (this.mAbis == null)
      return super.getSoSourceAbis();
    return this.mAbis;
  }

  public int loadLibrary(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
    throws IOException
  {
    synchronized (getLibraryLock(paramString))
    {
      int i = loadLibraryFrom(paramString, paramInt, this.soDirectory, paramThreadPolicy);
      return i;
    }
  }

  protected abstract Unpacker makeUnpacker()
    throws IOException;

  protected void prepare(int paramInt)
    throws IOException
  {
    SysUtil.mkdirOrThrow(this.soDirectory);
    FileLocker localFileLocker1 = FileLocker.lock(new File(this.soDirectory, "dso_lock"));
    try
    {
      Log.v("fb-UnpackingSoSource", "locked dso store " + this.soDirectory);
      boolean bool = refreshLocked(localFileLocker1, paramInt, getDepsBlock());
      if (bool);
      for (FileLocker localFileLocker2 = null; localFileLocker2 != null; localFileLocker2 = localFileLocker1)
      {
        Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.soDirectory);
        localFileLocker2.close();
        return;
        Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.soDirectory);
      }
      Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
      return;
    }
    finally
    {
      if (localFileLocker1 == null)
        break label224;
    }
    Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.soDirectory);
    localFileLocker1.close();
    while (true)
    {
      throw localObject;
      label224: Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
    }
  }

  protected void prepare(String paramString)
    throws IOException
  {
    try
    {
      synchronized (getLibraryLock(paramString))
      {
        this.mCorruptedLib = paramString;
        prepare(2);
        return;
      }
    }
    finally
    {
    }
  }

  public void setSoSourceAbis(String[] paramArrayOfString)
  {
    this.mAbis = paramArrayOfString;
  }

  public static class Dso
  {
    public final String hash;
    public final String name;

    public Dso(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.hash = paramString2;
    }
  }

  public static final class DsoManifest
  {
    public final UnpackingSoSource.Dso[] dsos;

    public DsoManifest(UnpackingSoSource.Dso[] paramArrayOfDso)
    {
      this.dsos = paramArrayOfDso;
    }

    static final DsoManifest read(DataInput paramDataInput)
      throws IOException
    {
      if (paramDataInput.readByte() != 1)
        throw new RuntimeException("wrong dso manifest version");
      int i = paramDataInput.readInt();
      if (i < 0)
        throw new RuntimeException("illegal number of shared libraries");
      UnpackingSoSource.Dso[] arrayOfDso = new UnpackingSoSource.Dso[i];
      for (int j = 0; j < i; j++)
        arrayOfDso[j] = new UnpackingSoSource.Dso(paramDataInput.readUTF(), paramDataInput.readUTF());
      return new DsoManifest(arrayOfDso);
    }

    public final void write(DataOutput paramDataOutput)
      throws IOException
    {
      paramDataOutput.writeByte(1);
      paramDataOutput.writeInt(this.dsos.length);
      for (int i = 0; i < this.dsos.length; i++)
      {
        paramDataOutput.writeUTF(this.dsos[i].name);
        paramDataOutput.writeUTF(this.dsos[i].hash);
      }
    }
  }

  protected static final class InputDso
    implements Closeable
  {
    public final InputStream content;
    public final UnpackingSoSource.Dso dso;

    public InputDso(UnpackingSoSource.Dso paramDso, InputStream paramInputStream)
    {
      this.dso = paramDso;
      this.content = paramInputStream;
    }

    public void close()
      throws IOException
    {
      this.content.close();
    }
  }

  protected static abstract class InputDsoIterator
    implements Closeable
  {
    public void close()
      throws IOException
    {
    }

    public abstract boolean hasNext();

    public abstract UnpackingSoSource.InputDso next()
      throws IOException;
  }

  protected static abstract class Unpacker
    implements Closeable
  {
    public void close()
      throws IOException
    {
    }

    protected abstract UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException;

    protected abstract UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.UnpackingSoSource
 * JD-Core Version:    0.6.2
 */