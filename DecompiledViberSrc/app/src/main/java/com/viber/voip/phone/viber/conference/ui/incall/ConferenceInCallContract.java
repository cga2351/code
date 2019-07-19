package com.viber.voip.phone.viber.conference.ui.incall;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.mvp.core.State;
import com.viber.voip.mvp.core.j;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantModel;
import com.viber.voip.phone.viber.conference.ui.controls.ControlState;
import com.viber.voip.util.e.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract interface ConferenceInCallContract
{
  public static abstract interface ConferenceMvpView extends j
  {
    public abstract void adjustConferenceStartTime(long paramLong);

    public abstract void displayConferenceName(String paramString);

    public abstract void displayParticipantItems(List<ConferenceParticipantModel> paramList);

    public abstract void displaySpeakingPersonName(String paramString);

    public abstract void displaySpeakingPersonPhoto(Uri paramUri, f paramf);

    public abstract void open1To1ConversationScreen(String paramString);

    public abstract void openContactsSelectionScreen(String[] paramArrayOfString);

    public abstract void openGroupConversationScreen(long paramLong);

    public abstract void showGroupCreateError();

    public abstract void showNoConnectionError();

    public abstract void showNoServiceError();

    public abstract void showPeersUnsupportedVersionError(ConferenceParticipant[] paramArrayOfConferenceParticipant);

    public abstract void startSpeakingPersonAnimation();

    public abstract void startSpeakingPersonVolumeLevelAnimation(long paramLong, float paramFloat);

    public abstract void stopSpeakingPersonAnimation();

    public abstract void updateAddParticipantVisibility(boolean paramBoolean);

    public abstract void updateMessageVisibility(boolean paramBoolean);

    public abstract void updateSilentCallControlState(ControlState paramControlState, boolean paramBoolean);

    public abstract void updateSpeakerControlState(ControlState paramControlState);
  }

  public static abstract interface ConferencePresenter
  {
    public abstract void handleCancelSendUpdateLink();

    public abstract void onAddParticipantClicked();

    public abstract void onBackPressed();

    public abstract void onInviteParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel);

    public abstract void onInviteParticipantsToConference(List<ParticipantSelector.Participant> paramList);

    public abstract void onLeaveConferenceClicked();

    public abstract void onMessageClicked();

    public abstract void onParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel);

    public abstract void onSilentCallClicked();

    public abstract void onSilentCallLongClicked();

    public abstract void onSpeakerPhoneClicked();

    public abstract void sendUpdateLink();
  }

  public static class ConferenceState extends State
  {
    public static final Parcelable.Creator<ConferenceState> CREATOR = new Parcelable.Creator()
    {
      public ConferenceInCallContract.ConferenceState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ConferenceInCallContract.ConferenceState(paramAnonymousParcel);
      }

      public ConferenceInCallContract.ConferenceState[] newArray(int paramAnonymousInt)
      {
        return new ConferenceInCallContract.ConferenceState[paramAnonymousInt];
      }
    };
    private String mConferenceName;
    private ControlState mHoldControlState = ControlState.DISABLED_INACTIVE;
    private ControlState mMicControlState = ControlState.DISABLED_INACTIVE;
    private transient List<ConferenceParticipantModel> mParticipants = Collections.emptyList();
    private ControlState mSpeakerControlState = ControlState.DISABLED_INACTIVE;
    private String mSpeakingPersonMemberId;
    private String mSpeakingPersonName;
    private Uri mSpeakingPersonPhotoUri;

    private ConferenceState()
    {
    }

    protected ConferenceState(Parcel paramParcel)
    {
      this.mSpeakingPersonMemberId = paramParcel.readString();
      this.mSpeakingPersonName = paramParcel.readString();
      this.mSpeakingPersonPhotoUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      this.mConferenceName = paramParcel.readString();
      this.mMicControlState = ((ControlState)paramParcel.readParcelable(ControlState.class.getClassLoader()));
      this.mSpeakerControlState = ((ControlState)paramParcel.readParcelable(ControlState.class.getClassLoader()));
      this.mHoldControlState = ((ControlState)paramParcel.readParcelable(ControlState.class.getClassLoader()));
    }

    public static Builder builder()
    {
      return new Builder(null);
    }

    public Builder buildUpon()
    {
      return new Builder(this, null);
    }

    public int describeContents()
    {
      return 0;
    }

    public String getConferenceName()
    {
      return this.mConferenceName;
    }

    public ControlState getHoldControlState()
    {
      return this.mHoldControlState;
    }

    public ControlState getMicControlState()
    {
      return this.mMicControlState;
    }

    public List<ConferenceParticipantModel> getParticipants()
    {
      return this.mParticipants;
    }

    public ControlState getSpeakerControlState()
    {
      return this.mSpeakerControlState;
    }

    public String getSpeakingPersonMemberId()
    {
      return this.mSpeakingPersonMemberId;
    }

    public String getSpeakingPersonName()
    {
      return this.mSpeakingPersonName;
    }

    public Uri getSpeakingPersonPhotoUri()
    {
      return this.mSpeakingPersonPhotoUri;
    }

    public ConferenceState getStateToSave()
    {
      return buildUpon().setParticipants(Collections.emptyList()).build();
    }

    public String toString()
    {
      return "ConferenceState{mSpeakingPersonMemberId='" + this.mSpeakingPersonMemberId + '\'' + ", mSpeakingPersonName='" + this.mSpeakingPersonName + '\'' + ", mSpeakingPersonPhotoUri=" + this.mSpeakingPersonPhotoUri + ", mConferenceName='" + this.mConferenceName + '\'' + ", mMicControlState=" + this.mMicControlState + ", mSpeakerControlState=" + this.mSpeakerControlState + ", mHoldControlState=" + this.mHoldControlState + ", mParticipants=" + this.mParticipants + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mSpeakingPersonMemberId);
      paramParcel.writeString(this.mSpeakingPersonName);
      paramParcel.writeParcelable(this.mSpeakingPersonPhotoUri, paramInt);
      paramParcel.writeString(this.mConferenceName);
      paramParcel.writeParcelable(this.mMicControlState, paramInt);
      paramParcel.writeParcelable(this.mSpeakerControlState, paramInt);
      paramParcel.writeParcelable(this.mHoldControlState, paramInt);
    }

    public static final class Builder
    {
      private static final List<ConferenceParticipantModel> UNMODIFIABLE_LIST_OF_PARTICIPANTS = Collections.unmodifiableList(new ArrayList());
      private ConferenceInCallContract.ConferenceState stateToBuild = new ConferenceInCallContract.ConferenceState(null);

      private Builder()
      {
      }

      private Builder(ConferenceInCallContract.ConferenceState paramConferenceState)
      {
        this();
        setSpeakingPersonMemberId(paramConferenceState.mSpeakingPersonMemberId);
        setSpeakingPersonName(paramConferenceState.mSpeakingPersonName);
        setSpeakingPersonPhoto(paramConferenceState.mSpeakingPersonPhotoUri);
        setConferenceName(paramConferenceState.mConferenceName);
        setParticipants(paramConferenceState.mParticipants);
        setMicControlState(paramConferenceState.mMicControlState);
        setSpeakerControlState(paramConferenceState.mSpeakerControlState);
        setHoldControlState(paramConferenceState.mHoldControlState);
      }

      public ConferenceInCallContract.ConferenceState build()
      {
        ConferenceInCallContract.ConferenceState localConferenceState = this.stateToBuild;
        this.stateToBuild = new ConferenceInCallContract.ConferenceState(null);
        return localConferenceState;
      }

      public Builder setConferenceName(String paramString)
      {
        ConferenceInCallContract.ConferenceState.access$602(this.stateToBuild, paramString);
        return this;
      }

      public Builder setHoldControlState(ControlState paramControlState)
      {
        ConferenceInCallContract.ConferenceState.access$1002(this.stateToBuild, paramControlState);
        return this;
      }

      public Builder setMicControlState(ControlState paramControlState)
      {
        ConferenceInCallContract.ConferenceState.access$802(this.stateToBuild, paramControlState);
        return this;
      }

      public Builder setParticipants(List<ConferenceParticipantModel> paramList)
      {
        ConferenceInCallContract.ConferenceState localConferenceState = this.stateToBuild;
        if (paramList.getClass().isInstance(UNMODIFIABLE_LIST_OF_PARTICIPANTS));
        while (true)
        {
          ConferenceInCallContract.ConferenceState.access$702(localConferenceState, paramList);
          return this;
          paramList = Collections.unmodifiableList(new ArrayList(paramList));
        }
      }

      public Builder setSpeakerControlState(ControlState paramControlState)
      {
        ConferenceInCallContract.ConferenceState.access$902(this.stateToBuild, paramControlState);
        return this;
      }

      public Builder setSpeakingPersonMemberId(String paramString)
      {
        ConferenceInCallContract.ConferenceState.access$302(this.stateToBuild, paramString);
        return this;
      }

      public Builder setSpeakingPersonName(String paramString)
      {
        ConferenceInCallContract.ConferenceState.access$402(this.stateToBuild, paramString);
        return this;
      }

      public Builder setSpeakingPersonPhoto(Uri paramUri)
      {
        ConferenceInCallContract.ConferenceState.access$502(this.stateToBuild, paramUri);
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.incall.ConferenceInCallContract
 * JD-Core Version:    0.6.2
 */