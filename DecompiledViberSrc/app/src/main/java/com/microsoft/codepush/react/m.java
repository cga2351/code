package com.microsoft.codepush.react;

import java.io.File;

public class m
{
  public static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = arrayOfFile.length;
      int j = 0;
      if (j < i)
      {
        File localFile = arrayOfFile[j];
        if (localFile.isDirectory())
          a(localFile);
        while (true)
        {
          j++;
          break;
          localFile.delete();
        }
      }
    }
    if (!paramFile.delete())
      j.b("Error deleting file " + paramFile.getName());
  }

  // ERROR //
  public static void a(File paramFile, String paramString)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 51	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: new 55	java/io/BufferedInputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 58	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: new 60	java/util/zip/ZipInputStream
    //   21: dup
    //   22: aload_3
    //   23: invokespecial 61	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore 4
    //   28: new 8	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 66	java/io/File:exists	()Z
    //   43: ifeq +8 -> 51
    //   46: aload 5
    //   48: invokestatic 18	com/microsoft/codepush/react/m:a	(Ljava/io/File;)V
    //   51: aload 5
    //   53: invokevirtual 69	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: sipush 8192
    //   60: newarray byte
    //   62: astore 11
    //   64: aload 4
    //   66: invokevirtual 73	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   69: astore 12
    //   71: aload 12
    //   73: ifnull +177 -> 250
    //   76: new 8	java/io/File
    //   79: dup
    //   80: aload 5
    //   82: aload 12
    //   84: invokevirtual 76	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   87: invokespecial 78	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   90: astore 13
    //   92: aload 12
    //   94: invokevirtual 79	java/util/zip/ZipEntry:isDirectory	()Z
    //   97: ifeq +75 -> 172
    //   100: aload 13
    //   102: invokevirtual 69	java/io/File:mkdirs	()Z
    //   105: pop
    //   106: aload 12
    //   108: invokevirtual 83	java/util/zip/ZipEntry:getTime	()J
    //   111: lstore 18
    //   113: lload 18
    //   115: lconst_0
    //   116: lcmp
    //   117: ifle -53 -> 64
    //   120: aload 13
    //   122: lload 18
    //   124: invokevirtual 87	java/io/File:setLastModified	(J)Z
    //   127: pop
    //   128: goto -64 -> 64
    //   131: astore 6
    //   133: aload_3
    //   134: astore 7
    //   136: aload_2
    //   137: astore 8
    //   139: aload 4
    //   141: ifnull +8 -> 149
    //   144: aload 4
    //   146: invokevirtual 90	java/util/zip/ZipInputStream:close	()V
    //   149: aload 7
    //   151: ifnull +8 -> 159
    //   154: aload 7
    //   156: invokevirtual 91	java/io/BufferedInputStream:close	()V
    //   159: aload 8
    //   161: ifnull +8 -> 169
    //   164: aload 8
    //   166: invokevirtual 92	java/io/FileInputStream:close	()V
    //   169: aload 6
    //   171: athrow
    //   172: aload 13
    //   174: invokevirtual 96	java/io/File:getParentFile	()Ljava/io/File;
    //   177: astore 14
    //   179: aload 14
    //   181: invokevirtual 66	java/io/File:exists	()Z
    //   184: ifne +9 -> 193
    //   187: aload 14
    //   189: invokevirtual 69	java/io/File:mkdirs	()Z
    //   192: pop
    //   193: new 98	java/io/FileOutputStream
    //   196: dup
    //   197: aload 13
    //   199: invokespecial 99	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   202: astore 15
    //   204: aload 4
    //   206: aload 11
    //   208: invokevirtual 103	java/util/zip/ZipInputStream:read	([B)I
    //   211: istore 17
    //   213: iload 17
    //   215: iconst_m1
    //   216: if_icmpeq +26 -> 242
    //   219: aload 15
    //   221: aload 11
    //   223: iconst_0
    //   224: iload 17
    //   226: invokevirtual 107	java/io/FileOutputStream:write	([BII)V
    //   229: goto -25 -> 204
    //   232: astore 16
    //   234: aload 15
    //   236: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   239: aload 16
    //   241: athrow
    //   242: aload 15
    //   244: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   247: goto -141 -> 106
    //   250: aload 4
    //   252: ifnull +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 90	java/util/zip/ZipInputStream:close	()V
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 91	java/io/BufferedInputStream:close	()V
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 92	java/io/FileInputStream:close	()V
    //   276: return
    //   277: astore 23
    //   279: new 110	com/microsoft/codepush/react/f
    //   282: dup
    //   283: ldc 112
    //   285: aload 23
    //   287: invokespecial 115	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   290: athrow
    //   291: astore 9
    //   293: new 110	com/microsoft/codepush/react/f
    //   296: dup
    //   297: ldc 112
    //   299: aload 9
    //   301: invokespecial 115	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   304: athrow
    //   305: astore 6
    //   307: aconst_null
    //   308: astore 4
    //   310: aconst_null
    //   311: astore 7
    //   313: aconst_null
    //   314: astore 8
    //   316: goto -177 -> 139
    //   319: astore 6
    //   321: aload_2
    //   322: astore 8
    //   324: aconst_null
    //   325: astore 4
    //   327: aconst_null
    //   328: astore 7
    //   330: goto -191 -> 139
    //   333: astore 6
    //   335: aload_3
    //   336: astore 7
    //   338: aload_2
    //   339: astore 8
    //   341: aconst_null
    //   342: astore 4
    //   344: goto -205 -> 139
    //
    // Exception table:
    //   from	to	target	type
    //   28	51	131	finally
    //   51	64	131	finally
    //   64	71	131	finally
    //   76	106	131	finally
    //   106	113	131	finally
    //   120	128	131	finally
    //   172	193	131	finally
    //   193	204	131	finally
    //   234	242	131	finally
    //   242	247	131	finally
    //   204	213	232	finally
    //   219	229	232	finally
    //   255	260	277	java/io/IOException
    //   264	268	277	java/io/IOException
    //   272	276	277	java/io/IOException
    //   144	149	291	java/io/IOException
    //   154	159	291	java/io/IOException
    //   164	169	291	java/io/IOException
    //   0	9	305	finally
    //   9	18	319	finally
    //   18	28	333	finally
  }

  public static void a(File paramFile, String paramString1, String paramString2)
  {
    File localFile1 = new File(paramString1);
    if (!localFile1.exists())
      localFile1.mkdirs();
    File localFile2 = new File(paramString1, paramString2);
    if (!paramFile.renameTo(localFile2))
      throw new f("Unable to move file from " + paramFile.getAbsolutePath() + " to " + localFile2.getAbsolutePath() + ".");
  }

  public static void a(String paramString)
  {
    if (paramString == null)
      j.b("deleteDirectoryAtPath attempted with null directoryPath");
    File localFile;
    do
    {
      return;
      localFile = new File(paramString);
    }
    while (!localFile.exists());
    a(localFile);
  }

  // ERROR //
  public static void a(String paramString1, String paramString2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 8	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: new 8	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 66	java/io/File:exists	()Z
    //   26: ifne +9 -> 35
    //   29: aload 4
    //   31: invokevirtual 138	java/io/File:mkdir	()Z
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 16	java/io/File:listFiles	()[Ljava/io/File;
    //   39: astore 5
    //   41: aload 5
    //   43: arraylength
    //   44: istore 6
    //   46: iload_2
    //   47: iload 6
    //   49: if_icmpge +231 -> 280
    //   52: aload 5
    //   54: iload_2
    //   55: aaload
    //   56: astore 7
    //   58: aload 7
    //   60: invokevirtual 12	java/io/File:isDirectory	()Z
    //   63: ifeq +30 -> 93
    //   66: aload_0
    //   67: aload 7
    //   69: invokevirtual 37	java/io/File:getName	()Ljava/lang/String;
    //   72: invokestatic 141	com/microsoft/codepush/react/j:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: aload_1
    //   76: aload 7
    //   78: invokevirtual 37	java/io/File:getName	()Ljava/lang/String;
    //   81: invokestatic 141	com/microsoft/codepush/react/j:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 143	com/microsoft/codepush/react/m:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: iinc 2 1
    //   90: goto -44 -> 46
    //   93: new 8	java/io/File
    //   96: dup
    //   97: aload 4
    //   99: aload 7
    //   101: invokevirtual 37	java/io/File:getName	()Ljava/lang/String;
    //   104: invokespecial 78	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   107: astore 8
    //   109: sipush 8192
    //   112: newarray byte
    //   114: astore 9
    //   116: new 51	java/io/FileInputStream
    //   119: dup
    //   120: aload 7
    //   122: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: astore 10
    //   127: new 55	java/io/BufferedInputStream
    //   130: dup
    //   131: aload 10
    //   133: invokespecial 58	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   136: astore 11
    //   138: new 98	java/io/FileOutputStream
    //   141: dup
    //   142: aload 8
    //   144: invokespecial 99	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   147: astore 12
    //   149: aload 11
    //   151: aload 9
    //   153: invokevirtual 144	java/io/BufferedInputStream:read	([B)I
    //   156: istore 17
    //   158: iload 17
    //   160: ifle +59 -> 219
    //   163: aload 12
    //   165: aload 9
    //   167: iconst_0
    //   168: iload 17
    //   170: invokevirtual 107	java/io/FileOutputStream:write	([BII)V
    //   173: goto -24 -> 149
    //   176: astore 13
    //   178: aload 11
    //   180: astore 14
    //   182: aload 10
    //   184: astore 15
    //   186: aload 15
    //   188: ifnull +8 -> 196
    //   191: aload 15
    //   193: invokevirtual 92	java/io/FileInputStream:close	()V
    //   196: aload 14
    //   198: ifnull +8 -> 206
    //   201: aload 14
    //   203: invokevirtual 91	java/io/BufferedInputStream:close	()V
    //   206: aload 12
    //   208: ifnull +8 -> 216
    //   211: aload 12
    //   213: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   216: aload 13
    //   218: athrow
    //   219: aload 10
    //   221: ifnull +8 -> 229
    //   224: aload 10
    //   226: invokevirtual 92	java/io/FileInputStream:close	()V
    //   229: aload 11
    //   231: ifnull +8 -> 239
    //   234: aload 11
    //   236: invokevirtual 91	java/io/BufferedInputStream:close	()V
    //   239: aload 12
    //   241: ifnull -154 -> 87
    //   244: aload 12
    //   246: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   249: goto -162 -> 87
    //   252: astore 18
    //   254: new 110	com/microsoft/codepush/react/f
    //   257: dup
    //   258: ldc 112
    //   260: aload 18
    //   262: invokespecial 115	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: athrow
    //   266: astore 16
    //   268: new 110	com/microsoft/codepush/react/f
    //   271: dup
    //   272: ldc 112
    //   274: aload 16
    //   276: invokespecial 115	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: athrow
    //   280: return
    //   281: astore 13
    //   283: aconst_null
    //   284: astore 12
    //   286: aconst_null
    //   287: astore 14
    //   289: aconst_null
    //   290: astore 15
    //   292: goto -106 -> 186
    //   295: astore 13
    //   297: aload 10
    //   299: astore 15
    //   301: aconst_null
    //   302: astore 12
    //   304: aconst_null
    //   305: astore 14
    //   307: goto -121 -> 186
    //   310: astore 13
    //   312: aload 11
    //   314: astore 14
    //   316: aload 10
    //   318: astore 15
    //   320: aconst_null
    //   321: astore 12
    //   323: goto -137 -> 186
    //
    // Exception table:
    //   from	to	target	type
    //   149	158	176	finally
    //   163	173	176	finally
    //   224	229	252	java/io/IOException
    //   234	239	252	java/io/IOException
    //   244	249	252	java/io/IOException
    //   191	196	266	java/io/IOException
    //   201	206	266	java/io/IOException
    //   211	216	266	java/io/IOException
    //   116	127	281	finally
    //   127	138	295	finally
    //   138	149	310	finally
  }

  public static void b(String paramString)
  {
    a(new File(paramString));
  }

  // ERROR //
  public static void b(String paramString1, String paramString2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 146	java/io/PrintWriter
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 147	java/io/PrintWriter:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: aload_0
    //   11: invokevirtual 150	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: ifnull +7 -> 22
    //   18: aload_2
    //   19: invokevirtual 151	java/io/PrintWriter:close	()V
    //   22: return
    //   23: astore_3
    //   24: aconst_null
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +7 -> 34
    //   30: aload_2
    //   31: invokevirtual 151	java/io/PrintWriter:close	()V
    //   34: aload_3
    //   35: athrow
    //   36: astore_3
    //   37: goto -11 -> 26
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	23	finally
    //   9	14	36	finally
  }

  public static boolean c(String paramString)
  {
    return new File(paramString).exists();
  }

  // ERROR //
  public static String d(String paramString)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 51	java/io/FileInputStream
    //   3: dup
    //   4: new 8	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_1
    //   16: new 157	java/io/BufferedReader
    //   19: dup
    //   20: new 159	java/io/InputStreamReader
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 160	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   28: invokespecial 163	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: new 23	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   39: astore_3
    //   40: aload_2
    //   41: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 6
    //   46: aload 6
    //   48: ifnull +44 -> 92
    //   51: aload_3
    //   52: aload 6
    //   54: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 168
    //   59: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: goto -23 -> 40
    //   66: astore 4
    //   68: aload_1
    //   69: astore 5
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 169	java/io/BufferedReader:close	()V
    //   79: aload 5
    //   81: ifnull +8 -> 89
    //   84: aload 5
    //   86: invokevirtual 92	java/io/FileInputStream:close	()V
    //   89: aload 4
    //   91: athrow
    //   92: aload_3
    //   93: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore 8
    //   98: aload_2
    //   99: ifnull +7 -> 106
    //   102: aload_2
    //   103: invokevirtual 169	java/io/BufferedReader:close	()V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 92	java/io/FileInputStream:close	()V
    //   114: aload 8
    //   116: areturn
    //   117: astore 4
    //   119: aconst_null
    //   120: astore_2
    //   121: aconst_null
    //   122: astore 5
    //   124: goto -53 -> 71
    //   127: astore 4
    //   129: aload_1
    //   130: astore 5
    //   132: aconst_null
    //   133: astore_2
    //   134: goto -63 -> 71
    //
    // Exception table:
    //   from	to	target	type
    //   32	40	66	finally
    //   40	46	66	finally
    //   51	63	66	finally
    //   92	98	66	finally
    //   0	16	117	finally
    //   16	32	127	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.m
 * JD-Core Version:    0.6.2
 */