package com.viber.jni.im2.interfaces;

import com.viber.jni.im2.CActOnViberIdPasswordReplyMsg.Receiver;
import com.viber.jni.im2.CChangeViberIdEmailReplyMsg.Receiver;
import com.viber.jni.im2.CCheckEmailStatusReplyMsg.Receiver;
import com.viber.jni.im2.CGetViberIdReplyMsg.Receiver;
import com.viber.jni.im2.CRegisterViberIdReplyMsg.Receiver;
import com.viber.jni.im2.CUnlinkViberIdReplyMsg.Receiver;
import com.viber.jni.im2.CViberIdChangedMsg.Receiver;

public abstract interface ViberIdReceiver extends CActOnViberIdPasswordReplyMsg.Receiver, CChangeViberIdEmailReplyMsg.Receiver, CCheckEmailStatusReplyMsg.Receiver, CGetViberIdReplyMsg.Receiver, CRegisterViberIdReplyMsg.Receiver, CUnlinkViberIdReplyMsg.Receiver, CViberIdChangedMsg.Receiver
{
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.interfaces.ViberIdReceiver
 * JD-Core Version:    0.6.2
 */