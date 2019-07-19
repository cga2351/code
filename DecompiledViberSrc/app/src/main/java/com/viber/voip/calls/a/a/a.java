package com.viber.voip.calls.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.d;
import com.viber.voip.model.entity.CallEntity;
import com.viber.voip.util.p;

public class a
{
  public static int a = 0;
  private static final Logger b = ViberEnv.getLogger();
  private static String[] c = { "_id", "aggregate_hash", "number", "canonized_number", "date", "duration", "type", "looked", "token", "viber_call", "call_id", "end_reason", "start_reason", "viber_call_type", "conference_info" };
  private static int d = 1;
  private static int e = 2;
  private static int f = 3;
  private static int g = 4;
  private static int h = 5;
  private static int i = 6;
  private static int j = 7;
  private static int k = 8;
  private static int l = 9;
  private static int m = 10;
  private static int n = 11;
  private static int o = 12;
  private static int p = 13;
  private static int q = 14;

  private static ContentValues b(CallEntity paramCallEntity)
  {
    ContentValues localContentValues = new ContentValues(15);
    if (paramCallEntity.getId() != -1L)
      localContentValues.put("_id", Long.valueOf(paramCallEntity.getId()));
    if (0L == paramCallEntity.getAggregatedHash())
      localContentValues.put("aggregate_hash", Integer.valueOf(p.a(paramCallEntity.getNumber(), p.a(paramCallEntity))));
    while (true)
    {
      localContentValues.put("number", paramCallEntity.getNumber());
      localContentValues.put("canonized_number", paramCallEntity.getCanonizedNumber());
      localContentValues.put("date", Long.valueOf(paramCallEntity.getDate()));
      localContentValues.put("duration", Long.valueOf(paramCallEntity.getDuration()));
      localContentValues.put("type", Integer.valueOf(paramCallEntity.getType()));
      localContentValues.put("looked", Boolean.valueOf(paramCallEntity.isLooked()));
      localContentValues.put("token", Long.valueOf(paramCallEntity.getToken()));
      localContentValues.put("viber_call", Boolean.valueOf(paramCallEntity.isViberCall()));
      localContentValues.put("call_id", Long.valueOf(paramCallEntity.getNativeCallId()));
      localContentValues.put("end_reason", Integer.valueOf(paramCallEntity.getEndReason()));
      localContentValues.put("start_reason", Integer.valueOf(paramCallEntity.getStartReason()));
      localContentValues.put("viber_call_type", Integer.valueOf(paramCallEntity.getViberCallType()));
      localContentValues.put("conference_info", paramCallEntity.getRawConferenceInfo());
      return localContentValues;
      localContentValues.put("aggregate_hash", Long.valueOf(paramCallEntity.getAggregatedHash()));
    }
  }

  public static abstract class a extends Creator
  {
    public d a(CallEntity paramCallEntity, Cursor paramCursor, int paramInt)
    {
      int i = 1;
      try
      {
        paramCallEntity.setId(paramCursor.getLong(paramInt + a.a));
        paramCallEntity.setAggregatedHash(paramCursor.getLong(paramInt + a.a()));
        paramCallEntity.setNumber(paramCursor.getString(paramInt + a.b()));
        paramCallEntity.setCanonizedNumber(paramCursor.getString(paramInt + a.c()));
        paramCallEntity.setDate(paramCursor.getLong(paramInt + a.d()));
        paramCallEntity.setDuration(paramCursor.getLong(paramInt + a.e()));
        paramCallEntity.setType(paramCursor.getInt(paramInt + a.f()));
        if (paramCursor.getInt(paramInt + a.g()) == i)
        {
          int k = i;
          paramCallEntity.setLooked(k);
          paramCallEntity.setToken(paramCursor.getLong(paramInt + a.h()));
          if (paramCursor.getInt(paramInt + a.i()) != i)
            break label255;
        }
        while (true)
        {
          paramCallEntity.setViberCall(i);
          paramCallEntity.setNativeCallId(paramCursor.getLong(paramInt + a.j()));
          paramCallEntity.setEndReason(paramCursor.getInt(paramInt + a.k()));
          paramCallEntity.setStartReason(paramCursor.getInt(paramInt + a.l()));
          paramCallEntity.setViberCallType(paramCursor.getInt(paramInt + a.m()));
          paramCallEntity.setRawConferenceInfo(paramCursor.getString(paramInt + a.n()));
          return paramCallEntity;
          int m = 0;
          break;
          label255: int j = 0;
        }
      }
      catch (Exception localException)
      {
      }
      return paramCallEntity;
    }

    public Uri getContentUri()
    {
      return a.b.a;
    }

    public ContentValues getContentValues(d paramd)
    {
      return a.a((CallEntity)paramd);
    }

    public String[] getProjections()
    {
      return a.o();
    }

    public String getTable()
    {
      return a.b.a.getLastPathSegment();
    }

    public boolean updateInstance(d paramd, ContentValues paramContentValues)
    {
      throw new RuntimeException("method should be implement only for cached entities");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.a.a.a
 * JD-Core Version:    0.6.2
 */