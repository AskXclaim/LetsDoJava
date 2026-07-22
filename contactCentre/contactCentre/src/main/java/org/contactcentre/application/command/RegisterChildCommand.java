package org.contactcentre.application.command;

import lombok.Builder;

@Builder
public record RegisterChildCommand(ChildCommand child, ParentCommand father, ParentCommand mother) {
}
