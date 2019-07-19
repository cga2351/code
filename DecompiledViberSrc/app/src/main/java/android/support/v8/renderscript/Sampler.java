package android.support.v8.renderscript;

public class Sampler extends BaseObj
{
  float mAniso;
  Value mMag;
  Value mMin;
  Value mWrapR;
  Value mWrapS;
  Value mWrapT;

  Sampler(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  public static Sampler CLAMP_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_CLAMP_LINEAR == null)
    {
      Builder localBuilder = new Builder(paramRenderScript);
      localBuilder.setMinification(Value.LINEAR);
      localBuilder.setMagnification(Value.LINEAR);
      localBuilder.setWrapS(Value.CLAMP);
      localBuilder.setWrapT(Value.CLAMP);
      paramRenderScript.mSampler_CLAMP_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_CLAMP_LINEAR;
  }

  public static Sampler CLAMP_LINEAR_MIP_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_CLAMP_LINEAR_MIP_LINEAR == null)
    {
      Builder localBuilder = new Builder(paramRenderScript);
      localBuilder.setMinification(Value.LINEAR_MIP_LINEAR);
      localBuilder.setMagnification(Value.LINEAR);
      localBuilder.setWrapS(Value.CLAMP);
      localBuilder.setWrapT(Value.CLAMP);
      paramRenderScript.mSampler_CLAMP_LINEAR_MIP_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_CLAMP_LINEAR_MIP_LINEAR;
  }

  public static Sampler CLAMP_NEAREST(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_CLAMP_NEAREST == null)
    {
      Builder localBuilder = new Builder(paramRenderScript);
      localBuilder.setMinification(Value.NEAREST);
      localBuilder.setMagnification(Value.NEAREST);
      localBuilder.setWrapS(Value.CLAMP);
      localBuilder.setWrapT(Value.CLAMP);
      paramRenderScript.mSampler_CLAMP_NEAREST = localBuilder.create();
    }
    return paramRenderScript.mSampler_CLAMP_NEAREST;
  }

  public static Sampler MIRRORED_REPEAT_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_MIRRORED_REPEAT_LINEAR == null)
    {
      Builder localBuilder = new Builder(paramRenderScript);
      localBuilder.setMinification(Value.LINEAR);
      localBuilder.setMagnification(Value.LINEAR);
      localBuilder.setWrapS(Value.MIRRORED_REPEAT);
      localBuilder.setWrapT(Value.MIRRORED_REPEAT);
      paramRenderScript.mSampler_MIRRORED_REPEAT_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_MIRRORED_REPEAT_LINEAR;
  }

  public static Sampler MIRRORED_REPEAT_NEAREST(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_MIRRORED_REPEAT_NEAREST == null)
    {
      Builder localBuilder = new Builder(paramRenderScript);
      localBuilder.setMinification(Value.NEAREST);
      localBuilder.setMagnification(Value.NEAREST);
      localBuilder.setWrapS(Value.MIRRORED_REPEAT);
      localBuilder.setWrapT(Value.MIRRORED_REPEAT);
      paramRenderScript.mSampler_MIRRORED_REPEAT_NEAREST = localBuilder.create();
    }
    return paramRenderScript.mSampler_MIRRORED_REPEAT_NEAREST;
  }

  public static Sampler WRAP_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_WRAP_LINEAR == null)
    {
      Builder localBuilder = new Builder(paramRenderScript);
      localBuilder.setMinification(Value.LINEAR);
      localBuilder.setMagnification(Value.LINEAR);
      localBuilder.setWrapS(Value.WRAP);
      localBuilder.setWrapT(Value.WRAP);
      paramRenderScript.mSampler_WRAP_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_WRAP_LINEAR;
  }

  public static Sampler WRAP_LINEAR_MIP_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_WRAP_LINEAR_MIP_LINEAR == null)
    {
      Builder localBuilder = new Builder(paramRenderScript);
      localBuilder.setMinification(Value.LINEAR_MIP_LINEAR);
      localBuilder.setMagnification(Value.LINEAR);
      localBuilder.setWrapS(Value.WRAP);
      localBuilder.setWrapT(Value.WRAP);
      paramRenderScript.mSampler_WRAP_LINEAR_MIP_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_WRAP_LINEAR_MIP_LINEAR;
  }

  public static Sampler WRAP_NEAREST(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_WRAP_NEAREST == null)
    {
      Builder localBuilder = new Builder(paramRenderScript);
      localBuilder.setMinification(Value.NEAREST);
      localBuilder.setMagnification(Value.NEAREST);
      localBuilder.setWrapS(Value.WRAP);
      localBuilder.setWrapT(Value.WRAP);
      paramRenderScript.mSampler_WRAP_NEAREST = localBuilder.create();
    }
    return paramRenderScript.mSampler_WRAP_NEAREST;
  }

  public float getAnisotropy()
  {
    return this.mAniso;
  }

  public Value getMagnification()
  {
    return this.mMag;
  }

  public Value getMinification()
  {
    return this.mMin;
  }

  public Value getWrapS()
  {
    return this.mWrapS;
  }

  public Value getWrapT()
  {
    return this.mWrapT;
  }

  public static class Builder
  {
    float mAniso;
    Sampler.Value mMag;
    Sampler.Value mMin;
    RenderScript mRS;
    Sampler.Value mWrapR;
    Sampler.Value mWrapS;
    Sampler.Value mWrapT;

    public Builder(RenderScript paramRenderScript)
    {
      this.mRS = paramRenderScript;
      this.mMin = Sampler.Value.NEAREST;
      this.mMag = Sampler.Value.NEAREST;
      this.mWrapS = Sampler.Value.WRAP;
      this.mWrapT = Sampler.Value.WRAP;
      this.mWrapR = Sampler.Value.WRAP;
      this.mAniso = 1.0F;
    }

    public Sampler create()
    {
      this.mRS.validate();
      Sampler localSampler = new Sampler(this.mRS.nSamplerCreate(this.mMag.mID, this.mMin.mID, this.mWrapS.mID, this.mWrapT.mID, this.mWrapR.mID, this.mAniso), this.mRS);
      localSampler.mMin = this.mMin;
      localSampler.mMag = this.mMag;
      localSampler.mWrapS = this.mWrapS;
      localSampler.mWrapT = this.mWrapT;
      localSampler.mWrapR = this.mWrapR;
      localSampler.mAniso = this.mAniso;
      return localSampler;
    }

    public void setAnisotropy(float paramFloat)
    {
      if (paramFloat >= 0.0F)
      {
        this.mAniso = paramFloat;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }

    public void setMagnification(Sampler.Value paramValue)
    {
      if ((paramValue == Sampler.Value.NEAREST) || (paramValue == Sampler.Value.LINEAR))
      {
        this.mMag = paramValue;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }

    public void setMinification(Sampler.Value paramValue)
    {
      if ((paramValue == Sampler.Value.NEAREST) || (paramValue == Sampler.Value.LINEAR) || (paramValue == Sampler.Value.LINEAR_MIP_LINEAR) || (paramValue == Sampler.Value.LINEAR_MIP_NEAREST))
      {
        this.mMin = paramValue;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }

    public void setWrapS(Sampler.Value paramValue)
    {
      if ((paramValue == Sampler.Value.WRAP) || (paramValue == Sampler.Value.CLAMP) || (paramValue == Sampler.Value.MIRRORED_REPEAT))
      {
        this.mWrapS = paramValue;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }

    public void setWrapT(Sampler.Value paramValue)
    {
      if ((paramValue == Sampler.Value.WRAP) || (paramValue == Sampler.Value.CLAMP) || (paramValue == Sampler.Value.MIRRORED_REPEAT))
      {
        this.mWrapT = paramValue;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }
  }

  public static enum Value
  {
    int mID;

    static
    {
      LINEAR = new Value("LINEAR", 1, 1);
      LINEAR_MIP_LINEAR = new Value("LINEAR_MIP_LINEAR", 2, 2);
      LINEAR_MIP_NEAREST = new Value("LINEAR_MIP_NEAREST", 3, 5);
      WRAP = new Value("WRAP", 4, 3);
      CLAMP = new Value("CLAMP", 5, 4);
      MIRRORED_REPEAT = new Value("MIRRORED_REPEAT", 6, 6);
      Value[] arrayOfValue = new Value[7];
      arrayOfValue[0] = NEAREST;
      arrayOfValue[1] = LINEAR;
      arrayOfValue[2] = LINEAR_MIP_LINEAR;
      arrayOfValue[3] = LINEAR_MIP_NEAREST;
      arrayOfValue[4] = WRAP;
      arrayOfValue[5] = CLAMP;
      arrayOfValue[6] = MIRRORED_REPEAT;
    }

    private Value(int paramInt)
    {
      this.mID = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Sampler
 * JD-Core Version:    0.6.2
 */