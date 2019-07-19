package com.viber.voip.util.e.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.TextView;
import com.viber.common.ui.b;
import com.viber.common.ui.b.b;
import com.viber.voip.util.e.l;
import java.lang.ref.WeakReference;

public class a
  implements l
{
  private final b.b a;
  private final Rect b;
  private final WeakReference<TextView> c;
  private int d = 0;

  public a(b.b paramb, Rect paramRect, TextView paramTextView)
  {
    this.a = paramb;
    this.b = paramRect;
    this.c = new WeakReference(paramTextView);
  }

  private void a(Drawable paramDrawable, TextView paramTextView)
  {
    if ((paramDrawable != null) && (paramDrawable.getBounds().isEmpty()))
      paramDrawable.setBounds(this.b);
    Drawable localDrawable1;
    Drawable localDrawable2;
    label42: Drawable localDrawable3;
    if (this.d == 0)
    {
      localDrawable1 = paramDrawable;
      if (this.d != 1)
        break label77;
      localDrawable2 = paramDrawable;
      if (this.d != 2)
        break label83;
      localDrawable3 = paramDrawable;
      label53: if (this.d != 3)
        break label89;
    }
    while (true)
    {
      paramTextView.setCompoundDrawables(localDrawable1, localDrawable2, localDrawable3, paramDrawable);
      return;
      localDrawable1 = null;
      break;
      label77: localDrawable2 = null;
      break label42;
      label83: localDrawable3 = null;
      break label53;
      label89: paramDrawable = null;
    }
  }

  public Drawable a(Bitmap paramBitmap, Context paramContext, AsyncTask paramAsyncTask)
  {
    a locala = new a(paramBitmap, paramContext.getResources(), paramAsyncTask);
    locala.a(this.a);
    return locala;
  }

  public Drawable a(Bitmap paramBitmap, Context paramContext, boolean paramBoolean)
  {
    b localb = new b(paramContext.getResources(), paramBitmap, paramBoolean);
    localb.a(this.a);
    return localb;
  }

  public void a(int paramInt)
  {
  }

  public void a(int paramInt, Drawable paramDrawable)
  {
    TextView localTextView = (TextView)this.c.get();
    if (localTextView == null)
      return;
    a(paramDrawable, localTextView);
  }

  public Drawable b(int paramInt)
  {
    TextView localTextView = (TextView)this.c.get();
    if (localTextView == null)
      return null;
    return localTextView.getCompoundDrawables()[this.d];
  }

  public void b(int paramInt, Drawable paramDrawable)
  {
    TextView localTextView = (TextView)this.c.get();
    if (localTextView == null)
      return;
    a(paramDrawable, localTextView);
  }

  public void c(int paramInt)
  {
    if (this.d == paramInt);
    TextView localTextView;
    do
    {
      return;
      localTextView = (TextView)this.c.get();
    }
    while (localTextView == null);
    Drawable[] arrayOfDrawable = localTextView.getCompoundDrawables();
    int i = arrayOfDrawable.length;
    int j = 0;
    if (j < i)
    {
      Drawable localDrawable = arrayOfDrawable[j];
      if (!(localDrawable instanceof com.viber.voip.util.e.a));
      while (true)
      {
        j++;
        break;
        AsyncTask localAsyncTask = ((com.viber.voip.util.e.a)localDrawable).a();
        if (localAsyncTask != null)
          localAsyncTask.cancel(true);
      }
    }
    localTextView.setCompoundDrawables(null, null, null, null);
    this.d = paramInt;
  }

  static class a extends b
    implements com.viber.voip.util.e.a
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
 * Qualified Name:     com.viber.voip.util.e.c.a
 * JD-Core Version:    0.6.2
 */