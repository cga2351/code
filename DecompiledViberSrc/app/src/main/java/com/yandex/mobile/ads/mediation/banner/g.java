package com.yandex.mobile.ads.mediation.banner;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;
import com.yandex.mobile.ads.impl.as;
import java.lang.ref.WeakReference;

final class g
{
  private final Handler a = new Handler(Looper.getMainLooper());
  private final WeakReference<ViewGroup> b;
  private final as<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> c;

  g(ViewGroup paramViewGroup, as<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> paramas)
  {
    this.b = new WeakReference(paramViewGroup);
    this.c = paramas;
  }

  final void a(final View paramView)
  {
    this.a.post(new Runnable()
    {
      public final void run()
      {
        ViewGroup localViewGroup = (ViewGroup)g.a(g.this).get();
        if ((localViewGroup != null) && (localViewGroup.indexOfChild(paramView) == -1))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(13);
          localViewGroup.addView(paramView, localLayoutParams);
          localViewGroup.setVisibility(0);
          paramView.setVisibility(0);
          g localg = g.this;
          View localView = paramView;
          localView.getViewTreeObserver().addOnPreDrawListener(new g.2(localg, localView));
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.banner.g
 * JD-Core Version:    0.6.2
 */