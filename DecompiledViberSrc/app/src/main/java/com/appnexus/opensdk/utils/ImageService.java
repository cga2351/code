package com.appnexus.opensdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ImageService
{
  HashMap<String, String> a = new HashMap();
  ImageServiceListener b;
  private ImageReceiver c;

  private void a()
  {
    this.a = null;
    this.b = null;
  }

  public void execute()
  {
    if (this.b == null)
      a();
    while (true)
    {
      return;
      if ((this.a == null) || (this.a.isEmpty()))
        break;
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a locala = new a(this.c, (String)localEntry.getKey(), (String)localEntry.getValue(), this);
        Clog.d(Clog.baseLogTag, "Downloading " + localEntry.getKey() + " from url: " + localEntry.getValue());
        locala.execute(new Void[0]);
      }
    }
    this.b.onAllImageDownloadsFinish();
    a();
  }

  public void finishDownload(String paramString)
  {
    if ((this.a != null) && (this.a.containsKey(paramString)))
    {
      this.a.remove(paramString);
      if (this.a.size() == 0)
      {
        this.b.onAllImageDownloadsFinish();
        Clog.d(Clog.baseLogTag, "Images downloading finished.");
        a();
      }
    }
  }

  public void registerImageReceiver(ImageReceiver paramImageReceiver, HashMap<String, String> paramHashMap)
  {
    if ((paramImageReceiver != null) && (paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      this.c = paramImageReceiver;
      this.a = paramHashMap;
    }
  }

  public void registerNotification(ImageServiceListener paramImageServiceListener)
  {
    this.b = paramImageServiceListener;
  }

  public static abstract interface ImageReceiver
  {
    public abstract void onFail(String paramString);

    public abstract void onReceiveImage(String paramString, Bitmap paramBitmap);
  }

  public static abstract interface ImageServiceListener
  {
    public abstract void onAllImageDownloadsFinish();
  }

  class a extends AsyncTask<Void, Void, Bitmap>
  {
    WeakReference<ImageService> a;
    WeakReference<ImageService.ImageReceiver> b;
    String c;
    private final String e;

    a(ImageService.ImageReceiver paramString1, String paramString2, String paramImageService, ImageService arg5)
    {
      Object localObject;
      this.a = new WeakReference(localObject);
      this.b = new WeakReference(paramString1);
      this.c = paramImageService;
      this.e = paramString2;
    }

    protected Bitmap a(Void[] paramArrayOfVoid)
    {
      if ((isCancelled()) || (StringUtil.isEmpty(this.c)))
        return null;
      try
      {
        URLConnection localURLConnection = new URL(this.c).openConnection();
        localURLConnection.setReadTimeout(10000);
        InputStream localInputStream = (InputStream)localURLConnection.getContent();
        Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
        localInputStream.close();
        return localBitmap;
      }
      catch (Exception localException)
      {
      }
      return null;
    }

    protected void a(Bitmap paramBitmap)
    {
      ImageService.ImageReceiver localImageReceiver = (ImageService.ImageReceiver)this.b.get();
      ImageService localImageService = (ImageService)this.a.get();
      if (localImageReceiver != null)
      {
        if (paramBitmap != null)
          break label53;
        localImageReceiver.onFail(this.c);
      }
      while (true)
      {
        if (localImageService != null)
          localImageService.finishDownload(this.e);
        return;
        label53: localImageReceiver.onReceiveImage(this.e, paramBitmap);
      }
    }

    protected void onCancelled()
    {
      super.onCancelled();
      this.b.clear();
      this.a.clear();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.ImageService
 * JD-Core Version:    0.6.2
 */