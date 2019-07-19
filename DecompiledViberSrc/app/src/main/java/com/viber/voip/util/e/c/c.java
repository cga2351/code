package com.viber.voip.util.e.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import com.viber.voip.ui.d.b;
import com.viber.voip.util.e.a;
import com.viber.voip.util.e.l;
import com.viber.voip.widget.GroupIconView;
import java.lang.ref.WeakReference;

public class c
  implements l
{
  private final WeakReference<GroupIconView> a;

  public c(GroupIconView paramGroupIconView)
  {
    this.a = new WeakReference(paramGroupIconView);
  }

  public Drawable a(Bitmap paramBitmap, Context paramContext, AsyncTask paramAsyncTask)
  {
    GroupIconView localGroupIconView = (GroupIconView)this.a.get();
    if (localGroupIconView != null)
      paramContext = localGroupIconView.getContext();
    return new a(paramContext, paramAsyncTask);
  }

  public Drawable a(Bitmap paramBitmap, Context paramContext, boolean paramBoolean)
  {
    GroupIconView localGroupIconView = (GroupIconView)this.a.get();
    if (localGroupIconView != null)
      paramContext = localGroupIconView.getContext();
    if (paramBoolean)
      return new b(paramContext, true);
    return new b(paramContext, paramBitmap);
  }

  public void a(int paramInt)
  {
    GroupIconView localGroupIconView = (GroupIconView)this.a.get();
    if (localGroupIconView == null)
      return;
    localGroupIconView.a(paramInt, (Drawable)null, false);
  }

  public void a(int paramInt, Drawable paramDrawable)
  {
    GroupIconView localGroupIconView = (GroupIconView)this.a.get();
    if (localGroupIconView == null)
      return;
    localGroupIconView.b(paramInt, paramDrawable);
  }

  public Drawable b(int paramInt)
  {
    GroupIconView localGroupIconView = (GroupIconView)this.a.get();
    if (localGroupIconView == null)
      return null;
    return localGroupIconView.a(paramInt);
  }

  public void b(int paramInt, Drawable paramDrawable)
  {
    GroupIconView localGroupIconView = (GroupIconView)this.a.get();
    if (localGroupIconView == null)
      return;
    localGroupIconView.b(paramInt, paramDrawable);
  }

  static class a extends b
    implements a
  {
    private final WeakReference<AsyncTask> e;

    a(Context paramContext, AsyncTask paramAsyncTask)
    {
      super(true);
      this.e = new WeakReference(paramAsyncTask);
    }

    public AsyncTask a()
    {
      return (AsyncTask)this.e.get();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.c.c
 * JD-Core Version:    0.6.2
 */