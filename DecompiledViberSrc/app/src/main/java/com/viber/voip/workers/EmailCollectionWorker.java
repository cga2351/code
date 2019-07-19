package com.viber.voip.workers;

import android.content.Context;
import androidx.work.ListenableWorker.a;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.viber.voip.ViberApplication;
import com.viber.voip.g.a;
import com.viber.voip.j.a.a.c;
import d.d.b.h;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public final class EmailCollectionWorker extends Worker
{

  @Inject
  @NotNull
  public c b;

  public EmailCollectionWorker(@NotNull Context paramContext, @NotNull WorkerParameters paramWorkerParameters)
  {
    super(paramContext, paramWorkerParameters);
    ViberApplication localViberApplication = ViberApplication.getInstance();
    h.a(localViberApplication, "ViberApplication.getInstance()");
    localViberApplication.getAppComponent().a(this);
  }

  @NotNull
  public ListenableWorker.a k()
  {
    try
    {
      c localc = this.b;
      if (localc == null)
        h.b("emailsCollectionManager");
      localc.b();
      ListenableWorker.a locala2 = ListenableWorker.a.a();
      h.a(locala2, "ListenableWorker.Result.success()");
      return locala2;
    }
    catch (Throwable localThrowable)
    {
      ListenableWorker.a locala1 = ListenableWorker.a.c();
      h.a(locala1, "ListenableWorker.Result.failure()");
      return locala1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.workers.EmailCollectionWorker
 * JD-Core Version:    0.6.2
 */