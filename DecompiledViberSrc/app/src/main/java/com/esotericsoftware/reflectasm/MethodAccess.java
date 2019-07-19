package com.esotericsoftware.reflectasm;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class MethodAccess
{
  private String[] methodNames;
  private Class[][] parameterTypes;
  private Class[] returnTypes;

  private static void addDeclaredMethodsToList(Class paramClass, ArrayList<Method> paramArrayList)
  {
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int i = 0;
    int j = arrayOfMethod.length;
    if (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      int k = localMethod.getModifiers();
      if (Modifier.isStatic(k));
      while (true)
      {
        i++;
        break;
        if (!Modifier.isPrivate(k))
          paramArrayList.add(localMethod);
      }
    }
  }

  // ERROR //
  public static MethodAccess get(Class paramClass)
  {
    // Byte code:
    //   0: new 39	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 50	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 54	java/lang/Class:isInterface	()Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifne +29 -> 43
    //   17: aload_0
    //   18: astore 40
    //   20: aload 40
    //   22: ldc 4
    //   24: if_acmpeq +24 -> 48
    //   27: aload 40
    //   29: aload_1
    //   30: invokestatic 56	com/esotericsoftware/reflectasm/MethodAccess:addDeclaredMethodsToList	(Ljava/lang/Class;Ljava/util/ArrayList;)V
    //   33: aload 40
    //   35: invokevirtual 60	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   38: astore 40
    //   40: goto -20 -> 20
    //   43: aload_0
    //   44: aload_1
    //   45: invokestatic 63	com/esotericsoftware/reflectasm/MethodAccess:recursiveAddInterfaceMethodsToList	(Ljava/lang/Class;Ljava/util/ArrayList;)V
    //   48: aload_1
    //   49: invokevirtual 66	java/util/ArrayList:size	()I
    //   52: istore_3
    //   53: iload_3
    //   54: anewarray 68	java/lang/String
    //   57: astore 4
    //   59: iload_3
    //   60: anewarray 69	[Ljava/lang/Class;
    //   63: astore 5
    //   65: iload_3
    //   66: anewarray 18	java/lang/Class
    //   69: astore 6
    //   71: iconst_0
    //   72: istore 7
    //   74: iload 7
    //   76: iload_3
    //   77: if_icmpge +50 -> 127
    //   80: aload_1
    //   81: iload 7
    //   83: invokevirtual 72	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   86: checkcast 24	java/lang/reflect/Method
    //   89: astore 39
    //   91: aload 4
    //   93: iload 7
    //   95: aload 39
    //   97: invokevirtual 76	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   100: aastore
    //   101: aload 5
    //   103: iload 7
    //   105: aload 39
    //   107: invokevirtual 80	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   110: aastore
    //   111: aload 6
    //   113: iload 7
    //   115: aload 39
    //   117: invokevirtual 83	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   120: aastore
    //   121: iinc 7 1
    //   124: goto -50 -> 74
    //   127: aload_0
    //   128: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   131: astore 8
    //   133: new 86	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   140: aload 8
    //   142: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 93
    //   147: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore 9
    //   155: aload 9
    //   157: ldc 98
    //   159: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: ifeq +1296 -> 1458
    //   165: new 86	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   172: ldc 104
    //   174: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 9
    //   179: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: astore 10
    //   187: aload_0
    //   188: invokestatic 109	com/esotericsoftware/reflectasm/AccessClassLoader:get	(Ljava/lang/Class;)Lcom/esotericsoftware/reflectasm/AccessClassLoader;
    //   191: astore 11
    //   193: aload 11
    //   195: monitorenter
    //   196: aload 11
    //   198: aload 10
    //   200: invokevirtual 113	com/esotericsoftware/reflectasm/AccessClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   203: astore 38
    //   205: aload 38
    //   207: astore 20
    //   209: aload 11
    //   211: monitorexit
    //   212: aload 20
    //   214: invokevirtual 117	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   217: checkcast 2	com/esotericsoftware/reflectasm/MethodAccess
    //   220: astore 22
    //   222: aload 22
    //   224: aload 4
    //   226: putfield 119	com/esotericsoftware/reflectasm/MethodAccess:methodNames	[Ljava/lang/String;
    //   229: aload 22
    //   231: aload 5
    //   233: putfield 121	com/esotericsoftware/reflectasm/MethodAccess:parameterTypes	[[Ljava/lang/Class;
    //   236: aload 22
    //   238: aload 6
    //   240: putfield 123	com/esotericsoftware/reflectasm/MethodAccess:returnTypes	[Ljava/lang/Class;
    //   243: aload 22
    //   245: areturn
    //   246: astore 13
    //   248: aload 10
    //   250: bipush 46
    //   252: bipush 47
    //   254: invokevirtual 127	java/lang/String:replace	(CC)Ljava/lang/String;
    //   257: astore 14
    //   259: aload 8
    //   261: bipush 46
    //   263: bipush 47
    //   265: invokevirtual 127	java/lang/String:replace	(CC)Ljava/lang/String;
    //   268: astore 15
    //   270: new 129	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter
    //   273: dup
    //   274: iconst_1
    //   275: invokespecial 132	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:<init>	(I)V
    //   278: astore 16
    //   280: aload 16
    //   282: ldc 133
    //   284: bipush 33
    //   286: aload 14
    //   288: aconst_null
    //   289: ldc 134
    //   291: aconst_null
    //   292: invokevirtual 138	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:visit	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   295: aload 16
    //   297: iconst_1
    //   298: ldc 139
    //   300: ldc 140
    //   302: aconst_null
    //   303: aconst_null
    //   304: invokevirtual 144	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:visitMethod	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor;
    //   307: astore 17
    //   309: aload 17
    //   311: invokevirtual 149	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitCode	()V
    //   314: aload 17
    //   316: bipush 25
    //   318: iconst_0
    //   319: invokevirtual 153	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitVarInsn	(II)V
    //   322: aload 17
    //   324: sipush 183
    //   327: ldc 134
    //   329: ldc 139
    //   331: ldc 140
    //   333: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload 17
    //   338: sipush 177
    //   341: invokevirtual 160	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitInsn	(I)V
    //   344: aload 17
    //   346: iconst_0
    //   347: iconst_0
    //   348: invokevirtual 163	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMaxs	(II)V
    //   351: aload 17
    //   353: invokevirtual 166	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitEnd	()V
    //   356: aload 16
    //   358: sipush 129
    //   361: ldc 168
    //   363: ldc 170
    //   365: aconst_null
    //   366: aconst_null
    //   367: invokevirtual 144	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:visitMethod	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor;
    //   370: astore 18
    //   372: aload 18
    //   374: invokevirtual 149	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitCode	()V
    //   377: aload_1
    //   378: invokevirtual 173	java/util/ArrayList:isEmpty	()Z
    //   381: ifne +880 -> 1261
    //   384: aload 18
    //   386: bipush 25
    //   388: iconst_1
    //   389: invokevirtual 153	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitVarInsn	(II)V
    //   392: aload 18
    //   394: sipush 192
    //   397: aload 15
    //   399: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   402: aload 18
    //   404: bipush 58
    //   406: iconst_4
    //   407: invokevirtual 153	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitVarInsn	(II)V
    //   410: aload 18
    //   412: bipush 21
    //   414: iconst_2
    //   415: invokevirtual 153	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitVarInsn	(II)V
    //   418: iload_3
    //   419: anewarray 179	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Label
    //   422: astore 23
    //   424: iconst_0
    //   425: istore 24
    //   427: iload 24
    //   429: iload_3
    //   430: if_icmpge +21 -> 451
    //   433: aload 23
    //   435: iload 24
    //   437: new 179	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Label
    //   440: dup
    //   441: invokespecial 180	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Label:<init>	()V
    //   444: aastore
    //   445: iinc 24 1
    //   448: goto -21 -> 427
    //   451: new 179	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Label
    //   454: dup
    //   455: invokespecial 180	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Label:<init>	()V
    //   458: astore 25
    //   460: aload 18
    //   462: iconst_0
    //   463: iconst_m1
    //   464: aload 23
    //   466: arraylength
    //   467: iadd
    //   468: aload 25
    //   470: aload 23
    //   472: invokevirtual 184	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTableSwitchInsn	(IILcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Label;[Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Label;)V
    //   475: new 86	java/lang/StringBuilder
    //   478: dup
    //   479: sipush 128
    //   482: invokespecial 185	java/lang/StringBuilder:<init>	(I)V
    //   485: astore 26
    //   487: iconst_0
    //   488: istore 27
    //   490: iload 27
    //   492: iload_3
    //   493: if_icmpge +751 -> 1244
    //   496: aload 18
    //   498: aload 23
    //   500: iload 27
    //   502: aaload
    //   503: invokevirtual 189	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitLabel	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Label;)V
    //   506: iload 27
    //   508: ifne +185 -> 693
    //   511: aload 18
    //   513: iconst_1
    //   514: iconst_1
    //   515: iconst_1
    //   516: anewarray 4	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: aload 15
    //   523: aastore
    //   524: iconst_0
    //   525: aconst_null
    //   526: invokevirtual 193	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitFrame	(II[Ljava/lang/Object;I[Ljava/lang/Object;)V
    //   529: aload 18
    //   531: bipush 25
    //   533: iconst_4
    //   534: invokevirtual 153	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitVarInsn	(II)V
    //   537: aload 26
    //   539: iconst_0
    //   540: invokevirtual 196	java/lang/StringBuilder:setLength	(I)V
    //   543: aload 26
    //   545: bipush 40
    //   547: invokevirtual 199	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 4
    //   553: iload 27
    //   555: aaload
    //   556: astore 29
    //   558: aload 5
    //   560: iload 27
    //   562: aaload
    //   563: astore 30
    //   565: aload 6
    //   567: iload 27
    //   569: aaload
    //   570: astore 31
    //   572: iconst_0
    //   573: istore 32
    //   575: iload 32
    //   577: aload 30
    //   579: arraylength
    //   580: if_icmpge +386 -> 966
    //   583: aload 18
    //   585: bipush 25
    //   587: iconst_3
    //   588: invokevirtual 153	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitVarInsn	(II)V
    //   591: aload 18
    //   593: bipush 16
    //   595: iload 32
    //   597: invokevirtual 202	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitIntInsn	(II)V
    //   600: aload 18
    //   602: bipush 50
    //   604: invokevirtual 160	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitInsn	(I)V
    //   607: aload 30
    //   609: iload 32
    //   611: aaload
    //   612: invokestatic 208	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:getType	(Ljava/lang/Class;)Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   615: astore 36
    //   617: aload 36
    //   619: invokevirtual 211	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:getSort	()I
    //   622: tableswitch	default:+54 -> 676, 1:+92->714, 2:+146->768, 3:+119->741, 4:+173->795, 5:+200->822, 6:+227->849, 7:+254->876, 8:+281->903, 9:+312->934, 10:+328->950
    //   677: iload_0
    //   678: aload 36
    //   680: invokevirtual 214	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:getDescriptor	()Ljava/lang/String;
    //   683: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: iinc 32 1
    //   690: goto -115 -> 575
    //   693: aload 18
    //   695: iconst_3
    //   696: iconst_0
    //   697: aconst_null
    //   698: iconst_0
    //   699: aconst_null
    //   700: invokevirtual 193	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitFrame	(II[Ljava/lang/Object;I[Ljava/lang/Object;)V
    //   703: goto -174 -> 529
    //   706: astore 12
    //   708: aload 11
    //   710: monitorexit
    //   711: aload 12
    //   713: athrow
    //   714: aload 18
    //   716: sipush 192
    //   719: ldc 216
    //   721: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   724: aload 18
    //   726: sipush 182
    //   729: ldc 216
    //   731: ldc 218
    //   733: ldc 219
    //   735: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   738: goto -62 -> 676
    //   741: aload 18
    //   743: sipush 192
    //   746: ldc 221
    //   748: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   751: aload 18
    //   753: sipush 182
    //   756: ldc 221
    //   758: ldc 223
    //   760: ldc 225
    //   762: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   765: goto -89 -> 676
    //   768: aload 18
    //   770: sipush 192
    //   773: ldc 227
    //   775: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   778: aload 18
    //   780: sipush 182
    //   783: ldc 227
    //   785: ldc 229
    //   787: ldc 231
    //   789: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   792: goto -116 -> 676
    //   795: aload 18
    //   797: sipush 192
    //   800: ldc 233
    //   802: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   805: aload 18
    //   807: sipush 182
    //   810: ldc 233
    //   812: ldc 235
    //   814: ldc 237
    //   816: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   819: goto -143 -> 676
    //   822: aload 18
    //   824: sipush 192
    //   827: ldc 239
    //   829: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   832: aload 18
    //   834: sipush 182
    //   837: ldc 239
    //   839: ldc 241
    //   841: ldc 242
    //   843: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   846: goto -170 -> 676
    //   849: aload 18
    //   851: sipush 192
    //   854: ldc 244
    //   856: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   859: aload 18
    //   861: sipush 182
    //   864: ldc 244
    //   866: ldc 246
    //   868: ldc 248
    //   870: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   873: goto -197 -> 676
    //   876: aload 18
    //   878: sipush 192
    //   881: ldc 250
    //   883: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   886: aload 18
    //   888: sipush 182
    //   891: ldc 250
    //   893: ldc 252
    //   895: ldc 254
    //   897: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   900: goto -224 -> 676
    //   903: aload 18
    //   905: sipush 192
    //   908: ldc_w 256
    //   911: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   914: aload 18
    //   916: sipush 182
    //   919: ldc_w 256
    //   922: ldc_w 258
    //   925: ldc_w 260
    //   928: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   931: goto -255 -> 676
    //   934: aload 18
    //   936: sipush 192
    //   939: aload 36
    //   941: invokevirtual 214	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:getDescriptor	()Ljava/lang/String;
    //   944: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   947: goto -271 -> 676
    //   950: aload 18
    //   952: sipush 192
    //   955: aload 36
    //   957: invokevirtual 263	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:getInternalName	()Ljava/lang/String;
    //   960: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   963: goto -287 -> 676
    //   966: aload 26
    //   968: bipush 41
    //   970: invokevirtual 199	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload 26
    //   976: aload 31
    //   978: invokestatic 266	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:getDescriptor	(Ljava/lang/Class;)Ljava/lang/String;
    //   981: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: iload_2
    //   986: ifeq +479 -> 1465
    //   989: sipush 185
    //   992: istore 35
    //   994: aload 18
    //   996: iload 35
    //   998: aload 15
    //   1000: aload 29
    //   1002: aload 26
    //   1004: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1007: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1010: aload 31
    //   1012: invokestatic 208	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:getType	(Ljava/lang/Class;)Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   1015: invokevirtual 211	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:getSort	()I
    //   1018: tableswitch	default:+50 -> 1068, 0:+64->1082, 1:+73->1091, 2:+111->1129, 3:+92->1110, 4:+130->1148, 5:+149->1167, 6:+168->1186, 7:+187->1205, 8:+206->1224
    //   1069: ldc 17
    //   1071: nop
    //   1072: areturn
    //   1073: invokevirtual 160	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitInsn	(I)V
    //   1076: iinc 27 1
    //   1079: goto -589 -> 490
    //   1082: aload 18
    //   1084: iconst_1
    //   1085: invokevirtual 160	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitInsn	(I)V
    //   1088: goto -20 -> 1068
    //   1091: aload 18
    //   1093: sipush 184
    //   1096: ldc 216
    //   1098: ldc_w 268
    //   1101: ldc_w 270
    //   1104: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1107: goto -39 -> 1068
    //   1110: aload 18
    //   1112: sipush 184
    //   1115: ldc 221
    //   1117: ldc_w 268
    //   1120: ldc_w 272
    //   1123: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1126: goto -58 -> 1068
    //   1129: aload 18
    //   1131: sipush 184
    //   1134: ldc 227
    //   1136: ldc_w 268
    //   1139: ldc_w 274
    //   1142: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1145: goto -77 -> 1068
    //   1148: aload 18
    //   1150: sipush 184
    //   1153: ldc 233
    //   1155: ldc_w 268
    //   1158: ldc_w 276
    //   1161: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1164: goto -96 -> 1068
    //   1167: aload 18
    //   1169: sipush 184
    //   1172: ldc 239
    //   1174: ldc_w 268
    //   1177: ldc_w 278
    //   1180: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1183: goto -115 -> 1068
    //   1186: aload 18
    //   1188: sipush 184
    //   1191: ldc 244
    //   1193: ldc_w 268
    //   1196: ldc_w 280
    //   1199: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1202: goto -134 -> 1068
    //   1205: aload 18
    //   1207: sipush 184
    //   1210: ldc 250
    //   1212: ldc_w 268
    //   1215: ldc_w 282
    //   1218: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1221: goto -153 -> 1068
    //   1224: aload 18
    //   1226: sipush 184
    //   1229: ldc_w 256
    //   1232: ldc_w 268
    //   1235: ldc_w 284
    //   1238: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1241: goto -173 -> 1068
    //   1244: aload 18
    //   1246: aload 25
    //   1248: invokevirtual 189	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitLabel	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Label;)V
    //   1251: aload 18
    //   1253: iconst_3
    //   1254: iconst_0
    //   1255: aconst_null
    //   1256: iconst_0
    //   1257: aconst_null
    //   1258: invokevirtual 193	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitFrame	(II[Ljava/lang/Object;I[Ljava/lang/Object;)V
    //   1261: aload 18
    //   1263: sipush 187
    //   1266: ldc_w 286
    //   1269: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   1272: aload 18
    //   1274: bipush 89
    //   1276: invokevirtual 160	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitInsn	(I)V
    //   1279: aload 18
    //   1281: sipush 187
    //   1284: ldc_w 287
    //   1287: invokevirtual 177	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitTypeInsn	(ILjava/lang/String;)V
    //   1290: aload 18
    //   1292: bipush 89
    //   1294: invokevirtual 160	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitInsn	(I)V
    //   1297: aload 18
    //   1299: ldc_w 289
    //   1302: invokevirtual 293	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitLdcInsn	(Ljava/lang/Object;)V
    //   1305: aload 18
    //   1307: sipush 183
    //   1310: ldc_w 287
    //   1313: ldc 139
    //   1315: ldc_w 295
    //   1318: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1321: aload 18
    //   1323: bipush 21
    //   1325: iconst_2
    //   1326: invokevirtual 153	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitVarInsn	(II)V
    //   1329: aload 18
    //   1331: sipush 182
    //   1334: ldc_w 287
    //   1337: ldc_w 296
    //   1340: ldc_w 298
    //   1343: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1346: aload 18
    //   1348: sipush 182
    //   1351: ldc_w 287
    //   1354: ldc_w 299
    //   1357: ldc_w 300
    //   1360: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1363: aload 18
    //   1365: sipush 183
    //   1368: ldc_w 286
    //   1371: ldc 139
    //   1373: ldc_w 295
    //   1376: invokevirtual 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMethodInsn	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1379: aload 18
    //   1381: sipush 191
    //   1384: invokevirtual 160	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitInsn	(I)V
    //   1387: aload 18
    //   1389: iconst_0
    //   1390: iconst_0
    //   1391: invokevirtual 163	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitMaxs	(II)V
    //   1394: aload 18
    //   1396: invokevirtual 166	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/MethodVisitor:visitEnd	()V
    //   1399: aload 16
    //   1401: invokevirtual 301	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:visitEnd	()V
    //   1404: aload 11
    //   1406: aload 10
    //   1408: aload 16
    //   1410: invokevirtual 305	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:toByteArray	()[B
    //   1413: invokevirtual 309	com/esotericsoftware/reflectasm/AccessClassLoader:defineClass	(Ljava/lang/String;[B)Ljava/lang/Class;
    //   1416: astore 19
    //   1418: aload 19
    //   1420: astore 20
    //   1422: goto -1213 -> 209
    //   1425: astore 21
    //   1427: new 311	java/lang/RuntimeException
    //   1430: dup
    //   1431: new 86	java/lang/StringBuilder
    //   1434: dup
    //   1435: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1438: ldc_w 313
    //   1441: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: aload 10
    //   1446: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1452: aload 21
    //   1454: invokespecial 316	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1457: athrow
    //   1458: aload 9
    //   1460: astore 10
    //   1462: goto -1275 -> 187
    //   1465: sipush 182
    //   1468: istore 35
    //   1470: goto -476 -> 994
    //
    // Exception table:
    //   from	to	target	type
    //   196	205	246	java/lang/ClassNotFoundException
    //   196	205	706	finally
    //   209	212	706	finally
    //   248	424	706	finally
    //   433	445	706	finally
    //   451	487	706	finally
    //   496	506	706	finally
    //   511	529	706	finally
    //   529	572	706	finally
    //   575	676	706	finally
    //   676	687	706	finally
    //   693	703	706	finally
    //   708	711	706	finally
    //   714	738	706	finally
    //   741	765	706	finally
    //   768	792	706	finally
    //   795	819	706	finally
    //   822	846	706	finally
    //   849	873	706	finally
    //   876	900	706	finally
    //   903	931	706	finally
    //   934	947	706	finally
    //   950	963	706	finally
    //   966	985	706	finally
    //   994	1068	706	finally
    //   1068	1076	706	finally
    //   1082	1088	706	finally
    //   1091	1107	706	finally
    //   1110	1126	706	finally
    //   1129	1145	706	finally
    //   1148	1164	706	finally
    //   1167	1183	706	finally
    //   1186	1202	706	finally
    //   1205	1221	706	finally
    //   1224	1241	706	finally
    //   1244	1261	706	finally
    //   1261	1418	706	finally
    //   212	243	1425	java/lang/Exception
  }

  private static void recursiveAddInterfaceMethodsToList(Class paramClass, ArrayList<Method> paramArrayList)
  {
    addDeclaredMethodsToList(paramClass, paramArrayList);
    Class[] arrayOfClass = paramClass.getInterfaces();
    int i = arrayOfClass.length;
    for (int j = 0; j < i; j++)
      recursiveAddInterfaceMethodsToList(arrayOfClass[j], paramArrayList);
  }

  public int getIndex(String paramString)
  {
    int i = 0;
    int j = this.methodNames.length;
    while (i < j)
    {
      if (this.methodNames[i].equals(paramString))
        return i;
      i++;
    }
    throw new IllegalArgumentException("Unable to find public method: " + paramString);
  }

  public int getIndex(String paramString, int paramInt)
  {
    int i = 0;
    int j = this.methodNames.length;
    while (i < j)
    {
      if ((this.methodNames[i].equals(paramString)) && (this.parameterTypes[i].length == paramInt))
        return i;
      i++;
    }
    throw new IllegalArgumentException("Unable to find public method: " + paramString + " with " + paramInt + " params.");
  }

  public int getIndex(String paramString, Class[] paramArrayOfClass)
  {
    int i = 0;
    int j = this.methodNames.length;
    while (i < j)
    {
      if ((this.methodNames[i].equals(paramString)) && (Arrays.equals(paramArrayOfClass, this.parameterTypes[i])))
        return i;
      i++;
    }
    throw new IllegalArgumentException("Unable to find public method: " + paramString + " " + Arrays.toString(paramArrayOfClass));
  }

  public String[] getMethodNames()
  {
    return this.methodNames;
  }

  public Class[][] getParameterTypes()
  {
    return this.parameterTypes;
  }

  public Class[] getReturnTypes()
  {
    return this.returnTypes;
  }

  public abstract Object invoke(Object paramObject, int paramInt, Object[] paramArrayOfObject);

  public Object invoke(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    return invoke(paramObject, getIndex(paramString, paramArrayOfClass), paramArrayOfObject);
  }

  public Object invoke(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null);
    for (int i = 0; ; i = paramArrayOfObject.length)
      return invoke(paramObject, getIndex(paramString, i), paramArrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.MethodAccess
 * JD-Core Version:    0.6.2
 */