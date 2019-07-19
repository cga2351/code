package com.viber.voip;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PhoneControllerReadyListener;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.jni.ptt.VideoPttControllerDelegate.VideoRecorder;
import com.viber.jni.ptt.VideoPttRecorderListener;
import com.viber.voip.util.an;
import com.viber.voip.util.bn;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class av
{
  private static final Logger a = ViberEnv.getLogger();
  private static a b = a.a;
  private static final int c = an.c();
  private static final int d;
  private static final c[] e;
  private static final Handler[] f;

  static
  {
    if (c > 2);
    for (int i = -1 + c; ; i = c)
    {
      d = i;
      c[] arrayOfc1 = new c[11];
      arrayOfc1[0] = new c(e.a, 10, "TM:UIHandler");
      arrayOfc1[1] = new c(e.b, 5, -1, 1, "TM:serviceDispatcherHandler", true, true);
      arrayOfc1[2] = new c(e.c, 5, 0, 10, "TM:contactsHandler", true, true);
      arrayOfc1[3] = new c(e.d, 10, 0, 10, "TM:messagesHandler", true, true);
      arrayOfc1[4] = new c(e.e, 5, 19, 10, "TM:inCallTasksHandler", true, true);
      arrayOfc1[5] = new c(e.f, 5, 1, 19, "TM:idleTasksHandler", true, true);
      arrayOfc1[6] = new c(e.g, 1, 19, 19, "TM:lowPriorityHandler", true, true);
      arrayOfc1[7] = new c(e.h, 5, 1, 10, "TM:AsyncQueryWorker", true, true);
      arrayOfc1[8] = new c(e.i, 5, 10, 19, "TM:longTaskHandler", true, true);
      arrayOfc1[9] = new c(e.j, 5, 10, 19, "TM:backgroundsTaskHandler", true, true);
      arrayOfc1[10] = new c(e.k, 5, 10, 19, "TM:backupHandler", true, true);
      e = arrayOfc1;
      f = new Handler[e.length];
      for (c localc : e)
        f[localc.a.ordinal()] = b(localc.a);
    }
    ControllerListener.setDefaultHandler(e.b.a());
  }

  public static Handler a(e parame)
  {
    try
    {
      Handler localHandler = f[parame.ordinal()];
      return localHandler;
    }
    catch (Exception localException)
    {
    }
    return f[e.a.ordinal()];
  }

  public static a a()
  {
    return b;
  }

  public static void a(Engine paramEngine, boolean paramBoolean)
  {
    if (paramBoolean)
      b(a.b);
    DialerPhoneStateListener localDialerPhoneStateListener = paramEngine.getDelegatesManager().getDialerPhoneStateListener();
    DialerControllerDelegate.DialerPhoneState[] arrayOfDialerPhoneState = new DialerControllerDelegate.DialerPhoneState[1];
    arrayOfDialerPhoneState[0] = new b(null);
    localDialerPhoneStateListener.registerDelegate(arrayOfDialerPhoneState);
    VideoPttRecorderListener localVideoPttRecorderListener = paramEngine.getDelegatesManager().getVideoPttRecorderListener();
    VideoPttControllerDelegate.VideoRecorder[] arrayOfVideoRecorder = new VideoPttControllerDelegate.VideoRecorder[1];
    arrayOfVideoRecorder[0] = new g(null);
    localVideoPttRecorderListener.registerDelegate(arrayOfVideoRecorder);
    paramEngine.addReadyListener(new PhoneControllerReadyListener()
    {
      public void ready(PhoneController paramAnonymousPhoneController)
      {
        av.a(av.a.a);
      }
    });
  }

  private static Handler b(e parame)
  {
    c[] arrayOfc = e;
    int i = arrayOfc.length;
    int j = 0;
    c localc;
    if (j < i)
    {
      localc = arrayOfc[j];
      if (localc.a != parame);
    }
    while (true)
    {
      int k = 0;
      if (localc != null)
      {
        boolean bool = localc.d;
        k = 0;
        if (bool)
          k = 1;
      }
      if (k != 0)
      {
        d locald = new d(localc);
        locald.start();
        Looper localLooper = locald.getLooper();
        switch (2.a[parame.ordinal()])
        {
        default:
          return new ao(parame, localLooper);
          j++;
          break;
        case 1:
        case 2:
        case 3:
          return new Handler(localLooper);
        case 4:
          return new Handler(localLooper);
        case 5:
          return new aj(parame, localLooper);
        case 6:
          return new ao(parame, localLooper);
        }
      }
      return new Handler(Looper.getMainLooper());
      localc = null;
    }
  }

  private static ThreadFactory b(String paramString, int paramInt)
  {
    return new aw(paramString, paramInt);
  }

  public static void b()
  {
    for (int i = 0; i < f.length; i++)
      if ((f[i] != null) && (f[i].getLooper() != null) && (Looper.getMainLooper() != f[i].getLooper()))
      {
        f[i].removeCallbacksAndMessages(null);
        f[i].getLooper().quit();
      }
  }

  private static void b(a parama)
  {
    if (parama != b)
    {
      b = parama;
      int i = 0;
      if (i < f.length)
      {
        Handler localHandler = f[i];
        int j;
        label47: c localc;
        int n;
        if ((localHandler != null) && (localHandler.getLooper() != null))
        {
          if (parama == a.a)
            break label134;
          j = 1;
          if ((localHandler.getLooper().getThread() instanceof d))
          {
            localc = ((d)localHandler.getLooper().getThread()).a();
            if ((localc != null) && (localc.d))
            {
              int m = ((d)localHandler.getLooper().getThread()).b();
              if (j == 0)
                break label139;
              n = localc.g;
              label114: Process.setThreadPriority(m, n);
            }
          }
          if ((localHandler instanceof ao))
            break label149;
        }
        while (true)
        {
          i++;
          break;
          label134: j = 0;
          break label47;
          label139: n = localc.f;
          break label114;
          label149: if (localHandler.getLooper() != null)
          {
            int k;
            switch (2.b[parama.ordinal()])
            {
            default:
              k = 0;
            case 1:
            case 2:
            case 3:
            }
            while (true)
            {
              if (k == 0)
                break label296;
              ((ao)localHandler).a();
              break;
              if (e[i].a != e.d)
              {
                k = 1;
              }
              else
              {
                k = 0;
                continue;
                k = 1;
                continue;
                if ((e[i].a != e.g) && (e[i].a != e.c) && (e[i].a != e.d))
                  k = 1;
                else
                  k = 0;
              }
            }
            label296: ((ao)localHandler).b();
          }
        }
      }
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }

  private static class b
    implements DialerControllerDelegate.DialerPhoneState
  {
    public void onPhoneStateChanged(int paramInt)
    {
      switch (paramInt)
      {
      default:
        av.a(av.a.d);
        return;
      case 0:
      }
      av.a(av.a.a);
    }
  }

  private static class c
  {
    public final av.e a;
    public final int b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final int g;

    c(av.e parame, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = parame;
      this.b = paramInt1;
      this.c = paramString;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      this.f = paramInt2;
      this.g = paramInt3;
    }

    c(av.e parame, int paramInt, String paramString)
    {
      this(parame, paramInt, 0, 0, paramString, false, false);
    }
  }

  private static class d extends HandlerThread
  {
    private final av.c a;
    private volatile int b = -1;

    public d(av.c paramc)
    {
      super();
      this.a = paramc;
    }

    public final av.c a()
    {
      return this.a;
    }

    public final int b()
    {
      return this.b;
    }

    protected void onLooperPrepared()
    {
      super.onLooperPrepared();
    }

    public void run()
    {
      this.b = Process.myTid();
      Process.setThreadPriority(this.b, this.a.f);
      super.run();
    }

    public void start()
    {
      setDaemon(this.a.e);
      super.start();
    }
  }

  public static enum e
  {
    static
    {
      e[] arrayOfe = new e[11];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      arrayOfe[4] = e;
      arrayOfe[5] = f;
      arrayOfe[6] = g;
      arrayOfe[7] = h;
      arrayOfe[8] = i;
      arrayOfe[9] = j;
      arrayOfe[10] = k;
    }

    public Handler a()
    {
      return av.a(this);
    }
  }

  public static class f
  {
    public static final ScheduledExecutorService a;
    public static final ScheduledExecutorService b;
    public static final ExecutorService c;
    public static final ScheduledExecutorService d = localScheduledThreadPoolExecutor3;

    static
    {
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor1 = new ScheduledThreadPoolExecutor(7, av.a("IO pool", 5));
      localScheduledThreadPoolExecutor1.setKeepAliveTime(180L, TimeUnit.SECONDS);
      localScheduledThreadPoolExecutor1.allowCoreThreadTimeOut(true);
      a = localScheduledThreadPoolExecutor1;
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(av.c(), av.a("COMPUTATION pool", 5));
      localScheduledThreadPoolExecutor2.setKeepAliveTime(60L, TimeUnit.SECONDS);
      localScheduledThreadPoolExecutor2.allowCoreThreadTimeOut(true);
      b = localScheduledThreadPoolExecutor2;
      ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(av.d(), av.d(), 60L, TimeUnit.SECONDS, new bn(), av.a("LIFO_COMPUTATION pool", 5));
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
      c = localThreadPoolExecutor;
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor3 = new ScheduledThreadPoolExecutor(1, av.a("SINGLE low priority pool", 1));
      localScheduledThreadPoolExecutor3.setKeepAliveTime(60L, TimeUnit.SECONDS);
      localScheduledThreadPoolExecutor3.allowCoreThreadTimeOut(true);
    }
  }

  private static class g
    implements VideoPttControllerDelegate.VideoRecorder
  {
    public void onVideoPttRecordError(int paramInt)
    {
      av.a(av.a.a);
    }

    public void onVideoPttRecordInited()
    {
    }

    public void onVideoPttRecordStarted()
    {
      av.a(av.a.c);
    }

    public void onVideoPttRecordStopped(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      av.a(av.a.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.av
 * JD-Core Version:    0.6.2
 */