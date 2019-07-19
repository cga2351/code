package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.viber.voip.R.string;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.i.a;
import com.viber.voip.util.bk;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadStickerPackAction extends Action
{
  public static final Parcelable.Creator<DownloadStickerPackAction> CREATOR = new Parcelable.Creator()
  {
    public DownloadStickerPackAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new DownloadStickerPackAction(paramAnonymousParcel);
    }

    public DownloadStickerPackAction[] newArray(int paramAnonymousInt)
    {
      return new DownloadStickerPackAction[paramAnonymousInt];
    }
  };
  private static final String KEY_PACKAGE_ID = "id";
  private final int mPackageId;

  DownloadStickerPackAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mPackageId = paramParcel.readInt();
  }

  DownloadStickerPackAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    this.mPackageId = bk.b("id", paramJSONObject.getJSONObject("parameters").getString("id"));
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    if (this.mPackageId > 0)
      i.a().a(this.mPackageId, i.a.b);
    while (true)
    {
      if (paramExecuteListener != null)
        paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
      return;
      Toast.makeText(paramContext, R.string.dialog_902_title, 1).show();
    }
  }

  public int getPackageId()
  {
    return this.mPackageId;
  }

  public ActionType getType()
  {
    return ActionType.DOWNLOAD_STCKER_PACK;
  }

  public String toString()
  {
    return getType() + " {packageId=" + this.mPackageId + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mPackageId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.DownloadStickerPackAction
 * JD-Core Version:    0.6.2
 */