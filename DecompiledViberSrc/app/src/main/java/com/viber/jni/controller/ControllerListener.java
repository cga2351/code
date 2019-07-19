package com.viber.jni.controller;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ControllerListener<T>
{
  private static Handler sDefaultHandler;
  private final Logger L = ViberEnv.getLogger(getClass());
  private Map<T, Handler> mDelegatesHandlers = new LinkedHashMap();
  private Map<T, List<T>> mDelegatesQueues = new LinkedHashMap();
  private Map<T, List<T>> mDelegatesQueuesMap = new LinkedHashMap();
  private Handler mHandler;
  private List<T> mHeads = new ArrayList();

  public ControllerListener()
  {
    if (sDefaultHandler == null)
      throw new RuntimeException("ControllerListener has not been initialized yet");
    this.mHandler = sDefaultHandler;
  }

  public static void setDefaultHandler(Handler paramHandler)
  {
    sDefaultHandler = paramHandler;
  }

  public Handler getHandler()
  {
    return this.mHandler;
  }

  public void notifyListeners(ControllerListenerAction<T> paramControllerListenerAction)
  {
    new QueueNotifier(this.mHeads, paramControllerListenerAction).run();
  }

  public ControllerListener<T> registerDelegate(T paramT, Handler paramHandler)
  {
    registerDelegateQueue(paramT, paramHandler, (Object[])null);
    return this;
  }

  public ControllerListener<T> registerDelegate(T[] paramArrayOfT)
  {
    synchronized (this.mHeads)
    {
      int i = paramArrayOfT.length;
      for (int j = 0; j < i; j++)
        registerDelegateQueue(paramArrayOfT[j], this.mHandler, (Object[])null);
      return this;
    }
  }

  public ControllerListener<T> registerDelegateQueue(T paramT, Handler paramHandler, T[] paramArrayOfT)
  {
    if (paramHandler == null)
      paramHandler = this.mHandler;
    List localList1 = this.mHeads;
    List localList2 = null;
    while (true)
    {
      int j;
      T ?;
      try
      {
        if (!this.mDelegatesHandlers.containsKey(paramT))
        {
          this.mHeads.add(paramT);
          this.L.b("registerDelegateQueue head=?", new Object[] { paramT });
          this.mDelegatesHandlers.put(paramT, paramHandler);
          if (localList2 != null)
            break label401;
          ArrayList localArrayList = new ArrayList();
          this.mDelegatesQueues.put(paramT, localArrayList);
          localObject2 = localArrayList;
          if (paramArrayOfT == null)
            return this;
        }
        else
        {
          localList2 = (List)this.mDelegatesQueues.get(paramT);
          continue;
        }
        int i = paramArrayOfT.length;
        j = 0;
        if (j >= i)
          break label396;
        ? = paramArrayOfT[j];
        if (this.mHeads.contains(?))
          this.mHeads.remove(?);
        if (!this.mDelegatesHandlers.containsKey(?))
          this.mDelegatesHandlers.put(?, paramHandler);
        if ((this.mDelegatesQueuesMap.containsKey(?)) && (this.mDelegatesQueuesMap.get(?) != localObject2))
        {
          ((List)this.mDelegatesQueuesMap.get(?)).remove(?);
          throw new IllegalStateException("Delegate queues not allowed to be queued with two or more heads. Please resolve conflict manually. " + ?);
        }
      }
      finally
      {
      }
      this.mDelegatesQueuesMap.put(?, localObject2);
      try
      {
        if (!((List)localObject2).contains(?))
          ((List)localObject2).add(?);
        Logger localLogger = this.L;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = ?;
        arrayOfObject[1] = Integer.valueOf(this.mDelegatesQueuesMap.size());
        localLogger.b("registerDelegateQueue listener=? mDelegatesQueuesMap.size=?", arrayOfObject);
        j++;
        continue;
      }
      finally
      {
      }
      label396: return this;
      label401: Object localObject2 = localList2;
    }
  }

  public void removeDelegate(T paramT)
  {
    synchronized (this.mHeads)
    {
      this.mDelegatesHandlers.remove(paramT);
      this.mHeads.remove(paramT);
      this.mDelegatesQueues.remove(paramT);
      List localList2;
      if (this.mDelegatesQueuesMap.containsKey(paramT))
      {
        localList2 = (List)this.mDelegatesQueuesMap.remove(paramT);
        if (localList2 == null);
      }
      try
      {
        localList2.remove(paramT);
        Logger localLogger = this.L;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramT;
        arrayOfObject[1] = Integer.valueOf(this.mDelegatesQueuesMap.size());
        localLogger.b("removeDelegate listener=? mDelegatesQueuesMap.size=?", arrayOfObject);
        return;
      }
      finally
      {
      }
    }
  }

  public void setHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }

  public static abstract interface ControllerListenerAction<K>
  {
    public abstract void execute(K paramK);
  }

  private class QueueNotifier
    implements Runnable
  {
    private ControllerListener.ControllerListenerAction<T> mAction;
    private T mItem;
    private List<T> mList;

    public QueueNotifier(List<T> paramControllerListenerAction, ControllerListener.ControllerListenerAction<T> arg3)
    {
      this.mItem = paramControllerListenerAction;
      Collection localCollection;
      if (localCollection != null)
        this.mList = new ArrayList(localCollection);
      Object localObject;
      this.mAction = localObject;
    }

    public QueueNotifier(ControllerListener.ControllerListenerAction<T> arg2)
    {
      this(null, localList, localControllerListenerAction);
    }

    public void run()
    {
      if (this.mItem != null)
        this.mAction.execute(this.mItem);
      if (this.mList == null);
      int i;
      int j;
      do
      {
        return;
        i = this.mList.size();
        j = 0;
      }
      while (j >= i);
      Object localObject1 = this.mList.get(j);
      if (ControllerListener.this.mDelegatesHandlers.containsKey(localObject1));
      while (true)
      {
        Handler localHandler;
        QueueNotifier localQueueNotifier;
        synchronized (ControllerListener.this.mHeads)
        {
          if (ControllerListener.this.mDelegatesHandlers.containsKey(localObject1))
          {
            localHandler = (Handler)ControllerListener.this.mDelegatesHandlers.get(localObject1);
            List localList2 = (List)ControllerListener.this.mDelegatesQueues.get(localObject1);
            localQueueNotifier = new QueueNotifier(ControllerListener.this, localObject1, localList2, this.mAction);
            if (localHandler != null)
              break label189;
            localQueueNotifier.run();
            j++;
            break;
          }
        }
        label189: localHandler.post(localQueueNotifier);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.controller.ControllerListener
 * JD-Core Version:    0.6.2
 */