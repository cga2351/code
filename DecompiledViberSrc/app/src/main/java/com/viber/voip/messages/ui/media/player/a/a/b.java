package com.viber.voip.messages.ui.media.player.a.a;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.viber.voip.util.dj;

public abstract class b extends a
{
  protected int a = 0;

  public b(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }

  public final void a(int paramInt)
  {
    this.a = paramInt;
  }

  protected final void a(boolean paramBoolean, View[] paramArrayOfView)
  {
    int i = paramArrayOfView.length;
    for (int j = 0; j < i; j++)
      dj.b(paramArrayOfView[j], paramBoolean);
  }

  protected final void a(View[] paramArrayOfView)
  {
    int i = paramArrayOfView.length;
    for (int j = 0; j < i; j++)
      paramArrayOfView[j].animate().cancel();
  }

  protected void c()
  {
    j();
  }

  protected void e()
  {
    j();
  }

  protected abstract void j();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.a.b
 * JD-Core Version:    0.6.2
 */