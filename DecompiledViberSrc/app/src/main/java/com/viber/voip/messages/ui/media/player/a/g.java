package com.viber.voip.messages.ui.media.player.a;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.viber.voip.R.layout;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.a;

public final class g extends a
  implements h.a
{
  private SeekBar.OnSeekBarChangeListener f;
  private h g = h.q;
  private h h;
  private h i;

  public g(Context paramContext)
  {
    super(paramContext);
  }

  private void a(h paramh)
  {
    paramh.a(this);
    paramh.a(getProgressListener());
  }

  private void b(h paramh)
  {
    boolean bool = this.g.i();
    this.g.h();
    this.g = paramh;
    this.g.b(this.e);
    this.g.b(bool);
  }

  private SeekBar.OnSeekBarChangeListener getProgressListener()
  {
    if (this.f == null)
      this.f = new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            g.this.c.a(paramAnonymousInt);
            g.a(g.this).d();
          }
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      };
    return this.f;
  }

  public g a(com.viber.voip.analytics.g paramg)
  {
    this.h.a(paramg);
    this.i.a(paramg);
    return this;
  }

  public void a()
  {
    super.a();
    this.g.a();
  }

  protected void a(int paramInt)
  {
    super.a(paramInt);
    this.g.b(paramInt);
  }

  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    super.a(paramInt, paramLong1, paramLong2);
    this.g.a(paramInt, paramLong1, paramLong2);
  }

  protected void a(Context paramContext)
  {
    super.a(paramContext);
    inflate(getContext(), R.layout.video_url_web_player_controls, this);
    this.h = new d(this);
    a(this.h);
    this.i = new f(this);
    a(this.i);
  }

  public void b()
  {
    super.b();
    this.g.b();
  }

  protected void e()
  {
    super.e();
    b(this.i);
  }

  protected void f()
  {
    super.f();
    b(this.h);
  }

  public MediaPlayerControls.VisualSpec getCurrentVisualSpec()
  {
    return this.g.c();
  }

  public int getVisibilityMode()
  {
    return this.e;
  }

  public void h()
  {
    b();
    this.g.d();
    this.c.a();
  }

  public void i()
  {
    a();
    this.g.d();
    this.c.b();
  }

  public void j()
  {
    this.c.c();
  }

  public void k()
  {
    g();
  }

  public void l()
  {
    this.c.f();
  }

  public void m()
  {
    this.c.g();
  }

  public void n()
  {
    this.c.h();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.g.e();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g.f();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
      this.g.g();
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setControlsEnabled(boolean paramBoolean)
  {
    super.setControlsEnabled(paramBoolean);
    this.g.b(paramBoolean);
  }

  public void setVisualSpec(MediaPlayerControls.VisualSpec paramVisualSpec)
  {
    this.g.a(paramVisualSpec);
    this.g.b(this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.g
 * JD-Core Version:    0.6.2
 */