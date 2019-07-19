package com.viber.voip.stickers.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.ui.PositioningAwareFrameLayout;
import com.viber.voip.widget.EllipsizedEndDynamicMaxLinesTextView;
import com.viber.voip.widget.g;

public class c extends PositioningAwareFrameLayout
{
  private ImageView a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private View f;
  private View g;

  public c(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    b(paramContext);
  }

  private void a(View paramView)
  {
    addView(paramView, new FrameLayout.LayoutParams(-1, -1));
  }

  private void b(Context paramContext)
  {
    this.a = new ImageView(paramContext);
    this.a.setVisibility(8);
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    a(this.a);
    this.b = new g(paramContext);
    this.b.setVisibility(8);
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    a(this.b);
    this.c = new ImageView(paramContext);
    this.c.setVisibility(8);
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    a(this.c);
    this.d = new ImageView(getContext());
    this.d.setVisibility(8);
    this.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.d.setImageResource(R.drawable.ic_keyboard_cell_play);
    a(this.d);
    this.e = new EllipsizedEndDynamicMaxLinesTextView(paramContext);
    this.e.setVisibility(8);
    a(this.e);
    this.f = new View(paramContext);
    this.f.setVisibility(8);
    a(this.f);
    this.g = new View(paramContext);
    this.g.setVisibility(8);
    a(this.g);
  }

  public View getFrameView()
  {
    return this.f;
  }

  public ImageView getImgBackground()
  {
    return this.a;
  }

  public ImageView getImgGif()
  {
    return this.b;
  }

  public ImageView getImgPicture()
  {
    return this.c;
  }

  public View getOverlayView()
  {
    return this.g;
  }

  public ImageView getPlayBtn()
  {
    return this.d;
  }

  public TextView getTextView()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.ui.c
 * JD-Core Version:    0.6.2
 */