package com.viber.voip.phone.viber.conference.mapper;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallEntity;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import javax.inject.Inject;

public class ConferenceCallMapper
{
  private final a<ConferenceInfo> mJsonDeserializer;

  @Inject
  public ConferenceCallMapper(a<ConferenceInfo> parama)
  {
    this.mJsonDeserializer = parama;
  }

  public ContentValues mapToConferenceInfoContentValues(OngoingConferenceCallEntity paramOngoingConferenceCallEntity)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("conference_info", paramOngoingConferenceCallEntity.conferenceInfo);
    return localContentValues;
  }

  public ContentValues mapToContentValues(OngoingConferenceCallEntity paramOngoingConferenceCallEntity)
  {
    ContentValues localContentValues = new ContentValues(5);
    if (paramOngoingConferenceCallEntity.id > 0L)
      localContentValues.put("_id", Long.valueOf(paramOngoingConferenceCallEntity.id));
    localContentValues.put("call_token", Long.valueOf(paramOngoingConferenceCallEntity.callToken));
    localContentValues.put("conversation_id", Long.valueOf(paramOngoingConferenceCallEntity.conversationId));
    localContentValues.put("conference_info", paramOngoingConferenceCallEntity.conferenceInfo);
    localContentValues.put("start_time_millis", Long.valueOf(paramOngoingConferenceCallEntity.startTimeMillis));
    return localContentValues;
  }

  public OngoingConferenceCallModel mapToModel(OngoingConferenceCallEntity paramOngoingConferenceCallEntity)
  {
    ConferenceInfo localConferenceInfo = (ConferenceInfo)this.mJsonDeserializer.a(paramOngoingConferenceCallEntity.conferenceInfo);
    return new OngoingConferenceCallModel(paramOngoingConferenceCallEntity.conversationId, paramOngoingConferenceCallEntity.callToken, paramOngoingConferenceCallEntity.startTimeMillis, localConferenceInfo);
  }

  public OngoingConferenceCallEntity mapToRepositoryEntity(Cursor paramCursor)
  {
    return new OngoingConferenceCallEntity(paramCursor.getLong(0), paramCursor.getLong(1), paramCursor.getLong(2), paramCursor.getString(3), paramCursor.getLong(4));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.mapper.ConferenceCallMapper
 * JD-Core Version:    0.6.2
 */