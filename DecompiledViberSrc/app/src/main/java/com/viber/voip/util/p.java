package com.viber.voip.util;

import android.support.v4.text.BidiFormatter;
import android.text.TextUtils;
import com.viber.voip.ViberApplication;
import com.viber.voip.calls.d.a;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.model.a;
import com.viber.voip.model.entity.CallEntity;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInfo.CallType;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class p
{
  public static int a(ConferenceInfo paramConferenceInfo, int paramInt)
  {
    int i = 0;
    if (paramConferenceInfo == null);
    do
    {
      return i;
      TreeSet localTreeSet = new TreeSet();
      ConferenceParticipant[] arrayOfConferenceParticipant = paramConferenceInfo.getParticipants();
      int j = arrayOfConferenceParticipant.length;
      while (i < j)
      {
        localTreeSet.add(arrayOfConferenceParticipant[i].getMemberId());
        i++;
      }
      StringBuilder localStringBuilder = new StringBuilder(10 * localTreeSet.size());
      Iterator localIterator = localTreeSet.iterator();
      while (localIterator.hasNext())
        localStringBuilder.append((String)localIterator.next());
      i = a(localStringBuilder.toString(), paramInt);
    }
    while (i != 0);
    return -1073737473 + paramInt;
  }

  public static int a(CallEntity paramCallEntity)
  {
    if (paramCallEntity.getType() == 3)
      return 10;
    return 11;
  }

  public static int a(String paramString, int paramInt)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    return String.format("%s_%s", arrayOfObject).hashCode();
  }

  public static String a(ConferenceInfo paramConferenceInfo)
  {
    return a(paramConferenceInfo, true);
  }

  public static String a(ConferenceInfo paramConferenceInfo, String paramString)
  {
    return a(paramConferenceInfo, paramString, true);
  }

  public static String a(ConferenceInfo paramConferenceInfo, String paramString, boolean paramBoolean)
  {
    return a(paramConferenceInfo.getParticipants(), paramString, paramBoolean);
  }

  public static String a(ConferenceInfo paramConferenceInfo, boolean paramBoolean)
  {
    return a(paramConferenceInfo, null, paramBoolean);
  }

  public static String a(String paramString, BidiFormatter paramBidiFormatter)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replaceFirst(" .*", "");
      if (paramString.length() > 15)
        paramString = paramString.substring(0, 15) + "…";
    }
    return co.a(paramString, paramBidiFormatter);
  }

  public static String a(ConferenceParticipant[] paramArrayOfConferenceParticipant, String paramString)
  {
    return a(paramArrayOfConferenceParticipant, paramString, true);
  }

  public static String a(ConferenceParticipant[] paramArrayOfConferenceParticipant, String paramString, boolean paramBoolean)
  {
    BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    int j = paramArrayOfConferenceParticipant.length;
    int k = 0;
    if (k < j)
    {
      ConferenceParticipant localConferenceParticipant = paramArrayOfConferenceParticipant[k];
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(localConferenceParticipant.getMemberId())));
      String str;
      do
      {
        k++;
        break;
        str = localConferenceParticipant.getName();
      }
      while (TextUtils.isEmpty(str));
      if (i != 0)
        i = 0;
      while (true)
      {
        localStringBuilder.append(a(str, localBidiFormatter));
        break;
        localStringBuilder.append(", ");
      }
    }
    if (paramBoolean)
      return localBidiFormatter.unicodeWrap(localStringBuilder.toString());
    return localStringBuilder.toString();
  }

  public static void a(long paramLong1, CallInfo paramCallInfo, long paramLong2, d.a parama)
  {
    String str = paramCallInfo.getCallerInfo().getPhoneNumber();
    boolean bool1 = paramCallInfo.isTransfer();
    int i;
    int j;
    label38: int k;
    long l;
    int i1;
    label87: int m;
    label91: int n;
    if (paramCallInfo.getInCallState().getEndReason() == 10)
    {
      i = 1;
      if (!bool1)
        break label195;
      j = 1;
      k = paramCallInfo.getInCallState().getEndReason();
      l = System.currentTimeMillis() - 1000L * paramLong2;
      if (paramCallInfo.getType() != CallInfo.CallType.INCOMING)
        break label207;
      if ((paramLong2 <= 0L) && (i == 0) && (!bool1))
        break label201;
      i1 = 1;
      m = i1;
      if (!paramCallInfo.isVln())
        break label213;
      n = 5;
      label101: a locala = paramCallInfo.getCallerInfo().getContact();
      if ((locala == null) || (!locala.p()))
        break label279;
    }
    label279: for (boolean bool2 = true; ; bool2 = false)
    {
      ConferenceInfo localConferenceInfo = paramCallInfo.getCallerInfo().getConferenceInfo();
      ViberApplication.getInstance().getRecentCallsManager().a(paramLong1, str, paramCallInfo.getCallerInfo().getMemberId(), m, paramCallInfo.isViberCall(), n, paramCallInfo.isFromSecretConversation(), j, k, l, paramLong2, 0, bool2, localConferenceInfo, paramCallInfo.getToNumber(), parama);
      return;
      i = 0;
      break;
      label195: j = 0;
      break label38;
      label201: i1 = 3;
      break label87;
      label207: m = 2;
      break label91;
      label213: if (paramCallInfo.isViberIn())
      {
        n = 3;
        break label101;
      }
      if (paramCallInfo.isViberOut())
      {
        n = 2;
        break label101;
      }
      if ((paramCallInfo.isIncomingVideoCall()) || (paramCallInfo.isOutgoingVideoCall()))
      {
        n = 4;
        break label101;
      }
      if (paramCallInfo.isConference())
      {
        n = 6;
        break label101;
      }
      n = 1;
      break label101;
    }
  }

  public static void a(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ConferenceInfo paramConferenceInfo, String paramString3, d.a parama)
  {
    int i;
    int j;
    if (paramInt5 == 3)
    {
      i = 1;
      if (paramInt5 != 5)
        break label85;
      j = 4;
      label18: if ((i == 0) && (com.viber.voip.memberid.d.c()) && (paramString2.equals(paramString1)))
        break label117;
    }
    label85: label117: for (boolean bool = true; ; bool = false)
    {
      ViberApplication.getInstance().getRecentCallsManager().a(paramLong1, paramString1, paramString2, paramInt1, bool, j, false, paramInt2, paramInt3, paramLong2, paramLong3, paramInt4, true, paramConferenceInfo, paramString3, parama);
      return;
      i = 0;
      break;
      if (!da.a(paramString3))
      {
        j = 5;
        break label18;
      }
      if (i != 0)
      {
        j = 6;
        break label18;
      }
      j = 1;
      break label18;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.p
 * JD-Core Version:    0.6.2
 */