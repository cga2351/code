package com.viber.provider.messages.b;

import android.net.Uri;
import android.provider.BaseColumns;

public class c
{
  public static final class a
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibermessages/blocked_data");
  }

  public static final class b
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibermessages/chat_extensions_list");
  }

  public static abstract interface c extends BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibermessages/conversation_auxiliary_list");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibermessages/conversation_auxiliary");
  }

  public static final class d
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibermessages/conversations_list");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibermessages/conversation");
    public static final Uri c = Uri.parse("content://com.viber.voip.provider.vibermessages/common_groups");
  }

  public static final class e
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibermessages/messages_list");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibermessages/pin_messages_list");
    public static final Uri c = Uri.parse("content://com.viber.voip.provider.vibermessages/broadcast_message_status");
    public static final Uri d = Uri.parse("content://com.viber.voip.provider.vibermessages/broadcast_message_info");
  }

  public static final class f
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibermessages/message_likes_list");
  }

  public static final class g
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibermessages/participants_list");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibermessages/banned_participants_status");
  }

  public static final class h
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibermessages/conversations_extra_list");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibermessages/conversations_extra_with_ad_list");
    public static final Uri c = Uri.parse("content://com.viber.voip.provider.vibermessages/public_account");
    public static final Uri d = Uri.parse("content://com.viber.voip.provider.vibermessages/community");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.messages.b.c
 * JD-Core Version:    0.6.2
 */