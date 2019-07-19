package android.support.v4.os;

import android.os.Build.VERSION;

public final class CancellationSignal
{
  private boolean mCancelInProgress;
  private Object mCancellationSignalObj;
  private boolean mIsCanceled;
  private OnCancelListener mOnCancelListener;

  private void waitForCancelFinishedLocked()
  {
    while (this.mCancelInProgress)
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
      }
  }

  // ERROR //
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	android/support/v4/os/CancellationSignal:mIsCanceled	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 26	android/support/v4/os/CancellationSignal:mIsCanceled	Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 20	android/support/v4/os/CancellationSignal:mCancelInProgress	Z
    //   22: aload_0
    //   23: getfield 28	android/support/v4/os/CancellationSignal:mOnCancelListener	Landroid/support/v4/os/CancellationSignal$OnCancelListener;
    //   26: astore_2
    //   27: aload_0
    //   28: getfield 30	android/support/v4/os/CancellationSignal:mCancellationSignalObj	Ljava/lang/Object;
    //   31: astore_3
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: ifnull +9 -> 44
    //   38: aload_2
    //   39: invokeinterface 35 1 0
    //   44: aload_3
    //   45: ifnull +18 -> 63
    //   48: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 16
    //   53: if_icmplt +10 -> 63
    //   56: aload_3
    //   57: checkcast 43	android/os/CancellationSignal
    //   60: invokevirtual 45	android/os/CancellationSignal:cancel	()V
    //   63: aload_0
    //   64: monitorenter
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 20	android/support/v4/os/CancellationSignal:mCancelInProgress	Z
    //   70: aload_0
    //   71: invokevirtual 48	java/lang/Object:notifyAll	()V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore 6
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 6
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    //   89: astore 4
    //   91: aload_0
    //   92: monitorenter
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 20	android/support/v4/os/CancellationSignal:mCancelInProgress	Z
    //   98: aload_0
    //   99: invokevirtual 48	java/lang/Object:notifyAll	()V
    //   102: aload_0
    //   103: monitorexit
    //   104: aload 4
    //   106: athrow
    //   107: astore 5
    //   109: aload_0
    //   110: monitorexit
    //   111: aload 5
    //   113: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   65	76	77	finally
    //   79	81	77	finally
    //   2	11	84	finally
    //   12	34	84	finally
    //   85	87	84	finally
    //   38	44	89	finally
    //   48	63	89	finally
    //   93	104	107	finally
    //   109	111	107	finally
  }

  public Object getCancellationSignalObject()
  {
    if (Build.VERSION.SDK_INT < 16)
      return null;
    try
    {
      if (this.mCancellationSignalObj == null)
      {
        this.mCancellationSignalObj = new android.os.CancellationSignal();
        if (this.mIsCanceled)
          ((android.os.CancellationSignal)this.mCancellationSignalObj).cancel();
      }
      Object localObject2 = this.mCancellationSignalObj;
      return localObject2;
    }
    finally
    {
    }
  }

  public boolean isCanceled()
  {
    try
    {
      boolean bool = this.mIsCanceled;
      return bool;
    }
    finally
    {
    }
  }

  public void setOnCancelListener(OnCancelListener paramOnCancelListener)
  {
    try
    {
      waitForCancelFinishedLocked();
      if (this.mOnCancelListener == paramOnCancelListener)
        return;
      this.mOnCancelListener = paramOnCancelListener;
      if ((!this.mIsCanceled) || (paramOnCancelListener == null))
        return;
    }
    finally
    {
    }
    paramOnCancelListener.onCancel();
  }

  public void throwIfCanceled()
  {
    if (isCanceled())
      throw new OperationCanceledException();
  }

  public static abstract interface OnCancelListener
  {
    public abstract void onCancel();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.os.CancellationSignal
 * JD-Core Version:    0.6.2
 */