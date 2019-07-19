package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.b.b;
import android.arch.a.b.b.d;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  private static final Object NOT_SET = new Object();
  static final int START_VERSION = -1;
  private int mActiveCount = 0;
  private volatile Object mData = NOT_SET;
  private final Object mDataLock = new Object();
  private boolean mDispatchInvalidated;
  private boolean mDispatchingValue;
  private b<n<T>, LiveData<T>.b> mObservers = new b();
  private volatile Object mPendingData = NOT_SET;
  private final Runnable mPostValueRunnable = new Runnable()
  {
    public void run()
    {
      synchronized (LiveData.this.mDataLock)
      {
        Object localObject3 = LiveData.this.mPendingData;
        LiveData.access$102(LiveData.this, LiveData.NOT_SET);
        LiveData.this.setValue(localObject3);
        return;
      }
    }
  };
  private int mVersion = -1;

  private static void assertMainThread(String paramString)
  {
    if (!a.a().b())
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background" + " thread");
  }

  private void considerNotify(LiveData<T>.b paramLiveData)
  {
    if (!paramLiveData.d);
    do
    {
      return;
      if (!paramLiveData.a())
      {
        paramLiveData.a(false);
        return;
      }
    }
    while (paramLiveData.e >= this.mVersion);
    paramLiveData.e = this.mVersion;
    paramLiveData.c.onChanged(this.mData);
  }

  private void dispatchingValue(LiveData<T>.b paramLiveData)
  {
    if (this.mDispatchingValue)
    {
      this.mDispatchInvalidated = true;
      return;
    }
    this.mDispatchingValue = true;
    label93: 
    while (true)
    {
      this.mDispatchInvalidated = false;
      if (paramLiveData != null)
      {
        considerNotify(paramLiveData);
        paramLiveData = null;
      }
      while (true)
      {
        if (this.mDispatchInvalidated)
          break label93;
        this.mDispatchingValue = false;
        return;
        b.d locald = this.mObservers.c();
        if (locald.hasNext())
        {
          considerNotify((b)((Map.Entry)locald.next()).getValue());
          if (!this.mDispatchInvalidated)
            break;
        }
      }
    }
  }

  public T getValue()
  {
    Object localObject = this.mData;
    if (localObject != NOT_SET)
      return localObject;
    return null;
  }

  int getVersion()
  {
    return this.mVersion;
  }

  public boolean hasActiveObservers()
  {
    return this.mActiveCount > 0;
  }

  public boolean hasObservers()
  {
    return this.mObservers.a() > 0;
  }

  public void observe(h paramh, n<T> paramn)
  {
    if (paramh.getLifecycle().a() == e.b.a);
    LifecycleBoundObserver localLifecycleBoundObserver;
    b localb;
    do
    {
      return;
      localLifecycleBoundObserver = new LifecycleBoundObserver(paramh, paramn);
      localb = (b)this.mObservers.a(paramn, localLifecycleBoundObserver);
      if ((localb != null) && (!localb.a(paramh)))
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    while (localb != null);
    paramh.getLifecycle().a(localLifecycleBoundObserver);
  }

  public void observeForever(n<T> paramn)
  {
    a locala = new a(paramn);
    b localb = (b)this.mObservers.a(paramn, locala);
    if ((localb != null) && ((localb instanceof LifecycleBoundObserver)))
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    if (localb != null)
      return;
    locala.a(true);
  }

  protected void onActive()
  {
  }

  protected void onInactive()
  {
  }

  protected void postValue(T paramT)
  {
    while (true)
    {
      synchronized (this.mDataLock)
      {
        if (this.mPendingData != NOT_SET)
          break label49;
        i = 1;
        this.mPendingData = paramT;
        if (i == 0)
          return;
      }
      a.a().b(this.mPostValueRunnable);
      return;
      label49: int i = 0;
    }
  }

  public void removeObserver(n<T> paramn)
  {
    assertMainThread("removeObserver");
    b localb = (b)this.mObservers.b(paramn);
    if (localb == null)
      return;
    localb.b();
    localb.a(false);
  }

  public void removeObservers(h paramh)
  {
    assertMainThread("removeObservers");
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((b)localEntry.getValue()).a(paramh))
        removeObserver((n)localEntry.getKey());
    }
  }

  protected void setValue(T paramT)
  {
    assertMainThread("setValue");
    this.mVersion = (1 + this.mVersion);
    this.mData = paramT;
    dispatchingValue(null);
  }

  class LifecycleBoundObserver extends LiveData<T>.b
    implements GenericLifecycleObserver
  {
    final h a;

    LifecycleBoundObserver(n<T> arg2)
    {
      super(localn);
      Object localObject;
      this.a = localObject;
    }

    public void a(h paramh, e.a parama)
    {
      if (this.a.getLifecycle().a() == e.b.a)
      {
        LiveData.this.removeObserver(this.c);
        return;
      }
      a(a());
    }

    boolean a()
    {
      return this.a.getLifecycle().a().a(e.b.d);
    }

    boolean a(h paramh)
    {
      return this.a == paramh;
    }

    void b()
    {
      this.a.getLifecycle().b(this);
    }
  }

  private class a extends LiveData<T>.b
  {
    a()
    {
      super(localn);
    }

    boolean a()
    {
      return true;
    }
  }

  private abstract class b
  {
    final n<T> c;
    boolean d;
    int e = -1;

    b()
    {
      Object localObject;
      this.c = localObject;
    }

    void a(boolean paramBoolean)
    {
      int i = 1;
      if (paramBoolean == this.d)
        return;
      this.d = paramBoolean;
      int j;
      label28: LiveData localLiveData;
      int k;
      if (LiveData.this.mActiveCount == 0)
      {
        j = i;
        localLiveData = LiveData.this;
        k = localLiveData.mActiveCount;
        if (!this.d)
          break label121;
      }
      while (true)
      {
        LiveData.access$302(localLiveData, i + k);
        if ((j != 0) && (this.d))
          LiveData.this.onActive();
        if ((LiveData.this.mActiveCount == 0) && (!this.d))
          LiveData.this.onInactive();
        if (!this.d)
          break;
        LiveData.this.dispatchingValue(this);
        return;
        j = 0;
        break label28;
        label121: i = -1;
      }
    }

    abstract boolean a();

    boolean a(h paramh)
    {
      return false;
    }

    void b()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.LiveData
 * JD-Core Version:    0.6.2
 */