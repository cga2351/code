package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class StatefulRunnable<T>
  implements Runnable
{
  protected static final int STATE_CANCELLED = 2;
  protected static final int STATE_CREATED = 0;
  protected static final int STATE_FAILED = 4;
  protected static final int STATE_FINISHED = 3;
  protected static final int STATE_STARTED = 1;
  protected final AtomicInteger mState = new AtomicInteger(0);

  public void cancel()
  {
    if (this.mState.compareAndSet(0, 2))
      onCancellation();
  }

  protected void disposeResult(T paramT)
  {
  }

  protected abstract T getResult()
    throws Exception;

  protected void onCancellation()
  {
  }

  protected void onFailure(Exception paramException)
  {
  }

  protected void onSuccess(T paramT)
  {
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/facebook/common/executors/StatefulRunnable:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: iconst_0
    //   5: iconst_1
    //   6: invokevirtual 36	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 51	com/facebook/common/executors/StatefulRunnable:getResult	()Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 31	com/facebook/common/executors/StatefulRunnable:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   22: iconst_3
    //   23: invokevirtual 54	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   26: aload_0
    //   27: aload_2
    //   28: invokevirtual 56	com/facebook/common/executors/StatefulRunnable:onSuccess	(Ljava/lang/Object;)V
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 58	com/facebook/common/executors/StatefulRunnable:disposeResult	(Ljava/lang/Object;)V
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 31	com/facebook/common/executors/StatefulRunnable:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   42: iconst_4
    //   43: invokevirtual 54	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 60	com/facebook/common/executors/StatefulRunnable:onFailure	(Ljava/lang/Exception;)V
    //   51: return
    //   52: astore_3
    //   53: aload_0
    //   54: aload_2
    //   55: invokevirtual 58	com/facebook/common/executors/StatefulRunnable:disposeResult	(Ljava/lang/Object;)V
    //   58: aload_3
    //   59: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   13	18	37	java/lang/Exception
    //   26	31	52	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.executors.StatefulRunnable
 * JD-Core Version:    0.6.2
 */