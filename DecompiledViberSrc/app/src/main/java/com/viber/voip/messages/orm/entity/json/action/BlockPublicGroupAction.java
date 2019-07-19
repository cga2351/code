package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.util.bk;
import org.json.JSONException;
import org.json.JSONObject;

public class BlockPublicGroupAction extends Action
{
  public static final Parcelable.Creator<BlockPublicGroupAction> CREATOR = new Parcelable.Creator()
  {
    public BlockPublicGroupAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BlockPublicGroupAction(paramAnonymousParcel);
    }

    public BlockPublicGroupAction[] newArray(int paramAnonymousInt)
    {
      return new BlockPublicGroupAction[paramAnonymousInt];
    }
  };
  private static final String KEY_GROUP_ID = "group_id";
  private static final String KEY_IMAGE_ID = "image_id";
  private static final String KEY_NAME = "name";
  private final long mGroupId;
  private final String mGroupName;
  private final String mImageId;

  BlockPublicGroupAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mGroupName = paramParcel.readString();
    this.mGroupId = paramParcel.readLong();
    this.mImageId = paramParcel.readString();
  }

  BlockPublicGroupAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("parameters");
    this.mGroupName = localJSONObject.getString("name");
    this.mImageId = localJSONObject.getString("image_id");
    this.mGroupId = bk.a("group_id", localJSONObject.getString("group_id"));
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
  }

  public long getGroupId()
  {
    return this.mGroupId;
  }

  public String getGroupName()
  {
    return this.mGroupName;
  }

  public String getImageId()
  {
    return this.mImageId;
  }

  public ActionType getType()
  {
    return ActionType.BLOCK_PUBLIC_GROUP;
  }

  public String toString()
  {
    return getType() + " {groupName='" + this.mGroupName + '\'' + ", groupId='" + this.mGroupId + '\'' + ", imageId='" + this.mImageId + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mGroupName);
    paramParcel.writeLong(this.mGroupId);
    paramParcel.writeString(this.mImageId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.BlockPublicGroupAction
 * JD-Core Version:    0.6.2
 */