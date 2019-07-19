package com.vk.sdk.api.httpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

public class VKImageOperation extends VKHttpOperation<Bitmap>
{
  public float imageDensity;

  public VKImageOperation(String paramString)
  {
    super(new VKHttpClient.VKHTTPRequest(paramString));
  }

  public Bitmap getResultObject()
  {
    byte[] arrayOfByte = getResponseData();
    Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
    if (this.imageDensity > 0.0F)
      localBitmap = Bitmap.createScaledBitmap(localBitmap, (int)(localBitmap.getWidth() * this.imageDensity), (int)(localBitmap.getHeight() * this.imageDensity), true);
    return localBitmap;
  }

  public void setImageOperationListener(final VKImageOperationListener paramVKImageOperationListener)
  {
    setCompleteListener(new VKAbstractOperation.VKOperationCompleteListener()
    {
      public void onComplete()
      {
        if ((VKImageOperation.this.state() != VKAbstractOperation.VKOperationState.Finished) || (VKImageOperation.this.mLastException != null))
        {
          paramVKImageOperationListener.onError(VKImageOperation.this, VKImageOperation.this.generateError(VKImageOperation.this.mLastException));
          return;
        }
        final Bitmap localBitmap = VKImageOperation.this.getResultObject();
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            VKImageOperation.1.this.val$listener.onComplete(VKImageOperation.this, localBitmap);
          }
        });
      }
    });
  }

  public static abstract class VKImageOperationListener extends VKAbstractOperation.VKAbstractCompleteListener<VKImageOperation, Bitmap>
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.httpClient.VKImageOperation
 * JD-Core Version:    0.6.2
 */