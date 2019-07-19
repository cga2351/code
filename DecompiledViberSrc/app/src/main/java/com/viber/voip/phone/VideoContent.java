package com.viber.voip.phone;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.conversation.ui.ba;
import com.viber.voip.messages.ui.b.a.b;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.viber.LocalVideoContentPositionManager;
import com.viber.voip.phone.viber.LocalVideoContentPositionManager.PositionChangedListener;
import com.viber.voip.phone.viber.controller.CallStatusObserver;
import com.viber.voip.phone.viber.controller.SecureCallListener;
import com.viber.voip.phone.viber.controller.VoiceQualityUpdater;
import com.viber.voip.phone.viber.dialog.SecureStateDescription;
import com.viber.voip.util.dj;
import com.viber.voip.util.dq;
import com.viber.voip.widget.PausableChronometer;
import java.io.ByteArrayOutputStream;
import org.webrtc.videoengine.VideoCaptureApi;
import org.webrtc.videoengine.VideoCaptureDeviceInfo;

public class VideoContent
  implements View.OnClickListener, View.OnTouchListener, Runnable
{
  private static final boolean FLIP_CAMERA_ANIMATION_ENABLED = false;
  private static final Logger L = ViberEnv.getLogger();
  private static final long VISIBILITY_TIMEOUT = 4000L;
  private final Runnable mAnimateLocalVideoPositionChange = new Runnable()
  {
    public void run()
    {
      VideoContent.this.mLocalViewPositionAnimator.onBarsDisplayed(VideoContent.this.mBarsVisible, VideoContent.this.mLocalVideoContainerInitialPositionDefiner.getMarginsRectWhenBarsDisplayed(0, VideoContent.this.mBottomBarView, VideoContent.this.mTopBarView));
    }
  };
  private boolean mBarsVisible;
  private ViewGroup mBaseView;
  private View mBottomBarView;
  private CallStatusObserver mCallStatusObserver;
  private int mCameraCount = 0;
  private View mCameraFlipView;
  private CameraFlipper mCameraFlipper;
  private VideoCallMenuButton mChatButton;
  private PausableChronometer mChronometer;
  private Activity mContext;
  private final Runnable mCorrectInitialPositionOfLocalVideoContainer = new Runnable()
  {
    public void run()
    {
      if (!VideoContent.this.mBarsVisible)
        return;
      VideoContent.this.mLocalVideoContentPositionManager.addMask(VideoContent.this.mLocalVideoContainerInitialPositionDefiner.getMarginsRectWhenBarsDisplayed(0, VideoContent.this.mBottomBarView, VideoContent.this.mTopBarView), new LocalVideoContentPositionManager.PositionChangedListener()
      {
        public void onPositionChanged(int paramAnonymous2Int1, int paramAnonymous2Int2)
        {
          VideoContent.this.mLocalViewPositionAnimator.cancelAnimation();
          VideoContent.this.mLocalVideoContainer.setTranslationX(paramAnonymous2Int1);
          VideoContent.this.mLocalVideoContainer.setTranslationY(paramAnonymous2Int2);
        }
      });
    }
  };
  private Handler mHandler = av.a(av.e.a);
  private VideoCallMenuButton mHangupButton;
  private boolean mIsOutgoing;
  private LayoutInflater mLayoutInflater;
  private VideoContentListener mListener;
  private FrameLayout mLocalVideoContainer;
  private final LocalVideoContainerInitialPositionDefiner mLocalVideoContainerInitialPositionDefiner;
  private LocalVideoContentPositionManager mLocalVideoContentPositionManager;
  private LocalViewPositionAnimator mLocalViewPositionAnimator;
  private VideoCallMenuButton mMaxMinButton;
  private VideoCallMenuButton mMuteButton;
  private TextView mNameView;
  private int mOrientation = -1;
  private TextView mQualityView;
  private LinearLayout mRemoteVideo;
  private SecureCallListener mSecureCallListener;
  private VideoCallTitleName mSecureTooltip;
  private ImageButton mSecureView;
  private ba mSlidingMenuIgnoreViewCallback;
  private ImageButton mSwitchCameraButton;
  private View mTopBarView;
  private VideoCallMenuButton mTransferButton;
  private VideoCallMenuButton mVideoButton;
  private ViewGroup mVideoContentContainer;

  public VideoContent(Activity paramActivity, ba paramba, ViewGroup paramViewGroup, LocalVideoContainerInitialPositionDefiner paramLocalVideoContainerInitialPositionDefiner, int paramInt, VideoContentListener paramVideoContentListener, LayoutInflater paramLayoutInflater)
  {
    this.mContext = paramActivity;
    this.mCameraCount = paramInt;
    this.mSlidingMenuIgnoreViewCallback = paramba;
    this.mLayoutInflater = paramLayoutInflater;
    this.mBaseView = paramViewGroup;
    this.mVideoContentContainer = ((ViewGroup)this.mBaseView.findViewById(R.id.video_content_container));
    this.mLocalVideoContainerInitialPositionDefiner = paramLocalVideoContainerInitialPositionDefiner;
    this.mLocalVideoContainerInitialPositionDefiner.setCorrectPositionAction(this.mCorrectInitialPositionOfLocalVideoContainer);
    this.mListener = paramVideoContentListener;
    initBaseViews();
  }

  private void initBaseViews()
  {
    this.mRemoteVideo = ((LinearLayout)this.mBaseView.findViewById(R.id.remote));
    this.mLocalVideoContainer = ((FrameLayout)this.mBaseView.findViewById(R.id.local_video_container));
    this.mLocalVideoContentPositionManager = new LocalVideoContentPositionManager(new LocalVideoContentPositionManager.PositionChangedListener()
    {
      public void onPositionChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        VideoContent.this.mLocalVideoContainer.setTranslationX(paramAnonymousInt1);
        VideoContent.this.mLocalVideoContainer.setTranslationY(paramAnonymousInt2);
      }
    });
    this.mLocalViewPositionAnimator = new LocalViewPositionAnimator(this.mLocalVideoContainer, this.mLocalVideoContentPositionManager);
    initDragging(this.mLocalVideoContainer, this.mLocalVideoContentPositionManager, this.mLocalViewPositionAnimator);
    this.mSwitchCameraButton = ((ImageButton)this.mBaseView.findViewById(R.id.switch_camera));
    this.mCameraFlipView = this.mBaseView.findViewById(R.id.camera_flip_view);
    this.mLocalVideoContainer.setVisibility(4);
    if (this.mCameraCount <= 1)
    {
      this.mSwitchCameraButton.setVisibility(8);
      return;
    }
    this.mLocalVideoContainer.setOnClickListener(this);
  }

  private void initDragging(View paramView, final LocalVideoContentPositionManager paramLocalVideoContentPositionManager, final LocalViewPositionAnimator paramLocalViewPositionAnimator)
  {
    if (isLocalVideoContainerDraggingUnavailable())
      return;
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return this.val$detector.a(paramAnonymousMotionEvent);
      }
    });
  }

  private void initLocalVideoContainerPosition()
  {
    final LocalVideoContainerInitialPositionDefiner.InitialPosition localInitialPosition = this.mLocalVideoContainerInitialPositionDefiner.applyOrientation(0);
    this.mLocalVideoContentPositionManager.setQuadrant(localInitialPosition.containerQuadrant);
    ((FrameLayout.LayoutParams)this.mSwitchCameraButton.getLayoutParams()).gravity = localInitialPosition.switchCameraGravity;
    this.mSwitchCameraButton.setRotation(localInitialPosition.switchCameraRotation);
    this.mSwitchCameraButton.requestLayout();
    this.mSwitchCameraButton.bringToFront();
    if (this.mVideoContentContainer != null);
    for (final ViewGroup localViewGroup = this.mVideoContentContainer; localViewGroup.getWidth() == 0; localViewGroup = this.mBaseView)
    {
      dj.a(localViewGroup, new Runnable()
      {
        public void run()
        {
          VideoContent.this.initLocalVideoContentPositionManager(localViewGroup, localInitialPosition.availableRect);
        }
      });
      return;
    }
    initLocalVideoContentPositionManager(localViewGroup, localInitialPosition.availableRect);
  }

  private void initLocalVideoContentPositionManager(View paramView, Rect paramRect)
  {
    this.mLocalVideoContentPositionManager.removeMask(null);
    Rect localRect = new Rect(paramRect.left, paramRect.top, paramView.getWidth() - paramRect.right, paramView.getHeight() - paramRect.bottom);
    this.mLocalVideoContentPositionManager.updateAvailableRect(0, localRect);
    if (this.mBarsVisible)
      this.mCorrectInitialPositionOfLocalVideoContainer.run();
  }

  private boolean isLocalVideoContainerDraggingUnavailable()
  {
    return !com.viber.common.d.a.g();
  }

  private boolean isNeedToIgnoreLocalVideoContainerInSlidingMenu()
  {
    return (this.mSlidingMenuIgnoreViewCallback != null) && (!isLocalVideoContainerDraggingUnavailable());
  }

  private void postBarsInvisibleUpdate()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacks(this);
      this.mHandler.postDelayed(this, 4000L);
    }
  }

  private void setBarsVisible(boolean paramBoolean)
  {
    if (!this.mLocalVideoContainerInitialPositionDefiner.canBarsBeHidden())
      return;
    this.mBarsVisible = paramBoolean;
    this.mLocalVideoContainerInitialPositionDefiner.setBarsVisibility(this.mBarsVisible);
    int i;
    Activity localActivity;
    if (paramBoolean)
    {
      i = 0;
      View[] arrayOfView = new View[2];
      arrayOfView[0] = this.mTopBarView;
      arrayOfView[1] = this.mBottomBarView;
      if (paramBoolean != dj.a(arrayOfView))
      {
        localActivity = this.mContext;
        if (!paramBoolean)
          break label144;
      }
    }
    label144: for (int j = 17432576; ; j = 17432577)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(localActivity, j);
      this.mTopBarView.startAnimation(localAnimation);
      this.mTopBarView.setVisibility(i);
      this.mBottomBarView.startAnimation(localAnimation);
      this.mBottomBarView.setVisibility(i);
      if (this.mBottomBarView.getWidth() == 0)
        break label152;
      this.mAnimateLocalVideoPositionChange.run();
      return;
      i = 8;
      break;
    }
    label152: dj.a(this.mBottomBarView, this.mAnimateLocalVideoPositionChange);
  }

  private void updateSecureView(InCallState paramInCallState)
  {
    if (this.mSecureCallListener == null)
    {
      this.mSecureCallListener = new SecureCallListener(this.mSecureView);
      paramInCallState.addObserver(this.mSecureCallListener);
    }
    while (true)
    {
      this.mSecureCallListener.update(paramInCallState, paramInCallState.clone());
      return;
      this.mSecureCallListener.setSecureCallButton(this.mSecureView);
    }
  }

  public void addCallStatusObserver(InCallState paramInCallState)
  {
    if (this.mCallStatusObserver == null)
      return;
    paramInCallState.addObserver(this.mCallStatusObserver);
  }

  public void addLocalVideo(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mLocalVideoContainer.addView(paramView, paramLayoutParams);
  }

  public void addRemoteVideo(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mRemoteVideo.addView(paramView, paramLayoutParams);
  }

  public void addVideoCallStatistics(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    this.mBaseView.addView(paramView, localLayoutParams);
  }

  public void cancelAnimations()
  {
    if (this.mLocalViewPositionAnimator != null)
      this.mLocalViewPositionAnimator.cancelAnimation();
  }

  public void deleteCallStatusObserver(InCallState paramInCallState)
  {
    if (this.mCallStatusObserver == null)
      return;
    paramInCallState.deleteObserver(this.mCallStatusObserver);
  }

  public void destroy()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacks(this);
      this.mHandler = null;
    }
    if (isNeedToIgnoreLocalVideoContainerInSlidingMenu())
      this.mSlidingMenuIgnoreViewCallback.removeConversationIgnoredView(this.mLocalVideoContainer);
  }

  public String getNameText()
  {
    return this.mNameView.getText().toString();
  }

  public void inflateViews()
  {
    this.mVideoContentContainer.removeAllViews();
    this.mLocalVideoContainerInitialPositionDefiner.resetInitState();
    if ((this.mOrientation == 90) || (this.mOrientation == 270))
    {
      this.mLayoutInflater.inflate(R.layout.video_call_content_0_degrees_land, this.mVideoContentContainer, true).bringToFront();
      return;
    }
    this.mLayoutInflater.inflate(R.layout.video_call_content_0_degrees, this.mVideoContentContainer, true).bringToFront();
  }

  public void initCallStatusView(CallInfo paramCallInfo)
  {
    this.mCallStatusObserver = new CallStatusObserver(this.mChronometer, paramCallInfo);
    this.mCallStatusObserver.update(paramCallInfo.getInCallState(), paramCallInfo.getInCallState().clone());
  }

  public void initViews()
  {
    this.mBaseView.requestLayout();
    this.mVideoButton = ((VideoCallMenuButton)this.mBaseView.findViewById(R.id.video));
    this.mChatButton = ((VideoCallMenuButton)this.mBaseView.findViewById(R.id.chat));
    this.mTransferButton = ((VideoCallMenuButton)this.mBaseView.findViewById(R.id.transfer));
    this.mMuteButton = ((VideoCallMenuButton)this.mBaseView.findViewById(R.id.mute));
    this.mHangupButton = ((VideoCallMenuButton)this.mBaseView.findViewById(R.id.hangup));
    this.mMaxMinButton = ((VideoCallMenuButton)this.mBaseView.findViewById(R.id.max_min));
    this.mSecureView = ((ImageButton)this.mBaseView.findViewById(R.id.phone_call_secure));
    this.mSecureTooltip = ((VideoCallTitleName)this.mBaseView.findViewById(R.id.video_call_tooltip_secure));
    this.mNameView = ((TextView)this.mBaseView.findViewById(R.id.name));
    this.mQualityView = ((TextView)this.mBaseView.findViewById(R.id.phone_call_quality));
    this.mChronometer = ((PausableChronometer)this.mBaseView.findViewById(R.id.chronometer));
    this.mTopBarView = this.mBaseView.findViewById(R.id.video_call_title);
    this.mBottomBarView = this.mBaseView.findViewById(R.id.video_call_menu);
    initLocalVideoContainerPosition();
    if ((this.mVideoButton != null) && (this.mChatButton != null) && (this.mTransferButton != null) && (this.mMuteButton != null) && (this.mHangupButton != null))
    {
      this.mVideoButton.setOnClickListener(this);
      this.mChatButton.setOnClickListener(this);
      this.mTransferButton.setOnClickListener(this);
      this.mMuteButton.setOnClickListener(this);
      this.mHangupButton.setOnClickListener(this);
    }
    if (this.mMaxMinButton != null)
      this.mMaxMinButton.setOnClickListener(this);
    if (this.mSecureView != null)
      this.mSecureView.setOnClickListener(this);
    if (this.mTopBarView != null)
      this.mBaseView.setOnTouchListener(this);
    View[] arrayOfView = new View[2];
    arrayOfView[0] = this.mBottomBarView;
    arrayOfView[1] = this.mTopBarView;
    this.mBarsVisible = dj.a(arrayOfView);
    this.mLocalVideoContainerInitialPositionDefiner.setBarsVisibility(this.mBarsVisible);
    this.mLocalVideoContainerInitialPositionDefiner.onBarViewsInit(this.mBottomBarView);
  }

  public void onClick(View paramView)
  {
    if (this.mLocalVideoContainer == paramView)
      this.mListener.onSwitchCameraClicked();
    while (true)
    {
      if ((this.mTopBarView != null) && (!this.mIsOutgoing))
        postBarsInvisibleUpdate();
      return;
      if (this.mVideoButton == paramView)
      {
        this.mListener.onVideoClicked();
      }
      else if (this.mChatButton == paramView)
      {
        this.mListener.onChatClicked();
      }
      else if (this.mTransferButton == paramView)
      {
        this.mListener.onTransferClicked();
      }
      else if (this.mMuteButton == paramView)
      {
        this.mListener.onMuteClicked(this.mMuteButton);
      }
      else if (this.mHangupButton == paramView)
      {
        this.mListener.onHangupClicked();
      }
      else if ((this.mMaxMinButton != null) && (this.mMaxMinButton == paramView))
      {
        this.mListener.onMaxMinClicked();
      }
      else if (this.mSecureView == paramView)
      {
        this.mListener.onSecureClicked(paramView);
        new SecureStateDescription(this.mContext, ViberApplication.getInstance().getEngine(false).getCurrentCall()).showSecureStateDialog();
      }
    }
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.mIsOutgoing)
      if (this.mBarsVisible)
        break label38;
    label38: for (boolean bool = true; ; bool = false)
    {
      setBarsVisible(bool);
      if (this.mBarsVisible)
        break;
      this.mHandler.removeCallbacks(this);
      return false;
    }
    postBarsInvisibleUpdate();
    return false;
  }

  public void removeRemoteVideo(View paramView)
  {
    this.mRemoteVideo.removeView(paramView);
  }

  public void run()
  {
    if (!this.mIsOutgoing)
      setBarsVisible(false);
  }

  public void setChatChecked(boolean paramBoolean)
  {
    if (this.mChatButton != null)
      this.mChatButton.setChecked(paramBoolean);
  }

  public void setLocalVideoContainerVisible(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.mLocalVideoContainer;
    int i;
    if (paramBoolean)
    {
      i = 0;
      localFrameLayout.setVisibility(i);
      if (!paramBoolean)
        break label58;
      initLocalVideoContainerPosition();
      this.mLocalVideoContentPositionManager.applyGravity(0);
      if (isNeedToIgnoreLocalVideoContainerInSlidingMenu())
        this.mSlidingMenuIgnoreViewCallback.addConversationIgnoredView(this.mLocalVideoContainer);
    }
    label58: 
    do
    {
      return;
      i = 4;
      break;
      this.mLocalViewPositionAnimator.cancelAnimation();
      this.mLocalVideoContentPositionManager.clear();
    }
    while (!isNeedToIgnoreLocalVideoContainerInSlidingMenu());
    this.mSlidingMenuIgnoreViewCallback.removeConversationIgnoredView(this.mLocalVideoContainer);
  }

  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }

  public void setVideoChecked(boolean paramBoolean)
  {
    if (this.mVideoButton != null)
      this.mVideoButton.setChecked(paramBoolean);
  }

  public void update(CallInfo paramCallInfo)
  {
    if (paramCallInfo != null)
    {
      InCallState localInCallState = paramCallInfo.getInCallState();
      if (localInCallState != null)
      {
        if (this.mMuteButton != null)
          this.mMuteButton.setChecked(localInCallState.isMuteEnabled());
        if (this.mSecureView != null)
          updateSecureView(localInCallState);
        if (this.mTransferButton != null)
          this.mTransferButton.setChecked(localInCallState.isTransferring());
      }
      CallerInfo localCallerInfo = paramCallInfo.getCallerInfo();
      if (localCallerInfo != null)
        this.mNameView.setText(localCallerInfo.getVideoContentDisplayName());
      if ((this.mIsOutgoing) || (!paramCallInfo.isOutgoing()))
        break label212;
    }
    for (this.mIsOutgoing = true; ; this.mIsOutgoing = false)
      label212: 
      do
      {
        if ((this.mChatButton != null) && (this.mVideoButton != null) && (this.mMuteButton != null) && (this.mTransferButton != null))
        {
          boolean bool = this.mIsOutgoing;
          int i = 0;
          if (bool)
            i = 8;
          this.mChatButton.setVisibility(i);
          this.mVideoButton.setVisibility(i);
          this.mMuteButton.setVisibility(i);
          this.mTransferButton.setVisibility(i);
          this.mVideoButton.setEnabled(paramCallInfo.isLocalVideoAvailable());
        }
        if ((this.mTopBarView != null) && (!this.mIsOutgoing))
          postBarsInvisibleUpdate();
        return;
      }
      while ((!this.mIsOutgoing) || (paramCallInfo.isOutgoing()));
  }

  public void updateLocalVideoContainerSize(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mLocalVideoContainer.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    this.mLocalVideoContentPositionManager.updateViewRect(paramInt1, paramInt2);
    this.mLocalVideoContainerInitialPositionDefiner.onLocalVideoContainerSizeUpdated(this.mBottomBarView);
    this.mLocalVideoContainer.requestLayout();
  }

  public void updateQualityView(VoiceQualityUpdater paramVoiceQualityUpdater)
  {
    paramVoiceQualityUpdater.setQualityTextView(this.mQualityView);
    if (this.mCallStatusObserver != null)
      this.mCallStatusObserver.setVoiceQualityUpdater(paramVoiceQualityUpdater);
  }

  private class CameraFlipper
    implements Animator.AnimatorListener
  {
    protected static final long FLIP_DURATION = 750L;
    private AnimatorSet mAnimatorSet;

    private CameraFlipper()
    {
    }

    private ObjectAnimator getAnimator(float paramFloat1, float paramFloat2)
    {
      ObjectAnimator localObjectAnimator;
      if (VideoContent.this.mOrientation == 90)
      {
        FrameLayout localFrameLayout = VideoContent.this.mLocalVideoContainer;
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = (-paramFloat1);
        arrayOfFloat[1] = (-paramFloat2);
        localObjectAnimator = ObjectAnimator.ofFloat(localFrameLayout, "rotationX", arrayOfFloat);
      }
      while (true)
      {
        localObjectAnimator.setDuration(750L);
        return localObjectAnimator;
        if (VideoContent.this.mOrientation == 270)
          localObjectAnimator = ObjectAnimator.ofFloat(VideoContent.this.mLocalVideoContainer, "rotationX", new float[] { paramFloat1, paramFloat2 });
        else
          localObjectAnimator = ObjectAnimator.ofFloat(VideoContent.this.mLocalVideoContainer, "rotationY", new float[] { paramFloat1, paramFloat2 });
      }
    }

    private Bitmap getCameraBitmap()
    {
      VideoCaptureApi localVideoCaptureApi = VideoCaptureDeviceInfo.getInstance().getCurrentCaptureObject();
      Object localObject = null;
      if (localVideoCaptureApi != null)
      {
        YuvImage localYuvImage = localVideoCaptureApi.getPreviewBufferCopy();
        localVideoCaptureApi.lockPreviewUpdate();
        localObject = null;
        if (localYuvImage != null)
        {
          Rect localRect = new Rect(0, 0, localYuvImage.getWidth(), localYuvImage.getHeight());
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          boolean bool = localYuvImage.compressToJpeg(localRect, 100, localByteArrayOutputStream);
          localObject = null;
          if (bool)
          {
            byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
            Bitmap localBitmap1 = dq.a(arrayOfByte, 0, arrayOfByte.length);
            Matrix localMatrix = new Matrix();
            if (1 == localVideoCaptureApi.getFacing())
              localMatrix.setScale(1.0F, -1.0F);
            localMatrix.postRotate(localVideoCaptureApi.getPreviewRotation());
            Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 1, 1, -1 + localBitmap1.getWidth(), -1 + localBitmap1.getHeight(), localMatrix, false);
            localBitmap1.recycle();
            localObject = localBitmap2;
          }
        }
        localVideoCaptureApi.unlockPreviewUpdate();
      }
      return localObject;
    }

    private void onEnd()
    {
      if ((VideoContent.this.mCameraFlipView.getBackground() != null) && ((VideoContent.this.mCameraFlipView.getBackground() instanceof BitmapDrawable)))
        ((BitmapDrawable)VideoContent.this.mCameraFlipView.getBackground()).getBitmap().recycle();
      dj.a(VideoContent.this.mCameraFlipView, null);
      VideoContent.this.mCameraFlipView.setVisibility(8);
      VideoContent.this.mLocalVideoContainer.setEnabled(true);
    }

    private void onStart()
    {
      Bitmap localBitmap = getCameraBitmap();
      if (localBitmap != null)
      {
        VideoContent.this.mCameraFlipView.setDrawingCacheEnabled(false);
        dj.a(VideoContent.this.mCameraFlipView, new BitmapDrawable(VideoContent.this.mContext.getResources(), localBitmap));
      }
      while (true)
      {
        VideoContent.this.mLocalVideoContainer.setEnabled(false);
        VideoContent.this.mCameraFlipView.setVisibility(0);
        return;
        VideoContent.this.mCameraFlipView.setBackgroundColor(-16777216);
      }
    }

    public void cancel()
    {
      if (this.mAnimatorSet != null)
        this.mAnimatorSet.cancel();
    }

    public void flip()
    {
      onStart();
      ObjectAnimator localObjectAnimator1 = getAnimator(0.0F, 90.0F);
      ObjectAnimator localObjectAnimator2 = getAnimator(270.0F, 360.0F);
      this.mAnimatorSet = new AnimatorSet();
      this.mAnimatorSet.addListener(this);
      this.mAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      this.mAnimatorSet.start();
    }

    public void onAnimationCancel(Animator paramAnimator)
    {
    }

    public void onAnimationEnd(Animator paramAnimator)
    {
      onEnd();
    }

    public void onAnimationRepeat(Animator paramAnimator)
    {
    }

    public void onAnimationStart(Animator paramAnimator)
    {
    }
  }

  private static class LocalViewPositionAnimator
  {
    private static final int AFTER_BARS_VISIBILITY_CHANGED_MILLIS = 500;
    private static final int AFTER_DRAG_CORRECTION_MILLIS = 100;
    private final PositionChangedListener mDragCompletedListener = new PositionChangedListener(100, null);
    private boolean mIsViewInInteraction;
    private final PositionChangedListener mPositionChangedListener = new PositionChangedListener(500, null);
    private final LocalVideoContentPositionManager mPositionManager;
    private final View mView;

    public LocalViewPositionAnimator(View paramView, LocalVideoContentPositionManager paramLocalVideoContentPositionManager)
    {
      this.mView = paramView;
      this.mPositionManager = paramLocalVideoContentPositionManager;
    }

    public void cancelAnimation()
    {
      ViewPropertyAnimator localViewPropertyAnimator = this.mView.animate();
      localViewPropertyAnimator.cancel();
      localViewPropertyAnimator.setDuration(0L);
    }

    public void onBarsDisplayed(boolean paramBoolean, Rect paramRect)
    {
      if (paramBoolean)
      {
        this.mPositionManager.addMask(paramRect, this.mPositionChangedListener);
        return;
      }
      this.mPositionManager.removeMask(this.mPositionChangedListener);
    }

    public void onDragCompleted(int paramInt)
    {
      this.mPositionManager.calculateFinalPosition(paramInt, this.mDragCompletedListener);
    }

    public void setIsViewInInteraction(boolean paramBoolean)
    {
      this.mIsViewInInteraction = paramBoolean;
      if (paramBoolean)
        cancelAnimation();
    }

    private class PositionChangedListener
      implements LocalVideoContentPositionManager.PositionChangedListener
    {
      private final int mDuration;

      private PositionChangedListener(int arg2)
      {
        int i;
        this.mDuration = i;
      }

      public void onPositionChanged(int paramInt1, int paramInt2)
      {
        if (VideoContent.LocalViewPositionAnimator.this.mIsViewInInteraction);
        do
        {
          return;
          VideoContent.LocalViewPositionAnimator.this.cancelAnimation();
        }
        while ((VideoContent.LocalViewPositionAnimator.this.mView.getTranslationX() == paramInt1) && (VideoContent.LocalViewPositionAnimator.this.mView.getTranslationY() == paramInt2));
        VideoContent.LocalViewPositionAnimator.this.mView.animate().translationX(paramInt1).translationY(paramInt2).setDuration(this.mDuration).start();
      }
    }
  }

  public static abstract interface VideoContentListener
  {
    public abstract void onChatClicked();

    public abstract void onHangupClicked();

    public abstract void onMaxMinClicked();

    public abstract void onMuteClicked(VideoCallMenuButton paramVideoCallMenuButton);

    public abstract void onSecureClicked(View paramView);

    public abstract void onSwitchCameraClicked();

    public abstract void onTransferClicked();

    public abstract void onVideoClicked();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.VideoContent
 * JD-Core Version:    0.6.2
 */