package org.webrtc.videoengine;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import org.webrtc.DefaultVideoDecoderFactory;
import org.webrtc.DefaultVideoEncoderFactory;
import org.webrtc.EglBase;
import org.webrtc.EglBase.Context;
import org.webrtc.SoftwareVideoDecoderFactory;
import org.webrtc.SoftwareVideoEncoderFactory;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoDecoderFactory;
import org.webrtc.VideoEncoderFactory;

public class ViberRTCWorkarounds
{
  private static final String[] ANDROID_VERSION_HW_DECODING_BLACKLIST;
  private static final boolean DEVICE_SAMSUNG_GALAXY_S4;
  private static final boolean DEVICE_SAMSUNG_NOTE_2;
  private static Boolean EGL_PARENT_CONTEXT_SUPPORT;
  private static final e L = ViberEnv.getLogger();
  private static final boolean TOO_OLD_FOR_CAPTURE_HW_ACCELERATION;

  static
  {
    EGL_PARENT_CONTEXT_SUPPORT = null;
    boolean bool1;
    boolean bool2;
    if (Build.VERSION.SDK_INT <= 18)
    {
      bool1 = true;
      TOO_OLD_FOR_CAPTURE_HW_ACCELERATION = bool1;
      if ((!Build.MODEL.equals("GT-N7100")) && (!Build.MODEL.equals("GT-N7105")))
        break label130;
      bool2 = true;
      label48: DEVICE_SAMSUNG_NOTE_2 = bool2;
      if ((!Build.MODEL.equals("GT-I9500")) && (!Build.MODEL.equals("GT-I9505")) && (!Build.MODEL.equals("GT-I9506")) && (!Build.MODEL.equals("GT-I9515")))
        break label135;
    }
    label130: label135: for (boolean bool3 = true; ; bool3 = false)
    {
      DEVICE_SAMSUNG_GALAXY_S4 = bool3;
      ANDROID_VERSION_HW_DECODING_BLACKLIST = new String[] { "5.0.1", "5.0.2", "5.1.1" };
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label48;
    }
  }

  public static boolean allowHWAcceleration()
  {
    checkInitialized();
    return (!TOO_OLD_FOR_CAPTURE_HW_ACCELERATION) && (parentContextSupported());
  }

  private static void checkInitialized()
  {
    if (EGL_PARENT_CONTEXT_SUPPORT == null)
      throw new IllegalStateException("initParentContextSupported must be invoked from UI thread, before usage of this class");
  }

  private static void checkOnMainThread()
  {
    if (Thread.currentThread() != av.e.a.a().getLooper().getThread())
      throw new IllegalStateException("must be invoked from UI thread");
  }

