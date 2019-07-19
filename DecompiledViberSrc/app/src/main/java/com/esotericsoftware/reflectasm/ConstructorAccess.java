package com.esotericsoftware.reflectasm;

import com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.ClassWriter;
import com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.MethodVisitor;

public abstract class ConstructorAccess<T>
{
  boolean isNonStaticMemberClass;

  // ERROR //
  public static <T> ConstructorAccess<T> get(java.lang.Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 23	java/lang/Class:getEnclosingClass	()Ljava/lang/Class;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +124 -> 130
    //   9: aload_0
    //   10: invokevirtual 27	java/lang/Class:isMemberClass	()Z
    //   13: ifeq +117 -> 130
    //   16: aload_0
    //   17: invokevirtual 31	java/lang/Class:getModifiers	()I
    //   20: invokestatic 37	java/lang/reflect/Modifier:isStatic	(I)Z
    //   23: ifne +107 -> 130
    //   26: iconst_1
    //   27: istore_2
    //   28: aload_0
    //   29: invokevirtual 41	java/lang/Class:getName	()Ljava/lang/String;
    //   32: astore_3
    //   33: new 43	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   40: aload_3
    //   41: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 50
    //   46: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: ldc 55
    //   58: invokevirtual 61	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   61: ifeq +406 -> 467
    //   64: new 43	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   71: ldc 63
    //   73: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 4
    //   78: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 5
    //   86: aload_0
    //   87: invokestatic 68	com/esotericsoftware/reflectasm/AccessClassLoader:get	(Ljava/lang/Class;)Lcom/esotericsoftware/reflectasm/AccessClassLoader;
    //   90: astore 6
    //   92: aload 6
    //   94: monitorenter
    //   95: aload 6
    //   97: aload 5
    //   99: invokevirtual 72	com/esotericsoftware/reflectasm/AccessClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   102: astore 22
    //   104: aload 22
    //   106: astore 17
    //   108: aload 6
    //   110: monitorexit
    //   111: aload 17
    //   113: invokevirtual 76	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   116: checkcast 2	com/esotericsoftware/reflectasm/ConstructorAccess
    //   119: astore 19
    //   121: aload 19
    //   123: iload_2
    //   124: putfield 78	com/esotericsoftware/reflectasm/ConstructorAccess:isNonStaticMemberClass	Z
    //   127: aload 19
    //   129: areturn
    //   130: iconst_0
    //   131: istore_2
    //   132: goto -104 -> 28
    //   135: astore 8
    //   137: aload 5
    //   139: bipush 46
    //   141: bipush 47
    //   143: invokevirtual 82	java/lang/String:replace	(CC)Ljava/lang/String;
    //   146: astore 9
    //   148: aload_3
    //   149: bipush 46
    //   151: bipush 47
    //   153: invokevirtual 82	java/lang/String:replace	(CC)Ljava/lang/String;
    //   156: astore 10
    //   158: iload_2
    //   159: ifne +96 -> 255
    //   162: aload_0
    //   163: aconst_null
    //   164: checkcast 84	[Ljava/lang/Class;
    //   167: invokevirtual 88	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   170: invokevirtual 91	java/lang/reflect/Constructor:getModifiers	()I
    //   173: invokestatic 94	java/lang/reflect/Modifier:isPrivate	(I)Z
    //   176: istore 21
    //   178: iload 21
    //   180: ifeq +281 -> 461
    //   183: new 96	java/lang/RuntimeException
    //   186: dup
    //   187: new 43	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   194: ldc 98
    //   196: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: invokevirtual 41	java/lang/Class:getName	()Ljava/lang/String;
    //   203: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokespecial 101	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   212: athrow
    //   213: astore 7
    //   215: aload 6
    //   217: monitorexit
    //   218: aload 7
    //   220: athrow
    //   221: astore 20
    //   223: new 96	java/lang/RuntimeException
    //   226: dup
    //   227: new 43	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   234: ldc 103
    //   236: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: invokevirtual 41	java/lang/Class:getName	()Ljava/lang/String;
    //   243: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: aload 20
    //   251: invokespecial 106	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   254: athrow
    //   255: aload_1
    //   256: invokevirtual 41	java/lang/Class:getName	()Ljava/lang/String;
    //   259: bipush 46
    //   261: bipush 47
    //   263: invokevirtual 82	java/lang/String:replace	(CC)Ljava/lang/String;
    //   266: astore 11
    //   268: aload_0
    //   269: iconst_1
    //   270: anewarray 19	java/lang/Class
    //   273: dup
    //   274: iconst_0
    //   275: aload_1
    //   276: aastore
    //   277: invokevirtual 88	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   280: invokevirtual 91	java/lang/reflect/Constructor:getModifiers	()I
    //   283: invokestatic 94	java/lang/reflect/Modifier:isPrivate	(I)Z
    //   286: istore 13
    //   288: iload 13
    //   290: ifeq +184 -> 474
    //   293: new 96	java/lang/RuntimeException
    //   296: dup
    //   297: new 43	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   304: ldc 108
    //   306: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_0
    //   310: invokevirtual 41	java/lang/Class:getName	()Ljava/lang/String;
    //   313: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokespecial 101	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   322: athrow
    //   323: astore 12
    //   325: new 96	java/lang/RuntimeException
    //   328: dup
    //   329: new 43	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   336: ldc 110
    //   338: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: invokevirtual 41	java/lang/Class:getName	()Ljava/lang/String;
    //   345: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: aload 12
    //   353: invokespecial 106	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   356: athrow
    //   357: new 112	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter
    //   360: dup
    //   361: iconst_0
    //   362: invokespecial 115	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:<init>	(I)V
    //   365: astore 15
    //   367: aload 15
    //   369: ldc 116
    //   371: bipush 33
    //   373: aload 9
    //   375: aconst_null
    //   376: ldc 117
    //   378: aconst_null
    //   379: invokevirtual 121	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:visit	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   382: aload 15
    //   384: invokestatic 125	com/esotericsoftware/reflectasm/ConstructorAccess:insertConstructor	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;)V
    //   387: aload 15
    //   389: aload 10
    //   391: invokestatic 129	com/esotericsoftware/reflectasm/ConstructorAccess:insertNewInstance	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;)V
    //   394: aload 15
    //   396: aload 10
    //   398: aload 14
    //   400: invokestatic 133	com/esotericsoftware/reflectasm/ConstructorAccess:insertNewInstanceInner	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload 15
    //   405: invokevirtual 136	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:visitEnd	()V
    //   408: aload 6
    //   410: aload 5
    //   412: aload 15
    //   414: invokevirtual 140	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:toByteArray	()[B
    //   417: invokevirtual 144	com/esotericsoftware/reflectasm/AccessClassLoader:defineClass	(Ljava/lang/String;[B)Ljava/lang/Class;
    //   420: astore 16
    //   422: aload 16
    //   424: astore 17
    //   426: goto -318 -> 108
    //   429: astore 18
    //   431: new 96	java/lang/RuntimeException
    //   434: dup
    //   435: new 43	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   442: ldc 146
    //   444: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 5
    //   449: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: aload 18
    //   457: invokespecial 106	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   460: athrow
    //   461: aconst_null
    //   462: astore 14
    //   464: goto -107 -> 357
    //   467: aload 4
    //   469: astore 5
    //   471: goto -385 -> 86
    //   474: aload 11
    //   476: astore 14
    //   478: goto -121 -> 357
    //
    // Exception table:
    //   from	to	target	type
    //   95	104	135	java/lang/ClassNotFoundException
    //   95	104	213	finally
    //   108	111	213	finally
    //   137	158	213	finally
    //   162	178	213	finally
    //   183	213	213	finally
    //   215	218	213	finally
    //   223	255	213	finally
    //   255	268	213	finally
    //   268	288	213	finally
    //   293	323	213	finally
    //   325	357	213	finally
    //   357	422	213	finally
    //   162	178	221	java/lang/Exception
    //   268	288	323	java/lang/Exception
    //   111	127	429	java/lang/Exception
  }

