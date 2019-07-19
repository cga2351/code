package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters.a;
import androidx.work.i;
import androidx.work.impl.a;
import androidx.work.impl.c;
import androidx.work.impl.h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService
  implements a
{
  private static final String a = i.a("SystemJobService");
  private h b;
  private final Map<String, JobParameters> c = new HashMap();

  public void a(String paramString, boolean paramBoolean)
  {
    i.a().b(a, String.format("%s executed on JobScheduler", new Object[] { paramString }), new Throwable[0]);
    synchronized (this.c)
    {
      JobParameters localJobParameters = (JobParameters)this.c.remove(paramString);
      if (localJobParameters != null)
        jobFinished(localJobParameters, paramBoolean);
      return;
    }
  }

  public void onCreate()
  {
    super.onCreate();
    this.b = h.b();
    if (this.b == null)
    {
      if (!Application.class.equals(getApplication().getClass()))
        throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
      i.a().d(a, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
      return;
    }
    this.b.g().a(this);
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.b != null)
      this.b.g().b(this);
  }

  public boolean onStartJob(JobParameters paramJobParameters)
  {
    if (this.b == null)
    {
      i.a().b(a, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
      jobFinished(paramJobParameters, true);
      return false;
    }
    String str = paramJobParameters.getExtras().getString("EXTRA_WORK_SPEC_ID");
    if (TextUtils.isEmpty(str))
    {
      i.a().e(a, "WorkSpec id not found!", new Throwable[0]);
      return false;
    }
    synchronized (this.c)
    {
      if (this.c.containsKey(str))
      {
        i.a().b(a, String.format("Job is already being executed by SystemJobService: %s", new Object[] { str }), new Throwable[0]);
        return false;
      }
    }
    i.a().b(a, String.format("onStartJob for %s", new Object[] { str }), new Throwable[0]);
    this.c.put(str, paramJobParameters);
    int i = Build.VERSION.SDK_INT;
    WorkerParameters.a locala = null;
    if (i >= 24)
    {
      locala = new WorkerParameters.a();
      if (paramJobParameters.getTriggeredContentUris() != null)
        locala.b = Arrays.asList(paramJobParameters.getTriggeredContentUris());
      if (paramJobParameters.getTriggeredContentAuthorities() != null)
        locala.a = Arrays.asList(paramJobParameters.getTriggeredContentAuthorities());
      if (Build.VERSION.SDK_INT >= 28)
        locala.c = paramJobParameters.getNetwork();
    }
    this.b.a(str, locala);
    return true;
  }

  public boolean onStopJob(JobParameters paramJobParameters)
  {
    if (this.b == null)
      i.a().b(a, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
    while (true)
    {
      return true;
      String str = paramJobParameters.getExtras().getString("EXTRA_WORK_SPEC_ID");
      if (TextUtils.isEmpty(str))
      {
        i.a().e(a, "WorkSpec id not found!", new Throwable[0]);
        return false;
      }
      i.a().b(a, String.format("onStopJob for %s", new Object[] { str }), new Throwable[0]);
      synchronized (this.c)
      {
        this.c.remove(str);
        this.b.d(str);
        if (!this.b.g().d(str))
          continue;
        return false;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemjob.SystemJobService
 * JD-Core Version:    0.6.2
 */