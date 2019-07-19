package com.viber.voip.gallery.b;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.LruCache;
import com.viber.provider.d.a;
import com.viber.voip.gallery.selection.GalleryFilter;
import com.viber.voip.model.entity.i;

public class c extends e
{
  private LruCache<Integer, i> l = new LruCache(100)
  {
    protected int a(Integer paramAnonymousInteger, i paramAnonymousi)
    {
      return 1;
    }
  };

  public c(GalleryFilter paramGalleryFilter, String paramString, Context paramContext, LoaderManager paramLoaderManager, d.a parama)
  {
    super(13, paramGalleryFilter, paramContext, paramLoaderManager, parama);
    a(i.a);
    switch (2.a[paramGalleryFilter.ordinal()])
    {
    default:
      a("media_type = 1 AND bucket_id=" + paramString);
    case 1:
    case 2:
    }
    while (true)
    {
      d("datetaken DESC, _id ASC");
      return;
      a("media_type=3 AND bucket_id=" + paramString);
      continue;
      a("(media_type = 1 OR media_type = 3) AND _size>0");
    }
  }

  public i e(int paramInt)
  {
    i locali = (i)this.l.get(Integer.valueOf(paramInt));
    if ((locali == null) && (b_(paramInt)))
    {
      locali = new i(this.f);
      this.l.put(Integer.valueOf(paramInt), locali);
    }
    return locali;
  }

  protected void m()
  {
    super.m();
    this.l.evictAll();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.b.c
 * JD-Core Version:    0.6.2
 */