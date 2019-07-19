package com.viber.voip.util.e.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import com.viber.voip.messages.ui.ac;
import com.viber.voip.util.e.a;
import com.viber.voip.util.e.l;
import java.lang.ref.WeakReference;

public class b
  implements l
{
  private final WeakReference<ac> a;
  private final a b;

  public b(ac paramac, a parama)
  {
    this.a = new WeakReference(paramac);
    this.b = parama;
  }

  public Drawable a(Bitmap paramBitmap, Context paramContext, AsyncTask paramAsyncTask)
  {
    b localb = new b(paramBitmap, paramContext.getResources(), paramAsyncTask);
    localb.a(com.viber.common.ui.b.b.f);
    return localb;
  }

  public Drawable a(Bitmap paramBitmap, Context paramContext, boolean paramBoolean)
  {
    com.viber.common.ui.b localb = new com.viber.common.ui.b(paramContext.getResources(), paramBitmap, paramBoolean);
    localb.a(com.viber.common.ui.b.b.f);
    return localb;
  }

  public void a(int paramInt)
  {
  }

  public void a(int paramInt, Drawable paramDrawable)
  {
    ac localac = (ac)this.a.get();
    if (localac == null)
      return;
    this.b.a(localac, paramDrawable);
  }

  public Drawable b(int paramInt)
  {
    ac localac = (ac)this.a.get();
    if (localac == null)
      return null;
    return localac.getDrawable();
  }

  public void b(int paramInt, Drawable paramDrawable)
  {
    ac localac = (ac)this.a.get();
    if (localac == null)
      return;
    this.b.a(localac, paramDrawable);
  }

  public static abstract interface a
  {
    public abstract void a(ac paramac, Drawable paramDrawable);
  }

  public static class b extends com.viber.common.ui.b
    implements a
  {
    private final WeakReference<AsyncTask> e;

    b(Bitmap paramBitmap, Resources paramResources, AsyncTask paramAsyncTask)
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
 * Qualified Name:     com.viber.voip.util.e.c.b
 * JD-Core Version:    0.6.2
 */