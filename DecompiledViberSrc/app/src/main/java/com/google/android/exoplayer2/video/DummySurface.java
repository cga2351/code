package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.f;

@TargetApi(17)
public final class DummySurface extends Surface
{
  private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
  private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
  private static final String TAG = "DummySurface";
  private static int secureMode;
  private static boolean secureModeInitialized;
  public final boolean secure;
  private final a thread;
  private boolean threadReleased;

  private DummySurface(a parama, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    super(paramSurfaceTexture);
    this.thread = parama;
    this.secure = paramBoolean;
  }

  private static void assertApiLevel17OrHigher()
  {
    if (ag.a < 17)
      throw new UnsupportedOperationException("Unsupported prior to API level 17");
  }

  @TargetApi(24)
  private static int getSecureModeV24(Context paramContext)
  {
    if ((ag.a < 26) && (("samsung".equals(ag.c)) || ("XT1650".equals(ag.d))));
    String str;
    do
    {
      do
        return 0;
      while ((ag.a < 26) && (!paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")));
      str = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
    }
    while ((str == null) || (!str.contains("EGL_EXT_protected_content")));
    if (str.contains("EGL_KHR_surfaceless_context"))
      return 1;
    return 2;
  }

  public static boolean isSecureSupported(Context paramContext)
  {
    boolean bool = true;
    try
    {
      int j;
      if (!secureModeInitialized)
      {
        if (ag.a < 24)
        {
          j = 0;
          secureMode = j;
          secureModeInitialized = true;
        }
      }
      else
      {
        int i = secureMode;
        if (i == 0)
          break label57;
      }
      while (true)
      {
        return bool;
        int k = getSecureModeV24(paramContext);
        j = k;
        break;
        label57: bool = false;
      }
    }
    finally
    {
    }
  }

  public static DummySurface newInstanceV17(Context paramContext, boolean paramBoolean)
  {
    assertApiLevel17OrHigher();
    if ((!paramBoolean) || (isSecureSupported(paramContext)));
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      a locala = new a();
      int i = 0;
      if (paramBoolean)
        i = secureMode;
      return locala.a(i);
    }
  }

  public void release()
  {
    super.release();
    synchronized (this.thread)
    {
      if (!this.threadReleased)
      {
        this.thread.a();
        this.threadReleased = true;
      }
      return;
    }
  }

  private static class a extends HandlerThread
    implements Handler.Callback
  {
    private f a;
    private Handler b;
    private Error c;
    private RuntimeException d;
    private DummySurface e;

    public a()
    {
      super();
    }

    private void b()
    {
      a.a(this.a);
      this.a.a();
    }

    private void b(int paramInt)
    {
      a.a(this.a);
      this.a.a(paramInt);
      SurfaceTexture localSurfaceTexture = this.a.b();
      if (paramInt != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.e = new DummySurface(this, localSurfaceTexture, bool, null);
        return;
      }
    }

    public DummySurface a(int paramInt)
    {
      int i = 0;
      start();
      this.b = new Handler(getLooper(), this);
      this.a = new f(this.b);
      try
      {
        this.b.obtainMessage(1, paramInt, 0).sendToTarget();
        while ((this.e == null) && (this.d == null))
        {
          Error localError = this.c;
          if (localError != null)
            break;
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            i = 1;
          }
        }
        if (i != 0)
          Thread.currentThread().interrupt();
        if (this.d != null)
          throw this.d;
      }
      finally
      {
      }
      if (this.c != null)
        throw this.c;
      return (DummySurface)a.a(this.e);
    }

    public void a()
    {
      a.a(this.b);
      this.b.sendEmptyMessage(2);
    }

    // ERROR //
    public boolean handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 110	android/os/Message:what	I
      //   4: tableswitch	default:+24 -> 28, 1:+26->30, 2:+139->143
      //   29: ireturn
      //   30: aload_0
      //   31: aload_1
      //   32: getfield 113	android/os/Message:arg1	I
      //   35: invokespecial 115	com/google/android/exoplayer2/video/DummySurface$a:b	(I)V
      //   38: aload_0
      //   39: monitorenter
      //   40: aload_0
      //   41: invokevirtual 118	java/lang/Object:notify	()V
      //   44: aload_0
      //   45: monitorexit
      //   46: iconst_1
      //   47: ireturn
      //   48: astore 13
      //   50: aload_0
      //   51: monitorexit
      //   52: aload 13
      //   54: athrow
      //   55: astore 11
      //   57: ldc 120
      //   59: ldc 122
      //   61: aload 11
      //   63: invokestatic 127	com/google/android/exoplayer2/g/l:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   66: aload_0
      //   67: aload 11
      //   69: putfield 78	com/google/android/exoplayer2/video/DummySurface$a:d	Ljava/lang/RuntimeException;
      //   72: aload_0
      //   73: monitorenter
      //   74: aload_0
      //   75: invokevirtual 118	java/lang/Object:notify	()V
      //   78: aload_0
      //   79: monitorexit
      //   80: iconst_1
      //   81: ireturn
      //   82: astore 12
      //   84: aload_0
      //   85: monitorexit
      //   86: aload 12
      //   88: athrow
      //   89: astore 9
      //   91: ldc 120
      //   93: ldc 122
      //   95: aload 9
      //   97: invokestatic 127	com/google/android/exoplayer2/g/l:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   100: aload_0
      //   101: aload 9
      //   103: putfield 80	com/google/android/exoplayer2/video/DummySurface$a:c	Ljava/lang/Error;
      //   106: aload_0
      //   107: monitorenter
      //   108: aload_0
      //   109: invokevirtual 118	java/lang/Object:notify	()V
      //   112: aload_0
      //   113: monitorexit
      //   114: iconst_1
      //   115: ireturn
      //   116: astore 10
      //   118: aload_0
      //   119: monitorexit
      //   120: aload 10
      //   122: athrow
      //   123: astore 7
      //   125: aload_0
      //   126: monitorenter
      //   127: aload_0
      //   128: invokevirtual 118	java/lang/Object:notify	()V
      //   131: aload_0
      //   132: monitorexit
      //   133: aload 7
      //   135: athrow
      //   136: astore 8
      //   138: aload_0
      //   139: monitorexit
      //   140: aload 8
      //   142: athrow
      //   143: aload_0
      //   144: invokespecial 129	com/google/android/exoplayer2/video/DummySurface$a:b	()V
      //   147: aload_0
      //   148: invokevirtual 133	com/google/android/exoplayer2/video/DummySurface$a:quit	()Z
      //   151: pop
      //   152: iconst_1
      //   153: ireturn
      //   154: astore 4
      //   156: ldc 120
      //   158: ldc 135
      //   160: aload 4
      //   162: invokestatic 127	com/google/android/exoplayer2/g/l:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   165: aload_0
      //   166: invokevirtual 133	com/google/android/exoplayer2/video/DummySurface$a:quit	()Z
      //   169: pop
      //   170: iconst_1
      //   171: ireturn
      //   172: astore_2
      //   173: aload_0
      //   174: invokevirtual 133	com/google/android/exoplayer2/video/DummySurface$a:quit	()Z
      //   177: pop
      //   178: aload_2
      //   179: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   40	46	48	finally
      //   50	52	48	finally
      //   30	38	55	java/lang/RuntimeException
      //   74	80	82	finally
      //   84	86	82	finally
      //   30	38	89	java/lang/Error
      //   108	114	116	finally
      //   118	120	116	finally
      //   30	38	123	finally
      //   57	72	123	finally
      //   91	106	123	finally
      //   127	133	136	finally
      //   138	140	136	finally
      //   143	147	154	java/lang/Throwable
      //   143	147	172	finally
      //   156	165	172	finally
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface
 * JD-Core Version:    0.6.2
 */