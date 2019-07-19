package com.slidingmenu.lib;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.viber.dexshared.Logger;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;
import java.lang.reflect.Method;

public class SlidingMenu extends RelativeLayout
{
  private static final Logger a = ViberEnv.getLogger();
  private boolean b = false;
  private a c;
  private c d;
  private d e;
  private b f;
  private f g;
  private g h;
  private Handler i = new Handler();

  public SlidingMenu(Activity paramActivity, int paramInt)
  {
    this(paramActivity, null);
    a(paramActivity, paramInt);
  }

  public SlidingMenu(Context paramContext)
  {
    this(paramContext, null);
  }

  public SlidingMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SlidingMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    this.d = new c(paramContext);
    addView(this.d, localLayoutParams1);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    this.c = new a(paramContext);
    addView(this.c, localLayoutParams2);
    this.c.setCustomViewBehind(this.d);
    this.d.setCustomViewAbove(this.c);
    this.c.setOnPageChangeListener(new a.a()
    {
      public void a(int paramAnonymousInt)
      {
        if ((paramAnonymousInt == 0) && (SlidingMenu.a(SlidingMenu.this) != null))
          SlidingMenu.a(SlidingMenu.this).a();
        while (true)
        {
          if (SlidingMenu.c(SlidingMenu.this) != null)
            SlidingMenu.c(SlidingMenu.this).a(paramAnonymousInt);
          return;
          if ((paramAnonymousInt == 1) && (SlidingMenu.b(SlidingMenu.this) != null))
            SlidingMenu.b(SlidingMenu.this).a();
        }
      }

      public void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
      }
    });
    this.c.setDragListener(new g()
    {
      public void a(int paramAnonymousInt)
      {
        if (SlidingMenu.d(SlidingMenu.this) != null)
          SlidingMenu.d(SlidingMenu.this).a(paramAnonymousInt);
      }
    });
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SlidingMenu);
    setMode(localTypedArray.getInt(R.styleable.SlidingMenu_mode, 0));
    int j = localTypedArray.getResourceId(R.styleable.SlidingMenu_viewAbove, -1);
    if (j != -1)
    {
      setContent(j);
      int k = localTypedArray.getResourceId(R.styleable.SlidingMenu_viewBehind, -1);
      if (k == -1)
        break label299;
      setMenu(k);
    }
    int m;
    int n;
    while (true)
    {
      setTouchModeAbove(localTypedArray.getInt(R.styleable.SlidingMenu_touchModeAbove, 0));
      setTouchModeBehind(localTypedArray.getInt(R.styleable.SlidingMenu_touchModeBehind, 0));
      m = (int)localTypedArray.getDimension(R.styleable.SlidingMenu_behindOffset, -1.0F);
      n = (int)localTypedArray.getDimension(R.styleable.SlidingMenu_behindWidth, -1.0F);
      if ((m == -1) || (n == -1))
        break label314;
      throw new IllegalStateException("Cannot set both behindOffset and behindWidth for a SlidingMenu");
      setContent(new FrameLayout(paramContext));
      break;
      label299: setMenu(new FrameLayout(paramContext));
    }
    label314: if (m != -1)
      setBehindOffset(m);
    while (true)
    {
      setBehindScrollScale(localTypedArray.getFloat(R.styleable.SlidingMenu_behindScrollScale, 0.33F));
      int i1 = localTypedArray.getResourceId(R.styleable.SlidingMenu_shadowDrawable, -1);
      if (i1 != -1)
        setShadowDrawable(i1);
      setShadowWidth((int)localTypedArray.getDimension(R.styleable.SlidingMenu_shadowWidth, 0.0F));
      setFadeEnabled(localTypedArray.getBoolean(R.styleable.SlidingMenu_fadeEnabled, true));
      setFadeDegree(localTypedArray.getFloat(R.styleable.SlidingMenu_fadeDegree, 0.33F));
      setSelectorEnabled(localTypedArray.getBoolean(R.styleable.SlidingMenu_selectorEnabled, false));
      int i2 = localTypedArray.getResourceId(R.styleable.SlidingMenu_selectorDrawable, -1);
      if (i2 != -1)
        setSelectorDrawable(i2);
      localTypedArray.recycle();
      return;
      if (n != -1)
        setBehindWidth(n);
      else
        setBehindOffset(0);
    }
  }

  public void a()
  {
    a(true);
  }

  @TargetApi(11)
  public void a(float paramFloat)
  {
    if (Build.VERSION.SDK_INT < 11)
      return;
    if ((dj.b()) && (paramFloat > 0.0F) && (paramFloat < 1.0F));
    for (int j = 1; ; j = 0)
    {
      final int k = 0;
      if (j != 0)
        k = 2;
      if (k == getContent().getLayerType())
        break;
      this.i.post(new Runnable()
      {
        public void run()
        {
          boolean bool = true;
          Logger localLogger = SlidingMenu.i();
          Object[] arrayOfObject = new Object[bool];
          if (k == 2);
          while (true)
          {
            arrayOfObject[0] = Boolean.valueOf(bool);
            localLogger.a("changing layerType. hardware\\? ?", arrayOfObject);
            SlidingMenu.this.getContent().setLayerType(k, null);
            SlidingMenu.this.getMenu().setLayerType(k, null);
            if (SlidingMenu.this.getSecondaryMenu() != null)
              SlidingMenu.this.getSecondaryMenu().setLayerType(k, null);
            return;
            bool = false;
          }
        }
      });
      return;
    }
  }

  public void a(Activity paramActivity, int paramInt)
  {
    a(paramActivity, paramInt, false);
  }

  public void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if ((paramInt != 0) && (paramInt != 1))
      throw new IllegalArgumentException("slideStyle must be either SLIDING_WINDOW or SLIDING_CONTENT");
    if (getParent() != null)
      throw new IllegalStateException("This SlidingMenu appears to already be attached");
    TypedArray localTypedArray = paramActivity.getTheme().obtainStyledAttributes(new int[] { 16842836 });
    int j = localTypedArray.getResourceId(0, 0);
    localTypedArray.recycle();
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    }
    View localView;
    do
    {
      return;
      this.b = false;
      ViewGroup localViewGroup2 = (ViewGroup)paramActivity.getWindow().getDecorView();
      ViewGroup localViewGroup3 = (ViewGroup)localViewGroup2.getChildAt(0);
      localViewGroup3.setBackgroundResource(j);
      localViewGroup2.removeView(localViewGroup3);
      localViewGroup2.addView(this);
      setContent(localViewGroup3);
      return;
      this.b = paramBoolean;
      ViewGroup localViewGroup1 = (ViewGroup)paramActivity.findViewById(16908290);
      localView = localViewGroup1.getChildAt(0);
      localViewGroup1.removeView(localView);
      localViewGroup1.addView(this);
      setContent(localView);
    }
    while (localView.getBackground() != null);
    localView.setBackgroundResource(j);
  }

  public void a(View paramView)
  {
    this.c.a(paramView);
  }

  public void a(boolean paramBoolean)
  {
    this.c.a(0, paramBoolean);
  }

  public void b()
  {
    b(true);
  }

  public void b(View paramView)
  {
    this.c.b(paramView);
  }

  public void b(boolean paramBoolean)
  {
    this.c.a(2, paramBoolean);
  }

  public void c()
  {
    c(true);
  }

  public void c(boolean paramBoolean)
  {
    this.c.a(1, paramBoolean);
  }

  public boolean d()
  {
    return (this.c.getCurrentItem() == 0) || (this.c.getCurrentItem() == 2);
  }

  public boolean e()
  {
    return this.c.getCurrentItem() == 2;
  }

  public boolean f()
  {
    int j = this.d.getMode();
    return ((j == 0) || (j == 2)) && (this.c.getCurrentItem() == 0);
  }

  @SuppressLint({"NewApi"})
  protected boolean fitSystemWindows(Rect paramRect)
  {
    int j = paramRect.left;
    int k = paramRect.right;
    int m = paramRect.top;
    int n = paramRect.bottom;
    if (!this.b)
    {
      a.a("setting padding!", new Object[0]);
      setPadding(j, m, k, n);
    }
    return true;
  }

  public boolean g()
  {
    int j = this.d.getMode();
    return ((j == 1) || (j == 2)) && (this.c.getCurrentItem() == 2);
  }

  public int getBehindOffset()
  {
    return this.d.getWidthOffset();
  }

  public float getBehindScrollScale()
  {
    return this.d.getScrollScale();
  }

  public View getContent()
  {
    return this.c.getContent();
  }

  public View getMenu()
  {
    return this.d.getContent();
  }

  public int getMode()
  {
    return this.d.getMode();
  }

  public View getSecondaryMenu()
  {
    return this.d.getSecondaryContent();
  }

  public int getTouchModeAbove()
  {
    return this.c.getTouchMode();
  }

  public int getTouchmodeMarginThreshold()
  {
    return this.d.getMarginThreshold();
  }

  public void h()
  {
    this.c.b();
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(((SavedState)paramParcelable).getSuperState());
  }

  protected Parcelable onSaveInstanceState()
  {
    return new SavedState(super.onSaveInstanceState(), this.c.getCurrentItem());
  }

  public void setAboveOffset(int paramInt)
  {
    this.c.setAboveOffset(paramInt);
  }

  public void setAboveOffsetRes(int paramInt)
  {
    setAboveOffset((int)getContext().getResources().getDimension(paramInt));
  }

  public void setBehindCanvasTransformer(a parama)
  {
    this.d.setCanvasTransformer(parama);
  }

  public void setBehindOffset(int paramInt)
  {
    this.d.setWidthOffset(paramInt);
  }

  public void setBehindOffsetRes(int paramInt)
  {
    setBehindOffset((int)getContext().getResources().getDimension(paramInt));
  }

  public void setBehindScrollScale(float paramFloat)
  {
    if ((paramFloat < 0.0F) && (paramFloat > 1.0F))
      throw new IllegalStateException("ScrollScale must be between 0 and 1");
    this.d.setScrollScale(paramFloat);
  }

  public void setBehindWidth(int paramInt)
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    try
    {
      Class[] arrayOfClass = { Point.class };
      Point localPoint = new Point();
      Display.class.getMethod("getSize", arrayOfClass).invoke(localDisplay, new Object[] { localPoint });
      j = localPoint.x;
      setBehindOffset(j - paramInt);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        int j = localDisplay.getWidth();
    }
  }

  public void setBehindWidthRes(int paramInt)
  {
    setBehindWidth((int)getContext().getResources().getDimension(paramInt));
  }

  public void setContent(int paramInt)
  {
    setContent(LayoutInflater.from(getContext()).inflate(paramInt, null));
  }

  public void setContent(View paramView)
  {
    this.c.setContent(paramView);
    c();
  }

  public void setContentWithoutShowing(int paramInt)
  {
    this.c.setContent(LayoutInflater.from(getContext()).inflate(paramInt, null));
  }

  public void setFadeDegree(float paramFloat)
  {
    this.d.setFadeDegree(paramFloat);
  }

  public void setFadeEnabled(boolean paramBoolean)
  {
    this.d.setFadeEnabled(paramBoolean);
  }

  public void setMenu(int paramInt)
  {
    setMenu(LayoutInflater.from(getContext()).inflate(paramInt, this.d, false));
  }

  public void setMenu(View paramView)
  {
    this.d.setContent(paramView);
  }

  public void setMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
      throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
    this.d.setMode(paramInt);
  }

  public void setOnCloseListener(b paramb)
  {
    this.f = paramb;
  }

  public void setOnClosedListener(c paramc)
  {
    this.c.setOnClosedListener(paramc);
  }

  public void setOnOpenListener(d paramd)
  {
    this.e = paramd;
  }

  public void setOnOpenedListener(e parame)
  {
    this.c.setOnOpenedListener(parame);
  }

  public void setOnPageSelectedListener(f paramf)
  {
    this.g = paramf;
  }

  public void setOnStartDragListener(g paramg)
  {
    this.h = paramg;
  }

  public void setRightSwipeInitialAvailableArea(float paramFloat)
  {
    this.c.setRightSwipeInitialAvailableArea(paramFloat);
  }

  public void setSecondaryMenu(int paramInt)
  {
    setSecondaryMenu(LayoutInflater.from(getContext()).inflate(paramInt, this.d, false));
  }

  public void setSecondaryMenu(View paramView)
  {
    this.d.setSecondaryContent(paramView);
  }

  public void setSecondaryShadowDrawable(int paramInt)
  {
    setSecondaryShadowDrawable(getContext().getResources().getDrawable(paramInt));
  }

  public void setSecondaryShadowDrawable(Drawable paramDrawable)
  {
    this.d.setSecondaryShadowDrawable(paramDrawable);
  }

  public void setSelectedView(View paramView)
  {
    this.d.setSelectedView(paramView);
  }

  public void setSelectorBitmap(Bitmap paramBitmap)
  {
    this.d.setSelectorBitmap(paramBitmap);
  }

  public void setSelectorDrawable(int paramInt)
  {
    this.d.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), paramInt));
  }

  public void setSelectorEnabled(boolean paramBoolean)
  {
    this.d.setSelectorEnabled(true);
  }

  public void setShadowDrawable(int paramInt)
  {
    setShadowDrawable(getContext().getResources().getDrawable(paramInt));
  }

  public void setShadowDrawable(Drawable paramDrawable)
  {
    this.d.setShadowDrawable(paramDrawable);
  }

  public void setShadowWidth(int paramInt)
  {
    this.d.setShadowWidth(paramInt);
  }

  public void setShadowWidthRes(int paramInt)
  {
    setShadowWidth((int)getResources().getDimension(paramInt));
  }

  public void setSlidingEnabled(boolean paramBoolean)
  {
    this.c.setSlidingEnabled(paramBoolean);
  }

  public void setStatic(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setSlidingEnabled(false);
      this.c.setCustomViewBehind(null);
      this.c.setCurrentItem(1);
      return;
    }
    this.c.setCurrentItem(1);
    this.c.setCustomViewBehind(this.d);
    setSlidingEnabled(true);
  }

  public void setTouchModeAbove(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0) && (paramInt != 2))
      throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
    this.c.setTouchMode(paramInt);
  }

  public void setTouchModeBehind(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0) && (paramInt != 2))
      throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
    this.d.setTouchMode(paramInt);
  }

  public void setTouchmodeMarginThreshold(int paramInt)
  {
    this.d.setMarginThreshold(paramInt);
  }

  public static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public SlidingMenu.SavedState a(Parcel paramAnonymousParcel)
      {
        return new SlidingMenu.SavedState(paramAnonymousParcel, null);
      }

      public SlidingMenu.SavedState[] a(int paramAnonymousInt)
      {
        return new SlidingMenu.SavedState[paramAnonymousInt];
      }
    };
    private final int mItem;

    private SavedState(Parcel paramParcel)
    {
      super();
      this.mItem = paramParcel.readInt();
    }

    public SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.mItem = paramInt;
    }

    public int getItem()
    {
      return this.mItem;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mItem);
    }
  }

  public static abstract interface a
  {
    public abstract void a(Canvas paramCanvas, float paramFloat);
  }

  public static abstract interface b
  {
    public abstract void a();
  }

  public static abstract interface c
  {
    public abstract void a();
  }

  public static abstract interface d
  {
    public abstract void a();
  }

  public static abstract interface e
  {
    public abstract void b();
  }

  public static abstract interface f
  {
    public abstract void a(int paramInt);
  }

  public static abstract interface g
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.slidingmenu.lib.SlidingMenu
 * JD-Core Version:    0.6.2
 */