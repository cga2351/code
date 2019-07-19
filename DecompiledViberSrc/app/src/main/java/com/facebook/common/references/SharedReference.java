package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
public class SharedReference<T>
{

  @GuardedBy("itself")
  private static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();

  @GuardedBy("this")
  private int mRefCount;
  private final ResourceReleaser<T> mResourceReleaser;

  @GuardedBy("this")
  private T mValue;

  public SharedReference(T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    this.mValue = Preconditions.checkNotNull(paramT);
    this.mResourceReleaser = ((ResourceReleaser)Preconditions.checkNotNull(paramResourceReleaser));
    this.mRefCount = 1;
    addLiveReference(paramT);
  }

  private static void addLiveReference(Object paramObject)
  {
    synchronized (sLiveObjects)
    {
      Integer localInteger = (Integer)sLiveObjects.get(paramObject);
      if (localInteger == null)
      {
        sLiveObjects.put(paramObject, Integer.valueOf(1));
        return;
      }
      sLiveObjects.put(paramObject, Integer.valueOf(1 + localInteger.intValue()));
    }
  }

  private int decreaseRefCount()
  {
    try
    {
      ensureValid();
      if (this.mRefCount > 0);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        this.mRefCount = (-1 + this.mRefCount);
        int i = this.mRefCount;
        return i;
      }
    }
    finally
    {
    }
  }

  private void ensureValid()
  {
    if (!isValid(this))
      throw new NullReferenceException();
  }

  public static boolean isValid(SharedReference<?> paramSharedReference)
  {
    return (paramSharedReference != null) && (paramSharedReference.isValid());
  }

  private static void removeLiveReference(Object paramObject)
  {
    while (true)
    {
      Integer localInteger;
      synchronized (sLiveObjects)
      {
        localInteger = (Integer)sLiveObjects.get(paramObject);
        if (localInteger == null)
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = paramObject.getClass();
          FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", arrayOfObject);
          return;
        }
        if (localInteger.intValue() == 1)
          sLiveObjects.remove(paramObject);
      }
      sLiveObjects.put(paramObject, Integer.valueOf(-1 + localInteger.intValue()));
    }
  }

  public void addReference()
  {
    try
    {
      ensureValid();
      this.mRefCount = (1 + this.mRefCount);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void deleteReference()
  {
    if (decreaseRefCount() == 0);
    try
    {
      Object localObject2 = this.mValue;
      this.mValue = null;
      this.mResourceReleaser.release(localObject2);
      removeLiveReference(localObject2);
      return;
    }
    finally
    {
    }
  }

  public T get()
  {
    try
    {
      Object localObject2 = this.mValue;
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  public int getRefCountTestOnly()
  {
    try
    {
      int i = this.mRefCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isValid()
  {
    try
    {
      int i = this.mRefCount;
      if (i > 0)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public static class NullReferenceException extends RuntimeException
  {
    public NullReferenceException()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.references.SharedReference
 * JD-Core Version:    0.6.2
 */