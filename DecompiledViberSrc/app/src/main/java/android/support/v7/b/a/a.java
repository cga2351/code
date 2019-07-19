package android.support.v7.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.graphics.drawable.c;
import android.support.graphics.drawable.i;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.util.StateSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a extends e
{
  private static final String a = a.class.getSimpleName();
  private b b;
  private f c;
  private int d = -1;
  private int e = -1;
  private boolean f;

  public a()
  {
    this(null, null);
  }

  a(b paramb, Resources paramResources)
  {
    super(null);
    a(new b(paramb, this, paramResources));
    onStateChange(getState());
    jumpToCurrentState();
  }

  public static a a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    String str = paramXmlPullParser.getName();
    if (!str.equals("animated-selector"))
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + str);
    a locala = new a();
    locala.b(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return locala;
  }

  private void a(TypedArray paramTypedArray)
  {
    b localb = this.b;
    if (Build.VERSION.SDK_INT >= 21)
      localb.f |= paramTypedArray.getChangingConfigurations();
    localb.a(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, localb.k));
    localb.b(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, localb.n));
    localb.c(paramTypedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, localb.C));
    localb.d(paramTypedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, localb.D));
    setDither(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, localb.z));
  }

  private boolean b(int paramInt)
  {
    f localf = this.c;
    int n;
    if (localf != null)
    {
      if (paramInt == this.d)
        return true;
      if ((paramInt == this.e) && (localf.c()))
      {
        localf.d();
        this.d = this.e;
        this.e = paramInt;
        return true;
      }
      n = this.d;
      localf.b();
    }
    b localb;
    int j;
    int k;
    for (int i = n; ; i = d())
    {
      this.c = null;
      this.e = -1;
      this.d = -1;
      localb = this.b;
      j = localb.a(i);
      k = localb.a(paramInt);
      if ((k != 0) && (j != 0))
        break;
      return false;
    }
    int m = localb.a(j, k);
    if (m < 0)
      return false;
    boolean bool1 = localb.c(j, k);
    a(m);
    Drawable localDrawable = getCurrent();
    Object localObject;
    if ((localDrawable instanceof AnimationDrawable))
    {
      boolean bool2 = localb.b(j, k);
      localObject = new d((AnimationDrawable)localDrawable, bool2, bool1);
    }
    while (true)
    {
      ((f)localObject).a();
      this.c = ((f)localObject);
      this.e = i;
      this.d = paramInt;
      return true;
      if ((localDrawable instanceof c))
      {
        localObject = new c((c)localDrawable);
      }
      else
      {
        if (!(localDrawable instanceof Animatable))
          break;
        localObject = new a((Animatable)localDrawable);
      }
    }
    return false;
  }

  private void c(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int i = 1 + paramXmlPullParser.getDepth();
    while (true)
    {
      int j = paramXmlPullParser.next();
      if (j == 1)
        break;
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3))
        break;
      if ((j == 2) && (k <= i))
        if (paramXmlPullParser.getName().equals("item"))
          e(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        else if (paramXmlPullParser.getName().equals("transition"))
          d(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
  }

  private int d(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableTransition);
    int i = localTypedArray.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
    int j = localTypedArray.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
    int k = localTypedArray.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
    Object localObject = null;
    if (k > 0)
      localObject = android.support.v7.a.a.a.b(paramContext, k);
    boolean bool = localTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
    localTypedArray.recycle();
    if (localObject == null)
    {
      int m;
      do
        m = paramXmlPullParser.next();
      while (m == 4);
      if (m != 2)
        throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
      if (!paramXmlPullParser.getName().equals("animated-vector"))
        break label201;
      localObject = c.a(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    while (localObject == null)
    {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
      label201: if (Build.VERSION.SDK_INT >= 21)
        localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      else
        localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
    }
    if ((i == -1) || (j == -1))
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    return this.b.a(i, j, (Drawable)localObject, bool);
  }

  private int e(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableItem);
    int i = localTypedArray.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
    int j = localTypedArray.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
    Object localObject = null;
    if (j > 0)
      localObject = android.support.v7.a.a.a.b(paramContext, j);
    localTypedArray.recycle();
    int[] arrayOfInt = a(paramAttributeSet);
    if (localObject == null)
    {
      int k;
      do
        k = paramXmlPullParser.next();
      while (k == 4);
      if (k != 2)
        throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
      if (!paramXmlPullParser.getName().equals("vector"))
        break label186;
      localObject = i.a(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    while (localObject == null)
    {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
      label186: if (Build.VERSION.SDK_INT >= 21)
        localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      else
        localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
    }
    return this.b.a(arrayOfInt, (Drawable)localObject, i);
  }

  private void e()
  {
    onStateChange(getState());
  }

  b a()
  {
    return new b(this.b, this, null);
  }

  protected void a(b.b paramb)
  {
    super.a(paramb);
    if ((paramb instanceof b))
      this.b = ((b)paramb);
  }

  public void b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableCompat);
    setVisible(localTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
    a(localTypedArray);
    a(paramResources);
    localTypedArray.recycle();
    c(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    e();
  }

  public boolean isStateful()
  {
    return true;
  }

  public void jumpToCurrentState()
  {
    super.jumpToCurrentState();
    if (this.c != null)
    {
      this.c.b();
      this.c = null;
      a(this.d);
      this.d = -1;
      this.e = -1;
    }
  }

  public Drawable mutate()
  {
    if ((!this.f) && (super.mutate() == this))
    {
      this.b.a();
      this.f = true;
    }
    return this;
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.b.a(paramArrayOfInt);
    if ((i != d()) && ((b(i)) || (a(i))));
    for (boolean bool = true; ; bool = false)
    {
      Drawable localDrawable = getCurrent();
      if (localDrawable != null)
        bool |= localDrawable.setState(paramArrayOfInt);
      return bool;
    }
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if ((this.c != null) && ((bool) || (paramBoolean2)))
    {
      if (paramBoolean1)
        this.c.a();
    }
    else
      return bool;
    jumpToCurrentState();
    return bool;
  }

  private static class a extends a.f
  {
    private final Animatable a;

    a(Animatable paramAnimatable)
    {
      super();
      this.a = paramAnimatable;
    }

    public void a()
    {
      this.a.start();
    }

    public void b()
    {
      this.a.stop();
    }
  }

  static class b extends e.a
  {
    LongSparseArray<Long> a;
    SparseArrayCompat<Integer> b;

    b(b paramb, a parama, Resources paramResources)
    {
      super(parama, paramResources);
      if (paramb != null)
      {
        this.a = paramb.a;
        this.b = paramb.b;
        return;
      }
      this.a = new LongSparseArray();
      this.b = new SparseArrayCompat();
    }

    private static long f(int paramInt1, int paramInt2)
    {
      return paramInt1 << 32 | paramInt2;
    }

    int a(int paramInt)
    {
      if (paramInt < 0)
        return 0;
      return ((Integer)this.b.get(paramInt, Integer.valueOf(0))).intValue();
    }

    int a(int paramInt1, int paramInt2)
    {
      long l = f(paramInt1, paramInt2);
      return (int)((Long)this.a.get(l, Long.valueOf(-1L))).longValue();
    }

    int a(int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean)
    {
      int i = super.a(paramDrawable);
      long l1 = f(paramInt1, paramInt2);
      long l2 = 0L;
      if (paramBoolean)
        l2 = 8589934592L;
      this.a.append(l1, Long.valueOf(l2 | i));
      if (paramBoolean)
      {
        long l3 = f(paramInt2, paramInt1);
        this.a.append(l3, Long.valueOf(l2 | (0x0 | i)));
      }
      return i;
    }

    int a(int[] paramArrayOfInt)
    {
      int i = super.b(paramArrayOfInt);
      if (i >= 0)
        return i;
      return super.b(StateSet.WILD_CARD);
    }

    int a(int[] paramArrayOfInt, Drawable paramDrawable, int paramInt)
    {
      int i = super.a(paramArrayOfInt, paramDrawable);
      this.b.put(i, Integer.valueOf(paramInt));
      return i;
    }

    void a()
    {
      this.a = this.a.clone();
      this.b = this.b.clone();
    }

    boolean b(int paramInt1, int paramInt2)
    {
      long l = f(paramInt1, paramInt2);
      return (0x0 & ((Long)this.a.get(l, Long.valueOf(-1L))).longValue()) != 0L;
    }

    boolean c(int paramInt1, int paramInt2)
    {
      long l = f(paramInt1, paramInt2);
      return (0x0 & ((Long)this.a.get(l, Long.valueOf(-1L))).longValue()) != 0L;
    }

    public Drawable newDrawable()
    {
      return new a(this, null);
    }

    public Drawable newDrawable(Resources paramResources)
    {
      return new a(this, paramResources);
    }
  }

  private static class c extends a.f
  {
    private final c a;

    c(c paramc)
    {
      super();
      this.a = paramc;
    }

    public void a()
    {
      this.a.start();
    }

    public void b()
    {
      this.a.stop();
    }
  }

  private static class d extends a.f
  {
    private final ObjectAnimator a;
    private final boolean b;

    d(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      int i = paramAnimationDrawable.getNumberOfFrames();
      int j;
      if (paramBoolean1)
      {
        j = i - 1;
        if (!paramBoolean1)
          break label111;
      }
      label111: for (int k = 0; ; k = i - 1)
      {
        a.e locale = new a.e(paramAnimationDrawable, paramBoolean1);
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(paramAnimationDrawable, "currentIndex", new int[] { j, k });
        if (Build.VERSION.SDK_INT >= 18)
          localObjectAnimator.setAutoCancel(true);
        localObjectAnimator.setDuration(locale.a());
        localObjectAnimator.setInterpolator(locale);
        this.b = paramBoolean2;
        this.a = localObjectAnimator;
        return;
        j = 0;
        break;
      }
    }

    public void a()
    {
      this.a.start();
    }

    public void b()
    {
      this.a.cancel();
    }

    public boolean c()
    {
      return this.b;
    }

    public void d()
    {
      this.a.reverse();
    }
  }

  private static class e
    implements TimeInterpolator
  {
    private int[] a;
    private int b;
    private int c;

    e(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
    {
      a(paramAnimationDrawable, paramBoolean);
    }

    int a()
    {
      return this.c;
    }

    int a(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
    {
      int i = 0;
      int j = paramAnimationDrawable.getNumberOfFrames();
      this.b = j;
      if ((this.a == null) || (this.a.length < j))
        this.a = new int[j];
      int[] arrayOfInt = this.a;
      int k = 0;
      if (i < j)
      {
        if (paramBoolean);
        for (int m = -1 + (j - i); ; m = i)
        {
          int n = paramAnimationDrawable.getDuration(m);
          arrayOfInt[i] = n;
          int i1 = n + k;
          i++;
          k = i1;
          break;
        }
      }
      this.c = k;
      return k;
    }

    public float getInterpolation(float paramFloat)
    {
      int i = (int)(0.5F + paramFloat * this.c);
      int j = this.b;
      int[] arrayOfInt = this.a;
      int k = i;
      int m = 0;
      while ((m < j) && (k >= arrayOfInt[m]))
      {
        int n = k - arrayOfInt[m];
        m++;
        k = n;
      }
      if (m < j);
      for (float f = k / this.c; ; f = 0.0F)
        return f + m / j;
    }
  }

  private static abstract class f
  {
    public abstract void a();

    public abstract void b();

    public boolean c()
    {
      return false;
    }

    public void d()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.b.a.a
 * JD-Core Version:    0.6.2
 */