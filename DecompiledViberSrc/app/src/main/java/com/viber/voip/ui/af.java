package com.viber.voip.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AbsListView.RecyclerListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.ui.g.d;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.ae;
import com.viber.voip.util.dj;
import org.jetbrains.annotations.NotNull;

public abstract class af extends ViberListView
{
  private static final int a = View.MeasureSpec.makeMeasureSpec(0, 0);
  private int[] A;
  private Runnable B;
  private AdapterView.OnItemLongClickListener C;
  private View.OnCreateContextMenuListener D;
  private AdapterView.OnItemClickListener E;
  private boolean b;
  private float c = -1.0F;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  protected boolean g;
  protected boolean h;
  protected boolean i;
  protected boolean j;
  protected a k;
  protected int l = -1;
  protected int m;
  protected b n = b.c;
  protected float o;
  protected boolean p = true;
  AbsListView.RecyclerListener q = ag.a;
  Handler r = new Handler();
  protected AdapterView.OnItemLongClickListener s;
  protected View.OnCreateContextMenuListener t;
  protected AdapterView.OnItemClickListener u;
  private float v = -1.0F;
  private float w = -1.0F;
  private float[] x = new float[3];
  private c y = new c();
  private c z = new c();

  public af(Context paramContext)
  {
    super(paramContext);
    this.B = new al(this);
    this.C = new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (af.this.s == null)
          return false;
        if (af.this.m())
          return af.this.s.onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousView.setPressed(false);
        return false;
      }
    };
    this.D = new View.OnCreateContextMenuListener()
    {
      public void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        if (af.this.t == null)
          return;
        AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramAnonymousContextMenuInfo;
        if (af.this.m())
        {
          af.this.t.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
          return;
        }
        localAdapterContextMenuInfo.targetView.setPressed(false);
      }
    };
    this.E = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (af.this.u == null)
          return;
        if (af.this.m())
        {
          af.this.u.onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          return;
        }
        paramAnonymousView.setPressed(false);
      }
    };
    b(paramContext);
  }

  public af(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.B = new aj(this);
    this.C = new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (af.this.s == null)
          return false;
        if (af.this.m())
          return af.this.s.onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousView.setPressed(false);
        return false;
      }
    };
    this.D = new View.OnCreateContextMenuListener()
    {
      public void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        if (af.this.t == null)
          return;
        AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramAnonymousContextMenuInfo;
        if (af.this.m())
        {
          af.this.t.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
          return;
        }
        localAdapterContextMenuInfo.targetView.setPressed(false);
      }
    };
    this.E = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (af.this.u == null)
          return;
        if (af.this.m())
        {
          af.this.u.onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          return;
        }
        paramAnonymousView.setPressed(false);
      }
    };
    b(paramContext);
  }

  public af(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.B = new ah(this);
    this.C = new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (af.this.s == null)
          return false;
        if (af.this.m())
          return af.this.s.onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousView.setPressed(false);
        return false;
      }
    };
    this.D = new View.OnCreateContextMenuListener()
    {
      public void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        if (af.this.t == null)
          return;
        AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramAnonymousContextMenuInfo;
        if (af.this.m())
        {
          af.this.t.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
          return;
        }
        localAdapterContextMenuInfo.targetView.setPressed(false);
      }
    };
    this.E = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (af.this.u == null)
          return;
        if (af.this.m())
        {
          af.this.u.onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          return;
        }
        paramAnonymousView.setPressed(false);
      }
    };
    b(paramContext);
  }

  private float a(float[] paramArrayOfFloat)
  {
    int i1 = 0;
    int i2 = 0;
    float f1 = 0.0F;
    while (i2 < 3)
    {
      f1 += paramArrayOfFloat[i2];
      if (paramArrayOfFloat[i2] != 0.0F)
        i1++;
      i2++;
    }
    return f1 / i1;
  }

  @NotNull
  protected static Context a(Context paramContext)
  {
    return new ContextThemeWrapper(paramContext, ((av)ViberApplication.getInstance().getThemeController().get()).a(R.style.Theme_Viber_ListView_FastScroll));
  }

  private void a(float paramFloat)
  {
    int i1 = 0;
    int i2 = getLastVisiblePosition() - getFirstVisiblePosition();
    for (int i3 = 0; i3 <= i2; i3++)
    {
      View localView = getChildAt(i3);
      if (localView != null)
      {
        localView.setTranslationY((int)paramFloat);
        if (localView.getY() + localView.getHeight() < 0.0F)
          i1++;
      }
    }
    this.m = i1;
    this.o = paramFloat;
    invalidate();
  }

  private void a(int paramInt, float paramFloat)
  {
    boolean bool1;
    boolean bool2;
    if (!k())
    {
      bool1 = h();
      bool2 = i();
      if ((bool1) || (bool2))
        switch (paramInt)
        {
        case 1:
        default:
        case 0:
        case 2:
        }
    }
    do
    {
      return;
      this.w = paramFloat;
      return;
      if (this.w == -1.0F)
        this.w = paramFloat;
      float f1 = paramFloat - this.w;
      if (((bool1) && (f1 > 5.0F) && ((this.j) || (this.i))) || ((bool2) && (-f1 > 5.0F) && (this.i)))
      {
        setOverscrolled(true);
        return;
      }
    }
    while (!this.d);
    setOverscrolled(false);
  }

  private void b(Context paramContext)
  {
    setOverScrollMode(2);
    setDescendantFocusability(262144);
    this.k = c();
  }

  private boolean b(float paramFloat)
  {
    float f1 = a(this.x) - paramFloat;
    if ((f1 < 0.0F) && (i()))
      setOverscrollDirection(b.b);
    if ((f1 > 0.0F) && (h()))
      setOverscrollDirection(b.a);
    if (((f1 > 0.0F) && (i())) || ((f1 < 0.0F) && (h()) && (i() != h())))
    {
      d();
      a(0.0F);
      return false;
    }
    a(f1);
    return true;
  }

  private boolean b(MotionEvent paramMotionEvent, int paramInt, float paramFloat)
  {
    if (this.b)
    {
      this.b = false;
      return super.onTouchEvent(paramMotionEvent);
    }
    a(paramInt, paramFloat);
    if (!k())
    {
      this.m = 0;
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramInt)
    {
    default:
      return false;
    case 0:
      this.m = 0;
      this.v = paramFloat;
      return super.onTouchEvent(paramMotionEvent);
    case 2:
      this.v = paramFloat;
      if (this.c == -1.0F)
        this.c = paramFloat;
      o();
      c(paramFloat);
      b(this.c);
      return false;
    case 1:
    case 3:
    }
    this.c = -1.0F;
    this.w = -1.0F;
    this.v = -1.0F;
    this.m = 0;
    e();
    l();
    return super.onTouchEvent(paramMotionEvent);
  }

  private void c(float paramFloat)
  {
    System.arraycopy(this.x, 1, this.x, 0, 2);
    this.x[2] = (paramFloat - this.o);
  }

  private void d()
  {
    l();
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.currentThreadTimeMillis(), SystemClock.uptimeMillis(), 0, -1.0F, this.x[2], 0);
    g();
    this.b = true;
    dispatchTouchEvent(localMotionEvent);
    setOverscrolled(false);
    localMotionEvent.recycle();
    b(this.q);
  }

  private void e()
  {
    for (int i1 = 0; i1 < 3; i1++)
      this.x[i1] = 0.0F;
  }

  private void o()
  {
    a(this.q);
    this.A = new int[1 + (getLastVisiblePosition() - getFirstVisiblePosition())];
    for (int i1 = 0; i1 <= getLastVisiblePosition() - getFirstVisiblePosition(); i1++)
      if (getChildAt(i1) != null)
        this.A[i1] = getChildAt(i1).getTop();
    this.l = -1;
  }

  private void p()
  {
    int i1;
    label19: View localView;
    if (this.k != null)
    {
      i1 = this.k.a;
      if (i1 > 0)
      {
        localView = getChildAt(this.m);
        if (localView == null)
          break label67;
      }
    }
    label67: for (int i2 = localView.getBottom(); ; i2 = i1)
    {
      if (i2 < i1)
        this.m = (1 + this.m);
      if ((localView != null) && (i2 < i1))
        break label19;
      return;
      i1 = 0;
      break;
    }
  }

  private void setOverscrollDirection(b paramb)
  {
    this.n = paramb;
  }

  private void setOverscrolled(boolean paramBoolean)
  {
    if ((!this.d) && (paramBoolean == true))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.currentThreadTimeMillis(), SystemClock.uptimeMillis(), 1, 0.0F, 0.0F, 0);
      this.b = true;
      dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
    this.d = paramBoolean;
  }

  protected void a()
  {
    View localView = this.k.c;
    if (localView != null)
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(this.k.f, 1073741824), a);
      localView.layout(0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
    }
  }

  protected void a(int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    if ((getAdapter() == null) || (getChildCount() == 0));
    View localView1;
    int i1;
    View localView2;
    boolean bool2;
    label54: 
    do
    {
      return;
      localView1 = getChildAt(paramInt2);
      if (getChildCount() >= 2)
        break;
      i1 = paramInt2;
      localView2 = getChildAt(i1);
      if (this.l == paramInt1)
        break label478;
      bool2 = bool1;
      this.g = bool2;
      if (this.g)
      {
        this.l = paramInt1;
        a(paramInt2, localView1);
      }
    }
    while ((localView1 == null) || (localView2 == null) || (this.k == null) || (this.k.c == null));
    int i2 = getHeaderTag();
    c localc1 = this.z;
    Object localObject1;
    label131: c localc2;
    Object localObject2;
    label163: int i3;
    int i4;
    int i5;
    if (i2 == -1)
    {
      localObject1 = localView1.getTag();
      localc1.a(localObject1);
      localc2 = this.z;
      c localc3 = this.y;
      if (i2 != -1)
        break label496;
      localObject2 = localView2.getTag();
      localc3.a(localObject2);
      this.e = bool1;
      if ((paramInt1 == 0) && (!c.a(localc2)))
        this.e = false;
      if (!c.b(localc2))
        this.e = false;
      if ((k()) && (this.n == b.a))
        this.e = false;
      if (TextUtils.isEmpty(localc2.b()))
        this.e = false;
      i3 = (int)localView1.getY();
      i4 = this.k.a;
      if ((!this.y.a()) || (a(i1)))
        break label508;
      i5 = i3 + localView1.getHeight() + getDividerHeight() - this.k.c.getHeight();
      label305: if ((!localc2.a()) || (i3 + this.k.b <= i4))
        break label537;
      i5 = i3 + this.k.b;
      label340: if ((localc2.a()) && (c.c(localc2)))
        this.k.b = localc2.e();
      this.k.a(i5);
      this.k.a(this.e);
      if ((this.k.g != i4) || (!this.e) || ((i3 >= i4) && (localView1.getTop() >= i4)) || ((!c.a(localc2)) && (!c.a(this.y))))
        break label551;
    }
    while (true)
    {
      this.f = bool1;
      a(localc2);
      if (this.p)
        a();
      this.m = 0;
      return;
      i1 = paramInt2 + 1;
      break;
      label478: bool2 = false;
      break label54;
      localObject1 = localView1.getTag(i2);
      break label131;
      label496: localObject2 = localView2.getTag(i2);
      break label163;
      label508: if ((localc2.a()) && (i3 > i4))
      {
        i5 = i3;
        break label305;
      }
      i5 = i4;
      break label305;
      label537: if (i5 <= i4)
        break label340;
      i5 = i4;
      break label340;
      label551: bool1 = false;
    }
  }

  protected abstract void a(int paramInt, View paramView);

  public abstract void a(c paramc);

  protected boolean a(int paramInt)
  {
    return paramInt == -1 + getCount();
  }

  public boolean a(MotionEvent paramMotionEvent, int paramInt, float paramFloat)
  {
    return b(paramMotionEvent, paramInt, paramFloat);
  }

  protected abstract a c();

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.e)
    {
      int i1 = paramCanvas.save();
      paramCanvas.translate(this.k.e, this.k.g);
      this.k.c.draw(paramCanvas);
      paramCanvas.restoreToCount(i1);
    }
  }

  public void f()
  {
    this.l = -1;
    this.g = true;
  }

  public void g()
  {
    this.o = 0.0F;
    a(this.o);
    setOverscrolled(false);
    this.c = -1.0F;
    e();
  }

  protected float getBottomFadingEdgeStrength()
  {
    return 0.0F;
  }

  protected View.OnCreateContextMenuListener getExtendedCreateContextMenuItemClickListener()
  {
    return this.D;
  }

  protected AdapterView.OnItemClickListener getExtendedItemClickListener()
  {
    return this.E;
  }

  protected AdapterView.OnItemLongClickListener getExtendedItemLongClickListener()
  {
    return this.C;
  }

  protected abstract int getHeaderTag();

  public a getStickyHeader()
  {
    return this.k;
  }

  protected float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }

  protected boolean h()
  {
    if (getCount() == 0);
    do
    {
      return true;
      if ((getFirstVisiblePosition() != 0) || (getChildAt(0) == null))
        break;
    }
    while (getChildAt(0).getTop() >= 0);
    return false;
    return false;
  }

  protected boolean i()
  {
    if (getCount() == 0);
    do
    {
      return true;
      if ((getLastVisiblePosition() != -1 + getCount()) || (getChildAt(-1 + getChildCount()) == null))
        break;
    }
    while (getChildAt(-1 + getChildCount()).getBottom() <= getBottom());
    return false;
    return false;
  }

  public void j()
  {
    setAdapter(null);
  }

  protected boolean k()
  {
    return this.d;
  }

  protected void l()
  {
    if (this.o != 0.0F)
    {
      this.o -= this.o / 3.0F;
      if ((this.o < 3.0F) && (this.o > -3.0F))
      {
        this.o = 0.0F;
        setOverscrolled(false);
      }
      if (this.c == -1.0F)
      {
        a(this.o);
        this.r.postDelayed(this.B, 0L);
      }
      return;
    }
    b(this.q);
    a(this.o);
    setOverscrolled(false);
  }

  protected boolean m()
  {
    return !k();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.d)
    {
      a(0.0F);
      g();
      setOverscrolled(false);
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    p();
    a(getFirstVisiblePosition() + this.m, this.m);
    super.onDraw(paramCanvas);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.k != null)
    {
      this.k.e = getPaddingLeft();
      this.k.f = (paramInt3 - paramInt1 - this.k.e - getPaddingRight());
    }
    if (k())
      a(this.o);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return b(paramMotionEvent, paramMotionEvent.getAction(), paramMotionEvent.getY());
  }

  public void setEnablSmoothOverscroll(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.t = paramOnCreateContextMenuListener;
    super.setOnCreateContextMenuListener(getExtendedCreateContextMenuItemClickListener());
  }

  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.u = paramOnItemClickListener;
    super.setOnItemClickListener(getExtendedItemClickListener());
  }

  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.s = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(getExtendedItemLongClickListener());
  }

  public void setStickyHeaderStickyPosition(int paramInt)
  {
    if (this.k != null)
      this.k.a = paramInt;
  }

  public static class a
  {
    public int a = 0;
    public int b = 0;
    public View c;
    public View d;
    public int e;
    public int f;
    public int g;
    private int h;
    private boolean i;
    private boolean j;
    private Boolean k;
    private boolean l;

    public a()
    {
      this.j = true;
    }

    public a(boolean paramBoolean)
    {
      this.j = paramBoolean;
    }

    private void b()
    {
      if (this.c != null)
        dj.c(this.c, 8);
    }

    private void c()
    {
      if (this.c != null)
        dj.c(this.c, 0);
      if ((this.d != null) && (!this.j))
      {
        View localView = this.d;
        boolean bool = this.i;
        int m = 0;
        if (bool)
          m = this.h;
        localView.setBackgroundResource(m);
      }
    }

    public void a(int paramInt)
    {
      boolean bool1 = true;
      if (paramInt > this.b + this.a)
        paramInt = this.b + this.a;
      boolean bool2;
      if (this.g != paramInt)
      {
        bool2 = bool1;
        this.l = bool2;
        this.g = paramInt;
        if (this.g > this.a)
          break label67;
      }
      while (true)
      {
        this.i = bool1;
        return;
        bool2 = false;
        break;
        label67: bool1 = false;
      }
    }

    public void a(boolean paramBoolean)
    {
      if ((!this.l) && (this.k != null) && (paramBoolean == this.k.booleanValue()))
        return;
      this.k = Boolean.valueOf(paramBoolean);
      if (paramBoolean)
      {
        if (this.g <= this.a);
        for (boolean bool = true; ; bool = false)
        {
          this.i = bool;
          c();
          return;
        }
      }
      b();
    }

    public boolean a()
    {
      return this.i;
    }

    public void b(int paramInt)
    {
      this.h = paramInt;
    }
  }

  private static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }
  }

  public static class c
  {
    private boolean a;
    private boolean b;
    private CharSequence c;
    private String d;
    private boolean e;
    private int f;
    private boolean g;
    private long h;

    public void a(int paramInt)
    {
      this.f = paramInt;
    }

    public void a(CharSequence paramCharSequence)
    {
      this.c = paramCharSequence;
    }

    public void a(Object paramObject)
    {
      if ((paramObject instanceof com.viber.voip.ui.g.a))
      {
        com.viber.voip.messages.conversation.adapter.a.a locala = (com.viber.voip.messages.conversation.adapter.a.a)((com.viber.voip.ui.g.a)paramObject).a().d();
        if (locala != null)
        {
          boolean bool = locala.g();
          a(bool);
          b(bool);
          if ((TextUtils.isEmpty(this.c)) || (ae.a(this.h, locala.c().e())))
          {
            this.h = locala.c().e();
            a(locala.c().G());
          }
          c(true);
        }
        return;
      }
      if ((paramObject instanceof c))
      {
        c localc = (c)paramObject;
        a(localc.a());
        b(localc.d());
        a(localc.b());
        a(localc.c());
        a(localc.e());
        d(true);
        c(true);
        return;
      }
      a(true);
      a("");
    }

    public void a(String paramString)
    {
      this.d = paramString;
    }

    public void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }

    public boolean a()
    {
      return this.b;
    }

    public CharSequence b()
    {
      return this.c;
    }

    public void b(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    public String c()
    {
      return this.d;
    }

    public void c(boolean paramBoolean)
    {
      this.e = paramBoolean;
    }

    public void d(boolean paramBoolean)
    {
      this.g = paramBoolean;
    }

    public boolean d()
    {
      return this.a;
    }

    public int e()
    {
      return this.f;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.af
 * JD-Core Version:    0.6.2
 */