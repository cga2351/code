package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public class g
  implements Interpolator
{
  private float[] a;
  private float[] b;

  public g(Context paramContext, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    this(paramContext.getResources(), paramContext.getTheme(), paramAttributeSet, paramXmlPullParser);
  }

  public g(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.l);
    a(localTypedArray, paramXmlPullParser);
    localTypedArray.recycle();
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    a(localPath);
  }

  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    a(localPath);
  }

  private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
  {
    if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData"))
    {
      String str = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "pathData", 4);
      Path localPath = PathParser.createPathFromPathData(str);
      if (localPath == null)
        throw new InflateException("The path is null, which is created from " + str);
      a(localPath);
      return;
    }
    if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlX1"))
      throw new InflateException("pathInterpolator requires the controlX1 attribute");
    if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlY1"))
      throw new InflateException("pathInterpolator requires the controlY1 attribute");
    float f1 = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "controlX1", 0, 0.0F);
    float f2 = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "controlY1", 1, 0.0F);
    boolean bool = TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlX2");
    if (bool != TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlY2"))
      throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
    if (!bool)
    {
      a(f1, f2);
      return;
    }
    a(f1, f2, TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "controlX2", 2, 0.0F), TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "controlY2", 3, 0.0F));
  }

  private void a(Path paramPath)
  {
    int i = 0;
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f1 = localPathMeasure.getLength();
    int j = Math.min(3000, 1 + (int)(f1 / 0.002F));
    if (j <= 0)
      throw new IllegalArgumentException("The Path has a invalid length " + f1);
    this.a = new float[j];
    this.b = new float[j];
    float[] arrayOfFloat1 = new float[2];
    for (int k = 0; k < j; k++)
    {
      localPathMeasure.getPosTan(f1 * k / (j - 1), arrayOfFloat1, null);
      this.a[k] = arrayOfFloat1[0];
      this.b[k] = arrayOfFloat1[1];
    }
    if ((Math.abs(this.a[0]) > 1.E-005D) || (Math.abs(this.b[0]) > 1.E-005D) || (Math.abs(this.a[(j - 1)] - 1.0F) > 1.E-005D) || (Math.abs(this.b[(j - 1)] - 1.0F) > 1.E-005D))
      throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.a[0] + "," + this.b[0] + " end:" + this.a[(j - 1)] + "," + this.b[(j - 1)]);
    float f2 = 0.0F;
    int n;
    for (int m = 0; i < j; m = n)
    {
      float[] arrayOfFloat2 = this.a;
      n = m + 1;
      float f3 = arrayOfFloat2[m];
      if (f3 < f2)
        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f3);
      this.a[i] = f3;
      i++;
      f2 = f3;
    }
    if (localPathMeasure.nextContour())
      throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
  }

  public float getInterpolation(float paramFloat)
  {
    float f1 = 1.0F;
    if (paramFloat <= 0.0F)
      f1 = 0.0F;
    while (paramFloat >= f1)
      return f1;
    int i = 0;
    int j = -1 + this.a.length;
    if (j - i > 1)
    {
      int k = (i + j) / 2;
      int n;
      if (paramFloat < this.a[k])
        n = i;
      while (true)
      {
        i = n;
        j = k;
        break;
        int m = j;
        n = k;
        k = m;
      }
    }
    float f2 = this.a[j] - this.a[i];
    if (f2 == 0.0F)
      return this.b[i];
    float f3 = (paramFloat - this.a[i]) / f2;
    float f4 = this.b[i];
    return f4 + f3 * (this.b[j] - f4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.graphics.drawable.g
 * JD-Core Version:    0.6.2
 */