package com.viber.voip.stickers.c;

import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;

public abstract class h extends a
  implements Runnable
{
  private static final Logger d = ViberEnv.getLogger();
  private Sticker e;
  private com.viber.voip.util.upload.b f;
  private long g;

  public h(Sticker paramSticker, i parami, com.viber.voip.stickers.e.b paramb)
  {
    super(paramb, parami);
    this.e = paramSticker;
    this.g = SystemClock.elapsedRealtime();
  }

  long a()
  {
    return this.g;
  }

  public void b()
  {
    if (this.f != null)
      this.f.g();
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   4: getfield 58	com/viber/voip/stickers/entity/Sticker:id	I
    //   7: invokestatic 63	com/viber/voip/stickers/c/g:f	(I)I
    //   10: istore_3
    //   11: iload_3
    //   12: invokestatic 69	com/viber/voip/billing/ProductId:fromStickerPackageId	(I)Lcom/viber/voip/billing/ProductId;
    //   15: invokestatic 74	com/viber/voip/market/g:a	(Lcom/viber/voip/billing/ProductId;)Lcom/viber/voip/market/g;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +128 -> 150
    //   25: aload 4
    //   27: getfield 77	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   30: astore 5
    //   32: aload 4
    //   34: ifnull +24 -> 58
    //   37: aload 4
    //   39: getfield 77	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   42: ifnull +16 -> 58
    //   45: aload 4
    //   47: getfield 77	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   50: arraylength
    //   51: istore 18
    //   53: iload 18
    //   55: ifne +13 -> 68
    //   58: iload_3
    //   59: invokestatic 82	com/viber/voip/stickers/u:a	(I)Lcom/viber/voip/market/g;
    //   62: astore 17
    //   64: aload 17
    //   66: astore 4
    //   68: aload 4
    //   70: ifnonnull +89 -> 159
    //   73: iload_3
    //   74: sipush 400
    //   77: if_icmpeq +124 -> 201
    //   80: new 50	com/viber/voip/util/upload/b$a
    //   83: dup
    //   84: new 52	java/lang/Exception
    //   87: dup
    //   88: ldc 84
    //   90: invokespecial 87	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   93: invokespecial 90	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: astore_2
    //   98: aload_0
    //   99: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   102: ifnull +36 -> 138
    //   105: aload_0
    //   106: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   109: invokevirtual 94	com/viber/voip/util/upload/b:i	()I
    //   112: ifeq +26 -> 138
    //   115: invokestatic 100	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   118: invokevirtual 104	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   121: aload_0
    //   122: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   125: invokevirtual 107	com/viber/voip/util/upload/b:b	()Ljava/lang/String;
    //   128: aload_0
    //   129: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   132: invokevirtual 94	com/viber/voip/util/upload/b:i	()I
    //   135: invokevirtual 112	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   138: aload_0
    //   139: aload_0
    //   140: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   143: getfield 58	com/viber/voip/stickers/entity/Sticker:id	I
    //   146: invokevirtual 115	com/viber/voip/stickers/c/h:a	(I)V
    //   149: return
    //   150: iconst_0
    //   151: anewarray 117	java/lang/String
    //   154: astore 5
    //   156: goto -124 -> 32
    //   159: aload 4
    //   161: getfield 77	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   164: ifnull +240 -> 404
    //   167: aload 4
    //   169: getfield 77	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   172: arraylength
    //   173: anewarray 117	java/lang/String
    //   176: astore 5
    //   178: aload 5
    //   180: ifnull +21 -> 201
    //   183: aload 4
    //   185: getfield 77	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   188: iconst_0
    //   189: aload 5
    //   191: iconst_0
    //   192: aload 4
    //   194: getfield 77	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   197: arraylength
    //   198: invokestatic 123	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   201: aload 5
    //   203: astore 7
    //   205: getstatic 127	com/viber/voip/stickers/p:a	I
    //   208: invokestatic 131	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   211: astore 8
    //   213: aload 7
    //   215: ifnull +461 -> 676
    //   218: aload 7
    //   220: arraylength
    //   221: ifle +455 -> 676
    //   224: aload 7
    //   226: ldc 133
    //   228: invokestatic 138	com/viber/voip/util/n:a	([Ljava/lang/Object;Ljava/lang/Object;)Z
    //   231: ifne +454 -> 685
    //   234: aload 7
    //   236: ldc 140
    //   238: invokestatic 138	com/viber/voip/util/n:a	([Ljava/lang/Object;Ljava/lang/Object;)Z
    //   241: ifeq +429 -> 670
    //   244: goto +441 -> 685
    //   247: aload 7
    //   249: ldc 142
    //   251: invokestatic 138	com/viber/voip/util/n:a	([Ljava/lang/Object;Ljava/lang/Object;)Z
    //   254: istore 16
    //   256: iconst_0
    //   257: istore 9
    //   259: iload 16
    //   261: ifeq +6 -> 267
    //   264: iconst_1
    //   265: istore 9
    //   267: aload_0
    //   268: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   271: iload 10
    //   273: invokevirtual 146	com/viber/voip/stickers/entity/Sticker:setIsSvg	(Z)V
    //   276: aload_0
    //   277: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   280: iload 9
    //   282: invokevirtual 149	com/viber/voip/stickers/entity/Sticker:setHasSound	(Z)V
    //   285: aload_0
    //   286: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   289: getfield 58	com/viber/voip/stickers/entity/Sticker:id	I
    //   292: aload 8
    //   294: invokestatic 152	com/viber/voip/stickers/c/g:a	(ILjava/lang/String;)Ljava/lang/String;
    //   297: astore 11
    //   299: invokestatic 100	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   302: invokevirtual 104	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   305: aload 11
    //   307: invokevirtual 156	com/viber/voip/util/ap:c	(Ljava/lang/String;)Z
    //   310: ifne +100 -> 410
    //   313: new 50	com/viber/voip/util/upload/b$a
    //   316: dup
    //   317: new 52	java/lang/Exception
    //   320: dup
    //   321: new 158	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   328: ldc 162
    //   330: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 11
    //   335: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokespecial 87	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   344: ldc 171
    //   346: invokespecial 174	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   349: athrow
    //   350: astore_1
    //   351: aload_0
    //   352: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   355: ifnull +36 -> 391
    //   358: aload_0
    //   359: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   362: invokevirtual 94	com/viber/voip/util/upload/b:i	()I
    //   365: ifeq +26 -> 391
    //   368: invokestatic 100	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   371: invokevirtual 104	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   374: aload_0
    //   375: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   378: invokevirtual 107	com/viber/voip/util/upload/b:b	()Ljava/lang/String;
    //   381: aload_0
    //   382: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   385: invokevirtual 94	com/viber/voip/util/upload/b:i	()I
    //   388: invokevirtual 112	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   391: aload_0
    //   392: aload_0
    //   393: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   396: getfield 58	com/viber/voip/stickers/entity/Sticker:id	I
    //   399: invokevirtual 115	com/viber/voip/stickers/c/h:a	(I)V
    //   402: aload_1
    //   403: athrow
    //   404: aconst_null
    //   405: astore 5
    //   407: goto -229 -> 178
    //   410: aload_0
    //   411: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   414: invokevirtual 177	com/viber/voip/stickers/entity/Sticker:createFolder	()V
    //   417: aload_0
    //   418: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   421: invokevirtual 180	com/viber/voip/stickers/entity/Sticker:getOrigPath	()Ljava/lang/String;
    //   424: astore 12
    //   426: iload 10
    //   428: ifeq +235 -> 663
    //   431: new 158	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   438: aload 12
    //   440: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: ldc 182
    //   445: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore 13
    //   453: aload_0
    //   454: new 45	com/viber/voip/util/upload/b
    //   457: dup
    //   458: aload 11
    //   460: aload 13
    //   462: new 158	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   469: aload 13
    //   471: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: ldc 184
    //   476: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokespecial 187	com/viber/voip/util/upload/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   485: putfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   488: aload_0
    //   489: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   492: invokevirtual 189	com/viber/voip/util/upload/b:f	()V
    //   495: iload 10
    //   497: ifeq +17 -> 514
    //   500: aload 13
    //   502: aload_0
    //   503: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   506: getfield 58	com/viber/voip/stickers/entity/Sticker:id	I
    //   509: aload 12
    //   511: invokestatic 192	com/viber/voip/stickers/c/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: invokestatic 100	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   517: invokevirtual 104	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   520: aload 11
    //   522: invokevirtual 194	com/viber/voip/util/ap:d	(Ljava/lang/String;)V
    //   525: iload 9
    //   527: ifeq +68 -> 595
    //   530: aload_0
    //   531: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   534: getfield 58	com/viber/voip/stickers/entity/Sticker:id	I
    //   537: ldc 196
    //   539: invokestatic 152	com/viber/voip/stickers/c/g:a	(ILjava/lang/String;)Ljava/lang/String;
    //   542: astore 14
    //   544: aload_0
    //   545: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   548: invokevirtual 199	com/viber/voip/stickers/entity/Sticker:getOrigSoundPath	()Ljava/lang/String;
    //   551: astore 15
    //   553: aload_0
    //   554: new 45	com/viber/voip/util/upload/b
    //   557: dup
    //   558: aload 14
    //   560: aload 15
    //   562: new 158	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   569: aload 15
    //   571: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: ldc 184
    //   576: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokespecial 187	com/viber/voip/util/upload/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   585: putfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   588: aload_0
    //   589: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   592: invokevirtual 189	com/viber/voip/util/upload/b:f	()V
    //   595: aload_0
    //   596: getfield 202	com/viber/voip/stickers/c/h:a	Lcom/viber/voip/stickers/i;
    //   599: aload_0
    //   600: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   603: invokevirtual 207	com/viber/voip/stickers/i:b	(Lcom/viber/voip/stickers/entity/Sticker;)V
    //   606: aload_0
    //   607: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   610: ifnull +36 -> 646
    //   613: aload_0
    //   614: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   617: invokevirtual 94	com/viber/voip/util/upload/b:i	()I
    //   620: ifeq +26 -> 646
    //   623: invokestatic 100	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   626: invokevirtual 104	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   629: aload_0
    //   630: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   633: invokevirtual 107	com/viber/voip/util/upload/b:b	()Ljava/lang/String;
    //   636: aload_0
    //   637: getfield 43	com/viber/voip/stickers/c/h:f	Lcom/viber/voip/util/upload/b;
    //   640: invokevirtual 94	com/viber/voip/util/upload/b:i	()I
    //   643: invokevirtual 112	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   646: aload_0
    //   647: aload_0
    //   648: getfield 31	com/viber/voip/stickers/c/h:e	Lcom/viber/voip/stickers/entity/Sticker;
    //   651: getfield 58	com/viber/voip/stickers/entity/Sticker:id	I
    //   654: invokevirtual 115	com/viber/voip/stickers/c/h:a	(I)V
    //   657: return
    //   658: astore 6
    //   660: goto -592 -> 68
    //   663: aload 12
    //   665: astore 13
    //   667: goto -214 -> 453
    //   670: iconst_0
    //   671: istore 10
    //   673: goto -426 -> 247
    //   676: iconst_0
    //   677: istore 9
    //   679: iconst_0
    //   680: istore 10
    //   682: goto -415 -> 267
    //   685: ldc 209
    //   687: astore 8
    //   689: iconst_1
    //   690: istore 10
    //   692: goto -445 -> 247
    //
    // Exception table:
    //   from	to	target	type
    //   0	20	97	com/viber/voip/util/upload/b$a
    //   25	32	97	com/viber/voip/util/upload/b$a
    //   37	53	97	com/viber/voip/util/upload/b$a
    //   58	64	97	com/viber/voip/util/upload/b$a
    //   80	97	97	com/viber/voip/util/upload/b$a
    //   150	156	97	com/viber/voip/util/upload/b$a
    //   159	178	97	com/viber/voip/util/upload/b$a
    //   183	201	97	com/viber/voip/util/upload/b$a
    //   205	213	97	com/viber/voip/util/upload/b$a
    //   218	244	97	com/viber/voip/util/upload/b$a
    //   247	256	97	com/viber/voip/util/upload/b$a
    //   267	350	97	com/viber/voip/util/upload/b$a
    //   410	426	97	com/viber/voip/util/upload/b$a
    //   431	453	97	com/viber/voip/util/upload/b$a
    //   453	495	97	com/viber/voip/util/upload/b$a
    //   500	514	97	com/viber/voip/util/upload/b$a
    //   514	525	97	com/viber/voip/util/upload/b$a
    //   530	595	97	com/viber/voip/util/upload/b$a
    //   595	606	97	com/viber/voip/util/upload/b$a
    //   0	20	350	finally
    //   25	32	350	finally
    //   37	53	350	finally
    //   58	64	350	finally
    //   80	97	350	finally
    //   150	156	350	finally
    //   159	178	350	finally
    //   183	201	350	finally
    //   205	213	350	finally
    //   218	244	350	finally
    //   247	256	350	finally
    //   267	350	350	finally
    //   410	426	350	finally
    //   431	453	350	finally
    //   453	495	350	finally
    //   500	514	350	finally
    //   514	525	350	finally
    //   530	595	350	finally
    //   595	606	350	finally
    //   58	64	658	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.c.h
 * JD-Core Version:    0.6.2
 */