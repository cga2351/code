package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import java.util.LinkedList;

@KeepForSdk
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate>
{
  private T zare;
  private Bundle zarf;
  private LinkedList<zaa> zarg;
  private final OnDelegateCreatedListener<T> zarh = new zaa(this);

  @KeepForSdk
  public static void showGooglePlayUnavailableMessage(FrameLayout paramFrameLayout)
  {
    GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
    Context localContext = paramFrameLayout.getContext();
    int i = localGoogleApiAvailability.isGooglePlayServicesAvailable(localContext);
    String str1 = ConnectionErrorMessages.getErrorMessage(localContext, i);
    String str2 = ConnectionErrorMessages.getErrorDialogButtonMessage(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    TextView localTextView = new TextView(paramFrameLayout.getContext());
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    localTextView.setText(str1);
    localLinearLayout.addView(localTextView);
    Intent localIntent = localGoogleApiAvailability.getErrorResolutionIntent(localContext, i, null);
    if (localIntent != null)
    {
      Button localButton = new Button(localContext);
      localButton.setId(16908313);
      localButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      localButton.setText(str2);
      localLinearLayout.addView(localButton);
      localButton.setOnClickListener(new zae(localContext, localIntent));
    }
  }

  private final void zaa(Bundle paramBundle, zaa paramzaa)
  {
    if (this.zare != null)
    {
      paramzaa.zaa(this.zare);
      return;
    }
    if (this.zarg == null)
      this.zarg = new LinkedList();
    this.zarg.add(paramzaa);
    if (paramBundle != null)
    {
      if (this.zarf != null)
        break label76;
      this.zarf = ((Bundle)paramBundle.clone());
    }
    while (true)
    {
      createDelegate(this.zarh);
      return;
      label76: this.zarf.putAll(paramBundle);
    }
  }

  private final void zal(int paramInt)
  {
    while ((!this.zarg.isEmpty()) && (((zaa)this.zarg.getLast()).getState() >= paramInt))
      this.zarg.removeLast();
  }

  @KeepForSdk
  protected abstract void createDelegate(OnDelegateCreatedListener<T> paramOnDelegateCreatedListener);

  @KeepForSdk
  public T getDelegate()
  {
    return this.zare;
  }

  @KeepForSdk
  protected void handleGooglePlayUnavailable(FrameLayout paramFrameLayout)
  {
    showGooglePlayUnavailableMessage(paramFrameLayout);
  }

  @KeepForSdk
  public void onCreate(Bundle paramBundle)
  {
    zaa(paramBundle, new zac(this, paramBundle));
  }

  @KeepForSdk
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zaa(paramBundle, new zad(this, localFrameLayout, paramLayoutInflater, paramViewGroup, paramBundle));
    if (this.zare == null)
      handleGooglePlayUnavailable(localFrameLayout);
    return localFrameLayout;
  }

  @KeepForSdk
  public void onDestroy()
  {
    if (this.zare != null)
    {
      this.zare.onDestroy();
      return;
    }
    zal(1);
  }

  @KeepForSdk
  public void onDestroyView()
  {
    if (this.zare != null)
    {
      this.zare.onDestroyView();
      return;
    }
    zal(2);
  }

  @KeepForSdk
  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    zaa(paramBundle2, new zab(this, paramActivity, paramBundle1, paramBundle2));
  }

  @KeepForSdk
  public void onLowMemory()
  {
    if (this.zare != null)
      this.zare.onLowMemory();
  }

  @KeepForSdk
  public void onPause()
  {
    if (this.zare != null)
    {
      this.zare.onPause();
      return;
    }
    zal(5);
  }

  @KeepForSdk
  public void onResume()
  {
    zaa(null, new zag(this));
  }

  @KeepForSdk
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.zare != null)
      this.zare.onSaveInstanceState(paramBundle);
    while (this.zarf == null)
      return;
    paramBundle.putAll(this.zarf);
  }

  @KeepForSdk
  public void onStart()
  {
    zaa(null, new zaf(this));
  }

  @KeepForSdk
  public void onStop()
  {
    if (this.zare != null)
    {
      this.zare.onStop();
      return;
    }
    zal(4);
  }

  private static abstract interface zaa
  {
    public abstract int getState();

    public abstract void zaa(LifecycleDelegate paramLifecycleDelegate);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.DeferredLifecycleHelper
 * JD-Core Version:    0.6.2
 */