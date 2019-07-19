package com.viber.voip.messages.ui.media.player.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.viber.voip.R.drawable;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec.a;
import com.viber.voip.util.ch;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public abstract class b<A extends com.viber.voip.messages.ui.media.player.a.a.b>
  implements View.OnClickListener, h
{
  protected h.a a = r;
  protected boolean b;
  protected boolean c = true;
  protected int d = 0;
  protected boolean e;
  protected View f;
  protected ImageView g;
  protected ImageView h;
  protected SeekBar i;
  protected A j;
  protected CharSequence k;
  protected CharSequence l;
  private g m;
  private float n = 1.0F;

  public void a()
  {
    this.b = false;
    this.g.setImageResource(R.drawable.preview_media_play_selector);
  }

  protected void a(float paramFloat)
  {
    this.n = paramFloat;
  }

  protected void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    this.i.setProgress(paramInt);
  }

  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.i.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
  }

  public void a(g paramg)
  {
    this.m = paramg;
  }

  public void a(MediaPlayerControls.VisualSpec paramVisualSpec)
  {
    a(paramVisualSpec.getTitle());
    b(paramVisualSpec.getSubtitle());
    a(paramVisualSpec.getTextScale());
    a(paramVisualSpec.getFavoriteOptionVisualState());
    a(paramVisualSpec.isSendRichMessageAvailable());
  }

  public void a(h.a parama)
  {
    if (parama != null);
    while (true)
    {
      this.a = parama;
      return;
      parama = r;
    }
  }

  protected void a(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
  }

  protected void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public void b()
  {
    this.b = true;
    this.g.setImageResource(R.drawable.preview_media_pause_selector);
  }

  public void b(int paramInt)
  {
    boolean bool = true;
    this.j.a(paramInt);
    d();
    dj.b(this.f, bool);
    dj.b(this.g, ch.b(paramInt));
    ImageView localImageView = this.h;
    if ((ch.b(paramInt)) && (this.e));
    while (true)
    {
      dj.b(localImageView, bool);
      return;
      bool = false;
    }
  }

  protected void b(CharSequence paramCharSequence)
  {
    this.l = paramCharSequence;
  }

  public final void b(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      c(paramBoolean);
    }
  }

  public MediaPlayerControls.VisualSpec c()
  {
    MediaPlayerControls.VisualSpec.a locala1 = MediaPlayerControls.VisualSpec.builder();
    if (this.k != null);
    for (String str1 = this.k.toString(); ; str1 = null)
    {
      MediaPlayerControls.VisualSpec.a locala2 = locala1.a(str1);
      CharSequence localCharSequence = this.l;
      String str2 = null;
      if (localCharSequence != null)
        str2 = this.l.toString();
      return locala2.b(str2).a(this.n).a(this.d).a(this.e).a();
    }
  }

  protected void c(boolean paramBoolean)
  {
    this.g.setEnabled(paramBoolean);
    this.i.setEnabled(paramBoolean);
  }

  public void d()
  {
    this.j.b(false);
    this.j.d();
  }

  public void e()
  {
    this.j.d();
  }

  public void f()
  {
    this.j.g();
  }

  public void g()
  {
    this.j.a(true);
  }

  public void h()
  {
    dj.b(this.f, false);
    this.j.g();
  }

  public final boolean i()
  {
    return this.c;
  }

  final void j()
  {
    g();
    if (!da.a(this.k))
      this.a.n();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.g)
    {
      if (this.b)
        this.a.i();
    }
    else
      return;
    this.a.h();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.b
 * JD-Core Version:    0.6.2
 */