  private static void insertConstructor(ClassWriter paramClassWriter)
  {
    MethodVisitor localMethodVisitor = paramClassWriter.visitMethod(1, "<init>", "()V", null, null);
    localMethodVisitor.visitCode();
    localMethodVisitor.visitVarInsn(25, 0);
    localMethodVisitor.visitMethodInsn(183, "com/esotericsoftware/reflectasm/ConstructorAccess", "<init>", "()V");
    localMethodVisitor.visitInsn(177);
    localMethodVisitor.visitMaxs(1, 1);
    localMethodVisitor.visitEnd();
  }

  static void insertNewInstance(ClassWriter paramClassWriter, String paramString)
  {
    MethodVisitor localMethodVisitor = paramClassWriter.visitMethod(1, "newInstance", "()Ljava/lang/Object;", null, null);
    localMethodVisitor.visitCode();
    localMethodVisitor.visitTypeInsn(187, paramString);
    localMethodVisitor.visitInsn(89);
    localMethodVisitor.visitMethodInsn(183, paramString, "<init>", "()V");
    localMethodVisitor.visitInsn(176);
    localMethodVisitor.visitMaxs(2, 1);
    localMethodVisitor.visitEnd();
  }

  static void insertNewInstanceInner(ClassWriter paramClassWriter, String paramString1, String paramString2)
  {
    MethodVisitor localMethodVisitor = paramClassWriter.visitMethod(1, "newInstance", "(Ljava/lang/Object;)Ljava/lang/Object;", null, null);
    localMethodVisitor.visitCode();
    if (paramString2 != null)
    {
      localMethodVisitor.visitTypeInsn(187, paramString1);
      localMethodVisitor.visitInsn(89);
      localMethodVisitor.visitVarInsn(25, 1);
      localMethodVisitor.visitTypeInsn(192, paramString2);
      localMethodVisitor.visitInsn(89);
      localMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
      localMethodVisitor.visitInsn(87);
      localMethodVisitor.visitMethodInsn(183, paramString1, "<init>", "(L" + paramString2 + ";)V");
      localMethodVisitor.visitInsn(176);
      localMethodVisitor.visitMaxs(4, 2);
    }
    while (true)
    {
      localMethodVisitor.visitEnd();
      return;
      localMethodVisitor.visitTypeInsn(187, "java/lang/UnsupportedOperationException");
      localMethodVisitor.visitInsn(89);
      localMethodVisitor.visitLdcInsn("Not an inner class.");
      localMethodVisitor.visitMethodInsn(183, "java/lang/UnsupportedOperationException", "<init>", "(Ljava/lang/String;)V");
      localMethodVisitor.visitInsn(191);
      localMethodVisitor.visitMaxs(3, 2);
    }
  }

  public boolean isNonStaticMemberClass()
  {
    return this.isNonStaticMemberClass;
  }

  public abstract T newInstance();

  public abstract T newInstance(Object paramObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.ConstructorAccess
 * JD-Core Version:    0.6.2
 */