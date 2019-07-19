package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

public class ImageSource
{
  private boolean isResource;
  private double mSize;
  private String mSource;

  @Nullable
  private Uri mUri;

  public ImageSource(Context paramContext, String paramString)
  {
    this(paramContext, paramString, 0.0D, 0.0D);
  }

  public ImageSource(Context paramContext, String paramString, double paramDouble1, double paramDouble2)
  {
    this.mSource = paramString;
    this.mSize = (paramDouble1 * paramDouble2);
    this.mUri = computeUri(paramContext);
  }

  private Uri computeLocalUri(Context paramContext)
  {
    this.isResource = true;
    return ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(paramContext, this.mSource);
  }

  private Uri computeUri(Context paramContext)
  {
    try
    {
      Object localObject = Uri.parse(this.mSource);
      if (((Uri)localObject).getScheme() == null)
      {
        Uri localUri = computeLocalUri(paramContext);
        localObject = localUri;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return computeLocalUri(paramContext);
  }

  public double getSize()
  {
    return this.mSize;
  }

  public String getSource()
  {
    return this.mSource;
  }

  public Uri getUri()
  {
    return (Uri)Assertions.assertNotNull(this.mUri);
  }

  public boolean isResource()
  {
    return this.isResource;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.imagehelper.ImageSource
 * JD-Core Version:    0.6.2
 */