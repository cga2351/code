package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.common.dialogs.h.a;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.b;
import com.viber.voip.billing.b.d;
import com.viber.voip.billing.l;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.ui.dialogs.af;
import org.json.JSONException;
import org.json.JSONObject;

public class ViberOutPurchaseAction extends Action
{
  public static final Parcelable.Creator<ViberOutPurchaseAction> CREATOR = new Parcelable.Creator()
  {
    public ViberOutPurchaseAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ViberOutPurchaseAction(paramAnonymousParcel);
    }

    public ViberOutPurchaseAction[] newArray(int paramAnonymousInt)
    {
      return new ViberOutPurchaseAction[paramAnonymousInt];
    }
  };
  private static final String KEY_PRODUCT_ID = "product";
  private final String mProductId;

  ViberOutPurchaseAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mProductId = paramParcel.readString();
  }

  ViberOutPurchaseAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    this.mProductId = paramJSONObject.getJSONObject("parameters").getString("product");
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, final Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    b.a().a(new b.d()
    {
      public void onBillingHealthIssues(int paramAnonymousInt)
      {
        if (paramExecuteListener != null)
          paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
        af.a("ViberOutPurchaseAction error: " + paramAnonymousInt).d();
      }

      public void onBillingHealthOk()
      {
        if (!TextUtils.isEmpty(ViberOutPurchaseAction.this.mProductId))
        {
          l.a().a(IabProductId.fromString(ViberOutPurchaseAction.this.mProductId));
          if (paramExecuteListener != null)
            paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
          return;
        }
        if (paramExecuteListener != null)
          paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
        af.a("ViberOutPurchaseAction empty productId").d();
      }
    });
  }

  public String getProductId()
  {
    return this.mProductId;
  }

  public ActionType getType()
  {
    return ActionType.VO_PURCHASE;
  }

  public String toString()
  {
    return getType() + " {productId='" + this.mProductId + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mProductId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ViberOutPurchaseAction
 * JD-Core Version:    0.6.2
 */