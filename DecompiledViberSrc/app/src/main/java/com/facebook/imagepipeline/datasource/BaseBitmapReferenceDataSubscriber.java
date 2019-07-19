package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import javax.annotation.Nullable;

public abstract class BaseBitmapReferenceDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>>
{
  protected abstract void onNewResultImpl(@Nullable CloseableReference<Bitmap> paramCloseableReference);

  public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> paramDataSource)
  {
    if (!paramDataSource.isFinished())
      return;
    CloseableReference localCloseableReference1 = (CloseableReference)paramDataSource.getResult();
    CloseableReference localCloseableReference2 = null;
    if (localCloseableReference1 != null)
    {
      boolean bool = localCloseableReference1.get() instanceof CloseableStaticBitmap;
      localCloseableReference2 = null;
      if (bool)
        localCloseableReference2 = ((CloseableStaticBitmap)localCloseableReference1.get()).convertToBitmapReference();
    }
    try
    {
      onNewResultImpl(localCloseableReference2);
      return;
    }
    finally
    {
      CloseableReference.closeSafely(localCloseableReference2);
      CloseableReference.closeSafely(localCloseableReference1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.datasource.BaseBitmapReferenceDataSubscriber
 * JD-Core Version:    0.6.2
 */