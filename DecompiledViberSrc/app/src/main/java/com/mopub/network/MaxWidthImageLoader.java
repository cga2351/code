package com.mopub.network;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader.ImageCache;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

public class MaxWidthImageLoader extends ImageLoader
{
  private final int a;

  public MaxWidthImageLoader(RequestQueue paramRequestQueue, Context paramContext, ImageLoader.ImageCache paramImageCache)
  {
    super(paramRequestQueue, paramImageCache);
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    this.a = Math.min(localPoint.x, localPoint.y);
  }

  public ImageLoader.ImageContainer get(String paramString, ImageLoader.ImageListener paramImageListener)
  {
    return super.get(paramString, paramImageListener, this.a, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.MaxWidthImageLoader
 * JD-Core Version:    0.6.2
 */