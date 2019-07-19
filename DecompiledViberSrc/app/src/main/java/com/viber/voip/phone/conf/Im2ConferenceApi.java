package com.viber.voip.phone.conf;

import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CCreateConferenceCallMsg;
import com.viber.jni.im2.CCreateConferenceCallReplyMsg;
import com.viber.jni.im2.CCreateConferenceCallReplyMsg.Receiver;
import com.viber.jni.im2.CInviteToConferenceMsg;
import com.viber.jni.im2.CInviteToConferenceReplyMsg;
import com.viber.jni.im2.CInviteToConferenceReplyMsg.Receiver;
import com.viber.jni.im2.CJoinConfCallMsg;
import com.viber.jni.im2.CJoinConfCallReplyMsg;
import com.viber.jni.im2.CJoinConfCallReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.webrtc.SdpCompressor;
import com.viber.voip.ViberEnv;
import java.nio.ByteBuffer;

public class Im2ConferenceApi
  implements CCreateConferenceCallReplyMsg.Receiver, CInviteToConferenceReplyMsg.Receiver, CJoinConfCallReplyMsg.Receiver, IConferenceCall.SnConferenceDelegate
{
  private static final Logger L = ViberEnv.getLogger();
  final Im2Exchanger mExchanger;
  int mLastCreateConfSeq;
  IConferenceCall.SnConferenceObserver mObserver = null;
  final PhoneController mPhoneController;

  public Im2ConferenceApi(Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController)
  {
    this.mExchanger = paramIm2Exchanger;
    this.mPhoneController = paramPhoneController;
  }

  public void handleCreateConferenceCall(String[] paramArrayOfString, String paramString, int paramInt)
  {
    this.mLastCreateConfSeq = this.mPhoneController.generateSequence();
    CCreateConferenceCallMsg localCCreateConferenceCallMsg = new CCreateConferenceCallMsg(this.mLastCreateConfSeq, paramArrayOfString, paramString, paramInt);
    this.mExchanger.handleCCreateConferenceCallMsg(localCCreateConferenceCallMsg);
  }

  public void handleInviteToConference(long paramLong, String[] paramArrayOfString, String paramString)
  {
    CInviteToConferenceMsg localCInviteToConferenceMsg = new CInviteToConferenceMsg(paramLong, paramArrayOfString, paramString, this.mPhoneController.generateSequence());
    this.mExchanger.handleCInviteToConferenceMsg(localCInviteToConferenceMsg);
  }

  public void handleJoinConferenceCall(long paramLong, String paramString1, String paramString2)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramString1.length());
    int i = SdpCompressor.compressSdp(paramString1, localByteBuffer);
    byte[] arrayOfByte = new byte[i];
    localByteBuffer.get(arrayOfByte, 0, i);
    CJoinConfCallMsg localCJoinConfCallMsg = new CJoinConfCallMsg(paramLong, arrayOfByte, paramString2, 0, this.mPhoneController.generateSequence());
    this.mExchanger.handleCJoinConfCallMsg(localCJoinConfCallMsg);
  }

  public void onCCreateConferenceCallReplyMsg(CCreateConferenceCallReplyMsg paramCCreateConferenceCallReplyMsg)
  {
    if (this.mObserver != null)
      this.mObserver.onCreateConference(paramCCreateConferenceCallReplyMsg.status, paramCCreateConferenceCallReplyMsg.confID, paramCCreateConferenceCallReplyMsg.callToken, paramCCreateConferenceCallReplyMsg.memberStatus);
  }

  public void onCInviteToConferenceReplyMsg(CInviteToConferenceReplyMsg paramCInviteToConferenceReplyMsg)
  {
    if (this.mObserver != null)
      this.mObserver.onInviteToConverenceReply(paramCInviteToConferenceReplyMsg.status, paramCInviteToConferenceReplyMsg.memberStatus, paramCInviteToConferenceReplyMsg.attachment);
  }

  public void onCJoinConfCallReplyMsg(CJoinConfCallReplyMsg paramCJoinConfCallReplyMsg)
  {
    if (this.mObserver != null)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramCJoinConfCallReplyMsg.compressedSdpAnswer.length);
      localByteBuffer.put(paramCJoinConfCallReplyMsg.compressedSdpAnswer);
      String str = SdpCompressor.decompressSdp(localByteBuffer, paramCJoinConfCallReplyMsg.compressedSdpAnswer.length);
      this.mObserver.onJoinConference(paramCJoinConfCallReplyMsg.status, paramCJoinConfCallReplyMsg.confID, paramCJoinConfCallReplyMsg.callToken, str, paramCJoinConfCallReplyMsg.attachment);
    }
  }

  public void setObserver(IConferenceCall.SnConferenceObserver paramSnConferenceObserver)
  {
    this.mObserver = paramSnConferenceObserver;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.Im2ConferenceApi
 * JD-Core Version:    0.6.2
 */