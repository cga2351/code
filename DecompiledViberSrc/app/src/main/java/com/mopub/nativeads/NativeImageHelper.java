package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class NativeImageHelper
{
  public static void loadImageView(String paramString, ImageView paramImageView)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramImageView, "Cannot load image into null ImageView"))
      return;
    if (!Preconditions.NoThrow.checkNotNull(paramString, "Cannot load image with null url"))
    {
      paramImageView.setImageDrawable(null);
      return;
    }
    Networking.getImageLoader(paramImageView.getContext()).get(paramString, new ImageLoader.ImageListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Failed to load image.", paramAnonymousVolleyError });
        this.a.setImageDrawable(null);
      }

      public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Image was not loaded immediately into your ad view. You should call preCacheImages as part of your custom event loading process." });
        this.a.setImageBitmap(paramAnonymousImageContainer.getBitmap());
      }
    });
  }

  public static void preCacheImages(Context paramContext, List<String> paramList, final ImageListener paramImageListener)
  {
    ImageLoader localImageLoader = Networking.getImageLoader(paramContext);
    AtomicInteger localAtomicInteger = new AtomicInteger(paramList.size());
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    ImageLoader.ImageListener local1 = new ImageLoader.ImageListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Failed to download a native ads image:", paramAnonymousVolleyError });
        boolean bool = localAtomicBoolean.getAndSet(true);
        this.a.decrementAndGet();
        if (!bool)
          paramImageListener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
      }

      public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousImageContainer.getBitmap() != null) && (this.a.decrementAndGet() == 0) && (!localAtomicBoolean.get()))
          paramImageListener.onImagesCached();
      }
    };
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      String str;
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (TextUtils.isEmpty(str))
        {
          localAtomicBoolean.set(true);
          paramImageListener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
        }
      }
      else
      {
        return;
      }
      localImageLoader.get(str, local1);
    }
  }

  public static abstract interface ImageListener
  {
    public abstract void onImagesCached();

    public abstract void onImagesFailedToCache(NativeErrorCode paramNativeErrorCode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.NativeImageHelper
 * JD-Core Version:    0.6.2
 */