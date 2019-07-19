package com.viber.voip.calls.ui;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.layout;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.p;
import com.viber.voip.widget.GroupIconView;

public class aa extends t<GroupIconView, u<GroupIconView>>
{
  public aa(Context paramContext, RecentCallsFragmentModeManager paramRecentCallsFragmentModeManager, boolean paramBoolean, ab.a parama, e parame, f paramf)
  {
    super(paramContext, paramRecentCallsFragmentModeManager, paramBoolean, parama, parame, paramf);
  }

  public u<GroupIconView> a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return new u(paramLayoutInflater.inflate(R.layout.item_recent_group_call, paramViewGroup, false));
  }

  public void a(u<GroupIconView> paramu, AggregatedCall paramAggregatedCall, int paramInt)
  {
    super.a(paramu, paramAggregatedCall, paramInt);
    if (!paramAggregatedCall.hasConferenceInfo())
      return;
    ConferenceInfo localConferenceInfo = paramAggregatedCall.getConferenceInfo();
    ConferenceParticipant[] arrayOfConferenceParticipant = localConferenceInfo.getParticipants();
    ((GroupIconView)paramu.e).a(Math.min(4, arrayOfConferenceParticipant.length), false);
    int i = arrayOfConferenceParticipant.length;
    int j = 0;
    if (j < i)
    {
      String str = arrayOfConferenceParticipant[j].getImage();
      e locale = this.d;
      if (!TextUtils.isEmpty(str));
      for (Uri localUri = Uri.parse(str); ; localUri = null)
      {
        locale.a(localUri, (GroupIconView)paramu.e, this.e);
        j++;
        break;
      }
    }
    paramu.f.setText(p.a(localConferenceInfo, false));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.aa
 * JD-Core Version:    0.6.2
 */