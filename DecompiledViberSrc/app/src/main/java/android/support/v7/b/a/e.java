package android.support.v7.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.a.a.a;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.util.StateSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class e extends b
{
  private a a;
  private boolean b;

  e()
  {
    this(null, null);
  }

  e(a parama)
  {
    if (parama != null)
      a(parama);
  }

  e(a parama, Resources paramResources)
  {
    a(new a(parama, this, paramResources));
    onStateChange(getState());
  }

  private void a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    a locala = this.a;
    int i = 1 + paramXmlPullParser.getDepth();
    int j;
    int k;
    do
    {
      j = paramXmlPullParser.next();
      if (j == 1)
        break;
      k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3))
        break;
    }
    while ((j != 2) || (k > i) || (!paramXmlPullParser.getName().equals("item")));
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawableItem);
    int m = localTypedArray.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
    Drawable localDrawable = null;
    if (m > 0)
      localDrawable = a.b(paramContext, m);
    localTypedArray.recycle();
    int[] arrayOfInt = a(paramAttributeSet);
    if (localDrawable == null)
    {
      int n;
      do
        n = paramXmlPullParser.next();
      while (n == 4);
      if (n != 2)
        throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or " + "child tag defining a drawable");
      if (Build.VERSION.SDK_INT < 21)
        break label225;
    }
    label225: for (localDrawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme); ; localDrawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet))
    {
      locala.a(arrayOfInt, localDrawable);
      break;
    }
  }

  private void a(TypedArray paramTypedArray)
  {
    a locala = this.a;
    if (Build.VERSION.SDK_INT >= 21)
      locala.f |= paramTypedArray.getChangingConfigurations();
    locala.k = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, locala.k);
    locala.n = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, locala.n);
    locala.C = paramTypedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, locala.C);
    locala.D = paramTypedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, locala.D);
    locala.z = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_dither, locala.z);
  }

  protected void a(b.b paramb)
  {
    super.a(paramb);
    if ((paramb instanceof a))
      this.a = ((a)paramb);
  }

  int[] a(AttributeSet paramAttributeSet)
  {
    int i = paramAttributeSet.getAttributeCount();
    int[] arrayOfInt = new int[i];
    int j = 0;
    int k = 0;
    if (j < i)
    {
      int m = paramAttributeSet.getAttributeNameResource(j);
      int i1;
      switch (m)
      {
      default:
        i1 = k + 1;
        if (!paramAttributeSet.getAttributeBooleanValue(j, false))
          break;
      case 0:
      case 16842960:
      case 16843161:
      }
      while (true)
      {
        arrayOfInt[k] = m;
        int n = i1;
        while (true)
        {
          j++;
          k = n;
          break;
          n = k;
          continue;
          n = k;
        }
        m = -m;
      }
    }
    return StateSet.trimStateSet(arrayOfInt, k);
  }

  public void applyTheme(Resources.Theme paramTheme)
  {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }

  a b()
  {
    return new a(this.a, this, null);
  }

  public void b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawable);
    setVisible(localTypedArray.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
    a(localTypedArray);
    a(paramResources);
    localTypedArray.recycle();
    a(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    onStateChange(getState());
  }

  public boolean isStateful()
  {
    return true;
  }

  public Drawable mutate()
  {
    if ((!this.b) && (super.mutate() == this))
    {
      this.a.a();
      this.b = true;
    }
    return this;
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int i = this.a.b(paramArrayOfInt);
    if (i < 0)
      i = this.a.b(StateSet.WILD_CARD);
    return (a(i)) || (bool);
  }

  static class a extends b.b
  {
    int[][] L;

    a(a parama, e parame, Resources paramResources)
    {
      super(parame, paramResources);
      if (parama != null)
      {
        this.L = parama.L;
        return;
      }
      this.L = new int[c()][];
    }

    int a(int[] paramArrayOfInt, Drawable paramDrawable)
    {
      int i = a(paramDrawable);
      this.L[i] = paramArrayOfInt;
      return i;
    }

    void a()
    {
      int[][] arrayOfInt = new int[this.L.length][];
      int i = -1 + this.L.length;
      if (i >= 0)
      {
        if (this.L[i] != null);
        for (int[] arrayOfInt1 = (int[])this.L[i].clone(); ; arrayOfInt1 = null)
        {
          arrayOfInt[i] = arrayOfInt1;
          i--;
          break;
        }
      }
      this.L = arrayOfInt;
    }

    int b(int[] paramArrayOfInt)
    {
      int[][] arrayOfInt = this.L;
      int i = d();
      for (int j = 0; j < i; j++)
        if (StateSet.stateSetMatches(arrayOfInt[j], paramArrayOfInt))
          return j;
      return -1;
    }

    public void e(int paramInt1, int paramInt2)
    {
      super.e(paramInt1, paramInt2);
      int[][] arrayOfInt = new int[paramInt2][];
      System.arraycopy(this.L, 0, arrayOfInt, 0, paramInt1);
      this.L = arrayOfInt;
    }

    public Drawable newDrawable()
    {
      return new e(this, null);
    }

    public Drawable newDrawable(Resources paramResources)
    {
      return new e(this, paramResources);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.b.a.e
 * JD-Core Version:    0.6.2
 */