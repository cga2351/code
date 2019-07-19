package com.esotericsoftware.kryo.util;

import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import sun.misc.Cleaner;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

public class UnsafeUtil
{
  private static final Unsafe _unsafe;
  public static final long byteArrayBaseOffset;
  public static final long charArrayBaseOffset;
  static Constructor<? extends ByteBuffer> directByteBufferConstr;
  public static final long doubleArrayBaseOffset;
  public static final long floatArrayBaseOffset;
  public static final long intArrayBaseOffset;
  public static final long longArrayBaseOffset;
  public static final long shortArrayBaseOffset;

  // ERROR //
  static
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_0
    //   2: lconst_0
    //   3: lstore_2
    //   4: lconst_0
    //   5: lstore 4
    //   7: lconst_0
    //   8: lstore 6
    //   10: lconst_0
    //   11: lstore 8
    //   13: lconst_0
    //   14: lstore 10
    //   16: lconst_0
    //   17: lstore 12
    //   19: getstatic 27	com/esotericsoftware/kryo/util/Util:isAndroid	Z
    //   22: ifne +244 -> 266
    //   25: ldc 29
    //   27: ldc 31
    //   29: invokevirtual 37	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   32: astore 42
    //   34: aload 42
    //   36: iconst_1
    //   37: invokevirtual 43	java/lang/reflect/Field:setAccessible	(Z)V
    //   40: aload 42
    //   42: aconst_null
    //   43: invokevirtual 47	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 29	sun/misc/Unsafe
    //   49: astore 43
    //   51: aload 43
    //   53: ldc 49
    //   55: invokevirtual 53	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   58: i2l
    //   59: lstore_0
    //   60: aload 43
    //   62: ldc 55
    //   64: invokevirtual 53	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   67: i2l
    //   68: lstore 12
    //   70: aload 43
    //   72: ldc 57
    //   74: invokevirtual 53	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   77: i2l
    //   78: lstore 10
    //   80: aload 43
    //   82: ldc 59
    //   84: invokevirtual 53	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   87: i2l
    //   88: lstore 6
    //   90: aload 43
    //   92: ldc 61
    //   94: invokevirtual 53	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   97: i2l
    //   98: lstore_2
    //   99: aload 43
    //   101: ldc 63
    //   103: invokevirtual 53	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   106: i2l
    //   107: lstore 8
    //   109: aload 43
    //   111: ldc 65
    //   113: invokevirtual 53	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   116: istore 47
    //   118: iload 47
    //   120: i2l
    //   121: lstore 48
    //   123: lload 12
    //   125: lstore 50
    //   127: lload 10
    //   129: lstore 17
    //   131: lload 8
    //   133: lstore 19
    //   135: lload 6
    //   137: lstore 21
    //   139: lload 48
    //   141: lstore 36
    //   143: lload_2
    //   144: lstore 38
    //   146: lload_0
    //   147: lstore 25
    //   149: aload 43
    //   151: astore 27
    //   153: lload 50
    //   155: lstore 28
    //   157: lload 36
    //   159: lstore 40
    //   161: lload 38
    //   163: lstore 23
    //   165: lload 40
    //   167: lstore 4
    //   169: lload 25
    //   171: putstatic 67	com/esotericsoftware/kryo/util/UnsafeUtil:byteArrayBaseOffset	J
    //   174: lload 28
    //   176: putstatic 69	com/esotericsoftware/kryo/util/UnsafeUtil:charArrayBaseOffset	J
    //   179: lload 17
    //   181: putstatic 71	com/esotericsoftware/kryo/util/UnsafeUtil:shortArrayBaseOffset	J
    //   184: lload 21
    //   186: putstatic 73	com/esotericsoftware/kryo/util/UnsafeUtil:intArrayBaseOffset	J
    //   189: lload 23
    //   191: putstatic 75	com/esotericsoftware/kryo/util/UnsafeUtil:floatArrayBaseOffset	J
    //   194: lload 19
    //   196: putstatic 77	com/esotericsoftware/kryo/util/UnsafeUtil:longArrayBaseOffset	J
    //   199: lload 4
    //   201: putstatic 79	com/esotericsoftware/kryo/util/UnsafeUtil:doubleArrayBaseOffset	J
    //   204: aload 27
    //   206: putstatic 81	com/esotericsoftware/kryo/util/UnsafeUtil:_unsafe	Lsun/misc/Unsafe;
    //   209: iconst_1
    //   210: invokestatic 87	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   213: astore 30
    //   215: aload 30
    //   217: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   220: astore 32
    //   222: iconst_3
    //   223: anewarray 33	java/lang/Class
    //   226: astore 33
    //   228: aload 33
    //   230: iconst_0
    //   231: getstatic 97	java/lang/Long:TYPE	Ljava/lang/Class;
    //   234: aastore
    //   235: aload 33
    //   237: iconst_1
    //   238: getstatic 100	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   241: aastore
    //   242: aload 33
    //   244: iconst_2
    //   245: ldc 4
    //   247: aastore
    //   248: aload 32
    //   250: aload 33
    //   252: invokevirtual 104	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   255: putstatic 106	com/esotericsoftware/kryo/util/UnsafeUtil:directByteBufferConstr	Ljava/lang/reflect/Constructor;
    //   258: getstatic 106	com/esotericsoftware/kryo/util/UnsafeUtil:directByteBufferConstr	Ljava/lang/reflect/Constructor;
    //   261: iconst_1
    //   262: invokevirtual 109	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   265: return
    //   266: getstatic 114	com/esotericsoftware/minlog/Log:TRACE	Z
    //   269: ifeq +10 -> 279
    //   272: ldc 116
    //   274: ldc 118
    //   276: invokestatic 122	com/esotericsoftware/minlog/Log:trace	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: lload 12
    //   281: lstore 34
    //   283: lload 10
    //   285: lstore 17
    //   287: lload 8
    //   289: lstore 19
    //   291: lload 6
    //   293: lstore 21
    //   295: lload 4
    //   297: lstore 36
    //   299: lload_2
    //   300: lstore 38
    //   302: lload_0
    //   303: lstore 25
    //   305: lload 34
    //   307: lstore 28
    //   309: aconst_null
    //   310: astore 27
    //   312: goto -155 -> 157
    //   315: astore 14
    //   317: lload 12
    //   319: lstore 15
    //   321: lload 10
    //   323: lstore 17
    //   325: lload 8
    //   327: lstore 19
    //   329: lload 6
    //   331: lstore 21
    //   333: lload_2
    //   334: lstore 23
    //   336: lload_0
    //   337: lstore 25
    //   339: aconst_null
    //   340: astore 27
    //   342: lload 15
    //   344: lstore 28
    //   346: getstatic 114	com/esotericsoftware/minlog/Log:TRACE	Z
    //   349: ifeq -180 -> 169
    //   352: ldc 116
    //   354: ldc 124
    //   356: invokestatic 122	com/esotericsoftware/minlog/Log:trace	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: goto -190 -> 169
    //   362: astore 31
    //   364: aconst_null
    //   365: putstatic 106	com/esotericsoftware/kryo/util/UnsafeUtil:directByteBufferConstr	Ljava/lang/reflect/Constructor;
    //   368: return
    //   369: astore 44
    //   371: lload 12
    //   373: lstore 45
    //   375: lload 10
    //   377: lstore 17
    //   379: lload 8
    //   381: lstore 19
    //   383: lload 6
    //   385: lstore 21
    //   387: lload_2
    //   388: lstore 23
    //   390: lload_0
    //   391: lstore 25
    //   393: aload 43
    //   395: astore 27
    //   397: lload 45
    //   399: lstore 28
    //   401: goto -55 -> 346
    //
    // Exception table:
    //   from	to	target	type
    //   19	51	315	java/lang/Exception
    //   266	279	315	java/lang/Exception
    //   215	265	362	java/lang/Exception
    //   51	118	369	java/lang/Exception
  }

  public static final ByteBuffer getDirectBufferAt(long paramLong, int paramInt)
  {
    if (directByteBufferConstr == null)
      return null;
    try
    {
      Constructor localConstructor = directByteBufferConstr;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(paramLong);
      arrayOfObject[1] = Integer.valueOf(paramInt);
      arrayOfObject[2] = null;
      ByteBuffer localByteBuffer = (ByteBuffer)localConstructor.newInstance(arrayOfObject);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Cannot allocate ByteBuffer at a given address: " + paramLong, localException);
    }
  }

  public static void releaseBuffer(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer != null) && (paramByteBuffer.isDirect()))
    {
      Cleaner localCleaner = ((DirectBuffer)paramByteBuffer).cleaner();
      if (localCleaner != null)
        ((Cleaner)localCleaner).clean();
    }
  }

  public static Field[] sortFieldsByOffset(List<Field> paramList)
  {
    Field[] arrayOfField = (Field[])paramList.toArray(new Field[0]);
    Arrays.sort(arrayOfField, new Comparator()
    {
      public int compare(Field paramAnonymousField1, Field paramAnonymousField2)
      {
        long l1 = UnsafeUtil.unsafe().objectFieldOffset(paramAnonymousField1);
        long l2 = UnsafeUtil.unsafe().objectFieldOffset(paramAnonymousField2);
        if (l1 < l2)
          return -1;
        if (l1 == l2)
          return 0;
        return 1;
      }
    });
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Field localField = (Field)localIterator.next();
      if (Log.TRACE)
        Log.trace("kryo", "Field '" + localField.getName() + "' at offset " + unsafe().objectFieldOffset(localField));
    }
    return arrayOfField;
  }

  public static final Unsafe unsafe()
  {
    return _unsafe;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.util.UnsafeUtil
 * JD-Core Version:    0.6.2
 */