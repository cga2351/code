package com.google.e.b.a.a;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@TargetApi(15)
public final class a
{
  private static final Pattern a = Pattern.compile(";");

  public static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    List localList = paramParameters.getSupportedPreviewSizes();
    if (localList == null)
    {
      Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
      Camera.Size localSize5 = paramParameters.getPreviewSize();
      if (localSize5 == null)
        throw new IllegalStateException("Parameters contained no preview size!");
      return new Point(localSize5.width, localSize5.height);
    }
    ArrayList localArrayList = new ArrayList(localList);
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(Camera.Size paramAnonymousSize1, Camera.Size paramAnonymousSize2)
      {
        int i = paramAnonymousSize1.height * paramAnonymousSize1.width;
        int j = paramAnonymousSize2.height * paramAnonymousSize2.width;
        if (j < i)
          return -1;
        if (j > i)
          return 1;
        return 0;
      }
    });
    if (Log.isLoggable("CameraConfiguration", 4))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        Camera.Size localSize4 = (Camera.Size)localIterator1.next();
        localStringBuilder.append(localSize4.width).append('x').append(localSize4.height).append(' ');
      }
      Log.i("CameraConfiguration", "Supported preview sizes: " + localStringBuilder);
    }
    double d = paramPoint.y / paramPoint.x;
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      Camera.Size localSize3 = (Camera.Size)localIterator2.next();
      int i = localSize3.width;
      int j = localSize3.height;
      if (i * j < 153600)
      {
        localIterator2.remove();
      }
      else
      {
        int k;
        label269: int m;
        if (i < j)
        {
          k = 1;
          if (k == 0)
            break label323;
          m = j;
          label278: if (k == 0)
            break label330;
        }
        label323: label330: for (int n = i; ; n = j)
        {
          if (Math.abs(m / n - d) <= 0.15D)
            break label337;
          localIterator2.remove();
          break;
          k = 0;
          break label269;
          m = i;
          break label278;
        }
        label337: if ((m == paramPoint.x) && (n == paramPoint.y))
        {
          Point localPoint3 = new Point(i, j);
          Log.i("CameraConfiguration", "Found preview size exactly matching screen size: " + localPoint3);
          return localPoint3;
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Camera.Size localSize2 = (Camera.Size)localArrayList.get(0);
      Point localPoint2 = new Point(localSize2.width, localSize2.height);
      Log.i("CameraConfiguration", "Using largest suitable preview size: " + localPoint2);
      return localPoint2;
    }
    Camera.Size localSize1 = paramParameters.getPreviewSize();
    if (localSize1 == null)
      throw new IllegalStateException("Parameters contained no preview size!");
    Point localPoint1 = new Point(localSize1.width, localSize1.height);
    Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + localPoint1);
    return localPoint1;
  }

  private static String a(String paramString, Collection<String> paramCollection, String[] paramArrayOfString)
  {
    Log.i("CameraConfiguration", "Requesting " + paramString + " value from among: " + Arrays.toString(paramArrayOfString));
    Log.i("CameraConfiguration", "Supported " + paramString + " values: " + paramCollection);
    if (paramCollection != null)
    {
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        if (paramCollection.contains(str))
        {
          Log.i("CameraConfiguration", "Can set " + paramString + " to: " + str);
          return str;
        }
      }
    }
    Log.i("CameraConfiguration", "No supported values match");
    return null;
  }

  public static void a(Camera.Parameters paramParameters)
  {
    if (paramParameters.isVideoStabilizationSupported())
    {
      if (paramParameters.getVideoStabilization())
      {
        Log.i("CameraConfiguration", "Video stabilization already enabled");
        return;
      }
      Log.i("CameraConfiguration", "Enabling video stabilization...");
      paramParameters.setVideoStabilization(true);
      return;
    }
    Log.i("CameraConfiguration", "This device does not support video stabilization");
  }

  public static void a(Camera.Parameters paramParameters, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    List localList = paramParameters.getSupportedFocusModes();
    String str = null;
    if (paramBoolean1)
      if ((!paramBoolean3) && (!paramBoolean2))
        break label115;
    label115: for (str = a("focus mode", localList, new String[] { "auto" }); ; str = a("focus mode", localList, new String[] { "continuous-picture", "continuous-video", "auto" }))
    {
      if ((!paramBoolean3) && (str == null))
        str = a("focus mode", localList, new String[] { "macro", "edof" });
      if (str != null)
      {
        if (!str.equals(paramParameters.getFocusMode()))
          break;
        Log.i("CameraConfiguration", "Focus mode already set to " + str);
      }
      return;
    }
    paramParameters.setFocusMode(str);
  }

  public static void b(Camera.Parameters paramParameters)
  {
    if ("barcode".equals(paramParameters.getSceneMode()))
      Log.i("CameraConfiguration", "Barcode scene mode already set");
    String str;
    do
    {
      return;
      str = a("scene mode", paramParameters.getSupportedSceneModes(), new String[] { "barcode" });
    }
    while (str == null);
    paramParameters.setSceneMode(str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.b.a.a.a
 * JD-Core Version:    0.6.2
 */