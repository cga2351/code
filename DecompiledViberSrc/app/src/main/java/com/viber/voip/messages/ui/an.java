package com.viber.voip.messages.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.viber.svg.jni.SvgImageView;
import com.viber.svg.jni.clock.CyclicClock;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.util.e.j;

public final class an extends ct
{
  private final ColorDrawable d;

  public an(Context paramContext)
  {
    super(paramContext);
    this.d = new ColorDrawable(ContextCompat.getColor(paramContext, R.color.negative));
  }

  public View a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.a);
    View localView = super.a();
    localView.setBackground(this.d);
    localFrameLayout.addView(localView);
    localFrameLayout.findViewById(R.id.bottom).getLayoutParams().height = -1;
    return localFrameLayout;
  }

  public void a(View paramView)
  {
    e(paramView).setText(R.string.keyboard_extension_no_results);
    SvgImageView localSvgImageView = d(paramView);
    localSvgImageView.setSvgEnabled(true);
    localSvgImageView.setClock(new CyclicClock(d(), 0.1D, 1));
  }

  protected String b()
  {
    return "svg/keyboard_extensions_loading_state.svg";
  }

  protected int c()
  {
    return j.a(40.0F);
  }

  protected int d()
  {
    return 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.an
 * JD-Core Version:    0.6.2
 */