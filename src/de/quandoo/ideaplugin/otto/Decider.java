package de.quandoo.ideaplugin.otto;

import com.intellij.usages.Usage;

public interface Decider {
  boolean shouldShow(Usage usage);
}
