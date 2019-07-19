package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import android.widget.Toast;
import com.viber.voip.R.string;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.dx;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ViewMediaAction extends Action
{
  private static final String KEY_BUCKET_ID = "bucket_id";
  private static final String KEY_DOWNLOAD_ID = "image_id";
  private static final String KEY_MEDIA_URL = "url";
  private final String mBucketId;
  private long mConversationId;
  private final String mDownloadId;
  protected final String mMediaUrl;

  ViewMediaAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mMediaUrl = paramParcel.readString();
    this.mBucketId = paramParcel.readString();
    this.mDownloadId = paramParcel.readString();
    this.mConversationId = paramParcel.readLong();
  }

  public ViewMediaAction(String paramString, long paramLong)
  {
    this.mMediaUrl = paramString;
    this.mConversationId = paramLong;
    this.mBucketId = null;
    this.mDownloadId = null;
  }

  ViewMediaAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("parameters");
    this.mMediaUrl = localJSONObject.optString("url");
    this.mBucketId = localJSONObject.optString("bucket_id");
    this.mDownloadId = localJSONObject.optString("image_id");
  }

  String buildMediaUrl()
  {
    if ((TextUtils.isEmpty(this.mMediaUrl)) && ((TextUtils.isEmpty(this.mBucketId)) || (TextUtils.isEmpty(this.mDownloadId))))
      return null;
    if (TextUtils.isEmpty(this.mMediaUrl))
      return dx.a(getBucketId(), getDownloadId()).toString();
    return this.mMediaUrl;
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    String str = buildMediaUrl();
    if (str == null)
    {
      Toast.makeText(paramContext, R.string.dialog_download_fail, 1).show();
      if (paramExecuteListener != null)
        paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
    }
    do
    {
      return;
      ViberActionRunner.bm.a(paramContext, str, getMediaType(), this.mConversationId);
    }
    while (paramExecuteListener == null);
    paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
  }

  public String getBucketId()
  {
    return this.mBucketId;
  }

  public long getConversationId()
  {
    return this.mConversationId;
  }

  public String getDownloadId()
  {
    return this.mDownloadId;
  }

  public abstract int getMediaType();

  public void setConversationId(long paramLong)
  {
    this.mConversationId = paramLong;
  }

  public String toString()
  {
    return getType() + " {mediaUrl='" + this.mMediaUrl + '\'' + ", bucketId='" + this.mBucketId + '\'' + ", downloadId='" + this.mDownloadId + '\'' + ", conversationId='" + this.mConversationId + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mMediaUrl);
    paramParcel.writeString(this.mBucketId);
    paramParcel.writeString(this.mDownloadId);
    paramParcel.writeLong(this.mConversationId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ViewMediaAction
 * JD-Core Version:    0.6.2
 */