package com.vk.sdk.api.photo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vk.sdk.VKObject;

public class VKImageParameters extends VKObject
  implements Parcelable
{
  public static final Parcelable.Creator<VKImageParameters> CREATOR = new Parcelable.Creator()
  {
    public VKImageParameters createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKImageParameters(paramAnonymousParcel, null);
    }

    public VKImageParameters[] newArray(int paramAnonymousInt)
    {
      return new VKImageParameters[paramAnonymousInt];
    }
  };
  public VKImageType mImageType = VKImageType.Png;
  public float mJpegQuality;

  public VKImageParameters()
  {
  }

  private VKImageParameters(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1);
    for (VKImageType localVKImageType = null; ; localVKImageType = VKImageType.values()[i])
    {
      this.mImageType = localVKImageType;
      this.mJpegQuality = paramParcel.readFloat();
      return;
    }
  }

  public static VKImageParameters jpgImage(float paramFloat)
  {
    VKImageParameters localVKImageParameters = new VKImageParameters();
    localVKImageParameters.mImageType = VKImageType.Jpg;
    localVKImageParameters.mJpegQuality = paramFloat;
    return localVKImageParameters;
  }

  public static VKImageParameters pngImage()
  {
    VKImageParameters localVKImageParameters = new VKImageParameters();
    localVKImageParameters.mImageType = VKImageType.Png;
    return localVKImageParameters;
  }

  public int describeContents()
  {
    return 0;
  }

  public String fileExtension()
  {
    switch (2.$SwitchMap$com$vk$sdk$api$photo$VKImageParameters$VKImageType[this.mImageType.ordinal()])
    {
    default:
      return "file";
    case 1:
      return "jpg";
    case 2:
    }
    return "png";
  }

  public String mimeType()
  {
    switch (2.$SwitchMap$com$vk$sdk$api$photo$VKImageParameters$VKImageType[this.mImageType.ordinal()])
    {
    default:
      return "application/octet-stream";
    case 1:
      return "image/jpeg";
    case 2:
    }
    return "image/png";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mImageType == null);
    for (int i = -1; ; i = this.mImageType.ordinal())
    {
      paramParcel.writeInt(i);
      paramParcel.writeFloat(this.mJpegQuality);
      return;
    }
  }

  static enum VKImageType
  {
    static
    {
      VKImageType[] arrayOfVKImageType = new VKImageType[2];
      arrayOfVKImageType[0] = Jpg;
      arrayOfVKImageType[1] = Png;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.photo.VKImageParameters
 * JD-Core Version:    0.6.2
 */