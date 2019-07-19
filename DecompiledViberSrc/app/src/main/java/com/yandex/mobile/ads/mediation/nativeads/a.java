package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import com.yandex.mobile.ads.impl.lh;
import com.yandex.mobile.ads.impl.lk;
import java.util.Map;

final class a
{
  private final c a;
  private final b b;

  a(Context paramContext, c paramc)
  {
    this.a = paramc;
    this.b = new b(paramContext);
  }

  private lh a(int paramInt1, int paramInt2, String paramString)
  {
    return a(paramInt1, paramInt2, paramString, this.b.a(paramInt1, paramInt2));
  }

  private static lh a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    lh locallh = new lh();
    locallh.a(paramString1);
    locallh.a(paramInt1);
    locallh.b(paramInt2);
    locallh.b(paramString2);
    return locallh;
  }

  private lh a(String paramString, Map<String, Bitmap> paramMap)
  {
    Bitmap localBitmap = (Bitmap)paramMap.get(paramString);
    if (localBitmap != null)
    {
      int i = localBitmap.getWidth();
      int j = localBitmap.getHeight();
      return a(i, j, paramString, this.b.a(i, j));
    }
    return null;
  }

  final lk a(Map<String, Bitmap> paramMap, MediatedNativeAdImage paramMediatedNativeAdImage)
  {
    return new lk(null, b(paramMap, paramMediatedNativeAdImage));
  }

  final lh b(Map<String, Bitmap> paramMap, MediatedNativeAdImage paramMediatedNativeAdImage)
  {
    if (paramMediatedNativeAdImage != null)
    {
      String str = paramMediatedNativeAdImage.getUrl();
      int i = paramMediatedNativeAdImage.getWidth();
      int j = paramMediatedNativeAdImage.getHeight();
      if (c.a(i, j))
        return a(i, j, str);
      return a(str, paramMap);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.a
 * JD-Core Version:    0.6.2
 */