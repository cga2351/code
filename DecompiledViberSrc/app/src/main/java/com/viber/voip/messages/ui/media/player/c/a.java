package com.viber.voip.messages.ui.media.player.c;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.media.player.MediaPlayer.a;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.k;
import com.viber.voip.widget.ForegroundImageView;

public abstract class a<V extends View> extends b<V>
{
  private static final com.viber.common.a.e z = ViberEnv.getLogger();
  protected String c;
  protected boolean d;
  protected boolean e = true;
  protected boolean f;

  public a(Context paramContext)
  {
    super(paramContext);
  }

  protected int a(int paramInt)
  {
    return R.layout.media_url_web_player_preview_state;
  }

  public final void a()
  {
    super.a();
    if (-1 == this.r);
    do
    {
      return;
      if (this.r == 3)
      {
        this.f = false;
        return;
      }
      if (this.r == 0)
        break;
    }
    while (this.r == 4);
    int i = this.r;
    int j = 0;
    if (i == 2)
      j = 1;
    if (this.r == 1)
      setState(3);
    while (true)
    {
      if (j != 0)
        e(1);
      g();
      return;
      setState(4);
    }
    this.e = true;
  }

  public final void a(long paramLong)
  {
    super.a(paramLong);
    if (this.r != 0)
    {
      this.p = paramLong;
      b(paramLong);
    }
  }

  protected void a(long paramLong1, long paramLong2)
  {
    this.p = paramLong2;
    this.o = paramLong1;
    this.g.a(this, this.o, this.p);
  }

  protected void a(long paramLong, boolean paramBoolean)
  {
    this.o = paramLong;
    this.n = paramBoolean;
    setState(1);
  }

  protected void a(Context paramContext)
  {
    this.d = false;
    super.a(paramContext);
  }

