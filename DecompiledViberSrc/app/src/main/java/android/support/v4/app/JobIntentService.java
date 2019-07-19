package android.support.v4.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service
{
  static final boolean DEBUG = false;
  static final String TAG = "JobIntentService";
  static final HashMap<ComponentName, WorkEnqueuer> sClassWorkEnqueuer = new HashMap();
  static final Object sLock = new Object();
  final ArrayList<CompatWorkItem> mCompatQueue;
  WorkEnqueuer mCompatWorkEnqueuer;
  CommandProcessor mCurProcessor;
  boolean mDestroyed = false;
  boolean mInterruptIfStopped = false;
  CompatJobEngine mJobImpl;
  boolean mStopped = false;

  public JobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mCompatQueue = null;
      return;
    }
    this.mCompatQueue = new ArrayList();
  }

  public static void enqueueWork(Context paramContext, ComponentName paramComponentName, int paramInt, Intent paramIntent)
  {
    if (paramIntent == null)
      throw new IllegalArgumentException("work must not be null");
    synchronized (sLock)
    {
      WorkEnqueuer localWorkEnqueuer = getWorkEnqueuer(paramContext, paramComponentName, true, paramInt);
      localWorkEnqueuer.ensureJobId(paramInt);
      localWorkEnqueuer.enqueueWork(paramIntent);
      return;
    }
  }

  public static void enqueueWork(Context paramContext, Class paramClass, int paramInt, Intent paramIntent)
  {
    enqueueWork(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }

  static WorkEnqueuer getWorkEnqueuer(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    Object localObject = (WorkEnqueuer)sClassWorkEnqueuer.get(paramComponentName);
    if (localObject == null)
    {
      if (Build.VERSION.SDK_INT < 26)
        break label64;
      if (!paramBoolean)
        throw new IllegalArgumentException("Can't be here without a job id");
    }
    label64: for (localObject = new JobWorkEnqueuer(paramContext, paramComponentName, paramInt); ; localObject = new CompatWorkEnqueuer(paramContext, paramComponentName))
    {
      sClassWorkEnqueuer.put(paramComponentName, localObject);
      return localObject;
    }
  }

  GenericWorkItem dequeueWork()
  {
    if (this.mJobImpl != null)
      return this.mJobImpl.dequeueWork();
    synchronized (this.mCompatQueue)
    {
      if (this.mCompatQueue.size() > 0)
      {
        GenericWorkItem localGenericWorkItem = (GenericWorkItem)this.mCompatQueue.remove(0);
        return localGenericWorkItem;
      }
    }
    return null;
  }

  boolean doStopCurrentWork()
  {
    if (this.mCurProcessor != null)
      this.mCurProcessor.cancel(this.mInterruptIfStopped);
    this.mStopped = true;
    return onStopCurrentWork();
  }

  void ensureProcessorRunningLocked(boolean paramBoolean)
  {
    if (this.mCurProcessor == null)
    {
      this.mCurProcessor = new CommandProcessor();
      if ((this.mCompatWorkEnqueuer != null) && (paramBoolean))
        this.mCompatWorkEnqueuer.serviceProcessingStarted();
      this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }

  public boolean isStopped()
  {
    return this.mStopped;
  }

  public IBinder onBind(Intent paramIntent)
  {
    if (this.mJobImpl != null)
      return this.mJobImpl.compatGetBinder();
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mJobImpl = new JobServiceEngineImpl(this);
      this.mCompatWorkEnqueuer = null;
      return;
    }
    this.mJobImpl = null;
    this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.mCompatQueue != null)
      synchronized (this.mCompatQueue)
      {
        this.mDestroyed = true;
        this.mCompatWorkEnqueuer.serviceProcessingFinished();
        return;
      }
  }

  protected abstract void onHandleWork(Intent paramIntent);

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.mCompatQueue != null)
    {
      this.mCompatWorkEnqueuer.serviceStartReceived();
      synchronized (this.mCompatQueue)
      {
        ArrayList localArrayList2 = this.mCompatQueue;
        if (paramIntent != null)
        {
          localArrayList2.add(new CompatWorkItem(paramIntent, paramInt2));
          ensureProcessorRunningLocked(true);
          return 3;
        }
        paramIntent = new Intent();
      }
    }
    return 2;
  }

  public boolean onStopCurrentWork()
  {
    return true;
  }

  void processorFinished()
  {
    if (this.mCompatQueue != null)
      synchronized (this.mCompatQueue)
      {
        this.mCurProcessor = null;
        if ((this.mCompatQueue != null) && (this.mCompatQueue.size() > 0))
          ensureProcessorRunningLocked(false);
        while (this.mDestroyed)
          return;
        this.mCompatWorkEnqueuer.serviceProcessingFinished();
      }
  }

  public void setInterruptIfStopped(boolean paramBoolean)
  {
    this.mInterruptIfStopped = paramBoolean;
  }

  final class CommandProcessor extends AsyncTask<Void, Void, Void>
  {
    CommandProcessor()
    {
    }

    protected Void doInBackground(Void[] paramArrayOfVoid)
    {
      while (true)
      {
        JobIntentService.GenericWorkItem localGenericWorkItem = JobIntentService.this.dequeueWork();
        if (localGenericWorkItem == null)
          break;
        JobIntentService.this.onHandleWork(localGenericWorkItem.getIntent());
        localGenericWorkItem.complete();
      }
      return null;
    }

    protected void onCancelled(Void paramVoid)
    {
      JobIntentService.this.processorFinished();
    }

    protected void onPostExecute(Void paramVoid)
    {
      JobIntentService.this.processorFinished();
    }
  }

  static abstract interface CompatJobEngine
  {
    public abstract IBinder compatGetBinder();

    public abstract JobIntentService.GenericWorkItem dequeueWork();
  }

  static final class CompatWorkEnqueuer extends JobIntentService.WorkEnqueuer
  {
    private final Context mContext;
    private final PowerManager.WakeLock mLaunchWakeLock;
    boolean mLaunchingService;
    private final PowerManager.WakeLock mRunWakeLock;
    boolean mServiceProcessing;

    CompatWorkEnqueuer(Context paramContext, ComponentName paramComponentName)
    {
      super(paramComponentName);
      this.mContext = paramContext.getApplicationContext();
      PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
      this.mLaunchWakeLock = localPowerManager.newWakeLock(1, paramComponentName.getClassName() + ":launch");
      this.mLaunchWakeLock.setReferenceCounted(false);
      this.mRunWakeLock = localPowerManager.newWakeLock(1, paramComponentName.getClassName() + ":run");
      this.mRunWakeLock.setReferenceCounted(false);
    }

    void enqueueWork(Intent paramIntent)
    {
      Intent localIntent = new Intent(paramIntent);
      localIntent.setComponent(this.mComponentName);
      if (this.mContext.startService(localIntent) != null)
        try
        {
          if (!this.mLaunchingService)
          {
            this.mLaunchingService = true;
            if (!this.mServiceProcessing)
              this.mLaunchWakeLock.acquire(60000L);
          }
          return;
        }
        finally
        {
        }
    }

    public void serviceProcessingFinished()
    {
      try
      {
        if (this.mServiceProcessing)
        {
          if (this.mLaunchingService)
            this.mLaunchWakeLock.acquire(60000L);
          this.mServiceProcessing = false;
          this.mRunWakeLock.release();
        }
        return;
      }
      finally
      {
      }
    }

    public void serviceProcessingStarted()
    {
      try
      {
        if (!this.mServiceProcessing)
        {
          this.mServiceProcessing = true;
          this.mRunWakeLock.acquire(600000L);
          this.mLaunchWakeLock.release();
        }
        return;
      }
      finally
      {
      }
    }

    public void serviceStartReceived()
    {
      try
      {
        this.mLaunchingService = false;
        return;
      }
      finally
      {
      }
    }
  }

  final class CompatWorkItem
    implements JobIntentService.GenericWorkItem
  {
    final Intent mIntent;
    final int mStartId;

    CompatWorkItem(Intent paramInt, int arg3)
    {
      this.mIntent = paramInt;
      int i;
      this.mStartId = i;
    }

    public void complete()
    {
      JobIntentService.this.stopSelf(this.mStartId);
    }

    public Intent getIntent()
    {
      return this.mIntent;
    }
  }

  static abstract interface GenericWorkItem
  {
    public abstract void complete();

    public abstract Intent getIntent();
  }

  static final class JobServiceEngineImpl extends JobServiceEngine
    implements JobIntentService.CompatJobEngine
  {
    static final boolean DEBUG = false;
    static final String TAG = "JobServiceEngineImpl";
    final Object mLock = new Object();
    JobParameters mParams;
    final JobIntentService mService;

    JobServiceEngineImpl(JobIntentService paramJobIntentService)
    {
      super();
      this.mService = paramJobIntentService;
    }

    public IBinder compatGetBinder()
    {
      return getBinder();
    }

    public JobIntentService.GenericWorkItem dequeueWork()
    {
      synchronized (this.mLock)
      {
        if (this.mParams == null)
          return null;
        JobWorkItem localJobWorkItem = this.mParams.dequeueWork();
        if (localJobWorkItem != null)
        {
          localJobWorkItem.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
          return new WrapperWorkItem(localJobWorkItem);
        }
      }
      return null;
    }

    public boolean onStartJob(JobParameters paramJobParameters)
    {
      this.mParams = paramJobParameters;
      this.mService.ensureProcessorRunningLocked(false);
      return true;
    }

    public boolean onStopJob(JobParameters paramJobParameters)
    {
      boolean bool = this.mService.doStopCurrentWork();
      synchronized (this.mLock)
      {
        this.mParams = null;
        return bool;
      }
    }

    final class WrapperWorkItem
      implements JobIntentService.GenericWorkItem
    {
      final JobWorkItem mJobWork;

      WrapperWorkItem(JobWorkItem arg2)
      {
        Object localObject;
        this.mJobWork = localObject;
      }

      public void complete()
      {
        synchronized (JobIntentService.JobServiceEngineImpl.this.mLock)
        {
          if (JobIntentService.JobServiceEngineImpl.this.mParams != null)
            JobIntentService.JobServiceEngineImpl.this.mParams.completeWork(this.mJobWork);
          return;
        }
      }

      public Intent getIntent()
      {
        return this.mJobWork.getIntent();
      }
    }
  }

  static final class JobWorkEnqueuer extends JobIntentService.WorkEnqueuer
  {
    private final JobInfo mJobInfo;
    private final JobScheduler mJobScheduler;

    JobWorkEnqueuer(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super(paramComponentName);
      ensureJobId(paramInt);
      this.mJobInfo = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
      this.mJobScheduler = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }

    void enqueueWork(Intent paramIntent)
    {
      this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(paramIntent));
    }
  }

  static abstract class WorkEnqueuer
  {
    final ComponentName mComponentName;
    boolean mHasJobId;
    int mJobId;

    WorkEnqueuer(Context paramContext, ComponentName paramComponentName)
    {
      this.mComponentName = paramComponentName;
    }

    abstract void enqueueWork(Intent paramIntent);

    void ensureJobId(int paramInt)
    {
      if (!this.mHasJobId)
      {
        this.mHasJobId = true;
        this.mJobId = paramInt;
      }
      while (this.mJobId == paramInt)
        return;
      throw new IllegalArgumentException("Given job ID " + paramInt + " is different than previous " + this.mJobId);
    }

    public void serviceProcessingFinished()
    {
    }

    public void serviceProcessingStarted()
    {
    }

    public void serviceStartReceived()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.JobIntentService
 * JD-Core Version:    0.6.2
 */