package com.viber.voip.phone.viber;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.model.a;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.viber.controller.CallStatusObserver;
import com.viber.voip.phone.viber.controller.SecureCallListener;
import com.viber.voip.phone.viber.controller.VoiceQualityUpdater;
import com.viber.voip.phone.viber.dialog.SecureStateDescription;
import com.viber.voip.settings.d.as;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PausableChronometer;

public class CallControlsFragment extends CallViewHolder
  implements DialerControllerDelegate.DialerPhoneState
{
  private static final Logger L = ViberEnv.getLogger();
  private TextView mCallQuality;
  private View mCallQualityPane;
  private PausableChronometer mCallStatus;
  private CallStatusObserver mCallStatusObserver;
  private TextView mCallerName;
  private ImageView mCallerPhotoMain;
  private View mContent;
  private CallInfo mLastCallInfo;
  private TextView mNotInContactListNotify;
  private ImageButton mSecureCallIcon;
  private SecureCallListener mSecureCallListener;
  private TextView mViberOutIcon;
  private String mVoiceCodec;
  private VoiceQualityUpdater mVoiceQualityUpdater;

  public CallControlsFragment(CallFragment paramCallFragment)
  {
    super(paramCallFragment);
  }

  private void bindInCallStateObservers(CallInfo paramCallInfo)
  {
    InCallState localInCallState1 = paramCallInfo.getInCallState();
    InCallState localInCallState2 = (InCallState)localInCallState1.clone();
    localInCallState1.addObserver(this.mCallStatusObserver);
    this.mCallStatusObserver.update(localInCallState1, localInCallState2);
    if (this.mSecureCallListener != null)
    {
      localInCallState1.addObserver(this.mSecureCallListener);
      this.mSecureCallListener.update(localInCallState1, localInCallState2);
    }
  }

  private Context getContext()
  {
    if (this.mContent == null)
      return ViberApplication.getApplication();
    return this.mContent.getContext();
  }

  private void startVoiceQualityUpdates()
  {
    if ((this.mLastCallInfo != null) && (!this.mLastCallInfo.isViberOut()))
    {
      this.mVoiceQualityUpdater.start();
      this.mCallQualityPane.setVisibility(0);
    }
  }

  private void stopVoiceQualityUpdates()
  {
    this.mCallQualityPane.setVisibility(4);
    this.mVoiceQualityUpdater.stop();
  }

  private void unbindInCallStateObservers(CallInfo paramCallInfo)
  {
    if (paramCallInfo == null);
    InCallState localInCallState;
    do
    {
      do
      {
        return;
        localInCallState = paramCallInfo.getInCallState();
      }
      while (localInCallState == null);
      localInCallState.deleteObserver(this.mCallStatusObserver);
    }
    while (this.mSecureCallListener == null);
    localInCallState.deleteObserver(this.mSecureCallListener);
  }

  private void updateCallInfo(CallInfo paramCallInfo)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.mLastCallInfo != paramCallInfo)
    {
      this.mLastCallInfo = paramCallInfo;
      if (this.mSecureCallListener != null)
      {
        SecureCallListener localSecureCallListener = this.mSecureCallListener;
        if ((this.mLastCallInfo.isViberOut()) || (this.mLastCallInfo.isViberIn()))
          break label183;
        bool2 = bool1;
        localSecureCallListener.setViberCallType(bool2);
      }
      this.mCallStatusObserver.setCallInfo(paramCallInfo);
      dj.c(this.mViberOutIcon, paramCallInfo.isViberOut());
      View localView = this.mCallQualityPane;
      if (paramCallInfo.isViberOut())
        break label189;
      label89: dj.c(localView, bool1);
      CallerInfo localCallerInfo = paramCallInfo.getCallerInfo();
      this.mCallerName.setText(localCallerInfo.getCallControlsDisplayName());
      a locala = localCallerInfo.getContact();
      if (locala == null)
        break label194;
      if ((locala.getId() > 0L) && (this.mNotInContactListNotify != null))
        this.mNotInContactListNotify.setVisibility(8);
      if (this.mCallerPhotoMain != null)
      {
        localUri = localCallerInfo.getCallerPhoto();
        getFragment().loadPhoto(this.mCallerPhotoMain, localUri, R.drawable.phone_contact_generic);
      }
    }
    label183: label189: label194: 
    while (this.mCallerPhotoMain == null)
    {
      Uri localUri;
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label89;
    }
    this.mCallerPhotoMain.setImageResource(R.drawable.phone_contact_generic);
  }

  public int getCallMenuPlace()
  {
    return R.id.phone_menu_pad_pane;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContent = paramLayoutInflater.inflate(R.layout.phone_incall_normal, paramViewGroup, false);
    this.mCallerPhotoMain = ((ImageView)this.mContent.findViewById(R.id.phone_photo));
    this.mCallerName = ((TextView)this.mContent.findViewById(R.id.phone_caller_name));
    this.mCallStatus = ((PausableChronometer)this.mContent.findViewById(R.id.phone_call_status));
    this.mCallQuality = ((TextView)this.mContent.findViewById(R.id.phone_call_quality));
    this.mCallQualityPane = this.mContent.findViewById(R.id.phone_call_quality_pane);
    this.mViberOutIcon = ((TextView)this.mContent.findViewById(R.id.phone_call_viber_out));
    this.mSecureCallIcon = ((ImageButton)this.mContent.findViewById(R.id.phone_call_secure));
    this.mNotInContactListNotify = ((TextView)this.mContent.findViewById(R.id.phone_number_not_contact_list));
    if (this.mNotInContactListNotify == null)
      this.mNotInContactListNotify = ((TextView)((View)paramViewGroup.getParent()).findViewById(R.id.phone_number_not_contact_list));
    this.mNotInContactListNotify.setText("*" + getFragment().getString(R.string.block_number_not_contact_list));
    final CallFragment localCallFragment = getFragment();
    this.mVoiceQualityUpdater = new VoiceQualityUpdater(localCallFragment.getCallHandler(), localCallFragment.getDialerController());
    this.mVoiceQualityUpdater.setQualityTextView(this.mCallQuality);
    CallInfo localCallInfo = localCallFragment.getCallHandler().getCallInfo();
    this.mCallStatusObserver = new CallStatusObserver(this.mCallStatus, localCallInfo);
    this.mCallStatusObserver.setVoiceQualityUpdater(this.mVoiceQualityUpdater);
    if (d.as.a.d())
    {
      this.mSecureCallListener = new SecureCallListener(this.mSecureCallIcon);
      this.mSecureCallIcon.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          new SecureStateDescription(localCallFragment.getActivity(), CallControlsFragment.this.mLastCallInfo).showSecureStateDialog();
        }
      });
    }
    this.mLastCallInfo = null;
    updateCallInfo(localCallInfo);
    return this.mContent;
  }

  public void onDestroy()
  {
    onHide();
    setFragment(null);
    this.mContent = null;
    this.mSecureCallListener = null;
  }

  public void onHide()
  {
    if (this.mVoiceQualityUpdater != null)
      this.mVoiceQualityUpdater.stop();
    unbindInCallStateObservers(this.mLastCallInfo);
    getFragment().getDelegatesManager().getDialerPhoneStateListener().removeDelegate(this);
  }

  public void onPhoneStateChanged(int paramInt)
  {
    if (paramInt == 3);
    for (int i = 1; i != 0; i = 0)
    {
      startVoiceQualityUpdates();
      return;
    }
    stopVoiceQualityUpdates();
  }

  public void onShow()
  {
    CallFragment localCallFragment = getFragment();
    localCallFragment.getDelegatesManager().getDialerPhoneStateListener().registerDelegate(this, av.e.a.a());
    final CallInfo localCallInfo = localCallFragment.getCallHandler().getCallInfo();
    if (localCallInfo == null)
      return;
    updateCallInfo(localCallInfo);
    av.e.a.a().postDelayed(new Runnable()
    {
      public void run()
      {
        if (localCallInfo.getInCallState().getState() == 3)
        {
          CallControlsFragment.this.startVoiceQualityUpdates();
          return;
        }
        CallControlsFragment.this.stopVoiceQualityUpdates();
      }
    }
    , 100L);
    bindInCallStateObservers(localCallInfo);
  }

  public void setVoiceCodec(String paramString)
  {
    this.mVoiceCodec = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.CallControlsFragment
 * JD-Core Version:    0.6.2
 */