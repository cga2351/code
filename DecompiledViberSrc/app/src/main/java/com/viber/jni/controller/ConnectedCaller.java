package com.viber.jni.controller;

import android.util.SparseArray;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedCaller
  implements ConnectionDelegate
{
  protected static final int DEFAULT_TASK_TOKEN = 1;
  private boolean mConnected;
  protected Engine mEngine;
  private final Queue<Runnable> mQueue = new LinkedList();
  private final SparseArray<Runnable> mTaskTokens = new SparseArray();

  public ConnectedCaller(Engine paramEngine)
  {
    this.mEngine = paramEngine;
    paramEngine.getDelegatesManager().getConnectionListener().registerDelegate(new ConnectionDelegate[] { this });
  }

  private void run()
  {
    try
    {
      if ((this.mQueue.isEmpty()) || (!this.mConnected))
        return;
      LinkedList localLinkedList = new LinkedList(this.mQueue);
      this.mTaskTokens.clear();
      this.mQueue.clear();
      while (!localLinkedList.isEmpty())
        ((Runnable)localLinkedList.poll()).run();
    }
    finally
    {
    }
  }

  public final void onConnect()
  {
    run();
  }

  public final void onConnectionStateChange(int paramInt)
  {
    boolean bool;
    if (paramInt == 3)
      bool = true;
    try
    {
      this.mConnected = bool;
      return;
      bool = false;
    }
    finally
    {
    }
  }

  protected final void runOnConnect(int paramInt, Runnable paramRunnable)
  {
    if (paramInt != 0);
    try
    {
      Runnable localRunnable = (Runnable)this.mTaskTokens.get(paramInt);
      if (localRunnable != null)
        this.mQueue.remove(localRunnable);
      this.mTaskTokens.append(paramInt, paramRunnable);
      this.mQueue.add(paramRunnable);
      run();
      return;
    }
    finally
    {
    }
  }

  protected final void runOnConnect(Runnable paramRunnable)
  {
    runOnConnect(0, paramRunnable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.controller.ConnectedCaller
 * JD-Core Version:    0.6.2
 */