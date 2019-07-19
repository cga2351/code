package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>>
{
  public void onNewResultImpl(DataSource<List<CloseableReference<CloseableImage>>> paramDataSource)
  {
    if (!paramDataSource.isFinished())
      return;
    List localList = (List)paramDataSource.getResult();
    if (localList == null)
    {
      onNewResultListImpl(null);
      return;
    }
    try
    {
      localArrayList = new ArrayList(localList.size());
      Iterator localIterator2 = localList.iterator();
      while (true)
      {
        if (!localIterator2.hasNext())
          break label158;
        CloseableReference localCloseableReference = (CloseableReference)localIterator2.next();
        if ((localCloseableReference == null) || (!(localCloseableReference.get() instanceof CloseableBitmap)))
          break;
        localArrayList.add(((CloseableBitmap)localCloseableReference.get()).getUnderlyingBitmap());
      }
    }
    finally
    {
      ArrayList localArrayList;
      while (true)
      {
        Iterator localIterator1 = localList.iterator();
        while (localIterator1.hasNext())
          CloseableReference.closeSafely((CloseableReference)localIterator1.next());
        localArrayList.add(null);
      }
      label158: onNewResultListImpl(localArrayList);
      Iterator localIterator3 = localList.iterator();
      while (localIterator3.hasNext())
        CloseableReference.closeSafely((CloseableReference)localIterator3.next());
    }
  }

  protected abstract void onNewResultListImpl(List<Bitmap> paramList);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.datasource.BaseListBitmapDataSubscriber
 * JD-Core Version:    0.6.2
 */