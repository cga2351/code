package com.yandex.mobile.ads.video.models.ad;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.yandex.mobile.ads.impl.pw;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Icon
  implements Parcelable
{
  public static final Parcelable.Creator<Icon> CREATOR = new Parcelable.Creator()
  {
  };
  private String mApiFramework;
  private Long mDuration;
  private Integer mHeight;
  private IconHorizontalPosition mHorizontalPosition;
  private Long mOffset;
  private String mProgram;
  private IconResourceType mResourceType;
  private String mResourceUrl;
  private IconVerticalPosition mVerticalPosition;
  private Integer mWidth;
  private Integer mX;
  private Integer mY;

  public Icon()
  {
  }

  private Icon(Parcel paramParcel)
  {
    this.mResourceUrl = paramParcel.readString();
    int i = paramParcel.readInt();
    IconResourceType localIconResourceType;
    int j;
    IconHorizontalPosition localIconHorizontalPosition;
    label84: int k;
    IconVerticalPosition localIconVerticalPosition;
    if (i == -1)
    {
      localIconResourceType = null;
      this.mResourceType = localIconResourceType;
      this.mProgram = paramParcel.readString();
      this.mWidth = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
      this.mHeight = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
      j = paramParcel.readInt();
      if (j != -1)
        break label193;
      localIconHorizontalPosition = null;
      this.mHorizontalPosition = localIconHorizontalPosition;
      k = paramParcel.readInt();
      localIconVerticalPosition = null;
      if (k != -1)
        break label204;
    }
    while (true)
    {
      this.mVerticalPosition = localIconVerticalPosition;
      this.mApiFramework = paramParcel.readString();
      this.mOffset = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.mDuration = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.mX = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
      this.mY = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
      return;
      localIconResourceType = IconResourceType.values()[i];
      break;
      label193: localIconHorizontalPosition = IconHorizontalPosition.values()[j];
      break label84;
      label204: localIconVerticalPosition = IconVerticalPosition.values()[k];
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getApiFramework()
  {
    return this.mApiFramework;
  }

  public Long getDuration()
  {
    return this.mDuration;
  }

  public Integer getHeight()
  {
    return this.mHeight;
  }

  public IconHorizontalPosition getHorizontalPosition()
  {
    return this.mHorizontalPosition;
  }

  public Long getOffset()
  {
    return this.mOffset;
  }

  public String getProgram()
  {
    return this.mProgram;
  }

  public IconResourceType getResourceType()
  {
    return this.mResourceType;
  }

  public String getResourceUrl()
  {
    return this.mResourceUrl;
  }

  public IconVerticalPosition getVerticalPosition()
  {
    return this.mVerticalPosition;
  }

  public Integer getWidth()
  {
    return this.mWidth;
  }

  public Integer getXPosition()
  {
    return this.mX;
  }

  public Integer getYPosition()
  {
    return this.mY;
  }

  public void setApiFramework(String paramString)
  {
    this.mApiFramework = paramString;
  }

  public void setDuration(String paramString)
  {
    this.mDuration = pw.a(paramString);
  }

  public void setHeight(String paramString)
  {
    this.mHeight = pw.b(paramString);
  }

  public void setHorizontalPosition(String paramString)
  {
    this.mHorizontalPosition = IconHorizontalPosition.getPosition(paramString);
    if (this.mHorizontalPosition == IconHorizontalPosition.ICON_HORIZONTAL_POSITION_LEFT_OFFSET)
      this.mX = pw.b(paramString);
  }

  public void setOffset(String paramString)
  {
    this.mOffset = pw.a(paramString);
  }

  public void setProgram(String paramString)
  {
    this.mProgram = paramString;
  }

  public void setResourceType(String paramString)
  {
    this.mResourceType = IconResourceType.getConvertType(paramString);
  }

  public void setResourceUrl(String paramString)
  {
    this.mResourceUrl = paramString;
  }

  public void setVerticalPosition(String paramString)
  {
    this.mVerticalPosition = IconVerticalPosition.getPosition(paramString);
    if (this.mVerticalPosition == IconVerticalPosition.ICON_VERTICAL_POSITION_TOP_OFFSET)
      this.mY = pw.b(paramString);
  }

  public void setWidth(String paramString)
  {
    this.mWidth = pw.b(paramString);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    paramParcel.writeString(this.mResourceUrl);
    int j;
    int k;
    if (this.mResourceType == null)
    {
      j = i;
      paramParcel.writeInt(j);
      paramParcel.writeString(this.mProgram);
      paramParcel.writeValue(this.mWidth);
      paramParcel.writeValue(this.mHeight);
      if (this.mHorizontalPosition != null)
        break label131;
      k = i;
      label60: paramParcel.writeInt(k);
      if (this.mVerticalPosition != null)
        break label143;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.mApiFramework);
      paramParcel.writeValue(this.mOffset);
      paramParcel.writeValue(this.mDuration);
      paramParcel.writeValue(this.mX);
      paramParcel.writeValue(this.mY);
      return;
      j = this.mResourceType.ordinal();
      break;
      label131: k = this.mHorizontalPosition.ordinal();
      break label60;
      label143: i = this.mVerticalPosition.ordinal();
    }
  }

  public static enum IconHorizontalPosition
  {
    public final String horizontalPosition;

    static
    {
      ICON_HORIZONTAL_POSITION_LEFT_OFFSET = new IconHorizontalPosition("ICON_HORIZONTAL_POSITION_LEFT_OFFSET", 2, "leftOffset");
      IconHorizontalPosition[] arrayOfIconHorizontalPosition = new IconHorizontalPosition[3];
      arrayOfIconHorizontalPosition[0] = ICON_HORIZONTAL_POSITION_LEFT;
      arrayOfIconHorizontalPosition[1] = ICON_HORIZONTAL_POSITION_RIGHT;
      arrayOfIconHorizontalPosition[2] = ICON_HORIZONTAL_POSITION_LEFT_OFFSET;
    }

    private IconHorizontalPosition(String paramString)
    {
      this.horizontalPosition = paramString;
    }

    private static IconHorizontalPosition getPosition(String paramString)
    {
      if ("left".equals(paramString))
        return ICON_HORIZONTAL_POSITION_LEFT;
      if ("right".equals(paramString))
        return ICON_HORIZONTAL_POSITION_RIGHT;
      return ICON_HORIZONTAL_POSITION_LEFT_OFFSET;
    }
  }

  public static enum IconResourceType
  {
    public final String resourceType;

    static
    {
      IFRAME_RESOURCE = new IconResourceType("IFRAME_RESOURCE", 1, "IFrameResource");
      HTML_RESOURCE = new IconResourceType("HTML_RESOURCE", 2, "HTMLResource");
      IconResourceType[] arrayOfIconResourceType = new IconResourceType[3];
      arrayOfIconResourceType[0] = STATIC_RESOURCE;
      arrayOfIconResourceType[1] = IFRAME_RESOURCE;
      arrayOfIconResourceType[2] = HTML_RESOURCE;
    }

    private IconResourceType(String paramString)
    {
      this.resourceType = paramString;
    }

    public static boolean contains(String paramString)
    {
      Iterator localIterator = Arrays.asList(values()).iterator();
      while (localIterator.hasNext())
        if (((IconResourceType)localIterator.next()).resourceType.equals(paramString))
          return true;
      return false;
    }

    private static IconResourceType getConvertType(String paramString)
    {
      Iterator localIterator = Arrays.asList(values()).iterator();
      while (localIterator.hasNext())
      {
        IconResourceType localIconResourceType = (IconResourceType)localIterator.next();
        if (localIconResourceType.resourceType.equals(paramString))
          return localIconResourceType;
      }
      return null;
    }
  }

  public static enum IconVerticalPosition
  {
    public final String verticalPosition;

    static
    {
      ICON_VERTICAL_POSITION_BOTTOM = new IconVerticalPosition("ICON_VERTICAL_POSITION_BOTTOM", 1, "bottom");
      ICON_VERTICAL_POSITION_TOP_OFFSET = new IconVerticalPosition("ICON_VERTICAL_POSITION_TOP_OFFSET", 2, "topOffset");
      IconVerticalPosition[] arrayOfIconVerticalPosition = new IconVerticalPosition[3];
      arrayOfIconVerticalPosition[0] = ICON_VERTICAL_POSITION_TOP;
      arrayOfIconVerticalPosition[1] = ICON_VERTICAL_POSITION_BOTTOM;
      arrayOfIconVerticalPosition[2] = ICON_VERTICAL_POSITION_TOP_OFFSET;
    }

    private IconVerticalPosition(String paramString)
    {
      this.verticalPosition = paramString;
    }

    private static IconVerticalPosition getPosition(String paramString)
    {
      if ("top".equals(paramString))
        return ICON_VERTICAL_POSITION_TOP;
      if ("bottom".equals(paramString))
        return ICON_VERTICAL_POSITION_BOTTOM;
      return ICON_VERTICAL_POSITION_TOP_OFFSET;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.models.ad.Icon
 * JD-Core Version:    0.6.2
 */