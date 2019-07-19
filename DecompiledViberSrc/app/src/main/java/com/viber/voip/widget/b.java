package com.viber.voip.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.viber.voip.ui.d.a;
import com.viber.voip.util.LongSparseSet;

public abstract interface b
{
  public abstract void a();

  public abstract void a(boolean paramBoolean, long[] paramArrayOfLong);

  public abstract void b();

  public static class a
  {
    private a a;
    private LongSparseSet b;
    private boolean c = true;

    public a(Context paramContext, int paramInt)
    {
      this.a = new a(paramContext, paramInt);
    }

    private boolean a(View paramView)
    {
      return (this.b != null) && (this.b.contains(paramView.getId()));
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public void a(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }

    public void a(long[] paramArrayOfLong)
    {
      this.b = LongSparseSet.from(paramArrayOfLong);
    }

    public boolean a()
    {
      return this.c;
    }

    public boolean a(Canvas paramCanvas, View paramView, long paramLong, a parama)
    {
      Canvas localCanvas = this.a.a();
      if ((localCanvas == null) || (a(paramView)))
        return parama.a(paramCanvas, paramView, paramLong);
      localCanvas.save();
      localCanvas.scale(this.a.a().getWidth() / paramCanvas.getWidth(), this.a.a().getHeight() / paramCanvas.getHeight());
      localCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      boolean bool = parama.a(localCanvas, paramView, paramLong);
      localCanvas.restore();
      this.a.draw(paramCanvas);
      return bool;
    }

    public void b()
    {
      this.a.c();
    }

    public void c()
    {
      this.a.b();
    }

    static abstract interface a
    {
      public abstract boolean a(Canvas paramCanvas, View paramView, long paramLong);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.b
 * JD-Core Version:    0.6.2
 */