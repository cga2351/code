package android.support.v8.renderscript;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Surface;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class RenderScript
{
  private static final String CACHE_PATH = "com.android.renderscript.cache";
  public static final int CREATE_FLAG_NONE = 0;
  static final boolean DEBUG = false;
  static final boolean LOG_ENABLED = false;
  static final String LOG_TAG = "RenderScript_jni";
  static final int SUPPORT_LIB_API = 23;
  static final int SUPPORT_LIB_VERSION = 2301;
  static Object lock = new Object();
  private static String mBlackList;
  static String mCachePath;
  private static ArrayList<RenderScript> mProcessContextList = new ArrayList();
  static Method registerNativeAllocation;
  static Method registerNativeFree;
  static boolean sInitialized;
  private static int sNative = -1;
  static int sPointerSize;
  static Object sRuntime;
  private static int sSdkVersion = -1;
  static boolean sUseGCHooks;
  private static boolean useIOlib = false;
  private static boolean useNative;
  private Context mApplicationContext;
  long mContext;
  private int mContextFlags = 0;
  private int mContextSdkVersion = 0;
  ContextType mContextType = ContextType.NORMAL;
  private boolean mDestroyed = false;
  private int mDispatchAPILevel = 0;
  Element mElement_ALLOCATION;
  Element mElement_A_8;
  Element mElement_BOOLEAN;
  Element mElement_CHAR_2;
  Element mElement_CHAR_3;
  Element mElement_CHAR_4;
  Element mElement_DOUBLE_2;
  Element mElement_DOUBLE_3;
  Element mElement_DOUBLE_4;
  Element mElement_ELEMENT;
  Element mElement_F32;
  Element mElement_F64;
  Element mElement_FLOAT_2;
  Element mElement_FLOAT_3;
  Element mElement_FLOAT_4;
  Element mElement_I16;
  Element mElement_I32;
  Element mElement_I64;
  Element mElement_I8;
  Element mElement_INT_2;
  Element mElement_INT_3;
  Element mElement_INT_4;
  Element mElement_LONG_2;
  Element mElement_LONG_3;
  Element mElement_LONG_4;
  Element mElement_MATRIX_2X2;
  Element mElement_MATRIX_3X3;
  Element mElement_MATRIX_4X4;
  Element mElement_RGBA_4444;
  Element mElement_RGBA_5551;
  Element mElement_RGBA_8888;
  Element mElement_RGB_565;
  Element mElement_RGB_888;
  Element mElement_SAMPLER;
  Element mElement_SCRIPT;
  Element mElement_SHORT_2;
  Element mElement_SHORT_3;
  Element mElement_SHORT_4;
  Element mElement_TYPE;
  Element mElement_U16;
  Element mElement_U32;
  Element mElement_U64;
  Element mElement_U8;
  Element mElement_UCHAR_2;
  Element mElement_UCHAR_3;
  Element mElement_UCHAR_4;
  Element mElement_UINT_2;
  Element mElement_UINT_3;
  Element mElement_UINT_4;
  Element mElement_ULONG_2;
  Element mElement_ULONG_3;
  Element mElement_ULONG_4;
  Element mElement_USHORT_2;
  Element mElement_USHORT_3;
  Element mElement_USHORT_4;
  private boolean mEnableMultiInput = false;
  RSErrorHandler mErrorCallback = null;
  long mIncCon;
  boolean mIncLoaded;
  private boolean mIsProcessContext = false;
  RSMessageHandler mMessageCallback = null;
  MessageThread mMessageThread;
  private String mNativeLibDir;
  ReentrantReadWriteLock mRWLock;
  Sampler mSampler_CLAMP_LINEAR;
  Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
  Sampler mSampler_CLAMP_NEAREST;
  Sampler mSampler_MIRRORED_REPEAT_LINEAR;
  Sampler mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
  Sampler mSampler_MIRRORED_REPEAT_NEAREST;
  Sampler mSampler_WRAP_LINEAR;
  Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
  Sampler mSampler_WRAP_NEAREST;

  static
  {
    mBlackList = "";
  }

  RenderScript(Context paramContext)
  {
    if (paramContext != null)
    {
      this.mApplicationContext = paramContext.getApplicationContext();
      this.mNativeLibDir = this.mApplicationContext.getApplicationInfo().nativeLibraryDir;
    }
    this.mIncCon = 0L;
    this.mIncLoaded = false;
    this.mRWLock = new ReentrantReadWriteLock();
  }

  public static RenderScript create(Context paramContext)
  {
    return create(paramContext, ContextType.NORMAL);
  }

  public static RenderScript create(Context paramContext, int paramInt)
  {
    return create(paramContext, paramInt, ContextType.NORMAL, 0);
  }

  public static RenderScript create(Context paramContext, int paramInt, ContextType paramContextType)
  {
    return create(paramContext, paramInt, paramContextType, 0);
  }

  public static RenderScript create(Context paramContext, int paramInt1, ContextType paramContextType, int paramInt2)
  {
    synchronized (mProcessContextList)
    {
      Iterator localIterator = mProcessContextList.iterator();
      while (localIterator.hasNext())
      {
        RenderScript localRenderScript2 = (RenderScript)localIterator.next();
        if ((localRenderScript2.mContextType == paramContextType) && (localRenderScript2.mContextFlags == paramInt2) && (localRenderScript2.mContextSdkVersion == paramInt1))
          return localRenderScript2;
      }
      RenderScript localRenderScript1 = internalCreate(paramContext, paramInt1, paramContextType, paramInt2);
      localRenderScript1.mIsProcessContext = true;
      mProcessContextList.add(localRenderScript1);
      return localRenderScript1;
    }
  }

  public static RenderScript create(Context paramContext, ContextType paramContextType)
  {
    return create(paramContext, paramContextType, 0);
  }

  public static RenderScript create(Context paramContext, ContextType paramContextType, int paramInt)
  {
    return create(paramContext, paramContext.getApplicationInfo().targetSdkVersion, paramContextType, paramInt);
  }

  public static RenderScript createMultiContext(Context paramContext, ContextType paramContextType, int paramInt1, int paramInt2)
  {
    return internalCreate(paramContext, paramInt2, paramContextType, paramInt1);
  }

  public static void forceCompat()
  {
    sNative = 0;
  }

  public static int getPointerSize()
  {
    synchronized (lock)
    {
      if (!sInitialized)
        throw new RSInvalidStateException("Calling getPointerSize() before any RenderScript instantiated");
    }
    return sPointerSize;
  }

  // ERROR //
  private void helpDestroy()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 163	android/support/v8/renderscript/RenderScript:mDestroyed	Z
    //   8: ifne +122 -> 130
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 163	android/support/v8/renderscript/RenderScript:mDestroyed	Z
    //   16: iconst_1
    //   17: istore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_3
    //   21: ifeq +108 -> 129
    //   24: aload_0
    //   25: invokevirtual 261	android/support/v8/renderscript/RenderScript:nContextFinish	()V
    //   28: aload_0
    //   29: getfield 195	android/support/v8/renderscript/RenderScript:mIncCon	J
    //   32: lconst_0
    //   33: lcmp
    //   34: ifeq +16 -> 50
    //   37: aload_0
    //   38: invokevirtual 264	android/support/v8/renderscript/RenderScript:nIncContextFinish	()V
    //   41: aload_0
    //   42: invokevirtual 267	android/support/v8/renderscript/RenderScript:nIncContextDestroy	()V
    //   45: aload_0
    //   46: lconst_0
    //   47: putfield 195	android/support/v8/renderscript/RenderScript:mIncCon	J
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 269	android/support/v8/renderscript/RenderScript:mContext	J
    //   55: invokevirtual 273	android/support/v8/renderscript/RenderScript:nContextDeinitToClient	(J)V
    //   58: aload_0
    //   59: getfield 275	android/support/v8/renderscript/RenderScript:mMessageThread	Landroid/support/v8/renderscript/RenderScript$MessageThread;
    //   62: iconst_0
    //   63: putfield 280	android/support/v8/renderscript/RenderScript$MessageThread:mRun	Z
    //   66: aload_0
    //   67: getfield 275	android/support/v8/renderscript/RenderScript:mMessageThread	Landroid/support/v8/renderscript/RenderScript$MessageThread;
    //   70: invokevirtual 283	android/support/v8/renderscript/RenderScript$MessageThread:interrupt	()V
    //   73: iconst_0
    //   74: istore 4
    //   76: iload 4
    //   78: ifne +28 -> 106
    //   81: aload_0
    //   82: getfield 275	android/support/v8/renderscript/RenderScript:mMessageThread	Landroid/support/v8/renderscript/RenderScript$MessageThread;
    //   85: invokevirtual 286	android/support/v8/renderscript/RenderScript$MessageThread:join	()V
    //   88: iconst_1
    //   89: istore 4
    //   91: goto -15 -> 76
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    //   99: astore 6
    //   101: iconst_1
    //   102: istore_1
    //   103: goto -27 -> 76
    //   106: iload_1
    //   107: ifeq +18 -> 125
    //   110: ldc 17
    //   112: ldc_w 288
    //   115: invokestatic 294	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   118: pop
    //   119: invokestatic 300	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   122: invokevirtual 301	java/lang/Thread:interrupt	()V
    //   125: aload_0
    //   126: invokevirtual 304	android/support/v8/renderscript/RenderScript:nContextDestroy	()V
    //   129: return
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -114 -> 18
    //
    // Exception table:
    //   from	to	target	type
    //   4	16	94	finally
    //   18	20	94	finally
    //   95	97	94	finally
    //   81	88	99	java/lang/InterruptedException
  }

  // ERROR //
  private static RenderScript internalCreate(Context paramContext, int paramInt1, ContextType paramContextType, int paramInt2)
  {
    // Byte code:
    //   0: new 2	android/support/v8/renderscript/RenderScript
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 310	android/support/v8/renderscript/RenderScript:<init>	(Landroid/content/Context;)V
    //   8: astore 4
    //   10: getstatic 148	android/support/v8/renderscript/RenderScript:sSdkVersion	I
    //   13: iconst_m1
    //   14: if_icmpne +361 -> 375
    //   17: iload_1
    //   18: putstatic 148	android/support/v8/renderscript/RenderScript:sSdkVersion	I
    //   21: getstatic 148	android/support/v8/renderscript/RenderScript:sSdkVersion	I
    //   24: aload_0
    //   25: invokestatic 314	android/support/v8/renderscript/RenderScript:setupNative	(ILandroid/content/Context;)Z
    //   28: putstatic 316	android/support/v8/renderscript/RenderScript:useNative	Z
    //   31: getstatic 144	android/support/v8/renderscript/RenderScript:lock	Ljava/lang/Object;
    //   34: astore 5
    //   36: aload 5
    //   38: monitorenter
    //   39: getstatic 246	android/support/v8/renderscript/RenderScript:sInitialized	Z
    //   42: istore 7
    //   44: iload 7
    //   46: ifne +143 -> 189
    //   49: ldc_w 318
    //   52: invokestatic 324	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   55: astore 26
    //   57: aload 26
    //   59: ldc_w 326
    //   62: iconst_0
    //   63: anewarray 320	java/lang/Class
    //   66: invokevirtual 330	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   69: aconst_null
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokevirtual 336	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   77: putstatic 338	android/support/v8/renderscript/RenderScript:sRuntime	Ljava/lang/Object;
    //   80: iconst_1
    //   81: anewarray 320	java/lang/Class
    //   84: astore 27
    //   86: aload 27
    //   88: iconst_0
    //   89: getstatic 344	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   92: aastore
    //   93: aload 26
    //   95: ldc_w 345
    //   98: aload 27
    //   100: invokevirtual 330	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   103: putstatic 347	android/support/v8/renderscript/RenderScript:registerNativeAllocation	Ljava/lang/reflect/Method;
    //   106: iconst_1
    //   107: anewarray 320	java/lang/Class
    //   110: astore 28
    //   112: aload 28
    //   114: iconst_0
    //   115: getstatic 344	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   118: aastore
    //   119: aload 26
    //   121: ldc_w 348
    //   124: aload 28
    //   126: invokevirtual 330	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   129: putstatic 350	android/support/v8/renderscript/RenderScript:registerNativeFree	Ljava/lang/reflect/Method;
    //   132: iconst_1
    //   133: putstatic 352	android/support/v8/renderscript/RenderScript:sUseGCHooks	Z
    //   136: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   139: bipush 23
    //   141: if_icmpge +278 -> 419
    //   144: aload 4
    //   146: getfield 193	android/support/v8/renderscript/RenderScript:mNativeLibDir	Ljava/lang/String;
    //   149: ifnull +270 -> 419
    //   152: new 359	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   159: aload 4
    //   161: getfield 193	android/support/v8/renderscript/RenderScript:mNativeLibDir	Ljava/lang/String;
    //   164: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 366
    //   170: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 375	java/lang/System:load	(Ljava/lang/String;)V
    //   179: iconst_1
    //   180: putstatic 246	android/support/v8/renderscript/RenderScript:sInitialized	Z
    //   183: invokestatic 378	android/support/v8/renderscript/RenderScript:rsnSystemGetPointerSize	()I
    //   186: putstatic 255	android/support/v8/renderscript/RenderScript:sPointerSize	I
    //   189: aload 5
    //   191: monitorexit
    //   192: getstatic 316	android/support/v8/renderscript/RenderScript:useNative	Z
    //   195: ifeq +303 -> 498
    //   198: ldc 17
    //   200: ldc_w 380
    //   203: invokestatic 294	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   206: pop
    //   207: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   210: bipush 14
    //   212: if_icmplt +7 -> 219
    //   215: iconst_1
    //   216: putstatic 150	android/support/v8/renderscript/RenderScript:useIOlib	Z
    //   219: iload_1
    //   220: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   223: if_icmpge +574 -> 797
    //   226: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   229: istore 9
    //   231: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   234: istore 10
    //   236: aconst_null
    //   237: astore 11
    //   239: iload 10
    //   241: bipush 23
    //   243: if_icmpge +44 -> 287
    //   246: aload 4
    //   248: getfield 193	android/support/v8/renderscript/RenderScript:mNativeLibDir	Ljava/lang/String;
    //   251: astore 20
    //   253: aconst_null
    //   254: astore 11
    //   256: aload 20
    //   258: ifnull +29 -> 287
    //   261: new 359	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   268: aload 4
    //   270: getfield 193	android/support/v8/renderscript/RenderScript:mNativeLibDir	Ljava/lang/String;
    //   273: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc_w 382
    //   279: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: astore 11
    //   287: aload 4
    //   289: getstatic 316	android/support/v8/renderscript/RenderScript:useNative	Z
    //   292: iload 9
    //   294: aload 11
    //   296: invokevirtual 386	android/support/v8/renderscript/RenderScript:nLoadSO	(ZILjava/lang/String;)Z
    //   299: ifne +302 -> 601
    //   302: getstatic 316	android/support/v8/renderscript/RenderScript:useNative	Z
    //   305: ifeq +16 -> 321
    //   308: ldc 17
    //   310: ldc_w 388
    //   313: invokestatic 294	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   316: pop
    //   317: iconst_0
    //   318: putstatic 316	android/support/v8/renderscript/RenderScript:useNative	Z
    //   321: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   324: bipush 23
    //   326: if_icmpge +184 -> 510
    //   329: aload 4
    //   331: getfield 193	android/support/v8/renderscript/RenderScript:mNativeLibDir	Ljava/lang/String;
    //   334: ifnull +176 -> 510
    //   337: aload 11
    //   339: invokestatic 375	java/lang/System:load	(Ljava/lang/String;)V
    //   342: aload 4
    //   344: iconst_0
    //   345: iload 9
    //   347: aload 11
    //   349: invokevirtual 386	android/support/v8/renderscript/RenderScript:nLoadSO	(ZILjava/lang/String;)Z
    //   352: ifne +249 -> 601
    //   355: ldc 17
    //   357: ldc_w 390
    //   360: invokestatic 393	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   363: pop
    //   364: new 395	android/support/v8/renderscript/RSRuntimeException
    //   367: dup
    //   368: ldc_w 397
    //   371: invokespecial 398	android/support/v8/renderscript/RSRuntimeException:<init>	(Ljava/lang/String;)V
    //   374: athrow
    //   375: getstatic 148	android/support/v8/renderscript/RenderScript:sSdkVersion	I
    //   378: iload_1
    //   379: if_icmpeq -358 -> 21
    //   382: new 395	android/support/v8/renderscript/RSRuntimeException
    //   385: dup
    //   386: ldc_w 400
    //   389: invokespecial 398	android/support/v8/renderscript/RSRuntimeException:<init>	(Ljava/lang/String;)V
    //   392: athrow
    //   393: astore 22
    //   395: ldc 17
    //   397: ldc_w 402
    //   400: invokestatic 393	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   403: pop
    //   404: iconst_0
    //   405: putstatic 352	android/support/v8/renderscript/RenderScript:sUseGCHooks	Z
    //   408: goto -272 -> 136
    //   411: astore 6
    //   413: aload 5
    //   415: monitorexit
    //   416: aload 6
    //   418: athrow
    //   419: ldc_w 404
    //   422: invokestatic 407	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   425: goto -246 -> 179
    //   428: astore 24
    //   430: ldc 17
    //   432: new 359	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 409
    //   442: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 24
    //   447: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 393	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   456: pop
    //   457: new 395	android/support/v8/renderscript/RSRuntimeException
    //   460: dup
    //   461: new 359	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   468: ldc_w 409
    //   471: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload 24
    //   476: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   479: ldc_w 414
    //   482: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: sipush 2301
    //   488: invokevirtual 417	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokespecial 398	android/support/v8/renderscript/RSRuntimeException:<init>	(Ljava/lang/String;)V
    //   497: athrow
    //   498: ldc 17
    //   500: ldc_w 419
    //   503: invokestatic 294	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   506: pop
    //   507: goto -300 -> 207
    //   510: ldc_w 421
    //   513: invokestatic 407	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   516: goto -174 -> 342
    //   519: astore 16
    //   521: ldc 17
    //   523: new 359	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 423
    //   533: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 16
    //   538: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   541: ldc_w 425
    //   544: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: sipush 2301
    //   550: invokevirtual 417	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   553: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 393	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   559: pop
    //   560: new 395	android/support/v8/renderscript/RSRuntimeException
    //   563: dup
    //   564: new 359	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 423
    //   574: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 16
    //   579: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   582: ldc_w 425
    //   585: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: sipush 2301
    //   591: invokevirtual 417	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokespecial 398	android/support/v8/renderscript/RSRuntimeException:<init>	(Ljava/lang/String;)V
    //   600: athrow
    //   601: getstatic 150	android/support/v8/renderscript/RenderScript:useIOlib	Z
    //   604: ifeq +36 -> 640
    //   607: ldc_w 427
    //   610: invokestatic 407	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   613: getstatic 150	android/support/v8/renderscript/RenderScript:useIOlib	Z
    //   616: ifeq +11 -> 627
    //   619: aload 4
    //   621: invokevirtual 430	android/support/v8/renderscript/RenderScript:nLoadIOSO	()Z
    //   624: ifne +16 -> 640
    //   627: ldc 17
    //   629: ldc_w 432
    //   632: invokestatic 294	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   635: pop
    //   636: iconst_0
    //   637: putstatic 150	android/support/v8/renderscript/RenderScript:useIOlib	Z
    //   640: iload 9
    //   642: bipush 23
    //   644: if_icmplt +15 -> 659
    //   647: aload 4
    //   649: iconst_1
    //   650: putfield 155	android/support/v8/renderscript/RenderScript:mEnableMultiInput	Z
    //   653: ldc_w 434
    //   656: invokestatic 407	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   659: aload 4
    //   661: aload 4
    //   663: aload 4
    //   665: invokevirtual 438	android/support/v8/renderscript/RenderScript:nDeviceCreate	()J
    //   668: iconst_0
    //   669: iload_1
    //   670: aload_2
    //   671: getfield 441	android/support/v8/renderscript/RenderScript$ContextType:mID	I
    //   674: aload 4
    //   676: getfield 193	android/support/v8/renderscript/RenderScript:mNativeLibDir	Ljava/lang/String;
    //   679: invokevirtual 445	android/support/v8/renderscript/RenderScript:nContextCreate	(JIIILjava/lang/String;)J
    //   682: putfield 269	android/support/v8/renderscript/RenderScript:mContext	J
    //   685: aload 4
    //   687: aload_2
    //   688: putfield 174	android/support/v8/renderscript/RenderScript:mContextType	Landroid/support/v8/renderscript/RenderScript$ContextType;
    //   691: aload 4
    //   693: iload_3
    //   694: putfield 159	android/support/v8/renderscript/RenderScript:mContextFlags	I
    //   697: aload 4
    //   699: iload_1
    //   700: putfield 161	android/support/v8/renderscript/RenderScript:mContextSdkVersion	I
    //   703: aload 4
    //   705: iload 9
    //   707: putfield 157	android/support/v8/renderscript/RenderScript:mDispatchAPILevel	I
    //   710: aload 4
    //   712: getfield 269	android/support/v8/renderscript/RenderScript:mContext	J
    //   715: lconst_0
    //   716: lcmp
    //   717: ifne +55 -> 772
    //   720: new 447	android/support/v8/renderscript/RSDriverException
    //   723: dup
    //   724: ldc_w 449
    //   727: invokespecial 450	android/support/v8/renderscript/RSDriverException:<init>	(Ljava/lang/String;)V
    //   730: athrow
    //   731: astore 14
    //   733: iconst_0
    //   734: putstatic 150	android/support/v8/renderscript/RenderScript:useIOlib	Z
    //   737: goto -124 -> 613
    //   740: astore 12
    //   742: ldc 17
    //   744: new 359	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   751: ldc_w 452
    //   754: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload 12
    //   759: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 294	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   768: pop
    //   769: goto -110 -> 659
    //   772: aload 4
    //   774: new 277	android/support/v8/renderscript/RenderScript$MessageThread
    //   777: dup
    //   778: aload 4
    //   780: invokespecial 455	android/support/v8/renderscript/RenderScript$MessageThread:<init>	(Landroid/support/v8/renderscript/RenderScript;)V
    //   783: putfield 275	android/support/v8/renderscript/RenderScript:mMessageThread	Landroid/support/v8/renderscript/RenderScript$MessageThread;
    //   786: aload 4
    //   788: getfield 275	android/support/v8/renderscript/RenderScript:mMessageThread	Landroid/support/v8/renderscript/RenderScript$MessageThread;
    //   791: invokevirtual 458	android/support/v8/renderscript/RenderScript$MessageThread:start	()V
    //   794: aload 4
    //   796: areturn
    //   797: iload_1
    //   798: istore 9
    //   800: goto -569 -> 231
    //
    // Exception table:
    //   from	to	target	type
    //   49	136	393	java/lang/Exception
    //   39	44	411	finally
    //   49	136	411	finally
    //   136	179	411	finally
    //   179	189	411	finally
    //   189	192	411	finally
    //   395	408	411	finally
    //   413	416	411	finally
    //   419	425	411	finally
    //   430	498	411	finally
    //   136	179	428	java/lang/UnsatisfiedLinkError
    //   179	189	428	java/lang/UnsatisfiedLinkError
    //   419	425	428	java/lang/UnsatisfiedLinkError
    //   321	342	519	java/lang/UnsatisfiedLinkError
    //   510	516	519	java/lang/UnsatisfiedLinkError
    //   607	613	731	java/lang/UnsatisfiedLinkError
    //   653	659	740	java/lang/UnsatisfiedLinkError
  }

  public static void releaseAllContexts()
  {
    ArrayList localArrayList2;
    synchronized (mProcessContextList)
    {
      localArrayList2 = mProcessContextList;
      mProcessContextList = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      if (localIterator.hasNext())
      {
        RenderScript localRenderScript = (RenderScript)localIterator.next();
        localRenderScript.mIsProcessContext = false;
        localRenderScript.destroy();
      }
    }
    localArrayList2.clear();
  }

  static native int rsnSystemGetPointerSize();

  public static void setBlackList(String paramString)
  {
    if (paramString != null)
      mBlackList = paramString;
  }

  public static void setupDiskCache(File paramFile)
  {
    File localFile = new File(paramFile, "com.android.renderscript.cache");
    mCachePath = localFile.getAbsolutePath();
    localFile.mkdirs();
  }

  // ERROR //
  private static boolean setupNative(int paramInt, Context paramContext)
  {
    // Byte code:
    //   0: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   3: iload_0
    //   4: if_icmpge +15 -> 19
    //   7: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   10: bipush 21
    //   12: if_icmpge +7 -> 19
    //   15: iconst_0
    //   16: putstatic 146	android/support/v8/renderscript/RenderScript:sNative	I
    //   19: getstatic 146	android/support/v8/renderscript/RenderScript:sNative	I
    //   22: iconst_m1
    //   23: if_icmpne +228 -> 251
    //   26: ldc_w 485
    //   29: invokestatic 324	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   32: astore 12
    //   34: iconst_2
    //   35: anewarray 320	java/lang/Class
    //   38: astore 13
    //   40: aload 13
    //   42: iconst_0
    //   43: ldc_w 487
    //   46: aastore
    //   47: aload 13
    //   49: iconst_1
    //   50: getstatic 344	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   53: aastore
    //   54: aload 12
    //   56: ldc_w 489
    //   59: aload 13
    //   61: invokevirtual 330	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   64: astore 14
    //   66: iconst_2
    //   67: anewarray 4	java/lang/Object
    //   70: astore 15
    //   72: aload 15
    //   74: iconst_0
    //   75: ldc_w 491
    //   78: aastore
    //   79: aload 15
    //   81: iconst_1
    //   82: new 340	java/lang/Integer
    //   85: dup
    //   86: iconst_0
    //   87: invokespecial 494	java/lang/Integer:<init>	(I)V
    //   90: aastore
    //   91: aload 14
    //   93: aconst_null
    //   94: aload 15
    //   96: invokevirtual 336	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   99: checkcast 340	java/lang/Integer
    //   102: invokevirtual 497	java/lang/Integer:intValue	()I
    //   105: istore 16
    //   107: iload 16
    //   109: istore 4
    //   111: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   114: bipush 19
    //   116: if_icmplt +223 -> 339
    //   119: iload 4
    //   121: ifne +218 -> 339
    //   124: iconst_1
    //   125: putstatic 146	android/support/v8/renderscript/RenderScript:sNative	I
    //   128: getstatic 146	android/support/v8/renderscript/RenderScript:sNative	I
    //   131: iconst_1
    //   132: if_icmpne +119 -> 251
    //   135: aload_1
    //   136: invokevirtual 501	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   139: aload_1
    //   140: invokevirtual 504	android/content/Context:getPackageName	()Ljava/lang/String;
    //   143: sipush 128
    //   146: invokevirtual 509	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   149: astore 6
    //   151: lconst_0
    //   152: lstore 7
    //   154: ldc_w 511
    //   157: invokestatic 324	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   160: ldc_w 513
    //   163: iconst_0
    //   164: anewarray 320	java/lang/Class
    //   167: invokevirtual 330	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   170: aconst_null
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokevirtual 336	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   178: checkcast 515	java/lang/Long
    //   181: invokevirtual 518	java/lang/Long:longValue	()J
    //   184: lstore 10
    //   186: lload 10
    //   188: lstore 7
    //   190: aload 6
    //   192: getfield 522	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   195: ifnull +56 -> 251
    //   198: aload 6
    //   200: getfield 522	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   203: ldc_w 524
    //   206: invokevirtual 530	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   209: iconst_1
    //   210: if_icmpne +14 -> 224
    //   213: lload 7
    //   215: lconst_0
    //   216: lcmp
    //   217: ifne +7 -> 224
    //   220: iconst_0
    //   221: putstatic 146	android/support/v8/renderscript/RenderScript:sNative	I
    //   224: aload 6
    //   226: getfield 522	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   229: ldc_w 532
    //   232: invokevirtual 530	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   235: iconst_1
    //   236: if_icmpne +15 -> 251
    //   239: getstatic 357	android/os/Build$VERSION:SDK_INT	I
    //   242: bipush 19
    //   244: if_icmpgt +7 -> 251
    //   247: iconst_0
    //   248: putstatic 146	android/support/v8/renderscript/RenderScript:sNative	I
    //   251: getstatic 146	android/support/v8/renderscript/RenderScript:sNative	I
    //   254: iconst_1
    //   255: if_icmpne +75 -> 330
    //   258: getstatic 141	android/support/v8/renderscript/RenderScript:mBlackList	Ljava/lang/String;
    //   261: invokevirtual 535	java/lang/String:length	()I
    //   264: ifle +86 -> 350
    //   267: new 359	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   274: bipush 40
    //   276: invokevirtual 538	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   279: getstatic 543	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   282: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: bipush 58
    //   287: invokevirtual 538	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   290: getstatic 546	android/os/Build:PRODUCT	Ljava/lang/String;
    //   293: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: bipush 58
    //   298: invokevirtual 538	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   301: getstatic 549	android/os/Build:MODEL	Ljava/lang/String;
    //   304: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: bipush 41
    //   309: invokevirtual 538	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   312: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: astore_2
    //   316: getstatic 141	android/support/v8/renderscript/RenderScript:mBlackList	Ljava/lang/String;
    //   319: aload_2
    //   320: invokevirtual 553	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   323: ifeq +27 -> 350
    //   326: iconst_0
    //   327: putstatic 146	android/support/v8/renderscript/RenderScript:sNative	I
    //   330: iconst_0
    //   331: ireturn
    //   332: astore_3
    //   333: iconst_0
    //   334: istore 4
    //   336: goto -225 -> 111
    //   339: iconst_0
    //   340: putstatic 146	android/support/v8/renderscript/RenderScript:sNative	I
    //   343: goto -215 -> 128
    //   346: astore 5
    //   348: iconst_1
    //   349: ireturn
    //   350: iconst_1
    //   351: ireturn
    //   352: astore 9
    //   354: goto -164 -> 190
    //
    // Exception table:
    //   from	to	target	type
    //   26	107	332	java/lang/Exception
    //   135	151	346	android/content/pm/PackageManager$NameNotFoundException
    //   154	186	352	java/lang/Exception
  }

  public void contextDump()
  {
    validate();
    nContextDump(0);
  }

  public void destroy()
  {
    if (this.mIsProcessContext)
      return;
    validate();
    helpDestroy();
  }

  protected void finalize()
    throws Throwable
  {
    helpDestroy();
    super.finalize();
  }

  public void finish()
  {
    nContextFinish();
  }

  public final Context getApplicationContext()
  {
    return this.mApplicationContext;
  }

  int getDispatchAPILevel()
  {
    return this.mDispatchAPILevel;
  }

  public RSErrorHandler getErrorHandler()
  {
    return this.mErrorCallback;
  }

  public RSMessageHandler getMessageHandler()
  {
    return this.mMessageCallback;
  }

  boolean isAlive()
  {
    return this.mContext != 0L;
  }

  boolean isUseNative()
  {
    return useNative;
  }

  void nAllocationCopyFromBitmap(long paramLong, Bitmap paramBitmap)
  {
    try
    {
      validate();
      rsnAllocationCopyFromBitmap(this.mContext, paramLong, paramBitmap);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationCopyToBitmap(long paramLong, Bitmap paramBitmap)
  {
    try
    {
      validate();
      rsnAllocationCopyToBitmap(this.mContext, paramLong, paramBitmap);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nAllocationCreateBitmapBackedAllocation(long paramLong, int paramInt1, Bitmap paramBitmap, int paramInt2)
  {
    try
    {
      validate();
      long l = rsnAllocationCreateBitmapBackedAllocation(this.mContext, paramLong, paramInt1, paramBitmap, paramInt2);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nAllocationCreateBitmapRef(long paramLong, Bitmap paramBitmap)
  {
    try
    {
      validate();
      long l = rsnAllocationCreateBitmapRef(this.mContext, paramLong, paramBitmap);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nAllocationCreateFromAssetStream(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      long l = rsnAllocationCreateFromAssetStream(this.mContext, paramInt1, paramInt2, paramInt3);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nAllocationCreateFromBitmap(long paramLong, int paramInt1, Bitmap paramBitmap, int paramInt2)
  {
    try
    {
      validate();
      long l = rsnAllocationCreateFromBitmap(this.mContext, paramLong, paramInt1, paramBitmap, paramInt2);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nAllocationCreateTyped(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    try
    {
      validate();
      long l = rsnAllocationCreateTyped(this.mContext, paramLong1, paramInt1, paramInt2, paramLong2);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nAllocationCubeCreateFromBitmap(long paramLong, int paramInt1, Bitmap paramBitmap, int paramInt2)
  {
    try
    {
      validate();
      long l = rsnAllocationCubeCreateFromBitmap(this.mContext, paramLong, paramInt1, paramBitmap, paramInt2);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationData1D(long paramLong, int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4, Element.DataType paramDataType, int paramInt5, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnAllocationData1D(this.mContext, paramLong, paramInt1, paramInt2, paramInt3, paramObject, paramInt4, paramDataType.mID, paramInt5, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationData2D(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    try
    {
      validate();
      rsnAllocationData2D(this.mContext, paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong2, paramInt7, paramInt8, paramInt9, paramInt10);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationData2D(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject, int paramInt7, Element.DataType paramDataType, int paramInt8, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnAllocationData2D(this.mContext, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramObject, paramInt7, paramDataType.mID, paramInt8, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationData2D(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    try
    {
      validate();
      rsnAllocationData2D(this.mContext, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBitmap);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationData3D(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    try
    {
      validate();
      rsnAllocationData3D(this.mContext, paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong2, paramInt8, paramInt9, paramInt10, paramInt11);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationData3D(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Object paramObject, int paramInt8, Element.DataType paramDataType, int paramInt9, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnAllocationData3D(this.mContext, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramObject, paramInt8, paramDataType.mID, paramInt9, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationElementData1D(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    try
    {
      validate();
      rsnAllocationElementData1D(this.mContext, paramLong, paramInt1, paramInt2, paramInt3, paramArrayOfByte, paramInt4);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationGenerateMipmaps(long paramLong)
  {
    try
    {
      validate();
      rsnAllocationGenerateMipmaps(this.mContext, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  ByteBuffer nAllocationGetByteBuffer(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      ByteBuffer localByteBuffer = rsnAllocationGetByteBuffer(this.mContext, paramLong, paramInt1, paramInt2, paramInt3);
      return localByteBuffer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nAllocationGetStride(long paramLong)
  {
    try
    {
      validate();
      long l = rsnAllocationGetStride(this.mContext, paramLong);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nAllocationGetType(long paramLong)
  {
    try
    {
      validate();
      long l = rsnAllocationGetType(this.mContext, paramLong);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationIoReceive(long paramLong)
  {
    try
    {
      validate();
      rsnAllocationIoReceive(this.mContext, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationIoSend(long paramLong)
  {
    try
    {
      validate();
      rsnAllocationIoSend(this.mContext, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationRead(long paramLong, Object paramObject, Element.DataType paramDataType, int paramInt, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnAllocationRead(this.mContext, paramLong, paramObject, paramDataType.mID, paramInt, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationRead1D(long paramLong, int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4, Element.DataType paramDataType, int paramInt5, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnAllocationRead1D(this.mContext, paramLong, paramInt1, paramInt2, paramInt3, paramObject, paramInt4, paramDataType.mID, paramInt5, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationRead2D(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject, int paramInt7, Element.DataType paramDataType, int paramInt8, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnAllocationRead2D(this.mContext, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramObject, paramInt7, paramDataType.mID, paramInt8, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationResize1D(long paramLong, int paramInt)
  {
    try
    {
      validate();
      rsnAllocationResize1D(this.mContext, paramLong, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationResize2D(long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      validate();
      rsnAllocationResize2D(this.mContext, paramLong, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationSetSurface(long paramLong, Surface paramSurface)
  {
    try
    {
      validate();
      rsnAllocationSetSurface(this.mContext, paramLong, paramSurface);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nAllocationSyncAll(long paramLong, int paramInt)
  {
    try
    {
      validate();
      rsnAllocationSyncAll(this.mContext, paramLong, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nClosureCreate(long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, int[] paramArrayOfInt, long[] paramArrayOfLong3, long[] paramArrayOfLong4)
  {
    long l;
    try
    {
      validate();
      l = rsnClosureCreate(this.mContext, paramLong1, paramLong2, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfInt, paramArrayOfLong3, paramArrayOfLong4);
      if (l == 0L)
        throw new RSRuntimeException("Failed creating closure.");
    }
    finally
    {
    }
    return l;
  }

  void nClosureSetArg(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    try
    {
      validate();
      rsnClosureSetArg(this.mContext, paramLong1, paramInt1, paramLong2, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nClosureSetGlobal(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    try
    {
      validate();
      rsnClosureSetGlobal(this.mContext, paramLong1, paramLong2, paramLong3, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nContextCreate(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      long l = rsnContextCreate(paramLong, paramInt1, paramInt2, paramInt3, paramString);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  native void nContextDeinitToClient(long paramLong);

  void nContextDestroy()
  {
    try
    {
      validate();
      ReentrantReadWriteLock.WriteLock localWriteLock = this.mRWLock.writeLock();
      localWriteLock.lock();
      long l = this.mContext;
      this.mContext = 0L;
      localWriteLock.unlock();
      rsnContextDestroy(l);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nContextDump(int paramInt)
  {
    try
    {
      validate();
      rsnContextDump(this.mContext, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nContextFinish()
  {
    try
    {
      validate();
      rsnContextFinish(this.mContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  native String nContextGetErrorMessage(long paramLong);

  native int nContextGetUserMessage(long paramLong, int[] paramArrayOfInt);

  native void nContextInitToClient(long paramLong);

  native int nContextPeekMessage(long paramLong, int[] paramArrayOfInt);

  void nContextSendMessage(int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      rsnContextSendMessage(this.mContext, paramInt, paramArrayOfInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nContextSetPriority(int paramInt)
  {
    try
    {
      validate();
      rsnContextSetPriority(this.mContext, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  native long nDeviceCreate();

  native void nDeviceDestroy(long paramLong);

  native void nDeviceSetConfig(long paramLong, int paramInt1, int paramInt2);

  long nElementCreate(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    try
    {
      validate();
      long l = rsnElementCreate(this.mContext, paramLong, paramInt1, paramBoolean, paramInt2);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nElementCreate2(long[] paramArrayOfLong, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      long l = rsnElementCreate2(this.mContext, paramArrayOfLong, paramArrayOfString, paramArrayOfInt);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nElementGetNativeData(long paramLong, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      rsnElementGetNativeData(this.mContext, paramLong, paramArrayOfInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nElementGetSubElements(long paramLong, long[] paramArrayOfLong, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      rsnElementGetSubElements(this.mContext, paramLong, paramArrayOfLong, paramArrayOfString, paramArrayOfInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nIncAllocationCreateTyped(long paramLong1, long paramLong2, int paramInt)
  {
    try
    {
      validate();
      long l = rsnIncAllocationCreateTyped(this.mContext, this.mIncCon, paramLong1, paramLong2, paramInt);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nIncContextCreate(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      long l = rsnIncContextCreate(paramLong, paramInt1, paramInt2, paramInt3);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nIncContextDestroy()
  {
    try
    {
      validate();
      ReentrantReadWriteLock.WriteLock localWriteLock = this.mRWLock.writeLock();
      localWriteLock.lock();
      long l = this.mIncCon;
      this.mIncCon = 0L;
      localWriteLock.unlock();
      rsnIncContextDestroy(l);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nIncContextFinish()
  {
    try
    {
      validate();
      rsnIncContextFinish(this.mIncCon);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  native long nIncDeviceCreate();

  native void nIncDeviceDestroy(long paramLong);

  long nIncElementCreate(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    try
    {
      validate();
      long l = rsnIncElementCreate(this.mIncCon, paramLong, paramInt1, paramBoolean, paramInt2);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  native boolean nIncLoadSO(int paramInt, String paramString);

  void nIncObjDestroy(long paramLong)
  {
    if (this.mIncCon != 0L)
      rsnIncObjDestroy(this.mIncCon, paramLong);
  }

  long nIncTypeCreate(long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    try
    {
      validate();
      long l = rsnIncTypeCreate(this.mIncCon, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nInvokeClosureCreate(long paramLong, byte[] paramArrayOfByte, long[] paramArrayOfLong1, long[] paramArrayOfLong2, int[] paramArrayOfInt)
  {
    long l;
    try
    {
      validate();
      l = rsnInvokeClosureCreate(this.mContext, paramLong, paramArrayOfByte, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfInt);
      if (l == 0L)
        throw new RSRuntimeException("Failed creating closure.");
    }
    finally
    {
    }
    return l;
  }

  native boolean nLoadIOSO();

  native boolean nLoadSO(boolean paramBoolean, int paramInt, String paramString);

  void nObjDestroy(long paramLong)
  {
    if (this.mContext != 0L)
      rsnObjDestroy(this.mContext, paramLong);
  }

  long nSamplerCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    try
    {
      validate();
      long l = rsnSamplerCreate(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptBindAllocation(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptBindAllocation(l, paramLong1, paramLong2, paramInt, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  long nScriptCCreate(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      validate();
      long l = rsnScriptCCreate(this.mContext, paramString1, paramString2, paramArrayOfByte, paramInt);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nScriptFieldIDCreate(long paramLong, int paramInt, boolean paramBoolean)
  {
    try
    {
      validate();
      long l1 = this.mContext;
      if (paramBoolean)
        l1 = this.mIncCon;
      long l2 = rsnScriptFieldIDCreate(l1, paramLong, paramInt, paramBoolean);
      return l2;
    }
    finally
    {
    }
  }

  void nScriptForEach(long paramLong1, int paramInt, long paramLong2, long paramLong3, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      validate();
      if (paramArrayOfByte == null)
        rsnScriptForEach(this.mContext, this.mIncCon, paramLong1, paramInt, paramLong2, paramLong3, paramBoolean);
      while (true)
      {
        return;
        rsnScriptForEach(this.mContext, this.mIncCon, paramLong1, paramInt, paramLong2, paramLong3, paramArrayOfByte, paramBoolean);
      }
    }
    finally
    {
    }
  }

  void nScriptForEach(long paramLong1, int paramInt, long[] paramArrayOfLong, long paramLong2, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    try
    {
      if (!this.mEnableMultiInput)
      {
        Log.e("RenderScript_jni", "Multi-input kernels are not supported, please change targetSdkVersion to >= 23");
        throw new RSRuntimeException("Multi-input kernels are not supported before API 23)");
      }
    }
    finally
    {
    }
    validate();
    rsnScriptForEach(this.mContext, paramLong1, paramInt, paramArrayOfLong, paramLong2, paramArrayOfByte, paramArrayOfInt);
  }

  void nScriptForEachClipped(long paramLong1, int paramInt1, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    try
    {
      validate();
      if (paramArrayOfByte == null)
        rsnScriptForEachClipped(this.mContext, this.mIncCon, paramLong1, paramInt1, paramLong2, paramLong3, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean);
      while (true)
      {
        return;
        rsnScriptForEachClipped(this.mContext, this.mIncCon, paramLong1, paramInt1, paramLong2, paramLong3, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean);
      }
    }
    finally
    {
    }
  }

  long nScriptGroup2Create(String paramString1, String paramString2, long[] paramArrayOfLong)
  {
    try
    {
      validate();
      long l = rsnScriptGroup2Create(this.mContext, paramString1, paramString2, paramArrayOfLong);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptGroup2Execute(long paramLong)
  {
    try
    {
      validate();
      rsnScriptGroup2Execute(this.mContext, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nScriptGroupCreate(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, long[] paramArrayOfLong5)
  {
    try
    {
      validate();
      long l = rsnScriptGroupCreate(this.mContext, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfLong3, paramArrayOfLong4, paramArrayOfLong5);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptGroupExecute(long paramLong)
  {
    try
    {
      validate();
      rsnScriptGroupExecute(this.mContext, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptGroupSetInput(long paramLong1, long paramLong2, long paramLong3)
  {
    try
    {
      validate();
      rsnScriptGroupSetInput(this.mContext, paramLong1, paramLong2, paramLong3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptGroupSetOutput(long paramLong1, long paramLong2, long paramLong3)
  {
    try
    {
      validate();
      rsnScriptGroupSetOutput(this.mContext, paramLong1, paramLong2, paramLong3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptIntrinsicBLAS_BNNM(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, long paramLong3, int paramInt5, long paramLong4, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnScriptIntrinsicBLAS_BNNM(this.mContext, this.mIncCon, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramInt4, paramLong3, paramInt5, paramLong4, paramInt6, paramInt7, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptIntrinsicBLAS_Complex(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat1, float paramFloat2, long paramLong2, long paramLong3, float paramFloat3, float paramFloat4, long paramLong4, int paramInt10, int paramInt11, int paramInt12, int paramInt13, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnScriptIntrinsicBLAS_Complex(this.mContext, this.mIncCon, paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat1, paramFloat2, paramLong2, paramLong3, paramFloat3, paramFloat4, paramLong4, paramInt10, paramInt11, paramInt12, paramInt13, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptIntrinsicBLAS_Double(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, double paramDouble1, long paramLong2, long paramLong3, double paramDouble2, long paramLong4, int paramInt10, int paramInt11, int paramInt12, int paramInt13, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnScriptIntrinsicBLAS_Double(this.mContext, this.mIncCon, paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramDouble1, paramLong2, paramLong3, paramDouble2, paramLong4, paramInt10, paramInt11, paramInt12, paramInt13, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptIntrinsicBLAS_Single(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat1, long paramLong2, long paramLong3, float paramFloat2, long paramLong4, int paramInt10, int paramInt11, int paramInt12, int paramInt13, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnScriptIntrinsicBLAS_Single(this.mContext, this.mIncCon, paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat1, paramLong2, paramLong3, paramFloat2, paramLong4, paramInt10, paramInt11, paramInt12, paramInt13, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptIntrinsicBLAS_Z(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, double paramDouble1, double paramDouble2, long paramLong2, long paramLong3, double paramDouble3, double paramDouble4, long paramLong4, int paramInt10, int paramInt11, int paramInt12, int paramInt13, boolean paramBoolean)
  {
    try
    {
      validate();
      rsnScriptIntrinsicBLAS_Z(this.mContext, this.mIncCon, paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramDouble1, paramDouble2, paramLong2, paramLong3, paramDouble3, paramDouble4, paramLong4, paramInt10, paramInt11, paramInt12, paramInt13, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long nScriptIntrinsicCreate(int paramInt, long paramLong, boolean paramBoolean)
  {
    try
    {
      validate();
      if (!paramBoolean)
        break label216;
      if (Build.VERSION.SDK_INT < 21)
      {
        Log.e("RenderScript_jni", "Incremental Intrinsics are not supported, please change targetSdkVersion to >= 21");
        throw new RSRuntimeException("Incremental Intrinsics are not supported before Lollipop (API 21)");
      }
    }
    finally
    {
    }
    boolean bool = this.mIncLoaded;
    if (!bool)
    {
      try
      {
        System.loadLibrary("RSSupport");
        if (!nIncLoadSO(23, this.mNativeLibDir + "/libRSSupport.so"))
          throw new RSRuntimeException("Error loading libRSSupport library for Incremental Intrinsic Support");
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        Log.e("RenderScript_jni", "Error loading RS Compat library for Incremental Intrinsic Support: " + localUnsatisfiedLinkError);
        throw new RSRuntimeException("Error loading RS Compat library for Incremental Intrinsic Support: " + localUnsatisfiedLinkError);
      }
      this.mIncLoaded = true;
    }
    if (this.mIncCon == 0L)
      this.mIncCon = nIncContextCreate(nIncDeviceCreate(), 0, 0, 0);
    long l1 = rsnScriptIntrinsicCreate(this.mIncCon, paramInt, paramLong, paramBoolean);
    label216: long l3;
    for (long l2 = l1; ; l2 = l3)
    {
      return l2;
      l3 = rsnScriptIntrinsicCreate(this.mContext, paramInt, paramLong, paramBoolean);
    }
  }

  void nScriptInvoke(long paramLong, int paramInt, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptInvoke(l, paramLong, paramInt, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  long nScriptInvokeIDCreate(long paramLong, int paramInt)
  {
    try
    {
      validate();
      long l = rsnScriptInvokeIDCreate(this.mContext, paramLong, paramInt);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptInvokeV(long paramLong, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptInvokeV(l, paramLong, paramInt, paramArrayOfByte, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  long nScriptKernelIDCreate(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      validate();
      long l1 = this.mContext;
      if (paramBoolean)
        l1 = this.mIncCon;
      long l2 = rsnScriptKernelIDCreate(l1, paramLong, paramInt1, paramInt2, paramBoolean);
      return l2;
    }
    finally
    {
    }
  }

  void nScriptReduce(long paramLong1, int paramInt, long[] paramArrayOfLong, long paramLong2, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      rsnScriptReduce(this.mContext, paramLong1, paramInt, paramArrayOfLong, paramLong2, paramArrayOfInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nScriptSetTimeZone(long paramLong, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptSetTimeZone(l, paramLong, paramArrayOfByte, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  void nScriptSetVarD(long paramLong, int paramInt, double paramDouble, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptSetVarD(l, paramLong, paramInt, paramDouble, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  void nScriptSetVarF(long paramLong, int paramInt, float paramFloat, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptSetVarF(l, paramLong, paramInt, paramFloat, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  void nScriptSetVarI(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptSetVarI(l, paramLong, paramInt1, paramInt2, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  void nScriptSetVarJ(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptSetVarJ(l, paramLong1, paramInt, paramLong2, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  void nScriptSetVarObj(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptSetVarObj(l, paramLong1, paramInt, paramLong2, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  void nScriptSetVarV(long paramLong, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptSetVarV(l, paramLong, paramInt, paramArrayOfByte, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  void nScriptSetVarVE(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    try
    {
      validate();
      long l = this.mContext;
      if (paramBoolean)
        l = this.mIncCon;
      rsnScriptSetVarVE(l, paramLong1, paramInt, paramArrayOfByte, paramLong2, paramArrayOfInt, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  long nTypeCreate(long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    try
    {
      validate();
      long l = rsnTypeCreate(this.mContext, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void nTypeGetNativeData(long paramLong, long[] paramArrayOfLong)
  {
    try
    {
      validate();
      rsnTypeGetNativeData(this.mContext, paramLong, paramArrayOfLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  native void rsnAllocationCopyFromBitmap(long paramLong1, long paramLong2, Bitmap paramBitmap);

  native void rsnAllocationCopyToBitmap(long paramLong1, long paramLong2, Bitmap paramBitmap);

  native long rsnAllocationCreateBitmapBackedAllocation(long paramLong1, long paramLong2, int paramInt1, Bitmap paramBitmap, int paramInt2);

  native long rsnAllocationCreateBitmapRef(long paramLong1, long paramLong2, Bitmap paramBitmap);

  native long rsnAllocationCreateFromAssetStream(long paramLong, int paramInt1, int paramInt2, int paramInt3);

  native long rsnAllocationCreateFromBitmap(long paramLong1, long paramLong2, int paramInt1, Bitmap paramBitmap, int paramInt2);

  native long rsnAllocationCreateTyped(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);

  native long rsnAllocationCubeCreateFromBitmap(long paramLong1, long paramLong2, int paramInt1, Bitmap paramBitmap, int paramInt2);

  native void rsnAllocationData1D(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean);

  native void rsnAllocationData2D(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong3, int paramInt7, int paramInt8, int paramInt9, int paramInt10);

  native void rsnAllocationData2D(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean);

  native void rsnAllocationData2D(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap);

  native void rsnAllocationData3D(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong3, int paramInt8, int paramInt9, int paramInt10, int paramInt11);

  native void rsnAllocationData3D(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Object paramObject, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean);

  native void rsnAllocationElementData1D(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4);

  native void rsnAllocationGenerateMipmaps(long paramLong1, long paramLong2);

  native ByteBuffer rsnAllocationGetByteBuffer(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);

  native long rsnAllocationGetStride(long paramLong1, long paramLong2);

  native long rsnAllocationGetType(long paramLong1, long paramLong2);

  native void rsnAllocationIoReceive(long paramLong1, long paramLong2);

  native void rsnAllocationIoSend(long paramLong1, long paramLong2);

  native void rsnAllocationRead(long paramLong1, long paramLong2, Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean);

  native void rsnAllocationRead1D(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean);

  native void rsnAllocationRead2D(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean);

  native void rsnAllocationResize1D(long paramLong1, long paramLong2, int paramInt);

  native void rsnAllocationResize2D(long paramLong1, long paramLong2, int paramInt1, int paramInt2);

  native void rsnAllocationSetSurface(long paramLong1, long paramLong2, Surface paramSurface);

  native void rsnAllocationSyncAll(long paramLong1, long paramLong2, int paramInt);

  native long rsnClosureCreate(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong1, long[] paramArrayOfLong2, int[] paramArrayOfInt, long[] paramArrayOfLong3, long[] paramArrayOfLong4);

  native void rsnClosureSetArg(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2);

  native void rsnClosureSetGlobal(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);

  native long rsnContextCreate(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);

  native void rsnContextDestroy(long paramLong);

  native void rsnContextDump(long paramLong, int paramInt);

  native void rsnContextFinish(long paramLong);

  native void rsnContextSendMessage(long paramLong, int paramInt, int[] paramArrayOfInt);

  native void rsnContextSetPriority(long paramLong, int paramInt);

  native long rsnElementCreate(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, int paramInt2);

  native long rsnElementCreate2(long paramLong, long[] paramArrayOfLong, String[] paramArrayOfString, int[] paramArrayOfInt);

  native void rsnElementGetNativeData(long paramLong1, long paramLong2, int[] paramArrayOfInt);

  native void rsnElementGetSubElements(long paramLong1, long paramLong2, long[] paramArrayOfLong, String[] paramArrayOfString, int[] paramArrayOfInt);

  native long rsnIncAllocationCreateTyped(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);

  native long rsnIncContextCreate(long paramLong, int paramInt1, int paramInt2, int paramInt3);

  native void rsnIncContextDestroy(long paramLong);

  native void rsnIncContextFinish(long paramLong);

  native long rsnIncElementCreate(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, int paramInt2);

  native void rsnIncObjDestroy(long paramLong1, long paramLong2);

  native long rsnIncTypeCreate(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4);

  native long rsnInvokeClosureCreate(long paramLong1, long paramLong2, byte[] paramArrayOfByte, long[] paramArrayOfLong1, long[] paramArrayOfLong2, int[] paramArrayOfInt);

  native void rsnObjDestroy(long paramLong1, long paramLong2);

  native long rsnSamplerCreate(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat);

  native void rsnScriptBindAllocation(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean);

  native long rsnScriptCCreate(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt);

  native long rsnScriptFieldIDCreate(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);

  native void rsnScriptForEach(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOfLong, long paramLong3, byte[] paramArrayOfByte, int[] paramArrayOfInt);

  native void rsnScriptForEach(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, boolean paramBoolean);

  native void rsnScriptForEach(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, byte[] paramArrayOfByte, boolean paramBoolean);

  native void rsnScriptForEachClipped(long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, long paramLong5, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean);

  native void rsnScriptForEachClipped(long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, long paramLong5, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean);

  native long rsnScriptGroup2Create(long paramLong, String paramString1, String paramString2, long[] paramArrayOfLong);

  native void rsnScriptGroup2Execute(long paramLong1, long paramLong2);

  native long rsnScriptGroupCreate(long paramLong, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, long[] paramArrayOfLong5);

  native void rsnScriptGroupExecute(long paramLong1, long paramLong2);

  native void rsnScriptGroupSetInput(long paramLong1, long paramLong2, long paramLong3, long paramLong4);

  native void rsnScriptGroupSetOutput(long paramLong1, long paramLong2, long paramLong3, long paramLong4);

  native void rsnScriptIntrinsicBLAS_BNNM(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, long paramLong4, int paramInt4, long paramLong5, int paramInt5, long paramLong6, int paramInt6, int paramInt7, boolean paramBoolean);

  native void rsnScriptIntrinsicBLAS_Complex(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat1, float paramFloat2, long paramLong4, long paramLong5, float paramFloat3, float paramFloat4, long paramLong6, int paramInt10, int paramInt11, int paramInt12, int paramInt13, boolean paramBoolean);

  native void rsnScriptIntrinsicBLAS_Double(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, double paramDouble1, long paramLong4, long paramLong5, double paramDouble2, long paramLong6, int paramInt10, int paramInt11, int paramInt12, int paramInt13, boolean paramBoolean);

  native void rsnScriptIntrinsicBLAS_Single(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat1, long paramLong4, long paramLong5, float paramFloat2, long paramLong6, int paramInt10, int paramInt11, int paramInt12, int paramInt13, boolean paramBoolean);

  native void rsnScriptIntrinsicBLAS_Z(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, double paramDouble1, double paramDouble2, long paramLong4, long paramLong5, double paramDouble3, double paramDouble4, long paramLong6, int paramInt10, int paramInt11, int paramInt12, int paramInt13, boolean paramBoolean);

  native long rsnScriptIntrinsicCreate(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean);

  native void rsnScriptInvoke(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);

  native long rsnScriptInvokeIDCreate(long paramLong1, long paramLong2, int paramInt);

  native void rsnScriptInvokeV(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean);

  native long rsnScriptKernelIDCreate(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean);

  native void rsnScriptReduce(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOfLong, long paramLong3, int[] paramArrayOfInt);

  native void rsnScriptSetTimeZone(long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean);

  native void rsnScriptSetVarD(long paramLong1, long paramLong2, int paramInt, double paramDouble, boolean paramBoolean);

  native void rsnScriptSetVarF(long paramLong1, long paramLong2, int paramInt, float paramFloat, boolean paramBoolean);

  native void rsnScriptSetVarI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean);

  native void rsnScriptSetVarJ(long paramLong1, long paramLong2, int paramInt, long paramLong3, boolean paramBoolean);

  native void rsnScriptSetVarObj(long paramLong1, long paramLong2, int paramInt, long paramLong3, boolean paramBoolean);

  native void rsnScriptSetVarV(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean);

  native void rsnScriptSetVarVE(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte, long paramLong3, int[] paramArrayOfInt, boolean paramBoolean);

  native long rsnTypeCreate(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4);

  native void rsnTypeGetNativeData(long paramLong1, long paramLong2, long[] paramArrayOfLong);

  long safeID(BaseObj paramBaseObj)
  {
    if (paramBaseObj != null)
      return paramBaseObj.getID(this);
    return 0L;
  }

  public void sendMessage(int paramInt, int[] paramArrayOfInt)
  {
    nContextSendMessage(paramInt, paramArrayOfInt);
  }

  public void setErrorHandler(RSErrorHandler paramRSErrorHandler)
  {
    this.mErrorCallback = paramRSErrorHandler;
  }

  public void setMessageHandler(RSMessageHandler paramRSMessageHandler)
  {
    this.mMessageCallback = paramRSMessageHandler;
  }

  public void setPriority(Priority paramPriority)
  {
    validate();
    nContextSetPriority(paramPriority.mID);
  }

  boolean usingIO()
  {
    return useIOlib;
  }

  void validate()
  {
    if (this.mContext == 0L)
      throw new RSInvalidStateException("Calling RS with no Context active.");
  }

  void validateObject(BaseObj paramBaseObj)
  {
    if ((paramBaseObj != null) && (paramBaseObj.mRS != this))
      throw new RSIllegalArgumentException("Attempting to use an object across contexts.");
  }

  public static enum ContextType
  {
    int mID;

    static
    {
      DEBUG = new ContextType("DEBUG", 1, 1);
      PROFILE = new ContextType("PROFILE", 2, 2);
      ContextType[] arrayOfContextType = new ContextType[3];
      arrayOfContextType[0] = NORMAL;
      arrayOfContextType[1] = DEBUG;
      arrayOfContextType[2] = PROFILE;
    }

    private ContextType(int paramInt)
    {
      this.mID = paramInt;
    }
  }

  static class MessageThread extends Thread
  {
    static final int RS_ERROR_FATAL_DEBUG = 2048;
    static final int RS_ERROR_FATAL_UNKNOWN = 4096;
    static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
    static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
    static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
    static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
    static final int RS_MESSAGE_TO_CLIENT_USER = 4;
    int[] mAuxData = new int[2];
    RenderScript mRS;
    boolean mRun = true;

    MessageThread(RenderScript paramRenderScript)
    {
      super();
      this.mRS = paramRenderScript;
    }

    public void run()
    {
      int[] arrayOfInt = new int[16];
      this.mRS.nContextInitToClient(this.mRS.mContext);
      while (this.mRun)
      {
        arrayOfInt[0] = 0;
        int i = this.mRS.nContextPeekMessage(this.mRS.mContext, this.mAuxData);
        int j = this.mAuxData[1];
        int k = this.mAuxData[0];
        if (i == 4)
        {
          if (j >> 2 >= arrayOfInt.length)
            arrayOfInt = new int[j + 3 >> 2];
          if (this.mRS.nContextGetUserMessage(this.mRS.mContext, arrayOfInt) != 4)
            throw new RSDriverException("Error processing message from RenderScript.");
          if (this.mRS.mMessageCallback != null)
          {
            this.mRS.mMessageCallback.mData = arrayOfInt;
            this.mRS.mMessageCallback.mID = k;
            this.mRS.mMessageCallback.mLength = j;
            this.mRS.mMessageCallback.run();
          }
          else
          {
            throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
          }
        }
        else if (i == 3)
        {
          String str = this.mRS.nContextGetErrorMessage(this.mRS.mContext);
          if ((k >= 4096) || ((k >= 2048) && ((this.mRS.mContextType != RenderScript.ContextType.DEBUG) || (this.mRS.mErrorCallback == null))))
          {
            Log.e("RenderScript_jni", "fatal RS error, " + str);
            throw new RSRuntimeException("Fatal error " + k + ", details: " + str);
          }
          if (this.mRS.mErrorCallback != null)
          {
            this.mRS.mErrorCallback.mErrorMessage = str;
            this.mRS.mErrorCallback.mErrorNum = k;
            this.mRS.mErrorCallback.run();
          }
          else
          {
            Log.e("RenderScript_jni", "non fatal RS error, " + str);
          }
        }
        else
        {
          try
          {
            sleep(1L, 0);
          }
          catch (InterruptedException localInterruptedException)
          {
          }
        }
      }
    }
  }

  public static enum Priority
  {
    int mID;

    static
    {
      Priority[] arrayOfPriority = new Priority[2];
      arrayOfPriority[0] = LOW;
      arrayOfPriority[1] = NORMAL;
    }

    private Priority(int paramInt)
    {
      this.mID = paramInt;
    }
  }

  public static class RSErrorHandler
    implements Runnable
  {
    protected String mErrorMessage;
    protected int mErrorNum;

    public void run()
    {
    }
  }

  public static class RSMessageHandler
    implements Runnable
  {
    protected int[] mData;
    protected int mID;
    protected int mLength;

    public void run()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.RenderScript
 * JD-Core Version:    0.6.2
 */