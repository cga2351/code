package com.viber.voip.widget.d.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.viber.common.d.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.widget.d.a;

public class b extends FrameLayout
  implements a
{
  static final Logger a = ViberEnv.getLogger();
  private PlayerView b;
  private Path c;
  private int d;
  private int e;
  private int f;

  public b(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.b = ((PlayerView)LayoutInflater.from(paramContext).inflate(R.layout.vptt2_play_view, this, true).findViewById(R.id.vptt2_view));
    this.c = new Path();
    setShape(1);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }

  public boolean a()
  {
    return false;
  }

  public boolean b()
  {
    return this.f < this.e;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.d != 0)
    {
      paramCanvas.clipPath(this.c);
      super.dispatchDraw(paramCanvas);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }

  public float getAspectRatio()
  {
    return this.e / this.f;
  }

  public PlayerView getPlayerView()
  {
    return this.b;
  }

  public View getView()
  {
    return this;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = 0.0F;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    switch (this.d)
    {
    default:
      return;
    case 1:
      float f4 = paramInt1 / 2.0F;
      float f5 = paramInt2 / 2.0F;
      if (paramInt1 > paramInt2);
      while (true)
      {
        float f6 = 2.0F + paramInt2 / 2.0F;
        this.c.reset();
        this.c.addCircle(f4, f5, f6, Path.Direction.CW);
        return;
        paramInt2 = paramInt1;
      }
    case 2:
      float f2;
      if (paramInt1 > paramInt2)
        f2 = paramInt2;
      for (float f3 = (paramInt1 - paramInt2) / 2.0F; ; f3 = 0.0F)
      {
        h.b(f2, f2, f3, f1, this.c);
        return;
        f2 = paramInt1;
        f1 = (paramInt2 - paramInt1) / 2.0F;
      }
    case 0:
    }
    this.c.reset();
  }

  public void setShape(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      invalidate();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.d.a.b
 * JD-Core Version:    0.6.2
 */