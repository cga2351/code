package com.viber.voip.messages.orm.entity.json.action;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.entity.json.ActionType;
import org.json.JSONException;
import org.json.JSONObject;

public final class ActionFactory
{
  private static final Logger L = ViberEnv.getLogger();

  public static Action createAction(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null);
    ActionType localActionType;
    do
    {
      return null;
      localActionType = ActionType.toEnum(paramJSONObject.getString("name"));
    }
    while (localActionType == null);
    switch (1.$SwitchMap$com$viber$voip$messages$orm$entity$json$ActionType[localActionType.ordinal()])
    {
    default:
      return null;
    case 1:
      return new PreviewPublicGroupAction(paramJSONObject);
    case 2:
      return new FollowPublicGroupAction(paramJSONObject);
    case 3:
      return new AddContactAction(paramJSONObject);
    case 4:
      return new BlockPublicGroupAction(paramJSONObject);
    case 5:
      return new BlockTpaAction(paramJSONObject);
    case 6:
      return new ForwardAction(paramJSONObject);
    case 7:
      return new CopyAction(paramJSONObject);
    case 8:
      return new DownloadStickerPackAction(paramJSONObject);
    case 9:
      return new GetStickerPackAction(paramJSONObject);
    case 10:
      return new InitCallAction(paramJSONObject);
    case 11:
      return new OpenAppAction(paramJSONObject);
    case 12:
      return new OpenUrlAction(paramJSONObject);
    case 13:
      return new OpenStoreAction(paramJSONObject);
    case 14:
      return new OpenConversation(paramJSONObject);
    case 15:
      return new ViberOutPurchaseAction(paramJSONObject);
    case 16:
      return new ViewPhotoAction(paramJSONObject);
    case 17:
      return new ViewVideoAction(paramJSONObject);
    case 18:
    }
    return new InviteContactAction(paramJSONObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ActionFactory
 * JD-Core Version:    0.6.2
 */