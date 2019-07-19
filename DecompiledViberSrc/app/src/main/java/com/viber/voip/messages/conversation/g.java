package com.viber.voip.messages.conversation;

import android.database.Cursor;

public class g
{
  public static final String[] a = { "messages.broadcast_msg_id", "COUNT(*) AS total_count", "SUM(CASE WHEN messages.read_message_time>0 THEN 1 ELSE 0 END) AS read_count" };
  private long b;
  private int c;
  private int d;

  public g(Cursor paramCursor)
  {
    this.b = paramCursor.getLong(0);
    this.c = paramCursor.getInt(1);
    this.d = paramCursor.getInt(2);
  }

  public long a()
  {
    return this.b;
  }

  public String toString()
  {
    return "BroadcastMessageStatusLoaderEntity{mBroadcastMessageId=" + this.b + ", mTotalCount=" + this.c + ", mCountRead=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.g
 * JD-Core Version:    0.6.2
 */