package com.viber.voip.messages.ui.expanel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.settings.d.r;
import com.viber.voip.util.ParcelableSparseArray;
import com.viber.voip.util.bl;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.List;

public class ExpandablePanelLayout extends FrameLayout
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnPreDrawListener
{
  public static int a;
  public static boolean b;
  private static final Logger d = ViberEnv.getLogger();
  private static int g = 0;
  private static int h = 0;
  public boolean c;
  private Rect e = new Rect();
  private Rect f;
  private boolean i = true;
  private boolean j = true;
  private boolean k = true;
  private int l = 0;
  private int m = 0;
  private int n = -1;
  private int o;
  private int p;
  private boolean q = false;
  private int r;
  private b s;
  private c t;
  private SparseArrayCompat<View> u;
  private ParcelableSparseArray<HeightSpec> v = new ParcelableSparseArray();
  private View w;
  private Runnable x = new Runnable()
  {
    public void run()
    {
      if (ExpandablePanelLayout.a(ExpandablePanelLayout.this) != null)
        ExpandablePanelLayout.a(ExpandablePanelLayout.this).a(ExpandablePanelLayout.b(ExpandablePanelLayout.this));
      ExpandablePanelLayout.c(ExpandablePanelLayout.this);
    }
  };
  private final Runnable y = new Runnable()
  {
    public void run()
    {
      ExpandablePanelLayout.a(ExpandablePanelLayout.this, 8);
      ExpandablePanelLayout.e(ExpandablePanelLayout.this);
      ExpandablePanelLayout.a(ExpandablePanelLayout.this).b(ExpandablePanelLayout.b(ExpandablePanelLayout.this));
    }
  };
  private float z = 0.0F;

  public ExpandablePanelLayout(Context paramContext)
  {
    super(paramContext);
    f();
  }

  public ExpandablePanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }

  public ExpandablePanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }

  private void a(final View paramView)
  {
    if (this.j)
    {
      Animation localAnimation = AnimationUtils.makeInChildBottomAnimation(getContext());
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          paramView.postDelayed(ExpandablePanelLayout.d(ExpandablePanelLayout.this), 50L);
        }

        public void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
        }

        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
        }
      });
      paramView.startAnimation(localAnimation);
      return;
    }
    this.s.a(this.n);
    h();
  }

  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      requestLayout();
      return;
      if ((3 == this.m) || (1 == this.m))
      {
        d(-1);
      }
      else
      {
        this.m = paramInt;
        g();
        continue;
        this.m = 2;
        if (-1 != this.n)
          i();
        else
          g();
      }
    }
  }

  private void d(int paramInt)
  {
    if (this.l != 0);
    View localView2;
    do
    {
      return;
      if (-1 != paramInt)
        break;
      paramInt = this.n;
      View localView1 = (View)this.u.get(paramInt);
      localView2 = this.s.a(paramInt, localView1);
    }
    while (localView2 == null);
    this.u.put(paramInt, localView2);
    ViewParent localViewParent = localView2.getParent();
    if ((localViewParent == null) || (this != localViewParent))
    {
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
        ((ViewGroup)localViewParent).removeView(localView2);
      addView(localView2);
      localView2.requestLayout();
    }
    int i1;
    if (localView2 != this.w)
    {
      i1 = 1;
      label114: if (i1 != 0)
      {
        dj.c(this.w, 8);
        this.w = localView2;
        dj.c(localView2, 0);
      }
      if (1 != this.m)
        break label180;
      a(localView2);
    }
    while (true)
    {
      this.m = 3;
      setPanelVisibility(0);
      g();
      return;
      this.n = paramInt;
      break;
      i1 = 0;
      break label114;
      label180: removeCallbacks(this.x);
      postDelayed(this.x, 100L);
    }
  }

  private void f()
  {
    if (isInEditMode())
      return;
    Resources localResources = getResources();
    if (getRootView().getHeight() > getRootView().getWidth());
    for (boolean bool = true; ; bool = false)
    {
      this.i = bool;
      a = localResources.getDimensionPixelOffset(R.dimen.min_non_keyboard_menu_height);
      if (g == 0)
      {
        g = d.r.f.d();
        if (g < 0)
          g = 0;
      }
      if (h != 0)
        break;
      h = d.r.g.d();
      if (h >= 0)
        break;
      h = 0;
      return;
    }
  }

  private void g()
  {
    if ((this.t != null) && (this.s != null))
      this.t.a(this.m, getPanelId(), this.w);
  }

  private void h()
  {
    if ((this.t != null) && (this.s != null))
      this.t.a(getPanelId());
  }

  private void i()
  {
    post(this.y);
  }

  private void setPanelVisibility(int paramInt)
  {
    if (paramInt == 0)
      removeCallbacks(this.y);
    dj.c(this, paramInt);
  }

  public int a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = g;
      if ((i1 >= 0.5D * a) && (i1 <= 1.7D * a))
        break label69;
      i1 = a;
    }
    while (true)
    {
      if ((this.o > 0) && (i1 > this.o))
        i1 = this.o;
      return i1;
      i1 = h;
      break;
      label69: if ((h == 0) && (g == 0))
      {
        g = getLayoutParams().height;
        h = getLayoutParams().height;
      }
    }
  }

  public View a(int paramInt)
  {
    int i1 = this.s.d(paramInt);
    View localView = (View)this.u.get(i1);
    return this.s.a(i1, localView);
  }

  public void a()
  {
    if (this.c);
    do
    {
      return;
      getViewTreeObserver().addOnGlobalLayoutListener(this);
      getViewTreeObserver().addOnPreDrawListener(this);
      this.c = true;
    }
    while ((!b) || (!MessageComposerView.a));
    if (MessageComposerView.b == 2)
    {
      this.l = 2;
      c(this.l);
    }
    b = false;
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    int i1;
    if (this.n == this.s.d(paramInt))
    {
      i1 = 1;
      this.n = this.s.d(paramInt);
      this.j = paramBoolean;
      if ((isShown()) || (this.l != 0))
        break label69;
      b(paramInt, true);
    }
    while (true)
    {
      this.m = 1;
      return;
      i1 = 0;
      break;
      label69: if ((this.l == 0) && (i1 == 0))
        d(this.s.d(paramInt));
    }
  }

  public void a(HeightSpec paramHeightSpec, d paramd)
  {
    int i1 = this.s.d(paramd.a());
    this.v.put(i1, HeightSpec.from(paramHeightSpec, paramd));
  }

  public void b()
  {
    if (!this.c)
      return;
    getViewTreeObserver().removeOnPreDrawListener(this);
    if (a.a())
      getViewTreeObserver().removeOnGlobalLayoutListener(this);
    while (true)
    {
      this.c = false;
      return;
      getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }

  public void b(int paramInt, boolean paramBoolean)
  {
    a((HeightSpec)this.v.get(this.s.d(paramInt)), f.a(paramInt));
    if (paramBoolean);
    for (int i1 = 0; ; i1 = 8)
    {
      setPanelVisibility(i1);
      invalidate();
      requestLayout();
      return;
    }
  }

  public boolean b(int paramInt)
  {
    return (d()) && (paramInt == this.s.c(this.n));
  }

  public void c()
  {
    if (this.m != 0)
    {
      this.m = 0;
      i();
    }
  }

  public boolean d()
  {
    return (getVisibility() == 0) && ((3 == this.m) || (1 == this.m));
  }

  public boolean e()
  {
    return this.l != 0;
  }

  public int getHeightKeyboard()
  {
    return a(this.i);
  }

  public int getPanelId()
  {
    int i1 = -1;
    if (this.n != i1)
      i1 = this.s.c(this.n);
    return i1;
  }

  public int getPanelState()
  {
    return this.m;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.u.clear();
    try
    {
      removeAllViews();
      label16: requestLayout();
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }

  @SuppressLint({"NewApi"})
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }

  public void onGlobalLayout()
  {
    boolean bool1;
    boolean bool2;
    label22: label163: int i1;
    if (!dj.c(getContext()))
    {
      bool1 = true;
      if (bool1 == this.i)
        break label393;
      bool2 = true;
      this.q = bool2;
      this.i = bool1;
      getWindowVisibleDisplayFrame(this.e);
      if ((this.f == null) || (this.f.bottom < this.e.bottom) || (this.q))
        this.f = new Rect(this.e);
      if ((!this.q) && (this.f.right != this.e.right))
        this.f = new Rect(this.e);
      if ((this.i) || (this.p <= 0))
        break label398;
      this.o = (this.f.bottom - this.f.top - this.p);
      i1 = this.f.bottom - this.e.bottom;
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if ((i1 != 96) && (i1 != 192) && (localInputMethodManager.isAcceptingText()))
        break label524;
      this.f = new Rect(this.e);
    }
    label265: label524: for (int i2 = 0; ; i2 = i1)
    {
      int i3 = this.l;
      int i4;
      if (this.i)
      {
        i4 = g;
        label251: if (i2 <= this.r)
          break label414;
        this.l = 1;
        boolean bool3;
        if ((!this.q) && (i3 == this.l))
        {
          int i5 = this.r;
          bool3 = false;
          if (i5 == i2);
        }
        else
        {
          bool3 = true;
        }
        this.q = bool3;
        this.r = i2;
        if (2 == this.l)
        {
          if ((!this.i) || (g == i2))
            break label473;
          this.q = true;
          if (g != i2)
            d.r.f.a(i2);
          g = i2;
        }
        label361: if (this.q)
          if (!this.i)
            break label517;
      }
      while (true)
      {
        c(this.l);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label22;
        label398: this.o = 0;
        break label163;
        i4 = h;
        break label251;
        label414: if (((i2 == this.r) && (i2 != 0)) || ((i4 > 0) && (i2 == i4)))
        {
          this.l = 2;
          break label265;
        }
        if (i2 < this.r)
        {
          this.l = 3;
          break label265;
        }
        this.l = 0;
        break label265;
        label473: if ((this.i) || (h == i2))
          break label361;
        this.q = true;
        if (h != i2)
          d.r.g.a(i2);
        h = i2;
        break label361;
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = HeightSpec.applyTo((HeightSpec)this.v.get(this.n), getContext(), getHeightKeyboard());
    if (i1 > 0)
      getLayoutParams().height = i1;
    super.onMeasure(paramInt1, paramInt2);
    if ((1 == this.m) || ((3 == this.m) && (getMeasuredWidth() != this.z) && (this.l == 0)))
    {
      if (getMeasuredWidth() != this.z)
      {
        for (i2 = 0; i2 < this.u.size(); i2++)
        {
          localView = (View)this.u.valueAt(i2);
          if ((localView != null) && (localView.getParent() == this))
            removeView(localView);
        }
        this.u.clear();
      }
      this.z = getMeasuredWidth();
      d(this.n);
    }
    while ((3 != this.m) || (this.l != 0) || (this.u.size() != 0))
    {
      int i2;
      View localView;
      return;
    }
    d(this.n);
  }

  public boolean onPreDraw()
  {
    if ((!this.q) || (!((View)getParent()).isShown()));
    for (boolean bool = true; ; bool = false)
    {
      if (this.q)
        requestLayout();
      return bool;
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (1 != this.m)
      this.m = localSavedState.mPanelState;
    this.n = localSavedState.mCurrentPosition;
    g = localSavedState.mSoftInputHeightPortrait;
    h = localSavedState.mSoftInputHeightLandscape;
    this.l = localSavedState.mSoftInputState;
    this.r = localSavedState.mTmpHeight;
    this.i = localSavedState.mIsPortrait;
    this.v = localSavedState.mBoundHeight;
    if ((3 == this.m) && (this.n != -1))
      d(this.n);
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.access$602(localSavedState, this.m);
    SavedState.access$702(localSavedState, this.n);
    SavedState.access$802(localSavedState, g);
    SavedState.access$902(localSavedState, h);
    SavedState.access$1002(localSavedState, this.l);
    SavedState.access$1102(localSavedState, this.r);
    SavedState.access$1202(localSavedState, this.i);
    SavedState.access$1302(localSavedState, this.v);
    return localSavedState;
  }

  public void setAdapter(b paramb)
  {
    this.s = paramb;
    this.u = new SparseArrayCompat(paramb.a());
  }

  public void setStateListener(c paramc)
  {
    this.t = paramc;
  }

  public void setTopMargin(int paramInt)
  {
    this.p = paramInt;
  }

  public static class BotKeyboardAbsolutePercentHeightSpec extends ExpandablePanelLayout.HeightSpec
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public ExpandablePanelLayout.BotKeyboardAbsolutePercentHeightSpec a(Parcel paramAnonymousParcel)
      {
        return new ExpandablePanelLayout.BotKeyboardAbsolutePercentHeightSpec(paramAnonymousParcel);
      }

      public ExpandablePanelLayout.BotKeyboardAbsolutePercentHeightSpec[] a(int paramAnonymousInt)
      {
        return new ExpandablePanelLayout.BotKeyboardAbsolutePercentHeightSpec[paramAnonymousInt];
      }
    };
    private final int mScalePercent;

    public BotKeyboardAbsolutePercentHeightSpec(int paramInt)
    {
      this.mScalePercent = paramInt;
    }

    public BotKeyboardAbsolutePercentHeightSpec(Parcel paramParcel)
    {
      super();
      this.mScalePercent = paramParcel.readInt();
    }

    protected int applyTo(Context paramContext, int paramInt)
    {
      return Math.max(bl.a(paramContext, this.mScalePercent), paramInt);
    }

    protected ExpandablePanelLayout.HeightSpec copy()
    {
      return new BotKeyboardAbsolutePercentHeightSpec(this.mScalePercent);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mScalePercent);
    }
  }

  public static class DefaultHeightSpec extends ExpandablePanelLayout.HeightSpec
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public ExpandablePanelLayout.DefaultHeightSpec a(Parcel paramAnonymousParcel)
      {
        return new ExpandablePanelLayout.DefaultHeightSpec(paramAnonymousParcel);
      }

      public ExpandablePanelLayout.DefaultHeightSpec[] a(int paramAnonymousInt)
      {
        return new ExpandablePanelLayout.DefaultHeightSpec[paramAnonymousInt];
      }
    };
    protected final int mLandscapeHeight;
    protected final int mPortraitHeight;

    public DefaultHeightSpec(int paramInt1, int paramInt2)
    {
      this.mPortraitHeight = paramInt1;
      this.mLandscapeHeight = paramInt2;
    }

    protected DefaultHeightSpec(Parcel paramParcel)
    {
      super();
      this.mPortraitHeight = paramParcel.readInt();
      this.mLandscapeHeight = paramParcel.readInt();
    }

    protected int applyTo(Context paramContext, int paramInt)
    {
      if (!dj.c(paramContext));
      for (int i = this.mPortraitHeight; (i == 0) || (i > paramInt); i = this.mLandscapeHeight)
        return paramInt;
      return i;
    }

    protected ExpandablePanelLayout.HeightSpec copy()
    {
      return new DefaultHeightSpec(this.mPortraitHeight, this.mLandscapeHeight);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mPortraitHeight);
      paramParcel.writeInt(this.mLandscapeHeight);
    }
  }

  public static class HeightSpec
    implements Parcelable
  {
    public static final Parcelable.Creator<HeightSpec> CREATOR = new Parcelable.Creator()
    {
      public ExpandablePanelLayout.HeightSpec a(Parcel paramAnonymousParcel)
      {
        return new ExpandablePanelLayout.HeightSpec(paramAnonymousParcel);
      }

      public ExpandablePanelLayout.HeightSpec[] a(int paramAnonymousInt)
      {
        return new ExpandablePanelLayout.HeightSpec[paramAnonymousInt];
      }
    };
    public static final int UNSPECIFIED_HEIGHT;

    protected HeightSpec()
    {
    }

    protected HeightSpec(Parcel paramParcel)
    {
    }

    public static int applyTo(HeightSpec paramHeightSpec, Context paramContext, int paramInt)
    {
      if (paramHeightSpec == null)
        return paramInt;
      return paramHeightSpec.applyTo(paramContext, paramInt);
    }

    public static HeightSpec from(HeightSpec paramHeightSpec, d paramd)
    {
      if (paramHeightSpec == null)
        return paramd.b();
      return paramHeightSpec.copy();
    }

    protected int applyTo(Context paramContext, int paramInt)
    {
      return paramInt;
    }

    protected HeightSpec copy()
    {
      return new HeightSpec();
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
    }
  }

  private static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ExpandablePanelLayout.SavedState a(Parcel paramAnonymousParcel)
      {
        return new ExpandablePanelLayout.SavedState(paramAnonymousParcel);
      }

      public ExpandablePanelLayout.SavedState[] a(int paramAnonymousInt)
      {
        return new ExpandablePanelLayout.SavedState[paramAnonymousInt];
      }
    };
    private ParcelableSparseArray<ExpandablePanelLayout.HeightSpec> mBoundHeight;
    private int mCurrentPosition;
    private boolean mIsPortrait;
    private int mPanelState;
    private int mSoftInputHeightLandscape = 0;
    private int mSoftInputHeightPortrait = 0;
    private int mSoftInputState;
    private int mTmpHeight;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.mPanelState = paramParcel.readInt();
      this.mCurrentPosition = paramParcel.readInt();
      this.mSoftInputHeightPortrait = paramParcel.readInt();
      this.mSoftInputHeightLandscape = paramParcel.readInt();
      this.mSoftInputState = paramParcel.readInt();
      this.mTmpHeight = paramParcel.readInt();
      int i = paramParcel.readInt();
      boolean bool = false;
      if (i != 0)
        bool = true;
      this.mIsPortrait = bool;
      this.mBoundHeight = ((ParcelableSparseArray)paramParcel.readParcelable(ParcelableSparseArray.class.getClassLoader()));
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public String toString()
    {
      return "SavedState{mPanelState=" + this.mPanelState + ", mCurrentPosition=" + this.mCurrentPosition + ", mSoftInputHeightPortrait=" + this.mSoftInputHeightPortrait + ", mSoftInputHeightLandscape=" + this.mSoftInputHeightLandscape + ", mSoftInputState=" + this.mSoftInputState + ", mTmpHeight=" + this.mTmpHeight + ", mIsPortrait=" + this.mIsPortrait + ", mBoundHeight=" + this.mBoundHeight + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mPanelState);
      paramParcel.writeInt(this.mCurrentPosition);
      paramParcel.writeInt(this.mSoftInputHeightPortrait);
      paramParcel.writeInt(this.mSoftInputHeightLandscape);
      paramParcel.writeInt(this.mSoftInputState);
      paramParcel.writeInt(this.mTmpHeight);
      if (this.mIsPortrait);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.mBoundHeight, 0);
        return;
      }
    }
  }

  public static class a
    implements ExpandablePanelLayout.b
  {
    private ViewGroup a;
    private SparseArrayCompat<View> b = new SparseArrayCompat();
    private List<View> c;

    public a(ViewGroup paramViewGroup)
    {
      this.a = paramViewGroup;
      int i = this.a.getChildCount();
      this.c = new ArrayList(i);
      for (int j = 0; j < i; j++)
      {
        View localView = this.a.getChildAt(j);
        if (-1 != localView.getId())
          this.b.put(localView.getId(), localView);
        this.c.add(localView);
      }
    }

    public int a()
    {
      return this.c.size();
    }

    public View a(int paramInt, View paramView)
    {
      return (View)this.c.get(paramInt);
    }

    public void a(int paramInt)
    {
    }

    public void b(int paramInt)
    {
    }

    public int c(int paramInt)
    {
      return ((View)this.c.get(paramInt)).getId();
    }

    public int d(int paramInt)
    {
      View localView = (View)this.b.get(paramInt);
      if (localView != null)
        return this.c.indexOf(localView);
      return -1;
    }
  }

  public static abstract interface b
  {
    public abstract int a();

    public abstract View a(int paramInt, View paramView);

    public abstract void a(int paramInt);

    public abstract void b(int paramInt);

    public abstract int c(int paramInt);

    public abstract int d(int paramInt);
  }

  public static abstract interface c
  {
    public abstract void a(int paramInt);

    public abstract void a(int paramInt1, int paramInt2, View paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.expanel.ExpandablePanelLayout
 * JD-Core Version:    0.6.2
 */