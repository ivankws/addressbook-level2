package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public final String contactInfo;
    private boolean isPrivate;

    public Contact(String contact, boolean isPrivate, String messageConstraints, String validationRegex)
            throws IllegalValueException {

        this.contactInfo = contact.trim();
        this.isPrivate = isPrivate;

        if (!checkValidRegex(validationRegex)) {

            throw new IllegalValueException(messageConstraints);

        }

    }

    private boolean checkValidRegex(String validationRegex) {

        return this.contactInfo.matches(validationRegex);

    }

    public boolean isPrivate() {

        return isPrivate;
    }

    @Override
    public String toString() {
        return contactInfo;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                        && this.contactInfo.equals(((Contact) other).contactInfo)); // state
                                                                                    // check
    }

    @Override
    public int hashCode() {
        return contactInfo.hashCode();
    }

}
