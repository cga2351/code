package com.viber.voip.phone.viber.conference;

import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.string;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.h;
import com.viber.voip.messages.controller.bx;
import com.viber.voip.util.cn;
import java.util.Map;
import javax.inject.Inject;

public class ConferenceGroupCreationHelper
{
  private int mCreateGroupInProgressSeq = -1;
  private final bv.h mGroupChangeListener = new bv.h()
  {
    public void onAssignRole(int paramAnonymousInt1, String[] paramAnonymousArrayOfString, int paramAnonymousInt2, Map paramAnonymousMap)
    {
      bx.a(this, paramAnonymousInt1, paramAnonymousArrayOfString, paramAnonymousInt2, paramAnonymousMap);
    }

    public void onGroupCreateError(int paramAnonymousInt1, int paramAnonymousInt2, Map<String, Integer> paramAnonymousMap)
    {
      if (ConferenceGroupCreationHelper.this.mCreateGroupInProgressSeq == paramAnonymousInt1)
      {
        ConferenceGroupCreationHelper.access$002(ConferenceGroupCreationHelper.this, -1);
        if (ConferenceGroupCreationHelper.this.mListener != null)
          ConferenceGroupCreationHelper.this.mListener.onGroupCreateError();
      }
    }

    public void onGroupCreated(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2, Map<String, Integer> paramAnonymousMap, boolean paramAnonymousBoolean)
    {
      if (ConferenceGroupCreationHelper.this.mCreateGroupInProgressSeq == paramAnonymousInt)
      {
        ConferenceGroupCreationHelper.access$002(ConferenceGroupCreationHelper.this, -1);
        if (ConferenceGroupCreationHelper.this.mListener != null)
          ConferenceGroupCreationHelper.this.mListener.onGroupCreated(paramAnonymousLong1, paramAnonymousBoolean);
      }
    }

    public void onGroupIconChanged(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
    {
      bx.b(this, paramAnonymousInt1, paramAnonymousLong, paramAnonymousInt2);
    }

    public void onGroupInfoUpdateStarted(int paramAnonymousInt)
    {
      bx.a(this, paramAnonymousInt);
    }

    public void onGroupRenamed(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
    {
      bx.a(this, paramAnonymousInt1, paramAnonymousLong, paramAnonymousInt2);
    }

    public void onGroupUnknownChanged(long paramAnonymousLong, int paramAnonymousInt)
    {
      bx.a(this, paramAnonymousLong, paramAnonymousInt);
    }

    public void onMembersAddedToGroup(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, Map paramAnonymousMap)
    {
      bx.a(this, paramAnonymousInt1, paramAnonymousLong, paramAnonymousInt2, paramAnonymousMap);
    }

    public void onMembersRemovedFromGroup(long paramAnonymousLong, int paramAnonymousInt, String[] paramAnonymousArrayOfString, Map paramAnonymousMap)
    {
      bx.a(this, paramAnonymousLong, paramAnonymousInt, paramAnonymousArrayOfString, paramAnonymousMap);
    }
  };
  private final GroupController mGroupController;
  private boolean mIsGroupChangeListenerRegistered;
  private Listener mListener;
  private final bv mMessageNotificationManager;
  private final PhoneController mPhoneController;
  private final cn mResourceProvider;

  @Inject
  public ConferenceGroupCreationHelper(cn paramcn, GroupController paramGroupController, PhoneController paramPhoneController, bv parambv)
  {
    this.mResourceProvider = paramcn;
    this.mGroupController = paramGroupController;
    this.mPhoneController = paramPhoneController;
    this.mMessageNotificationManager = parambv;
  }

  private void disableGroupChangeObservation()
  {
    this.mMessageNotificationManager.b(this.mGroupChangeListener);
    this.mIsGroupChangeListenerRegistered = false;
  }

  private void enableGroupChangeObservation()
  {
    this.mMessageNotificationManager.a(this.mGroupChangeListener);
    this.mIsGroupChangeListenerRegistered = true;
  }

  public void createGroup(GroupController.GroupMember[] paramArrayOfGroupMember, Listener paramListener)
  {
    if (paramArrayOfGroupMember.length <= 1);
    while ((!this.mIsGroupChangeListenerRegistered) || (this.mCreateGroupInProgressSeq != -1))
      return;
    this.mListener = paramListener;
    this.mCreateGroupInProgressSeq = this.mPhoneController.generateSequence();
    this.mGroupController.a(this.mCreateGroupInProgressSeq, false, this.mResourceProvider.a(R.string.group_call), null, paramArrayOfGroupMember);
  }

  public void register()
  {
    enableGroupChangeObservation();
  }

  public void unregister()
  {
    disableGroupChangeObservation();
  }

  public static abstract interface Listener
  {
    public abstract void onGroupCreateError();

    public abstract void onGroupCreated(long paramLong, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ConferenceGroupCreationHelper
 * JD-Core Version:    0.6.2
 */