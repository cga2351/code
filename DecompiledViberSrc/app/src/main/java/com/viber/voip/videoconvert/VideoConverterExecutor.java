package com.viber.voip.videoconvert;

import android.content.Context;
import android.os.RemoteException;
import com.viber.voip.ah;
import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoConverterExecutor
  implements VideoConverterNative.IVideoConverterProgressObserver
{
  static Map<String, g> _cbs = Collections.synchronizedMap(new HashMap());
  private int _native_init_status = -5;
  private AtomicBoolean _permissionsSettled = new AtomicBoolean(false);

  private void fixLibraryPermissions()
  {
    new File("/data/data/" + VideoConverterService.b().getPackageName() + "/lib/").listFiles(new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        boolean bool = paramAnonymousFile.getName().endsWith(".so");
        paramAnonymousFile.setExecutable(bool, true);
        return bool;
      }
    });
  }

  // ERROR //
  private static String getFileMD5Digest(android.net.Uri paramUri)
  {
    // Byte code:
    //   0: new 41	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 92	android/net/Uri:getPath	()Ljava/lang/String;
    //   8: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 96	java/io/File:exists	()Z
    //   16: ifeq +12 -> 28
    //   19: aload_1
    //   20: invokevirtual 100	java/io/File:length	()J
    //   23: lconst_0
    //   24: lcmp
    //   25: ifne +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: ldc 102
    //   32: invokestatic 108	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   35: astore_3
    //   36: new 110	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokevirtual 92	android/net/Uri:getPath	()Ljava/lang/String;
    //   44: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   47: astore 4
    //   49: sipush 8192
    //   52: newarray byte
    //   54: astore 5
    //   56: aload 4
    //   58: aload 5
    //   60: invokevirtual 117	java/io/InputStream:read	([B)I
    //   63: istore 9
    //   65: iload 9
    //   67: ifle +61 -> 128
    //   70: aload_3
    //   71: aload 5
    //   73: iconst_0
    //   74: iload 9
    //   76: invokevirtual 121	java/security/MessageDigest:update	([BII)V
    //   79: goto -23 -> 56
    //   82: astore 8
    //   84: new 123	java/lang/RuntimeException
    //   87: dup
    //   88: ldc 125
    //   90: aload 8
    //   92: invokespecial 128	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: athrow
    //   96: astore 6
    //   98: aload 4
    //   100: invokevirtual 131	java/io/InputStream:close	()V
    //   103: aload 6
    //   105: athrow
    //   106: astore_2
    //   107: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   110: aload_2
    //   111: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   114: aconst_null
    //   115: areturn
    //   116: astore 12
    //   118: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   121: aload 12
    //   123: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   126: aconst_null
    //   127: areturn
    //   128: ldc 142
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: new 144	java/math/BigInteger
    //   139: dup
    //   140: iconst_1
    //   141: aload_3
    //   142: invokevirtual 148	java/security/MessageDigest:digest	()[B
    //   145: invokespecial 151	java/math/BigInteger:<init>	(I[B)V
    //   148: bipush 16
    //   150: invokevirtual 154	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 160	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   157: bipush 32
    //   159: bipush 48
    //   161: invokevirtual 164	java/lang/String:replace	(CC)Ljava/lang/String;
    //   164: astore 10
    //   166: aload 4
    //   168: invokevirtual 131	java/io/InputStream:close	()V
    //   171: aload 10
    //   173: areturn
    //   174: astore 11
    //   176: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   179: aload 11
    //   181: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   184: aload 10
    //   186: areturn
    //   187: astore 7
    //   189: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   192: aload 7
    //   194: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   197: goto -94 -> 103
    //
    // Exception table:
    //   from	to	target	type
    //   56	65	82	java/io/IOException
    //   70	79	82	java/io/IOException
    //   128	166	82	java/io/IOException
    //   56	65	96	finally
    //   70	79	96	finally
    //   84	96	96	finally
    //   128	166	96	finally
    //   30	36	106	java/security/NoSuchAlgorithmException
    //   36	49	116	java/io/FileNotFoundException
    //   166	171	174	java/io/IOException
    //   98	103	187	java/io/IOException
  }

  public static void interrupt(String paramString)
  {
    g localg = (g)_cbs.get(paramString);
    if (localg == null)
      return;
    localg.s = true;
  }

  public void initialize()
  {
    if ((!VideoConverterNative.b()) || (VideoConverterService.b() == null));
    String str;
    Matcher localMatcher;
    do
    {
      return;
      str = "/data/data/" + VideoConverterService.b().getPackageName() + "/lib/libinput.384x256.h264.so";
      localMatcher = Pattern.compile(".*\\/libinput\\.(\\d*)x(\\d*)\\.h264\\.so").matcher(str);
    }
    while (!localMatcher.matches());
    int i = Integer.parseInt(localMatcher.group(1));
    int j = Integer.parseInt(localMatcher.group(2));
    try
    {
      this._native_init_status = VideoConverterNative.initialize(this, str, i, j, VideoConverterService.b().getPackageName());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void onProgress(String paramString, int paramInt)
  {
    g localg = (g)_cbs.get(paramString);
    if (localg == null);
    while (true)
    {
      return;
      try
      {
        if (localg.p != null)
        {
          localg.p.a(localg.r, paramInt);
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        e.a().a(localRemoteException);
      }
    }
  }

  // ERROR //
  public int process(com.viber.voip.VideoConverterPreparedRequest paramVideoConverterPreparedRequest, ah paramah, b paramb)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 244	com/viber/voip/VideoConverterPreparedRequest:request	()Lcom/viber/voip/VideoConverterRequest;
    //   4: astore 4
    //   6: new 246	com/viber/voip/videoconvert/a
    //   9: dup
    //   10: aload 4
    //   12: invokevirtual 251	com/viber/voip/VideoConverterRequest:debugHints	()Ljava/lang/String;
    //   15: invokespecial 252	com/viber/voip/videoconvert/a:<init>	(Ljava/lang/String;)V
    //   18: astore 5
    //   20: aload 5
    //   22: bipush 69
    //   24: invokevirtual 255	com/viber/voip/videoconvert/a:a	(I)Z
    //   27: ifeq +39 -> 66
    //   30: aload_2
    //   31: ifnull +29 -> 60
    //   34: new 257	com/viber/voip/VideoConverterReply
    //   37: dup
    //   38: aload 4
    //   40: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   43: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   46: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   49: astore 69
    //   51: aload_2
    //   52: aload_1
    //   53: aload 69
    //   55: invokeinterface 272 3 0
    //   60: iconst_m1
    //   61: istore 64
    //   63: iload 64
    //   65: ireturn
    //   66: aload_0
    //   67: getfield 31	com/viber/voip/videoconvert/VideoConverterExecutor:_native_init_status	I
    //   70: istore 6
    //   72: aload_0
    //   73: getfield 38	com/viber/voip/videoconvert/VideoConverterExecutor:_permissionsSettled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   76: iconst_0
    //   77: iconst_1
    //   78: invokevirtual 276	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   81: ifeq +7 -> 88
    //   84: aload_0
    //   85: invokespecial 278	com/viber/voip/videoconvert/VideoConverterExecutor:fixLibraryPermissions	()V
    //   88: ldc_w 280
    //   91: astore 7
    //   93: ldc_w 280
    //   96: astore 8
    //   98: aload_3
    //   99: ifnull +10 -> 109
    //   102: aload_3
    //   103: aload_1
    //   104: invokeinterface 285 2 0
    //   109: invokestatic 184	com/viber/voip/videoconvert/VideoConverterNative:b	()Z
    //   112: istore 16
    //   114: iload 16
    //   116: ifne +285 -> 401
    //   119: bipush 248
    //   121: istore 64
    //   123: aload_3
    //   124: ifnull +12 -> 136
    //   127: aload_3
    //   128: aload_1
    //   129: iload 6
    //   131: invokeinterface 286 3 0
    //   136: aload_2
    //   137: ifnull -74 -> 63
    //   140: aload 7
    //   142: invokevirtual 289	java/lang/String:isEmpty	()Z
    //   145: ifne +119 -> 264
    //   148: new 43	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   155: getstatic 295	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   158: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc_w 297
    //   164: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: getstatic 300	android/os/Build:DEVICE	Ljava/lang/String;
    //   170: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 297
    //   176: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: getstatic 303	android/os/Build:MODEL	Ljava/lang/String;
    //   182: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc_w 297
    //   188: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: getstatic 308	android/os/Build$VERSION:SDK_INT	I
    //   194: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc_w 297
    //   200: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 8
    //   205: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 313
    //   211: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 7
    //   216: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore 68
    //   224: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   227: new 43	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 315
    //   237: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 68
    //   242: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokevirtual 317	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   251: aload_2
    //   252: ifnull +12 -> 264
    //   255: aload_2
    //   256: aload_1
    //   257: aload 68
    //   259: invokeinterface 320 3 0
    //   264: aload_2
    //   265: ifnull -202 -> 63
    //   268: iload 6
    //   270: ifeq +84 -> 354
    //   273: new 257	com/viber/voip/VideoConverterReply
    //   276: dup
    //   277: aload 4
    //   279: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   282: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   285: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   288: astore 67
    //   290: aload_2
    //   291: aload_1
    //   292: aload 67
    //   294: invokeinterface 272 3 0
    //   299: iload 64
    //   301: ireturn
    //   302: astore 65
    //   304: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   307: aload 65
    //   309: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   312: aload_2
    //   313: ifnull -250 -> 63
    //   316: aload_2
    //   317: aload_1
    //   318: new 257	com/viber/voip/VideoConverterReply
    //   321: dup
    //   322: aload 4
    //   324: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   327: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   330: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   333: invokeinterface 272 3 0
    //   338: iload 64
    //   340: ireturn
    //   341: astore 66
    //   343: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   346: aload 65
    //   348: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   351: iload 64
    //   353: ireturn
    //   354: new 257	com/viber/voip/VideoConverterReply
    //   357: dup
    //   358: aload 4
    //   360: invokevirtual 323	com/viber/voip/VideoConverterRequest:destination	()Landroid/net/Uri;
    //   363: getstatic 325	com/viber/voip/VideoConverterReply$a:a	Lcom/viber/voip/VideoConverterReply$a;
    //   366: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   369: astore 67
    //   371: aload 5
    //   373: bipush 84
    //   375: invokevirtual 255	com/viber/voip/videoconvert/a:a	(I)Z
    //   378: ifeq -88 -> 290
    //   381: new 257	com/viber/voip/VideoConverterReply
    //   384: dup
    //   385: aload 4
    //   387: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   390: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   393: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   396: astore 67
    //   398: goto -108 -> 290
    //   401: aload_0
    //   402: monitorenter
    //   403: aload_2
    //   404: ifnull +10 -> 414
    //   407: aload_2
    //   408: aload_1
    //   409: invokeinterface 327 2 0
    //   414: aload 4
    //   416: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   419: invokevirtual 92	android/net/Uri:getPath	()Ljava/lang/String;
    //   422: astore 22
    //   424: aload 4
    //   426: invokevirtual 323	com/viber/voip/VideoConverterRequest:destination	()Landroid/net/Uri;
    //   429: invokevirtual 92	android/net/Uri:getPath	()Ljava/lang/String;
    //   432: astore 23
    //   434: iconst_1
    //   435: newarray long
    //   437: astore 24
    //   439: aload 4
    //   441: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   444: aload 24
    //   446: invokestatic 332	com/viber/voip/videoconvert/o:b	(Landroid/net/Uri;[J)Lcom/viber/voip/Resolution;
    //   449: astore 25
    //   451: aload 4
    //   453: invokestatic 335	com/viber/voip/videoconvert/o:a	(Lcom/viber/voip/VideoConverterRequest;)Lcom/viber/voip/videoconvert/o$a;
    //   456: astore 26
    //   458: iconst_4
    //   459: anewarray 4	java/lang/Object
    //   462: astore 27
    //   464: aload 27
    //   466: iconst_0
    //   467: aload 25
    //   469: getfield 340	com/viber/voip/Resolution:width	I
    //   472: invokestatic 344	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   475: aastore
    //   476: aload 27
    //   478: iconst_1
    //   479: aload 25
    //   481: getfield 347	com/viber/voip/Resolution:height	I
    //   484: invokestatic 344	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   487: aastore
    //   488: aload 27
    //   490: iconst_2
    //   491: aload 26
    //   493: getfield 351	com/viber/voip/videoconvert/o$a:a	I
    //   496: invokestatic 344	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: aload 27
    //   502: iconst_3
    //   503: aload 26
    //   505: getfield 353	com/viber/voip/videoconvert/o$a:b	I
    //   508: invokestatic 344	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: aastore
    //   512: ldc_w 355
    //   515: aload 27
    //   517: invokestatic 160	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   520: astore 28
    //   522: aload 28
    //   524: astore 8
    //   526: aload 4
    //   528: invokestatic 360	com/viber/voip/videoconvert/h:a	(Lcom/viber/voip/VideoConverterRequest;)Lcom/viber/voip/videoconvert/p;
    //   531: astore 62
    //   533: aload 62
    //   535: astore 30
    //   537: new 362	java/util/ArrayList
    //   540: dup
    //   541: invokespecial 363	java/util/ArrayList:<init>	()V
    //   544: astore 31
    //   546: aload 5
    //   548: bipush 83
    //   550: invokevirtual 255	com/viber/voip/videoconvert/a:a	(I)Z
    //   553: ifeq +488 -> 1041
    //   556: aload 31
    //   558: new 365	com/viber/voip/videoconvert/k
    //   561: dup
    //   562: invokespecial 366	com/viber/voip/videoconvert/k:<init>	()V
    //   565: invokeinterface 372 2 0
    //   570: pop
    //   571: aload 31
    //   573: invokeinterface 376 1 0
    //   578: astore 37
    //   580: aload 37
    //   582: invokeinterface 381 1 0
    //   587: ifeq +1416 -> 2003
    //   590: aload 37
    //   592: invokeinterface 385 1 0
    //   597: checkcast 387	com/viber/voip/videoconvert/c
    //   600: astore 45
    //   602: new 173	com/viber/voip/videoconvert/g
    //   605: dup
    //   606: invokespecial 388	com/viber/voip/videoconvert/g:<init>	()V
    //   609: astore 46
    //   611: new 390	com/viber/voip/videoconvert/m
    //   614: dup
    //   615: invokespecial 391	com/viber/voip/videoconvert/m:<init>	()V
    //   618: astore 47
    //   620: new 393	com/viber/voip/videoconvert/m$b
    //   623: dup
    //   624: invokespecial 394	com/viber/voip/videoconvert/m$b:<init>	()V
    //   627: astore 48
    //   629: aload 48
    //   631: aload 45
    //   633: putfield 397	com/viber/voip/videoconvert/m$b:a	Lcom/viber/voip/videoconvert/c;
    //   636: aload 48
    //   638: aload 22
    //   640: putfield 399	com/viber/voip/videoconvert/m$b:b	Ljava/lang/String;
    //   643: aload 48
    //   645: aload 25
    //   647: getfield 340	com/viber/voip/Resolution:width	I
    //   650: putfield 402	com/viber/voip/videoconvert/m$b:c	I
    //   653: aload 48
    //   655: aload 25
    //   657: getfield 347	com/viber/voip/Resolution:height	I
    //   660: putfield 405	com/viber/voip/videoconvert/m$b:d	I
    //   663: aload 48
    //   665: aload 26
    //   667: getfield 351	com/viber/voip/videoconvert/o$a:a	I
    //   670: putfield 408	com/viber/voip/videoconvert/m$b:e	I
    //   673: aload 48
    //   675: aload 26
    //   677: getfield 353	com/viber/voip/videoconvert/o$a:b	I
    //   680: putfield 411	com/viber/voip/videoconvert/m$b:f	I
    //   683: aload 5
    //   685: bipush 86
    //   687: invokevirtual 255	com/viber/voip/videoconvert/a:a	(I)Z
    //   690: ifne +938 -> 1628
    //   693: aload 47
    //   695: aload 48
    //   697: invokevirtual 414	com/viber/voip/videoconvert/m:a	(Lcom/viber/voip/videoconvert/m$b;)Lcom/viber/voip/videoconvert/m$c;
    //   700: astore 55
    //   702: aload 55
    //   704: getfield 418	com/viber/voip/videoconvert/m$c:a	Z
    //   707: ifne +477 -> 1184
    //   710: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   713: ldc_w 420
    //   716: invokevirtual 317	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   719: new 43	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   726: aload 7
    //   728: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload 45
    //   733: invokeinterface 422 1 0
    //   738: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: ldc_w 313
    //   744: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: aload 55
    //   749: getfield 423	com/viber/voip/videoconvert/m$c:b	Ljava/lang/String;
    //   752: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: ldc_w 425
    //   758: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: astore 56
    //   766: aload 56
    //   768: astore 7
    //   770: goto -190 -> 580
    //   773: astore 63
    //   775: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   778: aload 63
    //   780: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   783: goto -369 -> 414
    //   786: astore 17
    //   788: iconst_0
    //   789: istore 18
    //   791: iconst_0
    //   792: istore 19
    //   794: aload 8
    //   796: astore 20
    //   798: aload 7
    //   800: astore 21
    //   802: aload_0
    //   803: monitorexit
    //   804: aload 17
    //   806: athrow
    //   807: astore 9
    //   809: aload 21
    //   811: astore 7
    //   813: aload 20
    //   815: astore 8
    //   817: iload 19
    //   819: istore 11
    //   821: iload 18
    //   823: istore 10
    //   825: aload_3
    //   826: ifnull +12 -> 838
    //   829: aload_3
    //   830: aload_1
    //   831: iload 6
    //   833: invokeinterface 286 3 0
    //   838: aload_2
    //   839: ifnull +167 -> 1006
    //   842: iload 10
    //   844: ifne +127 -> 971
    //   847: aload 7
    //   849: invokevirtual 289	java/lang/String:isEmpty	()Z
    //   852: ifne +119 -> 971
    //   855: new 43	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   862: getstatic 295	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   865: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: ldc_w 297
    //   871: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: getstatic 300	android/os/Build:DEVICE	Ljava/lang/String;
    //   877: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: ldc_w 297
    //   883: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: getstatic 303	android/os/Build:MODEL	Ljava/lang/String;
    //   889: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: ldc_w 297
    //   895: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: getstatic 308	android/os/Build$VERSION:SDK_INT	I
    //   901: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   904: ldc_w 297
    //   907: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: aload 8
    //   912: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: ldc_w 313
    //   918: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: aload 7
    //   923: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: astore 15
    //   931: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   934: new 43	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   941: ldc_w 315
    //   944: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload 15
    //   949: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokevirtual 317	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   958: aload_2
    //   959: ifnull +12 -> 971
    //   962: aload_2
    //   963: aload_1
    //   964: aload 15
    //   966: invokeinterface 320 3 0
    //   971: aload_2
    //   972: ifnull +34 -> 1006
    //   975: iload 11
    //   977: ifeq +864 -> 1841
    //   980: new 257	com/viber/voip/VideoConverterReply
    //   983: dup
    //   984: aload 4
    //   986: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   989: getstatic 427	com/viber/voip/VideoConverterReply$a:c	Lcom/viber/voip/VideoConverterReply$a;
    //   992: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   995: astore 12
    //   997: aload_2
    //   998: aload_1
    //   999: aload 12
    //   1001: invokeinterface 272 3 0
    //   1006: aload 9
    //   1008: athrow
    //   1009: astore 61
    //   1011: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1014: aload 61
    //   1016: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   1019: aconst_null
    //   1020: astore 30
    //   1022: goto -485 -> 537
    //   1025: astore 29
    //   1027: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1030: aload 29
    //   1032: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   1035: aconst_null
    //   1036: astore 30
    //   1038: goto -501 -> 537
    //   1041: aload 5
    //   1043: bipush 85
    //   1045: invokevirtual 255	com/viber/voip/videoconvert/a:a	(I)Z
    //   1048: ifeq +21 -> 1069
    //   1051: aload 31
    //   1053: new 429	com/viber/voip/videoconvert/j
    //   1056: dup
    //   1057: invokespecial 430	com/viber/voip/videoconvert/j:<init>	()V
    //   1060: invokeinterface 372 2 0
    //   1065: pop
    //   1066: goto -495 -> 571
    //   1069: aload 5
    //   1071: bipush 88
    //   1073: invokevirtual 255	com/viber/voip/videoconvert/a:a	(I)Z
    //   1076: ifeq +21 -> 1097
    //   1079: aload 31
    //   1081: new 432	com/viber/voip/videoconvert/l
    //   1084: dup
    //   1085: invokespecial 433	com/viber/voip/videoconvert/l:<init>	()V
    //   1088: invokeinterface 372 2 0
    //   1093: pop
    //   1094: goto -523 -> 571
    //   1097: aload 31
    //   1099: new 365	com/viber/voip/videoconvert/k
    //   1102: dup
    //   1103: invokespecial 366	com/viber/voip/videoconvert/k:<init>	()V
    //   1106: invokeinterface 372 2 0
    //   1111: pop
    //   1112: aload 31
    //   1114: new 429	com/viber/voip/videoconvert/j
    //   1117: dup
    //   1118: invokespecial 430	com/viber/voip/videoconvert/j:<init>	()V
    //   1121: invokeinterface 372 2 0
    //   1126: pop
    //   1127: new 432	com/viber/voip/videoconvert/l
    //   1130: dup
    //   1131: invokespecial 433	com/viber/voip/videoconvert/l:<init>	()V
    //   1134: astore 34
    //   1136: aload 34
    //   1138: invokevirtual 435	com/viber/voip/videoconvert/l:a	()Z
    //   1141: ifeq +13 -> 1154
    //   1144: aload 31
    //   1146: aload 34
    //   1148: invokeinterface 372 2 0
    //   1153: pop
    //   1154: new 357	com/viber/voip/videoconvert/h
    //   1157: dup
    //   1158: invokespecial 436	com/viber/voip/videoconvert/h:<init>	()V
    //   1161: astore 35
    //   1163: aload 35
    //   1165: invokevirtual 437	com/viber/voip/videoconvert/h:a	()Z
    //   1168: ifeq -597 -> 571
    //   1171: aload 31
    //   1173: aload 35
    //   1175: invokeinterface 372 2 0
    //   1180: pop
    //   1181: goto -610 -> 571
    //   1184: aload 46
    //   1186: aload 55
    //   1188: getfield 439	com/viber/voip/videoconvert/m$c:d	Z
    //   1191: putfield 442	com/viber/voip/videoconvert/g:n	Z
    //   1194: aload 46
    //   1196: aload 55
    //   1198: getfield 445	com/viber/voip/videoconvert/m$c:e	Lcom/viber/voip/videoconvert/m$a;
    //   1201: putfield 448	com/viber/voip/videoconvert/g:o	Lcom/viber/voip/videoconvert/m$a;
    //   1204: aload 5
    //   1206: bipush 87
    //   1208: invokevirtual 255	com/viber/voip/videoconvert/a:a	(I)Z
    //   1211: ifeq +21 -> 1232
    //   1214: aload 46
    //   1216: getfield 442	com/viber/voip/videoconvert/g:n	Z
    //   1219: ifne +462 -> 1681
    //   1222: iconst_1
    //   1223: istore 54
    //   1225: aload 46
    //   1227: iload 54
    //   1229: putfield 442	com/viber/voip/videoconvert/g:n	Z
    //   1232: aload 46
    //   1234: aload 5
    //   1236: putfield 452	com/viber/voip/videoconvert/g:t	Lcom/viber/voip/videoconvert/a;
    //   1239: aload 46
    //   1241: aload 22
    //   1243: putfield 454	com/viber/voip/videoconvert/g:a	Ljava/lang/String;
    //   1246: aload 46
    //   1248: aload 22
    //   1250: putfield 455	com/viber/voip/videoconvert/g:b	Ljava/lang/String;
    //   1253: aload 46
    //   1255: aload 30
    //   1257: invokevirtual 460	com/viber/voip/videoconvert/p:b	()D
    //   1260: putfield 463	com/viber/voip/videoconvert/g:c	D
    //   1263: aload 46
    //   1265: aload 30
    //   1267: invokevirtual 466	com/viber/voip/videoconvert/p:a	()I
    //   1270: putfield 467	com/viber/voip/videoconvert/g:d	I
    //   1273: aload 46
    //   1275: aload 25
    //   1277: getfield 340	com/viber/voip/Resolution:width	I
    //   1280: putfield 468	com/viber/voip/videoconvert/g:e	I
    //   1283: aload 46
    //   1285: aload 25
    //   1287: getfield 347	com/viber/voip/Resolution:height	I
    //   1290: putfield 469	com/viber/voip/videoconvert/g:f	I
    //   1293: aload 46
    //   1295: aload 23
    //   1297: putfield 472	com/viber/voip/videoconvert/g:g	Ljava/lang/String;
    //   1300: aload 46
    //   1302: aload 26
    //   1304: getfield 351	com/viber/voip/videoconvert/o$a:a	I
    //   1307: putfield 475	com/viber/voip/videoconvert/g:h	I
    //   1310: aload 46
    //   1312: aload 26
    //   1314: getfield 353	com/viber/voip/videoconvert/o$a:b	I
    //   1317: putfield 478	com/viber/voip/videoconvert/g:i	I
    //   1320: aload 46
    //   1322: aload 26
    //   1324: getfield 481	com/viber/voip/videoconvert/o$a:c	J
    //   1327: l2i
    //   1328: putfield 484	com/viber/voip/videoconvert/g:j	I
    //   1331: aload 46
    //   1333: iconst_0
    //   1334: putfield 487	com/viber/voip/videoconvert/g:k	I
    //   1337: aload 46
    //   1339: aload_0
    //   1340: putfield 491	com/viber/voip/videoconvert/g:l	Lcom/viber/voip/videoconvert/VideoConverterNative$IVideoConverterProgressObserver;
    //   1343: aload 46
    //   1345: aconst_null
    //   1346: putfield 495	com/viber/voip/videoconvert/g:m	Ljava/lang/Integer;
    //   1349: aload 46
    //   1351: aload_2
    //   1352: putfield 223	com/viber/voip/videoconvert/g:p	Lcom/viber/voip/ah;
    //   1355: aload 46
    //   1357: aload 24
    //   1359: iconst_0
    //   1360: laload
    //   1361: putfield 498	com/viber/voip/videoconvert/g:q	J
    //   1364: aload 46
    //   1366: aload_1
    //   1367: putfield 227	com/viber/voip/videoconvert/g:r	Lcom/viber/voip/VideoConverterPreparedRequest;
    //   1370: aload 46
    //   1372: iconst_0
    //   1373: putfield 177	com/viber/voip/videoconvert/g:s	Z
    //   1376: getstatic 28	com/viber/voip/videoconvert/VideoConverterExecutor:_cbs	Ljava/util/Map;
    //   1379: aload 4
    //   1381: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   1384: invokevirtual 92	android/net/Uri:getPath	()Ljava/lang/String;
    //   1387: aload 46
    //   1389: invokeinterface 502 3 0
    //   1394: pop
    //   1395: aload 45
    //   1397: aload 46
    //   1399: invokeinterface 505 2 0
    //   1404: istore 52
    //   1406: iload 52
    //   1408: ifeq +279 -> 1687
    //   1411: iconst_1
    //   1412: istore 38
    //   1414: iconst_0
    //   1415: istore 19
    //   1417: getstatic 28	com/viber/voip/videoconvert/VideoConverterExecutor:_cbs	Ljava/util/Map;
    //   1420: aload 4
    //   1422: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   1425: invokevirtual 92	android/net/Uri:getPath	()Ljava/lang/String;
    //   1428: invokeinterface 508 2 0
    //   1433: pop
    //   1434: aload_0
    //   1435: monitorexit
    //   1436: iload 38
    //   1438: ifne +273 -> 1711
    //   1441: bipush 252
    //   1443: istore 40
    //   1445: aload_3
    //   1446: ifnull +12 -> 1458
    //   1449: aload_3
    //   1450: aload_1
    //   1451: iload 40
    //   1453: invokeinterface 286 3 0
    //   1458: aload_2
    //   1459: ifnull +167 -> 1626
    //   1462: iload 38
    //   1464: ifne +127 -> 1591
    //   1467: aload 7
    //   1469: invokevirtual 289	java/lang/String:isEmpty	()Z
    //   1472: ifne +119 -> 1591
    //   1475: new 43	java/lang/StringBuilder
    //   1478: dup
    //   1479: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   1482: getstatic 295	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1485: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: ldc_w 297
    //   1491: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: getstatic 300	android/os/Build:DEVICE	Ljava/lang/String;
    //   1497: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: ldc_w 297
    //   1503: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: getstatic 303	android/os/Build:MODEL	Ljava/lang/String;
    //   1509: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: ldc_w 297
    //   1515: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: getstatic 308	android/os/Build$VERSION:SDK_INT	I
    //   1521: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1524: ldc_w 297
    //   1527: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: aload 8
    //   1532: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: ldc_w 313
    //   1538: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: aload 7
    //   1543: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1549: astore 44
    //   1551: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1554: new 43	java/lang/StringBuilder
    //   1557: dup
    //   1558: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   1561: ldc_w 315
    //   1564: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: aload 44
    //   1569: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1575: invokevirtual 317	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   1578: aload_2
    //   1579: ifnull +12 -> 1591
    //   1582: aload_2
    //   1583: aload_1
    //   1584: aload 44
    //   1586: invokeinterface 320 3 0
    //   1591: aload_2
    //   1592: ifnull +34 -> 1626
    //   1595: iload 19
    //   1597: ifeq +120 -> 1717
    //   1600: new 257	com/viber/voip/VideoConverterReply
    //   1603: dup
    //   1604: aload 4
    //   1606: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   1609: getstatic 427	com/viber/voip/VideoConverterReply$a:c	Lcom/viber/voip/VideoConverterReply$a;
    //   1612: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   1615: astore 41
    //   1617: aload_2
    //   1618: aload_1
    //   1619: aload 41
    //   1621: invokeinterface 272 3 0
    //   1626: iconst_0
    //   1627: ireturn
    //   1628: aload 46
    //   1630: iconst_0
    //   1631: putfield 442	com/viber/voip/videoconvert/g:n	Z
    //   1634: aload 46
    //   1636: new 510	com/viber/voip/videoconvert/m$a
    //   1639: dup
    //   1640: invokespecial 511	com/viber/voip/videoconvert/m$a:<init>	()V
    //   1643: putfield 448	com/viber/voip/videoconvert/g:o	Lcom/viber/voip/videoconvert/m$a;
    //   1646: goto -442 -> 1204
    //   1649: astore 49
    //   1651: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1654: aload 49
    //   1656: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   1659: new 41	java/io/File
    //   1662: dup
    //   1663: aload 4
    //   1665: invokevirtual 323	com/viber/voip/VideoConverterRequest:destination	()Landroid/net/Uri;
    //   1668: invokevirtual 92	android/net/Uri:getPath	()Ljava/lang/String;
    //   1671: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   1674: invokevirtual 514	java/io/File:delete	()Z
    //   1677: pop
    //   1678: goto -1098 -> 580
    //   1681: iconst_0
    //   1682: istore 54
    //   1684: goto -459 -> 1225
    //   1687: aload 46
    //   1689: getfield 177	com/viber/voip/videoconvert/g:s	Z
    //   1692: istore 53
    //   1694: iload 53
    //   1696: ifeq +12 -> 1708
    //   1699: iconst_1
    //   1700: istore 19
    //   1702: iconst_0
    //   1703: istore 38
    //   1705: goto -288 -> 1417
    //   1708: goto -30 -> 1678
    //   1711: iconst_0
    //   1712: istore 40
    //   1714: goto -269 -> 1445
    //   1717: iload 40
    //   1719: ifeq +75 -> 1794
    //   1722: new 257	com/viber/voip/VideoConverterReply
    //   1725: dup
    //   1726: aload 4
    //   1728: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   1731: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   1734: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   1737: astore 41
    //   1739: goto -122 -> 1617
    //   1742: astore 42
    //   1744: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1747: aload 42
    //   1749: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   1752: aload_2
    //   1753: ifnull -127 -> 1626
    //   1756: aload_2
    //   1757: aload_1
    //   1758: new 257	com/viber/voip/VideoConverterReply
    //   1761: dup
    //   1762: aload 4
    //   1764: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   1767: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   1770: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   1773: invokeinterface 272 3 0
    //   1778: goto -152 -> 1626
    //   1781: astore 43
    //   1783: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1786: aload 42
    //   1788: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   1791: goto -165 -> 1626
    //   1794: new 257	com/viber/voip/VideoConverterReply
    //   1797: dup
    //   1798: aload 4
    //   1800: invokevirtual 323	com/viber/voip/VideoConverterRequest:destination	()Landroid/net/Uri;
    //   1803: getstatic 325	com/viber/voip/VideoConverterReply$a:a	Lcom/viber/voip/VideoConverterReply$a;
    //   1806: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   1809: astore 41
    //   1811: aload 5
    //   1813: bipush 84
    //   1815: invokevirtual 255	com/viber/voip/videoconvert/a:a	(I)Z
    //   1818: ifeq -201 -> 1617
    //   1821: new 257	com/viber/voip/VideoConverterReply
    //   1824: dup
    //   1825: aload 4
    //   1827: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   1830: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   1833: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   1836: astore 41
    //   1838: goto -221 -> 1617
    //   1841: iload 6
    //   1843: ifeq +75 -> 1918
    //   1846: new 257	com/viber/voip/VideoConverterReply
    //   1849: dup
    //   1850: aload 4
    //   1852: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   1855: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   1858: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   1861: astore 12
    //   1863: goto -866 -> 997
    //   1866: astore 13
    //   1868: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1871: aload 13
    //   1873: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   1876: aload_2
    //   1877: ifnull -871 -> 1006
    //   1880: aload_2
    //   1881: aload_1
    //   1882: new 257	com/viber/voip/VideoConverterReply
    //   1885: dup
    //   1886: aload 4
    //   1888: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   1891: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   1894: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   1897: invokeinterface 272 3 0
    //   1902: goto -896 -> 1006
    //   1905: astore 14
    //   1907: invokestatic 137	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1910: aload 13
    //   1912: invokevirtual 140	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   1915: goto -909 -> 1006
    //   1918: new 257	com/viber/voip/VideoConverterReply
    //   1921: dup
    //   1922: aload 4
    //   1924: invokevirtual 323	com/viber/voip/VideoConverterRequest:destination	()Landroid/net/Uri;
    //   1927: getstatic 325	com/viber/voip/VideoConverterReply$a:a	Lcom/viber/voip/VideoConverterReply$a;
    //   1930: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   1933: astore 12
    //   1935: aload 5
    //   1937: bipush 84
    //   1939: invokevirtual 255	com/viber/voip/videoconvert/a:a	(I)Z
    //   1942: ifeq -945 -> 997
    //   1945: new 257	com/viber/voip/VideoConverterReply
    //   1948: dup
    //   1949: aload 4
    //   1951: invokevirtual 261	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   1954: getstatic 266	com/viber/voip/VideoConverterReply$a:b	Lcom/viber/voip/VideoConverterReply$a;
    //   1957: invokespecial 269	com/viber/voip/VideoConverterReply:<init>	(Landroid/net/Uri;Lcom/viber/voip/VideoConverterReply$a;)V
    //   1960: astore 12
    //   1962: goto -965 -> 997
    //   1965: astore 70
    //   1967: goto -1907 -> 60
    //   1970: astore 9
    //   1972: iconst_0
    //   1973: istore 10
    //   1975: iconst_0
    //   1976: istore 11
    //   1978: goto -1153 -> 825
    //   1981: astore 17
    //   1983: iload 38
    //   1985: istore 18
    //   1987: aload 8
    //   1989: astore 20
    //   1991: aload 7
    //   1993: astore 21
    //   1995: goto -1193 -> 802
    //   1998: astore 17
    //   2000: goto -1198 -> 802
    //   2003: iconst_0
    //   2004: istore 19
    //   2006: iconst_0
    //   2007: istore 38
    //   2009: goto -592 -> 1417
    //
    // Exception table:
    //   from	to	target	type
    //   140	251	302	java/lang/Exception
    //   255	264	302	java/lang/Exception
    //   273	290	302	java/lang/Exception
    //   290	299	302	java/lang/Exception
    //   354	398	302	java/lang/Exception
    //   316	338	341	android/os/RemoteException
    //   407	414	773	android/os/RemoteException
    //   407	414	786	finally
    //   414	522	786	finally
    //   526	533	786	finally
    //   537	571	786	finally
    //   571	580	786	finally
    //   580	602	786	finally
    //   602	766	786	finally
    //   775	783	786	finally
    //   1011	1019	786	finally
    //   1027	1035	786	finally
    //   1041	1066	786	finally
    //   1069	1094	786	finally
    //   1097	1154	786	finally
    //   1154	1181	786	finally
    //   1184	1204	786	finally
    //   1204	1222	786	finally
    //   1225	1232	786	finally
    //   1232	1406	786	finally
    //   1628	1646	786	finally
    //   1651	1678	786	finally
    //   1687	1694	786	finally
    //   804	807	807	finally
    //   526	533	1009	java/io/IOException
    //   526	533	1025	java/lang/InterruptedException
    //   602	766	1649	java/lang/Throwable
    //   1184	1204	1649	java/lang/Throwable
    //   1204	1222	1649	java/lang/Throwable
    //   1225	1232	1649	java/lang/Throwable
    //   1232	1406	1649	java/lang/Throwable
    //   1628	1646	1649	java/lang/Throwable
    //   1687	1694	1649	java/lang/Throwable
    //   1467	1578	1742	java/lang/Exception
    //   1582	1591	1742	java/lang/Exception
    //   1600	1617	1742	java/lang/Exception
    //   1617	1626	1742	java/lang/Exception
    //   1722	1739	1742	java/lang/Exception
    //   1794	1838	1742	java/lang/Exception
    //   1756	1778	1781	android/os/RemoteException
    //   847	958	1866	java/lang/Exception
    //   962	971	1866	java/lang/Exception
    //   980	997	1866	java/lang/Exception
    //   997	1006	1866	java/lang/Exception
    //   1846	1863	1866	java/lang/Exception
    //   1918	1962	1866	java/lang/Exception
    //   1880	1902	1905	android/os/RemoteException
    //   51	60	1965	android/os/RemoteException
    //   102	109	1970	finally
    //   109	114	1970	finally
    //   401	403	1970	finally
    //   1417	1436	1981	finally
    //   802	804	1998	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.VideoConverterExecutor
 * JD-Core Version:    0.6.2
 */