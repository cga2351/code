package com.viber.voip.ui.bottomnavigation;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.a;
import android.support.constraint.c.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import java.util.ArrayList;
import java.util.Arrays;

public class BottomNavigationView extends ConstraintLayout
  implements View.OnClickListener
{
  private ArrayList<a> g = new ArrayList(3);
  private ArrayList<c> h = new ArrayList(3);
  private final int[] i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private a t;

  public BottomNavigationView(Context paramContext)
  {
    super(paramContext);
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = R.id.bottom_nav_tab_1;
    arrayOfInt[1] = R.id.bottom_nav_tab_2;
    arrayOfInt[2] = R.id.bottom_nav_tab_3;
    arrayOfInt[3] = R.id.bottom_nav_tab_4;
    arrayOfInt[4] = R.id.bottom_nav_tab_5;
    this.i = arrayOfInt;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    a(paramContext, null);
  }

  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = R.id.bottom_nav_tab_1;
    arrayOfInt[1] = R.id.bottom_nav_tab_2;
    arrayOfInt[2] = R.id.bottom_nav_tab_3;
    arrayOfInt[3] = R.id.bottom_nav_tab_4;
    arrayOfInt[4] = R.id.bottom_nav_tab_5;
    this.i = arrayOfInt;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    a(paramContext, paramAttributeSet);
  }

  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = R.id.bottom_nav_tab_1;
    arrayOfInt[1] = R.id.bottom_nav_tab_2;
    arrayOfInt[2] = R.id.bottom_nav_tab_3;
    arrayOfInt[3] = R.id.bottom_nav_tab_4;
    arrayOfInt[4] = R.id.bottom_nav_tab_5;
    this.i = arrayOfInt;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    a(paramContext, paramAttributeSet);
  }

  private c a(Context paramContext, int paramInt, c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    c localc = new c(paramContext);
    localc.setId(paramInt);
    localc.b(this.j);
    localc.c(this.k);
    localc.d(this.l);
    if (this.m != 0)
      localc.e(this.m);
    c.a locala = new c.a(0, 0);
    locala.h = 0;
    locala.k = 0;
    if (paramBoolean1)
    {
      locala.d = 0;
      locala.G = 2;
      locala.z = 0.5F;
    }
    if (paramBoolean2)
      locala.g = 0;
    locala.M = this.p;
    locala.K = this.o;
    locala.L = this.q;
    locala.N = this.r;
    locala.A = 0.5F;
    locala.E = 1.0F;
    addView(localc, locala);
    if (paramc != null)
    {
      locala.e = paramc.getId();
      ((ConstraintLayout.a)paramc.getLayoutParams()).f = localc.getId();
    }
    return localc;
  }

  // ERROR //
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 161
    //   4: ifne +51 -> 55
    //   7: aload_1
    //   8: instanceof 163
    //   11: ifeq +227 -> 238
    //   14: aload_1
    //   15: checkcast 163	android/view/ContextThemeWrapper
    //   18: astore 9
    //   20: aload 9
    //   22: invokevirtual 167	android/view/ContextThemeWrapper:getBaseContext	()Landroid/content/Context;
    //   25: instanceof 161
    //   28: ifeq +210 -> 238
    //   31: aload 9
    //   33: invokevirtual 167	android/view/ContextThemeWrapper:getBaseContext	()Landroid/content/Context;
    //   36: astore_1
    //   37: iconst_0
    //   38: istore 8
    //   40: iload 8
    //   42: ifeq +13 -> 55
    //   45: new 169	java/lang/RuntimeException
    //   48: dup
    //   49: ldc 171
    //   51: invokespecial 174	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   54: athrow
    //   55: aload_1
    //   56: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   59: astore_3
    //   60: aload_0
    //   61: aload_3
    //   62: getstatic 185	com/viber/voip/R$dimen:bottom_navigation_min_width	I
    //   65: invokevirtual 191	android/content/res/Resources:getDimensionPixelOffset	(I)I
    //   68: putfield 123	com/viber/voip/ui/bottomnavigation/BottomNavigationView:o	I
    //   71: aload_0
    //   72: aload_3
    //   73: getstatic 194	com/viber/voip/R$dimen:bottom_navigation_max_width	I
    //   76: invokevirtual 191	android/content/res/Resources:getDimensionPixelOffset	(I)I
    //   79: putfield 118	com/viber/voip/ui/bottomnavigation/BottomNavigationView:p	I
    //   82: aload_0
    //   83: aload_3
    //   84: getstatic 197	com/viber/voip/R$dimen:bottom_navigation_item_min_height	I
    //   87: invokevirtual 191	android/content/res/Resources:getDimensionPixelOffset	(I)I
    //   90: putfield 128	com/viber/voip/ui/bottomnavigation/BottomNavigationView:q	I
    //   93: aload_0
    //   94: aload_3
    //   95: getstatic 200	com/viber/voip/R$dimen:bottom_navigation_item_max_height	I
    //   98: invokevirtual 191	android/content/res/Resources:getDimensionPixelOffset	(I)I
    //   101: putfield 133	com/viber/voip/ui/bottomnavigation/BottomNavigationView:r	I
    //   104: aload_1
    //   105: aload_2
    //   106: getstatic 205	com/viber/voip/R$styleable:BottomNavigationView	[I
    //   109: iconst_0
    //   110: iconst_0
    //   111: invokevirtual 209	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   114: astore 4
    //   116: aload_0
    //   117: aload 4
    //   119: getstatic 212	com/viber/voip/R$styleable:BottomNavigationView_itemColorActive	I
    //   122: ldc 213
    //   124: invokevirtual 219	android/content/res/TypedArray:getColor	(II)I
    //   127: putfield 60	com/viber/voip/ui/bottomnavigation/BottomNavigationView:j	I
    //   130: aload_0
    //   131: aload 4
    //   133: getstatic 222	com/viber/voip/R$styleable:BottomNavigationView_itemColorInactive	I
    //   136: ldc 223
    //   138: invokevirtual 219	android/content/res/TypedArray:getColor	(II)I
    //   141: putfield 62	com/viber/voip/ui/bottomnavigation/BottomNavigationView:k	I
    //   144: aload_0
    //   145: aload 4
    //   147: getstatic 226	com/viber/voip/R$styleable:BottomNavigationView_badgeTextColor	I
    //   150: iconst_m1
    //   151: invokevirtual 219	android/content/res/TypedArray:getColor	(II)I
    //   154: putfield 64	com/viber/voip/ui/bottomnavigation/BottomNavigationView:l	I
    //   157: aload_0
    //   158: aload 4
    //   160: getstatic 229	com/viber/voip/R$styleable:BottomNavigationView_badgeBackground	I
    //   163: iconst_0
    //   164: invokevirtual 232	android/content/res/TypedArray:getResourceId	(II)I
    //   167: putfield 66	com/viber/voip/ui/bottomnavigation/BottomNavigationView:m	I
    //   170: aload 4
    //   172: invokevirtual 236	android/content/res/TypedArray:recycle	()V
    //   175: iconst_1
    //   176: newarray int
    //   178: astore 7
    //   180: aload 7
    //   182: iconst_0
    //   183: getstatic 241	com/viber/voip/R$attr:actionBarSize	I
    //   186: iastore
    //   187: aload_1
    //   188: aload 7
    //   190: invokevirtual 244	android/content/Context:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   193: astore 4
    //   195: aload_0
    //   196: aload 4
    //   198: iconst_0
    //   199: aload_3
    //   200: getstatic 247	com/viber/voip/R$dimen:bottom_navigation_height	I
    //   203: invokevirtual 191	android/content/res/Resources:getDimensionPixelOffset	(I)I
    //   206: invokevirtual 250	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   209: putfield 252	com/viber/voip/ui/bottomnavigation/BottomNavigationView:n	I
    //   212: aload 4
    //   214: invokevirtual 236	android/content/res/TypedArray:recycle	()V
    //   217: return
    //   218: astore 5
    //   220: aload 4
    //   222: invokevirtual 236	android/content/res/TypedArray:recycle	()V
    //   225: aload 5
    //   227: athrow
    //   228: astore 6
    //   230: aload 4
    //   232: invokevirtual 236	android/content/res/TypedArray:recycle	()V
    //   235: aload 6
    //   237: athrow
    //   238: iconst_1
    //   239: istore 8
    //   241: goto -201 -> 40
    //
    // Exception table:
    //   from	to	target	type
    //   116	170	218	finally
    //   175	212	228	finally
  }

  private void b()
  {
    int i1 = this.g.size();
    if ((3 > i1) || (i1 > 5))
      return;
    Context localContext = getContext();
    int i2 = 0;
    if (i2 < i1)
    {
      c localc1;
      label50: int i3;
      boolean bool1;
      if (i2 > 0)
      {
        localc1 = (c)this.h.get(i2 - 1);
        i3 = this.i[i2];
        if (i2 != 0)
          break label155;
        bool1 = true;
        label65: if (i2 != i1 - 1)
          break label161;
      }
      label155: label161: for (boolean bool2 = true; ; bool2 = false)
      {
        c localc2 = a(localContext, i3, localc1, bool1, bool2);
        a locala = (a)this.g.get(i2);
        localc2.a(locala.c());
        localc2.a(locala.b());
        localc2.setOnClickListener(this);
        this.h.add(localc2);
        i2++;
        break;
        localc1 = null;
        break label50;
        bool1 = false;
        break label65;
      }
    }
    ((c)this.h.get(0)).a(true);
  }

  private boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.h.size());
  }

  public void a(int paramInt, float paramFloat)
  {
    if (!b(paramInt))
      return;
    ((c)this.h.get(paramInt)).a(paramFloat);
  }

  public void a(int paramInt, String paramString)
  {
    if (!b(paramInt))
      return;
    ((c)this.h.get(paramInt)).b(paramString);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if (!b(paramInt));
    do
    {
      do
      {
        return;
        if (paramInt != this.s)
          break;
      }
      while ((!paramBoolean) || (this.t == null));
      this.t.b(this.s);
      return;
      this.s = paramInt;
      int i1 = this.h.size();
      int i2 = 0;
      if (i2 < i1)
      {
        if (((c)this.h.get(i2)).b())
          ((c)this.h.get(i2)).a(false);
        while (true)
        {
          i2++;
          break;
          if (i2 == this.s)
            ((c)this.h.get(i2)).a(true);
        }
      }
    }
    while ((!paramBoolean) || (this.t == null));
    this.t.a(this.s);
  }

  public void a(a[] paramArrayOfa)
  {
    this.h.clear();
    removeAllViews();
    this.g = new ArrayList(Arrays.asList(paramArrayOfa));
    b();
  }

  public int getCurrentItem()
  {
    return this.s;
  }

  public void onClick(View paramView)
  {
    int i1 = this.s;
    int i2 = 0;
    int i3 = this.h.size();
    if (i2 < i3)
      if (paramView != this.h.get(i2));
    while (true)
    {
      a(i2, true);
      return;
      i2++;
      break;
      i2 = i1;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.n, 1073741824));
  }

  public void setBottomNavigationListener(a parama)
  {
    this.t = parama;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void b(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.bottomnavigation.BottomNavigationView
 * JD-Core Version:    0.6.2
 */