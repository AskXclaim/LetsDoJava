package org.contactcentre.domain.model.client;

import lombok.Getter;
import lombok.ToString;
import org.contactcentre.domain.contract.Client;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.shared.Title;

@Getter
@ToString(callSuper = true)
public class Parent extends Client {
    private Title title;

    public Parent(Long id, Title title, String firstName, String middleName, String lastName, String gender) throws TitleException {
        super(id, firstName, middleName, lastName, gender);

        validateOrSetTitle(title);
    }

    public void setTitle(Title title) throws TitleException {
        validateOrSetTitle(title);
    }

    private void validateOrSetTitle(Title title) throws TitleException {
        if (isTitleValid(title)) {
            this.title = title;
            return;
        }

        throw new TitleException("Invalid title");
    }

    private boolean isTitleValid(Title title) {
        return Title.isValid(title);
    }
}
