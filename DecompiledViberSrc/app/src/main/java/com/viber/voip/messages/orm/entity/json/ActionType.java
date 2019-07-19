package com.viber.voip.messages.orm.entity.json;

public enum ActionType
{
  private final String mAction;

  static
  {
    BLOCK_PUBLIC_GROUP = new ActionType("BLOCK_PUBLIC_GROUP", 2, "blockgroup");
    BLOCK_TPA = new ActionType("BLOCK_TPA", 3, "blocktpa");
    FORWARD = new ActionType("FORWARD", 4, "forward");
    COPY = new ActionType("COPY", 5, "copy");
    GET_STICKER_PACK = new ActionType("GET_STICKER_PACK", 6, "getstickerpack");
    DOWNLOAD_STCKER_PACK = new ActionType("DOWNLOAD_STCKER_PACK", 7, "downloadstickerpack");
    ADD_CONTACT = new ActionType("ADD_CONTACT", 8, "addcontact");
    VO_PURCHASE = new ActionType("VO_PURCHASE", 9, "vopurchase");
    INIT_CALL = new ActionType("INIT_CALL", 10, "initiatecall");
    VIEW_PHOTO = new ActionType("VIEW_PHOTO", 11, "viewphoto");
    VIEW_VIDEO = new ActionType("VIEW_VIDEO", 12, "viewvideo");
    OPEN_URL = new ActionType("OPEN_URL", 13, "openurl");
    OPEN_APP = new ActionType("OPEN_APP", 14, "openapp");
    OPEN_STORE = new ActionType("OPEN_STORE", 15, "openstore");
    OPEN_CONVERSATION = new ActionType("OPEN_CONVERSATION", 16, "openconversation");
    PREVIEW_PUBLIC_ACCOUNT = new ActionType("PREVIEW_PUBLIC_ACCOUNT", 17, "previewpublicaccount");
    INVITE_CONTACT = new ActionType("INVITE_CONTACT", 18, "_invitecontact");
    ActionType[] arrayOfActionType = new ActionType[19];
    arrayOfActionType[0] = FOLLOW_PUBLIC_GROUP;
    arrayOfActionType[1] = PREVIEW_PUBLIC_GROUP;
    arrayOfActionType[2] = BLOCK_PUBLIC_GROUP;
    arrayOfActionType[3] = BLOCK_TPA;
    arrayOfActionType[4] = FORWARD;
    arrayOfActionType[5] = COPY;
    arrayOfActionType[6] = GET_STICKER_PACK;
    arrayOfActionType[7] = DOWNLOAD_STCKER_PACK;
    arrayOfActionType[8] = ADD_CONTACT;
    arrayOfActionType[9] = VO_PURCHASE;
    arrayOfActionType[10] = INIT_CALL;
    arrayOfActionType[11] = VIEW_PHOTO;
    arrayOfActionType[12] = VIEW_VIDEO;
    arrayOfActionType[13] = OPEN_URL;
    arrayOfActionType[14] = OPEN_APP;
    arrayOfActionType[15] = OPEN_STORE;
    arrayOfActionType[16] = OPEN_CONVERSATION;
    arrayOfActionType[17] = PREVIEW_PUBLIC_ACCOUNT;
    arrayOfActionType[18] = INVITE_CONTACT;
  }

  private ActionType(String paramString)
  {
    this.mAction = paramString;
  }

  public static ActionType toEnum(String paramString)
  {
    for (ActionType localActionType : values())
      if (localActionType.mAction.equalsIgnoreCase(paramString))
        return localActionType;
    return null;
  }

  public String getAction()
  {
    return this.mAction;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.ActionType
 * JD-Core Version:    0.6.2
 */