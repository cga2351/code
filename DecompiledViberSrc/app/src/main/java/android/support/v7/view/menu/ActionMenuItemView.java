package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ForwardingListener;
import android.support.v7.widget.TooltipCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

public class ActionMenuItemView extends AppCompatTextView
  implements p.a, ActionMenuView.ActionMenuChildView, View.OnClickListener
{
  j a;
  h.b b;
  b c;
  private CharSequence d;
  private Drawable e;
  private ForwardingListener f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private int k;

  public ActionMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.g = c();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMenuItemView, paramInt, 0);
    this.i = localTypedArray.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
    localTypedArray.recycle();
    this.k = ((int)(0.5F + 32.0F * localResources.getDisplayMetrics().density));
    setOnClickListener(this);
    this.j = -1;
    setSaveEnabled(false);
  }

  private boolean c()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int m = localConfiguration.screenWidthDp;
    int n = localConfiguration.screenHeightDp;
    return (m >= 480) || ((m >= 640) && (n >= 480)) || (localConfiguration.orientation == 2);
  }

  private void d()
  {
    int m;
    label57: CharSequence localCharSequence1;
    label71: CharSequence localCharSequence2;
    CharSequence localCharSequence5;
    label101: label107: CharSequence localCharSequence3;
    CharSequence localCharSequence4;
    if (!TextUtils.isEmpty(this.d))
    {
      m = 1;
      if (this.e != null)
      {
        boolean bool1 = this.a.l();
        n = 0;
        if (!bool1)
          break label57;
        if (!this.g)
        {
          boolean bool2 = this.h;
          n = 0;
          if (!bool2)
            break label57;
        }
      }
      int n = 1;
      int i1 = m & n;
      if (i1 == 0)
        break label143;
      localCharSequence1 = this.d;
      setText(localCharSequence1);
      localCharSequence2 = this.a.getContentDescription();
      if (!TextUtils.isEmpty(localCharSequence2))
        break label161;
      if (i1 == 0)
        break label149;
      localCharSequence5 = null;
      setContentDescription(localCharSequence5);
      localCharSequence3 = this.a.getTooltipText();
      if (!TextUtils.isEmpty(localCharSequence3))
        break label182;
      localCharSequence4 = null;
      if (i1 == 0)
        break label170;
    }
    while (true)
    {
      TooltipCompat.setTooltipText(this, localCharSequence4);
      return;
      m = 0;
      break;
      label143: localCharSequence1 = null;
      break label71;
      label149: localCharSequence5 = this.a.getTitle();
      break label101;
      label161: setContentDescription(localCharSequence2);
      break label107;
      label170: localCharSequence4 = this.a.getTitle();
    }
    label182: TooltipCompat.setTooltipText(this, localCharSequence3);
  }

  public void a(j paramj, int paramInt)
  {
    this.a = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible());
    for (int m = 0; ; m = 8)
    {
      setVisibility(m);
      setEnabled(paramj.isEnabled());
      if ((paramj.hasSubMenu()) && (this.f == null))
        this.f = new a();
      return;
    }
  }

  public boolean a()
  {
    return true;
  }

  public boolean b()
  {
    return !TextUtils.isEmpty(getText());
  }

  public j getItemData()
  {
    return this.a;
  }

  public boolean needsDividerAfter()
  {
    return b();
  }

  public boolean needsDividerBefore()
  {
    return (b()) && (this.a.getIcon() == null);
  }

  public void onClick(View paramView)
  {
    if (this.b != null)
      this.b.invokeItem(this.a);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.g = c();
    d();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = b();
    if ((bool) && (this.j >= 0))
      super.setPadding(this.j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i1 = getMeasuredWidth();
    if (m == -2147483648);
    for (int i2 = Math.min(n, this.i); ; i2 = this.i)
    {
      if ((m != 1073741824) && (this.i > 0) && (i1 < i2))
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), paramInt2);
      if ((!bool) && (this.e != null))
        super.setPadding((getMeasuredWidth() - this.e.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      return;
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(null);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a.hasSubMenu()) && (this.f != null) && (this.f.onTouch(this, paramMotionEvent)))
      return true;
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setCheckable(boolean paramBoolean)
  {
  }

  public void setChecked(boolean paramBoolean)
  {
  }

  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      if (this.a != null)
        this.a.g();
    }
  }

  public void setIcon(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int n = paramDrawable.getIntrinsicHeight();
      if (m > this.k)
      {
        float f2 = this.k / m;
        m = this.k;
        n = (int)(f2 * n);
      }
      if (n > this.k)
      {
        float f1 = this.k / n;
        n = this.k;
        m = (int)(f1 * m);
      }
      paramDrawable.setBounds(0, 0, m, n);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    d();
  }

  public void setItemInvoker(h.b paramb)
  {
    this.b = paramb;
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setPopupCallback(b paramb)
  {
    this.c = paramb;
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    d();
  }

  private class a extends ForwardingListener
  {
    public a()
    {
      super();
    }

    public s getPopup()
    {
      if (ActionMenuItemView.this.c != null)
        return ActionMenuItemView.this.c.getPopup();
      return null;
    }

    protected boolean onForwardingStarted()
    {
      h.b localb = ActionMenuItemView.this.b;
      boolean bool1 = false;
      if (localb != null)
      {
        boolean bool2 = ActionMenuItemView.this.b.invokeItem(ActionMenuItemView.this.a);
        bool1 = false;
        if (bool2)
        {
          s locals = getPopup();
          bool1 = false;
          if (locals != null)
          {
            boolean bool3 = locals.isShowing();
            bool1 = false;
            if (bool3)
              bool1 = true;
          }
        }
      }
      return bool1;
    }
  }

  public static abstract class b
  {
    public abstract s getPopup();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView
 * JD-Core Version:    0.6.2
 */