package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>>
{
  protected abstract void onNewResultImpl(@Nullable Bitmap paramBitmap);

  public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> paramDataSource)
  {
    if (!paramDataSource.isFinished())
      return;
    CloseableReference localCloseableReference = (CloseableReference)paramDataSource.getResult();
    Bitmap localBitmap = null;
    if (localCloseableReference != null)
    {
      boolean bool = localCloseableReference.get() instanceof CloseableBitmap;
      localBitmap = null;
      if (bool)
        localBitmap = ((CloseableBitmap)localCloseableReference.get()).getUnderlyingBitmap();
    }
    try
    {
      onNewResultImpl(localBitmap);
      return;
    }
    finally
    {
      CloseableReference.closeSafely(localCloseableReference);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
 * JD-Core Version:    0.6.2
 */