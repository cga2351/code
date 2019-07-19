package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.constraint.a.a.c.b;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.support.constraint.a.a.d.a;
import android.support.constraint.a.a.e;
import android.support.constraint.a.a.j;
import android.support.constraint.a.a.k;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup
{
  SparseArray<View> a = new SparseArray();
  e b = new e();
  int c = -1;
  int d = -1;
  int e = 0;
  int f = 0;
  private ArrayList<a> g = new ArrayList(4);
  private final ArrayList<d> h = new ArrayList(100);
  private int i = 0;
  private int j = 0;
  private int k = 2147483647;
  private int l = 2147483647;
  private boolean m = true;
  private int n = 3;
  private b o = null;
  private int p = -1;
  private HashMap<String, Integer> q = new HashMap();
  private int r = -1;
  private int s = -1;
  private android.support.constraint.a.f t;

  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    b(null);
  }

  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramAttributeSet);
  }

  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramAttributeSet);
  }

  private void a(int paramInt1, int paramInt2)
  {
    int i1 = getPaddingTop() + getPaddingBottom();
    int i2 = getPaddingLeft() + getPaddingRight();
    int i3 = getChildCount();
    int i4 = 0;
    View localView;
    a locala;
    d locald;
    int i5;
    int i6;
    int i7;
    label189: int i15;
    int i14;
    label216: int i18;
    int i11;
    label233: boolean bool1;
    label277: boolean bool2;
    label294: int i9;
    int i8;
    int i10;
    if (i4 < i3)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8);
      do
      {
        i4++;
        break;
        locala = (a)localView.getLayoutParams();
        locald = locala.al;
      }
      while ((locala.Y) || (locala.Z));
      locald.e(localView.getVisibility());
      i5 = locala.width;
      i6 = locala.height;
      if ((locala.V) || (locala.W) || ((!locala.V) && (locala.I == 1)) || (locala.width == -1) || ((!locala.W) && ((locala.J == 1) || (locala.height == -1))))
      {
        i7 = 1;
        if (i7 == 0)
          break label522;
        if (i5 != 0)
          break label402;
        int i21 = getChildMeasureSpec(paramInt1, i2, -2);
        i15 = 1;
        i14 = i21;
        if (i6 != 0)
          break label453;
        i18 = getChildMeasureSpec(paramInt2, i1, -2);
        i11 = 1;
        localView.measure(i14, i18);
        if (this.t != null)
        {
          android.support.constraint.a.f localf = this.t;
          localf.a = (1L + localf.a);
        }
        if (i5 != -2)
          break label503;
        bool1 = true;
        locald.b(bool1);
        if (i6 != -2)
          break label509;
        bool2 = true;
        locald.c(bool2);
        i9 = localView.getMeasuredWidth();
        int i19 = localView.getMeasuredHeight();
        int i20 = i15;
        i8 = i19;
        i10 = i20;
      }
    }
    while (true)
    {
      locald.h(i9);
      locald.i(i8);
      if (i10 != 0)
        locald.l(i9);
      if (i11 != 0)
        locald.m(i8);
      if (!locala.X)
        break;
      int i12 = localView.getBaseline();
      if (i12 == -1)
        break;
      locald.n(i12);
      break;
      i7 = 0;
      break label189;
      label402: if (i5 == -1)
      {
        i14 = getChildMeasureSpec(paramInt1, i2, -1);
        i15 = 0;
        break label216;
      }
      int i13 = 0;
      if (i5 == -2)
        i13 = 1;
      i14 = getChildMeasureSpec(paramInt1, i2, i5);
      i15 = i13;
      break label216;
      label453: if (i6 == -1)
      {
        i18 = getChildMeasureSpec(paramInt2, i1, -1);
        i11 = 0;
        break label233;
      }
      if (i6 == -2);
      for (int i16 = 1; ; i16 = 0)
      {
        int i17 = getChildMeasureSpec(paramInt2, i1, i6);
        i11 = i16;
        i18 = i17;
        break;
        label503: bool1 = false;
        break label277;
        label509: bool2 = false;
        break label294;
        return;
      }
      label522: i8 = i6;
      i9 = i5;
      i10 = 0;
      i11 = 0;
    }
  }

  private final d b(int paramInt)
  {
    if (paramInt == 0)
      return this.b;
    View localView = (View)this.a.get(paramInt);
    if (localView == this)
      return this.b;
    if (localView == null)
      return null;
    return ((a)localView.getLayoutParams()).al;
  }

  private void b()
  {
    int i1 = getChildCount();
    for (int i2 = 0; ; i2++)
    {
      int i3 = 0;
      if (i2 < i1)
      {
        if (getChildAt(i2).isLayoutRequested())
          i3 = 1;
      }
      else
      {
        if (i3 != 0)
        {
          this.h.clear();
          c();
        }
        return;
      }
    }
  }

  private void b(int paramInt1, int paramInt2)
  {
    int i1 = getPaddingTop() + getPaddingBottom();
    int i2 = getPaddingLeft() + getPaddingRight();
    int i3 = getChildCount();
    int i4 = 0;
    if (i4 < i3)
    {
      View localView2 = getChildAt(i4);
      if (localView2.getVisibility() == 8);
      a locala2;
      d locald2;
      int i32;
      int i33;
      while (true)
      {
        i4++;
        break;
        locala2 = (a)localView2.getLayoutParams();
        locald2 = locala2.al;
        if ((!locala2.Y) && (!locala2.Z))
        {
          locald2.e(localView2.getVisibility());
          i32 = locala2.width;
          i33 = locala2.height;
          if ((i32 != 0) && (i33 != 0))
            break label147;
          locald2.h().e();
          locald2.i().e();
        }
      }
      label147: int i34 = 0;
      if (i32 == -2)
        i34 = 1;
      int i35 = getChildMeasureSpec(paramInt1, i2, i32);
      int i36 = 0;
      if (i33 == -2)
        i36 = 1;
      localView2.measure(i35, getChildMeasureSpec(paramInt2, i1, i33));
      if (this.t != null)
      {
        android.support.constraint.a.f localf2 = this.t;
        localf2.a = (1L + localf2.a);
      }
      boolean bool3;
      if (i32 == -2)
      {
        bool3 = true;
        label232: locald2.b(bool3);
        if (i33 != -2)
          break label381;
      }
      label381: for (boolean bool4 = true; ; bool4 = false)
      {
        locald2.c(bool4);
        int i37 = localView2.getMeasuredWidth();
        int i38 = localView2.getMeasuredHeight();
        locald2.h(i37);
        locald2.i(i38);
        if (i34 != 0)
          locald2.l(i37);
        if (i36 != 0)
          locald2.m(i38);
        if (locala2.X)
        {
          int i39 = localView2.getBaseline();
          if (i39 != -1)
            locald2.n(i39);
        }
        if ((!locala2.V) || (!locala2.W))
          break;
        locald2.h().a(i37);
        locald2.i().a(i38);
        break;
        bool3 = false;
        break label232;
      }
    }
    this.b.Q();
    int i5 = 0;
    d locald1;
    int i6;
    int i7;
    label552: label609: int i10;
    int i11;
    label648: int i12;
    label664: int i15;
    int i16;
    int i17;
    int i18;
    label778: int i22;
    int i21;
    int i23;
    label858: boolean bool1;
    label902: boolean bool2;
    if (i5 < i3)
    {
      View localView1 = getChildAt(i5);
      if (localView1.getVisibility() == 8);
      a locala1;
      do
      {
        do
        {
          i5++;
          break;
          locala1 = (a)localView1.getLayoutParams();
          locald1 = locala1.al;
        }
        while ((locala1.Y) || (locala1.Z));
        locald1.e(localView1.getVisibility());
        i6 = locala1.width;
        i7 = locala1.height;
      }
      while ((i6 != 0) && (i7 != 0));
      j localj1 = locald1.a(c.c.b).a();
      j localj2 = locald1.a(c.c.d).a();
      int i8;
      j localj3;
      j localj4;
      int i9;
      if ((locald1.a(c.c.b).g() != null) && (locald1.a(c.c.d).g() != null))
      {
        i8 = 1;
        localj3 = locald1.a(c.c.c).a();
        localj4 = locald1.a(c.c.e).a();
        if ((locald1.a(c.c.c).g() == null) || (locald1.a(c.c.e).g() == null))
          break label1045;
        i9 = 1;
        if ((i6 == 0) && (i7 == 0) && (i8 != 0) && (i9 != 0))
          break label1049;
        i10 = 0;
        if (this.b.I() == d.a.b)
          break label1051;
        i11 = 1;
        if (this.b.J() == d.a.b)
          break label1057;
        i12 = 1;
        if (i11 == 0)
          locald1.h().e();
        if (i12 == 0)
          locald1.i().e();
        if (i6 != 0)
          break label1090;
        if ((i11 == 0) || (!locald1.d()) || (i8 == 0) || (!localj1.g()) || (!localj2.g()))
          break label1063;
        int i30 = (int)(localj2.d() - localj1.d());
        locald1.h().a(i30);
        int i31 = getChildMeasureSpec(paramInt1, i2, i30);
        i15 = i11;
        i16 = 0;
        i17 = i30;
        i18 = i31;
      }
      while (true)
        if (i7 == 0)
          if ((i12 != 0) && (locald1.e()) && (i9 != 0) && (localj3.g()) && (localj4.g()))
          {
            int i27 = (int)(localj4.d() - localj3.d());
            locald1.i().a(i27);
            i22 = getChildMeasureSpec(paramInt2, i1, i27);
            i21 = i27;
            i23 = i12;
            localView1.measure(i18, i22);
            if (this.t != null)
            {
              android.support.constraint.a.f localf1 = this.t;
              localf1.a = (1L + localf1.a);
            }
            if (i17 != -2)
              break label1250;
            bool1 = true;
            locald1.b(bool1);
            if (i21 != -2)
              break label1256;
            bool2 = true;
            label919: locald1.c(bool2);
            int i24 = localView1.getMeasuredWidth();
            int i25 = localView1.getMeasuredHeight();
            locald1.h(i24);
            locald1.i(i25);
            if (i16 != 0)
              locald1.l(i24);
            if (i10 != 0)
              locald1.m(i25);
            if (i15 == 0)
              break label1262;
            locald1.h().a(i24);
            label993: if (i23 == 0)
              break label1273;
            locald1.i().a(i25);
            label1008: if (!locala1.X)
              break label1282;
            int i26 = localView1.getBaseline();
            if (i26 == -1)
              break;
            locald1.n(i26);
            break;
            i8 = 0;
            break label552;
            label1045: i9 = 0;
            break label609;
            label1049: break;
            label1051: i11 = 0;
            break label648;
            label1057: i12 = 0;
            break label664;
            label1063: int i29 = getChildMeasureSpec(paramInt1, i2, -2);
            i16 = 1;
            i17 = i6;
            i18 = i29;
            i15 = 0;
            continue;
            label1090: if (i6 == -1)
            {
              int i28 = getChildMeasureSpec(paramInt1, i2, -1);
              i15 = i11;
              i17 = i6;
              i18 = i28;
              i16 = 0;
              continue;
            }
            if (i6 != -2)
              break label1291;
          }
    }
    label1282: label1291: for (int i13 = 1; ; i13 = 0)
    {
      int i14 = getChildMeasureSpec(paramInt1, i2, i6);
      i15 = i11;
      i16 = i13;
      i17 = i6;
      i18 = i14;
      break label778;
      i22 = getChildMeasureSpec(paramInt2, i1, -2);
      i10 = 1;
      i21 = i7;
      i23 = 0;
      break label858;
      if (i7 == -1)
      {
        i22 = getChildMeasureSpec(paramInt2, i1, -1);
        i23 = i12;
        i21 = i7;
        i10 = 0;
        break label858;
      }
      if (i7 == -2);
      for (int i19 = 1; ; i19 = 0)
      {
        int i20 = getChildMeasureSpec(paramInt2, i1, i7);
        i10 = i19;
        i21 = i7;
        i22 = i20;
        i23 = i12;
        break label858;
        label1250: bool1 = false;
        break label902;
        label1256: bool2 = false;
        break label919;
        label1262: locald1.h().c();
        break label993;
        label1273: locald1.i().c();
        break label1008;
        break;
        return;
      }
    }
  }

  private void b(AttributeSet paramAttributeSet)
  {
    this.b.a(this);
    this.a.put(getId(), this);
    this.o = null;
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i1 = localTypedArray.getIndexCount();
      int i2 = 0;
      if (i2 < i1)
      {
        int i3 = localTypedArray.getIndex(i2);
        if (i3 == R.styleable.ConstraintLayout_Layout_android_minWidth)
          this.i = localTypedArray.getDimensionPixelOffset(i3, this.i);
        while (true)
        {
          i2++;
          break;
          if (i3 == R.styleable.ConstraintLayout_Layout_android_minHeight)
          {
            this.j = localTypedArray.getDimensionPixelOffset(i3, this.j);
          }
          else if (i3 == R.styleable.ConstraintLayout_Layout_android_maxWidth)
          {
            this.k = localTypedArray.getDimensionPixelOffset(i3, this.k);
          }
          else if (i3 == R.styleable.ConstraintLayout_Layout_android_maxHeight)
          {
            this.l = localTypedArray.getDimensionPixelOffset(i3, this.l);
          }
          else if (i3 == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel)
          {
            this.n = localTypedArray.getInt(i3, this.n);
          }
          else if (i3 == R.styleable.ConstraintLayout_Layout_constraintSet)
          {
            int i4 = localTypedArray.getResourceId(i3, 0);
            try
            {
              this.o = new b();
              this.o.a(getContext(), i4);
              this.p = i4;
            }
            catch (Resources.NotFoundException localNotFoundException)
            {
              while (true)
                this.o = null;
            }
          }
        }
      }
      localTypedArray.recycle();
    }
    this.b.a(this.n);
  }

  private void c()
  {
    boolean bool = isInEditMode();
    int i1 = getChildCount();
    int i23;
    if (bool)
      i23 = 0;
    while (true)
    {
      View localView5;
      if (i23 < i1)
        localView5 = getChildAt(i23);
      try
      {
        String str3 = getResources().getResourceName(localView5.getId());
        a(0, str3, Integer.valueOf(localView5.getId()));
        int i24 = str3.indexOf('/');
        if (i24 != -1)
          str3 = str3.substring(i24 + 1);
        b(localView5.getId()).a(str3);
        i23++;
        continue;
        int i2 = 0;
        if (i2 < i1)
        {
          d locald12 = a(getChildAt(i2));
          if (locald12 == null);
          while (true)
          {
            i2++;
            break;
            locald12.f();
          }
        }
        if (this.p != -1)
          for (int i22 = 0; i22 < i1; i22++)
          {
            View localView4 = getChildAt(i22);
            if ((localView4.getId() == this.p) && ((localView4 instanceof c)))
              this.o = ((c)localView4).getConstraintSet();
          }
        if (this.o != null)
          this.o.a(this);
        this.b.V();
        int i3 = this.g.size();
        if (i3 > 0)
          for (int i21 = 0; i21 < i3; i21++)
            ((a)this.g.get(i21)).a(this);
        for (int i4 = 0; i4 < i1; i4++)
        {
          View localView3 = getChildAt(i4);
          if ((localView3 instanceof Placeholder))
            ((Placeholder)localView3).a(this);
        }
        int i5 = 0;
        if (i5 < i1)
        {
          View localView1 = getChildAt(i5);
          d locald1 = a(localView1);
          if (locald1 == null);
          a locala1;
          label602: label634: 
          do
            while (true)
            {
              i5++;
              break;
              locala1 = (a)localView1.getLayoutParams();
              locala1.a();
              if (locala1.am)
                locala1.am = false;
              android.support.constraint.a.a.f localf;
              int i19;
              int i20;
              while (true)
              {
                locald1.e(localView1.getVisibility());
                if (locala1.aa)
                  locald1.e(8);
                locald1.a(localView1);
                this.b.c(locald1);
                if ((!locala1.W) || (!locala1.V))
                  this.h.add(locald1);
                if (!locala1.Y)
                  break label634;
                localf = (android.support.constraint.a.a.f)locald1;
                i19 = locala1.ai;
                i20 = locala1.aj;
                float f3 = locala1.ak;
                if (Build.VERSION.SDK_INT < 17)
                {
                  i19 = locala1.a;
                  i20 = locala1.b;
                  f3 = locala1.c;
                }
                if (f3 == -1.0F)
                  break label602;
                localf.e(f3);
                break;
                if (bool)
                  try
                  {
                    String str1 = getResources().getResourceName(localView1.getId());
                    a(0, str1, Integer.valueOf(localView1.getId()));
                    String str2 = str1.substring(3 + str1.indexOf("id/"));
                    b(localView1.getId()).a(str2);
                  }
                  catch (Resources.NotFoundException localNotFoundException1)
                  {
                  }
              }
              if (i19 != -1)
                localf.q(i19);
              else if (i20 != -1)
                localf.r(i20);
            }
          while ((locala1.d == -1) && (locala1.e == -1) && (locala1.f == -1) && (locala1.g == -1) && (locala1.q == -1) && (locala1.p == -1) && (locala1.r == -1) && (locala1.s == -1) && (locala1.h == -1) && (locala1.i == -1) && (locala1.j == -1) && (locala1.k == -1) && (locala1.l == -1) && (locala1.Q == -1) && (locala1.R == -1) && (locala1.m == -1) && (locala1.width != -1) && (locala1.height != -1));
          i6 = locala1.ab;
          i7 = locala1.ac;
          i8 = locala1.ad;
          i9 = locala1.ae;
          int i10 = locala1.af;
          i11 = locala1.ag;
          f1 = locala1.ah;
          if (Build.VERSION.SDK_INT < 17)
          {
            i6 = locala1.d;
            i7 = locala1.e;
            i8 = locala1.f;
            i9 = locala1.g;
            i10 = locala1.t;
            i11 = locala1.v;
            f1 = locala1.z;
            if ((i6 == -1) && (i7 == -1))
            {
              if (locala1.q != -1)
                i6 = locala1.q;
            }
            else
            {
              label930: if ((i8 != -1) || (i9 != -1))
                break label1977;
              if (locala1.r == -1)
                break label1305;
              int i18 = locala1.r;
              f2 = f1;
              i12 = i18;
              i13 = i7;
              i14 = i11;
              i15 = i6;
              i16 = i9;
              label982: if (locala1.m == -1)
                break label1348;
              d locald11 = b(locala1.m);
              if (locald11 != null)
                locald1.a(locald11, locala1.o, locala1.n);
              if ((bool) && ((locala1.Q != -1) || (locala1.R != -1)))
                locald1.a(locala1.Q, locala1.R);
              if (locala1.V)
                break label1912;
              if (locala1.width != -1)
                break label1895;
              locald1.a(d.a.d);
              locald1.a(c.c.b).d = locala1.leftMargin;
              locald1.a(c.c.d).d = locala1.rightMargin;
              label1118: if (locala1.W)
                break label1950;
              if (locala1.height != -1)
                break label1933;
              locald1.b(d.a.d);
              locald1.a(c.c.c).d = locala1.topMargin;
              locald1.a(c.c.e).d = locala1.bottomMargin;
            }
            while (true)
            {
              if (locala1.B != null)
                locald1.b(locala1.B);
              locald1.c(locala1.E);
              locald1.d(locala1.F);
              locald1.o(locala1.G);
              locald1.p(locala1.H);
              locald1.a(locala1.I, locala1.K, locala1.M, locala1.O);
              locald1.b(locala1.J, locala1.L, locala1.N, locala1.P);
              break;
              if (locala1.p == -1)
                break label930;
              i7 = locala1.p;
              break label930;
              label1305: if (locala1.s == -1)
                break label1977;
              int i17 = locala1.s;
              f2 = f1;
              i12 = i8;
              i13 = i7;
              i14 = i11;
              i15 = i6;
              i16 = i17;
              break label982;
              label1348: if (i15 != -1)
              {
                d locald10 = b(i15);
                if (locald10 != null)
                  locald1.a(c.c.b, locald10, c.c.b, locala1.leftMargin, i10);
                label1387: if (i12 == -1)
                  break label1751;
                d locald9 = b(i12);
                if (locald9 != null)
                  locald1.a(c.c.d, locald9, c.c.b, locala1.rightMargin, i14);
                if (locala1.h == -1)
                  break label1793;
                d locald8 = b(locala1.h);
                if (locald8 != null)
                  locald1.a(c.c.c, locald8, c.c.c, locala1.topMargin, locala1.u);
                if (locala1.j == -1)
                  break label1844;
                d locald7 = b(locala1.j);
                if (locald7 != null)
                  locald1.a(c.c.e, locald7, c.c.c, locala1.bottomMargin, locala1.w);
              }
              while (true)
              {
                label1426: label1474: if (locala1.l != -1)
                {
                  View localView2 = (View)this.a.get(locala1.l);
                  d locald6 = b(locala1.l);
                  if ((locald6 != null) && (localView2 != null) && ((localView2.getLayoutParams() instanceof a)))
                  {
                    a locala2 = (a)localView2.getLayoutParams();
                    locala1.X = true;
                    locala2.X = true;
                    locald1.a(c.c.f).a(locald6.a(c.c.f), 0, -1, c.b.b, 0, true);
                    locald1.a(c.c.c).i();
                    locald1.a(c.c.e).i();
                  }
                }
                if ((f2 >= 0.0F) && (f2 != 0.5F))
                  locald1.a(f2);
                if ((locala1.A < 0.0F) || (locala1.A == 0.5F))
                  break;
                locald1.b(locala1.A);
                break;
                if (i13 == -1)
                  break label1387;
                d locald2 = b(i13);
                if (locald2 == null)
                  break label1387;
                locald1.a(c.c.b, locald2, c.c.d, locala1.leftMargin, i10);
                break label1387;
                label1751: if (i16 == -1)
                  break label1426;
                d locald3 = b(i16);
                if (locald3 == null)
                  break label1426;
                locald1.a(c.c.d, locald3, c.c.d, locala1.rightMargin, i14);
                break label1426;
                label1793: if (locala1.i == -1)
                  break label1474;
                d locald4 = b(locala1.i);
                if (locald4 == null)
                  break label1474;
                locald1.a(c.c.c, locald4, c.c.e, locala1.topMargin, locala1.u);
                break label1474;
                label1844: if (locala1.k != -1)
                {
                  d locald5 = b(locala1.k);
                  if (locald5 != null)
                    locald1.a(c.c.e, locald5, c.c.e, locala1.bottomMargin, locala1.w);
                }
              }
              label1895: locald1.a(d.a.c);
              locald1.h(0);
              break label1118;
              label1912: locald1.a(d.a.a);
              locald1.h(locala1.width);
              break label1118;
              label1933: locald1.b(d.a.c);
              locald1.i(0);
              continue;
              label1950: locald1.b(d.a.a);
              locald1.i(locala1.height);
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Resources.NotFoundException localNotFoundException2)
      {
        while (true)
        {
          int i6;
          int i7;
          int i8;
          int i9;
          int i11;
          float f1;
          continue;
          label1977: float f2 = f1;
          int i12 = i8;
          int i13 = i7;
          int i14 = i11;
          int i15 = i6;
          int i16 = i9;
        }
      }
    }
  }

  private void c(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i5 = getPaddingTop() + getPaddingBottom();
    int i6 = getPaddingLeft() + getPaddingRight();
    d.a locala1 = d.a.a;
    d.a locala2 = d.a.a;
    getLayoutParams();
    switch (i1)
    {
    default:
      i2 = 0;
      switch (i3)
      {
      default:
        i4 = 0;
      case -2147483648:
      case 0:
      case 1073741824:
      }
      break;
    case -2147483648:
    case 0:
    case 1073741824:
    }
    while (true)
    {
      this.b.j(0);
      this.b.k(0);
      this.b.a(locala1);
      this.b.h(i2);
      this.b.b(locala2);
      this.b.i(i4);
      this.b.j(this.i - getPaddingLeft() - getPaddingRight());
      this.b.k(this.j - getPaddingTop() - getPaddingBottom());
      return;
      locala1 = d.a.b;
      break;
      locala1 = d.a.b;
      i2 = 0;
      break;
      i2 = Math.min(this.k, i2) - i6;
      break;
      locala2 = d.a.b;
      continue;
      locala2 = d.a.b;
      i4 = 0;
      continue;
      i4 = Math.min(this.l, i4) - i5;
    }
  }

  private void d()
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if ((localView instanceof Placeholder))
        ((Placeholder)localView).b(this);
    }
    int i3 = this.g.size();
    int i4 = 0;
    if (i3 > 0)
      while (i4 < i3)
      {
        ((a)this.g.get(i4)).c(this);
        i4++;
      }
  }

  public a a(AttributeSet paramAttributeSet)
  {
    return new a(getContext(), paramAttributeSet);
  }

  public final d a(View paramView)
  {
    if (paramView == this)
      return this.b;
    if (paramView == null)
      return null;
    return ((a)paramView.getLayoutParams()).al;
  }

  public View a(int paramInt)
  {
    return (View)this.a.get(paramInt);
  }

  public Object a(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof String)))
    {
      String str = (String)paramObject;
      if ((this.q != null) && (this.q.containsKey(str)))
        return this.q.get(str);
    }
    return null;
  }

  public void a(int paramInt, Object paramObject1, Object paramObject2)
  {
    if ((paramInt == 0) && ((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (this.q == null)
        this.q = new HashMap();
      String str = (String)paramObject1;
      int i1 = str.indexOf("/");
      if (i1 != -1)
        str = str.substring(i1 + 1);
      int i2 = ((Integer)paramObject2).intValue();
      this.q.put(str, Integer.valueOf(i2));
    }
  }

  protected void a(String paramString)
  {
    this.b.O();
    if (this.t != null)
    {
      android.support.constraint.a.f localf = this.t;
      localf.c = (1L + localf.c);
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14)
      onViewAdded(paramView);
  }

  protected a ag_()
  {
    return new a(-2, -2);
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof a;
  }

  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (isInEditMode())
    {
      int i1 = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      int i2 = 0;
      if (i2 < i1)
      {
        View localView = getChildAt(i2);
        if (localView.getVisibility() == 8);
        while (true)
        {
          i2++;
          break;
          Object localObject = localView.getTag();
          if ((localObject != null) && ((localObject instanceof String)))
          {
            String[] arrayOfString = ((String)localObject).split(",");
            if (arrayOfString.length == 4)
            {
              int i3 = Integer.parseInt(arrayOfString[0]);
              int i4 = Integer.parseInt(arrayOfString[1]);
              int i5 = Integer.parseInt(arrayOfString[2]);
              int i6 = Integer.parseInt(arrayOfString[3]);
              int i7 = (int)(f1 * (i3 / 1080.0F));
              int i8 = (int)(f2 * (i4 / 1920.0F));
              int i9 = (int)(f1 * (i5 / 1080.0F));
              int i10 = (int)(f2 * (i6 / 1920.0F));
              Paint localPaint = new Paint();
              localPaint.setColor(-65536);
              paramCanvas.drawLine(i7, i8, i7 + i9, i8, localPaint);
              paramCanvas.drawLine(i7 + i9, i8, i7 + i9, i8 + i10, localPaint);
              paramCanvas.drawLine(i7 + i9, i8 + i10, i7, i8 + i10, localPaint);
              paramCanvas.drawLine(i7, i8 + i10, i7, i8, localPaint);
              localPaint.setColor(-16711936);
              paramCanvas.drawLine(i7, i8, i7 + i9, i8 + i10, localPaint);
              paramCanvas.drawLine(i7, i8 + i10, i7 + i9, i8, localPaint);
            }
          }
        }
      }
    }
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new a(paramLayoutParams);
  }

  public int getMaxHeight()
  {
    return this.l;
  }

  public int getMaxWidth()
  {
    return this.k;
  }

  public int getMinHeight()
  {
    return this.j;
  }

  public int getMinWidth()
  {
    return this.i;
  }

  public int getOptimizationLevel()
  {
    return this.b.K();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    boolean bool = isInEditMode();
    int i2 = 0;
    if (i2 < i1)
    {
      View localView1 = getChildAt(i2);
      a locala = (a)localView1.getLayoutParams();
      d locald = locala.al;
      if ((localView1.getVisibility() == 8) && (!locala.Y) && (!locala.Z) && (!bool));
      while (true)
      {
        i2++;
        break;
        if (!locala.aa)
        {
          int i5 = locald.s();
          int i6 = locald.t();
          int i7 = i5 + locald.o();
          int i8 = i6 + locald.q();
          localView1.layout(i5, i6, i7, i8);
          if ((localView1 instanceof Placeholder))
          {
            View localView2 = ((Placeholder)localView1).getContent();
            if (localView2 != null)
            {
              localView2.setVisibility(0);
              localView2.layout(i5, i6, i7, i8);
            }
          }
        }
      }
    }
    int i3 = this.g.size();
    if (i3 > 0)
      for (int i4 = 0; i4 < i3; i4++)
        ((a)this.g.get(i4)).b(this);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    System.currentTimeMillis();
    int i1 = 0;
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i6;
    boolean bool;
    label304: int i9;
    int i10;
    int i11;
    label366: int i12;
    label395: int i13;
    int i14;
    int i15;
    int i24;
    int i25;
    label467: int i26;
    label483: int i27;
    int i28;
    int i29;
    label518: d locald2;
    View localView2;
    int i35;
    int i36;
    if (((this.r == -1) || (this.s == -1)) || (((i2 != 1073741824) || (i4 != 1073741824) || (i3 != this.r) || (i5 != this.s)) || ((i2 == this.e) && (i4 == this.f))))
    {
      i6 = 1;
      if (((i6 == 0) || (i3 != this.c) || (i5 != this.d)) || (((i6 == 0) || (i2 != -2147483648) || (i4 != 1073741824) || (i3 < this.r) || (i5 != this.s)) || ((i6 != 0) && (i2 == 1073741824) && (i4 == -2147483648) && (i3 == this.r) && (i5 >= this.s))));
      this.e = i2;
      this.f = i4;
      this.c = i3;
      this.d = i5;
      int i7 = getPaddingLeft();
      int i8 = getPaddingTop();
      this.b.f(i7);
      this.b.g(i8);
      this.b.c(this.k);
      this.b.d(this.l);
      if (Build.VERSION.SDK_INT >= 17)
      {
        e locale = this.b;
        if (getLayoutDirection() != 1)
          break label582;
        bool = true;
        locale.a(bool);
      }
      c(paramInt1, paramInt2);
      i9 = this.b.o();
      i10 = this.b.q();
      if (this.m)
      {
        this.m = false;
        b();
      }
      if ((0x8 & this.n) != 8)
        break label588;
      i11 = 1;
      if (i11 == 0)
        break label594;
      this.b.P();
      this.b.e(i9, i10);
      b(paramInt1, paramInt2);
      d();
      if (getChildCount() > 0)
        a("First pass");
      i12 = this.h.size();
      i13 = i8 + getPaddingBottom();
      i14 = i7 + getPaddingRight();
      i15 = 0;
      if (i12 <= 0)
        break label1339;
      i24 = 0;
      if (this.b.I() != d.a.b)
        break label603;
      i25 = 1;
      if (this.b.J() != d.a.b)
        break label609;
      i26 = 1;
      i27 = Math.max(this.b.o(), this.i);
      i28 = Math.max(this.b.q(), this.j);
      i29 = 0;
      if (i29 >= i12)
        break label1087;
      locald2 = (d)this.h.get(i29);
      localView2 = (View)locald2.D();
      if (localView2 != null)
        break label615;
      i35 = i15;
      i36 = i1;
    }
    while (true)
    {
      i29++;
      i15 = i35;
      i1 = i36;
      break label518;
      i6 = 0;
      break;
      label582: bool = false;
      break label304;
      label588: i11 = 0;
      break label366;
      label594: a(paramInt1, paramInt2);
      break label395;
      label603: i25 = 0;
      break label467;
      label609: i26 = 0;
      break label483;
      label615: a locala = (a)localView2.getLayoutParams();
      if (!locala.Z)
      {
        if (locala.Y)
        {
          i35 = i15;
          i36 = i1;
        }
        else if (localView2.getVisibility() == 8)
        {
          i35 = i15;
          i36 = i1;
        }
        else if ((i11 != 0) && (locald2.h().g()) && (locald2.i().g()))
        {
          i35 = i15;
          i36 = i1;
        }
        else
        {
          int i37;
          label742: int i38;
          label773: int i39;
          int i41;
          int i42;
          if ((locala.width == -2) && (locala.V))
          {
            i37 = getChildMeasureSpec(paramInt1, i14, locala.width);
            if ((locala.height != -2) || (!locala.W))
              break label1071;
            i38 = getChildMeasureSpec(paramInt2, i13, locala.height);
            localView2.measure(i37, i38);
            if (this.t != null)
            {
              android.support.constraint.a.f localf2 = this.t;
              localf2.b = (1L + localf2.b);
            }
            i39 = i1 + 1;
            int i40 = localView2.getMeasuredWidth();
            i41 = localView2.getMeasuredHeight();
            if (i40 == locald2.o())
              break label1565;
            locald2.h(i40);
            if (i11 != 0)
              locald2.h().a(i40);
            if ((i25 == 0) || (locald2.y() <= i27))
              break label1558;
            i42 = Math.max(i27, locald2.y() + locald2.a(c.c.d).e());
          }
          label898: for (int i43 = 1; ; i43 = i24)
          {
            int i45;
            label972: int i44;
            if (i41 != locald2.q())
            {
              locald2.i(i41);
              if (i11 != 0)
                locald2.i().a(i41);
              if ((i26 != 0) && (locald2.z() > i28))
              {
                i45 = Math.max(i28, locald2.z() + locald2.a(c.c.e).e());
                i44 = 1;
              }
            }
            while (true)
            {
              if (locala.X)
              {
                int i46 = localView2.getBaseline();
                if ((i46 != -1) && (i46 != locald2.C()))
                {
                  locald2.n(i46);
                  i44 = 1;
                }
              }
              if (Build.VERSION.SDK_INT >= 11)
              {
                i35 = combineMeasuredStates(i15, localView2.getMeasuredState());
                i28 = i45;
                i24 = i44;
                i36 = i39;
                i27 = i42;
                break;
                i37 = View.MeasureSpec.makeMeasureSpec(locald2.o(), 1073741824);
                break label742;
                label1071: i38 = View.MeasureSpec.makeMeasureSpec(locald2.q(), 1073741824);
                break label773;
                label1087: if (i24 != 0)
                {
                  this.b.h(i9);
                  this.b.i(i10);
                  if (i11 != 0)
                    this.b.Q();
                  a("2nd pass");
                  int i33 = this.b.o();
                  int i34 = 0;
                  if (i33 < i27)
                  {
                    this.b.h(i27);
                    i34 = 1;
                  }
                  if (this.b.q() < i28)
                  {
                    this.b.i(i28);
                    i34 = 1;
                  }
                  if (i34 != 0)
                    a("3rd pass");
                }
                int i30 = 0;
                int i31 = 0;
                d locald1;
                View localView1;
                int i32;
                if (i30 < i12)
                {
                  locald1 = (d)this.h.get(i30);
                  localView1 = (View)locald1.D();
                  if (localView1 == null)
                    i32 = i31;
                }
                while (true)
                {
                  i30++;
                  i31 = i32;
                  break;
                  if ((localView1.getMeasuredWidth() != locald1.o()) || (localView1.getMeasuredHeight() != locald1.q()))
                  {
                    localView1.measure(View.MeasureSpec.makeMeasureSpec(locald1.o(), 1073741824), View.MeasureSpec.makeMeasureSpec(locald1.q(), 1073741824));
                    if (this.t != null)
                    {
                      android.support.constraint.a.f localf1 = this.t;
                      localf1.b = (1L + localf1.b);
                    }
                    i32 = i31 + 1;
                    continue;
                    label1339: int i16 = i14 + this.b.o();
                    int i17 = i13 + this.b.q();
                    if (Build.VERSION.SDK_INT >= 11)
                    {
                      int i18 = resolveSizeAndState(i16, paramInt1, i15);
                      int i19 = resolveSizeAndState(i17, paramInt2, i15 << 16);
                      int i20 = i18 & 0xFFFFFF;
                      int i21 = i19 & 0xFFFFFF;
                      int i22 = Math.min(this.k, i20);
                      int i23 = Math.min(this.l, i21);
                      if (this.b.L())
                        i22 |= 16777216;
                      if (this.b.M())
                        i23 |= 16777216;
                      setMeasuredDimension(i22, i23);
                      this.r = i22;
                      this.s = i23;
                      return;
                    }
                    setMeasuredDimension(i16, i17);
                    this.r = i16;
                    this.s = i17;
                  }
                  else
                  {
                    i32 = i31;
                  }
                }
              }
              i28 = i45;
              i24 = i44;
              i35 = i15;
              i36 = i39;
              i27 = i42;
              break;
              i45 = i28;
              break label972;
              i44 = i43;
              i45 = i28;
            }
            label1558: i42 = i27;
            break label898;
            label1565: i42 = i27;
          }
        }
      }
      else
      {
        i35 = i15;
        i36 = i1;
      }
    }
  }

  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14)
      super.onViewAdded(paramView);
    d locald = a(paramView);
    if (((paramView instanceof Guideline)) && (!(locald instanceof android.support.constraint.a.a.f)))
    {
      a locala1 = (a)paramView.getLayoutParams();
      locala1.al = new android.support.constraint.a.a.f();
      locala1.Y = true;
      ((android.support.constraint.a.a.f)locala1.al).a(locala1.S);
    }
    if ((paramView instanceof a))
    {
      a locala = (a)paramView;
      locala.a();
      ((a)paramView.getLayoutParams()).Z = true;
      if (!this.g.contains(locala))
        this.g.add(locala);
    }
    this.a.put(paramView.getId(), paramView);
    this.m = true;
  }

  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14)
      super.onViewRemoved(paramView);
    this.a.remove(paramView.getId());
    d locald = a(paramView);
    this.b.d(locald);
    this.g.remove(paramView);
    this.h.remove(locald);
    this.m = true;
  }

  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14)
      onViewRemoved(paramView);
  }

  public void requestLayout()
  {
    super.requestLayout();
    this.m = true;
    this.r = -1;
    this.s = -1;
    this.c = -1;
    this.d = -1;
    this.e = 0;
    this.f = 0;
  }

  public void setConstraintSet(b paramb)
  {
    this.o = paramb;
  }

  public void setId(int paramInt)
  {
    this.a.remove(getId());
    super.setId(paramInt);
    this.a.put(getId(), this);
  }

  public void setMaxHeight(int paramInt)
  {
    if (paramInt == this.l)
      return;
    this.l = paramInt;
    requestLayout();
  }

  public void setMaxWidth(int paramInt)
  {
    if (paramInt == this.k)
      return;
    this.k = paramInt;
    requestLayout();
  }

  public void setMinHeight(int paramInt)
  {
    if (paramInt == this.j)
      return;
    this.j = paramInt;
    requestLayout();
  }

  public void setMinWidth(int paramInt)
  {
    if (paramInt == this.i)
      return;
    this.i = paramInt;
    requestLayout();
  }

  public void setOptimizationLevel(int paramInt)
  {
    this.b.a(paramInt);
  }

  public boolean shouldDelayChildPressedState()
  {
    return false;
  }

  public static class a extends ViewGroup.MarginLayoutParams
  {
    public float A = 0.5F;
    public String B = null;
    float C = 0.0F;
    int D = 1;
    public float E = 0.0F;
    public float F = 0.0F;
    public int G = 0;
    public int H = 0;
    public int I = 0;
    public int J = 0;
    public int K = 0;
    public int L = 0;
    public int M = 0;
    public int N = 0;
    public float O = 1.0F;
    public float P = 1.0F;
    public int Q = -1;
    public int R = -1;
    public int S = -1;
    public boolean T = false;
    public boolean U = false;
    boolean V = true;
    boolean W = true;
    boolean X = false;
    boolean Y = false;
    boolean Z = false;
    public int a = -1;
    boolean aa = false;
    int ab = -1;
    int ac = -1;
    int ad = -1;
    int ae = -1;
    int af = -1;
    int ag = -1;
    float ah = 0.5F;
    int ai;
    int aj;
    float ak;
    d al = new d();
    public boolean am = false;
    public int b = -1;
    public float c = -1.0F;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = 0;
    public float o = 0.0F;
    public int p = -1;
    public int q = -1;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public int y = -1;
    public float z = 0.5F;

    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i1 = localTypedArray.getIndexCount();
      int i2 = 0;
      if (i2 < i1)
      {
        int i3 = localTypedArray.getIndex(i2);
        switch (a.a.get(i3))
        {
        case 0:
        case 39:
        case 40:
        case 41:
        case 42:
        case 43:
        default:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 2:
        case 3:
        case 4:
        case 49:
        case 50:
        case 5:
        case 6:
        case 7:
        case 1:
        case 17:
        case 18:
        case 19:
        case 20:
        case 21:
        case 22:
        case 23:
        case 24:
        case 25:
        case 26:
        case 29:
        case 30:
        case 44:
        case 45:
        case 46:
        case 47:
        case 48:
        case 27:
        case 28:
        case 31:
        case 32:
        case 33:
        case 34:
        case 35:
        case 36:
        case 37:
        case 38:
        }
        while (true)
        {
          i2++;
          break;
          this.d = localTypedArray.getResourceId(i3, this.d);
          if (this.d == -1)
          {
            this.d = localTypedArray.getInt(i3, -1);
            continue;
            this.e = localTypedArray.getResourceId(i3, this.e);
            if (this.e == -1)
            {
              this.e = localTypedArray.getInt(i3, -1);
              continue;
              this.f = localTypedArray.getResourceId(i3, this.f);
              if (this.f == -1)
              {
                this.f = localTypedArray.getInt(i3, -1);
                continue;
                this.g = localTypedArray.getResourceId(i3, this.g);
                if (this.g == -1)
                {
                  this.g = localTypedArray.getInt(i3, -1);
                  continue;
                  this.h = localTypedArray.getResourceId(i3, this.h);
                  if (this.h == -1)
                  {
                    this.h = localTypedArray.getInt(i3, -1);
                    continue;
                    this.i = localTypedArray.getResourceId(i3, this.i);
                    if (this.i == -1)
                    {
                      this.i = localTypedArray.getInt(i3, -1);
                      continue;
                      this.j = localTypedArray.getResourceId(i3, this.j);
                      if (this.j == -1)
                      {
                        this.j = localTypedArray.getInt(i3, -1);
                        continue;
                        this.k = localTypedArray.getResourceId(i3, this.k);
                        if (this.k == -1)
                        {
                          this.k = localTypedArray.getInt(i3, -1);
                          continue;
                          this.l = localTypedArray.getResourceId(i3, this.l);
                          if (this.l == -1)
                          {
                            this.l = localTypedArray.getInt(i3, -1);
                            continue;
                            this.m = localTypedArray.getResourceId(i3, this.m);
                            if (this.m == -1)
                            {
                              this.m = localTypedArray.getInt(i3, -1);
                              continue;
                              this.n = localTypedArray.getDimensionPixelSize(i3, this.n);
                              continue;
                              this.o = (localTypedArray.getFloat(i3, this.o) % 360.0F);
                              if (this.o < 0.0F)
                              {
                                this.o = ((360.0F - this.o) % 360.0F);
                                continue;
                                this.Q = localTypedArray.getDimensionPixelOffset(i3, this.Q);
                                continue;
                                this.R = localTypedArray.getDimensionPixelOffset(i3, this.R);
                                continue;
                                this.a = localTypedArray.getDimensionPixelOffset(i3, this.a);
                                continue;
                                this.b = localTypedArray.getDimensionPixelOffset(i3, this.b);
                                continue;
                                this.c = localTypedArray.getFloat(i3, this.c);
                                continue;
                                this.S = localTypedArray.getInt(i3, this.S);
                                continue;
                                this.p = localTypedArray.getResourceId(i3, this.p);
                                if (this.p == -1)
                                {
                                  this.p = localTypedArray.getInt(i3, -1);
                                  continue;
                                  this.q = localTypedArray.getResourceId(i3, this.q);
                                  if (this.q == -1)
                                  {
                                    this.q = localTypedArray.getInt(i3, -1);
                                    continue;
                                    this.r = localTypedArray.getResourceId(i3, this.r);
                                    if (this.r == -1)
                                    {
                                      this.r = localTypedArray.getInt(i3, -1);
                                      continue;
                                      this.s = localTypedArray.getResourceId(i3, this.s);
                                      if (this.s == -1)
                                      {
                                        this.s = localTypedArray.getInt(i3, -1);
                                        continue;
                                        this.t = localTypedArray.getDimensionPixelSize(i3, this.t);
                                        continue;
                                        this.u = localTypedArray.getDimensionPixelSize(i3, this.u);
                                        continue;
                                        this.v = localTypedArray.getDimensionPixelSize(i3, this.v);
                                        continue;
                                        this.w = localTypedArray.getDimensionPixelSize(i3, this.w);
                                        continue;
                                        this.x = localTypedArray.getDimensionPixelSize(i3, this.x);
                                        continue;
                                        this.y = localTypedArray.getDimensionPixelSize(i3, this.y);
                                        continue;
                                        this.z = localTypedArray.getFloat(i3, this.z);
                                        continue;
                                        this.A = localTypedArray.getFloat(i3, this.A);
                                        continue;
                                        this.B = localTypedArray.getString(i3);
                                        this.C = (0.0F / 0.0F);
                                        this.D = -1;
                                        if (this.B != null)
                                        {
                                          int i4 = this.B.length();
                                          int i5 = this.B.indexOf(',');
                                          String str4;
                                          if ((i5 > 0) && (i5 < i4 - 1))
                                          {
                                            str4 = this.B.substring(0, i5);
                                            if (str4.equalsIgnoreCase("W"))
                                              this.D = 0;
                                          }
                                          label1486: float f1;
                                          float f2;
                                          for (int i6 = i5 + 1; ; i6 = 0)
                                          {
                                            while (true)
                                            {
                                              int i7 = this.B.indexOf(':');
                                              if ((i7 < 0) || (i7 >= i4 - 1))
                                                break label1659;
                                              String str2 = this.B.substring(i6, i7);
                                              String str3 = this.B.substring(i7 + 1);
                                              if ((str2.length() <= 0) || (str3.length() <= 0))
                                                break;
                                              try
                                              {
                                                f1 = Float.parseFloat(str2);
                                                f2 = Float.parseFloat(str3);
                                                if ((f1 <= 0.0F) || (f2 <= 0.0F))
                                                  break;
                                                if (this.D != 1)
                                                  break label1640;
                                                this.C = Math.abs(f2 / f1);
                                              }
                                              catch (NumberFormatException localNumberFormatException2)
                                              {
                                              }
                                            }
                                            break;
                                            if (!str4.equalsIgnoreCase("H"))
                                              break label1486;
                                            this.D = 1;
                                            break label1486;
                                          }
                                          label1640: float f3 = f1 / f2;
                                          this.C = Math.abs(f3);
                                          continue;
                                          label1659: String str1 = this.B.substring(i6);
                                          if (str1.length() > 0)
                                          {
                                            try
                                            {
                                              this.C = Float.parseFloat(str1);
                                            }
                                            catch (NumberFormatException localNumberFormatException1)
                                            {
                                            }
                                            continue;
                                            this.E = localTypedArray.getFloat(i3, 0.0F);
                                            continue;
                                            this.F = localTypedArray.getFloat(i3, 0.0F);
                                            continue;
                                            this.G = localTypedArray.getInt(i3, 0);
                                            continue;
                                            this.H = localTypedArray.getInt(i3, 0);
                                            continue;
                                            this.T = localTypedArray.getBoolean(i3, this.T);
                                            continue;
                                            this.U = localTypedArray.getBoolean(i3, this.U);
                                            continue;
                                            this.I = localTypedArray.getInt(i3, 0);
                                            if (this.I == 1)
                                            {
                                              Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                                              continue;
                                              this.J = localTypedArray.getInt(i3, 0);
                                              if (this.J == 1)
                                              {
                                                Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                                                continue;
                                                try
                                                {
                                                  this.K = localTypedArray.getDimensionPixelSize(i3, this.K);
                                                }
                                                catch (Exception localException4)
                                                {
                                                }
                                                if (localTypedArray.getInt(i3, this.K) == -2)
                                                {
                                                  this.K = -2;
                                                  continue;
                                                  try
                                                  {
                                                    this.M = localTypedArray.getDimensionPixelSize(i3, this.M);
                                                  }
                                                  catch (Exception localException3)
                                                  {
                                                  }
                                                  if (localTypedArray.getInt(i3, this.M) == -2)
                                                  {
                                                    this.M = -2;
                                                    continue;
                                                    this.O = Math.max(0.0F, localTypedArray.getFloat(i3, this.O));
                                                    continue;
                                                    try
                                                    {
                                                      this.L = localTypedArray.getDimensionPixelSize(i3, this.L);
                                                    }
                                                    catch (Exception localException2)
                                                    {
                                                    }
                                                    if (localTypedArray.getInt(i3, this.L) == -2)
                                                    {
                                                      this.L = -2;
                                                      continue;
                                                      try
                                                      {
                                                        this.N = localTypedArray.getDimensionPixelSize(i3, this.N);
                                                      }
                                                      catch (Exception localException1)
                                                      {
                                                      }
                                                      if (localTypedArray.getInt(i3, this.N) == -2)
                                                      {
                                                        this.N = -2;
                                                        continue;
                                                        this.P = Math.max(0.0F, localTypedArray.getFloat(i3, this.P));
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      localTypedArray.recycle();
      a();
    }

    public a(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public void a()
    {
      this.Y = false;
      this.V = true;
      this.W = true;
      if ((this.width == -2) && (this.T))
      {
        this.V = false;
        this.I = 1;
      }
      if ((this.height == -2) && (this.U))
      {
        this.W = false;
        this.J = 1;
      }
      if ((this.width == 0) || (this.width == -1))
      {
        this.V = false;
        if ((this.width == 0) && (this.I == 1))
        {
          this.width = -2;
          this.T = true;
        }
      }
      if ((this.height == 0) || (this.height == -1))
      {
        this.W = false;
        if ((this.height == 0) && (this.J == 1))
        {
          this.height = -2;
          this.U = true;
        }
      }
      if ((this.c != -1.0F) || (this.a != -1) || (this.b != -1))
      {
        this.Y = true;
        this.V = true;
        this.W = true;
        if (!(this.al instanceof android.support.constraint.a.a.f))
          this.al = new android.support.constraint.a.a.f();
        ((android.support.constraint.a.a.f)this.al).a(this.S);
      }
    }

    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      int i1 = this.leftMargin;
      int i2 = this.rightMargin;
      super.resolveLayoutDirection(paramInt);
      this.ad = -1;
      this.ae = -1;
      this.ab = -1;
      this.ac = -1;
      this.af = -1;
      this.ag = -1;
      this.af = this.t;
      this.ag = this.v;
      this.ah = this.z;
      this.ai = this.a;
      this.aj = this.b;
      this.ak = this.c;
      int i3;
      int i5;
      if (1 == getLayoutDirection())
      {
        i3 = 1;
        if (i3 == 0)
          break label450;
        if (this.p == -1)
          break label361;
        this.ad = this.p;
        i5 = 1;
        label128: if (this.r != -1)
        {
          this.ac = this.r;
          i5 = 1;
        }
        if (this.s != -1)
        {
          this.ab = this.s;
          i5 = 1;
        }
        if (this.x != -1)
          this.ag = this.x;
        if (this.y != -1)
          this.af = this.y;
        if (i5 != 0)
          this.ah = (1.0F - this.z);
        if ((this.Y) && (this.S == 1))
        {
          if (this.c == -1.0F)
            break label390;
          this.ak = (1.0F - this.c);
          this.ai = -1;
          this.aj = -1;
        }
        label258: if ((this.r == -1) && (this.s == -1) && (this.q == -1) && (this.p == -1))
        {
          if (this.f == -1)
            break label549;
          this.ad = this.f;
          if ((this.rightMargin <= 0) && (i2 > 0))
            this.rightMargin = i2;
          label322: if (this.d == -1)
            break label584;
          this.ab = this.d;
          if ((this.leftMargin <= 0) && (i1 > 0))
            this.leftMargin = i1;
        }
      }
      label361: 
      do
      {
        do
        {
          return;
          i3 = 0;
          break;
          int i4 = this.q;
          i5 = 0;
          if (i4 == -1)
            break label128;
          this.ae = this.q;
          i5 = 1;
          break label128;
          if (this.a != -1)
          {
            this.aj = this.a;
            this.ai = -1;
            this.ak = -1.0F;
            break label258;
          }
          if (this.b == -1)
            break label258;
          this.ai = this.b;
          this.aj = -1;
          this.ak = -1.0F;
          break label258;
          if (this.p != -1)
            this.ac = this.p;
          if (this.q != -1)
            this.ab = this.q;
          if (this.r != -1)
            this.ad = this.r;
          if (this.s != -1)
            this.ae = this.s;
          if (this.x != -1)
            this.af = this.x;
          if (this.y == -1)
            break label258;
          this.ag = this.y;
          break label258;
          if (this.g == -1)
            break label322;
          this.ae = this.g;
          if ((this.rightMargin > 0) || (i2 <= 0))
            break label322;
          this.rightMargin = i2;
          break label322;
        }
        while (this.e == -1);
        this.ac = this.e;
      }
      while ((this.leftMargin > 0) || (i1 <= 0));
      label390: label450: label584: this.leftMargin = i1;
      label549:
    }

    private static class a
    {
      public static final SparseIntArray a = new SparseIntArray();

      static
      {
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        a.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.ConstraintLayout
 * JD-Core Version:    0.6.2
 */