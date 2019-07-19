package com.swmansion.gesturehandler;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import javax.annotation.Nullable;

public class d
{
  private static final PointF a = new PointF();
  private static final float[] b = new float[2];
  private static final Matrix c = new Matrix();
  private static final float[] d = new float[2];
  private static final Comparator<b> e = new Comparator()
  {
    public int a(b paramAnonymousb1, b paramAnonymousb2)
    {
      int i = -1;
      if (((paramAnonymousb1.b) && (paramAnonymousb2.b)) || ((paramAnonymousb1.c) && (paramAnonymousb2.c)))
        i = Integer.signum(paramAnonymousb2.a - paramAnonymousb1.a);
      do
      {
        do
          return i;
        while (paramAnonymousb1.b);
        if (paramAnonymousb2.b)
          return 1;
      }
      while (paramAnonymousb1.c);
      if (paramAnonymousb2.c)
        return 1;
      return 0;
    }
  };
  private final ViewGroup f;
  private final e g;
  private final p h;
  private final b[] i = new b[20];
  private final b[] j = new b[20];
  private final b[] k = new b[20];
  private final b[] l = new b[20];
  private int m = 0;
  private int n = 0;
  private boolean o = false;
  private int p = 0;
  private boolean q = false;
  private int r = 0;
  private float s = 0.0F;

  public d(ViewGroup paramViewGroup, e parame, p paramp)
  {
    this.f = paramViewGroup;
    this.g = parame;
    this.h = paramp;
  }

  private void a()
  {
    if ((this.o) || (this.p != 0))
    {
      this.q = true;
      return;
    }
    b();
  }

  private static void a(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, View paramView, PointF paramPointF)
  {
    float f1 = paramFloat1 + paramViewGroup.getScrollX() - paramView.getLeft();
    float f2 = paramFloat2 + paramViewGroup.getScrollY() - paramView.getTop();
    Matrix localMatrix1 = paramView.getMatrix();
    if (!localMatrix1.isIdentity())
    {
      float[] arrayOfFloat = b;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f2;
      Matrix localMatrix2 = c;
      localMatrix1.invert(localMatrix2);
      localMatrix2.mapPoints(arrayOfFloat);
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[1];
    }
    paramPointF.set(f1, f2);
  }

  private void a(View paramView, MotionEvent paramMotionEvent, float[] paramArrayOfFloat)
  {
    if (paramView == this.f)
    {
      paramArrayOfFloat[0] = paramMotionEvent.getX();
      paramArrayOfFloat[1] = paramMotionEvent.getY();
      return;
    }
    if ((paramView == null) || (!(paramView.getParent() instanceof ViewGroup)))
      throw new IllegalArgumentException("Parent is null? View is no longer in the tree");
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    a(localViewGroup, paramMotionEvent, paramArrayOfFloat);
    PointF localPointF = a;
    a(paramArrayOfFloat[0], paramArrayOfFloat[1], localViewGroup, paramView, localPointF);
    paramArrayOfFloat[0] = localPointF.x;
    paramArrayOfFloat[1] = localPointF.y;
  }

