package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public class BitmapCounter
{

  @GuardedBy("this")
  private int mCount;
  private final int mMaxCount;
  private final int mMaxSize;

  @GuardedBy("this")
  private long mSize;
  private final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

  public BitmapCounter(int paramInt1, int paramInt2)
  {
    boolean bool2;
    if (paramInt1 > 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramInt2 <= 0)
        break label55;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.mMaxCount = paramInt1;
      this.mMaxSize = paramInt2;
      this.mUnpooledBitmapsReleaser = new ResourceReleaser()
      {
        public void release(Bitmap paramAnonymousBitmap)
        {
          try
          {
            BitmapCounter.this.decrease(paramAnonymousBitmap);
            return;
          }
          finally
          {
            paramAnonymousBitmap.recycle();
          }
        }
      };
      return;
      bool2 = false;
      break;
      label55: bool1 = false;
    }
  }

  public List<CloseableReference<Bitmap>> associateBitmapsWithBitmapCounter(List<Bitmap> paramList)
  {
    int i = 0;
    ArrayList localArrayList;
    try
    {
      if (i < paramList.size())
      {
        Bitmap localBitmap2 = (Bitmap)paramList.get(i);
        if (Build.VERSION.SDK_INT < 21)
          Bitmaps.pinBitmap(localBitmap2);
        if (!increase(localBitmap2))
          throw new TooManyBitmapsException();
      }
    }
    catch (Exception localException)
    {
      while (paramList != null)
      {
        Iterator localIterator1 = paramList.iterator();
        while (true)
          if (localIterator1.hasNext())
          {
            Bitmap localBitmap1 = (Bitmap)localIterator1.next();
            int j = i - 1;
            if (i > 0)
              decrease(localBitmap1);
            localBitmap1.recycle();
            i = j;
            continue;
            i++;
            break;
            localArrayList = new ArrayList(paramList.size());
            Iterator localIterator2 = paramList.iterator();
            while (localIterator2.hasNext())
              localArrayList.add(CloseableReference.of((Bitmap)localIterator2.next(), this.mUnpooledBitmapsReleaser));
          }
      }
      throw Throwables.propagate(localException);
    }
    return localArrayList;
  }

  public void decrease(Bitmap paramBitmap)
  {
    boolean bool1 = true;
    try
    {
      int i = BitmapUtil.getSizeInBytes(paramBitmap);
      boolean bool2;
      if (this.mCount > 0)
      {
        bool2 = bool1;
        Preconditions.checkArgument(bool2, "No bitmaps registered.");
        if (i > this.mSize)
          break label103;
      }
      while (true)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(i);
        arrayOfObject[1] = Long.valueOf(this.mSize);
        Preconditions.checkArgument(bool1, "Bitmap size bigger than the total registered size: %d, %d", arrayOfObject);
        this.mSize -= i;
        this.mCount = (-1 + this.mCount);
        return;
        bool2 = false;
        break;
        label103: bool1 = false;
      }
    }
    finally
    {
    }
  }

  public int getCount()
  {
    try
    {
      int i = this.mCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getMaxCount()
  {
    try
    {
      int i = this.mMaxCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getMaxSize()
  {
    try
    {
      int i = this.mMaxSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public ResourceReleaser<Bitmap> getReleaser()
  {
    return this.mUnpooledBitmapsReleaser;
  }

  public long getSize()
  {
    try
    {
      long l = this.mSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean increase(Bitmap paramBitmap)
  {
    try
    {
      int i = BitmapUtil.getSizeInBytes(paramBitmap);
      if (this.mCount < this.mMaxCount)
      {
        long l = this.mSize + i;
        int j = this.mMaxSize;
        if (l <= j)
          break label50;
      }
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        label50: this.mCount = (1 + this.mCount);
        this.mSize += i;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.BitmapCounter
 * JD-Core Version:    0.6.2
 */