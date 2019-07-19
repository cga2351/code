package com.viber.voip.phone.viber.conference.model;

public class OngoingConferenceCallEntity
{
  public final long callToken;
  public final String conferenceInfo;
  public final long conversationId;
  public final long id;
  public final long startTimeMillis;

  public OngoingConferenceCallEntity(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4)
  {
    this.id = paramLong1;
    this.conversationId = paramLong2;
    this.callToken = paramLong3;
    this.conferenceInfo = paramString;
    this.startTimeMillis = paramLong4;
  }

  public OngoingConferenceCallEntity(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    this(0L, paramLong1, paramLong2, paramString, paramLong3);
  }

  public OngoingConferenceCallEntity copyWith(String paramString)
  {
    return new OngoingConferenceCallEntity(this.id, this.conversationId, this.callToken, paramString, this.startTimeMillis);
  }

  public String toString()
  {
    return "OngoingConferenceCallEntity{id=" + this.id + ", conversationId=" + this.conversationId + ", callToken=" + this.callToken + ", startTimeMillis=" + this.startTimeMillis + ", conferenceInfo='" + this.conferenceInfo + '\'' + '}';
  }

  public static abstract interface DatabaseColumnIndex
  {
    public static final int CALL_TOKEN = 2;
    public static final int CONFERENCE_INFO = 3;
    public static final int CONVERSATION_ID = 1;
    public static final int ID = 0;
    public static final int START_TIME_MILLIS = 4;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.model.OngoingConferenceCallEntity
 * JD-Core Version:    0.6.2
 */