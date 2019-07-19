package com.facebook.common.references;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.PropagatesNullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class CloseableReference<T>
  implements Closeable, Cloneable
{
  private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser()
  {
    public void release(Closeable paramAnonymousCloseable)
    {
      try
      {
        Closeables.close(paramAnonymousCloseable, true);
        return;
      }
      catch (IOException localIOException)
      {
      }
    }
  };
  private static Class<CloseableReference> TAG = CloseableReference.class;

  @GuardedBy("this")
  private boolean mIsClosed = false;
  private final SharedReference<T> mSharedReference;

  private CloseableReference(SharedReference<T> paramSharedReference)
  {
    this.mSharedReference = ((SharedReference)Preconditions.checkNotNull(paramSharedReference));
    paramSharedReference.addReference();
  }

  private CloseableReference(T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    this.mSharedReference = new SharedReference(paramT, paramResourceReleaser);
  }

  @Nullable
  public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> paramCloseableReference)
  {
    if (paramCloseableReference != null)
      return paramCloseableReference.cloneOrNull();
    return null;
  }

  public static <T> List<CloseableReference<T>> cloneOrNull(@PropagatesNullable Collection<CloseableReference<T>> paramCollection)
  {
    if (paramCollection == null)
      return null;
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localArrayList.add(cloneOrNull((CloseableReference)localIterator.next()));
    return localArrayList;
  }

  public static void closeSafely(@Nullable CloseableReference<?> paramCloseableReference)
  {
    if (paramCloseableReference != null)
      paramCloseableReference.close();
  }

  public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> paramIterable)
  {
    if (paramIterable != null)
    {
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
        closeSafely((CloseableReference)localIterator.next());
    }
  }

  public static boolean isValid(@Nullable CloseableReference<?> paramCloseableReference)
  {
    return (paramCloseableReference != null) && (paramCloseableReference.isValid());
  }

  public static <T extends Closeable> CloseableReference<T> of(@PropagatesNullable T paramT)
  {
    if (paramT == null)
      return null;
    return new CloseableReference(paramT, DEFAULT_CLOSEABLE_RELEASER);
  }

  public static <T> CloseableReference<T> of(@PropagatesNullable T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    if (paramT == null)
      return null;
    return new CloseableReference(paramT, paramResourceReleaser);
  }

  public CloseableReference<T> clone()
  {
    try
    {
      Preconditions.checkState(isValid());
      CloseableReference localCloseableReference = new CloseableReference(this.mSharedReference);
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  public CloseableReference<T> cloneOrNull()
  {
    try
    {
      if (isValid())
      {
        CloseableReference localCloseableReference2 = clone();
        localCloseableReference1 = localCloseableReference2;
        return localCloseableReference1;
      }
      CloseableReference localCloseableReference1 = null;
    }
    finally
    {
    }
  }

  public void close()
  {
    try
    {
      if (this.mIsClosed)
        return;
      this.mIsClosed = true;
      this.mSharedReference.deleteReference();
      return;
    }
    finally
    {
    }
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      try
      {
        if (this.mIsClosed)
          return;
        Class localClass = TAG;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(System.identityHashCode(this));
        arrayOfObject[1] = Integer.valueOf(System.identityHashCode(this.mSharedReference));
        arrayOfObject[2] = this.mSharedReference.get().getClass().getName();
        FLog.w(localClass, "Finalized without closing: %x %x (type = %s)", arrayOfObject);
        close();
        return;
      }
      finally
      {
      }
    }
    finally
    {
      super.finalize();
    }
  }

  public T get()
  {
    try
    {
      if (!this.mIsClosed);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        Object localObject2 = this.mSharedReference.get();
        return localObject2;
      }
    }
    finally
    {
    }
  }

  @VisibleForTesting
  public SharedReference<T> getUnderlyingReferenceTestOnly()
  {
    try
    {
      SharedReference localSharedReference = this.mSharedReference;
      return localSharedReference;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getValueHash()
  {
    if (isValid())
      return System.identityHashCode(this.mSharedReference.get());
    return 0;
  }

  public boolean isValid()
  {
    try
    {
      boolean bool1 = this.mIsClosed;
      if (!bool1)
      {
        bool2 = true;
        return bool2;
      }
      boolean bool2 = false;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.references.CloseableReference
 * JD-Core Version:    0.6.2
 */