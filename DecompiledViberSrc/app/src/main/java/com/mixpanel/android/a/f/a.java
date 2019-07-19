package com.mixpanel.android.a.f;

import android.annotation.SuppressLint;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

@SuppressLint({"Assert"})
public class a
{
  private static final byte[] b;
  private static final byte[] c;
  private static final byte[] d;
  private static final byte[] e;
  private static final byte[] f;
  private static final byte[] g;

  static
  {
    if (!a.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      b = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      c = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      d = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      e = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      f = new byte[] { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
      g = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      return;
    }
  }

  public static String a(byte[] paramArrayOfByte)
  {
    String str1;
    try
    {
      String str2 = a(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      str1 = str2;
      if ((!a) && (str1 == null))
        throw new AssertionError();
    }
    catch (IOException localIOException)
    {
      boolean bool;
      do
      {
        bool = a;
        str1 = null;
      }
      while (bool);
      throw new AssertionError(localIOException.getMessage());
    }
    return str1;
  }

  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    byte[] arrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(arrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return new String(arrayOfByte);
  }

  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = b(paramInt4);
    int i;
    if (paramInt2 > 0)
    {
      i = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label22: if (paramInt2 <= 1)
        break label112;
    }
    int n;
    label112: for (int j = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16; ; j = 0)
    {
      int k = j | i;
      int m = 0;
      if (paramInt2 > 2)
        m = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      n = m | k;
      switch (paramInt2)
      {
      default:
        return paramArrayOfByte2;
        i = 0;
        break label22;
      case 3:
      case 2:
      case 1:
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(n >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & n >>> 12)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(0x3F & n >>> 6)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(n & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(n >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & n >>> 12)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(0x3F & n >>> 6)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(n >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & n >>> 12)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }

  private static int b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 == null)
      throw new NullPointerException("Source array was null.");
    if (paramArrayOfByte2 == null)
      throw new NullPointerException("Destination array was null.");
    if ((paramInt1 < 0) || (paramInt1 + 3 >= paramArrayOfByte1.length))
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(paramArrayOfByte1.length);
      arrayOfObject1[1] = Integer.valueOf(paramInt1);
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", arrayOfObject1));
    }
    if ((paramInt2 < 0) || (paramInt2 + 2 >= paramArrayOfByte2.length))
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(paramArrayOfByte2.length);
      arrayOfObject2[1] = Integer.valueOf(paramInt2);
      throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", arrayOfObject2));
    }
    byte[] arrayOfByte = c(paramInt3);
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)(((0xFF & arrayOfByte[paramArrayOfByte1[paramInt1]]) << 18 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]]) << 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      int j = (0xFF & arrayOfByte[paramArrayOfByte1[paramInt1]]) << 18 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]]) << 12 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]]) << 6;
      paramArrayOfByte2[paramInt2] = ((byte)(j >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(j >>> 8));
      return 2;
    }
    int i = (0xFF & arrayOfByte[paramArrayOfByte1[paramInt1]]) << 18 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]]) << 12 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]]) << 6 | 0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 3)]];
    paramArrayOfByte2[paramInt2] = ((byte)(i >> 16));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(i >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)i);
    return 3;
  }

  private static final byte[] b(int paramInt)
  {
    if ((paramInt & 0x10) == 16)
      return d;
    if ((paramInt & 0x20) == 32)
      return f;
    return b;
  }

  // ERROR //
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +13 -> 17
    //   7: new 206	java/lang/NullPointerException
    //   10: dup
    //   11: ldc 234
    //   13: invokespecial 211	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: iload_1
    //   18: ifge +30 -> 48
    //   21: new 221	java/lang/IllegalArgumentException
    //   24: dup
    //   25: new 236	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   32: ldc 239
    //   34: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload_1
    //   38: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 228	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: iload_2
    //   49: ifge +30 -> 79
    //   52: new 221	java/lang/IllegalArgumentException
    //   55: dup
    //   56: new 236	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   63: ldc 251
    //   65: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 228	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: iload_1
    //   80: iload_2
    //   81: iadd
    //   82: aload_0
    //   83: arraylength
    //   84: if_icmple +49 -> 133
    //   87: iconst_3
    //   88: anewarray 4	java/lang/Object
    //   91: astore 31
    //   93: aload 31
    //   95: iconst_0
    //   96: iload_1
    //   97: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aastore
    //   101: aload 31
    //   103: iconst_1
    //   104: iload_2
    //   105: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: aload 31
    //   111: iconst_2
    //   112: aload_0
    //   113: arraylength
    //   114: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: new 221	java/lang/IllegalArgumentException
    //   121: dup
    //   122: ldc 253
    //   124: aload 31
    //   126: invokestatic 227	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokespecial 228	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   132: athrow
    //   133: iload_3
    //   134: iconst_2
    //   135: iand
    //   136: ifeq +110 -> 246
    //   139: new 255	java/io/ByteArrayOutputStream
    //   142: dup
    //   143: invokespecial 256	java/io/ByteArrayOutputStream:<init>	()V
    //   146: astore 19
    //   148: new 258	com/mixpanel/android/a/f/a$a
    //   151: dup
    //   152: aload 19
    //   154: iload_3
    //   155: iconst_1
    //   156: ior
    //   157: invokespecial 261	com/mixpanel/android/a/f/a$a:<init>	(Ljava/io/OutputStream;I)V
    //   160: astore 20
    //   162: new 263	java/util/zip/GZIPOutputStream
    //   165: dup
    //   166: aload 20
    //   168: invokespecial 266	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   171: astore 21
    //   173: aload 21
    //   175: aload_0
    //   176: iload_1
    //   177: iload_2
    //   178: invokevirtual 270	java/util/zip/GZIPOutputStream:write	([BII)V
    //   181: aload 21
    //   183: invokevirtual 273	java/util/zip/GZIPOutputStream:close	()V
    //   186: aload 21
    //   188: invokevirtual 273	java/util/zip/GZIPOutputStream:close	()V
    //   191: aload 20
    //   193: invokevirtual 274	com/mixpanel/android/a/f/a$a:close	()V
    //   196: aload 19
    //   198: invokevirtual 275	java/io/ByteArrayOutputStream:close	()V
    //   201: aload 19
    //   203: invokevirtual 279	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   206: astore 9
    //   208: aload 9
    //   210: areturn
    //   211: astore 22
    //   213: aconst_null
    //   214: astore 20
    //   216: aconst_null
    //   217: astore 23
    //   219: aload 22
    //   221: athrow
    //   222: astore 24
    //   224: aload 23
    //   226: astore 19
    //   228: aload 4
    //   230: invokevirtual 273	java/util/zip/GZIPOutputStream:close	()V
    //   233: aload 20
    //   235: invokevirtual 274	com/mixpanel/android/a/f/a$a:close	()V
    //   238: aload 19
    //   240: invokevirtual 275	java/io/ByteArrayOutputStream:close	()V
    //   243: aload 24
    //   245: athrow
    //   246: iload_3
    //   247: bipush 8
    //   249: iand
    //   250: ifeq +139 -> 389
    //   253: iconst_1
    //   254: istore 5
    //   256: iconst_4
    //   257: iload_2
    //   258: iconst_3
    //   259: idiv
    //   260: imul
    //   261: istore 6
    //   263: iload_2
    //   264: iconst_3
    //   265: irem
    //   266: ifle +129 -> 395
    //   269: iconst_4
    //   270: istore 7
    //   272: iload 7
    //   274: iload 6
    //   276: iadd
    //   277: istore 8
    //   279: iload 5
    //   281: ifeq +13 -> 294
    //   284: iload 8
    //   286: iload 8
    //   288: bipush 76
    //   290: idiv
    //   291: iadd
    //   292: istore 8
    //   294: iload 8
    //   296: newarray byte
    //   298: astore 9
    //   300: iload_2
    //   301: iconst_2
    //   302: isub
    //   303: istore 10
    //   305: iconst_0
    //   306: istore 11
    //   308: iconst_0
    //   309: istore 12
    //   311: iconst_0
    //   312: istore 13
    //   314: iload 13
    //   316: iload 10
    //   318: if_icmpge +83 -> 401
    //   321: aload_0
    //   322: iload 13
    //   324: iload_1
    //   325: iadd
    //   326: iconst_3
    //   327: aload 9
    //   329: iload 12
    //   331: iload_3
    //   332: invokestatic 281	com/mixpanel/android/a/f/a:a	([BII[BII)[B
    //   335: pop
    //   336: iload 11
    //   338: iconst_4
    //   339: iadd
    //   340: istore 17
    //   342: iload 5
    //   344: ifeq +25 -> 369
    //   347: iload 17
    //   349: bipush 76
    //   351: if_icmplt +18 -> 369
    //   354: aload 9
    //   356: iload 12
    //   358: iconst_4
    //   359: iadd
    //   360: bipush 10
    //   362: bastore
    //   363: iinc 12 1
    //   366: iconst_0
    //   367: istore 17
    //   369: iload 13
    //   371: iconst_3
    //   372: iadd
    //   373: istore 18
    //   375: iinc 12 4
    //   378: iload 17
    //   380: istore 11
    //   382: iload 18
    //   384: istore 13
    //   386: goto -72 -> 314
    //   389: iconst_0
    //   390: istore 5
    //   392: goto -136 -> 256
    //   395: iconst_0
    //   396: istore 7
    //   398: goto -126 -> 272
    //   401: iload 13
    //   403: iload_2
    //   404: if_icmpge +24 -> 428
    //   407: aload_0
    //   408: iload 13
    //   410: iload_1
    //   411: iadd
    //   412: iload_2
    //   413: iload 13
    //   415: isub
    //   416: aload 9
    //   418: iload 12
    //   420: iload_3
    //   421: invokestatic 281	com/mixpanel/android/a/f/a:a	([BII[BII)[B
    //   424: pop
    //   425: iinc 12 4
    //   428: iload 12
    //   430: iconst_m1
    //   431: aload 9
    //   433: arraylength
    //   434: iadd
    //   435: if_icmpgt -227 -> 208
    //   438: iload 12
    //   440: newarray byte
    //   442: astore 14
    //   444: aload 9
    //   446: iconst_0
    //   447: aload 14
    //   449: iconst_0
    //   450: iload 12
    //   452: invokestatic 287	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   455: aload 14
    //   457: areturn
    //   458: astore 28
    //   460: goto -269 -> 191
    //   463: astore 29
    //   465: goto -269 -> 196
    //   468: astore 30
    //   470: goto -269 -> 201
    //   473: astore 25
    //   475: goto -242 -> 233
    //   478: astore 26
    //   480: goto -242 -> 238
    //   483: astore 27
    //   485: goto -242 -> 243
    //   488: astore 24
    //   490: aconst_null
    //   491: astore 20
    //   493: aconst_null
    //   494: astore 4
    //   496: aconst_null
    //   497: astore 19
    //   499: goto -271 -> 228
    //   502: astore 24
    //   504: aconst_null
    //   505: astore 20
    //   507: aconst_null
    //   508: astore 4
    //   510: goto -282 -> 228
    //   513: astore 24
    //   515: aconst_null
    //   516: astore 4
    //   518: goto -290 -> 228
    //   521: astore 24
    //   523: aload 21
    //   525: astore 4
    //   527: goto -299 -> 228
    //   530: astore 22
    //   532: aload 19
    //   534: astore 23
    //   536: aconst_null
    //   537: astore 20
    //   539: aconst_null
    //   540: astore 4
    //   542: goto -323 -> 219
    //   545: astore 22
    //   547: aload 19
    //   549: astore 23
    //   551: aconst_null
    //   552: astore 4
    //   554: goto -335 -> 219
    //   557: astore 22
    //   559: aload 21
    //   561: astore 4
    //   563: aload 19
    //   565: astore 23
    //   567: goto -348 -> 219
    //
    // Exception table:
    //   from	to	target	type
    //   139	148	211	java/io/IOException
    //   219	222	222	finally
    //   186	191	458	java/lang/Exception
    //   191	196	463	java/lang/Exception
    //   196	201	468	java/lang/Exception
    //   228	233	473	java/lang/Exception
    //   233	238	478	java/lang/Exception
    //   238	243	483	java/lang/Exception
    //   139	148	488	finally
    //   148	162	502	finally
    //   162	173	513	finally
    //   173	186	521	finally
    //   148	162	530	java/io/IOException
    //   162	173	545	java/io/IOException
    //   173	186	557	java/io/IOException
  }

  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte2, 0, paramInt1, paramArrayOfByte1, 0, paramInt2);
    return paramArrayOfByte1;
  }

  private static final byte[] c(int paramInt)
  {
    if ((paramInt & 0x10) == 16)
      return e;
    if ((paramInt & 0x20) == 32)
      return g;
    return c;
  }

  public static class a extends FilterOutputStream
  {
    private boolean a;
    private int b;
    private byte[] c;
    private int d;
    private int e;
    private boolean f;
    private byte[] g;
    private boolean h;
    private int i;
    private byte[] j;

    public a(OutputStream paramOutputStream, int paramInt)
    {
      super();
      boolean bool2;
      if ((paramInt & 0x8) != 0)
      {
        bool2 = bool1;
        this.f = bool2;
        if ((paramInt & 0x1) == 0)
          break label102;
        label29: this.a = bool1;
        if (!this.a)
          break label107;
      }
      label102: label107: for (int k = 3; ; k = 4)
      {
        this.d = k;
        this.c = new byte[this.d];
        this.b = 0;
        this.e = 0;
        this.h = false;
        this.g = new byte[4];
        this.i = paramInt;
        this.j = a.a(paramInt);
        return;
        bool2 = false;
        break;
        bool1 = false;
        break label29;
      }
    }

    public void a()
      throws IOException
    {
      if (this.b > 0)
      {
        if (this.a)
        {
          this.out.write(a.a(this.g, this.c, this.b, this.i));
          this.b = 0;
        }
      }
      else
        return;
      throw new IOException("Base64 input not properly padded.");
    }

    public void close()
      throws IOException
    {
      a();
      super.close();
      this.c = null;
      this.out = null;
    }

    public void write(int paramInt)
      throws IOException
    {
      if (this.h)
        this.out.write(paramInt);
      do
      {
        do
        {
          do
          {
            return;
            if (!this.a)
              break;
            byte[] arrayOfByte2 = this.c;
            int n = this.b;
            this.b = (n + 1);
            arrayOfByte2[n] = ((byte)paramInt);
          }
          while (this.b < this.d);
          this.out.write(a.a(this.g, this.c, this.d, this.i));
          this.e = (4 + this.e);
          if ((this.f) && (this.e >= 76))
          {
            this.out.write(10);
            this.e = 0;
          }
          this.b = 0;
          return;
          if (this.j[(paramInt & 0x7F)] <= -5)
            break;
          byte[] arrayOfByte1 = this.c;
          int k = this.b;
          this.b = (k + 1);
          arrayOfByte1[k] = ((byte)paramInt);
        }
        while (this.b < this.d);
        int m = a.a(this.c, 0, this.g, 0, this.i);
        this.out.write(this.g, 0, m);
        this.b = 0;
        return;
      }
      while (this.j[(paramInt & 0x7F)] == -5);
      throw new IOException("Invalid character in Base64 data.");
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.h)
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      while (true)
      {
        return;
        for (int k = 0; k < paramInt2; k++)
          write(paramArrayOfByte[(paramInt1 + k)]);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.f.a
 * JD-Core Version:    0.6.2
 */