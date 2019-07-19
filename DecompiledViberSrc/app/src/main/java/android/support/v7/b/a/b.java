package android.support.v7.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.DisplayMetrics;
import android.util.SparseArray;

class b extends Drawable
  implements Drawable.Callback
{
  private b a;
  private Rect b;
  private Drawable c;
  private Drawable d;
  private int e = 255;
  private boolean f;
  private int g = -1;
  private int h = -1;
  private boolean i;
  private Runnable j;
  private long k;
  private long l;
  private a m;

  static int a(Resources paramResources, int paramInt)
  {
    if (paramResources == null);
    for (int n = paramInt; ; n = paramResources.getDisplayMetrics().densityDpi)
    {
      if (n == 0)
        n = 160;
      return n;
    }
  }

  private void a(Drawable paramDrawable)
  {
    if (this.m == null)
      this.m = new a();
    paramDrawable.setCallback(this.m.a(paramDrawable.getCallback()));
    try
    {
      if ((this.a.C <= 0) && (this.f))
        paramDrawable.setAlpha(this.e);
      if (this.a.G)
        paramDrawable.setColorFilter(this.a.F);
      while (true)
      {
        paramDrawable.setVisible(isVisible(), true);
        paramDrawable.setDither(this.a.z);
        paramDrawable.setState(getState());
        paramDrawable.setLevel(getLevel());
        paramDrawable.setBounds(getBounds());
        if (Build.VERSION.SDK_INT >= 23)
          paramDrawable.setLayoutDirection(getLayoutDirection());
        if (Build.VERSION.SDK_INT >= 19)
          paramDrawable.setAutoMirrored(this.a.E);
        Rect localRect = this.b;
        if ((Build.VERSION.SDK_INT >= 21) && (localRect != null))
          paramDrawable.setHotspotBounds(localRect.left, localRect.top, localRect.right, localRect.bottom);
        return;
        if (this.a.J)
          DrawableCompat.setTintList(paramDrawable, this.a.H);
        if (this.a.K)
          DrawableCompat.setTintMode(paramDrawable, this.a.I);
      }
    }
    finally
    {
      paramDrawable.setCallback(this.m.a());
    }
  }

  @SuppressLint({"WrongConstant"})
  @TargetApi(23)
  private boolean a()
  {
    return (isAutoMirrored()) && (getLayoutDirection() == 1);
  }

  final void a(Resources paramResources)
  {
    this.a.a(paramResources);
  }

  protected void a(b paramb)
  {
    this.a = paramb;
    if (this.g >= 0)
    {
      this.c = paramb.b(this.g);
      if (this.c != null)
        a(this.c);
    }
    this.h = -1;
    this.d = null;
  }

  void a(boolean paramBoolean)
  {
    this.f = true;
    long l1 = SystemClock.uptimeMillis();
    int n;
    if (this.c != null)
    {
      if (this.k == 0L)
        break label180;
      if (this.k <= l1)
      {
        this.c.setAlpha(this.e);
        this.k = 0L;
        n = 0;
        if (this.d == null)
          break label231;
        if (this.l != 0L)
        {
          if (this.l > l1)
            break label186;
          this.d.setVisible(false, false);
          this.d = null;
          this.h = -1;
          this.l = 0L;
        }
      }
    }
    while (true)
    {
      if ((paramBoolean) && (n != 0))
        scheduleSelf(this.j, 16L + l1);
      return;
      int i2 = (int)(255L * (this.k - l1)) / this.a.C;
      this.c.setAlpha((255 - i2) * this.e / 255);
      n = 1;
      break;
      this.k = 0L;
      label180: n = 0;
      break;
      label186: int i1 = (int)(255L * (this.l - l1)) / this.a.D;
      this.d.setAlpha(i1 * this.e / 255);
      n = 1;
      continue;
      label231: this.l = 0L;
    }
  }

  boolean a(int paramInt)
  {
    if (paramInt == this.g)
      return false;
    long l1 = SystemClock.uptimeMillis();
    if (this.a.D > 0)
    {
      if (this.d != null)
        this.d.setVisible(false, false);
      if (this.c != null)
      {
        this.d = this.c;
        this.h = this.g;
        this.l = (l1 + this.a.D);
        if ((paramInt < 0) || (paramInt >= this.a.j))
          break label235;
        Drawable localDrawable = this.a.b(paramInt);
        this.c = localDrawable;
        this.g = paramInt;
        if (localDrawable != null)
        {
          if (this.a.C > 0)
            this.k = (l1 + this.a.C);
          a(localDrawable);
        }
        label149: if ((this.k != 0L) || (this.l != 0L))
        {
          if (this.j != null)
            break label248;
          this.j = new Runnable()
          {
            public void run()
            {
              b.this.a(true);
              b.this.invalidateSelf();
            }
          };
        }
      }
    }
    while (true)
    {
      a(true);
      invalidateSelf();
      return true;
      this.d = null;
      this.h = -1;
      this.l = 0L;
      break;
      if (this.c == null)
        break;
      this.c.setVisible(false, false);
      break;
      label235: this.c = null;
      this.g = -1;
      break label149;
      label248: unscheduleSelf(this.j);
    }
  }

  public void applyTheme(Resources.Theme paramTheme)
  {
    this.a.a(paramTheme);
  }

  b c()
  {
    return this.a;
  }

  public boolean canApplyTheme()
  {
    return this.a.canApplyTheme();
  }

  int d()
  {
    return this.g;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.c != null)
      this.c.draw(paramCanvas);
    if (this.d != null)
      this.d.draw(paramCanvas);
  }

  public int getAlpha()
  {
    return this.e;
  }

  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.a.getChangingConfigurations();
  }

  public final Drawable.ConstantState getConstantState()
  {
    if (this.a.n())
    {
      this.a.f = getChangingConfigurations();
      return this.a;
    }
    return null;
  }

  public Drawable getCurrent()
  {
    return this.c;
  }

  public void getHotspotBounds(Rect paramRect)
  {
    if (this.b != null)
    {
      paramRect.set(this.b);
      return;
    }
    super.getHotspotBounds(paramRect);
  }

  public int getIntrinsicHeight()
  {
    if (this.a.f())
      return this.a.h();
    if (this.c != null)
      return this.c.getIntrinsicHeight();
    return -1;
  }

  public int getIntrinsicWidth()
  {
    if (this.a.f())
      return this.a.g();
    if (this.c != null)
      return this.c.getIntrinsicWidth();
    return -1;
  }

  public int getMinimumHeight()
  {
    if (this.a.f())
      return this.a.j();
    if (this.c != null)
      return this.c.getMinimumHeight();
    return 0;
  }

  public int getMinimumWidth()
  {
    if (this.a.f())
      return this.a.i();
    if (this.c != null)
      return this.c.getMinimumWidth();
    return 0;
  }

  public int getOpacity()
  {
    if ((this.c == null) || (!this.c.isVisible()))
      return -2;
    return this.a.l();
  }

  public void getOutline(Outline paramOutline)
  {
    if (this.c != null)
      this.c.getOutline(paramOutline);
  }

  public boolean getPadding(Rect paramRect)
  {
    Rect localRect = this.a.e();
    boolean bool;
    if (localRect != null)
    {
      paramRect.set(localRect);
      if ((localRect.left | localRect.top | localRect.bottom | localRect.right) != 0)
        bool = true;
    }
    while (true)
    {
      if (a())
      {
        int n = paramRect.left;
        paramRect.left = paramRect.right;
        paramRect.right = n;
      }
      return bool;
      bool = false;
      continue;
      if (this.c != null)
        bool = this.c.getPadding(paramRect);
      else
        bool = super.getPadding(paramRect);
    }
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.a != null)
      this.a.b();
    if ((paramDrawable == this.c) && (getCallback() != null))
      getCallback().invalidateDrawable(this);
  }

  public boolean isAutoMirrored()
  {
    return this.a.E;
  }

  public boolean isStateful()
  {
    return this.a.m();
  }

  public void jumpToCurrentState()
  {
    int n = 1;
    Drawable localDrawable = this.d;
    int i1 = 0;
    if (localDrawable != null)
    {
      this.d.jumpToCurrentState();
      this.d = null;
      this.h = -1;
      i1 = n;
    }
    if (this.c != null)
    {
      this.c.jumpToCurrentState();
      if (this.f)
        this.c.setAlpha(this.e);
    }
    if (this.l != 0L)
    {
      this.l = 0L;
      i1 = n;
    }
    if (this.k != 0L)
      this.k = 0L;
    while (true)
    {
      if (n != 0)
        invalidateSelf();
      return;
      n = i1;
    }
  }

  public Drawable mutate()
  {
    if ((!this.i) && (super.mutate() == this))
    {
      b localb = c();
      localb.a();
      a(localb);
      this.i = true;
    }
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    if (this.d != null)
      this.d.setBounds(paramRect);
    if (this.c != null)
      this.c.setBounds(paramRect);
  }

  public boolean onLayoutDirectionChanged(int paramInt)
  {
    return this.a.d(paramInt, d());
  }

  protected boolean onLevelChange(int paramInt)
  {
    if (this.d != null)
      return this.d.setLevel(paramInt);
    if (this.c != null)
      return this.c.setLevel(paramInt);
    return false;
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.d != null)
      return this.d.setState(paramArrayOfInt);
    if (this.c != null)
      return this.c.setState(paramArrayOfInt);
    return false;
  }

  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.c) && (getCallback() != null))
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
  }

  public void setAlpha(int paramInt)
  {
    if ((!this.f) || (this.e != paramInt))
    {
      this.f = true;
      this.e = paramInt;
      if (this.c != null)
      {
        if (this.k != 0L)
          break label50;
        this.c.setAlpha(paramInt);
      }
    }
    return;
    label50: a(false);
  }

  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.a.E != paramBoolean)
    {
      this.a.E = paramBoolean;
      if (this.c != null)
        DrawableCompat.setAutoMirrored(this.c, this.a.E);
    }
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.G = true;
    if (this.a.F != paramColorFilter)
    {
      this.a.F = paramColorFilter;
      if (this.c != null)
        this.c.setColorFilter(paramColorFilter);
    }
  }

  public void setDither(boolean paramBoolean)
  {
    if (this.a.z != paramBoolean)
    {
      this.a.z = paramBoolean;
      if (this.c != null)
        this.c.setDither(this.a.z);
    }
  }

  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.c != null)
      DrawableCompat.setHotspot(this.c, paramFloat1, paramFloat2);
  }

  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.b == null)
      this.b = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    while (true)
    {
      if (this.c != null)
        DrawableCompat.setHotspotBounds(this.c, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      this.b.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }

  public void setTintList(ColorStateList paramColorStateList)
  {
    this.a.J = true;
    if (this.a.H != paramColorStateList)
    {
      this.a.H = paramColorStateList;
      DrawableCompat.setTintList(this.c, paramColorStateList);
    }
  }

  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.a.K = true;
    if (this.a.I != paramMode)
    {
      this.a.I = paramMode;
      DrawableCompat.setTintMode(this.c, paramMode);
    }
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.d != null)
      this.d.setVisible(paramBoolean1, paramBoolean2);
    if (this.c != null)
      this.c.setVisible(paramBoolean1, paramBoolean2);
    return bool;
  }

  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.c) && (getCallback() != null))
      getCallback().unscheduleDrawable(this, paramRunnable);
  }

  static class a
    implements Drawable.Callback
  {
    private Drawable.Callback a;

    public Drawable.Callback a()
    {
      Drawable.Callback localCallback = this.a;
      this.a = null;
      return localCallback;
    }

    public a a(Drawable.Callback paramCallback)
    {
      this.a = paramCallback;
      return this;
    }

    public void invalidateDrawable(Drawable paramDrawable)
    {
    }

    public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      if (this.a != null)
        this.a.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
    }

    public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      if (this.a != null)
        this.a.unscheduleDrawable(paramDrawable, paramRunnable);
    }
  }

  static abstract class b extends Drawable.ConstantState
  {
    boolean A;
    int B;
    int C = 0;
    int D = 0;
    boolean E;
    ColorFilter F;
    boolean G;
    ColorStateList H;
    PorterDuff.Mode I;
    boolean J;
    boolean K;
    final b c;
    Resources d;
    int e = 160;
    int f;
    int g;
    SparseArray<Drawable.ConstantState> h;
    Drawable[] i;
    int j;
    boolean k = false;
    boolean l;
    Rect m;
    boolean n = false;
    boolean o;
    int p;
    int q;
    int r;
    int s;
    boolean t;
    int u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z = true;

    b(b paramb, b paramb1, Resources paramResources)
    {
      this.c = paramb1;
      Resources localResources;
      int i2;
      label67: Drawable[] arrayOfDrawable;
      if (paramResources != null)
      {
        localResources = paramResources;
        this.d = localResources;
        if (paramb == null)
          break label457;
        i2 = paramb.e;
        this.e = b.a(paramResources, i2);
        if (paramb == null)
          break label496;
        this.f = paramb.f;
        this.g = paramb.g;
        this.x = true;
        this.y = true;
        this.k = paramb.k;
        this.n = paramb.n;
        this.z = paramb.z;
        this.A = paramb.A;
        this.B = paramb.B;
        this.C = paramb.C;
        this.D = paramb.D;
        this.E = paramb.E;
        this.F = paramb.F;
        this.G = paramb.G;
        this.H = paramb.H;
        this.I = paramb.I;
        this.J = paramb.J;
        this.K = paramb.K;
        if (paramb.e == this.e)
        {
          if (paramb.l)
          {
            this.m = new Rect(paramb.m);
            this.l = true;
          }
          if (paramb.o)
          {
            this.p = paramb.p;
            this.q = paramb.q;
            this.r = paramb.r;
            this.s = paramb.s;
            this.o = true;
          }
        }
        if (paramb.t)
        {
          this.u = paramb.u;
          this.t = true;
        }
        if (paramb.v)
        {
          this.w = paramb.w;
          this.v = true;
        }
        arrayOfDrawable = paramb.i;
        this.i = new Drawable[arrayOfDrawable.length];
        this.j = paramb.j;
        SparseArray localSparseArray = paramb.h;
        if (localSparseArray == null)
          break label463;
        this.h = localSparseArray.clone();
        label385: int i3 = this.j;
        label391: if (i1 >= i3)
          return;
        if (arrayOfDrawable[i1] != null)
        {
          Drawable.ConstantState localConstantState = arrayOfDrawable[i1].getConstantState();
          if (localConstantState == null)
            break label481;
          this.h.put(i1, localConstantState);
        }
      }
      while (true)
      {
        i1++;
        break label391;
        if (paramb != null)
        {
          localResources = paramb.d;
          break;
        }
        localResources = null;
        break;
        label457: i2 = 0;
        break label67;
        label463: this.h = new SparseArray(this.j);
        break label385;
        label481: this.i[i1] = arrayOfDrawable[i1];
      }
      label496: this.i = new Drawable[10];
      this.j = 0;
    }

    private Drawable b(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23)
        paramDrawable.setLayoutDirection(this.B);
      Drawable localDrawable = paramDrawable.mutate();
      localDrawable.setCallback(this.c);
      return localDrawable;
    }

    private void o()
    {
      if (this.h != null)
      {
        int i1 = this.h.size();
        for (int i2 = 0; i2 < i1; i2++)
        {
          int i3 = this.h.keyAt(i2);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.h.valueAt(i2);
          this.i[i3] = b(localConstantState.newDrawable(this.d));
        }
        this.h = null;
      }
    }

    public final int a(Drawable paramDrawable)
    {
      int i1 = this.j;
      if (i1 >= this.i.length)
        e(i1, i1 + 10);
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.c);
      this.i[i1] = paramDrawable;
      this.j = (1 + this.j);
      this.g |= paramDrawable.getChangingConfigurations();
      b();
      this.m = null;
      this.l = false;
      this.o = false;
      this.x = false;
      return i1;
    }

    void a()
    {
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      for (int i2 = 0; i2 < i1; i2++)
        if (arrayOfDrawable[i2] != null)
          arrayOfDrawable[i2].mutate();
      this.A = true;
    }

    final void a(Resources.Theme paramTheme)
    {
      if (paramTheme != null)
      {
        o();
        int i1 = this.j;
        Drawable[] arrayOfDrawable = this.i;
        for (int i2 = 0; i2 < i1; i2++)
          if ((arrayOfDrawable[i2] != null) && (arrayOfDrawable[i2].canApplyTheme()))
          {
            arrayOfDrawable[i2].applyTheme(paramTheme);
            this.g |= arrayOfDrawable[i2].getChangingConfigurations();
          }
        a(paramTheme.getResources());
      }
    }

    final void a(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.d = paramResources;
        int i1 = b.a(paramResources, this.e);
        int i2 = this.e;
        this.e = i1;
        if (i2 != i1)
        {
          this.o = false;
          this.l = false;
        }
      }
    }

    public final void a(boolean paramBoolean)
    {
      this.k = paramBoolean;
    }

    public final Drawable b(int paramInt)
    {
      Drawable localDrawable = this.i[paramInt];
      if (localDrawable != null);
      do
      {
        return localDrawable;
        if (this.h == null)
          break;
        int i1 = this.h.indexOfKey(paramInt);
        if (i1 < 0)
          break;
        localDrawable = b(((Drawable.ConstantState)this.h.valueAt(i1)).newDrawable(this.d));
        this.i[paramInt] = localDrawable;
        this.h.removeAt(i1);
      }
      while (this.h.size() != 0);
      this.h = null;
      return localDrawable;
      return null;
    }

    void b()
    {
      this.t = false;
      this.v = false;
    }

    public final void b(boolean paramBoolean)
    {
      this.n = paramBoolean;
    }

    final int c()
    {
      return this.i.length;
    }

    public final void c(int paramInt)
    {
      this.C = paramInt;
    }

    public boolean canApplyTheme()
    {
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      for (int i2 = 0; i2 < i1; i2++)
      {
        Drawable localDrawable = arrayOfDrawable[i2];
        if (localDrawable != null)
        {
          if (localDrawable.canApplyTheme())
            return true;
        }
        else
        {
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.h.get(i2);
          if ((localConstantState != null) && (localConstantState.canApplyTheme()))
            return true;
        }
      }
      return false;
    }

    public final int d()
    {
      return this.j;
    }

    public final void d(int paramInt)
    {
      this.D = paramInt;
    }

    final boolean d(int paramInt1, int paramInt2)
    {
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      int i2 = 0;
      boolean bool1 = false;
      if (i2 < i1)
      {
        if (arrayOfDrawable[i2] == null)
          break label74;
        if (Build.VERSION.SDK_INT < 23)
          break label81;
      }
      label74: label81: for (boolean bool2 = arrayOfDrawable[i2].setLayoutDirection(paramInt1); ; bool2 = false)
      {
        if (i2 == paramInt2);
        while (true)
        {
          i2++;
          bool1 = bool2;
          break;
          this.B = paramInt1;
          return bool1;
          bool2 = bool1;
        }
      }
    }

    public final Rect e()
    {
      Rect localRect1 = null;
      if (this.k)
        return null;
      if ((this.m != null) || (this.l))
        return this.m;
      o();
      Rect localRect2 = new Rect();
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      for (int i2 = 0; i2 < i1; i2++)
        if (arrayOfDrawable[i2].getPadding(localRect2))
        {
          if (localRect1 == null)
            localRect1 = new Rect(0, 0, 0, 0);
          if (localRect2.left > localRect1.left)
            localRect1.left = localRect2.left;
          if (localRect2.top > localRect1.top)
            localRect1.top = localRect2.top;
          if (localRect2.right > localRect1.right)
            localRect1.right = localRect2.right;
          if (localRect2.bottom > localRect1.bottom)
            localRect1.bottom = localRect2.bottom;
        }
      this.l = true;
      this.m = localRect1;
      return localRect1;
    }

    public void e(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.i, 0, arrayOfDrawable, 0, paramInt1);
      this.i = arrayOfDrawable;
    }

    public final boolean f()
    {
      return this.n;
    }

    public final int g()
    {
      if (!this.o)
        k();
      return this.p;
    }

    public int getChangingConfigurations()
    {
      return this.f | this.g;
    }

    public final int h()
    {
      if (!this.o)
        k();
      return this.q;
    }

    public final int i()
    {
      if (!this.o)
        k();
      return this.r;
    }

    public final int j()
    {
      if (!this.o)
        k();
      return this.s;
    }

    protected void k()
    {
      int i1 = 0;
      this.o = true;
      o();
      int i2 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      this.q = -1;
      this.p = -1;
      this.s = 0;
      this.r = 0;
      while (i1 < i2)
      {
        Drawable localDrawable = arrayOfDrawable[i1];
        int i3 = localDrawable.getIntrinsicWidth();
        if (i3 > this.p)
          this.p = i3;
        int i4 = localDrawable.getIntrinsicHeight();
        if (i4 > this.q)
          this.q = i4;
        int i5 = localDrawable.getMinimumWidth();
        if (i5 > this.r)
          this.r = i5;
        int i6 = localDrawable.getMinimumHeight();
        if (i6 > this.s)
          this.s = i6;
        i1++;
      }
    }

    public final int l()
    {
      if (this.t)
        return this.u;
      o();
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      if (i1 > 0);
      for (int i2 = arrayOfDrawable[0].getOpacity(); ; i2 = -2)
      {
        int i3 = 1;
        while (i3 < i1)
        {
          int i4 = Drawable.resolveOpacity(i2, arrayOfDrawable[i3].getOpacity());
          i3++;
          i2 = i4;
        }
      }
      this.u = i2;
      this.t = true;
      return i2;
    }

    public final boolean m()
    {
      if (this.v)
        return this.w;
      o();
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      for (int i2 = 0; ; i2++)
      {
        boolean bool = false;
        if (i2 < i1)
        {
          if (arrayOfDrawable[i2].isStateful())
            bool = true;
        }
        else
        {
          this.w = bool;
          this.v = true;
          return bool;
        }
      }
    }

    public boolean n()
    {
      while (true)
      {
        int i2;
        try
        {
          if (this.x)
          {
            bool = this.y;
            return bool;
          }
          o();
          this.x = true;
          int i1 = this.j;
          Drawable[] arrayOfDrawable = this.i;
          i2 = 0;
          if (i2 >= i1)
            break label80;
          if (arrayOfDrawable[i2].getConstantState() == null)
          {
            this.y = false;
            bool = false;
            continue;
          }
        }
        finally
        {
        }
        i2++;
        continue;
        label80: this.y = true;
        boolean bool = true;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.b.a.b
 * JD-Core Version:    0.6.2
 */