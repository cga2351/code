package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Locale;

public class GifAnimationMetaData
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = new Parcelable.Creator()
  {
    public GifAnimationMetaData a(Parcel paramAnonymousParcel)
    {
      return new GifAnimationMetaData(paramAnonymousParcel, null);
    }

    public GifAnimationMetaData[] a(int paramAnonymousInt)
    {
      return new GifAnimationMetaData[paramAnonymousInt];
    }
  };
  private static final long serialVersionUID = 5692363926580237325L;
  private final int mDuration;
  private final int mHeight;
  private final int mImageCount;
  private final int mLoopCount;
  private final long mMetadataBytesCount;
  private final long mPixelsBytesCount;
  private final int mWidth;

  public GifAnimationMetaData(ContentResolver paramContentResolver, Uri paramUri)
    throws IOException
  {
    this(GifInfoHandle.a(paramContentResolver, paramUri));
  }

  public GifAnimationMetaData(AssetFileDescriptor paramAssetFileDescriptor)
    throws IOException
  {
    this(new GifInfoHandle(paramAssetFileDescriptor));
  }

  public GifAnimationMetaData(AssetManager paramAssetManager, String paramString)
    throws IOException
  {
    this(paramAssetManager.openFd(paramString));
  }

  public GifAnimationMetaData(Resources paramResources, int paramInt)
    throws Resources.NotFoundException, IOException
  {
    this(paramResources.openRawResourceFd(paramInt));
  }

  private GifAnimationMetaData(Parcel paramParcel)
  {
    this.mLoopCount = paramParcel.readInt();
    this.mDuration = paramParcel.readInt();
    this.mHeight = paramParcel.readInt();
    this.mWidth = paramParcel.readInt();
    this.mImageCount = paramParcel.readInt();
    this.mMetadataBytesCount = paramParcel.readLong();
    this.mPixelsBytesCount = paramParcel.readLong();
  }

  public GifAnimationMetaData(File paramFile)
    throws IOException
  {
    this(paramFile.getPath());
  }

  public GifAnimationMetaData(FileDescriptor paramFileDescriptor)
    throws IOException
  {
    this(new GifInfoHandle(paramFileDescriptor));
  }

  public GifAnimationMetaData(InputStream paramInputStream)
    throws IOException
  {
    this(new GifInfoHandle(paramInputStream));
  }

  public GifAnimationMetaData(String paramString)
    throws IOException
  {
    this(new GifInfoHandle(paramString));
  }

  public GifAnimationMetaData(ByteBuffer paramByteBuffer)
    throws IOException
  {
    this(new GifInfoHandle(paramByteBuffer));
  }

  private GifAnimationMetaData(GifInfoHandle paramGifInfoHandle)
  {
    this.mLoopCount = paramGifInfoHandle.e();
    this.mDuration = paramGifInfoHandle.g();
    this.mWidth = paramGifInfoHandle.o();
    this.mHeight = paramGifInfoHandle.p();
    this.mImageCount = paramGifInfoHandle.q();
    this.mMetadataBytesCount = paramGifInfoHandle.l();
    this.mPixelsBytesCount = paramGifInfoHandle.k();
    paramGifInfoHandle.a();
  }

  public GifAnimationMetaData(byte[] paramArrayOfByte)
    throws IOException
  {
    this(new GifInfoHandle(paramArrayOfByte));
  }

  public int describeContents()
  {
    return 0;
  }

  public long getAllocationByteCount()
  {
    return this.mPixelsBytesCount;
  }

  public long getDrawableAllocationByteCount(b paramb, int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 65535))
      throw new IllegalStateException("Sample size " + paramInt + " out of range <1, " + 65535 + ">");
    int i = paramInt * paramInt;
    long l;
    if ((paramb != null) && (!paramb.e.isRecycled()))
      if (Build.VERSION.SDK_INT >= 19)
        l = paramb.e.getAllocationByteCount();
    while (true)
    {
      return l + this.mPixelsBytesCount / i;
      l = paramb.e();
      continue;
      l = 4 * (this.mWidth * this.mHeight) / i;
    }
  }

  public int getDuration()
  {
    return this.mDuration;
  }

  public int getHeight()
  {
    return this.mHeight;
  }

  public int getLoopCount()
  {
    return this.mLoopCount;
  }

  public long getMetadataAllocationByteCount()
  {
    return this.mMetadataBytesCount;
  }

  public int getNumberOfFrames()
  {
    return this.mImageCount;
  }

  public int getWidth()
  {
    return this.mWidth;
  }

  public boolean isAnimated()
  {
    return (this.mImageCount > 1) && (this.mDuration > 0);
  }

  public String toString()
  {
    if (this.mLoopCount == 0);
    for (String str1 = "Infinity"; ; str1 = Integer.toString(this.mLoopCount))
    {
      Locale localLocale = Locale.ENGLISH;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = Integer.valueOf(this.mWidth);
      arrayOfObject[1] = Integer.valueOf(this.mHeight);
      arrayOfObject[2] = Integer.valueOf(this.mImageCount);
      arrayOfObject[3] = str1;
      arrayOfObject[4] = Integer.valueOf(this.mDuration);
      String str2 = String.format(localLocale, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", arrayOfObject);
      if (isAnimated())
        str2 = "Animated " + str2;
      return str2;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mLoopCount);
    paramParcel.writeInt(this.mDuration);
    paramParcel.writeInt(this.mHeight);
    paramParcel.writeInt(this.mWidth);
    paramParcel.writeInt(this.mImageCount);
    paramParcel.writeLong(this.mMetadataBytesCount);
    paramParcel.writeLong(this.mPixelsBytesCount);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.GifAnimationMetaData
 * JD-Core Version:    0.6.2
 */