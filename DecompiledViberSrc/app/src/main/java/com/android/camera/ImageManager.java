package com.android.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.android.camera.a.b;
import com.android.camera.a.c;
import com.android.camera.a.d;
import com.android.camera.a.f;
import com.android.camera.a.g;
import com.android.camera.a.i;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageManager
{
  public static final String a = Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera";
  public static final String b = a(a);
  private static final Logger c = ViberEnv.getLogger();
  private static final Uri d = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
  private static final Uri e = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
  private static final Uri f = Uri.parse("content://media/external/video/media");

  public static ImageListParam a(Uri paramUri)
  {
    ImageListParam localImageListParam = new ImageListParam();
    localImageListParam.mSingleImageUri = paramUri;
    return localImageListParam;
  }

  public static ImageListParam a(a parama, int paramInt1, int paramInt2, String paramString)
  {
    ImageListParam localImageListParam = new ImageListParam();
    localImageListParam.mLocation = parama;
    localImageListParam.mInclusion = paramInt1;
    localImageListParam.mSort = paramInt2;
    localImageListParam.mBucketId = paramString;
    return localImageListParam;
  }

  public static d a(Context paramContext, ContentResolver paramContentResolver, Uri paramUri)
  {
    return a(paramContext, paramContentResolver, a(paramUri));
  }

  public static d a(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, int paramInt)
  {
    if (paramUri != null);
    for (String str1 = paramUri.toString(); str1.startsWith("content://drm"); str1 = "")
      return a(paramContext, paramContentResolver, a.d, 2, paramInt, null);
    if (str1.startsWith("content://media/external/video"))
      return a(paramContext, paramContentResolver, a.c, 4, paramInt, null);
    if (c(str1))
      return a(paramContext, paramContentResolver, paramUri);
    String str2 = paramUri.getQueryParameter("bucketId");
    return a(paramContext, paramContentResolver, a.d, 1, paramInt, str2);
  }

  public static d a(Context paramContext, ContentResolver paramContentResolver, ImageListParam paramImageListParam)
  {
    a locala = paramImageListParam.mLocation;
    int i = paramImageListParam.mInclusion;
    int j = paramImageListParam.mSort;
    String str = paramImageListParam.mBucketId;
    Uri localUri = paramImageListParam.mSingleImageUri;
    if ((paramImageListParam.mIsEmptyImageList) || (paramContentResolver == null))
      return new b(null);
    if (localUri != null)
      return new i(paramContext, paramContentResolver, localUri);
    boolean bool = a(false);
    ArrayList localArrayList = new ArrayList();
    if ((bool) && (locala != a.b) && ((i & 0x1) != 0))
      localArrayList.add(new f(paramContentResolver, d, j, str));
    if (((locala == a.b) || (locala == a.d)) && ((i & 0x1) != 0))
      localArrayList.add(new f(paramContentResolver, MediaStore.Images.Media.INTERNAL_CONTENT_URI, j, str));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.c())
      {
        localb.a();
        localIterator.remove();
      }
    }
    if (localArrayList.size() == 1)
      return (b)localArrayList.get(0);
    return new g((d[])localArrayList.toArray(new d[localArrayList.size()]), j);
  }

  public static d a(Context paramContext, ContentResolver paramContentResolver, a parama, int paramInt1, int paramInt2, String paramString)
  {
    return a(paramContext, paramContentResolver, a(parama, paramInt1, paramInt2, paramString));
  }

  public static String a(String paramString)
  {
    return String.valueOf(paramString.toLowerCase().hashCode());
  }

  private static boolean a()
  {
    String str = Environment.getExternalStorageDirectory().toString() + "/DCIM";
    File localFile1 = new File(str);
    if ((!localFile1.isDirectory()) && (!localFile1.mkdirs()));
    while (true)
    {
      return false;
      File localFile2 = new File(str, ".probe");
      try
      {
        if (localFile2.exists())
          localFile2.delete();
        if (localFile2.createNewFile())
        {
          localFile2.delete();
          return true;
        }
      }
      catch (IOException localIOException)
      {
      }
    }
    return false;
  }

  public static boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    String str = o.e();
    if ("mounted".equals(str))
      if (paramBoolean)
        bool = a();
    while ((!paramBoolean) && ("mounted_ro".equals(str)))
      return bool;
    return false;
  }

  public static boolean b(String paramString)
  {
    return paramString.startsWith("image");
  }

  static boolean c(String paramString)
  {
    return (!paramString.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString())) && (!paramString.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString()));
  }

  public static class ImageListParam
    implements Parcelable
  {
    public static final Parcelable.Creator<ImageListParam> CREATOR = new Parcelable.Creator()
    {
      public ImageManager.ImageListParam a(Parcel paramAnonymousParcel)
      {
        return new ImageManager.ImageListParam(paramAnonymousParcel, null);
      }

      public ImageManager.ImageListParam[] a(int paramAnonymousInt)
      {
        return new ImageManager.ImageListParam[paramAnonymousInt];
      }
    };
    public String mBucketId;
    public int mInclusion;
    public boolean mIsEmptyImageList;
    public ImageManager.a mLocation;
    public Uri mSingleImageUri;
    public int mSort;

    public ImageListParam()
    {
    }

    private ImageListParam(Parcel paramParcel)
    {
      this.mLocation = ImageManager.a.values()[paramParcel.readInt()];
      this.mInclusion = paramParcel.readInt();
      this.mSort = paramParcel.readInt();
      this.mBucketId = paramParcel.readString();
      this.mSingleImageUri = ((Uri)paramParcel.readParcelable(null));
      if (paramParcel.readInt() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.mIsEmptyImageList = bool;
        return;
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = this.mLocation;
      arrayOfObject[1] = Integer.valueOf(this.mInclusion);
      arrayOfObject[2] = Integer.valueOf(this.mSort);
      arrayOfObject[3] = this.mBucketId;
      arrayOfObject[4] = Boolean.valueOf(this.mIsEmptyImageList);
      arrayOfObject[5] = this.mSingleImageUri;
      return String.format("ImageListParam{loc=%s,inc=%d,sort=%d,bucket=%s,empty=%b,single=%s}", arrayOfObject);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mLocation.ordinal());
      paramParcel.writeInt(this.mInclusion);
      paramParcel.writeInt(this.mSort);
      paramParcel.writeString(this.mBucketId);
      paramParcel.writeParcelable(this.mSingleImageUri, paramInt);
      if (this.mIsEmptyImageList);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }

  private static class b
    implements d
  {
    public c a(int paramInt)
    {
      return null;
    }

    public c a(Uri paramUri)
    {
      return null;
    }

    public void a()
    {
    }

    public int b()
    {
      return 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.ImageManager
 * JD-Core Version:    0.6.2
 */