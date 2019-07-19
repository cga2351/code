package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.yandex.mobile.ads.nativeads.template.SizeConstraint;

public final class ImageAppearance
  implements Parcelable
{
  public static final Parcelable.Creator<ImageAppearance> CREATOR = new Parcelable.Creator()
  {
  };
  private final SizeConstraint a;

  protected ImageAppearance(Parcel paramParcel)
  {
    this.a = ((SizeConstraint)paramParcel.readParcelable(SizeConstraint.class.getClassLoader()));
  }

  private ImageAppearance(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ImageAppearance localImageAppearance;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localImageAppearance = (ImageAppearance)paramObject;
      if (this.a == null)
        break;
    }
    while (this.a.equals(localImageAppearance.a));
    while (localImageAppearance.a != null)
      return false;
    return true;
  }

  public final SizeConstraint getWidthConstraint()
  {
    return this.a;
  }

  public final int hashCode()
  {
    if (this.a != null)
      return this.a.hashCode();
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
  }

  public static final class Builder
  {
    private SizeConstraint a;

    public final ImageAppearance build()
    {
      return new ImageAppearance(this, (byte)0);
    }

    public final Builder setWidthConstraint(SizeConstraint paramSizeConstraint)
    {
      this.a = paramSizeConstraint;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.appearance.ImageAppearance
 * JD-Core Version:    0.6.2
 */