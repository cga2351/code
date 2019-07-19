package com.viber.voip.ui.call;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.viber.voip.R.drawable;
import com.viber.voip.ui.call.a.a.a;
import com.viber.voip.ui.call.a.b;
import com.viber.voip.ui.call.a.d;
import com.viber.voip.ui.call.a.e;

public class a
  implements View.OnTouchListener, a.a, com.viber.voip.ui.call.a.c, e
{
  private Drawable A;
  private b B;
  private b C;
  private b D;
  private b E;
  private b F;
  private d G = new d(0L);
  private final int a = -20;
  private final int b = WavesView.a;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private int o;
  private int p;
  private int q;
  private boolean r = true;
  private boolean s = true;
  private Paint t;
  private Paint u;
  private com.viber.voip.ui.call.a.c[] v;
  private e[] w;
  private Drawable x;
  private Drawable y;
  private Drawable z;

  public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, Resources paramResources)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat1;
    this.h = paramFloat2;
    this.i = paramFloat3;
    this.c = paramFloat4;
    this.d = paramFloat4;
    this.k = paramFloat5;
    this.l = TypedValue.applyDimension(1, -2.5F, paramResources.getDisplayMetrics());
    this.m = TypedValue.applyDimension(1, 7.0F, paramResources.getDisplayMetrics());
    this.n = TypedValue.applyDimension(1, 42.0F, paramResources.getDisplayMetrics());
    this.x = paramResources.getDrawable(R.drawable.viber_phone);
    this.y = paramResources.getDrawable(R.drawable.phone_ring1);
    this.z = paramResources.getDrawable(R.drawable.phone_ring2);
    this.A = paramResources.getDrawable(R.drawable.phone_ring3);
    this.B = new b(0.0F, 0.64F, new float[] { 0.26F, 0.37F, 0.42F, 0.47F, 0.58F, 0.68F, 0.74F, 0.95F }, new float[] { 0.0F, 8.0F, 0.0F, -8.0F, 8.0F, 0.0F, 8.0F, 0.0F }, this);
    float[] arrayOfFloat1 = { 0.0F, 0.3F, 1.0F };
    float[] arrayOfFloat2 = new float[3];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = this.n;
    arrayOfFloat2[2] = 0.0F;
    this.C = new b(0.53F, 1.0F, arrayOfFloat1, arrayOfFloat2, this);
    float[] arrayOfFloat3 = { 0.0F, 1.0F };
    float[] arrayOfFloat4 = { 0.0F, 255.0F };
    this.D = new b(0.52F, 0.08F + 0.52F, arrayOfFloat3, arrayOfFloat4);
    float[] arrayOfFloat5 = { 0.0F, 1.0F };
    float[] arrayOfFloat6 = { 0.0F, 255.0F };
    this.E = new b(0.08F + 0.52F, 0.16F + 0.52F, arrayOfFloat5, arrayOfFloat6);
    float[] arrayOfFloat7 = { 0.0F, 1.0F };
    float[] arrayOfFloat8 = { 0.0F, 255.0F };
    this.F = new b(0.16F + 0.52F, 0.52F + 0.24F, arrayOfFloat7, arrayOfFloat8);
    this.G.a(d.a);
    this.G.a(this.B);
    this.G.a(this.C);
    this.G.a(this.D);
    this.G.a(this.E);
    this.G.a(this.F);
    Rect localRect1 = new Rect(0, 0, this.x.getIntrinsicWidth(), this.x.getIntrinsicHeight());
    this.x.setBounds(localRect1);
    if (localRect1.width() > localRect1.height());
    for (int i1 = localRect1.width() / 2; ; i1 = localRect1.height() / 2)
    {
      this.j = (i1 + this.i);
      Rect localRect2 = new Rect(0, 0, this.y.getIntrinsicWidth(), this.y.getIntrinsicHeight());
      this.y.setBounds(localRect2);
      Rect localRect3 = new Rect(0, 0, this.z.getIntrinsicWidth(), this.z.getIntrinsicHeight());
      int i2 = (int)TypedValue.applyDimension(1, 5.0F, paramResources.getDisplayMetrics());
      localRect3.offsetTo(i2, i2);
      this.z.setBounds(localRect3);
      Rect localRect4 = new Rect(0, 0, this.A.getIntrinsicWidth(), this.A.getIntrinsicHeight());
      localRect4.offsetTo(i2 * 2, i2 * 2);
      this.A.setBounds(localRect4);
      this.t = new Paint();
      this.t.setFlags(7);
      this.t.setColor(this.b);
      this.t.setStrokeWidth(this.d);
      this.t.setStyle(Paint.Style.STROKE);
      this.u = new Paint(this.t);
      this.u.setColor(0);
      this.u.setStyle(Paint.Style.FILL_AND_STROKE);
      this.o = ((int)TypedValue.applyDimension(1, 5.0F, paramResources.getDisplayMetrics()));
      this.p = ((int)TypedValue.applyDimension(1, 7.0F, paramResources.getDisplayMetrics()));
      this.q = ((int)TypedValue.applyDimension(1, 9.0F, paramResources.getDisplayMetrics()));
      return;
    }
  }

  public Rect a()
  {
    return new Rect((int)(this.e - this.j), (int)(this.f - this.j), (int)(this.e + this.j), (int)(this.f + this.j));
  }

  public void a(float paramFloat)
  {
    this.G.a(paramFloat);
    if (this.v != null)
      for (int i1 = 0; i1 < this.v.length; i1++)
        if (this.v[i1] != null)
          this.v[i1].a(paramFloat);
  }

  public void a(float paramFloat, int paramInt)
  {
    if ((paramInt == 0) && ((this.v == null) || (this.w == null)))
    {
      this.v = new com.viber.voip.ui.call.a.c[3];
      this.w = new e[3];
    }
    switch (paramInt)
    {
    case 1:
    case 2:
    case 4:
    default:
      return;
    case 0:
      if (this.v[0] == null)
      {
        this.v[0] = new c(this.e, this.f, this.j, this.k, paramFloat, false);
        this.w[0] = ((e)this.v[0]);
        return;
      }
      this.v[0].c();
      return;
    case 3:
      if (this.v[1] == null)
      {
        this.v[1] = new c(this.e, this.f, this.j, this.k, paramFloat, false);
        this.w[1] = ((e)this.v[1]);
        return;
      }
      this.v[1].c();
      return;
    case 5:
    }
    if (this.v[2] == null)
    {
      this.v[2] = new c(this.e, this.f, this.j, this.k, paramFloat, false);
      this.w[2] = ((e)this.v[2]);
      return;
    }
    this.v[2].c();
  }

  public void a(Canvas paramCanvas)
  {
    if (this.w != null)
      for (int i1 = 0; i1 < this.w.length; i1++)
        if ((this.w[i1] != null) && (this.w[i1].b()))
          this.w[i1].a(paramCanvas);
    if (this.r)
    {
      if (this.s)
      {
        paramCanvas.save();
        paramCanvas.translate(this.C.c, 0.0F);
      }
      this.u.setStrokeWidth(this.d);
      paramCanvas.drawCircle(this.g, this.h, this.j, this.u);
      this.t.setStrokeWidth(this.d);
      paramCanvas.drawCircle(this.g, this.h, this.j, this.t);
      Rect localRect1 = this.x.copyBounds();
      localRect1.offsetTo((int)(this.g - localRect1.width() / 2), (int)(this.h - localRect1.height() / 2));
      this.x.setBounds(localRect1);
      if (!this.s)
        break label542;
      paramCanvas.save();
      paramCanvas.rotate(this.B.c, this.g + this.l, this.h + this.m);
      this.x.draw(paramCanvas);
      paramCanvas.restore();
      Rect localRect2 = this.y.copyBounds();
      localRect2.offsetTo((int)(this.g + this.o - localRect2.width() / 2), (int)(this.h - this.o - localRect2.height() / 2));
      this.y.setBounds(localRect2);
      if (!this.s)
        break label553;
      this.y.setAlpha((int)this.D.c);
      label336: this.y.draw(paramCanvas);
      Rect localRect3 = this.z.copyBounds();
      localRect3.offsetTo((int)(this.g + this.p - localRect3.width() / 2), (int)(this.h - this.p - localRect3.height() / 2));
      this.z.setBounds(localRect3);
      if (!this.s)
        break label566;
      this.z.setAlpha((int)this.E.c);
      label429: this.z.draw(paramCanvas);
      Rect localRect4 = this.A.copyBounds();
      localRect4.offsetTo((int)(this.g + this.q - localRect4.width() / 2), (int)(this.h - this.q - localRect4.height() / 2));
      this.A.setBounds(localRect4);
      if (!this.s)
        break label579;
      this.A.setAlpha((int)this.F.c);
    }
    while (true)
    {
      this.A.draw(paramCanvas);
      if (this.s)
        paramCanvas.restore();
      return;
      label542: this.x.draw(paramCanvas);
      break;
      label553: this.y.setAlpha(255);
      break label336;
      label566: this.z.setAlpha(255);
      break label429;
      label579: this.A.setAlpha(255);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public void b(float paramFloat)
  {
  }

  public void b(float paramFloat, int paramInt)
  {
  }

  public boolean b()
  {
    return true;
  }

  public void c()
  {
    this.G.c();
    this.g = this.e;
    this.h = this.f;
  }

  public void c(float paramFloat)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.s)
    {
      Rect localRect = a();
      localRect.inset(-20, -20);
      if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        return false;
    }
    int i1 = paramMotionEvent.getAction();
    boolean bool = false;
    if (i1 != 2)
    {
      int i2 = paramMotionEvent.getAction();
      bool = false;
      if (i2 != 0)
        bool = true;
    }
    this.s = bool;
    if (!this.s)
    {
      this.g = paramMotionEvent.getX();
      this.h = paramMotionEvent.getY();
    }
    for (this.d = (this.c / 2.0F); ; this.d = this.c)
    {
      return true;
      this.g = this.e;
      this.h = this.f;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.call.a
 * JD-Core Version:    0.6.2
 */