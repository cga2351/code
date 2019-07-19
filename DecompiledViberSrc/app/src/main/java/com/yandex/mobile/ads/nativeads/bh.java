package com.yandex.mobile.ads.nativeads;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.yandex.mobile.ads.impl.jk;
import com.yandex.mobile.ads.impl.jl;
import com.yandex.mobile.ads.impl.jn;
import com.yandex.mobile.ads.impl.ns;
import java.lang.ref.WeakReference;

final class bh
{
  private final ns a = new ns();
  private final jk b = jl.a();
  private b c;
  private jn d;
  private a e;

  private void b(Context paramContext)
  {
    if (this.d != null)
      this.b.b(paramContext, this.d);
    if (this.e != null)
      this.e.a();
  }

  final void a(Context paramContext)
  {
    this.c = null;
    b(paramContext);
  }

  final void a(View paramView, b paramb)
  {
    this.c = paramb;
    b(paramView.getContext());
    Context localContext = ns.a(paramView.getContext());
    if (localContext != null)
    {
      this.d = new c(localContext);
      this.e = new a(paramView);
      this.b.a(localContext, this.d);
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
    }
  }

  private final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private final WeakReference<View> b;

    a(View arg2)
    {
      Object localObject;
      this.b = new WeakReference(localObject);
    }

    final void a()
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        View localView = (View)this.b.get();
        if (localView != null)
          localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }

    public final void onGlobalLayout()
    {
      View localView = (View)this.b.get();
      if (localView != null)
      {
        Integer localInteger = Integer.valueOf(localView.getVisibility());
        if (localView.getTag() != localInteger)
        {
          localView.setTag(localInteger);
          if (bh.a(bh.this) != null)
          {
            if (localInteger.intValue() != 0)
              break label66;
            bh.a(bh.this).a();
          }
        }
      }
      return;
      label66: bh.a(bh.this).b();
    }
  }

  static abstract interface b
  {
    public abstract void a();

    public abstract void b();
  }

  private final class c
    implements jn
  {
    private final WeakReference<Context> b;

    c(Context arg2)
    {
      Object localObject;
      this.b = new WeakReference(localObject);
    }

    public final void a(Activity paramActivity)
    {
      Context localContext = (Context)this.b.get();
      if ((localContext != null) && (localContext.equals(paramActivity)) && (bh.a(bh.this) != null))
        bh.a(bh.this).a();
    }

    public final void b(Activity paramActivity)
    {
      Context localContext = (Context)this.b.get();
      if ((localContext != null) && (localContext.equals(paramActivity)) && (bh.a(bh.this) != null))
        bh.a(bh.this).b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.bh
 * JD-Core Version:    0.6.2
 */