package com.viber.voip.phone.viber.conference.ui.incall;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantModel;
import java.util.ArrayList;
import java.util.List;

public class ConferenceParticipantsAdapter extends RecyclerView.Adapter<ConferenceParticipantViewHolder>
{
  private final LayoutInflater mInflater;
  private List<ConferenceParticipantModel> mItems = new ArrayList();
  private final ListenerDelegate mListenerDelegate;
  private OnInviteParticipantActionListener mOnInviteParticipantActionListener;
  private OnParticipantClickListener mOnParticipantClickListener;

  public ConferenceParticipantsAdapter(LayoutInflater paramLayoutInflater)
  {
    this.mInflater = paramLayoutInflater;
    this.mListenerDelegate = new ListenerDelegate(null);
  }

  public int getItemCount()
  {
    return this.mItems.size();
  }

  public void onBindViewHolder(ConferenceParticipantViewHolder paramConferenceParticipantViewHolder, int paramInt)
  {
    paramConferenceParticipantViewHolder.bindTo((ConferenceParticipantModel)this.mItems.get(paramInt));
  }

  public ConferenceParticipantViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ConferenceParticipantViewHolder(this.mInflater.inflate(R.layout.conference_participant_item, paramViewGroup, false), this.mListenerDelegate, this.mListenerDelegate);
  }

  public void setOnInviteParticipantActionListener(OnInviteParticipantActionListener paramOnInviteParticipantActionListener)
  {
    this.mOnInviteParticipantActionListener = paramOnInviteParticipantActionListener;
  }

  public void setOnParticipantClickListener(OnParticipantClickListener paramOnParticipantClickListener)
  {
    this.mOnParticipantClickListener = paramOnParticipantClickListener;
  }

  public void submitList(List<ConferenceParticipantModel> paramList)
  {
    this.mItems.clear();
    this.mItems.addAll(paramList);
    notifyDataSetChanged();
  }

  private class ListenerDelegate
    implements ConferenceParticipantsAdapter.OnInviteParticipantActionListener, ConferenceParticipantsAdapter.OnParticipantClickListener
  {
    private ListenerDelegate()
    {
    }

    public void onInviteParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel)
    {
      if (ConferenceParticipantsAdapter.this.mOnInviteParticipantActionListener != null)
        ConferenceParticipantsAdapter.this.mOnInviteParticipantActionListener.onInviteParticipantClicked(paramConferenceParticipantModel);
    }

    public void onParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel)
    {
      if (ConferenceParticipantsAdapter.this.mOnParticipantClickListener != null)
        ConferenceParticipantsAdapter.this.mOnParticipantClickListener.onParticipantClicked(paramConferenceParticipantModel);
    }
  }

  public static abstract interface OnInviteParticipantActionListener
  {
    public abstract void onInviteParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel);
  }

  public static abstract interface OnParticipantClickListener
  {
    public abstract void onParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.incall.ConferenceParticipantsAdapter
 * JD-Core Version:    0.6.2
 */