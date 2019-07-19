package com.esotericsoftware.reflectasm;

import com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.ClassWriter;
import com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Label;
import com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.MethodVisitor;
import com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Type;
import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class FieldAccess
{
  private String[] fieldNames;
  private Class[] fieldTypes;

  // ERROR //
  public static FieldAccess get(Class paramClass)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 20	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 21	java/util/ArrayList:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: astore_3
    //   12: aload_3
    //   13: ldc 4
    //   15: if_acmpeq +78 -> 93
    //   18: aload_3
    //   19: invokevirtual 27	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   22: astore 20
    //   24: aload 20
    //   26: arraylength
    //   27: istore 21
    //   29: iconst_0
    //   30: istore 22
    //   32: iload 22
    //   34: iload 21
    //   36: if_icmpge +49 -> 85
    //   39: aload 20
    //   41: iload 22
    //   43: aaload
    //   44: astore 23
    //   46: aload 23
    //   48: invokevirtual 33	java/lang/reflect/Field:getModifiers	()I
    //   51: istore 24
    //   53: iload 24
    //   55: invokestatic 39	java/lang/reflect/Modifier:isStatic	(I)Z
    //   58: ifeq +9 -> 67
    //   61: iinc 22 1
    //   64: goto -32 -> 32
    //   67: iload 24
    //   69: invokestatic 42	java/lang/reflect/Modifier:isPrivate	(I)Z
    //   72: ifne -11 -> 61
    //   75: aload_2
    //   76: aload 23
    //   78: invokevirtual 46	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: goto -21 -> 61
    //   85: aload_3
    //   86: invokevirtual 50	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   89: astore_3
    //   90: goto -78 -> 12
    //   93: aload_2
    //   94: invokevirtual 53	java/util/ArrayList:size	()I
    //   97: anewarray 55	java/lang/String
    //   100: astore 4
    //   102: aload_2
    //   103: invokevirtual 53	java/util/ArrayList:size	()I
    //   106: anewarray 23	java/lang/Class
    //   109: astore 5
    //   111: aload 4
    //   113: arraylength
    //   114: istore 6
    //   116: iload_1
    //   117: iload 6
    //   119: if_icmpge +39 -> 158
    //   122: aload 4
    //   124: iload_1
    //   125: aload_2
    //   126: iload_1
    //   127: invokevirtual 58	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   130: checkcast 29	java/lang/reflect/Field
    //   133: invokevirtual 62	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   136: aastore
    //   137: aload 5
    //   139: iload_1
    //   140: aload_2
    //   141: iload_1
    //   142: invokevirtual 58	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   145: checkcast 29	java/lang/reflect/Field
    //   148: invokevirtual 65	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   151: aastore
    //   152: iinc 1 1
    //   155: goto -39 -> 116
    //   158: aload_0
    //   159: invokevirtual 66	java/lang/Class:getName	()Ljava/lang/String;
    //   162: astore 7
    //   164: new 68	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   171: aload 7
    //   173: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 75
    //   178: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: astore 8
    //   186: aload 8
    //   188: ldc 80
    //   190: invokevirtual 84	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   193: ifeq +393 -> 586
    //   196: new 68	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   203: ldc 86
    //   205: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 8
    //   210: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: astore 9
    //   218: aload_0
    //   219: invokestatic 91	com/esotericsoftware/reflectasm/AccessClassLoader:get	(Ljava/lang/Class;)Lcom/esotericsoftware/reflectasm/AccessClassLoader;
    //   222: astore 10
    //   224: aload 10
    //   226: monitorenter
    //   227: aload 10
    //   229: aload 9
    //   231: invokevirtual 95	com/esotericsoftware/reflectasm/AccessClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   234: astore 19
    //   236: aload 19
    //   238: astore 16
    //   240: aload 10
    //   242: monitorexit
    //   243: aload 16
    //   245: invokevirtual 99	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   248: checkcast 2	com/esotericsoftware/reflectasm/FieldAccess
    //   251: astore 18
    //   253: aload 18
    //   255: aload 4
    //   257: putfield 101	com/esotericsoftware/reflectasm/FieldAccess:fieldNames	[Ljava/lang/String;
    //   260: aload 18
    //   262: aload 5
    //   264: putfield 103	com/esotericsoftware/reflectasm/FieldAccess:fieldTypes	[Ljava/lang/Class;
    //   267: aload 18
    //   269: areturn
    //   270: astore 12
    //   272: aload 9
    //   274: bipush 46
    //   276: bipush 47
    //   278: invokevirtual 107	java/lang/String:replace	(CC)Ljava/lang/String;
    //   281: astore 13
    //   283: aload 7
    //   285: bipush 46
    //   287: bipush 47
    //   289: invokevirtual 107	java/lang/String:replace	(CC)Ljava/lang/String;
    //   292: astore 14
    //   294: new 109	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter
    //   297: dup
    //   298: iconst_0
    //   299: invokespecial 112	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:<init>	(I)V
    //   302: astore 15
    //   304: aload 15
    //   306: ldc 113
    //   308: bipush 33
    //   310: aload 13
    //   312: aconst_null
    //   313: ldc 114
    //   315: aconst_null
    //   316: invokevirtual 118	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:visit	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   319: aload 15
    //   321: invokestatic 122	com/esotericsoftware/reflectasm/FieldAccess:insertConstructor	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;)V
    //   324: aload 15
    //   326: aload 14
    //   328: aload_2
    //   329: invokestatic 126	com/esotericsoftware/reflectasm/FieldAccess:insertGetObject	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   332: aload 15
    //   334: aload 14
    //   336: aload_2
    //   337: invokestatic 129	com/esotericsoftware/reflectasm/FieldAccess:insertSetObject	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   340: aload 15
    //   342: aload 14
    //   344: aload_2
    //   345: getstatic 135	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:BOOLEAN_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   348: invokestatic 139	com/esotericsoftware/reflectasm/FieldAccess:insertGetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   351: aload 15
    //   353: aload 14
    //   355: aload_2
    //   356: getstatic 135	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:BOOLEAN_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   359: invokestatic 142	com/esotericsoftware/reflectasm/FieldAccess:insertSetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   362: aload 15
    //   364: aload 14
    //   366: aload_2
    //   367: getstatic 145	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:BYTE_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   370: invokestatic 139	com/esotericsoftware/reflectasm/FieldAccess:insertGetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   373: aload 15
    //   375: aload 14
    //   377: aload_2
    //   378: getstatic 145	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:BYTE_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   381: invokestatic 142	com/esotericsoftware/reflectasm/FieldAccess:insertSetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   384: aload 15
    //   386: aload 14
    //   388: aload_2
    //   389: getstatic 148	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:SHORT_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   392: invokestatic 139	com/esotericsoftware/reflectasm/FieldAccess:insertGetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   395: aload 15
    //   397: aload 14
    //   399: aload_2
    //   400: getstatic 148	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:SHORT_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   403: invokestatic 142	com/esotericsoftware/reflectasm/FieldAccess:insertSetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   406: aload 15
    //   408: aload 14
    //   410: aload_2
    //   411: getstatic 151	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:INT_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   414: invokestatic 139	com/esotericsoftware/reflectasm/FieldAccess:insertGetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   417: aload 15
    //   419: aload 14
    //   421: aload_2
    //   422: getstatic 151	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:INT_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   425: invokestatic 142	com/esotericsoftware/reflectasm/FieldAccess:insertSetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   428: aload 15
    //   430: aload 14
    //   432: aload_2
    //   433: getstatic 154	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:LONG_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   436: invokestatic 139	com/esotericsoftware/reflectasm/FieldAccess:insertGetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   439: aload 15
    //   441: aload 14
    //   443: aload_2
    //   444: getstatic 154	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:LONG_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   447: invokestatic 142	com/esotericsoftware/reflectasm/FieldAccess:insertSetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   450: aload 15
    //   452: aload 14
    //   454: aload_2
    //   455: getstatic 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:DOUBLE_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   458: invokestatic 139	com/esotericsoftware/reflectasm/FieldAccess:insertGetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   461: aload 15
    //   463: aload 14
    //   465: aload_2
    //   466: getstatic 157	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:DOUBLE_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   469: invokestatic 142	com/esotericsoftware/reflectasm/FieldAccess:insertSetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   472: aload 15
    //   474: aload 14
    //   476: aload_2
    //   477: getstatic 160	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:FLOAT_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   480: invokestatic 139	com/esotericsoftware/reflectasm/FieldAccess:insertGetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   483: aload 15
    //   485: aload 14
    //   487: aload_2
    //   488: getstatic 160	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:FLOAT_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   491: invokestatic 142	com/esotericsoftware/reflectasm/FieldAccess:insertSetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   494: aload 15
    //   496: aload 14
    //   498: aload_2
    //   499: getstatic 163	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:CHAR_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   502: invokestatic 139	com/esotericsoftware/reflectasm/FieldAccess:insertGetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   505: aload 15
    //   507: aload 14
    //   509: aload_2
    //   510: getstatic 163	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type:CHAR_TYPE	Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;
    //   513: invokestatic 142	com/esotericsoftware/reflectasm/FieldAccess:insertSetPrimitive	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/Type;)V
    //   516: aload 15
    //   518: aload 14
    //   520: aload_2
    //   521: invokestatic 166	com/esotericsoftware/reflectasm/FieldAccess:insertGetString	(Lcom/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   524: aload 15
    //   526: invokevirtual 169	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:visitEnd	()V
    //   529: aload 10
    //   531: aload 9
    //   533: aload 15
    //   535: invokevirtual 173	com/esotericsoftware/reflectasm/shaded/org/objectweb/asm/ClassWriter:toByteArray	()[B
    //   538: invokevirtual 177	com/esotericsoftware/reflectasm/AccessClassLoader:defineClass	(Ljava/lang/String;[B)Ljava/lang/Class;
    //   541: astore 16
    //   543: goto -303 -> 240
    //   546: astore 11
    //   548: aload 10
    //   550: monitorexit
    //   551: aload 11
    //   553: athrow
    //   554: astore 17
    //   556: new 179	java/lang/RuntimeException
    //   559: dup
    //   560: new 68	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   567: ldc 181
    //   569: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload 9
    //   574: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: aload 17
    //   582: invokespecial 184	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   585: athrow
    //   586: aload 8
    //   588: astore 9
    //   590: goto -372 -> 218
    //
    // Exception table:
    //   from	to	target	type
    //   227	236	270	java/lang/ClassNotFoundException
    //   227	236	546	finally
    //   240	243	546	finally
    //   272	543	546	finally
    //   548	551	546	finally
    //   243	267	554	java/lang/Exception
  }

  private static void insertConstructor(ClassWriter paramClassWriter)
  {
    MethodVisitor localMethodVisitor = paramClassWriter.visitMethod(1, "<init>", "()V", null, null);
    localMethodVisitor.visitCode();
    localMethodVisitor.visitVarInsn(25, 0);
    localMethodVisitor.visitMethodInsn(183, "com/esotericsoftware/reflectasm/FieldAccess", "<init>", "()V");
    localMethodVisitor.visitInsn(177);
    localMethodVisitor.visitMaxs(1, 1);
    localMethodVisitor.visitEnd();
  }

  private static void insertGetObject(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList)
  {
    MethodVisitor localMethodVisitor = paramClassWriter.visitMethod(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
    localMethodVisitor.visitCode();
    localMethodVisitor.visitVarInsn(21, 2);
    if (!paramArrayList.isEmpty())
    {
      Label[] arrayOfLabel = new Label[paramArrayList.size()];
      int j = 0;
      int k = arrayOfLabel.length;
      while (j < k)
      {
        arrayOfLabel[j] = new Label();
        j++;
      }
      Label localLabel = new Label();
      localMethodVisitor.visitTableSwitchInsn(0, -1 + arrayOfLabel.length, localLabel, arrayOfLabel);
      int m = arrayOfLabel.length;
      int n = 0;
      if (n < m)
      {
        Field localField = (Field)paramArrayList.get(n);
        localMethodVisitor.visitLabel(arrayOfLabel[n]);
        localMethodVisitor.visitFrame(3, 0, null, 0, null);
        localMethodVisitor.visitVarInsn(25, 1);
        localMethodVisitor.visitTypeInsn(192, paramString);
        localMethodVisitor.visitFieldInsn(180, paramString, localField.getName(), Type.getDescriptor(localField.getType()));
        switch (Type.getType(localField.getType()).getSort())
        {
        default:
        case 1:
        case 3:
        case 2:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        }
        while (true)
        {
          localMethodVisitor.visitInsn(176);
          n++;
          break;
          localMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
          continue;
          localMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
          continue;
          localMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
          continue;
          localMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
          continue;
          localMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
          continue;
          localMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
          continue;
          localMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
          continue;
          localMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        }
      }
      localMethodVisitor.visitLabel(localLabel);
      localMethodVisitor.visitFrame(3, 0, null, 0, null);
    }
    for (int i = 5; ; i = 6)
    {
      insertThrowExceptionForFieldNotFound(localMethodVisitor);
      localMethodVisitor.visitMaxs(i, 3);
      localMethodVisitor.visitEnd();
      return;
    }
  }

  private static void insertGetPrimitive(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList, Type paramType)
  {
    String str1 = paramType.getDescriptor();
    String str2;
    int i;
    MethodVisitor localMethodVisitor1;
    Label[] arrayOfLabel;
    Label localLabel1;
    int k;
    int n;
    switch (paramType.getSort())
    {
    default:
      str2 = "get";
      i = 176;
      localMethodVisitor1 = paramClassWriter.visitMethod(1, str2, "(Ljava/lang/Object;I)" + str1, null, null);
      localMethodVisitor1.visitCode();
      localMethodVisitor1.visitVarInsn(21, 2);
      if (paramArrayList.isEmpty())
        break label520;
      arrayOfLabel = new Label[paramArrayList.size()];
      localLabel1 = new Label();
      k = 0;
      int m = arrayOfLabel.length;
      n = 0;
      label146: if (n >= m)
        break label318;
      if (Type.getType(((Field)paramArrayList.get(n)).getType()).equals(paramType))
        arrayOfLabel[n] = new Label();
      break;
    case 1:
    case 3:
    case 2:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    for (int i3 = k; ; i3 = 1)
    {
      n++;
      k = i3;
      break label146;
      str2 = "getBoolean";
      i = 172;
      break;
      str2 = "getByte";
      i = 172;
      break;
      str2 = "getChar";
      i = 172;
      break;
      str2 = "getShort";
      i = 172;
      break;
      str2 = "getInt";
      i = 172;
      break;
      str2 = "getFloat";
      i = 174;
      break;
      str2 = "getLong";
      i = 173;
      break;
      str2 = "getDouble";
      i = 175;
      break;
      arrayOfLabel[n] = localLabel1;
    }
    label318: Label localLabel2 = new Label();
    localMethodVisitor1.visitTableSwitchInsn(0, -1 + arrayOfLabel.length, localLabel2, arrayOfLabel);
    int i1 = arrayOfLabel.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      Field localField = (Field)paramArrayList.get(i2);
      if (!arrayOfLabel[i2].equals(localLabel1))
      {
        localMethodVisitor1.visitLabel(arrayOfLabel[i2]);
        localMethodVisitor1.visitFrame(3, 0, null, 0, null);
        localMethodVisitor1.visitVarInsn(25, 1);
        localMethodVisitor1.visitTypeInsn(192, paramString);
        localMethodVisitor1.visitFieldInsn(180, paramString, localField.getName(), str1);
        localMethodVisitor1.visitInsn(i);
      }
    }
    if (k != 0)
    {
      localMethodVisitor1.visitLabel(localLabel1);
      localMethodVisitor1.visitFrame(3, 0, null, 0, null);
      insertThrowExceptionForFieldType(localMethodVisitor1, paramType.getClassName());
    }
    localMethodVisitor1.visitLabel(localLabel2);
    localMethodVisitor1.visitFrame(3, 0, null, 0, null);
    label520: for (int j = 5; ; j = 6)
    {
      MethodVisitor localMethodVisitor2 = insertThrowExceptionForFieldNotFound(localMethodVisitor1);
      localMethodVisitor2.visitMaxs(j, 3);
      localMethodVisitor2.visitEnd();
      return;
    }
  }

  private static void insertGetString(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList)
  {
    MethodVisitor localMethodVisitor = paramClassWriter.visitMethod(1, "getString", "(Ljava/lang/Object;I)Ljava/lang/String;", null, null);
    localMethodVisitor.visitCode();
    localMethodVisitor.visitVarInsn(21, 2);
    if (!paramArrayList.isEmpty())
    {
      Label[] arrayOfLabel = new Label[paramArrayList.size()];
      Label localLabel1 = new Label();
      int j = 0;
      int k = arrayOfLabel.length;
      int m = 0;
      if (m < k)
      {
        if (((Field)paramArrayList.get(m)).getType().equals(String.class))
          arrayOfLabel[m] = new Label();
        for (int i2 = j; ; i2 = 1)
        {
          m++;
          j = i2;
          break;
          arrayOfLabel[m] = localLabel1;
        }
      }
      Label localLabel2 = new Label();
      localMethodVisitor.visitTableSwitchInsn(0, -1 + arrayOfLabel.length, localLabel2, arrayOfLabel);
      int n = arrayOfLabel.length;
      for (int i1 = 0; i1 < n; i1++)
        if (!arrayOfLabel[i1].equals(localLabel1))
        {
          localMethodVisitor.visitLabel(arrayOfLabel[i1]);
          localMethodVisitor.visitFrame(3, 0, null, 0, null);
          localMethodVisitor.visitVarInsn(25, 1);
          localMethodVisitor.visitTypeInsn(192, paramString);
          localMethodVisitor.visitFieldInsn(180, paramString, ((Field)paramArrayList.get(i1)).getName(), "Ljava/lang/String;");
          localMethodVisitor.visitInsn(176);
        }
      if (j != 0)
      {
        localMethodVisitor.visitLabel(localLabel1);
        localMethodVisitor.visitFrame(3, 0, null, 0, null);
        insertThrowExceptionForFieldType(localMethodVisitor, "String");
      }
      localMethodVisitor.visitLabel(localLabel2);
      localMethodVisitor.visitFrame(3, 0, null, 0, null);
    }
    for (int i = 5; ; i = 6)
    {
      insertThrowExceptionForFieldNotFound(localMethodVisitor);
      localMethodVisitor.visitMaxs(i, 3);
      localMethodVisitor.visitEnd();
      return;
    }
  }

  private static void insertSetObject(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList)
  {
    MethodVisitor localMethodVisitor1 = paramClassWriter.visitMethod(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
    localMethodVisitor1.visitCode();
    localMethodVisitor1.visitVarInsn(21, 2);
    if (!paramArrayList.isEmpty())
    {
      Label[] arrayOfLabel = new Label[paramArrayList.size()];
      int j = 0;
      int k = arrayOfLabel.length;
      while (j < k)
      {
        arrayOfLabel[j] = new Label();
        j++;
      }
      Label localLabel = new Label();
      localMethodVisitor1.visitTableSwitchInsn(0, -1 + arrayOfLabel.length, localLabel, arrayOfLabel);
      int m = arrayOfLabel.length;
      int n = 0;
      if (n < m)
      {
        Field localField = (Field)paramArrayList.get(n);
        Type localType = Type.getType(localField.getType());
        localMethodVisitor1.visitLabel(arrayOfLabel[n]);
        localMethodVisitor1.visitFrame(3, 0, null, 0, null);
        localMethodVisitor1.visitVarInsn(25, 1);
        localMethodVisitor1.visitTypeInsn(192, paramString);
        localMethodVisitor1.visitVarInsn(25, 3);
        switch (localType.getSort())
        {
        default:
        case 1:
        case 3:
        case 2:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        }
        while (true)
        {
          localMethodVisitor1.visitFieldInsn(181, paramString, localField.getName(), localType.getDescriptor());
          localMethodVisitor1.visitInsn(177);
          n++;
          break;
          localMethodVisitor1.visitTypeInsn(192, "java/lang/Boolean");
          localMethodVisitor1.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z");
          continue;
          localMethodVisitor1.visitTypeInsn(192, "java/lang/Byte");
          localMethodVisitor1.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B");
          continue;
          localMethodVisitor1.visitTypeInsn(192, "java/lang/Character");
          localMethodVisitor1.visitMethodInsn(182, "java/lang/Character", "charValue", "()C");
          continue;
          localMethodVisitor1.visitTypeInsn(192, "java/lang/Short");
          localMethodVisitor1.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S");
          continue;
          localMethodVisitor1.visitTypeInsn(192, "java/lang/Integer");
          localMethodVisitor1.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I");
          continue;
          localMethodVisitor1.visitTypeInsn(192, "java/lang/Float");
          localMethodVisitor1.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F");
          continue;
          localMethodVisitor1.visitTypeInsn(192, "java/lang/Long");
          localMethodVisitor1.visitMethodInsn(182, "java/lang/Long", "longValue", "()J");
          continue;
          localMethodVisitor1.visitTypeInsn(192, "java/lang/Double");
          localMethodVisitor1.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D");
          continue;
          localMethodVisitor1.visitTypeInsn(192, localType.getDescriptor());
          continue;
          localMethodVisitor1.visitTypeInsn(192, localType.getInternalName());
        }
      }
      localMethodVisitor1.visitLabel(localLabel);
      localMethodVisitor1.visitFrame(3, 0, null, 0, null);
    }
    for (int i = 5; ; i = 6)
    {
      MethodVisitor localMethodVisitor2 = insertThrowExceptionForFieldNotFound(localMethodVisitor1);
      localMethodVisitor2.visitMaxs(i, 4);
      localMethodVisitor2.visitEnd();
      return;
    }
  }

  private static void insertSetPrimitive(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList, Type paramType)
  {
    String str1 = paramType.getDescriptor();
    String str2;
    int i;
    int j;
    MethodVisitor localMethodVisitor1;
    Label[] arrayOfLabel;
    Label localLabel1;
    int m;
    int i1;
    switch (paramType.getSort())
    {
    default:
      str2 = "set";
      i = 25;
      j = 4;
      localMethodVisitor1 = paramClassWriter.visitMethod(1, str2, "(Ljava/lang/Object;I" + str1 + ")V", null, null);
      localMethodVisitor1.visitCode();
      localMethodVisitor1.visitVarInsn(21, 2);
      if (paramArrayList.isEmpty())
        break label551;
      arrayOfLabel = new Label[paramArrayList.size()];
      localLabel1 = new Label();
      m = 0;
      int n = arrayOfLabel.length;
      i1 = 0;
      label155: if (i1 >= n)
        break label343;
      if (Type.getType(((Field)paramArrayList.get(i1)).getType()).equals(paramType))
        arrayOfLabel[i1] = new Label();
      break;
    case 1:
    case 3:
    case 2:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    for (int i4 = m; ; i4 = 1)
    {
      i1++;
      m = i4;
      break label155;
      str2 = "setBoolean";
      i = 21;
      j = 4;
      break;
      str2 = "setByte";
      i = 21;
      j = 4;
      break;
      str2 = "setChar";
      i = 21;
      j = 4;
      break;
      str2 = "setShort";
      i = 21;
      j = 4;
      break;
      str2 = "setInt";
      i = 21;
      j = 4;
      break;
      str2 = "setFloat";
      i = 23;
      j = 4;
      break;
      str2 = "setLong";
      i = 22;
      j = 5;
      break;
      str2 = "setDouble";
      i = 24;
      j = 5;
      break;
      arrayOfLabel[i1] = localLabel1;
    }
    label343: Label localLabel2 = new Label();
    localMethodVisitor1.visitTableSwitchInsn(0, -1 + arrayOfLabel.length, localLabel2, arrayOfLabel);
    int i2 = arrayOfLabel.length;
    for (int i3 = 0; i3 < i2; i3++)
      if (!arrayOfLabel[i3].equals(localLabel1))
      {
        localMethodVisitor1.visitLabel(arrayOfLabel[i3]);
        localMethodVisitor1.visitFrame(3, 0, null, 0, null);
        localMethodVisitor1.visitVarInsn(25, 1);
        localMethodVisitor1.visitTypeInsn(192, paramString);
        localMethodVisitor1.visitVarInsn(i, 3);
        localMethodVisitor1.visitFieldInsn(181, paramString, ((Field)paramArrayList.get(i3)).getName(), str1);
        localMethodVisitor1.visitInsn(177);
      }
    if (m != 0)
    {
      localMethodVisitor1.visitLabel(localLabel1);
      localMethodVisitor1.visitFrame(3, 0, null, 0, null);
      insertThrowExceptionForFieldType(localMethodVisitor1, paramType.getClassName());
    }
    localMethodVisitor1.visitLabel(localLabel2);
    localMethodVisitor1.visitFrame(3, 0, null, 0, null);
    label551: for (int k = 5; ; k = 6)
    {
      MethodVisitor localMethodVisitor2 = insertThrowExceptionForFieldNotFound(localMethodVisitor1);
      localMethodVisitor2.visitMaxs(k, j);
      localMethodVisitor2.visitEnd();
      return;
    }
  }

  private static MethodVisitor insertThrowExceptionForFieldNotFound(MethodVisitor paramMethodVisitor)
  {
    paramMethodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitLdcInsn("Field not found: ");
    paramMethodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
    paramMethodVisitor.visitVarInsn(21, 2);
    paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
    paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
    paramMethodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
    paramMethodVisitor.visitInsn(191);
    return paramMethodVisitor;
  }

  private static MethodVisitor insertThrowExceptionForFieldType(MethodVisitor paramMethodVisitor, String paramString)
  {
    paramMethodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitLdcInsn("Field not declared as " + paramString + ": ");
    paramMethodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
    paramMethodVisitor.visitVarInsn(21, 2);
    paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
    paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
    paramMethodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
    paramMethodVisitor.visitInsn(191);
    return paramMethodVisitor;
  }

  public abstract Object get(Object paramObject, int paramInt);

  public Object get(Object paramObject, String paramString)
  {
    return get(paramObject, getIndex(paramString));
  }

  public abstract boolean getBoolean(Object paramObject, int paramInt);

  public abstract byte getByte(Object paramObject, int paramInt);

  public abstract char getChar(Object paramObject, int paramInt);

  public abstract double getDouble(Object paramObject, int paramInt);

  public int getFieldCount()
  {
    return this.fieldTypes.length;
  }

  public String[] getFieldNames()
  {
    return this.fieldNames;
  }

  public Class[] getFieldTypes()
  {
    return this.fieldTypes;
  }

  public abstract float getFloat(Object paramObject, int paramInt);

  public int getIndex(String paramString)
  {
    int i = 0;
    int j = this.fieldNames.length;
    while (i < j)
    {
      if (this.fieldNames[i].equals(paramString))
        return i;
      i++;
    }
    throw new IllegalArgumentException("Unable to find public field: " + paramString);
  }

  public abstract int getInt(Object paramObject, int paramInt);

  public abstract long getLong(Object paramObject, int paramInt);

  public abstract short getShort(Object paramObject, int paramInt);

  public abstract String getString(Object paramObject, int paramInt);

  public abstract void set(Object paramObject1, int paramInt, Object paramObject2);

  public void set(Object paramObject1, String paramString, Object paramObject2)
  {
    set(paramObject1, getIndex(paramString), paramObject2);
  }

  public abstract void setBoolean(Object paramObject, int paramInt, boolean paramBoolean);

  public abstract void setByte(Object paramObject, int paramInt, byte paramByte);

  public abstract void setChar(Object paramObject, int paramInt, char paramChar);

  public abstract void setDouble(Object paramObject, int paramInt, double paramDouble);

  public abstract void setFloat(Object paramObject, int paramInt, float paramFloat);

  public abstract void setInt(Object paramObject, int paramInt1, int paramInt2);

  public abstract void setLong(Object paramObject, int paramInt, long paramLong);

  public abstract void setShort(Object paramObject, int paramInt, short paramShort);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.FieldAccess
 * JD-Core Version:    0.6.2
 */