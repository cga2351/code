package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object zamg = new Object();
  private static HashSet<Uri> zamh = new HashSet();
  private static ImageManager zami;
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService zamj;
  private final zaa zamk;
  private final zak zaml;
  private final Map<zaa, ImageReceiver> zamm;
  private final Map<Uri, ImageReceiver> zamn;
  private final Map<Uri, Long> zamo;

  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new zal(Looper.getMainLooper());
    this.zamj = Executors.newFixedThreadPool(4);
    this.zamk = null;
    this.zaml = new zak();
    this.zamm = new HashMap();
    this.zamn = new HashMap();
    this.zamo = new HashMap();
  }

  public static ImageManager create(Context paramContext)
  {
    if (zami == null)
      zami = new ImageManager(paramContext, false);
    return zami;
  }

  private final Bitmap zaa(zab paramzab)
  {
    if (this.zamk == null)
      return null;
    return (Bitmap)this.zamk.get(paramzab);
  }

  private final void zaa(zaa paramzaa)
  {
    Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
    new zac(paramzaa).run();
  }

  public final void loadImage(ImageView paramImageView, int paramInt)
  {
    zaa(new zac(paramImageView, paramInt));
  }

  public final void loadImage(ImageView paramImageView, Uri paramUri)
  {
    zaa(new zac(paramImageView, paramUri));
  }

  public final void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    zac localzac = new zac(paramImageView, paramUri);
    localzac.zamw = paramInt;
    zaa(localzac);
  }

  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    zaa(new zad(paramOnImageLoadedListener, paramUri));
  }

  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    zad localzad = new zad(paramOnImageLoadedListener, paramUri);
    localzad.zamw = paramInt;
    zaa(localzad);
  }

  @KeepName
  private final class ImageReceiver extends ResultReceiver
  {
    private final Uri mUri;
    private final ArrayList<zaa> zamp;

    ImageReceiver(Uri arg2)
    {
      super();
      Object localObject;
      this.mUri = localObject;
      this.zamp = new ArrayList();
    }

    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zaf(ImageManager.this).execute(new ImageManager.zab(ImageManager.this, this.mUri, localParcelFileDescriptor));
    }

    public final void zab(zaa paramzaa)
    {
      Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
      this.zamp.add(paramzaa);
    }

    public final void zac(zaa paramzaa)
    {
      Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.zamp.remove(paramzaa);
    }

    public final void zace()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zab(ImageManager.this).sendBroadcast(localIntent);
    }
  }

  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }

  private static final class zaa extends LruCache<zab, Bitmap>
  {
  }

  private final class zab
    implements Runnable
  {
    private final Uri mUri;
    private final ParcelFileDescriptor zamr;

    public zab(Uri paramParcelFileDescriptor, ParcelFileDescriptor arg3)
    {
      this.mUri = paramParcelFileDescriptor;
      Object localObject;
      this.zamr = localObject;
    }

    public final void run()
    {
      Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      ParcelFileDescriptor localParcelFileDescriptor = this.zamr;
      Object localObject = null;
      boolean bool = false;
      if (localParcelFileDescriptor != null);
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(this.zamr.getFileDescriptor());
        localObject = localBitmap;
      }
      catch (OutOfMemoryError localIOException)
      {
        try
        {
          this.zamr.close();
          localCountDownLatch = new CountDownLatch(1);
          ImageManager.zag(ImageManager.this).post(new ImageManager.zad(ImageManager.this, this.mUri, localObject, bool, localCountDownLatch));
        }
        catch (IOException localIOException)
        {
          try
          {
            while (true)
            {
              CountDownLatch localCountDownLatch;
              localCountDownLatch.await();
              return;
              localOutOfMemoryError = localOutOfMemoryError;
              String str2 = String.valueOf(this.mUri);
              Log.e("ImageManager", 34 + String.valueOf(str2).length() + "OOM while loading bitmap for uri: " + str2, localOutOfMemoryError);
              bool = true;
              localObject = null;
            }
            localIOException = localIOException;
            Log.e("ImageManager", "closed failed", localIOException);
          }
          catch (InterruptedException localInterruptedException)
          {
            String str1 = String.valueOf(this.mUri);
            Log.w("ImageManager", 32 + String.valueOf(str1).length() + "Latch interrupted while posting " + str1);
          }
        }
      }
    }
  }

  private final class zac
    implements Runnable
  {
    private final zaa zams;

    public zac(zaa arg2)
    {
      Object localObject;
      this.zams = localObject;
    }

    public final void run()
    {
      Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
      ImageManager.ImageReceiver localImageReceiver1 = (ImageManager.ImageReceiver)ImageManager.zaa(ImageManager.this).get(this.zams);
      if (localImageReceiver1 != null)
      {
        ImageManager.zaa(ImageManager.this).remove(this.zams);
        localImageReceiver1.zac(this.zams);
      }
      zab localzab = this.zams.zamu;
      if (localzab.uri == null)
      {
        this.zams.zaa(ImageManager.zab(ImageManager.this), ImageManager.zac(ImageManager.this), true);
        return;
      }
      Bitmap localBitmap = ImageManager.zaa(ImageManager.this, localzab);
      if (localBitmap != null)
      {
        this.zams.zaa(ImageManager.zab(ImageManager.this), localBitmap, true);
        return;
      }
      Long localLong = (Long)ImageManager.zad(ImageManager.this).get(localzab.uri);
      if (localLong != null)
      {
        if (SystemClock.elapsedRealtime() - localLong.longValue() < 3600000L)
        {
          this.zams.zaa(ImageManager.zab(ImageManager.this), ImageManager.zac(ImageManager.this), true);
          return;
        }
        ImageManager.zad(ImageManager.this).remove(localzab.uri);
      }
      this.zams.zaa(ImageManager.zab(ImageManager.this), ImageManager.zac(ImageManager.this));
      ImageManager.ImageReceiver localImageReceiver2 = (ImageManager.ImageReceiver)ImageManager.zae(ImageManager.this).get(localzab.uri);
      if (localImageReceiver2 == null)
      {
        localImageReceiver2 = new ImageManager.ImageReceiver(ImageManager.this, localzab.uri);
        ImageManager.zae(ImageManager.this).put(localzab.uri, localImageReceiver2);
      }
      localImageReceiver2.zab(this.zams);
      if (!(this.zams instanceof zad))
        ImageManager.zaa(ImageManager.this).put(this.zams, localImageReceiver2);
      synchronized (ImageManager.zacc())
      {
        if (!ImageManager.zacd().contains(localzab.uri))
        {
          ImageManager.zacd().add(localzab.uri);
          localImageReceiver2.zace();
        }
        return;
      }
    }
  }

  private final class zad
    implements Runnable
  {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch zadq;
    private boolean zamt;

    public zad(Uri paramBitmap, Bitmap paramBoolean, boolean paramCountDownLatch, CountDownLatch arg5)
    {
      this.mUri = paramBitmap;
      this.mBitmap = paramBoolean;
      this.zamt = paramCountDownLatch;
      Object localObject;
      this.zadq = localObject;
    }

    public final void run()
    {
      Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
      int i;
      if (this.mBitmap != null)
        i = 1;
      while (ImageManager.zah(ImageManager.this) != null)
        if (this.zamt)
        {
          ImageManager.zah(ImageManager.this).evictAll();
          System.gc();
          this.zamt = false;
          ImageManager.zag(ImageManager.this).post(this);
          return;
          i = 0;
        }
        else if (i != 0)
        {
          ImageManager.zah(ImageManager.this).put(new zab(this.mUri), this.mBitmap);
        }
      ImageManager.ImageReceiver localImageReceiver = (ImageManager.ImageReceiver)ImageManager.zae(ImageManager.this).remove(this.mUri);
      if (localImageReceiver != null)
      {
        ArrayList localArrayList = ImageManager.ImageReceiver.zaa(localImageReceiver);
        int j = localArrayList.size();
        int k = 0;
        if (k < j)
        {
          zaa localzaa = (zaa)localArrayList.get(k);
          if (i != 0)
            localzaa.zaa(ImageManager.zab(ImageManager.this), this.mBitmap, false);
          while (true)
          {
            if (!(localzaa instanceof zad))
              ImageManager.zaa(ImageManager.this).remove(localzaa);
            k++;
            break;
            ImageManager.zad(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
            localzaa.zaa(ImageManager.zab(ImageManager.this), ImageManager.zac(ImageManager.this), false);
          }
        }
      }
      this.zadq.countDown();
      synchronized (ImageManager.zacc())
      {
        ImageManager.zacd().remove(this.mUri);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.6.2
 */