package org.contactcentre.presentation.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record RegisterChildDto(@NonNull ChildDto child, @NonNull ParentDto dad, @NonNull ParentDto mom) {
}
