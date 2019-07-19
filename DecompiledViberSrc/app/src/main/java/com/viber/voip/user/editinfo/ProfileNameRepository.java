package com.viber.voip.user.editinfo;

public abstract interface ProfileNameRepository
{
  public abstract void changeName(String paramString);

  public abstract String getName();

  public abstract CharSequence getNameOrDefault(DefaultNameProvider paramDefaultNameProvider);

  public abstract String getNameOrNumber();

  public static abstract interface DefaultNameProvider
  {
    public abstract CharSequence get();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.ProfileNameRepository
 * JD-Core Version:    0.6.2
 */