package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PendingCallStore;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import java.util.UUID;

public class UiLifecycleHelper
{
  private static final String ACTIVITY_NULL_MESSAGE = "activity cannot be null";
  private static final String DIALOG_CALL_ID_SAVE_KEY = "com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey";
  private final Activity activity;
  private AppEventsLogger appEventsLogger;
  private final LocalBroadcastManager broadcastManager;
  private final Session.StatusCallback callback;
  private UUID pendingFacebookDialogCallId;
  private PendingCallStore pendingFacebookDialogCallStore;
  private final BroadcastReceiver receiver;

  public UiLifecycleHelper(Activity paramActivity, Session.StatusCallback paramStatusCallback)
  {
    if (paramActivity == null)
      throw new IllegalArgumentException("activity cannot be null");
    this.activity = paramActivity;
    this.callback = paramStatusCallback;
    this.receiver = new ActiveSessionBroadcastReceiver(null);
    this.broadcastManager = LocalBroadcastManager.getInstance(paramActivity);
    this.pendingFacebookDialogCallStore = PendingCallStore.getInstance();
    Settings.sdkInitialize(paramActivity);
  }

  private void cancelPendingAppCall(FacebookDialog.Callback paramCallback)
  {
    if (this.pendingFacebookDialogCallId == null);
    FacebookDialog.PendingCall localPendingCall;
    do
    {
      return;
      localPendingCall = this.pendingFacebookDialogCallStore.getPendingCallById(this.pendingFacebookDialogCallId);
    }
    while (localPendingCall == null);
    if (paramCallback != null)
    {
      Intent localIntent1 = localPendingCall.getRequestIntent();
      Intent localIntent2 = new Intent();
      localIntent2.putExtra("com.facebook.platform.protocol.CALL_ID", localIntent1.getStringExtra("com.facebook.platform.protocol.CALL_ID"));
      localIntent2.putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", localIntent1.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION"));
      localIntent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", localIntent1.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0));
      localIntent2.putExtra("com.facebook.platform.status.ERROR_TYPE", "UnknownError");
      FacebookDialog.handleActivityResult(this.activity, localPendingCall, localPendingCall.getRequestCode(), localIntent2, paramCallback);
    }
    stopTrackingPendingAppCall();
  }

  private boolean handleFacebookDialogActivityResult(int paramInt1, int paramInt2, Intent paramIntent, FacebookDialog.Callback paramCallback)
  {
    if (this.pendingFacebookDialogCallId == null);
    FacebookDialog.PendingCall localPendingCall;
    do
    {
      return false;
      localPendingCall = this.pendingFacebookDialogCallStore.getPendingCallById(this.pendingFacebookDialogCallId);
    }
    while ((localPendingCall == null) || (localPendingCall.getRequestCode() != paramInt1));
    if (paramIntent == null)
    {
      cancelPendingAppCall(paramCallback);
      return true;
    }
    UUID localUUID = NativeProtocol.getCallIdFromIntent(paramIntent);
    if ((localUUID != null) && (this.pendingFacebookDialogCallId.equals(localUUID)))
      FacebookDialog.handleActivityResult(this.activity, localPendingCall, paramInt1, paramIntent, paramCallback);
    while (true)
    {
      stopTrackingPendingAppCall();
      return true;
      cancelPendingAppCall(paramCallback);
    }
  }

  private void stopTrackingPendingAppCall()
  {
    this.pendingFacebookDialogCallStore.stopTrackingPendingCall(this.pendingFacebookDialogCallId);
    this.pendingFacebookDialogCallId = null;
  }

  public AppEventsLogger getAppEventsLogger()
  {
    Session localSession = Session.getActiveSession();
    if (localSession == null)
      return null;
    if ((this.appEventsLogger == null) || (!this.appEventsLogger.isValidForSession(localSession)))
    {
      if (this.appEventsLogger != null)
        AppEventsLogger.onContextStop();
      this.appEventsLogger = AppEventsLogger.newLogger(this.activity, localSession);
    }
    return this.appEventsLogger;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    onActivityResult(paramInt1, paramInt2, paramIntent, null);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent, FacebookDialog.Callback paramCallback)
  {
    Session localSession = Session.getActiveSession();
    Activity localActivity;
    if (localSession != null)
    {
      localActivity = this.activity;
      if (paramIntent == null)
        break label49;
    }
    label49: for (Bundle localBundle = paramIntent.getExtras(); ; localBundle = null)
    {
      localSession.onActivityResult(localActivity, paramInt1, paramInt2, localBundle);
      handleFacebookDialogActivityResult(paramInt1, paramInt2, paramIntent, paramCallback);
      return;
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    Session localSession = Session.getActiveSession();
    if (localSession == null)
    {
      if (paramBundle != null)
        localSession = Session.restoreSession(this.activity, null, this.callback, paramBundle);
      if (localSession == null)
        localSession = new Session(this.activity);
      Session.setActiveSession(localSession);
    }
    if (paramBundle != null)
    {
      String str = paramBundle.getString("com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey");
      if (str != null)
        this.pendingFacebookDialogCallId = UUID.fromString(str);
      this.pendingFacebookDialogCallStore.restoreFromSavedInstanceState(paramBundle);
    }
  }

  public void onDestroy()
  {
  }

  public void onPause()
  {
    this.broadcastManager.unregisterReceiver(this.receiver);
    if (this.callback != null)
    {
      Session localSession = Session.getActiveSession();
      if (localSession != null)
        localSession.removeCallback(this.callback);
    }
  }

  public void onResume()
  {
    Session localSession = Session.getActiveSession();
    if (localSession != null)
    {
      if (this.callback != null)
        localSession.addCallback(this.callback);
      if (SessionState.CREATED_TOKEN_LOADED.equals(localSession.getState()))
        localSession.openForRead(null);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
    localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
    this.broadcastManager.registerReceiver(this.receiver, localIntentFilter);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    Session.saveSession(Session.getActiveSession(), paramBundle);
    if (this.pendingFacebookDialogCallId != null)
      paramBundle.putString("com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey", this.pendingFacebookDialogCallId.toString());
    this.pendingFacebookDialogCallStore.saveInstanceState(paramBundle);
  }

  public void onStop()
  {
    AppEventsLogger.onContextStop();
  }

  public void trackPendingDialogCall(FacebookDialog.PendingCall paramPendingCall)
  {
    if (this.pendingFacebookDialogCallId != null)
    {
      Log.i("Facebook", "Tracking new app call while one is still pending; canceling pending call.");
      cancelPendingAppCall(null);
    }
    if (paramPendingCall != null)
    {
      this.pendingFacebookDialogCallId = paramPendingCall.getCallId();
      this.pendingFacebookDialogCallStore.trackPendingCall(paramPendingCall);
    }
  }

  private class ActiveSessionBroadcastReceiver extends BroadcastReceiver
  {
    private ActiveSessionBroadcastReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.facebook.sdk.ACTIVE_SESSION_SET".equals(paramIntent.getAction()))
      {
        Session localSession2 = Session.getActiveSession();
        if ((localSession2 != null) && (UiLifecycleHelper.this.callback != null))
          localSession2.addCallback(UiLifecycleHelper.this.callback);
      }
      Session localSession1;
      do
      {
        do
          return;
        while (!"com.facebook.sdk.ACTIVE_SESSION_UNSET".equals(paramIntent.getAction()));
        localSession1 = Session.getActiveSession();
      }
      while ((localSession1 == null) || (UiLifecycleHelper.this.callback == null));
      localSession1.removeCallback(UiLifecycleHelper.this.callback);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.UiLifecycleHelper
 * JD-Core Version:    0.6.2
 */