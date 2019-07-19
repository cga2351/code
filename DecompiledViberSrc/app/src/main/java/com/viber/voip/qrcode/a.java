package com.viber.voip.qrcode;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Collection;

final class a
  implements Camera.AutoFocusCallback
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Collection<String> b = new ArrayList(2);
  private boolean c;
  private boolean d;
  private final boolean e;
  private final Camera f;
  private AsyncTask<?, ?, ?> g;

  static
  {
    b.add("auto");
    b.add("macro");
  }

  a(Context paramContext, Camera paramCamera)
  {
    this.f = paramCamera;
    String str = paramCamera.getParameters().getFocusMode();
    this.e = b.contains(str);
    a();
  }

  // ERROR //
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/viber/voip/qrcode/a:c	Z
    //   6: ifne +37 -> 43
    //   9: aload_0
    //   10: getfield 78	com/viber/voip/qrcode/a:g	Landroid/os/AsyncTask;
    //   13: ifnonnull +30 -> 43
    //   16: new 80	com/viber/voip/qrcode/a$a
    //   19: dup
    //   20: aload_0
    //   21: aconst_null
    //   22: invokespecial 83	com/viber/voip/qrcode/a$a:<init>	(Lcom/viber/voip/qrcode/a;Lcom/viber/voip/qrcode/a$1;)V
    //   25: astore_2
    //   26: aload_2
    //   27: getstatic 89	android/os/AsyncTask:THREAD_POOL_EXECUTOR	Ljava/util/concurrent/Executor;
    //   30: iconst_0
    //   31: anewarray 4	java/lang/Object
    //   34: invokevirtual 93	com/viber/voip/qrcode/a$a:executeOnExecutor	(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   37: pop
    //   38: aload_0
    //   39: aload_2
    //   40: putfield 78	com/viber/voip/qrcode/a:g	Landroid/os/AsyncTask;
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_3
    //   52: goto -9 -> 43
    //
    // Exception table:
    //   from	to	target	type
    //   2	26	46	finally
    //   26	43	46	finally
    //   26	43	51	java/util/concurrent/RejectedExecutionException
  }

  private void d()
  {
    try
    {
      if (this.g != null)
      {
        if (this.g.getStatus() != AsyncTask.Status.FINISHED)
          this.g.cancel(true);
        this.g = null;
      }
      return;
    }
    finally
    {
    }
  }

  void a()
  {
    try
    {
      if (this.e)
      {
        this.g = null;
        if (!this.c)
        {
          boolean bool = this.d;
          if (bool);
        }
      }
      try
      {
        this.f.autoFocus(this);
        this.d = true;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        while (true)
          c();
      }
    }
    finally
    {
    }
  }

  // ERROR //
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 76	com/viber/voip/qrcode/a:c	Z
    //   7: aload_0
    //   8: getfield 70	com/viber/voip/qrcode/a:e	Z
    //   11: ifeq +14 -> 25
    //   14: aload_0
    //   15: invokespecial 119	com/viber/voip/qrcode/a:d	()V
    //   18: aload_0
    //   19: getfield 53	com/viber/voip/qrcode/a:f	Landroid/hardware/Camera;
    //   22: invokevirtual 122	android/hardware/Camera:cancelAutoFocus	()V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: astore_2
    //   34: goto -9 -> 25
    //
    // Exception table:
    //   from	to	target	type
    //   2	18	28	finally
    //   18	25	28	finally
    //   18	25	33	java/lang/RuntimeException
  }

  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    try
    {
      this.d = false;
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private final class a extends AsyncTask<Object, Object, Object>
  {
    private a()
    {
    }

    protected Object doInBackground(Object[] paramArrayOfObject)
    {
      try
      {
        Thread.sleep(2000L);
        label6: a.this.a();
        return null;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label6;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.a
 * JD-Core Version:    0.6.2
 */