package com.viber.voip.videoconvert;

import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.viber.voip.VideoConverterPreparedRequest;
import com.viber.voip.VideoConverterPreparedRequest.a;
import com.viber.voip.VideoConverterRequest;
import com.viber.voip.ag;
import com.viber.voip.ah;
import com.viber.voip.ai;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class n
  implements b, d
{
  static List<String> a = Arrays.asList(new String[] { "isom", "avc1", "f4v", "f4p", "iso2", "mmp4", "mp41", "mp42", "ndsc", "ndsh", "ndsm", "ndsp", "ndss", "ndxc", "ndxh", "ndxm", "ndxp", "ndxs" });
  private static HandlerThread h;
  private Set<ai> b = new HashSet();
  private Queue<a> c = new LinkedBlockingDeque();
  private VideoConverterExecutor d = new VideoConverterExecutor();
  private d e = null;
  private b f = new b(this);
  private e g = e.a();
  private volatile int i = 1;

  static
  {
    HandlerThread localHandlerThread = new HandlerThread("videoconverterworker");
    h = localHandlerThread;
    localHandlerThread.start();
  }

  n()
  {
    this.e.sendEmptyMessageDelayed(0, 1000L);
  }

  private void a(c paramc)
  {
    synchronized (this.b)
    {
      HashSet localHashSet = new HashSet(this.b);
      Iterator localIterator = localHashSet.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          ai localai = (ai)localIterator.next();
          if (localai != null)
            try
            {
              paramc.a(localai);
            }
            catch (RemoteException localRemoteException)
            {
              this.g.a(localRemoteException);
            }
        }
    }
  }

  private void b(final int paramInt)
  {
    a(new c()
    {
      public void a(ai paramAnonymousai)
        throws RemoteException
      {
        paramAnonymousai.a(paramInt);
      }
    });
  }

  private void b(final VideoConverterPreparedRequest paramVideoConverterPreparedRequest, final int paramInt)
  {
    a(new c()
    {
      public void a(ai paramAnonymousai)
        throws RemoteException
      {
        paramAnonymousai.a(paramVideoConverterPreparedRequest, paramInt);
      }
    });
  }

  private void c(int paramInt)
  {
    if (this.i == paramInt)
      return;
    b localb = this.f;
    this.i = paramInt;
    localb.sendEmptyMessage(paramInt);
  }

  private void c(final VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
  {
    a(new c()
    {
      public void a(ai paramAnonymousai)
        throws RemoteException
      {
        paramAnonymousai.a(paramVideoConverterPreparedRequest);
      }
    });
  }

  private void c(final VideoConverterPreparedRequest paramVideoConverterPreparedRequest, final int paramInt)
  {
    a(new c()
    {
      public void a(ai paramAnonymousai)
        throws RemoteException
      {
        paramAnonymousai.b(paramVideoConverterPreparedRequest, paramInt);
      }
    });
  }

  int a(int paramInt)
    throws RemoteException
  {
    this.g.a("Video converter version 3.1.0");
    int j;
    if (11 > Build.VERSION.SDK_INT)
    {
      j = 0;
      return j;
    }
    if ((!c("arm64-v8a")) && (!c("x86")) && (!VideoConverterNative.c()))
    {
      this.g.a("no NEON instruction set on this device. video conversion isn't supported");
      return 0;
    }
    if (Build.VERSION.SDK_INT < 18)
      paramInt = 0xFFFFFFFD & (paramInt & 0xFFFFFFF7);
    int i1;
    if ((paramInt & 0x8) != 0)
    {
      boolean bool4 = new k().a();
      if (bool4)
      {
        i1 = 8;
        label102: j = i1 | 0x0;
        if (bool4)
          this.g.a("selecting CONVERSION_CLASS_GPU_SURFACE bit");
      }
    }
    while (true)
    {
      int n;
      if ((paramInt & 0x10) != 0)
      {
        boolean bool3 = new j().a();
        if (!bool3)
          break label272;
        n = 16;
        label151: j |= n;
        if (bool3)
          this.g.a("selecting CONVERSION_CLASS_GPU_BUFFERS bit");
      }
      boolean bool2;
      if ((paramInt & 0x2) != 0)
      {
        bool2 = new l().a();
        if (!bool2)
          break label278;
      }
      label272: label278: for (int m = 2; ; m = 0)
      {
        j |= m;
        if (bool2)
          this.g.a("selecting CONVERSION_CLASS_OMX bit");
        if ((paramInt & 0x4) == 0)
          break;
        boolean bool1 = new h().a();
        int k = 0;
        if (bool1)
          k = 4;
        j |= k;
        if (!bool1)
          break;
        this.g.a("selecting CONVERSION_CLASS_SOFT bit");
        return j;
        i1 = 0;
        break label102;
        n = 0;
        break label151;
      }
      j = 0;
    }
  }

  public VideoConverterPreparedRequest a(VideoConverterRequest paramVideoConverterRequest)
    throws RemoteException
  {
    a locala = new a(paramVideoConverterRequest.debugHints());
    if (locala.a(76))
      return new VideoConverterPreparedRequest(paramVideoConverterRequest, "", VideoConverterPreparedRequest.a.a);
    if (locala.a(67))
      return new VideoConverterPreparedRequest(paramVideoConverterRequest, "", VideoConverterPreparedRequest.a.b);
    if (locala.a(66))
      return new VideoConverterPreparedRequest(paramVideoConverterRequest, "", VideoConverterPreparedRequest.a.c);
    if (a(-1) != 0);
    for (VideoConverterPreparedRequest.a locala1 = VideoConverterPreparedRequest.a.a; ; locala1 = VideoConverterPreparedRequest.a.c)
      return new VideoConverterPreparedRequest(paramVideoConverterRequest, "", locala1);
  }

  public ag a()
    throws RemoteException
  {
    return this;
  }

  public String a(String paramString)
    throws RemoteException
  {
    return "";
  }

  public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
    throws RemoteException
  {
    VideoConverterExecutor.interrupt(paramVideoConverterPreparedRequest.request().source().getPath());
  }

  public void a(final VideoConverterPreparedRequest paramVideoConverterPreparedRequest, final int paramInt)
  {
    this.f.post(new Runnable()
    {
      public void run()
      {
        n.b(n.this, paramVideoConverterPreparedRequest, paramInt);
        if (paramInt != 0)
          n.a(n.this, paramInt);
      }
    });
  }

  public void a(final VideoConverterPreparedRequest paramVideoConverterPreparedRequest, ah paramah)
    throws RemoteException
  {
    this.g.a("entering postAction, action: " + paramVideoConverterPreparedRequest + ", callback:" + paramah);
    if (!this.c.add(new a(paramVideoConverterPreparedRequest, paramah)))
    {
      c(4);
      return;
    }
    this.f.post(new Runnable()
    {
      public void run()
      {
        n.a(n.this, paramVideoConverterPreparedRequest, 3);
      }
    });
    this.e.sendEmptyMessage(3);
  }

  public void a(ai paramai)
  {
    synchronized (this.b)
    {
      this.b.add(paramai);
      return;
    }
  }

  public IBinder asBinder()
  {
    return null;
  }

  // ERROR //
  public String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 348	java/io/BufferedReader
    //   5: dup
    //   6: new 350	java/io/InputStreamReader
    //   9: dup
    //   10: invokestatic 356	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: new 311	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 358
    //   23: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokevirtual 362	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   36: invokevirtual 368	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   39: invokespecial 371	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: sipush 1024
    //   45: invokespecial 374	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 377	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 10
    //   55: aload_3
    //   56: invokevirtual 380	java/io/BufferedReader:close	()V
    //   59: aload_3
    //   60: ifnull +7 -> 67
    //   63: aload_3
    //   64: invokevirtual 380	java/io/BufferedReader:close	()V
    //   67: aload 10
    //   69: areturn
    //   70: astore 11
    //   72: aload_0
    //   73: getfield 123	com/viber/voip/videoconvert/n:g	Lcom/viber/voip/videoconvert/e;
    //   76: ldc_w 382
    //   79: invokevirtual 211	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   82: aload 10
    //   84: areturn
    //   85: astore 12
    //   87: aconst_null
    //   88: astore 5
    //   90: aload_0
    //   91: getfield 123	com/viber/voip/videoconvert/n:g	Lcom/viber/voip/videoconvert/e;
    //   94: new 311	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 384
    //   104: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 211	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   117: aload 5
    //   119: ifnull +8 -> 127
    //   122: aload 5
    //   124: invokevirtual 380	java/io/BufferedReader:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore 9
    //   131: aload_0
    //   132: getfield 123	com/viber/voip/videoconvert/n:g	Lcom/viber/voip/videoconvert/e;
    //   135: ldc_w 382
    //   138: invokevirtual 211	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   141: goto -14 -> 127
    //   144: astore 7
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 380	java/io/BufferedReader:close	()V
    //   154: aload 7
    //   156: athrow
    //   157: astore 8
    //   159: aload_0
    //   160: getfield 123	com/viber/voip/videoconvert/n:g	Lcom/viber/voip/videoconvert/e;
    //   163: ldc_w 382
    //   166: invokevirtual 211	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   169: goto -15 -> 154
    //   172: astore 7
    //   174: aload_3
    //   175: astore_2
    //   176: goto -30 -> 146
    //   179: astore 6
    //   181: aload 5
    //   183: astore_2
    //   184: aload 6
    //   186: astore 7
    //   188: goto -42 -> 146
    //   191: astore 4
    //   193: aload_3
    //   194: astore 5
    //   196: goto -106 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   63	67	70	java/io/IOException
    //   2	49	85	java/io/IOException
    //   122	127	129	java/io/IOException
    //   2	49	144	finally
    //   150	154	157	java/io/IOException
    //   49	59	172	finally
    //   90	117	179	finally
    //   49	59	191	java/io/IOException
  }

  public void b(final VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
  {
    this.f.post(new Runnable()
    {
      public void run()
      {
        n.a(n.this, paramVideoConverterPreparedRequest);
      }
    });
  }

  public void b(ai paramai)
  {
    synchronized (this.b)
    {
      this.b.remove(paramai);
      return;
    }
  }

  public boolean c(String paramString)
  {
    String str1 = b("ro.product.cpu.abi");
    String str2 = b("ro.product.cpu.abi2");
    e locale1 = this.g;
    StringBuilder localStringBuilder1 = new StringBuilder().append("primary abi: ");
    String str3;
    e locale2;
    StringBuilder localStringBuilder2;
    if (str1 == null)
    {
      str3 = "null";
      locale1.a(str3);
      locale2 = this.g;
      localStringBuilder2 = new StringBuilder().append("secondary abi: ");
      if (str2 != null)
        break label145;
    }
    label145: for (String str4 = "null"; ; str4 = str2)
    {
      locale2.a(str4);
      boolean bool = false;
      if (str1 != null)
        bool = str1.equalsIgnoreCase(paramString);
      if ((!bool) && (str2 != null))
        bool = str2.equalsIgnoreCase(paramString);
      return bool;
      str3 = str1;
      break;
    }
  }

  class a
  {
    final VideoConverterPreparedRequest a;
    final ah b;

    public a(VideoConverterPreparedRequest paramah, ah arg3)
    {
      this.a = paramah;
      Object localObject;
      this.b = localObject;
    }
  }

  class b extends Handler
  {
    final d a;

    b(d arg2)
    {
      super();
      Object localObject;
      this.a = localObject;
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      n.b(n.this, paramMessage.what);
    }
  }

  static abstract interface c
  {
    public abstract void a(ai paramai)
      throws RemoteException;
  }

  class d extends Handler
  {
    private final Queue<n.a> b;
    private final VideoConverterExecutor c;
    private final AtomicBoolean d = new AtomicBoolean(false);

    d(VideoConverterExecutor arg2)
    {
      super();
      Object localObject1;
      this.b = localObject1;
      Object localObject2;
      this.c = localObject2;
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (this.d.compareAndSet(false, true))
        this.c.initialize();
      try
      {
        if (3 == paramMessage.what)
        {
          n.a locala = (n.a)this.b.poll();
          if (locala == null)
          {
            n.this.a(null, -4);
            return;
          }
          n.a(n.this, 2);
          int i = this.c.process(locala.a, locala.b, n.this);
          if (i != 0)
            n.a(n.this, i);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        n.a(n.this, -1);
        return;
      }
      finally
      {
        if (this.b.size() == 0)
          n.a(n.this, 1);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.n
 * JD-Core Version:    0.6.2
 */