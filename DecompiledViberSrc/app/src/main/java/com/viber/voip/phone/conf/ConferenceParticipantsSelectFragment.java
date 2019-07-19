package com.viber.voip.phone.conf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.contacts.ui.ParticipantSelector;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.s;
import com.viber.voip.util.dj;
import java.util.ArrayList;

public class ConferenceParticipantsSelectFragment extends s
{
  private View mStartGroupCallView;

  private void handleAddedParticipants(ArrayList<ParticipantSelector.Participant> paramArrayList)
  {
    FragmentActivity localFragmentActivity = getActivity();
    Intent localIntent = localFragmentActivity.getIntent();
    localIntent.putParcelableArrayListExtra("added_participants", paramArrayList);
    localFragmentActivity.setResult(-1, localIntent);
    localFragmentActivity.finish();
  }

  private void handleStartGroupCallClick()
  {
    handleAddedParticipants(new ArrayList(this.mParticipantSelector.a(ConferenceParticipantsSelectFragment..Lambda.1.$instance)));
  }

  private void initStartGroupCallView(View paramView)
  {
    this.mStartGroupCallView = ((ViewStub)paramView.findViewById(R.id.start_group_call_btn)).inflate();
    this.mStartGroupCallView.setOnClickListener(new ConferenceParticipantsSelectFragment..Lambda.0(this));
  }

  protected boolean canRemoveAddedParticipants()
  {
    return true;
  }

  protected int getContactsPermissionString()
  {
    return R.string.block_list_permission_description;
  }

  protected void handleDone()
  {
    handleAddedParticipants(new ArrayList(this.mParticipantSelector.f()));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ("com.viber.voip.action.CREATE_CONFERENCE_WITH_1ON1_PARTICIPANTS".equals(getActivity().getIntent().getAction()))
      initStartGroupCallView(localView);
    return localView;
  }

  protected void setDoneVisible(boolean paramBoolean)
  {
    if ("com.viber.voip.action.CREATE_CONFERENCE_WITH_1ON1_PARTICIPANTS".equals(getActivity().getIntent().getAction()))
    {
      dj.b(this.mStartGroupCallView, paramBoolean);
      return;
    }
    super.setDoneVisible(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.ConferenceParticipantsSelectFragment
 * JD-Core Version:    0.6.2
 */