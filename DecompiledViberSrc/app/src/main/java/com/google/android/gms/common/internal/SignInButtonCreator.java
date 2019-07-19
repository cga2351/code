package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

public final class SignInButtonCreator extends RemoteCreator<ISignInButtonCreator>
{
  private static final SignInButtonCreator zape = new SignInButtonCreator();

  private SignInButtonCreator()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }

  public static View createView(Context paramContext, int paramInt1, int paramInt2)
    throws RemoteCreator.RemoteCreatorException
  {
    return zape.zaa(paramContext, paramInt1, paramInt2);
  }

  private final View zaa(Context paramContext, int paramInt1, int paramInt2)
    throws RemoteCreator.RemoteCreatorException
  {
    try
    {
      SignInButtonConfig localSignInButtonConfig = new SignInButtonConfig(paramInt1, paramInt2, null);
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
      View localView = (View)ObjectWrapper.unwrap(((ISignInButtonCreator)getRemoteCreatorInstance(paramContext)).newSignInButtonFromConfig(localIObjectWrapper, localSignInButtonConfig));
      return localView;
    }
    catch (Exception localException)
    {
      throw new RemoteCreator.RemoteCreatorException(64 + "Could not get button with size " + paramInt1 + " and color " + paramInt2, localException);
    }
  }

  public final ISignInButtonCreator getRemoteCreator(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
    if ((localIInterface instanceof ISignInButtonCreator))
      return (ISignInButtonCreator)localIInterface;
    return new zah(paramIBinder);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.SignInButtonCreator
 * JD-Core Version:    0.6.2
 */