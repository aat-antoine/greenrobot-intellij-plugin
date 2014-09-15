package com.antoine.ideaplugin.greenrobot;

import com.intellij.usages.Usage;

public interface Decider {
  boolean shouldShow(Usage usage);
}
