package com.viber.voip.ui.call;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.call.a.c;
import com.viber.voip.ui.call.a.d;
import com.viber.voip.ui.call.a.e;
import java.util.ArrayList;
import java.util.List;

public class b
  implements View.OnTouchListener, c, e
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private List<Drawable> c = new ArrayList();
  private boolean[] d;
  private com.viber.voip.ui.call.a.b e = new com.viber.voip.ui.call.a.b(0.0F, 1.0F, new float[] { 0.0F, 0.5F, 0.75F, 1.0F }, new float[] { 0.0F, 0.2F, 0.5F, 1.0F });
  private d f = new d(1200L, this.e);
  private Rect g = new Rect(0, 0, 0, 0);
  private Rect h = new Rect(0, 0, 10, 10);
  private boolean i = true;
  private boolean j = false;
  private float k = 0.0F;
  private float l = 0.0F;
  private float m = 0.0F;
  private Resources n;

  public b(List<Drawable> paramList, Resources paramResources, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, a parama)
  {
    this.n = paramResources;
    this.c = paramList;
    this.d = new boolean[this.c.size()];
    this.k = paramFloat1;
    this.l = paramFloat2;
    this.m = paramFloat3;
    this.b = parama;
    this.g.right = paramInt;
    this.g.bottom = paramInt;
    this.h.right = paramInt;
    this.h.bottom = paramInt;
    int i1 = 0;
    if (i1 < this.c.size())
    {
      Drawable localDrawable = (Drawable)this.c.get(i1);
      if (localDrawable == null);
      while (true)
      {
        i1++;
        break;
        Rect localRect = new Rect();
        localRect.left = ((int)(this.k + (this.m - localDrawable.getIntrinsicWidth() / 2) * Math.cos(3.141592653589793D + 1.570796326794897D * i1) - localDrawable.getIntrinsicWidth() / 2));
        localRect.top = ((int)(this.l + (this.m - localDrawable.getIntrinsicHeight() / 2) * Math.sin(3.141592653589793D + 1.570796326794897D * i1) - localDrawable.getIntrinsicHeight() / 2));
        localRect.right = (localRect.left + localDrawable.getIntrinsicWidth());
        localRect.bottom = (localRect.top + localDrawable.getIntrinsicHeight());
        localDrawable.setBounds(localRect);
      }
    }
  }

  private boolean a()
  {
    for (int i1 = 0; ; i1++)
    {
      int i2 = this.d.length;
      boolean bool = false;
      if (i1 < i2)
      {
        if (this.d[i1] != 0)
          bool = true;
      }
      else
        return bool;
    }
  }

  public void a(float paramFloat)
  {
    if (this.i)
      this.f.a(paramFloat);
  }

  public void a(long paramLong)
  {
    if (this.i)
      this.f.a(paramLong);
  }

  public void a(Canvas paramCanvas)
  {
    int i1 = 0;
    if (i1 < this.c.size())
    {
      Drawable localDrawable = (Drawable)this.c.get(i1);
      if (localDrawable == null);
      while (true)
      {
        i1++;
        break;
        localDrawable.setAlpha((int)(255.0F * this.e.c));
        localDrawable.draw(paramCanvas);
      }
    }
  }

  public boolean b()
  {
    return this.i;
  }

  public void c()
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = 1;
    if ((paramMotionEvent.getAction() != i1) && ((paramMotionEvent.getAction() == 0) || ((paramMotionEvent.getAction() == 2) && (this.j))))
    {
      int i3 = i1;
      this.j = i3;
      if (paramMotionEvent.getAction() != i1)
        break label67;
    }
    label67: int i6;
    for (int i5 = i1; ; i6 = 0)
    {
      if (this.i)
        break label73;
      return false;
      int i4 = 0;
      break;
    }
    label73: int[] arrayOfInt1 = new int[this.c.size()];
    int i7 = 0;
    int i8 = 0;
    if (i7 < this.c.size())
    {
      Drawable localDrawable = (Drawable)this.c.get(i7);
      if (localDrawable == null);
      while (true)
      {
        i7++;
        break;
        this.g.offsetTo((int)paramMotionEvent.getX() - this.g.width() / 2, (int)paramMotionEvent.getY() - this.g.height() / 2);
        this.h.offsetTo(localDrawable.getBounds().centerX() - this.h.width() / 2, localDrawable.getBounds().centerY() - this.h.height() / 2);
        if (Rect.intersects(this.g, this.h))
        {
          if (i6 == 0)
          {
            localDrawable.setState(new int[] { 16842910, 16842914 });
            if ((this.b != null) && (this.d[i7] == 0))
              this.b.a(i7);
            this.d[i7] = i1;
          }
          while (true)
          {
            arrayOfInt1[i8] = i7;
            i8++;
            break;
            localDrawable.setState(new int[] { 16842910, 16842908 });
            if (this.b != null)
              this.b.b(i7);
          }
        }
        if (this.d[i7] != 0)
        {
          this.d[i7] = false;
          if (this.b != null)
            this.b.a(i7, a());
        }
        if (i6 != 0)
        {
          int[] arrayOfInt2 = new int[i1];
          arrayOfInt2[0] = 16842910;
          localDrawable.setState(arrayOfInt2);
        }
        else
        {
          localDrawable.setState(new int[] { 16842910, 16842908 });
        }
      }
    }
    if (i8 >= 0);
    while (true)
    {
      return i1;
      int i2 = 0;
    }
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(int paramInt, boolean paramBoolean);

    public abstract void b(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.call.b
 * JD-Core Version:    0.6.2
 */