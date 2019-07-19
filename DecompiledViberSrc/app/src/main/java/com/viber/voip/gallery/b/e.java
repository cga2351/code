package com.viber.voip.gallery.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.av.e;
import com.viber.voip.gallery.selection.GalleryFilter;

abstract class e extends d
{
  private final GalleryFilter l;
  private final ContentObserver m = new ContentObserver(av.e.f.a())
  {
    private final String b = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    private final String c = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString();

    public void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
    {
      if (paramAnonymousUri != null);
      for (String str = paramAnonymousUri.toString(); ; str = null)
      {
        if ((str != null) && (str.contains("external")) && (!this.b.equals(str)) && (!this.c.equals(str)))
          e.a(e.this);
        return;
      }
    }
  };
  private final Runnable n = new Runnable()
  {
    public void run()
    {
      e.this.l();
    }
  };
  private final Handler o = av.e.a.a();

  protected e(int paramInt, GalleryFilter paramGalleryFilter, Context paramContext, LoaderManager paramLoaderManager, d.a parama)
  {
    super(paramInt, MediaStore.Files.getContentUri("external"), paramContext, paramLoaderManager, parama, 0);
    this.l = paramGalleryFilter;
  }

  private void r()
  {
    this.o.removeCallbacks(this.n);
    this.o.postDelayed(this.n, 300L);
  }

  private void s()
  {
    ContentResolver localContentResolver = this.d.getContentResolver();
    if ((this.l == GalleryFilter.VIDEO) || (this.l == GalleryFilter.ALL_MEDIA))
      localContentResolver.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, this.m);
    if ((this.l == GalleryFilter.IMAGE) || (this.l == GalleryFilter.ALL_MEDIA))
      localContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.m);
  }

  private void t()
  {
    this.d.getContentResolver().unregisterContentObserver(this.m);
  }

  public void i()
  {
    try
    {
      super.i();
      s();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void j()
  {
    try
    {
      super.j();
      t();
      this.o.removeCallbacks(this.n);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.b.e
 * JD-Core Version:    0.6.2
 */