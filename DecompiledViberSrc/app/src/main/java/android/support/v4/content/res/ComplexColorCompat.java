package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ComplexColorCompat
{
  private static final String LOG_TAG = "ComplexColorCompat";
  private int mColor;
  private final ColorStateList mColorStateList;
  private final Shader mShader;

  private ComplexColorCompat(Shader paramShader, ColorStateList paramColorStateList, int paramInt)
  {
    this.mShader = paramShader;
    this.mColorStateList = paramColorStateList;
    this.mColor = paramInt;
  }

  private static ComplexColorCompat createFromXml(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
    int i;
    do
      i = localXmlResourceParser.next();
    while ((i != 2) && (i != 1));
    if (i != 2)
      throw new XmlPullParserException("No start tag found");
    String str = localXmlResourceParser.getName();
    int j = -1;
    switch (str.hashCode())
    {
    default:
    case 1191572447:
    case 89650992:
    }
    while (true)
      switch (j)
      {
      default:
        throw new XmlPullParserException(localXmlResourceParser.getPositionDescription() + ": unsupported complex color tag " + str);
        if (str.equals("selector"))
        {
          j = 0;
          continue;
          if (str.equals("gradient"))
            j = 1;
        }
        break;
      case 0:
      case 1:
      }
    return from(ColorStateListInflaterCompat.createFromXmlInner(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
    return from(GradientColorInflaterCompat.createFromXmlInner(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
  }

  static ComplexColorCompat from(int paramInt)
  {
    return new ComplexColorCompat(null, null, paramInt);
  }

  static ComplexColorCompat from(ColorStateList paramColorStateList)
  {
    return new ComplexColorCompat(null, paramColorStateList, paramColorStateList.getDefaultColor());
  }

  static ComplexColorCompat from(Shader paramShader)
  {
    return new ComplexColorCompat(paramShader, null, 0);
  }

  public static ComplexColorCompat inflate(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      ComplexColorCompat localComplexColorCompat = createFromXml(paramResources, paramInt, paramTheme);
      return localComplexColorCompat;
    }
    catch (Exception localException)
    {
      Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", localException);
    }
    return null;
  }

  public int getColor()
  {
    return this.mColor;
  }

  public Shader getShader()
  {
    return this.mShader;
  }

  public boolean isGradient()
  {
    return this.mShader != null;
  }

  public boolean isStateful()
  {
    return (this.mShader == null) && (this.mColorStateList != null) && (this.mColorStateList.isStateful());
  }

  public boolean onStateChanged(int[] paramArrayOfInt)
  {
    boolean bool1 = isStateful();
    boolean bool2 = false;
    if (bool1)
    {
      int i = this.mColorStateList.getColorForState(paramArrayOfInt, this.mColorStateList.getDefaultColor());
      int j = this.mColor;
      bool2 = false;
      if (i != j)
      {
        bool2 = true;
        this.mColor = i;
      }
    }
    return bool2;
  }

  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
  }

  public boolean willDraw()
  {
    return (isGradient()) || (this.mColor != 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.res.ComplexColorCompat
 * JD-Core Version:    0.6.2
 */