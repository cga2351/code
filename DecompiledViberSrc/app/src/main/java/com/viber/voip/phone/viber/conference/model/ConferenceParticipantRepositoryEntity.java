package com.viber.voip.phone.viber.conference.model;

import android.net.Uri;

public class ConferenceParticipantRepositoryEntity
{
  public final ConferenceCallStatus callStatus;
  public final String displayName;
  public final boolean isUnknownParticipant;
  public final String memberId;
  public final String number;
  public final Uri photo;
  public final long statusUpdateTimestampMillis;

  public ConferenceParticipantRepositoryEntity(String paramString1, String paramString2, String paramString3, Uri paramUri, boolean paramBoolean, ConferenceCallStatus paramConferenceCallStatus, long paramLong)
  {
    this.memberId = paramString1;
    this.displayName = paramString2;
    this.number = paramString3;
    this.photo = paramUri;
    this.isUnknownParticipant = paramBoolean;
    this.callStatus = paramConferenceCallStatus;
    this.statusUpdateTimestampMillis = paramLong;
  }

  public String toString()
  {
    return "ConferenceParticipantRepositoryEntity{memberId='" + this.memberId + '\'' + ", displayName='" + this.displayName + '\'' + ", number='" + this.number + '\'' + ", photo=" + this.photo + ", callStatus=" + this.callStatus + ", isUnknownParticipant=" + this.isUnknownParticipant + ", statusUpdateTimestampMillis=" + this.statusUpdateTimestampMillis + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.model.ConferenceParticipantRepositoryEntity
 * JD-Core Version:    0.6.2
 */