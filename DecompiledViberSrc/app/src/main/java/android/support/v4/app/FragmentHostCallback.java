package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.Preconditions;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer
{
  private final Activity mActivity;
  private final Context mContext;
  final FragmentManagerImpl mFragmentManager = new FragmentManagerImpl();
  private final Handler mHandler;
  private final int mWindowAnimations;

  FragmentHostCallback(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "context == null"));
    this.mHandler = ((Handler)Preconditions.checkNotNull(paramHandler, "handler == null"));
    this.mWindowAnimations = paramInt;
  }

  public FragmentHostCallback(Context paramContext, Handler paramHandler, int paramInt)
  {
  }

  FragmentHostCallback(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, paramFragmentActivity.mHandler, 0);
  }

  Activity getActivity()
  {
    return this.mActivity;
  }

  Context getContext()
  {
    return this.mContext;
  }

  FragmentManagerImpl getFragmentManagerImpl()
  {
    return this.mFragmentManager;
  }

  Handler getHandler()
  {
    return this.mHandler;
  }

  void onAttachFragment(Fragment paramFragment)
  {
  }

  public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
  }

  public View onFindViewById(int paramInt)
  {
    return null;
  }

  public abstract E onGetHost();

  public LayoutInflater onGetLayoutInflater()
  {
    return LayoutInflater.from(this.mContext);
  }

  public int onGetWindowAnimations()
  {
    return this.mWindowAnimations;
  }

  public boolean onHasView()
  {
    return true;
  }

  public boolean onHasWindowAnimations()
  {
    return true;
  }

  public void onRequestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
  }

  public boolean onShouldSaveFragmentState(Fragment paramFragment)
  {
    return true;
  }

  public boolean onShouldShowRequestPermissionRationale(String paramString)
  {
    return false;
  }

  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    onStartActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }

  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt != -1)
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    this.mContext.startActivity(paramIntent);
  }

  public void onStartIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (paramInt1 != -1)
      throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    ActivityCompat.startIntentSenderForResult(this.mActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }

  public void onSupportInvalidateOptionsMenu()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentHostCallback
 * JD-Core Version:    0.6.2
 */