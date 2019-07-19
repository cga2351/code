package com.viber.voip.messages.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.viber.jni.Engine;
import com.viber.jni.connection.ConnectionController;
import com.viber.svg.jni.SvgImageView;
import com.viber.svg.jni.SvgViewBackend;
import com.viber.svg.jni.clock.CyclicClock;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.d.b;
import com.viber.voip.ui.be;
import com.viber.voip.util.dj;

public abstract class ct extends be
  implements View.OnLayoutChangeListener
{
  private View.OnClickListener d;

  public ct(Context paramContext)
  {
    super(paramContext);
  }

  private View a(View paramView)
  {
    return dj.d(paramView, R.id.share_and_shop_empty_state_retry_button);
  }

  @SuppressLint({"InflateParams"})
  public View a()
  {
    View localView = this.c.inflate(R.layout.share_and_shop_empty_state, null);
    d(localView).loadFromAsset(this.a, b(), "", 0);
    return localView;
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }

  protected void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = R.string.loading; ; i = R.string.no_connection)
    {
      paramTextView.setText(i);
      return;
    }
  }

  public View b(View paramView)
  {
    int i = 1;
    boolean bool = ViberApplication.getInstance().getEngine(false).getConnectionController().isConnected();
    TextView localTextView = e(paramView);
    View localView = a(paramView);
    SvgImageView localSvgImageView = d(paramView);
    localSvgImageView.setSvgEnabled(i);
    CyclicClock localCyclicClock;
    if (bool)
    {
      localCyclicClock = new CyclicClock(1.8D);
      localSvgImageView.setClock(localCyclicClock);
      new a(localSvgImageView, -2, c(), null).run();
      a(localTextView, bool);
      if (bool)
        break label141;
    }
    while (true)
    {
      dj.b(localView, i);
      localView.setOnClickListener(this.d);
      paramView.addOnLayoutChangeListener(this);
      return paramView;
      localCyclicClock = new CyclicClock(d(), 0.1D, i);
      break;
      label141: int j = 0;
    }
  }

  protected abstract String b();

  protected abstract int c();

  public View c(View paramView)
  {
    SvgImageView localSvgImageView = d(paramView);
    localSvgImageView.setClock(null);
    localSvgImageView.setSvgEnabled(false);
    paramView.removeOnLayoutChangeListener(this);
    return paramView;
  }

  protected abstract int d();

  protected SvgImageView d(View paramView)
  {
    return (SvgImageView)dj.d(paramView, R.id.share_and_shop_empty_state_loading_logo);
  }

  protected TextView e(View paramView)
  {
    return (TextView)dj.d(paramView, R.id.share_and_shop_empty_state_loading_label);
  }

  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = paramInt4 - paramInt2;
    if (i <= 0)
      return;
    TextView localTextView = e(paramView);
    int j = i - (localTextView.getPaddingBottom() + localTextView.getPaddingTop()) - (int)localTextView.getTextSize();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int k = j - (localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin) - (paramView.getPaddingTop() + paramView.getPaddingBottom()) - 2 * this.b.getDimensionPixelOffset(R.dimen.share_and_shop_empty_state_margin);
    SvgImageView localSvgImageView = d(paramView);
    int m = Math.min(k, c());
    float f = localSvgImageView.getBackend().getIntrinsicHeight() / localSvgImageView.getBackend().getIntrinsicWidth();
    int n = (int)(m / f);
    av.a(av.e.a).post(new a(localSvgImageView, n, m, null));
  }

  private static class a extends b<View>
  {
    private final int b;
    private final int c;

    private a(View paramView, int paramInt1, int paramInt2)
    {
      super();
      this.b = paramInt1;
      this.c = paramInt2;
    }

    public void a(View paramView)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if ((this.b != localLayoutParams.width) || (this.c != localLayoutParams.height))
      {
        localLayoutParams.width = this.b;
        localLayoutParams.height = this.c;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ct
 * JD-Core Version:    0.6.2
 */