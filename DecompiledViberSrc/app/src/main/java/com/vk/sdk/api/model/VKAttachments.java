package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vk.sdk.util.VKStringJoiner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class VKAttachments extends VKList<VKApiAttachment>
  implements Parcelable
{
  public static Parcelable.Creator<VKAttachments> CREATOR = new Parcelable.Creator()
  {
    public VKAttachments createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKAttachments(paramAnonymousParcel);
    }

    public VKAttachments[] newArray(int paramAnonymousInt)
    {
      return new VKAttachments[paramAnonymousInt];
    }
  };
  public static final String TYPE_ALBUM = "album";
  public static final String TYPE_APP = "app";
  public static final String TYPE_AUDIO = "audio";
  public static final String TYPE_DOC = "doc";
  public static final String TYPE_LINK = "link";
  public static final String TYPE_NOTE = "note";
  public static final String TYPE_PHOTO = "photo";
  public static final String TYPE_POLL = "poll";
  public static final String TYPE_POST = "wall";
  public static final String TYPE_POSTED_PHOTO = "posted_photo";
  public static final String TYPE_VIDEO = "video";
  public static final String TYPE_WIKI_PAGE = "page";
  private final VKList.Parser<VKApiAttachment> parser = new VKList.Parser()
  {
    public VKAttachments.VKApiAttachment parseObject(JSONObject paramAnonymousJSONObject)
      throws Exception
    {
      String str = paramAnonymousJSONObject.optString("type");
      if ("photo".equals(str))
        return new VKApiPhoto().parse(paramAnonymousJSONObject.getJSONObject("photo"));
      if ("video".equals(str))
        return new VKApiVideo().parse(paramAnonymousJSONObject.getJSONObject("video"));
      if ("audio".equals(str))
        return new VKApiAudio().parse(paramAnonymousJSONObject.getJSONObject("audio"));
      if ("doc".equals(str))
        return new VKApiDocument().parse(paramAnonymousJSONObject.getJSONObject("doc"));
      if ("wall".equals(str))
        return new VKApiPost().parse(paramAnonymousJSONObject.getJSONObject("wall"));
      if ("posted_photo".equals(str))
        return new VKApiPostedPhoto().parse(paramAnonymousJSONObject.getJSONObject("posted_photo"));
      if ("link".equals(str))
        return new VKApiLink().parse(paramAnonymousJSONObject.getJSONObject("link"));
      if ("note".equals(str))
        return new VKApiNote().parse(paramAnonymousJSONObject.getJSONObject("note"));
      if ("app".equals(str))
        return new VKApiApplicationContent().parse(paramAnonymousJSONObject.getJSONObject("app"));
      if ("poll".equals(str))
        return new VKApiPoll().parse(paramAnonymousJSONObject.getJSONObject("poll"));
      if ("page".equals(str))
        return new VKApiWikiPage().parse(paramAnonymousJSONObject.getJSONObject("page"));
      if ("album".equals(str))
        return new VKApiPhotoAlbum().parse(paramAnonymousJSONObject.getJSONObject("album"));
      return null;
    }
  };

  public VKAttachments()
  {
  }

  public VKAttachments(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    int j = 0;
    if (j < i)
    {
      String str = paramParcel.readString();
      if ("photo".equals(str))
        add((VKApiAttachment)paramParcel.readParcelable(VKApiPhoto.class.getClassLoader()));
      while (true)
      {
        j++;
        break;
        if ("video".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiVideo.class.getClassLoader()));
        else if ("audio".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiAudio.class.getClassLoader()));
        else if ("doc".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiDocument.class.getClassLoader()));
        else if ("wall".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiPost.class.getClassLoader()));
        else if ("posted_photo".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiPostedPhoto.class.getClassLoader()));
        else if ("link".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiLink.class.getClassLoader()));
        else if ("note".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiNote.class.getClassLoader()));
        else if ("app".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiApplicationContent.class.getClassLoader()));
        else if ("poll".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiPoll.class.getClassLoader()));
        else if ("page".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiWikiPage.class.getClassLoader()));
        else if ("album".equals(str))
          add((VKApiAttachment)paramParcel.readParcelable(VKApiPhotoAlbum.class.getClassLoader()));
      }
    }
  }

  public VKAttachments(List<? extends VKApiAttachment> paramList)
  {
    super(paramList);
  }

  public VKAttachments(JSONArray paramJSONArray)
  {
    fill(paramJSONArray);
  }

  public VKAttachments(JSONObject paramJSONObject)
  {
    fill(paramJSONObject);
  }

  public VKAttachments(VKApiAttachment[] paramArrayOfVKApiAttachment)
  {
    super(Arrays.asList(paramArrayOfVKApiAttachment));
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(JSONArray paramJSONArray)
  {
    super.fill(paramJSONArray, this.parser);
  }

  public void fill(JSONObject paramJSONObject)
  {
    super.fill(paramJSONObject, this.parser);
  }

  public String toAttachmentsString()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
      localArrayList.add(((VKApiAttachment)localIterator.next()).toAttachmentString());
    return VKStringJoiner.join(localArrayList, ",");
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      VKApiAttachment localVKApiAttachment = (VKApiAttachment)localIterator.next();
      paramParcel.writeString(localVKApiAttachment.getType());
      paramParcel.writeParcelable(localVKApiAttachment, 0);
    }
  }

  public static abstract class VKApiAttachment extends VKApiModel
    implements Identifiable
  {
    public abstract String getType();

    public abstract CharSequence toAttachmentString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKAttachments
 * JD-Core Version:    0.6.2
 */