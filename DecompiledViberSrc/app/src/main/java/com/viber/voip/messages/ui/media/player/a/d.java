package com.viber.voip.messages.ui.media.player.a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.util.ch;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class d extends b<com.viber.voip.messages.ui.media.player.a.a.d>
{
  protected View m;
  protected View n;
  protected ImageView o;
  private final View p;
  private final TextView s;
  private final TextView t;
  private final int u;
  private final int v;
  private final int w;
  private final int x;

  @SuppressLint({"ClickableViewAccessibility"})
  public d(View paramView)
  {
    this.m = paramView.findViewById(R.id.video_url_web_player_collapsed_close_button);
    this.n = paramView.findViewById(R.id.video_url_web_player_collapsed_maximize_button);
    this.g = ((ImageView)paramView.findViewById(R.id.video_url_web_player_collapsed_play_pause_button));
    this.o = ((ImageView)paramView.findViewById(R.id.video_url_web_player_collapsed_favorites_button));
    this.h = ((ImageView)paramView.findViewById(R.id.video_url_web_player_collapsed_send_button));
    this.p = paramView.findViewById(R.id.video_url_web_player_collapsed_text_underlay_background);
    this.s = ((TextView)paramView.findViewById(R.id.video_url_web_player_collapsed_title));
    this.t = ((TextView)paramView.findViewById(R.id.video_url_web_player_collapsed_subtitle));
    this.s.setOnClickListener(this);
    Resources localResources = paramView.getResources();
    this.u = localResources.getDimensionPixelSize(R.dimen.video_url_web_player_minimized_controls_title_min_text_size);
    this.v = localResources.getDimensionPixelSize(R.dimen.video_url_web_player_minimized_controls_title_max_text_size);
    this.w = localResources.getDimensionPixelSize(R.dimen.video_url_web_player_minimized_controls_subtitle_min_text_size);
    this.x = localResources.getDimensionPixelSize(R.dimen.video_url_web_player_minimized_controls_subtitle_max_text_size);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i = ((SeekBar)paramView.findViewById(R.id.video_url_web_player_collapsed_progress));
    this.i.setOnTouchListener(new e(this));
    this.f = paramView.findViewById(R.id.video_url_web_player_collapsed_controls);
    this.j = new com.viber.voip.messages.ui.media.player.a.a.d(this.f);
  }

  private int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(0.5D + (paramInt1 + paramFloat * (paramInt2 - paramInt1)));
  }

  private void k()
  {
    boolean bool1 = true;
    boolean bool2;
    TextView localTextView;
    if (!da.a(this.s.getText()))
    {
      bool2 = bool1;
      dj.b(this.s, bool2);
      localTextView = this.t;
      if ((!bool2) || (da.a(this.t.getText())))
        break label66;
    }
    while (true)
    {
      dj.b(localTextView, bool1);
      dj.b(this.p, bool2);
      return;
      bool2 = false;
      break;
      label66: bool1 = false;
    }
  }

  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    int i = a(this.u, this.v, paramFloat);
    this.s.setTextSize(0, i);
    int j = a(this.w, this.x, paramFloat);
    this.t.setTextSize(0, j);
  }

  protected void a(int paramInt)
  {
    super.a(paramInt);
    switch (paramInt)
    {
    default:
      return;
    case 0:
      dj.b(this.o, false);
      return;
    case 1:
      dj.b(this.o, true);
      this.o.setImageResource(R.drawable.ic_embedded_player_collapsed_favorites);
      return;
    case 2:
    }
    dj.b(this.o, true);
    this.o.setImageResource(R.drawable.ic_embedded_player_collapsed_favorites_highlighted);
  }

  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
  }

  protected void a(CharSequence paramCharSequence)
  {
    super.a(paramCharSequence);
    this.s.setText(paramCharSequence);
    k();
  }

  public void b(int paramInt)
  {
    super.b(paramInt);
    dj.b(this.m, ch.d(paramInt));
    dj.b(this.n, ch.d(paramInt));
    dj.b(this.i, ch.c(paramInt));
    dj.b(this.s, ch.a(paramInt));
    dj.b(this.t, ch.a(paramInt));
    dj.b(this.p, ch.a(paramInt));
    if (this.d != 0)
      dj.b(this.o, ch.d(paramInt));
  }

  protected void b(CharSequence paramCharSequence)
  {
    super.b(paramCharSequence);
    this.t.setText(paramCharSequence);
    k();
  }

  protected void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    this.m.setEnabled(paramBoolean);
    this.n.setEnabled(paramBoolean);
    this.o.setEnabled(paramBoolean);
    this.h.setEnabled(paramBoolean);
  }

  public void onClick(View paramView)
  {
    if (paramView == this.s)
    {
      j();
      return;
    }
    if (paramView == this.m)
    {
      this.a.j();
      return;
    }
    if (paramView == this.n)
    {
      this.a.k();
      return;
    }
    if (paramView == this.o)
    {
      this.a.l();
      return;
    }
    if (paramView == this.h)
    {
      this.a.m();
      return;
    }
    super.onClick(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.d
 * JD-Core Version:    0.6.2
 */