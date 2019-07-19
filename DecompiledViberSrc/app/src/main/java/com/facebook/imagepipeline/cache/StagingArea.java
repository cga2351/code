package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class StagingArea
{
  private static final Class<?> TAG = StagingArea.class;

  @GuardedBy("this")
  private Map<CacheKey, EncodedImage> mMap = new HashMap();

  public static StagingArea getInstance()
  {
    return new StagingArea();
  }

  private void logStats()
  {
    try
    {
      FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void clearAll()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      this.mMap.clear();
      for (int i = 0; i < localArrayList.size(); i++)
      {
        EncodedImage localEncodedImage = (EncodedImage)localArrayList.get(i);
        if (localEncodedImage != null)
          localEncodedImage.close();
      }
    }
    finally
    {
    }
  }

  public boolean containsKey(CacheKey paramCacheKey)
  {
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      boolean bool1 = this.mMap.containsKey(paramCacheKey);
      boolean bool2;
      if (!bool1)
        bool2 = false;
      while (true)
      {
        return bool2;
        synchronized ((EncodedImage)this.mMap.get(paramCacheKey))
        {
          if (!EncodedImage.isValid(???))
          {
            this.mMap.remove(paramCacheKey);
            Class localClass = TAG;
            Object[] arrayOfObject = new Object[3];
            arrayOfObject[0] = Integer.valueOf(System.identityHashCode(???));
            arrayOfObject[1] = paramCacheKey.getUriString();
            arrayOfObject[2] = Integer.valueOf(System.identityHashCode(paramCacheKey));
            FLog.w(localClass, "Found closed reference %d for key %s (%d)", arrayOfObject);
            bool2 = false;
            continue;
          }
          bool2 = true;
        }
      }
    }
    finally
    {
    }
  }

  public EncodedImage get(CacheKey paramCacheKey)
  {
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      Object localObject2 = (EncodedImage)this.mMap.get(paramCacheKey);
      if (localObject2 != null);
      try
      {
        if (!EncodedImage.isValid((EncodedImage)localObject2))
        {
          this.mMap.remove(paramCacheKey);
          Class localClass = TAG;
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = Integer.valueOf(System.identityHashCode(localObject2));
          arrayOfObject[1] = paramCacheKey.getUriString();
          arrayOfObject[2] = Integer.valueOf(System.identityHashCode(paramCacheKey));
          FLog.w(localClass, "Found closed reference %d for key %s (%d)", arrayOfObject);
        }
        EncodedImage localEncodedImage;
        for (localObject2 = null; ; localObject2 = localEncodedImage)
        {
          return localObject2;
          localEncodedImage = EncodedImage.cloneOrNull((EncodedImage)localObject2);
        }
      }
      finally
      {
      }
    }
    finally
    {
    }
  }

  public void put(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
      EncodedImage.closeSafely((EncodedImage)this.mMap.put(paramCacheKey, EncodedImage.cloneOrNull(paramEncodedImage)));
      logStats();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean remove(CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    EncodedImage localEncodedImage;
    try
    {
      localEncodedImage = (EncodedImage)this.mMap.remove(paramCacheKey);
      if (localEncodedImage == null)
        return false;
    }
    finally
    {
    }
    try
    {
      boolean bool = localEncodedImage.isValid();
      return bool;
    }
    finally
    {
      localEncodedImage.close();
    }
  }

  public boolean remove(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      Preconditions.checkNotNull(paramEncodedImage);
      Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
      EncodedImage localEncodedImage = (EncodedImage)this.mMap.get(paramCacheKey);
      boolean bool;
      if (localEncodedImage == null)
        bool = false;
      while (true)
      {
        return bool;
        CloseableReference localCloseableReference1 = localEncodedImage.getByteBufferRef();
        CloseableReference localCloseableReference2 = paramEncodedImage.getByteBufferRef();
        if ((localCloseableReference1 != null) && (localCloseableReference2 != null));
        try
        {
          Object localObject3 = localCloseableReference1.get();
          Object localObject4 = localCloseableReference2.get();
          if (localObject3 != localObject4)
          {
            CloseableReference.closeSafely(localCloseableReference2);
            CloseableReference.closeSafely(localCloseableReference1);
            EncodedImage.closeSafely(localEncodedImage);
            bool = false;
            continue;
          }
          this.mMap.remove(paramCacheKey);
          CloseableReference.closeSafely(localCloseableReference2);
          CloseableReference.closeSafely(localCloseableReference1);
          EncodedImage.closeSafely(localEncodedImage);
          logStats();
          bool = true;
        }
        finally
        {
          CloseableReference.closeSafely(localCloseableReference2);
          CloseableReference.closeSafely(localCloseableReference1);
          EncodedImage.closeSafely(localEncodedImage);
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.StagingArea
 * JD-Core Version:    0.6.2
 */