package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiPhotoSize extends VKApiModel
  implements Parcelable, Identifiable, Comparable<VKApiPhotoSize>
{
  public static Parcelable.Creator<VKApiPhotoSize> CREATOR = new Parcelable.Creator()
  {
    public VKApiPhotoSize createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiPhotoSize(paramAnonymousParcel, null);
    }

    public VKApiPhotoSize[] newArray(int paramAnonymousInt)
    {
      return new VKApiPhotoSize[paramAnonymousInt];
    }
  };
  public static final char M = 'm';
  public static final char O = 'o';
  public static final char P = 'p';
  public static final char Q = 'q';
  public static final char S = 's';
  public static final char W = 'w';
  public static final char X = 'x';
  public static final char Y = 'y';
  public static final char Z = 'z';
  public int height;
  public String src;
  public char type;
  public int width;

  private VKApiPhotoSize()
  {
  }

  private VKApiPhotoSize(Parcel paramParcel)
  {
    this.src = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.type = ((char)paramParcel.readInt());
  }

  public VKApiPhotoSize(JSONObject paramJSONObject)
    throws JSONException
  {
    parse(paramJSONObject, 0, 0);
  }

  public static VKApiPhotoSize create(String paramString, char paramChar, int paramInt1, int paramInt2)
  {
    VKApiPhotoSize localVKApiPhotoSize = new VKApiPhotoSize();
    localVKApiPhotoSize.src = paramString;
    localVKApiPhotoSize.type = paramChar;
    fillDimensions(localVKApiPhotoSize, paramInt1, paramInt2);
    return localVKApiPhotoSize;
  }

  public static VKApiPhotoSize create(String paramString, int paramInt)
  {
    return create(paramString, paramInt, paramInt);
  }

  public static VKApiPhotoSize create(String paramString, int paramInt1, int paramInt2)
  {
    VKApiPhotoSize localVKApiPhotoSize = new VKApiPhotoSize();
    localVKApiPhotoSize.src = paramString;
    localVKApiPhotoSize.width = paramInt1;
    localVKApiPhotoSize.height = paramInt2;
    float f = paramInt1 / paramInt2;
    if (paramInt1 <= 75)
      localVKApiPhotoSize.type = 's';
    do
    {
      return localVKApiPhotoSize;
      if (paramInt1 <= 130)
      {
        if (f <= 1.5F);
        for (char c = 'o'; ; c = 'm')
        {
          localVKApiPhotoSize.type = c;
          return localVKApiPhotoSize;
        }
      }
      if ((paramInt1 <= 200) && (f <= 1.5F))
      {
        localVKApiPhotoSize.type = 'p';
        return localVKApiPhotoSize;
      }
      if ((paramInt1 <= 320) && (f <= 1.5F))
      {
        localVKApiPhotoSize.type = 'q';
        return localVKApiPhotoSize;
      }
      if (paramInt1 <= 604)
      {
        localVKApiPhotoSize.type = 'x';
        return localVKApiPhotoSize;
      }
      if (paramInt1 <= 807)
      {
        localVKApiPhotoSize.type = 'y';
        return localVKApiPhotoSize;
      }
      if ((paramInt1 <= 1280) && (paramInt2 <= 1024))
      {
        localVKApiPhotoSize.type = 'z';
        return localVKApiPhotoSize;
      }
    }
    while ((paramInt1 > 2560) || (paramInt2 > 2048));
    localVKApiPhotoSize.type = 'w';
    return localVKApiPhotoSize;
  }

  private static void fillDimensionOPQ(VKApiPhotoSize paramVKApiPhotoSize, float paramFloat, int paramInt)
  {
    fillDimensionSMXY(paramVKApiPhotoSize, Math.min(1.5F, paramFloat), paramInt);
  }

  private static void fillDimensionSMXY(VKApiPhotoSize paramVKApiPhotoSize, float paramFloat, int paramInt)
  {
    paramVKApiPhotoSize.width = paramInt;
    paramVKApiPhotoSize.height = ((int)Math.ceil(paramVKApiPhotoSize.width / paramFloat));
  }

  private static void fillDimensionZW(VKApiPhotoSize paramVKApiPhotoSize, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramFloat > 1.0F)
    {
      paramVKApiPhotoSize.width = paramInt1;
      paramVKApiPhotoSize.height = ((int)(paramVKApiPhotoSize.width / paramFloat));
      return;
    }
    paramVKApiPhotoSize.height = paramInt2;
    paramVKApiPhotoSize.width = ((int)(paramFloat * paramVKApiPhotoSize.height));
  }

  private static void fillDimensions(VKApiPhotoSize paramVKApiPhotoSize, int paramInt1, int paramInt2)
  {
    float f = paramInt1 / paramInt2;
    switch (paramVKApiPhotoSize.type)
    {
    case 'n':
    case 'r':
    case 't':
    case 'u':
    case 'v':
    default:
      return;
    case 's':
      fillDimensionSMXY(paramVKApiPhotoSize, f, Math.min(paramInt1, 75));
      return;
    case 'm':
      fillDimensionSMXY(paramVKApiPhotoSize, f, Math.min(paramInt1, 130));
      return;
    case 'x':
      fillDimensionSMXY(paramVKApiPhotoSize, f, Math.min(paramInt1, 604));
      return;
    case 'y':
      fillDimensionSMXY(paramVKApiPhotoSize, f, Math.min(paramInt1, 807));
      return;
    case 'o':
      fillDimensionOPQ(paramVKApiPhotoSize, f, Math.min(paramInt1, 130));
      return;
    case 'p':
      fillDimensionOPQ(paramVKApiPhotoSize, f, Math.min(paramInt1, 200));
      return;
    case 'q':
      fillDimensionOPQ(paramVKApiPhotoSize, f, Math.min(paramInt1, 320));
      return;
    case 'z':
      fillDimensionZW(paramVKApiPhotoSize, f, Math.min(paramInt1, 1280), Math.min(paramInt2, 1024));
      return;
    case 'w':
    }
    fillDimensionZW(paramVKApiPhotoSize, f, Math.min(paramInt1, 2560), Math.min(paramInt2, 2048));
  }

  public static VKApiPhotoSize parse(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    VKApiPhotoSize localVKApiPhotoSize = new VKApiPhotoSize();
    localVKApiPhotoSize.src = paramJSONObject.optString("src");
    localVKApiPhotoSize.width = paramJSONObject.optInt("width");
    localVKApiPhotoSize.height = paramJSONObject.optInt("height");
    String str = paramJSONObject.optString("type");
    if (!TextUtils.isEmpty(str))
      localVKApiPhotoSize.type = str.charAt(0);
    if ((localVKApiPhotoSize.width == 0) || (localVKApiPhotoSize.height == 0))
      fillDimensions(localVKApiPhotoSize, paramInt1, paramInt2);
    return localVKApiPhotoSize;
  }

  public int compareTo(VKApiPhotoSize paramVKApiPhotoSize)
  {
    if (this.width < paramVKApiPhotoSize.width)
      return -1;
    if (this.width == paramVKApiPhotoSize.width)
      return 0;
    return 1;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getId()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.src);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.type);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiPhotoSize
 * JD-Core Version:    0.6.2
 */