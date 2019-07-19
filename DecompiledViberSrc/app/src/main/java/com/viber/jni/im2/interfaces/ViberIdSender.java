package com.viber.jni.im2.interfaces;

import com.viber.jni.im2.CActOnViberIdPasswordMsg.Sender;
import com.viber.jni.im2.CChangeViberIdEmailMsg.Sender;
import com.viber.jni.im2.CCheckEmailStatusMsg.Sender;
import com.viber.jni.im2.CGetViberIdMsg.Sender;
import com.viber.jni.im2.CRegisterViberIdMsg.Sender;
import com.viber.jni.im2.CUnlinkViberIdMsg.Sender;

public abstract interface ViberIdSender extends CActOnViberIdPasswordMsg.Sender, CChangeViberIdEmailMsg.Sender, CCheckEmailStatusMsg.Sender, CGetViberIdMsg.Sender, CRegisterViberIdMsg.Sender, CUnlinkViberIdMsg.Sender
{
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.interfaces.ViberIdSender
 * JD-Core Version:    0.6.2
 */