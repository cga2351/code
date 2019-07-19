package com.viber.voip.stickers;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Picture;
import android.support.v4.util.LruCache;
import android.support.v7.app.c.a;
import android.text.TextUtils;
import android.widget.ImageView;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.AndroidSvgObject;
import com.viber.svg.jni.SvgObject;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.ax;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.e.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class x extends aa
{
  public static final a a = locala;
  public static final int b = b(a);
  private static final Logger c = ViberEnv.getLogger();
  private final c d;
  private final b e;
  private final i f;
  private d.al g;

  static
  {
    a.values();
    a locala = c();
    if (locala == a.a)
      locala = d();
  }

  public x(i parami)
  {
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.ax.p;
    this.g = new d.al(arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        ViberApplication.exit(null, false);
      }
    };
    this.d = new c(null);
    this.e = new b(20);
    this.f = parami;
    d.a(this.g);
  }

  private com.viber.voip.stickers.f.a a(String paramString, w paramw)
  {
    if (w.b == paramw)
      return a(paramString);
    return c.a(this.d, paramString);
  }

  @SuppressLint({"InlinedApi"})
  public static final void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 0; ; i = 1)
    {
      paramImageView.setLayerType(i, null);
      return;
    }
  }

  private void a(String paramString, Picture paramPicture, w paramw, boolean paramBoolean)
  {
    com.viber.voip.stickers.f.a locala;
    if (!TextUtils.isEmpty(paramString))
    {
      locala = a(paramString, paramw);
      if (paramBoolean)
        locala.b = paramPicture;
    }
    else
    {
      return;
    }
    locala.a = paramPicture;
  }

  private static int b(a parama)
  {
    switch (3.a[parama.ordinal()])
    {
    case 2:
    case 3:
    default:
      return 0;
    case 1:
      return 1048577;
    case 4:
      return 458767;
    case 5:
    }
    return 720911;
  }

  private static a c()
  {
    try
    {
      a locala = a.valueOf(d.ax.p.d());
      return locala;
    }
    catch (Exception localException)
    {
    }
    return a.a;
  }

  private static a d()
  {
    if (com.viber.common.d.a.g())
      return a.d;
    return a.c;
  }

  public Bitmap a(AndroidSvgObject paramAndroidSvgObject, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, w paramw)
  {
    if (paramw == w.c)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      a(paramAndroidSvgObject, localBitmap, paramInt1, paramInt2);
      j.a(localBitmap, new File(paramString2), 100, Bitmap.CompressFormat.PNG, false);
      return localBitmap;
    }
    return null;
  }

  public Picture a(Sticker paramSticker, int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, w paramw, boolean paramBoolean2)
  {
    return a(paramSticker, paramInt1, paramInt2, paramString, paramBoolean1, paramw, paramBoolean2, false);
  }

  public Picture a(Sticker paramSticker, int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, w paramw, boolean paramBoolean2, boolean paramBoolean3)
  {
    com.viber.voip.stickers.f.a locala;
    if (paramBoolean2)
      locala = a(paramString, paramw);
    while ((locala.a == null) || (locala.a.getHeight() != paramInt2) || (locala.a.getWidth() != paramInt1) || ((paramBoolean3) && (locala.b == null)))
    {
      AndroidSvgObject localAndroidSvgObject = b(paramString);
      Picture localPicture = new Picture();
      if (localAndroidSvgObject == null)
      {
        this.f.u().a(paramSticker, false, paramBoolean1, paramw, new FileNotFoundException());
        return localPicture;
        locala = new com.viber.voip.stickers.f.a();
      }
      else
      {
        try
        {
          a(localAndroidSvgObject, localPicture, paramInt1, paramInt2, paramString, paramBoolean1, paramw, paramBoolean2, paramBoolean3);
          localAndroidSvgObject.destroy();
          if (!paramBoolean2)
            return localPicture;
        }
        finally
        {
          localAndroidSvgObject.destroy();
        }
      }
    }
    if (paramBoolean3)
      return locala.b;
    return locala.a;
  }

  public com.viber.voip.stickers.f.a a(String paramString)
  {
    com.viber.voip.stickers.f.a locala = (com.viber.voip.stickers.f.a)this.e.get(paramString);
    if (locala == null)
    {
      locala = new com.viber.voip.stickers.f.a();
      this.e.put(paramString, locala);
    }
    return locala;
  }

  public void a()
  {
    c.a(this.d);
  }

  public void a(Context paramContext)
  {
    CharSequence[] arrayOfCharSequence = new CharSequence[a.values().length];
    int i = 0;
    if (i < a.values().length)
    {
      a locala1 = a.values()[i];
      if (locala1 == a.a);
      for (String str = "AUTO (" + d() + ")"; ; str = locala1.toString())
      {
        arrayOfCharSequence[i] = str;
        i++;
        break;
      }
    }
    c.a locala = new c.a(paramContext);
    locala.a("Select The Difficulty Level");
    locala.a(arrayOfCharSequence, c().ordinal(), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        x.a locala = x.a.values()[paramAnonymousInt];
        x.this.a(locala);
        paramAnonymousDialogInterface.dismiss();
      }
    });
    locala.b().show();
  }

  public void a(AndroidSvgObject paramAndroidSvgObject, Picture paramPicture, int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, w paramw, boolean paramBoolean2, boolean paramBoolean3)
  {
    super.a(paramAndroidSvgObject, paramPicture, paramInt1, paramInt2, paramBoolean3);
    if (paramBoolean2)
      a(paramString, paramPicture, paramw, paramBoolean3);
  }

  public void a(Sticker paramSticker)
    throws IOException
  {
    b(paramSticker);
  }

  public void a(a parama)
  {
    d.ax.p.a(parama.toString());
  }

  public void b()
  {
    this.e.evictAll();
  }

  public void b(Sticker paramSticker)
    throws IOException
  {
    try
    {
      AndroidSvgObject localAndroidSvgObject = new AndroidSvgObject(String.valueOf(paramSticker.id), b);
      localAndroidSvgObject.parseFile(paramSticker.getOrigPath());
      localAndroidSvgObject.prepare(paramSticker.getConversationWidth(), paramSticker.getConversationHeight());
      double d2 = localAndroidSvgObject.getMaxTime();
      d1 = d2;
      if (d1 > 0.0D)
      {
        bool = true;
        paramSticker.setIsAnimated(bool);
        return;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        double d1 = 0.0D;
        continue;
        boolean bool = false;
      }
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
    }
  }

  private class b extends LruCache<String, com.viber.voip.stickers.f.a>
  {
    public b(int arg2)
    {
      super();
    }

    protected int a(String paramString, com.viber.voip.stickers.f.a parama)
    {
      return 1;
    }
  }

  private class c
  {
    private final Map<String, com.viber.voip.stickers.f.a> b = new HashMap();

    private c()
    {
    }

    private com.viber.voip.stickers.f.a a(String paramString)
    {
      com.viber.voip.stickers.f.a locala1;
      if (TextUtils.isEmpty(paramString))
        locala1 = null;
      do
      {
        return locala1;
        locala1 = (com.viber.voip.stickers.f.a)this.b.get(paramString);
      }
      while (locala1 != null);
      com.viber.voip.stickers.f.a locala2 = new com.viber.voip.stickers.f.a();
      this.b.put(paramString, locala2);
      return locala2;
    }

    private void a()
    {
      this.b.clear();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.x
 * JD-Core Version:    0.6.2
 */