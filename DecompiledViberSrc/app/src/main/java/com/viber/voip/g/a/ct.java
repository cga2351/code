package com.viber.voip.g.a;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.util.e.d.a;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.g;
import javax.inject.Singleton;

public abstract class ct
{
  static com.viber.voip.messages.extras.image.a a()
  {
    return com.viber.voip.messages.extras.image.a.a();
  }

  @Singleton
  static e a(Context paramContext)
  {
    e locale = new e(paramContext);
    d.a locala = new d.a(paramContext, "image_fetcher_cache", false);
    locala.c = Bitmap.CompressFormat.PNG;
    locale.a(locala);
    return locale;
  }

  @Singleton
  static aj b()
  {
    return aj.b();
  }

  @Singleton
  static g b(Context paramContext)
  {
    g localg = new g(paramContext, true);
    d.a locala = new d.a(paramContext, "ImageFetcherThumb", true);
    locala.a(com.viber.voip.b.a.h);
    localg.a(locala);
    return localg;
  }

  @Singleton
  static ai c(Context paramContext)
  {
    return new ai(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ct
 * JD-Core Version:    0.6.2
 */