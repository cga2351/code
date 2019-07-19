package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.ComplexColorCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends h
{
  static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  private g b;
  private PorterDuffColorFilter d;
  private ColorFilter e;
  private boolean f;
  private boolean g = true;
  private Drawable.ConstantState h;
  private final float[] i = new float[9];
  private final Matrix j = new Matrix();
  private final Rect k = new Rect();

  i()
  {
    this.b = new g();
  }

  i(g paramg)
  {
    this.b = paramg;
    this.d = a(this.d, paramg.c, paramg.d);
  }

  static int a(int paramInt, float paramFloat)
  {
    int m = Color.alpha(paramInt);
    return 0xFFFFFF & paramInt | (int)(paramFloat * m) << 24;
  }

  private static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4:
    case 6:
    case 7:
    case 8:
    case 10:
    case 11:
    case 12:
    case 13:
    default:
      return paramMode;
    case 3:
      return PorterDuff.Mode.SRC_OVER;
    case 5:
      return PorterDuff.Mode.SRC_IN;
    case 9:
      return PorterDuff.Mode.SRC_ATOP;
    case 14:
      return PorterDuff.Mode.MULTIPLY;
    case 15:
      return PorterDuff.Mode.SCREEN;
    case 16:
    }
    return PorterDuff.Mode.ADD;
  }

  public static i a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      i locali1 = new i();
      locali1.c = ResourcesCompat.getDrawable(paramResources, paramInt, paramTheme);
      locali1.h = new h(locali1.c.getConstantState());
      return locali1;
    }
    try
    {
      localXmlResourceParser = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
      int m;
      do
        m = localXmlResourceParser.next();
      while ((m != 2) && (m != 1));
      if (m != 2)
        throw new XmlPullParserException("No start tag found");
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      XmlResourceParser localXmlResourceParser;
      AttributeSet localAttributeSet;
      Log.e("VectorDrawableCompat", "parser error", localXmlPullParserException);
      return null;
      i locali2 = a(paramResources, localXmlResourceParser, localAttributeSet, paramTheme);
      return locali2;
    }
    catch (IOException localIOException)
    {
      while (true)
        Log.e("VectorDrawableCompat", "parser error", localIOException);
    }
  }

  public static i a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    i locali = new i();
    locali.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return locali;
  }

  private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException
  {
    g localg = this.b;
    f localf = localg.b;
    localg.d = a(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    ColorStateList localColorStateList = paramTypedArray.getColorStateList(1);
    if (localColorStateList != null)
      localg.c = localColorStateList;
    localg.e = TypedArrayUtils.getNamedBoolean(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, localg.e);
    localf.f = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, localf.f);
    localf.g = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, localf.g);
    if (localf.f <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    if (localf.g <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    localf.d = paramTypedArray.getDimension(3, localf.d);
    localf.e = paramTypedArray.getDimension(2, localf.e);
    if (localf.d <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    if (localf.e <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    localf.setAlpha(TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "alpha", 4, localf.getAlpha()));
    String str = paramTypedArray.getString(0);
    if (str != null)
    {
      localf.i = str;
      localf.k.put(str, localf);
    }
  }

  private boolean a()
  {
    if (Build.VERSION.SDK_INT >= 17)
      return (isAutoMirrored()) && (DrawableCompat.getLayoutDirection(this) == 1);
    return false;
  }

  private void b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    g localg = this.b;
    f localf = localg.b;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localf.c);
    int m = paramXmlPullParser.getEventType();
    int n = 1 + paramXmlPullParser.getDepth();
    int i1 = 1;
    if ((m != 1) && ((paramXmlPullParser.getDepth() >= n) || (m != 3)))
    {
      String str;
      c localc1;
      int i2;
      if (m == 2)
      {
        str = paramXmlPullParser.getName();
        localc1 = (c)localArrayDeque.peek();
        if ("path".equals(str))
        {
          b localb = new b();
          localb.a(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localc1.b.add(localb);
          if (localb.getPathName() != null)
            localf.k.put(localb.getPathName(), localb);
          i2 = 0;
          localg.a |= localb.o;
          label184: i1 = i2;
        }
      }
      while (true)
      {
        m = paramXmlPullParser.next();
        break;
        if ("clip-path".equals(str))
        {
          a locala = new a();
          locala.a(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localc1.b.add(locala);
          if (locala.getPathName() != null)
            localf.k.put(locala.getPathName(), locala);
          localg.a |= locala.o;
          i2 = i1;
          break label184;
        }
        if ("group".equals(str))
        {
          c localc2 = new c();
          localc2.a(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localc1.b.add(localc2);
          localArrayDeque.push(localc2);
          if (localc2.getGroupName() != null)
            localf.k.put(localc2.getGroupName(), localc2);
          localg.a |= localc2.e;
        }
        i2 = i1;
        break label184;
        if ((m == 3) && ("group".equals(paramXmlPullParser.getName())))
          localArrayDeque.pop();
      }
    }
    if (i1 != 0)
      throw new XmlPullParserException("no path defined");
  }

  PorterDuffColorFilter a(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null))
      return null;
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }

  Object a(String paramString)
  {
    return this.b.b.k.get(paramString);
  }

  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public boolean canApplyTheme()
  {
    if (this.c != null)
      DrawableCompat.canApplyTheme(this.c);
    return false;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.c != null)
      this.c.draw(paramCanvas);
    Object localObject;
    int i1;
    int i2;
    do
    {
      do
      {
        return;
        copyBounds(this.k);
      }
      while ((this.k.width() <= 0) || (this.k.height() <= 0));
      if (this.e != null)
        break;
      localObject = this.d;
      paramCanvas.getMatrix(this.j);
      this.j.getValues(this.i);
      float f1 = Math.abs(this.i[0]);
      float f2 = Math.abs(this.i[4]);
      float f3 = Math.abs(this.i[1]);
      float f4 = Math.abs(this.i[3]);
      if ((f3 != 0.0F) || (f4 != 0.0F))
      {
        f2 = 1.0F;
        f1 = 1.0F;
      }
      int m = (int)(f1 * this.k.width());
      int n = (int)(f2 * this.k.height());
      i1 = Math.min(2048, m);
      i2 = Math.min(2048, n);
    }
    while ((i1 <= 0) || (i2 <= 0));
    int i3 = paramCanvas.save();
    paramCanvas.translate(this.k.left, this.k.top);
    if (a())
    {
      paramCanvas.translate(this.k.width(), 0.0F);
      paramCanvas.scale(-1.0F, 1.0F);
    }
    this.k.offsetTo(0, 0);
    this.b.b(i1, i2);
    if (!this.g)
      this.b.a(i1, i2);
    while (true)
    {
      this.b.a(paramCanvas, (ColorFilter)localObject, this.k);
      paramCanvas.restoreToCount(i3);
      return;
      localObject = this.e;
      break;
      if (!this.b.b())
      {
        this.b.a(i1, i2);
        this.b.c();
      }
    }
  }

  public int getAlpha()
  {
    if (this.c != null)
      return DrawableCompat.getAlpha(this.c);
    return this.b.b.getRootAlpha();
  }

  public int getChangingConfigurations()
  {
    if (this.c != null)
      return this.c.getChangingConfigurations();
    return super.getChangingConfigurations() | this.b.getChangingConfigurations();
  }

  public Drawable.ConstantState getConstantState()
  {
    if ((this.c != null) && (Build.VERSION.SDK_INT >= 24))
      return new h(this.c.getConstantState());
    this.b.a = getChangingConfigurations();
    return this.b;
  }

  public int getIntrinsicHeight()
  {
    if (this.c != null)
      return this.c.getIntrinsicHeight();
    return (int)this.b.b.e;
  }

  public int getIntrinsicWidth()
  {
    if (this.c != null)
      return this.c.getIntrinsicWidth();
    return (int)this.b.b.d;
  }

  public int getOpacity()
  {
    if (this.c != null)
      return this.c.getOpacity();
    return -3;
  }

  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    if (this.c != null)
    {
      this.c.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }

  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (this.c != null)
    {
      DrawableCompat.inflate(this.c, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    g localg = this.b;
    localg.b = new f();
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.a);
    a(localTypedArray, paramXmlPullParser);
    localTypedArray.recycle();
    localg.a = getChangingConfigurations();
    localg.k = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.d = a(this.d, localg.c, localg.d);
  }

  public void invalidateSelf()
  {
    if (this.c != null)
    {
      this.c.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }

  public boolean isAutoMirrored()
  {
    if (this.c != null)
      return DrawableCompat.isAutoMirrored(this.c);
    return this.b.e;
  }

  public boolean isStateful()
  {
    if (this.c != null)
      return this.c.isStateful();
    return (super.isStateful()) || ((this.b != null) && ((this.b.d()) || ((this.b.c != null) && (this.b.c.isStateful()))));
  }

  public Drawable mutate()
  {
    if (this.c != null)
      this.c.mutate();
    while ((this.f) || (super.mutate() != this))
      return this;
    this.b = new g(this.b);
    this.f = true;
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    if (this.c != null)
      this.c.setBounds(paramRect);
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool;
    if (this.c != null)
      bool = this.c.setState(paramArrayOfInt);
    g localg;
    do
    {
      return bool;
      localg = this.b;
      ColorStateList localColorStateList = localg.c;
      bool = false;
      if (localColorStateList != null)
      {
        PorterDuff.Mode localMode = localg.d;
        bool = false;
        if (localMode != null)
        {
          this.d = a(this.d, localg.c, localg.d);
          invalidateSelf();
          bool = true;
        }
      }
    }
    while ((!localg.d()) || (!localg.a(paramArrayOfInt)));
    invalidateSelf();
    return true;
  }

  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.c != null)
    {
      this.c.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }

  public void setAlpha(int paramInt)
  {
    if (this.c != null)
      this.c.setAlpha(paramInt);
    while (this.b.b.getRootAlpha() == paramInt)
      return;
    this.b.b.setRootAlpha(paramInt);
    invalidateSelf();
  }

  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.c != null)
    {
      DrawableCompat.setAutoMirrored(this.c, paramBoolean);
      return;
    }
    this.b.e = paramBoolean;
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.c != null)
    {
      this.c.setColorFilter(paramColorFilter);
      return;
    }
    this.e = paramColorFilter;
    invalidateSelf();
  }

  public void setTint(int paramInt)
  {
    if (this.c != null)
    {
      DrawableCompat.setTint(this.c, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }

  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.c != null)
      DrawableCompat.setTintList(this.c, paramColorStateList);
    g localg;
    do
    {
      return;
      localg = this.b;
    }
    while (localg.c == paramColorStateList);
    localg.c = paramColorStateList;
    this.d = a(this.d, paramColorStateList, localg.d);
    invalidateSelf();
  }

  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.c != null)
      DrawableCompat.setTintMode(this.c, paramMode);
    g localg;
    do
    {
      return;
      localg = this.b;
    }
    while (localg.d == paramMode);
    localg.d = paramMode;
    this.d = a(this.d, localg.c, paramMode);
    invalidateSelf();
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c != null)
      return this.c.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }

  public void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.c != null)
    {
      this.c.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }

  private static class a extends i.e
  {
    public a()
    {
    }

    public a(a parama)
    {
      super();
    }

    private void a(TypedArray paramTypedArray)
    {
      String str1 = paramTypedArray.getString(0);
      if (str1 != null)
        this.n = str1;
      String str2 = paramTypedArray.getString(1);
      if (str2 != null)
        this.m = PathParser.createNodesFromPathData(str2);
    }

    public void a(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData"))
        return;
      TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.d);
      a(localTypedArray);
      localTypedArray.recycle();
    }

    public boolean a()
    {
      return true;
    }
  }

  private static class b extends i.e
  {
    ComplexColorCompat a;
    float b = 0.0F;
    ComplexColorCompat c;
    float d = 1.0F;
    int e = 0;
    float f = 1.0F;
    float g = 0.0F;
    float h = 1.0F;
    float i = 0.0F;
    Paint.Cap j = Paint.Cap.BUTT;
    Paint.Join k = Paint.Join.MITER;
    float l = 4.0F;
    private int[] p;

    public b()
    {
    }

    public b(b paramb)
    {
      super();
      this.p = paramb.p;
      this.a = paramb.a;
      this.b = paramb.b;
      this.d = paramb.d;
      this.c = paramb.c;
      this.e = paramb.e;
      this.f = paramb.f;
      this.g = paramb.g;
      this.h = paramb.h;
      this.i = paramb.i;
      this.j = paramb.j;
      this.k = paramb.k;
      this.l = paramb.l;
    }

    private Paint.Cap a(int paramInt, Paint.Cap paramCap)
    {
      switch (paramInt)
      {
      default:
        return paramCap;
      case 0:
        return Paint.Cap.BUTT;
      case 1:
        return Paint.Cap.ROUND;
      case 2:
      }
      return Paint.Cap.SQUARE;
    }

    private Paint.Join a(int paramInt, Paint.Join paramJoin)
    {
      switch (paramInt)
      {
      default:
        return paramJoin;
      case 0:
        return Paint.Join.MITER;
      case 1:
        return Paint.Join.ROUND;
      case 2:
      }
      return Paint.Join.BEVEL;
    }

    private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      this.p = null;
      if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData"))
        return;
      String str1 = paramTypedArray.getString(0);
      if (str1 != null)
        this.n = str1;
      String str2 = paramTypedArray.getString(2);
      if (str2 != null)
        this.m = PathParser.createNodesFromPathData(str2);
      this.c = TypedArrayUtils.getNamedComplexColor(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1, 0);
      this.f = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.f);
      this.j = a(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1), this.j);
      this.k = a(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1), this.k);
      this.l = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.l);
      this.a = TypedArrayUtils.getNamedComplexColor(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3, 0);
      this.d = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.d);
      this.b = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.b);
      this.h = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.h);
      this.i = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.i);
      this.g = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.g);
      this.e = TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "fillType", 13, this.e);
    }

    public void a(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.c);
      a(localTypedArray, paramXmlPullParser, paramTheme);
      localTypedArray.recycle();
    }

    public boolean a(int[] paramArrayOfInt)
    {
      return this.c.onStateChanged(paramArrayOfInt) | this.a.onStateChanged(paramArrayOfInt);
    }

    public boolean b()
    {
      return (this.c.isStateful()) || (this.a.isStateful());
    }

    float getFillAlpha()
    {
      return this.f;
    }

    int getFillColor()
    {
      return this.c.getColor();
    }

    float getStrokeAlpha()
    {
      return this.d;
    }

    int getStrokeColor()
    {
      return this.a.getColor();
    }

    float getStrokeWidth()
    {
      return this.b;
    }

    float getTrimPathEnd()
    {
      return this.h;
    }

    float getTrimPathOffset()
    {
      return this.i;
    }

    float getTrimPathStart()
    {
      return this.g;
    }

    void setFillAlpha(float paramFloat)
    {
      this.f = paramFloat;
    }

    void setFillColor(int paramInt)
    {
      this.c.setColor(paramInt);
    }

    void setStrokeAlpha(float paramFloat)
    {
      this.d = paramFloat;
    }

    void setStrokeColor(int paramInt)
    {
      this.a.setColor(paramInt);
    }

    void setStrokeWidth(float paramFloat)
    {
      this.b = paramFloat;
    }

    void setTrimPathEnd(float paramFloat)
    {
      this.h = paramFloat;
    }

    void setTrimPathOffset(float paramFloat)
    {
      this.i = paramFloat;
    }

    void setTrimPathStart(float paramFloat)
    {
      this.g = paramFloat;
    }
  }

  private static class c extends i.d
  {
    final Matrix a = new Matrix();
    final ArrayList<i.d> b = new ArrayList();
    float c = 0.0F;
    final Matrix d = new Matrix();
    int e;
    private float f = 0.0F;
    private float g = 0.0F;
    private float h = 1.0F;
    private float i = 1.0F;
    private float j = 0.0F;
    private float k = 0.0F;
    private int[] l;
    private String m = null;

    public c()
    {
      super();
    }

    public c(c paramc, ArrayMap<String, Object> paramArrayMap)
    {
      super();
      this.c = paramc.c;
      this.f = paramc.f;
      this.g = paramc.g;
      this.h = paramc.h;
      this.i = paramc.i;
      this.j = paramc.j;
      this.k = paramc.k;
      this.l = paramc.l;
      this.m = paramc.m;
      this.e = paramc.e;
      if (this.m != null)
        paramArrayMap.put(this.m, this);
      this.d.set(paramc.d);
      ArrayList localArrayList = paramc.b;
      int n = 0;
      while (n < localArrayList.size())
      {
        Object localObject1 = localArrayList.get(n);
        if ((localObject1 instanceof c))
        {
          c localc = (c)localObject1;
          this.b.add(new c(localc, paramArrayMap));
          n++;
        }
        else
        {
          if ((localObject1 instanceof i.b));
          for (Object localObject2 = new i.b((i.b)localObject1); ; localObject2 = new i.a((i.a)localObject1))
          {
            this.b.add(localObject2);
            if (((i.e)localObject2).n == null)
              break;
            paramArrayMap.put(((i.e)localObject2).n, localObject2);
            break;
            if (!(localObject1 instanceof i.a))
              break label330;
          }
          label330: throw new IllegalStateException("Unknown object in the tree!");
        }
      }
    }

    private void a()
    {
      this.d.reset();
      this.d.postTranslate(-this.f, -this.g);
      this.d.postScale(this.h, this.i);
      this.d.postRotate(this.c, 0.0F, 0.0F);
      this.d.postTranslate(this.j + this.f, this.k + this.g);
    }

    private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.l = null;
      this.c = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "rotation", 5, this.c);
      this.f = paramTypedArray.getFloat(1, this.f);
      this.g = paramTypedArray.getFloat(2, this.g);
      this.h = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleX", 3, this.h);
      this.i = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleY", 4, this.i);
      this.j = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateX", 6, this.j);
      this.k = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateY", 7, this.k);
      String str = paramTypedArray.getString(0);
      if (str != null)
        this.m = str;
      a();
    }

    public void a(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.b);
      a(localTypedArray, paramXmlPullParser);
      localTypedArray.recycle();
    }

    public boolean a(int[] paramArrayOfInt)
    {
      int n = 0;
      boolean bool = false;
      while (n < this.b.size())
      {
        bool |= ((i.d)this.b.get(n)).a(paramArrayOfInt);
        n++;
      }
      return bool;
    }

    public boolean b()
    {
      for (int n = 0; ; n++)
      {
        int i1 = this.b.size();
        boolean bool = false;
        if (n < i1)
        {
          if (((i.d)this.b.get(n)).b())
            bool = true;
        }
        else
          return bool;
      }
    }

    public String getGroupName()
    {
      return this.m;
    }

    public Matrix getLocalMatrix()
    {
      return this.d;
    }

    public float getPivotX()
    {
      return this.f;
    }

    public float getPivotY()
    {
      return this.g;
    }

    public float getRotation()
    {
      return this.c;
    }

    public float getScaleX()
    {
      return this.h;
    }

    public float getScaleY()
    {
      return this.i;
    }

    public float getTranslateX()
    {
      return this.j;
    }

    public float getTranslateY()
    {
      return this.k;
    }

    public void setPivotX(float paramFloat)
    {
      if (paramFloat != this.f)
      {
        this.f = paramFloat;
        a();
      }
    }

    public void setPivotY(float paramFloat)
    {
      if (paramFloat != this.g)
      {
        this.g = paramFloat;
        a();
      }
    }

    public void setRotation(float paramFloat)
    {
      if (paramFloat != this.c)
      {
        this.c = paramFloat;
        a();
      }
    }

    public void setScaleX(float paramFloat)
    {
      if (paramFloat != this.h)
      {
        this.h = paramFloat;
        a();
      }
    }

    public void setScaleY(float paramFloat)
    {
      if (paramFloat != this.i)
      {
        this.i = paramFloat;
        a();
      }
    }

    public void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.j)
      {
        this.j = paramFloat;
        a();
      }
    }

    public void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.k)
      {
        this.k = paramFloat;
        a();
      }
    }
  }

  private static abstract class d
  {
    public boolean a(int[] paramArrayOfInt)
    {
      return false;
    }

    public boolean b()
    {
      return false;
    }
  }

  private static abstract class e extends i.d
  {
    protected PathParser.PathDataNode[] m = null;
    String n;
    int o;

    public e()
    {
      super();
    }

    public e(e parame)
    {
      super();
      this.n = parame.n;
      this.o = parame.o;
      this.m = PathParser.deepCopyNodes(parame.m);
    }

    public void a(Path paramPath)
    {
      paramPath.reset();
      if (this.m != null)
        PathParser.PathDataNode.nodesToPath(this.m, paramPath);
    }

    public boolean a()
    {
      return false;
    }

    public PathParser.PathDataNode[] getPathData()
    {
      return this.m;
    }

    public String getPathName()
    {
      return this.n;
    }

    public void setPathData(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      if (!PathParser.canMorph(this.m, paramArrayOfPathDataNode))
      {
        this.m = PathParser.deepCopyNodes(paramArrayOfPathDataNode);
        return;
      }
      PathParser.updateNodes(this.m, paramArrayOfPathDataNode);
    }
  }

  private static class f
  {
    private static final Matrix n = new Matrix();
    Paint a;
    Paint b;
    final i.c c;
    float d = 0.0F;
    float e = 0.0F;
    float f = 0.0F;
    float g = 0.0F;
    int h = 255;
    String i = null;
    Boolean j = null;
    final ArrayMap<String, Object> k = new ArrayMap();
    private final Path l;
    private final Path m;
    private final Matrix o = new Matrix();
    private PathMeasure p;
    private int q;

    public f()
    {
      this.c = new i.c();
      this.l = new Path();
      this.m = new Path();
    }

    public f(f paramf)
    {
      this.c = new i.c(paramf.c, this.k);
      this.l = new Path(paramf.l);
      this.m = new Path(paramf.m);
      this.d = paramf.d;
      this.e = paramf.e;
      this.f = paramf.f;
      this.g = paramf.g;
      this.q = paramf.q;
      this.h = paramf.h;
      this.i = paramf.i;
      if (paramf.i != null)
        this.k.put(paramf.i, this);
      this.j = paramf.j;
    }

    private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
    }

    private float a(Matrix paramMatrix)
    {
      float[] arrayOfFloat = { 0.0F, 1.0F, 1.0F, 0.0F };
      paramMatrix.mapVectors(arrayOfFloat);
      float f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f2 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f3 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      float f4 = Math.max(f1, f2);
      boolean bool = f4 < 0.0F;
      float f5 = 0.0F;
      if (bool)
        f5 = Math.abs(f3) / f4;
      return f5;
    }

    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramc.a.set(paramMatrix);
      paramc.a.preConcat(paramc.d);
      paramCanvas.save();
      int i1 = 0;
      if (i1 < paramc.b.size())
      {
        i.d locald = (i.d)paramc.b.get(i1);
        if ((locald instanceof i.c))
          a((i.c)locald, paramc.a, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        while (true)
        {
          i1++;
          break;
          if ((locald instanceof i.e))
            a(paramc, (i.e)locald, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
      }
      paramCanvas.restore();
    }

    private void a(i.c paramc, i.e parame, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      float f1 = paramInt1 / this.f;
      float f2 = paramInt2 / this.g;
      float f3 = Math.min(f1, f2);
      Matrix localMatrix = paramc.a;
      this.o.set(localMatrix);
      this.o.postScale(f1, f2);
      float f4 = a(localMatrix);
      if (f4 == 0.0F);
      Path localPath1;
      i.b localb;
      float f8;
      float f9;
      ComplexColorCompat localComplexColorCompat2;
      Paint localPaint2;
      label395: Path.FillType localFillType;
      label422: 
      do
      {
        return;
        parame.a(this.l);
        localPath1 = this.l;
        this.m.reset();
        if (parame.a())
        {
          this.m.addPath(localPath1, this.o);
          paramCanvas.clipPath(this.m);
          return;
        }
        localb = (i.b)parame;
        if ((localb.g != 0.0F) || (localb.h != 1.0F))
        {
          float f5 = (localb.g + localb.i) % 1.0F;
          float f6 = (localb.h + localb.i) % 1.0F;
          if (this.p == null)
            this.p = new PathMeasure();
          this.p.setPath(this.l, false);
          float f7 = this.p.getLength();
          f8 = f5 * f7;
          f9 = f6 * f7;
          localPath1.reset();
          if (f8 <= f9)
            break;
          this.p.getSegment(f8, f7, localPath1, true);
          this.p.getSegment(0.0F, f9, localPath1, true);
          localPath1.rLineTo(0.0F, 0.0F);
        }
        this.m.addPath(localPath1, this.o);
        if (localb.c.willDraw())
        {
          localComplexColorCompat2 = localb.c;
          if (this.b == null)
          {
            this.b = new Paint(1);
            this.b.setStyle(Paint.Style.FILL);
          }
          localPaint2 = this.b;
          if (!localComplexColorCompat2.isGradient())
            break label639;
          Shader localShader2 = localComplexColorCompat2.getShader();
          localShader2.setLocalMatrix(this.o);
          localPaint2.setShader(localShader2);
          localPaint2.setAlpha(Math.round(255.0F * localb.f));
          localPaint2.setColorFilter(paramColorFilter);
          Path localPath2 = this.m;
          if (localb.e != 0)
            break label660;
          localFillType = Path.FillType.WINDING;
          localPath2.setFillType(localFillType);
          paramCanvas.drawPath(this.m, localPaint2);
        }
      }
      while (!localb.a.willDraw());
      ComplexColorCompat localComplexColorCompat1 = localb.a;
      if (this.a == null)
      {
        this.a = new Paint(1);
        this.a.setStyle(Paint.Style.STROKE);
      }
      Paint localPaint1 = this.a;
      if (localb.k != null)
        localPaint1.setStrokeJoin(localb.k);
      if (localb.j != null)
        localPaint1.setStrokeCap(localb.j);
      localPaint1.setStrokeMiter(localb.l);
      if (localComplexColorCompat1.isGradient())
      {
        Shader localShader1 = localComplexColorCompat1.getShader();
        localShader1.setLocalMatrix(this.o);
        localPaint1.setShader(localShader1);
        localPaint1.setAlpha(Math.round(255.0F * localb.d));
      }
      while (true)
      {
        localPaint1.setColorFilter(paramColorFilter);
        localPaint1.setStrokeWidth(f3 * f4 * localb.b);
        paramCanvas.drawPath(this.m, localPaint1);
        return;
        this.p.getSegment(f8, f9, localPath1, true);
        break;
        label639: localPaint2.setColor(i.a(localComplexColorCompat2.getColor(), localb.f));
        break label395;
        label660: localFillType = Path.FillType.EVEN_ODD;
        break label422;
        localPaint1.setColor(i.a(localComplexColorCompat1.getColor(), localb.d));
      }
    }

    public void a(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      a(this.c, n, paramCanvas, paramInt1, paramInt2, paramColorFilter);
    }

    public boolean a()
    {
      if (this.j == null)
        this.j = Boolean.valueOf(this.c.b());
      return this.j.booleanValue();
    }

    public boolean a(int[] paramArrayOfInt)
    {
      return this.c.a(paramArrayOfInt);
    }

    public float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }

    public int getRootAlpha()
    {
      return this.h;
    }

    public void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(255.0F * paramFloat));
    }

    public void setRootAlpha(int paramInt)
    {
      this.h = paramInt;
    }
  }

  private static class g extends Drawable.ConstantState
  {
    int a;
    i.f b;
    ColorStateList c = null;
    PorterDuff.Mode d = i.a;
    boolean e;
    Bitmap f;
    ColorStateList g;
    PorterDuff.Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;

    public g()
    {
      this.b = new i.f();
    }

    public g(g paramg)
    {
      if (paramg != null)
      {
        this.a = paramg.a;
        this.b = new i.f(paramg.b);
        if (paramg.b.b != null)
          this.b.b = new Paint(paramg.b.b);
        if (paramg.b.a != null)
          this.b.a = new Paint(paramg.b.a);
        this.c = paramg.c;
        this.d = paramg.d;
        this.e = paramg.e;
      }
    }

    public Paint a(ColorFilter paramColorFilter)
    {
      if ((!a()) && (paramColorFilter == null))
        return null;
      if (this.l == null)
      {
        this.l = new Paint();
        this.l.setFilterBitmap(true);
      }
      this.l.setAlpha(this.b.getRootAlpha());
      this.l.setColorFilter(paramColorFilter);
      return this.l;
    }

    public void a(int paramInt1, int paramInt2)
    {
      this.f.eraseColor(0);
      Canvas localCanvas = new Canvas(this.f);
      this.b.a(localCanvas, paramInt1, paramInt2, null);
    }

    public void a(Canvas paramCanvas, ColorFilter paramColorFilter, Rect paramRect)
    {
      Paint localPaint = a(paramColorFilter);
      paramCanvas.drawBitmap(this.f, null, paramRect, localPaint);
    }

    public boolean a()
    {
      return this.b.getRootAlpha() < 255;
    }

    public boolean a(int[] paramArrayOfInt)
    {
      boolean bool = this.b.a(paramArrayOfInt);
      this.k = (bool | this.k);
      return bool;
    }

    public void b(int paramInt1, int paramInt2)
    {
      if ((this.f == null) || (!c(paramInt1, paramInt2)))
      {
        this.f = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        this.k = true;
      }
    }

    public boolean b()
    {
      return (!this.k) && (this.g == this.c) && (this.h == this.d) && (this.j == this.e) && (this.i == this.b.getRootAlpha());
    }

    public void c()
    {
      this.g = this.c;
      this.h = this.d;
      this.i = this.b.getRootAlpha();
      this.j = this.e;
      this.k = false;
    }

    public boolean c(int paramInt1, int paramInt2)
    {
      return (paramInt1 == this.f.getWidth()) && (paramInt2 == this.f.getHeight());
    }

    public boolean d()
    {
      return this.b.a();
    }

    public int getChangingConfigurations()
    {
      return this.a;
    }

    public Drawable newDrawable()
    {
      return new i(this);
    }

    public Drawable newDrawable(Resources paramResources)
    {
      return new i(this);
    }
  }

  private static class h extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;

    public h(Drawable.ConstantState paramConstantState)
    {
      this.a = paramConstantState;
    }

    public boolean canApplyTheme()
    {
      return this.a.canApplyTheme();
    }

    public int getChangingConfigurations()
    {
      return this.a.getChangingConfigurations();
    }

    public Drawable newDrawable()
    {
      i locali = new i();
      locali.c = ((VectorDrawable)this.a.newDrawable());
      return locali;
    }

    public Drawable newDrawable(Resources paramResources)
    {
      i locali = new i();
      locali.c = ((VectorDrawable)this.a.newDrawable(paramResources));
      return locali;
    }

    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      i locali = new i();
      locali.c = ((VectorDrawable)this.a.newDrawable(paramResources, paramTheme));
      return locali;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.graphics.drawable.i
 * JD-Core Version:    0.6.2
 */