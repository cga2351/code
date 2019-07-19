package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.e;
import android.arch.lifecycle.e.a;
import android.arch.lifecycle.h;
import android.arch.lifecycle.i;
import android.arch.lifecycle.m;
import android.arch.lifecycle.u;
import android.arch.lifecycle.v;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Fragment
  implements h, v, ComponentCallbacks, View.OnCreateContextMenuListener
{
  static final int ACTIVITY_CREATED = 2;
  static final int CREATED = 1;
  static final int INITIALIZING = 0;
  static final int RESUMED = 4;
  static final int STARTED = 3;
  static final Object USE_DEFAULT_TRANSITION = new Object();
  private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap();
  boolean mAdded;
  AnimationInfo mAnimationInfo;
  Bundle mArguments;
  int mBackStackNesting;
  boolean mCalled;
  FragmentManagerImpl mChildFragmentManager;
  FragmentManagerNonConfig mChildNonConfig;
  ViewGroup mContainer;
  int mContainerId;
  boolean mDeferStart;
  boolean mDetached;
  int mFragmentId;
  FragmentManagerImpl mFragmentManager;
  boolean mFromLayout;
  boolean mHasMenu;
  boolean mHidden;
  boolean mHiddenChanged;
  FragmentHostCallback mHost;
  boolean mInLayout;
  int mIndex = -1;
  View mInnerView;
  boolean mIsCreated;
  boolean mIsNewlyAdded;
  LayoutInflater mLayoutInflater;
  i mLifecycleRegistry = new i(this);
  boolean mMenuVisible = true;
  Fragment mParentFragment;
  boolean mPerformedCreateView;
  float mPostponedAlpha;
  boolean mRemoving;
  boolean mRestored;
  boolean mRetainInstance;
  boolean mRetaining;
  Bundle mSavedFragmentState;
  Boolean mSavedUserVisibleHint;
  SparseArray<Parcelable> mSavedViewState;
  int mState = 0;
  String mTag;
  Fragment mTarget;
  int mTargetIndex = -1;
  int mTargetRequestCode;
  boolean mUserVisibleHint = true;
  View mView;
  h mViewLifecycleOwner;
  m<h> mViewLifecycleOwnerLiveData = new m();
  i mViewLifecycleRegistry;
  u mViewModelStore;
  String mWho;

  private AnimationInfo ensureAnimationInfo()
  {
    if (this.mAnimationInfo == null)
      this.mAnimationInfo = new AnimationInfo();
    return this.mAnimationInfo;
  }

  public static Fragment instantiate(Context paramContext, String paramString)
  {
    return instantiate(paramContext, paramString, null);
  }

  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass = (Class)sClassMap.get(paramString);
      if (localClass == null)
      {
        localClass = paramContext.getClassLoader().loadClass(paramString);
        sClassMap.put(paramString, localClass);
      }
      Fragment localFragment = (Fragment)localClass.getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(localFragment.getClass().getClassLoader());
        localFragment.setArguments(paramBundle);
      }
      return localFragment;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localIllegalAccessException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new InstantiationException("Unable to instantiate fragment " + paramString + ": could not find Fragment constructor", localNoSuchMethodException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new InstantiationException("Unable to instantiate fragment " + paramString + ": calling Fragment constructor caused an exception", localInvocationTargetException);
    }
  }

  static boolean isSupportFragmentClass(Context paramContext, String paramString)
  {
    try
    {
      Class localClass = (Class)sClassMap.get(paramString);
      if (localClass == null)
      {
        localClass = paramContext.getClassLoader().loadClass(paramString);
        sClassMap.put(paramString, localClass);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass);
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  void callStartTransitionListener()
  {
    AnimationInfo localAnimationInfo = this.mAnimationInfo;
    Object localObject = null;
    if (localAnimationInfo == null);
    while (true)
    {
      if (localObject != null)
        localObject.onStartEnterTransition();
      return;
      this.mAnimationInfo.mEnterTransitionPostponed = false;
      OnStartEnterTransitionListener localOnStartEnterTransitionListener = this.mAnimationInfo.mStartEnterTransitionListener;
      this.mAnimationInfo.mStartEnterTransitionListener = null;
      localObject = localOnStartEnterTransitionListener;
    }
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.mState);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.mIndex);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.mRemoving);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.mRetainInstance);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.mRetaining);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.mUserVisibleHint);
    if (this.mFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.mFragmentManager);
    }
    if (this.mHost != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.mHost);
    }
    if (this.mParentFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.mParentFragment);
    }
    if (this.mArguments != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.mArguments);
    }
    if (this.mSavedFragmentState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.mSavedFragmentState);
    }
    if (this.mSavedViewState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.mSavedViewState);
    }
    if (this.mTarget != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.mTarget);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.mTargetRequestCode);
    }
    if (getNextAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(getNextAnim());
    }
    if (this.mContainer != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.mContainer);
    }
    if (this.mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.mView);
    }
    if (this.mInnerView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.mView);
    }
    if (getAnimatingAway() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(getStateAfterAnimating());
    }
    if (getContext() != null)
      LoaderManager.getInstance(this).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.mChildFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.mChildFragmentManager + ":");
      this.mChildFragmentManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }

  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }

  Fragment findFragmentByWho(String paramString)
  {
    if (paramString.equals(this.mWho))
      return this;
    if (this.mChildFragmentManager != null)
      return this.mChildFragmentManager.findFragmentByWho(paramString);
    return null;
  }

  public final FragmentActivity getActivity()
  {
    if (this.mHost == null)
      return null;
    return (FragmentActivity)this.mHost.getActivity();
  }

  public boolean getAllowEnterTransitionOverlap()
  {
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.mAllowEnterTransitionOverlap == null))
      return true;
    return this.mAnimationInfo.mAllowEnterTransitionOverlap.booleanValue();
  }

  public boolean getAllowReturnTransitionOverlap()
  {
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.mAllowReturnTransitionOverlap == null))
      return true;
    return this.mAnimationInfo.mAllowReturnTransitionOverlap.booleanValue();
  }

  View getAnimatingAway()
  {
    if (this.mAnimationInfo == null)
      return null;
    return this.mAnimationInfo.mAnimatingAway;
  }

  Animator getAnimator()
  {
    if (this.mAnimationInfo == null)
      return null;
    return this.mAnimationInfo.mAnimator;
  }

  public final Bundle getArguments()
  {
    return this.mArguments;
  }

  public final FragmentManager getChildFragmentManager()
  {
    if (this.mChildFragmentManager == null)
    {
      instantiateChildFragmentManager();
      if (this.mState < 4)
        break label31;
      this.mChildFragmentManager.dispatchResume();
    }
    while (true)
    {
      return this.mChildFragmentManager;
      label31: if (this.mState >= 3)
        this.mChildFragmentManager.dispatchStart();
      else if (this.mState >= 2)
        this.mChildFragmentManager.dispatchActivityCreated();
      else if (this.mState >= 1)
        this.mChildFragmentManager.dispatchCreate();
    }
  }

  public Context getContext()
  {
    if (this.mHost == null)
      return null;
    return this.mHost.getContext();
  }

  public Object getEnterTransition()
  {
    if (this.mAnimationInfo == null)
      return null;
    return this.mAnimationInfo.mEnterTransition;
  }

  SharedElementCallback getEnterTransitionCallback()
  {
    if (this.mAnimationInfo == null)
      return null;
    return this.mAnimationInfo.mEnterTransitionCallback;
  }

  public Object getExitTransition()
  {
    if (this.mAnimationInfo == null)
      return null;
    return this.mAnimationInfo.mExitTransition;
  }

  SharedElementCallback getExitTransitionCallback()
  {
    if (this.mAnimationInfo == null)
      return null;
    return this.mAnimationInfo.mExitTransitionCallback;
  }

  public final FragmentManager getFragmentManager()
  {
    return this.mFragmentManager;
  }

  public final Object getHost()
  {
    if (this.mHost == null)
      return null;
    return this.mHost.onGetHost();
  }

  public final int getId()
  {
    return this.mFragmentId;
  }

  public final LayoutInflater getLayoutInflater()
  {
    if (this.mLayoutInflater == null)
      return performGetLayoutInflater(null);
    return this.mLayoutInflater;
  }

  @Deprecated
  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    if (this.mHost == null)
      throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    LayoutInflater localLayoutInflater = this.mHost.onGetLayoutInflater();
    getChildFragmentManager();
    LayoutInflaterCompat.setFactory2(localLayoutInflater, this.mChildFragmentManager.getLayoutInflaterFactory());
    return localLayoutInflater;
  }

  public e getLifecycle()
  {
    return this.mLifecycleRegistry;
  }

  @Deprecated
  public LoaderManager getLoaderManager()
  {
    return LoaderManager.getInstance(this);
  }

  int getNextAnim()
  {
    if (this.mAnimationInfo == null)
      return 0;
    return this.mAnimationInfo.mNextAnim;
  }

  int getNextTransition()
  {
    if (this.mAnimationInfo == null)
      return 0;
    return this.mAnimationInfo.mNextTransition;
  }

  int getNextTransitionStyle()
  {
    if (this.mAnimationInfo == null)
      return 0;
    return this.mAnimationInfo.mNextTransitionStyle;
  }

  public final Fragment getParentFragment()
  {
    return this.mParentFragment;
  }

  public Object getReenterTransition()
  {
    if (this.mAnimationInfo == null)
      return null;
    if (this.mAnimationInfo.mReenterTransition == USE_DEFAULT_TRANSITION)
      return getExitTransition();
    return this.mAnimationInfo.mReenterTransition;
  }

  public final Resources getResources()
  {
    return requireContext().getResources();
  }

  public final boolean getRetainInstance()
  {
    return this.mRetainInstance;
  }

  public Object getReturnTransition()
  {
    if (this.mAnimationInfo == null)
      return null;
    if (this.mAnimationInfo.mReturnTransition == USE_DEFAULT_TRANSITION)
      return getEnterTransition();
    return this.mAnimationInfo.mReturnTransition;
  }

  public Object getSharedElementEnterTransition()
  {
    if (this.mAnimationInfo == null)
      return null;
    return this.mAnimationInfo.mSharedElementEnterTransition;
  }

  public Object getSharedElementReturnTransition()
  {
    if (this.mAnimationInfo == null)
      return null;
    if (this.mAnimationInfo.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION)
      return getSharedElementEnterTransition();
    return this.mAnimationInfo.mSharedElementReturnTransition;
  }

  int getStateAfterAnimating()
  {
    if (this.mAnimationInfo == null)
      return 0;
    return this.mAnimationInfo.mStateAfterAnimating;
  }

  public final String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }

  public final String getString(int paramInt, Object[] paramArrayOfObject)
  {
    return getResources().getString(paramInt, paramArrayOfObject);
  }

  public final String getTag()
  {
    return this.mTag;
  }

  public final Fragment getTargetFragment()
  {
    return this.mTarget;
  }

  public final int getTargetRequestCode()
  {
    return this.mTargetRequestCode;
  }

  public final CharSequence getText(int paramInt)
  {
    return getResources().getText(paramInt);
  }

  public boolean getUserVisibleHint()
  {
    return this.mUserVisibleHint;
  }

  public View getView()
  {
    return this.mView;
  }

  public h getViewLifecycleOwner()
  {
    if (this.mViewLifecycleOwner == null)
      throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    return this.mViewLifecycleOwner;
  }

  public LiveData<h> getViewLifecycleOwnerLiveData()
  {
    return this.mViewLifecycleOwnerLiveData;
  }

  public u getViewModelStore()
  {
    if (getContext() == null)
      throw new IllegalStateException("Can't access ViewModels from detached fragment");
    if (this.mViewModelStore == null)
      this.mViewModelStore = new u();
    return this.mViewModelStore;
  }

  public final boolean hasOptionsMenu()
  {
    return this.mHasMenu;
  }

  public final int hashCode()
  {
    return super.hashCode();
  }

  void initState()
  {
    this.mIndex = -1;
    this.mWho = null;
    this.mAdded = false;
    this.mRemoving = false;
    this.mFromLayout = false;
    this.mInLayout = false;
    this.mRestored = false;
    this.mBackStackNesting = 0;
    this.mFragmentManager = null;
    this.mChildFragmentManager = null;
    this.mHost = null;
    this.mFragmentId = 0;
    this.mContainerId = 0;
    this.mTag = null;
    this.mHidden = false;
    this.mDetached = false;
    this.mRetaining = false;
  }

  void instantiateChildFragmentManager()
  {
    if (this.mHost == null)
      throw new IllegalStateException("Fragment has not been attached yet.");
    this.mChildFragmentManager = new FragmentManagerImpl();
    this.mChildFragmentManager.attachController(this.mHost, new FragmentContainer()
    {
      public Fragment instantiate(Context paramAnonymousContext, String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        return Fragment.this.mHost.instantiate(paramAnonymousContext, paramAnonymousString, paramAnonymousBundle);
      }

      public View onFindViewById(int paramAnonymousInt)
      {
        if (Fragment.this.mView == null)
          throw new IllegalStateException("Fragment does not have a view");
        return Fragment.this.mView.findViewById(paramAnonymousInt);
      }

      public boolean onHasView()
      {
        return Fragment.this.mView != null;
      }
    }
    , this);
  }

  public final boolean isAdded()
  {
    return (this.mHost != null) && (this.mAdded);
  }

  public final boolean isDetached()
  {
    return this.mDetached;
  }

  public final boolean isHidden()
  {
    return this.mHidden;
  }

  boolean isHideReplaced()
  {
    if (this.mAnimationInfo == null)
      return false;
    return this.mAnimationInfo.mIsHideReplaced;
  }

  final boolean isInBackStack()
  {
    return this.mBackStackNesting > 0;
  }

  public final boolean isInLayout()
  {
    return this.mInLayout;
  }

  public final boolean isMenuVisible()
  {
    return this.mMenuVisible;
  }

  boolean isPostponed()
  {
    if (this.mAnimationInfo == null)
      return false;
    return this.mAnimationInfo.mEnterTransitionPostponed;
  }

  public final boolean isRemoving()
  {
    return this.mRemoving;
  }

  public final boolean isResumed()
  {
    return this.mState >= 4;
  }

  public final boolean isStateSaved()
  {
    if (this.mFragmentManager == null)
      return false;
    return this.mFragmentManager.isStateSaved();
  }

  public final boolean isVisible()
  {
    return (isAdded()) && (!isHidden()) && (this.mView != null) && (this.mView.getWindowToken() != null) && (this.mView.getVisibility() == 0);
  }

  void noteStateNotSaved()
  {
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.noteStateNotSaved();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    this.mCalled = true;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  @Deprecated
  public void onAttach(Activity paramActivity)
  {
    this.mCalled = true;
  }

  public void onAttach(Context paramContext)
  {
    this.mCalled = true;
    if (this.mHost == null);
    for (Activity localActivity = null; ; localActivity = this.mHost.getActivity())
    {
      if (localActivity != null)
      {
        this.mCalled = false;
        onAttach(localActivity);
      }
      return;
    }
  }

  public void onAttachFragment(Fragment paramFragment)
  {
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mCalled = true;
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }

  public void onCreate(Bundle paramBundle)
  {
    this.mCalled = true;
    restoreChildFragmentState(paramBundle);
    if ((this.mChildFragmentManager != null) && (!this.mChildFragmentManager.isStateAtLeast(1)))
      this.mChildFragmentManager.dispatchCreate();
  }

  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }

  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    getActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }

  public void onDestroy()
  {
    boolean bool = true;
    this.mCalled = bool;
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (localFragmentActivity.isChangingConfigurations()));
    while (true)
    {
      if ((this.mViewModelStore != null) && (!bool))
        this.mViewModelStore.a();
      return;
      bool = false;
    }
  }

  public void onDestroyOptionsMenu()
  {
  }

  public void onDestroyView()
  {
    this.mCalled = true;
  }

  public void onDetach()
  {
    this.mCalled = true;
  }

  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    return getLayoutInflater(paramBundle);
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
  }

  @Deprecated
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mCalled = true;
  }

  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mCalled = true;
    if (this.mHost == null);
    for (Activity localActivity = null; ; localActivity = this.mHost.getActivity())
    {
      if (localActivity != null)
      {
        this.mCalled = false;
        onInflate(localActivity, paramAttributeSet, paramBundle);
      }
      return;
    }
  }

  public void onLowMemory()
  {
    this.mCalled = true;
  }

  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }

  public void onOptionsMenuClosed(Menu paramMenu)
  {
  }

  public void onPause()
  {
    this.mCalled = true;
  }

  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
  }

  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
  }

  public void onResume()
  {
    this.mCalled = true;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
  }

  public void onStart()
  {
    this.mCalled = true;
  }

  public void onStop()
  {
    this.mCalled = true;
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
  }

  public void onViewStateRestored(Bundle paramBundle)
  {
    this.mCalled = true;
  }

  FragmentManager peekChildFragmentManager()
  {
    return this.mChildFragmentManager;
  }

  void performActivityCreated(Bundle paramBundle)
  {
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.noteStateNotSaved();
    this.mState = 2;
    this.mCalled = false;
    onActivityCreated(paramBundle);
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchActivityCreated();
  }

  void performConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchConfigurationChanged(paramConfiguration);
  }

  boolean performContextItemSelected(MenuItem paramMenuItem)
  {
    if (!this.mHidden)
    {
      if (onContextItemSelected(paramMenuItem));
      while ((this.mChildFragmentManager != null) && (this.mChildFragmentManager.dispatchContextItemSelected(paramMenuItem)))
        return true;
    }
    return false;
  }

  void performCreate(Bundle paramBundle)
  {
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.noteStateNotSaved();
    this.mState = 1;
    this.mCalled = false;
    onCreate(paramBundle);
    this.mIsCreated = true;
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    this.mLifecycleRegistry.a(e.a.ON_CREATE);
  }

  boolean performCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool1 = this.mHidden;
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = this.mHasMenu;
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.mMenuVisible;
        bool2 = false;
        if (bool4)
        {
          bool2 = true;
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
        }
      }
      if (this.mChildFragmentManager != null)
        bool2 |= this.mChildFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
    }
    return bool2;
  }

  void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.noteStateNotSaved();
    this.mPerformedCreateView = true;
    this.mViewLifecycleOwner = new h()
    {
      public e getLifecycle()
      {
        if (Fragment.this.mViewLifecycleRegistry == null)
          Fragment.this.mViewLifecycleRegistry = new i(Fragment.this.mViewLifecycleOwner);
        return Fragment.this.mViewLifecycleRegistry;
      }
    };
    this.mViewLifecycleRegistry = null;
    this.mView = onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mView != null)
    {
      this.mViewLifecycleOwner.getLifecycle();
      this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
      return;
    }
    if (this.mViewLifecycleRegistry != null)
      throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    this.mViewLifecycleOwner = null;
  }

  void performDestroy()
  {
    this.mLifecycleRegistry.a(e.a.ON_DESTROY);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchDestroy();
    this.mState = 0;
    this.mCalled = false;
    this.mIsCreated = false;
    onDestroy();
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    this.mChildFragmentManager = null;
  }

  void performDestroyView()
  {
    if (this.mView != null)
      this.mViewLifecycleRegistry.a(e.a.ON_DESTROY);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchDestroyView();
    this.mState = 1;
    this.mCalled = false;
    onDestroyView();
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    LoaderManager.getInstance(this).markForRedelivery();
    this.mPerformedCreateView = false;
  }

  void performDetach()
  {
    this.mCalled = false;
    onDetach();
    this.mLayoutInflater = null;
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    if (this.mChildFragmentManager != null)
    {
      if (!this.mRetaining)
        throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
      this.mChildFragmentManager.dispatchDestroy();
      this.mChildFragmentManager = null;
    }
  }

  LayoutInflater performGetLayoutInflater(Bundle paramBundle)
  {
    this.mLayoutInflater = onGetLayoutInflater(paramBundle);
    return this.mLayoutInflater;
  }

  void performLowMemory()
  {
    onLowMemory();
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchLowMemory();
  }

  void performMultiWindowModeChanged(boolean paramBoolean)
  {
    onMultiWindowModeChanged(paramBoolean);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
  }

  boolean performOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible) && (onOptionsItemSelected(paramMenuItem)));
      while ((this.mChildFragmentManager != null) && (this.mChildFragmentManager.dispatchOptionsItemSelected(paramMenuItem)))
        return true;
    }
    return false;
  }

  void performOptionsMenuClosed(Menu paramMenu)
  {
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible))
        onOptionsMenuClosed(paramMenu);
      if (this.mChildFragmentManager != null)
        this.mChildFragmentManager.dispatchOptionsMenuClosed(paramMenu);
    }
  }

  void performPause()
  {
    if (this.mView != null)
      this.mViewLifecycleRegistry.a(e.a.ON_PAUSE);
    this.mLifecycleRegistry.a(e.a.ON_PAUSE);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchPause();
    this.mState = 3;
    this.mCalled = false;
    onPause();
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
  }

  void performPictureInPictureModeChanged(boolean paramBoolean)
  {
    onPictureInPictureModeChanged(paramBoolean);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
  }

  boolean performPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool1 = this.mHidden;
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = this.mHasMenu;
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.mMenuVisible;
        bool2 = false;
        if (bool4)
        {
          bool2 = true;
          onPrepareOptionsMenu(paramMenu);
        }
      }
      if (this.mChildFragmentManager != null)
        bool2 |= this.mChildFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
    }
    return bool2;
  }

  void performResume()
  {
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mState = 4;
    this.mCalled = false;
    onResume();
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.dispatchResume();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mLifecycleRegistry.a(e.a.ON_RESUME);
    if (this.mView != null)
      this.mViewLifecycleRegistry.a(e.a.ON_RESUME);
  }

  void performSaveInstanceState(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    if (this.mChildFragmentManager != null)
    {
      Parcelable localParcelable = this.mChildFragmentManager.saveAllState();
      if (localParcelable != null)
        paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }

  void performStart()
  {
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mState = 3;
    this.mCalled = false;
    onStart();
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchStart();
    this.mLifecycleRegistry.a(e.a.ON_START);
    if (this.mView != null)
      this.mViewLifecycleRegistry.a(e.a.ON_START);
  }

  void performStop()
  {
    if (this.mView != null)
      this.mViewLifecycleRegistry.a(e.a.ON_STOP);
    this.mLifecycleRegistry.a(e.a.ON_STOP);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchStop();
    this.mState = 2;
    this.mCalled = false;
    onStop();
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
  }

  public void postponeEnterTransition()
  {
    ensureAnimationInfo().mEnterTransitionPostponed = true;
  }

  public void registerForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }

  public final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    if (this.mHost == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    this.mHost.onRequestPermissionsFromFragment(this, paramArrayOfString, paramInt);
  }

  public final FragmentActivity requireActivity()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
      throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    return localFragmentActivity;
  }

  public final Context requireContext()
  {
    Context localContext = getContext();
    if (localContext == null)
      throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    return localContext;
  }

  public final FragmentManager requireFragmentManager()
  {
    FragmentManager localFragmentManager = getFragmentManager();
    if (localFragmentManager == null)
      throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    return localFragmentManager;
  }

  public final Object requireHost()
  {
    Object localObject = getHost();
    if (localObject == null)
      throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    return localObject;
  }

  void restoreChildFragmentState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      if (localParcelable != null)
      {
        if (this.mChildFragmentManager == null)
          instantiateChildFragmentManager();
        this.mChildFragmentManager.restoreAllState(localParcelable, this.mChildNonConfig);
        this.mChildNonConfig = null;
        this.mChildFragmentManager.dispatchCreate();
      }
    }
  }

  final void restoreViewState(Bundle paramBundle)
  {
    if (this.mSavedViewState != null)
    {
      this.mInnerView.restoreHierarchyState(this.mSavedViewState);
      this.mSavedViewState = null;
    }
    this.mCalled = false;
    onViewStateRestored(paramBundle);
    if (!this.mCalled)
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    if (this.mView != null)
      this.mViewLifecycleRegistry.a(e.a.ON_CREATE);
  }

  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfo().mAllowEnterTransitionOverlap = Boolean.valueOf(paramBoolean);
  }

  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfo().mAllowReturnTransitionOverlap = Boolean.valueOf(paramBoolean);
  }

  void setAnimatingAway(View paramView)
  {
    ensureAnimationInfo().mAnimatingAway = paramView;
  }

  void setAnimator(Animator paramAnimator)
  {
    ensureAnimationInfo().mAnimator = paramAnimator;
  }

  public void setArguments(Bundle paramBundle)
  {
    if ((this.mIndex >= 0) && (isStateSaved()))
      throw new IllegalStateException("Fragment already active and state has been saved");
    this.mArguments = paramBundle;
  }

  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfo().mEnterTransitionCallback = paramSharedElementCallback;
  }

  public void setEnterTransition(Object paramObject)
  {
    ensureAnimationInfo().mEnterTransition = paramObject;
  }

  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfo().mExitTransitionCallback = paramSharedElementCallback;
  }

  public void setExitTransition(Object paramObject)
  {
    ensureAnimationInfo().mExitTransition = paramObject;
  }

  public void setHasOptionsMenu(boolean paramBoolean)
  {
    if (this.mHasMenu != paramBoolean)
    {
      this.mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden()))
        this.mHost.onSupportInvalidateOptionsMenu();
    }
  }

  void setHideReplaced(boolean paramBoolean)
  {
    ensureAnimationInfo().mIsHideReplaced = paramBoolean;
  }

  final void setIndex(int paramInt, Fragment paramFragment)
  {
    this.mIndex = paramInt;
    if (paramFragment != null)
    {
      this.mWho = (paramFragment.mWho + ":" + this.mIndex);
      return;
    }
    this.mWho = ("android:fragment:" + this.mIndex);
  }

  public void setInitialSavedState(SavedState paramSavedState)
  {
    if (this.mIndex >= 0)
      throw new IllegalStateException("Fragment already active");
    if ((paramSavedState != null) && (paramSavedState.mState != null));
    for (Bundle localBundle = paramSavedState.mState; ; localBundle = null)
    {
      this.mSavedFragmentState = localBundle;
      return;
    }
  }

  public void setMenuVisibility(boolean paramBoolean)
  {
    if (this.mMenuVisible != paramBoolean)
    {
      this.mMenuVisible = paramBoolean;
      if ((this.mHasMenu) && (isAdded()) && (!isHidden()))
        this.mHost.onSupportInvalidateOptionsMenu();
    }
  }

  void setNextAnim(int paramInt)
  {
    if ((this.mAnimationInfo == null) && (paramInt == 0))
      return;
    ensureAnimationInfo().mNextAnim = paramInt;
  }

  void setNextTransition(int paramInt1, int paramInt2)
  {
    if ((this.mAnimationInfo == null) && (paramInt1 == 0) && (paramInt2 == 0))
      return;
    ensureAnimationInfo();
    this.mAnimationInfo.mNextTransition = paramInt1;
    this.mAnimationInfo.mNextTransitionStyle = paramInt2;
  }

  void setOnStartEnterTransitionListener(OnStartEnterTransitionListener paramOnStartEnterTransitionListener)
  {
    ensureAnimationInfo();
    if (paramOnStartEnterTransitionListener == this.mAnimationInfo.mStartEnterTransitionListener);
    do
    {
      return;
      if ((paramOnStartEnterTransitionListener != null) && (this.mAnimationInfo.mStartEnterTransitionListener != null))
        throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
      if (this.mAnimationInfo.mEnterTransitionPostponed)
        this.mAnimationInfo.mStartEnterTransitionListener = paramOnStartEnterTransitionListener;
    }
    while (paramOnStartEnterTransitionListener == null);
    paramOnStartEnterTransitionListener.startListening();
  }

  public void setReenterTransition(Object paramObject)
  {
    ensureAnimationInfo().mReenterTransition = paramObject;
  }

  public void setRetainInstance(boolean paramBoolean)
  {
    this.mRetainInstance = paramBoolean;
  }

  public void setReturnTransition(Object paramObject)
  {
    ensureAnimationInfo().mReturnTransition = paramObject;
  }

  public void setSharedElementEnterTransition(Object paramObject)
  {
    ensureAnimationInfo().mSharedElementEnterTransition = paramObject;
  }

  public void setSharedElementReturnTransition(Object paramObject)
  {
    ensureAnimationInfo().mSharedElementReturnTransition = paramObject;
  }

  void setStateAfterAnimating(int paramInt)
  {
    ensureAnimationInfo().mStateAfterAnimating = paramInt;
  }

  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    FragmentManager localFragmentManager1 = getFragmentManager();
    if (paramFragment != null);
    for (FragmentManager localFragmentManager2 = paramFragment.getFragmentManager(); (localFragmentManager1 != null) && (localFragmentManager2 != null) && (localFragmentManager1 != localFragmentManager2); localFragmentManager2 = null)
      throw new IllegalArgumentException("Fragment " + paramFragment + " must share the same FragmentManager to be set as a target fragment");
    for (Fragment localFragment = paramFragment; localFragment != null; localFragment = localFragment.getTargetFragment())
      if (localFragment == this)
        throw new IllegalArgumentException("Setting " + paramFragment + " as the target of " + this + " would create a target cycle");
    this.mTarget = paramFragment;
    this.mTargetRequestCode = paramInt;
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((!this.mUserVisibleHint) && (paramBoolean) && (this.mState < 3) && (this.mFragmentManager != null) && (isAdded()) && (this.mIsCreated))
      this.mFragmentManager.performPendingDeferredStart(this);
    this.mUserVisibleHint = paramBoolean;
    if ((this.mState < 3) && (!paramBoolean));
    for (boolean bool = true; ; bool = false)
    {
      this.mDeferStart = bool;
      if (this.mSavedFragmentState != null)
        this.mSavedUserVisibleHint = Boolean.valueOf(paramBoolean);
      return;
    }
  }

  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    if (this.mHost != null)
      return this.mHost.onShouldShowRequestPermissionRationale(paramString);
    return false;
  }

  public void startActivity(Intent paramIntent)
  {
    startActivity(paramIntent, null);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    if (this.mHost == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    this.mHost.onStartActivityFromFragment(this, paramIntent, -1, paramBundle);
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt, null);
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (this.mHost == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    this.mHost.onStartActivityFromFragment(this, paramIntent, paramInt, paramBundle);
  }

  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (this.mHost == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    this.mHost.onStartIntentSenderFromFragment(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }

  public void startPostponedEnterTransition()
  {
    if ((this.mFragmentManager == null) || (this.mFragmentManager.mHost == null))
    {
      ensureAnimationInfo().mEnterTransitionPostponed = false;
      return;
    }
    if (Looper.myLooper() != this.mFragmentManager.mHost.getHandler().getLooper())
    {
      this.mFragmentManager.mHost.getHandler().postAtFrontOfQueue(new Runnable()
      {
        public void run()
        {
          Fragment.this.callStartTransitionListener();
        }
      });
      return;
    }
    callStartTransitionListener();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    DebugUtils.buildShortClassTag(this, localStringBuilder);
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.mFragmentId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.mFragmentId));
    }
    if (this.mTag != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mTag);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }

  public void unregisterForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(null);
  }

  static class AnimationInfo
  {
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Animator mAnimator;
    Object mEnterTransition = null;
    SharedElementCallback mEnterTransitionCallback = null;
    boolean mEnterTransitionPostponed;
    Object mExitTransition = null;
    SharedElementCallback mExitTransitionCallback = null;
    boolean mIsHideReplaced;
    int mNextAnim;
    int mNextTransition;
    int mNextTransitionStyle;
    Object mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
    Object mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
    Object mSharedElementEnterTransition = null;
    Object mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
    Fragment.OnStartEnterTransitionListener mStartEnterTransitionListener;
    int mStateAfterAnimating;
  }

  public static class InstantiationException extends RuntimeException
  {
    public InstantiationException(String paramString, Exception paramException)
    {
      super(paramException);
    }
  }

  static abstract interface OnStartEnterTransitionListener
  {
    public abstract void onStartEnterTransition();

    public abstract void startListening();
  }

  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public Fragment.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Fragment.SavedState(paramAnonymousParcel, null);
      }

      public Fragment.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new Fragment.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }

      public Fragment.SavedState[] newArray(int paramAnonymousInt)
      {
        return new Fragment.SavedState[paramAnonymousInt];
      }
    };
    final Bundle mState;

    SavedState(Bundle paramBundle)
    {
      this.mState = paramBundle;
    }

    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      this.mState = paramParcel.readBundle();
      if ((paramClassLoader != null) && (this.mState != null))
        this.mState.setClassLoader(paramClassLoader);
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeBundle(this.mState);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.Fragment
 * JD-Core Version:    0.6.2
 */