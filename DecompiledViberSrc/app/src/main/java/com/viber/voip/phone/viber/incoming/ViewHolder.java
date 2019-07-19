package com.viber.voip.phone.viber.incoming;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.cg;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.widget.GroupIconView;

class ViewHolder
{
  protected ViberTextView mCallStatus;
  protected TextView mCallerName;
  private ImageView mCallerPhoto;
  protected GroupIconView mGroupPhoto;
  protected boolean mIsVideoCall;
  private TextView mNotInContactListNotify;
  private String mToNumber;

  public ViewHolder(View paramView, boolean paramBoolean, String paramString)
  {
    this.mToNumber = paramString;
    this.mIsVideoCall = paramBoolean;
    this.mCallerPhoto = ((ImageView)paramView.findViewById(R.id.phone_incoming_photo));
    this.mGroupPhoto = ((GroupIconView)paramView.findViewById(R.id.phone_incoming_group_photo));
    this.mCallerName = ((TextView)paramView.findViewById(R.id.phone_caller_name));
    this.mCallStatus = ((ViberTextView)paramView.findViewById(R.id.phone_call_status));
    if (!TextUtils.isEmpty(this.mToNumber))
    {
      ViberTextView localViberTextView = this.mCallStatus;
      Resources localResources = paramView.getResources();
      int i = R.string.incoming_call_to;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = cg.a(paramView.getContext(), this.mToNumber);
      localViberTextView.setText(localResources.getString(i, arrayOfObject));
    }
    while (true)
    {
      this.mNotInContactListNotify = ((TextView)paramView.findViewById(R.id.phone_number_not_contact_list));
      this.mNotInContactListNotify.setText("*" + paramView.getContext().getString(R.string.block_number_not_contact_list));
      return;
      if (paramBoolean)
        this.mCallStatus.setText(R.string.type_incoming_video);
    }
  }

  public void bindName(String paramString)
  {
    this.mCallerName.setText(paramString);
  }

  public void bindPhoto(e parame, f paramf, Uri paramUri, ConferenceInfo paramConferenceInfo)
  {
    if (paramConferenceInfo != null)
    {
      dj.b(this.mCallerPhoto, false);
      dj.b(this.mGroupPhoto, true);
      ConferenceParticipant[] arrayOfConferenceParticipant = paramConferenceInfo.getParticipants();
      this.mGroupPhoto.a(Math.min(4, arrayOfConferenceParticipant.length), false);
      int i = arrayOfConferenceParticipant.length;
      int j = 0;
      if (j < i)
      {
        String str = arrayOfConferenceParticipant[j].getImage();
        if (!TextUtils.isEmpty(str));
        for (Uri localUri = Uri.parse(str); ; localUri = null)
        {
          parame.a(localUri, this.mGroupPhoto, paramf);
          j++;
          break;
        }
      }
    }
    else
    {
      dj.b(this.mCallerPhoto, true);
      dj.b(this.mGroupPhoto, false);
      dj.a(this.mCallerPhoto, new ViewHolder..Lambda.0(this, parame, paramUri));
    }
  }

  public void pauseCallStatusAnimation()
  {
  }

  public void resumeCallStatusAnimation()
  {
  }

  public void updateCallControlsVisibility(boolean paramBoolean)
  {
  }

  public void updateNotInContactListVisibility(boolean paramBoolean)
  {
    dj.b(this.mNotInContactListNotify, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incoming.ViewHolder
 * JD-Core Version:    0.6.2
 */