package com.viber.voip.phone.call;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.common.d.c;
import com.viber.dexshared.Logger;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.model.a;
import com.viber.voip.util.ca;
import com.viber.voip.util.dj;
import com.viber.voip.util.n;
import com.viber.voip.util.p;
import com.viber.voip.util.x;
import java.util.Observable;

public class CallerInfo extends Observable
  implements Parcelable
{
  public static final Parcelable.Creator<CallerInfo> CREATOR = new Parcelable.Creator()
  {
    public CallerInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CallerInfo(paramAnonymousParcel);
    }

    public CallerInfo[] newArray(int paramAnonymousInt)
    {
      return new CallerInfo[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  private volatile ConferenceInfo conferenceInfo;
  private final a contact;
  private final String memberId;
  private final String name;
  private PeerTrustState.PeerTrustEnum peerTrustState;
  private final String phoneNumber;

  public CallerInfo(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.phoneNumber = paramParcel.readString();
    this.memberId = paramParcel.readString();
    this.peerTrustState = PeerTrustState.PeerTrustEnum.values()[paramParcel.readInt()];
    this.contact = null;
    this.conferenceInfo = ((ConferenceInfo)paramParcel.readParcelable(ConferenceInfo.class.getClassLoader()));
  }

  public CallerInfo(String paramString1, String paramString2, a parama, PeerTrustState.PeerTrustEnum paramPeerTrustEnum, ConferenceInfo paramConferenceInfo)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("The phoneNumber argument is invalid");
    String str = x.a(parama, null);
    if (TextUtils.isEmpty(str));
    for (this.name = ViberApplication.getLocalizedResources().getString(R.string.unknown); ; this.name = str)
    {
      this.phoneNumber = paramString1;
      this.memberId = paramString2;
      this.contact = parama;
      this.peerTrustState = paramPeerTrustEnum;
      this.conferenceInfo = paramConferenceInfo;
      return;
    }
  }

  private String addAsterisk(String paramString)
  {
    if ((ViberApplication.isTablet(ViberApplication.getApplication())) && (!dj.c(ViberApplication.getApplication())))
      return "*" + paramString;
    return paramString + "*";
  }

  private String getConferenceDisplayName()
  {
    if (this.conferenceInfo == null)
      return null;
    return p.a(this.conferenceInfo, false);
  }

  private boolean isPrivateNumber()
  {
    return "private_number".equals(this.phoneNumber);
  }

  public int describeContents()
  {
    return 0;
  }

  public String getCallControlsDisplayName()
  {
    String str = getNameOrPhoneNumber();
    if ((this.contact == null) || (this.contact.getId() <= 0L))
      str = addAsterisk(str);
    return str;
  }

  public Uri getCallerPhoto()
  {
    return x.a(this.contact);
  }

  public ConferenceInfo getConferenceInfo()
  {
    return this.conferenceInfo;
  }

  public a getContact()
  {
    return this.contact;
  }

  public String getEndCallDisplayName()
  {
    String str;
    if (this.conferenceInfo != null)
      str = getConferenceDisplayName();
    do
    {
      return str;
      str = getNameOrPhoneNumber();
    }
    while ((this.contact == null) || (this.contact.getId() > 0L));
    return str + "*";
  }

  public String getIncomingCallDisplayName()
  {
    return getVideoContentDisplayName();
  }

  public String getMemberId()
  {
    return this.memberId;
  }

  public String getName()
  {
    return this.name;
  }

  public String getNameOrPhoneNumber()
  {
    if ((ViberApplication.getLocalizedResources().getString(R.string.unknown).equals(this.name)) && (!isPrivateNumber()))
      return this.phoneNumber;
    return c.b(this.name);
  }

  public PeerTrustState.PeerTrustEnum getPeerTrustState()
  {
    return this.peerTrustState;
  }

  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }

  public String getSecureStateContactName()
  {
    if ((this.contact != null) && (this.contact.getId() > 0L))
      return this.name;
    return this.phoneNumber;
  }

  public String getVideoContentDisplayName()
  {
    String str;
    if (this.conferenceInfo != null)
      str = getConferenceDisplayName();
    do
    {
      return str;
      str = getNameOrPhoneNumber();
    }
    while ((this.contact == null) || (this.contact.getId() > 0L));
    return str + "*";
  }

  public void setConferenceInfo(ConferenceInfo paramConferenceInfo)
  {
    this.conferenceInfo = paramConferenceInfo;
    setChanged();
    notifyObservers(paramConferenceInfo.copy());
  }

  public void setPeerTrustState(PeerTrustState.PeerTrustEnum paramPeerTrustEnum)
  {
    this.peerTrustState = paramPeerTrustEnum;
  }

  public String toString()
  {
    return "CallerInfo{name='" + this.name + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + ", memberId='" + this.memberId + '\'' + ", contact=" + this.contact + ", peerTrustState=" + this.peerTrustState + ", conferenceInfo=" + this.conferenceInfo + '}';
  }

  public void updateConferenceInfoParticipants(ConferenceParticipant[] paramArrayOfConferenceParticipant)
  {
    ConferenceInfo localConferenceInfo = this.conferenceInfo;
    String str;
    int i;
    if (localConferenceInfo != null)
    {
      ConferenceParticipant[] arrayOfConferenceParticipant = localConferenceInfo.getParticipants();
      if ((!localConferenceInfo.isSelfInitiated()) && (arrayOfConferenceParticipant.length > 0))
      {
        str = arrayOfConferenceParticipant[0].getMemberId();
        i = paramArrayOfConferenceParticipant.length;
      }
    }
    for (int j = 0; ; j++)
      if ((j < i) && (i > 1))
      {
        if (ca.b(paramArrayOfConferenceParticipant[j].getMemberId(), str))
          n.a(paramArrayOfConferenceParticipant, 0, j);
      }
      else
      {
        localConferenceInfo.setParticipants(paramArrayOfConferenceParticipant);
        setChanged();
        notifyObservers(localConferenceInfo.copy());
        return;
      }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.phoneNumber);
    paramParcel.writeString(this.memberId);
    paramParcel.writeInt(this.peerTrustState.ordinal());
    paramParcel.writeParcelable(this.conferenceInfo, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.CallerInfo
 * JD-Core Version:    0.6.2
 */