package com.yandex.mobile.ads.nativeads.template.appearance;

import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.template.SizeConstraint;

final class a
{
  public static ImageAppearance a(ImageAppearance paramImageAppearance1, ImageAppearance paramImageAppearance2)
  {
    if ((paramImageAppearance2 == null) || (paramImageAppearance1.equals(paramImageAppearance2)))
      return paramImageAppearance1;
    SizeConstraint localSizeConstraint = paramImageAppearance2.getWidthConstraint();
    ImageAppearance.Builder localBuilder = new ImageAppearance.Builder();
    if (localSizeConstraint != null);
    while (true)
    {
      return localBuilder.setWidthConstraint(localSizeConstraint).build();
      localSizeConstraint = paramImageAppearance1.getWidthConstraint();
    }
  }

  static TextAppearance a(TextAppearance paramTextAppearance1, TextAppearance paramTextAppearance2)
  {
    if ((paramTextAppearance2 == null) || (paramTextAppearance1.equals(paramTextAppearance2)))
      return paramTextAppearance1;
    int i = paramTextAppearance2.getTextColor();
    float f1 = paramTextAppearance2.getTextSize();
    String str1 = paramTextAppearance2.getFontFamilyName();
    int j = paramTextAppearance2.getFontStyle();
    TextAppearance.Builder localBuilder1 = new TextAppearance.Builder();
    float f2;
    label66: TextAppearance.Builder localBuilder3;
    if (i != 0)
    {
      TextAppearance.Builder localBuilder2 = localBuilder1.setTextColor(i);
      if (f1 < 1.0F)
        break label111;
      f2 = f1;
      localBuilder3 = localBuilder2.setTextSize(f2);
      if (TextUtils.isEmpty(str1))
        break label120;
    }
    label111: label120: for (String str2 = str1; ; str2 = paramTextAppearance1.getFontFamilyName())
    {
      return localBuilder3.setFontFamilyName(str2).setFontStyle(j).build();
      i = paramTextAppearance1.getTextColor();
      break;
      f2 = paramTextAppearance1.getTextSize();
      break label66;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.appearance.a
 * JD-Core Version:    0.6.2
 */