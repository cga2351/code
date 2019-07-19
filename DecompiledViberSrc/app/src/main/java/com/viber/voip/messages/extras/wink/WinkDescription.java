package com.viber.voip.messages.extras.wink;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.camera.ImageManager;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.b;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;

public final class WinkDescription
  implements Parcelable
{
  public static final Parcelable.Creator<WinkDescription> CREATOR = new Parcelable.Creator()
  {
    public WinkDescription a(Parcel paramAnonymousParcel)
    {
      return new WinkDescription(paramAnonymousParcel);
    }

    public WinkDescription[] a(int paramAnonymousInt)
    {
      return new WinkDescription[paramAnonymousInt];
    }
  };
  private int bombTime;
  private String mimeType;

  public WinkDescription()
  {
  }

  protected WinkDescription(Parcel paramParcel)
  {
    this.bombTime = paramParcel.readInt();
    this.mimeType = paramParcel.readString();
  }

  public static WinkDescription from(int paramInt, String paramString)
  {
    if ((paramInt >= 0) || (paramString.startsWith("video")))
    {
      WinkDescription localWinkDescription = new WinkDescription();
      localWinkDescription.bombTime = paramInt;
      localWinkDescription.mimeType = paramString;
      return localWinkDescription;
    }
    return null;
  }

  public static WinkDescription from(Intent paramIntent)
  {
    if (!paramIntent.getBooleanExtra("com.viber.voip.wink.WINK_MODE_ENABLED", false))
      return null;
    WinkDescription localWinkDescription = new WinkDescription();
    localWinkDescription.bombTime = paramIntent.getIntExtra("com.viber.voip.wink.WINK_BOMB_TIME", -1);
    localWinkDescription.mimeType = paramIntent.getStringExtra("com.viber.voip.wink.WINK_MIME_TYPE");
    return localWinkDescription;
  }

  public static WinkDescription from(aa paramaa)
  {
    try
    {
      FileInfo localFileInfo = paramaa.bz();
      WinkDescription localWinkDescription = new WinkDescription();
      if (localFileInfo.isWinkImage())
      {
        localWinkDescription.bombTime = localFileInfo.getLifeSpan();
        localWinkDescription.mimeType = "image/*";
        return localWinkDescription;
      }
      localWinkDescription.bombTime = ((int)localFileInfo.getDuration());
      localWinkDescription.mimeType = "video/*";
      return localWinkDescription;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public int describeContents()
  {
    return 0;
  }

  public WinkDescription fixBombTime(int paramInt)
  {
    WinkDescription localWinkDescription = new WinkDescription();
    localWinkDescription.bombTime = paramInt;
    localWinkDescription.mimeType = this.mimeType;
    return localWinkDescription;
  }

  public long getBombTimeMillis()
  {
    return 1000L * this.bombTime;
  }

  public boolean isWinkImage()
  {
    return this.mimeType.startsWith("image");
  }

  public String mimeType()
  {
    return this.mimeType;
  }

  public MsgInfo toMessageInfo()
  {
    MsgInfo localMsgInfo = new MsgInfo();
    FileInfo localFileInfo = new FileInfo();
    localMsgInfo.setFileInfo(localFileInfo);
    if (ImageManager.b(this.mimeType));
    for (FileInfo.b localb = FileInfo.b.IMAGE; ; localb = FileInfo.b.VIDEO)
    {
      localFileInfo.setWinkType(localb);
      if (this.bombTime > 0)
        localFileInfo.setLifeSpan(this.bombTime);
      return localMsgInfo;
    }
  }

  public String toString()
  {
    return "{bombTime: " + this.bombTime + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.bombTime);
    paramParcel.writeString(this.mimeType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.wink.WinkDescription
 * JD-Core Version:    0.6.2
 */