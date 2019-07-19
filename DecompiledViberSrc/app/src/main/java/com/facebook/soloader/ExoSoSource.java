package com.facebook.soloader;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class ExoSoSource extends UnpackingSoSource
{
  public ExoSoSource(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }

  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ExoUnpacker(this);
  }

  private final class ExoUnpacker extends UnpackingSoSource.Unpacker
  {
    private final ExoSoSource.FileDso[] mDsos;

    // ERROR //
    ExoUnpacker(UnpackingSoSource arg2)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 16	com/facebook/soloader/ExoSoSource$ExoUnpacker:this$0	Lcom/facebook/soloader/ExoSoSource;
      //   5: aload_0
      //   6: invokespecial 19	com/facebook/soloader/UnpackingSoSource$Unpacker:<init>	()V
      //   9: aload_1
      //   10: getfield 25	com/facebook/soloader/ExoSoSource:mContext	Landroid/content/Context;
      //   13: astore_3
      //   14: new 27	java/io/File
      //   17: dup
      //   18: new 29	java/lang/StringBuilder
      //   21: dup
      //   22: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   25: ldc 32
      //   27: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: aload_3
      //   31: invokevirtual 42	android/content/Context:getPackageName	()Ljava/lang/String;
      //   34: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: ldc 44
      //   39: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   45: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
      //   48: astore 4
      //   50: new 52	java/util/ArrayList
      //   53: dup
      //   54: invokespecial 53	java/util/ArrayList:<init>	()V
      //   57: astore 5
      //   59: new 55	java/util/LinkedHashSet
      //   62: dup
      //   63: invokespecial 56	java/util/LinkedHashSet:<init>	()V
      //   66: astore 6
      //   68: invokestatic 62	com/facebook/soloader/SysUtil:getSupportedAbis	()[Ljava/lang/String;
      //   71: astore 7
      //   73: aload 7
      //   75: arraylength
      //   76: istore 8
      //   78: iconst_0
      //   79: istore 9
      //   81: iload 9
      //   83: iload 8
      //   85: if_icmpge +463 -> 548
      //   88: aload 7
      //   90: iload 9
      //   92: aaload
      //   93: astore 10
      //   95: new 27	java/io/File
      //   98: dup
      //   99: aload 4
      //   101: aload 10
      //   103: invokespecial 65	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   106: astore 11
      //   108: aload 11
      //   110: invokevirtual 69	java/io/File:isDirectory	()Z
      //   113: ifne +9 -> 122
      //   116: iinc 9 1
      //   119: goto -38 -> 81
      //   122: aload 6
      //   124: aload 10
      //   126: invokeinterface 75 2 0
      //   131: pop
      //   132: new 27	java/io/File
      //   135: dup
      //   136: aload 11
      //   138: ldc 77
      //   140: invokespecial 65	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   143: astore 13
      //   145: aload 13
      //   147: invokevirtual 80	java/io/File:isFile	()Z
      //   150: ifeq -34 -> 116
      //   153: new 82	java/io/FileReader
      //   156: dup
      //   157: aload 13
      //   159: invokespecial 85	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   162: astore 14
      //   164: new 87	java/io/BufferedReader
      //   167: dup
      //   168: aload 14
      //   170: invokespecial 90	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   173: astore 15
      //   175: aload 15
      //   177: invokevirtual 93	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   180: astore 26
      //   182: aload 26
      //   184: ifnull +255 -> 439
      //   187: aload 26
      //   189: invokevirtual 99	java/lang/String:length	()I
      //   192: ifeq -17 -> 175
      //   195: aload 26
      //   197: bipush 32
      //   199: invokevirtual 103	java/lang/String:indexOf	(I)I
      //   202: istore 27
      //   204: iload 27
      //   206: iconst_m1
      //   207: if_icmpne +102 -> 309
      //   210: new 105	java/lang/RuntimeException
      //   213: dup
      //   214: new 29	java/lang/StringBuilder
      //   217: dup
      //   218: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   221: ldc 107
      //   223: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   226: aload 26
      //   228: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   231: ldc 109
      //   233: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   236: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   239: invokespecial 110	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   242: athrow
      //   243: astore 24
      //   245: aload 24
      //   247: athrow
      //   248: astore 25
      //   250: aload 24
      //   252: astore 17
      //   254: aload 25
      //   256: astore 16
      //   258: aload 15
      //   260: ifnull +13 -> 273
      //   263: aload 17
      //   265: ifnull +247 -> 512
      //   268: aload 15
      //   270: invokevirtual 113	java/io/BufferedReader:close	()V
      //   273: aload 16
      //   275: athrow
      //   276: astore 21
      //   278: aload 21
      //   280: athrow
      //   281: astore 22
      //   283: aload 21
      //   285: astore 19
      //   287: aload 22
      //   289: astore 18
      //   291: aload 14
      //   293: ifnull +13 -> 306
      //   296: aload 19
      //   298: ifnull +242 -> 540
      //   301: aload 14
      //   303: invokevirtual 114	java/io/FileReader:close	()V
      //   306: aload 18
      //   308: athrow
      //   309: new 29	java/lang/StringBuilder
      //   312: dup
      //   313: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   316: aload 26
      //   318: iconst_0
      //   319: iload 27
      //   321: invokevirtual 118	java/lang/String:substring	(II)Ljava/lang/String;
      //   324: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   327: ldc 120
      //   329: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   332: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   335: astore 28
      //   337: aload 5
      //   339: invokevirtual 123	java/util/ArrayList:size	()I
      //   342: istore 29
      //   344: iconst_0
      //   345: istore 30
      //   347: iload 30
      //   349: iload 29
      //   351: if_icmpge +242 -> 593
      //   354: aload 5
      //   356: iload 30
      //   358: invokevirtual 127	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   361: checkcast 129	com/facebook/soloader/ExoSoSource$FileDso
      //   364: getfield 133	com/facebook/soloader/ExoSoSource$FileDso:name	Ljava/lang/String;
      //   367: aload 28
      //   369: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   372: ifeq +61 -> 433
      //   375: iconst_1
      //   376: istore 31
      //   378: iload 31
      //   380: ifne -205 -> 175
      //   383: aload 26
      //   385: iload 27
      //   387: iconst_1
      //   388: iadd
      //   389: invokevirtual 139	java/lang/String:substring	(I)Ljava/lang/String;
      //   392: astore 32
      //   394: aload 5
      //   396: new 129	com/facebook/soloader/ExoSoSource$FileDso
      //   399: dup
      //   400: aload 28
      //   402: aload 32
      //   404: new 27	java/io/File
      //   407: dup
      //   408: aload 11
      //   410: aload 32
      //   412: invokespecial 65	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   415: invokespecial 142	com/facebook/soloader/ExoSoSource$FileDso:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
      //   418: invokevirtual 143	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   421: pop
      //   422: goto -247 -> 175
      //   425: astore 16
      //   427: aconst_null
      //   428: astore 17
      //   430: goto -172 -> 258
      //   433: iinc 30 1
      //   436: goto -89 -> 347
      //   439: aload 15
      //   441: ifnull +12 -> 453
      //   444: iconst_0
      //   445: ifeq +47 -> 492
      //   448: aload 15
      //   450: invokevirtual 113	java/io/BufferedReader:close	()V
      //   453: aload 14
      //   455: ifnull -339 -> 116
      //   458: iconst_0
      //   459: ifeq +61 -> 520
      //   462: aload 14
      //   464: invokevirtual 114	java/io/FileReader:close	()V
      //   467: goto -351 -> 116
      //   470: astore 34
      //   472: aconst_null
      //   473: aload 34
      //   475: invokevirtual 147	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   478: goto -362 -> 116
      //   481: astore 35
      //   483: aconst_null
      //   484: aload 35
      //   486: invokevirtual 147	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   489: goto -36 -> 453
      //   492: aload 15
      //   494: invokevirtual 113	java/io/BufferedReader:close	()V
      //   497: goto -44 -> 453
      //   500: astore 23
      //   502: aload 17
      //   504: aload 23
      //   506: invokevirtual 147	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   509: goto -236 -> 273
      //   512: aload 15
      //   514: invokevirtual 113	java/io/BufferedReader:close	()V
      //   517: goto -244 -> 273
      //   520: aload 14
      //   522: invokevirtual 114	java/io/FileReader:close	()V
      //   525: goto -409 -> 116
      //   528: astore 20
      //   530: aload 19
      //   532: aload 20
      //   534: invokevirtual 147	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   537: goto -231 -> 306
      //   540: aload 14
      //   542: invokevirtual 114	java/io/FileReader:close	()V
      //   545: goto -239 -> 306
      //   548: aload_2
      //   549: aload 6
      //   551: aload 6
      //   553: invokeinterface 148 1 0
      //   558: anewarray 95	java/lang/String
      //   561: invokeinterface 152 2 0
      //   566: checkcast 154	[Ljava/lang/String;
      //   569: invokevirtual 160	com/facebook/soloader/UnpackingSoSource:setSoSourceAbis	([Ljava/lang/String;)V
      //   572: aload_0
      //   573: aload 5
      //   575: aload 5
      //   577: invokevirtual 123	java/util/ArrayList:size	()I
      //   580: anewarray 129	com/facebook/soloader/ExoSoSource$FileDso
      //   583: invokevirtual 161	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
      //   586: checkcast 162	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   589: putfield 164	com/facebook/soloader/ExoSoSource$ExoUnpacker:mDsos	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   592: return
      //   593: iconst_0
      //   594: istore 31
      //   596: goto -218 -> 378
      //   599: astore 18
      //   601: aconst_null
      //   602: astore 19
      //   604: goto -313 -> 291
      //
      // Exception table:
      //   from	to	target	type
      //   175	182	243	java/lang/Throwable
      //   187	204	243	java/lang/Throwable
      //   210	243	243	java/lang/Throwable
      //   309	344	243	java/lang/Throwable
      //   354	375	243	java/lang/Throwable
      //   383	422	243	java/lang/Throwable
      //   245	248	248	finally
      //   164	175	276	java/lang/Throwable
      //   273	276	276	java/lang/Throwable
      //   483	489	276	java/lang/Throwable
      //   492	497	276	java/lang/Throwable
      //   502	509	276	java/lang/Throwable
      //   512	517	276	java/lang/Throwable
      //   278	281	281	finally
      //   175	182	425	finally
      //   187	204	425	finally
      //   210	243	425	finally
      //   309	344	425	finally
      //   354	375	425	finally
      //   383	422	425	finally
      //   462	467	470	java/lang/Throwable
      //   448	453	481	java/lang/Throwable
      //   268	273	500	java/lang/Throwable
      //   301	306	528	java/lang/Throwable
      //   164	175	599	finally
      //   268	273	599	finally
      //   273	276	599	finally
      //   448	453	599	finally
      //   483	489	599	finally
      //   492	497	599	finally
      //   502	509	599	finally
      //   512	517	599	finally
    }

    protected UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException
    {
      return new UnpackingSoSource.DsoManifest(this.mDsos);
    }

    protected UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException
    {
      return new FileBackedInputDsoIterator(null);
    }

    private final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator
    {
      private int mCurrentDso;

      private FileBackedInputDsoIterator()
      {
      }

      public boolean hasNext()
      {
        return this.mCurrentDso < ExoSoSource.ExoUnpacker.this.mDsos.length;
      }

      public UnpackingSoSource.InputDso next()
        throws IOException
      {
        ExoSoSource.FileDso[] arrayOfFileDso = ExoSoSource.ExoUnpacker.this.mDsos;
        int i = this.mCurrentDso;
        this.mCurrentDso = (i + 1);
        ExoSoSource.FileDso localFileDso = arrayOfFileDso[i];
        FileInputStream localFileInputStream = new FileInputStream(localFileDso.backingFile);
        try
        {
          UnpackingSoSource.InputDso localInputDso = new UnpackingSoSource.InputDso(localFileDso, localFileInputStream);
          if (0 != 0)
            null.close();
          return localInputDso;
        }
        finally
        {
          if (localFileInputStream != null)
            localFileInputStream.close();
        }
      }
    }
  }

  private static final class FileDso extends UnpackingSoSource.Dso
  {
    final File backingFile;

    FileDso(String paramString1, String paramString2, File paramFile)
    {
      super(paramString2);
      this.backingFile = paramFile;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.ExoSoSource
 * JD-Core Version:    0.6.2
 */