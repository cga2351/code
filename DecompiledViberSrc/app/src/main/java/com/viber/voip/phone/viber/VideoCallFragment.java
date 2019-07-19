package com.viber.voip.phone.viber;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerVideo;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.jni.dialer.DialerVideoListener;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.be;
import com.viber.voip.messages.conversation.ui.ba;
import com.viber.voip.n.a;
import com.viber.voip.n.b;
import com.viber.voip.phone.LocalVideoContainerInitialPositionDefiner;
import com.viber.voip.phone.LocalVideoContainerInitialPositionDefiner.PhoneLocalVideoContainerInitialPositionDefiner;
import com.viber.voip.phone.LocalVideoContainerInitialPositionDefiner.TabletLocalVideoContainerInitialPositionDefiner;
import com.viber.voip.phone.LocalVideoContainerInitialPositionDefiner.TabletMinimizedLocalVideoContainerInitialPositionDefiner;
import com.viber.voip.phone.MinimizedCallManager;
import com.viber.voip.phone.RTCCall;
import com.viber.voip.phone.TabletVideoCallActivity;
import com.viber.voip.phone.VideoCallMenuButton;
import com.viber.voip.phone.VideoCallStatistics;
import com.viber.voip.phone.VideoContent;
import com.viber.voip.phone.VideoContent.VideoContentListener;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInfo.VideoState;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.call.listeners.SwitchToConferenceListenersStore;
import com.viber.voip.phone.call.listeners.SwitchToConferenceListenersStore.Listener;
import com.viber.voip.phone.viber.controller.VoiceQualityUpdater;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.ui.dialogs.ag;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.d;
import com.viber.voip.util.dj;
import com.viber.voip.util.dj.a;
import com.viber.voip.util.e.j;
import com.viber.voip.y;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class VideoCallFragment extends CallFragment
  implements DialerControllerDelegate.DialerPhoneState, DialerControllerDelegate.DialerVideo, VideoContent.VideoContentListener, SwitchToConferenceListenersStore.Listener, Observer
{
  private static final boolean ENABLE_VIDEO_CHARTS;
  private static final Logger L = ViberEnv.getLogger();
  private View mBaseView;
  private RTCCall mCall;
  private WeakReference<VideoCallCallbacks> mCallbacks;
  private boolean mIsMaxMinClicked;
  private boolean mIsVideoCloseRequested;
  View mLocalView;
  private Mode mMode = Mode.PHONE;
  private View mPhotoView;
  View mRemoteView;
  private ba mSlidingMenuIgnoreViewCallback;
  private VideoCallStateDelayedUnsubscriber mVideoCallStateUnsubscriber = new VideoCallStateDelayedUnsubscriber(av.e.a.a());
  private VideoCallStatistics mVideoCallStatistics;
  private VideoContent mVideoContent;
  private VoiceQualityUpdater mVoiceQualityUpdater;
  private Integer prevOrientation = null;

  private void closeVideo()
  {
    setVideoState(CallInfo.VideoState.OFF);
    MinimizedCallManager.getInstance().setCallProximityEnabled(true);
    setDeviceOrientation(0, 0);
  }

  private Point getAspectRatio(DisplayMetrics paramDisplayMetrics)
  {
    int i = 4;
    int j = 3;
    paramDisplayMetrics.setTo(ViberApplication.getApplication().getResources().getDisplayMetrics());
    if (paramDisplayMetrics.heightPixels > paramDisplayMetrics.widthPixels);
    while (true)
    {
      return new Point(j, i);
      int k = j;
      j = i;
      i = k;
    }
  }

  private int getDeviceOrientation()
  {
    int i = ((WindowManager)getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay().getRotation();
    int j = getActivity().getResources().getConfiguration().orientation;
    if ((i == 0) || (i == 1))
    {
      if (j == 1)
        return 0;
      if (j == 2)
        return 90;
    }
    else if ((i == 2) || (i == 3))
    {
      if (j == 1)
        return 180;
      if (j == 2)
        return 270;
    }
    return 0;
  }

  private void hideLocalVideo()
  {
    if (this.mLocalView != null)
    {
      this.mLocalView.setVisibility(4);
      this.mVideoContent.setLocalVideoContainerVisible(false);
      this.mVideoContent.setVideoChecked(false);
      removeView(this.mLocalView);
      this.mLocalView = null;
    }
  }

  private void hideRemoteVideo()
  {
    if ((this.mVideoContent != null) && (this.mRemoteView != null))
    {
      this.mVideoContent.removeRemoteVideo(this.mRemoteView);
      this.mRemoteView.setVisibility(4);
      this.mRemoteView = null;
    }
  }

  private void initMode()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((y.c()) && (localFragmentActivity != null) && (localFragmentActivity.getClass() == y.b()))
      this.mMode = Mode.TABLET_MIN;
    while (!(localFragmentActivity instanceof TabletVideoCallActivity))
      return;
    this.mMode = Mode.TABLET_MAX;
  }

  private void maximize()
  {
    this.mIsMaxMinClicked = true;
    startActivity(new Intent(getActivity(), TabletVideoCallActivity.class));
  }

  private void minimize()
  {
    this.mIsMaxMinClicked = true;
    getActivity().finish();
  }

  private void onConferenceRequested()
  {
    this.mIsVideoCloseRequested = true;
    onVideoClosed();
  }

  private void onVideoClosed()
  {
    setVideoState(CallInfo.VideoState.OFF);
    if (this.mCallbacks != null)
    {
      VideoCallCallbacks localVideoCallCallbacks = (VideoCallCallbacks)this.mCallbacks.get();
      if (localVideoCallCallbacks != null)
        localVideoCallCallbacks.onVideoClosed();
    }
  }

  private static void removeView(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ViewGroup));
    for (ViewGroup localViewGroup = (ViewGroup)localViewParent; ; localViewGroup = null)
    {
      if (localViewGroup != null)
        localViewGroup.removeView(paramView);
      return;
    }
  }

  public static void setDeviceOrientation(int paramInt1, int paramInt2)
  {
    int i = b.a() % 360;
    ViberApplication.getInstance().getEngine(true).getPhoneController().setDeviceOrientation(i, paramInt1, paramInt2);
  }

  private void setSpeakerEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((!getSoundService().isBluetoothOn()) && (!getSoundService().isHeadsetPluggedIn()) && (!getSoundService().isSpeakerphoneOn()))
        getSoundService().setSpeakerphoneOn(true);
      return;
    }
    getSoundService().setSpeakerphoneOn(false);
  }

  private void setVideoState(CallInfo.VideoState paramVideoState)
  {
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    if (localCallInfo != null)
      localCallInfo.setVideoState(paramVideoState);
    if (paramVideoState != CallInfo.VideoState.OFF)
      setSpeakerEnabled(true);
  }

  private void setWindowFlags()
  {
    Window localWindow = getActivity().getWindow();
    localWindow.addFlags(4751360);
    if (!((PowerManager)getActivity().getSystemService("power")).isScreenOn())
      localWindow.addFlags(2097152);
  }

  private void showLocalVideo()
  {
    if (this.mLocalView != null);
    while (this.mCall == null)
      return;
    this.mLocalView = this.mCall.getLocalVideo(ViberApplication.getApplication());
    DisplayMetrics localDisplayMetrics1 = new DisplayMetrics();
    Point localPoint = getAspectRatio(localDisplayMetrics1);
    int i = (int)TypedValue.applyDimension(1, 40.0F, localDisplayMetrics1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i * localPoint.x, i * localPoint.y);
    ((SurfaceView)this.mLocalView).setZOrderMediaOverlay(true);
    removeView(this.mLocalView);
    this.mVideoContent.addLocalVideo(this.mLocalView, localLayoutParams);
    this.mLocalView.setVisibility(0);
    this.mVideoContent.setLocalVideoContainerVisible(true);
    this.mVideoContent.setVideoChecked(true);
    dj.a(this.mLocalView, new Runnable()
    {
      public void run()
      {
        if ((VideoCallFragment.this.mLocalView != null) && (VideoCallFragment.this.mLocalView.getWidth() != 0) && (VideoCallFragment.this.mLocalView.getHeight() != 0))
          VideoCallFragment.this.mVideoContent.updateLocalVideoContainerSize(VideoCallFragment.this.mLocalView.getWidth(), VideoCallFragment.this.mLocalView.getHeight());
      }
    });
    DisplayMetrics localDisplayMetrics2 = ViberApplication.getApplication().getResources().getDisplayMetrics();
    setDeviceOrientation(localDisplayMetrics2.widthPixels, localDisplayMetrics2.heightPixels);
  }

  private void showRemoteVideo()
  {
    if (this.mRemoteView != null);
    while (this.mCall == null)
      return;
    this.mRemoteView = this.mCall.getRemoteVideo(ViberApplication.getApplication());
    if ((this.mRemoteView != null) && (this.mRemoteView.getParent() != null))
      removeView(this.mRemoteView);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.weight = 1.0F;
    this.mVideoContent.addRemoteVideo(this.mRemoteView, localLayoutParams);
    this.mRemoteView.setVisibility(0);
  }

  private void updateVideoContent()
  {
    InCallState localInCallState = getCallHandler().getCurrentInCallState();
    if (localInCallState != null)
    {
      int i = localInCallState.getState();
      if ((4 == i) || (6 == i) || (2 == i) || (3 == i))
      {
        int j = getDeviceOrientation();
        this.mVideoContent.setOrientation(j);
        this.mVideoContent.inflateViews();
        this.mVideoContent.initViews();
        CallInfo localCallInfo = getCallHandler().getCallInfo();
        this.mVideoContent.initCallStatusView(localCallInfo);
        this.mVideoContent.update(localCallInfo);
        this.mVideoContent.setVideoChecked(localInCallState.isLocalVideoStarted());
        if (this.mMode != Mode.PHONE)
        {
          this.mVideoContent.updateQualityView(this.mVoiceQualityUpdater);
          if (this.mMode == Mode.TABLET_MIN)
            this.mVideoContent.setChatChecked(true);
        }
      }
    }
  }

  public void onChatClicked()
  {
    if (this.mMode == Mode.TABLET_MAX)
      minimize();
    CallerInfo localCallerInfo;
    do
    {
      CallInfo localCallInfo;
      do
      {
        do
        {
          return;
          if (this.mMode == Mode.TABLET_MIN)
          {
            maximize();
            return;
          }
        }
        while (this.mMode != Mode.PHONE);
        localCallInfo = getCallHandler().getCallInfo();
      }
      while (localCallInfo == null);
      localCallerInfo = localCallInfo.getCallerInfo();
    }
    while (localCallerInfo == null);
    ViberActionRunner.a(getActivity(), localCallerInfo.getMemberId(), localCallerInfo.getPhoneNumber(), localCallerInfo.getName(), false);
    getActivity().finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    final int i = this.mBaseView.getWidth();
    super.onConfigurationChanged(paramConfiguration);
    dj.a(this.mBaseView, new dj.a()
    {
      public boolean onGlobalLayout()
      {
        if (VideoCallFragment.this.mBaseView.getWidth() == i)
          return false;
        if (VideoCallFragment.this.mLocalView != null)
        {
          DisplayMetrics localDisplayMetrics = new DisplayMetrics();
          Point localPoint = VideoCallFragment.this.getAspectRatio(localDisplayMetrics);
          int i = (int)TypedValue.applyDimension(1, 40.0F, localDisplayMetrics);
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i * localPoint.x, i * localPoint.y);
          ((SurfaceView)VideoCallFragment.this.mLocalView).setZOrderMediaOverlay(true);
          VideoCallFragment.this.mLocalView.setLayoutParams(localLayoutParams);
          VideoCallFragment.this.mVideoContent.updateLocalVideoContainerSize(localLayoutParams.width, localLayoutParams.height);
        }
        VideoCallFragment.this.updateVideoContent();
        return true;
      }
    });
    DisplayMetrics localDisplayMetrics = ViberApplication.getApplication().getResources().getDisplayMetrics();
    setDeviceOrientation(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initMode();
    if ((this.mMode != Mode.TABLET_MIN) && (be.a))
    {
      this.prevOrientation = Integer.valueOf(getActivity().getRequestedOrientation());
      a.a(getActivity(), -1);
    }
    setWindowFlags();
    this.mCall = getCallHandler().getRTCCall();
    if (ViberApplication.getInstance().getEngine(false).isReady())
    {
      getActivity().setVolumeControlStream(0);
      return;
    }
    getActivity().finish();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mPhotoView = paramViewGroup;
    int i;
    View localView;
    Object localObject;
    if (this.mMode == Mode.TABLET_MIN)
    {
      i = R.layout.video_call_tablet_min;
      localView = paramLayoutInflater.inflate(i, paramViewGroup, false);
      switch (4.$SwitchMap$com$viber$voip$phone$viber$VideoCallFragment$Mode[this.mMode.ordinal()])
      {
      default:
        localObject = new LocalVideoContainerInitialPositionDefiner.PhoneLocalVideoContainerInitialPositionDefiner(getResources());
      case 1:
      case 2:
      }
    }
    while (true)
    {
      this.mBaseView = localView.findViewById(R.id.video_content);
      FragmentActivity localFragmentActivity = getActivity();
      ba localba = this.mSlidingMenuIgnoreViewCallback;
      ViewGroup localViewGroup = (ViewGroup)this.mBaseView;
      RTCCall localRTCCall = this.mCall;
      int j = 0;
      if (localRTCCall != null)
        j = this.mCall.getCameraCount(ViberApplication.getApplication());
      this.mVideoContent = new VideoContent(localFragmentActivity, localba, localViewGroup, (LocalVideoContainerInitialPositionDefiner)localObject, j, this, getLayoutInflater());
      this.mVideoContent.setOrientation(getDeviceOrientation());
      if (this.mMode != Mode.TABLET_MIN)
        this.mVideoContent.inflateViews();
      this.mVideoContent.initViews();
      CallInfo localCallInfo = getCallHandler().getCallInfo();
      if (localCallInfo != null)
        this.mVideoContent.initCallStatusView(localCallInfo);
      this.mVideoContent.update(getCallHandler().getCallInfo());
      if (this.mMode != Mode.PHONE)
      {
        this.mVoiceQualityUpdater = new VoiceQualityUpdater(getCallHandler(), getDialerController());
        this.mVideoContent.updateQualityView(this.mVoiceQualityUpdater);
        if (this.mMode == Mode.TABLET_MIN)
          this.mVideoContent.setChatChecked(true);
      }
      return localView;
      i = R.layout.video_call_content;
      break;
      localObject = new LocalVideoContainerInitialPositionDefiner.TabletLocalVideoContainerInitialPositionDefiner(getResources());
      continue;
      localObject = new LocalVideoContainerInitialPositionDefiner.TabletMinimizedLocalVideoContainerInitialPositionDefiner(getResources());
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (this.prevOrientation != null))
      a.a(localFragmentActivity, this.prevOrientation.intValue());
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    hideRemoteVideo();
    this.mVideoContent.destroy();
  }

  public void onDetach()
  {
    super.onDetach();
  }

  public void onHangupClicked()
  {
    getDialerController().handleHangup();
  }

  public void onMaxMinClicked()
  {
    if (this.mMode == Mode.TABLET_MAX)
    {
      minimize();
      return;
    }
    maximize();
  }

  public void onMuteClicked(VideoCallMenuButton paramVideoCallMenuButton)
  {
    InCallState localInCallState = getCallHandler().getCurrentInCallState();
    boolean bool1;
    if (localInCallState != null)
    {
      bool1 = localInCallState.isMuteEnabled();
      if (bool1)
        break label44;
    }
    label44: for (boolean bool2 = true; ; bool2 = false)
    {
      paramVideoCallMenuButton.setChecked(bool2);
      if (!bool1)
        break;
      getDialerController().handleUnmute();
      return;
    }
    getDialerController().handleMute();
  }

  public void onPause()
  {
    super.onPause();
    getCallHandler().getSwitchToConferenceListenersStore().unregisterListener(this);
    if (this.mMode == Mode.TABLET_MAX)
      setVideoState(CallInfo.VideoState.MIN);
    if (getCallHandler().getCurrentInCallState() != null)
    {
      hideRemoteVideo();
      hideLocalVideo();
    }
    if (!this.mIsMaxMinClicked)
    {
      if ((this.mMode != Mode.TABLET_MAX) || (this.mIsVideoCloseRequested))
        break label100;
      av.a(av.e.a).postDelayed(new Runnable()
      {
        public void run()
        {
          if (!ViberApplication.getInstance().getAppBackgroundChecker().b())
            VideoCallFragment.this.closeVideo();
        }
      }
      , 2000L);
    }
    while (true)
    {
      removeRenderViews();
      return;
      label100: closeVideo();
    }
  }

  public int onPeerVideoEnded(int paramInt)
  {
    hideRemoteVideo();
    return 0;
  }

  public int onPeerVideoStarted()
  {
    showRemoteVideo();
    return 0;
  }

  public void onPhoneStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
    case 8:
    case 10:
    }
    onVideoClosed();
    setSpeakerEnabled(false);
  }

  public void onResume()
  {
    super.onResume();
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    if ((localCallInfo != null) && (localCallInfo.isConference()))
      onConferenceRequested();
    do
    {
      return;
      getCallHandler().getSwitchToConferenceListenersStore().registerListener(this);
      if (localCallInfo != null)
      {
        if (localCallInfo.getInCallState().isRemoteVideoStarted())
          showRemoteVideo();
        if (localCallInfo.getInCallState().isLocalVideoStarted())
          showLocalVideo();
      }
    }
    while ((this.mMode == Mode.TABLET_MIN) || (localCallInfo == null));
    Uri localUri = localCallInfo.getCallerInfo().getCallerPhoto();
    if (localUri != null)
    {
      loadPhoto(this.mPhotoView, localUri, R.drawable.call_screen_bg);
      return;
    }
    dj.a(this.mPhotoView, j.a(getResources(), R.drawable.call_screen_bg));
  }

  public void onSecureClicked(View paramView)
  {
  }

  public void onSelfVideoEnded(int paramInt)
  {
    hideLocalVideo();
    switch (paramInt)
    {
    case 1:
    default:
      return;
    case 0:
    }
    onVideoClosed();
  }

  public void onSelfVideoStarted()
  {
    showLocalVideo();
  }

  public void onStart()
  {
    super.onStart();
    if (this.mMode != Mode.TABLET_MAX);
    for (CallInfo.VideoState localVideoState = CallInfo.VideoState.MIN; ; localVideoState = CallInfo.VideoState.MAX)
    {
      setVideoState(localVideoState);
      InCallState localInCallState = getCallHandler().getCurrentInCallState();
      if (localInCallState != null)
      {
        localInCallState.addObserver(this);
        this.mVideoContent.addCallStatusObserver(localInCallState);
        if (localInCallState.isRemoteVideoStarted())
          showRemoteVideo();
        if (localInCallState.isLocalVideoStarted())
          showLocalVideo();
      }
      CallInfo localCallInfo = getCallHandler().getCallInfo();
      if ((localCallInfo != null) && (!localCallInfo.isCallInProgress()) && (localCallInfo.isOutgoingVideoCall()))
        showLocalVideo();
      if (this.mMode != Mode.PHONE)
        this.mVoiceQualityUpdater.start();
      getDelegatesManager().getDialerPhoneStateListener().registerDelegateQueue(getCallHandler(), av.e.a.a(), new Observer[] { this });
      getDelegatesManager().getDialerVideoListener().registerDelegateQueue(getCallHandler(), av.e.a.a(), new DialerControllerDelegate.DialerVideo[] { this });
      MinimizedCallManager.getInstance().setCallProximityEnabled(false);
      return;
    }
  }

  public void onStop()
  {
    super.onStop();
    this.mVideoContent.cancelAnimations();
    InCallState localInCallState = getCallHandler().getCurrentInCallState();
    if (localInCallState != null)
    {
      localInCallState.deleteObserver(this);
      this.mVideoContent.deleteCallStatusObserver(localInCallState);
    }
    getDelegatesManager().getDialerPhoneStateListener().removeDelegate(this);
    this.mVideoCallStateUnsubscriber.scheduleUnregisterVideoCallStateListener();
    if (this.mMode != Mode.PHONE)
      this.mVoiceQualityUpdater.stop();
  }

  public void onSwitchCameraClicked()
  {
    if (this.mCall != null)
      this.mCall.switchCamera();
  }

  public void onSwitchToConference()
  {
    onConferenceRequested();
  }

  public void onTransferClicked()
  {
    InCallState localInCallState = getCallHandler().getCurrentInCallState();
    if (localInCallState != null)
      if (localInCallState.isTransferring())
        break label32;
    label32: for (boolean bool = true; ; bool = false)
    {
      getDialerController().handleTransfer(bool);
      return;
    }
  }

  public void onVideoCallEnded()
  {
    this.mVideoCallStateUnsubscriber.unregisterVideoCallStateListenerIfNeeded();
    this.mIsVideoCloseRequested = true;
    onVideoClosed();
  }

  public void onVideoClicked()
  {
    InCallState localInCallState = getCallHandler().getCurrentInCallState();
    if (localInCallState != null)
    {
      if (!localInCallState.isLocalVideoStarted())
        getCallHandler().startSendVideo();
    }
    else
      return;
    getCallHandler().stopSendVideo();
  }

  public void onVideoCompatibility(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      h.a locala = ag.b();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.mVideoContent.getNameText();
      locala.b(-1, arrayOfObject).b(this);
      onVideoClosed();
    }
  }

  public void removeRenderViews()
  {
    if (this.mLocalView != null)
      removeView(this.mLocalView);
    if (this.mRemoteView != null)
      removeView(this.mRemoteView);
  }

  public void setSlidingMenuIgnoreViewCallback(ba paramba)
  {
    this.mSlidingMenuIgnoreViewCallback = paramba;
  }

  public void setVideoCallCallbacks(VideoCallCallbacks paramVideoCallCallbacks)
  {
    if (paramVideoCallCallbacks == null)
    {
      this.mVideoCallStateUnsubscriber.scheduleUnregisterVideoCallCallbacks();
      return;
    }
    this.mVideoCallStateUnsubscriber.cancelUnregisterVideoCallCallbacksIfNeeded();
    this.mCallbacks = new WeakReference(paramVideoCallCallbacks);
  }

  public void update(Observable paramObservable, Object paramObject)
  {
    InCallState localInCallState = (InCallState)paramObject;
    switch (localInCallState.getState())
    {
    case 5:
    default:
    case 2:
    case 3:
    case 4:
    case 6:
    }
    while (true)
    {
      if (!localInCallState.isHeadphonesEnabled())
        setSpeakerEnabled(true);
      return;
      CallInfo localCallInfo = getCallHandler().getCallInfo();
      this.mVideoContent.update(localCallInfo);
    }
  }

  protected static enum Mode
  {
    static
    {
      TABLET_MAX = new Mode("TABLET_MAX", 2);
      Mode[] arrayOfMode = new Mode[3];
      arrayOfMode[0] = PHONE;
      arrayOfMode[1] = TABLET_MIN;
      arrayOfMode[2] = TABLET_MAX;
    }
  }

  private class VideoCallStateDelayedUnsubscriber
  {
    static final long DELAY = 300L;
    final Handler handler;
    Runnable unregisterVideoCallCallbacksRunnable;
    Runnable unregisterVideoCallStateListenerRunnable;

    VideoCallStateDelayedUnsubscriber(Handler arg2)
    {
      Object localObject;
      this.handler = localObject;
    }

    void cancelUnregisterVideoCallCallbacksIfNeeded()
    {
      if (this.unregisterVideoCallCallbacksRunnable != null)
      {
        this.handler.removeCallbacks(this.unregisterVideoCallCallbacksRunnable);
        this.unregisterVideoCallCallbacksRunnable = null;
      }
    }

    void scheduleUnregisterVideoCallCallbacks()
    {
      cancelUnregisterVideoCallCallbacksIfNeeded();
      this.unregisterVideoCallCallbacksRunnable = new Runnable()
      {
        public void run()
        {
          VideoCallFragment.access$502(VideoCallFragment.this, null);
          VideoCallFragment.VideoCallStateDelayedUnsubscriber.this.unregisterVideoCallCallbacksRunnable = null;
        }
      };
      this.handler.postDelayed(this.unregisterVideoCallCallbacksRunnable, 300L);
    }

    void scheduleUnregisterVideoCallStateListener()
    {
      if (this.unregisterVideoCallStateListenerRunnable != null)
        this.handler.removeCallbacks(this.unregisterVideoCallStateListenerRunnable);
      this.unregisterVideoCallStateListenerRunnable = new Runnable()
      {
        public void run()
        {
          VideoCallFragment.VideoCallStateDelayedUnsubscriber.this.unregisterVideoCallStateListenerIfNeeded();
        }
      };
      this.handler.postDelayed(this.unregisterVideoCallStateListenerRunnable, 300L);
    }

    void unregisterVideoCallStateListenerIfNeeded()
    {
      if (this.unregisterVideoCallStateListenerRunnable != null)
      {
        this.handler.removeCallbacks(this.unregisterVideoCallStateListenerRunnable);
        this.unregisterVideoCallStateListenerRunnable = null;
        VideoCallFragment.this.getDelegatesManager().getDialerVideoListener().removeDelegate(VideoCallFragment.this);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.VideoCallFragment
 * JD-Core Version:    0.6.2
 */