package org.contactcentre.application.contract;

import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.presentation.api.dto.ParentDto;

public interface ParentService {
    void add(ParentDto parentDto) throws TitleException;
}
