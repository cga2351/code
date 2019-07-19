package com.viber.voip.notif.b.f.b;

import android.support.v4.util.ArrayMap;
import com.viber.voip.R.string;
import java.util.Map;

public class q
{
  private static final Map<Integer, a> a = new ArrayMap();
  private static final a b = new a(R.string.message_notification_wink_text, R.string.message_notification_wink_text_content, R.string.message_notification_group_wink_text);

  static
  {
    a.put(Integer.valueOf(0), new a(R.string.message_notification_text, R.string.message_notification_text_content, R.string.message_notification_text_group));
    a.put(Integer.valueOf(1), new a(R.string.message_notification_photo_text, R.string.message_notification_photo_text_content, R.string.message_notification_photo_group_text));
    a.put(Integer.valueOf(3), new a(R.string.message_notification_video_text, R.string.message_notification_video_text_content, R.string.message_notification_video_group_text));
    a.put(Integer.valueOf(2), new a(R.string.message_notification_voice_text, R.string.message_notification_voice_text_content, R.string.message_notification_voice_group_text));
    a.put(Integer.valueOf(1009), new a(R.string.message_notification_voice_text, R.string.message_notification_voice_text_content, R.string.message_notification_voice_group_text));
    a.put(Integer.valueOf(14), new a(R.string.message_notification_video_ptt_text, R.string.message_notification_video_ptt_text_content, R.string.message_notification_video_ptt_group_text));
    a.put(Integer.valueOf(1010), new a(R.string.message_notification_video_ptt_text, R.string.message_notification_video_ptt_text_content, R.string.message_notification_video_ptt_group_text));
    a.put(Integer.valueOf(4), new a(R.string.message_notification_sticker_text, R.string.message_notification_sticker_text_content, R.string.message_notification_sticker_group_text));
    a.put(Integer.valueOf(5), new a(R.string.message_notification_location_text, R.string.message_notification_location_text_content, R.string.message_notification_location_group_text));
    a.put(Integer.valueOf(1002), new a(R.string.msg_call_missed, R.string.msg_call_missed, R.string.message_notification_group_wink_text));
    a.put(Integer.valueOf(10), new a(R.string.message_notification_file_text, R.string.message_notification_file_text_content, R.string.message_notification_file_group_text));
    a.put(Integer.valueOf(1003), new a(R.string.message_notification_wink_text, R.string.message_notification_wink_text_content, R.string.message_notification_group_wink_text));
    a.put(Integer.valueOf(1004), new a(R.string.message_notification_wink_text, R.string.message_notification_wink_text_content, R.string.message_notification_group_wink_text));
    a.put(Integer.valueOf(1005), new a(R.string.message_notification_gif_group_text, R.string.message_notification_gif_text_content, R.string.message_notification_gif_group_text));
    a.put(Integer.valueOf(7), new a(R.string.message_notification_rich_message_incoming_1on1, R.string.message_type_rich_message, R.string.message_notification_rich_message_incoming_group));
    a.put(Integer.valueOf(9), new a(R.string.message_notification_share_contact_text_content_in_group, R.string.message_notification_share_contact_text_content, R.string.message_notification_share_contact_text_content_in_group));
    a.put(Integer.valueOf(1006), new a(R.string.message_notification_rich_message_incoming_1on1, R.string.message_type_rich_message, R.string.message_notification_rich_message_incoming_group));
  }

  public a a(int paramInt)
  {
    a locala = (a)a.get(Integer.valueOf(paramInt));
    if (locala == null)
      locala = b;
    return locala;
  }

  static class a
  {
    int a;
    int b;
    int c;

    a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }

    int a()
    {
      return this.a;
    }

    int b()
    {
      return this.b;
    }

    int c()
    {
      return this.c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.q
 * JD-Core Version:    0.6.2
 */