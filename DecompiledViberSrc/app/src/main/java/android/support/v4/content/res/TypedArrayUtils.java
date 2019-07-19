package android.support.v4.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public class TypedArrayUtils
{
  private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

  public static int getAttr(Context paramContext, int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt1, localTypedValue, true);
    if (localTypedValue.resourceId != 0)
      return paramInt1;
    return paramInt2;
  }

  public static boolean getBoolean(TypedArray paramTypedArray, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return paramTypedArray.getBoolean(paramInt1, paramTypedArray.getBoolean(paramInt2, paramBoolean));
  }

  public static Drawable getDrawable(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = paramTypedArray.getDrawable(paramInt1);
    if (localDrawable == null)
      localDrawable = paramTypedArray.getDrawable(paramInt2);
    return localDrawable;
  }

  public static int getInt(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3)
  {
    return paramTypedArray.getInt(paramInt1, paramTypedArray.getInt(paramInt2, paramInt3));
  }

  public static boolean getNamedBoolean(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, boolean paramBoolean)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return paramBoolean;
    return paramTypedArray.getBoolean(paramInt, paramBoolean);
  }

  public static int getNamedColor(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return paramInt2;
    return paramTypedArray.getColor(paramInt1, paramInt2);
  }

  public static ComplexColorCompat getNamedComplexColor(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme, String paramString, int paramInt1, int paramInt2)
  {
    if (hasAttribute(paramXmlPullParser, paramString))
    {
      TypedValue localTypedValue = new TypedValue();
      paramTypedArray.getValue(paramInt1, localTypedValue);
      ComplexColorCompat localComplexColorCompat;
      if ((localTypedValue.type >= 28) && (localTypedValue.type <= 31))
        localComplexColorCompat = ComplexColorCompat.from(localTypedValue.data);
      do
      {
        return localComplexColorCompat;
        localComplexColorCompat = ComplexColorCompat.inflate(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt1, 0), paramTheme);
      }
      while (localComplexColorCompat != null);
    }
    return ComplexColorCompat.from(paramInt2);
  }

  public static float getNamedFloat(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return paramFloat;
    return paramTypedArray.getFloat(paramInt, paramFloat);
  }

  public static int getNamedInt(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return paramInt2;
    return paramTypedArray.getInt(paramInt1, paramInt2);
  }

  public static int getNamedResourceId(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return paramInt2;
    return paramTypedArray.getResourceId(paramInt1, paramInt2);
  }

  public static String getNamedString(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return null;
    return paramTypedArray.getString(paramInt);
  }

  public static int getResourceId(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3)
  {
    return paramTypedArray.getResourceId(paramInt1, paramTypedArray.getResourceId(paramInt2, paramInt3));
  }

  public static String getString(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    String str = paramTypedArray.getString(paramInt1);
    if (str == null)
      str = paramTypedArray.getString(paramInt2);
    return str;
  }

  public static CharSequence getText(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    CharSequence localCharSequence = paramTypedArray.getText(paramInt1);
    if (localCharSequence == null)
      localCharSequence = paramTypedArray.getText(paramInt2);
    return localCharSequence;
  }

  public static CharSequence[] getTextArray(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    CharSequence[] arrayOfCharSequence = paramTypedArray.getTextArray(paramInt1);
    if (arrayOfCharSequence == null)
      arrayOfCharSequence = paramTypedArray.getTextArray(paramInt2);
    return arrayOfCharSequence;
  }

  public static boolean hasAttribute(XmlPullParser paramXmlPullParser, String paramString)
  {
    return paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null;
  }

  public static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null)
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }

  public static TypedValue peekNamedValue(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    if (!hasAttribute(paramXmlPullParser, paramString))
      return null;
    return paramTypedArray.peekValue(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.res.TypedArrayUtils
 * JD-Core Version:    0.6.2
 */