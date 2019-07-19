package com.viber.voip.stickers.c;

import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.AndroidSvgObject;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.stickers.e.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.p;
import com.viber.voip.stickers.x;
import com.viber.voip.util.at;
import com.viber.voip.util.e.j;
import java.io.File;
import java.io.IOException;

public abstract class a
{
  private static final Logger d = ViberEnv.getLogger();
  protected i a;
  protected final x b;
  protected b c = new b()
  {
    public void onStickerDeployed(final Sticker paramAnonymousSticker)
    {
      a.b(a.this).post(new Runnable()
      {
        public void run()
        {
          a.a(a.this).onStickerDeployed(paramAnonymousSticker);
        }
      });
    }

    public void onStickerPackageDeployed(final com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      a.b(a.this).post(new Runnable()
      {
        public void run()
        {
          a.a(a.this).onStickerPackageDeployed(paramAnonymousa);
        }
      });
    }

    public void onStickerPackageDownloadError(boolean paramAnonymousBoolean, com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      a.a(a.this).onStickerPackageDownloadError(paramAnonymousBoolean, paramAnonymousa);
    }

    public void onStickerPackageDownloadScheduled(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      a.a(a.this).onStickerPackageDownloadScheduled(paramAnonymousa);
    }

    public void onStickerPackageDownloadStarted(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      a.a(a.this).onStickerPackageDownloadStarted(paramAnonymousa);
    }

    public void onStickerPackageDownloading(com.viber.voip.stickers.entity.a paramAnonymousa, int paramAnonymousInt)
    {
      a.a(a.this).onStickerPackageDownloading(paramAnonymousa, paramAnonymousInt);
    }
  };
  private Handler e = av.a(av.e.a);
  private b f;

  public a(b paramb, i parami)
  {
    this.f = paramb;
    this.a = parami;
    this.b = this.a.f();
  }

  public abstract void a(int paramInt);

  protected void a(Sticker paramSticker)
  {
    String str = paramSticker.getOrigPath();
    AndroidSvgObject localAndroidSvgObject;
    Object localObject1;
    if (paramSticker.isSvg())
    {
      localAndroidSvgObject = this.b.b(str);
      localObject1 = null;
      if (localAndroidSvgObject == null);
    }
    while (true)
    {
      try
      {
        int[] arrayOfInt = this.b.a(localAndroidSvgObject);
        localObject1 = null;
        if (arrayOfInt != null)
        {
          g.c localc = new g.c(arrayOfInt[0], arrayOfInt[1]);
          localObject1 = localc;
        }
        if (localAndroidSvgObject != null)
          localAndroidSvgObject.destroy();
        if (localObject1 == null)
          break;
        p.a(paramSticker, ((g.c)localObject1).a(), ((g.c)localObject1).b(), p.a(paramSticker.isSvg()));
        return;
      }
      catch (IOException localIOException)
      {
        localObject1 = null;
        if (localAndroidSvgObject == null)
          continue;
        localAndroidSvgObject.destroy();
        localObject1 = null;
        continue;
      }
      finally
      {
        if (localAndroidSvgObject != null)
          localAndroidSvgObject.destroy();
      }
      BitmapFactory.Options localOptions = j.a(ViberApplication.getApplication(), Uri.fromFile(new File(str)));
      if ((localOptions.outWidth != 0) && (localOptions.outHeight == 0));
      localObject1 = new g.c(localOptions.outWidth, localOptions.outHeight);
    }
    at.f(new File(str));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.c.a
 * JD-Core Version:    0.6.2
 */