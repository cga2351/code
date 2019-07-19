package com.facebook.react.module.model;

public class ReactModuleInfo
{
  private final boolean mCanOverrideExistingModule;
  private String mClassName;
  private final boolean mHasConstants;
  private final boolean mIsCxxModule;
  private final boolean mIsTurboModule;
  private final String mName;
  private final boolean mNeedsEagerInit;

  public ReactModuleInfo(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.mName = paramString1;
    this.mClassName = paramString2;
    this.mCanOverrideExistingModule = paramBoolean1;
    this.mNeedsEagerInit = paramBoolean2;
    this.mHasConstants = paramBoolean3;
    this.mIsCxxModule = paramBoolean4;
    this.mIsTurboModule = paramBoolean5;
  }

  public boolean canOverrideExistingModule()
  {
    return this.mCanOverrideExistingModule;
  }

  public String className()
  {
    return this.mClassName;
  }

  public boolean hasConstants()
  {
    return this.mHasConstants;
  }

  public boolean isCxxModule()
  {
    return this.mIsCxxModule;
  }

  public boolean isTurboModule()
  {
    return this.mIsTurboModule;
  }

  public String name()
  {
    return this.mName;
  }

  public boolean needsEagerInit()
  {
    return this.mNeedsEagerInit;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.module.model.ReactModuleInfo
 * JD-Core Version:    0.6.2
 */