package com.android.camera.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import com.android.camera.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.extras.image.b;
import com.viber.voip.util.e.j;
import java.io.File;

public class a
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a(Activity paramActivity, Bitmap paramBitmap, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, Uri paramUri)
  {
    while (true)
    {
      int i3;
      int i4;
      try
      {
        int[] arrayOfInt = j.b(paramActivity);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        Logger localLogger1 = a;
        Object[] arrayOfObject1 = new Object[4];
        arrayOfObject1[0] = Integer.valueOf(paramRect.left);
        arrayOfObject1[1] = Integer.valueOf(paramRect.top);
        arrayOfObject1[2] = Integer.valueOf(paramRect.width());
        arrayOfObject1[3] = Integer.valueOf(paramRect.height());
        localLogger1.c("landscapeCrop:cropped (left, top) = (?,?), width: ?, height: ?", arrayOfObject1);
        Logger localLogger2 = a;
        Object[] arrayOfObject2 = new Object[4];
        arrayOfObject2[0] = Integer.valueOf(paramBitmap.getWidth());
        arrayOfObject2[1] = Integer.valueOf(paramBitmap.getHeight());
        arrayOfObject2[2] = Integer.valueOf(i);
        arrayOfObject2[3] = Integer.valueOf(j);
        localLogger2.c("landscapeCrop:bitmap width: ?, height: ?, display width: ?, height: ?", arrayOfObject2);
        int k = paramRect.right;
        int m = paramRect.left;
        int n = paramRect.top;
        int i1 = k - m;
        int i2 = i - b.b(paramActivity);
        float f = j / i2;
        i3 = (int)(i1 * (i2 / i));
        i4 = (int)(f * i3);
        if (i4 > paramBitmap.getWidth())
        {
          int i9 = (int)(i3 * (paramBitmap.getWidth() / i4));
          i5 = paramBitmap.getWidth();
          i6 = i9;
          int i7 = (m + k - i5) / 2;
          if (i7 < 0)
          {
            i7 = 0;
            Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, i7, n, i5, i6);
            Logger localLogger3 = a;
            Object[] arrayOfObject3 = new Object[4];
            arrayOfObject3[0] = Integer.valueOf(i7);
            arrayOfObject3[1] = Integer.valueOf(n);
            arrayOfObject3[2] = Integer.valueOf(i5);
            arrayOfObject3[3] = Integer.valueOf(i6);
            localLogger3.c("landscapeCrop:create new bitmap cropX: ?, cropY: ?, width: ?, height: ?", arrayOfObject3);
            if (paramBoolean1)
              localBitmap = e.a(new Matrix(), localBitmap, j, i2, paramBoolean2, true);
            j.a(localBitmap, new File(paramUri.getPath()));
            localBitmap.recycle();
            return;
          }
          if (i7 + i5 <= paramBitmap.getWidth())
            continue;
          int i8 = paramBitmap.getWidth();
          i7 = i8 - i5;
          continue;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        a.a(localIllegalArgumentException, "doCropForConversationBackgroundLandscape error", new Object[0]);
        return;
      }
      int i5 = i4;
      int i6 = i3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.b.a
 * JD-Core Version:    0.6.2
 */