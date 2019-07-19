package com.vk.sdk.api.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vk.sdk.VKObject;
import com.vk.sdk.VKUIHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class VKUploadImage extends VKObject
  implements Parcelable
{
  public static final Parcelable.Creator<VKUploadImage> CREATOR = new Parcelable.Creator()
  {
    public VKUploadImage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKUploadImage(paramAnonymousParcel, null);
    }

    public VKUploadImage[] newArray(int paramAnonymousInt)
    {
      return new VKUploadImage[paramAnonymousInt];
    }
  };
  public final Bitmap mImageData;
  public final VKImageParameters mParameters;

  public VKUploadImage(Bitmap paramBitmap, VKImageParameters paramVKImageParameters)
  {
    this.mImageData = paramBitmap;
    this.mParameters = paramVKImageParameters;
  }

  private VKUploadImage(Parcel paramParcel)
  {
    this.mImageData = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.mParameters = ((VKImageParameters)paramParcel.readParcelable(VKImageParameters.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public File getTmpFile()
  {
    Context localContext = VKUIHelper.getApplicationContext();
    if (localContext != null)
    {
      localFile1 = localContext.getExternalCacheDir();
      if ((localFile1 != null) && (localFile1.canWrite()));
    }
    for (File localFile1 = localContext.getCacheDir(); ; localFile1 = null)
      try
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.mParameters.fileExtension();
        File localFile2 = File.createTempFile("tmpImg", String.format(".%s", arrayOfObject), localFile1);
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
          if (this.mParameters.mImageType == VKImageParameters.VKImageType.Png)
            this.mImageData.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
          while (true)
          {
            localFileOutputStream.close();
            return localFile2;
            this.mImageData.compress(Bitmap.CompressFormat.JPEG, (int)(100.0F * this.mParameters.mJpegQuality), localFileOutputStream);
          }
        }
        catch (IOException localIOException2)
        {
          return localFile2;
        }
      }
      catch (IOException localIOException1)
      {
        return null;
      }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mImageData, 0);
    paramParcel.writeParcelable(this.mParameters, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.photo.VKUploadImage
 * JD-Core Version:    0.6.2
 */