package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.infer.annotation.ReturnsOwnership;
import javax.annotation.Nullable;

public class GenericDraweeHierarchyInflater
{
  @Nullable
  private static Drawable getDrawable(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    int i = paramTypedArray.getResourceId(paramInt, 0);
    if (i == 0)
      return null;
    return paramContext.getResources().getDrawable(i);
  }

  @ReturnsOwnership
  private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder)
  {
    if (paramGenericDraweeHierarchyBuilder.getRoundingParams() == null)
      paramGenericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
    return paramGenericDraweeHierarchyBuilder.getRoundingParams();
  }

  @Nullable
  private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray paramTypedArray, int paramInt)
  {
    switch (paramTypedArray.getInt(paramInt, -2))
    {
    default:
      throw new RuntimeException("XML attribute not specified!");
    case -1:
      return null;
    case 0:
      return ScalingUtils.ScaleType.FIT_XY;
    case 1:
      return ScalingUtils.ScaleType.FIT_START;
    case 2:
      return ScalingUtils.ScaleType.FIT_CENTER;
    case 3:
      return ScalingUtils.ScaleType.FIT_END;
    case 4:
      return ScalingUtils.ScaleType.CENTER;
    case 5:
      return ScalingUtils.ScaleType.CENTER_INSIDE;
    case 6:
      return ScalingUtils.ScaleType.CENTER_CROP;
    case 7:
      return ScalingUtils.ScaleType.FOCUS_CROP;
    case 8:
    }
    return ScalingUtils.ScaleType.FIT_BOTTOM_START;
  }

  public static GenericDraweeHierarchyBuilder inflateBuilder(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return updateBuilder(new GenericDraweeHierarchyBuilder(paramContext.getResources()), paramContext, paramAttributeSet);
  }

  public static GenericDraweeHierarchy inflateHierarchy(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return inflateBuilder(paramContext, paramAttributeSet).build();
  }

  // ERROR //
  public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder, Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 4
    //   5: iconst_1
    //   6: istore 5
    //   8: iconst_1
    //   9: istore 6
    //   11: iconst_0
    //   12: istore 7
    //   14: iconst_0
    //   15: istore 8
    //   17: aload_2
    //   18: ifnull +956 -> 974
    //   21: aload_1
    //   22: aload_2
    //   23: getstatic 108	com/facebook/drawee/R$styleable:GenericDraweeHierarchy	[I
    //   26: invokevirtual 112	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   29: astore 16
    //   31: aload 16
    //   33: invokevirtual 116	android/content/res/TypedArray:getIndexCount	()I
    //   36: istore 27
    //   38: iload 6
    //   40: istore 28
    //   42: iconst_1
    //   43: istore 29
    //   45: iload 5
    //   47: istore 30
    //   49: iconst_1
    //   50: istore 31
    //   52: iload 4
    //   54: istore 32
    //   56: iconst_1
    //   57: istore 33
    //   59: iload_3
    //   60: istore 34
    //   62: iconst_1
    //   63: istore 35
    //   65: iconst_0
    //   66: istore 36
    //   68: iload 36
    //   70: iload 27
    //   72: if_icmpge +808 -> 880
    //   75: aload 16
    //   77: iload 36
    //   79: invokevirtual 120	android/content/res/TypedArray:getIndex	(I)I
    //   82: istore 46
    //   84: iload 46
    //   86: getstatic 124	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_actualImageScaleType	I
    //   89: if_icmpne +18 -> 107
    //   92: aload_0
    //   93: aload 16
    //   95: iload 46
    //   97: invokestatic 126	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getScaleTypeFromXml	(Landroid/content/res/TypedArray;I)Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    //   100: invokevirtual 130	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setActualImageScaleType	(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   103: pop
    //   104: goto +1187 -> 1291
    //   107: iload 46
    //   109: getstatic 133	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_placeholderImage	I
    //   112: if_icmpne +127 -> 239
    //   115: aload_0
    //   116: aload_1
    //   117: aload 16
    //   119: iload 46
    //   121: invokestatic 135	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getDrawable	(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;
    //   124: invokevirtual 139	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setPlaceholderImage	(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   127: pop
    //   128: goto +1163 -> 1291
    //   131: astore 45
    //   133: iload 34
    //   135: istore 18
    //   137: iload 32
    //   139: istore 20
    //   141: iload 30
    //   143: istore 22
    //   145: iload 28
    //   147: istore 24
    //   149: iload 35
    //   151: istore 26
    //   153: iload 33
    //   155: istore 19
    //   157: iload 31
    //   159: istore 21
    //   161: iload 29
    //   163: istore 23
    //   165: aload 45
    //   167: astore 25
    //   169: aload 16
    //   171: invokevirtual 142	android/content/res/TypedArray:recycle	()V
    //   174: getstatic 147	android/os/Build$VERSION:SDK_INT	I
    //   177: bipush 17
    //   179: if_icmplt +1009 -> 1188
    //   182: aload_1
    //   183: invokevirtual 23	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   186: invokevirtual 151	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   189: invokevirtual 156	android/content/res/Configuration:getLayoutDirection	()I
    //   192: iconst_1
    //   193: if_icmpne +995 -> 1188
    //   196: iload 18
    //   198: ifeq +8 -> 206
    //   201: iload 19
    //   203: ifeq +3 -> 206
    //   206: iload 20
    //   208: ifeq +8 -> 216
    //   211: iload 26
    //   213: ifeq +3 -> 216
    //   216: iload 24
    //   218: ifeq +8 -> 226
    //   221: iload 21
    //   223: ifeq +3 -> 226
    //   226: iload 22
    //   228: ifeq +8 -> 236
    //   231: iload 23
    //   233: ifeq +3 -> 236
    //   236: aload 25
    //   238: athrow
    //   239: iload 46
    //   241: getstatic 159	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_pressedStateOverlayImage	I
    //   244: if_icmpne +19 -> 263
    //   247: aload_0
    //   248: aload_1
    //   249: aload 16
    //   251: iload 46
    //   253: invokestatic 135	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getDrawable	(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;
    //   256: invokevirtual 162	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setPressedStateOverlay	(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   259: pop
    //   260: goto +1031 -> 1291
    //   263: iload 46
    //   265: getstatic 165	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_progressBarImage	I
    //   268: if_icmpne +19 -> 287
    //   271: aload_0
    //   272: aload_1
    //   273: aload 16
    //   275: iload 46
    //   277: invokestatic 135	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getDrawable	(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;
    //   280: invokevirtual 168	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setProgressBarImage	(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   283: pop
    //   284: goto +1007 -> 1291
    //   287: iload 46
    //   289: getstatic 171	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_fadeDuration	I
    //   292: if_icmpne +19 -> 311
    //   295: aload_0
    //   296: aload 16
    //   298: iload 46
    //   300: iconst_0
    //   301: invokevirtual 48	android/content/res/TypedArray:getInt	(II)I
    //   304: invokevirtual 175	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setFadeDuration	(I)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   307: pop
    //   308: goto +983 -> 1291
    //   311: iload 46
    //   313: getstatic 178	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_viewAspectRatio	I
    //   316: if_icmpne +19 -> 335
    //   319: aload_0
    //   320: aload 16
    //   322: iload 46
    //   324: fconst_0
    //   325: invokevirtual 182	android/content/res/TypedArray:getFloat	(IF)F
    //   328: invokevirtual 186	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setDesiredAspectRatio	(F)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   331: pop
    //   332: goto +959 -> 1291
    //   335: iload 46
    //   337: getstatic 189	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_placeholderImageScaleType	I
    //   340: if_icmpne +18 -> 358
    //   343: aload_0
    //   344: aload 16
    //   346: iload 46
    //   348: invokestatic 126	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getScaleTypeFromXml	(Landroid/content/res/TypedArray;I)Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    //   351: invokevirtual 192	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setPlaceholderImageScaleType	(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   354: pop
    //   355: goto +936 -> 1291
    //   358: iload 46
    //   360: getstatic 195	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_retryImage	I
    //   363: if_icmpne +19 -> 382
    //   366: aload_0
    //   367: aload_1
    //   368: aload 16
    //   370: iload 46
    //   372: invokestatic 135	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getDrawable	(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;
    //   375: invokevirtual 198	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setRetryImage	(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   378: pop
    //   379: goto +912 -> 1291
    //   382: iload 46
    //   384: getstatic 201	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_retryImageScaleType	I
    //   387: if_icmpne +18 -> 405
    //   390: aload_0
    //   391: aload 16
    //   393: iload 46
    //   395: invokestatic 126	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getScaleTypeFromXml	(Landroid/content/res/TypedArray;I)Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    //   398: invokevirtual 204	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setRetryImageScaleType	(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   401: pop
    //   402: goto +889 -> 1291
    //   405: iload 46
    //   407: getstatic 207	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_failureImage	I
    //   410: if_icmpne +19 -> 429
    //   413: aload_0
    //   414: aload_1
    //   415: aload 16
    //   417: iload 46
    //   419: invokestatic 135	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getDrawable	(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;
    //   422: invokevirtual 210	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setFailureImage	(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   425: pop
    //   426: goto +865 -> 1291
    //   429: iload 46
    //   431: getstatic 213	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_failureImageScaleType	I
    //   434: if_icmpne +18 -> 452
    //   437: aload_0
    //   438: aload 16
    //   440: iload 46
    //   442: invokestatic 126	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getScaleTypeFromXml	(Landroid/content/res/TypedArray;I)Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    //   445: invokevirtual 216	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setFailureImageScaleType	(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   448: pop
    //   449: goto +842 -> 1291
    //   452: iload 46
    //   454: getstatic 219	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_progressBarImageScaleType	I
    //   457: if_icmpne +18 -> 475
    //   460: aload_0
    //   461: aload 16
    //   463: iload 46
    //   465: invokestatic 126	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getScaleTypeFromXml	(Landroid/content/res/TypedArray;I)Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    //   468: invokevirtual 222	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setProgressBarImageScaleType	(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   471: pop
    //   472: goto +819 -> 1291
    //   475: iload 46
    //   477: getstatic 225	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_progressBarAutoRotateInterval	I
    //   480: if_icmpne +17 -> 497
    //   483: aload 16
    //   485: iload 46
    //   487: iload 8
    //   489: invokevirtual 228	android/content/res/TypedArray:getInteger	(II)I
    //   492: istore 8
    //   494: goto +797 -> 1291
    //   497: iload 46
    //   499: getstatic 231	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_backgroundImage	I
    //   502: if_icmpne +19 -> 521
    //   505: aload_0
    //   506: aload_1
    //   507: aload 16
    //   509: iload 46
    //   511: invokestatic 135	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getDrawable	(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;
    //   514: invokevirtual 234	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setBackground	(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   517: pop
    //   518: goto +773 -> 1291
    //   521: iload 46
    //   523: getstatic 237	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_overlayImage	I
    //   526: if_icmpne +19 -> 545
    //   529: aload_0
    //   530: aload_1
    //   531: aload 16
    //   533: iload 46
    //   535: invokestatic 135	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getDrawable	(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;
    //   538: invokevirtual 240	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setOverlay	(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   541: pop
    //   542: goto +749 -> 1291
    //   545: iload 46
    //   547: getstatic 243	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundAsCircle	I
    //   550: if_icmpne +22 -> 572
    //   553: aload_0
    //   554: invokestatic 245	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getRoundingParams	(Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;)Lcom/facebook/drawee/generic/RoundingParams;
    //   557: aload 16
    //   559: iload 46
    //   561: iconst_0
    //   562: invokevirtual 249	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   565: invokevirtual 253	com/facebook/drawee/generic/RoundingParams:setRoundAsCircle	(Z)Lcom/facebook/drawee/generic/RoundingParams;
    //   568: pop
    //   569: goto +722 -> 1291
    //   572: iload 46
    //   574: getstatic 256	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundedCornerRadius	I
    //   577: if_icmpne +17 -> 594
    //   580: aload 16
    //   582: iload 46
    //   584: iload 7
    //   586: invokevirtual 259	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   589: istore 7
    //   591: goto +700 -> 1291
    //   594: iload 46
    //   596: getstatic 262	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundTopLeft	I
    //   599: if_icmpne +17 -> 616
    //   602: aload 16
    //   604: iload 46
    //   606: iload 34
    //   608: invokevirtual 249	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   611: istore 34
    //   613: goto +678 -> 1291
    //   616: iload 46
    //   618: getstatic 265	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundTopRight	I
    //   621: if_icmpne +17 -> 638
    //   624: aload 16
    //   626: iload 46
    //   628: iload 32
    //   630: invokevirtual 249	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   633: istore 32
    //   635: goto +656 -> 1291
    //   638: iload 46
    //   640: getstatic 268	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundBottomLeft	I
    //   643: if_icmpne +17 -> 660
    //   646: aload 16
    //   648: iload 46
    //   650: iload 30
    //   652: invokevirtual 249	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   655: istore 30
    //   657: goto +634 -> 1291
    //   660: iload 46
    //   662: getstatic 271	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundBottomRight	I
    //   665: if_icmpne +17 -> 682
    //   668: aload 16
    //   670: iload 46
    //   672: iload 28
    //   674: invokevirtual 249	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   677: istore 28
    //   679: goto +612 -> 1291
    //   682: iload 46
    //   684: getstatic 274	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundTopStart	I
    //   687: if_icmpne +17 -> 704
    //   690: aload 16
    //   692: iload 46
    //   694: iload 35
    //   696: invokevirtual 249	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   699: istore 35
    //   701: goto +590 -> 1291
    //   704: iload 46
    //   706: getstatic 277	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundTopEnd	I
    //   709: if_icmpne +17 -> 726
    //   712: aload 16
    //   714: iload 46
    //   716: iload 33
    //   718: invokevirtual 249	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   721: istore 33
    //   723: goto +568 -> 1291
    //   726: iload 46
    //   728: getstatic 280	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundBottomStart	I
    //   731: if_icmpne +17 -> 748
    //   734: aload 16
    //   736: iload 46
    //   738: iload 31
    //   740: invokevirtual 249	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   743: istore 31
    //   745: goto +546 -> 1291
    //   748: iload 46
    //   750: getstatic 283	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundBottomEnd	I
    //   753: if_icmpne +17 -> 770
    //   756: aload 16
    //   758: iload 46
    //   760: iload 29
    //   762: invokevirtual 249	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   765: istore 29
    //   767: goto +524 -> 1291
    //   770: iload 46
    //   772: getstatic 286	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundWithOverlayColor	I
    //   775: if_icmpne +22 -> 797
    //   778: aload_0
    //   779: invokestatic 245	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getRoundingParams	(Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;)Lcom/facebook/drawee/generic/RoundingParams;
    //   782: aload 16
    //   784: iload 46
    //   786: iconst_0
    //   787: invokevirtual 289	android/content/res/TypedArray:getColor	(II)I
    //   790: invokevirtual 293	com/facebook/drawee/generic/RoundingParams:setOverlayColor	(I)Lcom/facebook/drawee/generic/RoundingParams;
    //   793: pop
    //   794: goto +497 -> 1291
    //   797: iload 46
    //   799: getstatic 296	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundingBorderWidth	I
    //   802: if_icmpne +23 -> 825
    //   805: aload_0
    //   806: invokestatic 245	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getRoundingParams	(Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;)Lcom/facebook/drawee/generic/RoundingParams;
    //   809: aload 16
    //   811: iload 46
    //   813: iconst_0
    //   814: invokevirtual 259	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   817: i2f
    //   818: invokevirtual 300	com/facebook/drawee/generic/RoundingParams:setBorderWidth	(F)Lcom/facebook/drawee/generic/RoundingParams;
    //   821: pop
    //   822: goto +469 -> 1291
    //   825: iload 46
    //   827: getstatic 303	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundingBorderColor	I
    //   830: if_icmpne +22 -> 852
    //   833: aload_0
    //   834: invokestatic 245	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getRoundingParams	(Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;)Lcom/facebook/drawee/generic/RoundingParams;
    //   837: aload 16
    //   839: iload 46
    //   841: iconst_0
    //   842: invokevirtual 289	android/content/res/TypedArray:getColor	(II)I
    //   845: invokevirtual 306	com/facebook/drawee/generic/RoundingParams:setBorderColor	(I)Lcom/facebook/drawee/generic/RoundingParams;
    //   848: pop
    //   849: goto +442 -> 1291
    //   852: iload 46
    //   854: getstatic 309	com/facebook/drawee/R$styleable:GenericDraweeHierarchy_roundingBorderPadding	I
    //   857: if_icmpne +434 -> 1291
    //   860: aload_0
    //   861: invokestatic 245	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getRoundingParams	(Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;)Lcom/facebook/drawee/generic/RoundingParams;
    //   864: aload 16
    //   866: iload 46
    //   868: iconst_0
    //   869: invokevirtual 259	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   872: i2f
    //   873: invokevirtual 312	com/facebook/drawee/generic/RoundingParams:setPadding	(F)Lcom/facebook/drawee/generic/RoundingParams;
    //   876: pop
    //   877: goto +414 -> 1291
    //   880: aload 16
    //   882: invokevirtual 142	android/content/res/TypedArray:recycle	()V
    //   885: getstatic 147	android/os/Build$VERSION:SDK_INT	I
    //   888: bipush 17
    //   890: if_icmplt +204 -> 1094
    //   893: aload_1
    //   894: invokevirtual 23	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   897: invokevirtual 151	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   900: invokevirtual 156	android/content/res/Configuration:getLayoutDirection	()I
    //   903: iconst_1
    //   904: if_icmpne +190 -> 1094
    //   907: iload 34
    //   909: ifeq +161 -> 1070
    //   912: iload 33
    //   914: ifeq +156 -> 1070
    //   917: iconst_1
    //   918: istore 41
    //   920: iload 32
    //   922: ifeq +154 -> 1076
    //   925: iload 35
    //   927: ifeq +149 -> 1076
    //   930: iconst_1
    //   931: istore 4
    //   933: iload 28
    //   935: ifeq +147 -> 1082
    //   938: iload 31
    //   940: ifeq +142 -> 1082
    //   943: iconst_1
    //   944: istore 42
    //   946: iload 30
    //   948: ifeq +140 -> 1088
    //   951: iload 29
    //   953: ifeq +135 -> 1088
    //   956: iconst_1
    //   957: istore 43
    //   959: iload 41
    //   961: istore_3
    //   962: iload 43
    //   964: istore 44
    //   966: iload 42
    //   968: istore 6
    //   970: iload 44
    //   972: istore 5
    //   974: aload_0
    //   975: invokevirtual 316	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:getProgressBarImage	()Landroid/graphics/drawable/Drawable;
    //   978: ifnull +26 -> 1004
    //   981: iload 8
    //   983: ifle +21 -> 1004
    //   986: aload_0
    //   987: new 318	com/facebook/drawee/drawable/AutoRotateDrawable
    //   990: dup
    //   991: aload_0
    //   992: invokevirtual 316	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:getProgressBarImage	()Landroid/graphics/drawable/Drawable;
    //   995: iload 8
    //   997: invokespecial 321	com/facebook/drawee/drawable/AutoRotateDrawable:<init>	(Landroid/graphics/drawable/Drawable;I)V
    //   1000: invokevirtual 168	com/facebook/drawee/generic/GenericDraweeHierarchyBuilder:setProgressBarImage	(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    //   1003: pop
    //   1004: iload 7
    //   1006: ifle +62 -> 1068
    //   1009: aload_0
    //   1010: invokestatic 245	com/facebook/drawee/generic/GenericDraweeHierarchyInflater:getRoundingParams	(Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;)Lcom/facebook/drawee/generic/RoundingParams;
    //   1013: astore 9
    //   1015: iload_3
    //   1016: ifeq +215 -> 1231
    //   1019: iload 7
    //   1021: i2f
    //   1022: fstore 10
    //   1024: iload 4
    //   1026: ifeq +211 -> 1237
    //   1029: iload 7
    //   1031: i2f
    //   1032: fstore 11
    //   1034: iload 6
    //   1036: ifeq +207 -> 1243
    //   1039: iload 7
    //   1041: i2f
    //   1042: fstore 12
    //   1044: iload 5
    //   1046: ifeq +203 -> 1249
    //   1049: iload 7
    //   1051: i2f
    //   1052: fstore 13
    //   1054: aload 9
    //   1056: fload 10
    //   1058: fload 11
    //   1060: fload 12
    //   1062: fload 13
    //   1064: invokevirtual 325	com/facebook/drawee/generic/RoundingParams:setCornersRadii	(FFFF)Lcom/facebook/drawee/generic/RoundingParams;
    //   1067: pop
    //   1068: aload_0
    //   1069: areturn
    //   1070: iconst_0
    //   1071: istore 41
    //   1073: goto -153 -> 920
    //   1076: iconst_0
    //   1077: istore 4
    //   1079: goto -146 -> 933
    //   1082: iconst_0
    //   1083: istore 42
    //   1085: goto -139 -> 946
    //   1088: iconst_0
    //   1089: istore 43
    //   1091: goto -132 -> 959
    //   1094: iload 34
    //   1096: ifeq +68 -> 1164
    //   1099: iload 35
    //   1101: ifeq +63 -> 1164
    //   1104: iconst_1
    //   1105: istore 37
    //   1107: iload 32
    //   1109: ifeq +61 -> 1170
    //   1112: iload 33
    //   1114: ifeq +56 -> 1170
    //   1117: iconst_1
    //   1118: istore 38
    //   1120: iload 28
    //   1122: ifeq +54 -> 1176
    //   1125: iload 29
    //   1127: ifeq +49 -> 1176
    //   1130: iconst_1
    //   1131: istore 39
    //   1133: iload 30
    //   1135: ifeq +47 -> 1182
    //   1138: iload 31
    //   1140: ifeq +42 -> 1182
    //   1143: iconst_1
    //   1144: istore 40
    //   1146: iload 40
    //   1148: istore 5
    //   1150: iload 39
    //   1152: istore 6
    //   1154: iload 38
    //   1156: istore 4
    //   1158: iload 37
    //   1160: istore_3
    //   1161: goto -187 -> 974
    //   1164: iconst_0
    //   1165: istore 37
    //   1167: goto -60 -> 1107
    //   1170: iconst_0
    //   1171: istore 38
    //   1173: goto -53 -> 1120
    //   1176: iconst_0
    //   1177: istore 39
    //   1179: goto -46 -> 1133
    //   1182: iconst_0
    //   1183: istore 40
    //   1185: goto -39 -> 1146
    //   1188: iload 18
    //   1190: ifeq +8 -> 1198
    //   1193: iload 26
    //   1195: ifeq +3 -> 1198
    //   1198: iload 20
    //   1200: ifeq +8 -> 1208
    //   1203: iload 19
    //   1205: ifeq +3 -> 1208
    //   1208: iload 24
    //   1210: ifeq +8 -> 1218
    //   1213: iload 23
    //   1215: ifeq +3 -> 1218
    //   1218: iload 22
    //   1220: ifeq -984 -> 236
    //   1223: iload 21
    //   1225: ifeq -989 -> 236
    //   1228: goto -992 -> 236
    //   1231: fconst_0
    //   1232: fstore 10
    //   1234: goto -210 -> 1024
    //   1237: fconst_0
    //   1238: fstore 11
    //   1240: goto -206 -> 1034
    //   1243: fconst_0
    //   1244: fstore 12
    //   1246: goto -202 -> 1044
    //   1249: fconst_0
    //   1250: fstore 13
    //   1252: goto -198 -> 1054
    //   1255: astore 17
    //   1257: iload_3
    //   1258: istore 18
    //   1260: iconst_1
    //   1261: istore 19
    //   1263: iload 4
    //   1265: istore 20
    //   1267: iconst_1
    //   1268: istore 21
    //   1270: iload 5
    //   1272: istore 22
    //   1274: iconst_1
    //   1275: istore 23
    //   1277: iload 6
    //   1279: istore 24
    //   1281: aload 17
    //   1283: astore 25
    //   1285: iconst_1
    //   1286: istore 26
    //   1288: goto -1119 -> 169
    //   1291: iinc 36 1
    //   1294: goto -1226 -> 68
    //
    // Exception table:
    //   from	to	target	type
    //   75	104	131	finally
    //   107	128	131	finally
    //   239	260	131	finally
    //   263	284	131	finally
    //   287	308	131	finally
    //   311	332	131	finally
    //   335	355	131	finally
    //   358	379	131	finally
    //   382	402	131	finally
    //   405	426	131	finally
    //   429	449	131	finally
    //   452	472	131	finally
    //   475	494	131	finally
    //   497	518	131	finally
    //   521	542	131	finally
    //   545	569	131	finally
    //   572	591	131	finally
    //   594	613	131	finally
    //   616	635	131	finally
    //   638	657	131	finally
    //   660	679	131	finally
    //   682	701	131	finally
    //   704	723	131	finally
    //   726	745	131	finally
    //   748	767	131	finally
    //   770	794	131	finally
    //   797	822	131	finally
    //   825	849	131	finally
    //   852	877	131	finally
    //   31	38	1255	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.generic.GenericDraweeHierarchyInflater
 * JD-Core Version:    0.6.2
 */