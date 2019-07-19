package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.compat.R.attr;
import android.support.compat.R.styleable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat
{
  private static final int DEFAULT_COLOR = -65536;

  public static ColorStateList createFromXml(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
      i = paramXmlPullParser.next();
    while ((i != 2) && (i != 1));
    if (i != 2)
      throw new XmlPullParserException("No start tag found");
    return createFromXmlInner(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
  }

  public static ColorStateList createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    String str = paramXmlPullParser.getName();
    if (!str.equals("selector"))
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid color state list tag " + str);
    return inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }

  private static ColorStateList inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int i = 1 + paramXmlPullParser.getDepth();
    int[][] arrayOfInt1 = new int[20][];
    int[] arrayOfInt2 = new int[arrayOfInt1.length];
    Object localObject1 = arrayOfInt1;
    int j = 0;
    Object localObject2 = arrayOfInt2;
    int k;
    int m;
    do
    {
      k = paramXmlPullParser.next();
      if (k == 1)
        break;
      m = paramXmlPullParser.getDepth();
      if ((m < i) && (k == 3))
        break;
    }
    while ((k != 2) || (m > i) || (!paramXmlPullParser.getName().equals("item")));
    TypedArray localTypedArray = obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.ColorStateListItem);
    int n = localTypedArray.getColor(R.styleable.ColorStateListItem_android_color, -65281);
    float f = 1.0F;
    label146: int i1;
    int[] arrayOfInt5;
    int i3;
    label171: int i5;
    int i7;
    if (localTypedArray.hasValue(R.styleable.ColorStateListItem_android_alpha))
    {
      f = localTypedArray.getFloat(R.styleable.ColorStateListItem_android_alpha, f);
      localTypedArray.recycle();
      i1 = 0;
      int i2 = paramAttributeSet.getAttributeCount();
      arrayOfInt5 = new int[i2];
      i3 = 0;
      if (i3 >= i2)
        break label283;
      i5 = paramAttributeSet.getAttributeNameResource(i3);
      if ((i5 == 16843173) || (i5 == 16843551) || (i5 == R.attr.alpha))
        break label398;
      i7 = i1 + 1;
      if (!paramAttributeSet.getAttributeBooleanValue(i3, false))
        break label275;
      label228: arrayOfInt5[i1] = i5;
    }
    label398: for (int i6 = i7; ; i6 = i1)
    {
      i3++;
      i1 = i6;
      break label171;
      if (!localTypedArray.hasValue(R.styleable.ColorStateListItem_alpha))
        break label146;
      f = localTypedArray.getFloat(R.styleable.ColorStateListItem_alpha, f);
      break label146;
      label275: i5 = -i5;
      break label228;
      label283: int[] arrayOfInt6 = StateSet.trimStateSet(arrayOfInt5, i1);
      int i4 = modulateColorAlpha(n, f);
      if ((j != 0) && (arrayOfInt6.length == 0));
      int[] arrayOfInt7 = GrowingArrayUtils.append((int[])localObject2, j, i4);
      int[][] arrayOfInt = (int[][])GrowingArrayUtils.append((Object[])localObject1, j, arrayOfInt6);
      j++;
      localObject1 = arrayOfInt;
      localObject2 = arrayOfInt7;
      break;
      int[] arrayOfInt3 = new int[j];
      int[][] arrayOfInt4 = new int[j][];
      System.arraycopy(localObject2, 0, arrayOfInt3, 0, j);
      System.arraycopy(localObject1, 0, arrayOfInt4, 0, j);
      return new ColorStateList(arrayOfInt4, arrayOfInt3);
    }
  }

  private static int modulateColorAlpha(int paramInt, float paramFloat)
  {
    int i = Math.round(paramFloat * Color.alpha(paramInt));
    return 0xFFFFFF & paramInt | i << 24;
  }

  private static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null)
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.res.ColorStateListInflaterCompat
 * JD-Core Version:    0.6.2
 */