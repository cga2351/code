package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Keep;
import androidx.work.impl.utils.a.c;
import com.google.b.a.a.a;
import java.util.concurrent.Executor;

public abstract class Worker extends ListenableWorker
{
  c<ListenableWorker.a> a;

  @SuppressLint({"BanKeepAnnotation"})
  @Keep
  public Worker(Context paramContext, WorkerParameters paramWorkerParameters)
  {
    super(paramContext, paramWorkerParameters);
  }

  public final a<ListenableWorker.a> d()
  {
    this.a = c.d();
    i().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          ListenableWorker.a locala = Worker.this.k();
          Worker.this.a.a(locala);
          return;
        }
        catch (Throwable localThrowable)
        {
          Worker.this.a.a(localThrowable);
        }
      }
    });
    return this.a;
  }

  public abstract ListenableWorker.a k();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.Worker
 * JD-Core Version:    0.6.2
 */