  protected void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    b(paramView, paramInt);
    d(paramView, paramInt);
    c(paramView, paramInt);
  }

  protected final void a(boolean paramBoolean)
  {
    if ((!da.a(this.j, this.c)) && (this.d))
    {
      this.c = this.j;
      if (paramBoolean)
        this.e = true;
      setState(0);
      this.o = 0L;
      this.p = 0L;
      i();
    }
  }

  protected int b(int paramInt)
  {
    if (-1 == paramInt)
      return ContextCompat.getColor(getContext(), R.color.media_url_web_player_error_state_background);
    return ContextCompat.getColor(getContext(), R.color.solid);
  }

  public final void b()
  {
    super.b();
    if (-1 == this.r);
    do
    {
      return;
      this.q.d();
      if (this.r == 3)
      {
        this.f = true;
        return;
      }
      if (this.r == 0)
        break;
    }
    while ((this.r == 5) || (this.r == 2));
    h();
    setState(5);
    return;
    this.e = false;
  }

  protected void b(long paramLong)
  {
  }

  protected void b(final long paramLong, boolean paramBoolean)
  {
    a(new b.a(paramLong)
    {
      protected void a()
      {
        a.this.a(paramLong, this.b);
        if (a.this.e)
        {
          a.this.a();
          return;
        }
        a.this.setState(2);
        a.this.e(1);
        a.this.g.a(a.this, 1);
        a.this.g.a(a.this);
      }
    });
  }

  protected void b(View paramView, int paramInt)
  {
    TextView localTextView = (TextView)dj.d(paramView, R.id.preview_state_message);
    if (-1 == paramInt)
    {
      localTextView.setText(getErrorPreviewStateMessage());
      dj.b(localTextView, true);
      return;
    }
    dj.b(localTextView, false);
  }

  protected void b(final boolean paramBoolean)
  {
    a(new b.a(paramBoolean)
    {
      public void a()
      {
        a.this.setState(4);
        a.this.d(0);
        a.this.q.d();
        if (a.this.f)
        {
          a.this.f = false;
          a.this.g.a(a.this, 1);
          a.this.g.a(a.this);
          a.this.b();
          return;
        }
        boolean bool = paramBoolean;
        int i = 0;
        if (bool);
        while (true)
        {
          a.this.g.a(a.this, i);
          return;
          i = 2;
        }
      }
    });
  }

  protected void c(View paramView, int paramInt)
  {
    View localView = dj.d(paramView, R.id.preview_state_loading_progress);
    if ((1 == paramInt) && (2 != this.r))
    {
      dj.b(localView, true);
      return;
    }
    dj.b(localView, false);
  }

  protected boolean c(final int paramInt)
  {
    a(new b.a(paramInt)
    {
      protected void a()
      {
        int i = -1;
        if (a.this.r == 3)
          a.this.f = false;
        a.this.setState(i);
        a locala = a.this;
        if (paramInt == 1)
          i = -2;
        locala.d(i);
        a.this.q.d();
        a.this.g.b(a.this, paramInt);
      }
    });
    return true;
  }

  protected void d(View paramView, int paramInt)
  {
    ForegroundImageView localForegroundImageView = (ForegroundImageView)dj.d(paramView, R.id.preview_state_thumbnail);
    localForegroundImageView.setScaleType(this.m);
    localForegroundImageView.setBackgroundColor(b(paramInt));
    int i = 0;
    if ((-2 == paramInt) || (-1 == paramInt))
      localForegroundImageView.setImageDrawable(null);
    while (true)
    {
      if (i == 0)
        localForegroundImageView.setForeground(null);
      return;
      if ((!da.a(this.k)) || (this.l > 0))
      {
        k.a(localForegroundImageView);
        if (!da.a(this.k))
          this.u.a(Uri.parse(this.k), localForegroundImageView, this.v);
        while (true)
        {
          i = 0;
          if (1 != paramInt)
            break;
          localForegroundImageView.setForeground(R.drawable.media_url_web_player_preview_state_overlay);
          i = 1;
          break;
          localForegroundImageView.setImageResource(this.l);
        }
      }
      k.a(localForegroundImageView);
      localForegroundImageView.setImageDrawable(null);
      i = 0;
    }
  }

  protected void e()
  {
    this.c = null;
    this.d = false;
    super.e();
  }

  protected void f()
  {
    removeView(this.h);
    super.f();
  }

  protected void g()
  {
  }

  protected int getErrorPreviewStateMessage()
  {
    return 0;
  }

  protected void h()
  {
  }

  protected void i()
  {
  }

  protected void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 262	com/viber/voip/messages/ui/media/player/c/a$3
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 265	com/viber/voip/messages/ui/media/player/c/a$3:<init>	(Lcom/viber/voip/messages/ui/media/player/c/a;)V
    //   9: invokevirtual 145	com/viber/voip/messages/ui/media/player/c/a:a	(Lcom/viber/voip/messages/ui/media/player/c/b$a;)V
    //   12: return
  }

  public void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 268	com/viber/voip/messages/ui/media/player/c/a:r	()Z
    //   4: ifeq +18 -> 22
    //   7: new 270	com/viber/voip/messages/ui/media/player/c/a$4
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 271	com/viber/voip/messages/ui/media/player/c/a$4:<init>	(Lcom/viber/voip/messages/ui/media/player/c/a;)V
    //   15: astore_1
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 145	com/viber/voip/messages/ui/media/player/c/a:a	(Lcom/viber/voip/messages/ui/media/player/c/b$a;)V
    //   21: return
    //   22: new 273	com/viber/voip/messages/ui/media/player/c/a$5
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 274	com/viber/voip/messages/ui/media/player/c/a$5:<init>	(Lcom/viber/voip/messages/ui/media/player/c/a;)V
    //   30: astore_1
    //   31: goto -15 -> 16
  }

  public void setSourceUrl(String paramString)
  {
    super.setSourceUrl(paramString);
    a(true);
  }

  public void setThumbnailResource(int paramInt)
  {
    super.setThumbnailResource(paramInt);
    if (1 == getCurrentPreviewState())
      e(1);
  }

  public void setThumbnailScaleType(ImageView.ScaleType paramScaleType)
  {
    super.setThumbnailScaleType(paramScaleType);
    if (1 == getCurrentPreviewState())
      e(1);
  }

  public void setThumbnailUrl(String paramString)
  {
    super.setThumbnailUrl(paramString);
    if (1 == getCurrentPreviewState())
      e(1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.c.a
 * JD-Core Version:    0.6.2
 */