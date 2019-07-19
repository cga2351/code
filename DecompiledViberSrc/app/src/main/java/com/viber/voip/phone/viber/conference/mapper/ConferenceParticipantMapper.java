package com.viber.voip.phone.viber.conference.mapper;

import android.net.Uri;
import com.viber.jni.OnlineContactInfo;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.list.n;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.model.entity.m;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.PeerInfo;
import com.viber.voip.phone.viber.conference.model.ConferenceCallStatus;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantModel;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantRepositoryEntity;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.i.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class ConferenceParticipantMapper
{
  private final e mTimeProvider;

  @Inject
  public ConferenceParticipantMapper(e parame)
  {
    this.mTimeProvider = parame;
  }

  public ConferenceParticipant mapToConferenceInfoParticipant(ConferenceParticipantRepositoryEntity paramConferenceParticipantRepositoryEntity)
  {
    ConferenceParticipant localConferenceParticipant = new ConferenceParticipant();
    localConferenceParticipant.setMemberId(paramConferenceParticipantRepositoryEntity.memberId);
    localConferenceParticipant.setName(paramConferenceParticipantRepositoryEntity.displayName);
    if (paramConferenceParticipantRepositoryEntity.photo != null);
    for (String str = paramConferenceParticipantRepositoryEntity.photo.toString(); ; str = "")
    {
      localConferenceParticipant.setImage(str);
      return localConferenceParticipant;
    }
  }

  public ConferenceParticipant mapToConferenceParticipant(ParticipantSelector.Participant paramParticipant)
  {
    ConferenceParticipant localConferenceParticipant = new ConferenceParticipant();
    localConferenceParticipant.setMemberId(paramParticipant.getMemberId());
    localConferenceParticipant.setName(paramParticipant.getDisplayName());
    if (paramParticipant.getPhotoUri() != null);
    for (String str = paramParticipant.getPhotoUri().toString(); ; str = "")
    {
      localConferenceParticipant.setImage(str);
      return localConferenceParticipant;
    }
  }

  public ConferenceParticipant mapToConferenceParticipant(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    ConferenceParticipant localConferenceParticipant = new ConferenceParticipant();
    localConferenceParticipant.setMemberId(paramConferenceParticipantModel.memberId);
    localConferenceParticipant.setName(paramConferenceParticipantModel.name);
    if (paramConferenceParticipantModel.photoUri != null);
    for (String str = paramConferenceParticipantModel.photoUri.toString(); ; str = "")
    {
      localConferenceParticipant.setImage(str);
      return localConferenceParticipant;
    }
  }

  public List<n> mapToGroupCallStartParticipantsItemList(ConferenceParticipant[] paramArrayOfConferenceParticipant, OnlineContactInfo[] paramArrayOfOnlineContactInfo)
  {
    HashMap localHashMap = new HashMap();
    if ((paramArrayOfOnlineContactInfo != null) && (paramArrayOfOnlineContactInfo.length > 0))
    {
      int k = paramArrayOfOnlineContactInfo.length;
      for (int m = 0; m < k; m++)
      {
        OnlineContactInfo localOnlineContactInfo = paramArrayOfOnlineContactInfo[m];
        localHashMap.put(localOnlineContactInfo.memberId, localOnlineContactInfo);
      }
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfConferenceParticipant.length;
    int j = 0;
    if (j < i)
    {
      ConferenceParticipant localConferenceParticipant = paramArrayOfConferenceParticipant[j];
      String str1 = localConferenceParticipant.getImage();
      String str2 = dg.a((OnlineContactInfo)localHashMap.get(localConferenceParticipant.getMemberId()));
      String str3 = localConferenceParticipant.getMemberId();
      if (!da.a(str1));
      for (Uri localUri = Uri.parse(str1); ; localUri = null)
      {
        localArrayList.add(new n(str3, localUri, localConferenceParticipant.getName(), str2));
        j++;
        break;
      }
    }
    return localArrayList;
  }

  public GroupController.GroupMember mapToGroupMember(ConferenceParticipant paramConferenceParticipant)
  {
    return new GroupController.GroupMember(paramConferenceParticipant.getMemberId(), "", "", paramConferenceParticipant.getName(), null, null, 0);
  }

  public GroupController.GroupMember mapToGroupMember(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    return new GroupController.GroupMember(paramConferenceParticipantModel.memberId, "", "", paramConferenceParticipantModel.name, null, null, 0);
  }

  public ConferenceParticipantModel mapToModel(ConferenceParticipantModel paramConferenceParticipantModel, ConferenceCallStatus paramConferenceCallStatus)
  {
    return new ConferenceParticipantModel(paramConferenceParticipantModel.memberId, paramConferenceParticipantModel.displayName, paramConferenceParticipantModel.name, paramConferenceParticipantModel.photoUri, paramConferenceCallStatus, this.mTimeProvider.a());
  }

  public ConferenceParticipantModel mapToModel(ConferenceParticipantModel paramConferenceParticipantModel, ConferenceCallStatus paramConferenceCallStatus, long paramLong)
  {
    return new ConferenceParticipantModel(paramConferenceParticipantModel.memberId, paramConferenceParticipantModel.displayName, paramConferenceParticipantModel.name, paramConferenceParticipantModel.photoUri, paramConferenceCallStatus, paramLong);
  }

  public ConferenceParticipantModel mapToModel(ConferenceParticipantRepositoryEntity paramConferenceParticipantRepositoryEntity)
  {
    return new ConferenceParticipantModel(paramConferenceParticipantRepositoryEntity.memberId, paramConferenceParticipantRepositoryEntity.displayName, paramConferenceParticipantRepositoryEntity.displayName, paramConferenceParticipantRepositoryEntity.photo, paramConferenceParticipantRepositoryEntity.callStatus, paramConferenceParticipantRepositoryEntity.statusUpdateTimestampMillis);
  }

  public ConferenceParticipantRepositoryEntity mapToRepositoryEntity(m paramm, String paramString)
  {
    String str1 = dg.a(paramm, 0, 1);
    if (paramm != null);
    for (String str2 = paramm.getNumber(); ; str2 = null)
    {
      Uri localUri = null;
      if (paramm != null)
        localUri = cd.a(paramm);
      boolean bool1;
      if (paramm != null)
      {
        boolean bool2 = paramm.j();
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
      return new ConferenceParticipantRepositoryEntity(paramString, str1, str2, localUri, bool1, ConferenceCallStatus.UNKNOWN, this.mTimeProvider.a());
    }
  }

  public ConferenceParticipantRepositoryEntity mapToRepositoryEntity(IConferenceCall.UiDelegate.PeerInfo paramPeerInfo, String paramString)
  {
    return new ConferenceParticipantRepositoryEntity(paramString, null, null, null, false, ConferenceCallStatus.from(paramPeerInfo), this.mTimeProvider.a());
  }

  public ConferenceParticipantRepositoryEntity mapToRepositoryEntity(ConferenceParticipantRepositoryEntity paramConferenceParticipantRepositoryEntity, IConferenceCall.UiDelegate.PeerInfo paramPeerInfo)
  {
    return new ConferenceParticipantRepositoryEntity(paramConferenceParticipantRepositoryEntity.memberId, paramConferenceParticipantRepositoryEntity.displayName, paramConferenceParticipantRepositoryEntity.number, paramConferenceParticipantRepositoryEntity.photo, paramConferenceParticipantRepositoryEntity.isUnknownParticipant, ConferenceCallStatus.from(paramPeerInfo), this.mTimeProvider.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper
 * JD-Core Version:    0.6.2
 */