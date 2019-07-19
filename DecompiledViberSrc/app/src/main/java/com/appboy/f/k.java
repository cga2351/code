package com.appboy.f;

import android.content.Context;
import java.io.File;

public class k
{
  private static final String a = c.a(k.class);

  public static File a(Context paramContext)
  {
    return new File(paramContext.getCacheDir().getPath() + "/" + "appboy-html-inapp-messages");
  }

  public static String a(File paramFile, String paramString)
  {
    if (paramFile == null)
    {
      c.d(a, "Internal cache directory is null. No local URL will be created.");
      return null;
    }
    if (i.c(paramString))
    {
      c.d(a, "Remote zip url is null or empty. No local URL will be created.");
      return null;
    }
    String str1 = paramFile.getAbsolutePath();
    String str2 = String.valueOf(f.a());
    String str3 = str1 + "/" + str2;
    c.b(a, "Starting download of url: " + paramString);
    File localFile = a.a(str3, paramString, str2, ".zip");
    if (localFile == null)
    {
      c.b(a, "Could not download zip file to local storage.");
      a.a(new File(str3));
      return null;
    }
    c.b(a, "Html content zip downloaded.");
    if (!a(str3, localFile))
    {
      c.d(a, "Error during the zip unpack.");
      a.a(new File(str3));
      return null;
    }
    c.b(a, "Html content zip unpacked.");
    return str3;
  }

  static String a(String paramString1, String paramString2)
  {
    String str1 = new File(paramString1).getCanonicalPath();
    String str2 = new File(paramString2).getCanonicalPath();
    if (str2.startsWith(str1))
      return str2;
    throw new IllegalStateException("Invalid file with original path: " + paramString2 + " with canonical path: " + str2 + " does not exist under intended parent with  path: " + paramString1 + " and canonical path: " + str1);
  }

