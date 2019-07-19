package com.facebook.react.views.text.frescosupport;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactTextInlineImageShadowNode;
import com.facebook.react.views.text.TextInlineImageSpan;
import java.util.Locale;
import javax.annotation.Nullable;

public class FrescoBasedReactTextInlineImageShadowNode extends ReactTextInlineImageShadowNode
{

  @Nullable
  private final Object mCallerContext;
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  private ReadableMap mHeaders;
  private float mHeight = (0.0F / 0.0F);
  private int mTintColor = 0;

  @Nullable
  private Uri mUri;
  private float mWidth = (0.0F / 0.0F);

  public FrescoBasedReactTextInlineImageShadowNode(AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable Object paramObject)
  {
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mCallerContext = paramObject;
  }

  @Nullable
  private static Uri getResourceDrawableUri(Context paramContext, @Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return null;
    String str = paramString.toLowerCase(Locale.getDefault()).replace("-", "_");
    int i = paramContext.getResources().getIdentifier(str, "drawable", paramContext.getPackageName());
    return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
  }

  public TextInlineImageSpan buildInlineImageSpan()
  {
    Resources localResources = getThemedContext().getResources();
    int i = (int)Math.ceil(this.mWidth);
    return new FrescoBasedReactTextInlineImageSpan(localResources, (int)Math.ceil(this.mHeight), i, this.mTintColor, getUri(), getHeaders(), getDraweeControllerBuilder(), getCallerContext());
  }

  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  public AbstractDraweeControllerBuilder getDraweeControllerBuilder()
  {
    return this.mDraweeControllerBuilder;
  }

  public ReadableMap getHeaders()
  {
    return this.mHeaders;
  }

  @Nullable
  public Uri getUri()
  {
    return this.mUri;
  }

  public boolean isVirtual()
  {
    return true;
  }

  @ReactProp(name="headers")
  public void setHeaders(ReadableMap paramReadableMap)
  {
    this.mHeaders = paramReadableMap;
  }

  public void setHeight(Dynamic paramDynamic)
  {
    if (paramDynamic.getType() == ReadableType.Number)
    {
      this.mHeight = ((float)paramDynamic.asDouble());
      return;
    }
    throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based height");
  }

  @ReactProp(name="src")
  public void setSource(@Nullable ReadableArray paramReadableArray)
  {
    String str1;
    if ((paramReadableArray == null) || (paramReadableArray.size() == 0))
      str1 = null;
    while (true)
    {
      Object localObject = null;
      if (str1 != null);
      try
      {
        Uri localUri2 = Uri.parse(str1);
        localUri1 = localUri2;
      }
      catch (Exception localException1)
      {
        try
        {
          String str2 = localUri1.getScheme();
          localObject = null;
          if (str2 == null)
            while (true)
            {
              if (localObject == null)
                localObject = getResourceDrawableUri(getThemedContext(), str1);
              if (localObject != this.mUri)
                markUpdated();
              this.mUri = ((Uri)localObject);
              return;
              str1 = paramReadableArray.getMap(0).getString("uri");
              break;
              localException1 = localException1;
              localUri1 = null;
              localObject = localUri1;
            }
        }
        catch (Exception localException2)
        {
          while (true)
          {
            Uri localUri1;
            continue;
            localObject = localUri1;
          }
        }
      }
    }
  }

  @ReactProp(name="tintColor")
  public void setTintColor(int paramInt)
  {
    this.mTintColor = paramInt;
  }

  public void setWidth(Dynamic paramDynamic)
  {
    if (paramDynamic.getType() == ReadableType.Number)
    {
      this.mWidth = ((float)paramDynamic.asDouble());
      return;
    }
    throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based width");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageShadowNode
 * JD-Core Version:    0.6.2
 */