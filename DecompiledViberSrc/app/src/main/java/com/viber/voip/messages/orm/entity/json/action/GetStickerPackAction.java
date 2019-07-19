package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.Toast;
import com.viber.voip.R.string;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.l;
import com.viber.voip.messages.orm.entity.json.ActionType;
import org.json.JSONException;
import org.json.JSONObject;

public class GetStickerPackAction extends Action
{
  public static final Parcelable.Creator<GetStickerPackAction> CREATOR = new Parcelable.Creator()
  {
    public GetStickerPackAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new GetStickerPackAction(paramAnonymousParcel);
    }

    public GetStickerPackAction[] newArray(int paramAnonymousInt)
    {
      return new GetStickerPackAction[paramAnonymousInt];
    }
  };
  private static final String KEY_PACKAGE_ID = "id";
  private final String mPackageId;

  GetStickerPackAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mPackageId = paramParcel.readString();
  }

  GetStickerPackAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    this.mPackageId = paramJSONObject.getJSONObject("parameters").getString("id");
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    if (!TextUtils.isEmpty(this.mPackageId))
      l.a().a(IabProductId.fromString(this.mPackageId));
    while (true)
    {
      if (paramExecuteListener != null)
        paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
      return;
      Toast.makeText(paramContext, R.string.dialog_902_title, 1).show();
    }
  }

  public String getPackageId()
  {
    return this.mPackageId;
  }

  public ActionType getType()
  {
    return ActionType.GET_STICKER_PACK;
  }

  public String toString()
  {
    return getType() + " {packageId=" + this.mPackageId + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mPackageId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.GetStickerPackAction
 * JD-Core Version:    0.6.2
 */