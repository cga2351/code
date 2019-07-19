package com.viber.voip.phone.viber.endcall.viewholders;

import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.m.e;
import com.viber.voip.analytics.story.o;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.viber.endcall.EndCallStateResolver;
import com.viber.voip.ui.dialogs.af;

public class EndCallViewHolderBuilder
{
  private CallInfo mCallInfo;
  private View.OnClickListener mChatsClickListener;
  private View.OnClickListener mCloseClickListener;
  private EndCallStateResolver mEndCallStateResolver;
  private View.OnClickListener mLearnMoreClickListener;
  private View.OnClickListener mRedialClickListener;
  private View.OnClickListener mSendMessageClickListener;
  private View.OnClickListener mViberOutClickListener;

  public EndCallViewHolderBuilder(EndCallStateResolver paramEndCallStateResolver, CallInfo paramCallInfo)
  {
    this.mEndCallStateResolver = paramEndCallStateResolver;
    this.mCallInfo = paramCallInfo;
  }

  public EndCallViewHolder build(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TabletEndCallViewHolder localTabletEndCallViewHolder = new TabletEndCallViewHolder(paramLayoutInflater, paramViewGroup, this.mEndCallStateResolver);
      localTabletEndCallViewHolder.setSendMessageClickListener(this.mSendMessageClickListener);
      localTabletEndCallViewHolder.setRedialClickListener(this.mRedialClickListener);
      localTabletEndCallViewHolder.setViberOutClickListener(this.mViberOutClickListener);
      return localTabletEndCallViewHolder;
    }
    if (this.mCallInfo != null)
    {
      if (this.mCallInfo.isViberOut())
      {
        if (this.mCallInfo.getInCallState().isDestinationBlocked())
        {
          g.a().c().e().a();
          VoBlockedViewHolder localVoBlockedViewHolder = new VoBlockedViewHolder(paramLayoutInflater, paramViewGroup);
          localVoBlockedViewHolder.setLearnMoreClickListener(this.mLearnMoreClickListener);
          localVoBlockedViewHolder.setCloseClickListener(this.mCloseClickListener);
          return localVoBlockedViewHolder;
        }
        if (this.mCallInfo.getInCallState().isCallerBlocked())
        {
          g.a().c().e().a();
          af.g().d(true).d();
        }
        VoEndCallViewHolder localVoEndCallViewHolder = new VoEndCallViewHolder(paramLayoutInflater, paramViewGroup);
        localVoEndCallViewHolder.setRedialClickListener(this.mRedialClickListener);
        return localVoEndCallViewHolder;
      }
      if (this.mEndCallStateResolver == EndCallStateResolver.VIDEO_TIMEOUT)
      {
        VideoTimeoutEndCallViewHolder localVideoTimeoutEndCallViewHolder = new VideoTimeoutEndCallViewHolder(paramLayoutInflater, paramViewGroup);
        localVideoTimeoutEndCallViewHolder.setSendMessageClickListener(this.mSendMessageClickListener);
        localVideoTimeoutEndCallViewHolder.setRedialClickListener(this.mRedialClickListener);
        localVideoTimeoutEndCallViewHolder.setViberOutClickListener(this.mViberOutClickListener);
        return localVideoTimeoutEndCallViewHolder;
      }
      if (this.mEndCallStateResolver == EndCallStateResolver.TIMEOUT)
      {
        TimeOutEndCallViewHolder localTimeOutEndCallViewHolder = new TimeOutEndCallViewHolder(paramLayoutInflater, paramViewGroup);
        localTimeOutEndCallViewHolder.setSendMessageClickListener(this.mSendMessageClickListener);
        localTimeOutEndCallViewHolder.setRedialClickListener(this.mRedialClickListener);
        localTimeOutEndCallViewHolder.setViberOutClickListener(this.mViberOutClickListener);
        return localTimeOutEndCallViewHolder;
      }
      if (this.mEndCallStateResolver == EndCallStateResolver.BUSY)
      {
        BusyEndCallViewHolder localBusyEndCallViewHolder = new BusyEndCallViewHolder(paramLayoutInflater, paramViewGroup);
        localBusyEndCallViewHolder.setRedialClickListener(this.mRedialClickListener);
        localBusyEndCallViewHolder.setSendMessageClickListener(this.mSendMessageClickListener);
        return localBusyEndCallViewHolder;
      }
      DefaultEndCallViewHolder localDefaultEndCallViewHolder = new DefaultEndCallViewHolder(paramLayoutInflater, paramViewGroup, this.mEndCallStateResolver);
      localDefaultEndCallViewHolder.setSendMessageClickListener(this.mSendMessageClickListener);
      localDefaultEndCallViewHolder.setChatsClickListener(this.mChatsClickListener);
      return localDefaultEndCallViewHolder;
    }
    return new DefaultEndCallViewHolder(paramLayoutInflater, paramViewGroup, this.mEndCallStateResolver);
  }

  public EndCallViewHolderBuilder withChatsListener(View.OnClickListener paramOnClickListener)
  {
    this.mChatsClickListener = paramOnClickListener;
    return this;
  }

  public EndCallViewHolderBuilder withCloseListener(View.OnClickListener paramOnClickListener)
  {
    this.mCloseClickListener = paramOnClickListener;
    return this;
  }

  public EndCallViewHolderBuilder withLearnMoreListener(View.OnClickListener paramOnClickListener)
  {
    this.mLearnMoreClickListener = paramOnClickListener;
    return this;
  }

  public EndCallViewHolderBuilder withRedialListener(View.OnClickListener paramOnClickListener)
  {
    this.mRedialClickListener = paramOnClickListener;
    return this;
  }

  public EndCallViewHolderBuilder withSendMessageListener(View.OnClickListener paramOnClickListener)
  {
    this.mSendMessageClickListener = paramOnClickListener;
    return this;
  }

  public EndCallViewHolderBuilder withViberOutListener(View.OnClickListener paramOnClickListener)
  {
    this.mViberOutClickListener = paramOnClickListener;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.viewholders.EndCallViewHolderBuilder
 * JD-Core Version:    0.6.2
 */