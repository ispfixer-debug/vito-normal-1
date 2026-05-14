package com.vito.core.data.repository.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class PackageRepositoryImpl_Factory implements Factory<PackageRepositoryImpl> {
  @Override
  public PackageRepositoryImpl get() {
    return newInstance();
  }

  public static PackageRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PackageRepositoryImpl newInstance() {
    return new PackageRepositoryImpl();
  }

  private static final class InstanceHolder {
    private static final PackageRepositoryImpl_Factory INSTANCE = new PackageRepositoryImpl_Factory();
  }
}
