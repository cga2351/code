package android.support.v8.renderscript;

import android.content.Context;
import android.content.res.Resources;
import java.io.File;

public class ScriptC extends Script
{
  private static final String TAG = "ScriptC";

  protected ScriptC(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  protected ScriptC(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    super(0L, paramRenderScript);
    long l = internalCreate(paramRenderScript, paramResources, paramInt);
    if (l == 0L)
      throw new RSRuntimeException("Loading of ScriptC script failed.");
    setID(l);
  }

  protected ScriptC(RenderScript paramRenderScript, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(0L, paramRenderScript);
    if (RenderScript.sPointerSize == 4);
    for (long l = internalStringCreate(paramRenderScript, paramString, paramArrayOfByte1); l == 0L; l = internalStringCreate(paramRenderScript, paramString, paramArrayOfByte2))
      throw new RSRuntimeException("Loading of ScriptC script failed.");
    setID(l);
  }

  // ERROR //
  private static long internalCreate(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: iload_2
    //   5: invokevirtual 47	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore 4
    //   10: sipush 1024
    //   13: newarray byte
    //   15: astore 7
    //   17: iconst_0
    //   18: istore 8
    //   20: aload 7
    //   22: arraylength
    //   23: iload 8
    //   25: isub
    //   26: istore 9
    //   28: iload 9
    //   30: ifne +126 -> 156
    //   33: iconst_2
    //   34: aload 7
    //   36: arraylength
    //   37: imul
    //   38: newarray byte
    //   40: astore 10
    //   42: aload 7
    //   44: iconst_0
    //   45: aload 10
    //   47: iconst_0
    //   48: aload 7
    //   50: arraylength
    //   51: invokestatic 53	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   54: aload 10
    //   56: arraylength
    //   57: iload 8
    //   59: isub
    //   60: istore 9
    //   62: aload 4
    //   64: aload 10
    //   66: iload 8
    //   68: iload 9
    //   70: invokevirtual 59	java/io/InputStream:read	([BII)I
    //   73: istore 11
    //   75: iload 11
    //   77: ifgt +39 -> 116
    //   80: aload 4
    //   82: invokevirtual 63	java/io/InputStream:close	()V
    //   85: aload_0
    //   86: aload_1
    //   87: iload_2
    //   88: invokevirtual 67	android/content/res/Resources:getResourceEntryName	(I)Ljava/lang/String;
    //   91: aload_0
    //   92: invokevirtual 71	android/support/v8/renderscript/RenderScript:getApplicationContext	()Landroid/content/Context;
    //   95: invokevirtual 77	android/content/Context:getCacheDir	()Ljava/io/File;
    //   98: invokevirtual 83	java/io/File:toString	()Ljava/lang/String;
    //   101: aload 10
    //   103: iload 8
    //   105: invokevirtual 87	android/support/v8/renderscript/RenderScript:nScriptCCreate	(Ljava/lang/String;Ljava/lang/String;[BI)J
    //   108: lstore 12
    //   110: ldc 2
    //   112: monitorexit
    //   113: lload 12
    //   115: lreturn
    //   116: iload 11
    //   118: iload 8
    //   120: iadd
    //   121: istore 8
    //   123: aload 10
    //   125: astore 7
    //   127: goto -107 -> 20
    //   130: astore 5
    //   132: aload 4
    //   134: invokevirtual 63	java/io/InputStream:close	()V
    //   137: aload 5
    //   139: athrow
    //   140: astore 6
    //   142: new 89	android/content/res/Resources$NotFoundException
    //   145: dup
    //   146: invokespecial 91	android/content/res/Resources$NotFoundException:<init>	()V
    //   149: athrow
    //   150: astore_3
    //   151: ldc 2
    //   153: monitorexit
    //   154: aload_3
    //   155: athrow
    //   156: aload 7
    //   158: astore 10
    //   160: goto -98 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   10	17	130	finally
    //   20	28	130	finally
    //   33	62	130	finally
    //   62	75	130	finally
    //   80	85	140	java/io/IOException
    //   132	140	140	java/io/IOException
    //   3	10	150	finally
    //   80	85	150	finally
    //   85	110	150	finally
    //   132	140	150	finally
    //   142	150	150	finally
  }

  private static long internalStringCreate(RenderScript paramRenderScript, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      long l = paramRenderScript.nScriptCCreate(paramString, paramRenderScript.getApplicationContext().getCacheDir().toString(), paramArrayOfByte, paramArrayOfByte.length);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptC
 * JD-Core Version:    0.6.2
 */