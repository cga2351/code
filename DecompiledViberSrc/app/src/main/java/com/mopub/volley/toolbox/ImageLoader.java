package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ImageLoader
{
  private final RequestQueue a;
  private int b = 100;
  private final ImageCache c;
  private final HashMap<String, a> d = new HashMap();
  private final HashMap<String, a> e = new HashMap();
  private final Handler f = new Handler(Looper.getMainLooper());
  private Runnable g;

  public ImageLoader(RequestQueue paramRequestQueue, ImageCache paramImageCache)
  {
    this.a = paramRequestQueue;
    this.c = paramImageCache;
  }

  private static String a(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    return 12 + paramString.length() + "#W" + paramInt1 + "#H" + paramInt2 + "#S" + paramScaleType.ordinal() + paramString;
  }

  private void a(String paramString, a parama)
  {
    this.e.put(paramString, parama);
    if (this.g == null)
    {
      this.g = new Runnable()
      {
        public void run()
        {
          Iterator localIterator1 = ImageLoader.b(ImageLoader.this).values().iterator();
          while (localIterator1.hasNext())
          {
            ImageLoader.a locala = (ImageLoader.a)localIterator1.next();
            Iterator localIterator2 = ImageLoader.a.a(locala).iterator();
            while (localIterator2.hasNext())
            {
              ImageLoader.ImageContainer localImageContainer = (ImageLoader.ImageContainer)localIterator2.next();
              if (ImageLoader.ImageContainer.a(localImageContainer) != null)
                if (locala.getError() == null)
                {
                  ImageLoader.ImageContainer.a(localImageContainer, ImageLoader.a.b(locala));
                  ImageLoader.ImageContainer.a(localImageContainer).onResponse(localImageContainer, false);
                }
                else
                {
                  ImageLoader.ImageContainer.a(localImageContainer).onErrorResponse(locala.getError());
                }
            }
          }
          ImageLoader.b(ImageLoader.this).clear();
          ImageLoader.a(ImageLoader.this, null);
        }
      };
      this.f.postDelayed(this.g, this.b);
    }
  }

  public static ImageListener getImageListener(final ImageView paramImageView, final int paramInt1, int paramInt2)
  {
    return new ImageListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        if (this.a != 0)
          paramImageView.setImageResource(this.a);
      }

      public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousImageContainer.getBitmap() != null)
          paramImageView.setImageBitmap(paramAnonymousImageContainer.getBitmap());
        while (paramInt1 == 0)
          return;
        paramImageView.setImageResource(paramInt1);
      }
    };
  }

  protected Request<Bitmap> a(String paramString1, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, final String paramString2)
  {
    return new ImageRequest(paramString1, new Response.Listener()
    {
      public void onResponse(Bitmap paramAnonymousBitmap)
      {
        ImageLoader.this.a(paramString2, paramAnonymousBitmap);
      }
    }
    , paramInt1, paramInt2, paramScaleType, Bitmap.Config.RGB_565, new Response.ErrorListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        ImageLoader.this.a(paramString2, paramAnonymousVolleyError);
      }
    });
  }

  protected void a(String paramString, Bitmap paramBitmap)
  {
    this.c.putBitmap(paramString, paramBitmap);
    a locala = (a)this.d.remove(paramString);
    if (locala != null)
    {
      a.a(locala, paramBitmap);
      a(paramString, locala);
    }
  }

  protected void a(String paramString, VolleyError paramVolleyError)
  {
    a locala = (a)this.d.remove(paramString);
    if (locala != null)
    {
      locala.setError(paramVolleyError);
      a(paramString, locala);
    }
  }

  public ImageContainer get(String paramString, ImageListener paramImageListener)
  {
    return get(paramString, paramImageListener, 0, 0);
  }

  public ImageContainer get(String paramString, ImageListener paramImageListener, int paramInt1, int paramInt2)
  {
    return get(paramString, paramImageListener, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }

  public ImageContainer get(String paramString, ImageListener paramImageListener, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    a.a();
    String str = a(paramString, paramInt1, paramInt2, paramScaleType);
    Bitmap localBitmap = this.c.getBitmap(str);
    if (localBitmap != null)
    {
      ImageContainer localImageContainer1 = new ImageContainer(localBitmap, paramString, null, null);
      paramImageListener.onResponse(localImageContainer1, true);
      return localImageContainer1;
    }
    ImageContainer localImageContainer2 = new ImageContainer(null, paramString, str, paramImageListener);
    paramImageListener.onResponse(localImageContainer2, true);
    a locala = (a)this.d.get(str);
    if (locala == null)
      locala = (a)this.e.get(str);
    if (locala != null)
    {
      locala.addContainer(localImageContainer2);
      return localImageContainer2;
    }
    Request localRequest = a(paramString, paramInt1, paramInt2, paramScaleType, str);
    this.a.add(localRequest);
    this.d.put(str, new a(localRequest, localImageContainer2));
    return localImageContainer2;
  }

  public boolean isCached(String paramString, int paramInt1, int paramInt2)
  {
    return isCached(paramString, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }

  public boolean isCached(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    a.a();
    String str = a(paramString, paramInt1, paramInt2, paramScaleType);
    return this.c.getBitmap(str) != null;
  }

  public void setBatchedResponseDelay(int paramInt)
  {
    this.b = paramInt;
  }

  public static abstract interface ImageCache
  {
    public abstract Bitmap getBitmap(String paramString);

    public abstract void putBitmap(String paramString, Bitmap paramBitmap);
  }

  public class ImageContainer
  {
    private Bitmap b;
    private final ImageLoader.ImageListener c;
    private final String d;
    private final String e;

    public ImageContainer(Bitmap paramString1, String paramString2, String paramImageListener, ImageLoader.ImageListener arg5)
    {
      this.b = paramString1;
      this.e = paramString2;
      this.d = paramImageListener;
      Object localObject;
      this.c = localObject;
    }

    public void cancelRequest()
    {
      a.a();
      if (this.c == null);
      ImageLoader.a locala2;
      do
      {
        do
        {
          ImageLoader.a locala1;
          do
          {
            return;
            locala1 = (ImageLoader.a)ImageLoader.a(ImageLoader.this).get(this.d);
            if (locala1 == null)
              break;
          }
          while (!locala1.removeContainerAndCancelIfNecessary(this));
          ImageLoader.a(ImageLoader.this).remove(this.d);
          return;
          locala2 = (ImageLoader.a)ImageLoader.b(ImageLoader.this).get(this.d);
        }
        while (locala2 == null);
        locala2.removeContainerAndCancelIfNecessary(this);
      }
      while (ImageLoader.a.a(locala2).size() != 0);
      ImageLoader.b(ImageLoader.this).remove(this.d);
    }

    public Bitmap getBitmap()
    {
      return this.b;
    }

    public String getRequestUrl()
    {
      return this.e;
    }
  }

  public static abstract interface ImageListener extends Response.ErrorListener
  {
    public abstract void onResponse(ImageLoader.ImageContainer paramImageContainer, boolean paramBoolean);
  }

  private static class a
  {
    private final Request<?> a;
    private Bitmap b;
    private VolleyError c;
    private final List<ImageLoader.ImageContainer> d = new ArrayList();

    public a(Request<?> paramRequest, ImageLoader.ImageContainer paramImageContainer)
    {
      this.a = paramRequest;
      this.d.add(paramImageContainer);
    }

    public void addContainer(ImageLoader.ImageContainer paramImageContainer)
    {
      this.d.add(paramImageContainer);
    }

    public VolleyError getError()
    {
      return this.c;
    }

    public boolean removeContainerAndCancelIfNecessary(ImageLoader.ImageContainer paramImageContainer)
    {
      this.d.remove(paramImageContainer);
      if (this.d.size() == 0)
      {
        this.a.cancel();
        return true;
      }
      return false;
    }

    public void setError(VolleyError paramVolleyError)
    {
      this.c = paramVolleyError;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.ImageLoader
 * JD-Core Version:    0.6.2
 */