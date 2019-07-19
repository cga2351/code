package com.viber.voip.widget.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView extends ListView
{
  private static final Logger a = ViberEnv.getLogger();
  private int A;
  private int B = 0;
  private View[] C = new View[1];
  private d D;
  private float E = 0.3333333F;
  private float F = 0.3333333F;
  private int G;
  private int H;
  private float I;
  private float J;
  private float K;
  private float L;
  private float M = 0.5F;
  private c N = new c()
  {
    public float a(float paramAnonymousFloat, long paramAnonymousLong)
    {
      return paramAnonymousFloat * DragSortListView.a(DragSortListView.this);
    }
  };
  private int O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private int T = 0;
  private boolean U = false;
  private boolean V = false;
  private i W = null;
  private MotionEvent aa;
  private int ab = 0;
  private float ac = 0.25F;
  private float ad = 0.0F;
  private a ae;
  private boolean af = false;
  private f ag;
  private boolean ah = false;
  private boolean ai = false;
  private j aj = new j(3);
  private l ak;
  private k al;
  private g am;
  private boolean an;
  private float ao = 0.0F;
  private boolean ap = false;
  private boolean aq = false;
  private View b;
  private Point c = new Point();
  private Point d = new Point();
  private int e;
  private boolean f = false;
  private DataSetObserver g;
  private float h = 1.0F;
  private float i = 1.0F;
  private int j;
  private int k;
  private int l;
  private boolean m = false;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private b t;
  private h u;
  private m v;
  private boolean w = true;
  private int x = 0;
  private int y = 1;
  private int z;

  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode())
      return;
    int i1 = 150;
    boolean bool1;
    int i2;
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView, 0, 0);
      this.y = Math.max(1, localTypedArray.getDimensionPixelSize(R.styleable.DragSortListView_collapsed_height, 1));
      this.af = localTypedArray.getBoolean(R.styleable.DragSortListView_track_drag_sort, false);
      if (this.af)
        this.ag = new f();
      this.h = localTypedArray.getFloat(R.styleable.DragSortListView_float_alpha, this.h);
      this.i = this.h;
      this.w = localTypedArray.getBoolean(R.styleable.DragSortListView_drag_enabled, this.w);
      this.ac = Math.max(0.0F, Math.min(1.0F, 1.0F - localTypedArray.getFloat(R.styleable.DragSortListView_slide_shuffle_speed, 0.75F)));
      if (this.ac > 0.0F)
      {
        bool1 = true;
        this.m = bool1;
        setDragScrollStart(localTypedArray.getFloat(R.styleable.DragSortListView_drag_scroll_start, this.E));
        this.M = localTypedArray.getFloat(R.styleable.DragSortListView_max_drag_scroll_speed, this.M);
        int i3 = localTypedArray.getInt(R.styleable.DragSortListView_remove_animation_duration, i1);
        int i4 = localTypedArray.getInt(R.styleable.DragSortListView_drop_animation_duration, i1);
        if (localTypedArray.getBoolean(R.styleable.DragSortListView_use_default_controller, true))
        {
          boolean bool2 = localTypedArray.getBoolean(R.styleable.DragSortListView_remove_enabled, false);
          int i5 = localTypedArray.getInt(R.styleable.DragSortListView_remove_mode, 1);
          boolean bool3 = localTypedArray.getBoolean(R.styleable.DragSortListView_sort_enabled, true);
          int i6 = localTypedArray.getInt(R.styleable.DragSortListView_drag_start_mode, 0);
          int i7 = localTypedArray.getResourceId(R.styleable.DragSortListView_drag_handle_id, 0);
          int i8 = localTypedArray.getResourceId(R.styleable.DragSortListView_fling_handle_id, 0);
          int i9 = localTypedArray.getResourceId(R.styleable.DragSortListView_click_remove_id, 0);
          int i10 = localTypedArray.getColor(R.styleable.DragSortListView_float_background_color, -16777216);
          a locala = new a(this, i7, i6, i5, i9, i8);
          locala.b(bool2);
          locala.a(bool3);
          locala.d(i10);
          this.W = locala;
          setOnTouchListener(locala);
        }
        localTypedArray.recycle();
        i2 = i4;
        i1 = i3;
      }
    }
    while (true)
    {
      this.D = new d();
      if (i1 > 0)
        this.ak = new l(0.5F, i1);
      if (i2 > 0)
        this.am = new g(0.5F, i2);
      this.aa = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.g = new DataSetObserver()
      {
        private void a()
        {
          if (DragSortListView.b(DragSortListView.this) == 4)
            DragSortListView.this.a();
        }

        public void onChanged()
        {
          a();
        }

        public void onInvalidated()
        {
          a();
        }
      };
      return;
      bool1 = false;
      break;
      i2 = i1;
    }
  }

  private int a(int paramInt1, int paramInt2)
  {
    int i1 = getHeaderViewsCount();
    int i2 = getFooterViewsCount();
    if ((paramInt1 <= i1) || (paramInt1 >= getCount() - i2))
      return paramInt2;
    int i3 = getDividerHeight();
    int i4 = this.z - this.y;
    int i5 = d(paramInt1);
    int i6 = b(paramInt1);
    if (this.l <= this.n)
      if ((paramInt1 == this.l) && (this.k != this.l))
        if (paramInt1 == this.n)
          paramInt2 = paramInt2 + i6 - this.z;
    while (paramInt1 <= this.n)
    {
      return paramInt2 + (this.z - i3 - d(paramInt1 - 1)) / 2;
      paramInt2 = paramInt2 + (i6 - i5) - i4;
      continue;
      if ((paramInt1 > this.l) && (paramInt1 <= this.n))
      {
        paramInt2 -= i4;
        continue;
        if ((paramInt1 > this.n) && (paramInt1 <= this.k))
          paramInt2 += i4;
        else if ((paramInt1 == this.l) && (this.k != this.l))
          paramInt2 += i6 - i5;
      }
    }
    return paramInt2 + (i5 - i3 - this.z) / 2;
  }

  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    int i1 = d(paramInt1);
    int i2 = paramView.getHeight();
    int i3 = c(paramInt1, i1);
    int i5;
    int i4;
    if (paramInt1 != this.n)
    {
      i5 = i2 - i1;
      i4 = i3 - i1;
    }
    while (true)
    {
      int i6 = this.z;
      if ((this.n != this.k) && (this.n != this.l))
        i6 -= this.y;
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 > this.k)
          return 0 + (i6 - i4);
      }
      else
      {
        if (paramInt1 == paramInt3)
        {
          if (paramInt1 <= this.k)
            return 0 + (i5 - i6);
          if (paramInt1 == this.l)
            return 0 + (i2 - i3);
          return 0 + i5;
        }
        if (paramInt1 <= this.k)
          return 0 - i6;
        if (paramInt1 == this.l)
          return 0 - i4;
      }
      return 0;
      i4 = i3;
      i5 = i2;
    }
  }

  private void a(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = getDivider();
    int i1 = getDividerHeight();
    ViewGroup localViewGroup;
    int i2;
    int i3;
    int i4;
    int i6;
    int i5;
    if ((localDrawable != null) && (i1 != 0))
    {
      localViewGroup = (ViewGroup)getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        i2 = getPaddingLeft();
        i3 = getWidth() - getPaddingRight();
        i4 = localViewGroup.getChildAt(0).getHeight();
        if (paramInt <= this.n)
          break label133;
        i6 = i4 + localViewGroup.getTop();
        i5 = i6 + i1;
      }
    }
    while (true)
    {
      paramCanvas.save();
      paramCanvas.clipRect(i2, i6, i3, i5);
      localDrawable.setBounds(i2, i6, i3, i5);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
      label133: i5 = localViewGroup.getBottom() - i4;
      i6 = i5 - i1;
    }
  }

  private void a(int paramInt, View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i1;
    if ((paramInt != this.n) && (paramInt != this.k) && (paramInt != this.l))
    {
      i1 = -2;
      if (i1 != localLayoutParams.height)
      {
        localLayoutParams.height = i1;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.k) || (paramInt == this.l))
      {
        if (paramInt >= this.n)
          break label154;
        ((b)paramView).setGravity(80);
      }
    }
    while (true)
    {
      int i2 = paramView.getVisibility();
      int i3 = this.n;
      int i4 = 0;
      if (paramInt == i3)
      {
        View localView = this.b;
        i4 = 0;
        if (localView != null)
          i4 = 4;
      }
      if (i4 != i2)
        paramView.setVisibility(i4);
      return;
      i1 = c(paramInt, paramView, paramBoolean);
      break;
      label154: if (paramInt > this.n)
        ((b)paramView).setGravity(48);
    }
  }

  private void a(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i1 = ViewGroup.getChildMeasureSpec(this.B, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0);
    for (int i2 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824); ; i2 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i1, i2);
      return;
    }
  }

  private int b(int paramInt)
  {
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
      return localView.getHeight();
    return c(paramInt, d(paramInt));
  }

  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = this.n;
    int i2 = 0;
    if (paramInt == i1);
    do
    {
      return i2;
      if ((paramInt < getHeaderViewsCount()) || (paramInt >= getCount() - getFooterViewsCount()));
      while (true)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        if ((localLayoutParams == null) || (localLayoutParams.height <= 0))
          break;
        return localLayoutParams.height;
        paramView = ((ViewGroup)paramView).getChildAt(0);
      }
      i2 = paramView.getHeight();
    }
    while ((i2 != 0) && (!paramBoolean));
    a(paramView);
    return paramView.getMeasuredHeight();
  }

  private void b(int paramInt1, int paramInt2)
  {
    this.c.x = (paramInt1 - this.o);
    this.c.y = (paramInt2 - this.p);
    b(true);
    int i1 = Math.min(paramInt2, this.e + this.A);
    int i2 = Math.max(paramInt2, this.e - this.A);
    int i3 = this.D.b();
    if ((i1 > this.R) && (i1 > this.H) && (i3 != 1))
    {
      if (i3 != -1)
        this.D.a(true);
      this.D.a(1);
    }
    do
    {
      return;
      if ((i2 < this.R) && (i2 < this.G) && (i3 != 0))
      {
        if (i3 != -1)
          this.D.a(true);
        this.D.a(0);
        return;
      }
    }
    while ((i2 < this.G) || (i1 > this.H) || (!this.D.a()));
    this.D.a(true);
  }

  private void b(MotionEvent paramMotionEvent)
  {
    int i1 = 0xFF & paramMotionEvent.getAction();
    if (i1 != 0)
    {
      this.Q = this.O;
      this.R = this.P;
    }
    this.O = ((int)paramMotionEvent.getX());
    this.P = ((int)paramMotionEvent.getY());
    if (i1 == 0)
    {
      this.Q = this.O;
      this.R = this.P;
    }
    this.q = ((int)paramMotionEvent.getRawX() - this.O);
    this.r = ((int)paramMotionEvent.getRawY() - this.P);
  }

  private void b(boolean paramBoolean)
  {
    int i1 = getFirstVisiblePosition() + getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null)
      return;
    d(i1, localView, paramBoolean);
  }

  private int c(int paramInt1, int paramInt2)
  {
    getDividerHeight();
    int i1;
    int i2;
    int i3;
    if ((this.m) && (this.k != this.l))
    {
      i1 = 1;
      i2 = this.z - this.y;
      i3 = (int)(this.ad * i2);
      if (paramInt1 != this.n)
        break label117;
      if (this.n != this.k)
        break label93;
      if (i1 == 0)
        break label88;
      paramInt2 = i3 + this.y;
    }
    label88: label93: label117: 
    do
    {
      return paramInt2;
      i1 = 0;
      break;
      return this.z;
      if (this.n == this.l)
        return this.z - i3;
      return this.y;
      if (paramInt1 == this.k)
      {
        if (i1 != 0)
          return paramInt2 + i3;
        return paramInt2 + i2;
      }
    }
    while (paramInt1 != this.l);
    return paramInt2 + i2 - i3;
  }

  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    return c(paramInt, b(paramInt, paramView, paramBoolean));
  }

  private void c(int paramInt)
  {
    this.x = 1;
    if (this.v != null)
      this.v.a(paramInt);
    n();
    h();
    e();
    if (this.V)
    {
      this.x = 3;
      return;
    }
    this.x = 0;
  }

  private int d(int paramInt)
  {
    int i1 = this.n;
    int i2 = 0;
    if (paramInt == i1);
    do
    {
      return i2;
      View localView1 = getChildAt(paramInt - getFirstVisiblePosition());
      if (localView1 != null)
        return b(paramInt, localView1, false);
      i2 = this.aj.a(paramInt);
    }
    while (i2 != -1);
    ListAdapter localListAdapter = getAdapter();
    int i3 = localListAdapter.getItemViewType(paramInt);
    int i4 = localListAdapter.getViewTypeCount();
    if (i4 != this.C.length)
      this.C = new View[i4];
    View localView2;
    if (i3 >= 0)
      if (this.C[i3] == null)
      {
        localView2 = localListAdapter.getView(paramInt, null, this);
        this.C[i3] = localView2;
      }
    while (true)
    {
      int i5 = b(paramInt, localView2, true);
      this.aj.a(paramInt, i5);
      return i5;
      localView2 = localListAdapter.getView(paramInt, this.C[i3], this);
      continue;
      localView2 = localListAdapter.getView(paramInt, null, this);
    }
  }

  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    this.ah = true;
    m();
    int i1 = this.k;
    int i2 = this.l;
    boolean bool = d();
    if (bool)
    {
      k();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i1, i2) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean))
      invalidate();
    this.ah = false;
  }

  private boolean d()
  {
    int i1 = getFirstVisiblePosition();
    int i2 = this.k;
    View localView = getChildAt(i2 - i1);
    if (localView == null)
    {
      i2 = i1 + getChildCount() / 2;
      localView = getChildAt(i2 - i1);
    }
    int i3 = localView.getTop();
    int i4 = localView.getHeight();
    int i5 = a(i2, i3);
    int i6 = getDividerHeight();
    int i22;
    int i10;
    int i11;
    int i12;
    int i23;
    label121: int i13;
    int i14;
    label177: float f2;
    int i21;
    if (this.e < i5)
    {
      i22 = i3;
      i10 = i5;
      i11 = i2;
      i12 = i5;
      if (i11 >= 0)
      {
        i11--;
        i23 = b(i11);
        if (i11 == 0)
          i10 = i22 - i6 - i23;
      }
      else
      {
        i13 = getHeaderViewsCount();
        i14 = getFooterViewsCount();
        int i15 = this.k;
        int i16 = this.l;
        float f1 = this.ad;
        if (!this.m)
          break label569;
        int i17 = Math.abs(i10 - i12);
        if (this.e >= i10)
          break label493;
        int i19 = (int)(0.5F * this.ac * i17);
        f2 = i19;
        int i20 = i12 + i19;
        i21 = i10 - i19;
        if (this.e >= i20)
          break label508;
        this.k = (i11 - 1);
        this.l = i11;
        this.ad = (0.5F * (i20 - this.e) / f2);
        label251: if (this.k >= i13)
          break label584;
        this.k = i13;
        this.l = i13;
        i11 = i13;
        label276: if ((this.k == i15) && (this.l == i16) && (this.ad == f1))
          break label627;
      }
    }
    label491: label493: label627: for (boolean bool = true; ; bool = false)
    {
      if (i11 != this.j)
      {
        if (this.t != null)
          this.t.a(this.j - i13, i11 - i13);
        this.j = i11;
        return true;
        i22 -= i23 + i6;
        i10 = a(i11, i22);
        if (this.e >= i10)
          break label121;
        i12 = i10;
        break;
        int i7 = getCount();
        int i8 = i4;
        int i9 = i3;
        i10 = i5;
        i11 = i2;
        for (i12 = i5; ; i12 = i10)
        {
          if (i11 >= i7)
            break label491;
          if (i11 == i7 - 1)
          {
            i10 = i8 + (i9 + i6);
            break;
          }
          i9 += i6 + i8;
          i8 = b(i11 + 1);
          i10 = a(i11 + 1, i9);
          if (this.e < i10)
            break;
          i11++;
        }
        break label121;
        int i18 = i12;
        i12 = i10;
        i10 = i18;
        break label177;
        label508: if (this.e < i21)
        {
          this.k = i11;
          this.l = i11;
          break label251;
        }
        this.k = i11;
        this.l = (i11 + 1);
        this.ad = (0.5F * (1.0F + (i10 - this.e) / f2));
        break label251;
        this.k = i11;
        this.l = i11;
        break label251;
        if (this.l < getCount() - i14)
          break label276;
        i11 = -1 + (getCount() - i14);
        this.k = i11;
        this.l = i11;
        break label276;
      }
      return bool;
    }
  }

  private void e()
  {
    this.n = -1;
    this.k = -1;
    this.l = -1;
    this.j = -1;
  }

  private void f()
  {
    this.x = 2;
    if ((this.u != null) && (this.j >= 0) && (this.j < getCount()))
    {
      int i1 = getHeaderViewsCount();
      this.u.a_(this.n - i1, this.j - i1);
    }
    n();
    h();
    e();
    k();
    if (this.V)
    {
      this.x = 3;
      return;
    }
    this.x = 0;
  }

  private void g()
  {
    c(this.n - getHeaderViewsCount());
  }

  private void h()
  {
    int i1 = getFirstVisiblePosition();
    if (this.n < i1)
    {
      View localView = getChildAt(0);
      int i2 = 0;
      if (localView != null)
        i2 = localView.getTop();
      setSelectionFromTop(i1 - 1, i2 - getPaddingTop());
    }
  }

  private void i()
  {
    this.ab = 0;
    this.V = false;
    if (this.x == 3)
    {
      this.x = 4;
      a();
      this.x = 0;
    }
    this.i = this.h;
    this.ap = false;
    this.aj.a();
  }

  private void j()
  {
    int i1 = getPaddingTop();
    int i2 = getHeight() - i1 - getPaddingBottom();
    float f1 = i2;
    this.J = (i1 + f1 * this.E);
    this.I = (i1 + f1 * (1.0F - this.F));
    this.G = ((int)this.J);
    this.H = ((int)this.I);
    this.K = (this.J - i1);
    this.L = (i1 + i2 - this.I);
  }

  private void k()
  {
    int i1 = getFirstVisiblePosition();
    int i2 = getLastVisiblePosition();
    int i3 = Math.max(0, getHeaderViewsCount() - i1);
    int i4 = Math.min(i2 - i1, -1 + getCount() - getFooterViewsCount() - i1);
    while (i3 <= i4)
    {
      View localView = getChildAt(i3);
      if (localView != null)
        a(i1 + i3, localView, false);
      i3++;
    }
  }

  private void l()
  {
    if (this.b != null)
    {
      a(this.b);
      View localView = this.b.findViewById(R.id.image);
      if (localView == null)
        break label67;
      this.z = localView.getMeasuredHeight();
      this.s = ((this.b.getMeasuredHeight() - this.z) / 2);
    }
    while (true)
    {
      this.A = (this.z / 2);
      return;
      label67: this.z = this.b.getMeasuredHeight();
    }
  }

  private void m()
  {
    if (this.W != null)
    {
      this.d.set(this.O, this.P);
      this.W.a(this.b, this.c, this.d);
    }
    int i1 = this.c.x;
    int i2 = this.c.y;
    int i3 = getPaddingLeft();
    int i9;
    if (((0x1 & this.T) == 0) && (i1 > i3))
    {
      this.c.x = i3;
      int i4 = getHeaderViewsCount();
      int i5 = getFooterViewsCount();
      int i6 = getFirstVisiblePosition();
      int i7 = getLastVisiblePosition();
      int i8 = getPaddingTop();
      if (i6 < i4)
        i8 = getChildAt(-1 + (i4 - i6)).getBottom();
      if (((0x8 & this.T) == 0) && (i6 <= this.n))
        i8 = Math.max(getChildAt(this.n - i6).getTop(), i8);
      i9 = getHeight() - getPaddingBottom();
      if (i7 >= -1 + (getCount() - i5))
        i9 = getChildAt(-1 + (getCount() - i5) - i6).getBottom();
      if (((0x4 & this.T) == 0) && (i7 >= this.n))
        i9 = Math.min(getChildAt(this.n - i6).getBottom(), i9);
      if (i2 >= i8)
        break label321;
      this.c.y = i8;
    }
    while (true)
    {
      this.e = (this.c.y + this.A);
      return;
      if (((0x2 & this.T) != 0) || (i1 >= i3))
        break;
      this.c.x = i3;
      break;
      label321: if (i2 + this.z > i9)
        this.c.y = (i9 - this.z);
    }
  }

  private void n()
  {
    if (this.b != null)
    {
      this.b.setVisibility(8);
      if (this.W != null)
        this.W.a(this.b);
      this.b = null;
      invalidate();
    }
  }

  public void a()
  {
    if (this.x == 4)
    {
      this.D.a(true);
      n();
      e();
      k();
      if (this.V)
        this.x = 3;
    }
    else
    {
      return;
    }
    this.x = 0;
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.5F)
    {
      this.F = 0.5F;
      if (paramFloat1 <= 0.5F)
        break label46;
    }
    label46: for (this.E = 0.5F; ; this.E = paramFloat1)
    {
      if (getHeight() != 0)
        j();
      return;
      this.F = paramFloat2;
      break;
    }
  }

  public void a(int paramInt)
  {
    this.an = false;
    a(paramInt, 0.0F);
  }

  public void a(int paramInt, float paramFloat)
  {
    if ((this.x == 0) || (this.x == 4))
    {
      if (this.x == 0)
      {
        this.n = (paramInt + getHeaderViewsCount());
        this.k = this.n;
        this.l = this.n;
        this.j = this.n;
        View localView = getChildAt(this.n - getFirstVisiblePosition());
        if (localView != null)
          localView.setVisibility(4);
      }
      this.x = 1;
      this.ao = paramFloat;
      if (this.V)
        switch (this.ab)
        {
        default:
        case 1:
        case 2:
        }
    }
    while (this.ak != null)
    {
      this.ak.c();
      return;
      super.onTouchEvent(this.aa);
      continue;
      super.onInterceptTouchEvent(this.aa);
    }
    c(paramInt);
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!this.V) || (this.W == null));
    View localView;
    do
    {
      return false;
      localView = this.W.a(paramInt1);
    }
    while (localView == null);
    return a(paramInt1, localView, paramInt2, paramInt3, paramInt4);
  }

  public boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    if ((this.x != 0) || (!this.V) || (this.b != null) || (paramView == null) || (!this.w))
    {
      bool = false;
      return bool;
    }
    if (getParent() != null)
      getParent().requestDisallowInterceptTouchEvent(bool);
    int i1 = paramInt1 + getHeaderViewsCount();
    this.k = i1;
    this.l = i1;
    this.n = i1;
    this.j = i1;
    this.x = 4;
    this.T = 0;
    this.T = (paramInt2 | this.T);
    this.b = paramView;
    l();
    this.o = paramInt3;
    this.p = paramInt4;
    this.S = this.P;
    this.c.x = (this.O - this.o);
    this.c.y = (this.P - this.p);
    View localView = getChildAt(this.n - getFirstVisiblePosition());
    if (localView != null)
      localView.setVisibility(4);
    if (this.af)
      this.ag.a();
    switch (this.ab)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      requestLayout();
      if (this.al == null)
        break;
      this.al.c();
      return bool;
      super.onTouchEvent(this.aa);
      continue;
      super.onInterceptTouchEvent(this.aa);
    }
  }

  protected boolean a(MotionEvent paramMotionEvent)
  {
    switch (0xFF & paramMotionEvent.getAction())
    {
    default:
    case 3:
    case 1:
    case 2:
    }
    while (true)
    {
      return true;
      if (this.x == 4)
        a();
      i();
      continue;
      if (this.x == 4)
        a(false);
      i();
      continue;
      b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }

  public boolean a(boolean paramBoolean)
  {
    this.an = false;
    return b(paramBoolean, 0.0F);
  }

  public boolean a(boolean paramBoolean, float paramFloat)
  {
    this.an = true;
    return b(paramBoolean, paramFloat);
  }

  public boolean b()
  {
    return this.ap;
  }

  public boolean b(boolean paramBoolean, float paramFloat)
  {
    if (this.b != null)
    {
      this.D.a(true);
      if (paramBoolean)
        a(this.n - getHeaderViewsCount(), paramFloat);
      while (true)
      {
        if (this.af)
          this.ag.d();
        return true;
        if (this.am != null)
          this.am.c();
        else
          f();
      }
    }
    return false;
  }

  public boolean c()
  {
    return this.w;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.x != 0)
    {
      if (this.k != this.n)
        a(this.k, paramCanvas);
      if ((this.l != this.k) && (this.l != this.n))
        a(this.l, paramCanvas);
    }
    int i1;
    int i2;
    float f2;
    if (this.b != null)
    {
      i1 = this.b.getWidth();
      i2 = this.b.getHeight();
      int i3 = this.c.x;
      int i4 = getWidth();
      if (i3 < 0)
        i3 = -i3;
      if (i3 >= i4)
        break label218;
      f2 = (i4 - i3) / i4;
    }
    label218: for (float f1 = f2 * f2; ; f1 = 0.0F)
    {
      int i5 = (int)(f1 * (255.0F * this.i));
      paramCanvas.save();
      paramCanvas.translate(this.c.x, this.c.y - this.s);
      paramCanvas.clipRect(0, 0, i1, i2);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, i1, i2, i5, 31);
      this.b.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
  }

  public float getFloatAlpha()
  {
    return this.i;
  }

  public ListAdapter getInputAdapter()
  {
    if (this.ae == null)
      return null;
    return this.ae.a();
  }

  protected void layoutChildren()
  {
    super.layoutChildren();
    if (this.b != null)
    {
      if ((this.b.isLayoutRequested()) && (!this.f))
        l();
      this.b.layout(0, 0, this.b.getMeasuredWidth(), this.b.getMeasuredHeight());
      this.f = false;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.af)
      this.ag.b();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.w)
      return super.onInterceptTouchEvent(paramMotionEvent);
    b(paramMotionEvent);
    this.U = true;
    int i1 = 0xFF & paramMotionEvent.getAction();
    if (i1 == 0)
    {
      if (this.x != 0)
      {
        this.ai = true;
        return true;
      }
      this.V = true;
    }
    if (this.b != null)
    {
      bool = true;
      if ((i1 == 1) || (i1 == 3))
        this.V = false;
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent))
      this.ap = true;
    for (boolean bool = true; ; bool = false)
      switch (i1)
      {
      case 2:
      default:
        if (bool)
          this.ab = 1;
        break;
      case 1:
      case 3:
        i();
        break;
        this.ab = 2;
        break;
      }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.b != null)
    {
      if (this.b.isLayoutRequested())
        l();
      this.f = true;
    }
    this.B = paramInt1;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    j();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    if (this.ai)
      this.ai = false;
    do
    {
      return bool1;
      if (!this.w)
        return super.onTouchEvent(paramMotionEvent);
      boolean bool2 = this.U;
      this.U = false;
      if (!bool2)
        b(paramMotionEvent);
      if (this.x == 4)
      {
        a(paramMotionEvent);
        return true;
      }
      int i1 = this.x;
      bool1 = false;
      if (i1 == 0)
      {
        boolean bool3 = super.onTouchEvent(paramMotionEvent);
        bool1 = false;
        if (bool3)
          bool1 = true;
      }
      switch (0xFF & paramMotionEvent.getAction())
      {
      case 2:
      default:
      case 1:
      case 3:
      }
    }
    while (!bool1);
    this.ab = 1;
    return bool1;
    i();
    return bool1;
  }

  public void requestLayout()
  {
    if (!this.ah)
      super.requestLayout();
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter != null)
    {
      this.ae = new a(paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.g);
      if ((paramListAdapter instanceof h))
        setDropListener((h)paramListAdapter);
      if ((paramListAdapter instanceof b))
        setDragListener((b)paramListAdapter);
      if ((paramListAdapter instanceof m))
        setRemoveListener((m)paramListAdapter);
    }
    while (true)
    {
      super.setAdapter(this.ae);
      return;
      this.ae = null;
    }
  }

  public void setDragEnabled(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }

  public void setDragListener(b paramb)
  {
    this.t = paramb;
  }

  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null)
      this.N = paramc;
  }

  public void setDragScrollStart(float paramFloat)
  {
    a(paramFloat, paramFloat);
  }

  public void setDragSortListener(e parame)
  {
    setDropListener(parame);
    setDragListener(parame);
    setRemoveListener(parame);
  }

  public void setDropListener(h paramh)
  {
    this.u = paramh;
  }

  public void setFloatAlpha(float paramFloat)
  {
    this.i = paramFloat;
  }

  public void setFloatViewManager(i parami)
  {
    this.W = parami;
  }

  public void setMaxScrollSpeed(float paramFloat)
  {
    this.M = paramFloat;
  }

  public void setRemoveListener(m paramm)
  {
    this.v = paramm;
  }

  private class a extends BaseAdapter
  {
    private ListAdapter b;

    public a(ListAdapter arg2)
    {
      Object localObject;
      this.b = localObject;
      this.b.registerDataSetObserver(new DataSetObserver()
      {
        public void onChanged()
        {
          DragSortListView.a.this.notifyDataSetChanged();
        }

        public void onInvalidated()
        {
          DragSortListView.a.this.notifyDataSetInvalidated();
        }
      });
    }

    public ListAdapter a()
    {
      return this.b;
    }

    public boolean areAllItemsEnabled()
    {
      return this.b.areAllItemsEnabled();
    }

    public int getCount()
    {
      return this.b.getCount();
    }

    public Object getItem(int paramInt)
    {
      return this.b.getItem(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return this.b.getItemId(paramInt);
    }

    public int getItemViewType(int paramInt)
    {
      return this.b.getItemViewType(paramInt);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2;
      if (paramView != null)
      {
        localObject2 = (b)paramView;
        View localView2 = ((b)localObject2).getChildAt(0);
        View localView3 = this.b.getView(paramInt, localView2, DragSortListView.this);
        if (localView3 != localView2)
        {
          if (localView2 != null)
            ((b)localObject2).removeViewAt(0);
          ((b)localObject2).addView(localView3);
        }
        DragSortListView.a(DragSortListView.this, paramInt + DragSortListView.this.getHeaderViewsCount(), (View)localObject2, true);
        return localObject2;
      }
      View localView1 = this.b.getView(paramInt, null, DragSortListView.this);
      if ((localView1 instanceof Checkable));
      for (Object localObject1 = new c(DragSortListView.this.getContext()); ; localObject1 = new b(DragSortListView.this.getContext()))
      {
        ((b)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        ((b)localObject1).addView(localView1);
        localObject2 = localObject1;
        break;
      }
    }

    public int getViewTypeCount()
    {
      return this.b.getViewTypeCount();
    }

    public boolean hasStableIds()
    {
      return this.b.hasStableIds();
    }

    public boolean isEmpty()
    {
      return this.b.isEmpty();
    }

    public boolean isEnabled(int paramInt)
    {
      return this.b.isEnabled(paramInt);
    }
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2);
  }

  public static abstract interface c
  {
    public abstract float a(float paramFloat, long paramLong);
  }

  private class d
    implements Runnable
  {
    private boolean b;
    private long c;
    private long d;
    private int e;
    private float f;
    private long g;
    private int h;
    private float i;
    private boolean j = false;

    public d()
    {
    }

    public void a(int paramInt)
    {
      if (!this.j)
      {
        this.b = false;
        this.j = true;
        this.g = SystemClock.uptimeMillis();
        this.c = this.g;
        this.h = paramInt;
        DragSortListView.this.post(this);
      }
    }

    public void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        DragSortListView.this.removeCallbacks(this);
        this.j = false;
        return;
      }
      this.b = true;
    }

    public boolean a()
    {
      return this.j;
    }

    public int b()
    {
      if (this.j)
        return this.h;
      return -1;
    }

    public void run()
    {
      if (this.b)
      {
        this.j = false;
        return;
      }
      int k = DragSortListView.this.getFirstVisiblePosition();
      int m = DragSortListView.this.getLastVisiblePosition();
      int n = DragSortListView.this.getCount();
      int i1 = DragSortListView.this.getPaddingTop();
      int i2 = DragSortListView.this.getHeight() - i1 - DragSortListView.this.getPaddingBottom();
      int i3 = Math.min(DragSortListView.f(DragSortListView.this), DragSortListView.r(DragSortListView.this) + DragSortListView.d(DragSortListView.this));
      int i4 = Math.max(DragSortListView.f(DragSortListView.this), DragSortListView.r(DragSortListView.this) - DragSortListView.d(DragSortListView.this));
      if (this.h == 0)
      {
        View localView3 = DragSortListView.this.getChildAt(0);
        if (localView3 == null)
        {
          this.j = false;
          return;
        }
        if ((k == 0) && (localView3.getTop() == i1))
        {
          this.j = false;
          return;
        }
        this.i = DragSortListView.u(DragSortListView.this).a((DragSortListView.s(DragSortListView.this) - i4) / DragSortListView.t(DragSortListView.this), this.c);
        this.d = SystemClock.uptimeMillis();
        this.f = ((float)(this.d - this.c));
        this.e = Math.round(this.i * this.f);
        if (this.e < 0)
          break label471;
        this.e = Math.min(i2, this.e);
        m = k;
      }
      while (true)
      {
        View localView2 = DragSortListView.this.getChildAt(m - k);
        int i5 = localView2.getTop() + this.e;
        if ((m == 0) && (i5 > i1))
          i5 = i1;
        DragSortListView.b(DragSortListView.this, true);
        DragSortListView.this.setSelectionFromTop(m, i5 - i1);
        DragSortListView.this.layoutChildren();
        DragSortListView.this.invalidate();
        DragSortListView.b(DragSortListView.this, false);
        DragSortListView.c(DragSortListView.this, m, localView2, false);
        this.c = this.d;
        DragSortListView.this.post(this);
        return;
        View localView1 = DragSortListView.this.getChildAt(m - k);
        if (localView1 == null)
        {
          this.j = false;
          return;
        }
        if ((m == n - 1) && (localView1.getBottom() <= i2 + i1))
        {
          this.j = false;
          return;
        }
        this.i = (-DragSortListView.u(DragSortListView.this).a((i3 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this), this.c));
        break;
        label471: this.e = Math.max(-i2, this.e);
      }
    }
  }

  public static abstract interface e extends DragSortListView.b, DragSortListView.h, DragSortListView.m
  {
  }

  private class f
  {
    StringBuilder a = new StringBuilder();
    File b = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    private int d = 0;
    private int e = 0;
    private boolean f = false;

    public f()
    {
      if (!this.b.exists());
      try
      {
        this.b.createNewFile();
        return;
      }
      catch (IOException localIOException)
      {
      }
    }

    public void a()
    {
      this.a.append("<DSLVStates>\n");
      this.e = 0;
      this.f = true;
    }

    public void b()
    {
      if (!this.f);
      do
      {
        return;
        this.a.append("<DSLVState>\n");
        int i = DragSortListView.this.getChildCount();
        int j = DragSortListView.this.getFirstVisiblePosition();
        this.a.append("    <Positions>");
        for (int k = 0; k < i; k++)
          this.a.append(j + k).append(",");
        this.a.append("</Positions>\n");
        this.a.append("    <Tops>");
        for (int m = 0; m < i; m++)
          this.a.append(DragSortListView.this.getChildAt(m).getTop()).append(",");
        this.a.append("</Tops>\n");
        this.a.append("    <Bottoms>");
        for (int n = 0; n < i; n++)
          this.a.append(DragSortListView.this.getChildAt(n).getBottom()).append(",");
        this.a.append("</Bottoms>\n");
        this.a.append("    <FirstExpPos>").append(DragSortListView.l(DragSortListView.this)).append("</FirstExpPos>\n");
        this.a.append("    <FirstExpBlankHeight>").append(DragSortListView.c(DragSortListView.this, DragSortListView.l(DragSortListView.this)) - DragSortListView.d(DragSortListView.this, DragSortListView.l(DragSortListView.this))).append("</FirstExpBlankHeight>\n");
        this.a.append("    <SecondExpPos>").append(DragSortListView.m(DragSortListView.this)).append("</SecondExpPos>\n");
        this.a.append("    <SecondExpBlankHeight>").append(DragSortListView.c(DragSortListView.this, DragSortListView.m(DragSortListView.this)) - DragSortListView.d(DragSortListView.this, DragSortListView.m(DragSortListView.this))).append("</SecondExpBlankHeight>\n");
        this.a.append("    <SrcPos>").append(DragSortListView.h(DragSortListView.this)).append("</SrcPos>\n");
        this.a.append("    <SrcHeight>").append(DragSortListView.j(DragSortListView.this) + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
        this.a.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
        this.a.append("    <LastY>").append(DragSortListView.x(DragSortListView.this)).append("</LastY>\n");
        this.a.append("    <FloatY>").append(DragSortListView.r(DragSortListView.this)).append("</FloatY>\n");
        this.a.append("    <ShuffleEdges>");
        for (int i1 = 0; i1 < i; i1++)
          this.a.append(DragSortListView.a(DragSortListView.this, j + i1, DragSortListView.this.getChildAt(i1).getTop())).append(",");
        this.a.append("</ShuffleEdges>\n");
        this.a.append("</DSLVState>\n");
        this.d = (1 + this.d);
      }
      while (this.d <= 1000);
      c();
      this.d = 0;
    }

    public void c()
    {
      if (!this.f)
        return;
      while (true)
      {
        try
        {
          int i = this.e;
          bool = false;
          if (i == 0)
          {
            FileWriter localFileWriter = new FileWriter(this.b, bool);
            localFileWriter.write(this.a.toString());
            this.a.delete(0, this.a.length());
            localFileWriter.flush();
            localFileWriter.close();
            this.e = (1 + this.e);
            return;
          }
        }
        catch (IOException localIOException)
        {
          return;
        }
        boolean bool = true;
      }
    }

    public void d()
    {
      if (this.f)
      {
        this.a.append("</DSLVStates>\n");
        c();
        this.f = false;
      }
    }
  }

  private class g extends DragSortListView.n
  {
    private int d;
    private int e;
    private float f;
    private float g;

    public g(float paramInt, int arg3)
    {
      super(paramInt, i);
    }

    private int e()
    {
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.i(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.d - i);
      if (localView != null)
      {
        if (this.d == this.e)
          return localView.getTop();
        if (this.d < this.e)
          return localView.getTop() - j;
        return j + localView.getBottom() - DragSortListView.j(DragSortListView.this);
      }
      d();
      return -1;
    }

    public void a()
    {
      this.d = DragSortListView.g(DragSortListView.this);
      this.e = DragSortListView.h(DragSortListView.this);
      DragSortListView.b(DragSortListView.this, 2);
      this.f = (DragSortListView.e(DragSortListView.this).y - e());
      this.g = (DragSortListView.e(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
    }

    public void a(float paramFloat1, float paramFloat2)
    {
      int i = e();
      int j = DragSortListView.this.getPaddingLeft();
      float f1 = DragSortListView.e(DragSortListView.this).y - i;
      float f2 = DragSortListView.e(DragSortListView.this).x - j;
      float f3 = 1.0F - paramFloat2;
      if ((f3 < Math.abs(f1 / this.f)) || (f3 < Math.abs(f2 / this.g)))
      {
        DragSortListView.e(DragSortListView.this).y = (i + (int)(f3 * this.f));
        DragSortListView.e(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(f3 * this.g));
        DragSortListView.a(DragSortListView.this, true);
      }
    }

    public void b()
    {
      DragSortListView.k(DragSortListView.this);
    }
  }

  public static abstract interface h
  {
    public abstract void a_(int paramInt1, int paramInt2);
  }

  public static abstract interface i
  {
    public abstract View a(int paramInt);

    public abstract void a(View paramView);

    public abstract void a(View paramView, Point paramPoint1, Point paramPoint2);
  }

  private class j
  {
    private SparseIntArray b;
    private ArrayList<Integer> c;
    private int d;

    public j(int arg2)
    {
      int i;
      this.b = new SparseIntArray(i);
      this.c = new ArrayList(i);
      this.d = i;
    }

    public int a(int paramInt)
    {
      return this.b.get(paramInt, -1);
    }

    public void a()
    {
      this.b.clear();
      this.c.clear();
    }

    public void a(int paramInt1, int paramInt2)
    {
      int i = this.b.get(paramInt1, -1);
      if (i != paramInt2)
      {
        if (i != -1)
          break label77;
        if (this.b.size() == this.d)
          this.b.delete(((Integer)this.c.remove(0)).intValue());
      }
      while (true)
      {
        this.b.put(paramInt1, paramInt2);
        this.c.add(Integer.valueOf(paramInt1));
        return;
        label77: this.c.remove(Integer.valueOf(paramInt1));
      }
    }
  }

  private class k extends DragSortListView.n
  {
    private float d;
    private float e;

    public void a()
    {
      this.d = DragSortListView.c(this.a);
      this.e = DragSortListView.d(this.a);
    }

    public void a(float paramFloat1, float paramFloat2)
    {
      if (DragSortListView.b(this.a) != 4)
      {
        d();
        return;
      }
      DragSortListView.a(this.a, (int)(paramFloat2 * this.e + (1.0F - paramFloat2) * this.d));
      DragSortListView.e(this.a).y = (DragSortListView.f(this.a) - DragSortListView.c(this.a));
      DragSortListView.a(this.a, true);
    }
  }

  private class l extends DragSortListView.n
  {
    private float d;
    private float e;
    private float f;
    private int g = -1;
    private int h = -1;
    private int i;
    private int j;
    private int k;

    public l(float paramInt, int arg3)
    {
      super(paramInt, m);
    }

    public void a()
    {
      int m = -1;
      this.g = m;
      this.h = m;
      this.i = DragSortListView.l(DragSortListView.this);
      this.j = DragSortListView.m(DragSortListView.this);
      this.k = DragSortListView.h(DragSortListView.this);
      DragSortListView.b(DragSortListView.this, 1);
      this.d = DragSortListView.e(DragSortListView.this).x;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f1 = 2.0F * DragSortListView.this.getWidth();
        if (DragSortListView.o(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.d < 0.0F)
            DragSortListView.a(localDragSortListView, f1 * m);
        }
        float f2;
        do
        {
          return;
          m = 1;
          break;
          f2 = f1 * 2.0F;
          if ((DragSortListView.o(DragSortListView.this) < 0.0F) && (DragSortListView.o(DragSortListView.this) > -f2))
          {
            DragSortListView.a(DragSortListView.this, -f2);
            return;
          }
        }
        while ((DragSortListView.o(DragSortListView.this) <= 0.0F) || (DragSortListView.o(DragSortListView.this) >= f2));
        DragSortListView.a(DragSortListView.this, f2);
        return;
      }
      DragSortListView.p(DragSortListView.this);
    }

    public void a(float paramFloat1, float paramFloat2)
    {
      float f1 = 1.0F - paramFloat2;
      int m = DragSortListView.this.getFirstVisiblePosition();
      View localView1 = DragSortListView.this.getChildAt(this.i - m);
      float f2;
      if (DragSortListView.n(DragSortListView.this))
      {
        f2 = (float)(SystemClock.uptimeMillis() - this.b) / 1000.0F;
        if (f2 != 0.0F);
      }
      View localView2;
      do
      {
        do
        {
          return;
          float f3 = f2 * DragSortListView.o(DragSortListView.this);
          int i2 = DragSortListView.this.getWidth();
          DragSortListView localDragSortListView = DragSortListView.this;
          float f4 = DragSortListView.o(DragSortListView.this);
          if (DragSortListView.o(DragSortListView.this) > 0.0F);
          for (int i3 = 1; ; i3 = -1)
          {
            DragSortListView.a(localDragSortListView, f4 + f2 * i3 * i2);
            this.d = (f3 + this.d);
            DragSortListView.e(DragSortListView.this).x = ((int)this.d);
            if ((this.d >= i2) || (this.d <= -i2))
              break;
            this.b = SystemClock.uptimeMillis();
            DragSortListView.a(DragSortListView.this, true);
            return;
          }
          if (localView1 != null)
          {
            if (this.g == -1)
            {
              this.g = DragSortListView.b(DragSortListView.this, this.i, localView1, false);
              this.e = (localView1.getHeight() - this.g);
            }
            int i1 = Math.max((int)(f1 * this.e), 1);
            ViewGroup.LayoutParams localLayoutParams2 = localView1.getLayoutParams();
            localLayoutParams2.height = (i1 + this.g);
            localView1.setLayoutParams(localLayoutParams2);
          }
        }
        while (this.j == this.i);
        localView2 = DragSortListView.this.getChildAt(this.j - m);
      }
      while (localView2 == null);
      if (this.h == -1)
      {
        this.h = DragSortListView.b(DragSortListView.this, this.j, localView2, false);
        this.f = (localView2.getHeight() - this.h);
      }
      int n = Math.max((int)(f1 * this.f), 1);
      ViewGroup.LayoutParams localLayoutParams1 = localView2.getLayoutParams();
      localLayoutParams1.height = (n + this.h);
      localView2.setLayoutParams(localLayoutParams1);
    }

    public void b()
    {
      DragSortListView.q(DragSortListView.this);
    }
  }

  public static abstract interface m
  {
    public abstract void a(int paramInt);
  }

  private class n
    implements Runnable
  {
    private float a;
    protected long b;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private boolean i;

    public n(float paramInt, int arg3)
    {
      this.d = paramInt;
      int j;
      this.a = j;
      float f1 = 1.0F / (2.0F * this.d * (1.0F - this.d));
      this.h = f1;
      this.e = f1;
      this.f = (this.d / (2.0F * (this.d - 1.0F)));
      this.g = (1.0F / (1.0F - this.d));
    }

    public float a(float paramFloat)
    {
      if (paramFloat < this.d)
        return paramFloat * (paramFloat * this.e);
      if (paramFloat < 1.0F - this.d)
        return this.f + paramFloat * this.g;
      return 1.0F - this.h * (paramFloat - 1.0F) * (paramFloat - 1.0F);
    }

    public void a()
    {
    }

    public void a(float paramFloat1, float paramFloat2)
    {
    }

    public void b()
    {
    }

    public void c()
    {
      this.b = SystemClock.uptimeMillis();
      this.i = false;
      a();
      DragSortListView.this.post(this);
    }

    public void d()
    {
      this.i = true;
    }

    public void run()
    {
      if (this.i)
        return;
      float f1 = (float)(SystemClock.uptimeMillis() - this.b) / this.a;
      if (f1 >= 1.0F)
      {
        a(1.0F, 1.0F);
        b();
        return;
      }
      a(f1, a(f1));
      DragSortListView.this.post(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.dslv.DragSortListView
 * JD-Core Version:    0.6.2
 */