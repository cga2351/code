package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.support.compat.R.styleable;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class GradientColorInflaterCompat
{
  private static final int TILE_MODE_CLAMP = 0;
  private static final int TILE_MODE_MIRROR = 2;
  private static final int TILE_MODE_REPEAT = 1;

  private static ColorStops checkColors(ColorStops paramColorStops, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramColorStops != null)
      return paramColorStops;
    if (paramBoolean)
      return new ColorStops(paramInt1, paramInt3, paramInt2);
    return new ColorStops(paramInt1, paramInt2);
  }

  static Shader createFromXml(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
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

  static Shader createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    String str = paramXmlPullParser.getName();
    if (!str.equals("gradient"))
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid gradient color tag " + str);
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.GradientColor);
    float f1 = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0F);
    float f2 = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0F);
    float f3 = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0F);
    float f4 = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0F);
    float f5 = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0F);
    float f6 = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0F);
    int i = TypedArrayUtils.getNamedInt(localTypedArray, paramXmlPullParser, "type", R.styleable.GradientColor_android_type, 0);
    int j = TypedArrayUtils.getNamedColor(localTypedArray, paramXmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
    boolean bool = TypedArrayUtils.hasAttribute(paramXmlPullParser, "centerColor");
    int k = TypedArrayUtils.getNamedColor(localTypedArray, paramXmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
    int m = TypedArrayUtils.getNamedColor(localTypedArray, paramXmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
    int n = TypedArrayUtils.getNamedInt(localTypedArray, paramXmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
    float f7 = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0F);
    localTypedArray.recycle();
    ColorStops localColorStops = checkColors(inflateChildElements(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme), j, m, bool, k);
    switch (i)
    {
    default:
      return new LinearGradient(f1, f2, f3, f4, localColorStops.mColors, localColorStops.mOffsets, parseTileMode(n));
    case 1:
      if (f7 <= 0.0F)
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
      return new RadialGradient(f5, f6, f7, localColorStops.mColors, localColorStops.mOffsets, parseTileMode(n));
    case 2:
    }
    return new SweepGradient(f5, f6, localColorStops.mColors, localColorStops.mOffsets);
  }

  private static ColorStops inflateChildElements(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int i = 1 + paramXmlPullParser.getDepth();
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList(20);
    while (true)
    {
      int j = paramXmlPullParser.next();
      if (j == 1)
        break;
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3))
        break;
      if ((j == 2) && (k <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.GradientColorItem);
        boolean bool1 = localTypedArray.hasValue(R.styleable.GradientColorItem_android_color);
        boolean bool2 = localTypedArray.hasValue(R.styleable.GradientColorItem_android_offset);
        if ((!bool1) || (!bool2))
          throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' " + "attribute!");
        int m = localTypedArray.getColor(R.styleable.GradientColorItem_android_color, 0);
        float f = localTypedArray.getFloat(R.styleable.GradientColorItem_android_offset, 0.0F);
        localTypedArray.recycle();
        localArrayList2.add(Integer.valueOf(m));
        localArrayList1.add(Float.valueOf(f));
      }
    }
    if (localArrayList2.size() > 0)
      return new ColorStops(localArrayList2, localArrayList1);
    return null;
  }

  private static Shader.TileMode parseTileMode(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return Shader.TileMode.CLAMP;
    case 1:
      return Shader.TileMode.REPEAT;
    case 2:
    }
    return Shader.TileMode.MIRROR;
  }

  static final class ColorStops
  {
    final int[] mColors;
    final float[] mOffsets;

    ColorStops(int paramInt1, int paramInt2)
    {
      this.mColors = new int[] { paramInt1, paramInt2 };
      this.mOffsets = new float[] { 0.0F, 1.0F };
    }

    ColorStops(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mColors = new int[] { paramInt1, paramInt2, paramInt3 };
      this.mOffsets = new float[] { 0.0F, 0.5F, 1.0F };
    }

    ColorStops(List<Integer> paramList, List<Float> paramList1)
    {
      int i = paramList.size();
      this.mColors = new int[i];
      this.mOffsets = new float[i];
      for (int j = 0; j < i; j++)
      {
        this.mColors[j] = ((Integer)paramList.get(j)).intValue();
        this.mOffsets[j] = ((Float)paramList1.get(j)).floatValue();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.res.GradientColorInflaterCompat
 * JD-Core Version:    0.6.2
 */