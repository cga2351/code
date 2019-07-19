package com.viber.voip.messages.ui.media.player.a;

import android.content.Context;
import android.widget.FrameLayout;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.a;

public class a extends FrameLayout
  implements MediaPlayerControls
{
  protected MediaPlayerControls.a c = a;
  protected int d = 0;
  protected int e = 0;

  public a(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public void a()
  {
  }

  protected void a(int paramInt)
  {
  }

  public void a(int paramInt, long paramLong1, long paramLong2)
  {
  }

  protected void a(Context paramContext)
  {
  }

  public void b()
  {
  }

  public final void c()
  {
    if (2 != this.d)
    {
      this.d = 2;
      f();
    }
  }

  public final void d()
  {
    if (1 != this.d)
    {
      this.d = 1;
      e();
    }
  }

  protected void e()
  {
  }

  protected void f()
  {
  }

  protected final void g()
  {
    switch (this.d)
    {
    default:
      return;
    case 1:
      this.c.e();
      return;
    case 2:
    }
    this.c.d();
  }

  public MediaPlayerControls.VisualSpec getCurrentVisualSpec()
  {
    return MediaPlayerControls.VisualSpec.EMPTY;
  }

  public final void setCallbacks(MediaPlayerControls.a parama)
  {
    if (parama == null)
      parama = a;
    this.c = parama;
  }

  public void setControlsEnabled(boolean paramBoolean)
  {
  }

  public void setVisibilityMode(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      a(paramInt);
    }
  }

  public void setVisualSpec(MediaPlayerControls.VisualSpec paramVisualSpec)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.a
 * JD-Core Version:    0.6.2
 */