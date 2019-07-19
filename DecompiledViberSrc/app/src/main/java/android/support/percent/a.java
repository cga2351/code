package android.support.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

@Deprecated
public class a
{
  private final ViewGroup a;

  public a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
      throw new IllegalArgumentException("host must be non-null");
    this.a = paramViewGroup;
  }

  public static a a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PercentLayout_Layout);
    float f1 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0F);
    boolean bool = f1 < -1.0F;
    a locala = null;
    label74: label107: float f10;
    if (bool)
    {
      locala = null;
      if (0 != 0)
        locala.a = f1;
    }
    else
    {
      float f2 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0F);
      if (f2 != -1.0F)
      {
        if (locala == null)
          break label385;
        locala.b = f2;
      }
      float f3 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0F);
      if (f3 != -1.0F)
      {
        if (locala == null)
          break label397;
        locala.c = f3;
        locala.d = f3;
        locala.e = f3;
        locala.f = f3;
      }
      float f4 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0F);
      if (f4 != -1.0F)
      {
        if (locala == null)
          break label409;
        label161: locala.c = f4;
      }
      float f5 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0F);
      if (f5 != -1.0F)
      {
        if (locala == null)
          break label421;
        label194: locala.d = f5;
      }
      float f6 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0F);
      if (f6 != -1.0F)
      {
        if (locala == null)
          break label433;
        label227: locala.e = f6;
      }
      float f7 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0F);
      if (f7 != -1.0F)
      {
        if (locala == null)
          break label445;
        label260: locala.f = f7;
      }
      float f8 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0F);
      if (f8 != -1.0F)
      {
        if (locala == null)
          break label457;
        label293: locala.g = f8;
      }
      float f9 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0F);
      if (f9 != -1.0F)
      {
        if (locala == null)
          break label469;
        label326: locala.h = f9;
      }
      f10 = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0F);
      if (f10 != -1.0F)
        if (locala == null)
          break label481;
    }
    while (true)
    {
      locala.i = f10;
      localTypedArray.recycle();
      return locala;
      locala = new a();
      break;
      label385: locala = new a();
      break label74;
      label397: locala = new a();
      break label107;
      label409: locala = new a();
      break label161;
      label421: locala = new a();
      break label194;
      label433: locala = new a();
      break label227;
      label445: locala = new a();
      break label260;
      label457: locala = new a();
      break label293;
      label469: locala = new a();
      break label326;
      label481: locala = new a();
    }
  }

  public static void a(ViewGroup.LayoutParams paramLayoutParams, TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    paramLayoutParams.width = paramTypedArray.getLayoutDimension(paramInt1, 0);
    paramLayoutParams.height = paramTypedArray.getLayoutDimension(paramInt2, 0);
  }

  private static boolean a(View paramView, a parama)
  {
    return ((0xFF000000 & paramView.getMeasuredWidthAndState()) == 16777216) && (parama.a >= 0.0F) && (parama.j.width == -2);
  }

  private static boolean b(View paramView, a parama)
  {
    return ((0xFF000000 & paramView.getMeasuredHeightAndState()) == 16777216) && (parama.b >= 0.0F) && (parama.j.height == -2);
  }

  public void a()
  {
    int i = this.a.getChildCount();
    int j = 0;
    if (j < i)
    {
      ViewGroup.LayoutParams localLayoutParams = this.a.getChildAt(j).getLayoutParams();
      a locala;
      if ((localLayoutParams instanceof b))
      {
        locala = ((b)localLayoutParams).a();
        if (locala != null)
        {
          if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams))
            break label72;
          locala.a((ViewGroup.MarginLayoutParams)localLayoutParams);
        }
      }
      while (true)
      {
        j++;
        break;
        label72: locala.a(localLayoutParams);
      }
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1) - this.a.getPaddingLeft() - this.a.getPaddingRight();
    int j = View.MeasureSpec.getSize(paramInt2) - this.a.getPaddingTop() - this.a.getPaddingBottom();
    int k = this.a.getChildCount();
    int m = 0;
    if (m < k)
    {
      View localView = this.a.getChildAt(m);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      a locala;
      if ((localLayoutParams instanceof b))
      {
        locala = ((b)localLayoutParams).a();
        if (locala != null)
        {
          if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams))
            break label134;
          locala.a(localView, (ViewGroup.MarginLayoutParams)localLayoutParams, i, j);
        }
      }
      while (true)
      {
        m++;
        break;
        label134: locala.a(localLayoutParams, i, j);
      }
    }
  }

  public boolean b()
  {
    int i = this.a.getChildCount();
    int j = 0;
    boolean bool1 = false;
    View localView;
    ViewGroup.LayoutParams localLayoutParams;
    a locala;
    if (j < i)
    {
      localView = this.a.getChildAt(j);
      localLayoutParams = localView.getLayoutParams();
      if ((localLayoutParams instanceof b))
      {
        locala = ((b)localLayoutParams).a();
        if (locala != null)
        {
          if (!a(localView, locala))
            break label112;
          localLayoutParams.width = -2;
        }
      }
    }
    label112: for (boolean bool2 = true; ; bool2 = bool1)
    {
      if (b(localView, locala))
        localLayoutParams.height = -2;
      for (bool1 = true; ; bool1 = bool2)
      {
        j++;
        break;
        return bool1;
      }
    }
  }

  @Deprecated
  public static class a
  {
    public float a = -1.0F;
    public float b = -1.0F;
    public float c = -1.0F;
    public float d = -1.0F;
    public float e = -1.0F;
    public float f = -1.0F;
    public float g = -1.0F;
    public float h = -1.0F;
    public float i;
    final a.c j = new a.c(0, 0);

    public void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt1, int paramInt2)
    {
      int k = 1;
      a(paramMarginLayoutParams, paramInt1, paramInt2);
      this.j.leftMargin = paramMarginLayoutParams.leftMargin;
      this.j.topMargin = paramMarginLayoutParams.topMargin;
      this.j.rightMargin = paramMarginLayoutParams.rightMargin;
      this.j.bottomMargin = paramMarginLayoutParams.bottomMargin;
      MarginLayoutParamsCompat.setMarginStart(this.j, MarginLayoutParamsCompat.getMarginStart(paramMarginLayoutParams));
      MarginLayoutParamsCompat.setMarginEnd(this.j, MarginLayoutParamsCompat.getMarginEnd(paramMarginLayoutParams));
      if (this.c >= 0.0F)
        paramMarginLayoutParams.leftMargin = Math.round(paramInt1 * this.c);
      if (this.d >= 0.0F)
        paramMarginLayoutParams.topMargin = Math.round(paramInt2 * this.d);
      if (this.e >= 0.0F)
        paramMarginLayoutParams.rightMargin = Math.round(paramInt1 * this.e);
      if (this.f >= 0.0F)
        paramMarginLayoutParams.bottomMargin = Math.round(paramInt2 * this.f);
      boolean bool = this.g < 0.0F;
      int m = 0;
      if (!bool)
      {
        MarginLayoutParamsCompat.setMarginStart(paramMarginLayoutParams, Math.round(paramInt1 * this.g));
        m = k;
      }
      if (this.h >= 0.0F)
        MarginLayoutParamsCompat.setMarginEnd(paramMarginLayoutParams, Math.round(paramInt1 * this.h));
      while (true)
      {
        if ((k != 0) && (paramView != null))
          MarginLayoutParamsCompat.resolveLayoutDirection(paramMarginLayoutParams, ViewCompat.getLayoutDirection(paramView));
        return;
        k = m;
      }
    }

    public void a(ViewGroup.LayoutParams paramLayoutParams)
    {
      if (!this.j.b)
        paramLayoutParams.width = this.j.width;
      if (!this.j.a)
        paramLayoutParams.height = this.j.height;
      this.j.b = false;
      this.j.a = false;
    }

    public void a(ViewGroup.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
    {
      this.j.width = paramLayoutParams.width;
      this.j.height = paramLayoutParams.height;
      if (((this.j.b) || (this.j.width == 0)) && (this.a < 0.0F));
      for (int k = 1; ; k = 0)
      {
        int m;
        if (!this.j.a)
        {
          int n = this.j.height;
          m = 0;
          if (n != 0);
        }
        else
        {
          boolean bool = this.b < 0.0F;
          m = 0;
          if (bool)
            m = 1;
        }
        if (this.a >= 0.0F)
          paramLayoutParams.width = Math.round(paramInt1 * this.a);
        if (this.b >= 0.0F)
          paramLayoutParams.height = Math.round(paramInt2 * this.b);
        if (this.i >= 0.0F)
        {
          if (k != 0)
          {
            paramLayoutParams.width = Math.round(paramLayoutParams.height * this.i);
            this.j.b = true;
          }
          if (m != 0)
          {
            paramLayoutParams.height = Math.round(paramLayoutParams.width / this.i);
            this.j.a = true;
          }
        }
        return;
      }
    }

    public void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      a(paramMarginLayoutParams);
      paramMarginLayoutParams.leftMargin = this.j.leftMargin;
      paramMarginLayoutParams.topMargin = this.j.topMargin;
      paramMarginLayoutParams.rightMargin = this.j.rightMargin;
      paramMarginLayoutParams.bottomMargin = this.j.bottomMargin;
      MarginLayoutParamsCompat.setMarginStart(paramMarginLayoutParams, MarginLayoutParamsCompat.getMarginStart(this.j));
      MarginLayoutParamsCompat.setMarginEnd(paramMarginLayoutParams, MarginLayoutParamsCompat.getMarginEnd(this.j));
    }

    public String toString()
    {
      Object[] arrayOfObject = new Object[8];
      arrayOfObject[0] = Float.valueOf(this.a);
      arrayOfObject[1] = Float.valueOf(this.b);
      arrayOfObject[2] = Float.valueOf(this.c);
      arrayOfObject[3] = Float.valueOf(this.d);
      arrayOfObject[4] = Float.valueOf(this.e);
      arrayOfObject[5] = Float.valueOf(this.f);
      arrayOfObject[6] = Float.valueOf(this.g);
      arrayOfObject[7] = Float.valueOf(this.h);
      return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", arrayOfObject);
    }
  }

  @Deprecated
  public static abstract interface b
  {
    public abstract a.a a();
  }

  static class c extends ViewGroup.MarginLayoutParams
  {
    boolean a;
    boolean b;

    public c(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.percent.a
 * JD-Core Version:    0.6.2
 */