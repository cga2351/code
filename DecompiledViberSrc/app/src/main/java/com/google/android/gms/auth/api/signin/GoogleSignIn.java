package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.auth.api.signin.internal.zzp;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleSignIn
{
  public static GoogleSignInAccount getAccountForExtension(Context paramContext, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    Preconditions.checkNotNull(paramContext, "please provide a valid Context object");
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "please provide valid GoogleSignInOptionsExtension");
    GoogleSignInAccount localGoogleSignInAccount = getLastSignedInAccount(paramContext);
    if (localGoogleSignInAccount == null)
      localGoogleSignInAccount = GoogleSignInAccount.createDefault();
    return localGoogleSignInAccount.requestExtraScopes(zzc(paramGoogleSignInOptionsExtension.getImpliedScopes()));
  }

  public static GoogleSignInAccount getAccountForScopes(Context paramContext, Scope paramScope, Scope[] paramArrayOfScope)
  {
    Preconditions.checkNotNull(paramContext, "please provide a valid Context object");
    Preconditions.checkNotNull(paramScope, "please provide at least one valid scope");
    GoogleSignInAccount localGoogleSignInAccount = getLastSignedInAccount(paramContext);
    if (localGoogleSignInAccount == null)
      localGoogleSignInAccount = GoogleSignInAccount.createDefault();
    localGoogleSignInAccount.requestExtraScopes(new Scope[] { paramScope });
    localGoogleSignInAccount.requestExtraScopes(paramArrayOfScope);
    return localGoogleSignInAccount;
  }

  public static GoogleSignInClient getClient(Activity paramActivity, GoogleSignInOptions paramGoogleSignInOptions)
  {
    return new GoogleSignInClient(paramActivity, (GoogleSignInOptions)Preconditions.checkNotNull(paramGoogleSignInOptions));
  }

  public static GoogleSignInClient getClient(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    return new GoogleSignInClient(paramContext, (GoogleSignInOptions)Preconditions.checkNotNull(paramGoogleSignInOptions));
  }

  public static GoogleSignInAccount getLastSignedInAccount(Context paramContext)
  {
    return zzp.zzd(paramContext).zzh();
  }

  public static Task<GoogleSignInAccount> getSignedInAccountFromIntent(Intent paramIntent)
  {
    GoogleSignInResult localGoogleSignInResult = zzh.getSignInResultFromIntent(paramIntent);
    if (localGoogleSignInResult == null)
      return Tasks.forException(ApiExceptionUtil.fromStatus(Status.RESULT_INTERNAL_ERROR));
    if ((!localGoogleSignInResult.getStatus().isSuccess()) || (localGoogleSignInResult.getSignInAccount() == null))
      return Tasks.forException(ApiExceptionUtil.fromStatus(localGoogleSignInResult.getStatus()));
    return Tasks.forResult(localGoogleSignInResult.getSignInAccount());
  }

  public static boolean hasPermissions(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
    return hasPermissions(paramGoogleSignInAccount, zzc(paramGoogleSignInOptionsExtension.getImpliedScopes()));
  }

  public static boolean hasPermissions(GoogleSignInAccount paramGoogleSignInAccount, Scope[] paramArrayOfScope)
  {
    if (paramGoogleSignInAccount == null)
      return false;
    HashSet localHashSet = new HashSet();
    Collections.addAll(localHashSet, paramArrayOfScope);
    return paramGoogleSignInAccount.getGrantedScopes().containsAll(localHashSet);
  }

  public static void requestPermissions(Activity paramActivity, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    Preconditions.checkNotNull(paramActivity, "Please provide a non-null Activity");
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
    requestPermissions(paramActivity, paramInt, paramGoogleSignInAccount, zzc(paramGoogleSignInOptionsExtension.getImpliedScopes()));
  }

  public static void requestPermissions(Activity paramActivity, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, Scope[] paramArrayOfScope)
  {
    Preconditions.checkNotNull(paramActivity, "Please provide a non-null Activity");
    Preconditions.checkNotNull(paramArrayOfScope, "Please provide at least one scope");
    paramActivity.startActivityForResult(zzc(paramActivity, paramGoogleSignInAccount, paramArrayOfScope), paramInt);
  }

  public static void requestPermissions(Fragment paramFragment, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    Preconditions.checkNotNull(paramFragment, "Please provide a non-null Fragment");
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
    requestPermissions(paramFragment, paramInt, paramGoogleSignInAccount, zzc(paramGoogleSignInOptionsExtension.getImpliedScopes()));
  }

  public static void requestPermissions(Fragment paramFragment, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, Scope[] paramArrayOfScope)
  {
    Preconditions.checkNotNull(paramFragment, "Please provide a non-null Fragment");
    Preconditions.checkNotNull(paramArrayOfScope, "Please provide at least one scope");
    paramFragment.startActivityForResult(zzc(paramFragment.getActivity(), paramGoogleSignInAccount, paramArrayOfScope), paramInt);
  }

  private static Intent zzc(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount, Scope[] paramArrayOfScope)
  {
    GoogleSignInOptions.Builder localBuilder = new GoogleSignInOptions.Builder();
    if (paramArrayOfScope.length > 0)
      localBuilder.requestScopes(paramArrayOfScope[0], paramArrayOfScope);
    if ((paramGoogleSignInAccount != null) && (!TextUtils.isEmpty(paramGoogleSignInAccount.getEmail())))
      localBuilder.setAccountName(paramGoogleSignInAccount.getEmail());
    return new GoogleSignInClient(paramActivity, localBuilder.build()).getSignInIntent();
  }

  private static Scope[] zzc(List<Scope> paramList)
  {
    if (paramList == null)
      return new Scope[0];
    return (Scope[])paramList.toArray(new Scope[paramList.size()]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignIn
 * JD-Core Version:    0.6.2
 */