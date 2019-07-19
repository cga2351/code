package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class JobScheduler
{
  static final String QUEUE_TIME_KEY = "queueTime";
  private final Runnable mDoJobRunnable;

  @VisibleForTesting
  @GuardedBy("this")
  EncodedImage mEncodedImage;
  private final Executor mExecutor;
  private final JobRunnable mJobRunnable;

  @VisibleForTesting
  @GuardedBy("this")
  long mJobStartTime;

  @VisibleForTesting
  @GuardedBy("this")
  JobState mJobState;

  @VisibleForTesting
  @GuardedBy("this")
  long mJobSubmitTime;
  private final int mMinimumJobIntervalMs;

  @VisibleForTesting
  @GuardedBy("this")
  int mStatus;
  private final Runnable mSubmitJobRunnable;

  public JobScheduler(Executor paramExecutor, JobRunnable paramJobRunnable, int paramInt)
  {
    this.mExecutor = paramExecutor;
    this.mJobRunnable = paramJobRunnable;
    this.mMinimumJobIntervalMs = paramInt;
    this.mDoJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.doJob();
      }
    };
    this.mSubmitJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.submitJob();
      }
    };
    this.mEncodedImage = null;
    this.mStatus = 0;
    this.mJobState = JobState.IDLE;
    this.mJobSubmitTime = 0L;
    this.mJobStartTime = 0L;
  }

  // ERROR //
  private void doJob()
  {
    // Byte code:
    //   0: invokestatic 81	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 54	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 56	com/facebook/imagepipeline/producers/JobScheduler:mStatus	I
    //   16: istore 5
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 54	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 56	com/facebook/imagepipeline/producers/JobScheduler:mStatus	I
    //   28: aload_0
    //   29: getstatic 84	com/facebook/imagepipeline/producers/JobScheduler$JobState:RUNNING	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   32: putfield 63	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   35: aload_0
    //   36: lload_1
    //   37: putfield 67	com/facebook/imagepipeline/producers/JobScheduler:mJobStartTime	J
    //   40: aload_0
    //   41: monitorexit
    //   42: aload 4
    //   44: iload 5
    //   46: invokestatic 88	com/facebook/imagepipeline/producers/JobScheduler:shouldProcess	(Lcom/facebook/imagepipeline/image/EncodedImage;I)Z
    //   49: ifeq +16 -> 65
    //   52: aload_0
    //   53: getfield 38	com/facebook/imagepipeline/producers/JobScheduler:mJobRunnable	Lcom/facebook/imagepipeline/producers/JobScheduler$JobRunnable;
    //   56: aload 4
    //   58: iload 5
    //   60: invokeinterface 94 3 0
    //   65: aload 4
    //   67: invokestatic 100	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   70: aload_0
    //   71: invokespecial 103	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   74: return
    //   75: astore_3
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_3
    //   79: athrow
    //   80: astore 6
    //   82: aload 4
    //   84: invokestatic 100	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   87: aload_0
    //   88: invokespecial 103	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   91: aload 6
    //   93: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   6	42	75	finally
    //   76	78	75	finally
    //   42	65	80	finally
  }

  private void enqueueJob(long paramLong)
  {
    if (paramLong > 0L)
    {
      JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    this.mSubmitJobRunnable.run();
  }

  private void onJobFinished()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = 0L;
    try
    {
      int i;
      if (this.mJobState == JobState.RUNNING_AND_PENDING)
      {
        l2 = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, l1);
        i = 1;
        this.mJobSubmitTime = l1;
        this.mJobState = JobState.QUEUED;
      }
      while (true)
      {
        if (i != 0)
          enqueueJob(l2 - l1);
        return;
        this.mJobState = JobState.IDLE;
        i = 0;
      }
    }
    finally
    {
    }
  }

  private static boolean shouldProcess(EncodedImage paramEncodedImage, int paramInt)
  {
    return (BaseConsumer.isLast(paramInt)) || (BaseConsumer.statusHasFlag(paramInt, 4)) || (EncodedImage.isValid(paramEncodedImage));
  }

  private void submitJob()
  {
    this.mExecutor.execute(this.mDoJobRunnable);
  }

  public void clearJob()
  {
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = null;
      this.mStatus = 0;
      EncodedImage.closeSafely(localEncodedImage);
      return;
    }
    finally
    {
    }
  }

  public long getQueuedTime()
  {
    try
    {
      long l1 = this.mJobStartTime;
      long l2 = this.mJobSubmitTime;
      long l3 = l1 - l2;
      return l3;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean scheduleJob()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = 0L;
    try
    {
      if (!shouldProcess(this.mEncodedImage, this.mStatus))
        return false;
      int i = 3.$SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[this.mJobState.ordinal()];
      int j = 0;
      switch (i)
      {
      case 2:
      default:
      case 1:
      case 3:
      }
      while (true)
      {
        if (j != 0)
          enqueueJob(l2 - l1);
        return true;
        l2 = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, l1);
        this.mJobSubmitTime = l1;
        this.mJobState = JobState.QUEUED;
        j = 1;
        continue;
        this.mJobState = JobState.RUNNING_AND_PENDING;
        j = 0;
      }
    }
    finally
    {
    }
  }

  public boolean updateJob(EncodedImage paramEncodedImage, int paramInt)
  {
    if (!shouldProcess(paramEncodedImage, paramInt))
      return false;
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
      this.mStatus = paramInt;
      EncodedImage.closeSafely(localEncodedImage);
      return true;
    }
    finally
    {
    }
  }

  public static abstract interface JobRunnable
  {
    public abstract void run(EncodedImage paramEncodedImage, int paramInt);
  }

  @VisibleForTesting
  static class JobStartExecutorSupplier
  {
    private static ScheduledExecutorService sJobStarterExecutor;

    static ScheduledExecutorService get()
    {
      if (sJobStarterExecutor == null)
        sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
      return sJobStarterExecutor;
    }
  }

  @VisibleForTesting
  static enum JobState
  {
    static
    {
      JobState[] arrayOfJobState = new JobState[4];
      arrayOfJobState[0] = IDLE;
      arrayOfJobState[1] = QUEUED;
      arrayOfJobState[2] = RUNNING;
      arrayOfJobState[3] = RUNNING_AND_PENDING;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.JobScheduler
 * JD-Core Version:    0.6.2
 */