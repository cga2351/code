package com.viber.voip.gallery.b;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.gallery.selection.GalleryFilter;

public class a extends e
{
  public a(GalleryFilter paramGalleryFilter, Context paramContext, LoaderManager paramLoaderManager, d.a parama)
  {
    super(12, paramGalleryFilter, paramContext, paramLoaderManager, parama);
    a(com.viber.voip.model.entity.a.a);
    switch (1.a[paramGalleryFilter.ordinal()])
    {
    default:
      a("1) AND media_type=1 GROUP BY bucket_id, (media_type");
    case 1:
    }
    while (true)
    {
      d("MAX(datetaken) DESC");
      return;
      a("1) AND media_type=3 GROUP BY bucket_id, (media_type");
    }
  }

  public com.viber.voip.model.entity.a e(int paramInt)
  {
    if (b_(paramInt))
      return new com.viber.voip.model.entity.a(this.f);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.b.a
 * JD-Core Version:    0.6.2
 */