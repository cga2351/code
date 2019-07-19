package com.viber.voip.phone.call;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.common.d.g;
import com.viber.common.wear.CallState;
import com.viber.common.wear.data.CallStateResult;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.notif.i.a.b;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener..CC;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.ad;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.da;
import com.viber.voip.util.dq;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;
import com.viber.voip.util.i.c;
import com.viber.voip.util.p;
import java.util.Map;

public class WearCallNotifier extends a.b
  implements DataApi.DataListener, MessageApi.MessageListener
{
  private static final Logger L = ViberEnv.getLogger();
  private final CallHandler mCallHandler;
  private final ConferenceCallsRepository.ConferenceAvailabilityListener mConferenceAvailabilityListener = new ConferenceCallsRepository.ConferenceAvailabilityListener()
  {
    public void onConferenceMissedInProgress(OngoingConferenceCallModel paramAnonymousOngoingConferenceCallModel, String paramAnonymousString1, String paramAnonymousString2)
    {
      ConferenceCallsRepository.ConferenceAvailabilityListener..CC.onConferenceMissedInProgress(this, paramAnonymousOngoingConferenceCallModel, paramAnonymousString1, paramAnonymousString2);
    }

    public void onConferencesAvailable(Map<Long, OngoingConferenceCallModel> paramAnonymousMap)
    {
      if (WearCallNotifier.this.mConferenceCallsRepository.getConferenceTalkingTo() != null)
        WearCallNotifier.this.sendChangeCallState(WearCallNotifier.access$500(WearCallNotifier.this, null));
    }

    public void onConferencesUnavailable(Map paramAnonymousMap)
    {
      ConferenceCallsRepository.ConferenceAvailabilityListener..CC.onConferencesUnavailable(this, paramAnonymousMap);
    }
  };
  private final ConferenceCallsRepository mConferenceCallsRepository;
  private final f mFetcherConfig;
  private final GoogleApiClient mGoogleApiClient;
  private final com.viber.voip.util.e.e mImageFetcher;
  private final h.a mPhotoLoadListener = new h.a()
  {
    public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousUri == null) || (paramAnonymousBoolean))
        return;
      PutDataMapRequest localPutDataMapRequest = PutDataMapRequest.create("/update_call_photo");
      localPutDataMapRequest.setUrgent();
      DataMap localDataMap = localPutDataMapRequest.getDataMap();
      localDataMap.putAsset("contact_photo", Asset.createFromBytes(dq.a(paramAnonymousBitmap, Bitmap.CompressFormat.PNG, 100)));
      localDataMap.putLong("time", WearCallNotifier.this.mSystemTimeProvider.a());
      WearCallNotifier.this.putDataItem(localPutDataMapRequest.asPutDataRequest());
    }
  };
  private final ServiceStateDelegate mServiceStateChangeListener = new ServiceStateDelegate()
  {
    public void onServiceStateChanged(int paramAnonymousInt)
    {
      ServiceStateDelegate.ServiceState localServiceState = ServiceStateDelegate.ServiceState.resolveEnum(paramAnonymousInt);
      if (ServiceStateDelegate.ServiceState.SERVICE_CONNECTED == localServiceState)
      {
        WearCallNotifier.this.checkReportStats();
        Wearable.CapabilityApi.addLocalCapability(WearCallNotifier.this.mGoogleApiClient, "voip_service");
      }
      while (ServiceStateDelegate.ServiceState.SERVICE_NOT_CONNECTED != localServiceState)
        return;
      Wearable.CapabilityApi.removeLocalCapability(WearCallNotifier.this.mGoogleApiClient, "voip_service");
    }
  };
  private final c mSystemTimeProvider;

  public WearCallNotifier(Context paramContext, CallHandler paramCallHandler, ConferenceCallsRepository paramConferenceCallsRepository, c paramc)
  {
    this.mCallHandler = paramCallHandler;
    this.mSystemTimeProvider = paramc;
    this.mImageFetcher = com.viber.voip.util.e.e.a(paramContext);
    this.mFetcherConfig = f.e(R.drawable.contcat_info_generic_image);
    this.mConferenceCallsRepository = paramConferenceCallsRepository;
    this.mConferenceCallsRepository.registerConferenceAvailabilityListener(this.mConferenceAvailabilityListener);
    ServiceStateListener localServiceStateListener = ViberApplication.getInstance().getEngine(false).getDelegatesManager().getServiceStateListener();
    ServiceStateDelegate[] arrayOfServiceStateDelegate = new ServiceStateDelegate[1];
    arrayOfServiceStateDelegate[0] = this.mServiceStateChangeListener;
    localServiceStateListener.registerDelegate(arrayOfServiceStateDelegate);
    this.mGoogleApiClient = new GoogleApiClient.Builder(paramContext).addApi(Wearable.API).build();
    try
    {
      this.mGoogleApiClient.connect();
      Wearable.DataApi.addListener(this.mGoogleApiClient, this);
      Wearable.MessageApi.addListener(this.mGoogleApiClient, this);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  private void answerCall()
  {
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    if (localCallInfo == null);
    boolean bool;
    do
    {
      return;
      bool = ViberApplication.getApplication().getPackageManager().hasSystemFeature("android.hardware.microphone");
      localCallInfo.getInCallState().setUserReaction(true);
    }
    while (!bool);
    if (!localCallInfo.isConference())
    {
      this.mCallHandler.handleAnswer(false);
      return;
    }
    this.mCallHandler.handleAnswerAudioConference();
  }

  private void checkReportStats()
  {
    boolean bool = d.ad.p.d();
    long l1 = d.ad.o.d();
    long l2 = this.mSystemTimeProvider.a();
    if (l2 - l1 >= 86400000L);
    for (int i = 1; ; i = 0)
    {
      if ((!bool) && (i != 0))
      {
        d.ad.o.a(l2);
        PutDataMapRequest localPutDataMapRequest = PutDataMapRequest.create("/info");
        localPutDataMapRequest.getDataMap().putLong("time", l2);
        putDataItem(localPutDataMapRequest.asPutDataRequest());
      }
      return;
    }
  }

  private CallStateUpdate createCallStateUpdate(CallState paramCallState)
  {
    CallInfo localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
    if (paramCallState != null);
    while (true)
    {
      CallStateResult localCallStateResult = new CallStateResult(paramCallState);
      CallState localCallState1 = localCallStateResult.getCallState();
      CallState localCallState2 = CallState.IDLE;
      Uri localUri = null;
      if (localCallState1 != localCallState2)
      {
        localUri = getCallParticipantsDisplayPhoto();
        localCallStateResult.setDisplayName(getCallParticipantsDisplayName());
        localCallStateResult.setCallDuration(getCallDuration());
      }
      return new CallStateUpdate(localCallStateResult, localUri);
      paramCallState = toCallState(localCallInfo);
    }
  }

  private void declineCall()
  {
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    if (localCallInfo == null)
      return;
    DialerController localDialerController = ViberApplication.getInstance().getEngine(true).getDialerController();
    localCallInfo.getInCallState().setUserReaction(true);
    localDialerController.handleDecline();
  }

  private void deleteDataItems(String paramString)
  {
    Wearable.DataApi.deleteDataItems(this.mGoogleApiClient, Uri.parse("wear:" + paramString));
  }

  private long getCallDuration()
  {
    long l = 0L;
    CallInfo localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
    OngoingConferenceCallModel localOngoingConferenceCallModel = this.mConferenceCallsRepository.getConferenceTalkingTo();
    if (localOngoingConferenceCallModel != null)
      l = Math.max(this.mSystemTimeProvider.a() - localOngoingConferenceCallModel.startTimeMillis, l);
    while (localCallInfo == null)
      return l;
    return localCallInfo.getInCallState().getCallStats().getCallDuration();
  }

  private String getCallParticipantsDisplayName()
  {
    CallInfo localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
    ConferenceInfo localConferenceInfo;
    String str;
    if (localCallInfo != null)
    {
      localConferenceInfo = localCallInfo.getCallerInfo().getConferenceInfo();
      if (localConferenceInfo == null)
        break label40;
      str = p.a(localConferenceInfo, false);
    }
    label40: 
    do
    {
      return str;
      localConferenceInfo = null;
      break;
      str = null;
    }
    while (localCallInfo == null);
    return localCallInfo.getCallerInfo().getNameOrPhoneNumber();
  }

  private Uri getCallParticipantsDisplayPhoto()
  {
    CallInfo localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
    if ((localCallInfo != null) && (localCallInfo.isConference()))
      return Uri.parse("android.resource://com.viber.voip/drawable/ic_community_default");
    if (localCallInfo != null)
      return localCallInfo.getCallerInfo().getCallerPhoto();
    return null;
  }

  private void putDataItem(PutDataRequest paramPutDataRequest)
  {
    Wearable.DataApi.putDataItem(this.mGoogleApiClient, paramPutDataRequest);
  }

  private void sendChangeCallState(CallStateUpdate paramCallStateUpdate)
  {
    Wearable.NodeApi.getConnectedNodes(this.mGoogleApiClient).setResultCallback(new WearCallNotifier..Lambda.0(this, paramCallStateUpdate));
  }

  private void sendCheckCallState(String paramString)
  {
    CallStateUpdate localCallStateUpdate = createCallStateUpdate(null);
    byte[] arrayOfByte = g.a(localCallStateUpdate.callStateResult);
    Wearable.MessageApi.sendMessage(this.mGoogleApiClient, paramString, "/check_call_state_callback", arrayOfByte);
    if (localCallStateUpdate.contactPhotoUri != null)
      this.mImageFetcher.a(null, localCallStateUpdate.contactPhotoUri, null, this.mFetcherConfig, this.mPhotoLoadListener);
  }

  private static CallState toCallState(CallInfo paramCallInfo)
  {
    if (paramCallInfo == null)
      return CallState.IDLE;
    if (paramCallInfo.isCallInProgress())
      return CallState.IN_PROGRESS;
    if (paramCallInfo.isOutgoing())
      return CallState.OUTGOING;
    if (paramCallInfo.isCalling())
      return CallState.INCOMING;
    return CallState.IDLE;
  }

  public void onDataChanged(DataEventBuffer paramDataEventBuffer)
  {
    int i = 0;
    if (i < paramDataEventBuffer.getCount())
    {
      DataEvent localDataEvent = (DataEvent)paramDataEventBuffer.get(i);
      int j = localDataEvent.getType();
      DataItem localDataItem = localDataEvent.getDataItem();
      String str1 = localDataItem.getUri().getPath();
      if (j == 1)
      {
        DataMap localDataMap = DataMapItem.fromDataItem(localDataItem).getDataMap();
        if (str1.compareTo("/info_callback") != 0)
          break label256;
        String str2 = localDataMap.getString("manufacturer", null);
        String str3 = localDataMap.getString("model", null);
        String str4 = localDataMap.getString("version", null);
        String str5 = localDataMap.getString("id", null);
        d.ad.p.a(true);
        String str6 = UserManager.from(ViberApplication.getApplication()).getRegistrationValues().n();
        String str7 = str2 + " " + str3;
        if (!da.a(d.ad.q.d(), str5))
        {
          d.ad.q.a(str5);
          ViberApplication.getInstance().getEngine(true).getPhoneController().handleReportWatchActivationStatistics(str6, str7, 1, str4);
        }
        ViberApplication.getInstance().getEngine(true).getPhoneController().handleReportWatchDailyStatistics(str6, str7, 1, 1L, str4);
      }
      label256: for (int k = 1; ; k = 0)
      {
        if (k != 0)
          deleteDataItems(str1);
        i++;
        break;
      }
    }
  }

  public void onEndedCall(int paramInt)
  {
    onIdleCall();
  }

  public void onIdleCall()
  {
    sendChangeCallState(createCallStateUpdate(CallState.IDLE));
  }

  public void onInProgressCall(String paramString1, String paramString2, Uri paramUri, ConferenceInfo paramConferenceInfo)
  {
    sendChangeCallState(createCallStateUpdate(CallState.IN_PROGRESS));
  }

  public void onIncomingCall(String paramString1, String paramString2, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, ConferenceInfo paramConferenceInfo)
  {
    sendChangeCallState(createCallStateUpdate(CallState.INCOMING));
    checkReportStats();
  }

  public void onMessageReceived(MessageEvent paramMessageEvent)
  {
    String str1 = paramMessageEvent.getPath();
    String str2 = paramMessageEvent.getSourceNodeId();
    if ("/check_call_state".equals(str1))
      sendCheckCallState(str2);
    do
    {
      return;
      if ("/call_answer".equals(str1))
      {
        answerCall();
        return;
      }
    }
    while (!"/call_decline".equals(str1));
    declineCall();
  }

  public void onOutgoingCall(String paramString1, String paramString2, Uri paramUri, ConferenceInfo paramConferenceInfo)
  {
    sendChangeCallState(createCallStateUpdate(CallState.OUTGOING));
    checkReportStats();
  }

  private static class CallStateUpdate
  {
    final CallStateResult callStateResult;
    final Uri contactPhotoUri;

    CallStateUpdate(CallStateResult paramCallStateResult, Uri paramUri)
    {
      this.callStateResult = paramCallStateResult;
      this.contactPhotoUri = paramUri;
    }

    public String toString()
    {
      return "CallStateUpdate{callStateResult=" + this.callStateResult + ", contactPhotoUri=" + this.contactPhotoUri + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.WearCallNotifier
 * JD-Core Version:    0.6.2
 */