package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.ParseError;
import com.mopub.volley.Request;
import com.mopub.volley.Request.Priority;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyLog;

public class ImageRequest extends Request<Bitmap>
{
  public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0F;
  public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
  public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;
  private static final Object g = new Object();
  private final Object a = new Object();
  private Response.Listener<Bitmap> b;
  private final Bitmap.Config c;
  private final int d;
  private final int e;
  private final ImageView.ScaleType f;

  @Deprecated
  public ImageRequest(String paramString, Response.Listener<Bitmap> paramListener, int paramInt1, int paramInt2, Bitmap.Config paramConfig, Response.ErrorListener paramErrorListener)
  {
    this(paramString, paramListener, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE, paramConfig, paramErrorListener);
  }

  public ImageRequest(String paramString, Response.Listener<Bitmap> paramListener, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, Bitmap.Config paramConfig, Response.ErrorListener paramErrorListener)
  {
    super(0, paramString, paramErrorListener);
    setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0F));
    this.b = paramListener;
    this.c = paramConfig;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramScaleType;
  }

  static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    for (float f1 = 1.0F; f1 * 2.0F <= d1; f1 *= 2.0F);
    return (int)f1;
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageView.ScaleType paramScaleType)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
      paramInt1 = paramInt3;
    double d1;
    do
    {
      do
      {
        do
        {
          do
          {
            return paramInt1;
            if (paramScaleType != ImageView.ScaleType.FIT_XY)
              break;
          }
          while (paramInt1 != 0);
          return paramInt3;
          if (paramInt1 == 0)
            return (int)(paramInt2 / paramInt4 * paramInt3);
        }
        while (paramInt2 == 0);
        d1 = paramInt4 / paramInt3;
        if (paramScaleType != ImageView.ScaleType.CENTER_CROP)
          break;
      }
      while (d1 * paramInt1 >= paramInt2);
      return (int)(paramInt2 / d1);
    }
    while (d1 * paramInt1 <= paramInt2);
    return (int)(paramInt2 / d1);
  }

  private Response<Bitmap> b(NetworkResponse paramNetworkResponse)
  {
    byte[] arrayOfByte = paramNetworkResponse.data;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    Object localObject;
    if ((this.d == 0) && (this.e == 0))
    {
      localOptions.inPreferredConfig = this.c;
      localObject = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    while (localObject == null)
    {
      return Response.error(new ParseError(paramNetworkResponse));
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      int k = a(this.d, this.e, i, j, this.f);
      int m = a(this.e, this.d, j, i, this.f);
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = a(i, j, k, m);
      Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      if ((localBitmap != null) && ((localBitmap.getWidth() > k) || (localBitmap.getHeight() > m)))
      {
        localObject = Bitmap.createScaledBitmap(localBitmap, k, m, true);
        localBitmap.recycle();
      }
      else
      {
        localObject = localBitmap;
      }
    }
    return Response.success(localObject, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
  }

  protected Response<Bitmap> a(NetworkResponse paramNetworkResponse)
  {
    synchronized (g)
    {
      try
      {
        Response localResponse2 = b(paramNetworkResponse);
        return localResponse2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramNetworkResponse.data.length);
        arrayOfObject[1] = getUrl();
        VolleyLog.e("Caught OOM for %d byte image, url=%s", arrayOfObject);
        Response localResponse1 = Response.error(new ParseError(localOutOfMemoryError));
        return localResponse1;
      }
    }
  }

  protected void a(Bitmap paramBitmap)
  {
    synchronized (this.a)
    {
      Response.Listener localListener = this.b;
      if (localListener != null)
        localListener.onResponse(paramBitmap);
      return;
    }
  }

  public void cancel()
  {
    super.cancel();
    synchronized (this.a)
    {
      this.b = null;
      return;
    }
  }

  public Request.Priority getPriority()
  {
    return Request.Priority.LOW;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.ImageRequest
 * JD-Core Version:    0.6.2
 */