package com.viber.voip.messages.orm.service.uiwrapper;

import android.os.Handler;
import android.util.SparseArray;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.orm.service.EntityService;
import com.viber.voip.messages.orm.service.ServiceCallback;
import com.viber.voip.model.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class ServiceWrapper<T extends EntityService<? extends d>>
{
  private static final int DESTROY_CONTACTS_DELAY = 1000;
  private Handler uiHandler = av.a(av.e.a);
  private SparseArray<ServiceWrapper<T>.InternalWrapper> wrappers = new SparseArray();

  protected abstract T createInstance(ServiceCallback paramServiceCallback);

  public ServiceWrapper<T>.InternalWrapper getServiceWrapper(int paramInt)
  {
    InternalWrapper localInternalWrapper = (InternalWrapper)this.wrappers.get(paramInt);
    if (localInternalWrapper == null)
    {
      localInternalWrapper = new InternalWrapper();
      this.wrappers.append(paramInt, localInternalWrapper);
    }
    return localInternalWrapper;
  }

  protected abstract void onDestroy(T paramT, ServiceCallback paramServiceCallback);

  public class InternalWrapper
    implements ServiceCallback
  {
    private Set<ServiceCallback> mCallbacks = new HashSet();
    private T mService;
    private int refCount;

    public InternalWrapper()
    {
    }

    public void destroy()
    {
      try
      {
        this.refCount = (-1 + this.refCount);
        if (this.refCount == 0)
        {
          if (this.mService != null)
            ServiceWrapper.this.onDestroy(this.mService, this);
          this.mService = null;
        }
        return;
      }
      finally
      {
      }
    }

    public T getInstance(ServiceCallback paramServiceCallback)
    {
      try
      {
        this.mCallbacks.add(paramServiceCallback);
        if (this.mService == null)
          this.mService = ServiceWrapper.this.createInstance(this);
        this.refCount = (1 + this.refCount);
        EntityService localEntityService = this.mService;
        return localEntityService;
      }
      finally
      {
      }
    }

    public boolean isPaused()
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
        if (!((ServiceCallback)localIterator.next()).isPaused())
          return false;
      return true;
    }

    public void onDataChange(EntityService<?> paramEntityService, int paramInt, d[] paramArrayOfd)
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
        ((ServiceCallback)localIterator.next()).onDataChange(paramEntityService, paramInt, paramArrayOfd);
    }

    public void onDataReady(EntityService<?> paramEntityService)
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
        ((ServiceCallback)localIterator.next()).onDataReady(paramEntityService);
    }

    public void start(ServiceCallback paramServiceCallback)
    {
      this.mCallbacks.add(paramServiceCallback);
    }

    public void stop(ServiceCallback paramServiceCallback)
    {
      this.mCallbacks.remove(paramServiceCallback);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.service.uiwrapper.ServiceWrapper
 * JD-Core Version:    0.6.2
 */