  // ERROR //
  private static boolean checkParentContextSupport()
  {
    // Byte code:
    //   0: invokestatic 129	org/webrtc/videoengine/ViberRTCWorkarounds:checkOnMainThread	()V
    //   3: getstatic 52	org/webrtc/videoengine/ViberRTCWorkarounds:DEVICE_SAMSUNG_NOTE_2	Z
    //   6: istore_0
    //   7: iconst_0
    //   8: istore_1
    //   9: iload_0
    //   10: ifeq +9 -> 19
    //   13: iload_1
    //   14: ifne +3 -> 17
    //   17: iload_1
    //   18: ireturn
    //   19: getstatic 62	org/webrtc/videoengine/ViberRTCWorkarounds:DEVICE_SAMSUNG_GALAXY_S4	Z
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_1
    //   25: iload_2
    //   26: ifne -13 -> 13
    //   29: new 131	org/webrtc/SurfaceViewRenderer
    //   32: dup
    //   33: invokestatic 137	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
    //   36: invokespecial 140	org/webrtc/SurfaceViewRenderer:<init>	(Landroid/content/Context;)V
    //   39: astore_3
    //   40: invokestatic 146	org/webrtc/EglBase$$CC:create$$STATIC$$	()Lorg/webrtc/EglBase;
    //   43: astore 4
    //   45: aload_3
    //   46: aload 4
    //   48: invokeinterface 152 1 0
    //   53: aconst_null
    //   54: invokevirtual 156	org/webrtc/SurfaceViewRenderer:init	(Lorg/webrtc/EglBase$Context;Lorg/webrtc/RendererCommon$RendererEvents;)V
    //   57: aload_3
    //   58: invokevirtual 159	org/webrtc/SurfaceViewRenderer:release	()V
    //   61: aload 4
    //   63: invokeinterface 160 1 0
    //   68: iconst_1
    //   69: istore_1
    //   70: goto -57 -> 13
    //   73: astore 6
    //   75: aload_3
    //   76: invokevirtual 159	org/webrtc/SurfaceViewRenderer:release	()V
    //   79: aload 4
    //   81: invokeinterface 160 1 0
    //   86: iconst_0
    //   87: istore_1
    //   88: goto -75 -> 13
    //   91: astore 5
    //   93: aload_3
    //   94: invokevirtual 159	org/webrtc/SurfaceViewRenderer:release	()V
    //   97: aload 4
    //   99: invokeinterface 160 1 0
    //   104: aload 5
    //   106: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   45	57	73	java/lang/RuntimeException
    //   45	57	91	finally
  }

  public static VideoDecoderFactory getDecoderFactory(EglBase paramEglBase)
  {
    if (allowHWAcceleration())
      return new DefaultVideoDecoderFactory(getEglBaseContext(paramEglBase));
    return new SoftwareVideoDecoderFactory();
  }

  public static EglBase.Context getEglBaseContext(EglBase paramEglBase)
  {
    checkInitialized();
    if (paramEglBase == null);
    while (!parentContextSupported())
      return null;
    return paramEglBase.getEglBaseContext();
  }

  public static VideoEncoderFactory getEncoderFactory(EglBase paramEglBase)
  {
    if (allowHWAcceleration())
      return new DefaultVideoEncoderFactory(getEglBaseContext(paramEglBase), true, true);
    return new SoftwareVideoEncoderFactory();
  }

  public static VideoDecoderFactory getVideoPttDecoderFactory(EglBase paramEglBase)
  {
    boolean bool = allowHWAcceleration();
    Object localObject = null;
    String str;
    String[] arrayOfString;
    int i;
    if (bool)
    {
      str = Build.VERSION.RELEASE;
      arrayOfString = ANDROID_VERSION_HW_DECODING_BLACKLIST;
      i = arrayOfString.length;
    }
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (str.startsWith(arrayOfString[j]))
          k = 1;
      }
      else
      {
        localObject = null;
        if (k == 0)
          localObject = new DefaultVideoDecoderFactory(getEglBaseContext(paramEglBase));
        if (localObject == null)
          localObject = new SoftwareVideoDecoderFactory();
        return localObject;
      }
    }
  }

  public static void initParentContextSupported()
  {
    try
    {
      Boolean localBoolean = EGL_PARENT_CONTEXT_SUPPORT;
      if (localBoolean != null);
      while (true)
      {
        return;
        invokeOnMainThread(new Runnable()
        {
          public void run()
          {
            if (ViberRTCWorkarounds.EGL_PARENT_CONTEXT_SUPPORT == null)
              ViberRTCWorkarounds.access$002(Boolean.valueOf(ViberRTCWorkarounds.access$100()));
          }
        });
      }
    }
    finally
    {
    }
  }

  private static void invokeOnMainThread(Runnable paramRunnable)
  {
    ThreadUtils.invokeAtFrontUninterruptibly(av.e.a.a(), paramRunnable);
  }

  private static boolean parentContextSupported()
  {
    checkInitialized();
    return (EGL_PARENT_CONTEXT_SUPPORT != null) && (EGL_PARENT_CONTEXT_SUPPORT.booleanValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.ViberRTCWorkarounds
 * JD-Core Version:    0.6.2
 */