  private void a(b paramb, MotionEvent paramMotionEvent)
  {
    if (!a(paramb.e()))
      paramb.j();
    int i1;
    do
    {
      do
      {
        do
          return;
        while (!paramb.h());
        i1 = paramMotionEvent.getActionMasked();
      }
      while ((paramb.c) && (i1 == 2));
      float[] arrayOfFloat = d;
      a(paramb.e(), paramMotionEvent, arrayOfFloat);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      paramMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
      paramb.c(paramMotionEvent);
      if (paramb.b)
        paramb.b(paramMotionEvent);
      paramMotionEvent.setLocation(f1, f2);
    }
    while ((i1 != 1) && (i1 != 6));
    paramb.e(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
  }

  private void a(b paramb, View paramView)
  {
    for (int i1 = 0; i1 < this.m; i1++)
      if (this.i[i1] == paramb)
        return;
    if (this.m >= this.i.length)
      throw new IllegalStateException("Too many recognizers");
    b[] arrayOfb = this.i;
    int i2 = this.m;
    this.m = (i2 + 1);
    arrayOfb[i2] = paramb;
    paramb.b = false;
    paramb.c = false;
    paramb.a = 2147483647;
    paramb.a(paramView, this);
  }

  private static boolean a(float paramFloat1, float paramFloat2, View paramView)
  {
    return (paramFloat1 >= 0.0F) && (paramFloat1 <= paramView.getWidth()) && (paramFloat2 >= 0.0F) && (paramFloat2 < paramView.getHeight());
  }

  private static boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 1) || (paramInt == 5);
  }

  private boolean a(@Nullable View paramView)
  {
    boolean bool = true;
    if (paramView == null)
      bool = false;
    ViewParent localViewParent;
    do
    {
      do
        return bool;
      while (paramView == this.f);
      for (localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this.f); localViewParent = localViewParent.getParent());
    }
    while (localViewParent == this.f);
    return false;
  }

  private static boolean a(View paramView, float[] paramArrayOfFloat)
  {
    if ((!(paramView instanceof ViewGroup)) || (paramView.getBackground() != null));
    for (int i1 = 1; (i1 != 0) && (a(paramArrayOfFloat[0], paramArrayOfFloat[1], paramView)); i1 = 0)
      return true;
    return false;
  }

  private boolean a(View paramView, float[] paramArrayOfFloat, int paramInt)
  {
    ArrayList localArrayList = this.g.a(paramView);
    int i2;
    boolean bool1;
    if (localArrayList != null)
    {
      int i1 = localArrayList.size();
      i2 = 0;
      bool1 = false;
      if (i2 >= i1)
        break label101;
      b localb = (b)localArrayList.get(i2);
      if ((!localb.c()) || (!localb.a(paramView, paramArrayOfFloat[0], paramArrayOfFloat[1])))
        break label104;
      a(localb, paramView);
      localb.d(paramInt);
    }
    label101: label104: for (boolean bool2 = true; ; bool2 = bool1)
    {
      i2++;
      bool1 = bool2;
      break;
      bool1 = false;
      return bool1;
    }
  }

  private boolean a(ViewGroup paramViewGroup, float[] paramArrayOfFloat, int paramInt)
  {
    int i1 = -1 + paramViewGroup.getChildCount();
    boolean bool1 = false;
    View localView;
    float f1;
    float f2;
    if (i1 >= 0)
    {
      localView = this.h.a(paramViewGroup, i1);
      if (!b(localView))
        break label138;
      PointF localPointF = a;
      a(paramArrayOfFloat[0], paramArrayOfFloat[1], paramViewGroup, localView, localPointF);
      f1 = paramArrayOfFloat[0];
      f2 = paramArrayOfFloat[1];
      paramArrayOfFloat[0] = localPointF.x;
      paramArrayOfFloat[1] = localPointF.y;
      if ((c(localView)) && (!a(paramArrayOfFloat[0], paramArrayOfFloat[1], localView)))
        break label144;
    }
    label138: label144: for (boolean bool2 = b(localView, paramArrayOfFloat, paramInt); ; bool2 = false)
    {
      paramArrayOfFloat[0] = f1;
      paramArrayOfFloat[1] = f2;
      if (bool2)
      {
        bool1 = true;
        return bool1;
      }
      i1--;
      break;
    }
  }

  private boolean a(b paramb)
  {
    for (int i1 = 0; ; i1++)
    {
      int i2 = this.m;
      boolean bool = false;
      if (i1 < i2)
      {
        b localb = this.i[i1];
        if ((!a(localb.i())) && (a(paramb, localb)))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  private static boolean a(b paramb1, b paramb2)
  {
    return (paramb1 != paramb2) && ((paramb1.c(paramb2)) || (paramb2.b(paramb1)));
  }

  private void b()
  {
    int i1 = -1 + this.m;
    int i2 = 0;
    while (i1 >= 0)
    {
      b localb = this.i[i1];
      if ((a(localb.i())) && (!localb.c))
      {
        this.i[i1] = null;
        i2 = 1;
        localb.o();
        localb.b = false;
        localb.c = false;
        localb.a = 2147483647;
      }
      i1--;
    }
    if (i2 != 0)
    {
      int i3 = 0;
      int i4 = 0;
      while (i3 < this.m)
      {
        if (this.i[i3] != null)
        {
          b[] arrayOfb = this.i;
          int i5 = i4 + 1;
          arrayOfb[i4] = this.i[i3];
          i4 = i5;
        }
        i3++;
      }
      this.m = i4;
    }
    this.q = false;
  }

  private void b(b paramb)
  {
    if (a(paramb))
    {
      d(paramb);
      return;
    }
    c(paramb);
    paramb.c = false;
  }

  private boolean b(View paramView)
  {
    return (paramView.getVisibility() == 0) && (paramView.getAlpha() >= this.s);
  }

  private boolean b(View paramView, float[] paramArrayOfFloat, int paramInt)
  {
    l locall = this.h.a(paramView);
    if (locall == l.a);
    while (true)
    {
      return false;
      if (locall == l.c)
      {
        if ((a(paramView, paramArrayOfFloat, paramInt)) || (a(paramView, paramArrayOfFloat)));
        for (boolean bool2 = true; ; bool2 = false)
          return bool2;
      }
      if (locall == l.b)
      {
        if ((paramView instanceof ViewGroup))
          return a((ViewGroup)paramView, paramArrayOfFloat, paramInt);
      }
      else
      {
        if (locall == l.d)
          if (!(paramView instanceof ViewGroup))
            break label170;
        label170: for (boolean bool1 = a((ViewGroup)paramView, paramArrayOfFloat, paramInt); (a(paramView, paramArrayOfFloat, paramInt)) || (bool1) || (a(paramView, paramArrayOfFloat)); bool1 = false)
        {
          return true;
          throw new IllegalArgumentException("Unknown pointer event type: " + locall.toString());
        }
      }
    }
  }

  private static boolean b(b paramb1, b paramb2)
  {
    return (paramb1 == paramb2) || (paramb1.d(paramb2)) || (paramb2.d(paramb1));
  }

  private void c()
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.n)
    {
      if (this.j[i1].c)
      {
        b[] arrayOfb = this.j;
        int i3 = i2 + 1;
        arrayOfb[i2] = this.j[i1];
        i2 = i3;
      }
      i1++;
    }
    this.n = i2;
  }

  private void c(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    int i2 = paramMotionEvent.getPointerId(i1);
    d[0] = paramMotionEvent.getX(i1);
    d[1] = paramMotionEvent.getY(i1);
    b(this.f, d, i2);
    a(this.f, d, i2);
  }

  private void c(b paramb)
  {
    int i1 = paramb.i();
    paramb.c = false;
    paramb.b = true;
    int i2 = this.r;
    this.r = (i2 + 1);
    paramb.a = i2;
    int i3 = 0;
    int i4 = 0;
    while (i3 < this.m)
    {
      b localb2 = this.i[i3];
      if (c(localb2, paramb))
      {
        b[] arrayOfb = this.l;
        int i7 = i4 + 1;
        arrayOfb[i4] = localb2;
        i4 = i7;
      }
      i3++;
    }
    for (int i5 = i4 - 1; i5 >= 0; i5--)
      this.l[i5].j();
    for (int i6 = -1 + this.n; i6 >= 0; i6--)
    {
      b localb1 = this.j[i6];
      if (c(localb1, paramb))
      {
        localb1.j();
        localb1.c = false;
      }
    }
    c();
    paramb.a(4, 2);
    if (i1 != 4)
    {
      paramb.a(5, 4);
      if (i1 != 5)
        paramb.a(0, 5);
    }
  }

  private boolean c(View paramView)
  {
    return (!(paramView instanceof ViewGroup)) || (this.h.a((ViewGroup)paramView));
  }

  private static boolean c(b paramb1, b paramb2)
  {
    if (!paramb1.a(paramb2));
    while (b(paramb1, paramb2))
      return false;
    if ((paramb1 != paramb2) && ((paramb1.c) || (paramb1.i() == 4)))
      return paramb1.e(paramb2);
    return true;
  }

  private void d()
  {
    for (int i1 = -1 + this.n; i1 >= 0; i1--)
      this.j[i1].j();
    int i2 = this.m;
    for (int i3 = 0; i3 < i2; i3++)
      this.k[i3] = this.i[i3];
    for (int i4 = i2 - 1; i4 >= 0; i4--)
      this.k[i4].j();
  }

  private void d(b paramb)
  {
    for (int i1 = 0; i1 < this.n; i1++)
      if (this.j[i1] == paramb)
        return;
    if (this.n >= this.j.length)
      throw new IllegalStateException("Too many recognizers");
    b[] arrayOfb = this.j;
    int i2 = this.n;
    this.n = (i2 + 1);
    arrayOfb[i2] = paramb;
    paramb.c = true;
    int i3 = this.r;
    this.r = (i3 + 1);
    paramb.a = i3;
  }

  public void a(float paramFloat)
  {
    this.s = paramFloat;
  }

  void a(b paramb, int paramInt1, int paramInt2)
  {
    this.p = (1 + this.p);
    if (a(paramInt1))
    {
      int i1 = 0;
      if (i1 < this.n)
      {
        b localb = this.j[i1];
        if (a(localb, paramb))
        {
          if (paramInt1 != 5)
            break label69;
          localb.j();
          localb.c = false;
        }
        while (true)
        {
          i1++;
          break;
          label69: b(localb);
        }
      }
      c();
    }
    if (paramInt1 == 4)
      b(paramb);
    while (true)
    {
      this.p = (-1 + this.p);
      a();
      return;
      if ((paramInt2 == 4) || (paramInt2 == 5))
      {
        if (paramb.b)
          paramb.a(paramInt1, paramInt2);
      }
      else
        paramb.a(paramInt1, paramInt2);
    }
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    this.o = true;
    int i1 = paramMotionEvent.getActionMasked();
    if ((i1 == 0) || (i1 == 5))
      c(paramMotionEvent);
    while (true)
    {
      b(paramMotionEvent);
      this.o = false;
      if ((this.q) && (this.p == 0))
        b();
      return true;
      if (i1 == 3)
        d();
    }
  }

  public void b(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    int i2 = this.m;
    System.arraycopy(this.i, 0, this.k, 0, i2);
    Arrays.sort(this.k, 0, i2, e);
    while (i1 < i2)
    {
      a(this.k[i1], paramMotionEvent);
      i1++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.d
 * JD-Core Version:    0.6.2
 */