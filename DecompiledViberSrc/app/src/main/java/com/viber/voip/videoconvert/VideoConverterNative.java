package com.viber.voip.videoconvert;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VideoConverterNative
{
  private static AtomicBoolean a = new AtomicBoolean(false);

  static
  {
    try
    {
      Class localClass = Class.forName("com.viber.common.jni.NativeLibraryLoader");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("loadLibrary", arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "videoconvert";
      arrayOfObject[1] = Boolean.valueOf(true);
      localMethod.invoke(null, arrayOfObject);
      a();
      a.set(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        System.loadLibrary("videoconvert");
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
    }
  }

  static void a()
  {
  }

  static native long allocScaler(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);

  static boolean b()
  {
    return (a.get()) && (hasConversionSupportBuiltin());
  }

  // ERROR //
  public static boolean c()
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 30	java/lang/String
    //   4: dup
    //   5: iconst_0
    //   6: ldc 79
    //   8: aastore
    //   9: dup
    //   10: iconst_1
    //   11: ldc 81
    //   13: aastore
    //   14: astore_0
    //   15: invokestatic 87	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: aload_0
    //   19: invokevirtual 91	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   22: astore 4
    //   24: new 93	java/util/Scanner
    //   27: dup
    //   28: aload 4
    //   30: invokevirtual 99	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   33: invokespecial 102	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   36: astore 5
    //   38: aload 4
    //   40: invokevirtual 106	java/lang/Process:waitFor	()I
    //   43: pop
    //   44: iconst_0
    //   45: istore 7
    //   47: aload 5
    //   49: invokevirtual 109	java/util/Scanner:hasNextLine	()Z
    //   52: ifeq +165 -> 217
    //   55: aload 5
    //   57: invokevirtual 113	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   60: astore 9
    //   62: aload 9
    //   64: ifnull +62 -> 126
    //   67: aload 9
    //   69: ldc 115
    //   71: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifne +13 -> 87
    //   77: aload 9
    //   79: ldc 121
    //   81: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   84: ifeq +42 -> 126
    //   87: aload 9
    //   89: ldc 123
    //   91: invokevirtual 127	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   94: istore 10
    //   96: iload 10
    //   98: ifeq +28 -> 126
    //   101: iconst_1
    //   102: istore 11
    //   104: iload 7
    //   106: iload 11
    //   108: ior
    //   109: istore 7
    //   111: iload 7
    //   113: ifeq +19 -> 132
    //   116: iload 7
    //   118: istore_3
    //   119: aload 5
    //   121: invokevirtual 130	java/util/Scanner:close	()V
    //   124: iload_3
    //   125: ireturn
    //   126: iconst_0
    //   127: istore 11
    //   129: goto -25 -> 104
    //   132: aload 9
    //   134: ifnull +48 -> 182
    //   137: aload 9
    //   139: ldc 132
    //   141: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   144: ifeq +38 -> 182
    //   147: aload 9
    //   149: ldc 134
    //   151: invokevirtual 127	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   154: istore 13
    //   156: iload 13
    //   158: ifeq +24 -> 182
    //   161: iconst_1
    //   162: istore 12
    //   164: iload 7
    //   166: iload 12
    //   168: ior
    //   169: istore 7
    //   171: iload 7
    //   173: ifeq -126 -> 47
    //   176: iload 7
    //   178: istore_3
    //   179: goto -60 -> 119
    //   182: iconst_0
    //   183: istore 12
    //   185: goto -21 -> 164
    //   188: astore_1
    //   189: aload_1
    //   190: astore_2
    //   191: iconst_0
    //   192: istore_3
    //   193: invokestatic 139	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   196: aload_2
    //   197: invokevirtual 142	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   200: iload_3
    //   201: ireturn
    //   202: astore 8
    //   204: iload 7
    //   206: istore_3
    //   207: aload 8
    //   209: astore_2
    //   210: goto -17 -> 193
    //   213: astore_2
    //   214: goto -21 -> 193
    //   217: iload 7
    //   219: istore_3
    //   220: goto -101 -> 119
    //
    // Exception table:
    //   from	to	target	type
    //   15	44	188	java/lang/Exception
    //   47	62	202	java/lang/Exception
    //   67	87	202	java/lang/Exception
    //   87	96	202	java/lang/Exception
    //   137	156	202	java/lang/Exception
    //   119	124	213	java/lang/Exception
  }

  static native int checkColorspaceSupport(int paramInt, boolean paramBoolean);

  static native int convert(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, double paramDouble, int paramInt5);

  static native boolean hasConversionSupportBuiltin();

  static native int initialize(IVideoConverterProgressObserver paramIVideoConverterProgressObserver, String paramString1, int paramInt1, int paramInt2, String paramString2);

  static native void releaseScaler(long paramLong);

  static native int resize(long paramLong, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt);

  static native int updateScaler(long paramLong, int paramInt1, int paramInt2);

  public static abstract interface IVideoConverterProgressObserver
  {
    public abstract void onProgress(String paramString, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.VideoConverterNative
 * JD-Core Version:    0.6.2
 */