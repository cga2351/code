package com.viber.voip.videoconvert;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class l
  implements c
{
  private int a(MediaCodecInfo paramMediaCodecInfo, int paramInt)
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = paramMediaCodecInfo.getCapabilitiesForType("video/avc");
    TreeSet localTreeSet = new TreeSet();
    int[] arrayOfInt = localCodecCapabilities.colorFormats;
    int i = arrayOfInt.length;
    for (int j = 0; j < i; j++)
      localTreeSet.add(Integer.valueOf(arrayOfInt[j]));
    Iterator localIterator = localTreeSet.iterator();
    while (localIterator.hasNext())
    {
      int k = ((Integer)localIterator.next()).intValue();
      switch (k)
      {
      default:
        break;
      case 19:
      case 20:
      case 21:
      case 39:
      case 2130706433:
      case 2130706688:
      case 2141391872:
      case 2141391873:
      case 2141391874:
      case 2141391875:
      case 2141391876:
        paramInt = k;
      }
    }
    return paramInt;
  }

  private MediaCodecInfo a(String paramString)
  {
    return a(paramString, false);
  }

  private MediaCodecInfo a(String paramString, boolean paramBoolean)
  {
    int i = MediaCodecList.getCodecCount();
    int j = 0;
    if (j < i)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(j);
      if (!paramBoolean)
        if (localMediaCodecInfo.isEncoder());
      label128: 
      while (true)
      {
        j++;
        break;
        if ((!b(localMediaCodecInfo)) || (localMediaCodecInfo.getName().contains("google")))
        {
          label59: String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          for (int k = 0; ; k++)
          {
            if (k >= arrayOfString.length)
              break label128;
            if (arrayOfString[k].equalsIgnoreCase(paramString))
            {
              return localMediaCodecInfo;
              if (localMediaCodecInfo.isEncoder())
                break;
              if ((!a(localMediaCodecInfo)) || (localMediaCodecInfo.getName().contains("google")))
                break label59;
              break;
            }
          }
        }
      }
    }
    return null;
  }

  private static boolean a(MediaCodecInfo paramMediaCodecInfo)
  {
    return false;
  }

  private static boolean b(MediaCodecInfo paramMediaCodecInfo)
  {
    return false;
  }

  private static boolean c()
  {
    return Build.MANUFACTURER.equals("intel");
  }

  public boolean a()
  {
    return (Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19) && (VideoConverterNative.b()) && (c());
  }

  @TargetApi(18)
  public boolean a(g paramg)
  {
    return a(paramg.a, paramg.c, paramg.d, paramg.e, paramg.f, paramg.g, paramg.h, paramg.i, paramg.j, paramg.k, paramg.l, paramg.m);
  }

  // ERROR //
  @TargetApi(18)
  boolean a(String paramString1, double paramDouble, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, VideoConverterNative.IVideoConverterProgressObserver paramIVideoConverterProgressObserver, Integer paramInteger)
  {
    // Byte code:
    //   0: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   3: ldc 184
    //   5: invokevirtual 187	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   8: aload 13
    //   10: ifnull +11 -> 21
    //   13: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   16: ldc 189
    //   18: invokevirtual 187	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   21: new 191	android/media/MediaExtractor
    //   24: dup
    //   25: invokespecial 192	android/media/MediaExtractor:<init>	()V
    //   28: astore 14
    //   30: aload 14
    //   32: aload_1
    //   33: invokevirtual 195	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   36: new 197	java/util/HashMap
    //   39: dup
    //   40: invokespecial 198	java/util/HashMap:<init>	()V
    //   43: astore 16
    //   45: iconst_0
    //   46: istore 17
    //   48: iconst_0
    //   49: istore 18
    //   51: iload 17
    //   53: aload 14
    //   55: invokevirtual 201	android/media/MediaExtractor:getTrackCount	()I
    //   58: if_icmpge +93 -> 151
    //   61: aload 14
    //   63: iload 17
    //   65: invokevirtual 205	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   68: astore 132
    //   70: aload 132
    //   72: ifnull +54 -> 126
    //   75: aload 132
    //   77: ldc 207
    //   79: invokevirtual 212	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   82: ifeq +44 -> 126
    //   85: ldc 14
    //   87: aload 132
    //   89: ldc 207
    //   91: invokevirtual 216	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +29 -> 126
    //   100: iload 17
    //   102: istore 134
    //   104: iinc 17 1
    //   107: iload 134
    //   109: istore 18
    //   111: goto -60 -> 51
    //   114: astore 15
    //   116: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   119: aload 15
    //   121: invokevirtual 219	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   124: iconst_0
    //   125: ireturn
    //   126: aload 16
    //   128: iload 17
    //   130: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: iload 17
    //   135: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: invokeinterface 225 3 0
    //   143: pop
    //   144: iload 18
    //   146: istore 134
    //   148: goto -44 -> 104
    //   151: aload 14
    //   153: iload 18
    //   155: invokevirtual 205	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   158: astore 19
    //   160: ldc 14
    //   162: iload 8
    //   164: iload 9
    //   166: invokestatic 229	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   169: astore 20
    //   171: aload_0
    //   172: ldc 14
    //   174: invokespecial 231	com/viber/voip/videoconvert/l:a	(Ljava/lang/String;)Landroid/media/MediaCodecInfo;
    //   177: astore 21
    //   179: aload 19
    //   181: ldc 207
    //   183: invokevirtual 212	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   186: ifeq +259 -> 445
    //   189: aload 19
    //   191: ldc 207
    //   193: invokevirtual 216	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 22
    //   198: aload_0
    //   199: aload 22
    //   201: iconst_1
    //   202: invokespecial 63	com/viber/voip/videoconvert/l:a	(Ljava/lang/String;Z)Landroid/media/MediaCodecInfo;
    //   205: astore 23
    //   207: aload 21
    //   209: invokevirtual 83	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   212: invokestatic 237	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   215: astore 25
    //   217: aload 23
    //   219: invokevirtual 83	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   222: invokestatic 237	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   225: astore 26
    //   227: aload 20
    //   229: ldc 239
    //   231: iload 10
    //   233: invokevirtual 243	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   236: aload 20
    //   238: ldc 245
    //   240: dload_2
    //   241: invokestatic 251	java/lang/Math:round	(D)J
    //   244: l2i
    //   245: invokevirtual 243	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   248: aload 20
    //   250: ldc 253
    //   252: iconst_5
    //   253: invokevirtual 243	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   256: aload_0
    //   257: aload 21
    //   259: bipush 19
    //   261: invokespecial 255	com/viber/voip/videoconvert/l:a	(Landroid/media/MediaCodecInfo;I)I
    //   264: istore 27
    //   266: aload 20
    //   268: ldc_w 257
    //   271: iload 27
    //   273: invokevirtual 243	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   276: aload 25
    //   278: aload 20
    //   280: aconst_null
    //   281: aconst_null
    //   282: iconst_1
    //   283: invokevirtual 261	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   286: aload_0
    //   287: aload 23
    //   289: aload 20
    //   291: ldc_w 257
    //   294: invokevirtual 265	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   297: invokespecial 255	com/viber/voip/videoconvert/l:a	(Landroid/media/MediaCodecInfo;I)I
    //   300: istore 28
    //   302: aload 19
    //   304: ldc_w 257
    //   307: iload 28
    //   309: invokevirtual 243	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   312: aload 26
    //   314: aload 19
    //   316: aconst_null
    //   317: aconst_null
    //   318: iconst_0
    //   319: invokevirtual 261	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   322: new 267	android/media/MediaMuxer
    //   325: dup
    //   326: aload 7
    //   328: iconst_0
    //   329: invokespecial 269	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   332: astore 29
    //   334: aload 25
    //   336: invokevirtual 272	android/media/MediaCodec:start	()V
    //   339: aload 26
    //   341: invokevirtual 272	android/media/MediaCodec:start	()V
    //   344: ldc_w 273
    //   347: invokestatic 279	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   350: astore 30
    //   352: new 281	android/media/MediaCodec$BufferInfo
    //   355: dup
    //   356: invokespecial 282	android/media/MediaCodec$BufferInfo:<init>	()V
    //   359: astore 31
    //   361: aload 26
    //   363: invokevirtual 286	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   366: astore 32
    //   368: aload 26
    //   370: invokevirtual 289	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   373: astore 33
    //   375: aload 25
    //   377: invokevirtual 286	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   380: astore 34
    //   382: aload 25
    //   384: invokevirtual 289	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   387: astore 35
    //   389: new 281	android/media/MediaCodec$BufferInfo
    //   392: dup
    //   393: invokespecial 282	android/media/MediaCodec$BufferInfo:<init>	()V
    //   396: astore 36
    //   398: new 281	android/media/MediaCodec$BufferInfo
    //   401: dup
    //   402: invokespecial 282	android/media/MediaCodec$BufferInfo:<init>	()V
    //   405: astore 37
    //   407: iload 28
    //   409: iconst_1
    //   410: invokestatic 293	com/viber/voip/videoconvert/VideoConverterNative:checkColorspaceSupport	(IZ)I
    //   413: ifeq +63 -> 476
    //   416: new 295	com/viber/voip/videoconvert/f
    //   419: dup
    //   420: new 297	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 300
    //   430: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: iload 28
    //   435: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   438: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokespecial 312	com/viber/voip/videoconvert/f:<init>	(Ljava/lang/String;)V
    //   444: athrow
    //   445: ldc 14
    //   447: astore 22
    //   449: goto -251 -> 198
    //   452: astore 24
    //   454: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   457: aload 24
    //   459: invokevirtual 219	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   462: iconst_0
    //   463: ireturn
    //   464: astore 131
    //   466: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   469: aload 131
    //   471: invokevirtual 219	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   474: iconst_0
    //   475: ireturn
    //   476: iload 28
    //   478: iconst_0
    //   479: invokestatic 293	com/viber/voip/videoconvert/VideoConverterNative:checkColorspaceSupport	(IZ)I
    //   482: ifeq +32 -> 514
    //   485: new 295	com/viber/voip/videoconvert/f
    //   488: dup
    //   489: new 297	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 314
    //   499: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: iload 27
    //   504: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokespecial 312	com/viber/voip/videoconvert/f:<init>	(Ljava/lang/String;)V
    //   513: athrow
    //   514: iconst_3
    //   515: iload 8
    //   517: iload 9
    //   519: imul
    //   520: imul
    //   521: iconst_2
    //   522: idiv
    //   523: invokestatic 317	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   526: astore 38
    //   528: lconst_0
    //   529: lconst_0
    //   530: lsub
    //   531: lstore 39
    //   533: aload 14
    //   535: iload 18
    //   537: invokevirtual 321	android/media/MediaExtractor:selectTrack	(I)V
    //   540: aload 14
    //   542: lconst_0
    //   543: iconst_0
    //   544: invokevirtual 325	android/media/MediaExtractor:seekTo	(JI)V
    //   547: iload 28
    //   549: bipush 16
    //   551: iconst_1
    //   552: iload 5
    //   554: iconst_1
    //   555: isub
    //   556: bipush 16
    //   558: idiv
    //   559: iadd
    //   560: imul
    //   561: bipush 16
    //   563: iconst_1
    //   564: iload 6
    //   566: iconst_1
    //   567: isub
    //   568: bipush 16
    //   570: idiv
    //   571: iadd
    //   572: imul
    //   573: iload 27
    //   575: iload 8
    //   577: iload 9
    //   579: iload 4
    //   581: invokestatic 329	com/viber/voip/videoconvert/VideoConverterNative:allocScaler	(IIIIIII)J
    //   584: lstore 48
    //   586: lload 48
    //   588: lstore 45
    //   590: aload 34
    //   592: astore 50
    //   594: iload 27
    //   596: istore 51
    //   598: iconst_0
    //   599: istore 52
    //   601: iload 28
    //   603: istore 53
    //   605: iconst_0
    //   606: istore 54
    //   608: iload 18
    //   610: istore 55
    //   612: iconst_0
    //   613: istore 56
    //   615: iload 55
    //   617: istore 57
    //   619: aload 30
    //   621: iconst_0
    //   622: invokevirtual 333	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   625: pop
    //   626: aload 31
    //   628: iconst_0
    //   629: putfield 336	android/media/MediaCodec$BufferInfo:offset	I
    //   632: aload 31
    //   634: aload 14
    //   636: aload 30
    //   638: aload 31
    //   640: getfield 336	android/media/MediaCodec$BufferInfo:offset	I
    //   643: invokevirtual 340	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   646: putfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   649: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   652: new 297	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 345
    //   662: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload 31
    //   667: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   670: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   673: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokevirtual 187	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   679: aload 31
    //   681: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   684: iflt +464 -> 1148
    //   687: aload 14
    //   689: invokevirtual 349	android/media/MediaExtractor:getSampleTime	()J
    //   692: lstore 59
    //   694: aload 31
    //   696: lload 59
    //   698: putfield 353	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   701: aload 31
    //   703: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   706: iflt +448 -> 1154
    //   709: aload 14
    //   711: invokevirtual 356	android/media/MediaExtractor:getSampleFlags	()I
    //   714: istore 61
    //   716: aload 31
    //   718: iload 61
    //   720: putfield 359	android/media/MediaCodec$BufferInfo:flags	I
    //   723: aload 31
    //   725: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   728: iflt +432 -> 1160
    //   731: aload 31
    //   733: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   736: istore 62
    //   738: aload 30
    //   740: iload 62
    //   742: invokevirtual 362	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   745: pop
    //   746: aload 31
    //   748: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   751: ifgt +415 -> 1166
    //   754: iconst_1
    //   755: istore 64
    //   757: iload 64
    //   759: ifne +983 -> 1742
    //   762: aload 26
    //   764: ldc2_w 363
    //   767: invokevirtual 368	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   770: istore 65
    //   772: iload 65
    //   774: iflt -17 -> 757
    //   777: aload 33
    //   779: iload 65
    //   781: aaload
    //   782: astore 66
    //   784: aload 66
    //   786: iconst_0
    //   787: invokevirtual 333	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   790: pop
    //   791: aload 66
    //   793: aload 66
    //   795: invokevirtual 371	java/nio/ByteBuffer:capacity	()I
    //   798: invokevirtual 362	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   801: pop
    //   802: aload 30
    //   804: invokevirtual 374	java/nio/ByteBuffer:remaining	()I
    //   807: istore 69
    //   809: aload 66
    //   811: invokevirtual 374	java/nio/ByteBuffer:remaining	()I
    //   814: aload 30
    //   816: invokevirtual 374	java/nio/ByteBuffer:remaining	()I
    //   819: if_icmplt +353 -> 1172
    //   822: aload 66
    //   824: aload 30
    //   826: invokevirtual 378	java/nio/ByteBuffer:array	()[B
    //   829: aload 30
    //   831: invokevirtual 380	java/nio/ByteBuffer:position	()I
    //   834: aload 30
    //   836: invokevirtual 374	java/nio/ByteBuffer:remaining	()I
    //   839: invokevirtual 383	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   842: pop
    //   843: aload 30
    //   845: aload 30
    //   847: invokevirtual 380	java/nio/ByteBuffer:position	()I
    //   850: aload 30
    //   852: invokevirtual 374	java/nio/ByteBuffer:remaining	()I
    //   855: iadd
    //   856: invokevirtual 333	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   859: pop
    //   860: aload 66
    //   862: iload 69
    //   864: invokevirtual 362	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   867: pop
    //   868: iconst_1
    //   869: istore 74
    //   871: aload 26
    //   873: iload 65
    //   875: iconst_0
    //   876: aload 66
    //   878: invokevirtual 385	java/nio/ByteBuffer:limit	()I
    //   881: aload 31
    //   883: getfield 353	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   886: aload 31
    //   888: getfield 359	android/media/MediaCodec$BufferInfo:flags	I
    //   891: invokevirtual 389	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   894: aload 32
    //   896: astore 75
    //   898: iload 53
    //   900: istore 76
    //   902: aload 26
    //   904: aload 36
    //   906: ldc2_w 390
    //   909: invokevirtual 395	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   912: istore 77
    //   914: iload 77
    //   916: bipush 253
    //   918: if_icmpne +307 -> 1225
    //   921: aload 26
    //   923: invokevirtual 286	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   926: astore 32
    //   928: iload 76
    //   930: istore 53
    //   932: iload 77
    //   934: bipush 253
    //   936: if_icmpeq -42 -> 894
    //   939: iload 77
    //   941: bipush 254
    //   943: if_icmpeq -49 -> 894
    //   946: iload 77
    //   948: iflt +1382 -> 2330
    //   951: aload 32
    //   953: iload 77
    //   955: aaload
    //   956: astore 78
    //   958: aload 78
    //   960: aload 36
    //   962: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   965: invokevirtual 362	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   968: pop
    //   969: aload 78
    //   971: iconst_0
    //   972: invokevirtual 333	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   975: pop
    //   976: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   979: new 297	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   986: ldc_w 397
    //   989: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: aload 36
    //   994: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   997: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1000: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1003: invokevirtual 187	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   1006: lload 45
    //   1008: iload 53
    //   1010: iload 51
    //   1012: invokestatic 401	com/viber/voip/videoconvert/VideoConverterNative:updateScaler	(JII)I
    //   1015: ifeq +241 -> 1256
    //   1018: new 295	com/viber/voip/videoconvert/f
    //   1021: dup
    //   1022: new 297	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1029: ldc_w 403
    //   1032: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: iload 53
    //   1037: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1040: ldc_w 405
    //   1043: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: iload 51
    //   1048: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1051: ldc_w 407
    //   1054: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokespecial 312	com/viber/voip/videoconvert/f:<init>	(Ljava/lang/String;)V
    //   1063: athrow
    //   1064: astore 41
    //   1066: lload 45
    //   1068: lstore 42
    //   1070: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1073: aload 41
    //   1075: invokevirtual 219	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   1078: aload 41
    //   1080: instanceof 295
    //   1083: ifeq +1078 -> 2161
    //   1086: new 295	com/viber/voip/videoconvert/f
    //   1089: dup
    //   1090: aload 41
    //   1092: invokevirtual 410	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1095: invokespecial 312	com/viber/voip/videoconvert/f:<init>	(Ljava/lang/String;)V
    //   1098: athrow
    //   1099: astore 44
    //   1101: lload 42
    //   1103: lstore 45
    //   1105: aload 26
    //   1107: invokevirtual 413	android/media/MediaCodec:stop	()V
    //   1110: aload 26
    //   1112: invokevirtual 416	android/media/MediaCodec:release	()V
    //   1115: aload 25
    //   1117: invokevirtual 413	android/media/MediaCodec:stop	()V
    //   1120: aload 25
    //   1122: invokevirtual 416	android/media/MediaCodec:release	()V
    //   1125: aload 29
    //   1127: invokevirtual 417	android/media/MediaMuxer:stop	()V
    //   1130: aload 29
    //   1132: invokevirtual 418	android/media/MediaMuxer:release	()V
    //   1135: aload 14
    //   1137: invokevirtual 419	android/media/MediaExtractor:release	()V
    //   1140: lload 45
    //   1142: invokestatic 423	com/viber/voip/videoconvert/VideoConverterNative:releaseScaler	(J)V
    //   1145: aload 44
    //   1147: athrow
    //   1148: lconst_0
    //   1149: lstore 59
    //   1151: goto -457 -> 694
    //   1154: iconst_4
    //   1155: istore 61
    //   1157: goto -441 -> 716
    //   1160: iconst_0
    //   1161: istore 62
    //   1163: goto -425 -> 738
    //   1166: iconst_0
    //   1167: istore 64
    //   1169: goto -412 -> 757
    //   1172: aload 66
    //   1174: invokevirtual 374	java/nio/ByteBuffer:remaining	()I
    //   1177: istore 70
    //   1179: aload 66
    //   1181: aload 30
    //   1183: invokevirtual 378	java/nio/ByteBuffer:array	()[B
    //   1186: aload 30
    //   1188: invokevirtual 380	java/nio/ByteBuffer:position	()I
    //   1191: iload 70
    //   1193: invokevirtual 383	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1196: pop
    //   1197: aload 30
    //   1199: iload 70
    //   1201: aload 30
    //   1203: invokevirtual 380	java/nio/ByteBuffer:position	()I
    //   1206: iadd
    //   1207: invokevirtual 333	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1210: pop
    //   1211: aload 66
    //   1213: iload 70
    //   1215: invokevirtual 362	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1218: pop
    //   1219: iconst_0
    //   1220: istore 74
    //   1222: goto -351 -> 871
    //   1225: iload 77
    //   1227: bipush 254
    //   1229: if_icmpne +1124 -> 2353
    //   1232: aload 26
    //   1234: invokevirtual 427	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   1237: ldc_w 257
    //   1240: invokevirtual 265	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1243: istore 114
    //   1245: aload 75
    //   1247: astore 32
    //   1249: iload 114
    //   1251: istore 53
    //   1253: goto -321 -> 932
    //   1256: lload 45
    //   1258: aload 78
    //   1260: aload 38
    //   1262: iload 11
    //   1264: invokestatic 431	com/viber/voip/videoconvert/VideoConverterNative:resize	(JLjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I)I
    //   1267: istore 81
    //   1269: iload 81
    //   1271: ifle +18 -> 1289
    //   1274: aload 38
    //   1276: iload 81
    //   1278: invokevirtual 362	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1281: pop
    //   1282: aload 38
    //   1284: iconst_0
    //   1285: invokevirtual 333	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1288: pop
    //   1289: aload 25
    //   1291: ldc2_w 363
    //   1294: invokevirtual 368	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   1297: istore 84
    //   1299: iconst_m1
    //   1300: iload 84
    //   1302: if_icmpeq -13 -> 1289
    //   1305: iload 84
    //   1307: iflt -18 -> 1289
    //   1310: aload 35
    //   1312: iload 84
    //   1314: aaload
    //   1315: astore 85
    //   1317: aload 85
    //   1319: iconst_0
    //   1320: invokevirtual 333	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1323: pop
    //   1324: aload 85
    //   1326: aload 85
    //   1328: invokevirtual 371	java/nio/ByteBuffer:capacity	()I
    //   1331: invokevirtual 362	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1334: pop
    //   1335: aload 85
    //   1337: aload 38
    //   1339: invokevirtual 434	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   1342: pop
    //   1343: aload 25
    //   1345: iload 84
    //   1347: iconst_0
    //   1348: aload 38
    //   1350: invokevirtual 385	java/nio/ByteBuffer:limit	()I
    //   1353: aload 36
    //   1355: getfield 353	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   1358: aload 31
    //   1360: getfield 359	android/media/MediaCodec$BufferInfo:flags	I
    //   1363: invokevirtual 389	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   1366: aload 50
    //   1368: astore 89
    //   1370: iload 51
    //   1372: istore 90
    //   1374: iload 57
    //   1376: istore 91
    //   1378: iload 54
    //   1380: istore 92
    //   1382: aload 25
    //   1384: aload 37
    //   1386: ldc2_w 390
    //   1389: invokevirtual 395	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1392: istore 93
    //   1394: iload 93
    //   1396: bipush 253
    //   1398: if_icmpne +174 -> 1572
    //   1401: aload 25
    //   1403: invokevirtual 286	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1406: astore 94
    //   1408: iload 90
    //   1410: istore 95
    //   1412: iload 91
    //   1414: istore 96
    //   1416: aload 94
    //   1418: astore 97
    //   1420: iload 92
    //   1422: istore 98
    //   1424: iload 93
    //   1426: bipush 253
    //   1428: if_icmpeq +830 -> 2258
    //   1431: iload 93
    //   1433: bipush 254
    //   1435: if_icmpeq +823 -> 2258
    //   1438: iload 93
    //   1440: iflt +811 -> 2251
    //   1443: aload 97
    //   1445: iload 93
    //   1447: aaload
    //   1448: astore 100
    //   1450: aload 100
    //   1452: aload 37
    //   1454: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   1457: invokevirtual 362	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1460: pop
    //   1461: aload 100
    //   1463: iconst_0
    //   1464: invokevirtual 333	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1467: pop
    //   1468: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   1471: new 297	java/lang/StringBuilder
    //   1474: dup
    //   1475: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   1478: ldc_w 436
    //   1481: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload 37
    //   1486: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   1489: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1492: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1495: invokevirtual 187	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   1498: aload 29
    //   1500: iload 96
    //   1502: aload 100
    //   1504: aload 37
    //   1506: invokevirtual 440	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   1509: lconst_0
    //   1510: lload 39
    //   1512: lcmp
    //   1513: ifeq +731 -> 2244
    //   1516: ldc2_w 441
    //   1519: aload 37
    //   1521: getfield 353	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   1524: lmul
    //   1525: lload 39
    //   1527: ldiv
    //   1528: l2i
    //   1529: istore 103
    //   1531: iload 103
    //   1533: iload 56
    //   1535: if_icmpeq +709 -> 2244
    //   1538: aload 12
    //   1540: ifnull +13 -> 1553
    //   1543: aload 12
    //   1545: aload_1
    //   1546: iload 103
    //   1548: invokeinterface 447 3 0
    //   1553: aload 25
    //   1555: iload 93
    //   1557: iconst_0
    //   1558: invokevirtual 451	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   1561: aload 26
    //   1563: iload 77
    //   1565: iconst_0
    //   1566: invokevirtual 451	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   1569: goto +795 -> 2364
    //   1572: iload 93
    //   1574: bipush 254
    //   1576: if_icmpne +731 -> 2307
    //   1579: aload 25
    //   1581: invokevirtual 427	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   1584: astore 104
    //   1586: aload 104
    //   1588: ifnull +712 -> 2300
    //   1591: aload 104
    //   1593: ldc_w 257
    //   1596: invokevirtual 212	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1599: ifeq +701 -> 2300
    //   1602: aload 104
    //   1604: ldc_w 257
    //   1607: invokevirtual 265	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1610: istore 112
    //   1612: iload 112
    //   1614: istore 105
    //   1616: iload 105
    //   1618: ifeq +682 -> 2300
    //   1621: iload 105
    //   1623: istore 106
    //   1625: iload 92
    //   1627: ifne +654 -> 2281
    //   1630: aload 29
    //   1632: aload 104
    //   1634: invokevirtual 455	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   1637: istore 107
    //   1639: aload 16
    //   1641: invokeinterface 459 1 0
    //   1646: invokeinterface 462 1 0
    //   1651: astore 108
    //   1653: aload 108
    //   1655: invokeinterface 51 1 0
    //   1660: ifeq +52 -> 1712
    //   1663: aload 108
    //   1665: invokeinterface 55 1 0
    //   1670: checkcast 464	java/util/Map$Entry
    //   1673: astore 109
    //   1675: aload 109
    //   1677: aload 29
    //   1679: aload 14
    //   1681: aload 109
    //   1683: invokeinterface 467 1 0
    //   1688: checkcast 31	java/lang/Integer
    //   1691: invokevirtual 59	java/lang/Integer:intValue	()I
    //   1694: invokevirtual 205	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   1697: invokevirtual 455	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   1700: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1703: invokeinterface 471 2 0
    //   1708: pop
    //   1709: goto -56 -> 1653
    //   1712: aload 29
    //   1714: iload 4
    //   1716: invokevirtual 474	android/media/MediaMuxer:setOrientationHint	(I)V
    //   1719: aload 29
    //   1721: invokevirtual 475	android/media/MediaMuxer:start	()V
    //   1724: aload 89
    //   1726: astore 97
    //   1728: iload 106
    //   1730: istore 95
    //   1732: iload 107
    //   1734: istore 96
    //   1736: iconst_1
    //   1737: istore 98
    //   1739: goto -315 -> 1424
    //   1742: iload 52
    //   1744: iconst_1
    //   1745: iadd
    //   1746: istore 118
    //   1748: aload 14
    //   1750: invokevirtual 478	android/media/MediaExtractor:advance	()Z
    //   1753: ifne +484 -> 2237
    //   1756: aload 14
    //   1758: iload 57
    //   1760: invokevirtual 481	android/media/MediaExtractor:unselectTrack	(I)V
    //   1763: iload 54
    //   1765: ifne +88 -> 1853
    //   1768: aload 16
    //   1770: invokeinterface 459 1 0
    //   1775: invokeinterface 462 1 0
    //   1780: astore 119
    //   1782: aload 119
    //   1784: invokeinterface 51 1 0
    //   1789: ifeq +52 -> 1841
    //   1792: aload 119
    //   1794: invokeinterface 55 1 0
    //   1799: checkcast 464	java/util/Map$Entry
    //   1802: astore 129
    //   1804: aload 129
    //   1806: aload 29
    //   1808: aload 14
    //   1810: aload 129
    //   1812: invokeinterface 467 1 0
    //   1817: checkcast 31	java/lang/Integer
    //   1820: invokevirtual 59	java/lang/Integer:intValue	()I
    //   1823: invokevirtual 205	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   1826: invokevirtual 455	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   1829: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1832: invokeinterface 471 2 0
    //   1837: pop
    //   1838: goto -56 -> 1782
    //   1841: aload 29
    //   1843: iload 4
    //   1845: invokevirtual 474	android/media/MediaMuxer:setOrientationHint	(I)V
    //   1848: aload 29
    //   1850: invokevirtual 475	android/media/MediaMuxer:start	()V
    //   1853: aload 16
    //   1855: invokeinterface 459 1 0
    //   1860: invokeinterface 462 1 0
    //   1865: astore 120
    //   1867: lconst_0
    //   1868: lstore 121
    //   1870: aload 120
    //   1872: invokeinterface 51 1 0
    //   1877: ifeq +223 -> 2100
    //   1880: aload 120
    //   1882: invokeinterface 55 1 0
    //   1887: checkcast 464	java/util/Map$Entry
    //   1890: astore 123
    //   1892: aload 14
    //   1894: lconst_0
    //   1895: iconst_0
    //   1896: invokevirtual 325	android/media/MediaExtractor:seekTo	(JI)V
    //   1899: aload 14
    //   1901: aload 123
    //   1903: invokeinterface 467 1 0
    //   1908: checkcast 31	java/lang/Integer
    //   1911: invokevirtual 59	java/lang/Integer:intValue	()I
    //   1914: invokevirtual 321	android/media/MediaExtractor:selectTrack	(I)V
    //   1917: iconst_0
    //   1918: istore 124
    //   1920: aload 30
    //   1922: iconst_0
    //   1923: invokevirtual 333	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1926: pop
    //   1927: aload 31
    //   1929: iconst_0
    //   1930: putfield 336	android/media/MediaCodec$BufferInfo:offset	I
    //   1933: aload 31
    //   1935: aload 14
    //   1937: aload 30
    //   1939: aload 31
    //   1941: getfield 336	android/media/MediaCodec$BufferInfo:offset	I
    //   1944: invokevirtual 340	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   1947: putfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   1950: iconst_m1
    //   1951: aload 31
    //   1953: getfield 343	android/media/MediaCodec$BufferInfo:size	I
    //   1956: if_icmpeq +274 -> 2230
    //   1959: aload 14
    //   1961: invokevirtual 349	android/media/MediaExtractor:getSampleTime	()J
    //   1964: lstore 127
    //   1966: aload 31
    //   1968: lload 127
    //   1970: putfield 353	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   1973: lconst_0
    //   1974: lload 121
    //   1976: lcmp
    //   1977: ifne +7 -> 1984
    //   1980: lload 127
    //   1982: lstore 121
    //   1984: aload 31
    //   1986: aload 14
    //   1988: invokevirtual 356	android/media/MediaExtractor:getSampleFlags	()I
    //   1991: putfield 359	android/media/MediaCodec$BufferInfo:flags	I
    //   1994: aload 29
    //   1996: aload 123
    //   1998: invokeinterface 484 1 0
    //   2003: checkcast 31	java/lang/Integer
    //   2006: invokevirtual 59	java/lang/Integer:intValue	()I
    //   2009: aload 30
    //   2011: aload 31
    //   2013: invokevirtual 440	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   2016: iload 124
    //   2018: iconst_1
    //   2019: iadd
    //   2020: istore 126
    //   2022: aload 14
    //   2024: invokevirtual 478	android/media/MediaExtractor:advance	()Z
    //   2027: ifne +196 -> 2223
    //   2030: invokestatic 182	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   2033: new 297	java/lang/StringBuilder
    //   2036: dup
    //   2037: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   2040: ldc_w 486
    //   2043: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2046: aload 123
    //   2048: invokeinterface 467 1 0
    //   2053: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2056: ldc_w 491
    //   2059: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2062: iload 126
    //   2064: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2067: ldc_w 493
    //   2070: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2073: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2076: invokevirtual 187	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   2079: aload 14
    //   2081: aload 123
    //   2083: invokeinterface 467 1 0
    //   2088: checkcast 31	java/lang/Integer
    //   2091: invokevirtual 59	java/lang/Integer:intValue	()I
    //   2094: invokevirtual 481	android/media/MediaExtractor:unselectTrack	(I)V
    //   2097: goto -227 -> 1870
    //   2100: aload 12
    //   2102: ifnull +13 -> 2115
    //   2105: aload 12
    //   2107: aload_1
    //   2108: bipush 100
    //   2110: invokeinterface 447 3 0
    //   2115: iconst_1
    //   2116: istore 47
    //   2118: aload 26
    //   2120: invokevirtual 413	android/media/MediaCodec:stop	()V
    //   2123: aload 26
    //   2125: invokevirtual 416	android/media/MediaCodec:release	()V
    //   2128: aload 25
    //   2130: invokevirtual 413	android/media/MediaCodec:stop	()V
    //   2133: aload 25
    //   2135: invokevirtual 416	android/media/MediaCodec:release	()V
    //   2138: aload 29
    //   2140: invokevirtual 417	android/media/MediaMuxer:stop	()V
    //   2143: aload 29
    //   2145: invokevirtual 418	android/media/MediaMuxer:release	()V
    //   2148: aload 14
    //   2150: invokevirtual 419	android/media/MediaExtractor:release	()V
    //   2153: lload 45
    //   2155: invokestatic 423	com/viber/voip/videoconvert/VideoConverterNative:releaseScaler	(J)V
    //   2158: iload 47
    //   2160: ireturn
    //   2161: aload 26
    //   2163: invokevirtual 413	android/media/MediaCodec:stop	()V
    //   2166: aload 26
    //   2168: invokevirtual 416	android/media/MediaCodec:release	()V
    //   2171: aload 25
    //   2173: invokevirtual 413	android/media/MediaCodec:stop	()V
    //   2176: aload 25
    //   2178: invokevirtual 416	android/media/MediaCodec:release	()V
    //   2181: aload 29
    //   2183: invokevirtual 417	android/media/MediaMuxer:stop	()V
    //   2186: aload 29
    //   2188: invokevirtual 418	android/media/MediaMuxer:release	()V
    //   2191: aload 14
    //   2193: invokevirtual 419	android/media/MediaExtractor:release	()V
    //   2196: lload 42
    //   2198: invokestatic 423	com/viber/voip/videoconvert/VideoConverterNative:releaseScaler	(J)V
    //   2201: iconst_0
    //   2202: istore 47
    //   2204: goto -46 -> 2158
    //   2207: astore 44
    //   2209: lconst_0
    //   2210: lstore 45
    //   2212: goto -1107 -> 1105
    //   2215: astore 41
    //   2217: lconst_0
    //   2218: lstore 42
    //   2220: goto -1150 -> 1070
    //   2223: iload 126
    //   2225: istore 124
    //   2227: goto -307 -> 1920
    //   2230: iload 124
    //   2232: istore 126
    //   2234: goto -212 -> 2022
    //   2237: iload 118
    //   2239: istore 52
    //   2241: goto -1622 -> 619
    //   2244: iload 56
    //   2246: istore 103
    //   2248: goto -695 -> 1553
    //   2251: iload 56
    //   2253: istore 103
    //   2255: goto -694 -> 1561
    //   2258: iload 98
    //   2260: istore 92
    //   2262: iload 96
    //   2264: istore 91
    //   2266: iload 95
    //   2268: istore 99
    //   2270: aload 97
    //   2272: astore 89
    //   2274: iload 99
    //   2276: istore 90
    //   2278: goto -896 -> 1382
    //   2281: aload 89
    //   2283: astore 97
    //   2285: iload 106
    //   2287: istore 95
    //   2289: iload 91
    //   2291: istore 96
    //   2293: iload 92
    //   2295: istore 98
    //   2297: goto -873 -> 1424
    //   2300: iload 90
    //   2302: istore 105
    //   2304: goto -683 -> 1621
    //   2307: iload 91
    //   2309: istore 96
    //   2311: iload 92
    //   2313: istore 98
    //   2315: aload 89
    //   2317: astore 113
    //   2319: iload 90
    //   2321: istore 95
    //   2323: aload 113
    //   2325: astore 97
    //   2327: goto -903 -> 1424
    //   2330: iload 56
    //   2332: istore 103
    //   2334: aload 50
    //   2336: astore 97
    //   2338: iload 51
    //   2340: istore 95
    //   2342: iload 57
    //   2344: istore 96
    //   2346: iload 54
    //   2348: istore 98
    //   2350: goto +14 -> 2364
    //   2353: aload 75
    //   2355: astore 32
    //   2357: iload 76
    //   2359: istore 53
    //   2361: goto -1429 -> 932
    //   2364: iload 103
    //   2366: istore 56
    //   2368: aload 97
    //   2370: astore 50
    //   2372: iload 95
    //   2374: istore 51
    //   2376: iload 96
    //   2378: istore 57
    //   2380: iload 98
    //   2382: istore 54
    //   2384: iload 74
    //   2386: istore 64
    //   2388: goto -1631 -> 757
    //   2391: astore 44
    //   2393: goto -1288 -> 1105
    //   2396: astore 111
    //   2398: iload 90
    //   2400: istore 106
    //   2402: goto -777 -> 1625
    //
    // Exception table:
    //   from	to	target	type
    //   30	36	114	java/io/IOException
    //   207	227	452	java/lang/Exception
    //   322	334	464	java/lang/Throwable
    //   619	694	1064	java/lang/Throwable
    //   694	716	1064	java/lang/Throwable
    //   716	738	1064	java/lang/Throwable
    //   738	754	1064	java/lang/Throwable
    //   762	772	1064	java/lang/Throwable
    //   777	868	1064	java/lang/Throwable
    //   871	894	1064	java/lang/Throwable
    //   902	914	1064	java/lang/Throwable
    //   921	928	1064	java/lang/Throwable
    //   951	1064	1064	java/lang/Throwable
    //   1172	1219	1064	java/lang/Throwable
    //   1232	1245	1064	java/lang/Throwable
    //   1256	1269	1064	java/lang/Throwable
    //   1274	1289	1064	java/lang/Throwable
    //   1289	1299	1064	java/lang/Throwable
    //   1310	1366	1064	java/lang/Throwable
    //   1382	1394	1064	java/lang/Throwable
    //   1401	1408	1064	java/lang/Throwable
    //   1443	1509	1064	java/lang/Throwable
    //   1516	1531	1064	java/lang/Throwable
    //   1543	1553	1064	java/lang/Throwable
    //   1553	1561	1064	java/lang/Throwable
    //   1561	1569	1064	java/lang/Throwable
    //   1579	1586	1064	java/lang/Throwable
    //   1591	1612	1064	java/lang/Throwable
    //   1630	1653	1064	java/lang/Throwable
    //   1653	1709	1064	java/lang/Throwable
    //   1712	1724	1064	java/lang/Throwable
    //   1748	1763	1064	java/lang/Throwable
    //   1768	1782	1064	java/lang/Throwable
    //   1782	1838	1064	java/lang/Throwable
    //   1841	1853	1064	java/lang/Throwable
    //   1853	1867	1064	java/lang/Throwable
    //   1870	1917	1064	java/lang/Throwable
    //   1920	1973	1064	java/lang/Throwable
    //   1984	2016	1064	java/lang/Throwable
    //   2022	2097	1064	java/lang/Throwable
    //   2105	2115	1064	java/lang/Throwable
    //   1070	1099	1099	finally
    //   533	586	2207	finally
    //   533	586	2215	java/lang/Throwable
    //   619	694	2391	finally
    //   694	716	2391	finally
    //   716	738	2391	finally
    //   738	754	2391	finally
    //   762	772	2391	finally
    //   777	868	2391	finally
    //   871	894	2391	finally
    //   902	914	2391	finally
    //   921	928	2391	finally
    //   951	1064	2391	finally
    //   1172	1219	2391	finally
    //   1232	1245	2391	finally
    //   1256	1269	2391	finally
    //   1274	1289	2391	finally
    //   1289	1299	2391	finally
    //   1310	1366	2391	finally
    //   1382	1394	2391	finally
    //   1401	1408	2391	finally
    //   1443	1509	2391	finally
    //   1516	1531	2391	finally
    //   1543	1553	2391	finally
    //   1553	1561	2391	finally
    //   1561	1569	2391	finally
    //   1579	1586	2391	finally
    //   1591	1612	2391	finally
    //   1630	1653	2391	finally
    //   1653	1709	2391	finally
    //   1712	1724	2391	finally
    //   1748	1763	2391	finally
    //   1768	1782	2391	finally
    //   1782	1838	2391	finally
    //   1841	1853	2391	finally
    //   1853	1867	2391	finally
    //   1870	1917	2391	finally
    //   1920	1973	2391	finally
    //   1984	2016	2391	finally
    //   2022	2097	2391	finally
    //   2105	2115	2391	finally
    //   1591	1612	2396	java/lang/Exception
  }

  public String b()
  {
    return "omx";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.l
 * JD-Core Version:    0.6.2
 */