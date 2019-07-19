package com.viber.voip.util.e.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.viber.common.ui.b;
import com.viber.voip.util.e.a;
import com.viber.voip.util.e.l;
import java.lang.ref.WeakReference;

public class d
  implements l
{
  private final WeakReference<ImageView> a;

  public d(ImageView paramImageView)
  {
    this.a = new WeakReference(paramImageView);
  }

  public Drawable a(Bitmap paramBitmap, Context paramContext, AsyncTask paramAsyncTask)
  {
    return new a(paramBitmap, paramContext.getResources(), paramAsyncTask);
  }

  public Drawable a(Bitmap paramBitmap, Context paramContext, boolean paramBoolean)
  {
    return new b(paramContext.getResources(), paramBitmap, paramBoolean);
  }

  public void a(int paramInt)
  {
  }

  public void a(int paramInt, Drawable paramDrawable)
  {
    ImageView localImageView = (ImageView)this.a.get();
    if (localImageView == null)
      return;
    localImageView.setImageDrawable(paramDrawable);
  }

  public Drawable b(int paramInt)
  {
    ImageView localImageView = (ImageView)this.a.get();
    if (localImageView == null)
      return null;
    return localImageView.getDrawable();
  }

  public void b(int paramInt, Drawable paramDrawable)
  {
    ImageView localImageView = (ImageView)this.a.get();
    if (localImageView == null)
      return;
    localImageView.setImageDrawable(paramDrawable);
  }

  static class a extends b
    implements a
  {
    private final WeakReference<AsyncTask> e;

    a(Bitmap paramBitmap, Resources paramResources, AsyncTask paramAsyncTask)
    {
      super(paramBitmap, true);
      this.e = new WeakReference(paramAsyncTask);
    }

    public AsyncTask a()
    {
      return (AsyncTask)this.e.get();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.c.d
 * JD-Core Version:    0.6.2
 */