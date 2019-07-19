package com.viber.voip.messages.ui.media;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.ViberEnv;
import com.viber.voip.camrecorder.preview.DoodleDataContainer;
import com.viber.voip.e.a.c;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo.a;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.util.aw;
import com.viber.voip.util.bw;
import com.viber.voip.util.e.j;

public class SendMediaDataContainer
  implements Parcelable
{
  public static final Parcelable.Creator<SendMediaDataContainer> CREATOR = new Parcelable.Creator()
  {
    public SendMediaDataContainer a(Parcel paramAnonymousParcel)
    {
      return new SendMediaDataContainer(paramAnonymousParcel);
    }

    public SendMediaDataContainer[] a(int paramAnonymousInt)
    {
      return new SendMediaDataContainer[paramAnonymousInt];
    }
  };
  private static final com.viber.common.a.e L = ViberEnv.getLogger();
  public Uri croppedImage;
  public String description;
  public Uri fileUri;
  public int mediaFlag;
  public MediaInfo mediaInfo;
  public ScreenshotConversationData screenshotConversationData;
  public Uri thumbnailUri;
  public int type;
  public boolean useConversionIfRequire;
  public WinkDescription winkDescription;

  public SendMediaDataContainer()
  {
    this.useConversionIfRequire = true;
  }

  public SendMediaDataContainer(Context paramContext, Uri paramUri, int paramInt, String paramString, WinkDescription paramWinkDescription, DoodleDataContainer paramDoodleDataContainer)
  {
    this.useConversionIfRequire = true;
    this.fileUri = paramUri;
    this.type = paramInt;
    this.description = paramString;
    this.winkDescription = paramWinkDescription;
    if ((1 == paramInt) || (1003 == paramInt));
    for (this.mediaInfo = createImageMediaInfo(paramContext); ; this.mediaInfo = createVideoMediaInfo(paramContext))
      do
      {
        if ((paramDoodleDataContainer != null) && (paramDoodleDataContainer.doodle))
        {
          if (!paramDoodleDataContainer.emptyBackground)
            break;
          this.mediaFlag = 2;
        }
        return;
      }
      while ((3 != paramInt) && (1004 != paramInt));
    this.mediaFlag = 1;
  }

  public SendMediaDataContainer(Context paramContext, GalleryItem paramGalleryItem)
  {
    this.useConversionIfRequire = i;
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "SendMediaDataContainer create");
    this.fileUri = paramGalleryItem.getItemUri();
    this.description = paramGalleryItem.getDescription();
    if (j.e(this.fileUri))
      i = 3;
    this.type = i;
    if (paramGalleryItem.isGif())
      this.mediaInfo = createGifMediaInfo();
    while (true)
    {
      com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "SendMediaDataContainer create");
      return;
      if (paramGalleryItem.isImage())
        this.mediaInfo = createImageMediaInfo(paramContext);
      else if (paramGalleryItem.isVideo())
        this.mediaInfo = createVideoMediaInfo(paramContext);
    }
  }

  public SendMediaDataContainer(Context paramContext, SendMediaDataContainer paramSendMediaDataContainer)
  {
    this(paramContext, paramSendMediaDataContainer.fileUri, paramSendMediaDataContainer.type, paramSendMediaDataContainer.description, paramSendMediaDataContainer.winkDescription, null);
  }

  SendMediaDataContainer(Parcel paramParcel)
  {
    this.useConversionIfRequire = true;
    this.fileUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.croppedImage = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.thumbnailUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.description = paramParcel.readString();
    this.mediaFlag = paramParcel.readInt();
    this.winkDescription = ((WinkDescription)paramParcel.readParcelable(WinkDescription.class.getClassLoader()));
    if (1 == paramParcel.readByte());
    for (boolean bool = true; ; bool = false)
    {
      this.useConversionIfRequire = bool;
      this.mediaInfo = ((MediaInfo)paramParcel.readParcelable(MediaInfo.class.getClassLoader()));
      this.screenshotConversationData = ((ScreenshotConversationData)paramParcel.readParcelable(ScreenshotConversationData.class.getClassLoader()));
      return;
    }
  }

  private MediaInfo createGifMediaInfo()
  {
    Rect localRect = aw.a(this.fileUri);
    if (!localRect.isEmpty())
    {
      MediaInfo localMediaInfo = new MediaInfo();
      localMediaInfo.setMediaType(MediaInfo.a.GIF);
      localMediaInfo.setWidth(localRect.width());
      localMediaInfo.setHeight(localRect.height());
      return localMediaInfo;
    }
    return null;
  }

  private MediaInfo createImageMediaInfo(Context paramContext)
  {
    BitmapFactory.Options localOptions = j.a(paramContext, this.fileUri, 0);
    if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
    {
      MediaInfo localMediaInfo = new MediaInfo();
      localMediaInfo.setMediaType(MediaInfo.a.IMAGE);
      localMediaInfo.setWidth(localOptions.outWidth);
      localMediaInfo.setHeight(localOptions.outHeight);
      return localMediaInfo;
    }
    return null;
  }

  private MediaInfo createVideoMediaInfo(Context paramContext)
  {
    int[] arrayOfInt = bw.a(paramContext, this.fileUri);
    if ((arrayOfInt[0] > 0) && (arrayOfInt[1] > 0))
    {
      MediaInfo localMediaInfo = new MediaInfo();
      localMediaInfo.setMediaType(MediaInfo.a.VIDEO);
      localMediaInfo.setWidth(arrayOfInt[0]);
      localMediaInfo.setHeight(arrayOfInt[1]);
      return localMediaInfo;
    }
    return null;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "SendMediaDataContainer{fileUri=" + this.fileUri + ", croppedImage=" + this.croppedImage + ", thumbnailUri=" + this.thumbnailUri + ", type='" + this.type + '\'' + ", description='" + this.description + '\'' + ", mediaFlag=" + this.mediaFlag + ", mWinkDescription=" + this.winkDescription + ", useConversionIfRequire=" + this.useConversionIfRequire + ", mediaInfo=" + this.mediaInfo + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.fileUri, 0);
    paramParcel.writeParcelable(this.croppedImage, 0);
    paramParcel.writeParcelable(this.thumbnailUri, 0);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.mediaFlag);
    paramParcel.writeParcelable(this.winkDescription, 0);
    if (this.useConversionIfRequire);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.mediaInfo, 0);
      paramParcel.writeParcelable(this.screenshotConversationData, paramInt);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.SendMediaDataContainer
 * JD-Core Version:    0.6.2
 */