package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

abstract class zzxn
{
  // ERROR //
  static void zzc(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 18 1 0
    //   6: istore_2
    //   7: aload_1
    //   8: invokevirtual 23	java/nio/ByteBuffer:position	()I
    //   11: istore_3
    //   12: iconst_0
    //   13: istore 4
    //   15: iload 4
    //   17: iload_2
    //   18: if_icmpge +39 -> 57
    //   21: aload_0
    //   22: iload 4
    //   24: invokeinterface 27 2 0
    //   29: istore 32
    //   31: iload 32
    //   33: sipush 128
    //   36: if_icmpge +21 -> 57
    //   39: aload_1
    //   40: iload_3
    //   41: iload 4
    //   43: iadd
    //   44: iload 32
    //   46: i2b
    //   47: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   50: pop
    //   51: iinc 4 1
    //   54: goto -39 -> 15
    //   57: iload 4
    //   59: iload_2
    //   60: if_icmpne +429 -> 489
    //   63: aload_1
    //   64: iload_3
    //   65: iload 4
    //   67: iadd
    //   68: invokevirtual 34	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   71: pop
    //   72: return
    //   73: iload 4
    //   75: iload_2
    //   76: if_icmpge +390 -> 466
    //   79: aload_0
    //   80: iload 4
    //   82: invokeinterface 27 2 0
    //   87: istore 9
    //   89: iload 9
    //   91: sipush 128
    //   94: if_icmpge +21 -> 115
    //   97: aload_1
    //   98: iload_3
    //   99: iload 9
    //   101: i2b
    //   102: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   105: pop
    //   106: iinc 4 1
    //   109: iinc 3 1
    //   112: goto -39 -> 73
    //   115: iload 9
    //   117: sipush 2048
    //   120: if_icmpge +377 -> 497
    //   123: iload_3
    //   124: iconst_1
    //   125: iadd
    //   126: istore 11
    //   128: sipush 192
    //   131: iload 9
    //   133: bipush 6
    //   135: iushr
    //   136: ior
    //   137: i2b
    //   138: istore 28
    //   140: aload_1
    //   141: iload_3
    //   142: iload 28
    //   144: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   147: pop
    //   148: aload_1
    //   149: iload 11
    //   151: sipush 128
    //   154: iload 9
    //   156: bipush 63
    //   158: iand
    //   159: ior
    //   160: i2b
    //   161: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   164: pop
    //   165: iload 11
    //   167: istore_3
    //   168: goto -62 -> 106
    //   171: iload_3
    //   172: iconst_1
    //   173: iadd
    //   174: istore 11
    //   176: aload_1
    //   177: iload_3
    //   178: sipush 224
    //   181: iload 9
    //   183: bipush 12
    //   185: iushr
    //   186: ior
    //   187: i2b
    //   188: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   191: pop
    //   192: iload 11
    //   194: iconst_1
    //   195: iadd
    //   196: istore_3
    //   197: sipush 128
    //   200: bipush 63
    //   202: iload 9
    //   204: bipush 6
    //   206: iushr
    //   207: iand
    //   208: ior
    //   209: i2b
    //   210: istore 14
    //   212: aload_1
    //   213: iload 11
    //   215: iload 14
    //   217: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   220: pop
    //   221: aload_1
    //   222: iload_3
    //   223: sipush 128
    //   226: iload 9
    //   228: bipush 63
    //   230: iand
    //   231: ior
    //   232: i2b
    //   233: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   236: pop
    //   237: goto -131 -> 106
    //   240: astore 5
    //   242: aload_1
    //   243: invokevirtual 23	java/nio/ByteBuffer:position	()I
    //   246: iload 4
    //   248: iconst_1
    //   249: iload_3
    //   250: aload_1
    //   251: invokevirtual 23	java/nio/ByteBuffer:position	()I
    //   254: isub
    //   255: iadd
    //   256: invokestatic 40	java/lang/Math:max	(II)I
    //   259: iadd
    //   260: istore 6
    //   262: aload_0
    //   263: iload 4
    //   265: invokeinterface 27 2 0
    //   270: istore 7
    //   272: new 42	java/lang/ArrayIndexOutOfBoundsException
    //   275: dup
    //   276: new 44	java/lang/StringBuilder
    //   279: dup
    //   280: bipush 37
    //   282: invokespecial 47	java/lang/StringBuilder:<init>	(I)V
    //   285: ldc 49
    //   287: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: iload 7
    //   292: invokevirtual 56	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   295: ldc 58
    //   297: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: iload 6
    //   302: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokespecial 68	java/lang/ArrayIndexOutOfBoundsException:<init>	(Ljava/lang/String;)V
    //   311: athrow
    //   312: iload 4
    //   314: iconst_1
    //   315: iadd
    //   316: iload_2
    //   317: if_icmpeq +26 -> 343
    //   320: iinc 4 1
    //   323: aload_0
    //   324: iload 4
    //   326: invokeinterface 27 2 0
    //   331: istore 17
    //   333: iload 9
    //   335: iload 17
    //   337: invokestatic 74	java/lang/Character:isSurrogatePair	(CC)Z
    //   340: ifne +14 -> 354
    //   343: new 76	com/google/android/gms/internal/measurement/zzxp
    //   346: dup
    //   347: iload 4
    //   349: iload_2
    //   350: invokespecial 79	com/google/android/gms/internal/measurement/zzxp:<init>	(II)V
    //   353: athrow
    //   354: iload 9
    //   356: iload 17
    //   358: invokestatic 83	java/lang/Character:toCodePoint	(CC)I
    //   361: istore 18
    //   363: iload_3
    //   364: iconst_1
    //   365: iadd
    //   366: istore 19
    //   368: sipush 240
    //   371: iload 18
    //   373: bipush 18
    //   375: iushr
    //   376: ior
    //   377: i2b
    //   378: istore 20
    //   380: aload_1
    //   381: iload_3
    //   382: iload 20
    //   384: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   387: pop
    //   388: iload 19
    //   390: iconst_1
    //   391: iadd
    //   392: istore 11
    //   394: sipush 128
    //   397: bipush 63
    //   399: iload 18
    //   401: bipush 12
    //   403: iushr
    //   404: iand
    //   405: ior
    //   406: i2b
    //   407: istore 23
    //   409: aload_1
    //   410: iload 19
    //   412: iload 23
    //   414: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   417: pop
    //   418: iload 11
    //   420: iconst_1
    //   421: iadd
    //   422: istore_3
    //   423: sipush 128
    //   426: bipush 63
    //   428: iload 18
    //   430: bipush 6
    //   432: iushr
    //   433: iand
    //   434: ior
    //   435: i2b
    //   436: istore 25
    //   438: aload_1
    //   439: iload 11
    //   441: iload 25
    //   443: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   446: pop
    //   447: aload_1
    //   448: iload_3
    //   449: sipush 128
    //   452: iload 18
    //   454: bipush 63
    //   456: iand
    //   457: ior
    //   458: i2b
    //   459: invokevirtual 31	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   462: pop
    //   463: goto -357 -> 106
    //   466: aload_1
    //   467: iload_3
    //   468: invokevirtual 34	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   471: pop
    //   472: return
    //   473: astore 12
    //   475: iload 11
    //   477: istore_3
    //   478: goto -236 -> 242
    //   481: astore 21
    //   483: iload 19
    //   485: istore_3
    //   486: goto -244 -> 242
    //   489: iload_3
    //   490: iload 4
    //   492: iadd
    //   493: istore_3
    //   494: goto -421 -> 73
    //   497: iload 9
    //   499: ldc 84
    //   501: if_icmplt -330 -> 171
    //   504: ldc 85
    //   506: iload 9
    //   508: if_icmpge -196 -> 312
    //   511: goto -340 -> 171
    //
    // Exception table:
    //   from	to	target	type
    //   21	31	240	java/lang/IndexOutOfBoundsException
    //   39	51	240	java/lang/IndexOutOfBoundsException
    //   63	72	240	java/lang/IndexOutOfBoundsException
    //   79	89	240	java/lang/IndexOutOfBoundsException
    //   97	106	240	java/lang/IndexOutOfBoundsException
    //   212	237	240	java/lang/IndexOutOfBoundsException
    //   323	343	240	java/lang/IndexOutOfBoundsException
    //   343	354	240	java/lang/IndexOutOfBoundsException
    //   354	363	240	java/lang/IndexOutOfBoundsException
    //   438	463	240	java/lang/IndexOutOfBoundsException
    //   466	472	240	java/lang/IndexOutOfBoundsException
    //   140	165	473	java/lang/IndexOutOfBoundsException
    //   176	192	473	java/lang/IndexOutOfBoundsException
    //   409	418	473	java/lang/IndexOutOfBoundsException
    //   380	388	481	java/lang/IndexOutOfBoundsException
  }

  abstract int zzb(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);

  abstract int zzb(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  abstract void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer);

  final boolean zzf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = zzb(0, paramArrayOfByte, paramInt1, paramInt2);
    boolean bool = false;
    if (i == 0)
      bool = true;
    return bool;
  }

  abstract String zzh(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzuv;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxn
 * JD-Core Version:    0.6.2
 */