  // ERROR //
  static boolean a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: invokestatic 61	com/appboy/f/i:c	(Ljava/lang/String;)Z
    //   8: ifeq +14 -> 22
    //   11: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   14: ldc 129
    //   16: invokestatic 131	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   19: pop
    //   20: iload_3
    //   21: ireturn
    //   22: aload_1
    //   23: ifnonnull +14 -> 37
    //   26: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   29: ldc 133
    //   31: invokestatic 131	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   34: pop
    //   35: iconst_0
    //   36: ireturn
    //   37: new 21	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 137	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: new 139	java/util/zip/ZipInputStream
    //   52: dup
    //   53: new 141	java/io/BufferedInputStream
    //   56: dup
    //   57: new 143	java/io/FileInputStream
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: invokespecial 148	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: invokespecial 149	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 5
    //   73: sipush 8192
    //   76: newarray byte
    //   78: astore 22
    //   80: aload 5
    //   82: invokevirtual 153	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   85: astore 23
    //   87: aload 23
    //   89: ifnull +196 -> 285
    //   92: aload 23
    //   94: invokevirtual 158	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   97: astore 24
    //   99: aload 24
    //   101: getstatic 164	java/util/Locale:US	Ljava/util/Locale;
    //   104: invokevirtual 168	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   107: ldc 170
    //   109: invokevirtual 110	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   112: ifne -32 -> 80
    //   115: aload_0
    //   116: new 23	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   123: aload_0
    //   124: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 40
    //   129: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 24
    //   134: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 172	com/appboy/f/k:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 25
    //   145: aload 23
    //   147: invokevirtual 175	java/util/zip/ZipEntry:isDirectory	()Z
    //   150: ifeq +73 -> 223
    //   153: new 21	java/io/File
    //   156: dup
    //   157: aload 25
    //   159: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: invokevirtual 137	java/io/File:mkdirs	()Z
    //   165: pop
    //   166: goto -86 -> 80
    //   169: astore 17
    //   171: aload 5
    //   173: astore 18
    //   175: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   178: ldc 177
    //   180: aload 17
    //   182: invokestatic 180	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   185: pop
    //   186: aload 18
    //   188: ifnull +8 -> 196
    //   191: aload 18
    //   193: invokevirtual 183	java/util/zip/ZipInputStream:close	()V
    //   196: iconst_0
    //   197: istore_3
    //   198: aload_2
    //   199: ifnull -179 -> 20
    //   202: aload_2
    //   203: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   206: iconst_0
    //   207: ireturn
    //   208: astore 20
    //   210: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   213: ldc 188
    //   215: aload 20
    //   217: invokestatic 180	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   220: pop
    //   221: iconst_0
    //   222: ireturn
    //   223: new 185	java/io/BufferedOutputStream
    //   226: dup
    //   227: new 190	java/io/FileOutputStream
    //   230: dup
    //   231: aload 25
    //   233: invokespecial 191	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   236: invokespecial 194	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   239: astore 26
    //   241: aload 5
    //   243: aload 22
    //   245: invokevirtual 198	java/util/zip/ZipInputStream:read	([B)I
    //   248: istore 27
    //   250: iload 27
    //   252: iconst_m1
    //   253: if_icmpeq +16 -> 269
    //   256: aload 26
    //   258: aload 22
    //   260: iconst_0
    //   261: iload 27
    //   263: invokevirtual 202	java/io/BufferedOutputStream:write	([BII)V
    //   266: goto -25 -> 241
    //   269: aload 26
    //   271: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   274: aload 5
    //   276: invokevirtual 205	java/util/zip/ZipInputStream:closeEntry	()V
    //   279: aload 26
    //   281: astore_2
    //   282: goto -202 -> 80
    //   285: aload 5
    //   287: invokevirtual 183	java/util/zip/ZipInputStream:close	()V
    //   290: iconst_1
    //   291: istore_3
    //   292: aload 5
    //   294: ifnull +8 -> 302
    //   297: aload 5
    //   299: invokevirtual 183	java/util/zip/ZipInputStream:close	()V
    //   302: aload_2
    //   303: ifnull -283 -> 20
    //   306: aload_2
    //   307: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   310: iload_3
    //   311: ireturn
    //   312: astore 29
    //   314: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   317: ldc 188
    //   319: aload 29
    //   321: invokestatic 180	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   324: pop
    //   325: iload_3
    //   326: ireturn
    //   327: astore 6
    //   329: aconst_null
    //   330: astore 5
    //   332: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   335: ldc 207
    //   337: aload 6
    //   339: invokestatic 180	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   342: pop
    //   343: aload 5
    //   345: ifnull +8 -> 353
    //   348: aload 5
    //   350: invokevirtual 183	java/util/zip/ZipInputStream:close	()V
    //   353: iconst_0
    //   354: istore_3
    //   355: aload_2
    //   356: ifnull -336 -> 20
    //   359: aload_2
    //   360: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   363: iconst_0
    //   364: ireturn
    //   365: astore 11
    //   367: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   370: ldc 188
    //   372: aload 11
    //   374: invokestatic 180	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   377: pop
    //   378: iconst_0
    //   379: ireturn
    //   380: astore 13
    //   382: aconst_null
    //   383: astore 5
    //   385: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   388: ldc 209
    //   390: aload 13
    //   392: invokestatic 180	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   395: pop
    //   396: aload 5
    //   398: ifnull +8 -> 406
    //   401: aload 5
    //   403: invokevirtual 183	java/util/zip/ZipInputStream:close	()V
    //   406: iconst_0
    //   407: istore_3
    //   408: aload_2
    //   409: ifnull -389 -> 20
    //   412: aload_2
    //   413: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   416: iconst_0
    //   417: ireturn
    //   418: astore 15
    //   420: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   423: ldc 188
    //   425: aload 15
    //   427: invokestatic 180	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   430: pop
    //   431: iconst_0
    //   432: ireturn
    //   433: astore 7
    //   435: aconst_null
    //   436: astore 5
    //   438: aload 5
    //   440: ifnull +8 -> 448
    //   443: aload 5
    //   445: invokevirtual 183	java/util/zip/ZipInputStream:close	()V
    //   448: aload_2
    //   449: ifnull +7 -> 456
    //   452: aload_2
    //   453: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   456: aload 7
    //   458: athrow
    //   459: astore 8
    //   461: getstatic 15	com/appboy/f/k:a	Ljava/lang/String;
    //   464: ldc 188
    //   466: aload 8
    //   468: invokestatic 180	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   471: pop
    //   472: goto -16 -> 456
    //   475: astore 7
    //   477: goto -39 -> 438
    //   480: astore 7
    //   482: aload 26
    //   484: astore_2
    //   485: goto -47 -> 438
    //   488: astore 7
    //   490: aload 18
    //   492: astore 5
    //   494: goto -56 -> 438
    //   497: astore 13
    //   499: goto -114 -> 385
    //   502: astore 13
    //   504: aload 26
    //   506: astore_2
    //   507: goto -122 -> 385
    //   510: astore 6
    //   512: goto -180 -> 332
    //   515: astore 6
    //   517: aload 26
    //   519: astore_2
    //   520: goto -188 -> 332
    //   523: astore 17
    //   525: aconst_null
    //   526: astore_2
    //   527: aconst_null
    //   528: astore 18
    //   530: goto -355 -> 175
    //   533: astore 17
    //   535: aload 26
    //   537: astore_2
    //   538: aload 5
    //   540: astore 18
    //   542: goto -367 -> 175
    //
    // Exception table:
    //   from	to	target	type
    //   73	80	169	java/io/FileNotFoundException
    //   80	87	169	java/io/FileNotFoundException
    //   92	166	169	java/io/FileNotFoundException
    //   223	241	169	java/io/FileNotFoundException
    //   285	290	169	java/io/FileNotFoundException
    //   191	196	208	java/io/IOException
    //   202	206	208	java/io/IOException
    //   297	302	312	java/io/IOException
    //   306	310	312	java/io/IOException
    //   49	73	327	java/io/IOException
    //   348	353	365	java/io/IOException
    //   359	363	365	java/io/IOException
    //   49	73	380	java/lang/Throwable
    //   401	406	418	java/io/IOException
    //   412	416	418	java/io/IOException
    //   49	73	433	finally
    //   443	448	459	java/io/IOException
    //   452	456	459	java/io/IOException
    //   73	80	475	finally
    //   80	87	475	finally
    //   92	166	475	finally
    //   223	241	475	finally
    //   285	290	475	finally
    //   332	343	475	finally
    //   385	396	475	finally
    //   241	250	480	finally
    //   256	266	480	finally
    //   269	279	480	finally
    //   175	186	488	finally
    //   73	80	497	java/lang/Throwable
    //   80	87	497	java/lang/Throwable
    //   92	166	497	java/lang/Throwable
    //   223	241	497	java/lang/Throwable
    //   285	290	497	java/lang/Throwable
    //   241	250	502	java/lang/Throwable
    //   256	266	502	java/lang/Throwable
    //   269	279	502	java/lang/Throwable
    //   73	80	510	java/io/IOException
    //   80	87	510	java/io/IOException
    //   92	166	510	java/io/IOException
    //   223	241	510	java/io/IOException
    //   285	290	510	java/io/IOException
    //   241	250	515	java/io/IOException
    //   256	266	515	java/io/IOException
    //   269	279	515	java/io/IOException
    //   49	73	523	java/io/FileNotFoundException
    //   241	250	533	java/io/FileNotFoundException
    //   256	266	533	java/io/FileNotFoundException
    //   269	279	533	java/io/FileNotFoundException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.k
 * JD-Core Version:    0.6.2
 */