package com.facebook.react.uimanager;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

public class TransformHelper
{
  private static ThreadLocal<double[]> sHelperMatrix = new ThreadLocal()
  {
    protected double[] initialValue()
    {
      return new double[16];
    }
  };

  private static double convertToRadians(ReadableMap paramReadableMap, String paramString)
  {
    int i = 1;
    String str;
    int m;
    double d2;
    if (paramReadableMap.getType(paramString) == ReadableType.String)
    {
      str = paramReadableMap.getString(paramString);
      if (str.endsWith("rad"))
      {
        str = str.substring(0, -3 + str.length());
        double d3 = Float.parseFloat(str);
        m = i;
        d2 = d3;
      }
    }
    int j;
    for (int k = m; ; k = j)
    {
      if (k == 0)
        break label129;
      return d2;
      if (!str.endsWith("deg"))
        break;
      str = str.substring(0, -3 + str.length());
      i = 0;
      break;
      double d1 = paramReadableMap.getDouble(paramString);
      j = i;
      d2 = d1;
    }
    label129: return MatrixMathHelper.degreesToRadians(d2);
  }

  public static void processTransform(ReadableArray paramReadableArray, double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = (double[])sHelperMatrix.get();
    MatrixMathHelper.resetIdentityMatrix(paramArrayOfDouble);
    int i = paramReadableArray.size();
    int j = 0;
    if (j < i)
    {
      ReadableMap localReadableMap = paramReadableArray.getMap(j);
      String str = localReadableMap.keySetIterator().nextKey();
      MatrixMathHelper.resetIdentityMatrix(arrayOfDouble);
      if ("matrix".equals(str))
      {
        ReadableArray localReadableArray2 = localReadableMap.getArray(str);
        for (int k = 0; k < 16; k++)
          arrayOfDouble[k] = localReadableArray2.getDouble(k);
      }
      if ("perspective".equals(str))
        MatrixMathHelper.applyPerspective(arrayOfDouble, localReadableMap.getDouble(str));
      while (true)
      {
        MatrixMathHelper.multiplyInto(paramArrayOfDouble, paramArrayOfDouble, arrayOfDouble);
        j++;
        break;
        if ("rotateX".equals(str))
        {
          MatrixMathHelper.applyRotateX(arrayOfDouble, convertToRadians(localReadableMap, str));
        }
        else if ("rotateY".equals(str))
        {
          MatrixMathHelper.applyRotateY(arrayOfDouble, convertToRadians(localReadableMap, str));
        }
        else if (("rotate".equals(str)) || ("rotateZ".equals(str)))
        {
          MatrixMathHelper.applyRotateZ(arrayOfDouble, convertToRadians(localReadableMap, str));
        }
        else if ("scale".equals(str))
        {
          double d4 = localReadableMap.getDouble(str);
          MatrixMathHelper.applyScaleX(arrayOfDouble, d4);
          MatrixMathHelper.applyScaleY(arrayOfDouble, d4);
        }
        else if ("scaleX".equals(str))
        {
          MatrixMathHelper.applyScaleX(arrayOfDouble, localReadableMap.getDouble(str));
        }
        else if ("scaleY".equals(str))
        {
          MatrixMathHelper.applyScaleY(arrayOfDouble, localReadableMap.getDouble(str));
        }
        else
        {
          if ("translate".equals(str))
          {
            ReadableArray localReadableArray1 = localReadableMap.getArray(str);
            double d1 = localReadableArray1.getDouble(0);
            double d2 = localReadableArray1.getDouble(1);
            if (localReadableArray1.size() > 2);
            for (double d3 = localReadableArray1.getDouble(2); ; d3 = 0.0D)
            {
              MatrixMathHelper.applyTranslate3D(arrayOfDouble, d1, d2, d3);
              break;
            }
          }
          if ("translateX".equals(str))
          {
            MatrixMathHelper.applyTranslate2D(arrayOfDouble, localReadableMap.getDouble(str), 0.0D);
          }
          else if ("translateY".equals(str))
          {
            MatrixMathHelper.applyTranslate2D(arrayOfDouble, 0.0D, localReadableMap.getDouble(str));
          }
          else if ("skewX".equals(str))
          {
            MatrixMathHelper.applySkewX(arrayOfDouble, convertToRadians(localReadableMap, str));
          }
          else
          {
            if (!"skewY".equals(str))
              break label496;
            MatrixMathHelper.applySkewY(arrayOfDouble, convertToRadians(localReadableMap, str));
          }
        }
      }
      label496: throw new JSApplicationIllegalArgumentException("Unsupported transform type: " + str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.TransformHelper
 * JD-Core Version:    0.6.2
 */