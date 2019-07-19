package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;

public class ReactDrawableHelper
{
  private static final TypedValue sResolveOutValue = new TypedValue();

  @TargetApi(21)
  public static Drawable createDrawableFromJSDescription(Context paramContext, ReadableMap paramReadableMap)
  {
    String str1 = paramReadableMap.getString("type");
    if ("ThemeAttrAndroid".equals(str1))
    {
      String str2 = paramReadableMap.getString("attribute");
      SoftAssertions.assertNotNull(str2);
      int j = paramContext.getResources().getIdentifier(str2, "attr", "android");
      if (j == 0)
        throw new JSApplicationIllegalArgumentException("Attribute " + str2 + " couldn't be found in the resource list");
      if (paramContext.getTheme().resolveAttribute(j, sResolveOutValue, true))
      {
        if (Build.VERSION.SDK_INT >= 21)
          return paramContext.getResources().getDrawable(sResolveOutValue.resourceId, paramContext.getTheme());
        return paramContext.getResources().getDrawable(sResolveOutValue.resourceId);
      }
      throw new JSApplicationIllegalArgumentException("Attribute " + str2 + " couldn't be resolved into a drawable");
    }
    int i;
    if ("RippleAndroid".equals(str1))
    {
      if (Build.VERSION.SDK_INT < 21)
        throw new JSApplicationIllegalArgumentException("Ripple drawable is not available on android API <21");
      if ((paramReadableMap.hasKey("color")) && (!paramReadableMap.isNull("color")))
      {
        i = paramReadableMap.getInt("color");
        if ((paramReadableMap.hasKey("borderless")) && (!paramReadableMap.isNull("borderless")) && (paramReadableMap.getBoolean("borderless")))
          break label382;
      }
    }
    label382: for (ColorDrawable localColorDrawable = new ColorDrawable(-1); ; localColorDrawable = null)
    {
      return new RippleDrawable(new ColorStateList(new int[][] { new int[0] }, new int[] { i }), null, localColorDrawable);
      if (paramContext.getTheme().resolveAttribute(16843820, sResolveOutValue, true))
      {
        i = paramContext.getResources().getColor(sResolveOutValue.resourceId);
        break;
      }
      throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
      throw new JSApplicationIllegalArgumentException("Invalid type for android drawable: " + str1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactDrawableHelper
 * JD-Core Version:    0.6.2
 */